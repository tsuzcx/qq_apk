import UserGrowth.stNewIconStyle;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.view.ViewStub;

public class vri
  extends uyw<vpj>
{
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private vrj jdField_a_of_type_Vrj;
  private vrn jdField_a_of_type_Vrn;
  
  public vri(Context paramContext, vrn paramvrn)
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
      if (this.jdField_a_of_type_Vrj == null)
      {
        this.jdField_a_of_type_Vrj = new vrj(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Vrn);
        this.jdField_a_of_type_Vrj.a(this.jdField_a_of_type_AndroidViewViewStub);
      }
      this.jdField_a_of_type_Vrj.a(paramvpj);
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
    if (this.jdField_a_of_type_Vrj != null) {
      this.jdField_a_of_type_Vrj.c();
    }
  }
  
  protected void e()
  {
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131380769));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vri
 * JD-Core Version:    0.7.0.1
 */