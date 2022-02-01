package com.tencent.tavcut.session;

import android.util.SparseArray;
import com.tencent.tavcut.bean.TextEditorData;

class TAVCutSession$16
  implements Runnable
{
  TAVCutSession$16(TAVCutSession paramTAVCutSession, TextEditorData paramTextEditorData) {}
  
  public void run()
  {
    int i = 0;
    while (i < this.this$0.stickerControllers.size())
    {
      int j = this.this$0.stickerControllers.keyAt(i);
      this.this$0.runOnMainThread(new TAVCutSession.16.1(this, j), true);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutSession.16
 * JD-Core Version:    0.7.0.1
 */