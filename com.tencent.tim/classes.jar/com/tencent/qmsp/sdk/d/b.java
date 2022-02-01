package com.tencent.qmsp.sdk.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.qmsp.sdk.a.c;
import com.tencent.qmsp.sdk.app.QmspSDK;
import com.tencent.qmsp.sdk.f.g;
import com.tencent.qmsp.sdk.f.k;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class b
{
  private List<d.b> a = new ArrayList();
  private SharedPreferences b = null;
  
  private String a(String paramString1, String paramString2, String paramString3)
  {
    String str = "";
    if ((TextUtils.isEmpty(paramString1)) || (paramString1.equals("1"))) {
      str = QmspSDK.getContext().getFilesDir().getParent();
    }
    for (;;)
    {
      paramString1 = str;
      if (!str.endsWith(File.separator))
      {
        paramString1 = str;
        if (!paramString2.startsWith(File.separator)) {
          paramString1 = str + File.separator;
        }
      }
      paramString1 = paramString1 + paramString2;
      if (!paramString2.endsWith(File.separator)) {
        break;
      }
      return paramString1 + paramString3;
      if (paramString1.equals("2")) {
        str = QmspSDK.getContext().getExternalFilesDir(null).getParent();
      }
    }
    return paramString1 + File.separator + paramString3;
  }
  
  private String a(byte[] paramArrayOfByte)
  {
    return k.a(paramArrayOfByte);
  }
  
  private boolean a(String paramString, long paramLong1, long paramLong2)
  {
    boolean bool4 = true;
    boolean bool3;
    if ((paramString == null) || (!paramString.equals("android"))) {
      bool3 = false;
    }
    long l;
    do
    {
      boolean bool1;
      boolean bool2;
      do
      {
        do
        {
          do
          {
            return bool3;
            bool1 = paramLong1 < 0L;
            if (!bool1)
            {
              bool2 = paramLong2 < 0L;
              if (!bool2) {}
            }
            else
            {
              return false;
            }
            l = Build.VERSION.SDK_INT;
            if (bool1) {
              break;
            }
            bool3 = bool4;
          } while (!bool2);
          if ((bool1) || (!bool2)) {
            break;
          }
          bool3 = bool4;
        } while (l <= paramLong2);
        return false;
        if ((!bool1) || (bool2)) {
          break;
        }
        bool3 = bool4;
      } while (l >= paramLong1);
      return false;
      if ((!bool1) || (!bool2)) {
        break label143;
      }
      if (l < paramLong1) {
        break;
      }
      bool3 = bool4;
    } while (l <= paramLong2);
    return false;
    label143:
    return false;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramString1 == null) || (paramString2 == null)) {
      bool1 = false;
    }
    do
    {
      do
      {
        for (;;)
        {
          return bool1;
          paramString1 = paramString1.replace(" ", "");
          paramString2 = paramString2.replace(" ", "");
          boolean bool3 = paramString1.equals("*");
          boolean bool4 = paramString2.equals("*");
          String str;
          if (bool3)
          {
            bool1 = bool2;
            if (bool4) {}
          }
          else
          {
            str = c.c();
            if (TextUtils.isEmpty(str)) {
              return false;
            }
            if ((bool3) && (!bool4)) {
              bool1 = bool2;
            }
          }
          try
          {
            if (b(str, paramString2) > 0) {
              return false;
            }
          }
          catch (Exception paramString1)
          {
            int i;
            paramString1.printStackTrace();
          }
        }
        if ((bool3) || (!bool4)) {
          break;
        }
        bool1 = bool2;
      } while (b(str, paramString1) >= 0);
      return false;
      if ((bool3) || (bool4)) {
        break label175;
      }
      if (b(str, paramString2) > 0) {
        break;
      }
      i = b(str, paramString1);
      bool1 = bool2;
    } while (i >= 0);
    return false;
    label175:
    return false;
  }
  
  private int b(String paramString1, String paramString2)
  {
    paramString1 = paramString1.split("\\.");
    paramString2 = paramString2.split("\\.");
    int i;
    int j;
    if (paramString1.length < paramString2.length)
    {
      i = paramString1.length;
      j = 0;
    }
    for (;;)
    {
      if (j >= i) {
        break label84;
      }
      int k = Integer.parseInt(paramString1[j]);
      int m = Integer.parseInt(paramString2[j]);
      if (k > m)
      {
        return 1;
        i = paramString2.length;
        break;
      }
      if (k < m) {
        return -1;
      }
      j += 1;
    }
    label84:
    return 0;
  }
  
  private String b()
  {
    return com.tencent.qmsp.sdk.a.b.c() + a(d.a);
  }
  
  private boolean b(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return false;
      Object localObject = paramString.replace(" ", "");
      if (((String)localObject).equals("*")) {
        return true;
      }
      paramString = Build.CPU_ABI;
      localObject = ((String)localObject).split(",");
      if (localObject != null)
      {
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          if (paramString.contains(localObject[i])) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  private boolean c(String paramString)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      paramString = new JSONObject(paramString);
      paramString.getLong(a(d.g[0]));
      paramString.getBoolean(a(d.g[1]));
      paramString = paramString.getJSONArray(a(d.g[2]));
      int i = 0;
      while (i < paramString.length())
      {
        d.b localb = new d.b();
        Object localObject = paramString.getJSONObject(i);
        localb.a = ((JSONObject)localObject).getLong(a(d.g[3]));
        localb.b = ((JSONObject)localObject).getLong(a(d.g[4]));
        ((JSONObject)localObject).getLong(a(d.g[7]));
        localb.c = ((JSONObject)localObject).getString(a(d.g[5]));
        localb.d = ((JSONObject)localObject).getString(a(d.g[6]));
        localb.e = ((JSONObject)localObject).getString(a(d.g[8]));
        localb.f = ((JSONObject)localObject).getLong(a(d.g[15]));
        localb.g = ((JSONObject)localObject).getLong(a(d.g[16]));
        localb.j = ((JSONObject)localObject).getString(a(d.g[18]));
        localb.h = ((JSONObject)localObject).getString(a(d.g[10]));
        localb.i = ((JSONObject)localObject).getString(a(d.g[11]));
        localb.k = ((JSONObject)localObject).getString(a(d.g[9]));
        localb.m = a(localb.k, localb.f, localb.g);
        localb.n = b(localb.j);
        localb.l = a(localb.h, localb.i);
        if (((JSONObject)localObject).has(a(d.g[20]))) {
          localb.u = ((JSONObject)localObject).getInt(a(d.g[20]));
        }
        localObject = ((JSONObject)localObject).getJSONArray(a(d.g[12]));
        int j = 0;
        while (j < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(j);
          d.a locala = new d.a();
          localJSONObject.getLong(a(d.g[7]));
          locala.d = localJSONObject.getString(a(d.g[13]));
          locala.e = localJSONObject.getString(a(d.g[14]));
          locala.a = localJSONObject.getString(a(d.g[5]));
          locala.f = a(locala.d, locala.e, locala.a);
          locala.b = localJSONObject.getString(a(d.g[6]));
          locala.h = localJSONObject.getLong(a(d.g[17]));
          if (localJSONObject.has(a(d.g[19]))) {
            locala.i = localJSONObject.getString(a(d.g[19]));
          }
          localb.o.add(locala);
          j += 1;
        }
        localArrayList.add(localb);
        i += 1;
      }
      this.a = localArrayList;
      return true;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      g.a("Qp.QPUpdate", 1, "[SFU] parsing config error");
    }
    return false;
  }
  
  public List<d.b> a()
  {
    return this.a;
  }
  
  public List<d.b> a(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    if ((a(b())) && (!this.a.isEmpty()))
    {
      int i = 0;
      if (i < this.a.size())
      {
        d.b localb = (d.b)this.a.get(i);
        if (localb.b != paramLong) {}
        for (;;)
        {
          i += 1;
          break;
          int j = 0;
          d.a locala;
          while (j < localb.o.size())
          {
            locala = (d.a)localb.o.get(j);
            locala.g = this.b.getString(locala.f, "");
            j += 1;
          }
          j = 0;
          while (j < localb.q.size())
          {
            locala = (d.a)localb.q.get(j);
            locala.g = this.b.getString(locala.f, "");
            j += 1;
          }
          j = 0;
          while (j < localb.p.size())
          {
            locala = (d.a)localb.p.get(j);
            locala.g = this.b.getString(locala.f, "");
            j += 1;
          }
          localArrayList.add(localb);
        }
      }
    }
    return localArrayList;
  }
  
  public boolean a(String paramString)
  {
    byte[] arrayOfByte = e.a(new File(paramString), null);
    if (arrayOfByte != null) {
      return c(new String(arrayOfByte));
    }
    g.a("Qp.QPUpdate", 1, String.format("[SFU] invalid sig of config: %s", new Object[] { paramString }));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.d.b
 * JD-Core Version:    0.7.0.1
 */