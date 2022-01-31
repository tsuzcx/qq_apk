package com.tencent.mobileqq.startup.step;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.OOMHandler;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlite.R.color;
import com.tencent.qqlite.R.drawable;
import com.tencent.theme.SkinEngine;
import eei;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class InitSkin
  extends Step
{
  public static boolean a;
  private static final int[] a;
  
  static
  {
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_ArrayOfInt = new int[] { 2130837508, 2130837509, 2130837511, 2130837512, 2130837514, 2130837515, 2130837517, 2130837518, 2130837746, 2130837745, 2130839181, 2130839348, 2130839347, 2130839045, 2130838040, 2130838039, 2130839422, 2130839257, 2130839259, 2130839261, 2130839262, 2130839263, 2130839264, 2130839265, 2130839266, 2130839267, 2130839424, 2130839450, 2130839449, 2130838062, 2130838060, 2130838061, 2130838059, 2130838057, 2130838058, 2130838485, 2130838483, 2130838484, 2130838065, 2130838063, 2130838064, 2130837630, 2130839451, 2130838178, 2130838179, 2130838180, 2130838181, 2130839331, 2130839214, 2130839247, 2130839249, 2130838266, 2130838264, 2130838268, 2130839290, 2130839289, 2130839291, 2130838269, 2130838271, 2130839256, 2130838275, 2130838274, 2130838270, 2130839292, 2130837991, 2130837992, 2130839293 };
  }
  
  public static final boolean a(Context paramContext)
  {
    File localFile2;
    for (;;)
    {
      try
      {
        localFile2 = paramContext.getCacheDir();
        l1 = SystemClock.uptimeMillis();
        if (QLog.isColorLevel())
        {
          SkinEngine.SWITCH_DEBUG = true;
          SkinEngine.DEBUG = false;
          localFile1 = new File(localFile2, "/skin/web_config");
          localFile2 = new File(localFile2, "/skin/web_skin_cache");
        }
      }
      catch (Exception localException1)
      {
        long l1;
        File localFile1;
        ObjectInputStream localObjectInputStream;
        int i;
        String str;
        long l2;
        BaseApplicationImpl.jdField_a_of_type_Boolean = false;
        if (QLog.isColorLevel()) {
          QLog.e("SkinEngine", 2, "", localException1);
        }
        paramContext = new File(paramContext.getCacheDir(), "/skin/unsupport");
        if (paramContext.exists()) {
          break label496;
        }
        if (!paramContext.getParentFile().exists()) {
          paramContext.getParentFile().mkdirs();
        }
        try
        {
          paramContext.createNewFile();
          return true;
        }
        catch (IOException paramContext)
        {
          return true;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "web skin cache time out");
        }
        SkinEngine.init(paramContext, jdField_a_of_type_ArrayOfInt, R.color.class, 2131427328, null);
        ThreadManager.b().postDelayed(new eei("/skin/web_config", "/skin/web_skin_cache"), 10000L);
        continue;
      }
      try
      {
        if (!localFile1.exists()) {
          break label418;
        }
        localObjectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(localFile1)));
        i = localObjectInputStream.readInt();
        str = localObjectInputStream.readUTF();
        localObjectInputStream.close();
        if ((i != AppSetting.a) || (!"108074".equals(str))) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "web skin cache find, use cache file accered");
        }
        SkinEngine.init(paramContext, jdField_a_of_type_ArrayOfInt, R.color.class, 2131427328, localFile2);
      }
      catch (Exception localException3)
      {
        if (localException1.exists()) {
          break label372;
        }
        localException1.delete();
        if (localFile2.exists()) {
          break label386;
        }
        localFile2.delete();
        if (!QLog.isColorLevel()) {
          break label403;
        }
        QLog.d("SkinEngine", 2, "web skin Cache load failed.", localException3);
        SkinEngine.init(paramContext, jdField_a_of_type_ArrayOfInt, R.color.class, 2131427328, null);
        continue;
        if (!QLog.isColorLevel()) {
          break label433;
        }
        QLog.d("SkinEngine", 2, "No cache found");
        SkinEngine.init(paramContext, jdField_a_of_type_ArrayOfInt, R.color.class, 2131427328, null);
        ThreadManager.b().postDelayed(new eei("/skin/web_config", "/skin/web_skin_cache"), 10000L);
        continue;
      }
      SkinEngine.getInstances().setSkinEngineHandler(new OOMHandler(BaseApplicationImpl.a()));
      SkinEngine.getInstances().addDrawableResource(2130837635);
      SkinEngine.getInstances().addDrawableResource(2130837759);
      l2 = SystemClock.uptimeMillis();
      try
      {
        paramContext.getResources().getDrawable(2130837504);
        if (!QLog.isColorLevel()) {
          break label496;
        }
        QLog.d("SkinEngine", 2, "web skin init skin engine cost: " + (l2 - l1));
        return true;
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          break label487;
        }
        QLog.e("SkinEngine", 2, "", localException2);
        SkinEngine.getInstances().unInit();
        throw localException2;
      }
      SkinEngine.SWITCH_DEBUG = false;
    }
    label372:
    return true;
  }
  
  public static final boolean initSkin(Context paramContext)
  {
    File localFile2;
    try
    {
      localFile2 = paramContext.getCacheDir();
      l1 = SystemClock.uptimeMillis();
      if (QLog.isColorLevel())
      {
        SkinEngine.SWITCH_DEBUG = true;
        SkinEngine.DEBUG = false;
      }
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          long l1;
          if (paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData.getBoolean("com.sec.android.support.multiwindow"))
          {
            SkinEngine.mIconResourceID = Integer.valueOf(2130838046);
            if (QLog.isColorLevel()) {
              QLog.d("SkinEngine", 2, "Set icon resouceID to " + 2130838046);
            }
          }
          File localFile1 = new File(localFile2, "/skin/config");
          localFile2 = new File(localFile2, "/skin/skin_cache");
          try
          {
            if (!localFile1.exists()) {
              break label531;
            }
            ObjectInputStream localObjectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(localFile1)));
            int i = localObjectInputStream.readInt();
            String str = localObjectInputStream.readUTF();
            localObjectInputStream.close();
            if ((i != AppSetting.a) || (!"108074".equals(str))) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("SkinEngine", 2, "cache find, use cache file accered");
            }
            SkinEngine.init(paramContext, R.drawable.class, 2130837504, R.color.class, 2131427328, localFile2);
          }
          catch (Exception localException3)
          {
            for (;;)
            {
              long l2;
              if (!localNameNotFoundException.exists()) {
                localNameNotFoundException.delete();
              }
              if (!localFile2.exists()) {
                localFile2.delete();
              }
              if (QLog.isColorLevel()) {
                QLog.d("SkinEngine", 2, "Cache load failed.", localException3);
              }
              SkinEngine.init(paramContext, R.drawable.class, 2130837504, R.color.class, 2131427328, null);
              continue;
              if (QLog.isColorLevel()) {
                QLog.d("SkinEngine", 2, "No cache found");
              }
              SkinEngine.init(paramContext, R.drawable.class, 2130837504, R.color.class, 2131427328, null);
              ThreadManager.b().postDelayed(new eei("/skin/config", "/skin/skin_cache"), 10000L);
            }
          }
          SkinEngine.getInstances().setSkinEngineHandler(new OOMHandler(BaseApplicationImpl.a()));
          SkinEngine.getInstances().addDrawableResource(2130837635);
          SkinEngine.getInstances().addDrawableResource(2130837676);
          SkinEngine.getInstances().addDrawableResource(2130837759);
          SkinEngine.getInstances().addDrawableResource(2130837685);
          l2 = SystemClock.uptimeMillis();
          try
          {
            paramContext.getResources().getDrawable(2130837504);
            if (!QLog.isColorLevel()) {
              break label613;
            }
            QLog.d("SkinEngine", 2, "init skin engine cost: " + (l2 - l1));
          }
          catch (Exception localException2)
          {
            if (!QLog.isColorLevel()) {
              break label604;
            }
            QLog.e("SkinEngine", 2, "", localException2);
            SkinEngine.getInstances().unInit();
            throw localException2;
          }
          SkinEngine.SWITCH_DEBUG = false;
        }
        localException1 = localException1;
        BaseApplicationImpl.jdField_a_of_type_Boolean = false;
        if (QLog.isColorLevel()) {
          QLog.e("SkinEngine", 2, "", localException1);
        }
        paramContext = new File(paramContext.getCacheDir(), "/skin/unsupport");
        if (!paramContext.exists())
        {
          if (!paramContext.getParentFile().exists()) {
            paramContext.getParentFile().mkdirs();
          }
          try
          {
            paramContext.createNewFile();
          }
          catch (IOException paramContext) {}
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        for (;;)
        {
          localNameNotFoundException.printStackTrace();
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("SkinEngine", 2, "cache time out");
          }
          SkinEngine.init(paramContext, R.drawable.class, 2130837504, R.color.class, 2131427328, null);
          ThreadManager.b().postDelayed(new eei("/skin/config", "/skin/skin_cache"), 10000L);
        }
      }
    }
    label531:
    label604:
    label613:
    return true;
  }
  
  protected boolean a()
  {
    if (jdField_a_of_type_Boolean) {}
    String str;
    do
    {
      return true;
      jdField_a_of_type_Boolean = true;
      String[] arrayOfString = BaseApplicationImpl.processName.split(":");
      str = null;
      if (arrayOfString.length > 1) {
        str = arrayOfString[1];
      }
      if ((str == null) || (str.endsWith("map")) || (str.equals("pedit")) || (str.equals("plugin")) || (str.equals("demoji")) || (str.equals("peak")))
      {
        initSkin(BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
        return true;
      }
      if (str.equals("web"))
      {
        a(BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
        return true;
      }
    } while (!str.equals("qqfav"));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitSkin
 * JD-Core Version:    0.7.0.1
 */