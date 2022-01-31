import android.content.Context;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class eww
  implements Runnable
{
  public eww(ClubContentJsonTask.TaskInfo paramTaskInfo, File paramFile, Context paramContext, int paramInt) {}
  
  public void run()
  {
    boolean bool = HttpDownloadUtil.a(null, EmosmUtils.insertMtype("VIP_other", this.jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$TaskInfo.b), this.jdField_a_of_type_JavaIoFile);
    if (QLog.isColorLevel()) {
      QLog.d("ClubContentJsonTask", 2, "updateJson, " + this.jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$TaskInfo.b + ",ret=" + bool);
    }
    if (bool) {
      ClubContentJsonTask.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$TaskInfo.d, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eww
 * JD-Core Version:    0.7.0.1
 */