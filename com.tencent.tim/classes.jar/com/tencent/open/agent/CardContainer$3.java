package com.tencent.open.agent;

import android.graphics.drawable.Drawable;
import android.os.Message;
import aols;
import com.tencent.image.URLDrawable;

class CardContainer$3
  implements Runnable
{
  CardContainer$3(CardContainer paramCardContainer) {}
  
  public void run()
  {
    Object localObject = this.this$0.Dc();
    this.this$0.mDrawable = Drawable.createFromPath(aols.lE((String)localObject));
    if (this.this$0.mDrawable != null) {
      Message.obtain(this.this$0.mHandler, 10001).sendToTarget();
    }
    do
    {
      return;
      localObject = CardContainer.a(this.this$0, (String)localObject);
    } while ((localObject == null) || (((URLDrawable)localObject).getStatus() != 1));
    this.this$0.mDrawable = ((Drawable)localObject);
    Message.obtain(this.this$0.mHandler, 10001).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.CardContainer.3
 * JD-Core Version:    0.7.0.1
 */