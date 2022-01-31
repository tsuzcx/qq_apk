import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import com.tencent.biz.videostory.network.request.VSBaseRequest;
import com.tencent.biz.videostory.network.servlet.VSBaseServlet.1;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class yvs
  extends MSFServlet
{
  private int a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    long l = a(paramInputStream, paramOutputStream);
    if (l > 2147483647L) {
      return -1;
    }
    return (int)l;
  }
  
  private long a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    byte[] arrayOfByte = new byte[4096];
    int i;
    for (long l = 0L;; l += i)
    {
      i = paramInputStream.read(arrayOfByte);
      if (-1 == i) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
    return l;
  }
  
  private void a(VSBaseRequest paramVSBaseRequest)
  {
    if (paramVSBaseRequest.isEnableCache())
    {
      wsv.b("VSNetworkHelper| Protocol Cache", "start to response cache");
      ThreadManagerV2.executeOnFileThread(new VSBaseServlet.1(this, paramVSBaseRequest));
    }
  }
  
  private byte[] a(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    a(paramInputStream, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  @CallSuper
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    VSBaseRequest localVSBaseRequest = (VSBaseRequest)paramIntent.getSerializableExtra("key_request_data");
    localBundle.putSerializable("key_request_data", localVSBaseRequest);
    if (localVSBaseRequest == null)
    {
      QLog.e("VSNetworkHelper", 1, "onReceive. KEY_REQUEST_DATA is Null.");
      return;
    }
    if (paramFromServiceMsg != null) {
      try
      {
        QLog.i("VSNetworkHelper", 2, "onReceive Info:CmdName:" + paramFromServiceMsg.getServiceCmd() + " | TraceId:" + localVSBaseRequest.getTraceId() + " | seqNum:" + localVSBaseRequest.getCurrentSeq() + " | network cost:" + (System.currentTimeMillis() - paramIntent.getLongExtra("key_send_timestamp", 0L)));
        localBundle.putParcelable("key_response_msg", paramFromServiceMsg);
        localBundle.putLong("key_send_timestamp", System.currentTimeMillis());
        notifyObserver(paramIntent, localVSBaseRequest.getContextHashCode(), paramFromServiceMsg.isSuccess(), localBundle, yvm.class);
        return;
      }
      catch (Throwable paramFromServiceMsg)
      {
        QLog.e("VSNetworkHelper", 2, new Object[] { Integer.valueOf(1), paramFromServiceMsg + "onReceive error" });
        notifyObserver(paramIntent, localVSBaseRequest.getContextHashCode(), false, localBundle, yvm.class);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("VSNetworkHelper", 2, "onReceive Info:FromServiceMsg is null !! CmdName:null | TraceId:" + localVSBaseRequest.getTraceId() + " | seqNum:" + localVSBaseRequest.getCurrentSeq());
    }
    notifyObserver(paramIntent, localVSBaseRequest.getContextHashCode(), false, localBundle, yvm.class);
  }
  
  @CallSuper
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    VSBaseRequest localVSBaseRequest = (VSBaseRequest)paramIntent.getSerializableExtra("key_request_data");
    byte[] arrayOfByte2 = localVSBaseRequest.encode();
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null) {
      arrayOfByte1 = new byte[4];
    }
    QLog.i("VSNetworkHelper", 2, "onSend Info:CmdName:" + localVSBaseRequest.getCmdName() + " | TraceId:" + localVSBaseRequest.getTraceId() + " | SeqNum:" + localVSBaseRequest.getCurrentSeq() + " | request encode size:" + arrayOfByte1.length);
    paramIntent.putExtra("key_send_timestamp", System.currentTimeMillis());
    paramPacket.setSSOCommand(localVSBaseRequest.getCmdName());
    paramPacket.putSendData(bdku.a(arrayOfByte1));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    a(localVSBaseRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yvs
 * JD-Core Version:    0.7.0.1
 */