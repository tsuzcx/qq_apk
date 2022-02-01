import android.view.View;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.util.List;

public class wqj
  extends xqa
{
  public wqj(wqg paramwqg) {}
  
  public void a(int paramInt, View paramView, Object paramObject, xsh paramxsh)
  {
    if ((paramInt < 0) || (paramInt > this.a.a.a(wqg.a(this.a)).size())) {}
    do
    {
      return;
      paramObject = (CommentEntry)this.a.a.a(wqg.a(this.a)).get(paramInt);
      switch (paramView.getId())
      {
      default: 
        return;
      }
    } while ((paramObject.authorRole == 1002) || (paramObject.authorRole == 1003));
    vpl.a(paramView.getContext(), 12, paramObject.authorUnionId);
    return;
    if (wqg.a(this.a) != null) {
      wqg.a(this.a).a(paramObject, paramInt, wqg.a(this.a).a());
    }
    wqg.a(this.a).a(wqg.a(this.a).a());
  }
  
  public void b(int paramInt, View paramView, Object paramObject, xsh paramxsh)
  {
    if ((paramInt < 0) || (paramInt > this.a.a.a(wqg.a(this.a)).size())) {
      return;
    }
    paramObject = (CommentEntry)this.a.a.a(wqg.a(this.a)).get(paramInt);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131364836: 
      paramView = wqg.a(this.a).a();
      if ((paramView != null) && (paramView.a != null)) {
        if (!paramView.a.getOwner().isMe()) {
          break label194;
        }
      }
      label194:
      for (paramView = "2";; paramView = "1")
      {
        xwa.a("home_page", "press_reply", 0, 0, new String[] { paramView, xwa.a(wqg.a(this.a)) });
        if (wqg.a(this.a) == null) {
          break;
        }
        wqg.a(this.a).b(paramObject, paramInt, wqg.a(this.a).a());
        return;
      }
    }
    wqg.a(this.a).a(wqg.a(this.a).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wqj
 * JD-Core Version:    0.7.0.1
 */