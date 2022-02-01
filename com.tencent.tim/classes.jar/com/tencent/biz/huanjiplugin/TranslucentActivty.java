package com.tencent.biz.huanjiplugin;

import acfp;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import avfw;
import avfw.d;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qhuanji.QHuanjiPluginProxyActivity;
import jrw;

public class TranslucentActivty
  extends Activity
{
  private void aI(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.w("HuanjiPlugin", 2, "begin startPlugin.......");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (((avfw)localQQAppInterface.getManager(27)).isPlugininstalled("qhuanji_plugin.apk"))
    {
      jrw.a().J(4, 5, 100);
      paramIntent.putExtra("userQqResources", 2);
      avfw.d locald = new avfw.d(0);
      locald.mPluginID = "qhuanji_plugin.apk";
      locald.mPluginName = acfp.m(2131715434);
      locald.mUin = localQQAppInterface.getCurrentUin();
      locald.cKu = "com.tencent.huanji.activity.SwitchPhoneActivity";
      locald.K = QHuanjiPluginProxyActivity.class;
      locald.mIntent = paramIntent;
      locald.mRequestCode = -1;
      locald.mTimeOut = 10000;
      locald.cKv = null;
      avfw.a(this, locald);
      jrw.a().J(4, 6, 100);
      finish();
      return;
    }
    finish();
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().getProxy(paramString, paramInt);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    aI(super.getIntent());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.huanjiplugin.TranslucentActivty
 * JD-Core Version:    0.7.0.1
 */