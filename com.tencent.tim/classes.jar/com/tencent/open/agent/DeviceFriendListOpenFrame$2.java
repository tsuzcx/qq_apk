package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.PinnedDividerListView;

class DeviceFriendListOpenFrame$2
  implements Runnable
{
  DeviceFriendListOpenFrame$2(DeviceFriendListOpenFrame paramDeviceFriendListOpenFrame, String paramString, Bitmap paramBitmap) {}
  
  public void run()
  {
    int j = this.this$0.g.getChildCount();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        DeviceFriendListOpenFrame.b localb = (DeviceFriendListOpenFrame.b)this.this$0.g.getChildAt(i).getTag();
        if ((localb != null) && (this.val$avatarUrl.equals(localb.avatar))) {
          localb.pQ.setImageBitmap(this.val$bitmap);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.DeviceFriendListOpenFrame.2
 * JD-Core Version:    0.7.0.1
 */