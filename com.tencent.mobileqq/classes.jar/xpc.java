import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView;

public class xpc
  implements xos
{
  private xpc(StoryPlayerCommentListView paramStoryPlayerCommentListView) {}
  
  public void a()
  {
    this.a.p();
  }
  
  public void a(@NonNull yfw paramyfw, ErrorMessage paramErrorMessage, boolean paramBoolean)
  {
    Object localObject;
    if (paramErrorMessage.isSuccess())
    {
      localObject = "suc";
      yuk.a("Q.qqstory.player.StoryPlayerCommentListView", "on cache item back %s:%s ", localObject, paramyfw);
      boolean bool = StoryPlayerCommentListView.a(this.a).a();
      localObject = (xov)this.a.a("PlayerCommentSegment");
      if (localObject != null) {
        ((xov)localObject).a(paramyfw);
      }
      localObject = (xoz)this.a.a("PlayerDoubleTabSegment");
      if (localObject != null) {
        ((xoz)localObject).a(paramyfw);
      }
      localObject = (xou)this.a.a("PlayerCommentEmptySegment");
      if (localObject != null)
      {
        ((xou)localObject).a(paramyfw);
        if (!paramBoolean) {
          break label183;
        }
        ((xou)localObject).a(true);
      }
      label118:
      localObject = this.a;
      if (paramyfw.a(bool)) {
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
        StoryPlayerCommentListView.a(this.a).a(paramyfw, paramErrorMessage);
      }
      return;
      localObject = "fail";
      break;
      ((xou)localObject).a(false);
      break label118;
    }
  }
  
  public void a(@NonNull yfw paramyfw, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = "suc";
      yuk.a("Q.qqstory.player.StoryPlayerCommentListView", "on comment item back %s: %s", localObject, paramyfw);
      boolean bool = StoryPlayerCommentListView.a(this.a).a();
      localObject = (xov)this.a.a("PlayerCommentSegment");
      if (localObject != null) {
        ((xov)localObject).a(paramyfw);
      }
      localObject = (xoz)this.a.a("PlayerDoubleTabSegment");
      if (localObject != null) {
        ((xoz)localObject).a(paramyfw);
      }
      localObject = (xou)this.a.a("PlayerCommentEmptySegment");
      if (localObject != null)
      {
        ((xou)localObject).a(paramyfw);
        ((xou)localObject).a(false);
      }
      if (!paramBoolean) {
        break label159;
      }
      localObject = this.a;
      if (paramyfw.a(bool)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xpc
 * JD-Core Version:    0.7.0.1
 */