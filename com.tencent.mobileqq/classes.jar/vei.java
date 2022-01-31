import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.qphone.base.util.QLog;

class vei
  extends unj<vcf, vcg>
{
  vei(veh paramveh, String[] paramArrayOfString) {}
  
  public void a(@NonNull vcf paramvcf, @Nullable vcg paramvcg, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramvcg == null) || (paramvcg.jdField_a_of_type_Int != 0))
    {
      if (paramvcg != null) {}
      for (int i = paramvcg.jdField_a_of_type_Int;; i = -1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("EncryptUrlJob", 2, "encrypt failed, error code = " + i);
        }
        veh.a(this.jdField_a_of_type_Veh, false);
        return;
      }
    }
    if (((Boolean)((urk)urr.a(10)).b("key_share_encrypt_flag", Boolean.valueOf(false))).booleanValue()) {}
    for (paramvcf = vgp.a(this.jdField_a_of_type_ArrayOfJavaLangString[1], veh.a(this.jdField_a_of_type_Veh));; paramvcf = this.jdField_a_of_type_ArrayOfJavaLangString[1])
    {
      paramvcf = this.jdField_a_of_type_ArrayOfJavaLangString[0] + "?token=" + paramvcg.jdField_a_of_type_JavaLangString + "&" + paramvcf;
      if (QLog.isColorLevel()) {
        QLog.d("EncryptUrlJob", 2, new Object[] { "encrypt done url:", paramvcf });
      }
      this.jdField_a_of_type_Veh.a("EncryptUrlJob_coverUrl", paramvcg.c);
      this.jdField_a_of_type_Veh.a("EncryptUrlJob_encryptedUrl", paramvcf);
      veh.b(this.jdField_a_of_type_Veh, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vei
 * JD-Core Version:    0.7.0.1
 */