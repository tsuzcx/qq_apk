package com.tencent.acstat.a.a;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class a
{
  static File a(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      return paramString;
    }
    if (!paramString.getParentFile().exists()) {
      a(paramString.getParentFile().getAbsolutePath());
    }
    paramString.mkdir();
    return paramString;
  }
  
  static List<String> a(File paramFile)
    throws IOException
  {
    paramFile = new FileReader(paramFile);
    BufferedReader localBufferedReader = new BufferedReader(paramFile);
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      String str = localBufferedReader.readLine();
      if (str == null)
      {
        paramFile.close();
        localBufferedReader.close();
        return localArrayList;
      }
      localArrayList.add(str.trim());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.acstat.a.a.a
 * JD-Core Version:    0.7.0.1
 */