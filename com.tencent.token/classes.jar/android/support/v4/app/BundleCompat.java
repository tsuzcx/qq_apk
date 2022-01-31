package android.support.v4.app;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public final class BundleCompat
{
  @Nullable
  public static IBinder getBinder(@NonNull Bundle paramBundle, @Nullable String paramString)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return paramBundle.getBinder(paramString);
    }
    return BundleCompat.BundleCompatBaseImpl.getBinder(paramBundle, paramString);
  }
  
  public static void putBinder(@NonNull Bundle paramBundle, @Nullable String paramString, @Nullable IBinder paramIBinder)
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      paramBundle.putBinder(paramString, paramIBinder);
      return;
    }
    BundleCompat.BundleCompatBaseImpl.putBinder(paramBundle, paramString, paramIBinder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.BundleCompat
 * JD-Core Version:    0.7.0.1
 */