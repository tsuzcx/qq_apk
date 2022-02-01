import android.content.Context;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerBigPicItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.wadl.ipc.WadlParams;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"checkRealState", "", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/data/AdDownloadInfo;", "convertToWadlParams", "Lcooperation/wadl/ipc/WadlParams;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData;", "getDownloadEngine", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/engine/IDownloadEngine;", "getPackageName", "", "Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;", "isBottomAd", "", "Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData;", "isDownloadAd", "isGameDownloadAd", "isGameGiftAd", "isGameSubscribeAd", "isNormalAppDownloadAd", "isShowDownloadProgress", "isSoftDownloadAd", "AQQLiteApp_release"}, k=2, mv={1, 1, 16})
public final class ufc
{
  @NotNull
  public static final WadlParams a(@NotNull ule paramule)
  {
    Intrinsics.checkParameterIsNotNull(paramule, "$this$convertToWadlParams");
    WadlParams localWadlParams = new WadlParams(paramule.jdField_a_of_type_JavaLangString, paramule.d);
    localWadlParams.c = 7;
    localWadlParams.b = 2;
    localWadlParams.n = (paramule.g + "@" + paramule.h);
    localWadlParams.e = paramule.c;
    localWadlParams.j = paramule.e;
    localWadlParams.p = "biz_src_feeds_kandianads";
    localWadlParams.l = "qq_vas_game";
    return localWadlParams;
  }
  
  @NotNull
  public static final uex a(@NotNull ule paramule)
  {
    Intrinsics.checkParameterIsNotNull(paramule, "$this$getDownloadEngine");
    if (paramule.jdField_a_of_type_Boolean) {
      return (uex)uew.a;
    }
    return (uex)uey.a;
  }
  
  public static final void a(@NotNull uev paramuev)
  {
    Intrinsics.checkParameterIsNotNull(paramuev, "$this$checkRealState");
    if (bhfn.a((Context)BaseApplicationImpl.getContext(), paramuev.a()))
    {
      paramuev.a(1);
      paramuev.b(100);
    }
    do
    {
      return;
      if (paramuev.d() != null)
      {
        File localFile = new File(paramuev.d());
        if ((localFile.exists()) && (localFile.isFile()))
        {
          paramuev.a(5);
          paramuev.b(100);
          return;
        }
      }
      if (paramuev.a() == 5)
      {
        if (oil.a((Context)BaseApplicationImpl.getContext(), paramuev.a()))
        {
          paramuev.a(5);
          paramuev.b(100);
          return;
        }
        paramuev.a(0);
        paramuev.b(0);
        return;
      }
      if ((paramuev.b() == 0) && (paramuev.a() != 0))
      {
        paramuev.a(0);
        return;
      }
    } while (paramuev.b() != 100);
    if (bhfn.a((Context)BaseApplicationImpl.getContext(), paramuev.a()))
    {
      paramuev.a(1);
      return;
    }
    paramuev.a(5);
  }
  
  public static final boolean a(@Nullable AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo != null) {
      return ukr.a(paramAdvertisementInfo);
    }
    return false;
  }
  
  public static final boolean a(@Nullable AdData paramAdData)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAdData != null) {
      if (!(paramAdData instanceof ProteusBannerBigPicItemData))
      {
        bool1 = bool2;
        if (!(paramAdData instanceof ProteusBannerVideoItemData)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static final boolean b(@Nullable AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAdvertisementInfo != null) {
      if ((!c(paramAdvertisementInfo)) && (!d(paramAdvertisementInfo)))
      {
        bool1 = bool2;
        if (!e(paramAdvertisementInfo)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static final boolean c(@Nullable AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAdvertisementInfo != null)
    {
      bool1 = bool2;
      if (paramAdvertisementInfo.mAdProductType == 12) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static final boolean d(@Nullable AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo != null)
    {
      if ((paramAdvertisementInfo.mAdvertisementSoftInfo != null) && (paramAdvertisementInfo.mAdvertisementSoftInfo.e == 1) && (paramAdvertisementInfo.mSoftAdType == 2)) {
        return true;
      }
    }
    else {
      return false;
    }
    return false;
  }
  
  public static final boolean e(@Nullable AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo != null)
    {
      if ((paramAdvertisementInfo.gameAdComData != null) && (paramAdvertisementInfo.mSoftAdType == 1) && (paramAdvertisementInfo.gameAdComData.s != null) && (Intrinsics.areEqual(paramAdvertisementInfo.gameAdComData.s, "2"))) {
        return true;
      }
    }
    else {
      return false;
    }
    return false;
  }
  
  public static final boolean f(@Nullable AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo != null)
    {
      if ((paramAdvertisementInfo.gameAdComData != null) && (paramAdvertisementInfo.mSoftAdType == 1) && (paramAdvertisementInfo.gameAdComData.s != null) && (Intrinsics.areEqual(paramAdvertisementInfo.gameAdComData.s, "1"))) {
        return true;
      }
    }
    else {
      return false;
    }
    return false;
  }
  
  public static final boolean g(@Nullable AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo != null)
    {
      if ((paramAdvertisementInfo.gameAdComData != null) && (paramAdvertisementInfo.mSoftAdType == 1) && (paramAdvertisementInfo.gameAdComData.s != null) && (Intrinsics.areEqual(paramAdvertisementInfo.gameAdComData.s, "3"))) {
        return true;
      }
    }
    else {
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ufc
 * JD-Core Version:    0.7.0.1
 */