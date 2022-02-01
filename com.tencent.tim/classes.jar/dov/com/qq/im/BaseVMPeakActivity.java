package dov.com.qq.im;

import android.os.Bundle;
import android.support.annotation.NonNull;
import axzd;
import axzd.a;
import axzf;
import axzw;
import ayaa;
import ayab;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.qphone.base.util.QLog;

public class BaseVMPeakActivity
  extends PeakActivity
  implements axzf, ayab
{
  private axzw jdField_a_of_type_Axzw = new axzw(this);
  private ayaa jdField_a_of_type_Ayaa;
  
  public axzd a()
  {
    return this.jdField_a_of_type_Axzw;
  }
  
  @NonNull
  public ayaa a()
  {
    if (BaseApplicationImpl.getApplication() == null) {
      throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }
    if (this.jdField_a_of_type_Ayaa == null) {
      this.jdField_a_of_type_Ayaa = new ayaa();
    }
    return this.jdField_a_of_type_Ayaa;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Axzw = new axzw(this);
    try
    {
      this.jdField_a_of_type_Axzw.a(axzd.a.a);
      return;
    }
    catch (Throwable paramBundle)
    {
      QLog.e("BaseActivity2", 1, "mLifecycleRegistry 初始化失败");
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    try
    {
      this.jdField_a_of_type_Axzw.a(axzd.a.f);
      if ((this.jdField_a_of_type_Ayaa != null) && (!isChangingConfigurations())) {
        this.jdField_a_of_type_Ayaa.clear();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("BaseActivity2", 1, "mLifecycleRegistry 初始化失败");
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    try
    {
      this.jdField_a_of_type_Axzw.a(axzd.a.d);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("BaseActivity2", 1, "mLifecycleRegistry 初始化失败");
    }
  }
  
  public void onResume()
  {
    super.onResume();
    try
    {
      this.jdField_a_of_type_Axzw.a(axzd.a.c);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("BaseActivity2", 1, "mLifecycleRegistry 初始化失败");
    }
  }
  
  public void onStart()
  {
    super.onStart();
    try
    {
      this.jdField_a_of_type_Axzw.a(axzd.a.b);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("BaseActivity2", 1, "mLifecycleRegistry 初始化失败");
    }
  }
  
  public void onStop()
  {
    super.onStop();
    try
    {
      this.jdField_a_of_type_Axzw.a(axzd.a.e);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("BaseActivity2", 1, "mLifecycleRegistry 初始化失败");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.BaseVMPeakActivity
 * JD-Core Version:    0.7.0.1
 */