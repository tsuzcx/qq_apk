import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView;

public class vnn
  implements vnd
{
  private vnn(StoryPlayerCommentListView paramStoryPlayerCommentListView) {}
  
  public void a()
  {
    this.a.p();
  }
  
  public void a(@NonNull weh paramweh, ErrorMessage paramErrorMessage, boolean paramBoolean)
  {
    Object localObject;
    if (paramErrorMessage.isSuccess())
    {
      localObject = "suc";
      wsv.a("Q.qqstory.player.StoryPlayerCommentListView", "on cache item back %s:%s ", localObject, paramweh);
      boolean bool = StoryPlayerCommentListView.a(this.a).a();
      localObject = (vng)this.a.a("PlayerCommentSegment");
      if (localObject != null) {
        ((vng)localObject).a(paramweh);
      }
      localObject = (vnk)this.a.a("PlayerDoubleTabSegment");
      if (localObject != null) {
        ((vnk)localObject).a(paramweh);
      }
      localObject = (vnf)this.a.a("PlayerCommentEmptySegment");
      if (localObject != null)
      {
        ((vnf)localObject).a(paramweh);
        if (!paramBoolean) {
          break label183;
        }
        ((vnf)localObject).a(true);
      }
      label118:
      localObject = this.a;
      if (paramweh.a(bool)) {
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
        StoryPlayerCommentListView.a(this.a).a(paramweh, paramErrorMessage);
      }
      return;
      localObject = "fail";
      break;
      ((vnf)localObject).a(false);
      break label118;
    }
  }
  
  public void a(@NonNull weh paramweh, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = "suc";
      wsv.a("Q.qqstory.player.StoryPlayerCommentListView", "on comment item back %s: %s", localObject, paramweh);
      boolean bool = StoryPlayerCommentListView.a(this.a).a();
      localObject = (vng)this.a.a("PlayerCommentSegment");
      if (localObject != null) {
        ((vng)localObject).a(paramweh);
      }
      localObject = (vnk)this.a.a("PlayerDoubleTabSegment");
      if (localObject != null) {
        ((vnk)localObject).a(paramweh);
      }
      localObject = (vnf)this.a.a("PlayerCommentEmptySegment");
      if (localObject != null)
      {
        ((vnf)localObject).a(paramweh);
        ((vnf)localObject).a(false);
      }
      if (!paramBoolean) {
        break label159;
      }
      localObject = this.a;
      if (paramweh.a(bool)) {
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
 * Qualified Name:     vnn
 * JD-Core Version:    0.7.0.1
 */