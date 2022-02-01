import com.tencent.biz.pubaccount.NativeAd.report.constant.AdClickPos;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class uhn
  implements ViewBase.OnClickListener
{
  uhn(uhm paramuhm) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    int k;
    Object localObject;
    int j;
    int i;
    if (this.a.jdField_a_of_type_Uhl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData != null)
    {
      k = StringCommon.getStrIdFromString(paramViewBase.getClickEvnet());
      localObject = AdClickPos.SoftAdComponent;
      j = 0;
      switch (k)
      {
      default: 
        paramViewBase = (ViewBase)localObject;
        i = -1;
      }
    }
    for (;;)
    {
      if ((j != 0) && (k != -1))
      {
        localObject = ukt.a((AdData)this.a.jdField_a_of_type_Uhl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData);
        if ((localObject != null) && (((AdvertisementInfo)localObject).mSoftAdType != 0)) {
          ((AdvertisementInfo)localObject).adClickPos = paramViewBase;
        }
        tjk.a(this.a.jdField_a_of_type_AndroidContentContext, (AdvertisementInfo)localObject, true, i);
      }
      return;
      if (this.a.jdField_a_of_type_AndroidContentContext != null)
      {
        tkf.a(this.a.jdField_a_of_type_Uhl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, paramViewBase.getNativeView(), this.a.jdField_a_of_type_AndroidContentContext);
        i = 8;
        paramViewBase = (ViewBase)localObject;
        continue;
        j = 1;
        i = 5;
        paramViewBase = (ViewBase)localObject;
        continue;
        j = 1;
        i = 4;
        paramViewBase = (ViewBase)localObject;
        continue;
        paramViewBase = AdClickPos.SoftAdClickBtn;
        if (uki.g((AdData)this.a.jdField_a_of_type_Uhl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData))
        {
          uki.a(this.a.jdField_a_of_type_AndroidContentContext, (AdData)this.a.jdField_a_of_type_Uhl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, 8);
          return;
        }
        if (uki.h((AdData)this.a.jdField_a_of_type_Uhl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData)) {}
        for (i = 1;; i = 8)
        {
          j = 1;
          break;
          j = 1;
          paramViewBase = (ViewBase)localObject;
          i = 1;
          break;
          j = 1;
          i = 3;
          paramViewBase = (ViewBase)localObject;
          break;
          j = 1;
          i = 1000;
          paramViewBase = (ViewBase)localObject;
          break;
          paramViewBase = AdClickPos.SoftAdClickBtn;
          i = 1;
          j = 1;
          break;
        }
      }
      else
      {
        i = 8;
        paramViewBase = (ViewBase)localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uhn
 * JD-Core Version:    0.7.0.1
 */