import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListScene;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;

public class ecg
  implements ActionSheet.OnButtonClickListener
{
  public ecg(AIOImageListScene paramAIOImageListScene, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      paramView = this.jdField_a_of_type_ComTencentWidgetActionSheet.a(paramInt);
      if (paramView == null) {
        return;
      }
      if (!TextUtils.isEmpty(paramView))
      {
        if (!paramView.equals(AIOImageListScene.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene).getResources().getString(2131561871))) {
          break label81;
        }
        AIOImageListScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene);
        AIOImageListScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene, "Multi_Forward_Contacts", this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.a.size());
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      label81:
      if (paramView.equals(AIOImageListScene.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene).getResources().getString(2131562778)))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.a.size() > 20) {
          QQToast.a(AIOImageListScene.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene), 2131563256, 0).a();
        } else {
          AIOImageListScene.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene);
        }
      }
      else if (paramView.equals(AIOImageListScene.e(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene).getResources().getString(2131562914))) {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene.a.size() > 20) {
          QQToast.a(AIOImageListScene.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene), 2131563256, 0).a();
        } else {
          AIOImageListScene.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ecg
 * JD-Core Version:    0.7.0.1
 */