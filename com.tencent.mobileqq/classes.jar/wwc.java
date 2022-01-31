import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import com.tribe.async.dispatch.IEventReceiver;

public abstract class wwc
  implements IEventReceiver
{
  @NonNull
  public final wwe a;
  public wxp a;
  protected long c;
  
  public wwc(@NonNull wwe paramwwe)
  {
    this.jdField_a_of_type_Wwe = paramwwe;
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Wxp == null) {
      throw new IllegalStateException("have not attached ui");
    }
  }
  
  @NonNull
  public Context a()
  {
    f();
    return this.jdField_a_of_type_Wxp.a();
  }
  
  @NonNull
  public Resources a()
  {
    f();
    return this.jdField_a_of_type_Wxp.a().getResources();
  }
  
  @NonNull
  protected View a(int paramInt)
  {
    f();
    View localView = this.jdField_a_of_type_Wxp.a().findViewById(paramInt);
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
  
  public wwd a(Class<? extends wwd> paramClass)
  {
    f();
    return this.jdField_a_of_type_Wwe.a(paramClass);
  }
  
  @NonNull
  public wxp a()
  {
    f();
    return this.jdField_a_of_type_Wxp;
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
  
  public void a(int paramInt, @NonNull xgs paramxgs)
  {
    a(paramxgs);
  }
  
  public void a(Bundle paramBundle)
  {
    f();
  }
  
  public void a(Class<? extends wwd> paramClass, wwd paramwwd)
  {
    f();
    this.jdField_a_of_type_Wwe.a(paramClass, paramwwd);
  }
  
  public void a(@NonNull Error paramError) {}
  
  public void a(wxp paramwxp)
  {
    if (this.jdField_a_of_type_Wxp != null) {
      throw new IllegalStateException("attach context duplicate");
    }
    if (paramwxp == null) {
      throw new IllegalArgumentException("ui should not be null");
    }
    this.jdField_a_of_type_Wxp = paramwxp;
  }
  
  @Deprecated
  public void a(@NonNull xgs paramxgs) {}
  
  public boolean a()
  {
    f();
    return false;
  }
  
  protected boolean a(Message paramMessage)
  {
    return false;
  }
  
  public void ad_()
  {
    f();
  }
  
  public void af_()
  {
    f();
  }
  
  public void b(Bundle paramBundle)
  {
    f();
  }
  
  public void b(@NonNull xgs paramxgs) {}
  
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
    return this.jdField_a_of_type_Wwe.isValidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wwc
 * JD-Core Version:    0.7.0.1
 */