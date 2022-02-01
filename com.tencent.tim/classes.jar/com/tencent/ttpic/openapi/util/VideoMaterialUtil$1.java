package com.tencent.ttpic.openapi.util;

import com.tencent.ttpic.openapi.model.StickerItem;
import java.util.Comparator;

final class VideoMaterialUtil$1
  implements Comparator<StickerItem>
{
  public int compare(StickerItem paramStickerItem1, StickerItem paramStickerItem2)
  {
    return paramStickerItem1.type - paramStickerItem2.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.VideoMaterialUtil.1
 * JD-Core Version:    0.7.0.1
 */