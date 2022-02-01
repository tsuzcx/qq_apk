import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.UiThread;
import android.view.View;

public abstract class uyv<T>
  implements Handler.Callback
{
  protected int a;
  protected Context a;
  protected Handler a;
  protected View a;
  protected T a;
  protected int b = -1;
  
  public uyv(Context paramContext)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected Context a()
  {
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  protected Resources a()
  {
    if (this.jdField_a_of_type_AndroidContentContext != null) {
      return this.jdField_a_of_type_AndroidContentContext.getResources();
    }
    return null;
  }
  
  public T a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  protected abstract void a();
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(paramInt);
    }
  }
  
  public void a(T paramT)
  {
    this.jdField_a_of_type_JavaLangObject = paramT;
    a();
    e();
  }
  
  @UiThread
  protected abstract void b();
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected abstract void c();
  
  public void d()
  {
    c();
    b(-1);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      b();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uyv
 * JD-Core Version:    0.7.0.1
 */