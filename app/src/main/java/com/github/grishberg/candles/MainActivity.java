package com.github.grishberg.candles;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;

import com.github.mikephil.charting.charts.CandleStickChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleDataSet;
import com.github.mikephil.charting.data.CandleEntry;

import java.util.ArrayList;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        CandleStickChart chart = findViewById(R.id.chart);

        chart.setHighlightPerDragEnabled(true);

        chart.setDrawBorders(true);

        chart.setBorderColor(getResources().getColor(R.color.colorLightGray));

        YAxis yAxis = chart.getAxisLeft();
        YAxis rightAxis = chart.getAxisRight();
        yAxis.setDrawGridLines(false);
        rightAxis.setDrawGridLines(false);
        chart.requestDisallowInterceptTouchEvent(true);

        XAxis xAxis = chart.getXAxis();

        xAxis.setDrawGridLines(false);// disable x axis grid lines
        xAxis.setDrawLabels(false);
        rightAxis.setTextColor(Color.WHITE);
        yAxis.setDrawLabels(false);
        xAxis.setGranularity(1f);
        xAxis.setGranularityEnabled(true);
        xAxis.setAvoidFirstLastClipping(true);

        Legend l = chart.getLegend();
        l.setEnabled(false);

        ArrayList<CandleEntry> yValsCandleStick = new ArrayList<CandleEntry>();
        yValsCandleStick.add(new CandleEntry(0f, 225.0f, 219.84f, 224.94f, 221.07f));
        yValsCandleStick.add(new CandleEntry(1f, 228.35f, 222.57f, 223.52f, 226.41f));
        yValsCandleStick.add(new CandleEntry(2f, 226.84f, 222.52f, 225.75f, 223.84f));
        yValsCandleStick.add(new CandleEntry(3f, 222.95f, 217.27f, 222.15f, 217.88f));

        // create dataset
        CandleDataSet set1 = new CandleDataSet(yValsCandleStick, "DataSet 1");
        set1.setColor(Color.rgb(80, 80, 80));
        set1.setShadowColor(getResources().getColor(R.color.colorLightGrayMore));
        set1.setShadowWidth(0.8f);
        set1.setDecreasingColor(getResources().getColor(R.color.colorRed));
        set1.setDecreasingPaintStyle(Paint.Style.FILL);
        set1.setIncreasingColor(getResources().getColor(R.color.colorAccent));
        set1.setIncreasingPaintStyle(Paint.Style.FILL);
        set1.setNeutralColor(Color.LTGRAY);
        set1.setDrawValues(false);
        // create a data object with the datasets
        CandleData data = new CandleData(set1);

        //

        chart.setData(data);
        chart.invalidate();
    }
}
