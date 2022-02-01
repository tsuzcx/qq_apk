package com.tencent.tgpa.vendorpd.a;

import android.os.Build;
import android.util.Log;
import com.tencent.tgpa.vendorpd.gradish.GradishWrapper;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class i
{
  public static int a(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("status");
    if ((i != 0) && (i != 1))
    {
      m.b("current server forbid to combine apk. status: " + i);
      return e.k.a();
    }
    if (!a(paramJSONObject))
    {
      m.b("the channel tag in tgpa's cloud config is not correct, ple check it.");
      return e.l.a();
    }
    Object localObject = paramJSONObject.getJSONObject("channel_tag");
    long l = ((JSONObject)localObject).getLong("offset");
    int j = ((JSONObject)localObject).getInt("size");
    localObject = ((JSONObject)localObject).getString("content");
    byte[] arrayOfByte1;
    try
    {
      arrayOfByte1 = d.c((String)localObject);
      if (arrayOfByte1.length != j)
      {
        m.b("cloud channel tag's content size is not matched, ple check it.");
        i = e.m.a();
        return i;
      }
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      Log.e("TGPA", "cloud channel tag's content decrypt failed. ");
      return e.n.a();
    }
    byte[] arrayOfByte2 = a(l, j, paramString2);
    if (arrayOfByte2 == null) {
      return e.s.a();
    }
    if (i == 0)
    {
      m.b("local tag: " + String.valueOf(d.d(arrayOfByte2)) + " , cloud tag: " + (String)localObject);
      if (a(arrayOfByte2, arrayOfByte1))
      {
        localObject = new b(paramString2);
        if (!((b)localObject).a(paramJSONObject))
        {
          m.b("cloud operation parse failed, ple check it.");
          return e.i.a();
        }
        if (!((b)localObject).a())
        {
          m.b("cloud operation do failed, ple check it.");
          return e.o.a();
        }
        if (!a(paramString1, paramString2)) {
          return e.p.a();
        }
        return e.a.a();
      }
      m.b("you can't combine other channels' predownload file.");
      return e.q.a();
    }
    if (i == 1)
    {
      localObject = new b(paramString2);
      if (!((b)localObject).a(paramJSONObject)) {
        return e.i.a();
      }
      if (!((b)localObject).a()) {
        return e.o.a();
      }
      if (!a(paramString1, paramString2)) {
        return e.p.a();
      }
      return e.a.a();
    }
    return e.k.a();
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    if (m.a) {}
    for (String str1 = "https://testversion.tgpa.qq.com/pd_combine_pkg";; str1 = "https://version.tgpa.qq.com/pd_combine_pkg")
    {
      String str2 = f.g(paramString5);
      String str3 = String.valueOf(System.currentTimeMillis());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("time_stamp=").append(str3).append("&");
      localStringBuilder.append("api_key=").append("6d3cb8b9139aa731b912961282ff3b78").append("&");
      localStringBuilder.append("api_secret=").append("996f0a74d71f5803a269a64cf3a565c9").append("&");
      localStringBuilder.append("cdn_url=").append(paramString3).append("&");
      localStringBuilder.append("cdn_md5=").append(String.valueOf(paramString4)).append("&");
      localStringBuilder.append("game_package=").append(paramString7).append("&");
      localStringBuilder.append("predownload_file=").append(str2);
      paramString5 = new HashMap();
      paramString5.put("time_stamp", str3);
      paramString5.put("api_key", "6d3cb8b9139aa731b912961282ff3b78");
      paramString5.put("api_sign", String.valueOf(d.a(localStringBuilder.toString())));
      paramString5.put("model", Build.MODEL);
      paramString5.put("manufacturer", Build.MANUFACTURER);
      paramString5.put("channel", paramString2);
      paramString5.put("sdk_code", String.valueOf(115));
      paramString5.put("sdk_version", String.valueOf("1.1.5"));
      paramString5.put("cdn_url", paramString3);
      paramString5.put("cdn_md5", String.valueOf(paramString4));
      paramString5.put("game_package", paramString7);
      paramString5.put("predownload_file", str2);
      paramString5.put("predownfile_md5", paramString6);
      paramString5.put("app_name", paramString1);
      paramString5.put("xid", GradishWrapper.getCommonUniqueID2WithoutFlag());
      paramString2 = new HashMap();
      paramString2.put("app_name", paramString1);
      paramString2.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
      paramString2.put("X-Requested-With", "XMLHttpRequest");
      paramString2.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.116");
      try
      {
        m.b("request data: " + localStringBuilder.toString());
        paramString1 = paramString5.entrySet().iterator();
        while (paramString1.hasNext())
        {
          paramString3 = (Map.Entry)paramString1.next();
          m.b("request data: " + paramString3.getKey() + "=" + paramString3.getValue());
        }
        paramString1 = h.a(str1, paramString5, paramString2);
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        m.c("request predownload combine exception.");
        return null;
      }
      return paramString1;
    }
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      Log.d("TGPA", "combine apk cdnMD55 is null, do not need check.");
    }
    do
    {
      return true;
      long l = System.currentTimeMillis();
      paramString2 = d.a(new File(paramString2));
      c.c = System.currentTimeMillis() - l;
    } while ((paramString2 != null) && (paramString2.equals(paramString1)));
    Log.e("TGPA", "combine apk failed, md5 is not matched. md5: " + String.valueOf(paramString2));
    return false;
  }
  
  private static boolean a(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("channel_tag"))
    {
      paramJSONObject = paramJSONObject.optJSONObject("channel_tag");
      if ((paramJSONObject != null) && (paramJSONObject.has("offset")) && (paramJSONObject.has("size")) && (paramJSONObject.has("content"))) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null)) {
      return false;
    }
    if (!Arrays.equals(paramArrayOfByte1, paramArrayOfByte2))
    {
      Log.e("TGPA", "predownload file's channel tag is not matched in cloud config.");
      return false;
    }
    return true;
  }
  
  private static byte[] a(long paramLong, int paramInt, String paramString)
  {
    try
    {
      paramString = new RandomAccessFile(new File(paramString), "rw");
      paramString.seek(paramString.length() - paramLong);
      byte[] arrayOfByte = new byte[paramInt];
      paramString.read(arrayOfByte, 0, paramInt);
      paramString.close();
      return arrayOfByte;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      Log.e("TGPA", "can not read tgpa channel in predownload file content.");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tgpa.vendorpd.a.i
 * JD-Core Version:    0.7.0.1
 */