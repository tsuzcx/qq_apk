import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.view.View;
import android.view.ViewStub;

public class utv
  extends uuc
{
  private ueh<uru> a;
  
  public utv(Context paramContext, utw paramutw)
  {
    super(paramContext, paramutw);
  }
  
  private void f()
  {
    if ((a() != null) && (a().poster != null) && (!uov.a(a().poster.followStatus))) {
      ((usw)this.jdField_a_of_type_Ueh).a(a().poster);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void c(int paramInt)
  {
    if ((paramInt == 1) && ((this.jdField_a_of_type_Ueh instanceof usw)))
    {
      f();
      return;
    }
    super.c(paramInt);
  }
  
  public void e()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380819);
    this.jdField_a_of_type_Ueh = new usw(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Utw);
    this.jdField_a_of_type_Ueh.a(localViewStub);
    a(this.jdField_a_of_type_Ueh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     utv
 * JD-Core Version:    0.7.0.1
 */