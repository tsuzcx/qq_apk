package dov.com.qq.im.ae.play;

import axbq;
import axgv;
import java.util.List;

public class AEPlayShowPart$6
  implements Runnable
{
  public AEPlayShowPart$6(axgv paramaxgv, String paramString, int paramInt) {}
  
  public void run()
  {
    if ("".equals(this.cUo)) {
      axgv.a(this.this$0, 0);
    }
    for (;;)
    {
      return;
      List localList = axgv.a(this.this$0).hQ();
      if (localList != null)
      {
        int i = 0;
        while (i < localList.size())
        {
          axbq localaxbq = (axbq)localList.get(i);
          if ((localaxbq != null) && (this.cUo != null) && (this.cUo.equals(localaxbq.categoryName)))
          {
            axgv.a(this.this$0, i);
            if (axgv.a(this.this$0).a() != null) {
              axgv.a(this.this$0).a().Nq(this.val$scrollY);
            }
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AEPlayShowPart.6
 * JD-Core Version:    0.7.0.1
 */