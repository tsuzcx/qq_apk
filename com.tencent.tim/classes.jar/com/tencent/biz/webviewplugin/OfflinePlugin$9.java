package com.tencent.biz.webviewplugin;

import android.widget.LinearLayout;
import android.widget.ProgressBar;
import java.util.HashMap;
import obe;
import stw;

public class OfflinePlugin$9
  implements Runnable
{
  public OfflinePlugin$9(stw paramstw) {}
  
  public void run()
  {
    if (stw.fZ != null)
    {
      obe localobe = (obe)stw.fZ.get(stw.a(this.this$0));
      if ((localobe != null) && (localobe.getStatus() == 1))
      {
        if (this.this$0.fz != null) {
          this.this$0.fz.setVisibility(8);
        }
        if (this.this$0.I != null) {
          this.this$0.I.setVisibility(0);
        }
        localobe.setStatus(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.OfflinePlugin.9
 * JD-Core Version:    0.7.0.1
 */