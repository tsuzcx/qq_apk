package com.tencent.smtt.sdk;

import android.graphics.Bitmap;
import com.tencent.smtt.export.external.interfaces.IX5WebHistoryItem;

public class WebHistoryItem
{
  private android.webkit.WebHistoryItem mSysWebHistoryItem = null;
  private IX5WebHistoryItem mWebHistoryItemImpl = null;
  
  static WebHistoryItem wrap(android.webkit.WebHistoryItem paramWebHistoryItem)
  {
    if (paramWebHistoryItem == null) {
      return null;
    }
    WebHistoryItem localWebHistoryItem = new WebHistoryItem();
    localWebHistoryItem.mSysWebHistoryItem = paramWebHistoryItem;
    return localWebHistoryItem;
  }
  
  static WebHistoryItem wrap(IX5WebHistoryItem paramIX5WebHistoryItem)
  {
    if (paramIX5WebHistoryItem == null) {
      return null;
    }
    WebHistoryItem localWebHistoryItem = new WebHistoryItem();
    localWebHistoryItem.mWebHistoryItemImpl = paramIX5WebHistoryItem;
    return localWebHistoryItem;
  }
  
  public Bitmap getFavicon()
  {
    if (this.mWebHistoryItemImpl != null) {
      return this.mWebHistoryItemImpl.getFavicon();
    }
    return this.mSysWebHistoryItem.getFavicon();
  }
  
  public String getOriginalUrl()
  {
    if (this.mWebHistoryItemImpl != null) {
      return this.mWebHistoryItemImpl.getOriginalUrl();
    }
    return this.mSysWebHistoryItem.getOriginalUrl();
  }
  
  public String getTitle()
  {
    if (this.mWebHistoryItemImpl != null) {
      return this.mWebHistoryItemImpl.getTitle();
    }
    return this.mSysWebHistoryItem.getTitle();
  }
  
  public String getUrl()
  {
    if (this.mWebHistoryItemImpl != null) {
      return this.mWebHistoryItemImpl.getUrl();
    }
    return this.mSysWebHistoryItem.getUrl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebHistoryItem
 * JD-Core Version:    0.7.0.1
 */