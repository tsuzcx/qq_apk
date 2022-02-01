import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspAddFeedComment;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

final class pql
  implements prm
{
  pql(pqh.d paramd, CommentEntry paramCommentEntry, psa parampsa, boolean paramBoolean1, CommentLikeFeedItem paramCommentLikeFeedItem, int paramInt, boolean paramBoolean2) {}
  
  public void a(MessageMicro paramMessageMicro)
  {
    paramMessageMicro = (qqstory_service.RspAddFeedComment)paramMessageMicro;
    if (this.a.a(this.jdField_b_of_type_ComTencentBizQqstoryDatabaseCommentEntry, paramMessageMicro)) {
      return;
    }
    this.jdField_b_of_type_Psa.e(this.jdField_b_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
    this.jdField_b_of_type_ComTencentBizQqstoryDatabaseCommentEntry.commentId = paramMessageMicro.comment_id.get();
    this.jdField_b_of_type_ComTencentBizQqstoryDatabaseCommentEntry.status = 0;
    this.jdField_b_of_type_Psa.c(this.jdField_b_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
  }
  
  public void aJ(int paramInt, String paramString)
  {
    this.jdField_b_of_type_ComTencentBizQqstoryDatabaseCommentEntry.status = 2;
    this.jdField_b_of_type_Psa.d(this.jdField_b_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
    if (paramInt == 10407) {
      rar.a("play_video", "exp_limit", 0, 0, new String[] { "", "", "", "" });
    }
    if (QLog.isColorLevel()) {
      QLog.e("FeedCommentLego", 2, "ReqAddComment fails: " + paramInt + "|" + paramString);
    }
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = acfp.m(2131706152);
    }
    QQToast.a(BaseApplication.getContext(), 1, str, 0).show();
  }
  
  public void h(int paramInt, Bundle paramBundle)
  {
    if (this.aBg)
    {
      pqj.b(this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem, this.jdField_b_of_type_ComTencentBizQqstoryDatabaseCommentEntry, this.bjT, this.a, false, this.aBh);
      int i;
      if (this.jdField_b_of_type_ComTencentBizQqstoryDatabaseCommentEntry.isReply())
      {
        paramInt = 2;
        i = rar.a(this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
        if (!this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {
          break label117;
        }
      }
      label117:
      for (paramBundle = "1";; paramBundle = "2")
      {
        rar.a("home_page", "comment_auto", i, paramInt, new String[] { paramBundle, rar.bX(this.bjT), "", this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
        return;
        paramInt = 1;
        break;
      }
    }
    this.jdField_b_of_type_ComTencentBizQqstoryDatabaseCommentEntry.status = 2;
    this.jdField_b_of_type_Psa.d(this.jdField_b_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
    if (QLog.isColorLevel()) {
      QLog.e("FeedCommentLego", 2, "ReqAddComment errorCode " + paramInt);
    }
    QQToast.a(BaseApplication.getContext(), 1, acfp.m(2131706117), 0).show();
  }
  
  public void q(boolean paramBoolean, Bundle paramBundle)
  {
    pqy.a().bmw();
    if ((this.aBg) && (!paramBoolean))
    {
      pre.a().a(this.jdField_b_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      return;
    }
    pqj.b(this.bjT, 1, this.jdField_b_of_type_ComTencentBizQqstoryDatabaseCommentEntry.feedId, this.jdField_b_of_type_ComTencentBizQqstoryDatabaseCommentEntry.commentId);
    boolean bool;
    int i;
    label93:
    label100:
    String str2;
    String str3;
    if ((paramBoolean) && (this.jdField_b_of_type_ComTencentBizQqstoryDatabaseCommentEntry.status == 0))
    {
      bool = true;
      this.a.a(bool, paramBundle, this.jdField_b_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      if (!this.jdField_b_of_type_ComTencentBizQqstoryDatabaseCommentEntry.isReply()) {
        break label202;
      }
      i = 2;
      if (!paramBoolean) {
        break label207;
      }
      paramBundle = "comment_suc";
      str2 = rar.gc("home_page-comment_suc-d1");
      str3 = pre.a().auz;
      if (!this.aBh) {
        break label213;
      }
    }
    label202:
    label207:
    label213:
    for (int j = 12;; j = rar.a(this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem))
    {
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = "0";
      }
      rar.a("home_page", paramBundle, j, i, new String[] { str1, rar.bX(this.bjT), str3, this.jdField_b_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      pre.a().a(this.jdField_b_of_type_ComTencentBizQqstoryDatabaseCommentEntry);
      return;
      bool = false;
      break;
      i = 1;
      break label93;
      paramBundle = "comment_fail";
      break label100;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pql
 * JD-Core Version:    0.7.0.1
 */