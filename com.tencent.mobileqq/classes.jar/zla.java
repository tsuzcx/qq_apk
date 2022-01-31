import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.trooponline.data.TroopOnlineMemberManager;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xa2a.oidb_0xa2a.ReqBody;

public class zla
  implements Runnable
{
  public zla(TroopHandler paramTroopHandler, String paramString) {}
  
  public void run()
  {
    Object localObject = (TroopOnlineMemberManager)this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.b.getManager(233);
    if (NetConnInfoCenter.getServerTime() < ((TroopOnlineMemberManager)localObject).c(this.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopHandler", 2, "getAllOnlineMemberList, too frequency");
      }
      localObject = ((TroopOnlineMemberManager)localObject).b(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(98, true, new Object[] { this.jdField_a_of_type_JavaLangString, localObject });
      return;
    }
    try
    {
      localObject = new oidb_0xa2a.ReqBody();
      ((oidb_0xa2a.ReqBody)localObject).group_id.set(Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue());
      ((oidb_0xa2a.ReqBody)localObject).is_private.set(TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.b, this.jdField_a_of_type_JavaLangString));
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a("OidbSvc.0xa2a_1", 2602, 1, ((oidb_0xa2a.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("troopUin", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.b((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.i("TroopHandler", 1, "getAllOnlineMemberList, e=" + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zla
 * JD-Core Version:    0.7.0.1
 */