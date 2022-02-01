package androidx.core.provider;

import android.content.Context;
import androidx.collection.LruCache;
import java.util.concurrent.Callable;

final class FontsContractCompat$1
  implements Callable<FontsContractCompat.TypefaceResult>
{
  FontsContractCompat$1(Context paramContext, FontRequest paramFontRequest, int paramInt, String paramString) {}
  
  public FontsContractCompat.TypefaceResult call()
    throws Exception
  {
    FontsContractCompat.TypefaceResult localTypefaceResult = FontsContractCompat.getFontInternal(this.val$context, this.val$request, this.val$style);
    if (localTypefaceResult.mTypeface != null) {
      FontsContractCompat.sTypefaceCache.put(this.val$id, localTypefaceResult.mTypeface);
    }
    return localTypefaceResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.core.provider.FontsContractCompat.1
 * JD-Core Version:    0.7.0.1
 */