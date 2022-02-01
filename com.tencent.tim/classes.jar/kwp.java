import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class kwp
  implements ViewBase.OnClickListener
{
  kwp(kwc paramkwc, ViewBase paramViewBase) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if ((!(this.jdField_a_of_type_Kwc.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo instanceof ArticleInfo)) || (this.jdField_a_of_type_Kwc.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mProteusTemplateBean == null))
    {
      QLog.d("ProteusSupportUtil", 1, "click exception, return");
      return;
    }
    if ((this.jdField_a_of_type_Kwc.jdField_c_of_type_Ndi.nh() == 0) || (kys.dv(this.jdField_a_of_type_Kwc.jdField_c_of_type_Ndi.nh())))
    {
      lcm.a().a.a(this.jdField_a_of_type_Kwc.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getRootView(), this.jdField_a_of_type_Kwc.jdField_c_of_type_Ndi.b(), this.jdField_a_of_type_Kwc.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      meu.a().b(this.jdField_a_of_type_Kwc.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getRootView(), this.jdField_a_of_type_Kwc.jdField_c_of_type_Ndi.b(), this.jdField_a_of_type_Kwc.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    }
    int i;
    String str;
    Object localObject;
    boolean bool;
    if (kys.dv(this.jdField_a_of_type_Kwc.jdField_c_of_type_Ndi.nh()))
    {
      if (kxm.j(this.jdField_a_of_type_Kwc.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
      {
        i = 4;
        kvs.oT(i);
        QLog.d("ProteusSupportUtil", 2, "click daily card , update operationFlag : " + i);
      }
    }
    else
    {
      str = this.jdField_a_of_type_Kwc.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mProteusTemplateBean.getStyleName();
      localObject = kvx.a(null, this.jdField_a_of_type_Kwc.aMg, this.jdField_a_of_type_Kwc.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      if (localObject != null) {
        kvx.b(((TemplateBean)localObject).findViewById(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getName()));
      }
      EventCollector.getInstance().onViewClicked(this.jdField_a_of_type_Kwc.a);
      bool = false;
      if (!mgn.Z(this.jdField_a_of_type_Kwc.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
        bool = kxj.a().a(this.jdField_a_of_type_Kwc.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (TemplateBean)localObject, paramViewBase);
      }
      kvx.a(this.jdField_a_of_type_Kwc.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (TemplateBean)localObject, paramViewBase);
      lbz.a().H(this.jdField_a_of_type_Kwc.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID, System.currentTimeMillis());
      this.jdField_a_of_type_Kwc.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.invalidateProteusTemplateBean();
      this.jdField_a_of_type_Kwc.jdField_c_of_type_Ndi.notifyDataSetChanged();
      kvx.a(this.jdField_a_of_type_Kwc.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase, (TemplateBean)localObject);
      paramViewBase = kvx.b(this.jdField_a_of_type_Kwc.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      localObject = kxj.a().gd();
      if (TextUtils.isEmpty(paramViewBase)) {
        break label472;
      }
      if (!mgn.dV(paramViewBase)) {
        break label455;
      }
      kxm.a(this.jdField_a_of_type_Kwc.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Kwc.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, paramViewBase);
    }
    for (;;)
    {
      QLog.d("ProteusSupportUtil", 1, "UGRuleManager articleInfo hit ug title" + this.jdField_a_of_type_Kwc.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTitle);
      return;
      i = 2;
      break;
      label455:
      muj.aP(this.jdField_a_of_type_Kwc.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), paramViewBase);
    }
    label472:
    if ((!mgn.Z(this.jdField_a_of_type_Kwc.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) && (bool) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      kxm.a(this.jdField_a_of_type_Kwc.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Kwc.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (String)localObject);
      return;
    }
    if ((!mgn.Z(this.jdField_a_of_type_Kwc.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) && (!kxj.a().AH()) && (kxm.a(this.jdField_a_of_type_Kwc.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Kwc.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, str)))
    {
      kxm.a(this.jdField_a_of_type_Kwc.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Kwc.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, kxm.eA(this.jdField_a_of_type_Kwc.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getInnerUniqueID()));
      return;
    }
    kxm.a(this.jdField_a_of_type_Kwc.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext(), this.jdField_a_of_type_Kwc.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getEventAttachedData());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kwp
 * JD-Core Version:    0.7.0.1
 */