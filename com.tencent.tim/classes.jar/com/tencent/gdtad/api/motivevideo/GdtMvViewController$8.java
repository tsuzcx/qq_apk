package com.tencent.gdtad.api.motivevideo;

import abqr;
import android.media.AudioManager;
import tje;

public class GdtMvViewController$8
  implements Runnable
{
  public GdtMvViewController$8(tje paramtje) {}
  
  public void run()
  {
    int i = tje.a(this.this$0).getStreamVolume(3);
    tje localtje;
    if (tje.a(this.this$0) != null)
    {
      localtje = this.this$0;
      if (i > 0) {
        break label74;
      }
    }
    label74:
    for (boolean bool = true;; bool = false)
    {
      localtje.mIsMute = bool;
      tje.a(this.this$0).setMute(this.this$0.mIsMute);
      tje.a(this.this$0, i, tje.b(this.this$0), true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMvViewController.8
 * JD-Core Version:    0.7.0.1
 */