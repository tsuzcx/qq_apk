import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.qphone.base.util.QLog;

public class fud
  extends BroadcastReceiver
{
  public fud(FileManagerDataCenter paramFileManagerDataCenter) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ((paramContext != null) && (paramContext.equalsIgnoreCase("com.opensdk.downloadmanager.renameFilename")))
    {
      localBundle = paramIntent.getBundleExtra("extraBundle");
      if (localBundle != null) {
        break label46;
      }
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerDataCenter<FileAssistant>", 2, "INTENT_ACTION_RENAME_FILENAME extra is null!!!");
      }
    }
    return;
    label46:
    paramContext = localBundle.getString("peerUin");
    int i = localBundle.getInt("peerType");
    paramIntent = localBundle.getString("sourceStr");
    String str = localBundle.getString("filePath");
    long l = localBundle.getLong("dataLength");
    int j = localBundle.getInt("fileSourceId");
    Bundle localBundle = localBundle.getBundle("otherData");
    this.a.a(paramContext, i, str, l, j, paramIntent, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fud
 * JD-Core Version:    0.7.0.1
 */