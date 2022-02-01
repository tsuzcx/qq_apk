package com.tencent.weseevideo.model.effect;

import com.tencent.tavcut.bean.TextItem;
import com.tencent.weseevideo.composition.effectnode.VideoEffectType;
import java.util.ArrayList;
import java.util.List;

public class StickerModel
  extends VideoPagModel
{
  protected float centerX = 0.0F;
  protected float centerY = 0.0F;
  protected boolean editable = true;
  protected long endTime = 0L;
  protected String fontId = "";
  protected int height = 0;
  protected int layerIndex = -1;
  protected LimitArea limitArea;
  protected String materialId = "";
  protected float maxScale = 0.0F;
  protected float minScale = 0.0F;
  protected float rotate = 0.0F;
  protected float scale = 0.5F;
  protected List<TextItem> textItems = new ArrayList();
  protected String type = "";
  protected int width = 0;
  
  public StickerModel()
  {
    this.effectType = VideoEffectType.TYPE_STICKER.value;
  }
  
  public float getCenterX()
  {
    return this.centerX;
  }
  
  public float getCenterY()
  {
    return this.centerY;
  }
  
  public long getEndTime()
  {
    return this.endTime;
  }
  
  public String getFontId()
  {
    return this.fontId;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public int getLayerIndex()
  {
    return this.layerIndex;
  }
  
  public LimitArea getLimitArea()
  {
    return this.limitArea;
  }
  
  public String getMaterialId()
  {
    return this.materialId;
  }
  
  public float getMaxScale()
  {
    return this.maxScale;
  }
  
  public float getMinScale()
  {
    return this.minScale;
  }
  
  public float getRotate()
  {
    return this.rotate;
  }
  
  public float getScale()
  {
    return this.scale;
  }
  
  public List<TextItem> getTextItems()
  {
    return this.textItems;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public boolean isEditable()
  {
    return this.editable;
  }
  
  public void setCenterX(float paramFloat)
  {
    this.centerX = paramFloat;
  }
  
  public void setCenterY(float paramFloat)
  {
    this.centerY = paramFloat;
  }
  
  public void setEditable(boolean paramBoolean)
  {
    this.editable = paramBoolean;
  }
  
  public void setEndTime(long paramLong)
  {
    this.endTime = paramLong;
  }
  
  public void setFontId(String paramString)
  {
    this.fontId = paramString;
  }
  
  public void setHeight(int paramInt)
  {
    this.height = paramInt;
  }
  
  public void setLayerIndex(int paramInt)
  {
    this.layerIndex = paramInt;
  }
  
  public void setLimitArea(LimitArea paramLimitArea)
  {
    this.limitArea = paramLimitArea;
  }
  
  public void setMaterialId(String paramString)
  {
    this.materialId = paramString;
  }
  
  public void setMaxScale(float paramFloat)
  {
    this.maxScale = paramFloat;
  }
  
  public void setMinScale(float paramFloat)
  {
    this.minScale = paramFloat;
  }
  
  public void setRotate(float paramFloat)
  {
    this.rotate = paramFloat;
  }
  
  public void setScale(float paramFloat)
  {
    this.scale = paramFloat;
  }
  
  public void setTextItems(List<TextItem> paramList)
  {
    this.textItems = paramList;
  }
  
  public void setType(String paramString)
  {
    this.type = paramString;
  }
  
  public void setWidth(int paramInt)
  {
    this.width = paramInt;
  }
  
  class LimitArea
  {
    public float height = 1.0F;
    public float width = 1.0F;
    public float x = 0.0F;
    public float y = 0.0F;
    
    LimitArea() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.model.effect.StickerModel
 * JD-Core Version:    0.7.0.1
 */