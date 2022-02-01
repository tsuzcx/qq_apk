package com.android.safeguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class j
  extends h
{
  static SharedPreferences a;
  static Context b;
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
      int[] arrayOfInt = c;
      if (i1 >= arrayOfInt.length) {
        return;
      }
      arrayOfInt[i1] = 0;
      i1 += 1;
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    Object localObject = b;
    if ((localObject != null) && (localObject.equals(paramContext))) {
      return;
    }
    if (paramString != null)
    {
      localObject = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      localObject = "preferences";
    }
    d = (String)localObject;
    b = paramContext;
    a = paramContext.getSharedPreferences(d, 0);
    if (!a())
    {
      c[0] = a.getInt(e[0], 0);
      c[1] = a.getInt(e[1], 0);
      c[2] = a.getInt(e[2], 0);
    }
  }
  
  public static boolean a()
  {
    int[] arrayOfInt = c;
    int i2 = arrayOfInt.length;
    int i1 = 0;
    for (;;)
    {
      if (i1 >= i2) {
        return false;
      }
      if (arrayOfInt[i1] != 0) {
        return true;
      }
      i1 += 1;
    }
  }
  
  public static String c()
  {
    SharedPreferences localSharedPreferences = b.getSharedPreferences("token_save_info", 0);
    boolean bool = true;
    if (localSharedPreferences != null) {
      bool = localSharedPreferences.getBoolean("token_status", true);
    }
    if (bool) {
      return "1";
    }
    return "0";
  }
  
  public static void d()
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
  
  public static boolean e()
  {
    Calendar localCalendar = Calendar.getInstance();
    return (c[2] == localCalendar.get(5)) && (c[1] == localCalendar.get(2) + 1) && (c[0] == localCalendar.get(1));
  }
  
  public void a(String paramString)
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
  
  public byte[] b()
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    DataOutputStream localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
    localDataOutputStream.writeInt(4);
    localDataOutputStream.writeLong(this.B);
    if (this.C == null) {
      this.C = new ArrayList();
    }
    localDataOutputStream.writeInt(this.C.size());
    Object localObject = this.C.iterator();
    for (;;)
    {
      if (!((Iterator)localObject).hasNext())
      {
        localDataOutputStream.writeUTF(a(this.f, 32));
        localDataOutputStream.writeUTF(a(this.g, 32));
        localDataOutputStream.writeUTF(a(this.h, 32));
        localDataOutputStream.writeUTF(a(this.i, 32));
        localDataOutputStream.writeUTF(a(this.j, 32));
        localDataOutputStream.writeUTF(a(this.k, 32));
        localDataOutputStream.writeUTF(a(this.l, 32));
        localDataOutputStream.writeInt(this.m);
        localDataOutputStream.writeUTF(a(this.n, 32));
        localDataOutputStream.writeInt(this.o);
        localDataOutputStream.writeUTF(a(this.p, 32));
        localDataOutputStream.writeUTF(a(this.q, 32));
        localDataOutputStream.writeUTF(a(this.r, 32));
        localDataOutputStream.writeUTF(a(this.s, 42));
        localDataOutputStream.writeUTF(a(this.t, 32));
        localDataOutputStream.writeUTF(a(this.u, 32));
        localDataOutputStream.writeUTF(a(this.v, 54));
        localDataOutputStream.writeUTF(a(this.w, 32));
        localDataOutputStream.writeUTF(a(this.x, 32));
        localDataOutputStream.writeUTF(a(this.y, 32));
        localDataOutputStream.writeUTF(a(this.z, 12));
        localDataOutputStream.writeUTF(a(this.A, 12));
        localObject = localByteArrayOutputStream.toByteArray();
        localDataOutputStream.close();
        localByteArrayOutputStream.close();
        return localObject;
      }
      localDataOutputStream.writeUTF((String)((Iterator)localObject).next());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.android.safeguard.j
 * JD-Core Version:    0.7.0.1
 */