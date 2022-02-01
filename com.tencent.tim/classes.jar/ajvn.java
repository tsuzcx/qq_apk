import com.tencent.mobileqq.nearby.now.view.SplitedProgressBar;
import java.security.InvalidParameterException;

public class ajvn
{
  private SplitedProgressBar a;
  
  public ajvn(SplitedProgressBar paramSplitedProgressBar)
  {
    if (paramSplitedProgressBar == null) {
      throw new InvalidParameterException("ProgressControler: progressBar is null");
    }
    this.a = paramSplitedProgressBar;
  }
  
  public void Mr(boolean paramBoolean)
  {
    SplitedProgressBar localSplitedProgressBar = this.a;
    if (paramBoolean) {}
    for (int i = 8;; i = 0)
    {
      localSplitedProgressBar.setVisibility(i);
      return;
    }
  }
  
  public void iP(int paramInt1, int paramInt2)
  {
    if (paramInt1 < this.a.mTotalCount) {
      this.a.setProgress(paramInt1, paramInt2);
    }
  }
  
  public void setShowMaxCount(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    this.a.setShowMaxCount(paramInt);
  }
  
  public void setTotalCount(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    this.a.setTotalCount(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajvn
 * JD-Core Version:    0.7.0.1
 */