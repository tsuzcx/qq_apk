import android.app.Activity;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VVideoView;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.adapter.VComponentAdapter.OnVideoViewMethodListener;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.baseComponent.ComponentConstant.Event;
import org.json.JSONException;
import org.json.JSONObject;

public class uan
  implements ComponentConstant.Event, squ, uab, uaf, uam
{
  private int a;
  protected Activity a;
  protected VVideoView a;
  protected VideoPlayManager a;
  protected uaa a;
  private int b = 1;
  private int c = -1;
  
  public uan(Activity paramActivity, uaa paramuaa, VVideoView paramVVideoView, ViolaInstance paramViolaInstance)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager = new VideoPlayManager(paramActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a(paramuaa);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a(this);
    this.jdField_a_of_type_Uaa = paramuaa;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView = paramVVideoView;
    this.jdField_a_of_type_Uaa.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager);
    this.jdField_a_of_type_Uaa.setEventListener(this);
    sqt.a().a(paramActivity);
    sqt.a().a(this);
    if ((paramViolaInstance != null) && (paramViolaInstance.isPageVisiable())) {
      sqt.a().a(true, "viola video");
    }
  }
  
  public static final int a(long paramLong)
  {
    int i = 0;
    if (paramLong >= 500L) {
      i = (int)(paramLong / 1000L + 0.5D);
    }
    return i;
  }
  
  private void a(int paramInt, Object paramObject)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        this.b = paramInt;
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("state", paramInt);
        if (paramObject != null) {
          localJSONObject.put("message", paramObject);
        }
        paramObject = new JSONObject();
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a().a != null)
        {
          paramInt = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a().a.a().getWidth();
          paramObject.put("width", paramInt);
          paramInt = i;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a().a != null) {
            paramInt = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a().a.a().getHeight();
          }
          paramObject.put("height", paramInt);
          localJSONObject.put("videoSize", paramObject);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView.a("stateChange", localJSONObject);
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
  
  public void a() {}
  
  public void a(float paramFloat) {}
  
  public void a(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("currentTime", a(paramInt));
      localJSONObject.put("totalTime", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a() / 1000L);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView.a("playTimeChange", localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(int paramInt, VVideoView paramVVideoView, boolean paramBoolean, String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener)
  {
    boolean bool = false;
    this.jdField_a_of_type_Uaa.a(0, paramBoolean);
    try
    {
      paramVVideoView = new JSONObject();
      paramBoolean = bool;
      if (this.jdField_a_of_type_Int == 2) {
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.d(paramInt);
  }
  
  public void a(VVideoView paramVVideoView, String paramString)
  {
    paramVVideoView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a();
    if (paramVVideoView != null)
    {
      paramVVideoView.a(paramString);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.c(paramVVideoView.f);
    }
  }
  
  public void a(VVideoView paramVVideoView, String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener)
  {
    try
    {
      paramVVideoView = new JSONObject();
      paramVVideoView.put("state", this.b);
      paramVVideoView.put("currentTime", a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.b()));
      paramVVideoView.put("totalTime", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a() / 1000L);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("width", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a().a.a().getWidth());
      localJSONObject.put("height", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a().a.a().getHeight());
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
    paramVVideoView = this.jdField_a_of_type_Uaa.a();
    try
    {
      paramVVideoView = new ual(paramVVideoView, paramJSONObject);
      if (paramVVideoView != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.c();
        if (paramVVideoView.b)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.b(paramVVideoView);
          this.jdField_a_of_type_Uaa.a(paramVVideoView);
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
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a(paramVVideoView);
      }
    }
  }
  
  public void a(VVideoView paramVVideoView, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.c(paramBoolean);
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener) {}
  
  public void a(ual paramual, int paramInt)
  {
    a(4, null);
  }
  
  public void a(ual paramual, int paramInt1, int paramInt2, String paramString)
  {
    paramual = new JSONObject();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      paramual.put("code", 101);
      localJSONObject.put("code", paramInt1 + "-" + paramInt2);
      localJSONObject.put("msg", paramString);
      paramual.put("extra", localJSONObject);
      a(6, paramual);
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
  
  public void a(ual paramual, long paramLong)
  {
    try
    {
      paramual = new JSONObject();
      paramual.put("currentTime", a(paramLong));
      paramual.put("totalTime", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a() / 1000L);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView.a("playTimeChange", paramual);
      return;
    }
    catch (Exception paramual)
    {
      paramual.printStackTrace();
    }
  }
  
  public void a(ual paramual, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean)
  {
    VVideoView localVVideoView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView;
    if (paramBoolean) {}
    for (String str = "stateVisible";; str = "stateHidden")
    {
      localVVideoView.a(str, null);
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Uaa.a();
  }
  
  public void a_(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.b(paramBoolean);
  }
  
  public void b() {}
  
  public void b(VVideoView paramVVideoView)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a()) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a();
    }
    while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a() == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a());
  }
  
  public void b(VVideoView paramVVideoView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Uaa.setControlType(this.jdField_a_of_type_Int);
  }
  
  public void b(VVideoView paramVVideoView, String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener)
  {
    boolean bool = true;
    this.jdField_a_of_type_Uaa.a(1);
    try
    {
      paramVVideoView = new JSONObject();
      if (this.jdField_a_of_type_Int == 2) {}
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
  
  public void b(ual paramual) {}
  
  public void b(ual paramual, int paramInt)
  {
    a(2, null);
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      for (;;)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject();
          if (this.jdField_a_of_type_Int == 2)
          {
            paramBoolean = true;
            localJSONObject.put("hasUI", paramBoolean);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView.a("didEnterFullScreen", localJSONObject);
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView.a("didExitFullScreen", null);
  }
  
  public void b_(boolean paramBoolean)
  {
    this.jdField_a_of_type_Uaa.setEndWithLastFrame(paramBoolean);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.e();
    sqt.a().a(true, "viola video");
  }
  
  public void c(VVideoView paramVVideoView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.b();
  }
  
  public void c(VVideoView paramVVideoView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.e(paramInt);
  }
  
  public void c(VVideoView paramVVideoView, String paramString, VComponentAdapter.OnVideoViewMethodListener paramOnVideoViewMethodListener) {}
  
  public void c(VVideoView paramVVideoView, boolean paramBoolean)
  {
    this.jdField_a_of_type_Uaa.setFullScreenDisable(paramBoolean);
  }
  
  public void c(ual paramual)
  {
    a(1, null);
  }
  
  public void c(boolean paramBoolean) {}
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.d();
    sqt.a().a(false, "viola video");
  }
  
  public void d(VVideoView paramVVideoView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.c();
  }
  
  public void d(ual paramual)
  {
    a(2, null);
  }
  
  public void e() {}
  
  public void e(VVideoView paramVVideoView)
  {
    paramVVideoView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.c();
    if (paramVVideoView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.b(paramVVideoView);
    }
  }
  
  public void e(ual paramual)
  {
    a(7, null);
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.f();
    if (this.jdField_a_of_type_Uaa != null) {
      this.jdField_a_of_type_Uaa.c();
    }
    sqt.a().b(this.jdField_a_of_type_AndroidAppActivity);
    sqt.a().b(this);
    this.jdField_a_of_type_AndroidAppActivity = null;
  }
  
  public void f(VVideoView paramVVideoView)
  {
    this.jdField_a_of_type_Uaa.a();
  }
  
  public void f(ual paramual)
  {
    if (this.b >= 2) {
      a(3, null);
    }
  }
  
  public void g() {}
  
  public void g(VVideoView paramVVideoView)
  {
    this.jdField_a_of_type_Uaa.b();
  }
  
  public void g(ual paramual)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.d()) {
      a(2, null);
    }
    while (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.c()) {
      return;
    }
    a(4, null);
  }
  
  public void g_(int paramInt) {}
  
  public void h() {}
  
  public void h(ual paramual)
  {
    a(5, null);
  }
  
  public void i() {}
  
  public void j() {}
  
  public void onHeadsetStateChanged(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.c(false);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.c(true);
  }
  
  public void onPhoneCome()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.b();
  }
  
  public void onSystemVolumeChanged(int paramInt)
  {
    if (paramInt == 0) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.c(true);
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (this.c == -1) {
          this.c = sqt.a().a(3);
        }
        localJSONObject.put("value", paramInt / this.c);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView.a("volumeChange", localJSONObject);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVideoPlayManager.c(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uan
 * JD-Core Version:    0.7.0.1
 */