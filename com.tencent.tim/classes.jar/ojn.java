import java.lang.ref.WeakReference;

public abstract class ojn
{
  private WeakReference<ojp> cJ;
  
  public ojn(ojp paramojp)
  {
    this.cJ = new WeakReference(paramojp);
  }
  
  public boolean GW()
  {
    if ((this.cJ == null) || (this.cJ.get() == null)) {
      return false;
    }
    return a((ojp)this.cJ.get());
  }
  
  public abstract boolean a(ojp paramojp);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ojn
 * JD-Core Version:    0.7.0.1
 */