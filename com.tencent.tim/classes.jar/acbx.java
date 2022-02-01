import android.os.Process;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.msf.core.net.patch.PatchSharedPreUtil;
import com.tencent.mobileqq.startup.step.SetSplash;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class acbx
  extends acfo
{
  private String bnR;
  
  protected void Dp(String paramString)
  {
    this.c.x(3, paramString);
    if ("com.tencent.tim".equals(paramString)) {
      adrh.cTW();
    }
  }
  
  protected void Dq(String paramString)
  {
    super.Dq(paramString);
    this.bnR = paramString;
    if ("fake_p_msg".equals(paramString)) {
      this.PL = (acfn.a().a(this.c.a, this.c.mLastIndex, this.c.cvJ, MemoryManager.C(Process.myPid())) / 12000L - 2L);
    }
    CoreService.startCoreService(acfn.a().bHF);
    this.c.startTimer();
    adwp.onRunningBackground();
    BaseApplicationImpl.sApplication.getRuntime().onGuardEvent(1, 0L, 0L);
    if ("com.tencent.tim".equals(paramString)) {
      adrh.onBackground();
    }
  }
  
  protected void cHe()
  {
    this.PL += 1L;
    this.PM += 1L;
    if ((this.PM == 1L) && (SetSplash.ayy()) && (this.c.bok == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("setsplash", 2, "needshowsplashtoday , kill myself");
      }
      anot.c(null, "CliOper", "", "", "0X800483B", "0X800483B", 0, 0, "", "", "", "");
      System.exit(-1);
    }
    float f2 = MemoryManager.a().aW();
    float f1;
    long l;
    if (MagnifierSDK.a().a().oQ > 0.0F)
    {
      f1 = MagnifierSDK.a().a().oQ;
      if (MagnifierSDK.a().a().ER <= 0L) {
        break label434;
      }
      l = MagnifierSDK.a().a().ER;
      label143:
      if ((MagnifierSDK.a().a().aQy) && (f2 >= f1) && (this.PL >= l)) {
        this.c.x(5, this.bnR);
      }
      int i = acfn.a().P(MemoryManager.C(Process.myPid()));
      int j = acfn.a().a(this.c.a, this.c.mLastIndex, this.c.cvJ);
      l = acfn.a().kj[(i + j)] / 12000;
      if (this.PL < l) {
        break label442;
      }
      this.c.x(5, this.bnR);
      label265:
      if ((this.PM != 50L) && (this.PM != 51L)) {
        break label532;
      }
      GuardManager.EU(true);
      this.c.b(false, new String[0]);
      Object localObject = tnq.a(BaseApplicationImpl.sApplication, "dex");
      if ((localObject != null) && (((tnp)localObject).i(BaseApplicationImpl.sApplication, false)))
      {
        localObject = ((tnp)localObject).ot();
        if ((PatchSharedPreUtil.getPatchVerifyStatus(BaseApplicationImpl.sApplication, (String)localObject)) && (this.c.bok == null) && ((tnh.bCv == 0) || (!tnh.aJB.equals(localObject))))
        {
          QLog.d("PatchLogTag", 1, "GuardManager exit to install patch, target patchName=" + (String)localObject + ", installed patchName=" + tnh.aJB + ", installStatus=" + tnh.bCv);
          System.exit(-1);
        }
      }
    }
    label434:
    label442:
    do
    {
      return;
      f1 = 0.95F;
      break;
      l = 50L;
      break label143;
      if (this.PM == 1L)
      {
        MemoryManager.a().hA(1L);
        MemoryManager.a().Eh("BG_GUARD");
        break label265;
      }
      if ((this.PM != 3L) && (this.PM != 4L)) {
        break label265;
      }
      this.c.b(false, new String[] { "com.tencent.mobileqq:qzone", "com.tencent.mobileqq:mini", "com.tencent.mobileqq:tool", this.bnR });
      break label265;
      if ((this.PM == GuardManager.cvO) || (this.PM == GuardManager.cvO + 1))
      {
        if (!"com.tencent.mobileqq:qzone".equals(this.bnR)) {
          this.c.av(false, "com.tencent.mobileqq:qzone");
        }
        GuardManager.EU(false);
      }
    } while (((this.PM != GuardManager.cvN) && (this.PM != GuardManager.cvN + 1)) || ("com.tencent.mobileqq:tool".equals(this.bnR)));
    label532:
    this.c.av(false, "com.tencent.mobileqq:tool");
  }
  
  protected void cHf()
  {
    if (this.PL > 2L) {
      this.PL -= 2L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     acbx
 * JD-Core Version:    0.7.0.1
 */