import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.idlefish.flutterboost.containers.BoostFlutterActivity.SerializableMap;
import com.qflutter.native_resources.QFlutterSkinEnginePlugin;
import com.tencent.mobileqq.flutter.container.QFlutterFragment;
import com.tencent.mobileqq.flutter.container.QFlutterFragment.a;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import io.flutter.embedding.engine.renderer.OnFirstFrameRenderedListener;
import java.util.HashMap;
import java.util.Map;

public class ahfj
  implements ahfw, OnFirstFrameRenderedListener
{
  private boolean Yw;
  private ahfi a;
  private long aau;
  private long aav;
  private long aaw;
  private Bundle bf;
  private boolean cgA;
  private boolean cgB;
  private boolean cgC;
  private boolean cgz;
  private ViewGroup cj;
  private Activity mActivity;
  private View mLoadingView;
  private boolean mNeedReport = true;
  private long mStartTimeMillis;
  
  public ahfj(ahfi paramahfi)
  {
    this.a = paramahfi;
  }
  
  private void dnh()
  {
    Object localObject1 = new FrameLayout(this.mActivity);
    ((FrameLayout)localObject1).setId(2131367554);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    this.cj.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    this.cj.bringChildToFront(this.mLoadingView);
    String str = this.bf.getString("url");
    localObject1 = null;
    if (this.bf.getSerializable("params") != null) {
      localObject1 = ((BoostFlutterActivity.SerializableMap)this.bf.getSerializable("params")).getMap();
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new HashMap();
    }
    a(this.a, str, (Map)localObject2, 2131367554);
  }
  
  protected void a(ahfi paramahfi, String paramString, Map paramMap, int paramInt)
  {
    paramString = new QFlutterFragment.a().a(paramString).a(paramMap).a();
    paramString.a(new ahfk(this));
    paramahfi = (FragmentManager)paramahfi.x();
    if (paramahfi != null) {
      paramahfi.beginTransaction().add(paramInt, paramString).commitAllowingStateLoss();
    }
  }
  
  public void a(ahfx paramahfx)
  {
    if ((paramahfx != null) && (paramahfx.isSuccess()))
    {
      this.cgA = paramahfx.cgF;
      this.cgC = paramahfx.cgG;
      this.cgB = true;
      this.aaw = SystemClock.elapsedRealtime();
      dnh();
      if (paramahfx.isDebugMode) {
        QQToast.a(this.mActivity, 0, 2131700351, 1).show();
      }
      return;
    }
    QQToast.a(this.mActivity, 1, 2131695453, 1).show();
    this.mActivity.finish();
  }
  
  public void dng()
  {
    if (ahfz.a().anh()) {
      this.mNeedReport = false;
    }
    this.aav = SystemClock.elapsedRealtime();
    ahfz.a().a(this, this.cgz, this.mNeedReport);
    ahgc.a().onCreate();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      this.mNeedReport = false;
      paramBundle.remove("android:support:fragments");
    }
    if ((this.a.getHostActivity() == null) || (this.a.x() == null)) {
      throw new RuntimeException("must specify Activity and FragmentManager!");
    }
    this.mActivity = this.a.getHostActivity();
    this.bf = this.a.d();
    if (this.bf == null) {
      this.bf = new Bundle();
    }
    this.aau = this.bf.getLong("click_millis", 0L);
    this.cgz = this.bf.getBoolean("preload_process", false);
    this.mStartTimeMillis = SystemClock.elapsedRealtime();
    if ((this.aau == 0L) || (this.mStartTimeMillis == 0L)) {
      this.mNeedReport = false;
    }
  }
  
  public View onCreateView()
  {
    QFlutterSkinEnginePlugin.setCurrentThemeId(ThemeUtil.getCurrentThemeId());
    this.cj = new RelativeLayout(this.mActivity);
    this.cj.setBackgroundResource(2130851023);
    this.mLoadingView = LayoutInflater.from(this.mActivity).inflate(2131561078, null);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.cj.addView(this.mLoadingView, localLayoutParams);
    return this.cj;
  }
  
  public void onDestroy()
  {
    ahfz.a().b(this);
    ahgc.a().cc(this.cgA, this.cgB);
  }
  
  public void onFirstFrameRendered()
  {
    QLog.d("QFlutter.fragment", 1, String.format("onFirstFrameRendered, mIsFirstLaunch: %s, mIsFirstFrame: %s, mNeedReport: %s", new Object[] { Boolean.valueOf(this.cgA), Boolean.valueOf(this.Yw), Boolean.valueOf(this.mNeedReport) }));
    if ((!this.cgA) && (!this.Yw))
    {
      this.Yw = true;
      return;
    }
    this.cj.removeView(this.mLoadingView);
    if (this.mNeedReport)
    {
      this.mNeedReport = false;
      long l4 = SystemClock.elapsedRealtime();
      long l1 = l4 - this.aau;
      long l2 = this.mStartTimeMillis - this.aau;
      long l3 = this.aaw - this.aav;
      l4 -= this.aaw;
      if (QLog.isColorLevel()) {
        QLog.d("QFlutter.fragment", 2, String.format("[QFlutterFirstFrame], mIsPreloadProcess: %s, isFirstLaunch: %s, totalCost: %s, loadProcessCost: %s, launchCost: %s, openPageCost: %s", new Object[] { Boolean.valueOf(this.cgz), Boolean.valueOf(this.cgA), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4) }));
      }
      ahgd.a(this.cgA, this.cgC, this.cgz, l1, l2, l3, l4);
    }
    ahgc.a().Ko(this.cgA);
  }
  
  public void onPause()
  {
    this.mNeedReport = false;
    ahgc.a().aOR();
  }
  
  public void onPostThemeChanged()
  {
    QFlutterSkinEnginePlugin.setCurrentThemeId(ThemeUtil.getCurrentThemeId());
  }
  
  public void onResume() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahfj
 * JD-Core Version:    0.7.0.1
 */