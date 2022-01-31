package android.support.v4.content.res;

import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;

public abstract class ResourcesCompat$FontCallback
{
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public final void callbackFailAsync(int paramInt, @Nullable Handler paramHandler)
  {
    Handler localHandler = paramHandler;
    if (paramHandler == null) {
      localHandler = new Handler(Looper.getMainLooper());
    }
    localHandler.post(new ResourcesCompat.FontCallback.2(this, paramInt));
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public final void callbackSuccessAsync(Typeface paramTypeface, @Nullable Handler paramHandler)
  {
    Handler localHandler = paramHandler;
    if (paramHandler == null) {
      localHandler = new Handler(Looper.getMainLooper());
    }
    localHandler.post(new ResourcesCompat.FontCallback.1(this, paramTypeface));
  }
  
  public abstract void onFontRetrievalFailed(int paramInt);
  
  public abstract void onFontRetrieved(@NonNull Typeface paramTypeface);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.content.res.ResourcesCompat.FontCallback
 * JD-Core Version:    0.7.0.1
 */