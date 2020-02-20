package com.ivan.sison.mystore.data.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {

    @PrimaryKey
    private int id;

    private String lastname;
    private String firstname;
    private String middlename;
    private String bdadte;
    private String phone;
    private String email;
    private String password;
    private int type;
}
