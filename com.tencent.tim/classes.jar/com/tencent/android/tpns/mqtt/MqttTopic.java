package com.tencent.android.tpns.mqtt;

import com.tencent.android.tpns.mqtt.internal.ClientComms;
import com.tencent.android.tpns.mqtt.internal.Token;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPublish;
import com.tencent.android.tpns.mqtt.util.Strings;
import java.io.UnsupportedEncodingException;

public class MqttTopic
{
  private static final int MAX_TOPIC_LEN = 65535;
  private static final int MIN_TOPIC_LEN = 1;
  public static final String MULTI_LEVEL_WILDCARD = "#";
  public static final String MULTI_LEVEL_WILDCARD_PATTERN = "/#";
  private static final char NUL = '\000';
  public static final String SINGLE_LEVEL_WILDCARD = "+";
  public static final String TOPIC_LEVEL_SEPARATOR = "/";
  public static final String TOPIC_WILDCARDS = "#+";
  private ClientComms comms;
  private String name;
  
  public MqttTopic(String paramString, ClientComms paramClientComms)
  {
    this.comms = paramClientComms;
    this.name = paramString;
  }
  
  private MqttPublish createPublish(MqttMessage paramMqttMessage)
  {
    return new MqttPublish(getName(), paramMqttMessage);
  }
  
  public static boolean isMatched(String paramString1, String paramString2)
    throws IllegalArgumentException
  {
    int n = paramString2.length();
    int i1 = paramString1.length();
    validate(paramString1, true);
    validate(paramString2, false);
    int i;
    int j;
    int k;
    if (paramString1.equals(paramString2))
    {
      return true;
      j = i;
      if (paramString1.charAt(k) == '#') {
        j = n - 1;
      }
      i = j + 1;
      k += 1;
    }
    for (;;)
    {
      if ((k >= i1) || (i >= n) || ((paramString2.charAt(i) == '/') && (paramString1.charAt(k) != '/'))) {
        label94:
        if ((i != n) || (k != i1)) {
          break label201;
        }
      }
      label201:
      for (boolean bool = true;; bool = false)
      {
        return bool;
        if ((paramString1.charAt(k) != '+') && (paramString1.charAt(k) != '#') && (paramString1.charAt(k) != paramString2.charAt(i))) {
          break label94;
        }
        if (paramString1.charAt(k) != '+') {
          break;
        }
        for (int m = i + 1;; m = j + 1)
        {
          j = i;
          if (m >= n) {
            break;
          }
          j = i;
          if (paramString2.charAt(m) == '/') {
            break;
          }
          j = i + 1;
          i = j;
        }
      }
      k = 0;
      i = 0;
    }
  }
  
  public static void validate(String paramString, boolean paramBoolean)
    throws IllegalArgumentException
  {
    try
    {
      int i = paramString.getBytes("UTF-8").length;
      if ((i < 1) || (i > 65535)) {
        throw new IllegalArgumentException(String.format("Invalid topic length, should be in range[%d, %d]!", new Object[] { new Integer(1), new Integer(65535) }));
      }
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new IllegalStateException(paramString.getMessage());
    }
    if (paramBoolean) {
      if (!Strings.equalsAny(paramString, new String[] { "#", "+" })) {}
    }
    while (!Strings.containsAny(paramString, "#+"))
    {
      return;
      if ((Strings.countMatches(paramString, "#") > 1) || ((paramString.contains("#")) && (!paramString.endsWith("/#")))) {
        throw new IllegalArgumentException("Invalid usage of multi-level wildcard in topic string: " + paramString);
      }
      validateSingleLevelWildcard(paramString);
      return;
    }
    throw new IllegalArgumentException("The topic name MUST NOT contain any wildcard characters (#+)");
  }
  
  private static void validateSingleLevelWildcard(String paramString)
  {
    int m = "+".charAt(0);
    int n = "/".charAt(0);
    char[] arrayOfChar = paramString.toCharArray();
    int i1 = arrayOfChar.length;
    int i = 0;
    while (i < i1)
    {
      int j;
      if (i - 1 >= 0)
      {
        j = arrayOfChar[(i - 1)];
        if (i + 1 >= i1) {
          break label118;
        }
      }
      label118:
      for (int k = arrayOfChar[(i + 1)];; k = 0)
      {
        if ((arrayOfChar[i] != m) || (((j == n) || (j == 0)) && ((k == n) || (k == 0)))) {
          break label123;
        }
        throw new IllegalArgumentException(String.format("Invalid usage of single-level wildcard in topic string '%s'!", new Object[] { paramString }));
        j = 0;
        break;
      }
      label123:
      i += 1;
    }
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public MqttDeliveryToken publish(MqttMessage paramMqttMessage)
    throws MqttException, MqttPersistenceException
  {
    MqttDeliveryToken localMqttDeliveryToken = new MqttDeliveryToken(this.comms.getClient().getClientId());
    localMqttDeliveryToken.setMessage(paramMqttMessage);
    this.comms.sendNoWait(createPublish(paramMqttMessage), localMqttDeliveryToken);
    localMqttDeliveryToken.internalTok.waitUntilSent();
    return localMqttDeliveryToken;
  }
  
  public MqttDeliveryToken publish(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
    throws MqttException, MqttPersistenceException
  {
    paramArrayOfByte = new MqttMessage(paramArrayOfByte);
    paramArrayOfByte.setQos(paramInt);
    paramArrayOfByte.setRetained(paramBoolean);
    return publish(paramArrayOfByte);
  }
  
  public String toString()
  {
    return getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.MqttTopic
 * JD-Core Version:    0.7.0.1
 */