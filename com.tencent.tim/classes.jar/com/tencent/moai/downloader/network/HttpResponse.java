package com.tencent.moai.downloader.network;

import java.util.List;
import java.util.Map;

public class HttpResponse
{
  private Map<String, List<String>> responseHeader;
  
  public String getHeaderField(String paramString)
  {
    if ((this.responseHeader == null) || (this.responseHeader.size() == 0)) {
      return "";
    }
    paramString = (List)this.responseHeader.get(paramString);
    if ((paramString == null) || (paramString.size() == 0)) {
      return "";
    }
    return (String)paramString.get(0);
  }
  
  public Map<String, List<String>> getResponseHeader()
  {
    return this.responseHeader;
  }
  
  public void setResponseHeader(Map<String, List<String>> paramMap)
  {
    this.responseHeader = paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.downloader.network.HttpResponse
 * JD-Core Version:    0.7.0.1
 */