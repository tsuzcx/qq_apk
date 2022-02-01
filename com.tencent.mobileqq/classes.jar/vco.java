import UserGrowth.stNewIconStyle;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.view.ViewStub;

public class vco
  extends ukz<vaq>
{
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private vcp jdField_a_of_type_Vcp;
  private vct jdField_a_of_type_Vct;
  
  public vco(Context paramContext, vct paramvct)
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
      if (this.jdField_a_of_type_Vcp == null)
      {
        this.jdField_a_of_type_Vcp = new vcp(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Vct);
        this.jdField_a_of_type_Vcp.a(this.jdField_a_of_type_AndroidViewViewStub);
      }
      this.jdField_a_of_type_Vcp.a(paramvaq);
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
    if (this.jdField_a_of_type_Vcp != null) {
      this.jdField_a_of_type_Vcp.c();
    }
  }
  
  protected void e()
  {
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131380430));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vco
 * JD-Core Version:    0.7.0.1
 */