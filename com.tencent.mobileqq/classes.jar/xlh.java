import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView;

public class xlh
  implements xkx
{
  private xlh(StoryPlayerCommentListView paramStoryPlayerCommentListView) {}
  
  public void a()
  {
    this.a.p();
  }
  
  public void a(@NonNull ycb paramycb, ErrorMessage paramErrorMessage, boolean paramBoolean)
  {
    Object localObject;
    if (paramErrorMessage.isSuccess())
    {
      localObject = "suc";
      yqp.a("Q.qqstory.player.StoryPlayerCommentListView", "on cache item back %s:%s ", localObject, paramycb);
      boolean bool = StoryPlayerCommentListView.a(this.a).a();
      localObject = (xla)this.a.a("PlayerCommentSegment");
      if (localObject != null) {
        ((xla)localObject).a(paramycb);
      }
      localObject = (xle)this.a.a("PlayerDoubleTabSegment");
      if (localObject != null) {
        ((xle)localObject).a(paramycb);
      }
      localObject = (xkz)this.a.a("PlayerCommentEmptySegment");
      if (localObject != null)
      {
        ((xkz)localObject).a(paramycb);
        if (!paramBoolean) {
          break label183;
        }
        ((xkz)localObject).a(true);
      }
      label118:
      localObject = this.a;
      if (paramycb.a(bool)) {
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
        StoryPlayerCommentListView.a(this.a).a(paramycb, paramErrorMessage);
      }
      return;
      localObject = "fail";
      break;
      ((xkz)localObject).a(false);
      break label118;
    }
  }
  
  public void a(@NonNull ycb paramycb, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = "suc";
      yqp.a("Q.qqstory.player.StoryPlayerCommentListView", "on comment item back %s: %s", localObject, paramycb);
      boolean bool = StoryPlayerCommentListView.a(this.a).a();
      localObject = (xla)this.a.a("PlayerCommentSegment");
      if (localObject != null) {
        ((xla)localObject).a(paramycb);
      }
      localObject = (xle)this.a.a("PlayerDoubleTabSegment");
      if (localObject != null) {
        ((xle)localObject).a(paramycb);
      }
      localObject = (xkz)this.a.a("PlayerCommentEmptySegment");
      if (localObject != null)
      {
        ((xkz)localObject).a(paramycb);
        ((xkz)localObject).a(false);
      }
      if (!paramBoolean) {
        break label159;
      }
      localObject = this.a;
      if (paramycb.a(bool)) {
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
 * Qualified Name:     xlh
 * JD-Core Version:    0.7.0.1
 */