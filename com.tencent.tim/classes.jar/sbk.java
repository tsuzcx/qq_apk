import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedItemView;
import com.tencent.mobileqq.pb.PBStringField;

class sbk
  implements View.OnLongClickListener
{
  sbk(sbf.b paramb, ExtraTypeInfo paramExtraTypeInfo, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public boolean onLongClick(View paramView)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.b != null) {
      if (this.b.pageType == 7003)
      {
        sbf.a(this.a.c, this.e);
        bool1 = true;
      }
    }
    do
    {
      do
      {
        return bool1;
        if (this.b.pageType == 7002) {
          return true;
        }
        bool1 = bool2;
      } while (!(this.a.itemView instanceof RelativeFeedItemView));
      bool1 = bool2;
    } while (this.e == null);
    this.a.c.a(this.e, new sbl(this), new sbm(this));
    sqn.b(this.e.poster.id.get(), "auth_feeds", "press", 0, 0, new String[] { "", this.a.getAdapterPosition() + "", this.e.poster.nick.get(), this.e.title.get() });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sbk
 * JD-Core Version:    0.7.0.1
 */