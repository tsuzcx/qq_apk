package com.facebook.stetho.inspector.console;

import com.facebook.stetho.common.LogRedirector;
import com.facebook.stetho.inspector.helper.ChromePeerManager;
import com.facebook.stetho.inspector.protocol.module.Console.ConsoleMessage;
import com.facebook.stetho.inspector.protocol.module.Console.MessageAddedRequest;
import com.facebook.stetho.inspector.protocol.module.Console.MessageLevel;
import com.facebook.stetho.inspector.protocol.module.Console.MessageSource;

public class CLog
{
  private static final String TAG = "CLog";
  
  public static void writeToConsole(ChromePeerManager paramChromePeerManager, Console.MessageLevel paramMessageLevel, Console.MessageSource paramMessageSource, String paramString)
  {
    LogRedirector.d("CLog", paramString);
    Console.ConsoleMessage localConsoleMessage = new Console.ConsoleMessage();
    localConsoleMessage.source = paramMessageSource;
    localConsoleMessage.level = paramMessageLevel;
    localConsoleMessage.text = paramString;
    paramMessageLevel = new Console.MessageAddedRequest();
    paramMessageLevel.message = localConsoleMessage;
    paramChromePeerManager.sendNotificationToPeers("Console.messageAdded", paramMessageLevel);
  }
  
  public static void writeToConsole(Console.MessageLevel paramMessageLevel, Console.MessageSource paramMessageSource, String paramString)
  {
    ConsolePeerManager localConsolePeerManager = ConsolePeerManager.getInstanceOrNull();
    if (localConsolePeerManager == null) {
      return;
    }
    writeToConsole(localConsolePeerManager, paramMessageLevel, paramMessageSource, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.console.CLog
 * JD-Core Version:    0.7.0.1
 */