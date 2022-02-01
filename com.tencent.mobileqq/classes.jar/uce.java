import android.os.Bundle;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.FeedsInfo;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.ReqBody;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.RspBody;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.FeedsInfo;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.RspBody;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.SocializeFeedsInfo;

public class uce
  extends anii
{
  static final String a = "Q.pubaccount.video." + ucf.class.getSimpleName();
  
  public uce(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = new oidb_cmd0x8c8.RspBody();
    int k = qnf.a(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    paramObject = new Bundle();
    paramToServiceMsg = "";
    if (k == 0)
    {
      if ((((oidb_cmd0x8c8.RspBody)localObject).rpt_social_feeds_info.has()) && (((oidb_cmd0x8c8.RspBody)localObject).rpt_social_feeds_info.get() != null))
      {
        localObject = ((oidb_cmd0x8c8.RspBody)localObject).rpt_social_feeds_info.get().iterator();
        int i = 2;
        paramFromServiceMsg = paramToServiceMsg;
        j = i;
        if (!((Iterator)localObject).hasNext()) {
          break label311;
        }
        oidb_cmd0x8c8.FeedsInfo localFeedsInfo = (oidb_cmd0x8c8.FeedsInfo)((Iterator)localObject).next();
        if ((localFeedsInfo.bytes_rowkey.has()) && (localFeedsInfo.bytes_rowkey.get() != null))
        {
          paramFromServiceMsg = localFeedsInfo.bytes_rowkey.get().toStringUtf8();
          label136:
          if ((!localFeedsInfo.has()) || (localFeedsInfo.get() == null) || (!localFeedsInfo.msg_social_fees_info.has()) || (localFeedsInfo.msg_social_fees_info.get() == null)) {
            break label288;
          }
          paramToServiceMsg = (oidb_cmd0x8c8.SocializeFeedsInfo)localFeedsInfo.msg_social_fees_info.get();
          if (!paramToServiceMsg.uint32_myself_like_status.has()) {
            break label273;
          }
          j = paramToServiceMsg.uint32_myself_like_status.get();
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.d(a, 2, "getFavoriteState，faviriteState为:" + j);
            i = j;
          }
        }
        label273:
        label288:
        for (;;)
        {
          paramToServiceMsg = paramFromServiceMsg;
          break;
          paramFromServiceMsg = paramToServiceMsg;
          if (!QLog.isColorLevel()) {
            break label136;
          }
          QLog.e(a, 2, "getFavoriteState, 返回的articleId空");
          paramFromServiceMsg = paramToServiceMsg;
          break label136;
          if (QLog.isColorLevel()) {
            QLog.d(a, 2, "getFavoriteState，faviriteState为空");
          }
        }
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.e(a, 2, "getFavoriteState, 返回直接出错了");
    }
    int j = 2;
    paramFromServiceMsg = paramToServiceMsg;
    label311:
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "getFavoriteState articleId :" + paramFromServiceMsg + " faviriteState :" + j);
    }
    paramObject.putInt("VALUE_VIDEO_FAVORITE_STATE", j);
    paramObject.putString("VALUE_VIDEO_ARTICLE_ID", paramFromServiceMsg);
    if (k == 0) {}
    for (boolean bool = true;; bool = false)
    {
      super.notifyUI(1, bool, paramObject);
      return;
    }
  }
  
  private void a(boolean paramBoolean1, long paramLong, int paramInt, String paramString, boolean paramBoolean2)
  {
    oidb_cmd0x83e.ReqBody localReqBody = new oidb_cmd0x83e.ReqBody();
    localReqBody.uint64_uin.set(Long.valueOf(pha.a()).longValue());
    if (paramBoolean1)
    {
      localReqBody.uint64_feeds_id.set(paramLong);
      localReqBody.msg_feeds_info = new oidb_cmd0x83e.FeedsInfo();
      localReqBody.msg_feeds_info.feeds_type.set(paramInt);
      if (!paramBoolean2) {
        break label114;
      }
      localReqBody.uint32_operation.set(2);
    }
    for (;;)
    {
      super.sendPbReq(super.makeOIDBPkg("OidbSvc.0x83e", 2110, 0, localReqBody.toByteArray()));
      return;
      localReqBody.bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(paramString));
      break;
      label114:
      localReqBody.uint32_operation.set(3);
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = true;
    paramToServiceMsg = new oidb_cmd0x83e.RspBody();
    int i = qnf.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (i == 0)
    {
      QLog.d(a, 1, "handle0x83eUpvoteAction result OK");
      if (QLog.isColorLevel())
      {
        if (paramToServiceMsg.uint64_feeds_id.has()) {
          QLog.d(a, 2, "upvote feeds id:" + paramToServiceMsg.uint64_feeds_id.get());
        }
        if (paramToServiceMsg.uint32_operation.has())
        {
          paramFromServiceMsg = a;
          paramObject = new StringBuilder().append("upvote status:");
          if (paramToServiceMsg.uint32_operation.get() != 2) {
            break label134;
          }
          QLog.d(paramFromServiceMsg, 2, bool);
        }
      }
    }
    label134:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        bool = false;
      }
    }
    QLog.d(a, 1, "handle0x83eUpvoteAction result wrong:" + i);
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    if (paramVideoInfo == null) {
      return;
    }
    if (paramVideoInfo.b)
    {
      a(true, paramVideoInfo.d, paramVideoInfo.h, null, paramBoolean);
      return;
    }
    a(false, -1L, -1, paramVideoInfo.g, paramBoolean);
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    if (paramBaseArticleInfo == null) {
      return;
    }
    if (!snh.j(paramBaseArticleInfo))
    {
      a(true, paramBaseArticleInfo.mFeedId, paramBaseArticleInfo.mFeedType, null, paramBoolean);
      return;
    }
    a(false, -1L, -1, paramBaseArticleInfo.innerUniqueID, paramBoolean);
  }
  
  protected boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0x8c8");
      this.allowCmdSet.add("OidbSvc.0x83e");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  protected Class<? extends anil> observerClass()
  {
    return ucf.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "handleGetPlayCount onReceive");
    }
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd())) {}
    do
    {
      do
      {
        return;
        try
        {
          if (!paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x8c8")) {
            break;
          }
          a(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        catch (Exception paramToServiceMsg) {}
      } while (!QLog.isColorLevel());
      QLog.e(a, 2, "onReceive ERROR e=" + paramToServiceMsg.getMessage() + paramFromServiceMsg.getServiceCmd());
      return;
    } while (!paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x83e"));
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     uce
 * JD-Core Version:    0.7.0.1
 */