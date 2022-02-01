import UserGrowth.stNewIconStyle;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.view.ViewStub;

public class utr
  extends ueh<uru>
{
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private uts jdField_a_of_type_Uts;
  private utw jdField_a_of_type_Utw;
  
  public utr(Context paramContext, utw paramutw)
  {
    super(paramContext);
    this.jdField_a_of_type_Utw = paramutw;
  }
  
  private stSimpleMetaFeed a()
  {
    uru localuru = (uru)a();
    if ((localuru != null) && ((localuru.a() instanceof stSimpleMetaFeed))) {
      return (stSimpleMetaFeed)localuru.a();
    }
    return null;
  }
  
  private void b(uru paramuru)
  {
    if ((a() != null) && (a().new_icon != null) && (a().new_icon.tag_type == 0))
    {
      if (this.jdField_a_of_type_Uts == null)
      {
        this.jdField_a_of_type_Uts = new uts(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Utw);
        this.jdField_a_of_type_Uts.a(this.jdField_a_of_type_AndroidViewViewStub);
      }
      this.jdField_a_of_type_Uts.a(paramuru);
    }
  }
  
  protected void a() {}
  
  public void a(uru paramuru)
  {
    super.a(paramuru);
    b(paramuru);
  }
  
  protected int b()
  {
    return 2131560026;
  }
  
  protected void b() {}
  
  protected void c()
  {
    if (this.jdField_a_of_type_Uts != null) {
      this.jdField_a_of_type_Uts.c();
    }
  }
  
  protected void e()
  {
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131380518));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     utr
 * JD-Core Version:    0.7.0.1
 */