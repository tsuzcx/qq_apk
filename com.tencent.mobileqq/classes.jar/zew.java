import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zew
  implements View.OnClickListener
{
  public zew(CommentBottomBar paramCommentBottomBar) {}
  
  public void onClick(View paramView)
  {
    if (CommentBottomBar.a(this.a) != null)
    {
      CommentBottomBar.a(this.a).a(CommentBottomBar.a(this.a), CommentBottomBar.a(this.a));
      CommentBottomBar.a(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zew
 * JD-Core Version:    0.7.0.1
 */