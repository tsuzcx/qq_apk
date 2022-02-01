package com.tencent.qqmail.utilities.translate;

import com.tencent.qqmail.QMApplicationContext;

public class TranslateManager
{
  public static final int CLIENT_REGISTER = 0;
  public static final int DETECT = 1;
  public static final String KEY_MAIL = "mail";
  public static final String KEY_RESULT = "result";
  public static final String KEY_SUCCESS = "success";
  public static final int RESULT_BACK = 2;
  private static TranslateHandlerFactory sFactory;
  
  private static TranslateHandlerFactory getFactory()
  {
    if (sFactory == null)
    {
      if (!QMApplicationContext.sharedInstance().isMainProcess()) {
        break label29;
      }
      sFactory = new ClientTranslateHandlerFactory();
    }
    for (;;)
    {
      return sFactory;
      label29:
      if (QMApplicationContext.sharedInstance().isToolsProcess()) {
        sFactory = new ServerTranslateHandlerFactory();
      }
    }
  }
  
  public static boolean isFroeignLanguageSupport(String paramString)
    throws Throwable
  {
    TranslateHandlerFactory localTranslateHandlerFactory = getFactory();
    if (localTranslateHandlerFactory == null) {
      return false;
    }
    return localTranslateHandlerFactory.createTranslateHandler().isFroeignLanguageSupport(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.translate.TranslateManager
 * JD-Core Version:    0.7.0.1
 */