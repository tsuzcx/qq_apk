import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/notification/modularize/business/NativeUiJumpScheme;", "Lcom/tencent/mobileqq/notification/modularize/BaseJumpScheme;", "()V", "customJumpIntent", "Landroid/app/PendingIntent;", "pushComponent", "Lcom/tencent/mobileqq/notification/modularize/PushComponent;", "nativeUiIntent", "needCustomJump", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class akli
  extends akky
{
  @NotNull
  protected PendingIntent a(@NotNull aklc paramaklc)
  {
    Intrinsics.checkParameterIsNotNull(paramaklc, "pushComponent");
    return f(paramaklc);
  }
  
  protected boolean arV()
  {
    return true;
  }
  
  @NotNull
  public final PendingIntent f(@NotNull aklc paramaklc)
  {
    Intrinsics.checkParameterIsNotNull(paramaklc, "pushComponent");
    BaseApplication localBaseApplication = BaseApplication.context;
    Intent localIntent = new Intent((Context)localBaseApplication, NotifyPushSettingActivity.class);
    localIntent.addFlags(268435456);
    paramaklc = PendingIntent.getActivity((Context)localBaseApplication, paramaklc.dny, localIntent, 134217728);
    Intrinsics.checkExpressionValueIsNotNull(paramaklc, "PendingIntent.getActivit…tent.FLAG_UPDATE_CURRENT)");
    return paramaklc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akli
 * JD-Core Version:    0.7.0.1
 */