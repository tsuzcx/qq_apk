package com.tencent.open.agent;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.open.settings.OpensdkPreference;
import org.json.JSONException;
import org.json.JSONObject;

public class EncryTokenActivity
  extends Activity
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (BaseActivity.a(getIntent()))
    {
      finish();
      return;
    }
    if ("action_check_token".equals(super.getIntent().getStringExtra("key_action")))
    {
      String str = OpensdkPreference.a(this, "openid_encrytoken").getString(super.getIntent().getStringExtra("openid") + "", "");
      paramBundle = new Intent();
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("encry_token", str);
        paramBundle.putExtra("key_response", localJSONObject.toString());
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
    }
    paramBundle = new Intent();
    paramBundle.putExtra("key_response", "");
    super.setResult(-1, paramBundle);
    super.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.agent.EncryTokenActivity
 * JD-Core Version:    0.7.0.1
 */