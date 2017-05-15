package org.wargamesproject.vinlookup.model;

import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by Matt on 3/26/2017.
 */

public class VehicleDetails implements Serializable
{
    // Member variables
    private VINNumber vinNumber;
    private Map<VINFieldEnum,String> descriptionMap;

    // Constants
    private static final long serialVersionUID = 1L;

    public VehicleDetails(VINNumber vin)
    {
        this.vinNumber = vin;
        this.descriptionMap = new HashMap<VINFieldEnum,String>();
    }

    public VINNumber getVIN()
    {
        return this.vinNumber;
    }

    public void setDescription(VINFieldEnum field,String desc)
    {
        this.descriptionMap.put(field,desc);
    }

    public String getDescription(VINFieldEnum field)
    {
        return this.descriptionMap.get(field);
    }
}
