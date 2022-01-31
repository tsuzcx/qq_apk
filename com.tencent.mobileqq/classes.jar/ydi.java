import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;

public abstract class ydi<T>
  implements Handler.Callback
{
  protected int a;
  protected Context a;
  protected Handler a;
  protected int b = -1;
  protected View b;
  
  public ydi(Context paramContext, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (paramBoolean) {
      j();
    }
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
  
  protected final void a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public abstract void c();
  
  protected abstract void d();
  
  public void e()
  {
    f();
    b(-1);
  }
  
  protected abstract void f();
  
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
  
  protected abstract void j();
  
  public final void k()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ydi
 * JD-Core Version:    0.7.0.1
 */