import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import com.tribe.async.dispatch.IEventReceiver;

public abstract class ynu
  implements IEventReceiver
{
  @NonNull
  public final ynw a;
  public ypg a;
  protected long c;
  
  public ynu(@NonNull ynw paramynw)
  {
    this.jdField_a_of_type_Ynw = paramynw;
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Ypg == null) {
      throw new IllegalStateException("have not attached ui");
    }
  }
  
  public void S_()
  {
    g();
  }
  
  public void T_()
  {
    g();
  }
  
  @NonNull
  public Context a()
  {
    g();
    return this.jdField_a_of_type_Ypg.a();
  }
  
  @NonNull
  public Resources a()
  {
    g();
    return this.jdField_a_of_type_Ypg.a().getResources();
  }
  
  @NonNull
  protected View a(int paramInt)
  {
    g();
    View localView = this.jdField_a_of_type_Ypg.a().findViewById(paramInt);
    if (localView == null) {
      throw new IllegalArgumentException("can not find view by id " + paramInt);
    }
    return localView;
  }
  
  protected String a(int paramInt)
  {
    g();
    return a().getString(paramInt);
  }
  
  public ynv a(Class<? extends ynv> paramClass)
  {
    g();
    return this.jdField_a_of_type_Ynw.a(paramClass);
  }
  
  @NonNull
  public ypg a()
  {
    g();
    return this.jdField_a_of_type_Ypg;
  }
  
  public void a()
  {
    g();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    g();
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    a(paramInt2, paramObject);
  }
  
  public void a(int paramInt, Object paramObject) {}
  
  public void a(int paramInt, @NonNull yya paramyya)
  {
    a(paramyya);
  }
  
  public void a(Bundle paramBundle)
  {
    g();
  }
  
  public void a(Class<? extends ynv> paramClass, ynv paramynv)
  {
    g();
    this.jdField_a_of_type_Ynw.a(paramClass, paramynv);
  }
  
  public void a(@NonNull Error paramError) {}
  
  public void a(ypg paramypg)
  {
    if (this.jdField_a_of_type_Ypg != null) {
      throw new IllegalStateException("attach context duplicate");
    }
    if (paramypg == null) {
      throw new IllegalArgumentException("ui should not be null");
    }
    this.jdField_a_of_type_Ypg = paramypg;
  }
  
  @Deprecated
  public void a(@NonNull yya paramyya) {}
  
  public boolean a()
  {
    g();
    return false;
  }
  
  protected boolean a(Message paramMessage)
  {
    return false;
  }
  
  public void b(Bundle paramBundle)
  {
    g();
  }
  
  public void b(@NonNull yya paramyya) {}
  
  public final boolean b(@NonNull Message paramMessage)
  {
    boolean bool = a(paramMessage);
    paramMessage.recycle();
    return bool;
  }
  
  public void c()
  {
    g();
  }
  
  public void d()
  {
    g();
  }
  
  public void f()
  {
    g();
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_Ynw.isValidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ynu
 * JD-Core Version:    0.7.0.1
 */