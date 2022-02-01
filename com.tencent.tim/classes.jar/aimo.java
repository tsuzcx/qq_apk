import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import mqq.app.AppRuntime;

public abstract class aimo
{
  private aimp a = new aimp();
  private final HashSet<Long> ay = new HashSet();
  private boolean ckE = true;
  private final Map<Long, aimr> lx = new HashMap();
  
  public aimo()
  {
    aekj localaekj = (aekj)aeif.a().o(598);
    if (localaekj != null) {
      if (localaekj.bUB) {
        break label74;
      }
    }
    label74:
    for (boolean bool = true;; bool = false)
    {
      this.ckE = bool;
      return;
    }
  }
  
  private void a(long paramLong, RedTouch paramRedTouch)
  {
    int i = aims.b(paramRedTouch);
    if (i != 0) {
      this.lx.put(Long.valueOf(paramLong), new aimr(i, aims.c(paramRedTouch)));
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, long paramLong, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((!this.ay.contains(Long.valueOf(paramLong))) && (paramAppInfo != null) && (paramAppInfo.iNewFlag.get() != 0))
    {
      this.ay.add(Long.valueOf(paramLong));
      ((altq)paramQQAppInterface.getManager(36)).jq((int)paramLong, 30);
    }
  }
  
  public abstract BusinessInfoCheckUpdate.AppInfo a(QQAppInterface paramQQAppInterface, String paramString);
  
  public abstract void a(RedTouch paramRedTouch, BusinessInfoCheckUpdate.AppInfo paramAppInfo);
  
  public void a(zjo.b paramb)
  {
    QQAppInterface localQQAppInterface = paramb.app;
    Context localContext = paramb.context;
    RedTouch localRedTouch = paramb.redTouch;
    long l = paramb.Lg;
    String str = paramb.bal;
    int i = paramb.index;
    paramb = a(localQQAppInterface, String.valueOf(l));
    a(localQQAppInterface, l, paramb);
    if (this.ckE) {}
    for (boolean bool = this.a.a(localQQAppInterface, localContext, l, localRedTouch, str, this.lx, i);; bool = false)
    {
      QLog.d("Q.lebatab.LebaRedTouchBase", 1, new Object[] { "updateRedTouch,resID=", Long.valueOf(l), ",resPkgName=", str, ",isHandledRedTouch=", Boolean.valueOf(bool), ",leba_red_touch_spcific_enable->mSpecificEnable=", Boolean.valueOf(this.ckE) });
      if (!bool)
      {
        a(localRedTouch, paramb);
        a(l, localRedTouch);
        this.a.a(localQQAppInterface, str, paramb);
      }
      return;
    }
  }
  
  public Map<Long, aimr> ap()
  {
    return this.lx;
  }
  
  public void onPause()
  {
    if (!this.ay.isEmpty()) {}
    try
    {
      zjq.cdv |= 0x2;
      QLog.i("Q.lebatab.LebaRedTouchBase", 1, "onPause update" + zjq.cdv);
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        ((acks)((QQAppInterface)localAppRuntime).getBusinessHandler(87)).notifyUI(4, true, null);
      }
      this.ay.clear();
      this.lx.clear();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.i("Q.lebatab.LebaRedTouchBase", 1, "onPause", localException);
      }
    }
  }
  
  public int yj()
  {
    if (this.a != null) {
      return this.a.ddO;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aimo
 * JD-Core Version:    0.7.0.1
 */