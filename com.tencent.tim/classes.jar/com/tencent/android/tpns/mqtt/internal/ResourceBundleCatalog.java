package com.tencent.android.tpns.mqtt.internal;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ResourceBundleCatalog
  extends MessageCatalog
{
  private ResourceBundle bundle = ResourceBundle.getBundle("com.tencent.android.tpns.mqtt.internal.nls.messages");
  
  protected String getLocalizedMessage(int paramInt)
  {
    try
    {
      String str = this.bundle.getString(Integer.toString(paramInt));
      return str;
    }
    catch (MissingResourceException localMissingResourceException) {}
    return "MqttException";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.ResourceBundleCatalog
 * JD-Core Version:    0.7.0.1
 */