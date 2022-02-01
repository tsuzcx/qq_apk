import android.view.View;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.util.List;

public class xfe
  extends yev
{
  public xfe(xfb paramxfb) {}
  
  public void a(int paramInt, View paramView, Object paramObject, yhc paramyhc)
  {
    if ((paramInt < 0) || (paramInt > this.a.a.a(xfb.a(this.a)).size())) {}
    do
    {
      return;
      paramObject = (CommentEntry)this.a.a.a(xfb.a(this.a)).get(paramInt);
      switch (paramView.getId())
      {
      default: 
        return;
      }
    } while ((paramObject.authorRole == 1002) || (paramObject.authorRole == 1003));
    weg.a(paramView.getContext(), 12, paramObject.authorUnionId);
    return;
    if (xfb.a(this.a) != null) {
      xfb.a(this.a).a(paramObject, paramInt, xfb.a(this.a).a());
    }
    xfb.a(this.a).a(xfb.a(this.a).a());
  }
  
  public void b(int paramInt, View paramView, Object paramObject, yhc paramyhc)
  {
    if ((paramInt < 0) || (paramInt > this.a.a.a(xfb.a(this.a)).size())) {
      return;
    }
    paramObject = (CommentEntry)this.a.a.a(xfb.a(this.a)).get(paramInt);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131364923: 
      paramView = xfb.a(this.a).a();
      if ((paramView != null) && (paramView.a != null)) {
        if (!paramView.a.getOwner().isMe()) {
          break label194;
        }
      }
      label194:
      for (paramView = "2";; paramView = "1")
      {
        ykv.a("home_page", "press_reply", 0, 0, new String[] { paramView, ykv.a(xfb.a(this.a)) });
        if (xfb.a(this.a) == null) {
          break;
        }
        xfb.a(this.a).b(paramObject, paramInt, xfb.a(this.a).a());
        return;
      }
    }
    xfb.a(this.a).a(xfb.a(this.a).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xfe
 * JD-Core Version:    0.7.0.1
 */