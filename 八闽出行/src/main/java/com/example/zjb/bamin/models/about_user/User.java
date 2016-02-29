package com.example.zjb.bamin.models.about_user;

/**
 * Created by Administrator on 2016/2/4.
 */
public class User
{

    /**
     * id : 2
     * name : null
     * password : null
     * sex : null
     * image : null
     * phone : 1
     */

    private int id;
    private String name;
    private String password;
    private int sex;
    private String image;
    private String phone;

    public void setId(int id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setSex(int sex)
    {
        this.sex = sex;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getPassword()
    {
        return password;
    }

    public int getSex()
    {
        return sex;
    }

    public String getImage()
    {
        return image;
    }

    public String getPhone()
    {
        return phone;
    }
}
