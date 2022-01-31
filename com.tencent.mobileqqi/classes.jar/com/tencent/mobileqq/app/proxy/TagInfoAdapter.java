package com.tencent.mobileqq.app.proxy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class TagInfoAdapter
{
  public static QQService.TagInfo a(KQQ.TagInfo paramTagInfo)
  {
    QQService.TagInfo localTagInfo = null;
    if (paramTagInfo != null)
    {
      localTagInfo = new QQService.TagInfo();
      localTagInfo.bType = paramTagInfo.bType;
      localTagInfo.iTagId = paramTagInfo.iTagId;
      localTagInfo.strContent = paramTagInfo.strContent;
    }
    return localTagInfo;
  }
  
  public static ArrayList a(List paramList)
  {
    ArrayList localArrayList = null;
    if (paramList != null)
    {
      localArrayList = new ArrayList(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(a((KQQ.TagInfo)paramList.next()));
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.TagInfoAdapter
 * JD-Core Version:    0.7.0.1
 */