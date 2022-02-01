import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class ahkm
  implements BusinessObserver
{
  ahkm(ahki paramahki) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.this$0.x("KEY_GET_APP_INFO", paramBoolean);
    QLog.d("ForwardOption.ForwardSdkBaseOption", 1, new Object[] { "AppinfoObserver onReceive isSuccess = ", Boolean.valueOf(paramBoolean) });
    Object localObject2 = null;
    synchronized (ahki.dZ)
    {
      this.this$0.chl = false;
      Object localObject1 = localObject2;
      if (paramBoolean) {}
      for (;;)
      {
        try
        {
          localObject1 = paramBundle.getByteArray("data");
          if (localObject1 != null) {
            paramBundle = new GetAppInfoProto.GetAppinfoResponse();
          }
        }
        catch (Exception localException1)
        {
          paramBundle = null;
        }
        try
        {
          paramBundle.mergeFrom((byte[])localObject1);
          this.this$0.b = ahgf.a(paramBundle);
          if ((this.this$0 instanceof ahkr)) {
            ((ahlc)this.this$0.app.getManager(350)).a().a(this.this$0.mShareAppId, this.this$0.b);
          }
          QLog.d("ForwardOption.ForwardSdkBaseOption", 1, new Object[] { "get appinfo time=", Long.valueOf(System.currentTimeMillis() - this.this$0.aaE), ", ret=", Integer.valueOf(paramBundle.ret.get()) });
          this.this$0.dox();
          localObject1 = paramBundle;
          this.this$0.hideProgressDialog();
          if ((localObject1 == null) || (((GetAppInfoProto.GetAppinfoResponse)localObject1).ret.get() == 0) || (!(this.this$0 instanceof ahkr))) {
            break;
          }
          if (this.this$0.bf.getBoolean("enable_d55", false)) {
            this.this$0.ck(((GetAppInfoProto.GetAppinfoResponse)localObject1).msg.get(), true);
          }
          ahki.dZ.notify();
          return;
        }
        catch (Exception localException2)
        {
          Bundle localBundle;
          break label298;
        }
        QLog.e("ForwardOption.ForwardSdkBaseOption", 1, "AppinfoObserver onReceive data=null");
        localObject1 = localObject2;
        continue;
        label298:
        QLog.e("ForwardOption.ForwardSdkBaseOption", 1, new Object[] { "AppinfoObserver.onReceive ", localException1.getMessage() });
        localBundle = paramBundle;
      }
      QLog.d("ForwardOption.ForwardSdkBaseOption", 1, "AppinfoObserver onReceive success, go share");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahkm
 * JD-Core Version:    0.7.0.1
 */