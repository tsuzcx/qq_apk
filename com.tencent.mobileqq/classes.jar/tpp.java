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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class tpp
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
    if ((paramAdData == null) || (paramAdData.jdField_a_of_type_Tlq == null)) {
      return String.valueOf(0);
    }
    return paramAdData.jdField_a_of_type_Tlq.x;
  }
  
  public static void a(Context paramContext, AdData paramAdData)
  {
    if (a(paramAdData))
    {
      String str1 = paramAdData.jdField_a_of_type_Tlq.m;
      if (!TextUtils.isEmpty(paramAdData.jdField_a_of_type_Tlq.n)) {
        str1 = paramAdData.jdField_a_of_type_Tlq.n;
      }
      String str2 = str1;
      if (TextUtils.isEmpty(str1))
      {
        str2 = str1;
        if (!TextUtils.isEmpty(paramAdData.e)) {
          str2 = paramAdData.e;
        }
      }
      ozs.d(paramContext, ubd.a(str2));
    }
  }
  
  public static void a(Context paramContext, AdData paramAdData, int paramInt)
  {
    if (paramAdData == null) {
      return;
    }
    ubd.a(paramContext, paramAdData.C, paramAdData.e, paramAdData.m);
    paramContext = (QQAppInterface)ozs.a();
    nzq.a(new tlx().a(paramContext).a(BaseApplication.getContext()).a(nzq.L).b(nzq.M).a(tqb.a(paramAdData)).d(paramInt).d(nzq.a(paramAdData)).a());
  }
  
  public static void a(Context paramContext, ViewBase paramViewBase, String paramString, int paramInt)
  {
    try
    {
      View localView = ((qcx)paramViewBase).getNativeView();
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
      paramViewBase = (qcx)paramViewBase;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = paramInt2;
      localURLDrawableOptions.mRequestHeight = paramInt3;
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      paramString.setTag(bhez.b(paramInt2, paramInt3, agej.a(paramInt1, paramContext.getResources())));
      paramString.setDecodeHandler(bhez.j);
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
    ubd.a(paramContext);
    if (!TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      ozs.d(paramContext, ubd.a(paramString2));
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
    return (paramAdData != null) && (paramAdData.jdField_a_of_type_Tlq != null) && (!TextUtils.isEmpty(paramAdData.jdField_a_of_type_Tlq.b));
  }
  
  public static void b(Context paramContext, AdData paramAdData)
  {
    if (paramAdData == null) {
      return;
    }
    ubd.a(paramContext, paramAdData.C, paramAdData.e, paramAdData.m);
    paramContext = (QQAppInterface)ozs.a();
    nzq.a(new tlx().a(paramContext).a(BaseApplication.getContext()).a(nzq.L).b(nzq.M).a(tqb.a(paramAdData)).d(nzq.a(paramAdData)).a());
  }
  
  public static boolean b(AdvertisementInfo paramAdvertisementInfo)
  {
    return a(paramAdvertisementInfo).equalsIgnoreCase(String.valueOf(3));
  }
  
  public static boolean b(AdData paramAdData)
  {
    return (paramAdData != null) && (paramAdData.jdField_a_of_type_Tly != null) && (5001 == paramAdData.jdField_a_of_type_Tly.i);
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
    while ((TextUtils.isEmpty(paramAdData.C)) || (!paramAdData.b) || (!tpz.d(paramAdData))) {
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
 * Qualified Name:     tpp
 * JD-Core Version:    0.7.0.1
 */