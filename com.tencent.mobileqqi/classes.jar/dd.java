import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.dataline.mpfile.LiteMpFileDownloadActivity;

public class dd
  extends BroadcastReceiver
{
  public dd(LiteMpFileDownloadActivity paramLiteMpFileDownloadActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      do
      {
        return;
        paramContext = paramIntent.getAction();
      } while (paramContext == null);
      if (paramContext.equals("com.dataline.mpfile.download_progress"))
      {
        this.a.a();
        return;
      }
    } while (!paramContext.equals("com.dataline.mpfile.download_completed"));
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     dd
 * JD-Core Version:    0.7.0.1
 */