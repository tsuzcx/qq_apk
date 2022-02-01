import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.tencent.mobileqq.mvvm.LifeCycleFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"LIFE_CYCLE_FRAGMENT_TAG", "", "checkAndAddLifeCycleFragment", "Lcom/tencent/mobileqq/mvvm/LifeCycleFragment;", "Landroid/support/v4/app/FragmentActivity;", "AQQLiteApp_release"}, k=2, mv={1, 1, 16})
public final class ajor
{
  @NotNull
  public static final LifeCycleFragment a(@NotNull FragmentActivity paramFragmentActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramFragmentActivity, "$this$checkAndAddLifeCycleFragment");
    Object localObject = paramFragmentActivity.getSupportFragmentManager().findFragmentByTag("fragment_tag_life_cycle_fragment");
    if ((localObject instanceof LifeCycleFragment)) {
      return (LifeCycleFragment)localObject;
    }
    paramFragmentActivity = paramFragmentActivity.getSupportFragmentManager().beginTransaction();
    if (localObject != null) {
      paramFragmentActivity.remove((Fragment)localObject);
    }
    localObject = new LifeCycleFragment();
    paramFragmentActivity.add((Fragment)localObject, "fragment_tag_life_cycle_fragment");
    paramFragmentActivity.commitAllowingStateLoss();
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajor
 * JD-Core Version:    0.7.0.1
 */