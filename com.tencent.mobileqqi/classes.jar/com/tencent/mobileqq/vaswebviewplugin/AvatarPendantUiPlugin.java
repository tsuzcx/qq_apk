package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vas.AvatarPendantMarketActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class AvatarPendantUiPlugin
  extends VasWebviewUiPlugin
{
  private static final String LOG_TAG = "AvatarPendantUiPlugin";
  public static final int REQUEST_CODE_TAKE_PHOTO = 1;
  public static String sCallbackId;
  public static AvatarPendantJsPlugin sJsHandler;
  public static Uri sUploadPhotoUri;
  
  void OnActivityCreate()
  {
    this.activity.setTitle(2131562668);
    this.activity.I = decodeUrl(this.activity.I);
  }
  
  public String decodeUrl(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvatarPendantUiPlugin", 2, "Decode pendant market url: " + paramString);
    }
    if (paramString == null)
    {
      paramString = null;
      return paramString;
    }
    String str = paramString.replace("[client]", "androidQQ").replace("[version]", "6.0.2.6602").replace("[system]", Build.VERSION.RELEASE).replace("[device]", Build.DEVICE);
    if (super.getInfoIntent().getBooleanExtra("key_update_flag", false)) {}
    for (paramString = "1";; paramString = "0")
    {
      str = str.replace("[updateFlag]", paramString);
      paramString = str;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("AvatarPendantUiPlugin", 2, "After decode pendant market url: " + str);
      return str;
    }
  }
  
  protected boolean excuteEvent(String paramString, int paramInt, Map paramMap)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return false;
        } while (paramMap == null);
        paramString = (Intent)paramMap.get("intent");
      } while (paramString == null);
      paramString = paramString.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    } while (paramString == null);
    if ((sJsHandler == null) || (sCallbackId == null)) {
      return false;
    }
    paramMap = new Bundle();
    paramMap.putString("path", paramString);
    paramString = DataFactory.makeIPCRequestPacket("changeAvatar", sCallbackId, sJsHandler.getIPCResponseKey(), paramMap);
    paramMap = new JSONObject();
    try
    {
      paramMap.put("result", 0);
      callJs(sCallbackId + "(" + paramMap.toString() + ");");
      sJsHandler.sendRemoteReq(paramString, false, false);
      return true;
    }
    catch (JSONException paramMap)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AvatarPendantUiPlugin", 2, "Failed to notify starting upload avatar:" + paramMap.getMessage());
        }
      }
    }
  }
  
  protected long getPluginBusiness()
  {
    return 512L;
  }
  
  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvatarPendantUiPlugin", 2, "onActivityResult, requestCode=" + paramInt1 + ", resultCode=" + paramInt2 + ", data=" + paramIntent);
    }
    if (paramInt1 == 1) {
      if (paramInt2 == -1)
      {
        if (sUploadPhotoUri != null)
        {
          paramIntent = ImageUtil.c(this.activity, sUploadPhotoUri);
          paramInt1 = Math.min(482, ProfileCardUtil.a(this.activity));
          Intent localIntent = new Intent();
          localIntent.putExtra("Business_Origin", 100);
          PhotoUtils.a(localIntent, this.activity, AvatarPendantMarketActivity.class.getName(), paramInt1, paramInt1, 640, 640, paramIntent, ProfileCardUtil.b());
          sUploadPhotoUri = null;
          return true;
        }
      }
      else if ((paramInt2 == 0) && (sJsHandler != null) && (sCallbackId != null)) {
        try
        {
          paramIntent = new JSONObject();
          paramIntent.put("result", 2);
          callJs(sCallbackId + "(" + paramIntent.toString() + ");");
          return true;
        }
        catch (JSONException paramIntent)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("AvatarPendantUiPlugin", 2, "cancel select photo: " + paramIntent.getMessage());
            }
          }
        }
      }
    }
    return false;
  }
  
  public void onDestroy()
  {
    sCallbackId = null;
    sUploadPhotoUri = null;
    sJsHandler = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.AvatarPendantUiPlugin
 * JD-Core Version:    0.7.0.1
 */