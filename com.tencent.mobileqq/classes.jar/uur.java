import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import com.tribe.async.dispatch.IEventReceiver;

public abstract class uur
  implements IEventReceiver
{
  @NonNull
  public final uut a;
  public uwe a;
  protected long c;
  
  public uur(@NonNull uut paramuut)
  {
    this.jdField_a_of_type_Uut = paramuut;
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Uwe == null) {
      throw new IllegalStateException("have not attached ui");
    }
  }
  
  public void X_()
  {
    f();
  }
  
  public void Z_()
  {
    f();
  }
  
  @NonNull
  public Context a()
  {
    f();
    return this.jdField_a_of_type_Uwe.a();
  }
  
  @NonNull
  public Resources a()
  {
    f();
    return this.jdField_a_of_type_Uwe.a().getResources();
  }
  
  @NonNull
  protected View a(int paramInt)
  {
    f();
    View localView = this.jdField_a_of_type_Uwe.a().findViewById(paramInt);
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
  
  public uus a(Class<? extends uus> paramClass)
  {
    f();
    return this.jdField_a_of_type_Uut.a(paramClass);
  }
  
  @NonNull
  public uwe a()
  {
    f();
    return this.jdField_a_of_type_Uwe;
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
  
  public void a(int paramInt, @NonNull vfh paramvfh)
  {
    a(paramvfh);
  }
  
  public void a(Bundle paramBundle)
  {
    f();
  }
  
  public void a(Class<? extends uus> paramClass, uus paramuus)
  {
    f();
    this.jdField_a_of_type_Uut.a(paramClass, paramuus);
  }
  
  public void a(@NonNull Error paramError) {}
  
  public void a(uwe paramuwe)
  {
    if (this.jdField_a_of_type_Uwe != null) {
      throw new IllegalStateException("attach context duplicate");
    }
    if (paramuwe == null) {
      throw new IllegalArgumentException("ui should not be null");
    }
    this.jdField_a_of_type_Uwe = paramuwe;
  }
  
  @Deprecated
  public void a(@NonNull vfh paramvfh) {}
  
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
  
  public void b(@NonNull vfh paramvfh) {}
  
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
    return this.jdField_a_of_type_Uut.isValidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uur
 * JD-Core Version:    0.7.0.1
 */