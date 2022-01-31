import android.os.SystemClock;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.soso.LbsInfoReportManager;
import com.tencent.mobileqq.data.LbsReportInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class zsv
  implements Runnable
{
  public zsv(LbsInfoReportManager paramLbsInfoReportManager, double paramDouble1, double paramDouble2, double paramDouble3, float paramFloat, String paramString) {}
  
  public void run()
  {
    LbsReportInfo localLbsReportInfo = LbsInfoReportManager.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager, this.jdField_a_of_type_Double, this.b, this.c, this.jdField_a_of_type_Float, this.jdField_a_of_type_JavaLangString);
    LbsInfoReportManager.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager).add(localLbsReportInfo);
    LbsInfoReportManager.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager, this.jdField_a_of_type_Double);
    LbsInfoReportManager.b(this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager, this.b);
    LbsInfoReportManager.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager, SystemClock.elapsedRealtime());
    if (QLog.isColorLevel()) {
      QLog.i("LBSReport", 2, "onReceiveLbsInfo cache size : " + LbsInfoReportManager.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager).size() + " lastReportTime: " + LbsInfoReportManager.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager) + " currentTime: " + NetConnInfoCenter.getServerTime());
    }
    if ((LbsInfoReportManager.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager).a != null) && (!LbsInfoReportManager.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager).a.b())) {}
    for (int i = 1; i == 0; i = 0) {
      return;
    }
    if (!LbsInfoReportManager.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager)) {
      LbsInfoReportManager.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager);
    }
    if ((LbsInfoReportManager.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager).size() >= 20) || (NetConnInfoCenter.getServerTime() - LbsInfoReportManager.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager) >= 1200L))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager.a(LbsInfoReportManager.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager, LbsInfoReportManager.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager)), LbsReportInfo.convert2StrList(LbsInfoReportManager.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager)), LbsInfoReportManager.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager), 0);
      LbsInfoReportManager.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager).clear();
      LbsInfoReportManager.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager).getEntityManagerFactory().createEntityManager().a(LbsReportInfo.class.getSimpleName(), null, null);
      LbsInfoReportManager.b(this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager, NetConnInfoCenter.getServerTime());
      return;
    }
    LbsInfoReportManager.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager).getEntityManagerFactory().createEntityManager().a(localLbsReportInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zsv
 * JD-Core Version:    0.7.0.1
 */