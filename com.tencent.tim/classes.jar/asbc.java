import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.webkit.MimeTypeMap;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import java.io.File;

public final class asbc
{
  public static Intent a(Context paramContext, File paramFile)
  {
    if ((paramContext == null) || (paramFile == null) || (!paramFile.isFile())) {
      return null;
    }
    String str = paramFile.getName().toLowerCase().trim();
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addFlags(268435456);
    if (f(str, paramContext.getResources().getStringArray(2130968629))) {
      localIntent.setDataAndType(Uri.fromFile(paramFile), "image/*");
    }
    for (;;)
    {
      FileProvider7Helper.intentCompatForN(paramContext, localIntent);
      return localIntent;
      if (f(str, paramContext.getResources().getStringArray(2130968635)))
      {
        localIntent.setDataAndType(Uri.parse(paramFile.toString()).buildUpon().encodedAuthority("com.android.htmlfileprovider").scheme("content").encodedPath(paramFile.toString()).build(), "text/html");
      }
      else if (f(str, paramContext.getResources().getStringArray(2130968626)))
      {
        localIntent.addFlags(67108864);
        localIntent.putExtra("oneshot", 0);
        localIntent.putExtra("configchange", 0);
        localIntent.setDataAndType(Uri.fromFile(paramFile), "audio/*");
      }
      else if (f(str, paramContext.getResources().getStringArray(2130968634)))
      {
        localIntent.addFlags(67108864);
        localIntent.putExtra("oneshot", 0);
        localIntent.putExtra("configchange", 0);
        localIntent.setDataAndType(Uri.fromFile(paramFile), "video/*");
      }
      else if (f(str, paramContext.getResources().getStringArray(2130968633)))
      {
        localIntent.setDataAndType(Uri.fromFile(paramFile), "text/plain");
      }
      else if (f(str, paramContext.getResources().getStringArray(2130968632)))
      {
        localIntent.setDataAndType(Uri.fromFile(paramFile), "application/pdf");
      }
      else if (f(str, paramContext.getResources().getStringArray(2130968636)))
      {
        localIntent.setDataAndType(Uri.fromFile(paramFile), "application/msword");
      }
      else if (f(str, paramContext.getResources().getStringArray(2130968628)))
      {
        localIntent.setDataAndType(Uri.fromFile(paramFile), "application/vnd.ms-excel");
      }
      else if (f(str, paramContext.getResources().getStringArray(2130968630)))
      {
        localIntent.setDataAndType(Uri.fromFile(paramFile), "application/vnd.ms-powerpoint");
      }
      else if (f(str, paramContext.getResources().getStringArray(2130968627)))
      {
        localIntent.setDataAndType(Uri.fromFile(paramFile), "application/x-chm");
      }
      else
      {
        str = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str.substring(str.lastIndexOf(".") + 1).toLowerCase().trim());
        localIntent.setDataAndType(Uri.fromFile(paramFile), str);
      }
    }
  }
  
  public static boolean f(String paramString, String[] paramArrayOfString)
  {
    boolean bool2 = false;
    int j = paramArrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramString.endsWith(paramArrayOfString[i])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asbc
 * JD-Core Version:    0.7.0.1
 */