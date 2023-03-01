package hiber.model;

import javax.persistence.*;
import java.util.Objects;
@Entity(name="Car")
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private int series;
    @OneToOne
    @MapsId
    private User user;
    public Car() {

    }
    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }
    public User getUser() {
        return user;
    }

    public String getModel() {
        return model;
    }

    public int getSeries() {
        return series;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return series == car.series && Objects.equals(model, car.model);
    }
    @Override
    public int hashCode() {
        return Objects.hash(model, series);
    }
    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", series=" + series +
                '}';
    }
}
