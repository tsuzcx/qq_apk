import NS_QWEB_PROTOCAL.PROTOCAL.StQWebReq;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class wdq
{
  public static final AtomicInteger a = new AtomicInteger(0);
  
  public abstract byte[] a();
  
  public byte[] a(Intent paramIntent, int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new RuntimeException("req traceId is null!");
    }
    PROTOCAL.StQWebReq localStQWebReq = new PROTOCAL.StQWebReq();
    localStQWebReq.Seq.set(paramInt);
    localStQWebReq.qua.set(bfpk.a());
    localStQWebReq.deviceInfo.set(bfpj.a().c());
    localStQWebReq.busiBuff.set(ByteStringMicro.copyFrom(a()));
    if (!TextUtils.isEmpty(paramString)) {
      localStQWebReq.traceid.set(paramString);
    }
    if (paramIntent != null) {
      paramIntent.putExtra("traceid", paramString);
    }
    return localStQWebReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wdq
 * JD-Core Version:    0.7.0.1
 */