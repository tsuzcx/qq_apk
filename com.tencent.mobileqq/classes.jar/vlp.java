import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

class vlp
  implements Observer<uzp>
{
  vlp(vll paramvll) {}
  
  public void a(@Nullable uzp paramuzp)
  {
    if ((paramuzp != null) && (vll.a(this.a) != null))
    {
      vll.a(this.a, paramuzp);
      if (vll.a(this.a)) {
        break label41;
      }
      vll.b(this.a, paramuzp);
    }
    label41:
    while (vll.a(this.a) == null) {
      return;
    }
    vll.a(this.a).clearData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vlp
 * JD-Core Version:    0.7.0.1
 */