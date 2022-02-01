package com.tencent.mobileqq.avatar.dynamicavatar;

import advr;
import aqcy;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.util.WeakReference;

public class DynamicAvatarManager$7
  implements Runnable
{
  public DynamicAvatarManager$7(advr paramadvr, aqcy paramaqcy) {}
  
  public void run()
  {
    for (;;)
    {
      int i;
      synchronized (this.this$0.uT)
      {
        if (!this.this$0.uT.remove(this.a.bc)) {
          return;
        }
        i = this.this$0.uT.size() - 1;
        if (i >= 0)
        {
          if (((WeakReference)this.this$0.uT.get(i)).get() != null) {
            break label226;
          }
          this.this$0.uT.remove(i);
          break label226;
        }
        i = this.this$0.uU.size() - 1;
        if (i >= 0)
        {
          WeakReference localWeakReference = (WeakReference)this.this$0.uU.remove(i);
          if ((localWeakReference == null) || (localWeakReference.get() == null) || (this.this$0.uT.contains(localWeakReference))) {
            break label233;
          }
          boolean bool = this.this$0.a((aqcy)localWeakReference.get());
          if (QLog.isColorLevel()) {
            QLog.i("Q.dynamicAvatar", 2, "onPlayFinished to play. result : " + bool);
          }
          if (bool) {
            this.this$0.uT.add(localWeakReference);
          }
          return;
        }
      }
      return;
      label226:
      i -= 1;
      continue;
      label233:
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager.7
 * JD-Core Version:    0.7.0.1
 */