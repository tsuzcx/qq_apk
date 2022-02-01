package com.tencent.mobileqq.mybusiness;

import MyCarrier.Carrier;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import gdg;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import mqq.app.NewIntent;
import mqq.manager.Manager;

public class MyBusinessManager
  implements Manager
{
  public static final String a = "MyBusinessManager";
  public int a;
  Carrier jdField_a_of_type_MyCarrierCarrier = null;
  public QQAppInterface a;
  private MyBusinessObserver jdField_a_of_type_ComTencentMobileqqMybusinessMyBusinessObserver = new gdg(this);
  public boolean a;
  boolean b = false;
  
  public MyBusinessManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqMybusinessMyBusinessObserver);
  }
  
  public Carrier a()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    if ((this.jdField_a_of_type_MyCarrierCarrier != null) || (this.jdField_a_of_type_Boolean)) {
      return this.jdField_a_of_type_MyCarrierCarrier;
    }
    for (;;)
    {
      try
      {
        localFileInputStream = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().openFileInput(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + ".mycarrier");
        localObject1 = localFileInputStream;
        localObject3 = localFileInputStream;
        Object localObject4 = new byte[localFileInputStream.available()];
        localObject1 = localFileInputStream;
        localObject3 = localFileInputStream;
        localFileInputStream.read((byte[])localObject4);
        localObject1 = localFileInputStream;
        localObject3 = localFileInputStream;
        if (localObject4.length > 0)
        {
          localObject1 = localFileInputStream;
          localObject3 = localFileInputStream;
          localObject4 = new JceInputStream((byte[])localObject4);
          localObject1 = localFileInputStream;
          localObject3 = localFileInputStream;
          Carrier localCarrier = new Carrier();
          localObject1 = localFileInputStream;
          localObject3 = localFileInputStream;
          localCarrier.readFrom((JceInputStream)localObject4);
          localObject1 = localFileInputStream;
          localObject3 = localFileInputStream;
          this.jdField_a_of_type_MyCarrierCarrier = localCarrier;
        }
      }
      catch (Exception localException)
      {
        FileInputStream localFileInputStream;
        localObject3 = localIOException1;
        localException.printStackTrace();
        localObject3 = localIOException1;
        this.jdField_a_of_type_MyCarrierCarrier = null;
        if (localIOException1 == null) {
          continue;
        }
        try
        {
          localIOException1.close();
        }
        catch (IOException localIOException2)
        {
          localIOException2.printStackTrace();
        }
        continue;
      }
      finally
      {
        if (localObject3 == null) {
          break label243;
        }
      }
      try
      {
        localFileInputStream.close();
        if (QLog.isDevelopLevel()) {
          QLog.d("MyBusinessManager", 4, "getCarrier carrier = " + this.jdField_a_of_type_MyCarrierCarrier);
        }
        this.jdField_a_of_type_Boolean = true;
        return this.jdField_a_of_type_MyCarrierCarrier;
      }
      catch (IOException localIOException1)
      {
        localIOException1.printStackTrace();
      }
    }
    try
    {
      localObject3.close();
      label243:
      throw localObject2;
    }
    catch (IOException localIOException3)
    {
      for (;;)
      {
        localIOException3.printStackTrace();
      }
    }
  }
  
  public void a(Carrier paramCarrier)
  {
    this.b = false;
    this.jdField_a_of_type_MyCarrierCarrier = paramCarrier;
    Object localObject2 = null;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        localFileOutputStream = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().openFileOutput(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + ".mycarrier", 0);
        if (paramCarrier == null)
        {
          localObject1 = localFileOutputStream;
          localObject2 = localFileOutputStream;
          localFileOutputStream.write(new byte[0]);
        }
      }
      catch (Exception paramCarrier)
      {
        FileOutputStream localFileOutputStream;
        localObject2 = localObject1;
        paramCarrier.printStackTrace();
        if (localObject1 == null) {
          continue;
        }
        try
        {
          localObject1.close();
          return;
        }
        catch (IOException paramCarrier)
        {
          paramCarrier.printStackTrace();
          return;
        }
      }
      finally
      {
        if (localObject2 == null) {
          break label136;
        }
      }
      try
      {
        localFileOutputStream.close();
        return;
      }
      catch (IOException paramCarrier)
      {
        paramCarrier.printStackTrace();
        return;
      }
      localObject1 = localFileOutputStream;
      localObject2 = localFileOutputStream;
      localFileOutputStream.write(paramCarrier.toByteArray());
    }
    try
    {
      localObject2.close();
      label136:
      throw paramCarrier;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (this.b) {
      return;
    }
    this.b = true;
    if (QLog.isDevelopLevel()) {
      QLog.d("MyBusinessManager", 4, "......carrierQuery pBindMobile = " + paramString1 + ", pBindFrom = " + paramInt);
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), MyBusinessServlet.class);
    localNewIntent.putExtra("cmd_id", 1);
    localNewIntent.putExtra("phone_number", paramString1);
    localNewIntent.putExtra("bind_from", paramInt);
    localNewIntent.putExtra("opt_info", paramString2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putLong("lastQueryTime", System.currentTimeMillis()).commit();
  }
  
  public boolean a()
  {
    Carrier localCarrier = a();
    return (localCarrier != null) && (!TextUtils.isEmpty(localCarrier.carrierURL));
  }
  
  public void b(String paramString1, int paramInt, String paramString2)
  {
    if ((this.b) || (this.jdField_a_of_type_Int == 0)) {}
    long l;
    do
    {
      return;
      l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("lastQueryTime", 0L);
    } while (Math.abs((System.currentTimeMillis() - l) / 1000L) - this.jdField_a_of_type_Int <= 0L);
    a(paramString1, paramInt, paramString2);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqMybusinessMyBusinessObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.mybusiness.MyBusinessManager
 * JD-Core Version:    0.7.0.1
 */