package com.tencent.biz.pubaccount.share.watchword.mvp;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import nyw;
import nyw.a;
import nyy.a;
import nyy.b;
import nze;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "watchWord", "", "jumpUrl", "isOpen", "", "invoke"}, k=3, mv={1, 1, 16})
public final class RIJWriteWatchWordPresenter$fetchTopicWatchWord$1
  extends Lambda
  implements Function3<String, String, Boolean, Unit>
{
  public RIJWriteWatchWordPresenter$fetchTopicWatchWord$1(nze paramnze, String paramString1, String paramString2)
  {
    super(3);
  }
  
  public final void invoke(@Nullable String paramString1, @NotNull String paramString2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString2, "jumpUrl");
    int i;
    Object localObject;
    if (paramString1 != null) {
      if (((CharSequence)paramString1).length() > 0)
      {
        i = 1;
        if (i != 1) {
          break label125;
        }
        localObject = nze.a(this.this$0);
        if (localObject != null) {
          ((nyy.b)localObject).showSuccessToast(nze.a(this.this$0).kY());
        }
        nyy.a locala = nze.a(this.this$0);
        localObject = this.$title;
        if (localObject == null) {
          break label118;
        }
        label84:
        locala.a(paramString1, paramString2, (String)localObject, paramBoolean, 2);
        nyw.a.a().bR(paramString1, this.$url);
      }
    }
    label118:
    label125:
    do
    {
      return;
      i = 0;
      break;
      localObject = "";
      break label84;
      paramString1 = nze.a(this.this$0);
    } while (paramString1 == null);
    paramString1.showFailedToast(nze.a(this.this$0).kZ());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.share.watchword.mvp.RIJWriteWatchWordPresenter.fetchTopicWatchWord.1
 * JD-Core Version:    0.7.0.1
 */