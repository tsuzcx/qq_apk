import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerBigPicItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerTriplePicItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusInnerData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class twh
{
  public static int a(ProteusBannerBigPicItemData paramProteusBannerBigPicItemData)
  {
    if (b(paramProteusBannerBigPicItemData)) {
      return 28;
    }
    if (a(paramProteusBannerBigPicItemData)) {
      return 25;
    }
    if (paramProteusBannerBigPicItemData.f) {
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
        if (paramProteusInnerData.b()) {
          return 21;
        }
        i = j;
      } while (paramProteusInnerData.c());
      if (paramProteusInnerData.d()) {
        return 31;
      }
      i = j;
    } while (!paramProteusInnerData.e());
    return 31;
  }
  
  private static String a(AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramAdvertisementInfo == null) || (paramAdvertisementInfo.gameAdComData == null)) {
      return String.valueOf(0);
    }
    return paramAdvertisementInfo.gameAdComData.s;
  }
  
  private static String a(AdData paramAdData)
  {
    if ((paramAdData == null) || (paramAdData.jdField_a_of_type_Trg == null)) {
      return String.valueOf(0);
    }
    return paramAdData.jdField_a_of_type_Trg.x;
  }
  
  public static void a(Context paramContext, AdData paramAdData)
  {
    if (a(paramAdData))
    {
      String str1 = paramAdData.jdField_a_of_type_Trg.m;
      if (!TextUtils.isEmpty(paramAdData.jdField_a_of_type_Trg.n)) {
        str1 = paramAdData.jdField_a_of_type_Trg.n;
      }
      String str2 = str1;
      if (TextUtils.isEmpty(str1))
      {
        str2 = str1;
        if (!TextUtils.isEmpty(paramAdData.e)) {
          str2 = paramAdData.e;
        }
      }
      pay.d(paramContext, uhs.a(str2));
    }
  }
  
  public static void a(Context paramContext, AdData paramAdData, int paramInt)
  {
    if (paramAdData == null) {
      return;
    }
    uhs.a(paramContext, paramAdData.C, paramAdData.e, paramAdData.m);
    paramContext = (QQAppInterface)pay.a();
    obb.a(new trn().a(paramContext).a(BaseApplication.getContext()).a(obb.L).b(obb.M).a(tws.a(paramAdData)).d(paramInt).d(obb.a(paramAdData)).a());
  }
  
  public static void a(Context paramContext, ViewBase paramViewBase, String paramString, int paramInt)
  {
    try
    {
      View localView = ((qiv)paramViewBase).getNativeView();
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
      paramViewBase = (qiv)paramViewBase;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = paramInt2;
      localURLDrawableOptions.mRequestHeight = paramInt3;
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      paramString.setTag(bfol.b(paramInt2, paramInt3, AIOUtils.dp2px(paramInt1, paramContext.getResources())));
      paramString.setDecodeHandler(bfol.j);
      paramViewBase.setImageDrawable(paramString, true);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("FastWeqAdUtils", 2, "loadImage error " + paramContext.getMessage());
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    uhs.a(paramContext);
    if (!TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      pay.d(paramContext, uhs.a(paramString2));
      return;
      if (!TextUtils.isEmpty(paramString3)) {
        paramString2 = paramString3;
      } else {
        paramString2 = paramString1;
      }
    }
  }
  
  public static boolean a(AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool = true;
    if (paramAdvertisementInfo == null) {
      return false;
    }
    if ((paramAdvertisementInfo.mSoftAdType == 1) && (paramAdvertisementInfo.gameAdComData != null) && (!TextUtils.isEmpty(paramAdvertisementInfo.gameAdComData.d))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean a(AdData paramAdData)
  {
    return (paramAdData != null) && (paramAdData.jdField_a_of_type_Trg != null) && (!TextUtils.isEmpty(paramAdData.jdField_a_of_type_Trg.b));
  }
  
  public static void b(Context paramContext, AdData paramAdData)
  {
    if (paramAdData == null) {
      return;
    }
    uhs.a(paramContext, paramAdData.C, paramAdData.e, paramAdData.m);
    paramContext = (QQAppInterface)pay.a();
    obb.a(new trn().a(paramContext).a(BaseApplication.getContext()).a(obb.L).b(obb.M).a(tws.a(paramAdData)).d(obb.a(paramAdData)).a());
  }
  
  public static boolean b(AdvertisementInfo paramAdvertisementInfo)
  {
    return a(paramAdvertisementInfo).equalsIgnoreCase(String.valueOf(3));
  }
  
  public static boolean b(AdData paramAdData)
  {
    return (paramAdData != null) && (paramAdData.jdField_a_of_type_Tro != null) && (5001 == paramAdData.jdField_a_of_type_Tro.i);
  }
  
  public static boolean c(AdvertisementInfo paramAdvertisementInfo)
  {
    return a(paramAdvertisementInfo).equalsIgnoreCase(String.valueOf(1));
  }
  
  public static boolean c(AdData paramAdData)
  {
    return a(paramAdData).equalsIgnoreCase(String.valueOf(3));
  }
  
  public static boolean d(AdvertisementInfo paramAdvertisementInfo)
  {
    return a(paramAdvertisementInfo).equalsIgnoreCase(String.valueOf(2));
  }
  
  public static boolean d(AdData paramAdData)
  {
    return a(paramAdData).equalsIgnoreCase(String.valueOf(1));
  }
  
  public static boolean e(AdvertisementInfo paramAdvertisementInfo)
  {
    return a(paramAdvertisementInfo).equalsIgnoreCase(String.valueOf(4));
  }
  
  public static boolean e(AdData paramAdData)
  {
    return a(paramAdData).equalsIgnoreCase(String.valueOf(2));
  }
  
  public static boolean f(AdData paramAdData)
  {
    return a(paramAdData).equalsIgnoreCase(String.valueOf(4));
  }
  
  public static boolean g(AdData paramAdData)
  {
    if (paramAdData == null) {}
    while ((TextUtils.isEmpty(paramAdData.C)) || (!paramAdData.b) || (!twq.d(paramAdData))) {
      return false;
    }
    return true;
  }
  
  public static boolean h(AdData paramAdData)
  {
    if ((paramAdData instanceof ProteusInnerData)) {
      return ((ProteusInnerData)paramAdData).e();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     twh
 * JD-Core Version:    0.7.0.1
 */