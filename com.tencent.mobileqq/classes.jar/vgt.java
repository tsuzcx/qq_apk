import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.newshare.util.StoryShareEncryptHelper.2;
import com.tencent.qphone.base.util.QLog;

public class vgt
  extends unj<vcf, vcg>
{
  public vgt(StoryShareEncryptHelper.2 param2, long paramLong, bepp parambepp) {}
  
  public void a(@NonNull vcf paramvcf, @Nullable vcg paramvcg, @NonNull ErrorMessage paramErrorMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.share.trans.helper", 2, "decrypt done costTime = " + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + ", resp:" + paramvcg);
    }
    wta.a("StoryShareEncryptHelper", "decrypt", 0, 0, new String[] { String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long) });
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareUtilStoryShareEncryptHelper$2.a.a(paramvcg, this.jdField_a_of_type_Bepp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vgt
 * JD-Core Version:    0.7.0.1
 */