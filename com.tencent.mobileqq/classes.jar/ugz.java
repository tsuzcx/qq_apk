import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.util.List;

class ugz
  extends pvq
{
  ugz(ugx paramugx) {}
  
  public void a(Object paramObject, int paramInt, boolean paramBoolean, String... paramVarArgs)
  {
    if (paramInt == 101) {
      if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
    }
    Object localObject1;
    int j;
    int i;
    int k;
    label80:
    Object localObject2;
    Object localObject3;
    int m;
    while (paramInt != 110) {
      for (;;)
      {
        return;
        paramObject = (ReadInJoyXListView)this.a.a().a();
        localObject1 = this.a.a().a();
        if ((paramObject != null) && (localObject1 != null))
        {
          paramVarArgs = paramVarArgs[0];
          try
          {
            j = paramObject.getHeaderViewsCount();
            i = paramObject.getFirstVisiblePosition();
            k = paramObject.getLastVisiblePosition();
            paramInt = i;
            if (paramInt <= k)
            {
              if ((paramInt < j) || (paramInt - j >= ((List)localObject1).size())) {
                break label727;
              }
              localObject2 = (BaseArticleInfo)((List)localObject1).get(paramInt - j);
              localObject3 = paramObject.getChildAt(paramInt - i);
              if (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) {
                break label727;
              }
              localObject2 = (AdvertisementInfo)localObject2;
              m = uks.a((AdvertisementInfo)localObject2);
              String str = uks.a((AdvertisementInfo)localObject2);
              if ((m != 1) || (!paramVarArgs.equals(str)) || (!(localObject3 instanceof ProteusItemView))) {
                break label727;
              }
              localObject3 = ((ProteusItemView)localObject3).a().getVirtualView().findViewBaseByName("id_view_AdDownloadView");
              if (!(localObject3 instanceof ufn)) {
                break label727;
              }
              localObject3 = (ufn)localObject3;
              if (((ufn)localObject3).a() == null) {
                break label727;
              }
              ((ufn)localObject3).a().a(true, (AdvertisementInfo)localObject2, paramVarArgs);
            }
          }
          catch (Exception paramObject)
          {
            return;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramObject = (ReadInJoyXListView)this.a.a().a();
        paramVarArgs = this.a.a().a();
        k = paramObject.getHeaderViewsCount();
        j = paramObject.getFirstVisiblePosition();
        m = paramObject.getLastVisiblePosition();
        paramInt = j;
        if (paramInt > m) {
          break;
        }
        if ((paramInt < k) || (paramInt - k >= paramVarArgs.size())) {
          break label734;
        }
        localObject1 = (BaseArticleInfo)paramVarArgs.get(paramInt - k);
        localObject2 = paramObject.getChildAt(paramInt - j);
        if (!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject1)) {
          break label734;
        }
        localObject3 = (AdvertisementInfo)localObject1;
        if (!((AdvertisementInfo)localObject3).isHideForAnimate) {
          break label734;
        }
        if (paramBoolean) {
          break label650;
        }
        i = 4;
        localObject2 = ((ProteusItemView)localObject2).a().getVirtualView();
        if (((AdvertisementInfo)localObject3).mImaxShowAdType != 1001) {
          break label689;
        }
        localObject3 = ((ViewBase)localObject2).findViewBaseByName("id_article_large_imge");
        if (localObject3 != null) {
          ((ViewBase)localObject3).getNativeView().setVisibility(i);
        }
        localObject3 = ((ViewBase)localObject2).findViewBaseByName("id_large_video_icon");
        if (localObject3 != null) {
          ((ViewBase)localObject3).getNativeView().setVisibility(4);
        }
        if ((!NetworkState.isWifiConn()) || (i != 0)) {
          break label662;
        }
        if (localObject3 != null) {
          ((ViewBase)localObject3).getNativeView().setVisibility(i);
        }
        localObject3 = ((ViewBase)localObject2).findViewBaseByName("id_view_Ad_CompleteGudie");
        if (localObject3 != null) {
          ((ViewBase)localObject3).getNativeView().setVisibility(4);
        }
        localObject3 = ((ViewBase)localObject2).findViewBaseByName("id_large_video_activity_img");
        if (localObject3 != null) {
          ((ViewBase)localObject3).getNativeView().setVisibility(4);
        }
        localObject3 = ((ViewBase)localObject2).findViewBaseByName("id_large_video_cover");
        if (localObject3 != null) {
          ((ViewBase)localObject3).getNativeView().setVisibility(i);
        }
        localObject3 = ((ViewBase)localObject2).findViewBaseByName("id_large_video_duration");
        if (localObject3 != null) {
          ((ViewBase)localObject3).getNativeView().setVisibility(i);
        }
        if (!((AdvertisementInfo)localObject1).isIMaxAndNewStyle) {
          break label734;
        }
        localObject1 = ((ViewBase)localObject2).findViewBaseByName("id_artilce_title");
        if (localObject1 == null) {
          break label734;
        }
        ((ViewBase)localObject1).getNativeView().setVisibility(i);
      }
      catch (Exception paramObject) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ReadInjoyIMAXAdFragment", 2, "error  =>" + paramObject.getMessage());
      return;
      label650:
      ((AdvertisementInfo)localObject3).isHideForAnimate = false;
      i = 0;
      continue;
      label662:
      localObject3 = ((ViewBase)localObject2).findViewBaseByName("id_video_bg");
      if (localObject3 != null)
      {
        ((ViewBase)localObject3).getNativeView().setVisibility(i);
        continue;
        label689:
        if (((AdvertisementInfo)localObject3).mImaxShowAdType == 1002)
        {
          localObject1 = ((ViewBase)localObject2).findViewBaseByName("id_article_double_image");
          if (localObject1 != null)
          {
            ((ViewBase)localObject1).getNativeView().setVisibility(i);
            break label734;
            label727:
            paramInt += 1;
            break label80;
          }
        }
        label734:
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ugz
 * JD-Core Version:    0.7.0.1
 */