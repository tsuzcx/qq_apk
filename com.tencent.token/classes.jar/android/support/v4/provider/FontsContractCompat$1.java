package android.support.v4.provider;

import android.content.Context;
import android.support.v4.util.LruCache;
import java.util.concurrent.Callable;

final class FontsContractCompat$1
  implements Callable
{
  FontsContractCompat$1(Context paramContext, FontRequest paramFontRequest, int paramInt, String paramString) {}
  
  public FontsContractCompat.TypefaceResult call()
  {
    FontsContractCompat.TypefaceResult localTypefaceResult = FontsContractCompat.access$000(this.val$context, this.val$request, this.val$style);
    if (localTypefaceResult.mTypeface != null) {
      FontsContractCompat.access$100().put(this.val$id, localTypefaceResult.mTypeface);
    }
    return localTypefaceResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.provider.FontsContractCompat.1
 * JD-Core Version:    0.7.0.1
 */