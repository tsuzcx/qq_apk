import EncounterSvc.UserData;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class anaw
  extends swr
{
  static String[] gu = { "EncounterSvc", "NeighborSvc", "VisitorSvc" };
  public UserData[] a = new UserData[2];
  AppInterface app;
  
  public anaw(AppInterface paramAppInterface)
  {
    this.app = paramAppInterface;
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ("EncounterSvc.ReqGetEncounter".equals(paramFromServiceMsg.getServiceCmd())) {
      return acic.a(this.app, paramFromServiceMsg, paramToServiceMsg, this);
    }
    if ("NeighborSvc.ReqGetPoint".equals(paramFromServiceMsg.getServiceCmd())) {
      return acic.a(this, paramFromServiceMsg, paramToServiceMsg);
    }
    if ("VisitorSvc.ReqFavorite".equals(paramFromServiceMsg.getServiceCmd())) {
      acic.b(paramFromServiceMsg, paramToServiceMsg);
    }
    return super.a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if ("EncounterSvc.ReqGetEncounter".equals(str)) {
      return acic.a(this.app, paramToServiceMsg, paramUniPacket, this);
    }
    if ("NeighborSvc.ReqGetPoint".equals(str)) {
      return acic.a(this, paramToServiceMsg, paramUniPacket);
    }
    if ("VisitorSvc.ReqFavorite".equals(paramToServiceMsg.getServiceCmd())) {
      return acic.b(paramToServiceMsg, paramUniPacket);
    }
    return false;
  }
  
  public String[] y()
  {
    return gu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anaw
 * JD-Core Version:    0.7.0.1
 */