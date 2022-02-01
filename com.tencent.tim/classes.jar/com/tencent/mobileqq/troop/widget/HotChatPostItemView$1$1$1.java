package com.tencent.mobileqq.troop.widget;

import android.graphics.Bitmap;
import android.util.Pair;
import android.widget.ImageView;
import apuy;

class HotChatPostItemView$1$1$1
  implements Runnable
{
  HotChatPostItemView$1$1$1(HotChatPostItemView.1.1 param1, Pair paramPair) {}
  
  public void run()
  {
    if ((this.a.this$0.val$imageView.getTag() instanceof String))
    {
      String str = (String)this.a.this$0.val$imageView.getTag();
      if ((this.q != null) && (str.endsWith(this.a.this$0.val$imageUrl)))
      {
        this.a.this$0.val$imageView.setImageBitmap((Bitmap)this.q.first);
        HotChatPostItemView.A(this.a.this$0.val$imageUrl, (Bitmap)this.q.first);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.HotChatPostItemView.1.1.1
 * JD-Core Version:    0.7.0.1
 */