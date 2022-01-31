import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class bgy
  extends BroadcastReceiver
{
  public bgy(VideoAppInterface paramVideoAppInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    long l;
    boolean bool;
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
                try
                {
                  if (QLog.isColorLevel()) {
                    QLog.d(VideoAppInterface.jdField_a_of_type_JavaLangString, 2, "recv account broadcast: " + paramIntent.getAction());
                  }
                  if (!paramIntent.getAction().equals("mqq.i.intent.action.ACCOUNT_KICKED")) {
                    break;
                  }
                  this.a.a();
                  return;
                }
                catch (RuntimeException paramContext) {}
              } while (!QLog.isColorLevel());
              QLog.e(VideoAppInterface.jdField_a_of_type_JavaLangString, 2, "RuntimeException", paramContext);
              return;
              if (paramIntent.getAction().equals("mqq.i.intent.action.ACCOUNT_EXPIRED"))
              {
                this.a.a();
                return;
              }
              if (paramIntent.getAction().equals("mqq.i.intent.action.LOGOUT"))
              {
                this.a.a();
                return;
              }
              if (paramIntent.getAction().equals("mqq.intent.action.EXIT_" + this.a.a().getPackageName()))
              {
                this.a.a();
                return;
              }
              if (!"mqq.intent.action.ACCOUNT_CHANGED".equals(paramIntent.getAction())) {
                break;
              }
            } while (this.a.jdField_a_of_type_ComTencentAvVideoController == null);
            if (this.a.jdField_a_of_type_ComTencentAvVideoController.f) {
              this.a.jdField_a_of_type_ComTencentAvVideoController.b(this.a.jdField_a_of_type_ComTencentAvVideoController.a);
            }
            paramContext = paramIntent.getStringExtra("account");
          } while (paramContext == null);
          this.a.a(paramContext);
          return;
        } while (!"tencent.video.q2v.membersChange".equals(paramIntent.getAction()));
        l = paramIntent.getIntExtra("GroupId", -1);
        if (l != -1L) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e(VideoAppInterface.jdField_a_of_type_JavaLangString, 2, "can not get the right value");
      return;
      bool = paramIntent.getBooleanExtra("Exit", false);
      this.a.a(new Object[] { Integer.valueOf(79), Long.valueOf(l), Boolean.valueOf(bool) });
    } while (!bool);
    this.a.jdField_a_of_type_ComTencentAvVideoController.e(l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bgy
 * JD-Core Version:    0.7.0.1
 */