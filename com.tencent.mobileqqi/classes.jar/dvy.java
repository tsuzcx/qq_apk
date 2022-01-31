import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.view.View;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class dvy
  implements ActionSheet.OnButtonClickListener
{
  public dvy(PlusPanel paramPlusPanel, Uri paramUri, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    case 0: 
      PlusPanelUtils.a(PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel), PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel), this.jdField_a_of_type_AndroidNetUri, PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel));
      PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit().putString("LastScreenShotUri", null).commit();
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
    PlusPanelUtils.a(PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel), PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel), PlusPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dvy
 * JD-Core Version:    0.7.0.1
 */