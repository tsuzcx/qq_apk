import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class anle
  extends BroadcastReceiver
{
  anle(anld paramanld) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction() == null) {}
    do
    {
      do
      {
        return;
        paramContext = this.b.maxAvailableSizePath;
        this.b.getAllSDCardInfo();
      } while ((this.b.a == null) || (paramContext.equals(this.b.maxAvailableSizePath)));
      if (paramIntent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED"))
      {
        this.b.ahJ();
        this.b.a.H(0, this.b.maxAvailableSizePath);
        return;
      }
    } while (!paramIntent.getAction().equals("android.intent.action.MEDIA_MOUNTED"));
    this.b.a.H(1, this.b.maxAvailableSizePath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anle
 * JD-Core Version:    0.7.0.1
 */