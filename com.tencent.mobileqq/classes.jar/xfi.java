import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView;

public class xfi
  implements xey
{
  private xfi(StoryPlayerCommentListView paramStoryPlayerCommentListView) {}
  
  public void a()
  {
    this.a.p();
  }
  
  public void a(@NonNull xwc paramxwc, ErrorMessage paramErrorMessage, boolean paramBoolean)
  {
    Object localObject;
    if (paramErrorMessage.isSuccess())
    {
      localObject = "suc";
      ykq.a("Q.qqstory.player.StoryPlayerCommentListView", "on cache item back %s:%s ", localObject, paramxwc);
      boolean bool = StoryPlayerCommentListView.a(this.a).a();
      localObject = (xfb)this.a.a("PlayerCommentSegment");
      if (localObject != null) {
        ((xfb)localObject).a(paramxwc);
      }
      localObject = (xff)this.a.a("PlayerDoubleTabSegment");
      if (localObject != null) {
        ((xff)localObject).a(paramxwc);
      }
      localObject = (xfa)this.a.a("PlayerCommentEmptySegment");
      if (localObject != null)
      {
        ((xfa)localObject).a(paramxwc);
        if (!paramBoolean) {
          break label183;
        }
        ((xfa)localObject).a(true);
      }
      label118:
      localObject = this.a;
      if (paramxwc.a(bool)) {
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
        StoryPlayerCommentListView.a(this.a).a(paramxwc, paramErrorMessage);
      }
      return;
      localObject = "fail";
      break;
      ((xfa)localObject).a(false);
      break label118;
    }
  }
  
  public void a(@NonNull xwc paramxwc, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = "suc";
      ykq.a("Q.qqstory.player.StoryPlayerCommentListView", "on comment item back %s: %s", localObject, paramxwc);
      boolean bool = StoryPlayerCommentListView.a(this.a).a();
      localObject = (xfb)this.a.a("PlayerCommentSegment");
      if (localObject != null) {
        ((xfb)localObject).a(paramxwc);
      }
      localObject = (xff)this.a.a("PlayerDoubleTabSegment");
      if (localObject != null) {
        ((xff)localObject).a(paramxwc);
      }
      localObject = (xfa)this.a.a("PlayerCommentEmptySegment");
      if (localObject != null)
      {
        ((xfa)localObject).a(paramxwc);
        ((xfa)localObject).a(false);
      }
      if (!paramBoolean) {
        break label159;
      }
      localObject = this.a;
      if (paramxwc.a(bool)) {
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
 * Qualified Name:     xfi
 * JD-Core Version:    0.7.0.1
 */