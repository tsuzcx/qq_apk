import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qmethodmonitor.monitor.QMContactsMonitor.1;

public class alld
{
  @NonNull
  private static StringBuilder a(Uri paramUri, String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("query:").append(paramUri.getQuery()).append(".path:").append(paramUri.getPath()).append("\nURI-String:").append(paramUri.toString()).append("\n");
    if ((paramArrayOfString != null) && (paramArrayOfString.length != 0))
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(paramArrayOfString[i]).append(",");
        i += 1;
      }
    }
    return localStringBuilder;
  }
  
  private static void a(String paramString1, Throwable paramThrowable, Uri paramUri, String[] paramArrayOfString, String paramString2)
  {
    ThreadManagerV2.excute(new QMContactsMonitor.1(paramString1, paramUri, paramArrayOfString, paramString2, paramThrowable), 16, null, false);
  }
  
  public static Cursor query(ContentResolver paramContentResolver, @NonNull Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    a(paramUri.toString(), new Throwable(), paramUri, paramArrayOfString1, "query(U[SS[SS) ");
    return paramContentResolver.query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alld
 * JD-Core Version:    0.7.0.1
 */