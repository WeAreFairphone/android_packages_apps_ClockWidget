package com.fairphone.clock.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

import com.fairphone.clock.R;

public class ClockWidget extends AppWidgetProvider {

    private static final String TAG = ClockWidget.class.getSimpleName();

    private RemoteViews mWidget;
    private Context mContext;

    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);

        mWidget = new RemoteViews(context.getPackageName(), R.layout.clock_widget_main);
        //mWidget = new RemoteViews(context.getPackageName(), R.layout.clock_widget_peace_of_mind);
        new RemoteViews(context.getPackageName(), R.layout.clock_widget_peace_of_mind);
        mContext = context;

        updateBoard();
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        //mWidget = new RemoteViews(context.getPackageName(), R.layout.clock_widget_main);
        mWidget = new RemoteViews(context.getPackageName(), R.layout.clock_widget_peace_of_mind);
        mContext = context;

        Log.i(TAG, "onUpdate()");
        updateBoard();
    }

    private void updateBoard() {


        int code = 0;
        setupButtonClickIntents(mContext, code, mWidget);

        ComponentName widget = new ComponentName(mContext, ClockWidget.class);
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(mContext);
        appWidgetManager.updateAppWidget(widget, null);
        appWidgetManager.updateAppWidget(widget, mWidget);

    }

    private int setupButtonClickIntents(Context context, int code, RemoteViews widget) {
        // set up the all apps intent
        Intent launchIntent = new Intent();
        launchIntent.setAction("blalala");

        PendingIntent launchPendingIntent = PendingIntent.getBroadcast(context, code++, launchIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        return code;
    }
}
