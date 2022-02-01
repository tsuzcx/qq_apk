import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerBigPicItemData;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerTriplePicItemData;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusInnerData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class kmx
{
  public static int a(ProteusBannerBigPicItemData paramProteusBannerBigPicItemData)
  {
    if (b(paramProteusBannerBigPicItemData)) {
      return 28;
    }
    if (a(paramProteusBannerBigPicItemData)) {
      return 25;
    }
    if (paramProteusBannerBigPicItemData.agg) {
      return 26;
    }
    return 10;
  }
  
  public static int a(ProteusBannerTriplePicItemData paramProteusBannerTriplePicItemData)
  {
    if (a(paramProteusBannerTriplePicItemData)) {
      return 30;
    }
    return 27;
  }
  
  public static int a(ProteusBannerVideoItemData paramProteusBannerVideoItemData)
  {
    if (a(paramProteusBannerVideoItemData)) {
      return 29;
    }
    return 15;
  }
  
  public static int a(ProteusInnerData paramProteusInnerData)
  {
    int j = 20;
    int i;
    if (a(paramProteusInnerData)) {
      i = 24;
    }
    do
    {
      do
      {
        return i;
        if (paramProteusInnerData.zD()) {
          return 21;
        }
        i = j;
      } while (paramProteusInnerData.zE());
      if (paramProteusInnerData.zF()) {
        return 31;
      }
      i = j;
    } while (!paramProteusInnerData.zG());
    return 31;
  }
  
  public static void a(Context paramContext, AdData paramAdData, int paramInt)
  {
    if (paramAdData == null) {
      return;
    }
    ods.h(paramContext, paramAdData.mPopFormH5Url, paramAdData.alE, paramAdData.alJ);
    paramContext = (QQAppInterface)kxm.getAppRuntime();
    jzk.a(new kku.a().a(paramContext).a(BaseApplication.getContext()).a(jzk.aFu).b(jzk.aFv).a(kne.a(paramAdData)).d(paramInt).d(jzk.a(paramAdData)).a());
  }
  
  public static void a(Context paramContext, ViewBase paramViewBase, String paramString, int paramInt)
  {
    try
    {
      View localView = ((lsr)paramViewBase).getNativeView();
      a(paramContext, paramViewBase, paramString, paramInt, localView.getWidth(), localView.getHeight());
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("FastWeqAdUtils", 2, "loadImage error " + paramContext.getMessage());
    }
  }
  
  public static void a(Context paramContext, ViewBase paramViewBase, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      paramViewBase = (lsr)paramViewBase;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = paramInt2;
      localURLDrawableOptions.mRequestHeight = paramInt3;
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      paramString.setTag(aqbn.d(paramInt2, paramInt3, wja.dp2px(paramInt1, paramContext.getResources())));
      paramString.setDecodeHandler(aqbn.a);
      paramViewBase.setImageDrawable(paramString, true);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("FastWeqAdUtils", 2, "loadImage error " + paramContext.getMessage());
    }
  }
  
  public static boolean a(AdData paramAdData)
  {
    return (paramAdData != null) && (paramAdData.a != null) && (!TextUtils.isEmpty(paramAdData.a.packageName));
  }
  
  public static void b(Context paramContext, AdData paramAdData)
  {
    if (a(paramAdData))
    {
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
  
  public static boolean b(AdData paramAdData)
  {
    return (paramAdData != null) && (paramAdData.mAdvertisementExtInfo != null) && (5001 == paramAdData.mAdvertisementExtInfo.aJz);
  }
  
  public static void c(Context paramContext, AdData paramAdData)
  {
    if (paramAdData == null) {
      return;
    }
    ods.h(paramContext, paramAdData.mPopFormH5Url, paramAdData.alE, paramAdData.alJ);
    paramContext = (QQAppInterface)kxm.getAppRuntime();
    jzk.a(new kku.a().a(paramContext).a(BaseApplication.getContext()).a(jzk.aFu).b(jzk.aFv).a(kne.a(paramAdData)).d(jzk.a(paramAdData)).a());
  }
  
  public static boolean c(AdData paramAdData)
  {
    return (a(paramAdData)) && ("3".equals(paramAdData.a.aaa));
  }
  
  public static boolean d(AdData paramAdData)
  {
    return (a(paramAdData)) && ("1".equals(paramAdData.a.aaa));
  }
  
  public static boolean e(AdData paramAdData)
  {
    return (a(paramAdData)) && ("2".equals(paramAdData.a.aaa));
  }
  
  public static boolean f(AdData paramAdData)
  {
    return (a(paramAdData)) && ("4".equals(paramAdData.a.aaa));
  }
  
  public static void g(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    ods.cn(paramContext);
    if (!TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      kxm.C(paramContext, ods.fr(paramString2));
      return;
      if (!TextUtils.isEmpty(paramString3)) {
        paramString2 = paramString3;
      } else {
        paramString2 = paramString1;
      }
    }
  }
  
  public static boolean g(AdData paramAdData)
  {
    if (paramAdData == null) {}
    while ((TextUtils.isEmpty(paramAdData.mPopFormH5Url)) || (!paramAdData.atk) || (!knc.l(paramAdData))) {
      return false;
    }
    return true;
  }
  
  public static boolean h(AdData paramAdData)
  {
    if ((paramAdData instanceof ProteusInnerData)) {
      return ((ProteusInnerData)paramAdData).zG();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kmx
 * JD-Core Version:    0.7.0.1
 */