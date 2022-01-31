import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialog.OnCommentListViewStateChangeListener.1;
import com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView;
import com.tencent.widget.XEditTextEx;

public class tli
  implements tmb
{
  private tli(tla paramtla) {}
  
  public void a()
  {
    if (!tla.b(this.a)) {
      this.a.a();
    }
  }
  
  public void a(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    if (tla.a(this.a) != null) {
      tla.a(this.a).a(paramCommentEntry, paramInt1, paramInt2);
    }
  }
  
  public void a(@NonNull ucw paramucw, ErrorMessage paramErrorMessage)
  {
    if (paramErrorMessage.isSuccess())
    {
      tla.a(this.a, paramucw);
      tla.a(this.a).setVisibility(0);
      tla.a(this.a, new udl(this.a.getContext(), tla.b(this.a), paramucw, false, 4444, new tlf(this.a, null)));
      if (tla.a(this.a).a != null) {
        tla.a(this.a).a.setText(tla.a(this.a).a);
      }
      if (tla.a(this.a))
      {
        tla.a(this.a, false);
        tla.a(this.a).postDelayed(new CommentFloatDialog.OnCommentListViewStateChangeListener.1(this), 100);
      }
      return;
    }
    tla.a(this.a).setVisibility(8);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 1) && (tla.a(this.a) != null) && (tla.a(this.a).a()))
    {
      tla.a(this.a).c();
      return true;
    }
    return false;
  }
  
  public void b(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    if (tla.a(this.a) != null) {
      tla.a(this.a).b(paramCommentEntry, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tli
 * JD-Core Version:    0.7.0.1
 */