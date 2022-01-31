import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import com.tribe.async.dispatch.IEventReceiver;

public abstract class xal
  implements IEventReceiver
{
  @NonNull
  public final xan a;
  public xby a;
  protected long c;
  
  public xal(@NonNull xan paramxan)
  {
    this.jdField_a_of_type_Xan = paramxan;
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Xby == null) {
      throw new IllegalStateException("have not attached ui");
    }
  }
  
  @NonNull
  public Context a()
  {
    f();
    return this.jdField_a_of_type_Xby.a();
  }
  
  @NonNull
  public Resources a()
  {
    f();
    return this.jdField_a_of_type_Xby.a().getResources();
  }
  
  @NonNull
  protected View a(int paramInt)
  {
    f();
    View localView = this.jdField_a_of_type_Xby.a().findViewById(paramInt);
    if (localView == null) {
      throw new IllegalArgumentException("can not find view by id " + paramInt);
    }
    return localView;
  }
  
  protected String a(int paramInt)
  {
    f();
    return a().getString(paramInt);
  }
  
  public xam a(Class<? extends xam> paramClass)
  {
    f();
    return this.jdField_a_of_type_Xan.a(paramClass);
  }
  
  @NonNull
  public xby a()
  {
    f();
    return this.jdField_a_of_type_Xby;
  }
  
  public void a()
  {
    f();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    f();
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    a(paramInt2, paramObject);
  }
  
  public void a(int paramInt, Object paramObject) {}
  
  public void a(int paramInt, @NonNull xlb paramxlb)
  {
    a(paramxlb);
  }
  
  public void a(Bundle paramBundle)
  {
    f();
  }
  
  public void a(Class<? extends xam> paramClass, xam paramxam)
  {
    f();
    this.jdField_a_of_type_Xan.a(paramClass, paramxam);
  }
  
  public void a(@NonNull Error paramError) {}
  
  public void a(xby paramxby)
  {
    if (this.jdField_a_of_type_Xby != null) {
      throw new IllegalStateException("attach context duplicate");
    }
    if (paramxby == null) {
      throw new IllegalArgumentException("ui should not be null");
    }
    this.jdField_a_of_type_Xby = paramxby;
  }
  
  @Deprecated
  public void a(@NonNull xlb paramxlb) {}
  
  public boolean a()
  {
    f();
    return false;
  }
  
  protected boolean a(Message paramMessage)
  {
    return false;
  }
  
  public void aa_()
  {
    f();
  }
  
  public void ac_()
  {
    f();
  }
  
  public void b(Bundle paramBundle)
  {
    f();
  }
  
  public void b(@NonNull xlb paramxlb) {}
  
  public final boolean b(@NonNull Message paramMessage)
  {
    boolean bool = a(paramMessage);
    paramMessage.recycle();
    return bool;
  }
  
  public void c()
  {
    f();
  }
  
  public void d()
  {
    f();
  }
  
  public void h()
  {
    f();
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_Xan.isValidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xal
 * JD-Core Version:    0.7.0.1
 */