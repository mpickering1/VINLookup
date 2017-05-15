package org.wargamesproject.vinlookup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.util.Log;

import org.wargamesproject.vinlookup.model.VehicleDetails;

public class VINDetailsActivity extends AppCompatActivity
{
    // Member variables
    private VehicleDetails vehicleDetails;
    private TextView vinNumberHeader;
    // Constants
    private static final String TAG = "VINLOOKUP_DETAILS";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Log.v(TAG, "In onCreate()...");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vindetails);



        this.vinNumberHeader = (TextView) this.findViewById(R.id.vinNumberHeader);

        Intent intent = this.getIntent();
        this.vehicleDetails = (VehicleDetails) intent.getSerializableExtra(Constants.VIN_DETAILS);

        if (this.vehicleDetails != null)
        {
            Log.v(TAG,"Got vehicle details from Intent, displaying VIN detail information.");

            this.vinNumberHeader.setText(this.vehicleDetails.getVIN().getFullVINNumber());
            this.setCodeElementsInView();
        }
    }

    private void setCodeElementsInView()
    {
        TextView countryCodesLabel = (TextView)this.findViewById(R.id.countryCodesText);
        //countryCodesLabel.setText(this.vehicleDetails.getVIN().getManufacturerCountry1() + this.vehicleDetails.getVIN().getManufacturerCountry2());
    }
}
