package com.tencent.ark;

class ArkViewImplement$7
  implements Runnable
{
  ArkViewImplement$7(ArkViewImplement paramArkViewImplement, int paramInt, String paramString) {}
  
  public void run()
  {
    if (ArkViewImplement.access$000(this.this$0) == null) {
      return;
    }
    switch (this.val$inputComand)
    {
    default: 
      return;
    case 1: 
      ArkViewImplement.access$000(this.this$0).InputSelect();
      return;
    case 2: 
      ArkViewImplement.access$000(this.this$0).InputSelectAll();
      return;
    case 3: 
      ArkViewImplement.access$000(this.this$0).InputInsertText(this.val$arkPasteData);
      return;
    case 4: 
      str = ArkViewImplement.access$000(this.this$0).InputGetSelectText();
      ArkDispatchTask.getInstance().postToMainThread(new ArkViewImplement.7.1(this, str));
      return;
    }
    String str = ArkViewImplement.access$000(this.this$0).InputGetSelectText();
    ArkDispatchTask.getInstance().postToMainThread(new ArkViewImplement.7.2(this, str));
    ArkViewImplement.access$000(this.this$0).InputDeleteBackward();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.ark.ArkViewImplement.7
 * JD-Core Version:    0.7.0.1
 */