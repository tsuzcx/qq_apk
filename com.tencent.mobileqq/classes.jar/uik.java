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

public class uik
  implements qqa
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    return qll.a(paramInt, paramBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, qfw paramqfw, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    if ((paramqfw != null) && ((paramqfw.a() instanceof AdvertisementInfo)) && (((AdvertisementInfo)paramqfw.a()).isHideForAnimate)) {}
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
        pjr.a(false, localViewBase, null);
        if ((paramqfw == null) || (!(paramqfw.a() instanceof AdvertisementInfo)) || (!((AdvertisementInfo)paramqfw.a()).isShowingGuide)) {
          break label559;
        }
        localObject1 = (AdvertisementInfo)paramqfw.a();
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
        paramContainer = ((View)paramContainer.getParent()).findViewById(2131362070);
        if ((paramContainer instanceof ReadInJoyAdVideoGuide)) {
          paramContainer.setVisibility(0);
        }
      }
      try
      {
        localObject2 = new JSONObject(((AdvertisementInfo)localObject1).mAdExt).optString("pkg_name");
        ((ReadInJoyAdVideoGuide)paramContainer).setAppInfo(((AdvertisementInfo)localObject1).mAdProductType, ((AdvertisementInfo)localObject1).mAdCorporateLogo, ((AdvertisementInfo)localObject1).mAdCorporationName, (String)localObject2, uks.d((AdvertisementInfo)localObject1), (AdvertisementInfo)localObject1);
        while ((paramqfw != null) && (paramqfw.a() != null) && (AdvertisementInfo.isAdvertisementInfo(paramqfw.a())))
        {
          paramContainer = localViewBase.findViewBaseByName("id_view_AdDownloadView");
          if ((paramContainer instanceof una)) {
            ((una)paramContainer).a(paramqfw, true);
          }
          paramContainer = localViewBase.findViewBaseByName("id_view_Ad_CompleteGudie");
          if (!(paramContainer instanceof qtj)) {
            break;
          }
          paramqfw = (AdvertisementInfo)paramqfw.a();
          paramContainer.setTag(paramqfw);
          if (paramqfw.mChannelID != 0L) {
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
            localObject1 = anvx.a(2131699319);
            if (bhyk.a() == 1)
            {
              localObject1 = anvx.a(2131699318);
              label456:
              ((NativeText)localObject2).setText((CharSequence)localObject1);
            }
          }
          else
          {
            if (paramqfw == null) {
              break label553;
            }
          }
          label553:
          for (localObject1 = paramqfw.a();; localObject1 = null)
          {
            pjr.a(localViewBase, (BaseArticleInfo)localObject1);
            break;
            if (paramqfw == null) {
              break label643;
            }
            ArticleInfo localArticleInfo = paramqfw.a();
            if (!(localArticleInfo instanceof AdvertisementInfo)) {
              break label643;
            }
            long l = ((AdvertisementInfo)localArticleInfo).mAdVideoFileSize;
            if (l <= 0L) {
              break label643;
            }
            localObject1 = six.b(l) + anvx.a(2131699320);
            break label456;
          }
          label559:
          paramContainer = ((View)paramContainer.getParent()).findViewById(2131362070);
          if (paramContainer != null) {
            paramContainer.setVisibility(8);
          }
          paramContainer = localViewBase.findViewBaseByName("id_large_video_duration");
          if ((paramContainer != null) && (paramContainer.getNativeView() != null)) {
            paramContainer.getNativeView().setVisibility(0);
          }
        }
        label612:
        if ((paramqfw.isShowingGuide) && (paramqfw.mShowAdButton))
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
  
  public boolean a(int paramInt, Container paramContainer, qfw paramqfw, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uik
 * JD-Core Version:    0.7.0.1
 */