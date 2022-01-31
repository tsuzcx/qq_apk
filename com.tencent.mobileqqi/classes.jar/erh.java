import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.PhotoCropForPortraitActivity;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.utils.AvatarPendantUtil;

public class erh
  extends Handler
{
  public erh(PhotoCropForPortraitActivity paramPhotoCropForPortraitActivity, int paramInt1, int paramInt2, ExtensionInfo paramExtensionInfo) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (-1 != paramMessage.what) {
      return;
    }
    paramMessage = new URLImageView(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropForPortraitActivity.getApplicationContext());
    Object localObject = new RelativeLayout.LayoutParams((int)(this.jdField_a_of_type_Int * 1.257D), (int)(this.b * 1.481D));
    ((RelativeLayout.LayoutParams)localObject).addRule(14);
    ((RelativeLayout.LayoutParams)localObject).topMargin = (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropForPortraitActivity.a.getHeight() / 2 - (int)(this.b / 2 * 1.705D));
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropForPortraitActivity.a.addView(paramMessage, (ViewGroup.LayoutParams)localObject);
    localObject = AvatarPendantUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropForPortraitActivity.b, this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantId, 7);
    paramMessage.setVisibility(0);
    paramMessage.setImageDrawable((Drawable)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     erh
 * JD-Core Version:    0.7.0.1
 */