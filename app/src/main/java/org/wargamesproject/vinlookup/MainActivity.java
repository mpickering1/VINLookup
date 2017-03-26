package org.wargamesproject.vinlookup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.TextView;

import org.wargamesproject.vinlookup.model.VINNumber;

public class MainActivity extends AppCompatActivity implements TextWatcher
{
    // Member variables
    private TextView vinNumberText;
    private Button lookupButton;
    // Constants
    private static final String TAG = "VINLOOKUP_MAIN";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        this.vinNumberText = (TextView)this.findViewById(R.id.vinNumberText);
        this.vinNumberText.addTextChangedListener(this);

        this.lookupButton = (Button)this.findViewById(R.id.lookupButton);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after)
    {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count)
    {

    }

    @Override
    public void afterTextChanged(Editable s)
    {
        //Log.v(TAG,"In afterTextChanged()...");

        lookupButton.setEnabled(false);
        String vinNumberStr = s.toString();

        if (vinNumberStr.length() == 17)
        {
            Log.v(TAG, "Got 17 character value for VIN number...");

            // Create the VIN number object and ensure it is valid
            VINNumber enteredVIN = new VINNumber(vinNumberStr);

            if (enteredVIN.isValidVIN() == true)
            {
                Log.v(TAG,enteredVIN.toString());

                // The VIN is valid.  Enable the lookup button
                lookupButton.setEnabled(true);
            }
            else
            {
                Log.v(TAG,"VIN is not valid!");
            }
        }
    }
}
