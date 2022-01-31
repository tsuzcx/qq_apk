package android.support.v4.provider;

import android.support.v4.util.SimpleArrayMap;
import java.util.ArrayList;

final class FontsContractCompat$3
  implements SelfDestructiveThread.ReplyCallback
{
  FontsContractCompat$3(String paramString) {}
  
  public void onReply(FontsContractCompat.TypefaceResult paramTypefaceResult)
  {
    synchronized ()
    {
      ArrayList localArrayList = (ArrayList)FontsContractCompat.access$300().get(this.val$id);
      if (localArrayList == null) {
        return;
      }
      FontsContractCompat.access$300().remove(this.val$id);
      int i = 0;
      if (i < localArrayList.size())
      {
        ((SelfDestructiveThread.ReplyCallback)localArrayList.get(i)).onReply(paramTypefaceResult);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.provider.FontsContractCompat.3
 * JD-Core Version:    0.7.0.1
 */