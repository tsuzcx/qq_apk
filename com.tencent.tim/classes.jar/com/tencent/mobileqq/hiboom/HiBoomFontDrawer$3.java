package com.tencent.mobileqq.hiboom;

import ahxp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class HiBoomFontDrawer$3
  implements Runnable
{
  public HiBoomFontDrawer$3(ahxp paramahxp) {}
  
  public void run()
  {
    if (this.this$0.xh == null) {
      return;
    }
    int i = 0;
    label13:
    HiBoomTextView localHiBoomTextView;
    if (i < this.this$0.xh.size())
    {
      localHiBoomTextView = (HiBoomTextView)((WeakReference)this.this$0.xh.get(i)).get();
      if ((localHiBoomTextView != null) && (localHiBoomTextView.dbW == this.this$0.mFontId)) {
        break label89;
      }
      this.this$0.xh.remove(i);
      i -= 1;
    }
    for (;;)
    {
      i += 1;
      break label13;
      break;
      label89:
      localHiBoomTextView.refresh();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomFontDrawer.3
 * JD-Core Version:    0.7.0.1
 */