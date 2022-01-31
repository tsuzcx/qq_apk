import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialog.OnCommentListViewStateChangeListener.1;
import com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView;
import com.tencent.widget.XEditTextEx;

public class vrc
  implements vrv
{
  private vrc(vqu paramvqu) {}
  
  public void a()
  {
    if (!vqu.b(this.a)) {
      this.a.a();
    }
  }
  
  public void a(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    if (vqu.a(this.a) != null) {
      vqu.a(this.a).a(paramCommentEntry, paramInt1, paramInt2);
    }
  }
  
  public void a(@NonNull wiq paramwiq, ErrorMessage paramErrorMessage)
  {
    if (paramErrorMessage.isSuccess())
    {
      vqu.a(this.a, paramwiq);
      vqu.a(this.a).setVisibility(0);
      vqu.a(this.a, new wjf(this.a.getContext(), vqu.b(this.a), paramwiq, false, 4444, new vqz(this.a, null)));
      if (vqu.a(this.a).a != null) {
        vqu.a(this.a).a.setText(vqu.a(this.a).a);
      }
      if (vqu.a(this.a))
      {
        vqu.a(this.a, false);
        vqu.a(this.a).postDelayed(new CommentFloatDialog.OnCommentListViewStateChangeListener.1(this), 100);
      }
      return;
    }
    vqu.a(this.a).setVisibility(8);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 1) && (vqu.a(this.a) != null) && (vqu.a(this.a).a()))
    {
      vqu.a(this.a).c();
      return true;
    }
    return false;
  }
  
  public void b(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    if (vqu.a(this.a) != null) {
      vqu.a(this.a).b(paramCommentEntry, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vrc
 * JD-Core Version:    0.7.0.1
 */