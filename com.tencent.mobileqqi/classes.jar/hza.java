import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeAudioManager;
import com.tencent.sharp.jni.TraeAudioManager.DeviceConfigManager;
import java.util.HashMap;

class hza
  extends Handler
{
  hza(hyy paramhyy) {}
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject;
    label98:
    do
    {
      do
      {
        try
        {
          HashMap localHashMap = (HashMap)paramMessage.obj;
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder().append("TraeAudioManagerLooper msg:").append(paramMessage.what).append(" _enabled:");
            if (this.a.a)
            {
              str = "Y";
              QLog.w("TRAE", 2, str);
            }
          }
          else
          {
            if (paramMessage.what != 32772) {
              break label98;
            }
            this.a.a(localHashMap);
            return;
          }
        }
        catch (Exception localException)
        {
          do
          {
            for (;;)
            {
              localObject = null;
              continue;
              String str = "N";
            }
            if (!this.a.a)
            {
              if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "******* disabled ,skip msg******");
              }
              paramMessage = new Intent();
              this.a.b.a(paramMessage, (HashMap)localObject, 1);
              return;
            }
            switch (paramMessage.what)
            {
            default: 
              return;
            case 32773: 
              this.a.b();
              return;
            case 32774: 
              this.a.a((HashMap)localObject);
              return;
            case 32777: 
              this.a.b.c((HashMap)localObject);
              return;
            case 32778: 
              this.a.b.d((HashMap)localObject);
              return;
            case 32779: 
              this.a.b.e((HashMap)localObject);
              return;
            case 32780: 
              this.a.b((HashMap)localObject);
              return;
            case 32781: 
              this.a.c((HashMap)localObject);
              return;
            case 32788: 
              paramMessage = (Integer)((HashMap)localObject).get("PARAM_STREAMTYPE");
              if (paramMessage != null) {
                break label335;
              }
            }
          } while (!QLog.isColorLevel());
          QLog.e("TRAE", 2, " MESSAGE_VOICECALL_AUIDOPARAM_CHANGED params.get(PARAM_STREAMTYPE)==null!!");
          return;
          this.a.b.y = paramMessage.intValue();
          this.a.a(paramMessage.intValue());
          return;
          this.a.d((HashMap)localObject);
          return;
          this.a.e((HashMap)localObject);
          return;
          this.a.f((HashMap)localObject);
          return;
          this.a.b.a((HashMap)localObject);
          return;
          this.a.b.b((HashMap)localObject);
          return;
          paramMessage = this.a.b.a.b();
          localObject = this.a.b.a.d();
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "MESSAGE_AUTO_DEVICELIST_UPDATE  connectedDev:" + (String)localObject + " highestDev" + paramMessage);
          }
          if (!paramMessage.equals(localObject))
          {
            this.a.b.a(paramMessage, null);
            return;
          }
          this.a.b.a();
          return;
        }
        paramMessage = (String)((HashMap)localObject).get("PARAM_DEVICE");
      } while (this.a.b.a(paramMessage, null) == 0);
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, " plugin dev:" + paramMessage + " sessionConnectedDev:" + this.a.b.ak + " connected fail,auto switch!");
      }
      this.a.b.a(this.a.b.a.b(), null);
      return;
    } while (this.a.b.a(this.a.b.ak, null) == 0);
    label335:
    paramMessage = (String)((HashMap)localObject).get("PARAM_DEVICE");
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, " plugout dev:" + paramMessage + " sessionConnectedDev:" + this.a.b.ak + " connected fail,auto switch!");
    }
    this.a.b.a(this.a.b.a.b(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hza
 * JD-Core Version:    0.7.0.1
 */