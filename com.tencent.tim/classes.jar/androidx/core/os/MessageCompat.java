package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Message;
import androidx.annotation.NonNull;

public final class MessageCompat
{
  private static boolean sTryIsAsynchronous = true;
  private static boolean sTrySetAsynchronous = true;
  
  @SuppressLint({"NewApi"})
  public static boolean isAsynchronous(@NonNull Message paramMessage)
  {
    boolean bool2 = false;
    boolean bool1;
    if (Build.VERSION.SDK_INT >= 22) {
      bool1 = paramMessage.isAsynchronous();
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!sTryIsAsynchronous);
      bool1 = bool2;
    } while (Build.VERSION.SDK_INT < 16);
    try
    {
      bool1 = paramMessage.isAsynchronous();
      return bool1;
    }
    catch (NoSuchMethodError paramMessage)
    {
      sTryIsAsynchronous = false;
    }
    return false;
  }
  
  @SuppressLint({"NewApi"})
  public static void setAsynchronous(@NonNull Message paramMessage, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 22) {
      paramMessage.setAsynchronous(paramBoolean);
    }
    while ((!sTrySetAsynchronous) || (Build.VERSION.SDK_INT < 16)) {
      return;
    }
    try
    {
      paramMessage.setAsynchronous(paramBoolean);
      return;
    }
    catch (NoSuchMethodError paramMessage)
    {
      sTrySetAsynchronous = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.core.os.MessageCompat
 * JD-Core Version:    0.7.0.1
 */