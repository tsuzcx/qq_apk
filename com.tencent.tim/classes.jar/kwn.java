import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class kwn
  implements ViewBase.OnClickListener
{
  kwn(kwc paramkwc) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    paramViewBase = lbz.a().a();
    if ((paramViewBase != null) && (this.a.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null))
    {
      this.a.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.isShowFreeNetFlow = false;
      kxm.aJ(this.a.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), paramViewBase.jt());
      kwz.a(false, this.a.c.getVirtualView(), null);
      lic.no("0X8009661");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kwn
 * JD-Core Version:    0.7.0.1
 */