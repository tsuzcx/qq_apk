import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.qphone.base.util.BaseApplication;

class ucm
  implements Runnable
{
  ucm(ucl paramucl, TroopInfo paramTroopInfo) {}
  
  public void run()
  {
    GroupCatalogBean localGroupCatalogBean = GroupCatalogTool.a(BaseApplication.getContext()).a(this.jdField_a_of_type_Ucl.a, Long.toString(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.dwGroupClassExt));
    if (localGroupCatalogBean != null)
    {
      Message localMessage = new Message();
      localMessage.what = 2;
      localMessage.obj = localGroupCatalogBean.a();
      this.jdField_a_of_type_Ucl.a.a.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ucm
 * JD-Core Version:    0.7.0.1
 */