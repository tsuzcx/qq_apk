import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class scd
  implements View.OnClickListener
{
  public scd(CommentBottomBar paramCommentBottomBar) {}
  
  public void onClick(View paramView)
  {
    if (CommentBottomBar.a(this.b) != null)
    {
      CommentBottomBar.a(this.b).c(CommentBottomBar.a(this.b), CommentBottomBar.a(this.b));
      CommentBottomBar.a(this.b);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     scd
 * JD-Core Version:    0.7.0.1
 */