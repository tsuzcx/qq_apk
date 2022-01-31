import android.support.annotation.Nullable;
import java.lang.ref.WeakReference;

class upb
{
  private WeakReference<upa> a;
  
  public upb(upa paramupa)
  {
    this.a = new WeakReference(paramupa);
  }
  
  @Nullable
  public upa a()
  {
    return (upa)this.a.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     upb
 * JD-Core Version:    0.7.0.1
 */