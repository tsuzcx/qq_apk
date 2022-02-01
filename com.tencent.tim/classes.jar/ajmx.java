import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class ajmx
  extends BroadcastReceiver
{
  ajmx(ajmu paramajmu) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("BROAD_CAST_CALL_PAGE_SHARE".equals(paramIntent.getAction()))) {
      ajmu.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajmx
 * JD-Core Version:    0.7.0.1
 */