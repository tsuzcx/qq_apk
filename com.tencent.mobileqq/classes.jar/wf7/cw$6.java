package wf7;

import com.tencent.qqpimsecure.wificore.api.event.CurrentSessionItem;
import com.tencent.qqpimsecure.wificore.api.event.a;

class cw$6
  implements a
{
  cw$6(cw paramcw) {}
  
  public void a(CurrentSessionItem paramCurrentSessionItem)
  {
    if (paramCurrentSessionItem.isConnected()) {
      if (cw.a(this.iJ).bx().jp) {
        this.iJ.a(-1L, 3, null);
      }
    }
    while ((!bu.ap()) || (!cw.a(this.iJ).bx().jo)) {
      return;
    }
    this.iJ.a(-1L, 9, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.cw.6
 * JD-Core Version:    0.7.0.1
 */