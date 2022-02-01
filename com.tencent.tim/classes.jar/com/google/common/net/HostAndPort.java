package com.google.common.net;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.io.Serializable;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Beta
@GwtCompatible
@Immutable
public final class HostAndPort
  implements Serializable
{
  private static final int NO_PORT = -1;
  private static final long serialVersionUID = 0L;
  private final boolean hasBracketlessColons;
  private final String host;
  private final int port;
  
  private HostAndPort(String paramString, int paramInt, boolean paramBoolean)
  {
    this.host = paramString;
    this.port = paramInt;
    this.hasBracketlessColons = paramBoolean;
  }
  
  public static HostAndPort fromHost(String paramString)
  {
    HostAndPort localHostAndPort = fromString(paramString);
    if (!localHostAndPort.hasPort()) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Host has a port: %s", paramString);
      return localHostAndPort;
    }
  }
  
  public static HostAndPort fromParts(String paramString, int paramInt)
  {
    Preconditions.checkArgument(isValidPort(paramInt), "Port out of range: %s", paramInt);
    HostAndPort localHostAndPort = fromString(paramString);
    if (!localHostAndPort.hasPort()) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Host has a port: %s", paramString);
      return new HostAndPort(localHostAndPort.host, paramInt, localHostAndPort.hasBracketlessColons);
    }
  }
  
  public static HostAndPort fromString(String paramString)
  {
    boolean bool2 = true;
    Preconditions.checkNotNull(paramString);
    Object localObject;
    String str;
    boolean bool1;
    if (paramString.startsWith("["))
    {
      localObject = getHostAndPortFromBracketedHost(paramString);
      str = localObject[0];
      localObject = localObject[1];
      bool1 = false;
      if (Strings.isNullOrEmpty((String)localObject)) {
        break label189;
      }
      if (((String)localObject).startsWith("+")) {
        break label155;
      }
      label54:
      Preconditions.checkArgument(bool2, "Unparseable port number: %s", paramString);
    }
    for (;;)
    {
      try
      {
        i = Integer.parseInt((String)localObject);
        Preconditions.checkArgument(isValidPort(i), "Port number out of range: %s", paramString);
        return new HostAndPort(str, i, bool1);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        label155:
        throw new IllegalArgumentException("Unparseable port number: " + paramString);
      }
      int i = paramString.indexOf(':');
      if ((i >= 0) && (paramString.indexOf(':', i + 1) == -1))
      {
        str = paramString.substring(0, i);
        localObject = paramString.substring(i + 1);
        bool1 = false;
        break;
      }
      if (i >= 0)
      {
        bool1 = true;
        localObject = null;
        str = paramString;
        break;
      }
      bool1 = false;
      continue;
      bool2 = false;
      break label54;
      label189:
      i = -1;
    }
  }
  
  private static String[] getHostAndPortFromBracketedHost(String paramString)
  {
    int i;
    int j;
    if (paramString.charAt(0) == '[')
    {
      bool = true;
      Preconditions.checkArgument(bool, "Bracketed host-port string must start with a bracket: %s", paramString);
      i = paramString.indexOf(':');
      j = paramString.lastIndexOf(']');
      if ((i <= -1) || (j <= i)) {
        break label90;
      }
    }
    String str;
    label90:
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Invalid bracketed host/port: %s", paramString);
      str = paramString.substring(1, j);
      if (j + 1 != paramString.length()) {
        break label95;
      }
      return new String[] { str, "" };
      bool = false;
      break;
    }
    label95:
    if (paramString.charAt(j + 1) == ':') {}
    for (bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Only a colon may follow a close bracket: %s", paramString);
      i = j + 2;
      while (i < paramString.length())
      {
        Preconditions.checkArgument(Character.isDigit(paramString.charAt(i)), "Port must be numeric: %s", paramString);
        i += 1;
      }
    }
    return new String[] { str, paramString.substring(j + 2) };
  }
  
  private static boolean isValidPort(int paramInt)
  {
    return (paramInt >= 0) && (paramInt <= 65535);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof HostAndPort)) {
        break;
      }
      paramObject = (HostAndPort)paramObject;
    } while ((Objects.equal(this.host, paramObject.host)) && (this.port == paramObject.port) && (this.hasBracketlessColons == paramObject.hasBracketlessColons));
    return false;
    return false;
  }
  
  public String getHost()
  {
    return this.host;
  }
  
  @Deprecated
  public String getHostText()
  {
    return this.host;
  }
  
  public int getPort()
  {
    Preconditions.checkState(hasPort());
    return this.port;
  }
  
  public int getPortOrDefault(int paramInt)
  {
    if (hasPort()) {
      paramInt = this.port;
    }
    return paramInt;
  }
  
  public boolean hasPort()
  {
    return this.port >= 0;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { this.host, Integer.valueOf(this.port), Boolean.valueOf(this.hasBracketlessColons) });
  }
  
  public HostAndPort requireBracketsForIPv6()
  {
    if (!this.hasBracketlessColons) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "Possible bracketless IPv6 literal: %s", this.host);
      return this;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(this.host.length() + 8);
    if (this.host.indexOf(':') >= 0) {
      localStringBuilder.append('[').append(this.host).append(']');
    }
    for (;;)
    {
      if (hasPort()) {
        localStringBuilder.append(':').append(this.port);
      }
      return localStringBuilder.toString();
      localStringBuilder.append(this.host);
    }
  }
  
  public HostAndPort withDefaultPort(int paramInt)
  {
    Preconditions.checkArgument(isValidPort(paramInt));
    if ((hasPort()) || (this.port == paramInt)) {
      return this;
    }
    return new HostAndPort(this.host, paramInt, this.hasBracketlessColons);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.net.HostAndPort
 * JD-Core Version:    0.7.0.1
 */