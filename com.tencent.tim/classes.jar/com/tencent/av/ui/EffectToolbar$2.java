package com.tencent.av.ui;

import com.tencent.qphone.base.util.QLog;
import ikl;

class EffectToolbar$2
  implements Runnable
{
  EffectToolbar$2(EffectToolbar paramEffectToolbar, String paramString, long paramLong) {}
  
  public void run()
  {
    if (EffectToolbar.access$200(this.this$0) != null)
    {
      QLog.w("EffectToolbar", 1, "postSetCurrentItemById, id[" + this.val$id + "], seq[" + this.kQ + "]");
      EffectToolbar.access$200(this.this$0).d(this.kQ, this.val$id);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.EffectToolbar.2
 * JD-Core Version:    0.7.0.1
 */