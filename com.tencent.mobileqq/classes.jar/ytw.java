import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import com.tribe.async.dispatch.IEventReceiver;

public abstract class ytw
  implements IEventReceiver
{
  @NonNull
  public final yty a;
  public yvj a;
  protected long c;
  
  public ytw(@NonNull yty paramyty)
  {
    this.jdField_a_of_type_Yty = paramyty;
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Yvj == null) {
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
    return this.jdField_a_of_type_Yvj.a();
  }
  
  @NonNull
  public Resources a()
  {
    f();
    return this.jdField_a_of_type_Yvj.a().getResources();
  }
  
  @NonNull
  protected View a(int paramInt)
  {
    f();
    View localView = this.jdField_a_of_type_Yvj.a().findViewById(paramInt);
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
  
  public ytx a(Class<? extends ytx> paramClass)
  {
    f();
    return this.jdField_a_of_type_Yty.a(paramClass);
  }
  
  @NonNull
  public yvj a()
  {
    f();
    return this.jdField_a_of_type_Yvj;
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
  
  public void a(int paramInt, @NonNull zem paramzem)
  {
    a(paramzem);
  }
  
  public void a(Bundle paramBundle)
  {
    f();
  }
  
  public void a(Class<? extends ytx> paramClass, ytx paramytx)
  {
    f();
    this.jdField_a_of_type_Yty.a(paramClass, paramytx);
  }
  
  public void a(@NonNull Error paramError) {}
  
  public void a(yvj paramyvj)
  {
    if (this.jdField_a_of_type_Yvj != null) {
      throw new IllegalStateException("attach context duplicate");
    }
    if (paramyvj == null) {
      throw new IllegalArgumentException("ui should not be null");
    }
    this.jdField_a_of_type_Yvj = paramyvj;
  }
  
  @Deprecated
  public void a(@NonNull zem paramzem) {}
  
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
  
  public void b(@NonNull zem paramzem) {}
  
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
    return this.jdField_a_of_type_Yty.isValidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ytw
 * JD-Core Version:    0.7.0.1
 */