import android.os.Process;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class acby
  extends acfo
{
  protected void Dp(String paramString)
  {
    this.c.x(3, paramString);
  }
  
  protected void Dq(String paramString)
  {
    super.Dq(paramString);
    this.c.EV(false);
    if (!"trick_p_msg".equals(paramString)) {
      this.c.b(false, new String[] { paramString });
    }
    long l = MemoryManager.C(Process.myPid());
    if (acfn.a().P(l) != 2) {
      this.c.yR();
    }
    BaseApplicationImpl.sApplication.getRuntime().onGuardEvent(2, acfn.a().PH, 0L);
    CoreService.stopCoreService();
  }
  
  protected void cHe()
  {
    super.cHe();
    float f2 = MemoryManager.a().aW();
    float f1;
    if (MagnifierSDK.a().a().oQ > 0.0F)
    {
      f1 = MagnifierSDK.a().a().oQ;
      if ((f2 >= f1) && (MagnifierSDK.a().a().aQy) && (this.c.bok == null))
      {
        MemoryManager.a().hA(2L);
        System.exit(-1);
      }
      if (this.PM != GuardManager.cvM * 50 - 1) {
        break label236;
      }
      l = MemoryManager.C(Process.myPid());
      localHashMap = new HashMap();
      localHashMap.put("qqUsedMemory", String.valueOf(l / 1024L));
      localHashMap.put("ramSize", String.valueOf(aqgz.getSystemTotalMemory() / 1024L));
      localHashMap.put("heapSize", String.valueOf(Runtime.getRuntime().totalMemory() / 1024L));
      localHashMap.put("maxHeapSize", String.valueOf(Runtime.getRuntime().maxMemory() / 1024L));
      this.c.report("GM_reborn", localHashMap);
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, "suicide to free memory! suicide_factor=" + GuardManager.cvM);
      }
    }
    label236:
    while (((this.PM != GuardManager.cvM * 50) && (this.PM != GuardManager.cvM * 50 + 1)) || (this.c.bok != null))
    {
      long l;
      HashMap localHashMap;
      return;
      f1 = 0.95F;
      break;
    }
    System.exit(-1);
  }
  
  protected void cHf()
  {
    this.c.x(4, "fake_p_msg");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     acby
 * JD-Core Version:    0.7.0.1
 */