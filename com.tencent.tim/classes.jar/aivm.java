import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;

class aivm
  extends BroadcastReceiver
{
  aivm(aivl paramaivl) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    while ((paramIntent.getIntExtra("pid", Process.myPid()) != Process.myPid()) || (aivl.a(this.b) == null)) {
      return;
    }
    aivl.a(this.b).onThemeChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aivm
 * JD-Core Version:    0.7.0.1
 */