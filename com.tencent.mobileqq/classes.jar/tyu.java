import android.view.View;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.util.List;

public class tyu
  extends uyl
{
  public tyu(tyr paramtyr) {}
  
  public void a(int paramInt, View paramView, Object paramObject, vas paramvas)
  {
    if ((paramInt < 0) || (paramInt > this.a.a.a(tyr.a(this.a)).size())) {}
    do
    {
      return;
      paramObject = (CommentEntry)this.a.a.a(tyr.a(this.a)).get(paramInt);
      switch (paramView.getId())
      {
      default: 
        return;
      }
    } while ((paramObject.authorRole == 1002) || (paramObject.authorRole == 1003));
    sxp.a(paramView.getContext(), 12, paramObject.authorUnionId);
    return;
    if (tyr.a(this.a) != null) {
      tyr.a(this.a).a(paramObject, paramInt, tyr.a(this.a).a());
    }
    tyr.a(this.a).a(tyr.a(this.a).a());
  }
  
  public void b(int paramInt, View paramView, Object paramObject, vas paramvas)
  {
    if ((paramInt < 0) || (paramInt > this.a.a.a(tyr.a(this.a)).size())) {
      return;
    }
    paramObject = (CommentEntry)this.a.a.a(tyr.a(this.a)).get(paramInt);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131364470: 
      paramView = tyr.a(this.a).a();
      if ((paramView != null) && (paramView.a != null)) {
        if (!paramView.a.getOwner().isMe()) {
          break label194;
        }
      }
      label194:
      for (paramView = "2";; paramView = "1")
      {
        vel.a("home_page", "press_reply", 0, 0, new String[] { paramView, vel.a(tyr.a(this.a)) });
        if (tyr.a(this.a) == null) {
          break;
        }
        tyr.a(this.a).b(paramObject, paramInt, tyr.a(this.a).a());
        return;
      }
    }
    tyr.a(this.a).a(tyr.a(this.a).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tyu
 * JD-Core Version:    0.7.0.1
 */