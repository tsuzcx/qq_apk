package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.halley.common.f;
import com.tencent.halley.scheduler.c.c;
import com.tencent.halley.scheduler.c.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class bh
{
  public int a;
  public int b;
  public int c;
  public int d;
  public int e;
  public i f;
  
  public bh() {}
  
  public bh(c paramc)
  {
    this.a = paramc.a;
    this.b = paramc.b;
    this.c = paramc.c;
    this.d = paramc.d;
    this.e = paramc.e;
    this.f = paramc.f;
  }
  
  private void c()
  {
    int i = this.a;
    if ((i < 10000) || (i > 60000)) {
      this.a = 20000;
    }
    i = this.b;
    if ((i < 10000) || (i > 60000)) {
      this.b = 20000;
    }
    i = this.c;
    if ((i < 3) || (i > 15)) {
      this.c = 8;
    }
    i = this.d;
    if ((i <= 0) || (i > 5)) {
      this.d = 2;
    }
    i = this.e;
    if ((i < 5) || (i > 2160)) {
      this.e = 120;
    }
  }
  
  public final void a()
  {
    Object localObject = f.a().getSharedPreferences("Access_Preferences", 0);
    this.a = ((SharedPreferences)localObject).getInt("connectTimeout", 15000);
    this.b = ((SharedPreferences)localObject).getInt("readTimeout", 15000);
    this.c = ((SharedPreferences)localObject).getInt("apnCachedNum", 8);
    this.d = ((SharedPreferences)localObject).getInt("parallelNum", 2);
    this.e = ((SharedPreferences)localObject).getInt("expireTime", 120);
    i locali = null;
    localObject = ((SharedPreferences)localObject).getString("samplingInfo", null);
    if (localObject != null)
    {
      localObject = ((String)localObject).split(";");
      locali = new i();
      HashMap localHashMap = new HashMap();
      int i = 0;
      while (i < localObject.length - 1)
      {
        String[] arrayOfString = localObject[i].split(",");
        localHashMap.put(Integer.valueOf(Integer.parseInt(arrayOfString[0])), Byte.valueOf(Byte.parseByte(arrayOfString[1])));
        i += 1;
      }
      locali.a = localHashMap;
      locali.b = Byte.parseByte(localObject[(localObject.length - 1)]);
    }
    this.f = locali;
    c();
  }
  
  public final void b()
  {
    Object localObject = f.a().getSharedPreferences("Access_Preferences", 0);
    c();
    ((SharedPreferences)localObject).edit().putInt("connectTimeout", this.a).commit();
    ((SharedPreferences)localObject).edit().putInt("readTimeout", this.b).commit();
    ((SharedPreferences)localObject).edit().putInt("apnCachedNum", this.c).commit();
    ((SharedPreferences)localObject).edit().putInt("parallelNum", this.d).commit();
    ((SharedPreferences)localObject).edit().putInt("expireTime", this.e).commit();
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject).edit();
    localObject = this.f;
    StringBuilder localStringBuilder1 = new StringBuilder();
    if (((i)localObject).a != null)
    {
      Iterator localIterator = ((i)localObject).a.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(localEntry.getKey());
        localStringBuilder2.append(",");
        localStringBuilder2.append(localEntry.getValue());
        localStringBuilder2.append(";");
        localStringBuilder1.append(localStringBuilder2.toString());
      }
      localStringBuilder1.append(((i)localObject).b);
      localObject = localStringBuilder1.toString();
    }
    else
    {
      localObject = null;
    }
    localEditor.putString("samplingInfo", (String)localObject).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bh
 * JD-Core Version:    0.7.0.1
 */