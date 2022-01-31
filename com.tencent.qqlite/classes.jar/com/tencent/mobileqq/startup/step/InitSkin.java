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
import eec;
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
  private static final int[] b = { 2130837508, 2130837509, 2130837511, 2130837512, 2130837514, 2130837515, 2130837517, 2130837518, 2130837750, 2130837749, 2130839213, 2130839383, 2130839382, 2130839077, 2130838046, 2130838045, 2130839457, 2130839289, 2130839291, 2130839295, 2130839296, 2130839297, 2130839298, 2130839299, 2130839300, 2130839301, 2130839459, 2130839485, 2130839484, 2130838068, 2130838066, 2130838067, 2130838065, 2130838063, 2130838064, 2130838508, 2130838506, 2130838507, 2130838071, 2130838069, 2130838070, 2130837628, 2130839486, 2130838184, 2130838185, 2130838186, 2130838187, 2130839366, 2130839246, 2130839279, 2130839281, 2130838274, 2130838272, 2130838276, 2130839324, 2130839323, 2130839325, 2130838277, 2130838279, 2130839288, 2130838283, 2130838282, 2130838278, 2130839326, 2130837995, 2130837996, 2130839327 };
  
  static
  {
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_ArrayOfInt = new int[] { 2130837547, 2130837593, 2130837592, 2130837591, 2130837714, 2130837750, 2130837749, 2130837909, 2130837911, 2130837915, 2130837904, 2130837959, 2130838024, 2130838052, 2130838148, 2130838313, 2130838468, 2130838492, 2130838903, 2130838902, 2130838898, 2130838897, 2130838893, 2130838892, 2130838463, 2130838464, 2130838465, 2130838466, 2130838468, 2130838469, 2130838470, 2130838471, 2130838472, 2130838477, 2130838478, 2130838479, 2130838480, 2130838481, 2130838482, 2130838483, 2130838484, 2130838485, 2130838488, 2130838487, 2130838489, 2130838490, 2130838491, 2130838493, 2130838492, 2130838494, 2130838495, 2130838496, 2130838497, 2130838498, 2130838499, 2130838500, 2130838501, 2130838502, 2130838503, 2130838504, 2130838763, 2130838570, 2130838571, 2130838478, 2130838531, 2130838570, 2130838571, 2130838477, 2130839099, 2130839213, 2130839212, 2130839211, 2130839219, 2130839218, 2130839350, 2130839324, 2130839323, 2130839246, 2130839289, 2130839374, 2130839296, 2130839295, 2130839297, 2130839301, 2130839300, 2130839291, 2130839266, 2130839275, 2130839276, 2130839281, 2130839350, 2130839338, 2130839339, 2130839342, 2130839344, 2130839346, 2130839345, 2130839348, 2130839322, 2130839321, 2130837995, 2130837508, 2130837509, 2130837511, 2130837512, 2130837514, 2130837515, 2130837517, 2130837518, 2130839347 };
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
          break label512;
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
        SkinEngine.init(paramContext, b, R.color.class, 2131427328, null);
        ThreadManager.b().postDelayed(new eec("/skin/web_config", "/skin/web_skin_cache"), 10000L);
        continue;
      }
      try
      {
        if (!localFile1.exists()) {
          break label431;
        }
        localObjectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(localFile1)));
        i = localObjectInputStream.readInt();
        str = localObjectInputStream.readUTF();
        localObjectInputStream.close();
        if ((i != AppSetting.a) || (!"107392".equals(str))) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "web skin cache find, use cache file accered");
        }
        SkinEngine.init(paramContext, b, R.color.class, 2131427328, localFile2);
      }
      catch (Exception localException3)
      {
        if (localException1.exists()) {
          break label383;
        }
        localException1.delete();
        if (localFile2.exists()) {
          break label397;
        }
        localFile2.delete();
        if (!QLog.isColorLevel()) {
          break label414;
        }
        QLog.d("SkinEngine", 2, "web skin Cache load failed.", localException3);
        SkinEngine.init(paramContext, b, R.color.class, 2131427328, null);
        continue;
        if (!QLog.isColorLevel()) {
          break label446;
        }
        QLog.d("SkinEngine", 2, "No cache found");
        SkinEngine.init(paramContext, b, R.color.class, 2131427328, null);
        ThreadManager.b().postDelayed(new eec("/skin/web_config", "/skin/web_skin_cache"), 10000L);
        continue;
      }
      SkinEngine.getInstances().setSkinEngineHandler(new OOMHandler(BaseApplicationImpl.a()));
      SkinEngine.getInstances().addDrawableResource(2130837633);
      SkinEngine.getInstances().addDrawableResource(2130837906);
      l2 = SystemClock.uptimeMillis();
      try
      {
        paramContext.getResources().getDrawable(2130837504);
        if (!QLog.isColorLevel()) {
          break label512;
        }
        QLog.d("SkinEngine", 2, "web skin init skin engine cost: " + (l2 - l1));
        return true;
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          break label503;
        }
        QLog.e("SkinEngine", 2, "", localException2);
        SkinEngine.getInstances().unInit();
        throw localException2;
      }
      SkinEngine.SWITCH_DEBUG = false;
    }
    label383:
    return true;
  }
  
  public static final boolean b(Context paramContext)
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
          localFile1 = new File(localFile2, "/skin/qqfav_config");
          localFile2 = new File(localFile2, "/skin/qqfav_skin_cache");
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
          break label537;
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
          QLog.d("SkinEngine", 2, "qqfav skin cache time out");
        }
        SkinEngine.init(paramContext, jdField_a_of_type_ArrayOfInt, R.color.class, 2131427328, null);
        ThreadManager.b().postDelayed(new eec("/skin/qqfav_config", "/skin/qqfav_skin_cache"), 10000L);
        continue;
      }
      try
      {
        if (!localFile1.exists()) {
          break label454;
        }
        localObjectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(localFile1)));
        i = localObjectInputStream.readInt();
        str = localObjectInputStream.readUTF();
        localObjectInputStream.close();
        if ((i != AppSetting.a) || (!"107392".equals(str))) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SkinEngine", 2, "qqfav skin cache find, use cache file accered");
        }
        SkinEngine.init(paramContext, jdField_a_of_type_ArrayOfInt, R.color.class, 2131427328, localFile2);
      }
      catch (Exception localException3)
      {
        if (localException1.exists()) {
          break label406;
        }
        localException1.delete();
        if (localFile2.exists()) {
          break label420;
        }
        localFile2.delete();
        if (!QLog.isColorLevel()) {
          break label437;
        }
        QLog.d("SkinEngine", 2, "qqfav skin Cache load failed.", localException3);
        SkinEngine.init(paramContext, jdField_a_of_type_ArrayOfInt, R.color.class, 2131427328, null);
        continue;
        if (!QLog.isColorLevel()) {
          break label469;
        }
        QLog.d("SkinEngine", 2, "No cache found");
        SkinEngine.init(paramContext, jdField_a_of_type_ArrayOfInt, R.color.class, 2131427328, null);
        ThreadManager.b().postDelayed(new eec("/skin/qqfav_config", "/skin/qqfav_skin_cache"), 10000L);
        continue;
      }
      SkinEngine.getInstances().setSkinEngineHandler(new OOMHandler(BaseApplicationImpl.a()));
      SkinEngine.getInstances().addDrawableResource(2130837633);
      SkinEngine.getInstances().addDrawableResource(2130837674);
      SkinEngine.getInstances().addDrawableResource(2130837906);
      SkinEngine.getInstances().addDrawableResource(2130837683);
      l2 = SystemClock.uptimeMillis();
      try
      {
        paramContext.getResources().getDrawable(2130837504);
        if (!QLog.isColorLevel()) {
          break label537;
        }
        QLog.d("SkinEngine", 2, "qqfav skin init skin engine cost: " + (l2 - l1));
        return true;
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          break label528;
        }
        QLog.e("SkinEngine", 2, "", localException2);
        SkinEngine.getInstances().unInit();
        throw localException2;
      }
      SkinEngine.SWITCH_DEBUG = false;
    }
    label406:
    label420:
    label437:
    label454:
    label469:
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
            SkinEngine.mIconResourceID = Integer.valueOf(2130838052);
            if (QLog.isColorLevel()) {
              QLog.d("SkinEngine", 2, "Set icon resouceID to " + 2130838052);
            }
          }
          File localFile1 = new File(localFile2, "/skin/config");
          localFile2 = new File(localFile2, "/skin/skin_cache");
          try
          {
            if (!localFile1.exists()) {
              break label543;
            }
            ObjectInputStream localObjectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(localFile1)));
            int i = localObjectInputStream.readInt();
            String str = localObjectInputStream.readUTF();
            localObjectInputStream.close();
            if ((i != AppSetting.a) || (!"107392".equals(str))) {
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
              ThreadManager.b().postDelayed(new eec("/skin/config", "/skin/skin_cache"), 10000L);
            }
          }
          SkinEngine.getInstances().setSkinEngineHandler(new OOMHandler(BaseApplicationImpl.a()));
          SkinEngine.getInstances().addDrawableResource(2130837633);
          SkinEngine.getInstances().addDrawableResource(2130837674);
          SkinEngine.getInstances().addDrawableResource(2130837906);
          SkinEngine.getInstances().addDrawableResource(2130837683);
          l2 = SystemClock.uptimeMillis();
          try
          {
            paramContext.getResources().getDrawable(2130837504);
            if (!QLog.isColorLevel()) {
              break label629;
            }
            QLog.d("SkinEngine", 2, "init skin engine cost: " + (l2 - l1));
          }
          catch (Exception localException2)
          {
            if (!QLog.isColorLevel()) {
              break label620;
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
          ThreadManager.b().postDelayed(new eec("/skin/config", "/skin/skin_cache"), 10000L);
        }
      }
    }
    label543:
    label620:
    label629:
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
    b(BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitSkin
 * JD-Core Version:    0.7.0.1
 */