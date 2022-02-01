package com.tencent.av.ui;

import com.tencent.av.VideoController;
import iiv;
import iya;

class AVActivity$12
  implements Runnable
{
  AVActivity$12(AVActivity paramAVActivity, long paramLong) {}
  
  public void run()
  {
    if (this.this$0.a == null) {}
    iiv localiiv;
    do
    {
      return;
      localiiv = this.this$0.a.b();
    } while (!localiiv.sU());
    this.this$0.a.O(localiiv.peerUin, 229);
    this.this$0.a.ko(229);
    int i = localiiv.amI;
    this.this$0.a.P(localiiv.peerUin, 21);
    if (i == 1)
    {
      localiiv.e(this.kQ, "av.onResume.1", 3);
      if (!localiiv.sV()) {
        break label158;
      }
    }
    label158:
    for (localiiv.uinType = 1;; localiiv.uinType = 3000)
    {
      localiiv.o(this.kQ, false);
      localiiv.aa("AVActivity.onResume", 0);
      this.this$0.b.cE(this.kQ);
      return;
      if (i != 2) {
        break;
      }
      localiiv.e(this.kQ, "av.onResume.2", 4);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.12
 * JD-Core Version:    0.7.0.1
 */