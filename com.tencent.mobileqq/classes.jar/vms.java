import android.os.Bundle;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspAddFeedComment;
import com.tencent.biz.qqstory.playvideo.floatdialog.StoryPlayerCommentListView;
import com.tencent.mobileqq.pb.PBUInt32Field;

class vms
  extends uoj
{
  vms(vmq paramvmq) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle, CommentEntry paramCommentEntry)
  {
    wsv.a("Q.qqstory.player.CommentFloatDialog", "post comment result is %s.", Boolean.valueOf(paramBoolean));
    if (!vml.b(this.a.a)) {
      vml.a(this.a.a).p();
    }
  }
  
  public boolean a(CommentEntry paramCommentEntry, qqstory_service.RspAddFeedComment paramRspAddFeedComment)
  {
    uqo localuqo = (uqo)urr.a(17);
    localuqo.a(paramCommentEntry.commentId);
    paramCommentEntry.commentId = paramRspAddFeedComment.comment_id.get();
    paramCommentEntry.status = 0;
    localuqo.a(paramCommentEntry);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vms
 * JD-Core Version:    0.7.0.1
 */