import android.os.Bundle;
import com.tencent.mobileqq.pb.MessageMicro;

public class xcg<REQ extends MessageMicro>
  extends wpa<xee>
{
  public final Bundle a;
  public final REQ a;
  public final String a;
  
  public xcg(String paramString, REQ paramREQ, Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqPbMessageMicro = paramREQ;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public wov a(byte[] paramArrayOfByte)
  {
    return new xee(paramArrayOfByte);
  }
  
  protected byte[] a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqPbMessageMicro.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xcg
 * JD-Core Version:    0.7.0.1
 */