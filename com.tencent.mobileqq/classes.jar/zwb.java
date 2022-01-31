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

public class zwb
  implements Runnable
{
  public zwb(LbsInfoReportManager paramLbsInfoReportManager, double paramDouble1, double paramDouble2, double paramDouble3, float paramFloat, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void run()
  {
    LbsReportInfo localLbsReportInfo = new LbsReportInfo();
    localLbsReportInfo.operTime = NetConnInfoCenter.getServerTime();
    localLbsReportInfo.lat = this.jdField_a_of_type_Double;
    localLbsReportInfo.lng = this.jdField_b_of_type_Double;
    localLbsReportInfo.alt = this.jdField_c_of_type_Double;
    localLbsReportInfo.accuracy = this.jdField_a_of_type_Float;
    localLbsReportInfo.businessTag = this.jdField_a_of_type_JavaLangString;
    localLbsReportInfo.nation = this.jdField_b_of_type_JavaLangString;
    localLbsReportInfo.province = this.jdField_c_of_type_JavaLangString;
    localLbsReportInfo.city = this.d;
    localLbsReportInfo.district = this.e;
    localLbsReportInfo.createContent();
    LbsInfoReportManager.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager).add(localLbsReportInfo);
    LbsInfoReportManager.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager, this.jdField_a_of_type_Double);
    LbsInfoReportManager.b(this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager, this.jdField_b_of_type_Double);
    LbsInfoReportManager.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager, SystemClock.elapsedRealtime());
    if (QLog.isColorLevel()) {
      QLog.i("LBSReport", 2, "onReceiveLbsInfo cache size : " + LbsInfoReportManager.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager).size() + " lastReportTime: " + LbsInfoReportManager.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager) + " currentTime: " + NetConnInfoCenter.getServerTime());
    }
    int i;
    if ((LbsInfoReportManager.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager).a != null) && (!LbsInfoReportManager.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager).a.b()))
    {
      i = 1;
      if (i != 0) {
        break label245;
      }
    }
    label245:
    do
    {
      return;
      i = 0;
      break;
      if (!LbsInfoReportManager.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager)) {
        LbsInfoReportManager.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager);
      }
      if ((LbsInfoReportManager.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager).size() >= 20) || (NetConnInfoCenter.getServerTime() - LbsInfoReportManager.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager) >= 1200L))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager.a(LbsInfoReportManager.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager), 0);
        if (!LbsInfoReportManager.b(this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager)) {
          this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager.a(LbsInfoReportManager.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager, LbsInfoReportManager.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager)), LbsReportInfo.convert2StrList(LbsInfoReportManager.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager)), LbsInfoReportManager.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager), 0);
        }
        LbsInfoReportManager.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager).clear();
        LbsInfoReportManager.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager).getEntityManagerFactory().createEntityManager().a(LbsReportInfo.class.getSimpleName(), null, null);
        LbsInfoReportManager.b(this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager, NetConnInfoCenter.getServerTime());
        return;
      }
      LbsInfoReportManager.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoLbsInfoReportManager).getEntityManagerFactory().createEntityManager().a(localLbsReportInfo);
    } while (!QLog.isColorLevel());
    QLog.d("LBSReport", 2, "update db");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zwb
 * JD-Core Version:    0.7.0.1
 */