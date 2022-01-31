import android.content.Context;
import com.tencent.gdtad.api.adbox.GdtAdBoxData;

public class ykd
{
  private Context jdField_a_of_type_AndroidContentContext;
  private GdtAdBoxData jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData;
  private ykf jdField_a_of_type_Ykf;
  private ykm jdField_a_of_type_Ykm;
  
  public static yke a(Context paramContext)
  {
    return new yke(paramContext);
  }
  
  public GdtAdBoxData a()
  {
    return this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ykf = new ykl(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Ykf.a(this);
    this.jdField_a_of_type_Ykf.show();
  }
  
  void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  void a(GdtAdBoxData paramGdtAdBoxData)
  {
    this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData = paramGdtAdBoxData;
  }
  
  void a(ykm paramykm)
  {
    this.jdField_a_of_type_Ykm = paramykm;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Ykf != null) && (this.jdField_a_of_type_Ykf.isShowing()))
    {
      this.jdField_a_of_type_Ykf.dismiss();
      this.jdField_a_of_type_Ykf = null;
    }
    this.jdField_a_of_type_Ykm = null;
    this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData = null;
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Ykm != null) {
      this.jdField_a_of_type_Ykm.onDismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ykd
 * JD-Core Version:    0.7.0.1
 */