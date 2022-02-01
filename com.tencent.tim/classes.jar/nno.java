import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.NativeAd.fragment.ReadInJoyNativeAdFragment;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerBigPicItemData;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerTriplePicItemData;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusInnerData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RecommendAdData;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class nno
{
  private static auug a;
  
  public static void a(Activity paramActivity, AdData paramAdData)
  {
    if (paramAdData.atj) {
      u(paramActivity, paramAdData.alG);
    }
    for (;;)
    {
      paramActivity = (QQAppInterface)kxm.getAppRuntime();
      if (paramActivity != null) {
        jzk.c(paramActivity, paramAdData);
      }
      return;
      if (paramAdData.productType == 12) {
        o(paramActivity, paramAdData.pkgName, paramAdData.jumpUrl);
      } else {
        aQ(paramActivity, paramAdData.jumpUrl);
      }
    }
  }
  
  public static void a(BaseData paramBaseData, View paramView, Context paramContext)
  {
    Object localObject;
    if ((paramBaseData != null) && ((paramBaseData.type == 10) || (paramBaseData.type == 17) || (paramBaseData.type == 22) || (paramBaseData.type == 24) || (paramBaseData.type == 9)))
    {
      if (paramBaseData.type != 17) {
        break label147;
      }
      localObject = (ProteusBannerVideoItemData)paramBaseData;
    }
    for (;;)
    {
      if (a == null) {
        a = new auug((Activity)paramContext);
      }
      if (!a.hasInit()) {
        a.initPopupWindow();
      }
      paramBaseData = new nnp(paramContext, paramBaseData, (AdData)localObject);
      if (a.a(0, ((AdData)localObject).mDislikeInfos))
      {
        a.a(paramView, paramBaseData);
        a.a(new nnq(paramContext, (AdData)localObject));
      }
      return;
      label147:
      if (paramBaseData.type == 10) {
        localObject = (ProteusBannerBigPicItemData)paramBaseData;
      } else if (paramBaseData.type == 24) {
        localObject = (ProteusBannerTriplePicItemData)paramBaseData;
      } else if (paramBaseData.type == 9) {
        localObject = (RecommendAdData)paramBaseData;
      } else {
        localObject = (ProteusInnerData)paramBaseData;
      }
    }
  }
  
  public static void aQ(Context paramContext, String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (aqiw.isWifiConnected(paramContext)) {
        str = paramString + "&acttype=42";
      }
    }
    kxm.aJ(paramContext, str);
  }
  
  public static void aZz()
  {
    if ((a != null) && (a.isShowing())) {
      a.dismiss();
    }
    a = null;
  }
  
  public static void o(Context paramContext, String paramString1, String paramString2)
  {
    String str = paramString2;
    if (!TextUtils.isEmpty(paramString2)) {
      if (!paramString2.contains("?")) {
        break label70;
      }
    }
    label70:
    for (str = paramString2 + "?"; jzk.C(paramContext, paramString1); str = paramString2 + "&")
    {
      kxm.aJ(paramContext, str + "_wv=33554437");
      return;
    }
    aQ(paramContext, str + "_wv=1");
  }
  
  public static void u(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("param_ad_json", paramString);
    PublicTransFragmentActivity.start(paramActivity, localIntent, ReadInJoyNativeAdFragment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nno
 * JD-Core Version:    0.7.0.1
 */