package com.tencent.token;

import android.content.ContentValues;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.UserTask;
import com.tencent.token.utils.w;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ch
{
  private static int d = 20;
  private static int e = 30;
  private static int f = d;
  private static ch g = null;
  private static boolean i = false;
  public boolean a = true;
  protected JSONArray b = new JSONArray();
  protected String c;
  private boolean h = false;
  private boolean j;
  private UserTask k = null;
  
  public static ch a()
  {
    if (g == null) {
      g = new ch();
    }
    if ((!c.l()) && (!i))
    {
      i = true;
      g.c();
    }
    return g;
  }
  
  private f a(String paramString)
  {
    f localf = new f();
    if (!do.a().o())
    {
      if (this.j) {
        b();
      }
      localf.b(30001);
    }
    for (;;)
    {
      return localf;
      Object localObject = w.b(paramString.getBytes());
      paramString = c.e() + "/cn/mbtoken3/mbtoken3_click_flow_encrypt";
      ContentValues localContentValues = new ContentValues(3);
      localContentValues.put("aq_base_sid", do.c);
      localContentValues.put("data", (String)localObject);
      h.a("clickflow aq_base_sid=" + do.c);
      h.a("clickflow data=" + (String)localObject);
      localObject = new gk();
      paramString = ((gk)localObject).a(paramString, localContentValues);
      if (paramString == null)
      {
        if (this.j) {
          b();
        }
        localf.a(((gk)localObject).a());
        return localf;
      }
      try
      {
        paramString = new JSONObject(new String(paramString));
        m = paramString.getInt("err");
        if (m != 0)
        {
          paramString = paramString.getString("info");
          localf.a(m, paramString, paramString);
        }
        for (;;)
        {
          return localf;
          localf.c();
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
          h.c("parse json failed: " + paramString.toString());
          localf.a(10020, "JSONException:" + paramString.toString());
          return localf;
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
        h.c("unknown err: " + paramString.toString());
        localf.a(10021, "JSONException:" + paramString.toString());
        return localf;
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
          localObject2 = do.a().e();
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
    //   0: invokestatic 57	com/tencent/token/global/c:l	()Z
    //   3: ifeq +4 -> 7
    //   6: return
    //   7: aload_0
    //   8: iload_1
    //   9: putfield 80	com/tencent/token/ch:j	Z
    //   12: aload_0
    //   13: getfield 41	com/tencent/token/ch:h	Z
    //   16: ifne -10 -> 6
    //   19: aload_0
    //   20: getfield 39	com/tencent/token/ch:a	Z
    //   23: ifeq -17 -> 6
    //   26: aload_0
    //   27: getfield 48	com/tencent/token/ch:b	Lorg/json/JSONArray;
    //   30: invokevirtual 174	org/json/JSONArray:length	()I
    //   33: ifeq -27 -> 6
    //   36: aload_0
    //   37: iconst_1
    //   38: putfield 41	com/tencent/token/ch:h	Z
    //   41: new 45	org/json/JSONArray
    //   44: dup
    //   45: invokespecial 46	org/json/JSONArray:<init>	()V
    //   48: astore 6
    //   50: aload_0
    //   51: getfield 48	com/tencent/token/ch:b	Lorg/json/JSONArray;
    //   54: invokevirtual 174	org/json/JSONArray:length	()I
    //   57: getstatic 27	com/tencent/token/ch:e	I
    //   60: if_icmple +35 -> 95
    //   63: getstatic 27	com/tencent/token/ch:e	I
    //   66: istore_2
    //   67: iconst_0
    //   68: istore_3
    //   69: iload_3
    //   70: iload_2
    //   71: if_icmpge +37 -> 108
    //   74: aload 6
    //   76: aload_0
    //   77: getfield 48	com/tencent/token/ch:b	Lorg/json/JSONArray;
    //   80: iload_3
    //   81: invokevirtual 188	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   84: invokevirtual 191	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   87: pop
    //   88: iload_3
    //   89: iconst_1
    //   90: iadd
    //   91: istore_3
    //   92: goto -23 -> 69
    //   95: aload_0
    //   96: getfield 48	com/tencent/token/ch:b	Lorg/json/JSONArray;
    //   99: invokevirtual 174	org/json/JSONArray:length	()I
    //   102: istore_2
    //   103: goto -36 -> 67
    //   106: astore 7
    //   108: aload_0
    //   109: monitorenter
    //   110: new 148	org/json/JSONObject
    //   113: dup
    //   114: invokespecial 197	org/json/JSONObject:<init>	()V
    //   117: astore 7
    //   119: lconst_0
    //   120: lstore 4
    //   122: invokestatic 75	com/tencent/token/do:a	()Lcom/tencent/token/do;
    //   125: astore 8
    //   127: aload 8
    //   129: invokevirtual 232	com/tencent/token/do:k	()Lcom/tencent/token/core/bean/QQUser;
    //   132: astore 9
    //   134: aload 9
    //   136: ifnull +122 -> 258
    //   139: aload 9
    //   141: getfield 219	com/tencent/token/core/bean/QQUser:mUin	J
    //   144: lstore 4
    //   146: aload 7
    //   148: ldc 234
    //   150: invokestatic 239	com/tencent/token/cx:c	()Lcom/tencent/token/cx;
    //   153: invokevirtual 243	com/tencent/token/cx:s	()J
    //   156: ldc2_w 200
    //   159: ldiv
    //   160: l2i
    //   161: invokevirtual 208	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   164: pop
    //   165: getstatic 247	com/tencent/token/cw:a	I
    //   168: iconst_1
    //   169: iadd
    //   170: istore_2
    //   171: iload_2
    //   172: putstatic 247	com/tencent/token/cw:a	I
    //   175: aload 7
    //   177: ldc 249
    //   179: iload_2
    //   180: invokevirtual 208	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   183: pop
    //   184: aload 7
    //   186: ldc 251
    //   188: lload 4
    //   190: invokevirtual 204	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   193: pop
    //   194: aload 7
    //   196: ldc 253
    //   198: invokestatic 239	com/tencent/token/cx:c	()Lcom/tencent/token/cx;
    //   201: invokevirtual 255	com/tencent/token/cx:k	()J
    //   204: invokestatic 259	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   207: invokevirtual 262	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   210: pop
    //   211: aload 7
    //   213: ldc_w 264
    //   216: aload 6
    //   218: invokevirtual 262	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   221: pop
    //   222: aload_0
    //   223: aload 7
    //   225: invokevirtual 265	org/json/JSONObject:toString	()Ljava/lang/String;
    //   228: putfield 266	com/tencent/token/ch:c	Ljava/lang/String;
    //   231: aload_0
    //   232: monitorexit
    //   233: aload_0
    //   234: new 268	com/tencent/token/ci
    //   237: dup
    //   238: aload_0
    //   239: invokespecial 271	com/tencent/token/ci:<init>	(Lcom/tencent/token/ch;)V
    //   242: putfield 43	com/tencent/token/ch:k	Lcom/tencent/token/utils/UserTask;
    //   245: aload_0
    //   246: getfield 43	com/tencent/token/ch:k	Lcom/tencent/token/utils/UserTask;
    //   249: iconst_0
    //   250: anewarray 87	java/lang/String
    //   253: invokevirtual 276	com/tencent/token/utils/UserTask:c	([Ljava/lang/Object;)Lcom/tencent/token/utils/UserTask;
    //   256: pop
    //   257: return
    //   258: aload 8
    //   260: invokevirtual 211	com/tencent/token/do:e	()Lcom/tencent/token/core/bean/QQUser;
    //   263: astore 8
    //   265: aload 8
    //   267: ifnull -121 -> 146
    //   270: aload 8
    //   272: getfield 219	com/tencent/token/core/bean/QQUser:mUin	J
    //   275: lstore 4
    //   277: goto -131 -> 146
    //   280: astore 6
    //   282: aload_0
    //   283: monitorexit
    //   284: return
    //   285: astore 6
    //   287: aload_0
    //   288: monitorexit
    //   289: aload 6
    //   291: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	this	ch
    //   0	292	1	paramBoolean	boolean
    //   66	114	2	m	int
    //   68	24	3	n	int
    //   120	156	4	l	long
    //   48	169	6	localJSONArray	JSONArray
    //   280	1	6	localJSONException	JSONException
    //   285	5	6	localObject1	Object
    //   106	1	7	localException	Exception
    //   117	107	7	localJSONObject	JSONObject
    //   125	146	8	localObject2	Object
    //   132	8	9	localQQUser	QQUser
    // Exception table:
    //   from	to	target	type
    //   74	88	106	java/lang/Exception
    //   122	134	280	org/json/JSONException
    //   139	146	280	org/json/JSONException
    //   146	222	280	org/json/JSONException
    //   258	265	280	org/json/JSONException
    //   270	277	280	org/json/JSONException
    //   110	119	285	finally
    //   122	134	285	finally
    //   139	146	285	finally
    //   146	222	285	finally
    //   222	233	285	finally
    //   258	265	285	finally
    //   270	277	285	finally
    //   282	284	285	finally
    //   287	289	285	finally
  }
  
  /* Error */
  public boolean a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 57	com/tencent/token/global/c:l	()Z
    //   3: ifeq +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: aload_0
    //   9: getfield 48	com/tencent/token/ch:b	Lorg/json/JSONArray;
    //   12: ifnull -6 -> 6
    //   15: iconst_0
    //   16: putstatic 33	com/tencent/token/ch:i	Z
    //   19: aload_0
    //   20: getfield 39	com/tencent/token/ch:a	Z
    //   23: ifne +5 -> 28
    //   26: iconst_1
    //   27: ireturn
    //   28: aload_1
    //   29: ldc_w 283
    //   32: iconst_0
    //   33: invokevirtual 289	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   36: astore_1
    //   37: aload_1
    //   38: ifnull -32 -> 6
    //   41: aload_1
    //   42: aload_0
    //   43: getfield 48	com/tencent/token/ch:b	Lorg/json/JSONArray;
    //   46: invokevirtual 290	org/json/JSONArray:toString	()Ljava/lang/String;
    //   49: invokevirtual 91	java/lang/String:getBytes	()[B
    //   52: invokevirtual 295	java/io/FileOutputStream:write	([B)V
    //   55: aload_1
    //   56: invokevirtual 298	java/io/FileOutputStream:close	()V
    //   59: iconst_1
    //   60: ireturn
    //   61: astore_2
    //   62: aload_1
    //   63: invokevirtual 298	java/io/FileOutputStream:close	()V
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
    //   0	78	0	this	ch
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
    //   0: invokestatic 57	com/tencent/token/global/c:l	()Z
    //   3: ifeq +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: aload_0
    //   9: getfield 39	com/tencent/token/ch:a	Z
    //   12: ifne +5 -> 17
    //   15: iconst_1
    //   16: ireturn
    //   17: invokestatic 303	com/tencent/token/global/RqdApplication:l	()Landroid/content/Context;
    //   20: ldc_w 283
    //   23: invokevirtual 309	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   26: astore_1
    //   27: aload_1
    //   28: ifnull -22 -> 6
    //   31: sipush 2000
    //   34: newarray byte
    //   36: astore_2
    //   37: aload_1
    //   38: aload_2
    //   39: invokevirtual 315	java/io/FileInputStream:read	([B)I
    //   42: pop
    //   43: aload_0
    //   44: new 45	org/json/JSONArray
    //   47: dup
    //   48: new 87	java/lang/String
    //   51: dup
    //   52: aload_2
    //   53: invokespecial 151	java/lang/String:<init>	([B)V
    //   56: invokespecial 316	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   59: putfield 48	com/tencent/token/ch:b	Lorg/json/JSONArray;
    //   62: aload_1
    //   63: invokevirtual 317	java/io/FileInputStream:close	()V
    //   66: iconst_1
    //   67: ireturn
    //   68: astore_2
    //   69: aload_1
    //   70: invokevirtual 317	java/io/FileInputStream:close	()V
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
    //   0	85	0	this	ch
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
 * Qualified Name:     com.tencent.token.ch
 * JD-Core Version:    0.7.0.1
 */