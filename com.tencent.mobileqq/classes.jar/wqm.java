import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import android.view.View;
import com.tencent.biz.subscribe.fragments.SubscribePersonalBottomOpusFragment;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedItemView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class wqm
  implements wln
{
  public wqm(SubscribePersonalBottomOpusFragment paramSubscribePersonalBottomOpusFragment) {}
  
  public void a(View paramView, CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null) {
      if (!paramStFeed.id.get().startsWith("fakeid_")) {
        break label40;
      }
    }
    label40:
    do
    {
      bcpw.a(this.a.getActivity(), ajyc.a(2131714642), 0).a();
      do
      {
        return;
      } while (!(paramView instanceof RelativeFeedItemView));
      paramView = (RelativeFeedItemView)paramView;
    } while (paramView.a == null);
    wiv.a(this.a.getActivity(), paramStFeed, 0, wrt.a(paramView.a, paramStFeed.cover.width.get(), paramStFeed.cover.height.get()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wqm
 * JD-Core Version:    0.7.0.1
 */