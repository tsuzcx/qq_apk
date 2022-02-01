package com.tencent.mobileqq.activity.aio.stickerbubble;

import java.util.List;
import java.util.Map;
import yga;

class StickerBubbleAnimationView$1
  implements Runnable
{
  StickerBubbleAnimationView$1(StickerBubbleAnimationView paramStickerBubbleAnimationView, yga paramyga) {}
  
  public void run()
  {
    List localList = (List)StickerBubbleAnimationView.a(this.this$0).get(this.a.py());
    if ((localList == null) || (!localList.remove(this.a)))
    {
      localList = (List)StickerBubbleAnimationView.b(this.this$0).get(this.a.py());
      if (localList != null) {
        localList.remove(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView.1
 * JD-Core Version:    0.7.0.1
 */