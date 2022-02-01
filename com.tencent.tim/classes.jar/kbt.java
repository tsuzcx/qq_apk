import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.remote.FromServiceMsg;

public class kbt
  extends kbs
{
  protected byte[] a(FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = super.a(paramFromServiceMsg);
    if (paramFromServiceMsg != null)
    {
      PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
      try
      {
        localStQWebRsp.mergeFrom(paramFromServiceMsg);
        paramFromServiceMsg = localStQWebRsp.busiBuff.get().toByteArray();
        return paramFromServiceMsg;
      }
      catch (Throwable paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kbt
 * JD-Core Version:    0.7.0.1
 */