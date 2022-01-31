import android.content.Context;
import com.tencent.gdtad.api.adbox.GdtAdBoxData;

public class yke
{
  private Context jdField_a_of_type_AndroidContentContext;
  private GdtAdBoxData jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData;
  private ykm jdField_a_of_type_Ykm;
  
  yke(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public ykd a()
  {
    ykd localykd = new ykd();
    localykd.a(this.jdField_a_of_type_AndroidContentContext);
    localykd.a(this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData);
    localykd.a(this.jdField_a_of_type_Ykm);
    return localykd;
  }
  
  public yke a(GdtAdBoxData paramGdtAdBoxData)
  {
    this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData = paramGdtAdBoxData;
    return this;
  }
  
  public yke a(ykm paramykm)
  {
    this.jdField_a_of_type_Ykm = paramykm;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yke
 * JD-Core Version:    0.7.0.1
 */