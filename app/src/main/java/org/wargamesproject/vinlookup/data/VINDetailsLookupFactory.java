package org.wargamesproject.vinlookup.data;

import org.wargamesproject.vinlookup.data.impl.SimpleVINDetailsLookupImpl;

/**
 * Created by Matt on 3/26/2017.
 */

public class VINDetailsLookupFactory
{
    // Member variables
    private static VINDetailsLookup lookupInstance;

    public static VINDetailsLookup getDetailsLookup()
    {
        if (lookupInstance == null)
        {
            lookupInstance = new SimpleVINDetailsLookupImpl();
        }

        return lookupInstance;
    }
}
