import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialog.OnCommentListViewStateChangeListener.1;
import com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView;
import com.tencent.widget.XEditTextEx;

public class xeo
  implements xfh
{
  private xeo(xeg paramxeg) {}
  
  public void a()
  {
    if (!xeg.b(this.a)) {
      this.a.a();
    }
  }
  
  public void a(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    if (xeg.a(this.a) != null) {
      xeg.a(this.a).a(paramCommentEntry, paramInt1, paramInt2);
    }
  }
  
  public void a(@NonNull xwc paramxwc, ErrorMessage paramErrorMessage)
  {
    if (paramErrorMessage.isSuccess())
    {
      xeg.a(this.a, paramxwc);
      xeg.a(this.a).setVisibility(0);
      xeg.a(this.a, new xwr(this.a.getContext(), xeg.b(this.a), paramxwc, false, 4444, new xel(this.a, null)));
      if (xeg.a(this.a).a != null) {
        xeg.a(this.a).a.setText(xeg.a(this.a).a);
      }
      if (xeg.a(this.a))
      {
        xeg.a(this.a, false);
        xeg.a(this.a).postDelayed(new CommentFloatDialog.OnCommentListViewStateChangeListener.1(this), 100);
      }
      return;
    }
    xeg.a(this.a).setVisibility(8);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 1) && (xeg.a(this.a) != null) && (xeg.a(this.a).a()))
    {
      xeg.a(this.a).c();
      return true;
    }
    return false;
  }
  
  public void b(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    if (xeg.a(this.a) != null) {
      xeg.a(this.a).b(paramCommentEntry, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xeo
 * JD-Core Version:    0.7.0.1
 */