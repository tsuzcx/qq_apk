import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.newshare.util.StoryShareEncryptHelper.2;
import com.tencent.qphone.base.util.QLog;

public class tsb
  extends syr<tnn, tno>
{
  public tsb(StoryShareEncryptHelper.2 param2, long paramLong, bcqf parambcqf) {}
  
  public void a(@NonNull tnn paramtnn, @Nullable tno paramtno, @NonNull ErrorMessage paramErrorMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.share.trans.helper", 2, "decrypt done costTime = " + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + ", resp:" + paramtno);
    }
    vei.a("StoryShareEncryptHelper", "decrypt", 0, 0, new String[] { String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long) });
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareUtilStoryShareEncryptHelper$2.a.a(paramtno, this.jdField_a_of_type_Bcqf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tsb
 * JD-Core Version:    0.7.0.1
 */