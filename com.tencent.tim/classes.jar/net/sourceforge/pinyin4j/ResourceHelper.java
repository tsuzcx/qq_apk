package net.sourceforge.pinyin4j;

import java.io.BufferedInputStream;

class ResourceHelper
{
  static Class class$net$sourceforge$pinyin4j$ResourceHelper;
  
  static Class class$(String paramString)
  {
    try
    {
      paramString = Class.forName(paramString);
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      throw new NoClassDefFoundError(paramString.getMessage());
    }
  }
  
  static BufferedInputStream getResourceInputStream(String paramString)
  {
    Class localClass;
    if (class$net$sourceforge$pinyin4j$ResourceHelper == null)
    {
      localClass = class$("net.sourceforge.pinyin4j.ResourceHelper");
      class$net$sourceforge$pinyin4j$ResourceHelper = localClass;
    }
    for (;;)
    {
      return new BufferedInputStream(localClass.getResourceAsStream(paramString));
      localClass = class$net$sourceforge$pinyin4j$ResourceHelper;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.sourceforge.pinyin4j.ResourceHelper
 * JD-Core Version:    0.7.0.1
 */