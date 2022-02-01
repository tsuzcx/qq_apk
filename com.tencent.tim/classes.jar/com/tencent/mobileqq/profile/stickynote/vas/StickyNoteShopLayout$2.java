package com.tencent.mobileqq.profile.stickynote.vas;

import QC.GetSuixintieSigFontRsp;
import android.os.Handler;
import aqhq;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.app.ThreadManagerV2;

class StickyNoteShopLayout$2
  implements Runnable
{
  StickyNoteShopLayout$2(StickyNoteShopLayout paramStickyNoteShopLayout) {}
  
  public void run()
  {
    byte[] arrayOfByte = aqhq.readFile(StickyNoteShopLayout.CACHE_PATH + '_' + StickyNoteShopLayout.a(this.this$0));
    if (arrayOfByte != null)
    {
      GetSuixintieSigFontRsp localGetSuixintieSigFontRsp = new GetSuixintieSigFontRsp();
      localGetSuixintieSigFontRsp.readFrom(new JceInputStream(arrayOfByte));
      ThreadManagerV2.getUIHandlerV2().post(new StickyNoteShopLayout.2.1(this, localGetSuixintieSigFontRsp));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout.2
 * JD-Core Version:    0.7.0.1
 */