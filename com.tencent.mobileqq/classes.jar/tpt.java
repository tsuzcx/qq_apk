import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;

class tpt
  extends syu<tnq, tnr>
{
  tpt(tps paramtps, String[] paramArrayOfString) {}
  
  public void a(@NonNull tnq paramtnq, @Nullable tnr paramtnr, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramtnr == null) || (paramtnr.jdField_a_of_type_Int != 0))
    {
      if (paramtnr != null) {}
      for (int i = paramtnr.jdField_a_of_type_Int;; i = -1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("EncryptUrlJob", 2, "encrypt failed, error code = " + i);
        }
        tps.a(this.jdField_a_of_type_Tps, false);
        return;
      }
    }
    if (((Boolean)((tcv)tdc.a(10)).b("key_share_encrypt_flag", Boolean.valueOf(false))).booleanValue()) {}
    for (paramtnq = tsa.a(this.jdField_a_of_type_ArrayOfJavaLangString[1], tps.a(this.jdField_a_of_type_Tps));; paramtnq = this.jdField_a_of_type_ArrayOfJavaLangString[1])
    {
      paramtnq = this.jdField_a_of_type_ArrayOfJavaLangString[0] + "?token=" + paramtnr.jdField_a_of_type_JavaLangString + "&" + paramtnq;
      if (QLog.isColorLevel()) {
        QLog.d("EncryptUrlJob", 2, new Object[] { "encrypt done url:", paramtnq });
      }
      this.jdField_a_of_type_Tps.a("EncryptUrlJob_coverUrl", paramtnr.c);
      this.jdField_a_of_type_Tps.a("EncryptUrlJob_encryptedUrl", paramtnq);
      tps.b(this.jdField_a_of_type_Tps, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tpt
 * JD-Core Version:    0.7.0.1
 */