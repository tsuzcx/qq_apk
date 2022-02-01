import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusInnerData;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInjoyHeaderAdDownloadView.SimpleRoundProgress;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class kjz
{
  public static int a(Context paramContext, AdvertisementInfo paramAdvertisementInfo)
  {
    int j = 2;
    int i;
    if ((TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.aax)) && (!TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.aaw)))
    {
      i = 1;
      if (a(paramContext, paramAdvertisementInfo)) {
        return 1;
      }
    }
    else
    {
      i = 2;
    }
    if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.aax)) {
      j = 0;
    }
    for (;;)
    {
      return j;
      if (TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.jmpUrl)) {
        j = i;
      }
    }
  }
  
  public static int a(ViewBase paramViewBase, BaseData paramBaseData)
  {
    int j = 0;
    boolean bool = false;
    int i = j;
    if ((paramViewBase instanceof kox))
    {
      i = j;
      if ((paramBaseData instanceof AdData))
      {
        i = ((kox)paramViewBase).getDownloadState();
        j = ((AdData)paramBaseData).downloadState;
        if (i == 4) {
          bool = true;
        }
        i = i(j, bool);
      }
    }
    return i;
  }
  
  public static JSONObject a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i = 1;
    if (paramAdvertisementInfo == null) {
      return new JSONObject();
    }
    if (paramAdvertisementInfo.mAdvertisementSoftInfo.sourceId == 0) {}
    for (;;)
    {
      int j = a(paramContext, paramAdvertisementInfo);
      paramContext = new JSONObject();
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("source_id", paramAdvertisementInfo.mAdvertisementSoftInfo.sourceId);
        localJSONObject.put("platform_id", paramAdvertisementInfo.mAdvertisementSoftInfo.aJL);
        localJSONObject.put("goods_type", paramAdvertisementInfo.mAdvertisementSoftInfo.goodsType);
        localJSONObject.put("goods_id", paramAdvertisementInfo.mAdvertisementSoftInfo.aay);
        localJSONObject.put("goods_name", paramAdvertisementInfo.mAdvertisementSoftInfo.goodsName);
        localJSONObject.put("account_id", paramAdvertisementInfo.mAdvertisementSoftInfo.accountId);
        localJSONObject.put("content_type", 1);
        localJSONObject.put("rowkey", paramAdvertisementInfo.mRowKey);
        localJSONObject.put("cmsid", paramAdvertisementInfo.mAdvertisementSoftInfo.aaL);
        if (paramInt3 != -1) {
          localJSONObject.put("button_state", paramInt3);
        }
        localJSONObject.put("adid", paramAdvertisementInfo.mAdvertisementSoftInfo.WW);
        localJSONObject.put("position", paramInt5);
        localJSONObject.put("card_style", paramInt4);
        if (i != 0) {
          localJSONObject.put("is_ams_reported", 1);
        }
        if (paramInt1 == jzk.aEJ)
        {
          if (paramInt2 != 0) {
            localJSONObject.put("click_pos", paramInt2);
          }
          localJSONObject.put("link_type", j);
          localJSONObject.put("click_type", 3);
          paramContext.put("click_info_report", localJSONObject.toString());
        }
        else
        {
          localJSONObject.put("exposure_type", 3);
          paramContext.put("exposure_info_report", localJSONObject.toString());
        }
      }
      catch (JSONException paramAdvertisementInfo)
      {
        paramAdvertisementInfo.printStackTrace();
      }
      return paramContext;
      i = 0;
    }
  }
  
  public static void a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramAdvertisementInfo == null) || (paramAdvertisementInfo.mAdvertisementSoftInfo == null)) {}
    do
    {
      return;
      if (paramAdvertisementInfo.mAdvertisementSoftInfo.sourceId == 0)
      {
        ods.a(paramActivity, paramAdvertisementInfo, null, 3, true);
        return;
      }
    } while ((TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.aax)) && (!TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.aaw)) && (ods.a(paramAdvertisementInfo.mAdvertisementSoftInfo.aaw, paramActivity)));
    kmx.g(paramActivity, paramAdvertisementInfo.mAdvertisementSoftInfo.jmpUrl, paramAdvertisementInfo.mAdvertisementSoftInfo.aax, "");
  }
  
  public static void a(Context paramContext, ImageView paramImageView, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!TextUtils.isEmpty(paramString)) {
      for (;;)
      {
        try
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mRequestWidth = wja.dp2px(paramInt2, paramContext.getResources());
          localURLDrawableOptions.mRequestHeight = wja.dp2px(paramInt2, paramContext.getResources());
          if (paramInt3 != -1) {
            localURLDrawableOptions.mUseMemoryCache = false;
          }
          localURLDrawable = URLDrawable.getDrawable(new URL(paramString), localURLDrawableOptions);
          localURLDrawable.setTag(aqbn.d(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, wja.dp2px(paramInt1, paramContext.getResources())));
          if (paramInt3 != 0) {
            continue;
          }
          localURLDrawable.setTag(new int[] { 0, 0, paramInt1, 1 });
          localURLDrawable.setDecodeHandler(aqbn.j);
        }
        catch (Exception paramContext)
        {
          URLDrawable localURLDrawable;
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("ReadInJoyCommonAdUtils", 2, "后台下发的url格式有问题：" + paramString);
          return;
          localURLDrawable.setDecodeHandler(aqbn.a);
          continue;
        }
        paramImageView.setImageDrawable(localURLDrawable);
        return;
        if (paramInt3 != 1) {
          continue;
        }
        localURLDrawable.setTag(new int[] { 0, 0, paramInt1, 3 });
        localURLDrawable.setDecodeHandler(aqbn.j);
      }
    }
  }
  
  public static void a(Context paramContext, AdData paramAdData, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AdvertisementInfo localAdvertisementInfo = kne.a(paramAdData);
    localAdvertisementInfo.setClickPos(paramInt2);
    int i = 0;
    if ((paramAdData instanceof ProteusInnerData)) {
      i = ((ProteusInnerData)paramAdData).aJR;
    }
    jzk.a(new kku.a().a(paramContext).a(paramInt1).b(jzk.aFW).e(a(paramContext, localAdvertisementInfo, paramInt1, paramInt2, paramInt3, paramInt4, i)).a(localAdvertisementInfo).d(jzk.a(paramAdData)).a());
  }
  
  public static void a(ReadInjoyHeaderAdDownloadView.SimpleRoundProgress paramSimpleRoundProgress)
  {
    if (paramSimpleRoundProgress != null)
    {
      paramSimpleRoundProgress.aKN = Color.parseColor("#CCE5E5E5");
      paramSimpleRoundProgress.aKO = Color.parseColor("#FF00CAFC");
      paramSimpleRoundProgress.iD = wja.dp2px(1.5F, paramSimpleRoundProgress.getContext().getResources());
      paramSimpleRoundProgress.iE = wja.dp2px(1.5F, paramSimpleRoundProgress.getContext().getResources());
      paramSimpleRoundProgress.iF = wja.dp2px(7.0F, paramSimpleRoundProgress.getContext().getResources());
      paramSimpleRoundProgress.max = 100;
      paramSimpleRoundProgress.aJo = 270;
      paramSimpleRoundProgress.style = 0;
      paramSimpleRoundProgress.progress = 1;
    }
  }
  
  private static boolean a(Context paramContext, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramAdvertisementInfo == null) || (paramAdvertisementInfo.mAdvertisementSoftInfo == null) || (paramAdvertisementInfo.mAdvertisementSoftInfo.aaw == null)) {}
    for (;;)
    {
      return false;
      try
      {
        Intent localIntent = new Intent();
        localIntent.setAction("android.intent.action.VIEW");
        localIntent.setData(Uri.parse(paramAdvertisementInfo.mAdvertisementSoftInfo.aaw));
        paramContext = localIntent.resolveActivityInfo(paramContext.getPackageManager(), 0);
        if (paramContext != null)
        {
          boolean bool = TextUtils.isEmpty(paramContext.packageName);
          if (!bool) {
            return true;
          }
        }
      }
      catch (Exception paramContext) {}
    }
    return false;
  }
  
  public static int i(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return 0;
    case 3: 
      if (paramBoolean) {
        return 3;
      }
      return 1;
    case 4: 
      return 2;
    case 5: 
      return 4;
    }
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kjz
 * JD-Core Version:    0.7.0.1
 */