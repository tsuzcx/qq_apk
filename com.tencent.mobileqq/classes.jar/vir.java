import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;

class vir
  extends urs<vgo, vgp>
{
  vir(viq paramviq, String[] paramArrayOfString) {}
  
  public void a(@NonNull vgo paramvgo, @Nullable vgp paramvgp, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramvgp == null) || (paramvgp.jdField_a_of_type_Int != 0))
    {
      if (paramvgp != null) {}
      for (int i = paramvgp.jdField_a_of_type_Int;; i = -1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("EncryptUrlJob", 2, "encrypt failed, error code = " + i);
        }
        viq.a(this.jdField_a_of_type_Viq, false);
        return;
      }
    }
    if (((Boolean)((uvt)uwa.a(10)).b("key_share_encrypt_flag", Boolean.valueOf(false))).booleanValue()) {}
    for (paramvgo = vky.a(this.jdField_a_of_type_ArrayOfJavaLangString[1], viq.a(this.jdField_a_of_type_Viq));; paramvgo = this.jdField_a_of_type_ArrayOfJavaLangString[1])
    {
      paramvgo = this.jdField_a_of_type_ArrayOfJavaLangString[0] + "?token=" + paramvgp.jdField_a_of_type_JavaLangString + "&" + paramvgo;
      if (QLog.isColorLevel()) {
        QLog.d("EncryptUrlJob", 2, new Object[] { "encrypt done url:", paramvgo });
      }
      this.jdField_a_of_type_Viq.a("EncryptUrlJob_coverUrl", paramvgp.c);
      this.jdField_a_of_type_Viq.a("EncryptUrlJob_encryptedUrl", paramvgo);
      viq.b(this.jdField_a_of_type_Viq, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vir
 * JD-Core Version:    0.7.0.1
 */