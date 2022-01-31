import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView;

public class tyv
  implements tyl
{
  private tyv(StoryPlayerCommentListView paramStoryPlayerCommentListView) {}
  
  public void a()
  {
    this.a.p();
  }
  
  public void a(@NonNull upp paramupp, ErrorMessage paramErrorMessage, boolean paramBoolean)
  {
    Object localObject;
    if (paramErrorMessage.isSuccess())
    {
      localObject = "suc";
      ved.a("Q.qqstory.player.StoryPlayerCommentListView", "on cache item back %s:%s ", localObject, paramupp);
      boolean bool = StoryPlayerCommentListView.a(this.a).a();
      localObject = (tyo)this.a.a("PlayerCommentSegment");
      if (localObject != null) {
        ((tyo)localObject).a(paramupp);
      }
      localObject = (tys)this.a.a("PlayerDoubleTabSegment");
      if (localObject != null) {
        ((tys)localObject).a(paramupp);
      }
      localObject = (tyn)this.a.a("PlayerCommentEmptySegment");
      if (localObject != null)
      {
        ((tyn)localObject).a(paramupp);
        if (!paramBoolean) {
          break label183;
        }
        ((tyn)localObject).a(true);
      }
      label118:
      localObject = this.a;
      if (paramupp.a(bool)) {
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
        StoryPlayerCommentListView.a(this.a).a(paramupp, paramErrorMessage);
      }
      return;
      localObject = "fail";
      break;
      ((tyn)localObject).a(false);
      break label118;
    }
  }
  
  public void a(@NonNull upp paramupp, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = "suc";
      ved.a("Q.qqstory.player.StoryPlayerCommentListView", "on comment item back %s: %s", localObject, paramupp);
      boolean bool = StoryPlayerCommentListView.a(this.a).a();
      localObject = (tyo)this.a.a("PlayerCommentSegment");
      if (localObject != null) {
        ((tyo)localObject).a(paramupp);
      }
      localObject = (tys)this.a.a("PlayerDoubleTabSegment");
      if (localObject != null) {
        ((tys)localObject).a(paramupp);
      }
      localObject = (tyn)this.a.a("PlayerCommentEmptySegment");
      if (localObject != null)
      {
        ((tyn)localObject).a(paramupp);
        ((tyn)localObject).a(false);
      }
      if (!paramBoolean) {
        break label159;
      }
      localObject = this.a;
      if (paramupp.a(bool)) {
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
 * Qualified Name:     tyv
 * JD-Core Version:    0.7.0.1
 */