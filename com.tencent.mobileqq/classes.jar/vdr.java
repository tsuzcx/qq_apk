import java.lang.ref.WeakReference;

public abstract class vdr
{
  private WeakReference<vdt> a;
  
  public vdr(vdt paramvdt)
  {
    this.a = new WeakReference(paramvdt);
  }
  
  public boolean a()
  {
    if ((this.a == null) || (this.a.get() == null)) {
      return false;
    }
    return a((vdt)this.a.get());
  }
  
  public abstract boolean a(vdt paramvdt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vdr
 * JD-Core Version:    0.7.0.1
 */