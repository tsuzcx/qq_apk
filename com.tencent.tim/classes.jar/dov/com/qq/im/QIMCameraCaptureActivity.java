package dov.com.qq.im;

import acfp;
import aeee;
import alwy;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import anfe;
import anii;
import arlc;
import awrz;
import awsj;
import axcg;
import axgk;
import axis;
import axiy;
import axiz;
import axol;
import axov;
import ayca;
import aycb;
import aycc;
import ayxa;
import ayzs;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import shb;
import sxa;

@TargetApi(14)
public class QIMCameraCaptureActivity
  extends PeakActivity
  implements ayca, aycb
{
  private static SparseIntArray al = new SparseIntArray();
  private aycc a;
  private boolean ddR;
  private boolean drk;
  private boolean drl;
  private int eCu;
  private int fromType;
  private View mRootView;
  private int uf;
  
  public static Intent a(Context paramContext, Bundle paramBundle)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QIMCameraCaptureActivity", 4, "in getLaunchIntent");
    }
    paramContext = new Intent(paramContext, QIMCameraCaptureActivity.class);
    if (paramBundle != null)
    {
      int i = paramBundle.getInt("VIDEO_STORY_FROM_TYPE", axcg.a.getId());
      if ((axcg.l.ob(i)) || (axcg.k.ob(i))) {
        paramContext.setFlags(268435456);
      }
    }
    paramContext.putExtras(paramBundle);
    paramContext.putExtra("need_show_banner", false);
    return paramContext;
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    long l = System.currentTimeMillis();
    if (anfe.akH != 0L)
    {
      anfe.akJ = l;
      QLog.e("CAM_MONITOR_EVENT", 1, new Object[] { "TIMESTAMP_START_ACTIVITY ", Long.valueOf(anfe.akJ) });
      paramBundle.putLong("TIMESTAMP_PRELOAD_PEAK", anfe.akH);
      paramBundle.putLong("TIMESTAMP_CLICK_CAMERA", anfe.akI);
      paramBundle.putLong("TIMESTAMP_START_ACTIVITY", anfe.akJ);
    }
    paramBundle.putLong("ACTIVITY_START_TIME", l);
    paramBundle.putLong("intent_key_launch_begin_time", l);
    Object localObject = axol.getAppInterface();
    if (localObject != null) {}
    for (localObject = ((AppInterface)localObject).getCurrentAccountUin();; localObject = "none")
    {
      paramBundle.putString("intent_key_uid_for_report", (String)localObject);
      paramActivity.startActivityForResult(a(paramActivity, paramBundle), paramInt);
      axgk.a().acy("startActivityForResult");
      return;
    }
  }
  
  private boolean aNs()
  {
    if (al.indexOfKey(this.fromType) >= 0)
    {
      int j = al.get(this.fromType);
      SparseIntArray localSparseIntArray = al;
      int i = this.fromType;
      j += 1;
      localSparseIntArray.put(i, j);
      axiy.d("QIMCameraCaptureActivity", "isRepeatLaunch key: " + this.fromType + " value: " + j);
      return true;
    }
    al.put(this.fromType, 1);
    axiy.d("QIMCameraCaptureActivity", "isRepeatLaunch2 key: " + this.fromType + " value: " + 1);
    return false;
  }
  
  private void eEU()
  {
    if (this.drk) {
      return;
    }
    this.drk = true;
    if (al.indexOfKey(this.fromType) >= 0)
    {
      int i = al.get(this.fromType);
      axiy.d("QIMCameraCaptureActivity", "decreaseFrom key: " + this.fromType + " value: " + i);
      if (i <= 1)
      {
        al.delete(this.fromType);
        return;
      }
      al.put(this.fromType, i - 1);
      return;
    }
    axiy.d("QIMCameraCaptureActivity", "decreaseFrom2 key: " + this.fromType);
    al.delete(this.fromType);
  }
  
  public static void g(Context paramContext, Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    paramBundle.putLong("ACTIVITY_START_TIME", l);
    paramBundle.putLong("intent_key_launch_begin_time", l);
    Object localObject = axol.getAppInterface();
    if (localObject != null) {}
    for (localObject = ((AppInterface)localObject).getCurrentAccountUin();; localObject = "none")
    {
      paramBundle.putString("intent_key_uid_for_report", (String)localObject);
      paramContext.startActivity(a(paramContext, paramBundle));
      return;
    }
  }
  
  public void acX(int paramInt)
  {
    finish();
  }
  
  public void eET()
  {
    super.onBackPressed();
  }
  
  public void finish()
  {
    super.finish();
    if (this.a != null) {
      this.a.finish();
    }
  }
  
  public Activity getActivity()
  {
    return this;
  }
  
  public AppInterface getAppInterface()
  {
    return axol.getAppInterface();
  }
  
  public View getRootView()
  {
    return this.mRootView;
  }
  
  public boolean isLatecyWaitRuntime()
  {
    return true;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.a.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    this.a.onBackPressed();
    arlc.b(BaseApplicationImpl.getContext(), true, 51);
    aeee.e(BaseApplicationImpl.getContext(), 2, true);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (anii.isDualScreenPhone())
    {
      DisplayMetrics localDisplayMetrics = alwy.getDisplayMetrics(this);
      if ((localDisplayMetrics != null) && ((this.uf != localDisplayMetrics.widthPixels) || (this.eCu != localDisplayMetrics.heightPixels)))
      {
        this.uf = localDisplayMetrics.widthPixels;
        this.eCu = localDisplayMetrics.heightPixels;
        this.a.lp(this.uf, this.eCu);
      }
      if (QLog.isColorLevel()) {
        QLog.i("QIMCameraCaptureActivity", 2, "onConfigurationChanged width:" + localDisplayMetrics.widthPixels + ", hight:" + localDisplayMetrics.heightPixels);
      }
    }
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    axiy.i("QIMCameraCaptureActivity", "[onCreate] + BEGIN");
    long l1 = System.currentTimeMillis();
    long l2 = getActivity().getIntent().getLongExtra("intent_key_launch_begin_time", 0L);
    axiy.d("QIMCameraCaptureActivity", "[onCreate] from startActivity to onCreate, time cost = " + (l1 - l2));
    this.fromType = axcg.i(getIntent());
    axgk.a().eJx();
    axgk.a().bI("mainProcessLaunch", l2);
    axgk.a().bI("activityOnCreateBegin", l1);
    axgk.a().nY(l2);
    axpk.dvQ = false;
    super.getWindow().addFlags(256);
    super.getWindow().addFlags(512);
    super.getWindow().addFlags(128);
    if (anii.isDualScreenPhone()) {
      ayxa.resetFullScreen(this);
    }
    ayxa.initLiuHaiProperty(this);
    if (ayxa.needCloseFullScreen()) {
      ayxa.closeFullScreen(this);
    }
    Object localObject = alwy.getDisplayMetrics(this);
    if (localObject != null)
    {
      this.uf = ((DisplayMetrics)localObject).widthPixels;
      this.eCu = ((DisplayMetrics)localObject).heightPixels;
    }
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.onCreate(paramBundle);
    if (aNs())
    {
      axiy.e("QIMCameraCaptureActivity", "repeat launch from: " + this.fromType);
      finish();
      return;
    }
    int j = getIntent().getIntExtra("edit_video_type", 10002);
    int i = j;
    if (getIntent().getExtras() != null)
    {
      i = j;
      if (getIntent().getExtras().containsKey("VIDEO_STORY_FROM_TYPE"))
      {
        int k = getIntent().getExtras().getInt("VIDEO_STORY_FROM_TYPE");
        i = j;
        if (axcg.e.ob(k))
        {
          localObject = axis.a().t("app_alg_aio_camera_type_id", "", 4);
          QLog.d("QIMCameraCaptureActivity", 4, "aio camera type: " + (String)localObject);
          if ((!"NEWCAMERA".equals(localObject)) && (!"NEWCAMERA20".equals(localObject))) {
            break label507;
          }
          i = 10024;
          getIntent().putExtra("VIDEO_STORY_FROM_TYPE", axcg.e.getId());
        }
      }
    }
    for (;;)
    {
      axgk.a().acy("buildCaptureUnit-begin");
      axiz.eLD();
      this.a = awsj.a(i, this, this);
      axgk.a().acy("buildCaptureUnit-end");
      this.a.onCreate(paramBundle);
      axgk.a().acy("unitOnCreateView-begin");
      this.mRootView = this.a.onCreateView();
      axgk.a().acy("unitOnCreateView-end");
      setContentView(this.mRootView);
      if (!isInMultiWindow()) {
        break;
      }
      QQToast.a(this, acfp.m(2131711177), 0).show();
      finish();
      return;
      label507:
      i = 10000;
      getIntent().putExtra("VIDEO_STORY_FROM_TYPE", axcg.p.getId());
    }
    ThreadManagerV2.excute(new QIMCameraCaptureActivity.1(this, i), 16, null, true);
    axgk.a().acy("activityOnCreateEnd");
    axiy.i("QIMCameraCaptureActivity", "[onCreate] + END, time cost = " + (System.currentTimeMillis() - l1));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    axiy.d("QIMCameraCaptureActivity", "onDestroy from: " + this.fromType);
    eEU();
    if (this.a != null)
    {
      this.a.onDestroy();
      sxa.a().bzY = 0;
      ayzs localayzs = (ayzs)axov.a(3);
      ayzs.dyy = 0;
      ((awrz)axov.a(13)).acZ(0);
      arlc.b(BaseApplicationImpl.getContext(), true, 51);
      aeee.e(BaseApplicationImpl.getContext(), 2, true);
    }
    axgk.a().print(true);
    axgk.a().eJy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return this.a.a(paramInt, paramKeyEvent, super.onKeyDown(paramInt, paramKeyEvent));
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    getIntent().putExtras(paramIntent);
    this.a.onNewIntent(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.a != null) {
      this.a.onActivityPause();
    }
    axiy.d("QIMCameraCaptureActivity", "onPause from: " + this.fromType);
    if (getActivity().isFinishing()) {
      eEU();
    }
  }
  
  public void onResume()
  {
    axiy.i("QIMCameraCaptureActivity", "[onResume] + BEGIN");
    long l = System.currentTimeMillis();
    if (!this.drl) {
      axgk.a().acy("activityOnResumeBegin");
    }
    super.onResume();
    this.a.onActivityResume();
    ((awrz)axov.a(13)).xL(0);
    if ((Build.VERSION.SDK_INT >= 29) && (!axcg.oi(this.fromType))) {
      shb.e(getWindow());
    }
    arlc.b(BaseApplicationImpl.getContext(), false, 51);
    aeee.e(BaseApplicationImpl.getContext(), 2, false);
    if (!this.drl) {
      axgk.a().acy("activityOnResumeEnd");
    }
    this.drl = true;
    axiy.i("QIMCameraCaptureActivity", "[onResume] + END, time cost = " + (System.currentTimeMillis() - l));
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.a.onSaveInstanceState(paramBundle);
  }
  
  public void onStart()
  {
    axiy.i("QIMCameraCaptureActivity", "[onStart] + BEGIN");
    if (!this.ddR) {
      axgk.a().acy("activityOnStartBegin");
    }
    long l = System.currentTimeMillis();
    waitAppRuntime();
    axiy.d("QIMCameraCaptureActivity", "[onStart] waitAppRuntime, cost = " + (System.currentTimeMillis() - l));
    super.onStart();
    this.a.onActivityStart();
    if (!this.ddR) {
      axgk.a().acy("activityOnStartEnd");
    }
    this.ddR = true;
    axiy.i("QIMCameraCaptureActivity", "[onStart] + END, time cost = " + (System.currentTimeMillis() - l));
  }
  
  public void onStop()
  {
    super.onStop();
    axiy.d("QIMCameraCaptureActivity", "onStop from: " + this.fromType);
    if (this.a != null) {
      this.a.onActivityStop();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.a.onTouchEvent(paramMotionEvent, super.onTouchEvent(paramMotionEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraCaptureActivity
 * JD-Core Version:    0.7.0.1
 */