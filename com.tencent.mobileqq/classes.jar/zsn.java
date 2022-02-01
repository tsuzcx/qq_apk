import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedDetailRsp;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class zsn
  implements zvg
{
  zsn(zsl paramzsl) {}
  
  public void a(int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar != null) {
      this.a.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a(paramInt);
    }
  }
  
  public void a(CertifiedAccountRead.StGetFeedDetailRsp paramStGetFeedDetailRsp, boolean paramBoolean, long paramLong, String paramString)
  {
    if (paramStGetFeedDetailRsp == null)
    {
      QLog.e(zsl.jdField_a_of_type_JavaLangString, 1, "onFeedResponse rsp is null");
      return;
    }
    CertifiedAccountMeta.StFeed localStFeed = (CertifiedAccountMeta.StFeed)paramStGetFeedDetailRsp.feed.get();
    QLog.d(zsl.jdField_a_of_type_JavaLangString, 1, "onFeedResponse hideLoadingView!");
    this.a.f();
    boolean bool = zsl.a(this.a, paramLong, localStFeed);
    String str = zsl.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append("isInterceptRspByFeedStatus ").append(bool).append(",status ");
    if (localStFeed == null) {}
    for (Object localObject = "none";; localObject = Integer.valueOf(localStFeed.status.get()))
    {
      QLog.i(str, 2, localObject);
      if (!bool) {
        break;
      }
      this.a.a(paramLong, paramString);
      return;
    }
    this.a.b(localStFeed);
    zsl.a(this.a, paramStGetFeedDetailRsp.share);
    zsl.a(this.a, paramStGetFeedDetailRsp.detailUrl.get());
    zsl.b(this.a, paramStGetFeedDetailRsp.share);
    this.a.a(localStFeed);
    QLog.i(zsl.jdField_a_of_type_JavaLangString, 1, "isFinish:" + paramStGetFeedDetailRsp.isFinish.get() + " | recommend feeds size:" + paramStGetFeedDetailRsp.vecRcmdFeed.get().size());
    this.a.a(paramStGetFeedDetailRsp, paramBoolean);
    if (!paramBoolean) {
      aanb.a(this.a.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_" + aaba.a(this.a.a()), "exp", 0, 0, new String[] { "", "", localStFeed.id.get(), localStFeed.title.get() });
    }
    this.a.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zsn
 * JD-Core Version:    0.7.0.1
 */