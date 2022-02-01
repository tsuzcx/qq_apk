import android.os.Process;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.AppRuntime;

public class acgy
  extends acfo
{
  protected void Dp(String paramString)
  {
    GuardManager localGuardManager = this.c;
    if ("com.tencent.tim".equals(paramString)) {}
    for (int i = 2;; i = 3)
    {
      localGuardManager.x(i, paramString);
      return;
    }
  }
  
  protected void Dq(String paramString)
  {
    super.Dq(paramString);
    CoreService.startCoreService(acfn.a().bHF);
    this.c.startTimer();
    BaseApplicationImpl.sApplication.getRuntime().onGuardEvent(3, 0L, 0L);
  }
  
  protected void cHe()
  {
    super.cHe();
    if (this.PL >= acfn.a().a(this.c.a, this.c.mLastIndex, this.c.cvJ, MemoryManager.C(Process.myPid())) / 12000L) {
      this.c.x(7, null);
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.PM != 1L);
        MemoryManager.a().Eh("LITE_GUARD");
        localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      } while (localObject == null);
      localObject = (aops)((QQAppInterface)localObject).getManager(233);
    } while (localObject == null);
    ((aops)localObject).Re(true);
  }
  
  protected void cHf()
  {
    if (this.PL > 2L) {
      this.PL -= 2L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     acgy
 * JD-Core Version:    0.7.0.1
 */