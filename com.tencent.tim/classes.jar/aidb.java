import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class aidb
  extends BroadcastReceiver
{
  aidb(aida paramaida) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    int j = paramIntent.getIntExtra("key_state", -1);
    if (aida.a(this.this$0)) {
      aida.a(this.this$0, j);
    }
    if (paramContext.equals(aidi.lu(aida.a(this.this$0))))
    {
      paramContext = (aidc)aida.a(this.this$0).get();
      if (paramContext != null) {
        paramContext.I(j, paramIntent.getExtras());
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GroupVideoManager.IVPluginLoader", 2, "state:" + j);
        }
        paramContext = aida.lE;
        int k = paramContext.length;
        int i = 0;
        while (i < k)
        {
          if ((j == paramContext[i]) && (aida.b(this.this$0)))
          {
            aida.o().unregisterReceiver(this.this$0.bl);
            aida.a(this.this$0, false);
          }
          i += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.e("GroupVideoManager.IVPluginLoader", 2, "loadListener null");
        }
      }
      if ((aida.c(this.this$0)) && (j == 4))
      {
        aida.o().unregisterReceiver(this.this$0.bl);
        aida.a(this.this$0, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aidb
 * JD-Core Version:    0.7.0.1
 */