package com.tencent.mobileqq.emoticonview;

import afno;
import afoo;
import java.util.List;

public class EmoticonPanelSystemAndEmojiHelper$1
  implements Runnable
{
  public EmoticonPanelSystemAndEmojiHelper$1(afno paramafno) {}
  
  public void run()
  {
    List localList = this.this$0.a.zZ;
    int i;
    afoo localafoo;
    if (localList != null)
    {
      i = 0;
      if (i < localList.size())
      {
        localafoo = (afoo)localList.get(i);
        if ((localafoo == null) || (localafoo.type != 7)) {}
      }
    }
    for (;;)
    {
      if ((localafoo != null) && (this.this$0.a.a != null)) {
        this.this$0.a.a.d(localafoo);
      }
      return;
      i += 1;
      break;
      localafoo = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelSystemAndEmojiHelper.1
 * JD-Core Version:    0.7.0.1
 */