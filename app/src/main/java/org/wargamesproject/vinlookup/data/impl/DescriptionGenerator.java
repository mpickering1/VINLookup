package org.wargamesproject.vinlookup.data.impl;

import org.wargamesproject.vinlookup.model.VINNumber;
import org.wargamesproject.vinlookup.model.VINFieldEnum;

/**
 * Created by Matt on 5/13/2017.
 */

public interface DescriptionGenerator
{
    public String getDescription(VINFieldEnum vinField,VINNumber vin);
}
