package com.tencent.ttpic.openapi.cache;

import com.tencent.ttpic.openapi.extrastickerutil.ExtraStickerParserAgent;
import com.tencent.ttpic.openapi.extrastickerutil.IExtraStickerParser;
import com.tencent.ttpic.openapi.model.StickerItem;

public class LoadPagItemManager
  extends LoadExtraStickerParserManager
{
  private final String PAG_SUFFIX = ".pag";
  private final String TAG = "LoadPagItemManager";
  private String mPagName;
  
  public LoadPagItemManager(String paramString, StickerItem paramStickerItem)
  {
    super(paramString, paramStickerItem);
    if (paramStickerItem == null) {
      return;
    }
    this.mStickerParser = ExtraStickerParserAgent.getInstance().creatPagParser();
    if (this.mStickerParser != null)
    {
      if ((paramStickerItem.extarTypeHeight > 0) && (paramStickerItem.extraTypeWidth > 0)) {
        break label115;
      }
      this.mWidth = paramStickerItem.width;
    }
    for (this.mHeight = paramStickerItem.height;; this.mHeight = paramStickerItem.extarTypeHeight)
    {
      this.mStickerParser.setSize(this.mWidth, this.mHeight);
      this.mPagName = (paramStickerItem.id + ".pag");
      return;
      label115:
      this.mWidth = paramStickerItem.extraTypeWidth;
    }
  }
  
  public void prepareImages()
  {
    if (!this.mIsPrepared) {}
    do
    {
      return;
      if (this.mStickerParser == null) {
        this.mStickerParser = ExtraStickerParserAgent.getInstance().creatPagParser();
      }
    } while (this.mStickerParser == null);
    this.mIsPrepared = this.mStickerParser.prepare(this.mDataPath, this.mPagName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.cache.LoadPagItemManager
 * JD-Core Version:    0.7.0.1
 */