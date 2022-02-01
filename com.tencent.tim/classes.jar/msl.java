import android.app.Activity;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyAdVideoGuide;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class msl
  implements mye.a
{
  private ReadInJoyXListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView;
  private mye jdField_a_of_type_Mye;
  private ndi b;
  private ConcurrentHashMap<Integer, Integer> bt = new ConcurrentHashMap();
  private mye.b c;
  private int mChannelID = -1;
  private Activity mContext;
  private Handler mUiHandler;
  public boolean ob;
  
  public msl(Activity paramActivity, ndi paramndi, mye parammye, ReadInJoyXListView paramReadInJoyXListView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager Constructor");
    }
    this.mContext = paramActivity;
    this.b = paramndi;
    this.jdField_a_of_type_Mye = parammye;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = paramReadInJoyXListView;
    this.mChannelID = paramInt;
    this.mUiHandler = new msm(this, Looper.getMainLooper());
  }
  
  public void Destroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager Destroy");
    }
    if (this.mUiHandler != null)
    {
      this.mUiHandler.removeMessages(3001);
      this.mUiHandler = null;
    }
    this.jdField_a_of_type_Mye.b(this);
  }
  
  public mye.b a(AdvertisementInfo paramAdvertisementInfo, View paramView, lis paramlis)
  {
    if ((paramAdvertisementInfo == null) || (paramView == null) || (paramlis == null)) {}
    while ((paramlis.getCellType() != 6) && (paramlis.getCellType() != 66) && (paramlis.getCellType() != 115)) {
      return null;
    }
    Object localObject = (ProteusItemView)paramView;
    paramView = ndi.a(paramAdvertisementInfo);
    localObject = ((ProteusItemView)localObject).a().getVirtualView().findViewBaseByName("id_article_large_imge");
    if (localObject != null)
    {
      paramView.ma = ((ViewBase)localObject).getNativeView();
      if (((ViewBase)localObject).getNativeView() != null) {
        paramView.aVU = ((ViewBase)localObject).getNativeView().getWidth();
      }
    }
    paramView.position = paramlis.mPosition;
    paramView.d = paramAdvertisementInfo;
    paramView.aqp = true;
    paramView.aVV = 1;
    return paramView;
  }
  
  public mye.b a(boolean paramBoolean)
  {
    int i = 0;
    lis locallis;
    Object localObject2;
    if (i < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i);
      if ((localObject1 != null) && ((localObject1 instanceof ProteusItemView)))
      {
        locallis = (lis)((View)localObject1).getTag(2131381960);
        localObject2 = locallis.a();
        if (((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) && (locallis.getCellType() == 6)) || ((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) && (locallis.getCellType() == 66)) || ((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) && (locallis.getCellType() == 115)))
        {
          localObject2 = (AdvertisementInfo)localObject2;
          if ((paramBoolean) && (!knc.a((AdvertisementInfo)localObject2, null, this.b.getActivity(), 1)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("RecommendADVideoFeedsManager", 2, "isADVideoAutoPlayFlag false, AdvertisementInfo = " + ((AdvertisementInfo)localObject2).toSString());
            }
            return null;
          }
        }
      }
    }
    for (Object localObject1 = a((AdvertisementInfo)localObject2, (View)localObject1, locallis);; localObject1 = null)
    {
      return localObject1;
      i += 1;
      break;
    }
  }
  
  public void a(mye.b paramb, myi parammyi, int paramInt1, int paramInt2, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager onStateChange: videoPlayParam " + paramb + " videoPlayerWrapper = " + parammyi + " oldState" + paramInt1 + " newState = " + paramInt2);
    }
    if (paramInt2 == 7)
    {
      View localView;
      ReadInJoyAdVideoGuide localReadInJoyAdVideoGuide;
      AdvertisementInfo localAdvertisementInfo;
      String str3;
      String str4;
      if (paramb != null)
      {
        this.bt.put(Integer.valueOf(paramb.position), Integer.valueOf(7));
        if (QLog.isColorLevel()) {
          QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager mListPositionPlayStateMap " + this.bt.toString());
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null)
        {
          paramInt1 = 0;
          if (paramInt1 < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())
          {
            localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1);
            parammyi = localView.getTag(2131381960);
            if ((!(parammyi instanceof lis)) || (((lis)parammyi).a() != paramb.d) || (!(paramb.d instanceof AdvertisementInfo))) {
              break label773;
            }
            parammyi = (AdvertisementInfo)paramb.d;
            if ((!(localView instanceof ProteusItemView)) || (!parammyi.mShowAdButton)) {
              break label739;
            }
            parammyi = ((ProteusItemView)localView).a().getVirtualView().findViewBaseByName("id_view_Ad_CompleteGudie");
            if ((parammyi != null) && ((parammyi instanceof lrt)) && (parammyi.getNativeView() != null))
            {
              localReadInJoyAdVideoGuide = (ReadInJoyAdVideoGuide)((lrt)parammyi).getNativeView();
              localAdvertisementInfo = (AdvertisementInfo)paramb.d;
              parammyi = "";
              str3 = "";
              str4 = "";
              paramObject = str3;
            }
          }
        }
      }
      try
      {
        String str2 = new JSONObject(localAdvertisementInfo.mAdExt).optString("pkg_name");
        localObject = str4;
        String str1 = str3;
        paramObject = str3;
        parammyi = str2;
        if (!TextUtils.isEmpty(localAdvertisementInfo.mJsonVideoList))
        {
          paramObject = str3;
          parammyi = str2;
          JSONArray localJSONArray = new JSONObject(localAdvertisementInfo.mJsonVideoList).getJSONArray("videos");
          localObject = str4;
          str1 = str3;
          if (localJSONArray != null)
          {
            localObject = str4;
            str1 = str3;
            paramObject = str3;
            parammyi = str2;
            if (localJSONArray.length() > 0)
            {
              paramObject = str3;
              parammyi = str2;
              localObject = localJSONArray.getJSONObject(0);
              paramObject = str3;
              parammyi = str2;
              str1 = ((JSONObject)localObject).optString("thirdIcon");
              paramObject = str1;
              parammyi = str2;
              localObject = ((JSONObject)localObject).optString("thirdName");
            }
          }
        }
        parammyi = str2;
        paramObject = str1;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Object localObject = "";
        }
      }
      if (localAdvertisementInfo.mImaxShowAdType == 1001) {
        localReadInJoyAdVideoGuide.setBtnInfo(localAdvertisementInfo.mAdBtnTxt);
      }
      localReadInJoyAdVideoGuide.setAppInfo(localAdvertisementInfo.mAdProductType, paramObject, (String)localObject, parammyi, knd.j(localAdvertisementInfo));
      localReadInJoyAdVideoGuide.setAdGuideClickListener(new msn(this, localAdvertisementInfo, paramb));
      localReadInJoyAdVideoGuide.setVisibility(0);
      parammyi = ((ProteusItemView)localView).a().getVirtualView().findViewBaseByName("id_large_video_icon");
      if ((parammyi != null) && (parammyi.getNativeView() != null)) {
        parammyi.getNativeView().setVisibility(8);
      }
      parammyi = ((ProteusItemView)localView).a().getVirtualView().findViewBaseByName("id_large_video_duration");
      if ((parammyi != null) && (parammyi.getNativeView() != null)) {
        parammyi.getNativeView().setVisibility(8);
      }
      localAdvertisementInfo.isShowingGuide = true;
      label599:
      break label729;
      label600:
      this.b.notifyDataSetChanged();
      label607:
      if ((paramInt2 == 0) && (paramb != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null)) {
        paramInt1 = 0;
      }
    }
    for (;;)
    {
      boolean bool;
      if (paramInt1 < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount())
      {
        parammyi = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1);
        paramObject = parammyi.getTag(2131381960);
        if ((!(paramObject instanceof lis)) || (((lis)paramObject).a() != paramb.d) || (!(parammyi instanceof ProteusItemView))) {
          break label974;
        }
        paramObject = ((ProteusItemView)parammyi).a().getVirtualView().findViewBaseByName("id_large_video_icon");
        bool = NetworkState.isWifiConn();
        if ((!(paramb.d instanceof AdvertisementInfo)) || (!((AdvertisementInfo)paramb.d).isHideForAnimate)) {}
      }
      else
      {
        label729:
        return;
        label739:
        if (this.mUiHandler == null) {
          break label600;
        }
        this.mUiHandler.removeMessages(3001);
        this.mUiHandler.sendEmptyMessageDelayed(3001, 250L);
        break label600;
        label773:
        paramInt1 += 1;
        break;
        if ((paramb == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView == null)) {
          break label607;
        }
        paramInt1 = 0;
        for (;;)
        {
          if (paramInt1 >= this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount()) {
            break label908;
          }
          parammyi = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(paramInt1);
          paramObject = parammyi.getTag(2131381960);
          if (((paramObject instanceof lis)) && (((lis)paramObject).a() == paramb.d) && ((parammyi instanceof ProteusItemView)))
          {
            parammyi = ((ProteusItemView)parammyi).a().getVirtualView().findViewBaseByName("id_view_Ad_CompleteGudie");
            if ((parammyi == null) || (!(parammyi instanceof lrt)) || (parammyi.getNativeView() == null)) {
              break;
            }
            ((ReadInJoyAdVideoGuide)((lrt)parammyi).getNativeView()).setVisibility(8);
            break;
          }
          paramInt1 += 1;
        }
        label908:
        break label607;
      }
      if ((paramObject != null) && (paramObject.getNativeView() != null) && (bool)) {
        paramObject.getNativeView().setVisibility(0);
      }
      paramb = ((ProteusItemView)parammyi).a().getVirtualView().findViewBaseByName("id_large_video_duration");
      if ((paramb == null) || (paramb.getNativeView() == null)) {
        break label599;
      }
      paramb.getNativeView().setVisibility(0);
      return;
      label974:
      paramInt1 += 1;
    }
  }
  
  public void a(mye parammye)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager onAttached");
    }
    this.jdField_a_of_type_Mye = parammye;
    this.jdField_a_of_type_Mye.a(this);
  }
  
  public void b(mye.b paramb1, mye.b paramb2)
  {
    this.bt.put(Integer.valueOf(paramb2.position), Integer.valueOf(0));
    this.c = paramb2;
    mzj.a().aUJ();
    this.jdField_a_of_type_Mye.stop(2);
    this.b.k = paramb2;
    this.jdField_a_of_type_Mye.a(paramb2);
    if ((paramb2.d != null) && (AdvertisementInfo.isAdvertisementInfo(paramb2.d)))
    {
      ((AdvertisementInfo)paramb2.d).adbt = ((int)paramb2.xb);
      ((AdvertisementInfo)paramb2.d).adpa = 1;
      ((AdvertisementInfo)paramb2.d).adpb = 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "playVideoForADVideo  vid: " + paramb2.videoVid + " playParams = " + paramb2.toString());
    }
  }
  
  public boolean c(mye.b paramb)
  {
    if ((paramb == null) || (this.ob)) {}
    double d;
    do
    {
      do
      {
        return false;
        paramb = paramb.ma;
      } while (paramb == null);
      int i = paramb.getHeight();
      Rect localRect = new Rect();
      paramb.getLocalVisibleRect(localRect);
      d = localRect.height() * 1.0F / i;
    } while ((d < 0.5D) && (d <= 0.800000011920929D));
    return true;
  }
  
  public void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager doOnPause");
    }
  }
  
  public void doOnResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendADVideoFeedsManager", 2, "RecommendADVideoFeedsManager doOnResume");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     msl
 * JD-Core Version:    0.7.0.1
 */