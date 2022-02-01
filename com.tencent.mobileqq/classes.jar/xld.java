import android.view.View;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.util.List;

public class xld
  extends yku
{
  public xld(xla paramxla) {}
  
  public void a(int paramInt, View paramView, Object paramObject, ynb paramynb)
  {
    if ((paramInt < 0) || (paramInt > this.a.a.a(xla.a(this.a)).size())) {}
    do
    {
      return;
      paramObject = (CommentEntry)this.a.a.a(xla.a(this.a)).get(paramInt);
      switch (paramView.getId())
      {
      default: 
        return;
      }
    } while ((paramObject.authorRole == 1002) || (paramObject.authorRole == 1003));
    wjz.a(paramView.getContext(), 12, paramObject.authorUnionId);
    return;
    if (xla.a(this.a) != null) {
      xla.a(this.a).a(paramObject, paramInt, xla.a(this.a).a());
    }
    xla.a(this.a).a(xla.a(this.a).a());
  }
  
  public void b(int paramInt, View paramView, Object paramObject, ynb paramynb)
  {
    if ((paramInt < 0) || (paramInt > this.a.a.a(xla.a(this.a)).size())) {
      return;
    }
    paramObject = (CommentEntry)this.a.a.a(xla.a(this.a)).get(paramInt);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131364759: 
      paramView = xla.a(this.a).a();
      if ((paramView != null) && (paramView.a != null)) {
        if (!paramView.a.getOwner().isMe()) {
          break label194;
        }
      }
      label194:
      for (paramView = "2";; paramView = "1")
      {
        yqu.a("home_page", "press_reply", 0, 0, new String[] { paramView, yqu.a(xla.a(this.a)) });
        if (xla.a(this.a) == null) {
          break;
        }
        xla.a(this.a).b(paramObject, paramInt, xla.a(this.a).a());
        return;
      }
    }
    xla.a(this.a).a(xla.a(this.a).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xld
 * JD-Core Version:    0.7.0.1
 */