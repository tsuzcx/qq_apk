import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;

public class gtg
  implements ActionSheet.OnButtonClickListener
{
  public gtg(TroopBarReplyActivity paramTroopBarReplyActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.b();
      return;
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.jdField_a_of_type_AndroidNetUri = TroopBarUtils.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity, AppConstants.ap, 1001);
      continue;
      paramView = new ArrayList();
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.jdField_a_of_type_JavaUtilArrayList != null) {
        paramView.addAll(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.jdField_a_of_type_JavaUtilArrayList);
      }
      TroopBarReplyActivity localTroopBarReplyActivity = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity;
      Intent localIntent = new Intent(localTroopBarReplyActivity, TroopBarReplyActivity.class);
      localIntent.setClass(localTroopBarReplyActivity, PhotoListActivity.class);
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramView);
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", TroopBarReplyActivity.class.getName());
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqqi");
      localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 8);
      localIntent.getExtras().remove("forward_type");
      localIntent.putExtra("album_enter_directly", true);
      localIntent.putExtra("ALBUM_ID", AlbumUtil.b);
      localIntent.putExtra("ALBUM_NAME", AlbumUtil.c);
      localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarReplyActivity.startActivityForResult(localIntent, 1001);
      AlbumUtil.a(localTroopBarReplyActivity, false, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gtg
 * JD-Core Version:    0.7.0.1
 */