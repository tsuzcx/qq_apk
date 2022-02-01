package com.tencent.biz.qqstory.takevideo;

import ram;
import rdc;
import rdk;

public class EditVideoPermission$1
  implements Runnable
{
  public EditVideoPermission$1(rdk paramrdk) {}
  
  public void run()
  {
    if (rdk.a(this.this$0))
    {
      ram.d("Q.qqstory.publish.edit.EditVideoPermission", "PermissionSettingActivity launch failed, change state to IDLE");
      this.this$0.b.changeState(0);
      rdk.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoPermission.1
 * JD-Core Version:    0.7.0.1
 */