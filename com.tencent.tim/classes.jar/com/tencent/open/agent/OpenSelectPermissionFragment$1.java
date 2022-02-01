package com.tencent.open.agent;

import android.graphics.Bitmap;
import aurs;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;

class OpenSelectPermissionFragment$1
  implements Runnable
{
  OpenSelectPermissionFragment$1(OpenSelectPermissionFragment paramOpenSelectPermissionFragment) {}
  
  public void run()
  {
    Bitmap localBitmap = OpenSelectPermissionFragment.a(this.this$0).T(OpenSelectPermissionFragment.a(this.this$0));
    if (localBitmap != null) {
      aurs.runOnUiThread(new OpenSelectPermissionFragment.1.1(this, localBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.OpenSelectPermissionFragment.1
 * JD-Core Version:    0.7.0.1
 */