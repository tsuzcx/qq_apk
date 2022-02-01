import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"setBackgroundDrawableCompat", "", "Landroid/view/View;", "background", "Landroid/graphics/drawable/Drawable;", "setOnClickListener", "listener", "Lkotlin/Function0;", "AQQLiteApp_release"}, k=2, mv={1, 1, 16})
public final class ajov
{
  public static final void a(@NotNull View paramView, @NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$setOnClickListener");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "listener");
    paramView.setOnClickListener((View.OnClickListener)new ajow(paramFunction0));
  }
  
  public static final void c(@NotNull View paramView, @Nullable Drawable paramDrawable)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$setBackgroundDrawableCompat");
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView.setBackground(paramDrawable);
      return;
    }
    paramView.setBackgroundDrawable(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajov
 * JD-Core Version:    0.7.0.1
 */