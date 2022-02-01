import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.AdDownloadScene;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.HorizontalProgressStyle;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.RoundProgressStyle;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJAdDownloadViewBase;", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "vafContext", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/VafContext;", "(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/VafContext;)V", "adInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;", "getAdInfo", "()Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;", "setAdInfo", "(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)V", "buttonStyleJson", "Lorg/json/JSONObject;", "getButtonStyleJson", "()Lorg/json/JSONObject;", "setButtonStyleJson", "(Lorg/json/JSONObject;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "downloadData", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData;", "getDownloadData", "()Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData;", "setDownloadData", "(Lcom/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData;)V", "downloadStyle", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/style/IDownloadStyle;", "getDownloadStyle", "()Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/style/IDownloadStyle;", "setDownloadStyle", "(Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/style/IDownloadStyle;)V", "progressStyleJson", "getProgressStyleJson", "setProgressStyleJson", "rijDownloadView", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;", "getRijDownloadView", "()Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;", "setRijDownloadView", "(Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJDownloadView;)V", "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "checkAttribute", "", "convertJsonToButtonStyle", "convertJsonToProgressStyle", "getAdvertisementInfoFromParams", "value", "", "getComMeasuredHeight", "", "getComMeasuredWidth", "getNativeView", "initView", "onComLayout", "changed", "", "l", "t", "r", "b", "onComMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPause", "onResume", "setAttribute", "key", "setDefaultDownloadStyle", "updateAdData", "advertisementInfo", "Builder", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ufn
  extends ViewBase
{
  private final Context jdField_a_of_type_AndroidContentContext;
  @Nullable
  private View jdField_a_of_type_AndroidViewView;
  @Nullable
  private volatile AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  @Nullable
  private RIJDownloadView jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
  @Nullable
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  @Nullable
  private volatile ufa jdField_a_of_type_Ufa;
  @Nullable
  private JSONObject b;
  
  public ufn(@NotNull VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_AndroidContentContext = paramVafContext.getContext();
    c();
  }
  
  private final AdvertisementInfo a(Object paramObject)
  {
    AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)null;
    if ((paramObject instanceof AdvertisementInfo)) {
      localAdvertisementInfo = (AdvertisementInfo)paramObject;
    }
    if ((paramObject instanceof AdData)) {
      localAdvertisementInfo = ((AdData)paramObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
    }
    return localAdvertisementInfo;
  }
  
  private final void a(AdvertisementInfo paramAdvertisementInfo, Object paramObject)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
    paramAdvertisementInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
    if (paramAdvertisementInfo != null) {
      paramAdvertisementInfo.setAdvertisementInfo(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
    }
  }
  
  private final void a(Object paramObject)
  {
    AdvertisementInfo localAdvertisementInfo = a(paramObject);
    if ((localAdvertisementInfo != null) && ((Intrinsics.areEqual(getTag(), paramObject) ^ true)))
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
      if (localObject == null) {
        break label133;
      }
    }
    label133:
    for (Object localObject = ((AdvertisementInfo)localObject).getPackageName();; localObject = null)
    {
      if ((Intrinsics.areEqual(localObject, localAdvertisementInfo.getPackageName()) ^ true))
      {
        QLog.d("AD_DOWNLOAD_TAG", 1, "tag = " + getTag() + "  value = " + paramObject);
        setTag(paramObject);
        a(localAdvertisementInfo, paramObject);
        if (ufg.a.a(localAdvertisementInfo))
        {
          paramObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
          if (paramObject != null) {
            paramObject.setOnClickListener((View.OnClickListener)new ufp(this));
          }
        }
      }
      return;
    }
  }
  
  private final void a(JSONObject paramJSONObject)
  {
    if ((this.jdField_a_of_type_Ufa instanceof HorizontalProgressStyle))
    {
      localObject = this.jdField_a_of_type_Ufa;
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.HorizontalProgressStyle");
      }
      ((HorizontalProgressStyle)localObject).setBtnTextSize(paramJSONObject.optInt("buttonTextSize", 12));
      paramJSONObject = paramJSONObject.optString("buttonTextColor");
      if (!TextUtils.isEmpty((CharSequence)paramJSONObject))
      {
        localObject = this.jdField_a_of_type_Ufa;
        if (localObject == null) {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.HorizontalProgressStyle");
        }
        localObject = (HorizontalProgressStyle)localObject;
        if (paramJSONObject == null) {
          break label96;
        }
        ((HorizontalProgressStyle)localObject).setBtnTextColor(paramJSONObject);
      }
    }
    label96:
    do
    {
      do
      {
        return;
        paramJSONObject = "#FF12B7F5";
        break;
      } while (!(this.jdField_a_of_type_Ufa instanceof RoundProgressStyle));
      localObject = this.jdField_a_of_type_Ufa;
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.RoundProgressStyle");
      }
      RoundProgressStyle localRoundProgressStyle = (RoundProgressStyle)localObject;
      localObject = paramJSONObject.optString("buttonBackgroundColor");
      if (localObject != null) {}
      for (;;)
      {
        localRoundProgressStyle.setBtnDrawableNormalColor((String)localObject);
        localObject = this.jdField_a_of_type_Ufa;
        if (localObject != null) {
          break;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.RoundProgressStyle");
        localObject = "#12B7F5";
      }
      ((RoundProgressStyle)localObject).setBtnTextSize(paramJSONObject.optInt("buttonTextSize", 12));
      paramJSONObject = paramJSONObject.optString("buttonTextColor");
    } while (TextUtils.isEmpty((CharSequence)paramJSONObject));
    Object localObject = this.jdField_a_of_type_Ufa;
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.RoundProgressStyle");
    }
    localObject = (RoundProgressStyle)localObject;
    if (paramJSONObject != null) {}
    for (;;)
    {
      ((RoundProgressStyle)localObject).setBtnTextColor(paramJSONObject);
      return;
      paramJSONObject = "#FFFFFF";
    }
  }
  
  private final void b(JSONObject paramJSONObject)
  {
    if ((this.jdField_a_of_type_Ufa instanceof HorizontalProgressStyle))
    {
      localObject = this.jdField_a_of_type_Ufa;
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.HorizontalProgressStyle");
      }
      ((HorizontalProgressStyle)localObject).setProgressTextSize(paramJSONObject.optInt("textSize", 12));
      paramJSONObject = paramJSONObject.optString("textColor");
      if (!TextUtils.isEmpty((CharSequence)paramJSONObject))
      {
        localObject = this.jdField_a_of_type_Ufa;
        if (localObject == null) {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.HorizontalProgressStyle");
        }
        localObject = (HorizontalProgressStyle)localObject;
        if (paramJSONObject == null) {
          break label98;
        }
        ((HorizontalProgressStyle)localObject).setProgressTextColor(paramJSONObject);
      }
    }
    label98:
    while (!(this.jdField_a_of_type_Ufa instanceof RoundProgressStyle)) {
      for (;;)
      {
        return;
        paramJSONObject = "#FFFFFF";
      }
    }
    Object localObject = this.jdField_a_of_type_Ufa;
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.RoundProgressStyle");
    }
    RoundProgressStyle localRoundProgressStyle = (RoundProgressStyle)localObject;
    localObject = paramJSONObject.optString("progressColor");
    if (localObject != null) {}
    for (;;)
    {
      localRoundProgressStyle.setPauseRectColor((String)localObject);
      localObject = this.jdField_a_of_type_Ufa;
      if (localObject != null) {
        break;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.RoundProgressStyle");
      localObject = "#12B7F5";
    }
    localRoundProgressStyle = (RoundProgressStyle)localObject;
    localObject = paramJSONObject.optString("progressColor");
    if (localObject != null) {}
    for (;;)
    {
      localRoundProgressStyle.setProgressColorHighLight((String)localObject);
      localObject = this.jdField_a_of_type_Ufa;
      if (localObject != null) {
        break;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.RoundProgressStyle");
      localObject = "#12B7F5";
    }
    localObject = (RoundProgressStyle)localObject;
    paramJSONObject = paramJSONObject.optString("progressBg");
    if (paramJSONObject != null) {}
    for (;;)
    {
      ((RoundProgressStyle)localObject).setProgressColorNormal(paramJSONObject);
      return;
      paramJSONObject = "#CCCCCC";
    }
  }
  
  private final void c()
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater");
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.view.LayoutInflater");
    }
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)localObject).inflate(2131560094, null);
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null) {}
    for (localObject = (RIJDownloadView)((View)localObject).findViewById(2131362059);; localObject = null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView = ((RIJDownloadView)localObject);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
      if (localObject != null) {
        ((RIJDownloadView)localObject).setDownloadScene(AdDownloadScene.PTSCard);
      }
      return;
    }
  }
  
  private final void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) {}
    Object localObject;
    do
    {
      return;
      e();
      localObject = this.jdField_a_of_type_OrgJsonJSONObject;
      if (localObject != null) {
        b((JSONObject)localObject);
      }
      localObject = this.b;
      if (localObject != null) {
        a((JSONObject)localObject);
      }
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
    } while (localObject == null);
    ((RIJDownloadView)localObject).setProgressStyle(this.jdField_a_of_type_Ufa);
  }
  
  private final void e()
  {
    AdvertisementInfo localAdvertisementInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
    if ((localAdvertisementInfo != null) && (localAdvertisementInfo.isSoftAd() == true))
    {
      this.jdField_a_of_type_Ufa = ((ufa)RoundProgressStyle.FastWebSoftAd);
      return;
    }
    localAdvertisementInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
    if ((localAdvertisementInfo != null) && (localAdvertisementInfo.isGameAd() == true))
    {
      this.jdField_a_of_type_Ufa = ((ufa)HorizontalProgressStyle.FastWebGameStyle);
      return;
    }
    this.jdField_a_of_type_Ufa = ((ufa)HorizontalProgressStyle.FastWebAppStyle);
  }
  
  @Nullable
  public final RIJDownloadView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
  }
  
  public final void a()
  {
    RIJDownloadView localRIJDownloadView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
    if (localRIJDownloadView != null) {
      localRIJDownloadView.a();
    }
  }
  
  public final void b()
  {
    RIJDownloadView localRIJDownloadView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView;
    if (localRIJDownloadView != null) {
      localRIJDownloadView.b();
    }
  }
  
  public int getComMeasuredHeight()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      return localView.getMeasuredHeight();
    }
    return 0;
  }
  
  public int getComMeasuredWidth()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      return localView.getMeasuredWidth();
    }
    return 0;
  }
  
  @Nullable
  public View getNativeView()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      localView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      localView.measure(paramInt1, paramInt2);
    }
  }
  
  public boolean setAttribute(int paramInt, @Nullable Object paramObject)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      bool = super.setAttribute(paramInt, paramObject);
    }
    do
    {
      do
      {
        return bool;
        a(paramObject);
        d();
        return true;
      } while (!(paramObject instanceof JSONObject));
      this.jdField_a_of_type_OrgJsonJSONObject = ((JSONObject)paramObject);
      d();
      return true;
    } while (!(paramObject instanceof JSONObject));
    this.b = ((JSONObject)paramObject);
    d();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ufn
 * JD-Core Version:    0.7.0.1
 */