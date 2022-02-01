package com.tencent.tavmovie.sticker;

import android.support.annotation.NonNull;
import com.tencent.tavsticker.model.TAVStickerTextItem;

public class TAVMovieStickerTextItem
  implements Cloneable
{
  private String fontPath;
  private String text;
  private int textColor;
  private TAVStickerTextItem textItem;
  
  public TAVMovieStickerTextItem() {}
  
  public TAVMovieStickerTextItem(@NonNull TAVStickerTextItem paramTAVStickerTextItem)
  {
    this.textItem = paramTAVStickerTextItem;
    this.text = this.textItem.getText();
    this.textColor = this.textItem.getTextColor();
    this.fontPath = this.textItem.getFontPath();
  }
  
  public TAVMovieStickerTextItem clone()
  {
    TAVMovieStickerTextItem localTAVMovieStickerTextItem = new TAVMovieStickerTextItem();
    localTAVMovieStickerTextItem.setTextItem(this.textItem);
    localTAVMovieStickerTextItem.setText(this.text);
    localTAVMovieStickerTextItem.setTextColor(this.textColor);
    localTAVMovieStickerTextItem.setFontPath(this.fontPath);
    return localTAVMovieStickerTextItem;
  }
  
  public String getFontPath()
  {
    return this.fontPath;
  }
  
  public String getText()
  {
    return this.text;
  }
  
  public int getTextColor()
  {
    return this.textColor;
  }
  
  public TAVStickerTextItem getTextItem()
  {
    return this.textItem;
  }
  
  public void setFontPath(String paramString)
  {
    this.fontPath = paramString;
    if (this.textItem != null) {
      this.textItem.setFontPath(this.fontPath);
    }
  }
  
  public void setText(String paramString)
  {
    this.text = paramString;
    if (this.textItem != null) {
      this.textItem.setText(this.text);
    }
  }
  
  public void setTextColor(int paramInt)
  {
    this.textColor = paramInt;
    if (this.textItem != null) {
      this.textItem.setTextColor(this.textColor);
    }
  }
  
  public void setTextItem(TAVStickerTextItem paramTAVStickerTextItem)
  {
    this.textItem = paramTAVStickerTextItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavmovie.sticker.TAVMovieStickerTextItem
 * JD-Core Version:    0.7.0.1
 */