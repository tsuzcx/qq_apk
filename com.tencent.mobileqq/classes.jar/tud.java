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

public class tud
  implements qdy
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    return pzg.a(paramInt, paramBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, pvc parampvc, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    if ((parampvc != null) && ((parampvc.a() instanceof AdvertisementInfo)) && (((AdvertisementInfo)parampvc.a()).isHideForAnimate)) {}
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
        pai.a(false, localViewBase, null);
        if ((parampvc == null) || (!(parampvc.a() instanceof AdvertisementInfo)) || (!((AdvertisementInfo)parampvc.a()).isShowingGuide)) {
          break label559;
        }
        localObject1 = (AdvertisementInfo)parampvc.a();
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
        paramContainer = ((View)paramContainer.getParent()).findViewById(2131362063);
        if ((paramContainer instanceof ReadInJoyAdVideoGuide)) {
          paramContainer.setVisibility(0);
        }
      }
      try
      {
        localObject2 = new JSONObject(((AdvertisementInfo)localObject1).mAdExt).optString("pkg_name");
        ((ReadInJoyAdVideoGuide)paramContainer).setAppInfo(((AdvertisementInfo)localObject1).mAdProductType, ((AdvertisementInfo)localObject1).mAdCorporateLogo, ((AdvertisementInfo)localObject1).mAdCorporationName, (String)localObject2, twr.d((AdvertisementInfo)localObject1), (AdvertisementInfo)localObject1);
        while ((parampvc != null) && (parampvc.a() != null) && (AdvertisementInfo.isAdvertisementInfo(parampvc.a())))
        {
          paramContainer = localViewBase.findViewBaseByName("id_view_AdDownloadView");
          if ((paramContainer instanceof tyx)) {
            ((tyx)paramContainer).a(parampvc, true);
          }
          paramContainer = localViewBase.findViewBaseByName("id_view_Ad_CompleteGudie");
          if (!(paramContainer instanceof qhg)) {
            break;
          }
          parampvc = (AdvertisementInfo)parampvc.a();
          paramContainer.setTag(parampvc);
          if (parampvc.mChannelID != 0L) {
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
            localObject1 = amtj.a(2131698968);
            if (bgoa.a() == 1)
            {
              localObject1 = amtj.a(2131698967);
              label456:
              ((NativeText)localObject2).setText((CharSequence)localObject1);
            }
          }
          else
          {
            if (parampvc == null) {
              break label553;
            }
          }
          label553:
          for (localObject1 = parampvc.a();; localObject1 = null)
          {
            pai.a(localViewBase, (BaseArticleInfo)localObject1);
            break;
            if (parampvc == null) {
              break label643;
            }
            ArticleInfo localArticleInfo = parampvc.a();
            if (!(localArticleInfo instanceof AdvertisementInfo)) {
              break label643;
            }
            long l = ((AdvertisementInfo)localArticleInfo).mAdVideoFileSize;
            if (l <= 0L) {
              break label643;
            }
            localObject1 = rwv.b(l) + amtj.a(2131698969);
            break label456;
          }
          label559:
          paramContainer = ((View)paramContainer.getParent()).findViewById(2131362063);
          if (paramContainer != null) {
            paramContainer.setVisibility(8);
          }
          paramContainer = localViewBase.findViewBaseByName("id_large_video_duration");
          if ((paramContainer != null) && (paramContainer.getNativeView() != null)) {
            paramContainer.getNativeView().setVisibility(0);
          }
        }
        label612:
        if ((parampvc.isShowingGuide) && (parampvc.mShowAdButton))
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
  
  public boolean a(int paramInt, Container paramContainer, pvc parampvc, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tud
 * JD-Core Version:    0.7.0.1
 */