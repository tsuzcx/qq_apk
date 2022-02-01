import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import com.tribe.async.dispatch.IEventReceiver;

public abstract class yxr
  implements IEventReceiver
{
  @NonNull
  public final yxt a;
  public yze a;
  protected long c;
  
  public yxr(@NonNull yxt paramyxt)
  {
    this.jdField_a_of_type_Yxt = paramyxt;
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Yze == null) {
      throw new IllegalStateException("have not attached ui");
    }
  }
  
  public void W_()
  {
    f();
  }
  
  public void Y_()
  {
    f();
  }
  
  @NonNull
  public Context a()
  {
    f();
    return this.jdField_a_of_type_Yze.a();
  }
  
  @NonNull
  public Resources a()
  {
    f();
    return this.jdField_a_of_type_Yze.a().getResources();
  }
  
  @NonNull
  protected View a(int paramInt)
  {
    f();
    View localView = this.jdField_a_of_type_Yze.a().findViewById(paramInt);
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
  
  public yxs a(Class<? extends yxs> paramClass)
  {
    f();
    return this.jdField_a_of_type_Yxt.a(paramClass);
  }
  
  @NonNull
  public yze a()
  {
    f();
    return this.jdField_a_of_type_Yze;
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
  
  public void a(int paramInt, @NonNull zih paramzih)
  {
    a(paramzih);
  }
  
  public void a(Bundle paramBundle)
  {
    f();
  }
  
  public void a(Class<? extends yxs> paramClass, yxs paramyxs)
  {
    f();
    this.jdField_a_of_type_Yxt.a(paramClass, paramyxs);
  }
  
  public void a(@NonNull Error paramError) {}
  
  public void a(yze paramyze)
  {
    if (this.jdField_a_of_type_Yze != null) {
      throw new IllegalStateException("attach context duplicate");
    }
    if (paramyze == null) {
      throw new IllegalArgumentException("ui should not be null");
    }
    this.jdField_a_of_type_Yze = paramyze;
  }
  
  @Deprecated
  public void a(@NonNull zih paramzih) {}
  
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
  
  public void b(@NonNull zih paramzih) {}
  
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
    return this.jdField_a_of_type_Yxt.isValidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yxr
 * JD-Core Version:    0.7.0.1
 */