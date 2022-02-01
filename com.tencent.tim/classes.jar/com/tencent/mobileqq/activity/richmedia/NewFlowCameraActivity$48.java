package com.tencent.mobileqq.activity.richmedia;

import aaqh;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import anjd;
import anjg;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.view.CameraFilterGLView;
import com.tencent.mobileqq.activity.richmedia.view.FSurfaceViewLayout;
import com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureFilterManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

class NewFlowCameraActivity$48
  implements Runnable
{
  NewFlowCameraActivity$48(NewFlowCameraActivity paramNewFlowCameraActivity, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    if ((this.this$0.c != null) && (this.this$0.c.aL.get() != 4))
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("PTV.NewFlowCameraActivity", 4, "detect:" + this.byF + ",disable:" + this.this$0.a.Xu());
      }
      if ((!this.byF) && (this.this$0.a.Xu())) {
        break label411;
      }
      if (this.val$type != 0) {
        break label208;
      }
      this.this$0.zW.setVisibility(8);
      if ((NewFlowCameraActivity.b(this.this$0) != null) && ((this.this$0.a.a instanceof CameraFilterGLView)))
      {
        CameraFilterGLView localCameraFilterGLView = (CameraFilterGLView)this.this$0.a.a;
        if ((NewFlowCameraActivity.e(this.this$0) != 0) || ((localCameraFilterGLView.a.mHasBackFilter) && (aaqh.cix != 2))) {
          this.this$0.n(true, NewFlowCameraActivity.b(this.this$0), NewFlowCameraActivity.e(this.this$0));
        }
      }
    }
    label208:
    do
    {
      return;
      if ((this.val$type == 1) && (this.byF) && (this.this$0.a.Xv()))
      {
        this.this$0.zW.setVisibility(8);
        this.this$0.zZ.setVisibility(8);
        break;
      }
      if ((this.val$type != 1) || (this.byF) || (!this.this$0.a.Xv()) || (NewFlowCameraActivity.a(this.this$0)) || (this.this$0.zW.getVisibility() == 0)) {
        break;
      }
      if ((this.this$0.el == null) || (!this.this$0.bdM.equalsIgnoreCase(GestureFilterManager.sGestureType)))
      {
        this.this$0.el = anjg.g(this.this$0, GestureFilterManager.sGestureType);
        this.this$0.bdM = GestureFilterManager.sGestureType;
      }
      this.this$0.wu.setBackgroundDrawable(this.this$0.el);
      this.this$0.Ov.setText(GestureFilterManager.sGestureTips);
      this.this$0.zZ.setVisibility(0);
      break;
      if ((this.val$type == 0) && (this.this$0.a.Xu()))
      {
        this.this$0.zZ.setVisibility(8);
        this.this$0.zW.setVisibility(0);
        return;
      }
    } while ((this.val$type != 1) || (!this.this$0.a.Xv()) || (NewFlowCameraActivity.a(this.this$0)) || (this.this$0.zW.getVisibility() == 0));
    label411:
    if ((this.this$0.el == null) || (!this.this$0.bdM.equalsIgnoreCase(GestureFilterManager.sGestureType)))
    {
      this.this$0.el = anjg.g(this.this$0, GestureFilterManager.sGestureType);
      this.this$0.bdM = GestureFilterManager.sGestureType;
    }
    this.this$0.wu.setBackgroundDrawable(this.this$0.el);
    this.this$0.Ov.setText(GestureFilterManager.sGestureTips);
    this.this$0.zZ.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.48
 * JD-Core Version:    0.7.0.1
 */