import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.lbs.LbsInfoMgr;
import com.tencent.qphone.base.util.QLog;

public class zos
  implements Runnable
{
  public zos(LbsInfoMgr paramLbsInfoMgr) {}
  
  public void run()
  {
    LbsInfoMgr.a(this.a).addObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver, true);
    LbsInfoMgr.a(this.a).b();
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopMemberDistance.LbsInfoMgr", 2, "reportLbsInfoToServer: timeStamp = " + this.a.jdField_a_of_type_Long + ", cost=" + (System.currentTimeMillis() - this.a.jdField_a_of_type_Long));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zos
 * JD-Core Version:    0.7.0.1
 */