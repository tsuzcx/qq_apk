package com.tencent.tavcut.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavcut.bean.TextItem;
import com.tencent.tavsticker.exception.StickerInitializationException;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerMoveLimit;
import com.tencent.tavsticker.model.TAVStickerTextItem;
import com.tencent.tavsticker.utils.TimeRangeUtil;
import com.tencent.weseevideo.model.effect.StickerModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StickerUtil
{
  private static final String TAG = StickerUtil.class.getSimpleName();
  private static final int TIME_SCALE = 1000;
  
  @Nullable
  public static TAVSticker genTavSticker(@NonNull StickerModel paramStickerModel)
  {
    try
    {
      TAVSticker localTAVSticker = new TAVSticker().setFilePath(paramStickerModel.getFilePath()).setAssetFilePath(paramStickerModel.getAssetFilePath()).setCenterX(paramStickerModel.getCenterX()).setCenterY(paramStickerModel.getCenterY()).setScale(paramStickerModel.getScale());
      if (paramStickerModel.getDuration() > 0.0F) {}
      for (CMTimeRange localCMTimeRange = new CMTimeRange(new CMTime(paramStickerModel.getStartTime()), new CMTime(paramStickerModel.getDuration()));; localCMTimeRange = null)
      {
        paramStickerModel = localTAVSticker.setTimeRange(localCMTimeRange).setTavStickerMoveLimit(TAVStickerMoveLimit.LIMIT_VERTEX).setMaxScale(paramStickerModel.getMaxScale()).setMinScale(paramStickerModel.getMinScale()).init();
        return paramStickerModel;
      }
      return null;
    }
    catch (StickerInitializationException paramStickerModel)
    {
      Logger.e(paramStickerModel);
    }
  }
  
  public static TAVSticker stickerModel2TavSticker(StickerModel paramStickerModel)
  {
    CMTimeRange localCMTimeRange = new CMTimeRange(new CMTime(paramStickerModel.getStartTime(), 1000), new CMTime(((float)paramStickerModel.getEndTime() - paramStickerModel.getStartTime()), 1000));
    Object localObject = localCMTimeRange;
    if (!TimeRangeUtil.isValidTimeRange(localCMTimeRange)) {
      localObject = null;
    }
    localObject = new TAVSticker().setStickerId(paramStickerModel.getStickerId()).setFilePath(paramStickerModel.getFilePath()).setAssetFilePath(paramStickerModel.getAssetFilePath()).setLayerIndex(paramStickerModel.getLayerIndex()).setScale(paramStickerModel.getScale()).setRotate(paramStickerModel.getRotate()).setCenterX(paramStickerModel.getCenterX()).setCenterY(paramStickerModel.getCenterY()).setEditable(paramStickerModel.isEditable()).setMinScale(paramStickerModel.getMinScale()).setMaxScale(paramStickerModel.getMaxScale()).setTimeRange((CMTimeRange)localObject);
    try
    {
      ((TAVSticker)localObject).init();
      int i = 0;
      for (;;)
      {
        if (i >= paramStickerModel.getTextItems().size()) {
          break label291;
        }
        if (i >= ((TAVSticker)localObject).getStickerTextItems().size()) {
          break;
        }
        ((TAVStickerTextItem)((TAVSticker)localObject).getStickerTextItems().get(i)).setText(((TextItem)paramStickerModel.getTextItems().get(i)).text);
        ((TAVStickerTextItem)((TAVSticker)localObject).getStickerTextItems().get(i)).setTextColor(((TextItem)paramStickerModel.getTextItems().get(i)).textColor);
        ((TAVStickerTextItem)((TAVSticker)localObject).getStickerTextItems().get(i)).setFontPath(((TextItem)paramStickerModel.getTextItems().get(i)).fontPath);
        i += 1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        Logger.w(TAG, "sticker.stickerTextItems is not correct");
      }
      label291:
      ((TAVSticker)localObject).setStickerId(((TAVSticker)localObject).getStickerId());
      ((TAVSticker)localObject).updateTextData();
    }
    return localObject;
  }
  
  public static StickerModel tavSticker2StickerModel(TAVSticker paramTAVSticker)
  {
    long l2 = 0L;
    StickerModel localStickerModel = new StickerModel();
    localStickerModel.setStickerId(paramTAVSticker.getStickerId());
    localStickerModel.setFilePath(paramTAVSticker.getFilePath());
    localStickerModel.setAssetFilePath(paramTAVSticker.getAssetFilePath());
    if (paramTAVSticker.getTimeRange() != null) {}
    ArrayList localArrayList;
    for (long l1 = paramTAVSticker.getTimeRange().getStartUs();; l1 = 0L)
    {
      localStickerModel.setStartTime((float)l1 * 1.0F / 1000.0F);
      l1 = l2;
      if (paramTAVSticker.getTimeRange() != null) {
        l1 = paramTAVSticker.getTimeRange().getEndUs();
      }
      localStickerModel.setEndTime(l1 / 1000L);
      localStickerModel.setLayerIndex(paramTAVSticker.getLayerIndex());
      localStickerModel.setScale(paramTAVSticker.getScale());
      localStickerModel.setRotate(paramTAVSticker.getRotate());
      localStickerModel.setCenterX(paramTAVSticker.getCenterX());
      localStickerModel.setCenterY(paramTAVSticker.getCenterY());
      localStickerModel.setEditable(paramTAVSticker.isEditable());
      localStickerModel.setWidth(paramTAVSticker.getWidth());
      localStickerModel.setHeight(paramTAVSticker.getHeight());
      localStickerModel.setMinScale(paramTAVSticker.getMinScale());
      localStickerModel.setMaxScale(paramTAVSticker.getMaxScale());
      localArrayList = new ArrayList();
      paramTAVSticker = paramTAVSticker.getStickerTextItems().iterator();
      while (paramTAVSticker.hasNext())
      {
        TAVStickerTextItem localTAVStickerTextItem = (TAVStickerTextItem)paramTAVSticker.next();
        TextItem localTextItem = new TextItem();
        localTextItem.fontPath = localTAVStickerTextItem.getFontPath();
        localTextItem.text = localTAVStickerTextItem.getText();
        localTextItem.textColor = localTAVStickerTextItem.getTextColor();
        localArrayList.add(localTextItem);
      }
    }
    localStickerModel.setTextItems(localArrayList);
    return localStickerModel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavcut.util.StickerUtil
 * JD-Core Version:    0.7.0.1
 */