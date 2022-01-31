import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialog.OnCommentListViewStateChangeListener.1;
import com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView;
import com.tencent.widget.XEditTextEx;

public class tye
  implements tyx
{
  private tye(txw paramtxw) {}
  
  public void a()
  {
    if (!txw.b(this.a)) {
      this.a.a();
    }
  }
  
  public void a(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    if (txw.a(this.a) != null) {
      txw.a(this.a).a(paramCommentEntry, paramInt1, paramInt2);
    }
  }
  
  public void a(@NonNull ups paramups, ErrorMessage paramErrorMessage)
  {
    if (paramErrorMessage.isSuccess())
    {
      txw.a(this.a, paramups);
      txw.a(this.a).setVisibility(0);
      txw.a(this.a, new uqh(this.a.getContext(), txw.b(this.a), paramups, false, 4444, new tyb(this.a, null)));
      if (txw.a(this.a).a != null) {
        txw.a(this.a).a.setText(txw.a(this.a).a);
      }
      if (txw.a(this.a))
      {
        txw.a(this.a, false);
        txw.a(this.a).postDelayed(new CommentFloatDialog.OnCommentListViewStateChangeListener.1(this), 100);
      }
      return;
    }
    txw.a(this.a).setVisibility(8);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 1) && (txw.a(this.a) != null) && (txw.a(this.a).a()))
    {
      txw.a(this.a).c();
      return true;
    }
    return false;
  }
  
  public void b(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    if (txw.a(this.a) != null) {
      txw.a(this.a).b(paramCommentEntry, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tye
 * JD-Core Version:    0.7.0.1
 */