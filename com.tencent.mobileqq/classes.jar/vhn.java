import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import com.tribe.async.dispatch.IEventReceiver;

public abstract class vhn
  implements IEventReceiver
{
  @NonNull
  public final vhp a;
  public vja a;
  protected long c;
  
  public vhn(@NonNull vhp paramvhp)
  {
    this.jdField_a_of_type_Vhp = paramvhp;
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Vja == null) {
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
    return this.jdField_a_of_type_Vja.a();
  }
  
  @NonNull
  public Resources a()
  {
    f();
    return this.jdField_a_of_type_Vja.a().getResources();
  }
  
  @NonNull
  protected View a(int paramInt)
  {
    f();
    View localView = this.jdField_a_of_type_Vja.a().findViewById(paramInt);
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
  
  public vho a(Class<? extends vho> paramClass)
  {
    f();
    return this.jdField_a_of_type_Vhp.a(paramClass);
  }
  
  @NonNull
  public vja a()
  {
    f();
    return this.jdField_a_of_type_Vja;
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
  
  public void a(int paramInt, @NonNull vsd paramvsd)
  {
    a(paramvsd);
  }
  
  public void a(Bundle paramBundle)
  {
    f();
  }
  
  public void a(Class<? extends vho> paramClass, vho paramvho)
  {
    f();
    this.jdField_a_of_type_Vhp.a(paramClass, paramvho);
  }
  
  public void a(@NonNull Error paramError) {}
  
  public void a(vja paramvja)
  {
    if (this.jdField_a_of_type_Vja != null) {
      throw new IllegalStateException("attach context duplicate");
    }
    if (paramvja == null) {
      throw new IllegalArgumentException("ui should not be null");
    }
    this.jdField_a_of_type_Vja = paramvja;
  }
  
  @Deprecated
  public void a(@NonNull vsd paramvsd) {}
  
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
  
  public void b(@NonNull vsd paramvsd) {}
  
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
    return this.jdField_a_of_type_Vhp.isValidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vhn
 * JD-Core Version:    0.7.0.1
 */