import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qconn.protofile.fastauthorize.FastAuthorize.AuthorizeResponse;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

class akhr
  implements BusinessObserver
{
  akhr(akhp paramakhp, String paramString, Context paramContext, int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    new Bundle();
    String str = this.val$packageName;
    Object localObject = str;
    if (paramBoolean) {
      localObject = paramBundle.getByteArray("data");
    }
    try
    {
      paramBundle = new FastAuthorize.AuthorizeResponse();
      paramBundle.mergeFrom((byte[])localObject);
      this.b.mUiHandler.removeMessages(6);
      if ((paramBundle.ret.get().equals("0")) && (paramBundle.apk_name.has()))
      {
        if (paramBundle.access_token.has())
        {
          localObject = paramBundle.access_token.get();
          this.b.params = this.b.params.replace("$AT$", (CharSequence)localObject);
        }
        if (paramBundle.pay_token.has())
        {
          localObject = paramBundle.pay_token.get();
          this.b.params = this.b.params.replace("$PT$", (CharSequence)localObject);
        }
        if (paramBundle.openid.has())
        {
          localObject = paramBundle.openid.get();
          this.b.params = this.b.params.replace("$OPID$", (CharSequence)localObject);
        }
        if (paramBundle.pfkey.has())
        {
          localObject = paramBundle.pfkey.get();
          this.b.params = this.b.params.replace("$PF$", (CharSequence)localObject);
        }
        if (paramBundle.encrykey.has())
        {
          localObject = paramBundle.encrykey.get();
          this.b.params = this.b.params.replace("$ESK$", (CharSequence)localObject);
        }
        localObject = paramBundle.apk_name.get();
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return;
        }
        paramBundle = (Bundle)localObject;
        if (((String)localObject).contains(this.val$packageName)) {}
      }
      else
      {
        QLog.d(this.b.getClass().getSimpleName(), 4, "start without login state");
        paramBundle = str;
      }
      localObject = paramBundle;
    }
    catch (InvalidProtocolBufferMicroException paramBundle)
    {
      for (;;)
      {
        localObject = str;
        if (QLog.isColorLevel())
        {
          QLog.d(this.b.getClass().getSimpleName(), 2, paramBundle.getMessage());
          localObject = str;
        }
      }
    }
    paramBundle = anan.f(this.b.params);
    if (QLog.isColorLevel()) {
      QLog.d(getClass().getSimpleName(), 2, "lauchApp now");
    }
    arxn.a(this.val$context, (String)localObject, paramBundle, this.val$flags);
    if (this.b.i != null)
    {
      this.b.i.setObserver(null);
      this.b.i = null;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akhr
 * JD-Core Version:    0.7.0.1
 */