package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private String series;//по условию инт

    @OneToOne(mappedBy = "car")
    private User user;

    public Car() {
    }

    public Car(String model, String series) {
        this.model = model;
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public String getSeries() {
        return series;
    }

    public User getUser() {
        return user;
    }

}