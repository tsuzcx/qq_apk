import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;

class xcd
  extends wle<xaa, xab>
{
  xcd(xcc paramxcc, String[] paramArrayOfString) {}
  
  public void a(@NonNull xaa paramxaa, @Nullable xab paramxab, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramxab == null) || (paramxab.jdField_a_of_type_Int != 0))
    {
      if (paramxab != null) {}
      for (int i = paramxab.jdField_a_of_type_Int;; i = -1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("EncryptUrlJob", 2, "encrypt failed, error code = " + i);
        }
        xcc.a(this.jdField_a_of_type_Xcc, false);
        return;
      }
    }
    if (((Boolean)((wpf)wpm.a(10)).b("key_share_encrypt_flag", Boolean.valueOf(false))).booleanValue()) {}
    for (paramxaa = xek.a(this.jdField_a_of_type_ArrayOfJavaLangString[1], xcc.a(this.jdField_a_of_type_Xcc));; paramxaa = this.jdField_a_of_type_ArrayOfJavaLangString[1])
    {
      paramxaa = this.jdField_a_of_type_ArrayOfJavaLangString[0] + "?token=" + paramxab.jdField_a_of_type_JavaLangString + "&" + paramxaa;
      if (QLog.isColorLevel()) {
        QLog.d("EncryptUrlJob", 2, new Object[] { "encrypt done url:", paramxaa });
      }
      this.jdField_a_of_type_Xcc.a("EncryptUrlJob_coverUrl", paramxab.c);
      this.jdField_a_of_type_Xcc.a("EncryptUrlJob_encryptedUrl", paramxaa);
      xcc.b(this.jdField_a_of_type_Xcc, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xcd
 * JD-Core Version:    0.7.0.1
 */