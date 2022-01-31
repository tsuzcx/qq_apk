import android.view.View;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.util.List;

public class vrs
  extends wrj
{
  public vrs(vrp paramvrp) {}
  
  public void a(int paramInt, View paramView, Object paramObject, wtq paramwtq)
  {
    if ((paramInt < 0) || (paramInt > this.a.a.a(vrp.a(this.a)).size())) {}
    do
    {
      return;
      paramObject = (CommentEntry)this.a.a.a(vrp.a(this.a)).get(paramInt);
      switch (paramView.getId())
      {
      default: 
        return;
      }
    } while ((paramObject.authorRole == 1002) || (paramObject.authorRole == 1003));
    uqn.a(paramView.getContext(), 12, paramObject.authorUnionId);
    return;
    if (vrp.a(this.a) != null) {
      vrp.a(this.a).a(paramObject, paramInt, vrp.a(this.a).a());
    }
    vrp.a(this.a).a(vrp.a(this.a).a());
  }
  
  public void b(int paramInt, View paramView, Object paramObject, wtq paramwtq)
  {
    if ((paramInt < 0) || (paramInt > this.a.a.a(vrp.a(this.a)).size())) {
      return;
    }
    paramObject = (CommentEntry)this.a.a.a(vrp.a(this.a)).get(paramInt);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131364543: 
      paramView = vrp.a(this.a).a();
      if ((paramView != null) && (paramView.a != null)) {
        if (!paramView.a.getOwner().isMe()) {
          break label194;
        }
      }
      label194:
      for (paramView = "2";; paramView = "1")
      {
        wxj.a("home_page", "press_reply", 0, 0, new String[] { paramView, wxj.a(vrp.a(this.a)) });
        if (vrp.a(this.a) == null) {
          break;
        }
        vrp.a(this.a).b(paramObject, paramInt, vrp.a(this.a).a());
        return;
      }
    }
    vrp.a(this.a).a(vrp.a(this.a).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vrs
 * JD-Core Version:    0.7.0.1
 */