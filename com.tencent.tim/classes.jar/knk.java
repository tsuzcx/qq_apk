import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.biz.pubaccount.readinjoy.ad.utils.ReadInJoyTelePhoneUtils.1;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.app.AppActivity;
import org.json.JSONObject;

public class knk
{
  public static JSONObject a(int paramInt1, int paramInt2, String paramString, AdvertisementInfo paramAdvertisementInfo)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("perstatus", paramInt1);
      localJSONObject.put("callact", paramInt2);
      localJSONObject.put("callnum", paramString);
      if (paramAdvertisementInfo != null) {
        localJSONObject.put("phone_cmpt_id", String.valueOf(paramAdvertisementInfo.mPhoneComponetId));
      }
      paramString = new JSONObject();
      paramString.put("comp_stat_src", "");
      paramString.put("phone_component_info", localJSONObject.toString());
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramAdvertisementInfo == null) || (paramAdvertisementInfo.mAdRl == null)) {
      return;
    }
    ThreadManager.excute(new ReadInJoyTelePhoneUtils.1(paramAdvertisementInfo, paramContext), 128, null, true);
  }
  
  public static void a(Context paramContext, String paramString, AdvertisementInfo paramAdvertisementInfo)
  {
    if (!(paramContext instanceof AppActivity)) {
      return;
    }
    b(paramContext, paramString, paramAdvertisementInfo);
  }
  
  public static void b(Context paramContext, String paramString, AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramContext == null) {
      return;
    }
    paramContext.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + paramString)));
    jzk.a(new kku.a().a(paramContext).a(jzk.aFg).b(jzk.aFQ).a(paramAdvertisementInfo).e(a(2, 1, paramString, paramAdvertisementInfo)).a());
  }
  
  public static boolean n(AdData paramAdData)
  {
    return (paramAdData != null) && (paramAdData.aZX != 0) && (knc.m(paramAdData));
  }
  
  public static boolean w(AdvertisementInfo paramAdvertisementInfo)
  {
    return (paramAdvertisementInfo != null) && (paramAdvertisementInfo.mPhoneComponetId != 0) && (knc.e(paramAdvertisementInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     knk
 * JD-Core Version:    0.7.0.1
 */