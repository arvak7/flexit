package com.flexit.commons.entities;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Document(collection = "employees")
public class Employee implements Serializable {
    @Id
    private ObjectId id;
    @NotNull
    private String name;
    private Date lastEventDate;
}
