package com.tencent.tgpa.vendorpd.a;

import android.os.Environment;
import android.util.Base64;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class g
{
  private String a;
  private String b;
  private HashMap<String, String> c;
  private HashMap<String, String> d;
  
  public g(String paramString)
  {
    this.a = paramString;
    String str = Environment.getExternalStorageDirectory().getPath() + File.separator + l.a;
    this.b = (str + File.separator + "." + paramString + l.b);
  }
  
  public static boolean a(HashMap<String, String> paramHashMap)
  {
    m.a("Game_PD: TGPA dir exsit, start to save download info to file.");
    String str3 = (String)paramHashMap.get("game_name");
    String str1 = (String)paramHashMap.get("download_path");
    String str2 = (String)paramHashMap.get("channel");
    paramHashMap = (String)paramHashMap.get("file_name");
    Object localObject = Environment.getExternalStorageDirectory().getPath();
    localObject = (String)localObject + File.separator + l.a;
    str3 = (String)localObject + File.separator + "." + str3 + l.b;
    JSONObject localJSONObject2;
    if (f.d(str3))
    {
      m.a("Game_PD: pkgdowninfo file exsit, start to update it.");
      try
      {
        localObject = d.c(Base64.decode(f.c(str3), 2));
        if (localObject != null)
        {
          m.a("Game_PD: The last pd file info: " + new String((byte[])localObject));
          localObject = new JSONObject(new String((byte[])localObject, 0, localObject.length, "utf-8"));
          if (((JSONObject)localObject).has(str2))
          {
            localJSONObject2 = ((JSONObject)localObject).getJSONObject(str2);
            localJSONObject2.put(paramHashMap, System.currentTimeMillis() / 1000L);
            localJSONObject2.put("path", str1);
          }
          for (;;)
          {
            f.a(str3, Base64.encode(d.b(((JSONObject)localObject).toString().getBytes()), 2));
            return true;
            localJSONObject2 = new JSONObject();
            localJSONObject2.put(paramHashMap, System.currentTimeMillis() / 1000L);
            localJSONObject2.put("path", str1);
            ((JSONObject)localObject).put(str2, localJSONObject2);
          }
          m.a("Game_PD: pkgdowninfo file doesn't exsit, start to create.");
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        m.c("Game_PD: save download info to file exception. filename: " + String.valueOf(paramHashMap));
        f.f(str3);
      }
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject1 = new JSONObject();
        localJSONObject2 = new JSONObject();
        localJSONObject2.put("path", str1);
        localJSONObject2.put(paramHashMap, System.currentTimeMillis() / 1000L);
        localJSONObject1.put(str2, localJSONObject2);
        str1 = localJSONObject1.toString();
        m.a("Game_PD: write json to new file: " + str1);
        f.a(str3, Base64.encode(d.b(str1.getBytes()), 2));
        return true;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        m.c("Game_PD: save json content to new file exception. filename: " + String.valueOf(paramHashMap));
      }
      f.f(str3);
    }
    return false;
  }
  
  public String a(String paramString1, String paramString2)
  {
    if (this.c == null) {
      return null;
    }
    return (String)this.c.get(paramString1);
  }
  
  public void a()
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    if (f.d(this.b)) {
      try
      {
        JSONObject localJSONObject = new JSONObject(new String(d.c(Base64.decode(f.c(this.b).getBytes(), 2)), "utf-8"));
        Iterator localIterator = localJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str2 = (String)localIterator.next();
          Object localObject = localJSONObject.getJSONObject(str2);
          String str1 = "";
          if (localObject != null)
          {
            if (((JSONObject)localObject).has("path"))
            {
              str1 = ((JSONObject)localObject).getString("path");
              ((JSONObject)localObject).remove("path");
            }
            localObject = ((JSONObject)localObject).keys();
            while (((Iterator)localObject).hasNext())
            {
              String str3 = (String)((Iterator)localObject).next();
              localHashMap1.put(str3, str2);
              localHashMap2.put(str3, str1);
            }
          }
        }
        this.c = localHashMap1;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        m.c("Game_PD: parse game pdinfo exception.");
      }
    }
    for (;;)
    {
      this.d = localHashMap2;
      return;
      m.c("Game_PD: can not get pdinfo, game: " + this.a);
    }
  }
  
  public String b(String paramString1, String paramString2)
  {
    if (this.d == null) {
      return null;
    }
    return (String)this.d.get(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tgpa.vendorpd.a.g
 * JD-Core Version:    0.7.0.1
 */