package com.tencent.open.agent;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.open.settings.OpensdkPreference;
import org.json.JSONException;
import org.json.JSONObject;

public class EncryTokenActivity
  extends Activity
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Object localObject1 = "";
    try
    {
      localObject2 = super.getIntent();
      paramBundle = (Bundle)localObject1;
      if (localObject2 != null) {
        paramBundle = ((Intent)localObject2).getStringExtra("key_action");
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Object localObject2;
        label75:
        paramBundle = localException;
      }
    }
    if ("action_check_token".equals(paramBundle))
    {
      localObject2 = OpensdkPreference.a(this, "openid_encrytoken");
      paramBundle = "";
    }
    try
    {
      localObject1 = super.getIntent().getStringExtra("openid") + "";
      paramBundle = (Bundle)localObject1;
    }
    catch (Exception localException)
    {
      break label75;
    }
    localObject2 = ((SharedPreferences)localObject2).getString(paramBundle, "");
    paramBundle = new Intent();
    localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("encry_token", localObject2);
      paramBundle.putExtra("key_response", ((JSONObject)localObject1).toString());
      super.setResult(-1, paramBundle);
      super.finish();
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    paramBundle = new Intent();
    paramBundle.putExtra("key_response", "");
    super.setResult(-1, paramBundle);
    super.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.open.agent.EncryTokenActivity
 * JD-Core Version:    0.7.0.1
 */