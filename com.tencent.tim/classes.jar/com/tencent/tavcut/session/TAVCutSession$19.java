package com.tencent.tavcut.session;

import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.effect.StickerModel;
import java.util.Iterator;
import java.util.List;

class TAVCutSession$19
  implements Runnable
{
  TAVCutSession$19(TAVCutSession paramTAVCutSession, String paramString) {}
  
  public void run()
  {
    Iterator localIterator = this.this$0.mediaModels.iterator();
    label34:
    label108:
    label111:
    for (;;)
    {
      MediaModel localMediaModel;
      int i;
      if (localIterator.hasNext())
      {
        localMediaModel = (MediaModel)localIterator.next();
        i = 0;
        if (i >= localMediaModel.getMediaEffectModel().getStickerModelList().size()) {
          break label108;
        }
        if (!((StickerModel)localMediaModel.getMediaEffectModel().getStickerModelList().get(i)).getStickerId().equals(this.val$stickerId)) {}
      }
      for (;;)
      {
        if (i < 0) {
          break label111;
        }
        localMediaModel.getMediaEffectModel().getStickerModelList().remove(i);
        break;
        i += 1;
        break label34;
        return;
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutSession.19
 * JD-Core Version:    0.7.0.1
 */