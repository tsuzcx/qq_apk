import android.animation.ValueAnimator;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam.MotionInfo;
import java.util.HashMap;
import java.util.Map;

public abstract class aykh
{
  public float FH;
  public float FI;
  public float FJ;
  public float FK;
  public float FL = 1.0F;
  public float FM = 1.0F;
  public float FN = 1.0F;
  public ValueAnimator aX;
  public ValueAnimator aY;
  public boolean dzE;
  public boolean dzF;
  public boolean dzG;
  public boolean dzH;
  public int eKr = 0;
  public boolean isAnchor;
  public Map<Long, TrackerStickerParam.MotionInfo> qU = new HashMap();
  
  public void Zx(boolean paramBoolean)
  {
    this.dzE = false;
  }
  
  public void a(aykh paramaykh)
  {
    if (paramaykh != null)
    {
      this.dzE = paramaykh.dzE;
      this.FH = paramaykh.FH;
      this.FI = paramaykh.FI;
      this.FJ = paramaykh.FJ;
      this.FK = paramaykh.FK;
      this.dzF = paramaykh.dzF;
      this.isAnchor = paramaykh.isAnchor;
      this.dzH = paramaykh.dzH;
      this.FM = paramaykh.FM;
      this.eKr = paramaykh.eKr;
    }
  }
  
  public boolean aQK()
  {
    return this.eKr == 0;
  }
  
  public boolean aQL()
  {
    return this.eKr == 3;
  }
  
  public void eSc()
  {
    this.isAnchor = false;
    this.dzH = false;
    this.FH = 0.0F;
    this.FI = 0.0F;
    this.FJ = 0.0F;
    this.FK = 0.0F;
    this.FM = 1.0F;
    this.qU.clear();
    this.eKr = 0;
    if (this.aX != null)
    {
      this.aX.cancel();
      this.aX = null;
    }
    eSp();
  }
  
  public void eSp()
  {
    if ((this.aY != null) && (this.aY.isRunning())) {
      this.aY.cancel();
    }
  }
  
  public boolean isTracking()
  {
    return this.eKr == 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aykh
 * JD-Core Version:    0.7.0.1
 */