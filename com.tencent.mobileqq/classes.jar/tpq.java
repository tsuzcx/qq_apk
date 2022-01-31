import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;

class tpq
  extends syr<tnn, tno>
{
  tpq(tpp paramtpp, String[] paramArrayOfString) {}
  
  public void a(@NonNull tnn paramtnn, @Nullable tno paramtno, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramtno == null) || (paramtno.jdField_a_of_type_Int != 0))
    {
      if (paramtno != null) {}
      for (int i = paramtno.jdField_a_of_type_Int;; i = -1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("EncryptUrlJob", 2, "encrypt failed, error code = " + i);
        }
        tpp.a(this.jdField_a_of_type_Tpp, false);
        return;
      }
    }
    if (((Boolean)((tcs)tcz.a(10)).b("key_share_encrypt_flag", Boolean.valueOf(false))).booleanValue()) {}
    for (paramtnn = trx.a(this.jdField_a_of_type_ArrayOfJavaLangString[1], tpp.a(this.jdField_a_of_type_Tpp));; paramtnn = this.jdField_a_of_type_ArrayOfJavaLangString[1])
    {
      paramtnn = this.jdField_a_of_type_ArrayOfJavaLangString[0] + "?token=" + paramtno.jdField_a_of_type_JavaLangString + "&" + paramtnn;
      if (QLog.isColorLevel()) {
        QLog.d("EncryptUrlJob", 2, new Object[] { "encrypt done url:", paramtnn });
      }
      this.jdField_a_of_type_Tpp.a("EncryptUrlJob_coverUrl", paramtno.c);
      this.jdField_a_of_type_Tpp.a("EncryptUrlJob_encryptedUrl", paramtnn);
      tpp.b(this.jdField_a_of_type_Tpp, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tpq
 * JD-Core Version:    0.7.0.1
 */