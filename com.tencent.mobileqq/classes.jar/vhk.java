import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import com.tribe.async.dispatch.IEventReceiver;

public abstract class vhk
  implements IEventReceiver
{
  @NonNull
  public final vhm a;
  public vix a;
  protected long c;
  
  public vhk(@NonNull vhm paramvhm)
  {
    this.jdField_a_of_type_Vhm = paramvhm;
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Vix == null) {
      throw new IllegalStateException("have not attached ui");
    }
  }
  
  public void V_()
  {
    f();
  }
  
  public void X_()
  {
    f();
  }
  
  @NonNull
  public Context a()
  {
    f();
    return this.jdField_a_of_type_Vix.a();
  }
  
  @NonNull
  public Resources a()
  {
    f();
    return this.jdField_a_of_type_Vix.a().getResources();
  }
  
  @NonNull
  protected View a(int paramInt)
  {
    f();
    View localView = this.jdField_a_of_type_Vix.a().findViewById(paramInt);
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
  
  public vhl a(Class<? extends vhl> paramClass)
  {
    f();
    return this.jdField_a_of_type_Vhm.a(paramClass);
  }
  
  @NonNull
  public vix a()
  {
    f();
    return this.jdField_a_of_type_Vix;
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
  
  public void a(int paramInt, @NonNull vsa paramvsa)
  {
    a(paramvsa);
  }
  
  public void a(Bundle paramBundle)
  {
    f();
  }
  
  public void a(Class<? extends vhl> paramClass, vhl paramvhl)
  {
    f();
    this.jdField_a_of_type_Vhm.a(paramClass, paramvhl);
  }
  
  public void a(@NonNull Error paramError) {}
  
  public void a(vix paramvix)
  {
    if (this.jdField_a_of_type_Vix != null) {
      throw new IllegalStateException("attach context duplicate");
    }
    if (paramvix == null) {
      throw new IllegalArgumentException("ui should not be null");
    }
    this.jdField_a_of_type_Vix = paramvix;
  }
  
  @Deprecated
  public void a(@NonNull vsa paramvsa) {}
  
  public boolean a()
  {
    f();
    return false;
  }
  
  protected boolean a(Message paramMessage)
  {
    return false;
  }
  
  public void b(Bundle paramBundle)
  {
    f();
  }
  
  public void b(@NonNull vsa paramvsa) {}
  
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
    return this.jdField_a_of_type_Vhm.isValidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vhk
 * JD-Core Version:    0.7.0.1
 */