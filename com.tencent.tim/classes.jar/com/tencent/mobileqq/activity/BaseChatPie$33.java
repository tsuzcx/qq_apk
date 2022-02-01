package com.tencent.mobileqq.activity;

import com.tencent.imcore.message.QQMessageFacade.b;

class BaseChatPie$33
  implements Runnable
{
  BaseChatPie$33(BaseChatPie paramBaseChatPie, QQMessageFacade.b paramb) {}
  
  public void run()
  {
    if (this.c.aQi)
    {
      if (this.c.isSuccess)
      {
        this.this$0.refresh(131079);
        return;
      }
      this.this$0.refresh(131078);
      return;
    }
    this.this$0.refresh(131076);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.33
 * JD-Core Version:    0.7.0.1
 */