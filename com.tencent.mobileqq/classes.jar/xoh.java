import android.os.Bundle;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspAddFeedComment;
import com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView;
import com.tencent.mobileqq.pb.PBUInt32Field;

class xoh
  extends wpz
{
  xoh(xof paramxof) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle, CommentEntry paramCommentEntry)
  {
    yuk.a("Q.qqstory.player.CommentFloatDialog", "post comment result is %s.", Boolean.valueOf(paramBoolean));
    if (!xoa.b(this.a.a)) {
      xoa.a(this.a.a).p();
    }
  }
  
  public boolean a(CommentEntry paramCommentEntry, qqstory_service.RspAddFeedComment paramRspAddFeedComment)
  {
    wse localwse = (wse)wth.a(17);
    localwse.a(paramCommentEntry.commentId);
    paramCommentEntry.commentId = paramRspAddFeedComment.comment_id.get();
    paramCommentEntry.status = 0;
    localwse.a(paramCommentEntry);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xoh
 * JD-Core Version:    0.7.0.1
 */