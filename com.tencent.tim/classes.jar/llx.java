import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyAdVideoGuide;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText;
import cooperation.qzone.util.NetworkState;
import org.json.JSONException;
import org.json.JSONObject;

public class llx
  implements lpi
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
    throws JSONException
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    return lky.a(paramInt, paramBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, lie paramlie, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    if ((paramlie != null) && ((paramlie.a() instanceof AdvertisementInfo)) && (((AdvertisementInfo)paramlie.a()).isHideForAnimate)) {}
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
        kwz.a(false, localViewBase, null);
        if ((paramlie == null) || (!(paramlie.a() instanceof AdvertisementInfo)) || (!((AdvertisementInfo)paramlie.a()).isShowingGuide)) {
          break label526;
        }
        localObject1 = (AdvertisementInfo)paramlie.a();
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
        paramContainer = ((View)paramContainer.getParent()).findViewById(2131362099);
        if ((paramContainer instanceof ReadInJoyAdVideoGuide)) {
          paramContainer.setVisibility(0);
        }
      }
      try
      {
        localObject2 = new JSONObject(((AdvertisementInfo)localObject1).mAdExt).optString("pkg_name");
        ((ReadInJoyAdVideoGuide)paramContainer).setAppInfo(((AdvertisementInfo)localObject1).mAdProductType, ((AdvertisementInfo)localObject1).mAdCorporateLogo, ((AdvertisementInfo)localObject1).mAdCorporationName, (String)localObject2, knd.j((AdvertisementInfo)localObject1));
        label281:
        while ((paramlie != null) && (paramlie.a() != null) && (AdvertisementInfo.isAdvertisementInfo(paramlie.a())))
        {
          paramContainer = localViewBase.findViewBaseByName("id_view_AdDownloadView");
          if ((paramContainer != null) && ((paramContainer instanceof koh)))
          {
            paramContainer = (koh)paramContainer;
            paramContainer.pq(paramInt1);
            paramContainer.setModel(paramlie, true);
          }
          paramContainer = localViewBase.findViewBaseByName("id_view_Ad_CompleteGudie");
          if ((paramContainer == null) || (!(paramContainer instanceof lrt))) {
            break;
          }
          paramlie = (AdvertisementInfo)paramlie.a();
          if ((!paramlie.isShowingGuide) || (!paramlie.mShowAdButton)) {
            break label579;
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
          localObject1 = (NativeText)localViewBase.findViewBaseByName("id_video_paly_text");
          if (localObject1 != null)
          {
            if (aqux.Mv() == 1) {
              label455:
              ((NativeText)localObject1).setText("");
            }
          }
          else {
            if (paramlie == null) {
              break label520;
            }
          }
          for (localObject1 = paramlie.a();; localObject1 = null)
          {
            kwz.a(localViewBase, (BaseArticleInfo)localObject1);
            break;
            if (paramlie == null) {
              break label455;
            }
            localObject2 = paramlie.a();
            if ((!(localObject2 instanceof AdvertisementInfo)) || (((AdvertisementInfo)localObject2).mAdVideoFileSize <= 0L)) {
              break label455;
            }
            break label455;
          }
          paramContainer = ((View)paramContainer.getParent()).findViewById(2131362099);
          if (paramContainer != null) {
            paramContainer.setVisibility(8);
          }
          paramContainer = localViewBase.findViewBaseByName("id_large_video_duration");
          if ((paramContainer != null) && (paramContainer.getNativeView() != null)) {
            paramContainer.getNativeView().setVisibility(0);
          }
        }
        label520:
        label526:
        label579:
        paramContainer.setVisibility(8);
        return;
      }
      catch (JSONException paramContainer)
      {
        break label281;
      }
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, lie paramlie, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     llx
 * JD-Core Version:    0.7.0.1
 */