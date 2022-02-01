import android.app.PendingIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/notification/modularize/business/DefaultJumpScheme;", "Lcom/tencent/mobileqq/notification/modularize/BaseJumpScheme;", "()V", "customJumpIntent", "Landroid/app/PendingIntent;", "pushComponent", "Lcom/tencent/mobileqq/notification/modularize/PushComponent;", "needCustomJump", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class aklf
  extends akky
{
  @NotNull
  protected PendingIntent a(@NotNull aklc paramaklc)
  {
    Intrinsics.checkParameterIsNotNull(paramaklc, "pushComponent");
    return e(paramaklc);
  }
  
  protected boolean arV()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aklf
 * JD-Core Version:    0.7.0.1
 */