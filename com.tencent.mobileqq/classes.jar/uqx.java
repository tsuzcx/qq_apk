import android.os.Bundle;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspAddFeedComment;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.concurrent.atomic.AtomicBoolean;

class uqx
  extends szr
{
  uqx(uqv paramuqv) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle, CommentEntry paramCommentEntry)
  {
    ved.a("Q.qqstory.detail.StoryDetailPresenter", "post comment result is %s.", Boolean.valueOf(paramBoolean));
    if (!uqv.a(this.a).get()) {
      uqv.a(this.a).c();
    }
  }
  
  public boolean a(CommentEntry paramCommentEntry, qqstory_service.RspAddFeedComment paramRspAddFeedComment)
  {
    tbw localtbw = (tbw)tcz.a(17);
    localtbw.a(paramCommentEntry.commentId);
    paramCommentEntry.commentId = paramRspAddFeedComment.comment_id.get();
    paramCommentEntry.status = 0;
    localtbw.a(paramCommentEntry);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uqx
 * JD-Core Version:    0.7.0.1
 */