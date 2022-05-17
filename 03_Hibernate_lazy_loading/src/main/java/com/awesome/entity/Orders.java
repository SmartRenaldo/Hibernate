package com.awesome.entity;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    private Integer id;
    private String description;
    private Customer customer;

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
