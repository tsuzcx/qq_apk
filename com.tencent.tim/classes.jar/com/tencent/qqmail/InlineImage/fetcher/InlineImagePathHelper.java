package com.tencent.qqmail.InlineImage.fetcher;

import androidx.annotation.NonNull;
import java.util.HashMap;

public class InlineImagePathHelper
{
  public static HashMap<String, String> url_path_map = new HashMap();
  
  public static void clean()
  {
    url_path_map.clear();
  }
  
  public static String get(@NonNull String paramString)
  {
    return (String)url_path_map.get(paramString);
  }
  
  public static void put(@NonNull String paramString1, @NonNull String paramString2)
  {
    url_path_map.put(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.InlineImage.fetcher.InlineImagePathHelper
 * JD-Core Version:    0.7.0.1
 */