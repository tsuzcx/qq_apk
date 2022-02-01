import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.view.View;
import android.view.ViewStub;

public class vcs
  extends vcz
{
  private ukz<vaq> a;
  
  public vcs(Context paramContext, vct paramvct)
  {
    super(paramContext, paramvct);
  }
  
  private void f()
  {
    if ((a() != null) && (a().poster != null) && (!uxr.a(a().poster.followStatus))) {
      ((vbs)this.jdField_a_of_type_Ukz).a(a().poster);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void c(int paramInt)
  {
    if ((paramInt == 1) && ((this.jdField_a_of_type_Ukz instanceof vbs)))
    {
      f();
      return;
    }
    super.c(paramInt);
  }
  
  public void e()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131380722);
    this.jdField_a_of_type_Ukz = new vbs(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Vct);
    this.jdField_a_of_type_Ukz.a(localViewStub);
    a(this.jdField_a_of_type_Ukz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vcs
 * JD-Core Version:    0.7.0.1
 */