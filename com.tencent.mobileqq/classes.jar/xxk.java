import android.os.Bundle;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspAddFeedComment;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.concurrent.atomic.AtomicBoolean;

class xxk
  extends wgl
{
  xxk(xxi paramxxi) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle, CommentEntry paramCommentEntry)
  {
    ykq.a("Q.qqstory.detail.StoryDetailPresenter", "post comment result is %s.", Boolean.valueOf(paramBoolean));
    if (!xxi.a(this.a).get()) {
      xxi.a(this.a).c();
    }
  }
  
  public boolean a(CommentEntry paramCommentEntry, qqstory_service.RspAddFeedComment paramRspAddFeedComment)
  {
    wip localwip = (wip)wjs.a(17);
    localwip.a(paramCommentEntry.commentId);
    paramCommentEntry.commentId = paramRspAddFeedComment.comment_id.get();
    paramCommentEntry.status = 0;
    localwip.a(paramCommentEntry);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xxk
 * JD-Core Version:    0.7.0.1
 */