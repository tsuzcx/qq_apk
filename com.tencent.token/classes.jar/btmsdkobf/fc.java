package btmsdkobf;

import java.util.ArrayList;
import java.util.List;

class fc
  implements Runnable
{
  fc(bk parambk) {}
  
  public void run()
  {
    x localx = null;
    synchronized (bk.d(this.a))
    {
      if (bk.e(this.a).size() > 0)
      {
        localx = new x();
        localx.aW = new ArrayList(bk.e(this.a));
        bk.e(this.a).clear();
      }
      if ((localx != null) && (localx.aW != null)) {
        bk.c(this.a).a(21, localx, new af(), 2, new fd(this), 0L);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.fc
 * JD-Core Version:    0.7.0.1
 */