import java.lang.ref.WeakReference;

public abstract class uiv
{
  private WeakReference<uix> a;
  
  public uiv(uix paramuix)
  {
    this.a = new WeakReference(paramuix);
  }
  
  public boolean a()
  {
    if ((this.a == null) || (this.a.get() == null)) {
      return false;
    }
    return a((uix)this.a.get());
  }
  
  public abstract boolean a(uix paramuix);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uiv
 * JD-Core Version:    0.7.0.1
 */