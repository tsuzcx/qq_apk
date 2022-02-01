package com.tencent.token;

import android.content.ContentValues;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.UserTask;
import com.tencent.token.utils.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bu
{
  private static int d = 20;
  private static int e = 30;
  private static int f = d;
  private static bu g = null;
  private static boolean i = false;
  public boolean a = true;
  protected JSONArray b = new JSONArray();
  protected String c;
  private boolean h = false;
  private boolean j;
  private UserTask<String, String, e> k = null;
  
  public static bu a()
  {
    if (g == null) {
      g = new bu();
    }
    if ((!c.l()) && (!i))
    {
      i = true;
      g.c();
    }
    return g;
  }
  
  private e a(String paramString)
  {
    e locale = new e();
    if (!cq.a().o())
    {
      if (this.j) {
        b();
      }
      locale.b(30001);
    }
    for (;;)
    {
      return locale;
      Object localObject = l.b(paramString.getBytes());
      paramString = c.e() + "/cn/mbtoken3/mbtoken3_click_flow_encrypt";
      ContentValues localContentValues = new ContentValues(3);
      localContentValues.put("aq_base_sid", cq.c);
      localContentValues.put("data", (String)localObject);
      g.a("clickflow aq_base_sid=" + cq.c);
      g.a("clickflow data=" + (String)localObject);
      localObject = new ey();
      paramString = ((ey)localObject).a(paramString, localContentValues);
      if (paramString == null)
      {
        if (this.j) {
          b();
        }
        locale.a(((ey)localObject).a());
        return locale;
      }
      try
      {
        paramString = new JSONObject(new String(paramString));
        m = paramString.getInt("err");
        if (m != 0)
        {
          paramString = paramString.getString("info");
          locale.a(m, paramString, paramString);
        }
        for (;;)
        {
          return locale;
          locale.c();
          if (this.b.length() <= e) {
            break;
          }
          m = e;
          if (m > e) {
            break label367;
          }
          this.b = new JSONArray();
        }
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          g.c("parse json failed: " + paramString.toString());
          locale.a(10020, "JSONException:" + paramString.toString());
          return locale;
          int m = this.b.length();
          continue;
          paramString = new JSONArray();
          while (m < this.b.length())
          {
            paramString.put(this.b.get(m));
            m += 1;
          }
          this.b = paramString;
        }
      }
      catch (Exception paramString)
      {
        label367:
        g.c("unknown err: " + paramString.toString());
        locale.a(10021, "JSONException:" + paramString.toString());
        return locale;
      }
      finally
      {
        if (this.j) {
          b();
        }
      }
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (c.l()) {}
    for (;;)
    {
      return;
      if (this.b == null) {
        continue;
      }
      for (;;)
      {
        try
        {
          localJSONObject = new JSONObject();
          localJSONObject.put("t", paramLong / 1000L);
          localJSONObject.put("e", paramInt);
          localObject2 = cq.a().e();
          if (localObject2 != null) {
            localJSONObject.put("u", ((QQUser)localObject2).mUin);
          }
          int i1 = 1;
          m = 0;
          n = i1;
        }
        catch (Exception localException)
        {
          JSONObject localJSONObject;
          Object localObject2;
          int m;
          int n;
          continue;
        }
        try
        {
          if (m < this.b.length())
          {
            localObject2 = this.b.getJSONObject(m);
            if ((((JSONObject)localObject2).getInt("e") == paramInt) && (((JSONObject)localObject2).getLong("t") == paramLong / 1000L)) {
              n = 0;
            }
          }
          else
          {
            if (n != 0) {
              this.b.put(localJSONObject);
            }
            if (this.b.length() < f) {
              break;
            }
            a(false);
            return;
          }
          m += 1;
        }
        finally {}
      }
    }
  }
  
  /* Error */
  public void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 60	com/tencent/token/global/c:l	()Z
    //   3: ifeq +4 -> 7
    //   6: return
    //   7: aload_0
    //   8: iload_1
    //   9: putfield 83	com/tencent/token/bu:j	Z
    //   12: aload_0
    //   13: getfield 44	com/tencent/token/bu:h	Z
    //   16: ifne -10 -> 6
    //   19: aload_0
    //   20: getfield 42	com/tencent/token/bu:a	Z
    //   23: ifeq -17 -> 6
    //   26: aload_0
    //   27: getfield 51	com/tencent/token/bu:b	Lorg/json/JSONArray;
    //   30: invokevirtual 177	org/json/JSONArray:length	()I
    //   33: ifeq -27 -> 6
    //   36: aload_0
    //   37: iconst_1
    //   38: putfield 44	com/tencent/token/bu:h	Z
    //   41: new 48	org/json/JSONArray
    //   44: dup
    //   45: invokespecial 49	org/json/JSONArray:<init>	()V
    //   48: astore 6
    //   50: aload_0
    //   51: getfield 51	com/tencent/token/bu:b	Lorg/json/JSONArray;
    //   54: invokevirtual 177	org/json/JSONArray:length	()I
    //   57: getstatic 30	com/tencent/token/bu:e	I
    //   60: if_icmple +35 -> 95
    //   63: getstatic 30	com/tencent/token/bu:e	I
    //   66: istore_2
    //   67: iconst_0
    //   68: istore_3
    //   69: iload_3
    //   70: iload_2
    //   71: if_icmpge +37 -> 108
    //   74: aload 6
    //   76: aload_0
    //   77: getfield 51	com/tencent/token/bu:b	Lorg/json/JSONArray;
    //   80: iload_3
    //   81: invokevirtual 191	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   84: invokevirtual 194	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   87: pop
    //   88: iload_3
    //   89: iconst_1
    //   90: iadd
    //   91: istore_3
    //   92: goto -23 -> 69
    //   95: aload_0
    //   96: getfield 51	com/tencent/token/bu:b	Lorg/json/JSONArray;
    //   99: invokevirtual 177	org/json/JSONArray:length	()I
    //   102: istore_2
    //   103: goto -36 -> 67
    //   106: astore 7
    //   108: aload_0
    //   109: monitorenter
    //   110: new 151	org/json/JSONObject
    //   113: dup
    //   114: invokespecial 200	org/json/JSONObject:<init>	()V
    //   117: astore 7
    //   119: lconst_0
    //   120: lstore 4
    //   122: invokestatic 78	com/tencent/token/cq:a	()Lcom/tencent/token/cq;
    //   125: astore 8
    //   127: aload 8
    //   129: invokevirtual 235	com/tencent/token/cq:k	()Lcom/tencent/token/core/bean/QQUser;
    //   132: astore 9
    //   134: aload 9
    //   136: ifnull +123 -> 259
    //   139: aload 9
    //   141: getfield 222	com/tencent/token/core/bean/QQUser:mUin	J
    //   144: lstore 4
    //   146: aload 7
    //   148: ldc 237
    //   150: invokestatic 242	com/tencent/token/cb:c	()Lcom/tencent/token/cb;
    //   153: invokevirtual 246	com/tencent/token/cb:s	()J
    //   156: ldc2_w 203
    //   159: ldiv
    //   160: l2i
    //   161: invokevirtual 211	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   164: pop
    //   165: getstatic 250	com/tencent/token/ca:a	I
    //   168: iconst_1
    //   169: iadd
    //   170: istore_2
    //   171: iload_2
    //   172: putstatic 250	com/tencent/token/ca:a	I
    //   175: aload 7
    //   177: ldc 252
    //   179: iload_2
    //   180: invokevirtual 211	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   183: pop
    //   184: aload 7
    //   186: ldc 254
    //   188: lload 4
    //   190: invokevirtual 207	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   193: pop
    //   194: aload 7
    //   196: ldc_w 256
    //   199: invokestatic 242	com/tencent/token/cb:c	()Lcom/tencent/token/cb;
    //   202: invokevirtual 258	com/tencent/token/cb:k	()J
    //   205: invokestatic 262	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   208: invokevirtual 265	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   211: pop
    //   212: aload 7
    //   214: ldc_w 267
    //   217: aload 6
    //   219: invokevirtual 265	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   222: pop
    //   223: aload_0
    //   224: aload 7
    //   226: invokevirtual 268	org/json/JSONObject:toString	()Ljava/lang/String;
    //   229: putfield 269	com/tencent/token/bu:c	Ljava/lang/String;
    //   232: aload_0
    //   233: monitorexit
    //   234: aload_0
    //   235: new 6	com/tencent/token/bu$1
    //   238: dup
    //   239: aload_0
    //   240: invokespecial 272	com/tencent/token/bu$1:<init>	(Lcom/tencent/token/bu;)V
    //   243: putfield 46	com/tencent/token/bu:k	Lcom/tencent/token/utils/UserTask;
    //   246: aload_0
    //   247: getfield 46	com/tencent/token/bu:k	Lcom/tencent/token/utils/UserTask;
    //   250: iconst_0
    //   251: anewarray 90	java/lang/String
    //   254: invokevirtual 277	com/tencent/token/utils/UserTask:c	([Ljava/lang/Object;)Lcom/tencent/token/utils/UserTask;
    //   257: pop
    //   258: return
    //   259: aload 8
    //   261: invokevirtual 214	com/tencent/token/cq:e	()Lcom/tencent/token/core/bean/QQUser;
    //   264: astore 8
    //   266: aload 8
    //   268: ifnull -122 -> 146
    //   271: aload 8
    //   273: getfield 222	com/tencent/token/core/bean/QQUser:mUin	J
    //   276: lstore 4
    //   278: goto -132 -> 146
    //   281: astore 6
    //   283: aload_0
    //   284: monitorexit
    //   285: return
    //   286: astore 6
    //   288: aload_0
    //   289: monitorexit
    //   290: aload 6
    //   292: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	this	bu
    //   0	293	1	paramBoolean	boolean
    //   66	114	2	m	int
    //   68	24	3	n	int
    //   120	157	4	l	long
    //   48	170	6	localJSONArray	JSONArray
    //   281	1	6	localJSONException	JSONException
    //   286	5	6	localObject1	Object
    //   106	1	7	localException	Exception
    //   117	108	7	localJSONObject	JSONObject
    //   125	147	8	localObject2	Object
    //   132	8	9	localQQUser	QQUser
    // Exception table:
    //   from	to	target	type
    //   74	88	106	java/lang/Exception
    //   122	134	281	org/json/JSONException
    //   139	146	281	org/json/JSONException
    //   146	223	281	org/json/JSONException
    //   259	266	281	org/json/JSONException
    //   271	278	281	org/json/JSONException
    //   110	119	286	finally
    //   122	134	286	finally
    //   139	146	286	finally
    //   146	223	286	finally
    //   223	234	286	finally
    //   259	266	286	finally
    //   271	278	286	finally
    //   283	285	286	finally
    //   288	290	286	finally
  }
  
  /* Error */
  public boolean a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 60	com/tencent/token/global/c:l	()Z
    //   3: ifeq +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: aload_0
    //   9: getfield 51	com/tencent/token/bu:b	Lorg/json/JSONArray;
    //   12: ifnull -6 -> 6
    //   15: iconst_0
    //   16: putstatic 36	com/tencent/token/bu:i	Z
    //   19: aload_0
    //   20: getfield 42	com/tencent/token/bu:a	Z
    //   23: ifne +5 -> 28
    //   26: iconst_1
    //   27: ireturn
    //   28: aload_1
    //   29: ldc_w 284
    //   32: iconst_0
    //   33: invokevirtual 290	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   36: astore_1
    //   37: aload_1
    //   38: ifnull -32 -> 6
    //   41: aload_1
    //   42: aload_0
    //   43: getfield 51	com/tencent/token/bu:b	Lorg/json/JSONArray;
    //   46: invokevirtual 291	org/json/JSONArray:toString	()Ljava/lang/String;
    //   49: invokevirtual 94	java/lang/String:getBytes	()[B
    //   52: invokevirtual 296	java/io/FileOutputStream:write	([B)V
    //   55: aload_1
    //   56: invokevirtual 299	java/io/FileOutputStream:close	()V
    //   59: iconst_1
    //   60: ireturn
    //   61: astore_2
    //   62: aload_1
    //   63: invokevirtual 299	java/io/FileOutputStream:close	()V
    //   66: iconst_0
    //   67: ireturn
    //   68: astore_1
    //   69: iconst_0
    //   70: ireturn
    //   71: astore_1
    //   72: goto -13 -> 59
    //   75: astore_1
    //   76: iconst_0
    //   77: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	bu
    //   0	78	1	paramContext	android.content.Context
    //   61	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   41	55	61	java/lang/Exception
    //   62	66	68	java/io/IOException
    //   55	59	71	java/io/IOException
    //   28	37	75	java/io/FileNotFoundException
  }
  
  public boolean b()
  {
    if (c.l()) {
      return false;
    }
    return a(RqdApplication.l());
  }
  
  /* Error */
  public boolean c()
  {
    // Byte code:
    //   0: invokestatic 60	com/tencent/token/global/c:l	()Z
    //   3: ifeq +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: aload_0
    //   9: getfield 42	com/tencent/token/bu:a	Z
    //   12: ifne +5 -> 17
    //   15: iconst_1
    //   16: ireturn
    //   17: invokestatic 304	com/tencent/token/global/RqdApplication:l	()Landroid/content/Context;
    //   20: ldc_w 284
    //   23: invokevirtual 310	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   26: astore_1
    //   27: aload_1
    //   28: ifnull -22 -> 6
    //   31: sipush 2000
    //   34: newarray byte
    //   36: astore_2
    //   37: aload_1
    //   38: aload_2
    //   39: invokevirtual 316	java/io/FileInputStream:read	([B)I
    //   42: pop
    //   43: aload_0
    //   44: new 48	org/json/JSONArray
    //   47: dup
    //   48: new 90	java/lang/String
    //   51: dup
    //   52: aload_2
    //   53: invokespecial 154	java/lang/String:<init>	([B)V
    //   56: invokespecial 317	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   59: putfield 51	com/tencent/token/bu:b	Lorg/json/JSONArray;
    //   62: aload_1
    //   63: invokevirtual 318	java/io/FileInputStream:close	()V
    //   66: iconst_1
    //   67: ireturn
    //   68: astore_2
    //   69: aload_1
    //   70: invokevirtual 318	java/io/FileInputStream:close	()V
    //   73: iconst_0
    //   74: ireturn
    //   75: astore_1
    //   76: iconst_0
    //   77: ireturn
    //   78: astore_1
    //   79: goto -13 -> 66
    //   82: astore_1
    //   83: iconst_0
    //   84: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	bu
    //   26	44	1	localFileInputStream	java.io.FileInputStream
    //   75	1	1	localIOException1	java.io.IOException
    //   78	1	1	localIOException2	java.io.IOException
    //   82	1	1	localFileNotFoundException	java.io.FileNotFoundException
    //   36	17	2	arrayOfByte	byte[]
    //   68	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   31	62	68	java/lang/Exception
    //   69	73	75	java/io/IOException
    //   62	66	78	java/io/IOException
    //   17	27	82	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bu
 * JD-Core Version:    0.7.0.1
 */