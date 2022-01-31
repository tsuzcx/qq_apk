import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView;

public class tyy
  implements tyo
{
  private tyy(StoryPlayerCommentListView paramStoryPlayerCommentListView) {}
  
  public void a()
  {
    this.a.p();
  }
  
  public void a(@NonNull ups paramups, ErrorMessage paramErrorMessage, boolean paramBoolean)
  {
    Object localObject;
    if (paramErrorMessage.isSuccess())
    {
      localObject = "suc";
      veg.a("Q.qqstory.player.StoryPlayerCommentListView", "on cache item back %s:%s ", localObject, paramups);
      boolean bool = StoryPlayerCommentListView.a(this.a).a();
      localObject = (tyr)this.a.a("PlayerCommentSegment");
      if (localObject != null) {
        ((tyr)localObject).a(paramups);
      }
      localObject = (tyv)this.a.a("PlayerDoubleTabSegment");
      if (localObject != null) {
        ((tyv)localObject).a(paramups);
      }
      localObject = (tyq)this.a.a("PlayerCommentEmptySegment");
      if (localObject != null)
      {
        ((tyq)localObject).a(paramups);
        if (!paramBoolean) {
          break label183;
        }
        ((tyq)localObject).a(true);
      }
      label118:
      localObject = this.a;
      if (paramups.a(bool)) {
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
        StoryPlayerCommentListView.a(this.a).a(paramups, paramErrorMessage);
      }
      return;
      localObject = "fail";
      break;
      ((tyq)localObject).a(false);
      break label118;
    }
  }
  
  public void a(@NonNull ups paramups, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = "suc";
      veg.a("Q.qqstory.player.StoryPlayerCommentListView", "on comment item back %s: %s", localObject, paramups);
      boolean bool = StoryPlayerCommentListView.a(this.a).a();
      localObject = (tyr)this.a.a("PlayerCommentSegment");
      if (localObject != null) {
        ((tyr)localObject).a(paramups);
      }
      localObject = (tyv)this.a.a("PlayerDoubleTabSegment");
      if (localObject != null) {
        ((tyv)localObject).a(paramups);
      }
      localObject = (tyq)this.a.a("PlayerCommentEmptySegment");
      if (localObject != null)
      {
        ((tyq)localObject).a(paramups);
        ((tyq)localObject).a(false);
      }
      if (!paramBoolean) {
        break label159;
      }
      localObject = this.a;
      if (paramups.a(bool)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tyy
 * JD-Core Version:    0.7.0.1
 */