import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class imj
{
  static String TAG = "smartdevice::sharp";
  imi jdField_a_of_type_Imi = null;
  imj.a jdField_a_of_type_Imj$a = null;
  VideoAppInterface mApp = null;
  
  public imj(imi paramimi, VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_Imi = paramimi;
    this.mApp = paramVideoAppInterface;
    this.jdField_a_of_type_Imj$a = new imj.a();
    paramimi = new IntentFilter();
    paramimi.addAction("SmartDevice_ReceiveSharpMsg");
    paramimi.addAction("SmartDevice_ReceiveSharpAckMsg");
    paramimi.addAction("SmartDevice_DeviceUnBindRst");
    this.mApp.getApp().registerReceiver(this.jdField_a_of_type_Imj$a, paramimi, "com.tencent.tim.smartdevice.permission.broadcast", null);
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    c(paramArrayOfByte, paramLong);
  }
  
  void c(byte[] paramArrayOfByte, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "send broadcast : smartdevice send sharp msg");
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("size", paramArrayOfByte.length);
    localBundle.putLong("uin", paramLong);
    localBundle.putByteArray("value", paramArrayOfByte);
    paramArrayOfByte = new Intent();
    paramArrayOfByte.putExtra("msgData", localBundle);
    paramArrayOfByte.setAction("SmartDevice_SendSharpMsg");
    this.mApp.getApp().sendBroadcast(paramArrayOfByte, "com.tencent.tim.smartdevice.permission.broadcast");
  }
  
  class a
    extends BroadcastReceiver
  {
    a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_ReceiveSharpMsg"))
      {
        if (QLog.isColorLevel()) {
          QLog.d(imj.TAG, 2, "recv broadcast : smartdevice receive sharp msg");
        }
        paramContext = paramIntent.getBundleExtra("msgData");
        if (paramContext != null)
        {
          paramContext = paramContext.getByteArray("value");
          if (paramContext != null) {
            imj.this.a.a(0L, paramContext, null);
          }
        }
      }
      label154:
      int i;
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
                  if (!paramIntent.getAction().equalsIgnoreCase("SmartDevice_ReceiveSharpAckMsg")) {
                    break label154;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d(imj.TAG, 2, "recv broadcast : smartdevice receive sharp ack msg");
                  }
                  if (!paramIntent.getBooleanExtra("timeout", false)) {
                    break;
                  }
                } while (!QLog.isColorLevel());
                QLog.d(imj.TAG, 2, "recv broadcast : smartdevice receive sharp timeout msg");
                return;
                paramContext = paramIntent.getBundleExtra("msgData");
              } while (paramContext == null);
              paramContext = paramContext.getByteArray("value");
            } while (paramContext == null);
            imj.this.a.b(0L, paramContext, null);
            return;
          } while (!paramIntent.getAction().equals("SmartDevice_DeviceUnBindRst"));
          paramContext = paramIntent.getExtras();
        } while (paramContext == null);
        i = paramContext.getInt("deviceoprstcode");
        paramContext = Long.valueOf(paramContext.getLong("deviceopdin", 0L));
      } while ((i != 0) || (paramContext.longValue() == 0L) || (imj.this.mApp == null) || (imj.this.mApp.b() == null) || (imj.this.mApp.b().b() == null) || (imj.this.mApp.b().b().peerUin == null) || (!imj.this.mApp.b().b().peerUin.equals(String.valueOf(paramContext))));
      imj.this.mApp.kH(1000);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     imj
 * JD-Core Version:    0.7.0.1
 */