import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeSummaryView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class kwm
  implements View.OnClickListener
{
  kwm(kwc paramkwc) {}
  
  public void onClick(View paramView)
  {
    NativeSummaryView.b((ArticleInfo)this.a.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.a.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kwm
 * JD-Core Version:    0.7.0.1
 */