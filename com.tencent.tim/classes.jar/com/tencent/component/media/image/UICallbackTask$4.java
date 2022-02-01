package com.tencent.component.media.image;

class UICallbackTask$4
  implements Runnable
{
  UICallbackTask$4(UICallbackTask paramUICallbackTask, ImageKey paramImageKey, float paramFloat) {}
  
  public void run()
  {
    this.val$imageKey.listener.onImageProgress(UICallbackTask.access$000(this.this$0, this.val$imageKey), this.val$progress, this.val$imageKey.options);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.UICallbackTask.4
 * JD-Core Version:    0.7.0.1
 */