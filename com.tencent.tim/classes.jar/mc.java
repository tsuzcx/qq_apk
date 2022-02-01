import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xa4d.oidb_0xa4d.IMMRReq;
import tencent.im.oidb.cmd0xa4d.oidb_0xa4d.IMMRRsp;
import tencent.im.oidb.cmd0xa4d.oidb_0xa4d.ReqBody;
import tencent.im.oidb.cmd0xa4d.oidb_0xa4d.RspBody;

public class mc
  extends accg
{
  private mb b;
  private QQAppInterface mApp;
  
  public mc(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.mApp = paramQQAppInterface;
  }
  
  public void V(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ImmersionHandler", 2, "HapticMediaPlayer start request");
    }
    oidb_0xa4d.IMMRReq localIMMRReq = new oidb_0xa4d.IMMRReq();
    localIMMRReq.str_url.set(paramString);
    paramString = new oidb_0xa4d.ReqBody();
    paramString.msg_immr_req.set(localIMMRReq);
    jnm.a(this.mApp, new mc.a(false, this.b), paramString.toByteArray(), "OidbSvc.0xa4d", 2637, 1, null);
  }
  
  public void a(mb parammb)
  {
    this.b = parammb;
  }
  
  protected Class<? extends acci> observerClass()
  {
    return null;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mApp = null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public static class a
    extends jnm.d
  {
    private mb b;
    
    public a(boolean paramBoolean, mb parammb)
    {
      super();
      this.b = parammb;
    }
    
    public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
    {
      paramBundle = new oidb_0xa4d.RspBody();
      if (paramInt == 0) {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.i("ImmersionHandler", 2, "HapticMediaPlayer request success.errorcode = " + paramInt);
          }
          paramBundle.mergeFrom(paramArrayOfByte);
          paramArrayOfByte = (oidb_0xa4d.IMMRRsp)paramBundle.msg_immr_rsp.get();
          this.b.setConnection(new ma(paramArrayOfByte));
          return;
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
          return;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.e("ImmersionHandler", 2, "HapticMediaPlayer request failerrorcode = " + paramInt);
      }
      this.b.setConnection(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mc
 * JD-Core Version:    0.7.0.1
 */