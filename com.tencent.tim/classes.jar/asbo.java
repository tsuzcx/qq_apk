import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qconn.protofile.preAuth.PreAuthRequest;
import com.tencent.qconn.protofile.preAuth.PreAuthResponse;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class asbo
  implements BusinessObserver
{
  asbo(asbh paramasbh, asav paramasav, boolean paramBoolean, asbh.b paramb, int paramInt, preAuth.PreAuthRequest paramPreAuthRequest, Activity paramActivity) {}
  
  private void ea(int paramInt, String paramString)
  {
    QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, new Object[] { "--> preAuth onFail mPreAuthRetryCount=", Integer.valueOf(asbh.c(this.this$0)), ", errorCode=", Integer.valueOf(paramInt) });
    if ((asbh.c(this.this$0) < this.bdW) && (paramInt != 110537) && (paramInt != 110509))
    {
      asbh.d(this.this$0);
      this.this$0.a(this.a, this.val$activity, this.c, this.b, this.bdW);
      return;
    }
    asbh.b(this.this$0, 0);
    this.b.ea(paramInt, paramString);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, new Object[] { "preAuthWithRetry isSuccess=", Boolean.valueOf(paramBoolean), ", type=", Integer.valueOf(paramInt), ", mPreAuthRetryCount=", Integer.valueOf(asbh.c(this.this$0)) });
    if (!paramBoolean)
    {
      ahlw.a("KEY_PRE_AUTH", this.c, false);
      ea(paramBundle.getInt("code", -1), "");
      return;
    }
    byte[] arrayOfByte = paramBundle.getByteArray("data");
    if (arrayOfByte == null)
    {
      ahlw.a("KEY_PRE_AUTH", this.c, false);
      ea(paramBundle.getInt("code", -1), "");
      return;
    }
    preAuth.PreAuthResponse localPreAuthResponse = new preAuth.PreAuthResponse();
    Object localObject = arrayOfByte;
    if (this.dcO) {
      localObject = asbp.b(arrayOfByte, this.c);
    }
    try
    {
      localObject = (preAuth.PreAuthResponse)localPreAuthResponse.mergeFrom((byte[])localObject);
      if ((((preAuth.PreAuthResponse)localObject).ret.has()) && (((preAuth.PreAuthResponse)localObject).ret.get() == 0))
      {
        QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, "--> preAuth mergeFrom success");
        ahlw.a("KEY_PRE_AUTH", this.c, true);
        asbh.a(this.this$0, (preAuth.PreAuthResponse)localObject);
        asbh.b(this.this$0, 0);
        this.b.onSuccess();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("SDK_LOGIN.OpenSdkVirtualManager", 1, "Exception", localException);
      ahlw.a("KEY_PRE_AUTH", this.c, false);
      ea(paramBundle.getInt("code", -1), "");
      return;
    }
    QLog.d("SDK_LOGIN.OpenSdkVirtualManager", 1, new Object[] { "--> preAuth mergeFrom fail ret=", Integer.valueOf(localException.ret.get()), ", msg=", localException.msg.get() });
    ahlw.a("KEY_PRE_AUTH", this.c, false);
    ea(localException.ret.get(), localException.msg.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     asbo
 * JD-Core Version:    0.7.0.1
 */