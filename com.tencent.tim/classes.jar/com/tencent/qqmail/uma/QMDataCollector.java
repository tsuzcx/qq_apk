package com.tencent.qqmail.uma;

public class QMDataCollector
{
  private static int BUFFER_MAX_SIZE = 1000;
  private static long FILE_MAX_SIZE = 2097152L;
  private static StringBuilder buffer = new StringBuilder();
  
  private void appendLog(int paramInt, String paramString, String... paramVarArgs) {}
  
  private void flushBuffer() {}
  
  private String logFilePath()
  {
    return "/data/data/com.tencent.androidqqmail/cache/remotelog";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.uma.QMDataCollector
 * JD-Core Version:    0.7.0.1
 */