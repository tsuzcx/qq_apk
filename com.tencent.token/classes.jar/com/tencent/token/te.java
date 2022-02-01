package com.tencent.token;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class te
{
  public int a;
  public String b;
  public boolean c;
  public int d;
  public boolean e = false;
  public boolean f = false;
  public boolean g = false;
  public Object h = null;
  protected List<te> i = null;
  
  private void a(te paramte)
  {
    if (this.i == null) {
      this.i = new ArrayList();
    }
    this.i.add(paramte);
  }
  
  public final boolean a(JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        this.a = paramJSONObject.getInt("id");
        this.b = paramJSONObject.getString("name");
        if (paramJSONObject.getInt("value") != 0)
        {
          bool = true;
          this.c = bool;
          this.d = paramJSONObject.getInt("type");
          try
          {
            if (paramJSONObject.getInt("is_more") != 0) {
              break label253;
            }
            bool = false;
            this.g = bool;
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
        }
        int j;
        Object localObject2;
        Object localObject1;
        bool = false;
      }
      catch (JSONException paramJSONObject)
      {
        try
        {
          paramJSONObject = paramJSONObject.getJSONArray("child");
          if (paramJSONObject != null)
          {
            j = 0;
            if (j < paramJSONObject.length())
            {
              localObject2 = paramJSONObject.getJSONObject(j);
              if (localObject2 == null) {
                break label258;
              }
              bool = true;
              xv.a(bool);
              localObject1 = new te();
              if (!((te)localObject1).a((JSONObject)localObject2))
              {
                xv.c("child json parse error: ".concat(String.valueOf(j)));
                return false;
              }
              a((te)localObject1);
              localObject2 = new StringBuilder("add child: ");
              ((StringBuilder)localObject2).append(j);
              ((StringBuilder)localObject2).append(":");
              ((StringBuilder)localObject2).append(((te)localObject1).b);
              xv.b(((StringBuilder)localObject2).toString());
              j += 1;
              continue;
            }
          }
          return true;
        }
        catch (JSONException paramJSONObject)
        {
          return true;
        }
        paramJSONObject = paramJSONObject;
        localObject1 = new StringBuilder("JSONException: ");
        ((StringBuilder)localObject1).append(paramJSONObject.getMessage());
        xv.c(((StringBuilder)localObject1).toString());
        return false;
      }
      continue;
      label253:
      boolean bool = true;
      continue;
      label258:
      bool = false;
    }
  }
  
  public final boolean b(JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        this.a = paramJSONObject.getInt("id");
        this.b = paramJSONObject.getString("name");
        if (paramJSONObject.getInt("value") != 0)
        {
          bool = true;
          this.c = bool;
        }
        int j;
        Object localObject2;
        Object localObject1;
        bool = false;
      }
      catch (JSONException paramJSONObject)
      {
        try
        {
          paramJSONObject = paramJSONObject.getJSONArray("child");
          if (paramJSONObject != null)
          {
            j = 0;
            if (j < paramJSONObject.length())
            {
              localObject2 = paramJSONObject.getJSONObject(j);
              if (localObject2 == null) {
                break label214;
              }
              bool = true;
              xv.a(bool);
              localObject1 = new te();
              if (!((te)localObject1).b((JSONObject)localObject2))
              {
                xv.c("child json parse error: ".concat(String.valueOf(j)));
                return false;
              }
              a((te)localObject1);
              localObject2 = new StringBuilder("add child: ");
              ((StringBuilder)localObject2).append(j);
              ((StringBuilder)localObject2).append(":");
              ((StringBuilder)localObject2).append(((te)localObject1).b);
              xv.b(((StringBuilder)localObject2).toString());
              j += 1;
              continue;
            }
          }
          return true;
        }
        catch (JSONException paramJSONObject)
        {
          return true;
        }
        paramJSONObject = paramJSONObject;
        localObject1 = new StringBuilder("JSONException: ");
        ((StringBuilder)localObject1).append(paramJSONObject.getMessage());
        xv.c(((StringBuilder)localObject1).toString());
        return false;
      }
      continue;
      label214:
      boolean bool = false;
    }
  }
  
  /* Error */
  public final boolean c(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: ldc 49
    //   4: invokevirtual 55	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   7: putfield 57	com/tencent/token/te:a	I
    //   10: aload_0
    //   11: aload_1
    //   12: ldc 59
    //   14: invokevirtual 63	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   17: putfield 65	com/tencent/token/te:b	Ljava/lang/String;
    //   20: aload_1
    //   21: ldc 67
    //   23: invokevirtual 55	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   26: ifeq +202 -> 228
    //   29: iconst_1
    //   30: istore_3
    //   31: goto +3 -> 34
    //   34: aload_0
    //   35: iload_3
    //   36: putfield 69	com/tencent/token/te:c	Z
    //   39: aload_1
    //   40: ldc 75
    //   42: invokevirtual 55	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   45: ifne +188 -> 233
    //   48: iconst_0
    //   49: istore_3
    //   50: goto +3 -> 53
    //   53: aload_0
    //   54: iload_3
    //   55: putfield 29	com/tencent/token/te:g	Z
    //   58: aload_1
    //   59: ldc 80
    //   61: invokevirtual 84	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   64: astore_1
    //   65: aload_1
    //   66: ifnull +125 -> 191
    //   69: iconst_0
    //   70: istore_2
    //   71: iload_2
    //   72: aload_1
    //   73: invokevirtual 90	org/json/JSONArray:length	()I
    //   76: if_icmpge +115 -> 191
    //   79: aload_1
    //   80: iload_2
    //   81: invokevirtual 94	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   84: astore 5
    //   86: aload 5
    //   88: ifnull +150 -> 238
    //   91: iconst_1
    //   92: istore_3
    //   93: goto +3 -> 96
    //   96: iload_3
    //   97: invokestatic 99	com/tencent/token/xv:a	(Z)V
    //   100: new 2	com/tencent/token/te
    //   103: dup
    //   104: invokespecial 100	com/tencent/token/te:<init>	()V
    //   107: astore 4
    //   109: aload 4
    //   111: aload 5
    //   113: invokevirtual 148	com/tencent/token/te:c	(Lorg/json/JSONObject;)Z
    //   116: ifne +17 -> 133
    //   119: ldc 104
    //   121: iload_2
    //   122: invokestatic 110	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   125: invokevirtual 113	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   128: invokestatic 116	com/tencent/token/xv:c	(Ljava/lang/String;)V
    //   131: iconst_0
    //   132: ireturn
    //   133: aload_0
    //   134: aload 4
    //   136: invokespecial 118	com/tencent/token/te:a	(Lcom/tencent/token/te;)V
    //   139: new 120	java/lang/StringBuilder
    //   142: dup
    //   143: ldc 122
    //   145: invokespecial 124	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   148: astore 5
    //   150: aload 5
    //   152: iload_2
    //   153: invokevirtual 128	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload 5
    //   159: ldc 130
    //   161: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload 5
    //   167: aload 4
    //   169: getfield 65	com/tencent/token/te:b	Ljava/lang/String;
    //   172: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload 5
    //   178: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 139	com/tencent/token/xv:b	(Ljava/lang/String;)V
    //   184: iload_2
    //   185: iconst_1
    //   186: iadd
    //   187: istore_2
    //   188: goto -117 -> 71
    //   191: iconst_1
    //   192: ireturn
    //   193: astore_1
    //   194: new 120	java/lang/StringBuilder
    //   197: dup
    //   198: ldc 141
    //   200: invokespecial 124	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   203: astore 4
    //   205: aload 4
    //   207: aload_1
    //   208: invokevirtual 144	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   211: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload 4
    //   217: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 116	com/tencent/token/xv:c	(Ljava/lang/String;)V
    //   223: iconst_0
    //   224: ireturn
    //   225: astore_1
    //   226: iconst_1
    //   227: ireturn
    //   228: iconst_0
    //   229: istore_3
    //   230: goto -196 -> 34
    //   233: iconst_1
    //   234: istore_3
    //   235: goto -182 -> 53
    //   238: iconst_0
    //   239: istore_3
    //   240: goto -144 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	te
    //   0	243	1	paramJSONObject	JSONObject
    //   70	118	2	j	int
    //   30	210	3	bool	boolean
    //   107	109	4	localObject1	Object
    //   84	93	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	29	193	org/json/JSONException
    //   34	48	193	org/json/JSONException
    //   53	58	193	org/json/JSONException
    //   58	65	225	org/json/JSONException
    //   71	86	225	org/json/JSONException
    //   96	131	225	org/json/JSONException
    //   133	184	225	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.te
 * JD-Core Version:    0.7.0.1
 */