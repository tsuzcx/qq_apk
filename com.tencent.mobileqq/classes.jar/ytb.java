import android.content.Context;
import com.tencent.gdtad.api.adbox.GdtAdBoxData;

public class ytb
{
  private Context jdField_a_of_type_AndroidContentContext;
  private GdtAdBoxData jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData;
  private ytd jdField_a_of_type_Ytd;
  private ytk jdField_a_of_type_Ytk;
  
  public static ytc a(Context paramContext)
  {
    return new ytc(paramContext);
  }
  
  public GdtAdBoxData a()
  {
    return this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ytd = new ytj(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Ytd.a(this);
    this.jdField_a_of_type_Ytd.show();
  }
  
  void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  void a(GdtAdBoxData paramGdtAdBoxData)
  {
    this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData = paramGdtAdBoxData;
  }
  
  void a(ytk paramytk)
  {
    this.jdField_a_of_type_Ytk = paramytk;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Ytd != null) && (this.jdField_a_of_type_Ytd.isShowing()))
    {
      this.jdField_a_of_type_Ytd.dismiss();
      this.jdField_a_of_type_Ytd = null;
    }
    this.jdField_a_of_type_Ytk = null;
    this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData = null;
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Ytk != null) {
      this.jdField_a_of_type_Ytk.onDismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ytb
 * JD-Core Version:    0.7.0.1
 */