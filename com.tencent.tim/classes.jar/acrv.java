import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.transfile.ProtoReqManager.b;
import com.tencent.mobileqq.transfile.ProtoReqManager.c;
import com.tencent.mobileqq.transfile.ProtoReqManager.d;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.RspHead;
import tencent.mobileim.structmsg.structmsg.RspSystemMsgRead;

class acrv
  implements ProtoReqManager.b
{
  acrv(acrp paramacrp, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void a(ProtoReqManager.d paramd, ProtoReqManager.c paramc)
  {
    try
    {
      paramd = paramd.g.getWupBuffer();
      paramc = new structmsg.RspSystemMsgRead();
      paramc.mergeFrom(paramd);
      int i = paramc.head.result.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgReadedReportResp reqSeq=" + this.sP + ";resultCode=" + i + ";latestFriendSeq=" + this.Rp + ";latestGroupSeq=" + this.Rq);
      }
      return;
    }
    catch (Exception paramd)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.systemmsg.", 2, "sendFriendSystemMsgReadedReportResp exception", paramd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acrv
 * JD-Core Version:    0.7.0.1
 */