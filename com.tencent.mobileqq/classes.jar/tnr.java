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

class tnr
  implements ViewBase.OnClickListener
{
  tnr(tnq paramtnq) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    boolean bool1;
    int i;
    if ((this.a.jdField_a_of_type_Tnp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData instanceof ProteusItemData)) {
      switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
      {
      default: 
        bool1 = true;
        i = -1;
        if (tpp.g((AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData)) {
          tpp.b(this.a.jdField_a_of_type_AndroidContentContext, (AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
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
          do
          {
            return;
            ssu.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, paramViewBase.getNativeView(), this.a.jdField_a_of_type_AndroidContentContext);
          } while (!tno.b);
          tno.c = true;
        } while (tnp.a(this.a.jdField_a_of_type_Tnp) == null);
        tnp.a(this.a.jdField_a_of_type_Tnp).q();
        tnp.a(this.a.jdField_a_of_type_Tnp).o();
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
        paramViewBase = tqb.a((ProteusBannerVideoItemData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
      } while (paramViewBase == null);
      if (!ubd.a((Activity)this.a.jdField_a_of_type_AndroidContentContext, (AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, paramViewBase)) {
        break label317;
      }
    } while (tnp.a(this.a.jdField_a_of_type_Tnp) == null);
    tnp.a(this.a.jdField_a_of_type_Tnp).q();
    return;
    label317:
    if (tnp.a(this.a.jdField_a_of_type_Tnp) != null) {}
    for (boolean bool2 = tnp.a(this.a.jdField_a_of_type_Tnp).a();; bool2 = false)
    {
      paramViewBase.setClickPos(i);
      Object localObject = new tlt(bool2);
      if (i == 8) {
        ((tlt)localObject).c = true;
      }
      localObject = ubd.a((Activity)this.a.jdField_a_of_type_AndroidContentContext, paramViewBase, null, 2, bool1, (tlt)localObject);
      if (localObject == null) {
        break;
      }
      ((GdtHandler.Params)localObject).f = tpz.b((AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
      ubd.a((GdtHandler.Params)localObject, this.a.jdField_a_of_type_AndroidContentContext, paramViewBase);
      tno.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = (GdtHandler.Params)localObject;
      tno.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      paramViewBase.setClickPos(i);
      tku.a(true, (Context)this.a.jdField_a_of_type_Tnp.jdField_a_of_type_JavaLangRefWeakReference.get(), paramViewBase, 2, nzq.a, 3);
      if (tnp.a(this.a.jdField_a_of_type_Tnp) == null) {
        break;
      }
      tnp.a(this.a.jdField_a_of_type_Tnp).q();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tnr
 * JD-Core Version:    0.7.0.1
 */