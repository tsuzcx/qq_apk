import android.os.Process;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class crb
  extends cuj
{
  protected void a()
  {
    super.a();
    if (this.b == 299L)
    {
      l = MemoryManager.a(Process.myPid());
      localHashMap = new HashMap();
      localHashMap.put("qqUsedMemory", String.valueOf(l / 1024L));
      this.a.a("GM_reborn", localHashMap);
      if (QLog.isColorLevel()) {
        QLog.d("GuardManager", 1, "suicide to free memory!");
      }
    }
    while ((this.b != 301L) || (this.a.a(2)))
    {
      long l;
      HashMap localHashMap;
      return;
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
    this.a.b(false);
    this.a.a(false, new String[0]);
    long l = MemoryManager.a(Process.myPid());
    if (cuf.a().a(l) != 2) {
      this.a.f();
    }
    BaseApplicationImpl.a.a().onGuardEvent(2, cuf.a().a, 0L);
    CoreService.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     crb
 * JD-Core Version:    0.7.0.1
 */