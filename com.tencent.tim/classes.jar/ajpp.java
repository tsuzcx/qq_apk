import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.manager.Manager;
import tencent.im.oidb.cmd0x938.cmd0x938.CommParamReq;
import tencent.im.oidb.cmd0x938.cmd0x938.ReqBody;
import tencent.im.oidb.oidb_0x8da.oidb_0x8da.ReqBody;
import tencent.im.oidb.oidb_0x8da.oidb_0x8da.UserInfo;

public class ajpp
  implements Manager
{
  AppInterface app;
  
  public ajpp(AppInterface paramAppInterface)
  {
    this.app = paramAppInterface;
  }
  
  public void a(long paramLong, ajpa paramajpa)
  {
    oidb_0x8da.ReqBody localReqBody = new oidb_0x8da.ReqBody();
    oidb_0x8da.UserInfo localUserInfo = new oidb_0x8da.UserInfo();
    localUserInfo.uint64_uin.set(paramLong);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localUserInfo);
    localReqBody.rpt_msg_user_info.set(localArrayList);
    if (QLog.isColorLevel()) {
      QLog.e("Q..troop.faceScore", 2, "getTinyIdByUin, uin=" + paramLong);
    }
    jnm.a(this.app, new ajpr(this, paramajpa, paramLong), localReqBody.toByteArray(), "OidbSvc.0x8da_1", 2266, 0, null, 0L);
  }
  
  public void a(ajpa paramajpa)
  {
    cmd0x938.ReqBody localReqBody = new cmd0x938.ReqBody();
    cmd0x938.CommParamReq localCommParamReq = new cmd0x938.CommParamReq();
    localCommParamReq.bytes_version.set(ByteStringMicro.copyFromUtf8("3.4.4"));
    localCommParamReq.uint32_platform.set(1);
    localReqBody.msg_comm_param.set(localCommParamReq);
    if (QLog.isColorLevel()) {
      QLog.e("Q..troop.faceScore", 2, "fetchGrayAbility");
    }
    jnm.a(this.app, new ajpq(this, paramajpa), localReqBody.toByteArray(), "OidbSvc.0x938_1", 2360, 1, null, 0L);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajpp
 * JD-Core Version:    0.7.0.1
 */