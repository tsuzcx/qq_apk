package com.tencent.mobileqq.app.fms;

import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public class FullMessageSearchResult
{
  public int cyW = 0;
  public List<SearchResultItem> xW;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("FullMessageSearchResult:");
    if (this.xW == null)
    {
      localStringBuilder.append("null");
      return localStringBuilder.toString();
    }
    Iterator localIterator = this.xW.iterator();
    if (localIterator.hasNext())
    {
      SearchResultItem localSearchResultItem = (SearchResultItem)localIterator.next();
      localStringBuilder.append("(");
      localStringBuilder.append(localSearchResultItem.user.uin);
      localStringBuilder.append(",");
      if (localSearchResultItem.secondPageList == null)
      {
        i = 0;
        label96:
        localStringBuilder.append(i);
        localStringBuilder.append(",");
        if (localSearchResultItem.secondPageMessageUniseq != null) {
          break label149;
        }
      }
      label149:
      for (int i = 0;; i = localSearchResultItem.secondPageMessageUniseq.size())
      {
        localStringBuilder.append(i);
        localStringBuilder.append(")");
        break;
        i = localSearchResultItem.secondPageList.size();
        break label96;
      }
    }
    localStringBuilder.append(" searchFinFlag=" + this.cyW);
    return localStringBuilder.toString();
  }
  
  public static class SearchResultItem
    implements Serializable
  {
    public QQMessageFacade.Message lastMessage;
    public List<MessageRecord> secondPageList;
    public List<Long> secondPageMessageUniseq;
    public RecentUser user;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.fms.FullMessageSearchResult
 * JD-Core Version:    0.7.0.1
 */