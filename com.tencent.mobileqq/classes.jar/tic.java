import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class tic
  implements ViewBase.OnClickListener
{
  tic(tib paramtib) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    int i = StringCommon.getStrIdFromString(paramViewBase.getClickEvnet());
    tia.a(this.a.jdField_a_of_type_Tia, i).a(paramViewBase, this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tic
 * JD-Core Version:    0.7.0.1
 */