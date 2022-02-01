import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtReq;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.UUID;

public abstract class jlu
{
  final String TAG;
  protected AppInterface app;
  private final int commandId;
  
  protected jlu(AppInterface paramAppInterface, int paramInt, long paramLong)
  {
    this.TAG = ("FileUpload_" + paramInt + "_" + paramLong);
    this.commandId = paramInt;
    this.app = paramAppInterface;
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    if (paramAppInterface != null) {
      paramAppInterface.getHwEngine().preConnect();
    }
  }
  
  public static byte[] a(String paramString, AppInterface paramAppInterface)
  {
    try
    {
      String str = paramAppInterface.getCurrentAccountUin();
      if (SessionInfo.getInstance(str).getHttpconn_sig_session() != null)
      {
        int i = SessionInfo.getInstance(str).getHttpconn_sig_session().length;
        paramString = new byte[i];
        System.arraycopy(SessionInfo.getInstance(str).getHttpconn_sig_session(), 0, paramString, 0, i);
        return paramString;
      }
      HwServlet.getConfig(paramAppInterface, str);
      QLog.w(paramString, 1, "getSig, fail");
      return null;
    }
    finally {}
  }
  
  protected boolean a(String paramString, jlu.a parama)
  {
    long l = new File(paramString).length();
    String str = adgp.c(this.app);
    if (l == 0L)
    {
      parama.d(-10001, str, "", null);
      return false;
    }
    Object localObject = a(this.TAG, this.app);
    if ((localObject == null) || (localObject.length == 0))
    {
      parama.d(-10003, str, "", null);
      return false;
    }
    byte[] arrayOfByte = adgp.t(paramString);
    if ((arrayOfByte == null) || (arrayOfByte.length == 0))
    {
      parama.d(-10002, str, "", null);
      return false;
    }
    jlv localjlv = new jlv(this, str, l, arrayOfByte, parama);
    Bdh_extinfo.CommFileExtReq localCommFileExtReq = new Bdh_extinfo.CommFileExtReq();
    localCommFileExtReq.uint32_action_type.set(0);
    localCommFileExtReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(UUID.randomUUID().toString()));
    localObject = new Transaction(this.app.getCurrentAccountUin(), this.commandId, paramString, 0, (byte[])localObject, arrayOfByte, localjlv, localCommFileExtReq.toByteArray());
    int i = this.app.getHwEngine().submitTransactionTask((Transaction)localObject);
    if (i != 0) {
      parama.d(i, str, "", null);
    }
    QLog.w(this.TAG, 1, "requestToUpload, localFile[" + paramString + "], sessionId[" + str + "]");
    return i == 0;
  }
  
  public static abstract interface a
  {
    public abstract void d(int paramInt, String paramString1, String paramString2, String paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jlu
 * JD-Core Version:    0.7.0.1
 */