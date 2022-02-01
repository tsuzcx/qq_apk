package com.tencent.mobileqq.emoticonview;

import afnh;
import afoo;
import java.util.List;

public class EmoticonPanelMallHelper$5
  implements Runnable
{
  public EmoticonPanelMallHelper$5(afnh paramafnh) {}
  
  public void run()
  {
    List localList = this.this$0.a.zZ;
    afoo localafoo;
    int i;
    if (localList != null)
    {
      localafoo = null;
      i = 0;
      int j = localList.size();
      if (i >= j) {
        break label107;
      }
      localafoo = (afoo)localList.get(i);
      if ((localafoo == null) || (localafoo.type != 9)) {
        break label65;
      }
    }
    for (;;)
    {
      if (i == -1) {}
      label65:
      while ((EmoticonPanelController.cSe != i) || (this.this$0.a.a == null))
      {
        return;
        i += 1;
        break;
      }
      this.this$0.a.a.d(localafoo);
      return;
      label107:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.5
 * JD-Core Version:    0.7.0.1
 */