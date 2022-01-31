import android.content.ComponentName;
import android.content.Intent;
import com.tencent.mobileqq.activity.ShortcutGuideDialogActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.qphone.base.util.BaseApplication;

class hea
  implements Runnable
{
  hea(hdz paramhdz, MessageForVideo paramMessageForVideo, String paramString) {}
  
  public void run()
  {
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName("com.tencent.mobileqqi", ShortcutGuideDialogActivity.class.getName()));
    localIntent.setFlags(268435456);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqDataMessageForVideo.frienduin);
    localIntent.putExtra("nick", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Hdz.a.a().startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hea
 * JD-Core Version:    0.7.0.1
 */