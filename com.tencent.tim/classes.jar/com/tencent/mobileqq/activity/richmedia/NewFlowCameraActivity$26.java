package com.tencent.mobileqq.activity.richmedia;

import alvp;
import alvs;
import alvv;
import android.content.Intent;
import qqz;

class NewFlowCameraActivity$26
  implements Runnable
{
  NewFlowCameraActivity$26(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void run()
  {
    Object localObject = alvs.a().a().a(this.this$0.bdE);
    if (localObject != null) {
      ((alvp)localObject).Ts(103);
    }
    for (;;)
    {
      localObject = this.this$0.getIntent();
      ((Intent)localObject).putExtra("flow_back", 0);
      this.this$0.setResult(1001, (Intent)localObject);
      this.this$0.b.bpR();
      this.this$0.finish();
      return;
      this.this$0.cwj();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.26
 * JD-Core Version:    0.7.0.1
 */