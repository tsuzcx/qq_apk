package com.tencent.mobileqq.activity.aio.stickerrecommended;

import java.util.List;
import yhf;
import yhf.a;

public class StickerRecManager$2
  implements Runnable
{
  public StickerRecManager$2(yhf paramyhf, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    String str = this.this$0.hE(this.aXL);
    yhf.a(this.this$0, this.bmF, str);
    if ((yhf.a(this.this$0) != null) && (!yhf.a(this.this$0).isEmpty())) {
      yhf.a(this.this$0).a(yhf.a(this.this$0), str, "999", 0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager.2
 * JD-Core Version:    0.7.0.1
 */