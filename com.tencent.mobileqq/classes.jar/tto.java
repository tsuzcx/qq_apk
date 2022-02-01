import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyArticleBottomVideoView;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import java.lang.ref.WeakReference;

class tto
  implements ViewBase.OnClickListener
{
  tto(ttn paramttn) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    boolean bool1;
    int i;
    if ((this.a.jdField_a_of_type_Ttm.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData instanceof ProteusItemData)) {
      switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
      {
      default: 
        bool1 = true;
        i = -1;
        if (twh.g((AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData)) {
          twh.b(this.a.jdField_a_of_type_AndroidContentContext, (AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
        }
        break;
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          swu.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, paramViewBase.getNativeView(), this.a.jdField_a_of_type_AndroidContentContext);
        } while (ttm.a(this.a.jdField_a_of_type_Ttm) == null);
        ttm.a(this.a.jdField_a_of_type_Ttm).b();
        return;
        bool1 = true;
        i = 4;
        break;
        bool1 = true;
        i = 3;
        break;
        bool1 = false;
        i = 5;
        break;
        bool1 = true;
        i = 8;
        break;
        bool1 = true;
        i = 1000;
        break;
        bool1 = true;
        i = 2;
        break;
        paramViewBase = tws.a((ProteusBannerVideoItemData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
      } while (paramViewBase == null);
      if (!uhs.a((Activity)this.a.jdField_a_of_type_AndroidContentContext, (AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, paramViewBase)) {
        break label294;
      }
    } while (ttm.a(this.a.jdField_a_of_type_Ttm) == null);
    ttm.a(this.a.jdField_a_of_type_Ttm).b();
    return;
    label294:
    if (ttm.a(this.a.jdField_a_of_type_Ttm) != null) {}
    for (boolean bool2 = ttm.a(this.a.jdField_a_of_type_Ttm).a();; bool2 = false)
    {
      paramViewBase.setClickPos(i);
      Object localObject = new trj(bool2);
      if (i == 8) {
        ((trj)localObject).c = true;
      }
      localObject = uhs.a((Activity)this.a.jdField_a_of_type_AndroidContentContext, paramViewBase, null, 2, bool1, (trj)localObject);
      if (localObject == null) {
        break;
      }
      ((GdtHandler.Params)localObject).f = twq.b((AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
      uhs.a((GdtHandler.Params)localObject, this.a.jdField_a_of_type_AndroidContentContext, paramViewBase);
      ttl.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = (GdtHandler.Params)localObject;
      ttl.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      paramViewBase.setClickPos(i);
      tqk.a(true, (Context)this.a.jdField_a_of_type_Ttm.jdField_a_of_type_JavaLangRefWeakReference.get(), paramViewBase, 2, obb.a, 3);
      if (ttm.a(this.a.jdField_a_of_type_Ttm) == null) {
        break;
      }
      ttm.a(this.a.jdField_a_of_type_Ttm).b();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tto
 * JD-Core Version:    0.7.0.1
 */