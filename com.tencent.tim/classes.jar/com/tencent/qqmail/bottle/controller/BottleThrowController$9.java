package com.tencent.qqmail.bottle.controller;

class BottleThrowController$9
  implements Runnable
{
  BottleThrowController$9(BottleThrowController paramBottleThrowController, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    String str = BottleThrowController.access$900(this.this$0, this.val$bottleId, this.val$content, this.val$geo, this.val$cityname);
    BottleThrowController.access$1000(this.this$0, this.val$bottleId, str, true, BottleThrowController.isUnsendBottleId(this.val$bottleId));
    BottleThrowController.access$800(this.this$0, this.val$bottleId, str, this.val$content, this.val$geo, this.val$cityname);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleThrowController.9
 * JD-Core Version:    0.7.0.1
 */