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

public final class bg
{
  public int a;
  public int b;
  public int c;
  public int d;
  public int e;
  public i f;
  
  public bg() {}
  
  public bg(c paramc)
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
    if ((this.a < 10000) || (this.a > 60000)) {
      this.a = 20000;
    }
    if ((this.b < 10000) || (this.b > 60000)) {
      this.b = 20000;
    }
    if ((this.c < 3) || (this.c > 15)) {
      this.c = 8;
    }
    if ((this.d <= 0) || (this.d > 5)) {
      this.d = 2;
    }
    if ((this.e < 5) || (this.e > 2160)) {
      this.e = 120;
    }
  }
  
  public final void a()
  {
    i locali = null;
    Object localObject = f.a().getSharedPreferences("Access_Preferences", 0);
    this.a = ((SharedPreferences)localObject).getInt("connectTimeout", 15000);
    this.b = ((SharedPreferences)localObject).getInt("readTimeout", 15000);
    this.c = ((SharedPreferences)localObject).getInt("apnCachedNum", 8);
    this.d = ((SharedPreferences)localObject).getInt("parallelNum", 2);
    this.e = ((SharedPreferences)localObject).getInt("expireTime", 120);
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
    StringBuilder localStringBuilder = new StringBuilder();
    if (((i)localObject).a != null)
    {
      Iterator localIterator = ((i)localObject).a.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localStringBuilder.append(localEntry.getKey() + "," + localEntry.getValue() + ";");
      }
      localStringBuilder.append(((i)localObject).b);
    }
    for (localObject = localStringBuilder.toString();; localObject = null)
    {
      localEditor.putString("samplingInfo", (String)localObject).commit();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bg
 * JD-Core Version:    0.7.0.1
 */