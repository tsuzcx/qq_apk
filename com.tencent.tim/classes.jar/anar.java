import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qconn.protofile.fastauthorize.FastAuthorize.AuthorizeResponse;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

class anar
  implements BusinessObserver
{
  anar(anan paramanan, long paramLong, String paramString, Context paramContext, int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("AppLaucherHelper", 2, "t=" + (System.currentTimeMillis() - this.akq));
      QLog.d(this.a.getClass().getSimpleName(), 2, "onReceive");
    }
    new Bundle();
    Object localObject1 = this.val$packageName;
    if (paramBoolean)
    {
      Object localObject2 = paramBundle.getByteArray("data");
      try
      {
        paramBundle = new FastAuthorize.AuthorizeResponse();
        paramBundle.mergeFrom((byte[])localObject2);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("ret=").append(paramBundle.ret.get()).append(", ");
          ((StringBuilder)localObject2).append("msg=").append(paramBundle.msg.get()).append(", ");
          ((StringBuilder)localObject2).append("access_token=").append(paramBundle.access_token.get()).append(", ");
          ((StringBuilder)localObject2).append("expires_in=").append(paramBundle.expires_in.get()).append(", ");
          ((StringBuilder)localObject2).append("openid=").append(paramBundle.openid.get()).append(", ");
          ((StringBuilder)localObject2).append("pay_token=").append(paramBundle.pay_token.get()).append(", ");
          ((StringBuilder)localObject2).append("pf=").append(paramBundle.pf.get()).append(", ");
          ((StringBuilder)localObject2).append("pfkey=").append(paramBundle.pfkey.get()).append(", ");
          ((StringBuilder)localObject2).append("encrykey=").append(paramBundle.encrykey.get()).append(", ");
          ((StringBuilder)localObject2).append("apk_name=").append(paramBundle.apk_name.get()).append(", ");
          QLog.d("AppLaucherHelper", 2, "FastAuthorize.AuthorizeResponse=[" + ((StringBuilder)localObject2).toString() + "]");
        }
        this.a.mHandler.removeMessages(0);
        this.a.mHandler.removeMessages(1);
        this.a.nb.remove(this.val$packageName);
        if ((!paramBundle.ret.get().equals("0")) || (!paramBundle.apk_name.has())) {
          break label1164;
        }
        if (paramBundle.access_token.has())
        {
          localObject2 = paramBundle.access_token.get();
          this.a.ccI = this.a.ccI.replace("$AT$", (CharSequence)localObject2);
        }
        if (paramBundle.pay_token.has())
        {
          localObject2 = paramBundle.pay_token.get();
          this.a.ccI = this.a.ccI.replace("$PT$", (CharSequence)localObject2);
        }
        if (paramBundle.openid.has())
        {
          localObject2 = paramBundle.openid.get();
          this.a.ccI = this.a.ccI.replace("$OPID$", (CharSequence)localObject2);
        }
        for (;;)
        {
          if (paramBundle.pfkey.has())
          {
            localObject2 = paramBundle.pfkey.get();
            this.a.ccI = this.a.ccI.replace("$PF$", (CharSequence)localObject2);
          }
          if (paramBundle.encrykey.has())
          {
            localObject2 = paramBundle.encrykey.get();
            this.a.ccI = this.a.ccI.replace("$ESK$", (CharSequence)localObject2);
          }
          if (QLog.isColorLevel()) {
            QLog.d(this.a.getClass().getSimpleName(), 2, "mParams=" + this.a.ccI);
          }
          paramBundle = paramBundle.apk_name.get();
          if ((!TextUtils.isEmpty(paramBundle)) && (paramBundle.contains(this.val$packageName))) {
            break;
          }
          anan.cEB = false;
          QLog.d(this.a.getClass().getSimpleName(), 2, "cant't start app pkg invalide");
          return;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("ret=").append(paramBundle.ret.get()).append(", ");
          ((StringBuilder)localObject2).append("msg=").append(paramBundle.msg.get()).append(", ");
          ((StringBuilder)localObject2).append("access_token=").append(paramBundle.access_token.get()).append(", ");
          ((StringBuilder)localObject2).append("expires_in=").append(paramBundle.expires_in.get()).append(", ");
          ((StringBuilder)localObject2).append("openid=").append(paramBundle.openid.get()).append(", ");
          ((StringBuilder)localObject2).append("pay_token=").append(paramBundle.pay_token.get()).append(", ");
          ((StringBuilder)localObject2).append("pf=").append(paramBundle.pf.get()).append(", ");
          ((StringBuilder)localObject2).append("pfkey=").append(paramBundle.pfkey.get()).append(", ");
          ((StringBuilder)localObject2).append("encrykey=").append(paramBundle.encrykey.get()).append(", ");
          ((StringBuilder)localObject2).append("apk_name=").append(paramBundle.apk_name.get()).append(", ");
          QLog.d("AppLaucherHelper", 1, "FastAuthorize.AuthorizeResponse=[" + ((StringBuilder)localObject2).toString() + "]");
        }
        localObject1 = paramBundle;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
      {
        paramBundle = (Bundle)localObject1;
      }
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d(this.a.getClass().getSimpleName(), 2, localInvalidProtocolBufferMicroException1.getMessage());
          localObject1 = paramBundle;
        }
        for (;;)
        {
          paramBundle = anan.f(this.a.ccI);
          if (QLog.isColorLevel()) {
            QLog.d(getClass().getSimpleName(), 2, "lauchApp now");
          }
          arxn.a(this.val$context, (String)localObject1, paramBundle, this.val$flags);
          anan.cEB = false;
          if (this.a.i == null) {
            return;
          }
          this.a.i.setObserver(null);
          this.a.i = null;
          return;
          try
          {
            QLog.d(this.a.getClass().getSimpleName(), 4, "pkg=" + paramBundle);
            localObject1 = paramBundle;
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2) {}
        }
      }
      label1164:
      QLog.d(this.a.getClass().getSimpleName(), 4, "start without login state");
    }
    for (;;)
    {
      break;
      QLog.e("AppLaucherHelper", 1, "FastAuthorize.AuthorizeRequest failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anar
 * JD-Core Version:    0.7.0.1
 */