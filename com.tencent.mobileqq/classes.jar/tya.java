import android.os.Bundle;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspAddFeedComment;
import com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView;
import com.tencent.mobileqq.pb.PBUInt32Field;

class tya
  extends szr
{
  tya(txy paramtxy) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle, CommentEntry paramCommentEntry)
  {
    ved.a("Q.qqstory.player.CommentFloatDialog", "post comment result is %s.", Boolean.valueOf(paramBoolean));
    if (!txt.b(this.a.a)) {
      txt.a(this.a.a).p();
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
 * Qualified Name:     tya
 * JD-Core Version:    0.7.0.1
 */