package dov.com.qq.im.capture.text;

import android.view.View;

class DynamicTextItem$1
  implements Runnable
{
  DynamicTextItem$1(DynamicTextItem paramDynamicTextItem, View paramView) {}
  
  public void run()
  {
    DynamicTextItem.a locala = DynamicTextItem.a(this.this$0);
    if (!((Boolean)DynamicTextItem.a(this.this$0).second).booleanValue()) {}
    for (boolean bool = true;; bool = false)
    {
      locala.second = Boolean.valueOf(bool);
      this.val$container.invalidate();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.text.DynamicTextItem.1
 * JD-Core Version:    0.7.0.1
 */