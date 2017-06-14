package com.example.kripashankarjha.piechart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class PieChart extends AppCompatActivity {

    float rainFall[]={98.6f,95.3f,63.5f,86.8f};
    String name[]={"jan","feb","march","april"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);
        setPieChart();
    }

    public void setPieChart() {
        List<PieEntry> pi=new ArrayList<PieEntry>();
        for(int i=0;i<rainFall.length;i++){
            pi.add(new PieEntry(rainFall[i],name[i]));
        }
        PieDataSet pidataset=new PieDataSet(pi,"Graph of RainFall");
        pidataset.setColors(ColorTemplate.COLORFUL_COLORS);
        pidataset.setSliceSpace(2);
        pidataset.setValueTextSize(12);



        PieData data=new PieData(pidataset);

        com.github.mikephil.charting.charts.PieChart mychart= (com.github.mikephil.charting.charts.PieChart) findViewById(R.id.piChart);
        mychart.setCenterText("~ MONTHLY REPORT ~");
        mychart.setHoleRadius(25f);

        //mychart.setAnimation();
        mychart.animateXY(2000,2000);
        mychart.spin( 5000,0,-360f, Easing.EasingOption.EaseInOutElastic);

        mychart.setTransparentCircleAlpha(0);
        mychart.setData(data);
        mychart.invalidate();
    }


}
