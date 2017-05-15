package org.wargamesproject.vinlookup.data.impl;

import java.util.Map;
import java.util.HashMap;

import org.wargamesproject.vinlookup.data.VINDetailsLookup;
import org.wargamesproject.vinlookup.model.VINNumber;
import org.wargamesproject.vinlookup.model.VehicleDetails;

/**
 * Created by Matt on 3/26/2017.
 */

public class SimpleVINDetailsLookupImpl implements VINDetailsLookup
{
    // Member variables
    private Map<Character,String> countryCodeLookup;

    public SimpleVINDetailsLookupImpl()
    {
        this.countryCodeLookup = new HashMap<Character,String>();


        this.loadLookupData();
    }

    @Override
    public VehicleDetails getDetailsForVIN(VINNumber vin)
    {
        VehicleDetails details = new VehicleDetails(vin);

        return details;
    }

    //
    // Private methods
    //

    private void loadLookupData()
    {
        // Country code lookups
        this.countryCodeLookup.put('1',"United States");
        this.countryCodeLookup.put('2',"Canada");
        this.countryCodeLookup.put('3',"Mexico");
        this.countryCodeLookup.put('4',"United States");
        this.countryCodeLookup.put('5',"United States");
        this.countryCodeLookup.put('J',"Japan");
        this.countryCodeLookup.put('S',"United Kingdom");
        this.countryCodeLookup.put('V',"France/Spain");
        this.countryCodeLookup.put('T',"Switzerland");
        this.countryCodeLookup.put('W',"Germany");
        this.countryCodeLookup.put('Y',"Sweden/Finland");
        this.countryCodeLookup.put('Z',"Italy");
    }
}
