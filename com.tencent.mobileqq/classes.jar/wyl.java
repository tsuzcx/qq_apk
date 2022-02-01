import android.os.Bundle;
import com.tencent.mobileqq.pb.MessageMicro;

public class wyl<REQ extends MessageMicro>
  extends wlf<xaj>
{
  public final Bundle a;
  public final REQ a;
  public final String a;
  
  public wyl(String paramString, REQ paramREQ, Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqPbMessageMicro = paramREQ;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public wla a(byte[] paramArrayOfByte)
  {
    return new xaj(paramArrayOfByte);
  }
  
  protected byte[] a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqPbMessageMicro.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wyl
 * JD-Core Version:    0.7.0.1
 */