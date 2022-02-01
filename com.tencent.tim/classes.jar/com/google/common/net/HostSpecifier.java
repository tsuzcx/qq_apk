package com.google.common.net;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.text.ParseException;
import javax.annotation.Nullable;

@Beta
@GwtIncompatible
public final class HostSpecifier
{
  private final String canonicalForm;
  
  private HostSpecifier(String paramString)
  {
    this.canonicalForm = paramString;
  }
  
  public static HostSpecifier from(String paramString)
    throws ParseException
  {
    try
    {
      HostSpecifier localHostSpecifier = fromValid(paramString);
      return localHostSpecifier;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      paramString = new ParseException("Invalid host specifier: " + paramString, 0);
      paramString.initCause(localIllegalArgumentException);
      throw paramString;
    }
  }
  
  public static HostSpecifier fromValid(String paramString)
  {
    paramString = HostAndPort.fromString(paramString);
    boolean bool;
    if (!paramString.hasPort()) {
      bool = true;
    }
    for (;;)
    {
      Preconditions.checkArgument(bool);
      String str = paramString.getHost();
      try
      {
        paramString = InetAddresses.forString(str);
        if (paramString != null)
        {
          return new HostSpecifier(InetAddresses.toUriString(paramString));
          bool = false;
        }
      }
      catch (IllegalArgumentException paramString)
      {
        for (;;)
        {
          paramString = null;
        }
        paramString = InternetDomainName.from(str);
        if (paramString.hasPublicSuffix()) {
          return new HostSpecifier(paramString.toString());
        }
        throw new IllegalArgumentException("Domain name does not have a recognized public suffix: " + str);
      }
    }
  }
  
  public static boolean isValid(String paramString)
  {
    try
    {
      fromValid(paramString);
      return true;
    }
    catch (IllegalArgumentException paramString) {}
    return false;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof HostSpecifier))
    {
      paramObject = (HostSpecifier)paramObject;
      return this.canonicalForm.equals(paramObject.canonicalForm);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.canonicalForm.hashCode();
  }
  
  public String toString()
  {
    return this.canonicalForm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.net.HostSpecifier
 * JD-Core Version:    0.7.0.1
 */