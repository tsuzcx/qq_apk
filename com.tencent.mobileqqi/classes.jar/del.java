import android.view.View;
import com.tencent.mobileqq.activity.RecentLoginDevActivity;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;

public class del
  implements ActionSheet.OnButtonClickListener
{
  public del(RecentLoginDevActivity paramRecentLoginDevActivity, String paramString, ArrayList paramArrayList, int paramInt) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if ((RecentLoginDevActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentLoginDevActivity) != null) && (RecentLoginDevActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentLoginDevActivity).isShowing()) && (!this.jdField_a_of_type_ComTencentMobileqqActivityRecentLoginDevActivity.isFinishing()))
      {
        RecentLoginDevActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentLoginDevActivity).dismiss();
        RecentLoginDevActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentLoginDevActivity).cancel();
        RecentLoginDevActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentLoginDevActivity, null);
      }
      return;
      if (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqActivityRecentLoginDevActivity))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentLoginDevActivity, this.jdField_a_of_type_ComTencentMobileqqActivityRecentLoginDevActivity.getString(2131562452), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityRecentLoginDevActivity.d());
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.RecentLoginDevActivity", 2, "OnClick begin to delHistoryDev");
        }
        if (EquipmentLockImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentLoginDevActivity.b, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Int)) {
          RecentLoginDevActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentLoginDevActivity);
        } else if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.RecentLoginDevActivity", 2, "showDelDevActionSheet.OnClick delHistoryDev failed");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     del
 * JD-Core Version:    0.7.0.1
 */