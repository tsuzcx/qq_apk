import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView;

public class vrw
  implements vrm
{
  private vrw(StoryPlayerCommentListView paramStoryPlayerCommentListView) {}
  
  public void a()
  {
    this.a.p();
  }
  
  public void a(@NonNull wiq paramwiq, ErrorMessage paramErrorMessage, boolean paramBoolean)
  {
    Object localObject;
    if (paramErrorMessage.isSuccess())
    {
      localObject = "suc";
      wxe.a("Q.qqstory.player.StoryPlayerCommentListView", "on cache item back %s:%s ", localObject, paramwiq);
      boolean bool = StoryPlayerCommentListView.a(this.a).a();
      localObject = (vrp)this.a.a("PlayerCommentSegment");
      if (localObject != null) {
        ((vrp)localObject).a(paramwiq);
      }
      localObject = (vrt)this.a.a("PlayerDoubleTabSegment");
      if (localObject != null) {
        ((vrt)localObject).a(paramwiq);
      }
      localObject = (vro)this.a.a("PlayerCommentEmptySegment");
      if (localObject != null)
      {
        ((vro)localObject).a(paramwiq);
        if (!paramBoolean) {
          break label183;
        }
        ((vro)localObject).a(true);
      }
      label118:
      localObject = this.a;
      if (paramwiq.a(bool)) {
        break label192;
      }
    }
    label183:
    label192:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((StoryPlayerCommentListView)localObject).setLoadMoreComplete("CommentFloatDialog", true, paramBoolean);
      this.a.p();
      if (StoryPlayerCommentListView.a(this.a) != null) {
        StoryPlayerCommentListView.a(this.a).a(paramwiq, paramErrorMessage);
      }
      return;
      localObject = "fail";
      break;
      ((vro)localObject).a(false);
      break label118;
    }
  }
  
  public void a(@NonNull wiq paramwiq, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = "suc";
      wxe.a("Q.qqstory.player.StoryPlayerCommentListView", "on comment item back %s: %s", localObject, paramwiq);
      boolean bool = StoryPlayerCommentListView.a(this.a).a();
      localObject = (vrp)this.a.a("PlayerCommentSegment");
      if (localObject != null) {
        ((vrp)localObject).a(paramwiq);
      }
      localObject = (vrt)this.a.a("PlayerDoubleTabSegment");
      if (localObject != null) {
        ((vrt)localObject).a(paramwiq);
      }
      localObject = (vro)this.a.a("PlayerCommentEmptySegment");
      if (localObject != null)
      {
        ((vro)localObject).a(paramwiq);
        ((vro)localObject).a(false);
      }
      if (!paramBoolean) {
        break label159;
      }
      localObject = this.a;
      if (paramwiq.a(bool)) {
        break label154;
      }
      paramBoolean = true;
      label130:
      ((StoryPlayerCommentListView)localObject).setLoadMoreComplete("CommentFloatDialog", true, paramBoolean);
    }
    for (;;)
    {
      this.a.p();
      return;
      localObject = "fail";
      break;
      label154:
      paramBoolean = false;
      break label130;
      label159:
      this.a.setLoadMoreComplete("CommentFloatDialog", false, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vrw
 * JD-Core Version:    0.7.0.1
 */