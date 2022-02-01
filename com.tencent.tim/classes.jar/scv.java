import android.app.Activity;
import android.view.View;
import com.tencent.biz.subscribe.comment.CommentEditText.a;
import com.tencent.biz.subscribe.comment.CommentInputPopupWindow.1.1;

public class scv
  implements CommentEditText.a
{
  public void dv(View paramView)
  {
    if (this.this$0.isShowing()) {
      scu.a(this.this$0).runOnUiThread(new CommentInputPopupWindow.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     scv
 * JD-Core Version:    0.7.0.1
 */