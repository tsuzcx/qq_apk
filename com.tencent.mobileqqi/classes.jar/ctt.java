import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class ctt
  implements Runnable
{
  public ctt(FriendProfileCardActivity paramFriendProfileCardActivity, ProfileCardTemplate paramProfileCardTemplate) {}
  
  public void run()
  {
    Message localMessage = Message.obtain();
    Object localObject1;
    try
    {
      String str = ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.b, -1L);
      localObject1 = new File(str);
      if ((!((File)localObject1).isDirectory()) || (((File)localObject1).listFiles().length <= 1))
      {
        localObject1 = new File(str + ".zip");
        if (((File)localObject1).exists()) {
          ((File)localObject1).delete();
        }
        localObject2 = new DownloadInfo("http://imgcache.qq.com/club/mobile/profile/template/common.zip", (File)localObject1, 0);
        if (HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.b, (DownloadInfo)localObject2, null, null, "param_XGSummaryCardDownloadFlow", "param_WIFISummaryCardDownloadFlow") != 0) {
          break label280;
        }
      }
      label280:
      for (int i = 1; i != 0; i = 0)
      {
        FileUtils.a(((File)localObject1).getAbsolutePath(), str + File.separator);
        ((File)localObject1).delete();
        str = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.e;
        localObject1 = ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.b, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.a);
        if ((str == null) || (localObject1 == null)) {
          break label616;
        }
        localObject2 = new File((String)localObject1);
        File localFile = new File((String)localObject1 + File.separator + "config.json");
        if ((!((File)localObject2).isDirectory()) || (!localFile.exists())) {
          break label376;
        }
        localMessage.what = 6;
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.sendMessage(localMessage);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 2, "download card common template  error or unzip fail");
      }
      localMessage.what = 7;
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.sendMessage(localMessage);
      return;
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 2, "download card common template  exception msg=" + localException1.getMessage());
      }
      localMessage.what = 7;
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.sendMessage(localMessage);
      return;
    }
    label376:
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "start downloadCardTemplate path= " + (String)localObject1);
    }
    Object localObject2 = new File((String)localObject1 + ".zip");
    if (((File)localObject2).exists()) {
      ((File)localObject2).delete();
    }
    if (HttpDownloadUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.b, localException1, (File)localObject2)) {}
    try
    {
      FileUtils.a(((File)localObject2).getAbsolutePath(), (String)localObject1 + File.separator);
      ((File)localObject2).delete();
      ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.b, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.a, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.b);
      if (ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.b, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, true))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "downloadCardTemplate unzip success");
        }
        localMessage.what = 6;
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.sendMessage(localMessage);
        return;
      }
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 2, "downloadCardTemplate  exception msg=" + localIOException.getMessage());
      }
      localIOException.printStackTrace();
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "downloadCardTemplate  error or unzip fail");
        }
        localMessage.what = 7;
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.sendMessage(localMessage);
        return;
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "downloadCardTemplate  success but unzip error");
        }
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        label616:
        localException2.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ctt
 * JD-Core Version:    0.7.0.1
 */