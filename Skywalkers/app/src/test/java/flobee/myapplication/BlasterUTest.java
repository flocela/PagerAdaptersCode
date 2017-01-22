package flobee.myapplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

//MockitoJUnitRunner.class allows me to mock objects.
@RunWith(MockitoJUnitRunner.class)
public class BlasterUTest {
  @Mock Person  leia;
  @Mock Person  anyoneElse;

  @Test
  public void verifyTurnsSaberOn () {
    when(leia.getName()).thenReturn("Leia");
    when(anyoneElse.getName()).thenReturn("anything");

    Blaster blaster = new Blaster();

    blaster.shoot(leia);
    verify(leia, times(0)).hit();

    blaster.shoot(anyoneElse);
    verify(anyoneElse).hit();

  }

  class Blaster {
    void shoot (Person person) {
      if (!person.getName().equals("Leia"))
        person.hit();
    }
  }
  class Person {
    String name;
    boolean isHit = false;

    public Person (String name) {
      this.name = name;
    }
    void hit () {
      isHit = true;
    }

    String getName () {
      return name;
    }
  }
}
