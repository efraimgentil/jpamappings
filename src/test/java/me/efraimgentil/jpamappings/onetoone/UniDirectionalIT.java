package me.efraimgentil.jpamappings.onetoone;

import me.efraimgentil.jpamappings.models.User;
import me.efraimgentil.jpamappings.models.UserProfile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by efra on 17/06/17.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UniDirectionalIT {

  @Autowired
  TestEntityManager entityManager;

  @Test
  public void doesCreateUserAndUserProfile(){
    User user = new User("testname", new UserProfile("FirstName" , "SecondName"));
    Object userId = entityManager.persistAndGetId(user);
    entityManager.flush();
    entityManager.clear();

    //clean first level cache, to guarantee that will hit the database again
    User user1 = entityManager.find(User.class, userId);

    assertThat(user1).isNotNull();
    assertThat(user1.getUserProfile()).isNotNull();
  }

}
