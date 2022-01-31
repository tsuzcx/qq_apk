import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.qphone.base.util.QLog;

class wst
  implements Runnable
{
  wst(wss paramwss, Bitmap paramBitmap) {}
  
  public void run()
  {
    boolean bool = true;
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_Wss.a.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("AvatarPendantActivity decode Avatar, bitmap is null:");
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
          break label116;
        }
      }
    }
    for (;;)
    {
      QLog.d("Q.dynamicAvatar", 2, bool);
      return;
      this.jdField_a_of_type_Wss.a.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setFaceDrawable(this.jdField_a_of_type_Wss.a.app, 1, this.jdField_a_of_type_Wss.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a, 640, true, true, true, false, 7);
      break;
      label116:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wst
 * JD-Core Version:    0.7.0.1
 */