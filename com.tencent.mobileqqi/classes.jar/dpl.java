import android.content.Context;
import android.os.Handler;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.troopinfo.GroupCatalogBean;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class dpl
  extends Thread
{
  public dpl(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void run()
  {
    try
    {
      Object localObject = BaseApplication.getContext();
      String str = Long.toString(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a);
      GroupCatalogBean localGroupCatalogBean = GroupCatalogTool.a((Context)localObject).a();
      if ((localGroupCatalogBean != null) && (localGroupCatalogBean.b.equals(str))) {}
      for (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.i = localGroupCatalogBean.a();; this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.i = ((GroupCatalogBean)localObject).a())
      {
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
        return;
        localObject = GroupCatalogTool.a((Context)localObject).a((Context)localObject, str);
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, localException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dpl
 * JD-Core Version:    0.7.0.1
 */