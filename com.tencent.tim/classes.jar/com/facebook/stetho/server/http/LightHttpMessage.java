package com.facebook.stetho.server.http;

import android.support.annotation.Nullable;
import java.util.ArrayList;

public class LightHttpMessage
{
  public final ArrayList<String> headerNames = new ArrayList();
  public final ArrayList<String> headerValues = new ArrayList();
  
  public void addHeader(String paramString1, String paramString2)
  {
    this.headerNames.add(paramString1);
    this.headerValues.add(paramString2);
  }
  
  @Nullable
  public String getFirstHeaderValue(String paramString)
  {
    int i = 0;
    int j = this.headerNames.size();
    while (i < j)
    {
      if (paramString.equals(this.headerNames.get(i))) {
        return (String)this.headerValues.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  public void reset()
  {
    this.headerNames.clear();
    this.headerValues.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.server.http.LightHttpMessage
 * JD-Core Version:    0.7.0.1
 */