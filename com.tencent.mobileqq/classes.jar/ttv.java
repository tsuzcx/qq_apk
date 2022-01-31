import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopClassChoiceActivity;
import com.tencent.mobileqq.activity.TroopClassChoiceActivity.GetClassChoiceCallBack;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import java.util.ArrayList;

public class ttv
  implements Runnable
{
  public ttv(TroopClassChoiceActivity.GetClassChoiceCallBack paramGetClassChoiceCallBack) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.a.a.jdField_a_of_type_JavaLangString)) {
      this.a.a.jdField_a_of_type_JavaUtilArrayList = GroupCatalogTool.a(this.a.a).a();
    }
    for (;;)
    {
      TroopClassChoiceActivity.a(this.a.a).notifyDataSetChanged();
      return;
      this.a.a.jdField_a_of_type_JavaUtilArrayList = GroupCatalogTool.a(this.a.a).a(this.a.a.jdField_a_of_type_JavaLangString);
      if ((this.a.a.jdField_a_of_type_JavaUtilArrayList != null) && (this.a.a.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        GroupCatalogBean localGroupCatalogBean = (GroupCatalogBean)this.a.a.jdField_a_of_type_JavaUtilArrayList.get(0);
        if (localGroupCatalogBean.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean != null) {
          this.a.a.setTitle(localGroupCatalogBean.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ttv
 * JD-Core Version:    0.7.0.1
 */