import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class avcm
{
  private static final int ewo = new Random().nextInt(1000) + 1;
  private static final ConcurrentHashMap<Integer, avcm.a> jU = new ConcurrentHashMap();
  
  public static avcm.a a(int paramInt)
  {
    return (avcm.a)jU.get(Integer.valueOf(paramInt));
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, int paramInt5, String... paramVarArgs)
  {
    int i = 0;
    if ((paramInt1 != 0) && (ewo > 1)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1 + "|");
    localStringBuilder.append(paramInt2 + "|");
    localStringBuilder.append(paramInt3 + "|");
    localStringBuilder.append(paramInt4 + "|");
    localStringBuilder.append(paramString + "|");
    localStringBuilder.append(paramInt5);
    paramString = new String[6];
    System.arraycopy(paramVarArgs, 0, paramString, 0, Math.min(6, paramVarArgs.length));
    paramInt1 = i;
    if (paramInt1 < paramString.length)
    {
      if (paramString[paramInt1] == null) {
        localStringBuilder.append("|");
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        localStringBuilder.append("|" + paramString[paramInt1]);
      }
    }
    if ((paramAppRuntime instanceof QQAppInterface)) {}
    for (paramAppRuntime = (QQAppInterface)paramAppRuntime;; paramAppRuntime = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloadReportUtils", 2, "preload: " + localStringBuilder.toString());
      }
      annx.b(paramAppRuntime, "sendtdbank|b_sng_qqvip_qqcomic|preload", localStringBuilder.toString(), true);
      return;
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, String... paramVarArgs)
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1 + "|");
    localStringBuilder.append(paramInt2 + "|");
    localStringBuilder.append(paramInt3 + "|");
    localStringBuilder.append(paramInt4 + "|");
    localStringBuilder.append(paramString);
    paramString = new String[6];
    System.arraycopy(paramVarArgs, 0, paramString, 0, Math.min(6, paramVarArgs.length));
    paramInt1 = i;
    if (paramInt1 < paramString.length)
    {
      if (paramString[paramInt1] == null) {
        localStringBuilder.append("|");
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        localStringBuilder.append("|" + paramString[paramInt1]);
      }
    }
    if ((paramAppRuntime instanceof QQAppInterface)) {}
    for (paramAppRuntime = (QQAppInterface)paramAppRuntime;; paramAppRuntime = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloadReportUtils", 2, "hitrate: " + localStringBuilder.toString());
      }
      annx.b(paramAppRuntime, "sendtdbank|b_sng_qqvip_qqcomic|preloadhitrate", localStringBuilder.toString(), true);
      return;
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2, int paramInt3, long paramLong, String... paramVarArgs)
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1 + "|");
    localStringBuilder.append(paramInt2 + "|");
    localStringBuilder.append(paramInt3 + "|");
    localStringBuilder.append(paramLong);
    String[] arrayOfString = new String[6];
    System.arraycopy(paramVarArgs, 0, arrayOfString, 0, Math.min(6, paramVarArgs.length));
    paramInt1 = i;
    if (paramInt1 < arrayOfString.length)
    {
      if (arrayOfString[paramInt1] == null) {
        localStringBuilder.append("|");
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        localStringBuilder.append("|" + arrayOfString[paramInt1]);
      }
    }
    if ((paramAppRuntime instanceof QQAppInterface)) {}
    for (paramAppRuntime = (QQAppInterface)paramAppRuntime;; paramAppRuntime = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloadReportUtils", 2, "procbekilled: " + localStringBuilder.toString());
      }
      annx.b(paramAppRuntime, "sendtdbank|b_sng_qqvip_qqcomic|procbekilled", localStringBuilder.toString(), true);
      return;
    }
  }
  
  public static class a
  {
    public ahyh a;
    private final int cdu;
    private boolean dmd;
    private boolean dme;
    private final int ewp;
    private int ewq = 0;
    private String mEnv;
    private int mStrategyId;
    
    public a(int paramInt1, int paramInt2)
    {
      this.cdu = paramInt1;
      this.ewp = paramInt2;
      reset();
    }
    
    private void end()
    {
      if (!this.dmd) {
        return;
      }
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if (this.dme) {}
      for (int i = 0;; i = 1)
      {
        avcm.a(localAppRuntime, i, this.cdu, this.ewp, this.ewq, this.mEnv, new String[] { String.valueOf(this.mStrategyId) });
        reset();
        return;
      }
    }
    
    private void reset()
    {
      this.dmd = false;
      this.dme = false;
      this.ewq = 0;
      this.mEnv = null;
      this.mStrategyId = 0;
    }
    
    public void ad(int paramInt1, String paramString, int paramInt2)
    {
      a locala = (a)avcm.jU.get(Integer.valueOf(this.cdu));
      if ((locala != null) && (locala.dmd)) {
        locala.end();
      }
      this.dmd = true;
      this.ewq = paramInt1;
      this.mEnv = paramString;
      this.mStrategyId = paramInt2;
      avcm.jU.put(Integer.valueOf(this.cdu), this);
    }
    
    public void dqV()
    {
      if (!this.dmd) {
        return;
      }
      this.dme = true;
      end();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avcm
 * JD-Core Version:    0.7.0.1
 */