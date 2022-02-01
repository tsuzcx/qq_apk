import UserGrowth.stNotificationRsp;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment;
import com.tencent.biz.pubaccount.weishi_new.view.WeiShiNoticeView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ofx
  implements View.OnClickListener
{
  public ofx(WSRecommendFragment paramWSRecommendFragment) {}
  
  public void onClick(View paramView)
  {
    if (WSRecommendFragment.a(this.this$0) == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i = WSRecommendFragment.a(this.this$0).getType();
      String str1 = WSRecommendFragment.a(this.this$0, WSRecommendFragment.a(this.this$0));
      String str2 = WSRecommendFragment.a(this.this$0).h5Url;
      ooz.w("WSRecommendFragment", "schemeUrl:" + str1 + ", h5Url:" + str2);
      opn.a(this.this$0.mContext, str1, str2, "", i, this.this$0.a);
      ong.W(112, i, WSRecommendFragment.a(this.this$0).cid);
      ooz.i("weishi-808", "notification jumpUrl" + WSRecommendFragment.a(this.this$0).jump_url);
      this.this$0.qC(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ofx
 * JD-Core Version:    0.7.0.1
 */