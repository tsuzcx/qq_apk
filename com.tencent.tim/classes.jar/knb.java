import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusInnerData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class knb
{
  private static String TAG = "ReadInJoyAdInnerUtils";
  
  public static String A(String paramString, int paramInt)
  {
    int i = 0;
    int j = 0;
    for (;;)
    {
      String str1 = paramString;
      for (;;)
      {
        try
        {
          if (j < paramString.length())
          {
            if (String.valueOf(paramString.charAt(j)).getBytes().length != 1) {
              continue;
            }
            i += 1;
            if ((j >= paramString.length() - 1) || (i < paramInt)) {
              continue;
            }
            str1 = paramString.substring(0, j) + "...";
          }
        }
        catch (Exception localException)
        {
          String str2 = paramString;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("ReadInJoyAdUtils", 2, "getTitle error");
        }
        return str1;
        i += 2;
      }
      j += 1;
    }
    return paramString;
  }
  
  public static JSONObject a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)) && (TextUtils.isEmpty(paramString3)))
    {
      QLog.e("ReadInJoyAdUtils", 2, "getBusinessJson error articleId123:" + paramString1 + " tag:" + paramString2 + " cashInfo:" + paramString3);
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (!TextUtils.isEmpty(paramString1)) {
        localJSONObject.put("article_id", paramString1);
      }
      if (!TextUtils.isEmpty(paramString3)) {
        localJSONObject.put("cash_tag", paramString3);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        localJSONObject.put("tags", paramString2);
      }
      return localJSONObject;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public static JSONObject a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    if (paramJSONObject2 == null) {}
    for (;;)
    {
      return paramJSONObject1;
      try
      {
        if (paramJSONObject2.has("article_id")) {
          paramJSONObject1.put("article_id", paramJSONObject2.get("article_id"));
        }
        if (paramJSONObject2.has("tags")) {
          paramJSONObject1.put("tags", paramJSONObject2.get("tags"));
        }
        if (paramJSONObject2.has("cash_tag")) {
          paramJSONObject1.put("cash_tag", paramJSONObject2.get("cash_tag"));
        }
        if (paramJSONObject2.has("message")) {
          paramJSONObject1.put("message", paramJSONObject2.get("message"));
        }
        if (paramJSONObject2.has("rowkey"))
        {
          paramJSONObject1.put("rowkey", paramJSONObject2.get("rowkey"));
          return paramJSONObject1;
        }
      }
      catch (Exception paramJSONObject2)
      {
        paramJSONObject2.printStackTrace();
      }
    }
    return paramJSONObject1;
  }
  
  public static void a(ProteusInnerData paramProteusInnerData, int paramInt)
  {
    if (paramProteusInnerData == null) {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 1, "doClickReport adData null");
      }
    }
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 1, "doClickReport");
      }
      localQQAppInterface = (QQAppInterface)kxm.getAppRuntime();
    } while (localQQAppInterface == null);
    jzk.a(new kku.a().a(localQQAppInterface).a(BaseApplication.getContext()).a(jzk.aEJ).b(jzk.aFH).a(kne.a(paramProteusInnerData)).d(paramInt).d(jzk.a(paramProteusInnerData)).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     knb
 * JD-Core Version:    0.7.0.1
 */