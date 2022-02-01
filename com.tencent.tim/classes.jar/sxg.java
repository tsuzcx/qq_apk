import java.util.ArrayList;

public abstract class sxg
  implements sxv
{
  protected long animationDuring = 350L;
  public boolean isRectAnimation = true;
  public boolean jumpToPhotoList;
  protected ArrayList<sxv> listeners = new ArrayList();
  protected boolean mIsAnimating;
  
  public void a(sxv paramsxv)
  {
    if (!this.listeners.contains(paramsxv)) {
      this.listeners.add(paramsxv);
    }
  }
  
  public long getAnimationDuring()
  {
    return this.animationDuring;
  }
  
  public boolean isAnimating()
  {
    return this.mIsAnimating;
  }
  
  public void resetAnimationDuring()
  {
    this.animationDuring = 350L;
  }
  
  public abstract boolean startEnterAnimation();
  
  public abstract boolean startExitAnimation();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     sxg
 * JD-Core Version:    0.7.0.1
 */