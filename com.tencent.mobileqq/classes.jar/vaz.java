import UserGrowth.stNewIconStyle;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.view.ViewStub;

public class vaz
  extends ukz<vaq>
{
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private vba jdField_a_of_type_Vba;
  private vct jdField_a_of_type_Vct;
  
  public vaz(Context paramContext, vct paramvct)
  {
    super(paramContext);
    this.jdField_a_of_type_Vct = paramvct;
  }
  
  private stSimpleMetaFeed a()
  {
    vaq localvaq = (vaq)a();
    if ((localvaq != null) && ((localvaq.a() instanceof stSimpleMetaFeed))) {
      return (stSimpleMetaFeed)localvaq.a();
    }
    return null;
  }
  
  private void b(vaq paramvaq)
  {
    if ((a() != null) && (a().new_icon != null) && (a().new_icon.tag_type == 0))
    {
      if (this.jdField_a_of_type_Vba == null)
      {
        this.jdField_a_of_type_Vba = new vba(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Vct);
        this.jdField_a_of_type_Vba.a(this.jdField_a_of_type_AndroidViewViewStub);
      }
      this.jdField_a_of_type_Vba.a(paramvaq);
    }
  }
  
  protected void a() {}
  
  public void a(vaq paramvaq)
  {
    super.a(paramvaq);
    b(paramvaq);
  }
  
  protected int b()
  {
    return 2131560041;
  }
  
  protected void b() {}
  
  protected void c()
  {
    if (this.jdField_a_of_type_Vba != null) {
      this.jdField_a_of_type_Vba.c();
    }
  }
  
  protected void e()
  {
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131380430));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vaz
 * JD-Core Version:    0.7.0.1
 */