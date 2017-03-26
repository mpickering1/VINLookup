package org.wargamesproject.vinlookup.data;

import org.wargamesproject.vinlookup.model.VINNumber;
import org.wargamesproject.vinlookup.model.VehicleDetails;

/**
 * Created by Matt on 3/26/2017.
 */

public interface VINDetailsLookup
{
    public VehicleDetails getDetailsForVIN(VINNumber vin);
}
