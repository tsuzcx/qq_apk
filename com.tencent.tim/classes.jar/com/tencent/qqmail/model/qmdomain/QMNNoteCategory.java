package com.tencent.qqmail.model.qmdomain;

import com.alibaba.fastjson.JSONObject;

public class QMNNoteCategory
  extends QMDomain
{
  public static final String ALL_CATEGORY_ID = "all";
  public static final String STAR_CATEGORY_ID = "star";
  private static final long serialVersionUID = -1712090763461870117L;
  private String catalogId;
  private String catalogName;
  private int catalogPos;
  
  public QMNNoteCategory()
  {
    this.catalogId = "";
    this.catalogName = "";
  }
  
  public QMNNoteCategory(String paramString1, String paramString2)
  {
    setCatalogId(paramString1);
    setCatalogName(paramString2);
  }
  
  public QMNNoteCategory(String paramString1, String paramString2, int paramInt)
  {
    this(paramString1, paramString2);
    setCatalogPos(paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = (QMNNoteCategory)paramObject;
    return (this.catalogId.equals(paramObject.getCatalogId())) && (this.catalogName.equals(paramObject.getCatalogName()));
  }
  
  public String getCatalogId()
  {
    return this.catalogId;
  }
  
  public String getCatalogName()
  {
    return this.catalogName;
  }
  
  public int getCatalogPos()
  {
    return this.catalogPos;
  }
  
  public boolean parseWithDictionary(JSONObject paramJSONObject)
  {
    boolean bool2 = false;
    String str = (String)paramJSONObject.get("cid");
    boolean bool1 = bool2;
    if (str != null)
    {
      bool1 = bool2;
      if (!str.equals(this.catalogId))
      {
        this.catalogId = str;
        bool1 = true;
      }
    }
    paramJSONObject = (String)paramJSONObject.get("cnm");
    bool2 = bool1;
    if (paramJSONObject != null)
    {
      bool2 = bool1;
      if (!paramJSONObject.equals(this.catalogName))
      {
        this.catalogName = paramJSONObject;
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public boolean replaceCatalogName(String paramString)
  {
    if (this.catalogName.equals(paramString)) {
      return false;
    }
    setCatalogName(paramString);
    return true;
  }
  
  public void setCatalogId(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("not null");
    }
    this.catalogId = paramString;
  }
  
  public void setCatalogName(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("not null");
    }
    this.catalogName = paramString;
  }
  
  public void setCatalogPos(int paramInt)
  {
    this.catalogPos = paramInt;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("{");
    localStringBuffer.append("\"class\":\"QMNNoteCategory\"");
    if (this.catalogId != null) {
      localStringBuffer.append(",\"cid\":\"" + this.catalogId + "\"");
    }
    if (this.catalogName != null) {
      localStringBuffer.append(",\"cnm\":\"" + this.catalogName + "\"");
    }
    localStringBuffer.append("}");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.qmdomain.QMNNoteCategory
 * JD-Core Version:    0.7.0.1
 */