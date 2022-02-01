import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

class vnt
  implements Observer<vbf>
{
  vnt(vnp paramvnp) {}
  
  public void a(@Nullable vbf paramvbf)
  {
    if ((paramvbf != null) && (vnp.a(this.a) != null))
    {
      vnp.a(this.a, paramvbf);
      if (vnp.a(this.a)) {
        break label41;
      }
      vnp.b(this.a, paramvbf);
    }
    label41:
    while (vnp.a(this.a) == null) {
      return;
    }
    vnp.a(this.a).clearData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vnt
 * JD-Core Version:    0.7.0.1
 */