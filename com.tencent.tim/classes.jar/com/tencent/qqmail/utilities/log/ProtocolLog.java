package com.tencent.qqmail.utilities.log;

import moai.log.FileHandler;
import moai.log.Handler;
import moai.log.MLog;
import moai.log.MLogManager;

public class ProtocolLog
{
  private static FileHandler fileHandler;
  private static MLog logger = MLogManager.getLogger("qqmailProtocol");
  
  static
  {
    fileHandler = MLogConfiguration.createFileHandler(LogPathManager.getInstance().getProtocolLogDirPath());
    Object localObject = new ProtocolLog.1();
    logger.addHandler((Handler)localObject);
    localObject = MLogConfiguration.getInstance();
    ((MLogConfiguration)localObject).update(logger);
    ((MLogConfiguration)localObject).monitor(logger);
  }
  
  public static void flush()
  {
    fileHandler.flush();
  }
  
  public static void log(int paramInt, String paramString1, String paramString2)
  {
    logger.println(paramInt, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.log.ProtocolLog
 * JD-Core Version:    0.7.0.1
 */