package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.dp;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class ProtoSetMbMobile
  extends d
{
  private long d;
  private String e;
  private String f;
  private String g;
  private int h;
  private String i;
  private String j;
  private String k;
  
  public static void a(dp paramdp, long paramLong, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    paramdp.c.put("param.uinhash", Long.valueOf(paramLong));
    paramdp.c.put("param.mbmobile.set", Integer.valueOf(paramInt));
    paramdp.c.put("param.mbmobile.mobile", paramString1);
    paramdp.c.put("param.mbmoible.areacode", paramString2);
    paramdp.c.put("param.wtlogin.a2", paramString3);
  }
  
  /* Error */
  protected String a()
  {
    // Byte code:
    //   0: invokestatic 63	com/tencent/token/cb:a	()Lcom/tencent/token/cb;
    //   3: invokevirtual 66	com/tencent/token/cb:b	()Ljava/lang/String;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +14 -> 22
    //   11: aload_0
    //   12: getfield 69	com/tencent/token/core/protocolcenter/protocol/ProtoSetMbMobile:a	Lcom/tencent/token/global/e;
    //   15: bipush 104
    //   17: invokevirtual 74	com/tencent/token/global/e:b	(I)V
    //   20: aconst_null
    //   21: areturn
    //   22: new 76	org/json/JSONObject
    //   25: dup
    //   26: invokespecial 77	org/json/JSONObject:<init>	()V
    //   29: astore_3
    //   30: aload_3
    //   31: ldc 79
    //   33: aload_0
    //   34: getfield 81	com/tencent/token/core/protocolcenter/protocol/ProtoSetMbMobile:h	I
    //   37: invokevirtual 84	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   40: pop
    //   41: aload_3
    //   42: ldc 86
    //   44: aload_0
    //   45: getfield 88	com/tencent/token/core/protocolcenter/protocol/ProtoSetMbMobile:d	J
    //   48: invokevirtual 91	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   51: pop
    //   52: aload_3
    //   53: ldc 93
    //   55: aload_0
    //   56: getfield 95	com/tencent/token/core/protocolcenter/protocol/ProtoSetMbMobile:i	Ljava/lang/String;
    //   59: invokevirtual 98	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   62: pop
    //   63: aload_3
    //   64: ldc 100
    //   66: aload_0
    //   67: getfield 102	com/tencent/token/core/protocolcenter/protocol/ProtoSetMbMobile:j	Ljava/lang/String;
    //   70: invokevirtual 98	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   73: pop
    //   74: aload_3
    //   75: ldc 104
    //   77: aload_0
    //   78: getfield 106	com/tencent/token/core/protocolcenter/protocol/ProtoSetMbMobile:k	Ljava/lang/String;
    //   81: invokevirtual 98	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   84: pop
    //   85: aload_3
    //   86: ldc 108
    //   88: invokestatic 114	com/tencent/token/global/RqdApplication:n	()Landroid/content/Context;
    //   91: invokestatic 119	com/tencent/token/ca:a	(Landroid/content/Context;)Lcom/tencent/token/ca;
    //   94: invokevirtual 122	com/tencent/token/ca:b	()[B
    //   97: invokestatic 127	com/tencent/token/utils/l:a	([B)Ljava/lang/String;
    //   100: invokevirtual 98	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   103: pop
    //   104: getstatic 131	com/tencent/token/cc:a	I
    //   107: iconst_1
    //   108: iadd
    //   109: istore_1
    //   110: iload_1
    //   111: putstatic 131	com/tencent/token/cc:a	I
    //   114: aload_0
    //   115: iload_1
    //   116: putfield 133	com/tencent/token/core/protocolcenter/protocol/ProtoSetMbMobile:c	I
    //   119: aload_3
    //   120: ldc 135
    //   122: aload_0
    //   123: getfield 133	com/tencent/token/core/protocolcenter/protocol/ProtoSetMbMobile:c	I
    //   126: invokevirtual 84	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   129: pop
    //   130: aload_3
    //   131: ldc 137
    //   133: invokestatic 142	com/tencent/token/cd:c	()Lcom/tencent/token/cd;
    //   136: invokevirtual 146	com/tencent/token/cd:s	()J
    //   139: ldc2_w 147
    //   142: ldiv
    //   143: l2i
    //   144: invokevirtual 84	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   147: pop
    //   148: aload_3
    //   149: invokevirtual 151	org/json/JSONObject:toString	()Ljava/lang/String;
    //   152: invokevirtual 156	java/lang/String:getBytes	()[B
    //   155: invokestatic 158	com/tencent/token/utils/l:b	([B)Ljava/lang/String;
    //   158: astore_3
    //   159: aload_3
    //   160: ifnonnull +15 -> 175
    //   163: aload_0
    //   164: getfield 69	com/tencent/token/core/protocolcenter/protocol/ProtoSetMbMobile:a	Lcom/tencent/token/global/e;
    //   167: sipush 10000
    //   170: invokevirtual 74	com/tencent/token/global/e:b	(I)V
    //   173: aconst_null
    //   174: areturn
    //   175: new 160	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   182: astore 4
    //   184: aload 4
    //   186: ldc 163
    //   188: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload 4
    //   194: aload_2
    //   195: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload 4
    //   201: ldc 169
    //   203: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: aload 4
    //   209: aload_3
    //   210: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload 4
    //   216: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: astore_2
    //   220: new 160	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   227: astore_3
    //   228: aload_3
    //   229: invokestatic 174	com/tencent/token/global/c:e	()Ljava/lang/String;
    //   232: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload_3
    //   237: ldc 176
    //   239: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: aload_3
    //   244: aload_2
    //   245: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload_3
    //   250: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: areturn
    //   254: astore_2
    //   255: goto +11 -> 266
    //   258: astore_2
    //   259: aload_2
    //   260: invokevirtual 179	org/json/JSONException:printStackTrace	()V
    //   263: goto -100 -> 163
    //   266: aload_3
    //   267: invokevirtual 151	org/json/JSONObject:toString	()Ljava/lang/String;
    //   270: invokevirtual 156	java/lang/String:getBytes	()[B
    //   273: invokestatic 158	com/tencent/token/utils/l:b	([B)Ljava/lang/String;
    //   276: ifnonnull +6 -> 282
    //   279: goto -116 -> 163
    //   282: aload_2
    //   283: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	284	0	this	ProtoSetMbMobile
    //   109	7	1	m	int
    //   6	239	2	str	String
    //   254	1	2	localObject1	java.lang.Object
    //   258	25	2	localJSONException	JSONException
    //   29	238	3	localObject2	java.lang.Object
    //   182	33	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   30	148	254	finally
    //   259	263	254	finally
    //   30	148	258	org/json/JSONException
  }
  
  protected void a(dp paramdp)
  {
    this.d = ((Long)paramdp.c.get("param.uinhash")).longValue();
    this.h = ((Integer)paramdp.c.get("param.mbmobile.set")).intValue();
    this.i = ((String)paramdp.c.get("param.mbmobile.mobile"));
    this.j = ((String)paramdp.c.get("param.mbmoible.areacode"));
    this.k = ((String)paramdp.c.get("param.wtlogin.a2"));
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int m = paramJSONObject.getInt("err");
    if (m == 0)
    {
      paramJSONObject = l.c(paramJSONObject.getString("data"));
      if (paramJSONObject != null)
      {
        paramJSONObject = new JSONObject(new String(paramJSONObject));
        if (paramJSONObject.getInt("seq_id") != this.c)
        {
          a(10000, RqdApplication.n().getString(2131493068));
          return;
        }
        this.a.c();
        this.f = paramJSONObject.getString("time1");
        this.g = paramJSONObject.getString("time2");
        this.e = paramJSONObject.optString("extraInfo");
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parseJSON error decodeData=");
      localStringBuilder.append(paramJSONObject);
      g.c(localStringBuilder.toString());
      this.a.a(10022, RqdApplication.n().getString(2131493068), RqdApplication.n().getString(2131493068));
      return;
    }
    paramJSONObject = paramJSONObject.getString("info");
    this.e = paramJSONObject;
    a(m, paramJSONObject);
  }
  
  protected void b()
  {
    if ((!this.b.e) && (this.b.d != null))
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("info", this.e);
        localJSONObject.put("time1", this.f);
        localJSONObject.put("time2", this.g);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      localMessage.obj = localJSONObject;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoSetMbMobile
 * JD-Core Version:    0.7.0.1
 */