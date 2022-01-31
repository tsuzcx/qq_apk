import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView;

public class tmc
  implements tls
{
  private tmc(StoryPlayerCommentListView paramStoryPlayerCommentListView) {}
  
  public void a()
  {
    this.a.p();
  }
  
  public void a(@NonNull ucw paramucw, ErrorMessage paramErrorMessage, boolean paramBoolean)
  {
    Object localObject;
    if (paramErrorMessage.isSuccess())
    {
      localObject = "suc";
      urk.a("Q.qqstory.player.StoryPlayerCommentListView", "on cache item back %s:%s ", localObject, paramucw);
      boolean bool = StoryPlayerCommentListView.a(this.a).a();
      localObject = (tlv)this.a.a("PlayerCommentSegment");
      if (localObject != null) {
        ((tlv)localObject).a(paramucw);
      }
      localObject = (tlz)this.a.a("PlayerDoubleTabSegment");
      if (localObject != null) {
        ((tlz)localObject).a(paramucw);
      }
      localObject = (tlu)this.a.a("PlayerCommentEmptySegment");
      if (localObject != null)
      {
        ((tlu)localObject).a(paramucw);
        if (!paramBoolean) {
          break label183;
        }
        ((tlu)localObject).a(true);
      }
      label118:
      localObject = this.a;
      if (paramucw.a(bool)) {
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
        StoryPlayerCommentListView.a(this.a).a(paramucw, paramErrorMessage);
      }
      return;
      localObject = "fail";
      break;
      ((tlu)localObject).a(false);
      break label118;
    }
  }
  
  public void a(@NonNull ucw paramucw, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = "suc";
      urk.a("Q.qqstory.player.StoryPlayerCommentListView", "on comment item back %s: %s", localObject, paramucw);
      boolean bool = StoryPlayerCommentListView.a(this.a).a();
      localObject = (tlv)this.a.a("PlayerCommentSegment");
      if (localObject != null) {
        ((tlv)localObject).a(paramucw);
      }
      localObject = (tlz)this.a.a("PlayerDoubleTabSegment");
      if (localObject != null) {
        ((tlz)localObject).a(paramucw);
      }
      localObject = (tlu)this.a.a("PlayerCommentEmptySegment");
      if (localObject != null)
      {
        ((tlu)localObject).a(paramucw);
        ((tlu)localObject).a(false);
      }
      if (!paramBoolean) {
        break label159;
      }
      localObject = this.a;
      if (paramucw.a(bool)) {
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
 * Qualified Name:     tmc
 * JD-Core Version:    0.7.0.1
 */