package cooperation.vip.ar.controller;

import asge.a;
import asgf;
import awlb;

public class VipQGThreeController$1
  implements Runnable
{
  public VipQGThreeController$1(awlb paramawlb) {}
  
  public void run()
  {
    if (asgf.loadSo("VipQGThreeController load QG So")) {
      awlb.a(this.this$0).onSuccess();
    }
    asgf.b("1018", true, awlb.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.vip.ar.controller.VipQGThreeController.1
 * JD-Core Version:    0.7.0.1
 */