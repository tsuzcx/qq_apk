package btmsdkobf;

import java.util.Iterator;
import java.util.List;

class hc
  implements Runnable
{
  hc(hb paramhb, List paramList, int paramInt, dj paramdj) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      hg localhg = (hg)localIterator.next();
      if (localhg.e == 0)
      {
        eh.e("SharkProtocolQueue", "[shark_push]handle cached push, cmd: " + this.b + " pushId: " + localhg.b);
        db.a(this.d.a, localhg.b, localhg.c, localhg.d, this.c);
      }
      else
      {
        eh.e("SharkProtocolQueue", "[shark_push]handle cached gift, cmd: " + this.b + " pushId: " + localhg.b);
        db.b(this.d.a, localhg.b, localhg.c, localhg.d, this.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.hc
 * JD-Core Version:    0.7.0.1
 */