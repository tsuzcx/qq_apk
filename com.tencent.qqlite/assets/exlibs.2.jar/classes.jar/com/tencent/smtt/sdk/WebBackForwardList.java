package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.interfaces.IX5WebBackForwardList;

public class WebBackForwardList
{
  private android.webkit.WebBackForwardList mSysWebBackForwardList = null;
  private IX5WebBackForwardList mWebBackForwardListImpl = null;
  
  static WebBackForwardList wrap(android.webkit.WebBackForwardList paramWebBackForwardList)
  {
    if (paramWebBackForwardList == null) {
      return null;
    }
    WebBackForwardList localWebBackForwardList = new WebBackForwardList();
    localWebBackForwardList.mSysWebBackForwardList = paramWebBackForwardList;
    return localWebBackForwardList;
  }
  
  static WebBackForwardList wrap(IX5WebBackForwardList paramIX5WebBackForwardList)
  {
    if (paramIX5WebBackForwardList == null) {
      return null;
    }
    WebBackForwardList localWebBackForwardList = new WebBackForwardList();
    localWebBackForwardList.mWebBackForwardListImpl = paramIX5WebBackForwardList;
    return localWebBackForwardList;
  }
  
  public int getCurrentIndex()
  {
    if (this.mWebBackForwardListImpl != null) {
      return this.mWebBackForwardListImpl.getCurrentIndex();
    }
    return this.mSysWebBackForwardList.getCurrentIndex();
  }
  
  public WebHistoryItem getCurrentItem()
  {
    if (this.mWebBackForwardListImpl != null) {
      return WebHistoryItem.wrap(this.mWebBackForwardListImpl.getCurrentItem());
    }
    return WebHistoryItem.wrap(this.mSysWebBackForwardList.getCurrentItem());
  }
  
  public WebHistoryItem getItemAtIndex(int paramInt)
  {
    if (this.mWebBackForwardListImpl != null) {
      return WebHistoryItem.wrap(this.mWebBackForwardListImpl.getItemAtIndex(paramInt));
    }
    return WebHistoryItem.wrap(this.mSysWebBackForwardList.getItemAtIndex(paramInt));
  }
  
  public int getSize()
  {
    if (this.mWebBackForwardListImpl != null) {
      return this.mWebBackForwardListImpl.getSize();
    }
    return this.mSysWebBackForwardList.getSize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebBackForwardList
 * JD-Core Version:    0.7.0.1
 */