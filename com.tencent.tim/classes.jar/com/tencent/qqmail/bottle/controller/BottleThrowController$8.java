package com.tencent.qqmail.bottle.controller;

class BottleThrowController$8
  implements Runnable
{
  BottleThrowController$8(BottleThrowController paramBottleThrowController, String paramString1, String paramString2) {}
  
  public void run()
  {
    BottleThrowController_UnsendConversationDataCursorAdapterORM localBottleThrowController_UnsendConversationDataCursorAdapterORM = new BottleThrowController_UnsendConversationDataCursorAdapterORM(BottleThrowController.access$200(this.this$0).mDBOpenHelper.getReadableDatabase(), "FROM bottleconv LEFT JOIN bottlethrow ON bottleconv.bottleid=bottlethrow.bottleid WHERE bottleconv.bottleid=? AND bottleconv.unsend=2 AND bottleconv.msgid=?", new String[] { this.val$bottleId, this.val$msgId });
    if (localBottleThrowController_UnsendConversationDataCursorAdapterORM.getCount() == 1) {}
    for (BottleThrowController.UnsendConversationData localUnsendConversationData = localBottleThrowController_UnsendConversationDataCursorAdapterORM.getItem(0);; localUnsendConversationData = null)
    {
      localBottleThrowController_UnsendConversationDataCursorAdapterORM.close();
      if (localUnsendConversationData != null) {
        BottleThrowController.access$800(this.this$0, this.val$bottleId, this.val$msgId, localUnsendConversationData.content, localUnsendConversationData.geo, localUnsendConversationData.city);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleThrowController.8
 * JD-Core Version:    0.7.0.1
 */