package com.tencent.ttpic.module_switchface;

import com.tencent.qphone.base.util.QLog;
import iwl;
import java.util.List;

class SwitchFaceProcessor$1
  implements Runnable
{
  SwitchFaceProcessor$1(SwitchFaceProcessor paramSwitchFaceProcessor, List paramList1, int paramInt1, int paramInt2, List paramList2, int paramInt3, int paramInt4) {}
  
  public void run()
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("SwitchFaceProcessor", 2, "WL_DEBUG process run start");
    }
    SwitchFaceProcessor.access$000(this.this$0)[0].a(this.val$mFacePoint1, this.val$mWidth1, this.val$mHeight1);
    SwitchFaceProcessor.access$000(this.this$0)[1].a(this.val$mFacePoint2, this.val$mWidth2, this.val$mHeight2);
    int i = 0;
    while (i < SwitchFaceProcessor.access$000(this.this$0).length)
    {
      SwitchFaceProcessor.access$000(this.this$0)[i].arA();
      i += 1;
    }
    SwitchFaceProcessor.access$100(this.this$0);
    if (QLog.isColorLevel())
    {
      i = j;
      while (i < SwitchFaceProcessor.access$000(this.this$0).length)
      {
        QLog.d("SwitchFaceProcessor", 2, "WL_DEBUG process run mSwitchFaceItem[" + i + "].mUser = (" + SwitchFaceProcessor.access$000(this.this$0)[i].hA + ", " + SwitchFaceProcessor.access$000(this.this$0)[i].hB + ", " + SwitchFaceProcessor.access$000(this.this$0)[i].hC + ")");
        QLog.d("SwitchFaceProcessor", 2, "WL_DEBUG process run mSwitchFaceItem[" + i + "].mDiff = (" + SwitchFaceProcessor.access$000(this.this$0)[i].hD + ", " + SwitchFaceProcessor.access$000(this.this$0)[i].hE + ", " + SwitchFaceProcessor.access$000(this.this$0)[i].hF + ")");
        i += 1;
      }
      QLog.d("SwitchFaceProcessor", 2, "WL_DEBUG process run end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.module_switchface.SwitchFaceProcessor.1
 * JD-Core Version:    0.7.0.1
 */