package com.tencent.qqmail.utilities.translate;

public class ServerTranslateHandler
  implements ITranslateHandler
{
  private static final String[] SERVER_SUPPORT_LANGUAGES = { "fr", "ko", "en", "ja", "es", "de" };
  private static final String TAG = "ServerTranslateHandler";
  
  public static ServerTranslateHandler getInstance()
  {
    return Singleton.sInstance;
  }
  
  public boolean isFroeignLanguageSupport(String paramString)
    throws Throwable
  {
    return true;
  }
  
  static class Singleton
  {
    static ServerTranslateHandler sInstance = new ServerTranslateHandler(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.translate.ServerTranslateHandler
 * JD-Core Version:    0.7.0.1
 */