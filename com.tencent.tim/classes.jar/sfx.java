import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public abstract class sfx
  extends MSFServlet
{
  private static String TAG = "com.tencent.biz.subscribe.servlet.CertifiedAccountAbstractServlet";
  protected int bwI;
  
  public static String getTraceId()
  {
    String str = BaseApplicationImpl.sApplication.getRuntime().getAccount();
    StringBuilder localStringBuilder = new StringBuilder(50);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MMddHHmmss");
    Random localRandom = new Random();
    localRandom.setSeed(System.currentTimeMillis());
    localStringBuilder.append(str).append("_").append(localSimpleDateFormat.format(new Date())).append(System.currentTimeMillis() % 1000L).append("_").append(localRandom.nextInt(90000) + 10000);
    return localStringBuilder.toString();
  }
  
  protected abstract void onProcessData(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException;
  
  @CallSuper
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    try
    {
      localBundle.putLong("key_index", paramIntent.getLongExtra("key_index", -1L));
      if (paramFromServiceMsg != null)
      {
        if (paramFromServiceMsg.isSuccess())
        {
          PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
          localStQWebRsp.mergeFrom(aqnv.J(paramFromServiceMsg.getWupBuffer()));
          localBundle.putLong("key_index", localStQWebRsp.Seq.get());
          localBundle.putLong("retCode", localStQWebRsp.retCode.get());
          localBundle.putString("errMsg", localStQWebRsp.errMsg.get().toStringUtf8());
          onProcessData(paramIntent, localBundle, localStQWebRsp.busiBuff.get().toByteArray());
          return;
        }
        localBundle.putLong("retCode", paramFromServiceMsg.getBusinessFailCode());
        localBundle.putString("errMsg", paramFromServiceMsg.getBusinessFailMsg());
        notifyObserver(paramIntent, this.bwI, false, localBundle, null);
        return;
      }
    }
    catch (Throwable paramFromServiceMsg)
    {
      QLog.e(TAG, 1, paramFromServiceMsg + "onReceive error");
      notifyObserver(paramIntent, this.bwI, false, localBundle, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "onReceive. inform  resultcode fail.");
    }
    notifyObserver(paramIntent, this.bwI, false, localBundle, null);
  }
  
  @CallSuper
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject = null;
    if (paramPacket != null) {}
    for (paramPacket = paramPacket.toMsg();; paramPacket = null)
    {
      if (paramPacket != null)
      {
        String str = paramPacket.getServiceCmd();
        paramPacket = localObject;
        if (paramIntent != null) {
          paramPacket = paramIntent.getStringExtra("traceid");
        }
        QLog.i("certified-account-cmd", 1, "send request cmd=" + str + " traceId=" + paramPacket);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sfx
 * JD-Core Version:    0.7.0.1
 */