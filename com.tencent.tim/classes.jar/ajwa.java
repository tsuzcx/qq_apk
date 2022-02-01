import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.now.NowNearbyVideoCommentProto.AddCommentNoFilterReq;
import com.tencent.pb.now.NowNearbyVideoCommentProto.CommentMsg;
import com.tencent.pb.now.NowNearbyVideoCommentProto.CommentMsgBody;
import com.tencent.pb.now.NowNearbyVideoCommentProto.DelCommentReq;
import com.tencent.pb.now.NowNearbyVideoCommentProto.GetCommentListNoFilterReq;
import com.tencent.pb.now.NowNearbyVideoCommentProto.UserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import mqq.manager.TicketManager;
import tencent.im.oidb.cmd0xada.oidb_0xada.ReqBody;

public class ajwa
  implements ajvz
{
  private VideoData b;
  private HashSet<Long> bo = new HashSet();
  QQAppInterface mApp = null;
  private Handler mHandler = new Handler();
  
  public ajwa(VideoData paramVideoData, QQAppInterface paramQQAppInterface)
  {
    this.b = paramVideoData;
    this.mApp = paramQQAppInterface;
  }
  
  private boolean b(oidb_0xada.ReqBody paramReqBody)
  {
    paramReqBody.uid.set(Long.parseLong(this.mApp.getCurrentAccountUin()));
    paramReqBody.tinyid.set(Long.parseLong(this.mApp.getCurrentAccountUin()));
    Object localObject = (TicketManager)this.mApp.getManager(2);
    String str = ((TicketManager)localObject).getA2(this.mApp.getCurrentAccountUin());
    localObject = ((TicketManager)localObject).getSkey(this.mApp.getCurrentAccountUin());
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      paramReqBody.a2.set(str);
      paramReqBody.platform.set(1);
      paramReqBody.version.set("3.4.4");
      paramReqBody.original_id.set(this.mApp.getCurrentAccountUin());
      paramReqBody.original_key.set((String)localObject);
      paramReqBody.original_id_type.set(1);
      return true;
    }
    return false;
  }
  
  public int GF()
  {
    try
    {
      int i = Integer.parseInt("3.4.4".replace(".", ""));
      return i;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("CommentsDataSource", 2, "getVersionInt exp:" + localException.toString());
      }
    }
    return 0;
  }
  
  public void a(int paramInt, ajvz.b paramb)
  {
    if ((this.b == null) || (this.mApp == null)) {
      return;
    }
    oidb_0xada.ReqBody localReqBody = new oidb_0xada.ReqBody();
    if (!b(localReqBody))
    {
      QLog.i("CommentsDataSource", 1, "oidb_0xada configCommonFileds failed");
      paramb.dzN();
    }
    NowNearbyVideoCommentProto.GetCommentListNoFilterReq localGetCommentListNoFilterReq = new NowNearbyVideoCommentProto.GetCommentListNoFilterReq();
    localGetCommentListNoFilterReq.count.set(20L);
    if (!TextUtils.isEmpty(this.b.id)) {
      localGetCommentListNoFilterReq.feed_id.set(this.b.id);
    }
    localGetCommentListNoFilterReq.feed_type.set(this.b.feedType);
    localGetCommentListNoFilterReq.page.set(paramInt);
    localGetCommentListNoFilterReq.filter.set(0L);
    localReqBody.cmd.set(857);
    localReqBody.subcmd.set(8);
    localReqBody.busi_buf.set(ByteStringMicro.copyFrom(localGetCommentListNoFilterReq.toByteArray()));
    jnm.a(this.mApp, new ajwb(this, paramb), localReqBody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, null, 0L);
  }
  
  public void a(Comments.Comment paramComment, ajvz.a parama)
  {
    if ((this.b == null) || (this.mApp == null)) {
      return;
    }
    oidb_0xada.ReqBody localReqBody = new oidb_0xada.ReqBody();
    if (b(localReqBody))
    {
      localReqBody.cmd.set(857);
      localReqBody.subcmd.set(3);
      NowNearbyVideoCommentProto.DelCommentReq localDelCommentReq = new NowNearbyVideoCommentProto.DelCommentReq();
      localDelCommentReq.feed_id.set(ByteStringMicro.copyFrom(this.b.id.getBytes()));
      localDelCommentReq.comment_id.set(paramComment.id);
      localReqBody.busi_buf.set(ByteStringMicro.copyFrom(localDelCommentReq.toByteArray()));
      jnm.a(this.mApp, new ajwd(this, parama, paramComment), localReqBody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, null, 0L);
      return;
    }
    parama.a(paramComment, -1);
  }
  
  public void a(Comments.Comment paramComment, ajvz.c paramc)
  {
    if ((this.b == null) || (this.mApp == null)) {
      return;
    }
    oidb_0xada.ReqBody localReqBody = new oidb_0xada.ReqBody();
    if (!b(localReqBody))
    {
      QLog.i("CommentsDataSource", 1, "oidb_0xada configCommonFileds failed");
      paramc.a(paramComment, -1, "");
      return;
    }
    NowNearbyVideoCommentProto.AddCommentNoFilterReq localAddCommentNoFilterReq = new NowNearbyVideoCommentProto.AddCommentNoFilterReq();
    if (this.b.feedType == 6) {
      localAddCommentNoFilterReq.feed_type.set(6L);
    }
    for (;;)
    {
      localAddCommentNoFilterReq.feed_id.set(this.b.id);
      Object localObject = new NowNearbyVideoCommentProto.UserInfo();
      ((NowNearbyVideoCommentProto.UserInfo)localObject).uid.set(this.b.adu);
      ((NowNearbyVideoCommentProto.UserInfo)localObject).user_type.set(this.b.dlz);
      ((NowNearbyVideoCommentProto.UserInfo)localObject).now_id.set(this.b.adv);
      localAddCommentNoFilterReq.video_recorder.set((MessageMicro)localObject);
      if ((paramComment.ado > 0L) || (paramComment.adp > 0L))
      {
        localObject = new NowNearbyVideoCommentProto.UserInfo();
        ((NowNearbyVideoCommentProto.UserInfo)localObject).uid.set(paramComment.ado);
        ((NowNearbyVideoCommentProto.UserInfo)localObject).user_type.set(paramComment.dll);
        ((NowNearbyVideoCommentProto.UserInfo)localObject).now_id.set(paramComment.adp);
        localAddCommentNoFilterReq.reply_user.set((MessageMicro)localObject);
      }
      localObject = new NowNearbyVideoCommentProto.UserInfo();
      ((NowNearbyVideoCommentProto.UserInfo)localObject).uid.set(this.b.adw);
      ((NowNearbyVideoCommentProto.UserInfo)localObject).now_id.set(this.b.adx);
      ((NowNearbyVideoCommentProto.UserInfo)localObject).user_type.set(this.b.dlA);
      localAddCommentNoFilterReq.video_owner.set((MessageMicro)localObject);
      localAddCommentNoFilterReq.is_aggregate_short_video.set(0);
      localObject = new NowNearbyVideoCommentProto.UserInfo();
      ((NowNearbyVideoCommentProto.UserInfo)localObject).uid.set(this.b.ads);
      ((NowNearbyVideoCommentProto.UserInfo)localObject).user_type.set(this.b.dlx);
      ((NowNearbyVideoCommentProto.UserInfo)localObject).now_id.set(this.b.adt);
      localAddCommentNoFilterReq.video_anchor.set((MessageMicro)localObject);
      localObject = new NowNearbyVideoCommentProto.CommentMsgBody();
      NowNearbyVideoCommentProto.CommentMsg localCommentMsg = new NowNearbyVideoCommentProto.CommentMsg();
      localCommentMsg.msg.set(ByteStringMicro.copyFromUtf8(paramComment.content));
      localCommentMsg.type.set(0);
      ((NowNearbyVideoCommentProto.CommentMsgBody)localObject).msgs.add(localCommentMsg);
      localAddCommentNoFilterReq.content.set((MessageMicro)localObject);
      localReqBody.cmd.set(857);
      localReqBody.subcmd.set(9);
      localReqBody.busi_buf.set(ByteStringMicro.copyFrom(localAddCommentNoFilterReq.toByteArray()));
      if (QLog.isColorLevel()) {
        QLog.i("CommentsDataSource", 2, "print bytes count =" + localAddCommentNoFilterReq.toByteArray().length);
      }
      int i = GF();
      QLog.i("CommentsDataSource", 1, "publishComment, qqver=" + i);
      if (i > 0) {
        localReqBody.version_code.set(i);
      }
      jnm.a(this.mApp, new ajwc(this, paramc, paramComment), localReqBody.toByteArray(), "OidbSvc.0xada_0", 2778, 0, null, 0L);
      return;
      if (this.b.feedType == 4) {
        localAddCommentNoFilterReq.feed_type.set(4L);
      } else {
        localAddCommentNoFilterReq.feed_type.set(3L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajwa
 * JD-Core Version:    0.7.0.1
 */