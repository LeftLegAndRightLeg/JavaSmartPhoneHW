package src.ui;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import util.DatabaseConnector;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class Statistics extends Fragment {

    private TextView max1TextView;
    private TextView max2TextView;
    private TextView max3TextView;
    private TextView max4TextView;
    private TextView max5TextView;

    private TextView min1TextView;
    private TextView min2TextView;
    private TextView min3TextView;
    private TextView min4TextView;
    private TextView min5TextView;


    private TextView avg1TextView;
    private TextView avg2TextView;
    private TextView avg3TextView;
    private TextView avg4TextView;
    private TextView avg5TextView;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        System.out.println("ExampleFragment--onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        System.out.println("ExampleFragment--onCreateView");
        View view = inflater.inflate(R.layout.fragment_statistics, container, false);

        getReferences(view);

        DatabaseConnector dc = new DatabaseConnector(getActivity().getApplicationContext());

        displayStat(dc);

        return view;
    }

    public void displayStat(DatabaseConnector dc){

        int[] res = new int[3];
        int col = 0;

        res = dc.getStatScores(++col);
        max1TextView.setText(String.valueOf(res[0]));
        min1TextView.setText(String.valueOf(res[1]));
        avg1TextView.setText(String.valueOf(res[2]));

        res = dc.getStatScores(++col);
        max2TextView.setText(String.valueOf(res[0]));
        min2TextView.setText(String.valueOf(res[1]));
        avg2TextView.setText(String.valueOf(res[2]));

        res = dc.getStatScores(++col);
        max3TextView.setText(String.valueOf(res[0]));
        min3TextView.setText(String.valueOf(res[1]));
        avg3TextView.setText(String.valueOf(res[2]));

        res = dc.getStatScores(++col);
        max4TextView.setText(String.valueOf(res[0]));
        min4TextView.setText(String.valueOf(res[1]));
        avg4TextView.setText(String.valueOf(res[2]));

        res = dc.getStatScores(++col);
        max5TextView.setText(String.valueOf(res[0]));
        min5TextView.setText(String.valueOf(res[1]));
        avg5TextView.setText(String.valueOf(res[2]));
    }











    public void getReferences(View view){

        max1TextView = (TextView) view.findViewById(R.id.max1TextView);
        max2TextView = (TextView) view.findViewById(R.id.max2TextView);
        max3TextView = (TextView) view.findViewById(R.id.max3TextView);
        max4TextView = (TextView) view.findViewById(R.id.max4TextView);
        max5TextView = (TextView) view.findViewById(R.id.max5TextView);

        min1TextView = (TextView) view.findViewById(R.id.min1TextView);
        min2TextView = (TextView) view.findViewById(R.id.min2TextView);
        min3TextView = (TextView) view.findViewById(R.id.min3TextView);
        min4TextView = (TextView) view.findViewById(R.id.min4TextView);
        min5TextView = (TextView) view.findViewById(R.id.min5TextView);

        avg1TextView = (TextView) view.findViewById(R.id.avg1TextView);
        avg2TextView = (TextView) view.findViewById(R.id.avg2TextView);
        avg3TextView = (TextView) view.findViewById(R.id.avg3TextView);
        avg4TextView = (TextView) view.findViewById(R.id.avg4TextView);
        avg5TextView = (TextView) view.findViewById(R.id.avg5TextView);

    }


}
