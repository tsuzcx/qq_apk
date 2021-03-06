import com.tencent.biz.pubaccount.VideoColumnSubscribeHandler.1;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xd4b.oidb_0xd4b.QueryKdVideoColumnReq;
import tencent.im.oidb.cmd0xd4b.oidb_0xd4b.ReqBody;
import tencent.im.oidb.cmd0xd4b.oidb_0xd4b.SubscribeVideoColumnReq;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class kca
  extends accg
{
  public static final String TAG = kca.class.getSimpleName();
  
  public kca(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void ow(int paramInt)
  {
    oidb_0xd4b.ReqBody localReqBody = new oidb_0xd4b.ReqBody();
    localReqBody.msg_subscribe_video_column_req.uint32_video_column_id.set(paramInt);
    localReqBody.msg_query_kd_video_column_req.uint32_query_sub_status.set(1);
    super.sendPbReq(super.makeOIDBPkg("OidbSvc.0xd4b", 3403, 1, localReqBody.toByteArray()));
  }
  
  protected Class<? extends acci> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "onReceive() isSuccess = " + bool);
      }
      if (bool)
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        try
        {
          paramToServiceMsg.mergeFrom((byte[])paramObject);
          if (paramToServiceMsg.uint32_result.has())
          {
            if (QLog.isColorLevel()) {
              QLog.d(TAG, 2, "onReceive() pkg.uint32_result = " + paramToServiceMsg.uint32_result.get());
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.d(TAG, 2, "onReceive() pkg.uint32_result is null ");
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onReceive() exception = " + paramToServiceMsg.getMessage());
          }
        }
      }
      return;
    }
  }
  
  public void ov(int paramInt)
  {
    ThreadManager.excute(new VideoColumnSubscribeHandler.1(this, paramInt), 16, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kca
 * JD-Core Version:    0.7.0.1
 */