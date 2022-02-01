package com.tencent.android.tpns.mqtt.internal;

import com.tencent.android.tpns.mqtt.MqttDeliveryToken;
import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.MqttToken;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPublish;
import com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class CommsTokenStore
{
  private static final String CLASS_NAME = "CommsTokenStore";
  private static final Logger log = LoggerFactory.getLogger("com.tencent.android.tpns.mqtt.internal.nls.logcat", "CommsTokenStore");
  private MqttException closedResponse = null;
  private String logContext;
  private Hashtable tokens;
  
  public CommsTokenStore(String paramString)
  {
    log.setResourceName(paramString);
    this.tokens = new Hashtable();
    this.logContext = paramString;
    log.fine("CommsTokenStore", "<Init>", "308");
  }
  
  public void clear()
  {
    log.fine("CommsTokenStore", "clear", "305", new Object[] { new Integer(this.tokens.size()) });
    synchronized (this.tokens)
    {
      this.tokens.clear();
      return;
    }
  }
  
  public int count()
  {
    synchronized (this.tokens)
    {
      int i = this.tokens.size();
      return i;
    }
  }
  
  public MqttDeliveryToken[] getOutstandingDelTokens()
  {
    synchronized (this.tokens)
    {
      log.fine("CommsTokenStore", "getOutstandingDelTokens", "311");
      Vector localVector = new Vector();
      Enumeration localEnumeration = this.tokens.elements();
      while (localEnumeration.hasMoreElements())
      {
        MqttToken localMqttToken = (MqttToken)localEnumeration.nextElement();
        if ((localMqttToken != null) && ((localMqttToken instanceof MqttDeliveryToken)) && (!localMqttToken.internalTok.isNotified())) {
          localVector.addElement(localMqttToken);
        }
      }
    }
    MqttDeliveryToken[] arrayOfMqttDeliveryToken = (MqttDeliveryToken[])localObject.toArray(new MqttDeliveryToken[localObject.size()]);
    return arrayOfMqttDeliveryToken;
  }
  
  public Vector getOutstandingTokens()
  {
    synchronized (this.tokens)
    {
      log.fine("CommsTokenStore", "getOutstandingTokens", "312");
      Vector localVector1 = new Vector();
      Enumeration localEnumeration = this.tokens.elements();
      while (localEnumeration.hasMoreElements())
      {
        MqttToken localMqttToken = (MqttToken)localEnumeration.nextElement();
        if (localMqttToken != null) {
          localVector1.addElement(localMqttToken);
        }
      }
    }
    return localVector2;
  }
  
  public MqttToken getToken(MqttWireMessage paramMqttWireMessage)
  {
    paramMqttWireMessage = paramMqttWireMessage.getKey();
    return (MqttToken)this.tokens.get(paramMqttWireMessage);
  }
  
  public MqttToken getToken(String paramString)
  {
    return (MqttToken)this.tokens.get(paramString);
  }
  
  public void open()
  {
    synchronized (this.tokens)
    {
      log.fine("CommsTokenStore", "open", "310");
      this.closedResponse = null;
      return;
    }
  }
  
  protected void quiesce(MqttException paramMqttException)
  {
    synchronized (this.tokens)
    {
      log.fine("CommsTokenStore", "quiesce", "309", new Object[] { paramMqttException });
      this.closedResponse = paramMqttException;
      return;
    }
  }
  
  public MqttToken removeToken(MqttWireMessage paramMqttWireMessage)
  {
    if (paramMqttWireMessage != null) {
      return removeToken(paramMqttWireMessage.getKey());
    }
    return null;
  }
  
  public MqttToken removeToken(String paramString)
  {
    log.fine("CommsTokenStore", "removeToken", "306", new Object[] { paramString });
    if (paramString != null) {
      return (MqttToken)this.tokens.remove(paramString);
    }
    return null;
  }
  
  protected MqttDeliveryToken restoreToken(MqttPublish paramMqttPublish)
  {
    synchronized (this.tokens)
    {
      String str = new Integer(paramMqttPublish.getMessageId()).toString();
      if (this.tokens.containsKey(str))
      {
        localMqttDeliveryToken = (MqttDeliveryToken)this.tokens.get(str);
        log.fine("CommsTokenStore", "restoreToken", "302", new Object[] { str, paramMqttPublish, localMqttDeliveryToken });
        paramMqttPublish = localMqttDeliveryToken;
        return paramMqttPublish;
      }
      MqttDeliveryToken localMqttDeliveryToken = new MqttDeliveryToken(this.logContext);
      localMqttDeliveryToken.internalTok.setKey(str);
      this.tokens.put(str, localMqttDeliveryToken);
      log.fine("CommsTokenStore", "restoreToken", "303", new Object[] { str, paramMqttPublish, localMqttDeliveryToken });
      paramMqttPublish = localMqttDeliveryToken;
    }
  }
  
  protected void saveToken(MqttToken paramMqttToken, MqttWireMessage paramMqttWireMessage)
    throws MqttException
  {
    synchronized (this.tokens)
    {
      if (this.closedResponse == null)
      {
        String str = paramMqttWireMessage.getKey();
        log.fine("CommsTokenStore", "saveToken", "300", new Object[] { str, paramMqttWireMessage });
        saveToken(paramMqttToken, str);
        return;
      }
      throw this.closedResponse;
    }
  }
  
  protected void saveToken(MqttToken paramMqttToken, String paramString)
  {
    synchronized (this.tokens)
    {
      log.fine("CommsTokenStore", "saveToken", "307", new Object[] { paramString, paramMqttToken.toString() });
      paramMqttToken.internalTok.setKey(paramString);
      this.tokens.put(paramString, paramMqttToken);
      return;
    }
  }
  
  public String toString()
  {
    String str1 = System.getProperty("line.separator", "\n");
    StringBuffer localStringBuffer = new StringBuffer();
    synchronized (this.tokens)
    {
      Enumeration localEnumeration = this.tokens.elements();
      if (localEnumeration.hasMoreElements())
      {
        MqttToken localMqttToken = (MqttToken)localEnumeration.nextElement();
        localStringBuffer.append("{" + localMqttToken.internalTok + "}" + str1);
      }
    }
    String str2 = localStringBuffer.toString();
    return str2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.CommsTokenStore
 * JD-Core Version:    0.7.0.1
 */