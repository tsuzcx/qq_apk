import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class ttc
  implements ViewBase.OnClickListener
{
  ttc(ttb paramttb) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    int m = 8;
    int n;
    int k;
    if ((this.a.jdField_a_of_type_Tta.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData instanceof ProteusItemData))
    {
      n = StringCommon.getStrIdFromString(paramViewBase.getClickEvnet());
      k = 0;
    }
    int j;
    switch (n)
    {
    default: 
      i = -1;
      j = k;
    case 1001: 
    case 1070: 
    case 1087: 
    case 1088: 
      for (;;)
      {
        if ((j != 0) && (n != -1)) {
          svz.a(this.a.jdField_a_of_type_AndroidContentContext, tws.a((AdData)this.a.jdField_a_of_type_Tta.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData), true, i);
        }
        return;
        j = k;
        i = m;
        if (this.a.jdField_a_of_type_AndroidContentContext != null)
        {
          swu.a(this.a.jdField_a_of_type_Tta.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, paramViewBase.getNativeView(), this.a.jdField_a_of_type_AndroidContentContext);
          j = k;
          i = m;
          continue;
          i = 5;
          j = 1;
          continue;
          i = 4;
          j = 1;
        }
      }
    case 1089: 
      if (twh.g((AdData)this.a.jdField_a_of_type_Tta.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData))
      {
        twh.a(this.a.jdField_a_of_type_AndroidContentContext, (AdData)this.a.jdField_a_of_type_Tta.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, 8);
        return;
      }
      if (!twh.h((AdData)this.a.jdField_a_of_type_Tta.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData)) {
        break;
      }
    }
    for (int i = 1;; i = 8)
    {
      j = 1;
      break;
      j = 1;
      i = 1;
      break;
      i = 3;
      j = 1;
      break;
      i = 1000;
      j = 1;
      break;
      j = 1;
      i = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ttc
 * JD-Core Version:    0.7.0.1
 */