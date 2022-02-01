import android.app.Activity;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VVideo;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VVideoView;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VVideoView.a;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaLazyFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.adapter.VComponentAdapter.OnVideoViewMethodListener;
import com.tencent.viola.core.ViolaInstance;
import org.json.JSONException;
import org.json.JSONObject;

public class nwp
  implements VVideoView.a, mzk.a, nbh
{
  protected VVideoView a;
  @Nullable
  private nwq a;
  private int aUH = -1;
  private int aWr;
  private boolean aoL;
  private boolean aqZ;
  private boolean avb;
  nbi c;
  protected Activity mActivity;
  private long mStartPosition;
  
  public nwp(Activity paramActivity, VVideoView paramVVideoView, int paramInt, ViolaInstance paramViolaInstance)
  {
    this.c = new nbi(paramInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView = paramVVideoView;
    this.mActivity = paramActivity;
    mzk.a().ce(paramActivity);
    mzk.a().a(this);
    this.c.a(this);
    this.c.u(paramVVideoView);
    if ((paramViolaInstance != null) && (paramViolaInstance.isPageVisiable())) {
      mzk.a().z(true, "viola video");
    }
  }
  
  public static final int D(long paramLong)
  {
    int i = 0;
    if (paramLong >= 500L) {
      i = (int)(paramLong / 1000L + 0.5D);
    }
    return i;
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
      paramString.put("width", this.c.getVideoWidth());
      paramString.put("height", this.c.getVideoHeight());
      localJSONObject.put("videoSize", paramString);
      localJSONObject.put("errorData", paramJSONObject);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView.k("stateChange", localJSONObject);
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView.bbI();
    }
  }
  
  private void aC(int paramInt, String paramString)
  {
    a(paramInt, paramString, null);
  }
  
  private void bbH()
  {
    if (this.aoL) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("hasUI", 0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView.k("didEnterFullScreen", localJSONObject);
        return;
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("VVideoControlListenerImpl", 2, "initChangeFullScreenAnim onAnimationEnd error = : " + localException.getMessage());
        return;
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView.k("didExitFullScreen", null);
  }
  
  private int getVideoState()
  {
    switch (this.c.getCurrentState())
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
  
  public void HN()
  {
    aC(2, null);
  }
  
  public void HO()
  {
    aC(4, null);
  }
  
  public void a(int paramInt, VVideoView paramVVideoView, boolean paramBoolean, String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VVideoControlListenerImpl", 2, "deal enterFullScreen: ");
    }
    this.aoL = true;
    Activity localActivity;
    if (!paramBoolean)
    {
      if (paramInt == 0) {
        this.mActivity.setRequestedOrientation(0);
      }
    }
    else
    {
      paramVVideoView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView;
      localActivity = this.mActivity;
      Window localWindow = localActivity.getWindow();
      this.aWr = localWindow.getDecorView().getSystemUiVisibility();
      if (!paramBoolean) {
        break label200;
      }
      localWindow.setFlags(1024, 1024);
      if (!CommonSuspensionGestureLayout.isXiaoMi()) {
        break label192;
      }
      muj.hideNavigationBar(this.mActivity);
    }
    for (;;)
    {
      if ((paramVVideoView.a() != null) && (paramVVideoView.a().getInstance() != null) && (paramVVideoView.a().getInstance().getFragment() != null))
      {
        paramVVideoView = (ViolaLazyFragment)paramVVideoView.a().getInstance().getFragment();
        if (paramVVideoView != null)
        {
          paramVVideoView.hideTitleBar();
          paramVVideoView.aYe();
        }
      }
      bbH();
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
      this.mActivity.setRequestedOrientation(8);
      break;
      label192:
      muj.aM(localActivity);
      continue;
      label200:
      muj.aM(localActivity);
    }
  }
  
  public void a(VVideoView paramVVideoView)
  {
    if ((this.jdField_a_of_type_Nwq != null) && (!this.c.isPreload()))
    {
      this.c.ph(this.aqZ);
      this.c.a(this.jdField_a_of_type_Nwq.busiType, this.jdField_a_of_type_Nwq.vid, this.jdField_a_of_type_Nwq.videoUrl, this.mStartPosition, this.jdField_a_of_type_Nwq.duration);
    }
  }
  
  public void a(VVideoView paramVVideoView, int paramInt)
  {
    if (!this.avb) {
      this.c.seekTo(paramInt);
    }
  }
  
  public void a(VVideoView paramVVideoView, String paramString)
  {
    if (paramString.equals("contain")) {
      this.c.setXYaxis(0);
    }
    while (!paramString.equals("cover")) {
      return;
    }
    this.c.setXYaxis(2);
  }
  
  public void a(VVideoView paramVVideoView, String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener)
  {
    try
    {
      paramVVideoView = new JSONObject();
      paramVVideoView.put("state", getVideoState());
      paramVVideoView.put("currentTime", D(this.c.getCurrentPosition()));
      paramVVideoView.put("totalTime", this.c.getDuration() / 1000L);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("width", this.c.getVideoWidth());
      localJSONObject.put("height", this.c.getVideoHeight());
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
      boolean bool2 = paramJSONObject.optBoolean("autoPreplay", false);
      a(paramVVideoView, paramJSONObject.optString("resize"));
      c(paramVVideoView, paramJSONObject.optInt("timeupdateRate"));
      setEndWithLastFrame(paramJSONObject.optBoolean("endWithLastFrame"));
      this.aqZ = paramJSONObject.optBoolean("cover_frame", false);
      this.mStartPosition = (paramJSONObject.optLong("start_position", 0L) * 1000L);
      this.jdField_a_of_type_Nwq = new nwq(paramJSONObject.getJSONObject("video_info"));
      this.c.setMute(paramJSONObject.optBoolean("muted", false));
      this.c.setSpeedRatio(Float.valueOf(paramJSONObject.optString("rate", "1.0")).floatValue());
      if (bool1)
      {
        this.c.a(this.jdField_a_of_type_Nwq.busiType, this.jdField_a_of_type_Nwq.vid, this.jdField_a_of_type_Nwq.videoUrl, this.mStartPosition, this.jdField_a_of_type_Nwq.duration);
        return;
      }
      if (bool2)
      {
        a(null);
        return;
      }
    }
    catch (JSONException paramVVideoView)
    {
      paramVVideoView.printStackTrace();
    }
  }
  
  public void a(VVideoView paramVVideoView, boolean paramBoolean)
  {
    this.c.setMute(paramBoolean);
  }
  
  public void aRp()
  {
    aC(1, null);
  }
  
  public void aRq()
  {
    aC(2, null);
  }
  
  public void aRr()
  {
    aC(3, null);
  }
  
  public void aRs()
  {
    if (this.c.isPlaying()) {
      aC(2, null);
    }
    while (!this.c.isPause()) {
      return;
    }
    aC(4, null);
  }
  
  public void aRt()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView.k("firstFrameReady", null);
  }
  
  public void aUK()
  {
    this.c.pause();
  }
  
  public void b(VVideoView paramVVideoView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VVideoControlListenerImpl", 2, "play: status=" + this.c.getCurrentState() + ", isPreload=" + this.c.isPreload() + ", videoinfo=" + this.jdField_a_of_type_Nwq + ", mStartPosition:" + this.mStartPosition);
    }
    if ((this.jdField_a_of_type_Nwq != null) && (this.c.isPreload())) {
      this.c.a(this.jdField_a_of_type_Nwq.busiType, this.jdField_a_of_type_Nwq.vid, this.jdField_a_of_type_Nwq.videoUrl, this.mStartPosition, this.jdField_a_of_type_Nwq.duration);
    }
    do
    {
      return;
      if (this.c.Fe())
      {
        this.c.start();
        return;
      }
    } while (this.jdField_a_of_type_Nwq == null);
    this.c.a(this.jdField_a_of_type_Nwq.busiType, this.jdField_a_of_type_Nwq.vid, this.jdField_a_of_type_Nwq.videoUrl, this.mStartPosition, this.jdField_a_of_type_Nwq.duration);
  }
  
  public void b(VVideoView paramVVideoView, int paramInt) {}
  
  public void b(VVideoView paramVVideoView, String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VVideoControlListenerImpl", 2, "deal exitFullScreen: ");
    }
    this.aoL = false;
    this.mActivity.setRequestedOrientation(1);
    this.mActivity.setRequestedOrientation(1);
    paramVVideoView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView;
    Window localWindow = this.mActivity.getWindow();
    localWindow.getDecorView().setSystemUiVisibility(this.aWr);
    localWindow.clearFlags(1024);
    if ((paramVVideoView.a() != null) && (paramVVideoView.a().getInstance() != null) && (paramVVideoView.a().getInstance().getFragment() != null))
    {
      paramVVideoView = (ViolaFragment)paramVVideoView.a().getInstance().getFragment();
      if (paramVVideoView != null)
      {
        paramVVideoView.showTitleBar();
        paramVVideoView.bch();
      }
    }
    bbH();
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
    this.c.stop();
    a(paramVVideoView, paramJSONObject);
  }
  
  public void b(VVideoView paramVVideoView, boolean paramBoolean) {}
  
  public void c(VVideoView paramVVideoView)
  {
    this.c.pause();
  }
  
  public void c(VVideoView paramVVideoView, int paramInt)
  {
    this.c.ti(paramInt);
  }
  
  public void c(VVideoView paramVVideoView, boolean paramBoolean) {}
  
  public void d(VideoPreDownloadMgr paramVideoPreDownloadMgr)
  {
    this.c.a.a(paramVideoPreDownloadMgr);
  }
  
  public void d(VVideoView paramVVideoView)
  {
    this.c.stop();
  }
  
  public void e(VVideoView paramVVideoView)
  {
    if (this.jdField_a_of_type_Nwq != null) {
      this.c.a(this.jdField_a_of_type_Nwq.busiType, this.jdField_a_of_type_Nwq.vid, this.jdField_a_of_type_Nwq.videoUrl, this.mStartPosition, this.jdField_a_of_type_Nwq.duration);
    }
  }
  
  public void f(VVideoView paramVVideoView)
  {
    this.c.aTP();
  }
  
  public void g(VVideoView paramVVideoView)
  {
    this.c.aTQ();
  }
  
  public boolean isFullScreen()
  {
    return this.aoL;
  }
  
  public void k(int paramInt1, int paramInt2, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    if ((paramInt1 == 123) && (paramInt2 == 108)) {}
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
  
  public void oZ(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.c.setMute(false);
      return;
    }
    this.c.setMute(true);
  }
  
  public void onActivityCreate() {}
  
  public void onActivityDestroy()
  {
    this.c.onDestroy();
    mzk.a().cf(this.mActivity);
    mzk.a().b(this);
    this.mActivity = null;
  }
  
  public void onActivityPause()
  {
    this.c.onPause();
    mzk.a().z(false, "viola video");
  }
  
  public void onActivityResume()
  {
    this.c.onResume();
    mzk.a().z(true, "viola video");
    if (this.aoL) {
      muj.aM(this.mActivity);
    }
  }
  
  public void onActivityStart() {}
  
  public void onActivityStop() {}
  
  public void onCompletion()
  {
    aC(5, null);
  }
  
  public void onProgressChanged(long paramLong)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("currentTime", D(paramLong));
      localJSONObject.put("totalTime", this.c.getDuration() / 1000L);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView.k("playTimeChange", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onVideoStop()
  {
    aC(7, null);
  }
  
  public void sX(int paramInt)
  {
    if (paramInt == 0) {
      this.c.setMute(true);
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (this.aUH == -1) {
          this.aUH = mzk.a().getStreamMaxVolume(3);
        }
        localJSONObject.put("value", paramInt / this.aUH);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView.k("volumeChange", localJSONObject);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      this.c.setMute(false);
    }
  }
  
  public void setAccurate(boolean paramBoolean)
  {
    this.avb = paramBoolean;
  }
  
  public void setEndWithLastFrame(boolean paramBoolean)
  {
    this.c.oP(paramBoolean);
  }
  
  public void setLoopBack(boolean paramBoolean)
  {
    this.c.setLoopback(paramBoolean);
  }
  
  public void setRate(float paramFloat)
  {
    this.c.setSpeedRatio(paramFloat);
  }
  
  public void setStartPosition(int paramInt)
  {
    this.mStartPosition = (paramInt * 1000);
  }
  
  public void sj(int paramInt)
  {
    aC(5, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nwp
 * JD-Core Version:    0.7.0.1
 */