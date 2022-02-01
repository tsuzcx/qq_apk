package cooperation.qzone;

import acfp;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import arhz;
import avfw;
import avfw.d;
import avsc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AndroidOreoUtils;

public class TranslucentActivity
  extends Activity
{
  private void aI(Intent paramIntent)
  {
    arhz localarhz;
    if (!((avfw)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(27)).isPlugininstalled("qzone_plugin.apk"))
    {
      localarhz = new arhz(this, getResources().getDimensionPixelSize(2131299627));
      localarhz.setMessage(acfp.m(2131715436));
      localarhz.setOnDismissListener(new avsc(this));
    }
    for (;;)
    {
      String str = QzonePluginProxyActivity.i(paramIntent);
      paramIntent.putExtra("userQqResources", 2);
      avfw.d locald = new avfw.d(0);
      locald.mPluginID = "qzone_plugin.apk";
      locald.mPluginName = "QZone";
      locald.mUin = "";
      locald.cKu = str;
      locald.K = QzonePluginProxyActivity.class;
      locald.mIntent = paramIntent;
      locald.mRequestCode = -1;
      locald.mDialog = localarhz;
      locald.mTimeOut = 10000;
      locald.cKv = null;
      avfw.a(this, locald);
      if (localarhz == null) {
        finish();
      }
      return;
      localarhz = null;
    }
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().getProxy(paramString, paramInt);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AndroidOreoUtils localAndroidOreoUtils = new AndroidOreoUtils(this);
    if ((Build.VERSION.SDK_INT == 26) && (getApplicationInfo().targetSdkVersion >= 27) && (localAndroidOreoUtils.isTranslucentOrFloating()))
    {
      boolean bool = localAndroidOreoUtils.fixOrientation();
      QLog.i("TranslucentActivity", 1, "onCreate fixOrientation when Oreo, result = " + bool);
    }
    super.onCreate(paramBundle);
    paramBundle = super.getIntent();
    if (!TextUtils.isEmpty(QzonePluginProxyActivity.i(paramBundle))) {
      aI(paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.TranslucentActivity
 * JD-Core Version:    0.7.0.1
 */