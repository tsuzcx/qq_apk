package com.tencent.mobileqq.scribble;

import amiy;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.qphone.base.util.QLog;

public class ScribbleBaseOperator$1
  implements Runnable
{
  public ScribbleBaseOperator$1(amiy paramamiy, MessageForScribble paramMessageForScribble) {}
  
  public void run()
  {
    this.this$0.mApp.b().b(this.b, this.this$0.mApp.getCurrentAccountUin());
    this.this$0.a(this.b, this.b.localFildPath, null);
    QLog.i("SCRIBBLEMSG", 2, "!!!addMessage uniseq:" + this.b.uniseq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.ScribbleBaseOperator.1
 * JD-Core Version:    0.7.0.1
 */