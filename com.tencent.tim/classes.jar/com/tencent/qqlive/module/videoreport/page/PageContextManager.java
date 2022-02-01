package com.tencent.qqlive.module.videoreport.page;

import java.util.Map;
import java.util.WeakHashMap;

public class PageContextManager
{
  private final Map<Object, PageContext> mContextMap = new WeakHashMap();
  
  public static PageContextManager getInstance()
  {
    return InstanceHolder.INSTANCE;
  }
  
  public void clear()
  {
    this.mContextMap.clear();
  }
  
  public PageContext get(Object paramObject)
  {
    return (PageContext)this.mContextMap.get(paramObject);
  }
  
  public void set(Object paramObject, PageContext paramPageContext)
  {
    this.mContextMap.put(paramObject, paramPageContext);
  }
  
  static class InstanceHolder
  {
    static final PageContextManager INSTANCE = new PageContextManager(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageContextManager
 * JD-Core Version:    0.7.0.1
 */