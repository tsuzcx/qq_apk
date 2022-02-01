import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView;

public class wqn
  implements wqd
{
  private wqn(StoryPlayerCommentListView paramStoryPlayerCommentListView) {}
  
  public void a()
  {
    this.a.p();
  }
  
  public void a(@NonNull xhh paramxhh, ErrorMessage paramErrorMessage, boolean paramBoolean)
  {
    Object localObject;
    if (paramErrorMessage.isSuccess())
    {
      localObject = "suc";
      xvv.a("Q.qqstory.player.StoryPlayerCommentListView", "on cache item back %s:%s ", localObject, paramxhh);
      boolean bool = StoryPlayerCommentListView.a(this.a).a();
      localObject = (wqg)this.a.a("PlayerCommentSegment");
      if (localObject != null) {
        ((wqg)localObject).a(paramxhh);
      }
      localObject = (wqk)this.a.a("PlayerDoubleTabSegment");
      if (localObject != null) {
        ((wqk)localObject).a(paramxhh);
      }
      localObject = (wqf)this.a.a("PlayerCommentEmptySegment");
      if (localObject != null)
      {
        ((wqf)localObject).a(paramxhh);
        if (!paramBoolean) {
          break label183;
        }
        ((wqf)localObject).a(true);
      }
      label118:
      localObject = this.a;
      if (paramxhh.a(bool)) {
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
        StoryPlayerCommentListView.a(this.a).a(paramxhh, paramErrorMessage);
      }
      return;
      localObject = "fail";
      break;
      ((wqf)localObject).a(false);
      break label118;
    }
  }
  
  public void a(@NonNull xhh paramxhh, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = "suc";
      xvv.a("Q.qqstory.player.StoryPlayerCommentListView", "on comment item back %s: %s", localObject, paramxhh);
      boolean bool = StoryPlayerCommentListView.a(this.a).a();
      localObject = (wqg)this.a.a("PlayerCommentSegment");
      if (localObject != null) {
        ((wqg)localObject).a(paramxhh);
      }
      localObject = (wqk)this.a.a("PlayerDoubleTabSegment");
      if (localObject != null) {
        ((wqk)localObject).a(paramxhh);
      }
      localObject = (wqf)this.a.a("PlayerCommentEmptySegment");
      if (localObject != null)
      {
        ((wqf)localObject).a(paramxhh);
        ((wqf)localObject).a(false);
      }
      if (!paramBoolean) {
        break label159;
      }
      localObject = this.a;
      if (paramxhh.a(bool)) {
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
 * Qualified Name:     wqn
 * JD-Core Version:    0.7.0.1
 */