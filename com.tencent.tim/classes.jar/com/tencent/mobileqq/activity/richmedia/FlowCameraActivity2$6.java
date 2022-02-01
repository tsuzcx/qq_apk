package com.tencent.mobileqq.activity.richmedia;

import alvp;
import alvs;
import alvv;
import android.content.Intent;

class FlowCameraActivity2$6
  implements Runnable
{
  FlowCameraActivity2$6(FlowCameraActivity2 paramFlowCameraActivity2) {}
  
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
      this.this$0.finish();
      return;
      this.this$0.cwj();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2.6
 * JD-Core Version:    0.7.0.1
 */