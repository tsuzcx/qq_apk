import android.view.animation.AnimationUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CopyOnWriteArrayList;

public class txo
{
  private final CopyOnWriteArrayList<String> B = new CopyOnWriteArrayList();
  private String aBW;
  private int frameCount;
  private StringBuffer sb = new StringBuffer();
  private long startTime = -1L;
  
  public void bEQ()
  {
    if (this.aBW != null) {
      this.frameCount += 1;
    }
  }
  
  public void printLog()
  {
    if (this.B.size() < 1) {
      return;
    }
    new txp(this).execute(new Void[0]);
  }
  
  public void setActTAG(String paramString)
  {
    this.aBW = paramString;
  }
  
  public void zD(int paramInt)
  {
    if (this.aBW != null)
    {
      if (paramInt == 2)
      {
        this.startTime = AnimationUtils.currentAnimationTimeMillis();
        this.frameCount = 0;
      }
    }
    else {
      return;
    }
    if ((this.startTime > 0L) && (this.frameCount > 0))
    {
      long l = AnimationUtils.currentAnimationTimeMillis() - this.startTime;
      if ((l > 1000L) || ((l >= 500L) && ("actFPSRecent".equals(this.aBW))))
      {
        paramInt = (int)Math.floor(this.frameCount * 1000 / ((float)l * 1.0F));
        this.sb.setLength(0);
        this.sb.append("FPSCalculator ").append(this.aBW).append(" frameCount :").append(this.frameCount).append(",diffTime :").append(l).append(" fps:").append(paramInt);
        this.sb.append(",aioBusiness=").append(aqjc.Cc());
        if (QLog.isDevelopLevel()) {
          QLog.e("FPSCalculator", 4, this.sb.toString());
        }
        this.B.add(this.sb.toString());
        if ((paramInt > 0) && (!"".equals(this.aBW))) {
          aqjc.ae(this.aBW, paramInt, aqjc.Cc());
        }
        if (this.B.size() > 100) {
          printLog();
        }
      }
    }
    this.startTime = -1L;
    this.frameCount = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     txo
 * JD-Core Version:    0.7.0.1
 */