package org.apache.commons.lang3.text;

import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

public abstract class StrLookup<V>
{
  private static final StrLookup<String> NONE_LOOKUP = new MapStrLookup(null);
  
  private static Properties copyProperties(Properties paramProperties)
  {
    if (paramProperties == null) {
      return null;
    }
    Properties localProperties = new Properties();
    Enumeration localEnumeration = paramProperties.propertyNames();
    while (localEnumeration.hasMoreElements())
    {
      String str = (String)localEnumeration.nextElement();
      localProperties.setProperty(str, paramProperties.getProperty(str));
    }
    return localProperties;
  }
  
  public static <V> StrLookup<V> mapLookup(Map<String, V> paramMap)
  {
    return new MapStrLookup(paramMap);
  }
  
  public static StrLookup<?> noneLookup()
  {
    return NONE_LOOKUP;
  }
  
  public static StrLookup<String> systemPropertiesLookup()
  {
    Object localObject = null;
    try
    {
      Properties localProperties = System.getProperties();
      localObject = localProperties;
    }
    catch (SecurityException localSecurityException)
    {
      label8:
      break label8;
    }
    return new MapStrLookup(copyProperties(localObject));
  }
  
  public abstract String lookup(String paramString);
  
  static class MapStrLookup<V>
    extends StrLookup<V>
  {
    private final Map<String, V> map;
    
    MapStrLookup(Map<String, V> paramMap)
    {
      this.map = paramMap;
    }
    
    public String lookup(String paramString)
    {
      if (this.map == null) {}
      do
      {
        return null;
        paramString = this.map.get(paramString);
      } while (paramString == null);
      return paramString.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.text.StrLookup
 * JD-Core Version:    0.7.0.1
 */