package dov.com.qq.im.capture.text;

import android.view.View;

class DynamicTextItem$2
  implements Runnable
{
  DynamicTextItem$2(DynamicTextItem paramDynamicTextItem, boolean paramBoolean, View paramView, Runnable paramRunnable) {}
  
  public void run()
  {
    DynamicTextItem.a locala;
    if (((Boolean)DynamicTextItem.a(this.this$0).second).booleanValue() != this.dwH)
    {
      locala = DynamicTextItem.a(this.this$0);
      if (((Boolean)DynamicTextItem.a(this.this$0).second).booleanValue()) {
        break label93;
      }
    }
    label93:
    for (boolean bool = true;; bool = false)
    {
      locala.second = Boolean.valueOf(bool);
      this.val$container.invalidate();
      if (this.val$runnable != null) {
        this.val$runnable.run();
      }
      DynamicTextItem.a(this.this$0, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.text.DynamicTextItem.2
 * JD-Core Version:    0.7.0.1
 */