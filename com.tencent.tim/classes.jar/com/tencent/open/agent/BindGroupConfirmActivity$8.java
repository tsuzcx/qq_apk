package com.tencent.open.agent;

import android.text.TextUtils;
import aqha;
import aqju;
import arpy;

public class BindGroupConfirmActivity$8
  implements Runnable
{
  BindGroupConfirmActivity$8(BindGroupConfirmActivity paramBindGroupConfirmActivity, String paramString) {}
  
  public void run()
  {
    if (this.this$0.aH == null) {
      this.this$0.aH = aqha.a(this.this$0, 230);
    }
    if (!TextUtils.isEmpty(this.val$message)) {
      this.this$0.aH.setMessage(this.val$message);
    }
    arpy localarpy = new arpy(this);
    this.this$0.aH.setTitle(2131721362);
    this.this$0.aH.setPositiveButton(2131691970, localarpy);
    this.this$0.aH.setNegativeButton(2131721058, localarpy);
    if (!this.this$0.aH.isShowing()) {
      this.this$0.aH.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupConfirmActivity.8
 * JD-Core Version:    0.7.0.1
 */