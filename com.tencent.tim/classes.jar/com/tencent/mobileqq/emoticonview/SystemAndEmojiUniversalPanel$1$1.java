package com.tencent.mobileqq.emoticonview;

import afqq;
import afqt;
import java.util.List;

public class SystemAndEmojiUniversalPanel$1$1
  implements Runnable
{
  SystemAndEmojiUniversalPanel$1$1(SystemAndEmojiUniversalPanel.1 param1, List paramList) {}
  
  public void run()
  {
    SystemAndEmojiUniversalPanel.a(this.a.this$0).setOnScrollListener(new afqt(this));
    if (this.Ar != null) {
      SystemAndEmojiUniversalPanel.a(this.a.this$0).setData(this.Ar);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel.1.1
 * JD-Core Version:    0.7.0.1
 */