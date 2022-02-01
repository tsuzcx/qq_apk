import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialog.OnCommentListViewStateChangeListener.1;
import com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView;
import com.tencent.widget.XEditTextEx;

public class xoi
  implements xpb
{
  private xoi(xoa paramxoa) {}
  
  public void a()
  {
    if (!xoa.b(this.a)) {
      this.a.a();
    }
  }
  
  public void a(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    if (xoa.a(this.a) != null) {
      xoa.a(this.a).a(paramCommentEntry, paramInt1, paramInt2);
    }
  }
  
  public void a(@NonNull yfw paramyfw, ErrorMessage paramErrorMessage)
  {
    if (paramErrorMessage.isSuccess())
    {
      xoa.a(this.a, paramyfw);
      xoa.a(this.a).setVisibility(0);
      xoa.a(this.a, new ygl(this.a.getContext(), xoa.b(this.a), paramyfw, false, 4444, new xof(this.a, null)));
      if (xoa.a(this.a).a != null) {
        xoa.a(this.a).a.setText(xoa.a(this.a).a);
      }
      if (xoa.a(this.a))
      {
        xoa.a(this.a, false);
        xoa.a(this.a).postDelayed(new CommentFloatDialog.OnCommentListViewStateChangeListener.1(this), 100);
      }
      return;
    }
    xoa.a(this.a).setVisibility(8);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 1) && (xoa.a(this.a) != null) && (xoa.a(this.a).a()))
    {
      xoa.a(this.a).c();
      return true;
    }
    return false;
  }
  
  public void b(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    if (xoa.a(this.a) != null) {
      xoa.a(this.a).b(paramCommentEntry, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xoi
 * JD-Core Version:    0.7.0.1
 */