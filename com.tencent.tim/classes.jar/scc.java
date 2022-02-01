import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class scc
  implements View.OnClickListener
{
  public scc(CommentBottomBar paramCommentBottomBar) {}
  
  public void onClick(View paramView)
  {
    this.b.bxU();
    if (CommentBottomBar.a(this.b) != null) {
      CommentBottomBar.a(this.b).onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     scc
 * JD-Core Version:    0.7.0.1
 */