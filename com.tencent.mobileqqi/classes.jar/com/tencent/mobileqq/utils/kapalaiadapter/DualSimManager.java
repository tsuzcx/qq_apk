package com.tencent.mobileqq.utils.kapalaiadapter;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.telephony.TelephonyManager;
import com.android.internal.telephony.ISms;
import com.android.internal.telephony.ISms.Stub;
import com.tencent.common.app.BaseApplicationImpl;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class DualSimManager
{
  public static int a = 0;
  private static DualSimManager jdField_a_of_type_ComTencentMobileqqUtilsKapalaiadapterDualSimManager = null;
  public static String a;
  public static final int b = 0;
  public static String b;
  public static final int c = 1;
  public static String c = "1";
  public static final int d = 2;
  public static final int e = 3;
  public static final int f = 4;
  public static final int g = 5;
  private Object jdField_a_of_type_JavaLangObject = null;
  private TelephonyManager[] jdField_a_of_type_ArrayOfAndroidTelephonyTelephonyManager = null;
  private ISms[] jdField_a_of_type_ArrayOfComAndroidInternalTelephonyISms = null;
  private Object b;
  
  static
  {
    jdField_a_of_type_Int = -1;
    jdField_a_of_type_JavaLangString = null;
    jdField_b_of_type_JavaLangString = "0";
  }
  
  private DualSimManager()
  {
    this.jdField_b_of_type_JavaLangObject = null;
    a();
  }
  
  public static DualSimManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqUtilsKapalaiadapterDualSimManager == null) {}
    try
    {
      jdField_a_of_type_ComTencentMobileqqUtilsKapalaiadapterDualSimManager = new DualSimManager();
      return jdField_a_of_type_ComTencentMobileqqUtilsKapalaiadapterDualSimManager;
    }
    finally {}
  }
  
  private void a()
  {
    this.jdField_a_of_type_ArrayOfComAndroidInternalTelephonyISms = new ISms[2];
    switch (jdField_a_of_type_Int)
    {
    case 0: 
    case 1: 
    case 4: 
    default: 
    case 2: 
    case 3: 
      for (;;)
      {
        return;
        try
        {
          this.jdField_a_of_type_JavaLangObject = ReflecterHelper.a("android.telephony.MSimTelephonyManager", "getDefault", null, null);
          this.jdField_b_of_type_JavaLangObject = ReflecterHelper.a("android.telephony.MSimSmsManager", "getDefault", null, null);
          return;
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          return;
        }
        try
        {
          this.jdField_a_of_type_ArrayOfComAndroidInternalTelephonyISms[0] = ISms.Stub.a(ServiceManager.a("isms"));
          this.jdField_a_of_type_ArrayOfComAndroidInternalTelephonyISms[1] = ISms.Stub.a(ServiceManager.a("isms2"));
          if (this.jdField_a_of_type_ArrayOfAndroidTelephonyTelephonyManager == null)
          {
            this.jdField_a_of_type_ArrayOfAndroidTelephonyTelephonyManager = new TelephonyManager[2];
            this.jdField_a_of_type_ArrayOfAndroidTelephonyTelephonyManager[0] = ((TelephonyManager)ReflecterHelper.b("android.telephony.TelephonyManager", "getDefault"));
            this.jdField_a_of_type_ArrayOfAndroidTelephonyTelephonyManager[1] = ((TelephonyManager)ReflecterHelper.b("android.telephony.TelephonyManager", "getSecondary"));
            return;
          }
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          return;
        }
      }
    }
    try
    {
      this.jdField_a_of_type_JavaLangObject = BaseApplicationImpl.getContext().getSystemService("phone");
      ISms localISms = ISms.Stub.a((IBinder)Class.forName("android.os.ServiceManager").getMethod("getService", new Class[] { String.class }).invoke(null, new Object[] { "isms" }));
      this.jdField_a_of_type_ArrayOfComAndroidInternalTelephonyISms[0] = localISms;
      return;
    }
    catch (Exception localException3)
    {
      localException3.printStackTrace();
    }
  }
  
  public int a(int paramInt)
  {
    int i = 1;
    switch (jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      return 0;
      if (this.jdField_a_of_type_JavaLangObject == null) {
        continue;
      }
      try
      {
        paramInt = ((Integer)ReflecterHelper.a(this.jdField_a_of_type_JavaLangObject, "getSimState", new Object[] { Integer.valueOf(paramInt) })).intValue();
        return paramInt;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
      continue;
      if (this.jdField_a_of_type_ArrayOfAndroidTelephonyTelephonyManager == null) {
        continue;
      }
      return this.jdField_a_of_type_ArrayOfAndroidTelephonyTelephonyManager[paramInt].getSimState();
      if (this.jdField_a_of_type_JavaLangObject == null) {
        continue;
      }
      try
      {
        Object localObject = this.jdField_a_of_type_JavaLangObject;
        if (paramInt == 0) {}
        for (paramInt = i;; paramInt = 5)
        {
          paramInt = ((Integer)ReflecterHelper.a(localObject, "getIccState", new Object[] { Integer.valueOf(paramInt) })).intValue();
          return paramInt;
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    return a(paramInt) == 5;
  }
  
  public boolean a(int paramInt, String paramString1, String paramString2, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3)
  {
    switch (jdField_a_of_type_Int)
    {
    }
    Class localClass;
    Object localObject1;
    do
    {
      do
      {
        do
        {
          return false;
        } while (this.jdField_b_of_type_JavaLangObject == null);
        try
        {
          ReflecterHelper.a(this.jdField_b_of_type_JavaLangObject, "sendMultipartTextMessage", new Object[] { paramString1, paramString2, paramArrayList1, paramArrayList2, paramArrayList3, Integer.valueOf(paramInt) });
          return true;
        }
        catch (Exception paramString1)
        {
          paramString1.printStackTrace();
          return false;
        }
      } while (this.jdField_a_of_type_ArrayOfComAndroidInternalTelephonyISms == null);
      if (paramArrayList1.size() <= 1)
      {
        Object localObject2 = null;
        localClass = null;
        localObject1 = localObject2;
        if (paramArrayList2 != null)
        {
          localObject1 = localObject2;
          if (paramArrayList2.size() > 0) {
            localObject1 = (PendingIntent)paramArrayList2.get(0);
          }
        }
        paramArrayList2 = localClass;
        if (paramArrayList3 != null)
        {
          paramArrayList2 = localClass;
          if (paramArrayList3.size() > 0) {
            paramArrayList2 = (PendingIntent)paramArrayList3.get(0);
          }
        }
        try
        {
          this.jdField_a_of_type_ArrayOfComAndroidInternalTelephonyISms[paramInt].a(paramString1, paramString2, (String)paramArrayList1.get(0), (PendingIntent)localObject1, paramArrayList2);
          return true;
        }
        catch (Throwable paramString1)
        {
          return false;
        }
      }
      try
      {
        this.jdField_a_of_type_ArrayOfComAndroidInternalTelephonyISms[paramInt].a(paramString1, paramString2, paramArrayList1, paramArrayList2, paramArrayList3);
        return true;
      }
      catch (RemoteException paramString1)
      {
        paramString1.printStackTrace();
        return false;
      }
    } while (this.jdField_a_of_type_ArrayOfComAndroidInternalTelephonyISms[0] == null);
    if (paramInt == 0) {
      paramInt = 1;
    }
    for (;;)
    {
      if (paramArrayList1.size() > 1) {
        try
        {
          ReflecterHelper.a(this.jdField_a_of_type_ArrayOfComAndroidInternalTelephonyISms[0], "sendMultipartTextExt", new Class[] { String.class, String.class, List.class, List.class, List.class, Bundle.class, Integer.TYPE }, new Object[] { paramString1, paramString2, paramArrayList1, paramArrayList2, paramArrayList3, null, Integer.valueOf(paramInt) });
          return true;
          paramInt = 5;
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            paramString1.printStackTrace();
          }
        }
      }
    }
    if ((paramArrayList2 != null) && (paramArrayList2.size() > 0)) {}
    for (paramArrayList2 = (PendingIntent)paramArrayList2.get(0);; paramArrayList2 = null)
    {
      if ((paramArrayList3 != null) && (paramArrayList3.size() > 0)) {}
      for (paramArrayList3 = (PendingIntent)paramArrayList3.get(0);; paramArrayList3 = null) {
        try
        {
          localObject1 = this.jdField_a_of_type_ArrayOfComAndroidInternalTelephonyISms[0];
          localClass = Integer.TYPE;
          paramArrayList1 = paramArrayList1.get(0);
          ReflecterHelper.a(localObject1, "sendTextExt", new Class[] { String.class, String.class, String.class, PendingIntent.class, PendingIntent.class, Bundle.class, localClass }, new Object[] { paramString1, paramString2, paramArrayList1, paramArrayList2, paramArrayList3, null, Integer.valueOf(paramInt) });
        }
        catch (Exception paramString1)
        {
          paramString1.printStackTrace();
          return false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.kapalaiadapter.DualSimManager
 * JD-Core Version:    0.7.0.1
 */