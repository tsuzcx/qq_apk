package com.tencent.tavcut.session;

import com.tencent.tavcut.util.StickerUtil;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.weseevideo.editor.sticker.StickerController;

class TAVCutSession$14$1
  implements Runnable
{
  TAVCutSession$14$1(TAVCutSession.14 param14) {}
  
  public void run()
  {
    TAVSticker localTAVSticker = this.this$1.val$stickerController.getCurrentSticker();
    if (localTAVSticker != null) {
      TAVCutSession.access$000(this.this$1.this$0, localTAVSticker);
    }
    this.this$1.val$stickerController.resignCurrentSticker();
    localTAVSticker = StickerUtil.stickerModel2TavSticker(this.this$1.val$stickerModel);
    if (localTAVSticker != null) {
      this.this$1.val$stickerController.addSticker(localTAVSticker);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutSession.14.1
 * JD-Core Version:    0.7.0.1
 */