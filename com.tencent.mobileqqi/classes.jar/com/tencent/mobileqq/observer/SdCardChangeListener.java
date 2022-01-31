package com.tencent.mobileqq.observer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class SdCardChangeListener
  extends BroadcastReceiver
{
  public static final int a = 28929;
  private static final String jdField_a_of_type_JavaLangString = "SdCardListener";
  public static final int b = 0;
  public static final int c = -1;
  public static final int d = -2;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private String b;
  private int e;
  
  public SdCardChangeListener(Handler paramHandler)
  {
    this.a = paramHandler;
    this.b = Environment.getExternalStorageDirectory().getAbsolutePath();
  }
  
  public int a(int paramInt)
  {
    try
    {
      Object localObject1 = new File(this.b + "/" + System.currentTimeMillis() + ".tst");
      ((File)localObject1).createNewFile();
      ((File)localObject1).delete();
      if (paramInt == -2) {}
      Bundle localBundle;
      this.e = paramInt;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException = localException;
        localException.printStackTrace();
        if (paramInt == -2) {
          this.e = paramInt;
        } else {
          this.e = -1;
        }
      }
    }
    finally
    {
      if (paramInt != -2) {}
    }
    for (;;)
    {
      throw localObject3;
      this.e = -1;
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    this.e = a(0);
    if (this.e == 0) {
      bool = true;
    }
    return bool;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.MEDIA_UNMOUNTED"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SdCardListener", 2, "SDCARD ACTION_MEDIA_UNMOUNTED");
      }
      this.e = -2;
    }
    for (;;)
    {
      this.e = a(this.e);
      return;
      if (paramContext.equals("android.intent.action.MEDIA_MOUNTED"))
      {
        this.e = 0;
        if (QLog.isColorLevel()) {
          QLog.d("SdCardListener", 2, "SDCARD ACTION_MEDIA_MOUNTED");
        }
      }
      else if (paramContext.equals("android.intent.action.MEDIA_REMOVED"))
      {
        this.e = -2;
        if (QLog.isColorLevel()) {
          QLog.d("SdCardListener", 2, "SDCARD ACTION_MEDIA_REMOVED");
        }
      }
      else if (paramContext.equals("android.intent.action.MEDIA_EJECT"))
      {
        this.e = -2;
        if (QLog.isColorLevel()) {
          QLog.d("SdCardListener", 2, "SDCARD ACTION_MEDIA_EJECT");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.observer.SdCardChangeListener
 * JD-Core Version:    0.7.0.1
 */