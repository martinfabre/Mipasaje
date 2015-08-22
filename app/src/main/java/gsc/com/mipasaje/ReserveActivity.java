package gsc.com.mipasaje;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class ReserveActivity extends AppCompatActivity implements View.OnClickListener {

    private Context m_Context = null;
    private Button m_btnOrigin = null;
    private Button m_btnDestination = null;
    private  Button m_btnContinue = null;
    private  Button m_btnDateChoose = null;
    private Button m_btnTimeChoose = null;
    private Button m_btnCompanyChoose = null;
    private Button m_btnQuantity = null;

    private DatePickerDialog m_DatePicker = null;
    private TimePickerDialog m_TimePicker = null;

    private Dialog dialog = null;
    private ListView listview = null;

    String m_companyNames[] = {"company1", "company2", "company3", "company n"};
    String m_originCities[] = {"city1", "city2", "city3", "city n"};
    String m_destinationCities[] = {"city1", "city2", "city3", "city n"};
    String m_quantity[] = {"1", "2", "3", "n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve);

        m_Context = this;

        getUIObject();
        getOtherObject();
    }

    private void getUIObject()
    {
        m_btnOrigin = (Button) findViewById(R.id.btn_origin);
        m_btnOrigin.setOnClickListener(this);

        m_btnDestination = (Button) findViewById(R.id.btn_destination);
        m_btnDestination.setOnClickListener(this);

        m_btnQuantity = (Button) findViewById(R.id.btn_quantity_passagges);
        m_btnQuantity.setOnClickListener(this);

        m_btnContinue = (Button) findViewById(R.id.btn_continue);
        m_btnContinue.setOnClickListener(this);

        m_btnDateChoose = (Button) findViewById(R.id.btn_date_choose);
        m_btnDateChoose.setOnClickListener(this);

        m_btnTimeChoose = (Button) findViewById(R.id.btn_time_choose);
        m_btnTimeChoose.setOnClickListener(this);

        m_btnCompanyChoose = (Button) findViewById(R.id.btn_company_choose);
        m_btnCompanyChoose.setOnClickListener(this);
    }

    private void getOtherObject()
    {
        Calendar newCalendar = Calendar.getInstance();
        m_DatePicker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                Calendar newDate = Calendar.getInstance();
//                newDate.set(year, monthOfYear, dayOfMonth);
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        m_TimePicker = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {

            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                //eReminderTime.setText( ""+selectedHour + ":" + selectedMinute);
                //Log.d(new Integer(selectedHour).toString(), new Integer(selectedMinute).toString());
            }
        }, newCalendar.get(Calendar.HOUR_OF_DAY), newCalendar.get(Calendar.MINUTE), true);

    }

    @Override
    public void onClick(View view)
    {
        if(view == m_btnContinue)
        {
            startActivity(new Intent(m_Context, BusLayoutActivity.class));
        }
        if(view == m_btnDateChoose)
        {
            m_DatePicker.show();
        }
        if(view == m_btnTimeChoose)
        {
            m_TimePicker.show();
        }
        if(view == m_btnCompanyChoose)
        {
            listview = new ListView(this);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,m_companyNames);
            listview.setAdapter(adapter);
            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    dialog.dismiss();
                    m_btnCompanyChoose.setText(((TextView) view).getText());
                }
            });

            dialog = new Dialog(this);
            dialog.setContentView(listview);
            dialog.setTitle("Companies");
            dialog.show();
        }
        if(view == m_btnOrigin)
        {
            listview = new ListView(this);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, m_originCities);
            listview.setAdapter(adapter);
            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    dialog.dismiss();
                    m_btnOrigin.setText(((TextView) view).getText());
                }
            });

            dialog = new Dialog(this);
            dialog.setContentView(listview);
            dialog.setTitle("Companies");
            dialog.show();
        }
        if(view == m_btnDestination)
        {
            listview = new ListView(this);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,m_destinationCities);
            listview.setAdapter(adapter);
            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    dialog.dismiss();
                    m_btnDestination.setText(((TextView) view).getText());
                }
            });

            dialog = new Dialog(this);
            dialog.setContentView(listview);
            dialog.setTitle("Companies");
            dialog.show();
        }
        if(view == m_btnQuantity)
        {
            listview = new ListView(this);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,m_quantity);
            listview.setAdapter(adapter);
            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    dialog.dismiss();
                    m_btnQuantity.setText(((TextView) view).getText());
                }
            });

            dialog = new Dialog(this);
            dialog.setContentView(listview);
            dialog.setTitle("Companies");
            dialog.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_reserve, menu);
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
}
