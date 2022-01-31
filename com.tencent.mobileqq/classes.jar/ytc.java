import android.content.Context;
import com.tencent.gdtad.api.adbox.GdtAdBoxData;

public class ytc
{
  private Context jdField_a_of_type_AndroidContentContext;
  private GdtAdBoxData jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData;
  private ytk jdField_a_of_type_Ytk;
  
  ytc(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public ytb a()
  {
    ytb localytb = new ytb();
    localytb.a(this.jdField_a_of_type_AndroidContentContext);
    localytb.a(this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData);
    localytb.a(this.jdField_a_of_type_Ytk);
    return localytb;
  }
  
  public ytc a(GdtAdBoxData paramGdtAdBoxData)
  {
    this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxData = paramGdtAdBoxData;
    return this;
  }
  
  public ytc a(ytk paramytk)
  {
    this.jdField_a_of_type_Ytk = paramytk;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ytc
 * JD-Core Version:    0.7.0.1
 */