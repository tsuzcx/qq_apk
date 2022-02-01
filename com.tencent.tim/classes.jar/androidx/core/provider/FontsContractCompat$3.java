package androidx.core.provider;

import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

final class FontsContractCompat$3
  implements SelfDestructiveThread.ReplyCallback<FontsContractCompat.TypefaceResult>
{
  FontsContractCompat$3(String paramString) {}
  
  public void onReply(FontsContractCompat.TypefaceResult paramTypefaceResult)
  {
    synchronized (FontsContractCompat.sLock)
    {
      ArrayList localArrayList = (ArrayList)FontsContractCompat.sPendingReplies.get(this.val$id);
      if (localArrayList == null) {
        return;
      }
      FontsContractCompat.sPendingReplies.remove(this.val$id);
      int i = 0;
      if (i < localArrayList.size())
      {
        ((SelfDestructiveThread.ReplyCallback)localArrayList.get(i)).onReply(paramTypefaceResult);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.core.provider.FontsContractCompat.3
 * JD-Core Version:    0.7.0.1
 */