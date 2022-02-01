package com.tencent.wordsegment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex
{
  Pattern _pattern;
  
  public boolean init(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return false;
      try
      {
        this._pattern = Pattern.compile(paramString);
        if (this._pattern == null) {
          continue;
        }
        return true;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          this._pattern = null;
        }
      }
    }
  }
  
  public boolean match(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      do
      {
        return false;
      } while (this._pattern == null);
      paramString = this._pattern.matcher(paramString);
    } while ((paramString == null) || (!paramString.find()));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.wordsegment.Regex
 * JD-Core Version:    0.7.0.1
 */