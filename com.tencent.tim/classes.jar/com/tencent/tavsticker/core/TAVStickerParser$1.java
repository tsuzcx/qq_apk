package com.tencent.tavsticker.core;

import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavsticker.model.TAVStickerLayerInfo.TAVStickerTimeEffect;
import java.util.Comparator;

final class TAVStickerParser$1
  implements Comparator<TAVStickerLayerInfo.TAVStickerTimeEffect>
{
  public int compare(TAVStickerLayerInfo.TAVStickerTimeEffect paramTAVStickerTimeEffect1, TAVStickerLayerInfo.TAVStickerTimeEffect paramTAVStickerTimeEffect2)
  {
    if ((paramTAVStickerTimeEffect1 != null) && (paramTAVStickerTimeEffect1.getTimeRange() != null) && (paramTAVStickerTimeEffect2 != null) && (paramTAVStickerTimeEffect2.getTimeRange() != null)) {
      return (int)(paramTAVStickerTimeEffect1.getTimeRange().getStartUs() - paramTAVStickerTimeEffect1.getTimeRange().getStartUs());
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavsticker.core.TAVStickerParser.1
 * JD-Core Version:    0.7.0.1
 */