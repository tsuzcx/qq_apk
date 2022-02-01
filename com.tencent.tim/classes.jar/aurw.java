import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.av.ui.AVActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.multiaio.MultiAIOFragment;
import com.tencent.mobileqq.richmediabrowser.AIOGalleryActivity;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/util/notification/ForegroundNotifyManager;", "Lmqq/manager/Manager;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "(Lcom/tencent/mobileqq/app/QQAppInterface;)V", "onCheckedChangeListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "functionOpen", "", "uinType", "", "isAio", "isFullScreenMode", "isMiniAio", "isMultiAioMode", "isShieldActivity", "isShieldUi", "isSplashActivity", "newOnCheckedChangedListener", "onDestroy", "", "supportedUinType", "type", "switchEnabled", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class aurw
  implements Manager
{
  public static final aurw.a a = new aurw.a(null);
  private CompoundButton.OnCheckedChangeListener H;
  private final QQAppInterface app;
  
  public aurw(@NotNull QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  public final boolean aJD()
  {
    return SettingCloneUtil.readValue((Context)this.app.getApp(), this.app.getCurrentUin(), null, "top_msg_notification_key", true);
  }
  
  public final boolean aJE()
  {
    return (aJF()) || (aJI()) || (isFullScreenMode()) || (aJH()) || (aJJ()) || (aJG());
  }
  
  public final boolean aJF()
  {
    if ((BaseActivity.sTopActivity instanceof SplashActivity))
    {
      Object localObject = BaseActivity.sTopActivity;
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.activity.SplashActivity");
      }
      localObject = (SplashActivity)localObject;
      int i = MainFragment.bIk;
      int j = MainFragment.bIm;
      int k = MainFragment.bIq;
      int m = MainFragment.bIn;
      int n = ((SplashActivity)localObject).getCurrentTab();
      return ArraysKt.contains(new Integer[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) }, Integer.valueOf(n));
    }
    return false;
  }
  
  public final boolean aJG()
  {
    return (znx.a().Vx()) || (MiniChatActivity.Vw());
  }
  
  public final boolean aJH()
  {
    if ((BaseActivity.sTopActivity instanceof PublicFragmentActivity))
    {
      BaseActivity localBaseActivity = BaseActivity.sTopActivity;
      if (localBaseActivity == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.activity.PublicFragmentActivity");
      }
      return ((PublicFragmentActivity)localBaseActivity).b() instanceof MultiAIOFragment;
    }
    return false;
  }
  
  public final boolean aJI()
  {
    if ((BaseActivity.sTopActivity instanceof SplashActivity))
    {
      int i = SplashActivity.bKT;
      if (ArraysKt.contains(new Integer[] { Integer.valueOf(2) }, Integer.valueOf(i))) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean aJJ()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((localBaseActivity instanceof AVActivity)) {}
    while (((localBaseActivity instanceof QIMCameraCaptureActivity)) || ((localBaseActivity instanceof AIOGalleryActivity)) || ((localBaseActivity instanceof EditPicActivity))) {
      return true;
    }
    return false;
  }
  
  @NotNull
  public final CompoundButton.OnCheckedChangeListener b()
  {
    this.H = ((CompoundButton.OnCheckedChangeListener)new aurx(this));
    CompoundButton.OnCheckedChangeListener localOnCheckedChangeListener = this.H;
    if (localOnCheckedChangeListener == null) {
      Intrinsics.throwUninitializedPropertyAccessException("onCheckedChangeListener");
    }
    return localOnCheckedChangeListener;
  }
  
  public final boolean isFullScreenMode()
  {
    if ((BaseActivity.sTopActivity instanceof FragmentActivity))
    {
      Object localObject = BaseActivity.sTopActivity;
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
      }
      localObject = ((FragmentActivity)localObject).getSupportFragmentManager().findFragmentByTag(Reflection.getOrCreateKotlinClass(ChatFragment.class).getSimpleName());
      if ((localObject instanceof ChatFragment))
      {
        localObject = ((ChatFragment)localObject).a();
        if (localObject == null) {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.activity.BaseChatPie");
        }
        return ((BaseChatPie)localObject).isFullScreenMode();
      }
    }
    return false;
  }
  
  public final boolean na(int paramInt)
  {
    if ((aJD()) && (nb(paramInt)) && (!aJE())) {}
    return false;
  }
  
  public final boolean nb(int paramInt)
  {
    return ArraysKt.contains(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1009), Integer.valueOf(1001), Integer.valueOf(10002), Integer.valueOf(10004), Integer.valueOf(1003), Integer.valueOf(1004), Integer.valueOf(1005), Integer.valueOf(1020), Integer.valueOf(1000), Integer.valueOf(1023), Integer.valueOf(1024), Integer.valueOf(1025) }, Integer.valueOf(paramInt));
  }
  
  public void onDestroy() {}
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/util/notification/ForegroundNotifyManager$Companion;", "", "()V", "get", "Lcom/tencent/util/notification/ForegroundNotifyManager;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  public static final class a
  {
    @NotNull
    public final aurw a(@NotNull QQAppInterface paramQQAppInterface)
    {
      Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
      paramQQAppInterface = paramQQAppInterface.getManager(371);
      if (paramQQAppInterface == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.util.notification.ForegroundNotifyManager");
      }
      return (aurw)paramQQAppInterface;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aurw
 * JD-Core Version:    0.7.0.1
 */