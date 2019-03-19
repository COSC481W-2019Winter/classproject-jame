package com.example.activitease20;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.Toast;


public class Add_Interest_Fragment extends Fragment {

    /**
     * Variables which are input from the add interest page/form.
     * Example: My interest is pitching practice, and I would like to practice four times a week in one hour sessions.
     *
     * interestName = "pitching practice";
     * periodFreq = 4;
     * activityLength = 60.0;
     * periodSpanStr = "week". This String is matched with a double from the getPeriodSpan method.
     */
    private Button addInterestBn;
    private EditText interestName, periodSpan, periodFreq, numNotifications, activityLength;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.add_interest_page, container, false);

        String[] periodSpanTypes =
                {"Day", "Week", "Month", "Year"};
        Spinner periodSpanSpinner = (Spinner) v.findViewById(R.id.periodSpanInput);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, periodSpanTypes);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        periodSpanSpinner.setAdapter(adapter);

        interestName = v.findViewById(R.id.interestName);
        activityLength = v.findViewById(R.id.activityLength);
        periodFreq = v.findViewById(R.id.periodFreq);
        periodSpan = v.findViewById(R.id.periodSpanInput);
        numNotifications = v.findViewById(R.id.numNotifications);

        addInterestBn = v.findViewById(R.id.submitNewInterestButton);

        addInterestBn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newInterestName  = interestName.getText().toString();

                int newActivityLength = Integer.parseInt(activityLength.getText().toString());
                int newPeriodFreq = Integer.parseInt(periodFreq.getText().toString());
                String newPeriodSpan = periodSpan.getText().toString();
                int newNumNotifications = Integer.parseInt(periodSpan.getText().toString());

                int basePeriodSpan = 0;

                /**
                 * Temporary values of basePeriodSpan, which will have to be revised for later.
                 */
                switch (newPeriodSpan) {
                    case "Day":
                        basePeriodSpan = 1;
                        break;
                    case "Week":
                        basePeriodSpan = 7;
                        break;
                    case "Month":
                        basePeriodSpan = 30;
                        break;
                    case "Year":
                        basePeriodSpan = 365;
                        break;
                }
                Interest interest = new Interest(newInterestName, newPeriodFreq, basePeriodSpan,
                                                newActivityLength, newNumNotifications);

                MainActivity.myDB.myDao().addInterest(interest);
                Toast.makeText(getActivity(), "Interest added successfully", Toast.LENGTH_LONG).show();

                interestName.setText("");
                activityLength.setText("");
                periodFreq.setText("");
                numNotifications.setText("");
            }
        });

        return v;

    }
}
