package com.tencent.mobileqq.forward;

import ahjb;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import aqju;

public class ForwardPhotoOption$3
  implements Runnable
{
  ForwardPhotoOption$3(ForwardPhotoOption paramForwardPhotoOption, Drawable paramDrawable, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    if ((this.this$0.e.isShowing()) && (ForwardPhotoOption.a(this.this$0) != null))
    {
      ForwardPhotoOption.a(this.this$0).a(this.val$d, this.cgU, this.val$num, false);
      if (ForwardPhotoOption.a(this.this$0)) {
        this.this$0.dnP();
      }
    }
    else
    {
      return;
    }
    ForwardPhotoOption.a(this.this$0).framePreviewImage.setOnTouchListener(new ahjb(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPhotoOption.3
 * JD-Core Version:    0.7.0.1
 */