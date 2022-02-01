package com.tencent.qqmail.utilities.log;

import java.util.Comparator;

class LogPathManager$2
  implements Comparator<LogPathManager.PathData>
{
  LogPathManager$2(LogPathManager paramLogPathManager) {}
  
  public int compare(LogPathManager.PathData paramPathData1, LogPathManager.PathData paramPathData2)
  {
    return paramPathData2.suggestedName.compareTo(paramPathData1.suggestedName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.log.LogPathManager.2
 * JD-Core Version:    0.7.0.1
 */