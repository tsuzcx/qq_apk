import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.tim.filemanager.core.FileManagerDataCenter.2;

public class atth
  extends BroadcastReceiver
{
  public atth(FileManagerDataCenter.2 param2) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ((paramContext != null) && (paramContext.equalsIgnoreCase("com.opensdk.downloadmanager.renameFilename")))
    {
      paramContext = paramIntent.getBundleExtra("extraBundle");
      attf.a(this.a.this$0, paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atth
 * JD-Core Version:    0.7.0.1
 */