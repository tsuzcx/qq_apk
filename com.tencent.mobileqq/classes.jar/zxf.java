import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.biz.richframework.network.servlet.VSBaseServlet.1;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class zxf
  extends MSFServlet
{
  private static final long a = QzoneConfig.getInstance().getConfig("qqcircle", "secondary_vs_time_out_time", 20000);
  
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
      yqp.b("VSNetworkHelper| Protocol Cache", "start to response cache,CmdName:" + paramVSBaseRequest.getCmdName() + " Seq:" + paramVSBaseRequest.getCurrentSeq());
      ThreadManagerV2.executeOnSubThread(new VSBaseServlet.1(this, paramVSBaseRequest));
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
        long l = System.currentTimeMillis() - paramIntent.getLongExtra("key_send_timestamp", 0L);
        if (VSNetworkHelper.b(localVSBaseRequest.getCmdName())) {
          QLog.i("VSNetworkHelper", 2, "onReceive Info:CmdName:" + paramFromServiceMsg.getServiceCmd() + " | TraceId:" + localVSBaseRequest.getTraceId() + " | seqNum:" + localVSBaseRequest.getCurrentSeq() + " | network cost:" + l);
        }
        localBundle.putParcelable("key_response_msg", paramFromServiceMsg);
        localBundle.putLong("key_send_timestamp", System.currentTimeMillis());
        localBundle.putLong("key_network_time_cost", l);
        VSNetworkHelper.a().onReceive(localVSBaseRequest.getContextHashCode(), paramFromServiceMsg.isSuccess(), localBundle);
        return;
      }
      catch (Throwable paramIntent)
      {
        QLog.e("VSNetworkHelper", 2, new Object[] { Integer.valueOf(1), paramIntent + "onReceive error" });
        VSNetworkHelper.a().onReceive(localVSBaseRequest.getContextHashCode(), false, localBundle);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("VSNetworkHelper", 2, "onReceive Info:FromServiceMsg is null !! CmdName:null | TraceId:" + localVSBaseRequest.getTraceId() + " | seqNum:" + localVSBaseRequest.getCurrentSeq());
    }
    VSNetworkHelper.a().onReceive(localVSBaseRequest.getContextHashCode(), false, localBundle);
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
    if (VSNetworkHelper.b(localVSBaseRequest.getCmdName())) {
      QLog.i("VSNetworkHelper", 2, "onSend Info:CmdName:" + localVSBaseRequest.getCmdName() + " | TraceId:" + localVSBaseRequest.getTraceId() + " | SeqNum:" + localVSBaseRequest.getCurrentSeq() + " | request encode size:" + arrayOfByte1.length);
    }
    paramIntent.putExtra("key_send_timestamp", System.currentTimeMillis());
    paramPacket.setSSOCommand(localVSBaseRequest.getCmdName());
    paramPacket.putSendData(bguc.a(arrayOfByte1));
    paramPacket.setTimeout(a);
    vrh.a(600, localVSBaseRequest.getCmdName(), localVSBaseRequest.getTraceId(), 0L, 0);
    a(localVSBaseRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zxf
 * JD-Core Version:    0.7.0.1
 */