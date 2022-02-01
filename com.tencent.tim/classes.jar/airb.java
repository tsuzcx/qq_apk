import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import tencent.im.oidb.location.RoomOperate.ReqRoomOperation;
import tencent.im.oidb.location.RoomOperate.RspRoomOperation;
import tencent.im.oidb.location.qq_lbs_share.ResultInfo;
import tencent.im.oidb.location.qq_lbs_share.RoomKey;

public class airb
  extends aiqp<aiqs>
{
  private aiqs a;
  
  airb(QQAppInterface paramQQAppInterface, aiqs paramaiqs)
  {
    super(paramQQAppInterface);
    this.a = paramaiqs;
  }
  
  private void e(int paramInt1, int paramInt2, long paramLong)
  {
    Object localObject = this.a.b();
    if (QLog.isColorLevel()) {
      QLog.d("RoomOperateHandler", 2, new Object[] { "requestOperateRoom: invoked. ", "operateType = [" + paramInt1 + "]  R_OPT_CREATE = 1; //创建房间 R_OPT_JOIN = 2; //加入 R_OPT_QUIT = 3; //退出\n", ", uinType = [" + paramInt2 + "], sessionUin = [" + paramLong + "], location = [" + localObject + "]" });
    }
    if (localObject == null) {
      return;
    }
    RoomOperate.ReqRoomOperation localReqRoomOperation = new RoomOperate.ReqRoomOperation();
    qq_lbs_share.RoomKey localRoomKey = aiuq.a(this.app, paramInt2, paramLong);
    localReqRoomOperation.room_key.set(localRoomKey);
    localReqRoomOperation.room_key.setHasFlag(true);
    localReqRoomOperation.room_operation.set(paramInt1);
    localReqRoomOperation.lat.set(((LatLng)localObject).latitude);
    localReqRoomOperation.lon.set(((LatLng)localObject).longitude);
    localObject = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "QQLBSShareSvc.room_operation");
    ((ToServiceMsg)localObject).extraData.putInt("OPT_ROOM_TYPE", paramInt1);
    ((ToServiceMsg)localObject).extraData.putInt("uintype", paramInt2);
    ((ToServiceMsg)localObject).extraData.putString("uin", String.valueOf(paramLong));
    ((ToServiceMsg)localObject).putWupBuffer(localReqRoomOperation.toByteArray());
    a().sendPbReq((ToServiceMsg)localObject);
  }
  
  private void g(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    aiuq.b(this.app, paramInt1, paramString, false);
    aiup.a(this.app, paramInt1, paramString, false);
    a().notifyUI(1, false, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt1), paramString });
  }
  
  public void G(int paramInt1, int paramInt2, String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      e(paramInt1, paramInt2, l);
      return;
    }
    catch (NumberFormatException paramString)
    {
      QLog.e("RoomOperateHandler", 1, "requestOperateRoom: failed. ", paramString);
    }
  }
  
  protected aiqs a()
  {
    return aiqs.a(this.app);
  }
  
  public void jR(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if (b(paramToServiceMsg, paramFromServiceMsg, paramObject)) {
      try
      {
        i = paramToServiceMsg.extraData.getInt("OPT_ROOM_TYPE");
        int j = paramToServiceMsg.extraData.getInt("uintype", -1);
        paramToServiceMsg = paramToServiceMsg.extraData.getString("uin");
        paramFromServiceMsg = (qq_lbs_share.ResultInfo)((RoomOperate.RspRoomOperation)new RoomOperate.RspRoomOperation().mergeFrom((byte[])paramObject)).msg_result.get();
        if (aiuq.a(paramFromServiceMsg))
        {
          a().notifyUI(1, true, new Object[] { Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(j), paramToServiceMsg });
          return;
        }
        g(j, paramToServiceMsg, paramFromServiceMsg.uint32_result.get(), i);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("RoomOperateHandler", 1, "requestOperateRoomResp: failed. ", paramToServiceMsg);
        return;
      }
    }
    if (paramFromServiceMsg != null)
    {
      i = paramFromServiceMsg.getResultCode();
      if (QLog.isColorLevel()) {
        QLog.d("RoomOperateHandler", 2, new Object[] { "requestOperateRoomResp: invoked. ", " resultCode: ", Integer.valueOf(i) });
      }
    }
    g(-2, "", -10001, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     airb
 * JD-Core Version:    0.7.0.1
 */