import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import java.net.URLEncoder;
import org.json.JSONObject;

public class yya
{
  public static String a(int paramInt)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("pp", String.valueOf(paramInt));
      ((JSONObject)localObject).put("ps", String.valueOf(1));
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static String a(long paramLong1, long paramLong2, boolean paramBoolean, int paramInt)
  {
    int k = 1;
    int i;
    if ((paramLong1 >= 0L) && (paramLong2 == 0L)) {
      i = 4;
    }
    for (;;)
    {
      long l = paramLong1;
      if (paramLong1 <= -1L)
      {
        i = 4;
        l = 0L;
      }
      if (l >= paramLong2) {
        i = 4;
      }
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("bt", l + "");
        ((JSONObject)localObject).put("et", paramLong2 + "");
        StringBuilder localStringBuilder = new StringBuilder();
        if (l > 0L)
        {
          j = 0;
          ((JSONObject)localObject).put("bf", j + "");
          localStringBuilder = new StringBuilder();
          if (!paramBoolean) {
            break label249;
          }
        }
        label249:
        for (int j = k;; j = 0)
        {
          ((JSONObject)localObject).put("ef", j + "");
          ((JSONObject)localObject).put("pp", String.valueOf(paramInt));
          ((JSONObject)localObject).put("pa", i + "");
          localObject = ((JSONObject)localObject).toString();
          return localObject;
          j = 1;
          break;
        }
        i = 0;
      }
      catch (Exception localException)
      {
        return null;
      }
    }
  }
  
  public static void a(GdtAd paramGdtAd, String paramString)
  {
    if ((paramGdtAd == null) || (TextUtils.isEmpty(paramGdtAd.getUrlForImpression()))) {
      return;
    }
    a(paramGdtAd.getUrlForImpression(), paramString);
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    yyb.a(paramString);
  }
  
  private static void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      yyb.a(paramString1);
      return;
      paramString1 = paramString1 + "&" + "video" + "=" + URLEncoder.encode(paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yya
 * JD-Core Version:    0.7.0.1
 */