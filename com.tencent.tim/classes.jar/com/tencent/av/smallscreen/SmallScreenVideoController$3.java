package com.tencent.av.smallscreen;

import com.tencent.av.VideoController;
import iiv;
import ivz;
import iya;

public class SmallScreenVideoController$3
  implements Runnable
{
  public SmallScreenVideoController$3(ivz paramivz, long paramLong) {}
  
  public void run()
  {
    if (this.this$0.a == null) {
      break label10;
    }
    label10:
    while (this.this$0.a.b() == null) {
      return;
    }
    int i;
    if (this.this$0.a.b().sU())
    {
      this.this$0.a.O(this.this$0.a.b().peerUin, 226);
      this.this$0.a.ko(226);
      i = this.this$0.a.b().amI;
      this.this$0.a.P(this.this$0.a.b().peerUin, 21);
      if (i != 1) {
        break label290;
      }
      this.this$0.a.b().e(this.kQ, "small.onResume.1", 3);
      label143:
      if (!this.this$0.a.b().sV()) {
        break label318;
      }
    }
    label290:
    label318:
    for (this.this$0.a.b().uinType = 1;; this.this$0.a.b().uinType = 3000)
    {
      this.this$0.a.b().o(this.kQ, false);
      this.this$0.a.b().aa("SmallScreen.onResume", 0);
      if ((this.this$0.a.b().PZ) && (this.this$0.a.b().Rk) && (this.this$0.a.b().ann > 0)) {
        ivz.a(this.this$0);
      }
      if (this.this$0.a.b().amI != 2) {
        break;
      }
      this.this$0.b.ars();
      return;
      if (i != 2) {
        break label143;
      }
      this.this$0.a.b().e(this.kQ, "small.onResume.2", 4);
      break label143;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoController.3
 * JD-Core Version:    0.7.0.1
 */