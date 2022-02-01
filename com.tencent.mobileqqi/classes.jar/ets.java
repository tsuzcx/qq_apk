import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.voip.VoipDialInterface;
import com.tencent.mobileqq.activity.voip.VoipErrorCodeEnum;
import com.tencent.mobileqq.activity.voip.VoipGetUid.ResponseBody;
import com.tencent.mobileqq.activity.voip.VoipSSOInterface;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.voip.VoipSIPInterface;

public class ets
  extends Handler
{
  public ets(VoipDialInterface paramVoipDialInterface) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 2: 
    default: 
    case 100: 
    case 1: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
      for (;;)
      {
        super.handleMessage(paramMessage);
        return;
        QLog.d(VoipDialInterface.a, 4, "cuiyl begin exchange uid");
        VoipDialInterface.a(this.a).a(VoipDialInterface.a(this.a));
        continue;
        VoipDialInterface.b(this.a);
        localObject = new Intent();
        ((Intent)localObject).putExtra("value", VoipErrorCodeEnum.VOIP_INIT_FAIL.ordinal());
        ((Intent)localObject).setAction(VoipDialInterface.jdField_b_of_type_JavaLangString);
        BaseApplication.getContext().sendBroadcast((Intent)localObject);
        this.a.a(-1);
        this.a.b();
        continue;
        VoipDialInterface.b(this.a);
        localObject = new Intent();
        ((Intent)localObject).setAction(VoipDialInterface.jdField_b_of_type_JavaLangString);
        ((Intent)localObject).putExtra("value", VoipErrorCodeEnum.VOIP_GETUID_FAIL.ordinal());
        BaseApplication.getContext().sendBroadcast((Intent)localObject);
        this.a.a(-1);
        this.a.b();
        continue;
        QLog.d(VoipDialInterface.a, 4, "cuiyl getuid success");
        localObject = (VoipGetUid.ResponseBody)paramMessage.obj;
        if (((VoipGetUid.ResponseBody)localObject).extern_sign.get() == 0)
        {
          VoipDialInterface.b(this.a);
          Intent localIntent = new Intent();
          localIntent.setAction(VoipDialInterface.jdField_b_of_type_JavaLangString);
          localIntent.putExtra("cash", ((VoipGetUid.ResponseBody)localObject).cash.get());
          localIntent.putExtra("value", VoipErrorCodeEnum.VOIP_BALANCE_NOTENOUGH.ordinal());
          BaseApplication.getContext().sendBroadcast(localIntent);
          this.a.a(-1);
        }
        else
        {
          VoipDialInterface.a(this.a, ((VoipGetUid.ResponseBody)localObject).domain.get());
          VoipDialInterface.d = VoipDialInterface.a(this.a).RegAccount(((VoipGetUid.ResponseBody)localObject).user.get(), ((VoipGetUid.ResponseBody)localObject).password.get(), VoipDialInterface.b(this.a));
          if (VoipDialInterface.d == VoipDialInterface.jdField_b_of_type_Int)
          {
            VoipDialInterface.a(this.a).sendEmptyMessage(VoipErrorCodeEnum.VOIP_REG_FAIL.ordinal());
          }
          else
          {
            VoipDialInterface.a(this.a).sendEmptyMessage(VoipErrorCodeEnum.VOIP_REG_SUCCESS.ordinal());
            continue;
            VoipDialInterface.b(this.a);
            localObject = new Intent();
            ((Intent)localObject).setAction(VoipDialInterface.jdField_b_of_type_JavaLangString);
            ((Intent)localObject).putExtra("value", VoipErrorCodeEnum.VOIP_REG_FAIL.ordinal());
            BaseApplication.getContext().sendBroadcast((Intent)localObject);
            this.a.a(-1);
            this.a.b();
            continue;
            QLog.d(VoipDialInterface.a, 4, "cuiyl begin call");
            if (VoipDialInterface.d != VoipDialInterface.jdField_b_of_type_Int) {
              VoipDialInterface.a(this.a, VoipDialInterface.a(this.a).MakeCall(VoipDialInterface.d, VoipDialInterface.a(this.a), VoipDialInterface.b(this.a)));
            }
          }
        }
      }
    }
    Object localObject = new Intent();
    ((Intent)localObject).setAction(VoipDialInterface.jdField_b_of_type_JavaLangString);
    switch (paramMessage.arg1)
    {
    case 2: 
    case 3: 
    default: 
      ((Intent)localObject).putExtra("value", VoipErrorCodeEnum.VOIP_STATE_UNKNOWN.ordinal());
    }
    for (;;)
    {
      BaseApplication.getContext().sendBroadcast((Intent)localObject);
      break;
      VoipDialInterface.a(this.a, 0L);
      VoipDialInterface.a(this.a).postDelayed(VoipDialInterface.a(this.a), 1L);
      QLog.d(VoipDialInterface.a, 4, "cuiyl calling");
      ((Intent)localObject).putExtra("value", VoipErrorCodeEnum.VOIP_STATE_CALLING.ordinal());
      continue;
      QLog.d(VoipDialInterface.a, 4, "cuiyl connecting");
      ((Intent)localObject).putExtra("value", VoipErrorCodeEnum.VOIP_STATE_CONNECTING.ordinal());
      continue;
      QLog.d(VoipDialInterface.a, 4, "cuiyl connected");
      ((Intent)localObject).putExtra("value", VoipErrorCodeEnum.VOIP_STATE_CONNECTED.ordinal());
      this.a.b();
      continue;
      QLog.d(VoipDialInterface.a, 4, "cuiyl disconnected");
      ((Intent)localObject).putExtra("value", VoipErrorCodeEnum.VOIP_STATE_DISCONNECTED.ordinal());
      VoipDialInterface.b(this.a);
      this.a.a(-1);
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ets
 * JD-Core Version:    0.7.0.1
 */