package com.example.week3day2homework;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.Bundle;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_POP =
            "com.example.mybroadcast.action.FOO.Populate";
    private static final String ACTION_CLEAR
            = "com.example.mybroadcast.action.BAZ.Clear";

    // TODO: Rename parameters
    public static final String POPULATE_NUM_ONE
            = "com.example.mybroadcast.extra.NumberOne";

    public MyIntentService() {
        super("MyIntentService");
    }

    /**
     *
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startPopulation(Context context, int numOne) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_POP);
        intent.putExtra(POPULATE_NUM_ONE, numOne);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method


    //What the service will actually run.
    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_POP.equals(action)) {
                final int param1 = Integer.parseInt(intent.getStringExtra(POPULATE_NUM_ONE));
                //handlePopulation(param1);
            }
        }
    }


}
