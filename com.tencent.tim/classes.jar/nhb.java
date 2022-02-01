import android.net.Uri;
import com.tencent.qphone.base.util.QLog;

final class nhb
  implements oea.a
{
  public void a(Uri paramUri, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder().append("onDetectScreenshot() path=").append(paramString).append(", channelID=");
      if (nha.a(nha.a()) != null) {
        break label129;
      }
      paramUri = "null";
      paramString = paramString.append(paramUri).append(", channelType=");
      if (nha.b(nha.a()) != null) {
        break label139;
      }
    }
    label129:
    label139:
    for (paramUri = "null";; paramUri = nha.b(nha.a()))
    {
      QLog.d("ReadInJoyScreenShotReporter", 2, paramUri);
      if (nha.a(nha.a()) != null) {
        kbp.b(null, "", "0X8008100", "0X8008100", 0, 0, String.valueOf(System.currentTimeMillis() / 1000L), String.valueOf(nha.b(nha.a())), String.valueOf(nha.a(nha.a())), null, false);
      }
      return;
      paramUri = nha.a(nha.a());
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nhb
 * JD-Core Version:    0.7.0.1
 */