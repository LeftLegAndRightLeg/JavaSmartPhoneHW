package src.smslocation;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity implements LocationListener {

    private LocationManager lm;
    private String provider;
    private StringBuffer sb = new StringBuffer();
    private EditText phoneNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sendButton = (Button) findViewById(R.id.sendButton);
        phoneNumber = (EditText) findViewById(R.id.phoneNumberEdit);


        lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        //lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,5000,10,this);

        Criteria c=new Criteria();
        provider=lm.getBestProvider(c, false);
        Location l = lm.getLastKnownLocation(provider);


        if(l!=null)
        {
            double lng=l.getLongitude();
            double lat=l.getLatitude();
            System.out.println(lng);
            sb.append("Latitude: ").append(lat).append("\n").append("Longitude: ").append(lng);

        }else{
            sb.append("Not available");
        }


        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone_number = phoneNumber.getText().toString();

                sendSMSMessage(phone_number, sb.toString());
            }
        });

    }

    protected void sendSMSMessage(String phoneNo, String message) {
        Log.i("Send SMS", "");

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, message, null, null);
            Toast.makeText(getApplicationContext(), "SMS sent.",
                    Toast.LENGTH_LONG).show();
            System.out.println(message);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),
                    "SMS faild, please try again.",
                    Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onLocationChanged(Location location) {


    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        lm.requestLocationUpdates(provider, 4000, 10, this);
    }

}

