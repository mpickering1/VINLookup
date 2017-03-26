package org.wargamesproject.vinlookup.model;

import java.io.Serializable;

/**
 * Created by Matt on 3/26/2017.
 */

public class VehicleDetails implements Serializable
{
    // Member variables
    private VINNumber vinNumber;
    // Constants
    private static final long serialVersionUID = 1L;

    public VehicleDetails(VINNumber vin)
    {
        this.vinNumber = vin;
    }

    public VINNumber getVIN()
    {
        return this.vinNumber;
    }
}
