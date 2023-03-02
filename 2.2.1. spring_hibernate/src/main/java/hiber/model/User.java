package hiber.model;

import javax.persistence.*;
import java.util.Objects;

@Entity(name="User")
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @OneToOne(mappedBy = "user")
   //@JoinColumn(name = "car")
   private Car car;


   public User(String firstName, String lastName, String email, Car car) {
      this.car = car;
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }
   public User() {}

   public User(String user1, String lastname1, String s) {
      this.firstName = user1;
      this.lastName = lastname1;
      this.email = s;
   }

   public void setCar(Car car) {
      this.car = car;
   }

   public Car getCar() {
      return car;
   }

   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      User user = (User) o;
      return Objects.equals(id, user.id) && Objects.equals(car, user.car) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, car, firstName, lastName, email);
   }

   @Override
   public String toString() {
      return "\nUser{" +
              "id=" + id +
              ", car=" + car.getModel() + " " + car.getSeries() +
              ", firstName='" + firstName + '\'' +
              ", lastName='" + lastName + '\'' +
              ", email='" + email + '\'' +
              '}';
   }
}
