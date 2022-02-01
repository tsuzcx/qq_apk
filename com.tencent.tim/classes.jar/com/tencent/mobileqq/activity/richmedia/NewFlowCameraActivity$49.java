package com.tencent.mobileqq.activity.richmedia;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import anjg;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureFilterManager;
import java.util.concurrent.atomic.AtomicInteger;

class NewFlowCameraActivity$49
  implements Runnable
{
  NewFlowCameraActivity$49(NewFlowCameraActivity paramNewFlowCameraActivity, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    if ((this.this$0.c != null) && (this.this$0.c.aL.get() != 4))
    {
      if (this.val$type != 0) {
        break label85;
      }
      if (this.val$enable) {
        break label54;
      }
      this.this$0.zW.setVisibility(8);
    }
    label54:
    label85:
    do
    {
      do
      {
        do
        {
          return;
        } while (this.byG);
        this.this$0.zW.setVisibility(0);
        this.this$0.zZ.setVisibility(8);
        return;
      } while (this.val$type != 1);
      if (!this.val$enable)
      {
        this.this$0.zZ.setVisibility(8);
        return;
      }
    } while ((this.byG) || (NewFlowCameraActivity.a(this.this$0)));
    if ((this.this$0.el == null) || (!this.this$0.bdM.equalsIgnoreCase(GestureFilterManager.sGestureType)))
    {
      this.this$0.el = anjg.g(this.this$0, GestureFilterManager.sGestureType);
      this.this$0.bdM = GestureFilterManager.sGestureType;
    }
    this.this$0.wu.setBackgroundDrawable(this.this$0.el);
    this.this$0.Ov.setText(GestureFilterManager.sGestureTips);
    this.this$0.zZ.setVisibility(0);
    this.this$0.zW.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.49
 * JD-Core Version:    0.7.0.1
 */