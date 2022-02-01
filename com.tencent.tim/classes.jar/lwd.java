import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class lwd
{
  public static void a(nce.a parama, BaseArticleInfo paramBaseArticleInfo)
  {
    if ((!(paramBaseArticleInfo instanceof ArticleInfo)) || (parama == null)) {}
    for (;;)
    {
      return;
      if (!luy.Y(paramBaseArticleInfo)) {
        continue;
      }
      try
      {
        paramBaseArticleInfo = new JSONObject(paramBaseArticleInfo.proteusItemsData);
        if (paramBaseArticleInfo.optJSONObject("card_report_params") == null) {
          continue;
        }
        paramBaseArticleInfo = paramBaseArticleInfo.getJSONObject("card_report_params");
        Iterator localIterator = paramBaseArticleInfo.keys();
        while (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          String str2 = paramBaseArticleInfo.optString(str1);
          if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
            parama.a(str1, str2);
          }
        }
        return;
      }
      catch (JSONException parama)
      {
        QLog.e("RIJReport", 1, "[addPtsCardReportToR5], e = " + parama);
      }
    }
  }
  
  public static String k(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return null;
    }
    String str1 = kxm.f(paramArticleInfo);
    JSONObject localJSONObject = kxm.a(paramArticleInfo.mAlgorithmID, kxm.a(paramArticleInfo), (int)paramArticleInfo.mChannelID, aqiw.isWifiConnected(null), str1, paramArticleInfo.innerUniqueID, kxm.h(paramArticleInfo), 0, kxm.nQ(), paramArticleInfo);
    str1 = localJSONObject.toString();
    try
    {
      paramArticleInfo = new JSONObject(paramArticleInfo.proteusItemsData);
      if (paramArticleInfo.optJSONObject("card_report_params") != null)
      {
        paramArticleInfo = paramArticleInfo.getJSONObject("card_report_params");
        Iterator localIterator = paramArticleInfo.keys();
        while (localIterator.hasNext())
        {
          String str2 = (String)localIterator.next();
          String str3 = paramArticleInfo.optString(str2);
          if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3))) {
            localJSONObject.put(str2, str3);
          }
        }
      }
      return str1;
    }
    catch (JSONException paramArticleInfo)
    {
      QLog.e("RIJReport", 1, "[getR5Json], e = " + paramArticleInfo);
    }
    paramArticleInfo = localJSONObject.toString();
    return paramArticleInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lwd
 * JD-Core Version:    0.7.0.1
 */