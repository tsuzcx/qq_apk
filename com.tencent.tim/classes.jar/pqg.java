import android.os.Bundle;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspAddFeedComment;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tribe.async.dispatch.Dispatcher;

final class pqg
  implements prm
{
  pqg(String paramString1, int paramInt, long paramLong, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {}
  
  public void a(MessageMicro paramMessageMicro)
  {
    paramMessageMicro = (qqstory_service.RspAddFeedComment)paramMessageMicro;
    pqw localpqw = new pqw();
    localpqw.feedId = this.dL;
    localpqw.pbType = this.bjP;
    localpqw.Ao = this.Am;
    localpqw.commentId = paramMessageMicro.comment_id.get();
    localpqw.content = this.val$content;
    localpqw.auv = this.aum;
    localpqw.auw = this.aun;
    localpqw.aux = this.auo;
    localpqw.auy = this.aup;
    pmi.a().dispatch(localpqw);
  }
  
  public void aJ(int paramInt, String paramString)
  {
    ram.e("Q.qqstory:FeedCommentDataProvider", "onErrorInfo. errorCode=&d, errorMsg=%s", new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  public void h(int paramInt, Bundle paramBundle)
  {
    ram.e("Q.qqstory:FeedCommentDataProvider", "onNetError. errorCode=&d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void q(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {}
    for (paramBundle = "true";; paramBundle = "false")
    {
      ram.e("Q.qqstory:FeedCommentDataProvider", "onComplete. isSuccess=%s", new Object[] { paramBundle });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pqg
 * JD-Core Version:    0.7.0.1
 */