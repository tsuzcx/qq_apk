import android.support.annotation.Nullable;
import java.lang.ref.WeakReference;

class uks
{
  private WeakReference<ukr> a;
  
  public uks(ukr paramukr)
  {
    this.a = new WeakReference(paramukr);
  }
  
  @Nullable
  public ukr a()
  {
    return (ukr)this.a.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uks
 * JD-Core Version:    0.7.0.1
 */