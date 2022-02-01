import java.lang.ref.WeakReference;

public abstract class uig
{
  private WeakReference<uii> a;
  
  public uig(uii paramuii)
  {
    this.a = new WeakReference(paramuii);
  }
  
  public boolean a()
  {
    if ((this.a == null) || (this.a.get() == null)) {
      return false;
    }
    return a((uii)this.a.get());
  }
  
  public abstract boolean a(uii paramuii);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uig
 * JD-Core Version:    0.7.0.1
 */