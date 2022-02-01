import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.PgcSmallView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.b;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.j;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.o;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class lpc
  implements View.OnClickListener
{
  lpc(lot paramlot, lie paramlie, PgcSmallView paramPgcSmallView, Container paramContainer) {}
  
  public void onClick(View paramView)
  {
    ArticleInfo localArticleInfo = this.b.a();
    localArticleInfo.click_area = 11;
    QLog.d("PgcShortContentProteusItem", 1, "click short content small image");
    if (this.b.a().mSocialFeedInfo.a.aSS == 3)
    {
      localArticleInfo.click_jump_target = lrm.R(this.b.a().mSocialFeedInfo.a.b.jumpUrl, "-1");
      kxm.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPgcSmallView.getContext(), this.b.a().mSocialFeedInfo.a.b.jumpUrl, null);
    }
    for (;;)
    {
      kxm.b(this.c.getContext(), localArticleInfo, (int)localArticleInfo.mChannelID);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localArticleInfo.click_jump_target = lrm.R(this.b.a().mSocialFeedInfo.a.a.jumpUrl, "-1");
      kxm.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewPgcSmallView.getContext(), this.b.a().mSocialFeedInfo.a.a.jumpUrl, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lpc
 * JD-Core Version:    0.7.0.1
 */