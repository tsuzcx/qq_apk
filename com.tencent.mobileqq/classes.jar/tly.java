import android.os.Bundle;
import com.tencent.mobileqq.pb.MessageMicro;

public class tly<REQ extends MessageMicro>
  extends sys<tnw>
{
  public final Bundle a;
  public final REQ a;
  public final String a;
  
  public tly(String paramString, REQ paramREQ, Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqPbMessageMicro = paramREQ;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public syn a(byte[] paramArrayOfByte)
  {
    return new tnw(paramArrayOfByte);
  }
  
  protected byte[] a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqPbMessageMicro.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tly
 * JD-Core Version:    0.7.0.1
 */