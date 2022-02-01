import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Context;
import android.os.Build.VERSION;

public final class jpr
{
  @TargetApi(11)
  public static void aD(Context paramContext, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramContext = (android.content.ClipboardManager)paramContext.getSystemService("clipboard");
      paramString = ClipData.newPlainText(null, paramString);
      alkw.a(paramContext, paramString);
      paramContext.setPrimaryClip(paramString);
      return;
    }
    ((android.text.ClipboardManager)paramContext.getSystemService("clipboard")).setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jpr
 * JD-Core Version:    0.7.0.1
 */