package org.wargamesproject.vinlookup.data.impl.descgen;

import org.wargamesproject.vinlookup.data.impl.DescriptionGenerator;
import org.wargamesproject.vinlookup.model.VINFieldEnum;
import org.wargamesproject.vinlookup.model.VINNumber;

/**
 * Created by Matt on 5/14/2017.
 */

/**
 * The EchoDescriptionGenerator echos back the value of the requested field as a description.  Used for
 * fields that don't have formal descriptions like the check digit or serial number.
 */
public class EchoDescriptionGenerator implements DescriptionGenerator
{
    @Override
    public String getDescription(VINFieldEnum vinField, VINNumber vin)
    {
        return vin.getField(vinField);
    }
}
