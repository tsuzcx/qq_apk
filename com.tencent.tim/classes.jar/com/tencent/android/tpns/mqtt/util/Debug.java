package com.tencent.android.tpns.mqtt.util;

import com.tencent.android.tpns.mqtt.MqttConnectOptions;
import com.tencent.android.tpns.mqtt.internal.ClientComms;
import com.tencent.android.tpns.mqtt.internal.ClientState;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import java.util.Enumeration;
import java.util.Properties;

public class Debug
{
  private static final String CLASS_NAME = "ClientComms";
  private static final String lineSep = System.getProperty("line.separator", "\n");
  private static final Logger log = LoggerFactory.getLogger("com.tencent.android.tpns.mqtt.internal.nls.logcat", "ClientComms");
  private static final String separator = "==============";
  private String clientID;
  private ClientComms comms;
  
  public Debug(String paramString, ClientComms paramClientComms)
  {
    this.clientID = paramString;
    this.comms = paramClientComms;
    log.setResourceName(paramString);
  }
  
  public static String dumpProperties(Properties paramProperties, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Enumeration localEnumeration = paramProperties.propertyNames();
    localStringBuffer.append(lineSep + "==============" + " " + paramString + " " + "==============" + lineSep);
    while (localEnumeration.hasMoreElements())
    {
      paramString = (String)localEnumeration.nextElement();
      localStringBuffer.append(left(paramString, 28, ' ') + ":  " + paramProperties.get(paramString) + lineSep);
    }
    localStringBuffer.append("==========================================" + lineSep);
    return localStringBuffer.toString();
  }
  
  public static String left(String paramString, int paramInt, char paramChar)
  {
    if (paramString.length() >= paramInt) {
      return paramString;
    }
    StringBuffer localStringBuffer = new StringBuffer(paramInt);
    localStringBuffer.append(paramString);
    paramInt -= paramString.length();
    for (;;)
    {
      paramInt -= 1;
      if (paramInt < 0) {
        break;
      }
      localStringBuffer.append(paramChar);
    }
    return localStringBuffer.toString();
  }
  
  public void dumpBaseDebug()
  {
    dumpVersion();
    dumpSystemProperties();
    dumpMemoryTrace();
  }
  
  public void dumpClientComms()
  {
    if (this.comms != null)
    {
      Properties localProperties = this.comms.getDebug();
      log.fine("ClientComms", "dumpClientComms", dumpProperties(localProperties, this.clientID + " : ClientComms").toString());
    }
  }
  
  public void dumpClientDebug()
  {
    dumpClientComms();
    dumpConOptions();
    dumpClientState();
    dumpBaseDebug();
  }
  
  public void dumpClientState()
  {
    if ((this.comms != null) && (this.comms.getClientState() != null))
    {
      Properties localProperties = this.comms.getClientState().getDebug();
      log.fine("ClientComms", "dumpClientState", dumpProperties(localProperties, this.clientID + " : ClientState").toString());
    }
  }
  
  public void dumpConOptions()
  {
    if (this.comms != null)
    {
      Properties localProperties = this.comms.getConOptions().getDebug();
      log.fine("ClientComms", "dumpConOptions", dumpProperties(localProperties, this.clientID + " : Connect Options").toString());
    }
  }
  
  protected void dumpMemoryTrace()
  {
    log.dumpTrace();
  }
  
  public void dumpSystemProperties()
  {
    Properties localProperties = System.getProperties();
    log.fine("ClientComms", "dumpSystemProperties", dumpProperties(localProperties, "SystemProperties").toString());
  }
  
  protected void dumpVersion()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(lineSep + "==============" + " Version Info " + "==============" + lineSep);
    localStringBuffer.append(left("Version", 20, ' ') + ":  " + ClientComms.VERSION + lineSep);
    localStringBuffer.append(left("Build Level", 20, ' ') + ":  " + ClientComms.BUILD_LEVEL + lineSep);
    localStringBuffer.append("==========================================" + lineSep);
    log.fine("ClientComms", "dumpVersion", localStringBuffer.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.util.Debug
 * JD-Core Version:    0.7.0.1
 */