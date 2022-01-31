import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.playvideo.floatdialog.CommentFloatDialog.OnCommentListViewStateChangeListener.1;
import com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView;
import com.tencent.widget.XEditTextEx;

public class vmt
  implements vnm
{
  private vmt(vml paramvml) {}
  
  public void a()
  {
    if (!vml.b(this.a)) {
      this.a.a();
    }
  }
  
  public void a(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    if (vml.a(this.a) != null) {
      vml.a(this.a).a(paramCommentEntry, paramInt1, paramInt2);
    }
  }
  
  public void a(@NonNull weh paramweh, ErrorMessage paramErrorMessage)
  {
    if (paramErrorMessage.isSuccess())
    {
      vml.a(this.a, paramweh);
      vml.a(this.a).setVisibility(0);
      vml.a(this.a, new wew(this.a.getContext(), vml.b(this.a), paramweh, false, 4444, new vmq(this.a, null)));
      if (vml.a(this.a).a != null) {
        vml.a(this.a).a.setText(vml.a(this.a).a);
      }
      if (vml.a(this.a))
      {
        vml.a(this.a, false);
        vml.a(this.a).postDelayed(new CommentFloatDialog.OnCommentListViewStateChangeListener.1(this), 100);
      }
      return;
    }
    vml.a(this.a).setVisibility(8);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 1) && (vml.a(this.a) != null) && (vml.a(this.a).a()))
    {
      vml.a(this.a).c();
      return true;
    }
    return false;
  }
  
  public void b(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    if (vml.a(this.a) != null) {
      vml.a(this.a).b(paramCommentEntry, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vmt
 * JD-Core Version:    0.7.0.1
 */