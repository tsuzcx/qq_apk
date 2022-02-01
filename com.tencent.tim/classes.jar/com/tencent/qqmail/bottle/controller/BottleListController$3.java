package com.tencent.qqmail.bottle.controller;

class BottleListController$3
  implements Runnable
{
  BottleListController$3(BottleListController paramBottleListController, BottleListCursor paramBottleListCursor) {}
  
  public void run()
  {
    if (this.val$cursor == null) {
      if (BottleListController.access$100(this.this$0).mSettings.getListSvnTime() == 0L) {
        BottleListController.access$300(this.this$0, this.val$cursor, true, BottleListController.access$200(this.this$0));
      }
    }
    BottleListCursor localBottleListCursor;
    do
    {
      return;
      localBottleListCursor = BottleListController.access$400(this.this$0);
      BottleListController.access$500(this.this$0, localBottleListCursor);
      BottleListController.access$300(this.this$0, localBottleListCursor, true, BottleListController.access$200(this.this$0));
      return;
      localBottleListCursor = BottleListController.access$400(this.this$0);
      if (BottleListController.access$600(this.this$0, localBottleListCursor, this.val$cursor)) {
        BottleListController.access$500(this.this$0, localBottleListCursor);
      }
    } while (!BottleListController.access$700(this.this$0, localBottleListCursor));
    BottleListController.access$300(this.this$0, localBottleListCursor, true, BottleListController.access$200(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.controller.BottleListController.3
 * JD-Core Version:    0.7.0.1
 */