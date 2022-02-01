import com.tencent.biz.pubaccount.readinjoy.viola.videonew.barrage.BarrageItemView;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.barrage.BarrageItemView.BarrageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageItemView$Companion;", "", "()V", "BARRAGE_HEIGHT", "", "getBARRAGE_HEIGHT", "()I", "EMOTICON_TEXT_SIZE", "MAX_TEXT_LIMIT", "NEXT_LINE_LIMIT", "PADDING_LEFT_RIGHT", "getPADDING_LEFT_RIGHT", "getBarrageType", "Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageItemView$BarrageType;", "text", "", "getShowText", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class tnv
{
  public final int a()
  {
    return BarrageItemView.b();
  }
  
  @NotNull
  public final BarrageItemView.BarrageType a(@Nullable String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() <= 16) {
        return BarrageItemView.BarrageType.SHORT;
      }
      if (paramString.length() <= 25) {
        return BarrageItemView.BarrageType.LONG;
      }
      return BarrageItemView.BarrageType.DOUBLE_LINE;
    }
    return BarrageItemView.BarrageType.SHORT;
  }
  
  @NotNull
  public final String a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "text");
    paramString = new StringBuilder(paramString);
    if (paramString.length() >= 33)
    {
      paramString.delete(33, paramString.length());
      paramString.replace(31, 34, "...");
    }
    if (paramString.length() >= 16) {
      paramString.insert(16, '\n');
    }
    paramString = paramString.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "stringBuilder.toString()");
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tnv
 * JD-Core Version:    0.7.0.1
 */