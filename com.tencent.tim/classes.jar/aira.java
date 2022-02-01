import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.location.data.LocationRoom.b;
import com.tencent.mobileqq.location.net.ReportLocationHandler.1;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.concurrent.atomic.AtomicBoolean;
import tencent.im.oidb.location.RoomOperate.ReqReportLocation;
import tencent.im.oidb.location.RoomOperate.RspReportLocation;
import tencent.im.oidb.location.qq_lbs_share.ResultInfo;
import tencent.im.oidb.location.qq_lbs_share.RoomKey;

public class aira
  extends aiqp<aiqs>
{
  private static int intervalMillis = 2000;
  private Long X;
  private aira.a a;
  private Handler db = new Handler(ThreadManager.getSubThreadLooper());
  private int deY;
  private AtomicBoolean dn = new AtomicBoolean(true);
  private Runnable gR;
  
  public aira(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void dtX() {}
  
  private void stopReport()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportLocationHandler", 2, new Object[] { "stopReport: invoked. ", " loopReportStopped: ", this.dn });
    }
    this.dn.set(true);
    if (this.gR != null) {
      this.db.removeCallbacks(this.gR);
    }
  }
  
  int FV()
  {
    return this.deY;
  }
  
  protected aiqs a()
  {
    return aiqs.a(this.app);
  }
  
  public void a(int paramInt, long paramLong, aiqn paramaiqn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportLocationHandler", 2, new Object[] { "requestReportLocation: invoked. ", "uinType = [" + paramInt + "], sessionUin = [" + paramLong + "], locationItem = [" + paramaiqn + "]" });
    }
    RoomOperate.ReqReportLocation localReqReportLocation = new RoomOperate.ReqReportLocation();
    qq_lbs_share.RoomKey localRoomKey = aiuq.a(this.app, 0, paramLong);
    localReqReportLocation.room_key.set(localRoomKey);
    localReqReportLocation.room_key.setHasFlag(true);
    localReqReportLocation.direction.set(paramaiqn.x());
    paramaiqn = paramaiqn.a();
    if (paramaiqn == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReportLocationHandler", 2, new Object[] { "requestReportLocation: invoked. ", " latLng: ", paramaiqn });
      }
      return;
    }
    localReqReportLocation.lat.set(paramaiqn.latitude);
    localReqReportLocation.lon.set(paramaiqn.longitude);
    paramaiqn = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "QQLBSShareSvc.report_location");
    paramaiqn.putWupBuffer(localReqReportLocation.toByteArray());
    a().sendPbReq(paramaiqn);
  }
  
  public void a(String paramString, aira.a parama)
  {
    this.a = parama;
    if (!this.dn.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReportLocationHandler", 2, new Object[] { "startReportInLoop: invoked. still in loop, no need re-request ", " sessionUin: ", paramString });
      }
      return;
    }
    this.dn.set(false);
    this.gR = new ReportLocationHandler.1(this);
    this.db.post(this.gR);
  }
  
  public boolean ac(String paramString, int paramInt)
  {
    return (!TextUtils.isEmpty(xd())) && (xd().equals(paramString)) && (FV() == paramInt);
  }
  
  public boolean apC()
  {
    return !this.dn.get();
  }
  
  public boolean b(LocationRoom.b paramb)
  {
    if (!apC()) {
      return false;
    }
    return new LocationRoom.b(this.deY, "" + this.X).equals(paramb);
  }
  
  public void destroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReportLocationHandler", 2, "destroy: invoked. ");
    }
    stopReport();
    this.db.removeCallbacksAndMessages(null);
  }
  
  public void jQ(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if (b(paramToServiceMsg, paramFromServiceMsg, paramObject))
    {
      try
      {
        paramToServiceMsg = (RoomOperate.RspReportLocation)new RoomOperate.RspReportLocation().mergeFrom((byte[])paramObject);
        if (aiuq.a((qq_lbs_share.ResultInfo)paramToServiceMsg.msg_result.get()))
        {
          i = paramToServiceMsg.req_interval.get();
          if (i != 0) {
            intervalMillis = i * 1000;
          }
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("ReportLocationHandler", 2, new Object[] { "requestReportLocationResp: invoked. ", " intervalMillis: ", Integer.valueOf(intervalMillis) });
          return;
        }
        dtX();
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("ReportLocationHandler", 1, "requestReportLocationResp: failed. ", paramToServiceMsg);
        return;
      }
    }
    else
    {
      if (paramFromServiceMsg != null)
      {
        i = paramFromServiceMsg.getResultCode();
        if (QLog.isColorLevel()) {
          QLog.d("ReportLocationHandler", 2, new Object[] { "requestReportLocationResp: invoked. ", " resultCode: ", Integer.valueOf(i) });
        }
      }
      dtX();
    }
  }
  
  String xd()
  {
    return this.X + "";
  }
  
  public static abstract interface a
  {
    public abstract aiqn b();
    
    public abstract Pair<Integer, String> o();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aira
 * JD-Core Version:    0.7.0.1
 */