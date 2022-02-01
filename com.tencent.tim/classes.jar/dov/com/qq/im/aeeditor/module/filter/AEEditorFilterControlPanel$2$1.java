package dov.com.qq.im.aeeditor.module.filter;

import axmq;

public class AEEditorFilterControlPanel$2$1
  implements Runnable
{
  public AEEditorFilterControlPanel$2$1(axmq paramaxmq, boolean paramBoolean) {}
  
  public void run()
  {
    AEEditorFilterControlPanel.a(this.a.b);
    if (this.val$isSuccess)
    {
      if (AEEditorFilterControlPanel.a(this.a.b) != null) {
        AEEditorFilterControlPanel.a(this.a.b).a(this.a.val$position, this.a.val$lutPath, this.a.d.getDefaultAlpha(), this.a.d);
      }
      this.a.b.select(this.a.val$position);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel.2.1
 * JD-Core Version:    0.7.0.1
 */