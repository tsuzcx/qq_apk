import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.view.View;
import android.view.ViewStub;

public class vrm
  extends vru
{
  private uyw<vpj> a;
  
  public vrm(Context paramContext, vrn paramvrn)
  {
    super(paramContext, paramvrn);
  }
  
  private void f()
  {
    if ((a() != null) && (a().poster != null) && (!vmg.a(a().poster.followStatus))) {
      ((vql)this.jdField_a_of_type_Uyw).a(a().poster);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((stSimpleMetaFeed)localObject).poster;
      if (localObject != null) {}
    }
    else
    {
      return;
    }
    ((vql)this.jdField_a_of_type_Uyw).b((stSimpleMetaPerson)localObject);
  }
  
  public void c(int paramInt)
  {
    if ((paramInt == 1) && ((this.jdField_a_of_type_Uyw instanceof vql)))
    {
      f();
      return;
    }
    super.c(paramInt);
  }
  
  public void e()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131381074);
    this.jdField_a_of_type_Uyw = new vql(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Vrn);
    this.jdField_a_of_type_Uyw.a(localViewStub);
    a(this.jdField_a_of_type_Uyw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vrm
 * JD-Core Version:    0.7.0.1
 */