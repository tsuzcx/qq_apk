import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class atwy
{
  public long Zs;
  public long Zt;
  public long Zu;
  public long Zv;
  public long Zw;
  public long Zx;
  public long Zy;
  public long Zz;
  public String bHK;
  public String bII;
  public String bIK;
  public String bIL;
  public String bIM;
  public String bIN;
  public String bIO;
  public String bIx;
  public int cYu;
  public int cYv;
  public String strErrMsg;
  public String strMd5;
  public long uFileSize;
  public long uSessionId;
  
  public HashMap<String, String> I()
  {
    HashMap localHashMap = null;
    Object localObject = localHashMap;
    try
    {
      if (this.bIL != null)
      {
        localObject = localHashMap;
        if (this.bIL.length() > 0) {
          localObject = this.bIL.substring(this.bIL.indexOf("://") + 3, this.bIL.lastIndexOf(":"));
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str = this.bIL;
      }
    }
    localHashMap = new HashMap();
    localHashMap.put("param_serverip", String.valueOf(localObject));
    localHashMap.put("param_Server", String.valueOf(localObject));
    localHashMap.put("param_PeerUin", String.valueOf(this.bIM));
    localHashMap.put("param_PeerType", String.valueOf(this.cYu));
    localHashMap.put("param_uuid", String.valueOf(this.bHK));
    localHashMap.put("param_FailCode", Long.toString(this.Zs));
    localHashMap.put("param_fsized", String.valueOf(this.Zy));
    localHashMap.put("param_fsizeo", String.valueOf(this.uFileSize));
    localHashMap.put("param_url", String.valueOf(this.bIL));
    localHashMap.put("param_rspHeader", String.valueOf(this.bIN));
    localHashMap.put("param_retry", String.valueOf(this.cYv));
    localHashMap.put("param_errMsg", String.valueOf(this.strErrMsg));
    localHashMap.put("param_nSessionId", String.valueOf(this.uSessionId));
    localHashMap.put("param_CSDuration", String.valueOf(this.Zu - this.Zt));
    localHashMap.put("param_HttpDuration", String.valueOf(this.Zw - this.Zv));
    localHashMap.put("param_AllDuration", String.valueOf(this.Zx - this.Zt));
    return localHashMap;
  }
  
  public void diC()
  {
    long l2 = System.currentTimeMillis() - this.Zw;
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 0L;
    }
    this.Zx = System.currentTimeMillis();
    HashMap localHashMap = I();
    anpc localanpc = anpc.a(BaseApplication.getContext());
    String str1 = this.bIx;
    String str2 = this.bIK + "Detail";
    if (this.Zs == 0L) {}
    for (boolean bool = true;; bool = false)
    {
      localanpc.collectPerformance(str1, str2, bool, l1, this.Zz, localHashMap, this.bIO);
      return;
    }
  }
  
  public void diD()
  {
    long l2 = System.currentTimeMillis() - this.Zw;
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 0L;
    }
    this.Zx = System.currentTimeMillis();
    HashMap localHashMap = I();
    anpc localanpc = anpc.a(BaseApplication.getContext());
    String str1 = this.bIx;
    String str2 = this.bIK;
    if (this.Zs == 0L) {}
    for (boolean bool = true;; bool = false)
    {
      localanpc.collectPerformance(str1, str2, bool, l1, this.Zz, localHashMap, this.bIO);
      return;
    }
  }
  
  String vq()
  {
    if (this.Zz == 0L) {
      return "0 KB/s";
    }
    long l = this.Zw - this.Zu;
    if (l == 0L) {
      return "0 KB/s";
    }
    float f = (float)(this.Zz / 1024L) / (float)(l / 1000L);
    return f + " KB/s";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atwy
 * JD-Core Version:    0.7.0.1
 */