package org.wargamesproject.vinlookup.model;

import java.io.Serializable;

/**
 * Created by Matt on 3/26/2017.
 */

public class VINNumber implements Serializable
{
    // Member variables
    private String fullVINNumber;
    private Character manufactureCountry1,manufactureCountry2,marque,manufacturingLine,bodyType;
    private Character restraintSystem,checkDigit,modelYearCode,manufacturingPlant,steeringPosition;
    private String motorType,serialNumber;
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

    public char getManufacturerCountry1()
    {
        return this.manufactureCountry1;
    }

    public void setManufacturerCountry1(char countryCode)
    {
        this.manufactureCountry1 = countryCode;
    }

    public char getManufacturerCountry2()
    {
        return this.manufactureCountry2;
    }

    public void setManufacturerCountry2(char countryCode)
    {
        this.manufactureCountry2 = countryCode;
    }

    public char getMarque()
    {
        return marque;
    }

    public void setMarque(char marque)
    {
        this.marque = marque;
    }

    public char getManufacturingLine()
    {
        return manufacturingLine;
    }

    public void setManufacturingLine(char manufacturingLine)
    {
        this.manufacturingLine = manufacturingLine;
    }

    public char getBodyType()
    {
        return bodyType;
    }

    public void setBodyType(char bodyType)
    {
        this.bodyType = bodyType;
    }

    public char getRestraintSystem()
    {
        return restraintSystem;
    }

    public void setRestraintSystem(char restraintSystem)
    {
        this.restraintSystem = restraintSystem;
    }

    public char getCheckDigit()
    {
        return checkDigit;
    }

    public void setCheckDigit(char checkDigit)
    {
        this.checkDigit = checkDigit;
    }

    public char getModelYearCode()
    {
        return modelYearCode;
    }

    public void setModelYearCode(char modelYearCode)
    {
        this.modelYearCode = modelYearCode;
    }

    public char getManufacturingPlant()
    {
        return manufacturingPlant;
    }

    public void setManufacturingPlant(char manufacturingPlant)
    {
        this.manufacturingPlant = manufacturingPlant;
    }

    public char getSteeringPosition()
    {
        return steeringPosition;
    }

    public void setSteeringPosition(char steeringPosition)
    {
        this.steeringPosition = steeringPosition;
    }

    public String getMotorType()
    {
        return motorType;
    }

    public void setMotorType(String motorType)
    {
        this.motorType = motorType;
    }

    public String getSerialNumber()
    {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber)
    {
        this.serialNumber = serialNumber;
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
                this.manufactureCountry1 = this.fullVINNumber.charAt(POS_COUNTRY_CODE1);
                this.manufactureCountry2 = this.fullVINNumber.charAt(POS_COUNTRY_CODE2);
                this.marque = this.fullVINNumber.charAt(POS_MARQUE);
                this.manufacturingLine = this.fullVINNumber.charAt(POS_MANUFACTURING_LINE);
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
        builder.append("manufactureCountry1=");
        builder.append(this.manufactureCountry1);
        builder.append(',');
        builder.append("manufacturerCountry2=");
        builder.append(this.manufactureCountry2);
        builder.append(',');
        builder.append("marque=");
        builder.append(this.marque);
        builder.append(',');
        builder.append("manufacturingLine=");
        builder.append(this.manufacturingLine);
        builder.append(',');
        builder.append("bodyType=");
        builder.append(this.bodyType);
        builder.append(',');
        builder.append("motorType=");
        builder.append(this.motorType);
        builder.append(',');
        builder.append("restraintSystem=");
        builder.append(this.restraintSystem);
        builder.append(',');
        builder.append("checkDigit=");
        builder.append(this.checkDigit);
        builder.append(',');
        builder.append("modelYearCode=");
        builder.append(this.modelYearCode);
        builder.append(',');
        builder.append("manufacturingPlant=");
        builder.append(this.manufacturingPlant);
        builder.append(',');
        builder.append("steeringPosition=");
        builder.append(this.steeringPosition);
        builder.append(',');
        builder.append("serialNumber=");
        builder.append(this.serialNumber);
        builder.append(']');

        return builder.toString();
    }
}
