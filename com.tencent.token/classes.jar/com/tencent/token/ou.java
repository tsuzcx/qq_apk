package com.tencent.token;

import android.os.Bundle;

public final class ou
{
  public int a;
  public String b;
  public String c;
  public byte[] d;
  public b e = null;
  public String f;
  public String g;
  public String h;
  
  public ou()
  {
    this((byte)0);
  }
  
  private ou(byte paramByte) {}
  
  public final int a()
  {
    b localb = this.e;
    if (localb == null) {
      return 0;
    }
    return localb.a();
  }
  
  public static final class a
  {
    public static ou a(Bundle paramBundle)
    {
      ou localou = new ou();
      localou.a = paramBundle.getInt("_wxobject_sdkVer");
      localou.b = paramBundle.getString("_wxobject_title");
      localou.c = paramBundle.getString("_wxobject_description");
      localou.d = paramBundle.getByteArray("_wxobject_thumbdata");
      localou.f = paramBundle.getString("_wxobject_mediatagname");
      localou.g = paramBundle.getString("_wxobject_message_action");
      localou.h = paramBundle.getString("_wxobject_message_ext");
      Object localObject2 = paramBundle.getString("_wxobject_identifier_");
      "pathOldToNew, oldPath = ".concat(String.valueOf(localObject2));
      Object localObject1 = localObject2;
      if (localObject2 != null) {
        if (((String)localObject2).length() == 0)
        {
          localObject1 = localObject2;
        }
        else
        {
          int i = ((String)localObject2).lastIndexOf('.');
          if (i == -1)
          {
            "pathOldToNew fail, invalid pos, oldPath = ".concat(String.valueOf(localObject2));
            localObject1 = localObject2;
          }
          else
          {
            localObject1 = new StringBuilder("com.tencent.mm.opensdk.modelmsg");
            ((StringBuilder)localObject1).append(((String)localObject2).substring(i));
            localObject1 = ((StringBuilder)localObject1).toString();
          }
        }
      }
      if (localObject1 != null)
      {
        if (((String)localObject1).length() <= 0) {
          return localou;
        }
        try
        {
          localou.e = ((ou.b)Class.forName((String)localObject1).newInstance());
          localou.e.b(paramBundle);
          return localou;
        }
        catch (Exception paramBundle)
        {
          localObject2 = new StringBuilder("get media object from bundle failed: unknown ident ");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(", ex = ");
          ((StringBuilder)localObject2).append(paramBundle.getMessage());
        }
      }
      return localou;
    }
  }
  
  public static abstract interface b
  {
    public abstract int a();
    
    public abstract void a(Bundle paramBundle);
    
    public abstract void b(Bundle paramBundle);
    
    public abstract boolean b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ou
 * JD-Core Version:    0.7.0.1
 */