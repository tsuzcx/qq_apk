import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;

class who
  extends vqq<wfl, wfm>
{
  who(whn paramwhn, String[] paramArrayOfString) {}
  
  public void a(@NonNull wfl paramwfl, @Nullable wfm paramwfm, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramwfm == null) || (paramwfm.jdField_a_of_type_Int != 0))
    {
      if (paramwfm != null) {}
      for (int i = paramwfm.jdField_a_of_type_Int;; i = -1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("EncryptUrlJob", 2, "encrypt failed, error code = " + i);
        }
        whn.a(this.jdField_a_of_type_Whn, false);
        return;
      }
    }
    if (((Boolean)((vuq)vux.a(10)).b("key_share_encrypt_flag", Boolean.valueOf(false))).booleanValue()) {}
    for (paramwfl = wjv.a(this.jdField_a_of_type_ArrayOfJavaLangString[1], whn.a(this.jdField_a_of_type_Whn));; paramwfl = this.jdField_a_of_type_ArrayOfJavaLangString[1])
    {
      paramwfl = this.jdField_a_of_type_ArrayOfJavaLangString[0] + "?token=" + paramwfm.jdField_a_of_type_JavaLangString + "&" + paramwfl;
      if (QLog.isColorLevel()) {
        QLog.d("EncryptUrlJob", 2, new Object[] { "encrypt done url:", paramwfl });
      }
      this.jdField_a_of_type_Whn.a("EncryptUrlJob_coverUrl", paramwfm.c);
      this.jdField_a_of_type_Whn.a("EncryptUrlJob_encryptedUrl", paramwfl);
      whn.b(this.jdField_a_of_type_Whn, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     who
 * JD-Core Version:    0.7.0.1
 */