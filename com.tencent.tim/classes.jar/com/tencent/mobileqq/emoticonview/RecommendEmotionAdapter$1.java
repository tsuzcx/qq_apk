package com.tencent.mobileqq.emoticonview;

import afqc;
import afqc.a;
import aqpi.b;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class RecommendEmotionAdapter$1
  implements Runnable
{
  public RecommendEmotionAdapter$1(afqc paramafqc, afqc.a parama) {}
  
  public void run()
  {
    for (int i = 1;; i = -1) {
      synchronized (this.this$0.dB)
      {
        File localFile = VasQuickUpdateManager.getFileFromLocal(this.this$0.app, 1003L, "emotionRecommendEffect", null, this.this$0.cT.compareAndSet(false, true), this.this$0.callBacker);
        if (localFile == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RecommendEmotionAdapter", 2, "emoticon Effect effectFile = null, id:" + this.a.b.id + ", index:" + this.a.index);
          }
          if (this.this$0.wm == null) {
            this.this$0.wm = new ArrayList();
          }
          if (this.this$0.wm.size() <= 0) {
            continue;
          }
          i = ((afqc.a)this.this$0.wm.get(0)).index;
          if (this.a.index < i)
          {
            this.this$0.wm.add(0, this.a);
            i = 0;
          }
        }
        else
        {
          if (i != 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("RecommendEmotionAdapter", 2, "emoticon Effect postShow, id:" + this.a.b.id + ", index:" + this.a.index);
            }
            this.a.av = localFile;
            this.this$0.q.sendMessage(this.this$0.q.obtainMessage(102, this.a));
          }
          return;
        }
        this.this$0.wm.add(this.a);
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.RecommendEmotionAdapter.1
 * JD-Core Version:    0.7.0.1
 */