import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.PortraitImageview;
import com.tencent.mobileqq.activity.photo.PhotoCropForPortraitActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;

public class xcl
  extends Handler
{
  boolean jdField_a_of_type_Boolean;
  
  public xcl(PhotoCropForPortraitActivity paramPhotoCropForPortraitActivity, ExtensionInfo paramExtensionInfo, String paramString) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (1000 == paramMessage.what)
    {
      this.jdField_a_of_type_Boolean = true;
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropForPortraitActivity.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview.a();
      int j = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropForPortraitActivity.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview.b();
      paramMessage = new RelativeLayout.LayoutParams((int)(i * 1.257D), (int)(j * 1.481D));
      paramMessage.addRule(14);
      paramMessage.topMargin = ((int)(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropForPortraitActivity.jdField_a_of_type_AndroidViewViewGroup.getHeight() * 0.5F - j * 0.5F * 1.705D));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropForPortraitActivity.jdField_a_of_type_ComTencentImageURLImageView != null) {
        break label214;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropForPortraitActivity.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropForPortraitActivity);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropForPortraitActivity.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropForPortraitActivity.jdField_a_of_type_ComTencentImageURLImageView, paramMessage);
    }
    for (;;)
    {
      ((AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropForPortraitActivity.app.getManager(45)).a(this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantId).a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropForPortraitActivity.jdField_a_of_type_ComTencentImageURLImageView, 6, PendantInfo.e, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantDiyId);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropForPortraitActivity.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      return;
      if (this.jdField_a_of_type_Boolean) {
        break;
      }
      return;
      label214:
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropForPortraitActivity.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xcl
 * JD-Core Version:    0.7.0.1
 */