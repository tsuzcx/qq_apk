package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import java.io.InputStream;

public final class RoundedBitmapDrawableFactory
{
  private static final String TAG = "RoundedBitmapDrawableFa";
  
  @NonNull
  public static RoundedBitmapDrawable create(@NonNull Resources paramResources, @Nullable Bitmap paramBitmap)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new RoundedBitmapDrawable21(paramResources, paramBitmap);
    }
    return new RoundedBitmapDrawableFactory.DefaultRoundedBitmapDrawable(paramResources, paramBitmap);
  }
  
  @NonNull
  public static RoundedBitmapDrawable create(@NonNull Resources paramResources, @NonNull InputStream paramInputStream)
  {
    paramResources = create(paramResources, BitmapFactory.decodeStream(paramInputStream));
    if (paramResources.getBitmap() == null) {
      Log.w("RoundedBitmapDrawableFa", "RoundedBitmapDrawable cannot decode " + paramInputStream);
    }
    return paramResources;
  }
  
  @NonNull
  public static RoundedBitmapDrawable create(@NonNull Resources paramResources, @NonNull String paramString)
  {
    paramResources = create(paramResources, BitmapFactory.decodeFile(paramString));
    if (paramResources.getBitmap() == null) {
      Log.w("RoundedBitmapDrawableFa", "RoundedBitmapDrawable cannot decode " + paramString);
    }
    return paramResources;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory
 * JD-Core Version:    0.7.0.1
 */