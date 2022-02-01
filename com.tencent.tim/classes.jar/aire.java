import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.data.LocationRoom.b;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import tencent.im.oidb.location.RoomOperate.ReqAssemblyPointOperation;
import tencent.im.oidb.location.RoomOperate.RspAssemblyPointOperation;
import tencent.im.oidb.location.qq_lbs_share.ResultInfo;
import tencent.im.oidb.location.qq_lbs_share.RoomKey;

public class aire
  extends aiqp<aiqs>
{
  aire(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(int paramInt1, int paramInt2, long paramLong, LocationRoom.Venue paramVenue)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VenueOperateHandler", 2, new Object[] { "[venue] requestVenueOperate: invoked. ", "operateType: " + paramInt1 + " [R_OPT_ADD = 1; R_OPT_UPDATE = 2; R_OPT_DELETE = 3;]", ", uinType: " + paramInt2 + ", sessionUin: " + paramLong + ", venue: " + paramVenue });
    }
    RoomOperate.ReqAssemblyPointOperation localReqAssemblyPointOperation = new RoomOperate.ReqAssemblyPointOperation();
    Object localObject = aiuq.a(this.app, paramInt2, paramLong);
    localReqAssemblyPointOperation.room_key.set((MessageMicro)localObject);
    localReqAssemblyPointOperation.room_key.setHasFlag(true);
    localReqAssemblyPointOperation.point_operation.set(paramInt1);
    localReqAssemblyPointOperation.poi_name.set(ByteStringMicro.copyFrom(paramVenue.name.getBytes()));
    localReqAssemblyPointOperation.poi_address.set(ByteStringMicro.copyFrom(paramVenue.address.getBytes()));
    localReqAssemblyPointOperation.lat.set(paramVenue.g.latitude);
    localReqAssemblyPointOperation.lon.set(paramVenue.g.longitude);
    localObject = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "QQLBSShareSvc.assembly_point_operation");
    ((ToServiceMsg)localObject).extraData.putInt("OPT_VENUE_TYPE", paramInt1);
    ((ToServiceMsg)localObject).extraData.putInt("uintype", paramInt2);
    ((ToServiceMsg)localObject).extraData.putString("uin", String.valueOf(paramLong));
    ((ToServiceMsg)localObject).extraData.putParcelable("key_location_venue", paramVenue);
    ((ToServiceMsg)localObject).putWupBuffer(localReqAssemblyPointOperation.toByteArray());
    a().sendPbReq((ToServiceMsg)localObject);
  }
  
  private void a(int paramInt1, String paramString, int paramInt2, int paramInt3, LocationRoom.Venue paramVenue)
  {
    aiuq.b(this.app, paramInt1, paramString, false);
    aiup.a(this.app, paramInt1, paramString, false);
    a().notifyUI(7, false, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt1), paramString, paramVenue });
  }
  
  protected aiqs a()
  {
    return aiqs.a(this.app);
  }
  
  void a(LocationRoom.b paramb, LocationRoom.Venue paramVenue)
  {
    if ((paramb == null) || (paramVenue == null)) {
      return;
    }
    a(1, paramb.getSessionType(), Long.parseLong(paramb.xc()), paramVenue);
  }
  
  void b(LocationRoom.b paramb, LocationRoom.Venue paramVenue)
  {
    if ((paramb == null) || (paramVenue == null)) {
      return;
    }
    a(3, paramb.getSessionType(), Long.parseLong(paramb.xc()), paramVenue);
  }
  
  void jT(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if (b(paramToServiceMsg, paramFromServiceMsg, paramObject)) {
      try
      {
        i = paramToServiceMsg.extraData.getInt("OPT_VENUE_TYPE");
        int j = paramToServiceMsg.extraData.getInt("uintype", -1);
        paramFromServiceMsg = paramToServiceMsg.extraData.getString("uin");
        paramToServiceMsg = (LocationRoom.Venue)paramToServiceMsg.extraData.getParcelable("key_location_venue");
        paramObject = (qq_lbs_share.ResultInfo)((RoomOperate.RspAssemblyPointOperation)new RoomOperate.RspAssemblyPointOperation().mergeFrom((byte[])paramObject)).msg_result.get();
        if (aiuq.a(paramObject))
        {
          a().notifyUI(7, true, new Object[] { Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(j), paramFromServiceMsg, paramToServiceMsg });
          return;
        }
        a(j, paramFromServiceMsg, paramObject.uint32_result.get(), i, paramToServiceMsg);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("VenueOperateHandler", 1, "[venue] requestOperateRoomResp: failed. ", paramToServiceMsg);
        return;
      }
    }
    if (paramFromServiceMsg != null)
    {
      i = paramFromServiceMsg.getResultCode();
      if (QLog.isColorLevel()) {
        QLog.d("VenueOperateHandler", 2, new Object[] { "[venue] requestOperateRoomResp: invoked. ", " resultCode: ", Integer.valueOf(i) });
      }
    }
    a(-2, "", -10001, -1, (LocationRoom.Venue)paramToServiceMsg.extraData.getParcelable("key_location_venue"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aire
 * JD-Core Version:    0.7.0.1
 */