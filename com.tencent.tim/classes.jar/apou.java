import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0xe0a.cmd0xe0a.App;

public class apou
{
  private String app_icon;
  private String app_name;
  private long aqz;
  private String cmX;
  private int dVe;
  private int dVf = 0;
  private int dVg = -1;
  
  public static apou a(String paramString1, String paramString2)
  {
    apou localapou = new apou();
    localapou.aqz = 999L;
    localapou.app_name = paramString1;
    localapou.app_icon = paramString2;
    localapou.cmX = "local";
    localapou.dVe = 0;
    return localapou;
  }
  
  public static apou a(cmd0xe0a.App paramApp)
  {
    if (paramApp != null)
    {
      apou localapou = new apou();
      localapou.aqz = paramApp.appid.get();
      localapou.app_name = paramApp.name.get();
      localapou.app_icon = paramApp.icon.get();
      localapou.cmX = paramApp.url.get();
      localapou.dVe = paramApp.disabled.get();
      if (paramApp.default_disabled.has()) {
        localapou.dVg = paramApp.default_disabled.get();
      }
      return localapou;
    }
    return null;
  }
  
  public String Bv()
  {
    return this.app_icon;
  }
  
  public int LA()
  {
    return this.dVf;
  }
  
  public int LB()
  {
    return this.dVg;
  }
  
  public int Lz()
  {
    return this.dVe;
  }
  
  public void WS(int paramInt)
  {
    this.dVe = paramInt;
  }
  
  public void WT(int paramInt)
  {
    this.dVf = paramInt;
  }
  
  public String getAppName()
  {
    return this.app_name;
  }
  
  public long hw()
  {
    return this.aqz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apou
 * JD-Core Version:    0.7.0.1
 */