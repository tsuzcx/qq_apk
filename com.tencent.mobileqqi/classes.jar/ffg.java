import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.sharealbum.QZoneShareAlbumAssistantManager;
import com.tencent.qphone.base.util.QLog;

public class ffg
  extends BroadcastReceiver
{
  public ffg(QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("com.tencent.qzone.clean_sharealbum"))
    {
      paramIntent = paramIntent.getExtras();
      int i = -1;
      if (paramIntent != null) {
        i = paramIntent.getInt("para_sharealbum_operation_type");
      }
      switch (i)
      {
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
                      return;
                      QZoneShareAlbumAssistantManager.a().h(this.a);
                      return;
                    } while (paramIntent == null);
                    paramContext = paramIntent.getString("albumid");
                  } while (TextUtils.isEmpty(paramContext));
                  QZoneShareAlbumAssistantManager.a().a(paramContext, this.a);
                } while (!QLog.isColorLevel());
                QLog.d(QQAppInterface.b, 2, "sharealbum exitAlbum:" + paramContext);
                return;
              } while (paramIntent == null);
              paramContext = paramIntent.getString("albumid");
            } while (TextUtils.isEmpty(paramContext));
            QZoneShareAlbumAssistantManager.a().a(paramContext);
          } while (!QLog.isColorLevel());
          QLog.d(QQAppInterface.b, 2, "sharealbum clearShareAlbum:" + paramContext);
          return;
        } while (paramIntent == null);
        paramContext = paramIntent.getString("albumid");
        paramIntent = paramIntent.getString("albumname");
      } while ((TextUtils.isEmpty(paramContext)) || (TextUtils.isEmpty(paramIntent)));
      QZoneShareAlbumAssistantManager.a().a(paramContext, paramIntent);
    } while (!QLog.isColorLevel());
    QLog.d(QQAppInterface.b, 2, "sharealbum changeName:" + paramContext + " name:" + paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ffg
 * JD-Core Version:    0.7.0.1
 */