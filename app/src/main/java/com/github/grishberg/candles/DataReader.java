package com.github.grishberg.candles;

import android.content.Context;

import com.github.grishberg.binance.domain.Candle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class DataReader {
    private static final int DATE_ROW = 1;
    private static final int OPEN_ROW = 2;
    private static final int HIGHT_ROW = 3;
    private static final int LOW_ROW = 4;
    private static final int CLOSE_ROW = 5;
    private static final int VOLUME_ROW = 6;
    private final Context context;

    public DataReader(Context ctx) {
        context = ctx;
    }

    public List<Candle> readFromAssets(String fileName) {
        ArrayList<Candle> result = new ArrayList<>();

        try {
            InputStreamReader is = new InputStreamReader(context.getAssets()
                    .open(fileName));

            BufferedReader reader = new BufferedReader(is);
            reader.readLine();
            String line;
            boolean isFirstLine = true;
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] values = line.split(",");
                result.add(new CandleImpl(
                                Float.valueOf(values[OPEN_ROW]),
                                Float.valueOf(values[HIGHT_ROW]),
                                Float.valueOf(values[LOW_ROW]),
                                Float.valueOf(values[CLOSE_ROW]),
                                Float.valueOf(values[VOLUME_ROW]),
                                parseDate(values[DATE_ROW])
                        )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private long parseDate(String in) {
        return stringToDate(in).getTime();
    }

    private Date stringToDate(String aDate) {
        String aFormat = "EEE MMM d HH:mm:ss zz yyyy";
        if(aDate==null) return null;
        ParsePosition pos = new ParsePosition(0);
        SimpleDateFormat simpledateformat = new SimpleDateFormat(aFormat);
        Date stringDate = simpledateformat.parse(aDate, pos);
        return stringDate;

    }
}
