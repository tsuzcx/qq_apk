package com.tencent.token;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

public abstract interface akz
{
  public static final akz a = new akz()
  {
    public final List<InetAddress> a(String paramAnonymousString)
    {
      if (paramAnonymousString != null) {
        try
        {
          List localList = Arrays.asList(InetAddress.getAllByName(paramAnonymousString));
          return localList;
        }
        catch (NullPointerException localNullPointerException)
        {
          paramAnonymousString = new UnknownHostException("Broken system behaviour for dns lookup of ".concat(String.valueOf(paramAnonymousString)));
          paramAnonymousString.initCause(localNullPointerException);
          throw paramAnonymousString;
        }
      }
      throw new UnknownHostException("hostname == null");
    }
  };
  
  public abstract List<InetAddress> a(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.akz
 * JD-Core Version:    0.7.0.1
 */