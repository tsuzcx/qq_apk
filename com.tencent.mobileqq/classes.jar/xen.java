import android.os.Bundle;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspAddFeedComment;
import com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView;
import com.tencent.mobileqq.pb.PBUInt32Field;

class xen
  extends wgl
{
  xen(xel paramxel) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle, CommentEntry paramCommentEntry)
  {
    ykq.a("Q.qqstory.player.CommentFloatDialog", "post comment result is %s.", Boolean.valueOf(paramBoolean));
    if (!xeg.b(this.a.a)) {
      xeg.a(this.a.a).p();
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
 * Qualified Name:     xen
 * JD-Core Version:    0.7.0.1
 */