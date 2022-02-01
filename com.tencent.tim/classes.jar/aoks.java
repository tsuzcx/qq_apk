import android.os.Bundle;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.protofile.getappinfo.GetAppInfoProto.AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.observer.BusinessObserver;

class aoks
  implements BusinessObserver
{
  aoks(aokr.b paramb) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, "GetAppInfoStep|isSuccess=" + paramBoolean + ",time=" + (System.currentTimeMillis() - aokr.b(this.a.this$0)));
    int i = -1;
    paramInt = i;
    if (paramBoolean) {
      paramInt = i;
    }
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      paramInt = i;
      if (paramBundle != null)
      {
        paramInt = i;
        GetAppInfoProto.GetAppinfoResponse localGetAppinfoResponse = new GetAppInfoProto.GetAppinfoResponse();
        paramInt = i;
        localGetAppinfoResponse.mergeFrom(paramBundle);
        paramInt = i;
        i = localGetAppinfoResponse.ret.get();
        paramInt = i;
        if (QLog.isColorLevel())
        {
          paramInt = i;
          QLog.i("Q.share.ForwardSdkShareProcessor", 2, "GetAppInfoStep|ret=" + i);
        }
        paramInt = i;
        if (i == 0)
        {
          paramInt = i;
          aokr.a(this.a.this$0).cmr = svi.a(localGetAppinfoResponse.iconsURL, 16);
          paramInt = i;
          aokr.a(this.a.this$0).sourceIconBig = svi.a(localGetAppinfoResponse.iconsURL, 100);
          paramInt = i;
          if (localGetAppinfoResponse.androidInfo != null)
          {
            paramInt = i;
            paramBundle = localGetAppinfoResponse.androidInfo;
            paramInt = i;
            if (paramBundle.packName.has())
            {
              paramInt = i;
              aokr.a(this.a.this$0).packName = paramBundle.packName.get();
            }
            paramInt = i;
            if (paramBundle.messagetail.has())
            {
              paramInt = i;
              aokr.a(this.a.this$0).sourceName = paramBundle.messagetail.get();
            }
            paramInt = i;
            if (paramBundle.sourceUrl.has())
            {
              paramInt = i;
              if (aokr.a(this.a.this$0) != Long.parseLong("1103584836"))
              {
                paramInt = i;
                aokr.a(this.a.this$0).sourceUrl = paramBundle.sourceUrl.get();
              }
            }
          }
          paramInt = i;
          aokr.a(this.a.this$0).status = 1;
          paramInt = i;
          aokr.b.a(this.a);
          paramInt = i;
        }
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        QLog.e("Q.share.ForwardSdkShareProcessor", 1, paramBundle, new Object[0]);
      }
      aokr.b.a(this.a).set(true);
      this.a.dVB();
    }
    if ((aokr.a(this.a.this$0).status != 1) && (aokr.b.a(this.a) < 2) && (paramInt != 110507) && (paramInt != 110401))
    {
      aokr.b.b(this.a);
      this.a.process();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoks
 * JD-Core Version:    0.7.0.1
 */