import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class aejw
{
  public String aUw = "";
  public String aUx = "";
  public boolean bUy;
  public String byA = "";
  public String byB = "";
  public String byC = "";
  public String byD = "";
  public String byE = "";
  public String byF = "";
  public String byG = "";
  public String byH = "";
  public String byI = "";
  public String byJ = "";
  public String byK = "";
  public String byd = "https://ti.qq.com/hybrid-h5/intimate/list?_wv=83886083";
  public String bye = "https://ti.qq.com/hybrid-h5/intimate/launch?_wv=83886083";
  public String byf = "";
  public String byg = "";
  public String byh = "";
  public String byi = "";
  public String byj = "";
  public String byk = "";
  public String byl = "";
  public String bym = "";
  public String byn = "";
  public String byo = "";
  public String byp = "";
  public String byq = "";
  public String byr = "";
  public String bys = "";
  public String byt = "";
  public String byu = "";
  public String byv = "";
  public String byw = "";
  public String byx = "";
  public String byy = "";
  public String byz = "";
  public int cNB = 80;
  public int cNC = 100;
  public int cND = 80;
  
  public static aejw a(String paramString)
  {
    boolean bool = true;
    if (paramString == null) {
      return null;
    }
    try
    {
      aejw localaejw = new aejw();
      paramString = new JSONObject(paramString);
      if (paramString.optInt("isUpgradeOpen", 0) == 1) {}
      for (;;)
      {
        localaejw.bUy = bool;
        localaejw.byd = paramString.optString("managePageURL", "https://ti.qq.com/hybrid-h5/intimate/list?_wv=83886083");
        if (TextUtils.isEmpty(localaejw.byd)) {
          localaejw.byd = "https://ti.qq.com/hybrid-h5/intimate/list?_wv=83886083";
        }
        localaejw.bye = paramString.optString("bindPageURL", "https://ti.qq.com/hybrid-h5/intimate/launch?_wv=83886083");
        if (TextUtils.isEmpty(localaejw.bye)) {
          localaejw.bye = "https://ti.qq.com/hybrid-h5/intimate/launch?_wv=83886083";
        }
        Object localObject;
        JSONArray localJSONArray;
        if (paramString.has("bgImg"))
        {
          localObject = paramString.optJSONObject("bgImg");
          if ((localObject != null) && (((JSONObject)localObject).has("relationNo")))
          {
            localJSONArray = ((JSONObject)localObject).optJSONArray("relationNo");
            if ((localJSONArray != null) && (localJSONArray.length() > 0)) {
              localaejw.byf = localJSONArray.getString(0);
            }
          }
          if ((localObject != null) && (((JSONObject)localObject).has("relationGuimi")))
          {
            localJSONArray = ((JSONObject)localObject).optJSONArray("relationGuimi");
            if ((localJSONArray != null) && (localJSONArray.length() > 2))
            {
              localaejw.byg = localJSONArray.getString(0);
              localaejw.byh = localJSONArray.getString(1);
              localaejw.byi = localJSONArray.getString(2);
            }
          }
          if ((localObject != null) && (((JSONObject)localObject).has("relationJiyou")))
          {
            localJSONArray = ((JSONObject)localObject).optJSONArray("relationJiyou");
            if ((localJSONArray != null) && (localJSONArray.length() > 2))
            {
              localaejw.byj = localJSONArray.getString(0);
              localaejw.byk = localJSONArray.getString(1);
              localaejw.byl = localJSONArray.getString(2);
            }
          }
          if ((localObject != null) && (((JSONObject)localObject).has("relationLover")))
          {
            localObject = ((JSONObject)localObject).optJSONArray("relationLover");
            if ((localObject != null) && (((JSONArray)localObject).length() > 2))
            {
              localaejw.bym = ((JSONArray)localObject).getString(0);
              localaejw.byn = ((JSONArray)localObject).getString(1);
              localaejw.byo = ((JSONArray)localObject).getString(2);
            }
          }
        }
        if (paramString.has("darkBgImg"))
        {
          localObject = paramString.optJSONObject("darkBgImg");
          if ((localObject != null) && (((JSONObject)localObject).has("relationGuimi")))
          {
            localJSONArray = ((JSONObject)localObject).optJSONArray("relationGuimi");
            if ((localJSONArray != null) && (localJSONArray.length() > 2))
            {
              localaejw.byp = localJSONArray.getString(0);
              localaejw.byq = localJSONArray.getString(1);
              localaejw.byr = localJSONArray.getString(2);
            }
          }
          if ((localObject != null) && (((JSONObject)localObject).has("relationJiyou")))
          {
            localJSONArray = ((JSONObject)localObject).optJSONArray("relationJiyou");
            if ((localJSONArray != null) && (localJSONArray.length() > 2))
            {
              localaejw.bys = localJSONArray.getString(0);
              localaejw.byt = localJSONArray.getString(1);
              localaejw.byu = localJSONArray.getString(2);
            }
          }
          if ((localObject != null) && (((JSONObject)localObject).has("relationLover")))
          {
            localObject = ((JSONObject)localObject).optJSONArray("relationLover");
            if ((localObject != null) && (((JSONArray)localObject).length() > 2))
            {
              localaejw.byv = ((JSONArray)localObject).getString(0);
              localaejw.byw = ((JSONArray)localObject).getString(1);
              localaejw.byx = ((JSONArray)localObject).getString(2);
            }
          }
        }
        if (paramString.has("shareImg"))
        {
          localObject = paramString.optJSONObject("shareImg");
          if ((localObject != null) && (((JSONObject)localObject).has("relationNo")))
          {
            localJSONArray = ((JSONObject)localObject).optJSONArray("relationNo");
            if ((localJSONArray != null) && (localJSONArray.length() > 0)) {
              localaejw.byy = localJSONArray.getString(0);
            }
          }
          if ((localObject != null) && (((JSONObject)localObject).has("relationGuimi")))
          {
            localJSONArray = ((JSONObject)localObject).optJSONArray("relationGuimi");
            if ((localJSONArray != null) && (localJSONArray.length() > 2))
            {
              localaejw.byz = localJSONArray.getString(0);
              localaejw.byA = localJSONArray.getString(1);
              localaejw.byB = localJSONArray.getString(2);
            }
          }
          if ((localObject != null) && (((JSONObject)localObject).has("relationJiyou")))
          {
            localJSONArray = ((JSONObject)localObject).optJSONArray("relationJiyou");
            if ((localJSONArray != null) && (localJSONArray.length() > 2))
            {
              localaejw.byC = localJSONArray.getString(0);
              localaejw.byD = localJSONArray.getString(1);
              localaejw.byE = localJSONArray.getString(2);
            }
          }
          if ((localObject != null) && (((JSONObject)localObject).has("relationLover")))
          {
            localObject = ((JSONObject)localObject).optJSONArray("relationLover");
            if ((localObject != null) && (((JSONArray)localObject).length() > 2))
            {
              localaejw.byF = ((JSONArray)localObject).getString(0);
              localaejw.byG = ((JSONArray)localObject).getString(1);
              localaejw.byH = ((JSONArray)localObject).getString(2);
            }
          }
        }
        if (paramString.has("scoreAnimation")) {
          localaejw.byI = paramString.optString("scoreAnimation");
        }
        if (paramString.has("scoreAnimationMd5")) {
          localaejw.byJ = paramString.optString("scoreAnimationMd5");
        }
        if (paramString.has("scoreRuleURL")) {
          localaejw.byK = paramString.optString("scoreRuleURL");
        }
        if (paramString.has("scoreDisplayIntimateMin")) {
          localaejw.cNB = paramString.optInt("scoreDisplayIntimateMin");
        }
        if (paramString.has("scoreDisplayFriendMin")) {
          localaejw.cNC = paramString.optInt("scoreDisplayFriendMin");
        }
        if (paramString.has("scoreDisplayFriendMin818")) {
          localaejw.cND = paramString.optInt("scoreDisplayFriendMin818");
        }
        localaejw.aUw = paramString.optString("gifNormalUrl");
        localaejw.aUx = paramString.optString("gifNightUrl");
        return localaejw;
        bool = false;
      }
      return null;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FriendIntimateRelationshipBean isUpgradeOpen:").append(this.bUy).append(" managePageURL:").append(this.byd).append(" bindPageURL:").append(this.bye).append(" relationNoBgUrl:").append(this.byf).append(" relationGuimiBg0Url:").append(this.byg).append(" relationGuimiBg1Url:").append(this.byh).append(" relationGuimiBg2Url:").append(this.byi).append(" relationJiyouBg0Url:").append(this.byj).append(" relationJiyouBg1Url:").append(this.byk).append(" relationJiyouBg2Url:").append(this.byl).append(" relationLoverBg0Url:").append(this.bym).append(" relationLoverBg1Url:").append(this.byn).append(" relationLoverBg2Url:").append(this.byo).append(" relationGuimiDarkBg0Url:").append(this.byp).append(" relationGuimiDarkBg1Url:").append(this.byq).append(" relationGuimiDarkBg2Url:").append(this.byr).append(" relationJiyouDarkBg0Url:").append(this.bys).append(" relationJiyouDarkBg1Url:").append(this.byt).append(" relationJiyouDarkBg2Url:").append(this.byu).append(" relationLoverDarkBg0Url:").append(this.byv).append(" relationLoverDarkBg1Url:").append(this.byw).append(" relationLoverDarkBg2Url:").append(this.byx).append(" relationNoShareUrl:").append(this.byy).append(" relationGuimiShare0Url:").append(this.byz).append(" relationGuimiShare1Url:").append(this.byA).append(" relationGuimiShare2Url:").append(this.byB).append(" relationJiyouShare0Url:").append(this.byC).append(" relationJiyouShare1Url:").append(this.byD).append(" relationJiyouShare2Url:").append(this.byE).append(" relationLoverShare0Url:").append(this.byF).append(" relationLoverShare1Url:").append(this.byG).append(" relationLoverShare2Url:").append(this.byH).append(" gifNormalUrl:").append(this.aUw).append(" gifNightUrl:").append(this.aUx);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aejw
 * JD-Core Version:    0.7.0.1
 */