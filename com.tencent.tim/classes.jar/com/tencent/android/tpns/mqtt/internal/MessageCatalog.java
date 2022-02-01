package com.tencent.android.tpns.mqtt.internal;

public abstract class MessageCatalog
{
  private static MessageCatalog INSTANCE = null;
  
  public static final String getMessage(int paramInt)
  {
    if ((INSTANCE != null) || (ExceptionHelper.isClassAvailable("java.util.ResourceBundle"))) {}
    for (;;)
    {
      try
      {
        INSTANCE = (MessageCatalog)Class.forName("com.tencent.android.tpns.mqtt.internal.ResourceBundleCatalog").newInstance();
        return INSTANCE.getLocalizedMessage(paramInt);
      }
      catch (Throwable localThrowable1)
      {
        return "";
      }
      if (ExceptionHelper.isClassAvailable("com.tencent.android.tpns.mqtt.internal.MIDPCatalog")) {
        try
        {
          INSTANCE = (MessageCatalog)Class.forName("com.tencent.android.tpns.mqtt.internal.MIDPCatalog").newInstance();
        }
        catch (Throwable localThrowable2) {}
      }
    }
    return "";
  }
  
  protected abstract String getLocalizedMessage(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.MessageCatalog
 * JD-Core Version:    0.7.0.1
 */