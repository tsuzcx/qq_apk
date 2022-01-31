package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public final class k
  extends i
{
  static SharedPreferences a = null;
  static Context b = null;
  static int[] c;
  static String d = "";
  static String[] e = { "Year", "Month", "Date" };
  public String A = "";
  private long B = 0L;
  private List C = null;
  public String f = "";
  public String g = "";
  public String h = "";
  public String i = "";
  public String j = "";
  public String k = "";
  public String l = "";
  public int m = 0;
  public String n = "";
  public int o = 0;
  public String p = "";
  public String q = "";
  public String r = "";
  public String s = "";
  public String t = "";
  public String u = "";
  public String v = "";
  public String w = "";
  public String x = "";
  public String y = "";
  public String z = "";
  
  static
  {
    c = new int[3];
    int i1 = 0;
    for (;;)
    {
      if (i1 >= c.length) {
        return;
      }
      c[i1] = 0;
      i1 += 1;
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if ((b != null) && (b.equals(paramContext))) {
      return;
    }
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      str = "preferences";
    }
    d = str;
    b = paramContext;
    a = paramContext.getSharedPreferences(d, 0);
    paramContext = c;
    int i2 = paramContext.length;
    int i1 = 0;
    for (;;)
    {
      if (i1 >= i2) {}
      for (i1 = 0; i1 == 0; i1 = 1)
      {
        c[0] = a.getInt(e[0], 0);
        c[1] = a.getInt(e[1], 0);
        c[2] = a.getInt(e[2], 0);
        return;
        if (paramContext[i1] == 0) {
          break label144;
        }
      }
      break;
      label144:
      i1 += 1;
    }
  }
  
  public static String b()
  {
    boolean bool = true;
    SharedPreferences localSharedPreferences = b.getSharedPreferences("token_save_info", 0);
    if (localSharedPreferences != null) {
      bool = localSharedPreferences.getBoolean("token_status", true);
    }
    if (bool) {
      return "1";
    }
    return "0";
  }
  
  public static void c()
  {
    Object localObject = Calendar.getInstance();
    c[0] = ((Calendar)localObject).get(1);
    c[1] = (((Calendar)localObject).get(2) + 1);
    c[2] = ((Calendar)localObject).get(5);
    localObject = b.getSharedPreferences(d, 0);
    a = (SharedPreferences)localObject;
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt(e[0], c[0]);
    ((SharedPreferences.Editor)localObject).putInt(e[1], c[1]);
    ((SharedPreferences.Editor)localObject).putInt(e[2], c[2]);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public static boolean d()
  {
    Calendar localCalendar = Calendar.getInstance();
    return (c[2] == localCalendar.get(5)) && (c[1] == localCalendar.get(2) + 1) && (c[0] == localCalendar.get(1));
  }
  
  public final void a(String paramString)
  {
    if (this.C == null) {
      this.C = new ArrayList();
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.C.add(str);
  }
  
  public final byte[] a()
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    DataOutputStream localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
    localDataOutputStream.writeInt(4);
    localDataOutputStream.writeLong(this.B);
    if (this.C == null) {
      this.C = new ArrayList();
    }
    localDataOutputStream.writeInt(this.C.size());
    Object localObject1 = this.C.iterator();
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext())
      {
        Object localObject2 = this.f;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = localObject1;
        if (((String)localObject1).length() > 32) {
          localObject2 = ((String)localObject1).substring(0, 32);
        }
        localDataOutputStream.writeUTF((String)localObject2);
        localObject2 = this.g;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = localObject1;
        if (((String)localObject1).length() > 32) {
          localObject2 = ((String)localObject1).substring(0, 32);
        }
        localDataOutputStream.writeUTF((String)localObject2);
        localObject2 = this.h;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = localObject1;
        if (((String)localObject1).length() > 32) {
          localObject2 = ((String)localObject1).substring(0, 32);
        }
        localDataOutputStream.writeUTF((String)localObject2);
        localObject2 = this.i;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = localObject1;
        if (((String)localObject1).length() > 32) {
          localObject2 = ((String)localObject1).substring(0, 32);
        }
        localDataOutputStream.writeUTF((String)localObject2);
        localObject2 = this.j;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = localObject1;
        if (((String)localObject1).length() > 32) {
          localObject2 = ((String)localObject1).substring(0, 32);
        }
        localDataOutputStream.writeUTF((String)localObject2);
        localObject2 = this.k;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = localObject1;
        if (((String)localObject1).length() > 32) {
          localObject2 = ((String)localObject1).substring(0, 32);
        }
        localDataOutputStream.writeUTF((String)localObject2);
        localObject2 = this.l;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = localObject1;
        if (((String)localObject1).length() > 32) {
          localObject2 = ((String)localObject1).substring(0, 32);
        }
        localDataOutputStream.writeUTF((String)localObject2);
        localDataOutputStream.writeInt(this.m);
        localObject2 = this.n;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = localObject1;
        if (((String)localObject1).length() > 32) {
          localObject2 = ((String)localObject1).substring(0, 32);
        }
        localDataOutputStream.writeUTF((String)localObject2);
        localDataOutputStream.writeInt(this.o);
        localObject2 = this.p;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = localObject1;
        if (((String)localObject1).length() > 32) {
          localObject2 = ((String)localObject1).substring(0, 32);
        }
        localDataOutputStream.writeUTF((String)localObject2);
        localObject2 = this.q;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = localObject1;
        if (((String)localObject1).length() > 32) {
          localObject2 = ((String)localObject1).substring(0, 32);
        }
        localDataOutputStream.writeUTF((String)localObject2);
        localObject2 = this.r;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = localObject1;
        if (((String)localObject1).length() > 32) {
          localObject2 = ((String)localObject1).substring(0, 32);
        }
        localDataOutputStream.writeUTF((String)localObject2);
        localObject2 = this.s;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = localObject1;
        if (((String)localObject1).length() > 42) {
          localObject2 = ((String)localObject1).substring(0, 42);
        }
        localDataOutputStream.writeUTF((String)localObject2);
        localObject2 = this.t;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = localObject1;
        if (((String)localObject1).length() > 32) {
          localObject2 = ((String)localObject1).substring(0, 32);
        }
        localDataOutputStream.writeUTF((String)localObject2);
        localObject2 = this.u;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = localObject1;
        if (((String)localObject1).length() > 32) {
          localObject2 = ((String)localObject1).substring(0, 32);
        }
        localDataOutputStream.writeUTF((String)localObject2);
        localObject2 = this.v;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = localObject1;
        if (((String)localObject1).length() > 54) {
          localObject2 = ((String)localObject1).substring(0, 54);
        }
        localDataOutputStream.writeUTF((String)localObject2);
        localObject2 = this.w;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = localObject1;
        if (((String)localObject1).length() > 32) {
          localObject2 = ((String)localObject1).substring(0, 32);
        }
        localDataOutputStream.writeUTF((String)localObject2);
        localObject2 = this.x;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = localObject1;
        if (((String)localObject1).length() > 32) {
          localObject2 = ((String)localObject1).substring(0, 32);
        }
        localDataOutputStream.writeUTF((String)localObject2);
        localObject2 = this.y;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = localObject1;
        if (((String)localObject1).length() > 32) {
          localObject2 = ((String)localObject1).substring(0, 32);
        }
        localDataOutputStream.writeUTF((String)localObject2);
        localObject2 = this.z;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = localObject1;
        if (((String)localObject1).length() > 12) {
          localObject2 = ((String)localObject1).substring(0, 12);
        }
        localDataOutputStream.writeUTF((String)localObject2);
        localObject2 = this.A;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject2 = localObject1;
        if (((String)localObject1).length() > 12) {
          localObject2 = ((String)localObject1).substring(0, 12);
        }
        localDataOutputStream.writeUTF((String)localObject2);
        localObject1 = localByteArrayOutputStream.toByteArray();
        localDataOutputStream.close();
        localByteArrayOutputStream.close();
        return localObject1;
      }
      localDataOutputStream.writeUTF((String)((Iterator)localObject1).next());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.k
 * JD-Core Version:    0.7.0.1
 */