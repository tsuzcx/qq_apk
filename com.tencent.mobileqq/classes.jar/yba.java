import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.comment.CommentBottomBar;

public class yba
  implements View.OnClickListener
{
  public yba(CommentBottomBar paramCommentBottomBar) {}
  
  public void onClick(View paramView)
  {
    this.a.d();
    if (CommentBottomBar.a(this.a) != null) {
      CommentBottomBar.a(this.a).onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yba
 * JD-Core Version:    0.7.0.1
 */