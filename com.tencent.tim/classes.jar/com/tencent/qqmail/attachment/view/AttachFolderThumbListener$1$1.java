package com.tencent.qqmail.attachment.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;

class AttachFolderThumbListener$1$1
  implements Runnable
{
  AttachFolderThumbListener$1$1(AttachFolderThumbListener.1 param1, Bitmap paramBitmap) {}
  
  public void run()
  {
    BitmapDrawable localBitmapDrawable = new BitmapDrawable(AttachFolderThumbListener.access$000(this.this$1.this$0).getResources(), this.val$bitmap);
    AttachFolderThumbListener.access$400(this.this$1.this$0).setImageDrawable(localBitmapDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.attachment.view.AttachFolderThumbListener.1.1
 * JD-Core Version:    0.7.0.1
 */