package com.tencent.qqlive.module.videoreport.data;

import java.util.Map;

public class DataEntity
{
  String elementId;
  Map<String, Object> elementParams;
  Map<String, Object> innerParams;
  String pageContentId;
  String pageId;
  Map<String, Object> pageParams;
  
  public String toString()
  {
    return "DataEntity{elementId='" + this.elementId + '\'' + ", elementParams=" + this.elementParams + ", pageId='" + this.pageId + '\'' + ", pageContentId='" + this.pageContentId + '\'' + ", pageParams=" + this.pageParams + ", innerParams=" + this.innerParams + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.data.DataEntity
 * JD-Core Version:    0.7.0.1
 */