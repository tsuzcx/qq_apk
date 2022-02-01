import android.view.animation.AnimationUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CopyOnWriteArrayList;

public class ajiq
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
    new ajir(this).execute(new Void[0]);
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
      paramInt = (int)Math.floor(this.frameCount * 1000 / ((float)l * 1.0F));
      this.sb.setLength(0);
      this.sb.append("FPSCalculator ").append(this.aBW).append(" frameCount :").append(this.frameCount).append(",diffTime :").append(l).append(" fps:").append(paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("FPSCalculator", 2, this.sb.toString());
      }
      this.B.add(this.sb.toString());
      if (((paramInt <= 0) || ("".equals(this.aBW))) || (this.B.size() > 100)) {
        printLog();
      }
    }
    this.startTime = -1L;
    this.frameCount = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajiq
 * JD-Core Version:    0.7.0.1
 */