import android.view.View;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.util.List;

public class tyr
  extends uyi
{
  public tyr(tyo paramtyo) {}
  
  public void a(int paramInt, View paramView, Object paramObject, vap paramvap)
  {
    if ((paramInt < 0) || (paramInt > this.a.a.a(tyo.a(this.a)).size())) {}
    do
    {
      return;
      paramObject = (CommentEntry)this.a.a.a(tyo.a(this.a)).get(paramInt);
      switch (paramView.getId())
      {
      default: 
        return;
      }
    } while ((paramObject.authorRole == 1002) || (paramObject.authorRole == 1003));
    sxm.a(paramView.getContext(), 12, paramObject.authorUnionId);
    return;
    if (tyo.a(this.a) != null) {
      tyo.a(this.a).a(paramObject, paramInt, tyo.a(this.a).a());
    }
    tyo.a(this.a).a(tyo.a(this.a).a());
  }
  
  public void b(int paramInt, View paramView, Object paramObject, vap paramvap)
  {
    if ((paramInt < 0) || (paramInt > this.a.a.a(tyo.a(this.a)).size())) {
      return;
    }
    paramObject = (CommentEntry)this.a.a.a(tyo.a(this.a)).get(paramInt);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131364469: 
      paramView = tyo.a(this.a).a();
      if ((paramView != null) && (paramView.a != null)) {
        if (!paramView.a.getOwner().isMe()) {
          break label194;
        }
      }
      label194:
      for (paramView = "2";; paramView = "1")
      {
        vei.a("home_page", "press_reply", 0, 0, new String[] { paramView, vei.a(tyo.a(this.a)) });
        if (tyo.a(this.a) == null) {
          break;
        }
        tyo.a(this.a).b(paramObject, paramInt, tyo.a(this.a).a());
        return;
      }
    }
    tyo.a(this.a).a(tyo.a(this.a).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tyr
 * JD-Core Version:    0.7.0.1
 */