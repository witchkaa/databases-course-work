package com.duallo.app.rest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table
public class Label {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long taskID;
    @Column
    private Long tagID;

    @Override
    public String toString() {
        return "Label{" +
                "id=" + id +
                ", taskID=" + taskID +
                ", tagID=" + tagID +
                '}';
    }
}
