import java.util.HashMap;
import java.util.Map;

public final class axgk
{
  private long aBN;
  private long aBO;
  private boolean duw;
  private boolean dux = true;
  private Map<String, Long> qG = new HashMap();
  
  public static axgk a()
  {
    return axgk.a.b();
  }
  
  private long bt(String paramString)
  {
    if (this.qG.containsKey(paramString)) {
      return ((Long)this.qG.get(paramString)).longValue();
    }
    return 0L;
  }
  
  private boolean disable()
  {
    return true;
  }
  
  private long h(String paramString1, String paramString2)
  {
    long l2 = 0L;
    long l3 = bt(paramString1);
    long l4 = bt(paramString2);
    long l1 = l2;
    if (l4 > 0L)
    {
      l1 = l2;
      if (l3 > l4) {
        l1 = l3 - l4;
      }
    }
    return l1;
  }
  
  public void acy(String paramString)
  {
    if (disable()) {
      return;
    }
    if ((this.duw) && (!this.qG.containsKey(paramString))) {
      this.qG.put(paramString, Long.valueOf(System.currentTimeMillis()));
    }
    axiy.i("CameraLaunchPerf", paramString);
  }
  
  public void bI(String paramString, long paramLong)
  {
    if (disable()) {
      return;
    }
    if ((this.duw) && (!this.qG.containsKey(paramString))) {
      this.qG.put(paramString, Long.valueOf(paramLong));
    }
    axiy.i("CameraLaunchPerf", paramString + " real happened at " + paramLong);
  }
  
  public void eJu()
  {
    long l = System.currentTimeMillis();
    if (this.aBN > 0L) {
      axiy.i("CameraLaunchPerf", "old AIO launch total cost=" + (l - this.aBN));
    }
  }
  
  public void eJv()
  {
    if (disable()) {
      return;
    }
    this.aBO = System.currentTimeMillis();
    axiy.d("CameraLaunchPerf", "circleClickCameraTab");
  }
  
  public void eJw()
  {
    if (disable()) {}
    while (this.aBO <= 0L) {
      return;
    }
    long l = System.currentTimeMillis();
    axiy.i("CameraLaunchPerf", "circle camera launch cost=" + (l - this.aBO));
    this.aBO = 0L;
  }
  
  public void eJx()
  {
    if (disable()) {
      return;
    }
    if (!this.duw)
    {
      this.duw = true;
      this.qG.clear();
    }
    axiy.i("CameraLaunchPerf", "beginSession----");
  }
  
  public void eJy()
  {
    if (disable()) {
      return;
    }
    if (this.duw)
    {
      this.duw = false;
      this.qG.clear();
    }
    axiy.i("CameraLaunchPerf", "endSession----");
  }
  
  public void log(String paramString1, String paramString2)
  {
    if (!disable()) {
      axiy.i("CameraLaunchPerf******", paramString1 + "--" + paramString2);
    }
  }
  
  public void nY(long paramLong)
  {
    this.aBN = paramLong;
  }
  
  public void print(boolean paramBoolean)
  {
    if (disable()) {}
    while (!this.duw) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("collect data:{");
    if (!paramBoolean) {
      localStringBuilder.append("userClick-startActivity=").append(h("startActivityForResult", "userClick")).append(", userClickDispatch=").append(h("AECameraLauncher---launchAECameraUnit-begin", "userClick")).append(", launchAECameraUnit=").append(h("AECameraLauncher---launchAECameraUnit-end", "AECameraLauncher---launchAECameraUnit-begin"));
    }
    for (;;)
    {
      localStringBuilder.append("}");
      axiy.i("CameraLaunchPerf", localStringBuilder.toString());
      return;
      paramBoolean = this.dux;
      this.dux = false;
      localStringBuilder.append("isColdLaunch=").append(paramBoolean).append(", startActivity-firstRealFrame=").append(h("onDrawFrameReal-end", "mainProcessLaunch")).append(", startActivity-firstFakeFrame=").append(h("onDrawFrameFake-end1", "mainProcessLaunch")).append(", ipc_cost=").append(h("activityOnCreateBegin", "mainProcessLaunch")).append(", activityOnCreate=").append(h("activityOnCreateEnd", "activityOnCreateBegin")).append(", buildCaptureUnit=").append(h("buildCaptureUnit-end", "buildCaptureUnit-begin")).append(", unitOnCreateView=").append(h("unitOnCreateView-end", "unitOnCreateView-begin")).append(", unitInflateView=").append(h("unitInflateView-end", "unitInflateView-begin")).append(", glSurfaceViewStaticInit=").append(h("glSurfaceViewStaticInit-end", "glSurfaceViewStaticInit-begin")).append(", activityOnStart=").append(h("activityOnStartEnd", "activityOnStartBegin")).append(", activityOnResume=").append(h("activityOnResumeEnd", "activityOnResumeBegin")).append(", activityOnResume-onSurfaceCreated=").append(h("onSurfaceCreated-begin", "activityOnResumeEnd")).append(", onSurfaceCreated=").append(h("onSurfaceCreated-end", "onSurfaceCreated-begin")).append(", startCamPreview-onFrameAvailable=").append(h("onFrameAvailable", "startCameraPreview-end")).append(", onDrawFrame1=").append(h("onDrawFrameFake-end1", "onDrawFrameFake-begin1")).append(", onDrawFrame2=").append(h("onDrawFrameFake-end2", "onDrawFrameFake-begin2")).append(", onDrawFrame3=").append(h("onDrawFrameFake-end3", "onDrawFrameFake-begin3")).append(", onDrawFrameReal=").append(h("onDrawFrameReal-end", "onDrawFrameReal-begin")).append(", filterProcessInitFilters=").append(h("FilterProcessInitFilters-end", "FilterProcessInitFilters-begin")).append(", filterMgrDraw=").append(h("filterMgrDraw-end", "filterMgrDraw-begin")).append(", onDrawFrame1End-onFrameAvailable=").append(h("onFrameAvailable", "onDrawFrameFake-end1"));
    }
  }
  
  static class a
  {
    private static final axgk a = new axgk(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axgk
 * JD-Core Version:    0.7.0.1
 */