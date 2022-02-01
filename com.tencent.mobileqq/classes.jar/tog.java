import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdVideoGuide;
import cooperation.qzone.util.NetworkState;
import org.json.JSONException;
import org.json.JSONObject;

public class tog
  implements pye
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    return ptm.a(paramInt, paramBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, ppu paramppu, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    if ((paramppu != null) && ((paramppu.a() instanceof AdvertisementInfo)) && (((AdvertisementInfo)paramppu.a()).isHideForAnimate)) {}
    for (;;)
    {
      return;
      Object localObject1;
      Object localObject2;
      if (NetworkState.isWifiConn())
      {
        localObject1 = localViewBase.findViewBaseByName("id_large_video_icon");
        if (localObject1 != null) {
          ((ViewBase)localObject1).setVisibility(0);
        }
        localObject1 = localViewBase.findViewBaseByName("id_video_bg");
        if (localObject1 != null) {
          ((ViewBase)localObject1).setVisibility(8);
        }
        ozc.a(false, localViewBase, null);
        if ((paramppu == null) || (!(paramppu.a() instanceof AdvertisementInfo)) || (!((AdvertisementInfo)paramppu.a()).isShowingGuide)) {
          break label559;
        }
        localObject1 = (AdvertisementInfo)paramppu.a();
        localObject2 = localViewBase.findViewBaseByName("id_large_video_icon");
        if (localObject2 != null) {
          ((ViewBase)localObject2).setVisibility(8);
        }
        localObject2 = localViewBase.findViewBaseByName("id_video_bg");
        if (localObject2 != null) {
          ((ViewBase)localObject2).setVisibility(8);
        }
        localObject2 = localViewBase.findViewBaseByName("id_large_video_duration");
        if ((localObject2 != null) && (((ViewBase)localObject2).getNativeView() != null)) {
          ((ViewBase)localObject2).getNativeView().setVisibility(8);
        }
        paramContainer = ((View)paramContainer.getParent()).findViewById(2131362064);
        if ((paramContainer instanceof ReadInJoyAdVideoGuide)) {
          paramContainer.setVisibility(0);
        }
      }
      try
      {
        localObject2 = new JSONObject(((AdvertisementInfo)localObject1).mAdExt).optString("pkg_name");
        ((ReadInJoyAdVideoGuide)paramContainer).setAppInfo(((AdvertisementInfo)localObject1).mAdProductType, ((AdvertisementInfo)localObject1).mAdCorporateLogo, ((AdvertisementInfo)localObject1).mAdCorporationName, (String)localObject2, tqa.d((AdvertisementInfo)localObject1), (AdvertisementInfo)localObject1);
        while ((paramppu != null) && (paramppu.a() != null) && (AdvertisementInfo.isAdvertisementInfo(paramppu.a())))
        {
          paramContainer = localViewBase.findViewBaseByName("id_view_AdDownloadView");
          if ((paramContainer instanceof tse)) {
            ((tse)paramContainer).a(paramppu, true);
          }
          paramContainer = localViewBase.findViewBaseByName("id_view_Ad_CompleteGudie");
          if (!(paramContainer instanceof qbi)) {
            break;
          }
          paramppu = (AdvertisementInfo)paramppu.a();
          paramContainer.setTag(paramppu);
          if (paramppu.mChannelID != 0L) {
            break label612;
          }
          paramContainer.setVisibility(0);
          return;
          localObject1 = localViewBase.findViewBaseByName("id_large_video_icon");
          if (localObject1 != null) {
            ((ViewBase)localObject1).setVisibility(8);
          }
          localObject1 = localViewBase.findViewBaseByName("id_video_bg");
          if (localObject1 != null) {
            ((ViewBase)localObject1).setVisibility(0);
          }
          localObject2 = (NativeText)localViewBase.findViewBaseByName("id_video_paly_text");
          if (localObject2 != null)
          {
            localObject1 = anzj.a(2131698733);
            if (bihq.a() == 1)
            {
              localObject1 = anzj.a(2131698732);
              label456:
              ((NativeText)localObject2).setText((CharSequence)localObject1);
            }
          }
          else
          {
            if (paramppu == null) {
              break label553;
            }
          }
          label553:
          for (localObject1 = paramppu.a();; localObject1 = null)
          {
            ozc.a(localViewBase, (BaseArticleInfo)localObject1);
            break;
            if (paramppu == null) {
              break label643;
            }
            ArticleInfo localArticleInfo = paramppu.a();
            if (!(localArticleInfo instanceof AdvertisementInfo)) {
              break label643;
            }
            long l = ((AdvertisementInfo)localArticleInfo).mAdVideoFileSize;
            if (l <= 0L) {
              break label643;
            }
            localObject1 = rpt.b(l) + anzj.a(2131698734);
            break label456;
          }
          label559:
          paramContainer = ((View)paramContainer.getParent()).findViewById(2131362064);
          if (paramContainer != null) {
            paramContainer.setVisibility(8);
          }
          paramContainer = localViewBase.findViewBaseByName("id_large_video_duration");
          if ((paramContainer != null) && (paramContainer.getNativeView() != null)) {
            paramContainer.getNativeView().setVisibility(0);
          }
        }
        label612:
        if ((paramppu.isShowingGuide) && (paramppu.mShowAdButton))
        {
          paramContainer.setVisibility(0);
          return;
        }
        paramContainer.setVisibility(8);
        return;
      }
      catch (JSONException paramContainer)
      {
        label643:
        for (;;) {}
      }
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, ppu paramppu, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tog
 * JD-Core Version:    0.7.0.1
 */