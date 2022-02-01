import NS_QWEB_PROTOCAL.PROTOCAL.StQWebReq;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.oac.OACProfilePb.ProfileDataReq;
import com.tencent.pb.oac.OACProfilePb.ProfileDataRsp;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.observer.BusinessObserver;

public class kbu
  extends kbt
{
  public static void a(Long paramLong, String paramString, kbu.b<OACProfilePb.ProfileDataRsp> paramb)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = new OACProfilePb.ProfileDataReq();
    paramString.puin.set(paramLong.longValue());
    paramString.attachinfo.set(str);
    a("officialaccount.clientbusilogic.DataProfile", paramString, OACProfilePb.ProfileDataRsp.class, paramb);
  }
  
  public static <E extends MessageMicro<?>> void a(String paramString, MessageMicro<?> paramMessageMicro, Class<E> paramClass, kbu.b<E> paramb)
  {
    NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getApplication(), kbu.class);
    PROTOCAL.StQWebReq localStQWebReq = new PROTOCAL.StQWebReq();
    localStQWebReq.Seq.set(-1L);
    localStQWebReq.qua.set(avpq.getQUA3());
    localStQWebReq.deviceInfo.set(avpp.a().getDeviceInfor());
    localStQWebReq.busiBuff.set(ByteStringMicro.copyFrom(paramMessageMicro.toByteArray()));
    paramMessageMicro = sfx.getTraceId();
    if (!TextUtils.isEmpty(paramMessageMicro)) {
      localStQWebReq.traceid.set(paramMessageMicro);
    }
    localNewIntent.putExtra("traceid", paramMessageMicro);
    localNewIntent.putExtra("cmd", paramString);
    localNewIntent.putExtra("data", localStQWebReq.toByteArray());
    localNewIntent.setObserver(new kbu.a(paramb, paramClass));
    BaseApplicationImpl.getApplication().peekAppRuntime().startServlet(localNewIntent);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
    paramIntent = paramIntent.getStringExtra("cmd");
    obd.d(arrayOfByte, paramIntent);
    paramPacket.setSSOCommand(paramIntent);
    if (arrayOfByte != null) {
      paramPacket.putSendData(aqnv.I(arrayOfByte));
    }
  }
  
  static class a<T extends MessageMicro<?>>
    implements BusinessObserver
  {
    private kbu.b<T> a;
    private Class<T> k;
    
    public a(kbu.b<T> paramb, Class<T> paramClass)
    {
      this.a = paramb;
      this.k = paramClass;
    }
    
    private T a(byte[] paramArrayOfByte, Class<T> paramClass)
    {
      try
      {
        paramClass = (MessageMicro)paramClass.newInstance();
        if (paramArrayOfByte == null) {
          return null;
        }
        paramClass.mergeFrom(paramArrayOfByte);
        return paramClass;
      }
      catch (Throwable paramArrayOfByte)
      {
        Toast.makeText(BaseApplicationImpl.getContext(), 2131697432, 0).show();
        QLog.w("PublicAccountStQWebServlet", 4, "decode pb err:" + paramArrayOfByte.getMessage(), paramArrayOfByte);
      }
      return null;
    }
    
    public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
    {
      if (this.a == null) {
        return;
      }
      if (!paramBoolean) {
        this.a.a(paramInt, paramBoolean, null, paramBundle);
      }
      byte[] arrayOfByte = paramBundle.getByteArray("data");
      if (a(arrayOfByte, this.k) == null)
      {
        this.a.a(paramInt, false, null, paramBundle);
        return;
      }
      this.a.a(paramInt, paramBoolean, a(arrayOfByte, this.k), paramBundle);
    }
  }
  
  public static abstract interface b<T>
  {
    public abstract void a(int paramInt, boolean paramBoolean, T paramT, Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kbu
 * JD-Core Version:    0.7.0.1
 */