import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QzoneExternalRequest;

public class yot
  extends QzoneExternalRequest
{
  private JceStruct jdField_a_of_type_ComQqTafJceJceStruct;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public yot(String paramString1, JceStruct paramJceStruct, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.b = paramString3;
    long l = Long.parseLong(paramString1);
    super.setHostUin(l);
    super.setLoginUserId(l);
    this.needCompress = false;
    this.jdField_a_of_type_ComQqTafJceJceStruct = paramJceStruct;
  }
  
  public static JceStruct a(byte[] paramArrayOfByte, String paramString)
  {
    JceStruct localJceStruct = null;
    if (paramArrayOfByte != null) {
      localJceStruct = decode(paramArrayOfByte, paramString);
    }
    return localJceStruct;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService." + this.jdField_a_of_type_JavaLangString;
  }
  
  public JceStruct getReq()
  {
    return this.jdField_a_of_type_ComQqTafJceJceStruct;
  }
  
  public String uniKey()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yot
 * JD-Core Version:    0.7.0.1
 */