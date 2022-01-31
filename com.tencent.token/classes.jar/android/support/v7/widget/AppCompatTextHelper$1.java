package android.support.v7.widget;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v4.content.res.ResourcesCompat.FontCallback;
import java.lang.ref.WeakReference;

class AppCompatTextHelper$1
  extends ResourcesCompat.FontCallback
{
  AppCompatTextHelper$1(AppCompatTextHelper paramAppCompatTextHelper, WeakReference paramWeakReference) {}
  
  public void onFontRetrievalFailed(int paramInt) {}
  
  public void onFontRetrieved(@NonNull Typeface paramTypeface)
  {
    AppCompatTextHelper.access$000(this.this$0, this.val$textViewWeak, paramTypeface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatTextHelper.1
 * JD-Core Version:    0.7.0.1
 */