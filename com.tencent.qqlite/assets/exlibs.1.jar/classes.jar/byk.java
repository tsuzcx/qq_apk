import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListScene;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class byk
  implements ActionSheet.OnButtonClickListener
{
  public byk(AIOImageListScene paramAIOImageListScene, ActionSheet paramActionSheet) {}
  
  public void a(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      paramView = this.jdField_a_of_type_ComTencentWidgetActionSheet.a(paramInt);
      if (paramView == null) {
        return;
      }
      if ((!TextUtils.isEmpty(paramView)) && (paramView.equals(AIOImageListScene.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene).getResources().getString(2131364249)))) {
        AIOImageListScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListScene);
      }
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     byk
 * JD-Core Version:    0.7.0.1
 */