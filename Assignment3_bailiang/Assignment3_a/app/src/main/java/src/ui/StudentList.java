package src.ui;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import util.DatabaseConnector;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class StudentList extends Fragment {

    private ArrayList<String> list = new ArrayList<String>();
    private ListView listView;

    public void onCreate(Bundle savedInstanceState)
    {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_student_list, container, false);
        listView = (ListView) view.findViewById(R.id.stuListView);

        DatabaseConnector databaseConnector = new DatabaseConnector(
                getActivity());
        databaseConnector.open();
        getAllStu(databaseConnector.getAllInputs());
        databaseConnector.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, list);

        listView.setAdapter(adapter);
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }



    public void getAllStu(Cursor cursor){
        if (cursor.moveToFirst()) {
            do {
                StringBuilder stu = new StringBuilder();
                for(int i = 0 ; i <= 5; i++){
                    stu.append(cursor.getInt(i) + " ");
                }
                list.add(stu.toString());
            } while (cursor.moveToNext());
        }
    }
}
