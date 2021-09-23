package sqs.example.graalvmdemo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "car")
public class CarEntity {

    @Id
    private int id;

    private String plate;

    private String content;

    public static CarEntity nullObject() {
        CarEntity nullObj = new CarEntity();
        nullObj.plate = "EMPTY";
        nullObj.content = "";
        return nullObj;
    }
}
