import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class aicl
  extends BroadcastReceiver
{
  aicl(aicj paramaicj) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("command_type", 0);
    QLog.i("GroupVideoManager|Communicate", 2, "get message from plugin: " + paramIntent.getExtras());
    switch (i)
    {
    case 4: 
    default: 
      return;
    case 1: 
      aicj.a(this.a, paramIntent, aicj.a(this.a));
      return;
    case 2: 
      aicj.a(this.a, paramIntent, aicj.b(this.a));
      return;
    case 3: 
      aicj.a(this.a, paramIntent);
      return;
    }
    aicj.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aicl
 * JD-Core Version:    0.7.0.1
 */