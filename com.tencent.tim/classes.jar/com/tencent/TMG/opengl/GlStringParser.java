package com.tencent.TMG.opengl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class GlStringParser
{
  private Map<String, String> mMap;
  private char mend = '\t';
  private char mkey = '\r';
  
  public GlStringParser()
  {
    this.mkey = '\r';
    this.mend = '\t';
    this.mMap = new HashMap();
  }
  
  public GlStringParser(char paramChar1, char paramChar2)
  {
    this.mkey = paramChar1;
    this.mend = paramChar2;
    this.mMap = new HashMap();
  }
  
  public GlStringParser(String paramString)
  {
    this.mMap = new HashMap();
    unflatten(paramString);
  }
  
  public GlStringParser(Map<String, String> paramMap)
  {
    this.mMap = paramMap;
  }
  
  public String flatten()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.mMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localStringBuilder.append(str);
      localStringBuilder.append(this.mkey);
      localStringBuilder.append((String)this.mMap.get(str));
      localStringBuilder.append(this.mend);
    }
    localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    return localStringBuilder.toString();
  }
  
  public String get(String paramString)
  {
    return (String)this.mMap.get(paramString);
  }
  
  public Boolean getBoolean(String paramString)
  {
    paramString = (String)this.mMap.get(paramString);
    if ((paramString != null) && ((paramString.equals("true")) || (paramString.equals("false")))) {
      return Boolean.valueOf(paramString);
    }
    return Boolean.valueOf(false);
  }
  
  public int getInt(String paramString)
  {
    paramString = (String)this.mMap.get(paramString);
    if (paramString != null) {
      return Integer.parseInt(paramString);
    }
    return 0;
  }
  
  public Map<String, String> getMap()
  {
    return this.mMap;
  }
  
  public void remove(String paramString)
  {
    this.mMap.remove(paramString);
  }
  
  public void set(String paramString, int paramInt)
  {
    this.mMap.put(paramString, Integer.toString(paramInt));
  }
  
  public void set(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.indexOf(this.mend) != -1) || (paramString1.indexOf(this.mkey) != -1)) {}
    while ((paramString2 == null) || (paramString2.indexOf(this.mkey) != -1) || (paramString2.indexOf(this.mend) != -1)) {
      return;
    }
    this.mMap.put(paramString1, paramString2);
  }
  
  public void unflatten(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return;
      this.mMap.clear();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.mend);
      paramString = new StringTokenizer(paramString, ((StringBuilder)localObject).toString());
      while (paramString.hasMoreElements())
      {
        String str = paramString.nextToken();
        int i = str.indexOf(this.mkey);
        if (i != -1)
        {
          localObject = str.substring(0, i);
          str = str.substring(i + 1);
          this.mMap.put(localObject, str);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.TMG.opengl.GlStringParser
 * JD-Core Version:    0.7.0.1
 */