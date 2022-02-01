import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

public class lpy
  implements ViewBase.OnClickListener
{
  private ArticleInfo jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private ndi jdField_b_of_type_Ndi;
  
  public lpy(ArticleInfo paramArticleInfo, ndi paramndi)
  {
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_b_of_type_Ndi = paramndi;
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    paramViewBase = this.jdField_b_of_type_Ndi.a();
    if (paramViewBase != null) {
      paramViewBase.a(null, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 2);
    }
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.invalidateProteusTemplateBean();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lpy
 * JD-Core Version:    0.7.0.1
 */