package com.tencent.mobileqq.transfile;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import grw;
import java.util.concurrent.atomic.AtomicInteger;

public class NetworkCenter
{
  public static NetworkCenter a;
  public static final String a = "NetworkCenter";
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private Runnable jdField_a_of_type_JavaLangRunnable = new grw(this);
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private String b = "";
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqTransfileNetworkCenter = null;
  }
  
  protected NetworkCenter()
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 60000L);
  }
  
  public static NetworkCenter a()
  {
    if (jdField_a_of_type_ComTencentMobileqqTransfileNetworkCenter == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqTransfileNetworkCenter == null) {
        jdField_a_of_type_ComTencentMobileqqTransfileNetworkCenter = new NetworkCenter();
      }
      return jdField_a_of_type_ComTencentMobileqqTransfileNetworkCenter;
    }
    finally {}
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public String a()
  {
    try
    {
      String str = this.b;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a()
  {
    try
    {
      int i = NetworkUtil.a(BaseApplication.getContext());
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(i);
      NetworkInfo localNetworkInfo = ((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
      String str = null;
      if (localNetworkInfo != null) {
        str = localNetworkInfo.getExtraInfo();
      }
      this.b = PkgTools.f(str);
      if (QLog.isColorLevel()) {
        QLog.d("NetworkCenter", 2, "net event:" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + " apn type:" + this.b);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    finally {}
  }
  
  public void b()
  {
    try
    {
      a();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.NetworkCenter
 * JD-Core Version:    0.7.0.1
 */