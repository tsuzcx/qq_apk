import UserGrowth.stNewIconStyle;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.view.ViewStub;

public class vps
  extends uyw<vpj>
{
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private vpt jdField_a_of_type_Vpt;
  private vrn jdField_a_of_type_Vrn;
  
  public vps(Context paramContext, vrn paramvrn)
  {
    super(paramContext);
    this.jdField_a_of_type_Vrn = paramvrn;
  }
  
  private stSimpleMetaFeed a()
  {
    vpj localvpj = (vpj)a();
    if ((localvpj != null) && ((localvpj.a() instanceof stSimpleMetaFeed))) {
      return (stSimpleMetaFeed)localvpj.a();
    }
    return null;
  }
  
  private void b(vpj paramvpj)
  {
    if ((a() != null) && (a().new_icon != null) && (a().new_icon.tag_type == 0))
    {
      if (this.jdField_a_of_type_Vpt == null)
      {
        this.jdField_a_of_type_Vpt = new vpt(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Vrn);
        this.jdField_a_of_type_Vpt.a(this.jdField_a_of_type_AndroidViewViewStub);
      }
      this.jdField_a_of_type_Vpt.a(paramvpj);
    }
  }
  
  protected void a() {}
  
  public void a(vpj paramvpj)
  {
    super.a(paramvpj);
    b(paramvpj);
  }
  
  protected int b()
  {
    return 2131560085;
  }
  
  protected void b() {}
  
  protected void c()
  {
    if (this.jdField_a_of_type_Vpt != null) {
      this.jdField_a_of_type_Vpt.c();
    }
  }
  
  protected void e()
  {
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131380769));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vps
 * JD-Core Version:    0.7.0.1
 */