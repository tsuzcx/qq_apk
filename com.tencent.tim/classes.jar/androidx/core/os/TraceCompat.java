package androidx.core.os;

import android.os.Build.VERSION;
import android.os.Trace;
import androidx.annotation.NonNull;

public final class TraceCompat
{
  public static void beginSection(@NonNull String paramString)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      Trace.beginSection(paramString);
    }
  }
  
  public static void endSection()
  {
    if (Build.VERSION.SDK_INT >= 18) {
      Trace.endSection();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.core.os.TraceCompat
 * JD-Core Version:    0.7.0.1
 */