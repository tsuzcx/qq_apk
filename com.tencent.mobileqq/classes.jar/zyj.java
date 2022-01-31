import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.ar.NeonControl;
import com.tencent.mobileqq.ar.ScanEntranceDPC;
import com.tencent.mobileqq.statistics.cpu.CPUReport;
import com.tencent.qphone.base.util.QLog;

public class zyj
  implements Runnable
{
  public zyj(NeonControl paramNeonControl, SharedPreferences paramSharedPreferences, boolean paramBoolean) {}
  
  public void run()
  {
    boolean bool1 = true;
    ??? = new CPUReport();
    ((CPUReport)???).a();
    boolean bool2 = ((CPUReport)???).a();
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("sp_cpu_neon_support", bool2).apply();
    boolean bool3 = ScanEntranceDPC.a().e;
    int i;
    int j;
    if (QLog.isColorLevel())
    {
      if (!bool3) {
        break label216;
      }
      i = 1;
      if (!bool2) {
        break label221;
      }
      j = 1;
      label76:
      if (!this.jdField_a_of_type_Boolean) {
        break label226;
      }
    }
    label216:
    label221:
    label226:
    for (int k = 1;; k = 0)
    {
      QLog.i("NeonControl", 2, String.format("dpcNeonCfgSwitch:%d isCpuNeonSupport:%d forceOpenNeon:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) }));
      if (this.jdField_a_of_type_Boolean) {
        synchronized (this.jdField_a_of_type_ComTencentMobileqqArNeonControl.a)
        {
          NeonControl.a(this.jdField_a_of_type_ComTencentMobileqqArNeonControl, bool2);
          return;
        }
      }
      for (;;)
      {
        synchronized (this.jdField_a_of_type_ComTencentMobileqqArNeonControl.a)
        {
          NeonControl localNeonControl = this.jdField_a_of_type_ComTencentMobileqqArNeonControl;
          if ((bool3) && (bool2))
          {
            NeonControl.a(localNeonControl, bool1);
            return;
          }
        }
        bool1 = false;
      }
      i = 0;
      break;
      j = 0;
      break label76;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zyj
 * JD-Core Version:    0.7.0.1
 */