import android.os.Build;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class ikx
  extends iku
{
  private static int aoo = -1;
  static long lC = 30000L;
  long lB = 0L;
  
  public ikx(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  public static boolean b(VideoAppInterface paramVideoAppInterface)
  {
    return ((ikt)paramVideoAppInterface.a(5)).d(2, "ptu_so");
  }
  
  private boolean tJ()
  {
    if (tK()) {}
    do
    {
      return true;
      if (this.sdkVersion < 17)
      {
        igd.aJ("SupportPendant", "isUserEffectFace error  OSversion:" + this.sdkVersion);
        return false;
      }
      if (this.aoj < 4)
      {
        igd.aJ("SupportPendant", "isUserEffectFace error cpucount:" + this.aoj);
        return false;
      }
      if ((this.lz != 0L) && (this.lz < 1400000L))
      {
        igd.aJ("SupportPendant", "isUserEffectFace error cpuFrequency:" + this.lz);
        return false;
      }
    } while (this.lA >= 1073741824L);
    igd.aJ("SupportPendant", "isUserEffectFace error  memory:" + this.lA);
    return false;
  }
  
  private static boolean tK()
  {
    String str = Build.MODEL;
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return str.equals("MI 5");
  }
  
  public static boolean tM()
  {
    return aoo == 1;
  }
  
  public int an(String paramString)
  {
    return 0;
  }
  
  public void anD() {}
  
  public boolean ct(String paramString)
  {
    if ("ptu_so".equalsIgnoreCase(paramString)) {
      return tL();
    }
    return tJ();
  }
  
  public boolean e(int paramInt, String paramString)
  {
    return false;
  }
  
  public void restore() {}
  
  public boolean tL()
  {
    if (aoo != 1)
    {
      if (ankq.by(BaseApplicationImpl.getContext())) {
        break label138;
      }
      long l1 = System.currentTimeMillis();
      if (l1 <= this.lB) {
        break label121;
      }
      long l2 = AudioHelper.elapsedRealtimeNanos();
      if (!this.mApp.sP()) {
        break label114;
      }
      aoo = 1;
      long l3 = AudioHelper.elapsedRealtimeNanos();
      QLog.w("SupportPendant", 1, "isDownloadedPTUSO, isFilterSoDownLoadSuc[" + aoo + "], cost[" + (l3 - l2) + "]");
      this.lB = (l1 + lC);
    }
    label138:
    for (;;)
    {
      if (aoo != 1) {
        break label145;
      }
      return true;
      label114:
      aoo = 0;
      break;
      label121:
      if (QLog.isDevelopLevel())
      {
        QLog.w("SupportPendant", 1, "isDownloadedPTUSO, 频繁调用");
        continue;
        aoo = 1;
      }
    }
    label145:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ikx
 * JD-Core Version:    0.7.0.1
 */