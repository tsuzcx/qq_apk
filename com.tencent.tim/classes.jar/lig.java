import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.model.KingShareReadInjoyModule.1;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0xa70.oidb_cmd0xa70.ReqBody;
import tencent.im.oidb.cmd0xa70.oidb_cmd0xa70.RspBody;
import tencent.im.oidb.cmd0xa70.oidb_cmd0xa70.VideoReqInfo;
import tencent.im.oidb.cmd0xa70.oidb_cmd0xa70.VideoRspInfo;

public class lig
  extends lir
{
  public lig(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, lun paramlun, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramlun, paramHandler);
    if (QLog.isColorLevel()) {
      QLog.d("KingShareReadInjoyModule", 2, "construct!");
    }
  }
  
  public void al(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("KingShareReadInjoyModule", 2, "handle 0xa70 get king moment info");
    }
    paramToServiceMsg = new oidb_cmd0xa70.RspBody();
    int i = lup.parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    paramFromServiceMsg = new mhn();
    paramFromServiceMsg.businessId = ((oidb_cmd0xa70.VideoRspInfo)paramToServiceMsg.msg_video_rsp_info.get()).uint32_business_id.get();
    paramFromServiceMsg.businessName = ((oidb_cmd0xa70.VideoRspInfo)paramToServiceMsg.msg_video_rsp_info.get()).bytes_business_name.get().toStringUtf8();
    paramFromServiceMsg.businessUrl = ((oidb_cmd0xa70.VideoRspInfo)paramToServiceMsg.msg_video_rsp_info.get()).bytes_business_url.get().toStringUtf8();
    paramFromServiceMsg.ahg = ((oidb_cmd0xa70.VideoRspInfo)paramToServiceMsg.msg_video_rsp_info.get()).bytes_business_name_prefix.get().toStringUtf8();
    paramFromServiceMsg.title = ((oidb_cmd0xa70.VideoRspInfo)paramToServiceMsg.msg_video_rsp_info.get()).bytes_title.get().toStringUtf8();
    paramFromServiceMsg.desc = ((oidb_cmd0xa70.VideoRspInfo)paramToServiceMsg.msg_video_rsp_info.get()).bytes_desc.get().toStringUtf8();
    paramFromServiceMsg.uuid = ((oidb_cmd0xa70.VideoRspInfo)paramToServiceMsg.msg_video_rsp_info.get()).bytes_uuid.get().toStringUtf8();
    paramFromServiceMsg.url = ((oidb_cmd0xa70.VideoRspInfo)paramToServiceMsg.msg_video_rsp_info.get()).bytes_video_url.get().toStringUtf8();
    paramFromServiceMsg.coverUrl = ((oidb_cmd0xa70.VideoRspInfo)paramToServiceMsg.msg_video_rsp_info.get()).bytes_pic_url.get().toStringUtf8();
    paramFromServiceMsg.coverWidth = ((oidb_cmd0xa70.VideoRspInfo)paramToServiceMsg.msg_video_rsp_info.get()).uint32_pic_width.get();
    paramFromServiceMsg.coverHeight = ((oidb_cmd0xa70.VideoRspInfo)paramToServiceMsg.msg_video_rsp_info.get()).uint32_pic_height.get();
    paramFromServiceMsg.videoWidth = paramFromServiceMsg.coverWidth;
    paramFromServiceMsg.videoHeight = paramFromServiceMsg.coverHeight;
    paramFromServiceMsg.duration = ((oidb_cmd0xa70.VideoRspInfo)paramToServiceMsg.msg_video_rsp_info.get()).uint64_duration.get();
    this.mMainThreadHandler.post(new KingShareReadInjoyModule.1(this, i, paramFromServiceMsg));
  }
  
  public void bB(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("KingShareReadInjoyModule", 2, "get king moment ,url =" + paramString1);
    }
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString2);
      l1 = l2;
    }
    catch (Exception paramString2)
    {
      label42:
      oidb_cmd0xa70.VideoReqInfo localVideoReqInfo;
      break label42;
    }
    paramString2 = new oidb_cmd0xa70.ReqBody();
    paramString2.uint64_uin.set(l1);
    localVideoReqInfo = new oidb_cmd0xa70.VideoReqInfo();
    localVideoReqInfo.bytes_wangzhe_share_url.set(ByteStringMicro.copyFromUtf8(paramString1));
    paramString2.msg_video_req_info.set(localVideoReqInfo);
    sendPbReq(lup.makeOIDBPkg("OidbSvc.0xa70", 2672, 0, paramString2.toByteArray()));
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xa70")) {
      al(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lig
 * JD-Core Version:    0.7.0.1
 */