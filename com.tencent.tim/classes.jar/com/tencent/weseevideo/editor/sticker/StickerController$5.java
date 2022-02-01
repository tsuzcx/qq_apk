package com.tencent.weseevideo.editor.sticker;

import com.tencent.tavcut.session.callback.StickerStateCallback;

class StickerController$5
  implements Runnable
{
  StickerController$5(StickerController paramStickerController) {}
  
  public void run()
  {
    if (StickerController.access$700(this.this$0) == 0) {}
    while (StickerController.access$400(this.this$0) == null) {
      return;
    }
    StickerController.access$400(this.this$0).onStatusChanged(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.StickerController.5
 * JD-Core Version:    0.7.0.1
 */