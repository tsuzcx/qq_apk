import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.newshare.util.StoryShareEncryptHelper.2;
import com.tencent.qphone.base.util.QLog;

public class wyu
  extends wfl<wug, wuh>
{
  public wyu(StoryShareEncryptHelper.2 param2, long paramLong, bisl parambisl) {}
  
  public void a(@NonNull wug paramwug, @Nullable wuh paramwuh, @NonNull ErrorMessage paramErrorMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.share.trans.helper", 2, "decrypt done costTime = " + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + ", resp:" + paramwuh);
    }
    ykv.a("StoryShareEncryptHelper", "decrypt", 0, 0, new String[] { String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long) });
    this.jdField_a_of_type_ComTencentBizQqstoryNewshareUtilStoryShareEncryptHelper$2.a.a(paramwuh, this.jdField_a_of_type_Bisl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wyu
 * JD-Core Version:    0.7.0.1
 */