import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class viq
  extends vkh
{
  private String a;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  
  public viq(String paramString1, String paramString2, boolean paramBoolean)
  {
    a(false, true);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EncryptUrlJob", 2, new Object[] { "encrypt url:", this.jdField_a_of_type_JavaLangString });
    }
    vgo localvgo = new vgo();
    localvgo.jdField_c_of_type_Int = 1;
    String[] arrayOfString = this.jdField_a_of_type_JavaLangString.split("\\?");
    if (arrayOfString.length != 2)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EncryptUrlJob", 2, new Object[] { "Illegal url:", this.jdField_a_of_type_JavaLangString });
      }
      a("EncryptUrlJob_encryptedUrl", this.jdField_a_of_type_JavaLangString);
      b(true);
      return;
    }
    localvgo.b = arrayOfString[1];
    localvgo.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    urp.a().a(localvgo, new vir(this, arrayOfString));
  }
  
  protected void a(Map<String, Object> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) && (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()))
    {
      if (paramMap.containsKey("EncryptUrlJob_shareUrl")) {
        this.jdField_a_of_type_JavaLangString = ((String)a("EncryptUrlJob_shareUrl"));
      }
      if (paramMap.containsKey("EncryptUrlJob_feedId")) {
        this.jdField_c_of_type_JavaLangString = ((String)a("EncryptUrlJob_feedId"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     viq
 * JD-Core Version:    0.7.0.1
 */