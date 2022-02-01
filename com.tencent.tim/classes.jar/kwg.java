import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class kwg
  implements ViewBase.OnClickListener
{
  kwg(kwc paramkwc) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if (this.a.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null)
    {
      kxm.a(this.a.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.a.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, paramViewBase.getEventAttachedData());
      QLog.d("ProteusSupportUtil", 2, "familyJumpUrl " + paramViewBase.getEventAttachedData());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kwg
 * JD-Core Version:    0.7.0.1
 */