import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.net.Uri;
import com.tencent.qphone.base.util.QLog;

final class ahbg
  implements MediaScannerConnection.OnScanCompletedListener
{
  public void onScanCompleted(String paramString, Uri paramUri)
  {
    if (QLog.isDebugVersion()) {
      QLog.i("FilePathUtil<FileAssistant>", 1, "MediaScannerConnection Scanned:\n" + paramString + ":\nuri=" + paramUri);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahbg
 * JD-Core Version:    0.7.0.1
 */