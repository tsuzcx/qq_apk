import android.view.View;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class bmi
  implements ActionSheet.OnButtonClickListener
{
  public bmi(TroopAssistantActivity paramTroopAssistantActivity, int paramInt, String paramString, ActionSheet paramActionSheet) {}
  
  public void a(View paramView, int paramInt)
  {
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssistantActivity.a == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssistantActivity.a = new QQProgressNotifier(this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssistantActivity);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssistantActivity.a.a(2, 2131363527, 1500);
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      return;
      int i = -1;
      switch (paramInt)
      {
      default: 
        paramInt = i;
      }
      while (paramInt != this.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssistantActivity.app.a(this.jdField_a_of_type_JavaLangString, Integer.valueOf(paramInt));
        break;
        paramInt = 1;
        continue;
        paramInt = 2;
        continue;
        paramInt = 3;
      }
    }
    catch (Exception paramView)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("TroopAssistantActivity", 2, paramView.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bmi
 * JD-Core Version:    0.7.0.1
 */