import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.adapter.TroopListAdapter2;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.Switch;
import java.util.HashMap;

public class yim
  extends TroopObserver
{
  public yim(TroopListAdapter2 paramTroopListAdapter2, TroopActivity paramTroopActivity) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!paramBoolean)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity, this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.getString(2131430391), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopActivity.getTitleBarHeight());
      if ((this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)))
      {
        Switch localSwitch = (Switch)this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.jdField_a_of_type_JavaUtilHashMap.get(paramString);
        if (this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.jdField_a_of_type_ComTencentMobileqqAppTroopManager != null) {
          localSwitch.setChecked(this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.jdField_a_of_type_ComTencentMobileqqAppTroopManager.d(paramString));
        }
      }
    }
  }
  
  protected void b(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
      ((BaseActivity)this.jdField_a_of_type_ComTencentMobileqqAdapterTroopListAdapter2.jdField_a_of_type_AndroidContentContext).runOnUiThread(new yin(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yim
 * JD-Core Version:    0.7.0.1
 */