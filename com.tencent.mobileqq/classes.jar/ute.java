import UserGrowth.stNewIconStyle;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.view.ViewStub;

public class ute
  extends uej<usv>
{
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private utf jdField_a_of_type_Utf;
  private uuy jdField_a_of_type_Uuy;
  
  public ute(Context paramContext, uuy paramuuy)
  {
    super(paramContext);
    this.jdField_a_of_type_Uuy = paramuuy;
  }
  
  private stSimpleMetaFeed a()
  {
    usv localusv = (usv)a();
    if ((localusv != null) && ((localusv.a() instanceof stSimpleMetaFeed))) {
      return (stSimpleMetaFeed)localusv.a();
    }
    return null;
  }
  
  private void b(usv paramusv)
  {
    if ((a() != null) && (a().new_icon != null) && (a().new_icon.tag_type == 0))
    {
      if (this.jdField_a_of_type_Utf == null)
      {
        this.jdField_a_of_type_Utf = new utf(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Uuy);
        this.jdField_a_of_type_Utf.a(this.jdField_a_of_type_AndroidViewViewStub);
      }
      this.jdField_a_of_type_Utf.a(paramusv);
    }
  }
  
  protected void a() {}
  
  public void a(usv paramusv)
  {
    super.a(paramusv);
    b(paramusv);
  }
  
  protected int b()
  {
    return 2131560035;
  }
  
  protected void b() {}
  
  protected void c()
  {
    if (this.jdField_a_of_type_Utf != null) {
      this.jdField_a_of_type_Utf.c();
    }
  }
  
  protected void e()
  {
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131380704));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ute
 * JD-Core Version:    0.7.0.1
 */