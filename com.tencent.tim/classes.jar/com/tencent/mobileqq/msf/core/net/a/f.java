package com.tencent.mobileqq.msf.core.net.a;

import android.content.Context;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.qphone.base.util.QLog;

public class f
{
  public static final String a = "SocketAdaptorFactory";
  public static int b = 0;
  public static int c = 0;
  public static final int d = 0;
  public static final int e = 1;
  public static final int f = 2;
  public static final int g = 146;
  public static final int h = 147;
  public static final int i = 148;
  public static final int j = 149;
  public static final int k = 150;
  public static final int l = 151;
  public static final int m = 152;
  public static final int n = 153;
  public static final int o = 154;
  public static final int p = 155;
  public static final int q = 156;
  public static final int r = 513;
  public static final int s = 514;
  public static final int t = 515;
  public static final int u = 516;
  private static e v = null;
  private static boolean w = false;
  private static Context y;
  private static a z = null;
  private MsfCore x;
  
  public f(MsfCore paramMsfCore, Context paramContext)
  {
    try
    {
      this.x = paramMsfCore;
      y = paramContext;
      v = a(y);
      z = new a(paramMsfCore, b);
      QLog.d("SocketAdaptorFactory", 1, "init socketadaptorfacotry succ");
      return;
    }
    catch (Exception paramMsfCore)
    {
      QLog.d("SocketAdaptorFactory", 1, "failed to init socketadaptorfacotry " + paramMsfCore.toString());
      b = 0;
      w = false;
    }
  }
  
  private e a(Context paramContext)
  {
    for (;;)
    {
      try
      {
        b = f();
        QLog.d("SocketAdaptorFactory", 1, "create adaptor get mode " + b);
        switch (b)
        {
        case 2: 
          w = true;
          return new d(paramContext);
        }
      }
      catch (Exception localException)
      {
        c localc;
        w = false;
        QLog.d("SocketAdaptorFactory", 1, "Failed to create SocketAdaptor " + localException.toString());
        return new d(paramContext);
      }
      w = true;
      localc = new c(paramContext);
      return localc;
    }
  }
  
  public static boolean a()
  {
    return w;
  }
  
  private int f()
  {
    try
    {
      Class.forName("com.huawei.android.bastet.HwBastet");
      return 2;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
    }
    return 1;
  }
  
  public e b()
  {
    return v;
  }
  
  public a c()
  {
    return z;
  }
  
  public void d()
  {
    c = b;
    b = 0;
    w = false;
  }
  
  public void e()
  {
    b = c;
    w = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.a.f
 * JD-Core Version:    0.7.0.1
 */