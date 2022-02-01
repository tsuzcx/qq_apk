import android.text.TextUtils;
import org.json.JSONObject;

public class aemm
{
  private String bzC = "";
  private String bzD = "";
  private String bzE = "";
  private String bzF = "";
  private boolean enable;
  private int showCount;
  
  public static aemm a(String paramString)
  {
    boolean bool = true;
    if (paramString == null) {
      return null;
    }
    try
    {
      aemm localaemm = new aemm();
      paramString = new JSONObject(paramString);
      if (paramString.optInt("enable", 0) == 1) {}
      for (;;)
      {
        localaemm.enable = bool;
        localaemm.showCount = paramString.optInt("showCount", 0);
        localaemm.bzC = paramString.optString("c2cTipsContent", "");
        localaemm.bzD = paramString.optString("c2cHighlightContent", "");
        localaemm.bzE = paramString.optString("groupTipsContent", "");
        localaemm.bzF = paramString.optString("groupHighlightContent", "");
        return localaemm;
        bool = false;
      }
      return null;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public int Cr()
  {
    return this.showCount;
  }
  
  public boolean isEnable()
  {
    return this.enable;
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.enable = paramBoolean;
  }
  
  public String tA()
  {
    if (TextUtils.isEmpty(this.bzE)) {
      return "想及时收到对方的回复，快去打开消息推送设置吧。";
    }
    return this.bzE;
  }
  
  public String tB()
  {
    if (TextUtils.isEmpty(this.bzF)) {
      return "打开消息推送";
    }
    return this.bzF;
  }
  
  public String ty()
  {
    if (TextUtils.isEmpty(this.bzC)) {
      return "想及时收到对方的回复，快去打开消息推送设置吧。";
    }
    return this.bzC;
  }
  
  public String tz()
  {
    if (TextUtils.isEmpty(this.bzD)) {
      return "打开消息推送";
    }
    return this.bzD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aemm
 * JD-Core Version:    0.7.0.1
 */