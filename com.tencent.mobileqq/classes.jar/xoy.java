import android.view.View;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.util.List;

public class xoy
  extends yop
{
  public xoy(xov paramxov) {}
  
  public void a(int paramInt, View paramView, Object paramObject, yqw paramyqw)
  {
    if ((paramInt < 0) || (paramInt > this.a.a.a(xov.a(this.a)).size())) {}
    do
    {
      return;
      paramObject = (CommentEntry)this.a.a.a(xov.a(this.a)).get(paramInt);
      switch (paramView.getId())
      {
      default: 
        return;
      }
    } while ((paramObject.authorRole == 1002) || (paramObject.authorRole == 1003));
    wnu.a(paramView.getContext(), 12, paramObject.authorUnionId);
    return;
    if (xov.a(this.a) != null) {
      xov.a(this.a).a(paramObject, paramInt, xov.a(this.a).a());
    }
    xov.a(this.a).a(xov.a(this.a).a());
  }
  
  public void b(int paramInt, View paramView, Object paramObject, yqw paramyqw)
  {
    if ((paramInt < 0) || (paramInt > this.a.a.a(xov.a(this.a)).size())) {
      return;
    }
    paramObject = (CommentEntry)this.a.a.a(xov.a(this.a)).get(paramInt);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131364806: 
      paramView = xov.a(this.a).a();
      if ((paramView != null) && (paramView.a != null)) {
        if (!paramView.a.getOwner().isMe()) {
          break label194;
        }
      }
      label194:
      for (paramView = "2";; paramView = "1")
      {
        yup.a("home_page", "press_reply", 0, 0, new String[] { paramView, yup.a(xov.a(this.a)) });
        if (xov.a(this.a) == null) {
          break;
        }
        xov.a(this.a).b(paramObject, paramInt, xov.a(this.a).a());
        return;
      }
    }
    xov.a(this.a).a(xov.a(this.a).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xoy
 * JD-Core Version:    0.7.0.1
 */