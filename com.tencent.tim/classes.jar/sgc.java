import NS_QWEB_PROTOCAL.PROTOCAL.StQWebReq;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class sgc
{
  public static final AtomicInteger atomicInteger = new AtomicInteger(0);
  
  public byte[] encode(Intent paramIntent, int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new RuntimeException("req traceId is null!");
    }
    PROTOCAL.StQWebReq localStQWebReq = new PROTOCAL.StQWebReq();
    localStQWebReq.Seq.set(paramInt);
    localStQWebReq.qua.set(avpq.getQUA3());
    localStQWebReq.deviceInfo.set(avpp.a().getDeviceInfor());
    localStQWebReq.busiBuff.set(ByteStringMicro.copyFrom(getBusiBuf()));
    if (!TextUtils.isEmpty(paramString)) {
      localStQWebReq.traceid.set(paramString);
    }
    if (paramIntent != null) {
      paramIntent.putExtra("traceid", paramString);
    }
    return localStQWebReq.toByteArray();
  }
  
  public abstract byte[] getBusiBuf();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sgc
 * JD-Core Version:    0.7.0.1
 */