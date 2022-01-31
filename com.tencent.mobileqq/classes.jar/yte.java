import android.content.Context;
import com.tencent.gdtad.api.adbox.GdtAdBoxData;

public class yte
{
  private Context jdField_a_of_type_AndroidContentContext;
  private GdtAdBoxData jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData;
  private ytg jdField_a_of_type_Ytg;
  private ytn jdField_a_of_type_Ytn;
  
  public static ytf a(Context paramContext)
  {
    return new ytf(paramContext);
  }
  
  public GdtAdBoxData a()
  {
    return this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ytg = new ytm(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Ytg.a(this);
    this.jdField_a_of_type_Ytg.show();
  }
  
  void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  void a(GdtAdBoxData paramGdtAdBoxData)
  {
    this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData = paramGdtAdBoxData;
  }
  
  void a(ytn paramytn)
  {
    this.jdField_a_of_type_Ytn = paramytn;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Ytg != null) && (this.jdField_a_of_type_Ytg.isShowing()))
    {
      this.jdField_a_of_type_Ytg.dismiss();
      this.jdField_a_of_type_Ytg = null;
    }
    this.jdField_a_of_type_Ytn = null;
    this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData = null;
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Ytn != null) {
      this.jdField_a_of_type_Ytn.onDismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yte
 * JD-Core Version:    0.7.0.1
 */