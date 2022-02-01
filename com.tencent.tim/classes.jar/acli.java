import android.content.Intent;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.AccountSecurityInfo.SecCheckBanner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.msfmqpsdkbridge.MSFIntChkStrike;
import com.tencent.msfmqpsdkbridge.MSFNetTransportProvider;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;
import com.tencent.qqprotect.sfcfg.QPTxVerifyApkTimerTask;
import tencent.im.s2c.msgtype0x210.submsgtype0x4a.MsgBody;

public class acli
  extends accg
{
  public static int cxT;
  
  public acli(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public static void cMm()
  {
    try
    {
      cxT += 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void cMn()
  {
    try
    {
      cxT -= 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void aK(byte[] paramArrayOfByte)
  {
    Object localObject = new MsgBody();
    do
    {
      try
      {
        ((MsgBody)localObject).mergeFrom(paramArrayOfByte);
        if ((!((MsgBody)localObject).has()) || (!((MsgBody)localObject).uint32_sec_cmd.has())) {
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        do
        {
          do
          {
            do
            {
              do
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("SafeCenterPushHandler", 2, "onReceive: onReceive push package: msgbody parse fail");
                  }
                  paramArrayOfByte.printStackTrace();
                }
                switch (((MsgBody)localObject).uint32_sec_cmd.get())
                {
                case 5: 
                default: 
                  return;
                case 1: 
                  new syi(this.app).bBX();
                  return;
                case 2: 
                  paramArrayOfByte = (MSFNetTransportProvider)this.app.getBusinessHandler(63);
                  paramArrayOfByte = new arnx(this.app.getApp().getApplicationContext(), paramArrayOfByte);
                }
              } while (paramArrayOfByte == null);
              paramArrayOfByte = (aroa)paramArrayOfByte.v("intchk");
            } while (paramArrayOfByte == null);
            paramArrayOfByte.a(1, new MSFIntChkStrike(this.app, 1));
            paramArrayOfByte.a(2, new MSFIntChkStrike(this.app, 2));
            paramArrayOfByte.a(3, new MSFIntChkStrike(this.app, 3));
            paramArrayOfByte.start("3.4.4." + AppSetting.getRevision());
            return;
            paramArrayOfByte = (MSFNetTransportProvider)this.app.getBusinessHandler(63);
            paramArrayOfByte = new arnx(this.app.getApp().getApplicationContext(), paramArrayOfByte);
          } while (paramArrayOfByte == null);
          paramArrayOfByte = (arnz)paramArrayOfByte.v("app_scan");
        } while (paramArrayOfByte == null);
        paramArrayOfByte.bG(((MsgBody)localObject).bytes_data.get().toByteArray());
        return;
        localObject = ((MsgBody)localObject).bytes_data.get().toByteArray();
        paramArrayOfByte = new AccountSecurityInfo.SecCheckBanner();
        try
        {
          paramArrayOfByte.mergeFrom((byte[])localObject);
          localObject = paramArrayOfByte.str_wording.get();
          int i = paramArrayOfByte.u32_timeToShow.get();
          paramArrayOfByte = new Intent();
          paramArrayOfByte.putExtra("wording", (String)localObject);
          paramArrayOfByte.putExtra("timetowait", i);
          this.app.dj(paramArrayOfByte);
          return;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          for (;;)
          {
            localInvalidProtocolBufferMicroException.printStackTrace();
          }
        }
        new QPTxVerifyApkTimerTask(this.app, true).ekC();
        return;
      }
    } while (localInvalidProtocolBufferMicroException.bytes_data.get() == null);
    QSecFramework.a().bW(localInvalidProtocolBufferMicroException.bytes_data.get().toByteArray());
  }
  
  protected Class<? extends acci> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acli
 * JD-Core Version:    0.7.0.1
 */