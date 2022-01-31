import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedItemView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class yoz
  implements View.OnClickListener
{
  public yoz(RelativeFeedItemView paramRelativeFeedItemView) {}
  
  public void onClick(View paramView)
  {
    paramView = (CertifiedAccountMeta.StFeed)this.a.a();
    if (paramView == null) {}
    ExtraTypeInfo localExtraTypeInfo;
    do
    {
      do
      {
        return;
        ybt.a(this.a.getContext(), paramView, 0, ykt.a(this.a.a, paramView.cover.width.get(), paramView.cover.height.get()));
        localExtraTypeInfo = this.a.a();
      } while ((localExtraTypeInfo == null) || (paramView == null));
      if (localExtraTypeInfo.pageType == 7003)
      {
        zaj.a(paramView.poster.id.get(), "auth_follow", "new_c_clk", 0, 0, new String[] { "", "", paramView.id.get(), paramView.title.get() });
        return;
      }
    } while (localExtraTypeInfo.pageType != 7004);
    zaj.a(paramView.poster.id.get(), "auth_discover", "clk_content", 0, 0, new String[] { "", "", paramView.id.get(), paramView.title.get() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yoz
 * JD-Core Version:    0.7.0.1
 */