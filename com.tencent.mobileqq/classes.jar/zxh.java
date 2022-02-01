import java.lang.ref.WeakReference;

public class zxh
  implements zzq
{
  private WeakReference<zxg> a;
  
  zxh(zxg paramzxg)
  {
    this.a = new WeakReference(paramzxg);
  }
  
  public void a(Object[] paramArrayOfObject)
  {
    if (this.a != null)
    {
      zxg localzxg = (zxg)this.a.get();
      if (localzxg != null) {
        localzxg.a(paramArrayOfObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zxh
 * JD-Core Version:    0.7.0.1
 */