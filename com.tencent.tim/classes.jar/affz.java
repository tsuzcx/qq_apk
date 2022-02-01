import android.os.Bundle;

public final class affz
{
  public static Bundle a(String paramString1, String paramString2, int paramInt, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("cmd", paramString1);
    localBundle.putString("callbackid", paramString2);
    localBundle.putInt("respkey", paramInt);
    localBundle.putBundle("request", paramBundle);
    return localBundle;
  }
  
  public static class a
  {
    public String appid;
    public String bDk;
    public String callbackid;
    public String discountId;
    public String drmInfo;
    public String nr;
    public String other;
    public String payload;
    public String pf;
    public String pfKey;
    public String sessionId;
    public String sessionType;
    public String userId;
    public String zoneId;
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
    {
      this.callbackid = paramString1;
      this.appid = paramString2;
      this.userId = paramString3;
      this.nr = paramString4;
      this.sessionId = paramString5;
      this.sessionType = paramString6;
      this.zoneId = paramString7;
      this.pf = paramString8;
      this.pfKey = paramString9;
      this.bDk = paramString10;
      this.drmInfo = paramString11;
    }
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14)
    {
      this.callbackid = paramString1;
      this.appid = paramString2;
      this.userId = paramString3;
      this.nr = paramString4;
      this.sessionId = paramString5;
      this.sessionType = paramString6;
      this.zoneId = paramString7;
      this.pf = paramString8;
      this.pfKey = paramString9;
      this.bDk = paramString10;
      this.discountId = paramString11;
      this.other = paramString12;
      this.payload = paramString13;
      this.drmInfo = paramString14;
    }
    
    public static a a(Bundle paramBundle)
    {
      String str1 = "";
      String str2 = "";
      String str3 = "";
      String str4 = "";
      String str5 = "";
      String str6 = "";
      String str7 = "";
      String str8 = "";
      String str9 = "";
      String str10 = "";
      String str11 = "";
      String str12 = "";
      String str13 = "";
      String str14 = "";
      if (paramBundle != null)
      {
        str1 = paramBundle.getString("callbackid");
        str2 = paramBundle.getString("appid");
        str3 = paramBundle.getString("userId");
        str4 = paramBundle.getString("userKey");
        str5 = paramBundle.getString("sessionId");
        str6 = paramBundle.getString("sessionType");
        str7 = paramBundle.getString("zoneId");
        str8 = paramBundle.getString("pf");
        str9 = paramBundle.getString("pfKey");
        str10 = paramBundle.getString("tokenUrl");
        str11 = paramBundle.getString("discountId");
        str12 = paramBundle.getString("other");
        str13 = paramBundle.getString("payload");
        str14 = paramBundle.getString("drmInfo");
      }
      return new a(str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14);
    }
    
    public Bundle getBundleData()
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("callbackid", this.callbackid);
      localBundle.putString("appid", this.appid);
      localBundle.putString("userId", this.userId);
      localBundle.putString("userKey", this.nr);
      localBundle.putString("sessionId", this.sessionId);
      localBundle.putString("sessionType", this.sessionType);
      localBundle.putString("zoneId", this.zoneId);
      localBundle.putString("pf", this.pf);
      localBundle.putString("pfKey", this.pfKey);
      localBundle.putString("tokenUrl", this.bDk);
      return localBundle;
    }
  }
  
  public static class b
  {
    public String message = "";
    public int payChannel = -1;
    public int payState = -1;
    public int provideState = -1;
    public int realSaveNum;
    public int result = -1;
    
    public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString)
    {
      this.result = paramInt1;
      this.realSaveNum = paramInt2;
      this.payChannel = paramInt3;
      this.payState = paramInt4;
      this.provideState = paramInt5;
      this.message = paramString;
    }
    
    public static b a(Bundle paramBundle)
    {
      int j = 0;
      int n = -1;
      String str = "";
      int i;
      int k;
      int m;
      if (paramBundle != null)
      {
        i = paramBundle.getInt("result", -1);
        j = paramBundle.getInt("realSaveNum", 0);
        k = paramBundle.getInt("payChannel", -1);
        m = paramBundle.getInt("payState", -1);
        n = paramBundle.getInt("provideState", -1);
      }
      for (paramBundle = paramBundle.getString("message");; paramBundle = str)
      {
        return new b(i, j, k, m, n, paramBundle);
        m = -1;
        k = -1;
        i = -1;
      }
    }
    
    public Bundle getBundleData()
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("result", this.result);
      localBundle.putInt("realSaveNum", this.realSaveNum);
      localBundle.putInt("payChannel", this.payChannel);
      localBundle.putInt("payState", this.payState);
      localBundle.putInt("provideState", this.provideState);
      localBundle.putString("message", this.message);
      return localBundle;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     affz
 * JD-Core Version:    0.7.0.1
 */