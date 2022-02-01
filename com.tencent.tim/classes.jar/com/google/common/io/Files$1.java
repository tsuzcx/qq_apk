package com.google.common.io;

import com.google.common.collect.Lists;
import java.util.List;

final class Files$1
  implements LineProcessor<List<String>>
{
  final List<String> result = Lists.newArrayList();
  
  public List<String> getResult()
  {
    return this.result;
  }
  
  public boolean processLine(String paramString)
  {
    this.result.add(paramString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.io.Files.1
 * JD-Core Version:    0.7.0.1
 */