import java.lang.ref.WeakReference;

public abstract class upq
{
  private WeakReference<ups> a;
  
  public upq(ups paramups)
  {
    this.a = new WeakReference(paramups);
  }
  
  public boolean a()
  {
    if ((this.a == null) || (this.a.get() == null)) {
      return false;
    }
    return a((ups)this.a.get());
  }
  
  public abstract boolean a(ups paramups);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     upq
 * JD-Core Version:    0.7.0.1
 */