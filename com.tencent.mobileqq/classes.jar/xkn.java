import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialog.OnCommentListViewStateChangeListener.1;
import com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView;
import com.tencent.widget.XEditTextEx;

public class xkn
  implements xlg
{
  private xkn(xkf paramxkf) {}
  
  public void a()
  {
    if (!xkf.b(this.a)) {
      this.a.a();
    }
  }
  
  public void a(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    if (xkf.a(this.a) != null) {
      xkf.a(this.a).a(paramCommentEntry, paramInt1, paramInt2);
    }
  }
  
  public void a(@NonNull ycb paramycb, ErrorMessage paramErrorMessage)
  {
    if (paramErrorMessage.isSuccess())
    {
      xkf.a(this.a, paramycb);
      xkf.a(this.a).setVisibility(0);
      xkf.a(this.a, new ycq(this.a.getContext(), xkf.b(this.a), paramycb, false, 4444, new xkk(this.a, null)));
      if (xkf.a(this.a).a != null) {
        xkf.a(this.a).a.setText(xkf.a(this.a).a);
      }
      if (xkf.a(this.a))
      {
        xkf.a(this.a, false);
        xkf.a(this.a).postDelayed(new CommentFloatDialog.OnCommentListViewStateChangeListener.1(this), 100);
      }
      return;
    }
    xkf.a(this.a).setVisibility(8);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 1) && (xkf.a(this.a) != null) && (xkf.a(this.a).a()))
    {
      xkf.a(this.a).c();
      return true;
    }
    return false;
  }
  
  public void b(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    if (xkf.a(this.a) != null) {
      xkf.a(this.a).b(paramCommentEntry, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xkn
 * JD-Core Version:    0.7.0.1
 */