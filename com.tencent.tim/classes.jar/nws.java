import android.app.Activity;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VVideoView;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VVideoView.a;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager.c;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager.d;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.adapter.VComponentAdapter.OnVideoViewMethodListener;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.baseComponent.ComponentConstant.Event;
import org.json.JSONException;
import org.json.JSONObject;

public class nws
  implements VVideoView.a, VideoPlayManager.d, ComponentConstant.Event, mzk.a, nwn.a
{
  protected VVideoView a;
  protected VideoPlayManager a;
  protected nwn a;
  private int aUH = -1;
  private int bcP;
  private int bcQ = 1;
  protected Activity mActivity;
  
  public nws(Activity paramActivity, nwn paramnwn, VVideoView paramVVideoView, ViolaInstance paramViolaInstance)
  {
    this.mActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager = new VideoPlayManager(paramActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a(paramnwn);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a(this);
    this.jdField_a_of_type_Nwn = paramnwn;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView = paramVVideoView;
    this.jdField_a_of_type_Nwn.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager);
    this.jdField_a_of_type_Nwn.setEventListener(this);
    mzk.a().ce(paramActivity);
    mzk.a().a(this);
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
  
  private void k(int paramInt, Object paramObject)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        this.bcQ = paramInt;
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("state", paramInt);
        if (paramObject != null) {
          localJSONObject.put("message", paramObject);
        }
        paramObject = new JSONObject();
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a().a != null)
        {
          paramInt = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a().a.am().getWidth();
          paramObject.put("width", paramInt);
          paramInt = i;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a().a != null) {
            paramInt = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a().a.am().getHeight();
          }
          paramObject.put("height", paramInt);
          localJSONObject.put("videoSize", paramObject);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView.k("stateChange", localJSONObject);
          return;
        }
      }
      catch (Exception paramObject)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ViolaVideoDelegate", 2, "callJsStateChange,error = " + paramObject.getMessage());
      }
      paramInt = 0;
    }
  }
  
  public void a(int paramInt, VVideoView paramVVideoView, boolean paramBoolean, String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener)
  {
    boolean bool = false;
    this.jdField_a_of_type_Nwn.ai(0, paramBoolean);
    try
    {
      paramVVideoView = new JSONObject();
      paramBoolean = bool;
      if (this.bcP == 2) {
        paramBoolean = true;
      }
      paramVVideoView.put("hasUI", paramBoolean);
      paramOnVideoViewMethodListener.OnMethodSuccess(paramString, paramVVideoView);
      return;
    }
    catch (Exception paramVVideoView)
    {
      QLog.e("ViolaVideoDelegate", 2, "enterFullScreen error = : " + paramVVideoView.getMessage());
    }
  }
  
  public void a(VVideoView paramVVideoView) {}
  
  public void a(VVideoView paramVVideoView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.seekTo(paramInt);
  }
  
  public void a(VVideoView paramVVideoView, String paramString)
  {
    paramVVideoView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a();
    if (paramVVideoView != null)
    {
      paramVVideoView.oF(paramString);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.setXYaxis(paramVVideoView.aVm);
    }
  }
  
  public void a(VVideoView paramVVideoView, String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener)
  {
    try
    {
      paramVVideoView = new JSONObject();
      paramVVideoView.put("state", this.bcQ);
      paramVVideoView.put("currentTime", D(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.getCurrentPosition()));
      paramVVideoView.put("totalTime", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.getDuration() / 1000L);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("width", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a().a.am().getWidth());
      localJSONObject.put("height", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a().a.am().getHeight());
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
      QLog.d("ViolaVideoDelegate", 2, "open: " + paramJSONObject);
    }
    paramVVideoView = this.jdField_a_of_type_Nwn.n();
    try
    {
      paramVVideoView = new VideoPlayManager.c(paramVVideoView, paramJSONObject);
      if (paramVVideoView != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.stop();
        if (paramVVideoView.autoPlay)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.c(paramVVideoView);
          this.jdField_a_of_type_Nwn.a(paramVVideoView);
        }
      }
      else
      {
        return;
      }
    }
    catch (JSONException paramVVideoView)
    {
      for (;;)
      {
        paramVVideoView.printStackTrace();
        paramVVideoView = null;
        continue;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.b(paramVVideoView);
      }
    }
  }
  
  public void a(VVideoView paramVVideoView, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.setMute(paramBoolean);
  }
  
  public void a(VideoPlayManager.c paramc, int paramInt)
  {
    k(4, null);
  }
  
  public void a(VideoPlayManager.c paramc, int paramInt1, int paramInt2, String paramString)
  {
    paramc = new JSONObject();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      paramc.put("code", 101);
      localJSONObject.put("code", paramInt1 + "-" + paramInt2);
      localJSONObject.put("msg", paramString);
      paramc.put("extra", localJSONObject);
      k(6, paramc);
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void a(VideoPlayManager.c paramc, long paramLong)
  {
    try
    {
      paramc = new JSONObject();
      paramc.put("currentTime", D(paramLong));
      paramc.put("totalTime", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.getDuration() / 1000L);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView.k("playTimeChange", paramc);
      return;
    }
    catch (Exception paramc)
    {
      paramc.printStackTrace();
    }
  }
  
  public void a(VideoPlayManager.c paramc, boolean paramBoolean) {}
  
  public void aUK()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.pause();
  }
  
  public void b(VVideoView paramVVideoView)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.Gl()) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.start();
    }
    while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a() == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a());
  }
  
  public void b(VVideoView paramVVideoView, int paramInt)
  {
    this.bcP = paramInt;
    this.jdField_a_of_type_Nwn.setControlType(this.bcP);
  }
  
  public void b(VVideoView paramVVideoView, String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener)
  {
    boolean bool = true;
    this.jdField_a_of_type_Nwn.ul(1);
    try
    {
      paramVVideoView = new JSONObject();
      if (this.bcP == 2) {}
      for (;;)
      {
        paramVVideoView.put("hasUI", bool);
        paramOnVideoViewMethodListener.OnMethodSuccess(paramString, paramVVideoView);
        return;
        bool = false;
      }
      return;
    }
    catch (Exception paramVVideoView)
    {
      QLog.e("ViolaVideoDelegate", 2, "exitFullScreen error = : " + paramVVideoView.getMessage());
    }
  }
  
  public void b(VVideoView paramVVideoView, JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViolaVideoDelegate", 2, "resetSrc: " + paramJSONObject);
    }
    a(paramVVideoView, paramJSONObject);
  }
  
  public void b(VVideoView paramVVideoView, boolean paramBoolean) {}
  
  public void b(VideoPlayManager.c paramc, int paramInt)
  {
    k(2, null);
  }
  
  public void c(VVideoView paramVVideoView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.pause();
  }
  
  public void c(VVideoView paramVVideoView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.ti(paramInt);
  }
  
  public void c(VVideoView paramVVideoView, boolean paramBoolean)
  {
    this.jdField_a_of_type_Nwn.setFullScreenDisable(paramBoolean);
  }
  
  public void d(VVideoView paramVVideoView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.stop();
  }
  
  public void e(VVideoView paramVVideoView)
  {
    paramVVideoView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.stop();
    if (paramVVideoView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.c(paramVVideoView);
    }
  }
  
  public void f(VVideoView paramVVideoView)
  {
    this.jdField_a_of_type_Nwn.bbF();
  }
  
  public void g(VVideoView paramVVideoView)
  {
    this.jdField_a_of_type_Nwn.bbG();
  }
  
  public void g(VideoPlayManager.c paramc) {}
  
  public void h(VideoPlayManager.c paramc)
  {
    k(1, null);
  }
  
  public void i(VideoPlayManager.c paramc)
  {
    k(2, null);
  }
  
  public boolean isFullScreen()
  {
    return this.jdField_a_of_type_Nwn.isFullScreen();
  }
  
  public void j(VideoPlayManager.c paramc)
  {
    k(7, null);
  }
  
  public void k(VideoPlayManager.c paramc)
  {
    if (this.bcQ >= 2) {
      k(3, null);
    }
  }
  
  public void l(VideoPlayManager.c paramc)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.isPlaying()) {
      k(2, null);
    }
    while (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.isPause()) {
      return;
    }
    k(4, null);
  }
  
  public void m(VideoPlayManager.c paramc)
  {
    k(5, null);
  }
  
  public void oZ(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.setMute(false);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.setMute(true);
  }
  
  public void onActivityCreate() {}
  
  public void onActivityDestroy()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.onDestroy();
    if (this.jdField_a_of_type_Nwn != null) {
      this.jdField_a_of_type_Nwn.onDestory();
    }
    mzk.a().cf(this.mActivity);
    mzk.a().b(this);
    this.mActivity = null;
  }
  
  public void onActivityPause()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.onPause();
    mzk.a().z(false, "viola video");
  }
  
  public void onActivityResume()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.onResume();
    mzk.a().z(true, "viola video");
  }
  
  public void onActivityStart() {}
  
  public void onActivityStop() {}
  
  public void qi(boolean paramBoolean)
  {
    VVideoView localVVideoView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView;
    if (paramBoolean) {}
    for (String str = "stateVisible";; str = "stateHidden")
    {
      localVVideoView.k(str, null);
      return;
    }
  }
  
  public void qj(boolean paramBoolean)
  {
    if (paramBoolean) {
      for (;;)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject();
          if (this.bcP == 2)
          {
            paramBoolean = true;
            localJSONObject.put("hasUI", paramBoolean);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView.k("didEnterFullScreen", localJSONObject);
            return;
          }
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("ViolaVideoDelegate", 2, "initChangeFullScreenAnim onAnimationEnd error = : " + localException.getMessage());
          return;
        }
        paramBoolean = false;
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView.k("didExitFullScreen", null);
  }
  
  public void sX(int paramInt)
  {
    if (paramInt == 0) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.setMute(true);
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.setMute(false);
    }
  }
  
  public void setAccurate(boolean paramBoolean) {}
  
  public void setEndWithLastFrame(boolean paramBoolean)
  {
    this.jdField_a_of_type_Nwn.setEndWithLastFrame(paramBoolean);
  }
  
  public void setLoopBack(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.setLoopback(paramBoolean);
  }
  
  public void setRate(float paramFloat) {}
  
  public void setStartPosition(int paramInt) {}
  
  public void um(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("currentTime", D(paramInt));
      localJSONObject.put("totalTime", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.getDuration() / 1000L);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView.k("playTimeChange", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nws
 * JD-Core Version:    0.7.0.1
 */