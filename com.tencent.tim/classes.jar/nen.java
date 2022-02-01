import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.List;
import mqq.app.AppRuntime;

public class nen
  implements ngm
{
  private Interpolator interpolator = new AccelerateInterpolator();
  private float kr;
  
  private ImageView a(ListView paramListView)
  {
    if ((paramListView != null) && (paramListView.getOverScrollFooterView() != null)) {
      return (ImageView)paramListView.getOverScrollFooterView().findViewById(2131369832);
    }
    return null;
  }
  
  public static void aQ(Activity paramActivity)
  {
    i(paramActivity, null);
  }
  
  public static String ai(Context paramContext)
  {
    return (String)awit.f("kandian_daily_wrapper_default_text", paramContext.getResources().getString(2131718391));
  }
  
  public static void i(Activity paramActivity, Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    List localList = lbz.a().a(Integer.valueOf(kys.getChannelId()));
    if ((localList != null) && (!localList.isEmpty()))
    {
      KandianMergeManager localKandianMergeManager = (KandianMergeManager)kxm.getAppRuntime().getManager(162);
      KandianMergeManager.a locala = new KandianMergeManager.a();
      locala.rX = ((Long)localList.get(localList.size() - 1)).longValue();
      locala.launchFrom = 13;
      localKandianMergeManager.a(locala);
    }
    paramActivity.finish();
    paramActivity.overridePendingTransition(2130772002, 2130772426);
    localBundle.putString("folder_status", kvs.iL());
    localBundle.putBoolean("force_refresh", true);
    if (paramBundle != null) {
      localBundle.putAll(paramBundle);
    }
    kgw.a((QQAppInterface)kxm.getAppRuntime(), paramActivity, 13, 0, localBundle);
  }
  
  private void l(ListView paramListView)
  {
    paramListView = a(paramListView);
    if (paramListView == null) {
      return;
    }
    paramListView.setPivotX(paramListView.getWidth() / 2);
    paramListView.setPivotY(paramListView.getHeight() / 2);
    paramListView.setRotation(0.0F);
  }
  
  private void m(ListView paramListView)
  {
    if (kge.getMode() == 1)
    {
      aQ((Activity)paramListView.getContext());
      tt(1);
    }
    String str;
    do
    {
      return;
      str = kys.getJumpUrl();
    } while (TextUtils.isEmpty(str));
    kxm.aJ(paramListView.getContext(), str);
    tt(1);
  }
  
  public static void tt(int paramInt)
  {
    kxm.b localb = kxm.a();
    localb.b("jump_src", kys.ja());
    localb.b("entrance", "" + paramInt);
    localb.b("cmd", awit.Hf());
    kbp.a(null, "", "0X8009883", "0X8009883", 0, 0, "", "", "", localb.build(), false);
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    QLog.d("ReadInJoyDailyOverScrollListener", 2, "[onNotCompleteVisable] " + paramInt);
    if (paramInt == 1) {
      l(paramListView);
    }
  }
  
  public void a(int paramInt1, View paramView, ListView paramListView, int paramInt2)
  {
    QLog.d("ReadInJoyDailyOverScrollListener", 2, "[onNotCompleteVisable] " + paramInt1);
    if (paramInt1 == 1) {
      l(paramListView);
    }
  }
  
  public void a(View paramView, ListView paramListView, int paramInt)
  {
    float f1 = paramView.getHeight();
    float f2 = (float)(paramInt * 1.0D / f1);
    f1 = f2;
    if (f2 >= 1.0D) {
      f1 = 1.0F;
    }
    this.kr = f1;
    f1 = this.interpolator.getInterpolation(f1);
    paramView = a(paramListView);
    if (paramView == null) {
      return;
    }
    paramView.setPivotX(paramView.getWidth() / 2);
    paramView.setPivotY(paramView.getHeight() / 2);
    paramView.setRotation(f1 * 180.0F);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    QLog.d("ReadInJoyDailyOverScrollListener", 2, "[onViewCompleteVisableAndReleased] " + paramInt);
    if (paramInt == 1) {
      m(paramListView);
    }
    return false;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    QLog.d("ReadInJoyDailyOverScrollListener", 2, "[onViewCompleteVisable] ");
  }
  
  public void c(int paramInt, View paramView, ListView paramListView)
  {
    QLog.d("ReadInJoyDailyOverScrollListener", 2, "[onViewNotCompleteVisableAndReleased] " + paramInt);
    if (paramInt != 1) {}
    do
    {
      return;
      l(paramListView);
    } while (this.kr <= kys.af());
    QLog.d("ReadInJoyDailyOverScrollListener", 2, "[onViewCompleteVisableAndReleased] ");
    m(paramListView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nen
 * JD-Core Version:    0.7.0.1
 */