import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.barrage.BarrageInfo;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.barrage.BarrageItemView;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageFactory;", "", "()V", "createBarrageItemView", "Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageItemView;", "context", "Landroid/content/Context;", "barrageParam", "Lcom/tencent/biz/pubaccount/readinjoy/viola/videonew/barrage/BarrageInfo;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ubd
{
  public static final ubd a = new ubd();
  
  @NotNull
  public final BarrageItemView a(@NotNull Context paramContext, @NotNull BarrageInfo paramBarrageInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramBarrageInfo, "barrageParam");
    paramBarrageInfo = new BarrageItemView(paramContext, null, 0, 6, null);
    paramBarrageInfo.setX(DisplayUtil.getWindowScreenWidth(paramContext));
    paramBarrageInfo.setY(0.0F);
    return paramBarrageInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ubd
 * JD-Core Version:    0.7.0.1
 */