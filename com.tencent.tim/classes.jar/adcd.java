import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

class adcd
  extends BroadcastReceiver
{
  adcd(adcc paramadcc) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getAction() == null)) {}
    do
    {
      int i;
      int j;
      do
      {
        do
        {
          return;
        } while ((!"tencent.businessnotify.qq.to.subprocess".equals(paramIntent.getAction())) || (paramIntent.getIntExtra("bussinessType", 0) != 2));
        switch (paramIntent.getIntExtra("event", 0))
        {
        default: 
          return;
        case 1: 
          paramContext = paramIntent.getStringExtra("bussinessSubName");
          i = paramIntent.getIntExtra("download_Index", 0);
          j = paramIntent.getIntExtra("download_Progress", 0);
          if (AudioHelper.aCz()) {
            QLog.w(this.b.TAG, 1, "receive notify, index[" + i + "], progress[" + j + "]");
          }
          break;
        }
      } while (this.b.a == null);
      this.b.a.ai(paramContext, i, j);
      return;
      paramContext = paramIntent.getStringExtra("config_Content");
      this.b.Gq(paramContext);
    } while (this.b.a == null);
    this.b.a.cPV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adcd
 * JD-Core Version:    0.7.0.1
 */