package org.hj77.datamanager.repository.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "client")
public class Client {

    @Id
    @Column(name = "id", length = 10)
    private String id;

    @Column(name = "lastname", nullable = false, length = 100)
    private String lastName;

    @Column(name = "firstname", nullable = false, length = 100)
    private String firstName;

    @Column(name = "patronymic", nullable = false, length = 100)
    private String patronymic;

    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    @Column(name = "passportseries", nullable = false, length = 4)
    private String passportSeries;

    @Column(name = "passportnumber", nullable = false, length = 6)
    private String passportNumber;

    @Column(name = "inn", nullable = false, length = 12)
    private String inn;

    @Column(name = "address", nullable = false, length = 200)
    private String address;

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + patronymic + '\'' +
                '}';
    }
}