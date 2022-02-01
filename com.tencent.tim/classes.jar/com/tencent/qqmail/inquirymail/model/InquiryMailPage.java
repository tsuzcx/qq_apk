package com.tencent.qqmail.inquirymail.model;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.model.qmdomain.QMDomain;

public class InquiryMailPage
  extends QMDomain
{
  private long edgeTime;
  private int hasMore;
  private int page;
  
  public long getEdgeTime()
  {
    return this.edgeTime;
  }
  
  public int getHasMore()
  {
    return this.hasMore;
  }
  
  public int getPage()
  {
    return this.page;
  }
  
  public boolean parseWithDictionary(JSONObject paramJSONObject)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramJSONObject == null) {}
    int i;
    do
    {
      do
      {
        return bool1;
        String str = (String)paramJSONObject.get("next_page");
        bool1 = bool2;
        if (str != null)
        {
          i = Integer.parseInt(str);
          bool1 = bool2;
          if (getPage() != i)
          {
            setPage(i);
            bool1 = true;
          }
        }
        str = (String)paramJSONObject.get("next_edgetime");
        bool2 = bool1;
        if (str != null)
        {
          long l = Long.parseLong(str);
          bool2 = bool1;
          if (getEdgeTime() != l)
          {
            setEdgeTime(l);
            bool2 = true;
          }
        }
        paramJSONObject = (String)paramJSONObject.get("has_more");
        bool1 = bool2;
      } while (paramJSONObject == null);
      i = Integer.parseInt(paramJSONObject);
      bool1 = bool2;
    } while (getHasMore() == i);
    setHasMore(i);
    return true;
  }
  
  public void setEdgeTime(long paramLong)
  {
    this.edgeTime = paramLong;
  }
  
  public void setHasMore(int paramInt)
  {
    this.hasMore = paramInt;
  }
  
  public void setPage(int paramInt)
  {
    this.page = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.inquirymail.model.InquiryMailPage
 * JD-Core Version:    0.7.0.1
 */