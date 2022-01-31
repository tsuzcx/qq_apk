import android.view.View;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import java.util.List;

public class vnj
  extends wna
{
  public vnj(vng paramvng) {}
  
  public void a(int paramInt, View paramView, Object paramObject, wph paramwph)
  {
    if ((paramInt < 0) || (paramInt > this.a.a.a(vng.a(this.a)).size())) {}
    do
    {
      return;
      paramObject = (CommentEntry)this.a.a.a(vng.a(this.a)).get(paramInt);
      switch (paramView.getId())
      {
      default: 
        return;
      }
    } while ((paramObject.authorRole == 1002) || (paramObject.authorRole == 1003));
    ume.a(paramView.getContext(), 12, paramObject.authorUnionId);
    return;
    if (vng.a(this.a) != null) {
      vng.a(this.a).a(paramObject, paramInt, vng.a(this.a).a());
    }
    vng.a(this.a).a(vng.a(this.a).a());
  }
  
  public void b(int paramInt, View paramView, Object paramObject, wph paramwph)
  {
    if ((paramInt < 0) || (paramInt > this.a.a.a(vng.a(this.a)).size())) {
      return;
    }
    paramObject = (CommentEntry)this.a.a.a(vng.a(this.a)).get(paramInt);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131364541: 
      paramView = vng.a(this.a).a();
      if ((paramView != null) && (paramView.a != null)) {
        if (!paramView.a.getOwner().isMe()) {
          break label194;
        }
      }
      label194:
      for (paramView = "2";; paramView = "1")
      {
        wta.a("home_page", "press_reply", 0, 0, new String[] { paramView, wta.a(vng.a(this.a)) });
        if (vng.a(this.a) == null) {
          break;
        }
        vng.a(this.a).b(paramObject, paramInt, vng.a(this.a).a());
        return;
      }
    }
    vng.a(this.a).a(vng.a(this.a).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vnj
 * JD-Core Version:    0.7.0.1
 */