import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class avhe
  extends BroadcastReceiver
{
  avhe(avhc paramavhc) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (("com.tencent.qlink.finishworkingdlg".equalsIgnoreCase(paramIntent.getAction())) && (avhc.a(this.this$0) != null))
    {
      avhc.a(this.this$0).dismiss();
      avhc.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     avhe
 * JD-Core Version:    0.7.0.1
 */