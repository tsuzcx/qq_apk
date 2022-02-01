import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vip.KCWraperV2.1;
import com.tencent.mobileqq.vip.KCWraperV2.2;
import com.tencent.mobileqq.vip.KingCardActivationFragment;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_dc04233;
import dualsim.common.IKcActivationViewer;
import dualsim.common.IKingCardInterface;
import dualsim.common.IKingCardInterface.OnChangeListener;
import dualsim.common.OrderCheckResult;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import tmsdk.common.KcSdkShellManager;

public class aqvg
  extends aqvf
{
  public AtomicBoolean ew = new AtomicBoolean(false);
  
  private void a(OrderCheckResult paramOrderCheckResult)
  {
    int i = 1;
    String str1;
    if (paramOrderCheckResult != null)
    {
      str1 = paramOrderCheckResult.toString();
      VK(str1);
      if (paramOrderCheckResult != null) {
        break label30;
      }
    }
    label30:
    label46:
    boolean bool2;
    do
    {
      return;
      str1 = "result == null";
      break;
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if (localObject != null) {
        break label186;
      }
      str1 = null;
      if (TextUtils.isEmpty(str1)) {
        break label206;
      }
      bool2 = a(str1, paramOrderCheckResult);
    } while (!(localObject instanceof QQAppInterface));
    Object localObject = (QQAppInterface)localObject;
    String str2 = paramOrderCheckResult.phoneNum;
    acny localacny = (acny)((QQAppInterface)localObject).getBusinessHandler(27);
    boolean bool1;
    label113:
    long l;
    if (paramOrderCheckResult.operator == 1)
    {
      if (paramOrderCheckResult.kingcard != 1) {
        break label196;
      }
      bool1 = true;
      localacny.a(str1, str2, bool1, paramOrderCheckResult.product, "");
      l = Long.parseLong(str1);
      if (paramOrderCheckResult.kingcard != 1) {
        break label201;
      }
    }
    for (;;)
    {
      new LpReportInfo_dc04233(l, i).report();
      if (!bool2) {
        break;
      }
      localacny.fg(((TicketManager)((QQAppInterface)localObject).getManager(2)).getSkey(str1), str1);
      return;
      label186:
      str1 = ((AppRuntime)localObject).getAccount();
      break label46;
      label196:
      bool1 = false;
      break label113;
      label201:
      i = 0;
    }
    label206:
    QLog.e("KC.TMSManager", 1, "tmsQuery can't get uin");
  }
  
  void S(ViewGroup paramViewGroup)
  {
    Object localObject = KcSdkShellManager.getInstance().getKingCardInterface();
    if (localObject != null)
    {
      localObject = ((IKingCardInterface)localObject).generateActivationView(paramViewGroup.getContext());
      if (localObject != null)
      {
        paramViewGroup.addView(((IKcActivationViewer)localObject).getWebView());
        ((IKcActivationViewer)localObject).startLoad();
        return;
      }
      QLog.e("KC.TMSManager", 1, "activationViewer == null");
    }
    QLog.e("KC.TMSManager", 1, "kingCardInterface == null");
  }
  
  public void a(aqvn.a parama, boolean paramBoolean)
  {
    ThreadManager.post(new KCWraperV2.2(this, parama, paramBoolean), 5, null, false);
  }
  
  boolean aFG()
  {
    if (QLog.isColorLevel()) {
      QLog.e("KC.TMSManager", 1, "supportActivationView == true");
    }
    return true;
  }
  
  void ar(Runnable paramRunnable)
  {
    VK("load jar");
    if (this.ew.get()) {
      return;
    }
    Context localContext = BaseApplicationImpl.getApplication().getApplicationContext();
    File localFile = new File(aqvn.a().bB(localContext));
    if (!localFile.exists())
    {
      if (paramRunnable != null) {
        paramRunnable.run();
      }
      SV(false);
      return;
    }
    ThreadManager.post(new KCWraperV2.1(this, localFile, localContext), 5, null, false);
  }
  
  boolean isReady()
  {
    if (this.ew.get()) {
      return true;
    }
    if (!new File(aqvn.a().bB(BaseApplicationImpl.getApplication())).exists()) {
      return false;
    }
    synchronized (this.ew)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.e(tag(), 1, "wait load");
        }
        this.ew.wait(500L);
        if (QLog.isColorLevel()) {
          QLog.e(tag(), 1, "wait end");
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
          QLog.e(tag(), 1, localInterruptedException, new Object[0]);
        }
      }
      return this.ew.get();
    }
  }
  
  public String tag()
  {
    return "KC.KCWraperV2";
  }
  
  boolean x(Activity paramActivity)
  {
    PublicFragmentActivity.start(paramActivity, KingCardActivationFragment.class);
    return true;
  }
  
  public static class a
    implements IKingCardInterface.OnChangeListener
  {
    public void onChanged(OrderCheckResult paramOrderCheckResult)
    {
      if (QLog.isColorLevel()) {
        QLog.e("KC.KCWraperV2", 1, "state changed");
      }
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if (localObject == null) {}
      for (localObject = null;; localObject = ((AppRuntime)localObject).getAccount())
      {
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (paramOrderCheckResult != null)) {
          aqvf.a((String)localObject, paramOrderCheckResult);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqvg
 * JD-Core Version:    0.7.0.1
 */