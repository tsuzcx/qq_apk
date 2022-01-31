import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopHandler.Oidb_0xb36;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import tencent.im.oidb.cmd0xb36.oidb_cmd0xb36.RspBody;
import tencent.im.oidb.cmd0xb36.oidb_cmd0xb36.ToastInfo;

public class zol
  implements Runnable
{
  public zol(TroopManager paramTroopManager) {}
  
  public void run()
  {
    Object localObject = this.a.jdField_a_of_type_JavaUtilMap.values();
    long l = NetConnInfoCenter.getServerTime();
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      QLog.e(".troop.survey", 1, "Error: check survey list expire, app is null!");
      return;
    }
    TroopHandler localTroopHandler = (TroopHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
    if (localTroopHandler == null)
    {
      QLog.e(".troop.survey", 1, "Error: check survey list expire, troop handler is null!");
      return;
    }
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      oidb_cmd0xb36.RspBody localRspBody = (oidb_cmd0xb36.RspBody)((Iterator)localObject).next();
      if ((localRspBody.toast.expired.has()) && (localRspBody.toast.expired.get() < l))
      {
        String str = String.valueOf(localRspBody.group_id.get());
        if (QLog.isColorLevel()) {
          QLog.d(".troop.survey", 2, new Object[] { "group id ", str, "request survey toast, expiredTime: ", Integer.valueOf(localRspBody.toast.expired.get()) });
        }
        TroopHandler.Oidb_0xb36.a(localTroopHandler, str, 0);
      }
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zol
 * JD-Core Version:    0.7.0.1
 */