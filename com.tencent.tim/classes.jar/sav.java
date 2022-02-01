import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedDetailRsp;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class sav
  implements scw.c
{
  sav(sat paramsat) {}
  
  public void a(CertifiedAccountRead.StGetFeedDetailRsp paramStGetFeedDetailRsp, boolean paramBoolean, long paramLong, String paramString)
  {
    if (paramStGetFeedDetailRsp == null)
    {
      QLog.e(sat.TAG, 1, "onFeedResponse rsp is null");
      return;
    }
    CertifiedAccountMeta.StFeed localStFeed = (CertifiedAccountMeta.StFeed)paramStGetFeedDetailRsp.feed.get();
    QLog.d(sat.TAG, 1, "onFeedResponse hideLoadingView!");
    this.this$0.hideLoadingView();
    boolean bool = sat.a(this.this$0, paramLong, localStFeed);
    String str = sat.TAG;
    StringBuilder localStringBuilder = new StringBuilder().append("isInterceptRspByFeedStatus ").append(bool).append(",status ");
    if (localStFeed == null) {}
    for (Object localObject = "none";; localObject = Integer.valueOf(localStFeed.status.get()))
    {
      QLog.i(str, 2, localObject);
      if (!bool) {
        break;
      }
      this.this$0.G(paramLong, paramString);
      return;
    }
    this.this$0.b(localStFeed);
    sat.a(this.this$0, paramStGetFeedDetailRsp.share);
    sat.a(this.this$0, paramStGetFeedDetailRsp.detailUrl.get());
    sat.b(this.this$0, paramStGetFeedDetailRsp.share);
    this.this$0.a(localStFeed);
    QLog.i(sat.TAG, 1, "isFinish:" + paramStGetFeedDetailRsp.isFinish.get() + " | recommend feeds size:" + paramStGetFeedDetailRsp.vecRcmdFeed.get().size());
    this.this$0.a(paramStGetFeedDetailRsp, paramBoolean);
    if (!paramBoolean) {
      sqn.b(this.this$0.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_" + siu.b(this.this$0.getExtraTypeInfo()), "exp", 0, 0, new String[] { "", "", localStFeed.id.get(), localStFeed.title.get() });
    }
    this.this$0.notifyLoadingComplete(true);
  }
  
  public void yk(int paramInt)
  {
    if (this.this$0.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar != null) {
      this.this$0.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.el(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sav
 * JD-Core Version:    0.7.0.1
 */