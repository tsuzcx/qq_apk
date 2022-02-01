import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public final class hdy
  implements Runnable
{
  public hdy(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface, Handler paramHandler) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = null;
    int j = 0;
    MessageForVideo localMessageForVideo;
    FriendManager localFriendManager;
    int i;
    String str;
    Object localObject2;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForVideo)))
    {
      localMessageForVideo = (MessageForVideo)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localMessageForVideo.parse();
      localFriendManager = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      localObject1 = localEditor;
      i = j;
      if (!localMessageForVideo.isVideo)
      {
        localObject1 = localEditor;
        i = j;
        if (localFriendManager != null)
        {
          localObject1 = localEditor;
          i = j;
          if (localFriendManager.b(localMessageForVideo.frienduin))
          {
            localObject1 = localEditor;
            i = j;
            if (localMessageForVideo.text != null)
            {
              localObject1 = localEditor;
              i = j;
              if (localMessageForVideo.text.contains("通话时长"))
              {
                str = QQUtils.a() + "_";
                localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(str + "shortcut_guide_info", 0);
                localObject1 = localEditor;
                i = j;
                if (((SharedPreferences)localObject2).getBoolean(str + "shortcut_need_guide_flag", true)) {
                  if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (localMessageForVideo.frienduin == null)) {
                    break label567;
                  }
                }
              }
            }
          }
        }
      }
    }
    label567:
    for (Object localObject1 = localFriendManager.b(localMessageForVideo.frienduin);; localObject1 = null)
    {
      if (!QQUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), new String[] { localObject1 }))
      {
        localEditor = ((SharedPreferences)localObject2).edit();
        localObject2 = ((SharedPreferences)localObject2).getString(str + "shortcut_uin_array", null);
        if (localObject2 == null)
        {
          localEditor.putString(str + "shortcut_uin_array", localMessageForVideo.frienduin + "_");
          i = 1;
          localEditor.commit();
        }
      }
      for (;;)
      {
        if (i != 0) {
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new hdz(this, localMessageForVideo, (String)localObject1), 1000L);
        }
        return;
        if (!((String)localObject2).contains(localMessageForVideo.frienduin))
        {
          i = ((String)localObject2).split("_").length;
          if (QLog.isColorLevel()) {
            QLog.d(QQUtils.b(), 2, "showShotcutGuide uin array length = " + i);
          }
          if (i < 3)
          {
            localObject2 = (String)localObject2 + localMessageForVideo.frienduin + "_";
            localEditor.putString(str + "shortcut_uin_array", (String)localObject2);
            if (i + 1 == 3) {
              localEditor.putBoolean(str + "shortcut_need_guide_flag", false);
            }
            i = 1;
            break;
          }
        }
        i = 0;
        break;
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hdy
 * JD-Core Version:    0.7.0.1
 */