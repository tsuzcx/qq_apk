package com.tencent.moai.mailsdk.protocol.exchange.request;

import com.tencent.moai.mailsdk.protocol.exchange.model.ExchangeInfo;
import com.tencent.moai.mailsdk.util.DateUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class FindItemRequest
  extends ExchangeRequest
{
  private long endTime;
  private long findMaxCount = 512L;
  private String folderId;
  private HashMap<Integer, String> searchInfo;
  private long startTime;
  
  public FindItemRequest(ExchangeInfo paramExchangeInfo)
  {
    super(paramExchangeInfo, "FindItem");
  }
  
  public byte[] buildCmdData()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
    localStringBuilder.append("<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:enc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:t=\"http://schemas.microsoft.com/exchange/services/2006/types\" xmlns:m=\"http://schemas.microsoft.com/exchange/services/2006/messages\">");
    localStringBuilder.append(String.format("<s:Header><t:RequestServerVersion s:mustUnderstand=\"1\" Version=\"%s\"></t:RequestServerVersion></s:Header>", new Object[] { this.exchangeInfo.getExchangeVersion() }));
    localStringBuilder.append("<s:Body>");
    localStringBuilder.append("<m:FindItem Traversal=\"Shallow\">");
    localStringBuilder.append("<m:ItemShape>");
    localStringBuilder.append("<t:BaseShape>IdOnly</t:BaseShape>");
    localStringBuilder.append("<t:IncludeMimeContent>false</t:IncludeMimeContent>");
    localStringBuilder.append("<t:AdditionalProperties>");
    localStringBuilder.append("<t:FieldURI FieldURI=\"item:DateTimeSent\"></t:FieldURI>");
    localStringBuilder.append("</t:AdditionalProperties>");
    localStringBuilder.append("</m:ItemShape>");
    localStringBuilder.append("<m:IndexedPageItemView MaxEntriesReturned=\"").append(this.findMaxCount).append("\" BasePoint=\"Beginning\" Offset=\"0\"></m:IndexedPageItemView>");
    localStringBuilder.append("<m:Restriction>");
    localStringBuilder.append("<t:And>");
    localStringBuilder.append("<t:IsGreaterThan><t:FieldURI FieldURI=\"item:DateTimeSent\"></t:FieldURI><t:FieldURIOrConstant><t:Constant Value=\"").append(DateUtils.formatTime(this.startTime)).append("\"></t:Constant></t:FieldURIOrConstant></t:IsGreaterThan>");
    localStringBuilder.append("<t:IsLessThanOrEqualTo><t:FieldURI FieldURI=\"item:DateTimeSent\"></t:FieldURI><t:FieldURIOrConstant><t:Constant Value=\"").append(DateUtils.formatTime(this.endTime)).append("\"></t:Constant></t:FieldURIOrConstant></t:IsLessThanOrEqualTo>");
    if (this.searchInfo != null)
    {
      int i = this.searchInfo.size();
      Iterator localIterator = this.searchInfo.entrySet().iterator();
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        String str;
        switch (((Integer)localEntry.getKey()).intValue())
        {
        default: 
          str = "";
        }
        for (;;)
        {
          if (i > 1) {
            localStringBuilder.append("<t:Or>");
          }
          localStringBuilder.append("<t:Contains ContainmentComparison=\"IgnoreCase\" ContainmentMode=\"Substring\">");
          localStringBuilder.append("<t:FieldURI FieldURI=\"").append(str).append("\"></t:FieldURI>");
          localStringBuilder.append("<t:Constant Value=\"").append((String)localEntry.getValue()).append("\"></t:Constant></t:Contains>");
          if (i <= 1) {
            break;
          }
          localStringBuilder.append("</t:Or>");
          break;
          str = "message:From";
          continue;
          str = "item:Body";
          continue;
          str = "item:DisplayTo";
          continue;
          str = "item:Subject";
        }
      }
    }
    localStringBuilder.append("</t:And>");
    localStringBuilder.append("</m:Restriction>");
    localStringBuilder.append("<m:SortOrder>");
    localStringBuilder.append("<t:FieldOrder Order=\"Descending\">");
    localStringBuilder.append("<t:FieldURI FieldURI=\"item:DateTimeSent\"></t:FieldURI>");
    localStringBuilder.append("</t:FieldOrder>");
    localStringBuilder.append("</m:SortOrder>");
    localStringBuilder.append("<m:ParentFolderIds><t:FolderId Id=\"").append(this.folderId).append("\"></t:FolderId></m:ParentFolderIds>");
    localStringBuilder.append("</m:FindItem>");
    localStringBuilder.append("</s:Body>");
    localStringBuilder.append("</s:Envelope>");
    return localStringBuilder.toString().getBytes();
  }
  
  public long getEndTime()
  {
    return this.endTime;
  }
  
  public long getFindMaxCount()
  {
    return this.findMaxCount;
  }
  
  public String getFolderId()
  {
    return this.folderId;
  }
  
  public HashMap<Integer, String> getSearchInfo()
  {
    return this.searchInfo;
  }
  
  public long getStartTime()
  {
    return this.startTime;
  }
  
  public void setEndTime(long paramLong)
  {
    this.endTime = paramLong;
  }
  
  public void setFindMaxCount(long paramLong)
  {
    this.findMaxCount = paramLong;
  }
  
  public void setFolderId(String paramString)
  {
    this.folderId = paramString;
  }
  
  public void setSearchInfo(HashMap<Integer, String> paramHashMap)
  {
    this.searchInfo = paramHashMap;
  }
  
  public void setStartTime(long paramLong)
  {
    this.startTime = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.exchange.request.FindItemRequest
 * JD-Core Version:    0.7.0.1
 */