import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.view.View;
import android.view.ViewStub;

public class uux
  extends uve
{
  private uej<usv> a;
  
  public uux(Context paramContext, uuy paramuuy)
  {
    super(paramContext, paramuuy);
  }
  
  private void f()
  {
    if ((a() != null) && (a().poster != null) && (!upw.a(a().poster.followStatus))) {
      ((utx)this.jdField_a_of_type_Uej).a(a().poster);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void c(int paramInt)
  {
    if ((paramInt == 1) && ((this.jdField_a_of_type_Uej instanceof utx)))
    {
      f();
      return;
    }
    super.c(paramInt);
  }
  
  public void e()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380996);
    this.jdField_a_of_type_Uej = new utx(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Uuy);
    this.jdField_a_of_type_Uej.a(localViewStub);
    a(this.jdField_a_of_type_Uej);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uux
 * JD-Core Version:    0.7.0.1
 */