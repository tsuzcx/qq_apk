package com.tencent.component.media.image;

import android.graphics.drawable.Drawable;

class DecodeImageTask$1$2
  implements Runnable
{
  DecodeImageTask$1$2(DecodeImageTask.1 param1, Drawable paramDrawable) {}
  
  public void run()
  {
    this.this$1.val$key.listener.onImageLoaded(this.this$1.val$key.url, this.val$drawable, this.this$1.val$key.options);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.DecodeImageTask.1.2
 * JD-Core Version:    0.7.0.1
 */