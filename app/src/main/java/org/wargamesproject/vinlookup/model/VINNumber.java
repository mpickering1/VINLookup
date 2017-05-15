package org.wargamesproject.vinlookup.model;

import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by Matt on 3/26/2017.
 */

public class VINNumber implements Serializable
{
    // Member variables
    private String fullVINNumber;
    private Map<VINFieldEnum,String> vinFieldMap;
    private boolean validVIN;
    // Constants
    private final static long serialVersionUID = 1L;
    private final static int VIN_LENGTH = 17;
    // VIN number code position constants and lengths
    private final static int POS_COUNTRY_CODE1 = 0;
    private final static int POS_COUNTRY_CODE2 = 1;
    private final static int POS_MARQUE = 2;
    private final static int POS_MANUFACTURING_LINE = 3;
    private final static int POS_BODY_TYPE = 4;
    private final static int POS_MOTOR_TYPE = 5;
    private final static int LEN_MOTOR_TYPE = 2;
    private final static int POS_RESTRAINT_SYSTEM = 7;
    private final static int POS_CHECK_DIGIT = 8;
    private final static int POS_MODEL_YEAR = 9;
    private final static int POS_MANUFACTURING_PLANT = 10;
    private final static int POS_STEERING_POSITION = 11;
    private final static int POS_SERIAL_NUMBER = 12;
    private final static int LEN_SERIAL_NUMBER = 5;

    // Constructor

    public VINNumber(String vin)
    {
        this.vinFieldMap = new HashMap<VINFieldEnum,String>();
        // VINs are 17 digits.  Sample VIN could be SCBZD0TBXCH05038 or SCAZS02A8KCX26429
        this.setFullVINNumber(vin);
    }

    // Get/set methods

    public String getFullVINNumber()
    {
        return this.fullVINNumber;
    }

    public void setFullVINNumber(String fullVINNumber)
    {
        this.fullVINNumber = fullVINNumber;
        this.parseVIN();
    }

    public String getField(VINFieldEnum field)
    {
        return this.vinFieldMap.get(field);
    }

    // Convenience methods to retrieve specific VIN field values

    public String getCountryCode()
    {
        return this.vinFieldMap.get(VINFieldEnum.COUNTRY_CODE);
    }

    public String getMarque()
    {
        return this.vinFieldMap.get(VINFieldEnum.MARQUE);
    }

    public String getManufacturingLine()
    {
        return this.vinFieldMap.get(VINFieldEnum.MANUFACTURING_LINE);
    }

    public String getBodyType()
    {
        return this.vinFieldMap.get(VINFieldEnum.BODY_TYPE);
    }

    public String getRestraintSystem()
    {
        return this.vinFieldMap.get(VINFieldEnum.RESTRAINT_SYSTEM);
    }

    public String getCheckDigit()
    {
        return this.vinFieldMap.get(VINFieldEnum.CHECK_DIGIT);
    }

    public String getModelYearCode()
    {
        return this.vinFieldMap.get(VINFieldEnum.MODEL_YEAR);
    }

    public String getManufacturingPlant()
    {
        return this.vinFieldMap.get(VINFieldEnum.MANUFACTURING_PLANT);
    }

    public String getSteeringPosition()
    {
        return this.vinFieldMap.get(VINFieldEnum.STEERING_POSITION);
    }

    public String getMotorType()
    {
        return this.vinFieldMap.get(VINFieldEnum.MOTOR_TYPE);
    }

    public String getSerialNumber()
    {
        return this.vinFieldMap.get(VINFieldEnum.SERIAL_NUMBER);
    }

    public boolean isValidVIN()
    {
        return this.validVIN;
    }

    //
    // Private methods
    //

    private void parseVIN()
    {
        this.validVIN = false;

        if (this.fullVINNumber != null && this.fullVINNumber.length() == VIN_LENGTH)
        {
            // Assume the VIN is valid at this point for deeper checking
            this.validVIN = true;

            // The VIN is not null and the proper length.  Ensure it contains only letters and digits
            for (int c = 0; c < this.fullVINNumber.length(); c++)
            {
                char currentChar = this.fullVINNumber.charAt(c);

                if (Character.isLetterOrDigit(currentChar) == false)
                {
                    // The VIN contained something other than a letter or digit.  It is not a valid
                    // VIN number.
                    this.validVIN = false;
                    break;
                }
            }

            // If the VIN is valid, parse it into its component elements
            if (this.validVIN == true)
            {
                for (VINFieldEnum currentField : VINFieldEnum.values())
                {
                    this.vinFieldMap.put(currentField,this.fullVINNumber.substring(currentField.getPosition(),currentField.getPosition() + currentField.getLength()));
                }
            }
        }
    }

    //
    // Methods overridden from Object
    //

    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        builder.append(this.getClass().getName());
        builder.append('[');

        for (VINFieldEnum currentField : VINFieldEnum.values())
        {
            builder.append(currentField.name());
            builder.append('=');
            builder.append(this.vinFieldMap.get(currentField));
            builder.append(',');
        }

        builder.setLength(builder.length()-1);
        builder.append(']');

        return builder.toString();
    }
}
