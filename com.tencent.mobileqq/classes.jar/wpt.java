import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialog.OnCommentListViewStateChangeListener.1;
import com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView;
import com.tencent.widget.XEditTextEx;

public class wpt
  implements wqm
{
  private wpt(wpl paramwpl) {}
  
  public void a()
  {
    if (!wpl.b(this.a)) {
      this.a.a();
    }
  }
  
  public void a(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    if (wpl.a(this.a) != null) {
      wpl.a(this.a).a(paramCommentEntry, paramInt1, paramInt2);
    }
  }
  
  public void a(@NonNull xhh paramxhh, ErrorMessage paramErrorMessage)
  {
    if (paramErrorMessage.isSuccess())
    {
      wpl.a(this.a, paramxhh);
      wpl.a(this.a).setVisibility(0);
      wpl.a(this.a, new xhw(this.a.getContext(), wpl.b(this.a), paramxhh, false, 4444, new wpq(this.a, null)));
      if (wpl.a(this.a).a != null) {
        wpl.a(this.a).a.setText(wpl.a(this.a).a);
      }
      if (wpl.a(this.a))
      {
        wpl.a(this.a, false);
        wpl.a(this.a).postDelayed(new CommentFloatDialog.OnCommentListViewStateChangeListener.1(this), 100);
      }
      return;
    }
    wpl.a(this.a).setVisibility(8);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 1) && (wpl.a(this.a) != null) && (wpl.a(this.a).a()))
    {
      wpl.a(this.a).c();
      return true;
    }
    return false;
  }
  
  public void b(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    if (wpl.a(this.a) != null) {
      wpl.a(this.a).b(paramCommentEntry, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wpt
 * JD-Core Version:    0.7.0.1
 */