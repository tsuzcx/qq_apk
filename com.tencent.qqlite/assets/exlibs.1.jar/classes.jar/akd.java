import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.mobileqq.activity.DoodleActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.io.File;

public class akd
  implements ActionSheet.OnButtonClickListener
{
  public akd(DoodleActivity paramDoodleActivity, ActionSheet paramActionSheet) {}
  
  public void a(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    case 0: 
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityDoodleActivity.getIntent();
      paramView.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      PhotoUtils.a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityDoodleActivity, DoodleActivity.class.getName(), 1, true);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
    paramView = new File(AppConstants.as + "photo/");
    if (!paramView.exists()) {
      paramView.mkdirs();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityDoodleActivity.a = Uri.fromFile(new File(AppConstants.as + "photo/" + System.currentTimeMillis() + ".jpg"));
    paramView = new Intent("android.media.action.IMAGE_CAPTURE");
    paramView.putExtra("output", this.jdField_a_of_type_ComTencentMobileqqActivityDoodleActivity.a);
    paramView.putExtra("android.intent.extra.videoQuality", 100);
    this.jdField_a_of_type_ComTencentMobileqqActivityDoodleActivity.startActivityForResult(paramView, 1);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     akd
 * JD-Core Version:    0.7.0.1
 */