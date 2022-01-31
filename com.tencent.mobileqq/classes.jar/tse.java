import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.newshare.util.StoryShareEncryptHelper.2;
import com.tencent.qphone.base.util.QLog;

public class tse
  extends syu<tnq, tnr>
{
  public tse(StoryShareEncryptHelper.2 param2, long paramLong, bcpq parambcpq) {}
  
  public void a(@NonNull tnq paramtnq, @Nullable tnr paramtnr, @NonNull ErrorMessage paramErrorMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.share.trans.helper", 2, "decrypt done costTime = " + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + ", resp:" + paramtnr);
    }
    vel.a("StoryShareEncryptHelper", "decrypt", 0, 0, new String[] { String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long) });
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareUtilStoryShareEncryptHelper$2.a.a(paramtnr, this.jdField_a_of_type_Bcpq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tse
 * JD-Core Version:    0.7.0.1
 */