import android.os.Build.VERSION;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class apbn
{
  public static apbn.c a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 10: 
      return new apbn.g();
    case 12: 
      return new apbn.h();
    case 18: 
      return new apbn.a();
    case 5: 
    case 19: 
      return new apbn.e();
    case 4: 
      return new apbn.f();
    case 99: 
      return new apbn.b();
    }
    return new apbn.d();
  }
  
  /* Error */
  public static Object[] a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 45	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 46	java/util/ArrayList:<init>	()V
    //   7: astore 5
    //   9: new 45	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 46	java/util/ArrayList:<init>	()V
    //   16: astore 6
    //   18: aload_0
    //   19: ifnull +174 -> 193
    //   22: aload_0
    //   23: ldc 48
    //   25: invokevirtual 54	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   28: ifeq +48 -> 76
    //   31: aload_0
    //   32: ldc 48
    //   34: invokevirtual 58	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   37: astore 7
    //   39: iconst_0
    //   40: istore_3
    //   41: iload_3
    //   42: aload 7
    //   44: invokevirtual 64	org/json/JSONArray:length	()I
    //   47: if_icmpge +29 -> 76
    //   50: aload 5
    //   52: aload 7
    //   54: iload_3
    //   55: invokevirtual 68	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   58: ldc 70
    //   60: invokevirtual 74	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   63: invokeinterface 80 2 0
    //   68: pop
    //   69: iload_3
    //   70: iconst_1
    //   71: iadd
    //   72: istore_3
    //   73: goto -32 -> 41
    //   76: aload_0
    //   77: ldc 82
    //   79: invokevirtual 54	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   82: ifeq +111 -> 193
    //   85: aload_0
    //   86: ldc 82
    //   88: invokevirtual 58	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   91: astore_0
    //   92: iconst_0
    //   93: istore_3
    //   94: iload_3
    //   95: aload_0
    //   96: invokevirtual 64	org/json/JSONArray:length	()I
    //   99: if_icmpge +94 -> 193
    //   102: aload_0
    //   103: iload_3
    //   104: invokevirtual 68	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   107: astore 7
    //   109: aload 7
    //   111: ldc 84
    //   113: invokevirtual 88	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   116: istore 4
    //   118: iload 4
    //   120: invokestatic 90	apbn:a	(I)Lapbn$c;
    //   123: astore 8
    //   125: aload 8
    //   127: ifnull +54 -> 181
    //   130: aload 8
    //   132: aload 7
    //   134: invokevirtual 93	apbn$c:a	(Lorg/json/JSONObject;)Lcom/tencent/mobileqq/data/TroopFeedItem;
    //   137: astore 7
    //   139: aload 7
    //   141: ifnull +40 -> 181
    //   144: aload 7
    //   146: invokevirtual 99	com/tencent/mobileqq/data/TroopFeedItem:isVaild	()Z
    //   149: ifeq +32 -> 181
    //   152: aload 7
    //   154: iload 4
    //   156: putfield 103	com/tencent/mobileqq/data/TroopFeedItem:orginType	I
    //   159: aload 7
    //   161: aload_2
    //   162: putfield 107	com/tencent/mobileqq/data/TroopFeedItem:currentUin	Ljava/lang/String;
    //   165: aload 7
    //   167: aload_1
    //   168: putfield 110	com/tencent/mobileqq/data/TroopFeedItem:troopUin	Ljava/lang/String;
    //   171: aload 6
    //   173: aload 7
    //   175: invokeinterface 80 2 0
    //   180: pop
    //   181: iload_3
    //   182: iconst_1
    //   183: iadd
    //   184: istore_3
    //   185: goto -91 -> 94
    //   188: astore_0
    //   189: aload_0
    //   190: invokevirtual 113	org/json/JSONException:printStackTrace	()V
    //   193: iconst_2
    //   194: anewarray 4	java/lang/Object
    //   197: dup
    //   198: iconst_0
    //   199: aload 5
    //   201: aastore
    //   202: dup
    //   203: iconst_1
    //   204: aload 6
    //   206: aastore
    //   207: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	paramJSONObject	JSONObject
    //   0	208	1	paramString1	String
    //   0	208	2	paramString2	String
    //   40	145	3	i	int
    //   116	39	4	j	int
    //   7	193	5	localArrayList1	java.util.ArrayList
    //   16	189	6	localArrayList2	java.util.ArrayList
    //   37	137	7	localObject	Object
    //   123	8	8	localc	apbn.c
    // Exception table:
    //   from	to	target	type
    //   22	39	188	org/json/JSONException
    //   41	69	188	org/json/JSONException
    //   76	92	188	org/json/JSONException
    //   94	125	188	org/json/JSONException
    //   130	139	188	org/json/JSONException
    //   144	181	188	org/json/JSONException
  }
  
  public static String bK(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    Date localDate = new Date(1000L * paramLong);
    localCalendar.setTime(localDate);
    return new SimpleDateFormat("MM月dd日").format(localDate);
  }
  
  public static class a
    extends apbn.c
  {
    public TroopFeedItem a(JSONObject paramJSONObject)
    {
      TroopFeedItem localTroopFeedItem = super.a(paramJSONObject);
      if (localTroopFeedItem == null) {
        return null;
      }
      localTroopFeedItem.type = 18;
      try
      {
        localTroopFeedItem.title = (paramJSONObject.getString("album_name") + acfp.m(2131715664) + paramJSONObject.getString("photo_num") + acfp.m(2131715666));
        localTroopFeedItem.linkUrl = paramJSONObject.getString("open_url");
        paramJSONObject = paramJSONObject.getJSONArray("content");
        int i = 0;
        for (;;)
        {
          if (i < paramJSONObject.length())
          {
            JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
            if (localJSONObject.getInt("type") == 3) {
              localTroopFeedItem.picPath = (localJSONObject.getString("pic_url") + "200");
            }
          }
          else
          {
            return localTroopFeedItem;
          }
          i += 1;
        }
        return null;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
  
  public static class b
    extends apbn.c
  {
    public TroopFeedItem a(JSONObject paramJSONObject)
    {
      TroopFeedItem localTroopFeedItem = super.a(paramJSONObject);
      if (localTroopFeedItem == null) {}
      for (;;)
      {
        return null;
        localTroopFeedItem.type = 99;
        try
        {
          localTroopFeedItem.linkUrl = paramJSONObject.optString("open_url");
          if (paramJSONObject.has("app_id"))
          {
            localTroopFeedItem.ex_1 = ("" + paramJSONObject.getLong("app_id"));
            if ((!pmb.Ir()) && (localTroopFeedItem.isStoryType()))
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("TroopFeedParserHelperQ.qqstory.tag_api_limit", 2, "当前系统api：" + Build.VERSION.SDK_INT + ",低于14");
              return null;
            }
          }
        }
        catch (JSONException paramJSONObject)
        {
          paramJSONObject.printStackTrace();
          return null;
        }
      }
      paramJSONObject = paramJSONObject.getJSONObject("content");
      localTroopFeedItem.content = paramJSONObject.getString("body");
      localTroopFeedItem.title = paramJSONObject.getString("title");
      localTroopFeedItem.picPath = paramJSONObject.getString("pic_url");
      return localTroopFeedItem;
    }
  }
  
  public static abstract class c
  {
    public TroopFeedItem a(JSONObject paramJSONObject)
    {
      TroopFeedItem localTroopFeedItem = new TroopFeedItem();
      try
      {
        localTroopFeedItem.id = paramJSONObject.getString("feed_id");
        localTroopFeedItem.feedTime = paramJSONObject.getString("mod_time");
        localTroopFeedItem.tag = paramJSONObject.getString("tag");
        if (paramJSONObject.has("pub_uin")) {
          localTroopFeedItem.publishUin = paramJSONObject.getString("pub_uin");
        }
        return localTroopFeedItem;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
      return localTroopFeedItem;
    }
  }
  
  public static class d
    extends apbn.c
  {
    public TroopFeedItem a(JSONObject paramJSONObject)
    {
      int i = 0;
      TroopFeedItem localTroopFeedItem = super.a(paramJSONObject);
      if (localTroopFeedItem == null) {
        return null;
      }
      for (;;)
      {
        JSONObject localJSONObject;
        try
        {
          paramJSONObject = paramJSONObject.getJSONArray("content");
          if (i >= paramJSONObject.length()) {
            break label283;
          }
          localJSONObject = paramJSONObject.getJSONObject(i);
          int j = localJSONObject.getInt("type");
          if (j == 5)
          {
            if (localJSONObject.has("file_path")) {
              localTroopFeedItem.linkUrl = localJSONObject.getString("file_path");
            }
            localTroopFeedItem.type = 0;
            if (localJSONObject.has("sharesize")) {
              localTroopFeedItem.ex_1 = ("" + localJSONObject.getLong("sharesize"));
            }
            boolean bool = localJSONObject.has("bus_id");
            if (bool) {}
            try
            {
              localTroopFeedItem.content = ("" + localJSONObject.getLong("bus_id"));
              if (!localJSONObject.has("sharefile")) {
                break label308;
              }
              localTroopFeedItem.title = localJSONObject.getString("sharefile");
            }
            catch (JSONException localJSONException)
            {
              localTroopFeedItem.content = ("" + localJSONObject.getString("bus_id"));
              continue;
            }
          }
          if (j != 3) {
            break label308;
          }
        }
        catch (JSONException paramJSONObject)
        {
          paramJSONObject.printStackTrace();
          return null;
        }
        if (localJSONObject.has("pic_id"))
        {
          localTroopFeedItem.picPath = ("https://gdynamic.qpic.cn/gdynamic/" + localJSONObject.getString("pic_id") + "/109");
          break label308;
          label283:
          if ((aqmr.isEmpty(localTroopFeedItem.linkUrl)) || (aqmr.isEmpty(localTroopFeedItem.content))) {
            break;
          }
          return localTroopFeedItem;
        }
        label308:
        i += 1;
      }
    }
  }
  
  public static class e
    extends apbn.c
  {
    public TroopFeedItem a(JSONObject paramJSONObject)
    {
      TroopFeedItem localTroopFeedItem = super.a(paramJSONObject);
      if (localTroopFeedItem == null) {
        return null;
      }
      for (;;)
      {
        int i;
        int j;
        try
        {
          localTroopFeedItem.type = paramJSONObject.getInt("feed_type");
          JSONArray localJSONArray = paramJSONObject.getJSONArray("content");
          localTroopFeedItem.linkUrl = paramJSONObject.getString("open_url");
          i = 0;
          if (i >= localJSONArray.length()) {
            break label200;
          }
          paramJSONObject = localJSONArray.getJSONObject(i);
          j = paramJSONObject.getInt("type");
          if (j == 0)
          {
            localTroopFeedItem.content = paramJSONObject.getString("value");
          }
          else if (j == 3)
          {
            if (!paramJSONObject.has("pic_url")) {
              break label203;
            }
            localTroopFeedItem.picPath = (paramJSONObject.getString("pic_url") + "/109");
          }
        }
        catch (JSONException paramJSONObject)
        {
          paramJSONObject.printStackTrace();
          return null;
        }
        if (j == 10)
        {
          localTroopFeedItem.title = paramJSONObject.getString("value");
        }
        else if ((j == 6) && (aqmr.isEmpty(localTroopFeedItem.picPath)) && (paramJSONObject.has("pic_url")))
        {
          localTroopFeedItem.picPath = paramJSONObject.getString("pic_url");
          break label203;
          label200:
          return localTroopFeedItem;
        }
        label203:
        i += 1;
      }
    }
  }
  
  public static class f
    extends apbn.c
  {
    public TroopFeedItem a(JSONObject paramJSONObject)
    {
      TroopFeedItem localTroopFeedItem = super.a(paramJSONObject);
      if (localTroopFeedItem == null) {
        return null;
      }
      Object localObject;
      try
      {
        localObject = paramJSONObject.getJSONArray("content");
        if (((JSONArray)localObject).length() <= 0) {
          break label333;
        }
        localObject = ((JSONArray)localObject).getJSONObject(0);
        int i = ((JSONObject)localObject).getInt("type");
        if (i == 5)
        {
          if (((JSONObject)localObject).has("file_path")) {
            localTroopFeedItem.linkUrl = ((JSONObject)localObject).getString("file_path");
          }
          localTroopFeedItem.type = 131;
          if (((JSONObject)localObject).has("sharesize")) {
            localTroopFeedItem.ex_1 = ("" + ((JSONObject)localObject).getLong("sharesize"));
          }
          boolean bool = ((JSONObject)localObject).has("bus_id");
          if (bool) {}
          try
          {
            localTroopFeedItem.content = ("" + ((JSONObject)localObject).getLong("bus_id"));
            if (((JSONObject)localObject).has("sharefile")) {
              localTroopFeedItem.title = ((JSONObject)localObject).getString("sharefile");
            }
            if (((JSONObject)localObject).has("shareexpire")) {
              localTroopFeedItem.shareExpire = ((JSONObject)localObject).getLong("shareexpire");
            }
            if (!((JSONObject)localObject).has("sharefromuin")) {
              break label333;
            }
            localTroopFeedItem.shareFromUin = ((JSONObject)localObject).getString("sharefromuin");
          }
          catch (JSONException paramJSONObject)
          {
            for (;;)
            {
              localTroopFeedItem.content = ("" + ((JSONObject)localObject).getString("bus_id"));
            }
          }
        }
        if (i != 4) {
          break label333;
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return null;
      }
      localTroopFeedItem.type = 132;
      localTroopFeedItem.linkUrl = paramJSONObject.getString("open_url");
      localTroopFeedItem.title = ((JSONObject)localObject).getString("musicname");
      localTroopFeedItem.ex_1 = ((JSONObject)localObject).getString("musicid");
      localTroopFeedItem.picPath = ((JSONObject)localObject).getString("pic_url");
      label333:
      return localTroopFeedItem;
    }
  }
  
  public static class g
    extends apbn.c
  {
    public TroopFeedItem a(JSONObject paramJSONObject)
    {
      TroopFeedItem localTroopFeedItem = super.a(paramJSONObject);
      if (localTroopFeedItem == null) {
        return null;
      }
      localTroopFeedItem.type = 10;
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray("content");
        if (paramJSONObject.length() > 0)
        {
          paramJSONObject = paramJSONObject.getJSONObject(0);
          localTroopFeedItem.linkUrl = paramJSONObject.getString("videourl");
          localTroopFeedItem.title = paramJSONObject.getString("videointro");
          localTroopFeedItem.picPath = paramJSONObject.getString("videoid");
        }
        return localTroopFeedItem;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
      return null;
    }
  }
  
  public static class h
    extends apbn.c
  {
    public TroopFeedItem a(JSONObject paramJSONObject)
    {
      int j = 0;
      TroopFeedItem localTroopFeedItem = super.a(paramJSONObject);
      if (localTroopFeedItem == null) {
        return null;
      }
      localTroopFeedItem.type = 12;
      for (;;)
      {
        int i;
        try
        {
          localTroopFeedItem.linkUrl = paramJSONObject.getString("open_url");
          paramJSONObject = paramJSONObject.getJSONObject("vote");
          if (paramJSONObject != null)
          {
            JSONArray localJSONArray = paramJSONObject.getJSONArray("opts");
            i = 0;
            if ((i >= localJSONArray.length()) || (j > 1))
            {
              paramJSONObject = paramJSONObject.getJSONArray("title");
              if (paramJSONObject.length() > 0) {
                localTroopFeedItem.title = paramJSONObject.getJSONObject(0).getString("value");
              }
            }
            else
            {
              Object localObject = localJSONArray.getJSONArray(i);
              k = j;
              if (((JSONArray)localObject).length() <= 0) {
                break label177;
              }
              localObject = ((JSONArray)localObject).getJSONObject(0);
              if (j == 0) {
                localTroopFeedItem.content = ((JSONObject)localObject).getString("value");
              } else {
                localTroopFeedItem.ex_1 = ((JSONObject)localObject).getString("value");
              }
            }
          }
        }
        catch (JSONException paramJSONObject)
        {
          paramJSONObject.printStackTrace();
          return null;
        }
        return localTroopFeedItem;
        int k = j + 1;
        label177:
        i += 1;
        j = k;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apbn
 * JD-Core Version:    0.7.0.1
 */