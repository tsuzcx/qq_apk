import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.widget.TextView;
import com.tencent.mobileqq.activity.voip.VoipDialInterface;
import com.tencent.mobileqq.activity.voip.VoipDialInterfaceActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class faw
  extends BroadcastReceiver
{
  public faw(VoipDialInterfaceActivity paramVoipDialInterfaceActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      if ((paramContext != null) && (paramContext.equals(VoipDialInterface.b)))
      {
        VoipDialInterfaceActivity.b(this.a, paramIntent.getIntExtra("value", -1));
        switch (VoipDialInterfaceActivity.n(this.a))
        {
        default: 
          if (QLog.isColorLevel()) {
            QLog.d("script", 2, "VOIP_ debalut");
          }
          break;
        }
      }
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
                                  do
                                  {
                                    do
                                    {
                                      do
                                      {
                                        return;
                                        QLog.d("VoipDialInterfaceActivity", 2, "VOIP_GETUID_SUCCESS");
                                      } while (!QLog.isColorLevel());
                                      QLog.d("script", 2, "VOIP_ VOIP_GETUID_SUCCESS");
                                      return;
                                      QLog.d("VoipDialInterfaceActivity", 2, "VOIP_INIT_FAIL");
                                      if (QLog.isColorLevel()) {
                                        QLog.d("script", 2, "VOIP_ VOIP_INIT_FAIL");
                                      }
                                      this.a.a.a(-1);
                                    } while (VoipDialInterfaceActivity.d(this.a));
                                    this.a.o();
                                  } while (VoipDialInterfaceActivity.b(this.a) == null);
                                  VoipDialInterfaceActivity.b(this.a).setText(this.a.getString(2131559882));
                                  return;
                                  QLog.d("VoipDialInterfaceActivity", 2, "VOIP_INIT_SUCCESS");
                                } while (!QLog.isColorLevel());
                                QLog.d("script", 2, "VOIP_ VOIP_INIT_SUCCESS");
                                return;
                                QLog.d("VoipDialInterfaceActivity", 2, "VOIP_GETUID_FAIL");
                                if (QLog.isColorLevel()) {
                                  QLog.d("script", 2, "VOIP_ VOIP_GETUID_FAIL");
                                }
                                this.a.a.a(-1);
                              } while (VoipDialInterfaceActivity.d(this.a));
                              this.a.o();
                            } while (VoipDialInterfaceActivity.b(this.a) == null);
                            VoipDialInterfaceActivity.b(this.a).setText(this.a.getString(2131559882));
                            return;
                            QLog.d("VoipDialInterfaceActivity", 2, "VOIP_GETUID_SUCCESS");
                          } while (!QLog.isColorLevel());
                          QLog.d("script", 2, "VOIP_ VOIP_GETUID_SUCCESS");
                          return;
                          QLog.d("VoipDialInterfaceActivity", 2, "VOIP_REG_FAIL");
                          if (QLog.isColorLevel()) {
                            QLog.d("script", 2, "VOIP_ VOIP_REG_FAIL");
                          }
                          this.a.a.a(-1);
                        } while (VoipDialInterfaceActivity.d(this.a));
                        this.a.o();
                      } while (VoipDialInterfaceActivity.b(this.a) == null);
                      VoipDialInterfaceActivity.b(this.a).setText(this.a.getString(2131559882));
                      return;
                      QLog.d("VoipDialInterfaceActivity", 2, "VOIP_REG_SUCCESS");
                    } while (!QLog.isColorLevel());
                    QLog.d("script", 2, "VOIP_ VOIP_REG_SUCCESS");
                    return;
                    QLog.d("VoipDialInterfaceActivity", 2, "VOIP_STATE_CALLING");
                    if (QLog.isColorLevel()) {
                      QLog.d("script", 2, "VOIP_ VOIP_STATE_CALLING");
                    }
                    if (VoipDialInterfaceActivity.b(this.a) != null) {
                      VoipDialInterfaceActivity.b(this.a).setText(this.a.getString(2131559883));
                    }
                    ((AudioManager)this.a.getSystemService("audio")).setMode(3);
                    return;
                    QLog.d("VoipDialInterfaceActivity", 2, "VOIP_STATE_CONNECTING");
                    if (QLog.isColorLevel()) {
                      QLog.d("script", 2, "VOIP_ VOIP_STATE_CONNECTING");
                    }
                  } while (VoipDialInterfaceActivity.b(this.a) == null);
                  VoipDialInterfaceActivity.b(this.a).setText(this.a.getString(2131559884));
                  return;
                  QLog.d("VoipDialInterfaceActivity", 2, "VOIP_STATE_CONNECTED");
                  if (QLog.isColorLevel()) {
                    QLog.d("script", 2, "VOIP_ VOIP_STATE_CONNECTED");
                  }
                  VoipDialInterfaceActivity.a(this.a, System.currentTimeMillis());
                  QLog.d("script", 2, "VOIP_ (VOIP_STATE_CONNECTED) >> m_ldialStartTime:" + VoipDialInterfaceActivity.c(this.a));
                  QLog.d("script", 2, "VOIP_  >> m_ldialEndTime:" + VoipDialInterfaceActivity.d(this.a));
                  if (this.a.a == null) {
                    this.a.a = VoipDialInterface.a();
                  }
                  if (this.a.a != null) {
                    this.a.a.a(VoipDialInterfaceActivity.c(this.a), VoipDialInterfaceActivity.d(this.a));
                  }
                  this.a.p();
                } while (VoipDialInterfaceActivity.b(this.a) == null);
                VoipDialInterfaceActivity.b(this.a).setText(this.a.getString(2131559885));
                return;
                QLog.d("VoipDialInterfaceActivity", 2, "VOIP_STATE_DISCONNECTED");
                if (QLog.isColorLevel()) {
                  QLog.d("script", 2, "VOIP_ VOIP_STATE_DISCONNECTED");
                }
                this.a.a.a(-1);
              } while (VoipDialInterfaceActivity.d(this.a));
              this.a.o();
              return;
              QLog.d("VoipDialInterfaceActivity", 2, "VOIP_STATE_UNKNOWN");
            } while (!QLog.isColorLevel());
            QLog.d("script", 2, "VOIP_ VOIP_STATE_UNKNOWN");
            return;
            QLog.d("VoipDialInterfaceActivity", 2, "VOIP_CHECK_BALANCE_FAIL");
            if (QLog.isColorLevel()) {
              QLog.d("script", 2, "VOIP_ VOIP_CHECK_BALANCE_FAIL");
            }
            this.a.a.a(-1);
          } while (VoipDialInterfaceActivity.d(this.a));
          this.a.o();
        } while (VoipDialInterfaceActivity.b(this.a) == null);
        VoipDialInterfaceActivity.b(this.a).setText(this.a.getString(2131559886));
        return;
        QLog.d("VoipDialInterfaceActivity", 2, "VOIP_CHECK_BALANCE_SUCCESS");
      } while (!QLog.isColorLevel());
      QLog.d("script", 2, "VOIP_ VOIP_CHECK_BALANCE_SUCCESS");
      return;
      QLog.d("VoipDialInterfaceActivity", 2, "VOIP_BALANCE_NOTENOUGH");
      if (QLog.isColorLevel()) {
        QLog.d("script", 2, "VOIP_ VOIP_BALANCE_NOTENOUGH");
      }
      this.a.a.a(-1);
    } while (VoipDialInterfaceActivity.d(this.a));
    this.a.d();
    if (VoipDialInterfaceActivity.b(this.a) != null) {
      VoipDialInterfaceActivity.b(this.a).setText(this.a.getString(2131559887));
    }
    ReportController.b(this.a.b, "CliOper", "", "", "CallTab_external", "Recharge", 7, 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     faw
 * JD-Core Version:    0.7.0.1
 */