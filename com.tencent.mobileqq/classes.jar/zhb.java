import android.os.Process;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.MemoryConfigs;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class zhb
  extends zlr
{
  protected void a()
  {
    super.a();
    float f2 = MemoryManager.a().a();
    float f1;
    if (MemoryConfigs.a().d > 0.0F)
    {
      f1 = MemoryConfigs.a().d;
      if ((f2 >= f1) && (MemoryConfigs.a().c) && (this.a.a == null))
      {
        MemoryManager.a().a(2L);
        System.exit(-1);
      }
      if (this.d != GuardManager.c * 50 - 1) {
        break label227;
      }
      l = MemoryManager.a(Process.myPid());
      localHashMap = new HashMap();
      localHashMap.put("qqUsedMemory", String.valueOf(l / 1024L));
      localHashMap.put("ramSize", String.valueOf(DeviceInfoUtil.e() / 1024L));
      localHashMap.put("heapSize", String.valueOf(Runtime.getRuntime().totalMemory() / 1024L));
      localHashMap.put("maxHeapSize", String.valueOf(Runtime.getRuntime().maxMemory() / 1024L));
      this.a.a("GM_reborn", localHashMap);
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 2, "suicide to free memory! suicide_factor=" + GuardManager.c);
      }
    }
    label227:
    while (((this.d != GuardManager.c * 50) && (this.d != GuardManager.c * 50 + 1)) || (this.a.a != null))
    {
      long l;
      HashMap localHashMap;
      return;
      f1 = 0.95F;
      break;
    }
    System.exit(-1);
  }
  
  protected void a(String paramString)
  {
    this.a.a(3, paramString);
  }
  
  protected void b()
  {
    this.a.a(4, "fake_p_msg");
  }
  
  protected void b(String paramString)
  {
    super.b(paramString);
    this.a.c(false);
    if (!"trick_p_msg".equals(paramString)) {
      this.a.a(false, new String[] { paramString });
    }
    long l = MemoryManager.a(Process.myPid());
    if (zlp.a().a(l) != 2) {
      this.a.c();
    }
    BaseApplicationImpl.sApplication.getRuntime().onGuardEvent(2, zlp.a().a, 0L);
    CoreService.stopCoreService();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zhb
 * JD-Core Version:    0.7.0.1
 */