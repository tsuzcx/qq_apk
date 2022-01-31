import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.dataline.mpfile.LiteMpFileUploadActivity;
import com.dataline.mpfile.MpFileConstant;

public class cz
  extends BroadcastReceiver
{
  public cz(LiteMpFileUploadActivity paramLiteMpFileUploadActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      if ((paramContext == null) || (!paramContext.equals(MpFileConstant.d))) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cz
 * JD-Core Version:    0.7.0.1
 */