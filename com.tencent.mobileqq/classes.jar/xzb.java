import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import com.tribe.async.dispatch.IEventReceiver;

public abstract class xzb
  implements IEventReceiver
{
  @NonNull
  public final xzd a;
  public yan a;
  protected long c;
  
  public xzb(@NonNull xzd paramxzd)
  {
    this.jdField_a_of_type_Xzd = paramxzd;
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Yan == null) {
      throw new IllegalStateException("have not attached ui");
    }
  }
  
  public void Q_()
  {
    g();
  }
  
  public void R_()
  {
    g();
  }
  
  @NonNull
  public Context a()
  {
    g();
    return this.jdField_a_of_type_Yan.a();
  }
  
  @NonNull
  public Resources a()
  {
    g();
    return this.jdField_a_of_type_Yan.a().getResources();
  }
  
  @NonNull
  protected View a(int paramInt)
  {
    g();
    View localView = this.jdField_a_of_type_Yan.a().findViewById(paramInt);
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
  
  public xzc a(Class<? extends xzc> paramClass)
  {
    g();
    return this.jdField_a_of_type_Xzd.a(paramClass);
  }
  
  @NonNull
  public yan a()
  {
    g();
    return this.jdField_a_of_type_Yan;
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
  
  public void a(int paramInt, @NonNull yjh paramyjh)
  {
    a(paramyjh);
  }
  
  public void a(Bundle paramBundle)
  {
    g();
  }
  
  public void a(Class<? extends xzc> paramClass, xzc paramxzc)
  {
    g();
    this.jdField_a_of_type_Xzd.a(paramClass, paramxzc);
  }
  
  public void a(@NonNull Error paramError) {}
  
  public void a(yan paramyan)
  {
    if (this.jdField_a_of_type_Yan != null) {
      throw new IllegalStateException("attach context duplicate");
    }
    if (paramyan == null) {
      throw new IllegalArgumentException("ui should not be null");
    }
    this.jdField_a_of_type_Yan = paramyan;
  }
  
  @Deprecated
  public void a(@NonNull yjh paramyjh) {}
  
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
  
  public void b(@NonNull yjh paramyjh) {}
  
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
    return this.jdField_a_of_type_Xzd.isValidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xzb
 * JD-Core Version:    0.7.0.1
 */