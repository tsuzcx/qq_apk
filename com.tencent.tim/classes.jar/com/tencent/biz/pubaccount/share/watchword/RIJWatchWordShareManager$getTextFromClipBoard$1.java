package com.tencent.biz.pubaccount.share.watchword;

import alkw;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import com.tencent.TMG.utils.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"getText", "", "invoke"}, k=3, mv={1, 1, 16})
public final class RIJWatchWordShareManager$getTextFromClipBoard$1
  extends Lambda
  implements Function0<Unit>
{
  RIJWatchWordShareManager$getTextFromClipBoard$1(ClipboardManager paramClipboardManager, Function1 paramFunction1)
  {
    super(0);
  }
  
  public final void invoke()
  {
    Object localObject2 = null;
    if (this.$clipboardManager != null)
    {
      Object localObject1 = this.$clipboardManager;
      alkw.a((ClipboardManager)localObject1);
      localObject1 = ((ClipboardManager)localObject1).getPrimaryClipDescription();
      Object localObject3;
      if (localObject1 != null)
      {
        localObject1 = ((ClipDescription)localObject1).getLabel();
        if (localObject1 != null)
        {
          localObject1 = localObject1.toString();
          localObject3 = this.$clipboardManager;
          alkw.a((ClipboardManager)localObject3);
          localObject3 = ((ClipboardManager)localObject3).getPrimaryClip();
          if (localObject3 == null) {
            break label232;
          }
          i = ((ClipData)localObject3).getItemCount();
          label72:
          if ((i <= 0) || (!(Intrinsics.areEqual(localObject1, "RIJShareClip") ^ true))) {
            break label263;
          }
          localObject1 = this.$clipboardManager;
          alkw.a((ClipboardManager)localObject1);
          localObject1 = ((ClipboardManager)localObject1).getPrimaryClip();
          if (localObject1 == null) {
            break label242;
          }
          localObject1 = ((ClipData)localObject1).getItemAt(0);
          if (localObject1 == null) {
            break label242;
          }
          localObject1 = ((ClipData.Item)localObject1).getText();
          if (localObject1 == null) {
            break label242;
          }
          if (((CharSequence)localObject1).length() <= 0) {
            break label237;
          }
        }
      }
      label232:
      label237:
      for (int i = 1;; i = 0)
      {
        if (i != 1) {
          break label242;
        }
        localObject1 = this.$clipboardManager;
        alkw.a((ClipboardManager)localObject1);
        localObject3 = ((ClipboardManager)localObject1).getPrimaryClip();
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject3 = ((ClipData)localObject3).getItemAt(0);
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = ((ClipData.Item)localObject3).getText();
          }
        }
        localObject1 = String.valueOf(localObject1);
        QLog.i("RIJWatchWordShareManager", 1, "getTextFromClipBoard text: " + (String)localObject1);
        this.$callback.invoke(localObject1);
        return;
        localObject1 = null;
        break;
        i = 0;
        break label72;
      }
      label242:
      QLog.i("RIJWatchWordShareManager", 1, "getTextFromClipBoard text: ");
      this.$callback.invoke("");
      return;
      label263:
      QLog.i("RIJWatchWordShareManager", 1, "getTextFromClipBoard count <= 0 or tag == CLIP_TAG");
      this.$callback.invoke("");
      return;
    }
    QLog.i("RIJWatchWordShareManager", 1, "getTextFromClipBoard clipboardManager is null");
    this.$callback.invoke("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.share.watchword.RIJWatchWordShareManager.getTextFromClipBoard.1
 * JD-Core Version:    0.7.0.1
 */