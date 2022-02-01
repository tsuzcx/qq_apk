package com.tencent.thumbplayer.utils;

import android.text.TextUtils;
import com.tencent.thumbplayer.common.report.ITPReportProperties;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class TPProperties
  implements ITPReportProperties
{
  private static final String TAG = "TPProperties";
  protected final Properties properties = new Properties();
  
  public TPProperties()
  {
    this((Properties)null);
  }
  
  public TPProperties(String paramString1, String paramString2)
  {
    this(new TPProperties.1(paramString1, paramString2));
  }
  
  public TPProperties(Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        put((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
  }
  
  public TPProperties(Properties paramProperties)
  {
    if (paramProperties != null)
    {
      paramProperties = paramProperties.entrySet().iterator();
      while (paramProperties.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramProperties.next();
        put((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
  }
  
  public TPProperties(Object... paramVarArgs)
  {
    int j = paramVarArgs.length;
    if (j % 2 != 0) {
      throw new IllegalArgumentException("Supplied arguments must be even");
    }
    int i = 0;
    while (i < j)
    {
      put(String.valueOf(paramVarArgs[i]), String.valueOf(paramVarArgs[(i + 1)]));
      i += 2;
    }
  }
  
  public Properties getProperties()
  {
    return this.properties;
  }
  
  public boolean has(String paramString)
  {
    if (paramString == null) {}
    while (this.properties.get(paramString) == null) {
      return false;
    }
    return true;
  }
  
  public void propertiesToMap(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      throw new IllegalArgumentException("map must not be null!");
    }
    Iterator localIterator = this.properties.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      Object localObject1 = ((Map.Entry)localObject2).getKey();
      localObject2 = ((Map.Entry)localObject2).getValue();
      if (localObject2 == null) {
        paramMap.put(localObject1.toString(), "");
      } else {
        paramMap.put(localObject1.toString(), localObject2.toString());
      }
    }
  }
  
  public void put(String paramString, float paramFloat)
  {
    if (paramString != null) {
      this.properties.put(paramString, String.valueOf(paramFloat));
    }
  }
  
  public void put(String paramString, int paramInt)
  {
    if (paramString != null) {
      this.properties.put(paramString, String.valueOf(paramInt));
    }
  }
  
  public void put(String paramString, long paramLong)
  {
    if (paramString != null) {
      this.properties.put(paramString, String.valueOf(paramLong));
    }
  }
  
  public void put(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if (!TextUtils.isEmpty(paramString2)) {
        this.properties.put(paramString1, paramString2);
      }
    }
    else {
      return;
    }
    this.properties.put(paramString1, "");
  }
  
  public void put(String paramString, Properties paramProperties)
  {
    if (paramString != null) {
      this.properties.put(paramString, paramProperties);
    }
  }
  
  public void put(String paramString, JSONObject paramJSONObject)
  {
    if (paramString != null) {
      this.properties.put(paramString, paramJSONObject);
    }
  }
  
  public String toString()
  {
    JSONObject localJSONObject = new JSONObject(this.properties);
    if (localJSONObject.has("data")) {}
    try
    {
      String str = localJSONObject.getString("data");
      localJSONObject.remove("data");
      localJSONObject.put("data", new JSONObject(str));
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        TPLogUtil.e("TPProperties", localJSONException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.TPProperties
 * JD-Core Version:    0.7.0.1
 */