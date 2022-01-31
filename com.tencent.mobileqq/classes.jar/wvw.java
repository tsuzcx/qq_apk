import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedItemView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class wvw
  implements View.OnClickListener
{
  public wvw(RelativeFeedItemView paramRelativeFeedItemView) {}
  
  public void onClick(View paramView)
  {
    paramView = (CertifiedAccountMeta.StFeed)this.a.a();
    wiv.a(this.a.getContext(), paramView, 0, wrt.a(this.a.a, paramView.cover.width.get(), paramView.cover.height.get()));
    ExtraTypeInfo localExtraTypeInfo = this.a.a();
    if ((localExtraTypeInfo != null) && (paramView != null))
    {
      if (localExtraTypeInfo.pageType != 7003) {
        break label133;
      }
      xhe.a(paramView.poster.id.get(), "auth_follow", "new_c_clk", 0, 0, new String[] { "", "", paramView.id.get(), paramView.title.get() });
    }
    label133:
    while (localExtraTypeInfo.pageType != 7004) {
      return;
    }
    xhe.a(paramView.poster.id.get(), "auth_discover", "clk_content", 0, 0, new String[] { "", "", paramView.id.get(), paramView.title.get() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wvw
 * JD-Core Version:    0.7.0.1
 */