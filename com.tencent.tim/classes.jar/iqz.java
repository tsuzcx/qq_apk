import android.content.Context;
import android.view.ViewConfiguration;

public class iqz
{
  private boolean Ui;
  private iqx a;
  private int mOverflingDistance;
  
  public iqz(Context paramContext)
  {
    this.a = new iqx(paramContext);
    this.mOverflingDistance = ViewConfiguration.get(paramContext).getScaledOverflingDistance();
  }
  
  public void apC()
  {
    this.a.forceFinished(true);
  }
  
  public boolean av(long paramLong)
  {
    return this.a.computeScrollOffset();
  }
  
  public int f(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = this.a.getCurrX();
    if (this.a.isFinished()) {}
    for (int i = j;; i = this.a.getFinalX())
    {
      paramInt2 = irc.clamp(i + paramInt1, paramInt2, paramInt3);
      if (paramInt2 != j) {
        this.a.startScroll(j, 0, paramInt2 - j, 0, 0);
      }
      return i + paramInt1 - paramInt2;
    }
  }
  
  public int getPosition()
  {
    return this.a.getCurrX();
  }
  
  public void iJ(boolean paramBoolean)
  {
    this.Ui = paramBoolean;
  }
  
  public boolean isFinished()
  {
    return this.a.isFinished();
  }
  
  public void lt(int paramInt)
  {
    this.mOverflingDistance = Math.max(paramInt, this.mOverflingDistance);
  }
  
  public void setPosition(int paramInt)
  {
    this.a.startScroll(paramInt, 0, 0, 0, 0);
    this.a.abortAnimation();
  }
  
  public void z(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = getPosition();
    iqx localiqx = this.a;
    if (this.Ui) {}
    for (int i = this.mOverflingDistance;; i = 0)
    {
      localiqx.fling(j, 0, paramInt1, 0, paramInt2, paramInt3, 0, 0, i, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iqz
 * JD-Core Version:    0.7.0.1
 */