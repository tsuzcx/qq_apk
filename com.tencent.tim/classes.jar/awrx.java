import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class awrx
  implements axzf, ayab, aycc
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
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent, boolean paramBoolean)
  {
    return false;
  }
  
  public void finish() {}
  
  public void lp(int paramInt1, int paramInt2) {}
  
  @CallSuper
  public void onActivityPause()
  {
    try
    {
      this.jdField_a_of_type_Axzw.a(axzd.a.d);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QIMCameraLifeCycleBaseUnit", 1, "mLifecycleRegistry 初始化失败");
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  @CallSuper
  public void onActivityResume()
  {
    try
    {
      this.jdField_a_of_type_Axzw.a(axzd.a.c);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QIMCameraLifeCycleBaseUnit", 1, "mLifecycleRegistry 初始化失败");
    }
  }
  
  @CallSuper
  public void onActivityStart()
  {
    try
    {
      this.jdField_a_of_type_Axzw.a(axzd.a.b);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QIMCameraLifeCycleBaseUnit", 1, "mLifecycleRegistry 初始化失败");
    }
  }
  
  @CallSuper
  public void onActivityStop()
  {
    try
    {
      this.jdField_a_of_type_Axzw.a(axzd.a.e);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QIMCameraLifeCycleBaseUnit", 1, "mLifecycleRegistry 初始化失败");
    }
  }
  
  public boolean onBackPressed()
  {
    return false;
  }
  
  @CallSuper
  public void onCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Axzw = new axzw(this);
    try
    {
      this.jdField_a_of_type_Axzw.a(axzd.a.a);
      return;
    }
    catch (Throwable paramBundle)
    {
      QLog.e("QIMCameraLifeCycleBaseUnit", 1, "mLifecycleRegistry 初始化失败");
    }
  }
  
  public View onCreateView()
  {
    return null;
  }
  
  @CallSuper
  public void onDestroy()
  {
    try
    {
      this.jdField_a_of_type_Axzw.a(axzd.a.f);
      if (this.jdField_a_of_type_Ayaa != null) {
        this.jdField_a_of_type_Ayaa.clear();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("QIMCameraLifeCycleBaseUnit", 1, "mLifecycleRegistry 初始化失败");
      }
    }
  }
  
  public void onNewIntent(Intent paramIntent) {}
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awrx
 * JD-Core Version:    0.7.0.1
 */