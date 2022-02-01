import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/notification/modularize/BaseJumpScheme;", "", "()V", "customJumpIntent", "Landroid/app/PendingIntent;", "pushComponent", "Lcom/tencent/mobileqq/notification/modularize/PushComponent;", "fallbackJumpIntent", "jumpActionIntent", "jumpIntent", "jumpMsgTabIntent", "needCustomJump", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract class akky
{
  private final PendingIntent d(aklc paramaklc)
  {
    BaseApplication localBaseApplication = BaseApplication.context;
    Intent localIntent = new Intent((Context)localBaseApplication, SplashActivity.class);
    localIntent.putExtra("tab_index", MainFragment.bIk);
    localIntent.putExtra("fragment_id", 1);
    localIntent.setFlags(335544320);
    paramaklc = PendingIntent.getActivity((Context)localBaseApplication, paramaklc.dny, localIntent, 134217728);
    Intrinsics.checkExpressionValueIsNotNull(paramaklc, "jumpPendingIntent");
    return paramaklc;
  }
  
  @NotNull
  protected abstract PendingIntent a(@NotNull aklc paramaklc);
  
  protected boolean arV()
  {
    return false;
  }
  
  @NotNull
  public final PendingIntent b(@NotNull aklc paramaklc)
  {
    Intrinsics.checkParameterIsNotNull(paramaklc, "pushComponent");
    if (arV()) {
      return a(paramaklc);
    }
    return c(paramaklc);
  }
  
  @NotNull
  public final PendingIntent c(@NotNull aklc paramaklc)
  {
    Intrinsics.checkParameterIsNotNull(paramaklc, "pushComponent");
    if (Intrinsics.areEqual(paramaklc.wV, "")) {
      return d(paramaklc);
    }
    BaseApplication localBaseApplication = BaseApplication.context;
    Intent localIntent = new Intent((Context)localBaseApplication, QQBrowserActivity.class);
    localIntent.putExtra("url", paramaklc.wV);
    localIntent.addFlags(268435456);
    akld.a(localIntent, paramaklc);
    localIntent.putExtra("param_notifyid", paramaklc.dny);
    paramaklc = PendingIntent.getActivity((Context)localBaseApplication, paramaklc.dny, localIntent, 134217728);
    Intrinsics.checkExpressionValueIsNotNull(paramaklc, "jumpPendingIntent");
    return paramaklc;
  }
  
  @NotNull
  public final PendingIntent e(@NotNull aklc paramaklc)
  {
    Intrinsics.checkParameterIsNotNull(paramaklc, "pushComponent");
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramaklc.wV));
    localIntent.setFlags(268435456);
    paramaklc = PendingIntent.getActivity((Context)BaseApplication.context, paramaklc.dny, localIntent, 134217728);
    Intrinsics.checkExpressionValueIsNotNull(paramaklc, "PendingIntent.getActivit…tent.FLAG_UPDATE_CURRENT)");
    return paramaklc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akky
 * JD-Core Version:    0.7.0.1
 */