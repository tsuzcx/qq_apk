import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class kwh
  implements ViewBase.OnClickListener
{
  kwh(kwc paramkwc) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if ((!(this.a.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof ArticleInfo)) || (this.a.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mProteusTemplateBean == null))
    {
      QLog.d("ProteusSupportUtil", 1, "STR_ID_CMD_PARTNER_HEADER_CLICK,click exception, return");
      return;
    }
    TemplateBean localTemplateBean = kvx.a(null, this.a.aMg, this.a.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    if (localTemplateBean != null) {
      kvx.b(localTemplateBean.findViewById(paramViewBase.getName()));
    }
    kvx.a(this.a.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, localTemplateBean, paramViewBase);
    kxm.C(this.a.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), paramViewBase.getEventAttachedData());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kwh
 * JD-Core Version:    0.7.0.1
 */