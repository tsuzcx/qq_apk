import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;

public class kkm
{
  public static void a(Context paramContext, AdData paramAdData)
  {
    if (kmx.a(paramAdData))
    {
      ods.cn(paramContext);
      String str1 = paramAdData.a.detailUrl;
      if (!TextUtils.isEmpty(paramAdData.a.activityUrl)) {
        str1 = paramAdData.a.activityUrl;
      }
      String str2 = str1;
      if (TextUtils.isEmpty(str1))
      {
        str2 = str1;
        if (!TextUtils.isEmpty(paramAdData.alE)) {
          str2 = paramAdData.alE;
        }
      }
      kxm.C(paramContext, ods.fr(str2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kkm
 * JD-Core Version:    0.7.0.1
 */