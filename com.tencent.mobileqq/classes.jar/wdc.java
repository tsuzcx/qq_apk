import android.support.annotation.Nullable;
import java.lang.ref.WeakReference;

class wdc
{
  private WeakReference<wdb> a;
  
  public wdc(wdb paramwdb)
  {
    this.a = new WeakReference(paramwdb);
  }
  
  @Nullable
  public wdb a()
  {
    return (wdb)this.a.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wdc
 * JD-Core Version:    0.7.0.1
 */