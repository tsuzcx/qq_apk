import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialog.OnCommentListViewStateChangeListener.1;
import com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView;
import com.tencent.widget.XEditTextEx;

public class tyb
  implements tyu
{
  private tyb(txt paramtxt) {}
  
  public void a()
  {
    if (!txt.b(this.a)) {
      this.a.a();
    }
  }
  
  public void a(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    if (txt.a(this.a) != null) {
      txt.a(this.a).a(paramCommentEntry, paramInt1, paramInt2);
    }
  }
  
  public void a(@NonNull upp paramupp, ErrorMessage paramErrorMessage)
  {
    if (paramErrorMessage.isSuccess())
    {
      txt.a(this.a, paramupp);
      txt.a(this.a).setVisibility(0);
      txt.a(this.a, new uqe(this.a.getContext(), txt.b(this.a), paramupp, false, 4444, new txy(this.a, null)));
      if (txt.a(this.a).a != null) {
        txt.a(this.a).a.setText(txt.a(this.a).a);
      }
      if (txt.a(this.a))
      {
        txt.a(this.a, false);
        txt.a(this.a).postDelayed(new CommentFloatDialog.OnCommentListViewStateChangeListener.1(this), 100);
      }
      return;
    }
    txt.a(this.a).setVisibility(8);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 1) && (txt.a(this.a) != null) && (txt.a(this.a).a()))
    {
      txt.a(this.a).c();
      return true;
    }
    return false;
  }
  
  public void b(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    if (txt.a(this.a) != null) {
      txt.a(this.a).b(paramCommentEntry, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tyb
 * JD-Core Version:    0.7.0.1
 */