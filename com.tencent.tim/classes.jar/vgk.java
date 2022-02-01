import QQService.DeviceItemDes;
import QQService.SvcDevLoginInfo;
import android.os.Bundle;
import android.os.Message;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AuthDevRenameActivity;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;
import mqq.os.MqqHandler;

public class vgk
  extends MqqHandler
{
  public vgk(LoginInfoActivity paramLoginInfoActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (QLog.isColorLevel()) {
                QLog.d("LoginInfoActivity.AccDevSec", 2, "handleMessage.msg.arg1=" + paramMessage.arg1);
              }
            } while (LoginInfoActivity.a(this.this$0) == null);
            LoginInfoActivity.a(this.this$0).DevSetup = paramMessage.arg1;
            LoginInfoActivity.a(this.this$0, LoginInfoActivity.a(this.this$0));
            return;
            LoginInfoActivity.a(this.this$0, this.this$0.findViewById(1));
            return;
          } while (LoginInfoActivity.a(this.this$0) == null);
          localObject = paramMessage.getData();
        } while (localObject == null);
        paramMessage = ((Bundle)localObject).getString(AuthDevRenameActivity.aLp);
        Object localObject = ((Bundle)localObject).getByteArray(AuthDevRenameActivity.aLr);
        int i = 0;
        for (;;)
        {
          if (i < LoginInfoActivity.a(this.this$0).size())
          {
            SvcDevLoginInfo localSvcDevLoginInfo = (SvcDevLoginInfo)LoginInfoActivity.a(this.this$0).get(i);
            if ((localSvcDevLoginInfo != null) && (Arrays.equals(localSvcDevLoginInfo.stDeviceItemDes.vecItemDes, (byte[])localObject))) {
              localSvcDevLoginInfo.strDeviceName = paramMessage;
            }
          }
          else
          {
            LoginInfoActivity.a(this.this$0, LoginInfoActivity.a(this.this$0));
            return;
          }
          i += 1;
        }
      } while ((LoginInfoActivity.a(this.this$0) == null) || ((!LoginInfoActivity.a(this.this$0)) && (!LoginInfoActivity.b(this.this$0))));
      paramMessage = this.this$0.getString(2131717232);
      if (LoginInfoActivity.a(this.this$0) >= 4)
      {
        LoginInfoActivity.a(this.this$0).setText(paramMessage);
        return;
      }
      LoginInfoActivity.a(this.this$0).setVisibility(0);
      LoginInfoActivity.a(this.this$0, (LoginInfoActivity.a(this.this$0) + 1) % 4);
      switch (LoginInfoActivity.a(this.this$0))
      {
      }
      for (;;)
      {
        sendEmptyMessageDelayed(20170210, 300L);
        return;
        paramMessage = paramMessage + this.this$0.getString(2131719386);
        LoginInfoActivity.a(this.this$0).setText(paramMessage);
        continue;
        paramMessage = paramMessage + this.this$0.getString(2131719387);
        LoginInfoActivity.a(this.this$0).setText(paramMessage);
        continue;
        paramMessage = paramMessage + this.this$0.getString(2131719388);
        LoginInfoActivity.a(this.this$0).setText(paramMessage);
        continue;
        LoginInfoActivity.a(this.this$0).setText(paramMessage);
      }
      paramMessage = paramMessage.getData();
    } while (paramMessage == null);
    boolean bool = paramMessage.getBoolean("bSafe");
    paramMessage = paramMessage.getString("TipText");
    LoginInfoActivity.a(this.this$0, bool, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vgk
 * JD-Core Version:    0.7.0.1
 */