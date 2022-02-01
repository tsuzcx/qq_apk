package com.tencent.moai.nativepages.model;

import java.util.LinkedList;

public class AdLandingXmlInfo
{
  public int basicRootFontSize;
  public int basicWidth;
  public LinkedList<AdLandingPageInfo> pages = new LinkedList();
  public String shareDesc;
  public String shareTitle;
  public String shareUrl;
  public int sizeType;
  
  public String toString()
  {
    return "AdLandingXmlInfo{sizeType=" + this.sizeType + ", basicWidth=" + this.basicWidth + ", basicRootFontSize=" + this.basicRootFontSize + ", shareUrl='" + this.shareUrl + '\'' + ", shareTitle='" + this.shareTitle + '\'' + ", shareDesc='" + this.shareDesc + '\'' + ", pages=" + this.pages + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.model.AdLandingXmlInfo
 * JD-Core Version:    0.7.0.1
 */