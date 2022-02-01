package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.widget.BubbleImageView;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import xqa;

public class TroopGiftMsgItemBuilder$4
  implements Runnable
{
  public TroopGiftMsgItemBuilder$4(xqa paramxqa, String paramString1, BubbleImageView paramBubbleImageView, String paramString2, int paramInt) {}
  
  public void run()
  {
    Object localObject = (List)this.this$0.hQ.get(this.aVT);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Runnable)((Iterator)localObject).next()).run();
      }
    }
    this.this$0.hQ.remove(this.aVT);
    xqa.a(this.this$0, this.k, this.aVS, this.TJ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder.4
 * JD-Core Version:    0.7.0.1
 */