package org.wargamesproject.vinlookup.model;

/**
 * Created by Matt on 5/13/2017.
 */

public enum VINFieldEnum
{
    COUNTRY_CODE(0,2,"Region/Country"),
    MARQUE(2,1,"Marque"),
    MANUFACTURING_LINE(3,1,"Manufacturing Line"),
    BODY_TYPE(4,1,"Body Type"),
    MOTOR_TYPE(5,2,"Engine Type"),
    RESTRAINT_SYSTEM(7,1,"Restraint System"),
    CHECK_DIGIT(8,1,"Check Digit"),
    MODEL_YEAR(9,1,"Model Year"),
    MANUFACTURING_PLANT(10,1,"Manufacturing Plant"),
    STEERING_POSITION(11,1,"Steering"),
    SERIAL_NUMBER(12,5,"Serial Number");

    private int position,fieldLength;
    private String description;

    VINFieldEnum(int pos,int length,String desc)
    {
        this.position = pos;
        this.fieldLength = length;
    }

    public int getPosition()
    {
        return this.position;
    }

    public int getLength()
    {
        return this.fieldLength;
    }

    public String getDescription()
    {
        return this.description;
    }
}
