import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aele
{
  private static final aele a = new aele();
  private long Wi = 0L;
  private String bzv = "";
  private String guideText = "";
  private boolean visible = false;
  
  public static aele a(aeic[] paramArrayOfaeic)
  {
    Object localObject;
    if (paramArrayOfaeic == null) {
      localObject = a;
    }
    for (;;)
    {
      return localObject;
      try
      {
        aele localaele = new aele();
        int j = paramArrayOfaeic.length;
        int i = 0;
        localObject = localaele;
        if (i >= j) {
          continue;
        }
        localObject = new JSONObject(paramArrayOfaeic[i].content);
        if (((JSONObject)localObject).optInt("visible", 0) == 1) {}
        for (boolean bool = true;; bool = false)
        {
          localaele.visible = bool;
          localaele.guideText = ((JSONObject)localObject).optString("guideText", "");
          localaele.bzv = ((JSONObject)localObject).optString("guideHighlightText", "");
          localaele.Wi = ((JSONObject)localObject).optLong("showIntervalMs", 0L);
          i += 1;
          break;
        }
        return a;
      }
      catch (Exception paramArrayOfaeic)
      {
        QLog.e("NotificationBannerBean", 1, "parse: failed. ", paramArrayOfaeic);
      }
    }
  }
  
  public long ft()
  {
    return this.Wi;
  }
  
  public String tw()
  {
    return this.guideText;
  }
  
  public String tx()
  {
    return this.bzv;
  }
  
  public boolean visible()
  {
    return this.visible;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aele
 * JD-Core Version:    0.7.0.1
 */