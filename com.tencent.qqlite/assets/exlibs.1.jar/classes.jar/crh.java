import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Handler;
import com.dataline.mpfile.MpfileDataCenter;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import wifiphoto.WifiPhotoDataCenter;
import wifiphoto.WifiPhotoStatusMgr;

public class crh
  extends BroadcastReceiver
{
  public crh(DataLineHandler paramDataLineHandler, QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      if (paramContext != null)
      {
        if ((!paramContext.equals("com.tencent.mobileqq.intent.logout")) && (!paramContext.equals("mqql.intent.action.ACCOUNT_CHANGED")) && (!paramContext.equals("mqql.intent.action.ACCOUNT_KICKED")) && (!paramContext.equals("mqql.intent.action.FORCE_LOGOUT")) && (!paramContext.equals("mqql.intent.action.EXIT_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getPackageName())) && (!paramContext.equals("mqql.intent.action.FORCE_LOGOUT"))) {
          break label163;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DataLineHandler", 2, "--->>logout cancel all task");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.d(32);
        if (DataLineHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler) != null)
        {
          DataLineHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler).a();
          DataLineHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler, null);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.b(false);
        DataLineHandler.a.a.d();
      }
    }
    label163:
    label320:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!paramContext.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
              break label320;
            }
            paramContext = (NetworkInfo)paramIntent.getParcelableExtra("networkInfo");
            if ((paramContext == null) || (paramContext.getState() != NetworkInfo.State.DISCONNECTED) || (paramContext.getType() != 1)) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("DataLineHandler", 2, "--->>wifi lost cancel all task");
            }
            this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.d(8);
          } while (!DataLineHandler.a.a.a());
          this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.b(false);
          DataLineHandler.a.a.d();
          this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.k();
          return;
        } while ((paramContext == null) || (paramContext.getState() != NetworkInfo.State.CONNECTED) || (paramContext.getType() != 1) || (!DataLineHandler.a.a.a()));
        if (QLog.isColorLevel()) {
          QLog.d("wifiphoto", 2, "wifi status change and ask if need open wifiphoto");
        }
        DataLineHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler);
        return;
      } while ((!paramContext.equals("com.tencent.dataline.wifiphoto.ACTION_WIFIPHOTO_CONNECTED")) || (!DataLineHandler.a.a.a()));
      paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
    } while (paramContext == null);
    paramIntent = paramContext.obtainMessage(1134021);
    paramIntent.arg1 = 2;
    paramContext.sendMessage(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     crh
 * JD-Core Version:    0.7.0.1
 */