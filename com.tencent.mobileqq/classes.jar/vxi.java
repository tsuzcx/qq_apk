import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;

public abstract class vxi<T>
  implements Handler.Callback
{
  protected int a;
  protected Context a;
  protected Handler a;
  protected View a;
  protected int b = -1;
  
  public vxi(Context paramContext, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (paramBoolean) {
      a();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected Context a()
  {
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  protected abstract void a();
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected final void a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
  }
  
  public abstract void b();
  
  public final void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  protected abstract void d();
  
  protected abstract void e();
  
  public void f()
  {
    e();
    a(-1);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    d();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     vxi
 * JD-Core Version:    0.7.0.1
 */