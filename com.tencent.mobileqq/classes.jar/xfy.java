import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;

class xfy
  extends woz<xdv, xdw>
{
  xfy(xfx paramxfx, String[] paramArrayOfString) {}
  
  public void a(@NonNull xdv paramxdv, @Nullable xdw paramxdw, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramxdw == null) || (paramxdw.jdField_a_of_type_Int != 0))
    {
      if (paramxdw != null) {}
      for (int i = paramxdw.jdField_a_of_type_Int;; i = -1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("EncryptUrlJob", 2, "encrypt failed, error code = " + i);
        }
        xfx.a(this.jdField_a_of_type_Xfx, false);
        return;
      }
    }
    if (((Boolean)((wta)wth.a(10)).b("key_share_encrypt_flag", Boolean.valueOf(false))).booleanValue()) {}
    for (paramxdv = xif.a(this.jdField_a_of_type_ArrayOfJavaLangString[1], xfx.a(this.jdField_a_of_type_Xfx));; paramxdv = this.jdField_a_of_type_ArrayOfJavaLangString[1])
    {
      paramxdv = this.jdField_a_of_type_ArrayOfJavaLangString[0] + "?token=" + paramxdw.jdField_a_of_type_JavaLangString + "&" + paramxdv;
      if (QLog.isColorLevel()) {
        QLog.d("EncryptUrlJob", 2, new Object[] { "encrypt done url:", paramxdv });
      }
      this.jdField_a_of_type_Xfx.a("EncryptUrlJob_coverUrl", paramxdw.c);
      this.jdField_a_of_type_Xfx.a("EncryptUrlJob_encryptedUrl", paramxdv);
      xfx.b(this.jdField_a_of_type_Xfx, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xfy
 * JD-Core Version:    0.7.0.1
 */