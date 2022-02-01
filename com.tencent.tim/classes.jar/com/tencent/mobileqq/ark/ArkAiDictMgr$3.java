package com.tencent.mobileqq.ark;

import adpo;
import adpo.a;
import com.tencent.common.app.AppInterface;
import com.tencent.wordsegment.WordSegment;

public final class ArkAiDictMgr$3
  implements Runnable
{
  public ArkAiDictMgr$3(AppInterface paramAppInterface, adpo.a parama, String paramString) {}
  
  public void run()
  {
    adpo.n(this.b);
    if (adpo.afq())
    {
      this.a.success = true;
      this.a.es = WordSegment.segment(this.val$text);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiDictMgr.3
 * JD-Core Version:    0.7.0.1
 */