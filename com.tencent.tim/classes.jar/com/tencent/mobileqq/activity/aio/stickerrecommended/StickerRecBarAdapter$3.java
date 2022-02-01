package com.tencent.mobileqq.activity.aio.stickerrecommended;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import java.util.List;
import ygr;
import yhf;

public class StickerRecBarAdapter$3
  implements Runnable
{
  public StickerRecBarAdapter$3(ygr paramygr, List paramList1, List paramList2) {}
  
  public void run()
  {
    yhf localyhf = yhf.a(ygr.a(this.this$0));
    if (ygr.a(this.this$0) == null) {
      localyhf.a(this.sz, false, 0, null);
    }
    for (;;)
    {
      localyhf.gB(this.sz);
      ygr.a(this.this$0).gA(this.sA);
      return;
      localyhf.a(this.sz, true, ygr.a(this.this$0).cZ, ygr.a(this.this$0).aTl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecBarAdapter.3
 * JD-Core Version:    0.7.0.1
 */