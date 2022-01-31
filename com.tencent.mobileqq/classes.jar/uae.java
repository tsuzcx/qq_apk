import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.os.MqqHandler;

public class uae
  implements Runnable
{
  public uae(TroopRequestActivity paramTroopRequestActivity, TroopInfo paramTroopInfo) {}
  
  public void run()
  {
    GroupCatalogBean localGroupCatalogBean = GroupCatalogTool.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity, Long.toString(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupClassExt));
    if (localGroupCatalogBean != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopRequestActivity.i = localGroupCatalogBean.a();
      ThreadManager.getUIHandler().post(new uaf(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uae
 * JD-Core Version:    0.7.0.1
 */