import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;

public class aqqi
{
  private static HashMap<Integer, String> pc = new HashMap();
  public static HashMap<String, aqqi.b> pd;
  public ArrayList<Object> CU;
  public ArrayList<Object> CV;
  public ArrayList<Object> CW;
  public aqqi.a a;
  public String cvd;
  public String cve;
  
  static
  {
    pc.put(Integer.valueOf(100001), "emoji");
    pc.put(Integer.valueOf(100003), "bubble");
    pc.put(Integer.valueOf(100002), "theme");
    pc.put(Integer.valueOf(100011), "font");
    pc.put(Integer.valueOf(100006), "pendant");
    pc.put(Integer.valueOf(100012), "card");
    pc.put(Integer.valueOf(100019), "call");
    pc.put(Integer.valueOf(100020), "suit");
    pc.put(Integer.valueOf(100021), "background");
    pc.put(Integer.valueOf(100018), "ring");
    pc.put(Integer.valueOf(100028), "hongbao");
    pd = new HashMap();
    pd.put("1", new aqqi.b(2, true, 1, 1));
    pd.put("2", new aqqi.b(2, false, 1, 2));
    pd.put("3", new aqqi.b(3, true, 2, 3));
    pd.put("4", new aqqi.b(3, true, 1, 4));
    pd.put("5", new aqqi.b(3, true, 1, 5));
  }
  
  public static boolean bV(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return false;
      paramString1 = paramString1.split("\\.");
      paramString2 = paramString2.split("\\.");
    } while ((paramString1 == null) || (paramString2 == null));
    int m = Math.max(paramString1.length, paramString2.length);
    int k = 0;
    label50:
    if (k < m) {
      if (k >= paramString1.length) {
        break label150;
      }
    }
    for (;;)
    {
      try
      {
        i = Integer.parseInt(paramString1[k]);
        if (k >= paramString2.length) {
          break label145;
        }
      }
      catch (Exception localException1)
      {
        try
        {
          j = Integer.parseInt(paramString2[k]);
          if (k == m - 1) {
            break label131;
          }
          if (j > i)
          {
            return true;
            localException1 = localException1;
            i = 0;
          }
        }
        catch (Exception localException2)
        {
          j = 0;
          continue;
        }
      }
      if (j < i) {
        break;
      }
      label131:
      do
      {
        k += 1;
        break label50;
        break;
        if (j >= i) {
          return true;
        }
      } while (j >= i);
      return false;
      label145:
      int j = 0;
      continue;
      label150:
      int i = 0;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IndividuationConfigInfo: ").append("backgroudImgUrl=").append(this.cvd).append("\r\n").append("pullBgColor=").append(this.cve).append("\r\n").append("bannerConfig=").append(this.a).append("\r\n").append("activityConfigs=").append(this.CU).append("\r\n").append("recommendConfigs=").append(this.CV).append("\r\n").append("shapedImgConfigs=").append(this.CW);
    return localStringBuilder.toString();
  }
  
  public static class a
  {
    public String cvd;
    public String cvf;
    public String linkUrl;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("BannerConfig: ").append("backgroudImgUrl=").append(this.cvd).append(";").append("cornerMarkLevel=").append(this.cvf).append(";").append("linkUrl=").append(this.linkUrl);
      return localStringBuilder.toString();
    }
  }
  
  public static class b
  {
    public boolean cVG;
    public int ebI;
    public int ebJ;
    public int style;
    
    public b(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
    {
      this.ebI = paramInt1;
      this.cVG = paramBoolean;
      this.ebJ = paramInt2;
      this.style = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqqi
 * JD-Core Version:    0.7.0.1
 */