import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.subscribe.network.DoLikeRequest;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedItemView;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class sjg
  implements View.OnClickListener
{
  public sjg(RelativeFeedItemView paramRelativeFeedItemView, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public void onClick(View paramView)
  {
    if ((!RelativeFeedItemView.a(this.a)) || (this.a.getData() == null) || (!rze.fh(((CertifiedAccountMeta.StFeed)this.a.getData()).status.get()))) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!RelativeFeedItemView.b(this.a))
      {
        QQToast.a(this.a.getContext(), acfp.m(2131713856), 0).show();
      }
      else
      {
        RelativeFeedItemView.a(this.a, false);
        DoLikeRequest localDoLikeRequest = new DoLikeRequest(this.e);
        VSNetworkHelper.a().a(localDoLikeRequest, new sjh(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sjg
 * JD-Core Version:    0.7.0.1
 */