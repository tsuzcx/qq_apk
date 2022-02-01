import android.text.TextUtils;
import com.tencent.aekit.openrender.util.AEProfilerBase;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.util.ArrayList;
import java.util.List;

public class axgj
  extends AEProfilerBase
  implements axgm
{
  private static boolean xe;
  private List<Float> MA = new ArrayList();
  private long aBM;
  private String cUi = "none";
  private boolean dtb;
  private boolean enable;
  private int mFrameCount;
  private long startTimestamp;
  
  public axgj()
  {
    xe = false;
    this.mEnableBase = true;
  }
  
  private float cb()
  {
    log("getAverageFps: fps list size=" + this.MA.size());
    float f = 0.0F;
    int i = 0;
    while (i < this.MA.size())
    {
      f += ((Float)this.MA.get(i)).floatValue();
      i += 1;
    }
    return f / this.MA.size();
  }
  
  private void eJo()
  {
    if ((!this.enable) || (this.dtb)) {}
    do
    {
      do
      {
        return;
      } while (System.currentTimeMillis() - this.startTimestamp < 5000L);
      if (this.mFrameCount >= 30)
      {
        if (this.aBM > 0L)
        {
          float f = this.mFrameCount * 1000.0F / (float)this.aBM;
          if (this.MA.size() >= 500) {
            this.MA.remove(0);
          }
          this.MA.add(Float.valueOf(f));
        }
        this.mFrameCount = 0;
        this.aBM = 0L;
        return;
      }
    } while (this.mOneFrameCost == 0L);
    this.aBM += this.mOneFrameCost;
    this.mFrameCount += 1;
  }
  
  private void log(String paramString)
  {
    if (xe) {
      QLog.i("AEFpsManager", 2, "report fps: " + paramString);
    }
  }
  
  private void report()
  {
    boolean bool = true;
    if (this.MA.size() == 0) {
      return;
    }
    float f = cb();
    axim localaxim = axim.a();
    String str = this.cUi;
    if (aaqh.cix == 1) {}
    for (;;)
    {
      localaxim.a(str, bool, f, 0.0D, 0.0D, "");
      log("fps=" + f);
      return;
      bool = false;
    }
  }
  
  private void startMonitor()
  {
    log("startMonitor");
    this.enable = true;
  }
  
  public void Yg(boolean paramBoolean)
  {
    log("onCameraSwitch");
    report();
    stopMonitor();
    startMonitor();
  }
  
  public void Yh(boolean paramBoolean)
  {
    log("onModeChangedToGif");
    this.dtb = paramBoolean;
    if (paramBoolean) {
      stopMonitor();
    }
  }
  
  public void eJp()
  {
    log("onCameraOpened");
  }
  
  public void eJq()
  {
    log("onCapturePicture");
    report();
    stopMonitor();
  }
  
  public void eJr()
  {
    log("onCaptureVideo");
    report();
    stopMonitor();
  }
  
  public void eJs()
  {
    log("onEnterActivity");
  }
  
  public void eJt()
  {
    log("onExitActivity");
    stopMonitor();
  }
  
  public void f(VideoMaterial paramVideoMaterial)
  {
    log("onMaterialSelected, useMaterial=" + paramVideoMaterial);
    if ((paramVideoMaterial == null) || (TextUtils.isEmpty(paramVideoMaterial.getId()))) {}
    for (this.cUi = "none";; this.cUi = paramVideoMaterial.getId())
    {
      stopMonitor();
      startMonitor();
      return;
    }
  }
  
  public void onDrawFrame()
  {
    eJo();
  }
  
  public void onFirstFrame()
  {
    log("onFirstFrame");
    this.startTimestamp = System.currentTimeMillis();
    startMonitor();
  }
  
  public void stopMonitor()
  {
    log("stopMonitor");
    this.enable = false;
    this.startTimestamp = 0L;
    this.aBM = 0L;
    this.mFrameCount = 0;
    this.MA.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axgj
 * JD-Core Version:    0.7.0.1
 */