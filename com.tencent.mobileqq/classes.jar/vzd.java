import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLike;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDoLikeRsp;
import android.os.Bundle;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.biz.subscribe.event.PraisedUpdateEvents;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qipc.QIPCClientHelper;

public class vzd
  implements wxx<CertifiedAccountWrite.StDoLikeRsp>
{
  public vzd(CommentBottomBar paramCommentBottomBar) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountWrite.StDoLikeRsp paramStDoLikeRsp)
  {
    int i = 1;
    CommentBottomBar.a(this.a, true);
    if ((!paramBoolean) || (paramLong != 0L) || (paramStDoLikeRsp == null)) {
      bbmy.a(this.a.getContext(), 1, paramString, 0).a();
    }
    for (;;)
    {
      return;
      if (CommentBottomBar.a(this.a) != null) {
        CommentBottomBar.a(this.a).likeInfo.status.set(paramStDoLikeRsp.like.status.get());
      }
      wcj.a().a(new PraisedUpdateEvents(CommentBottomBar.a(this.a).id.get(), paramStDoLikeRsp.like.status.get()));
      if (BaseApplicationImpl.sProcessId == 1) {}
      while (i == 0)
      {
        paramString = new Bundle();
        paramString.putString("feed_id", CommentBottomBar.a(this.a).id.get());
        paramString.putInt("feed_like_status", paramStDoLikeRsp.like.status.get());
        QIPCClientHelper.getInstance().callServer(wcj.a, wcj.b, paramString, null);
        return;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     vzd
 * JD-Core Version:    0.7.0.1
 */