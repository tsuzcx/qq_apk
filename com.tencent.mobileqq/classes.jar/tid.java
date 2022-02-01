import android.app.Activity;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VVideo;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VVideoDelegate.1;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VVideoDelegate.2;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VVideoView;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaLazyFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.adapter.VComponentAdapter.OnVideoViewMethodListener;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaSDKManager;
import org.json.JSONException;
import org.json.JSONObject;

public class tid
  implements rxl, rzn, tif
{
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long;
  protected Activity a;
  protected VVideoView a;
  rzo jdField_a_of_type_Rzo;
  @Nullable
  private tih jdField_a_of_type_Tih;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  
  public tid(Activity paramActivity, VVideoView paramVVideoView, int paramInt, ViolaInstance paramViolaInstance, String paramString, boolean paramBoolean)
  {
    this.e = paramBoolean;
    this.jdField_a_of_type_Rzo = new rzo(paramInt, paramString, paramBoolean);
    this.f = paramBoolean;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView = paramVVideoView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    rxk.a().a(paramActivity);
    rxk.a().a(this);
    this.jdField_a_of_type_Rzo.a(this);
    this.jdField_a_of_type_Rzo.a(paramVVideoView);
    if ((paramViolaInstance != null) && (paramViolaInstance.isPageVisiable())) {
      rxk.a().a(true, "viola video");
    }
    if (!TextUtils.isEmpty(paramString)) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      this.d = paramBoolean;
      return;
    }
  }
  
  private int a()
  {
    switch (this.jdField_a_of_type_Rzo.a())
    {
    case 6: 
    default: 
      return 6;
    case 1: 
    case 2: 
      return 1;
    case 3: 
      return 2;
    case 4: 
      return 3;
    case 5: 
      return 4;
    }
    return 5;
  }
  
  public static final int a(long paramLong)
  {
    int i = 0;
    if (paramLong >= 500L) {
      i = (int)(paramLong / 1000L + 0.5D);
    }
    return i;
  }
  
  private void a(int paramInt, String paramString)
  {
    a(paramInt, paramString, null);
  }
  
  private void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("state", paramInt);
      if (paramString != null) {
        localJSONObject.put("message", paramString);
      }
      paramString = new JSONObject();
      paramString.put("width", this.jdField_a_of_type_Rzo.b());
      paramString.put("height", this.jdField_a_of_type_Rzo.c());
      localJSONObject.put("videoSize", paramString);
      localJSONObject.put("errorData", paramJSONObject);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView.a("stateChange", localJSONObject);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VVideoControlListenerImpl", 2, "callJsStateChange,error = " + paramString.getMessage());
        }
      }
    }
    if (paramInt == 2) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView.a();
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Rzo.a(paramString1, paramString2);
    boolean bool = this.jdField_a_of_type_Rzo.e();
    if ((bool) || (this.jdField_a_of_type_Rzo.i()) || (this.jdField_a_of_type_Rzo.d()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("VVideoControlListenerImpl", 2, "seamlessPlay VIDEO_STATE_BUFFERING");
      }
      a(3, null);
      if (bool) {
        this.jdField_a_of_type_Rzo.j();
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Rzo.h())
      {
        a(2, null);
        return;
      }
      if (this.jdField_a_of_type_Rzo.g())
      {
        a(4, null);
        return;
      }
      QLog.e("VVideoControlListenerImpl", 2, "seamlessPlay error state: " + this.jdField_a_of_type_Rzo.a());
      this.e = true;
      this.f = true;
      this.jdField_a_of_type_Rzo.f();
    } while (this.jdField_a_of_type_Tih == null);
    this.jdField_a_of_type_Rzo.a(this.jdField_a_of_type_Tih.jdField_a_of_type_Int, this.jdField_a_of_type_Tih.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Tih.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_Tih.jdField_d_of_type_Int);
  }
  
  private void k()
  {
    if (this.jdField_b_of_type_Boolean) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("hasUI", 0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView.a("didEnterFullScreen", localJSONObject);
        return;
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("VVideoControlListenerImpl", 2, "initChangeFullScreenAnim onAnimationEnd error = : " + localException.getMessage());
        return;
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView.a("didExitFullScreen", null);
  }
  
  public void a() {}
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Rzo.a(paramFloat);
  }
  
  public void a(int paramInt, VVideoView paramVVideoView, boolean paramBoolean, String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VVideoControlListenerImpl", 2, "deal enterFullScreen: ");
    }
    this.jdField_b_of_type_Boolean = true;
    Activity localActivity;
    if (!paramBoolean)
    {
      if (paramInt == 0) {
        this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(0);
      }
    }
    else
    {
      paramVVideoView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView;
      localActivity = this.jdField_a_of_type_AndroidAppActivity;
      Window localWindow = localActivity.getWindow();
      this.jdField_b_of_type_Int = localWindow.getDecorView().getSystemUiVisibility();
      if (!paramBoolean) {
        break label200;
      }
      localWindow.setFlags(1024, 1024);
      if (!CommonSuspensionGestureLayout.c()) {
        break label192;
      }
      rpt.b(this.jdField_a_of_type_AndroidAppActivity);
    }
    for (;;)
    {
      if ((paramVVideoView.a() != null) && (paramVVideoView.a().getInstance() != null) && (paramVVideoView.a().getInstance().getFragment() != null))
      {
        paramVVideoView = (ViolaLazyFragment)paramVVideoView.a().getInstance().getFragment();
        if (paramVVideoView != null)
        {
          paramVVideoView.hideTitleBar();
          paramVVideoView.hideStatusBar();
        }
      }
      k();
      try
      {
        paramVVideoView = new JSONObject();
        paramVVideoView.put("hasUI", false);
        paramOnVideoViewMethodListener.OnMethodSuccess(paramString, paramVVideoView);
        return;
      }
      catch (Exception paramVVideoView)
      {
        QLog.e("VVideoControlListenerImpl", 2, "enterFullScreen error = : " + paramVVideoView.getMessage());
      }
      this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(8);
      break;
      label192:
      rpt.a(localActivity);
      continue;
      label200:
      rpt.a(localActivity);
    }
  }
  
  public void a(VideoPreDownloadMgr paramVideoPreDownloadMgr)
  {
    this.jdField_a_of_type_Rzo.a.a(paramVideoPreDownloadMgr);
  }
  
  public void a(VVideoView paramVVideoView)
  {
    if ((this.jdField_a_of_type_Tih != null) && (!this.jdField_a_of_type_Rzo.a()))
    {
      this.jdField_a_of_type_Rzo.b(this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Rzo.a(this.jdField_a_of_type_Tih.jdField_a_of_type_Int, this.jdField_a_of_type_Tih.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Tih.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_Tih.jdField_d_of_type_Int);
    }
  }
  
  public void a(VVideoView paramVVideoView, int paramInt)
  {
    if (!this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_Rzo.b(paramInt);
    }
  }
  
  public void a(VVideoView paramVVideoView, String paramString)
  {
    if (paramString.equals("contain")) {
      this.jdField_c_of_type_Int = 0;
    }
    for (;;)
    {
      if (this.f) {
        this.jdField_a_of_type_Rzo.a(this.jdField_c_of_type_Int);
      }
      return;
      if (paramString.equals("cover")) {
        this.jdField_c_of_type_Int = 2;
      }
    }
  }
  
  public void a(VVideoView paramVVideoView, String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener)
  {
    try
    {
      paramVVideoView = new JSONObject();
      paramVVideoView.put("state", a());
      paramVVideoView.put("currentTime", a(this.jdField_a_of_type_Rzo.b()));
      paramVVideoView.put("totalTime", this.jdField_a_of_type_Rzo.a() / 1000L);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("width", this.jdField_a_of_type_Rzo.b());
      localJSONObject.put("height", this.jdField_a_of_type_Rzo.c());
      paramVVideoView.put("videoSize", localJSONObject);
      paramOnVideoViewMethodListener.OnMethodSuccess(paramString, paramVVideoView);
      return;
    }
    catch (JSONException paramVVideoView)
    {
      paramVVideoView.printStackTrace();
    }
  }
  
  public void a(VVideoView paramVVideoView, JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VVideoControlListenerImpl", 2, "open: " + paramJSONObject);
    }
    try
    {
      boolean bool1 = paramJSONObject.optBoolean("autoplay", true);
      bool2 = paramJSONObject.optBoolean("autoPreplay", false);
      a(paramVVideoView, paramJSONObject.optString("resize"));
      c(paramVVideoView, paramJSONObject.optInt("timeupdateRate"));
      c_(paramJSONObject.optBoolean("endWithLastFrame"));
      this.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("cover_frame", false);
      this.jdField_a_of_type_Long = (paramJSONObject.optLong("start_position", 0L) * 1000L);
      this.jdField_a_of_type_Tih = new tih(paramJSONObject.getJSONObject("video_info"));
      this.jdField_a_of_type_Rzo.e(paramJSONObject.optBoolean("muted", false));
      this.jdField_a_of_type_Rzo.a(Float.valueOf(paramJSONObject.optString("rate", "1.0")).floatValue());
      if (paramJSONObject.optBoolean("debugInfoEnable", bnrf.i(ozs.a())))
      {
        paramVVideoView = paramJSONObject.optString("debugInfo");
        bnrf.h(ozs.a(), true);
        this.jdField_a_of_type_Rzo.a(paramVVideoView);
      }
      if (this.jdField_a_of_type_Tih.e == 1)
      {
        this.jdField_c_of_type_Int = rpt.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Tih.jdField_b_of_type_Int, this.jdField_a_of_type_Tih.jdField_c_of_type_Int);
        this.jdField_a_of_type_Rzo.a(this.jdField_c_of_type_Int);
      }
      if (this.d)
      {
        a(this.jdField_a_of_type_Tih.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Tih.jdField_d_of_type_JavaLangString);
        return;
      }
      if (bool1)
      {
        this.jdField_a_of_type_Rzo.a(this.jdField_a_of_type_Tih.jdField_a_of_type_Int, this.jdField_a_of_type_Tih.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Tih.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_Tih.jdField_d_of_type_Int);
        return;
      }
    }
    catch (JSONException paramVVideoView)
    {
      boolean bool2;
      paramVVideoView.printStackTrace();
      if (QLog.isColorLevel())
      {
        QLog.e("VVideoControlListenerImpl", 2, "open: ", paramVVideoView);
        return;
        if (bool2) {
          a(null);
        }
      }
    }
  }
  
  public void a(VVideoView paramVVideoView, boolean paramBoolean)
  {
    this.jdField_a_of_type_Rzo.e(paramBoolean);
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener)
  {
    paramOnVideoViewMethodListener.OnMethodSuccess(paramString, new JSONObject(this.jdField_a_of_type_Rzo.a()));
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b() {}
  
  public void b(VVideoView paramVVideoView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VVideoControlListenerImpl", 2, "play: status=" + this.jdField_a_of_type_Rzo.a() + ", isPreload=" + this.jdField_a_of_type_Rzo.a() + ", videoinfo=" + this.jdField_a_of_type_Tih + ", mStartPosition:" + this.jdField_a_of_type_Long);
    }
    if ((this.jdField_a_of_type_Tih != null) && (this.jdField_a_of_type_Rzo.a())) {
      this.jdField_a_of_type_Rzo.a(this.jdField_a_of_type_Tih.jdField_a_of_type_Int, this.jdField_a_of_type_Tih.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Tih.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_Tih.jdField_d_of_type_Int);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Rzo.b())
      {
        this.jdField_a_of_type_Rzo.c();
        return;
      }
    } while (this.jdField_a_of_type_Tih == null);
    this.jdField_a_of_type_Rzo.a(this.jdField_a_of_type_Tih.jdField_a_of_type_Int, this.jdField_a_of_type_Tih.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Tih.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_Tih.jdField_d_of_type_Int);
  }
  
  public void b(VVideoView paramVVideoView, int paramInt) {}
  
  public void b(VVideoView paramVVideoView, String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VVideoControlListenerImpl", 2, "deal exitFullScreen: ");
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
    this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
    paramVVideoView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView;
    Window localWindow = this.jdField_a_of_type_AndroidAppActivity.getWindow();
    localWindow.getDecorView().setSystemUiVisibility(this.jdField_b_of_type_Int);
    localWindow.clearFlags(1024);
    if ((paramVVideoView.a() != null) && (paramVVideoView.a().getInstance() != null) && (paramVVideoView.a().getInstance().getFragment() != null))
    {
      paramVVideoView = (ViolaFragment)paramVVideoView.a().getInstance().getFragment();
      if (paramVVideoView != null)
      {
        paramVVideoView.showTitleBar();
        paramVVideoView.recoverStatusBar();
      }
    }
    k();
    if ((TextUtils.isEmpty(paramString)) && (paramOnVideoViewMethodListener != null)) {}
    try
    {
      paramVVideoView = new JSONObject();
      paramVVideoView.put("hasUI", false);
      paramOnVideoViewMethodListener.OnMethodSuccess(paramString, paramVVideoView);
      return;
    }
    catch (Exception paramVVideoView)
    {
      QLog.e("VVideoControlListenerImpl", 2, "exitFullScreen error = : " + paramVVideoView.getMessage());
    }
  }
  
  public void b(VVideoView paramVVideoView, JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VVideoControlListenerImpl", 2, "resetSrc: " + paramJSONObject);
    }
    this.d = false;
    this.jdField_a_of_type_Rzo.f();
    a(paramVVideoView, paramJSONObject);
  }
  
  public void b(VVideoView paramVVideoView, boolean paramBoolean) {}
  
  public void b_(boolean paramBoolean)
  {
    this.jdField_a_of_type_Rzo.d(paramBoolean);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Rzo.l();
    rxk.a().a(true, "viola video");
    if (this.jdField_b_of_type_Boolean) {
      rpt.a(this.jdField_a_of_type_AndroidAppActivity);
    }
  }
  
  public void c(VVideoView paramVVideoView)
  {
    this.jdField_a_of_type_Rzo.d();
  }
  
  public void c(VVideoView paramVVideoView, int paramInt)
  {
    this.jdField_a_of_type_Rzo.c(paramInt);
  }
  
  public void c(VVideoView paramVVideoView, String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener)
  {
    try
    {
      paramVVideoView = new JSONObject();
      paramVVideoView.put("videoToken", this.jdField_a_of_type_Rzo.a());
      paramOnVideoViewMethodListener.OnMethodSuccess(paramString, paramVVideoView);
      return;
    }
    catch (JSONException paramVVideoView)
    {
      paramVVideoView.printStackTrace();
    }
  }
  
  public void c(VVideoView paramVVideoView, boolean paramBoolean) {}
  
  public void c(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void c_(boolean paramBoolean)
  {
    this.jdField_a_of_type_Rzo.c(paramBoolean);
  }
  
  public void d()
  {
    this.jdField_a_of_type_Rzo.k();
    rxk.a().a(false, "viola video");
  }
  
  public void d(VVideoView paramVVideoView)
  {
    this.jdField_a_of_type_Rzo.f();
  }
  
  public void e() {}
  
  public void e(VVideoView paramVVideoView)
  {
    this.jdField_a_of_type_Rzo.a();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Rzo.m();
    rxk.a().b(this.jdField_a_of_type_AndroidAppActivity);
    rxk.a().b(this);
    this.jdField_a_of_type_AndroidAppActivity = null;
  }
  
  public void f(VVideoView paramVVideoView)
  {
    this.jdField_a_of_type_Rzo.g();
  }
  
  public void f_(int paramInt)
  {
    this.jdField_a_of_type_Long = (paramInt * 1000);
  }
  
  public void g()
  {
    this.jdField_a_of_type_Rzo.i();
  }
  
  public void g(VVideoView paramVVideoView)
  {
    this.jdField_a_of_type_Rzo.h();
  }
  
  public void h()
  {
    if (!this.e)
    {
      this.jdField_a_of_type_Rzo.b();
      this.jdField_a_of_type_Rzo.a(this.jdField_c_of_type_Int);
      this.f = true;
    }
  }
  
  public void i()
  {
    if (!this.e)
    {
      this.jdField_a_of_type_Rzo.b();
      this.jdField_a_of_type_Rzo.a(this.jdField_c_of_type_Int);
      this.f = true;
      ViolaSDKManager.getInstance().postOnUiThreadDelay(new VVideoDelegate.1(this), 0L);
      g();
    }
  }
  
  public void j()
  {
    ViolaSDKManager.getInstance().postOnUiThreadDelay(new VVideoDelegate.2(this), 0L);
  }
  
  public void onBufferEnd()
  {
    if (this.jdField_a_of_type_Rzo.h()) {
      a(2, null);
    }
    while (!this.jdField_a_of_type_Rzo.g()) {
      return;
    }
    a(4, null);
  }
  
  public void onBufferStart()
  {
    a(3, null);
  }
  
  public void onCompletion()
  {
    a(5, null);
  }
  
  public void onDownloadFinished() {}
  
  public void onFirstFrameRendered()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView.a("firstFrameReady", null);
    if (this.h) {
      a(2, null);
    }
    this.g = true;
  }
  
  public void onHeadsetStateChanged(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Rzo.e(false);
      return;
    }
    this.jdField_a_of_type_Rzo.e(true);
  }
  
  public void onPhoneCome()
  {
    this.jdField_a_of_type_Rzo.d();
  }
  
  public void onProgressChanged(long paramLong)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("currentTime", a(paramLong));
      localJSONObject.put("totalTime", this.jdField_a_of_type_Rzo.a() / 1000L);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView.a("playTimeChange", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onSystemVolumeChanged(int paramInt)
  {
    if (paramInt == 0) {
      this.jdField_a_of_type_Rzo.e(true);
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (this.jdField_a_of_type_Int == -1) {
          this.jdField_a_of_type_Int = rxk.a().a(3);
        }
        localJSONObject.put("value", paramInt / this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView.a("volumeChange", localJSONObject);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      this.jdField_a_of_type_Rzo.e(false);
    }
  }
  
  public void onVideoEnd(int paramInt)
  {
    a(5, null);
  }
  
  public void onVideoError(int paramInt1, int paramInt2, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    if ((paramInt1 == 202) && (paramInt2 == 108)) {}
    try
    {
      localJSONObject.put("code", "2");
      for (;;)
      {
        a(6, paramString, localJSONObject);
        return;
        localJSONObject.put("code", paramInt1 + "-" + paramInt2);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void onVideoOpen()
  {
    this.g = false;
    this.h = false;
  }
  
  public void onVideoPause()
  {
    a(4, null);
  }
  
  public void onVideoPrepared()
  {
    a(1, null);
  }
  
  public void onVideoRestart()
  {
    a(2, null);
  }
  
  public void onVideoStart()
  {
    if (this.g) {
      a(2, null);
    }
    this.h = true;
  }
  
  public void onVideoStop()
  {
    a(7, null);
    this.h = false;
    this.g = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tid
 * JD-Core Version:    0.7.0.1
 */