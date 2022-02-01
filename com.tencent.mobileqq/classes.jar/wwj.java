import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;

class wwj
  extends wfl<wug, wuh>
{
  wwj(wwi paramwwi, String[] paramArrayOfString) {}
  
  public void a(@NonNull wug paramwug, @Nullable wuh paramwuh, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramwuh == null) || (paramwuh.jdField_a_of_type_Int != 0))
    {
      if (paramwuh != null) {}
      for (int i = paramwuh.jdField_a_of_type_Int;; i = -1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("EncryptUrlJob", 2, "encrypt failed, error code = " + i);
        }
        wwi.a(this.jdField_a_of_type_Wwi, false);
        return;
      }
    }
    if (((Boolean)((wjl)wjs.a(10)).b("key_share_encrypt_flag", Boolean.valueOf(false))).booleanValue()) {}
    for (paramwug = wyq.a(this.jdField_a_of_type_ArrayOfJavaLangString[1], wwi.a(this.jdField_a_of_type_Wwi));; paramwug = this.jdField_a_of_type_ArrayOfJavaLangString[1])
    {
      paramwug = this.jdField_a_of_type_ArrayOfJavaLangString[0] + "?token=" + paramwuh.jdField_a_of_type_JavaLangString + "&" + paramwug;
      if (QLog.isColorLevel()) {
        QLog.d("EncryptUrlJob", 2, new Object[] { "encrypt done url:", paramwug });
      }
      this.jdField_a_of_type_Wwi.a("EncryptUrlJob_coverUrl", paramwuh.c);
      this.jdField_a_of_type_Wwi.a("EncryptUrlJob_encryptedUrl", paramwug);
      wwi.b(this.jdField_a_of_type_Wwi, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wwj
 * JD-Core Version:    0.7.0.1
 */