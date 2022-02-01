package com.tencent.token;

import android.os.Bundle;

public final class ot
{
  public int a;
  public String b;
  public String c;
  public byte[] d;
  public b e = null;
  public String f;
  public String g;
  public String h;
  
  public ot()
  {
    this((byte)0);
  }
  
  private ot(byte paramByte) {}
  
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
    public static ot a(Bundle paramBundle)
    {
      ot localot = new ot();
      localot.a = paramBundle.getInt("_wxobject_sdkVer");
      localot.b = paramBundle.getString("_wxobject_title");
      localot.c = paramBundle.getString("_wxobject_description");
      localot.d = paramBundle.getByteArray("_wxobject_thumbdata");
      localot.f = paramBundle.getString("_wxobject_mediatagname");
      localot.g = paramBundle.getString("_wxobject_message_action");
      localot.h = paramBundle.getString("_wxobject_message_ext");
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
          return localot;
        }
        try
        {
          localot.e = ((ot.b)Class.forName((String)localObject1).newInstance());
          localot.e.b(paramBundle);
          return localot;
        }
        catch (Exception paramBundle)
        {
          localObject2 = new StringBuilder("get media object from bundle failed: unknown ident ");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(", ex = ");
          ((StringBuilder)localObject2).append(paramBundle.getMessage());
        }
      }
      return localot;
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
 * Qualified Name:     com.tencent.token.ot
 * JD-Core Version:    0.7.0.1
 */