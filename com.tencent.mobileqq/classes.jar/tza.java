import java.lang.ref.WeakReference;

public class tza
  implements yfu
{
  private WeakReference<tyz> a;
  
  tza(tyz paramtyz)
  {
    this.a = new WeakReference(paramtyz);
  }
  
  public void a(Object[] paramArrayOfObject)
  {
    if (this.a != null)
    {
      tyz localtyz = (tyz)this.a.get();
      if (localtyz != null) {
        localtyz.a(paramArrayOfObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tza
 * JD-Core Version:    0.7.0.1
 */