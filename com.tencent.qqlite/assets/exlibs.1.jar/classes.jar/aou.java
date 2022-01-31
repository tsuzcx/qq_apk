import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.TimeTraceUtil;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;

public class aou
  implements Runnable
{
  String jdField_a_of_type_JavaLangString;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference b;
  
  public aou(FriendProfileCardActivity paramFriendProfileCardActivity, ProfileCardTemplate paramProfileCardTemplate, String paramString)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramFriendProfileCardActivity);
    this.b = new WeakReference(paramProfileCardTemplate);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.b != null))
        {
          FriendProfileCardActivity localFriendProfileCardActivity = (FriendProfileCardActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          Object localObject1 = (ProfileCardTemplate)this.b.get();
          if ((localFriendProfileCardActivity != null) && (localObject1 != null))
          {
            localFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("downloadTemplateBegin", "downloadTemplateStart", false);
            localObject1 = Message.obtain();
            boolean bool2 = ProfileCardUtil.a(localFriendProfileCardActivity.app.getApplication(), this.jdField_a_of_type_JavaLangString);
            bool1 = bool2;
            if (!bool2)
            {
              if (QLog.isColorLevel()) {
                QLog.i("Q.profilecard.FrdProfileCard", 2, "start download background=" + this.jdField_a_of_type_JavaLangString + ",isExistBgResource=" + bool2);
              }
              Object localObject2 = new File(ProfileCardUtil.a(localFriendProfileCardActivity.app.getApplication(), this.jdField_a_of_type_JavaLangString));
              localObject2 = new DownloadTask(this.jdField_a_of_type_JavaLangString, (File)localObject2);
              ((DownloadTask)localObject2).e = "profileCardDownload";
              ((DownloadTask)localObject2).d = "VIP_profilecard";
              if ((DownloaderFactory.a((DownloadTask)localObject2, localFriendProfileCardActivity.app) != 0) || (!ProfileCardUtil.a(localFriendProfileCardActivity.app.getApplication(), this.jdField_a_of_type_JavaLangString))) {
                break label280;
              }
              bool1 = true;
            }
            localFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("downloadTemplateBackground", "downloadTemplateStart", false);
            localFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqUtilsTimeTraceUtil.a("downloadTemplateCommon", "downloadTemplateStart", false);
            if (bool1)
            {
              ((Message)localObject1).what = 6;
              localFriendProfileCardActivity.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
              return;
            }
            ((Message)localObject1).what = 7;
            localFriendProfileCardActivity.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return;
      label280:
      boolean bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aou
 * JD-Core Version:    0.7.0.1
 */