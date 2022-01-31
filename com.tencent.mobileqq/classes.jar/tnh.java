import UserGrowth.stNewIconStyle;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.view.ViewStub;

public class tnh
  extends tck<tmv>
{
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private tni jdField_a_of_type_Tni;
  private tnj jdField_a_of_type_Tnj;
  
  public tnh(Context paramContext, tnj paramtnj)
  {
    super(paramContext);
    this.jdField_a_of_type_Tnj = paramtnj;
  }
  
  private stSimpleMetaFeed a()
  {
    tmv localtmv = (tmv)a();
    if ((localtmv != null) && ((localtmv.a() instanceof stSimpleMetaFeed))) {
      return (stSimpleMetaFeed)localtmv.a();
    }
    return null;
  }
  
  private void b(tmv paramtmv)
  {
    if ((a() != null) && (a().new_icon != null) && (a().new_icon.tag_type == 0))
    {
      if (this.jdField_a_of_type_Tni == null)
      {
        this.jdField_a_of_type_Tni = new tni(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Tnj);
        this.jdField_a_of_type_Tni.a(this.jdField_a_of_type_AndroidViewViewStub);
      }
      this.jdField_a_of_type_Tni.a(paramtmv);
    }
  }
  
  protected void a() {}
  
  public void a(tmv paramtmv)
  {
    super.a(paramtmv);
    b(paramtmv);
  }
  
  protected int b()
  {
    return 2131559876;
  }
  
  protected void b() {}
  
  protected void c()
  {
    if (this.jdField_a_of_type_Tni != null) {
      this.jdField_a_of_type_Tni.c();
    }
  }
  
  protected void e()
  {
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131379575));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tnh
 * JD-Core Version:    0.7.0.1
 */