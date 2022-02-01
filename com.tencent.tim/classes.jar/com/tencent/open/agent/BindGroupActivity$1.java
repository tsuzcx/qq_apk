package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.SlideDetectListView;

class BindGroupActivity$1
  implements Runnable
{
  BindGroupActivity$1(BindGroupActivity paramBindGroupActivity, String paramString, Bitmap paramBitmap) {}
  
  public void run()
  {
    int j = this.this$0.h.getChildCount();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        BindGroupActivity.c localc = (BindGroupActivity.c)this.this$0.h.getChildAt(i).getTag();
        if ((localc != null) && (this.val$avatarUrl.equals(localc.avatar))) {
          localc.pQ.setImageBitmap(this.val$bitmap);
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
 * Qualified Name:     com.tencent.open.agent.BindGroupActivity.1
 * JD-Core Version:    0.7.0.1
 */