package com.example.bluepopappbasicdemo;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefrenceConfig {

    private SharedPreferences sharedPreferences;
    private Context context;

    public SharedPrefrenceConfig(Context context)
    {
        this.context = context;

        sharedPreferences = context.getSharedPreferences(context.getResources().getString(R.string.Submit_Prefrence),Context.MODE_PRIVATE);
    }
public void writeSubmitStatus(Boolean status)
{
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putBoolean(context.getResources().getString(R.string.Submit_Status_Prefrences),status);
    editor.commit();

}

public boolean readLoginStatus()
{
    boolean status = false;
    status = sharedPreferences.getBoolean(context.getResources().getString(R.string.Submit_Status_Prefrences),false);
     return status;
}

}
