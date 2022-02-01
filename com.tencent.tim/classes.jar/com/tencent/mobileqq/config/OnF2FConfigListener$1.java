package com.tencent.mobileqq.config;

import aehn.a;
import aehz;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import org.json.JSONException;
import org.json.JSONObject;

public class OnF2FConfigListener$1
  implements Runnable
{
  public OnF2FConfigListener$1(aehz paramaehz, aehn.a parama, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    try
    {
      Object localObject = new JSONObject(this.a.strContent);
      int i = ((JSONObject)localObject).optInt("face2faceSwitchOn");
      localObject = ((JSONObject)localObject).optString("face2faceTip");
      BaseApplication.getContext().getSharedPreferences(this.val$app.getCurrentAccountUin() + "qqsettingme_f2f_guide", 0).edit().putInt("qqsettingme_f2f_guide_switch", i).putString("qqsettingme_f2f_guide_tip", (String)localObject).apply();
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.OnF2FConfigListener.1
 * JD-Core Version:    0.7.0.1
 */