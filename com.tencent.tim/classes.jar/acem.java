import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.QQAppInterface;

public class acem
  extends acfo
{
  protected long Pu;
  protected long Pv;
  private String bnR;
  
  protected void DE(String paramString)
  {
    if ("com.tencent.tim".equals(paramString))
    {
      this.c.x(4, null);
      adrh.onBackground();
      aeee.Hn(false);
    }
  }
  
  protected void Dp(String paramString)
  {
    if (!"com.tencent.tim".equals(paramString))
    {
      this.c.x(3, paramString);
      adrh.cTW();
    }
  }
  
  protected void Dq(String paramString)
  {
    super.Dq(paramString);
    QQAppInterface.a().onAppForeground();
    acek.a().onAppForeground(paramString);
    aeee.Hn(true);
    this.Pu = 0L;
    this.Pv = 0L;
    CoreService.startCoreService(acfn.a().bHF);
    this.c.startTimer();
  }
  
  protected void cHe()
  {
    boolean bool2 = true;
    super.cHe();
    this.Pu += 1L;
    this.Pv += 1L;
    if (this.PM >= 3L)
    {
      if (this.c.bok == null) {
        break label203;
      }
      bool1 = true;
      this.c.b(bool1, new String[] { "com.tencent.mobileqq:tool", "com.tencent.mobileqq:qzone", "com.tencent.mobileqq:mini", this.bnR });
      this.PM = 0L;
      if (!bool1) {
        this.c.x(4, null);
      }
    }
    if ((this.Pu >= 15L) && (!DeviceProfileManager.a().isFeatureSupported(DeviceProfileManager.DpcNames.disable_qzone_kill.name())))
    {
      if (this.c.bok != null)
      {
        bool1 = true;
        label139:
        this.c.av(bool1, "com.tencent.mobileqq:qzone");
        anpf.a().Rg(anpf.getUin());
        this.Pu = 0L;
      }
    }
    else if (this.Pv >= GuardManager.cvN) {
      if (this.c.bok == null) {
        break label213;
      }
    }
    label203:
    label213:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.c.av(bool1, "com.tencent.mobileqq:tool");
      this.Pv = 0L;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label139;
    }
  }
  
  protected void es(String paramString)
  {
    this.bnR = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     acem
 * JD-Core Version:    0.7.0.1
 */