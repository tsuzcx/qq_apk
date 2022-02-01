package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoGetMbMobileCode
  extends d
{
  private long d;
  private String e = "";
  private int f;
  private String g;
  private String h;
  
  public static void a(do paramdo, long paramLong, int paramInt, String paramString1, String paramString2)
  {
    paramdo.c.put("param.uinhash", Long.valueOf(paramLong));
    paramdo.c.put("param.mbmobile.getcode", Integer.valueOf(paramInt));
    paramdo.c.put("param.mbmobile.mobile", paramString1);
    paramdo.c.put("param.mbmoible.areacode", paramString2);
  }
  
  /* Error */
  protected String a()
  {
    // Byte code:
    //   0: invokestatic 62	com/tencent/token/ca:a	()Lcom/tencent/token/ca;
    //   3: invokevirtual 65	com/tencent/token/ca:b	()Ljava/lang/String;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +14 -> 22
    //   11: aload_0
    //   12: getfield 68	com/tencent/token/core/protocolcenter/protocol/ProtoGetMbMobileCode:a	Lcom/tencent/token/global/e;
    //   15: bipush 104
    //   17: invokevirtual 73	com/tencent/token/global/e:b	(I)V
    //   20: aconst_null
    //   21: areturn
    //   22: new 75	org/json/JSONObject
    //   25: dup
    //   26: invokespecial 76	org/json/JSONObject:<init>	()V
    //   29: astore_3
    //   30: aload_3
    //   31: ldc 78
    //   33: aload_0
    //   34: getfield 80	com/tencent/token/core/protocolcenter/protocol/ProtoGetMbMobileCode:d	J
    //   37: invokevirtual 83	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   40: pop
    //   41: getstatic 87	com/tencent/token/cb:a	I
    //   44: iconst_1
    //   45: iadd
    //   46: istore_1
    //   47: iload_1
    //   48: putstatic 87	com/tencent/token/cb:a	I
    //   51: aload_0
    //   52: iload_1
    //   53: putfield 89	com/tencent/token/core/protocolcenter/protocol/ProtoGetMbMobileCode:c	I
    //   56: aload_3
    //   57: ldc 91
    //   59: aload_0
    //   60: getfield 89	com/tencent/token/core/protocolcenter/protocol/ProtoGetMbMobileCode:c	I
    //   63: invokevirtual 94	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   66: pop
    //   67: aload_3
    //   68: ldc 96
    //   70: invokestatic 101	com/tencent/token/cc:c	()Lcom/tencent/token/cc;
    //   73: invokevirtual 105	com/tencent/token/cc:s	()J
    //   76: ldc2_w 106
    //   79: ldiv
    //   80: l2i
    //   81: invokevirtual 94	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   84: pop
    //   85: aload_3
    //   86: ldc 109
    //   88: aload_0
    //   89: getfield 111	com/tencent/token/core/protocolcenter/protocol/ProtoGetMbMobileCode:g	Ljava/lang/String;
    //   92: invokevirtual 114	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   95: pop
    //   96: aload_3
    //   97: ldc 116
    //   99: aload_0
    //   100: getfield 118	com/tencent/token/core/protocolcenter/protocol/ProtoGetMbMobileCode:f	I
    //   103: invokevirtual 94	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   106: pop
    //   107: aload_3
    //   108: ldc 120
    //   110: aload_0
    //   111: getfield 122	com/tencent/token/core/protocolcenter/protocol/ProtoGetMbMobileCode:h	Ljava/lang/String;
    //   114: invokevirtual 114	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   117: pop
    //   118: aload_3
    //   119: invokevirtual 125	org/json/JSONObject:toString	()Ljava/lang/String;
    //   122: invokevirtual 131	java/lang/String:getBytes	()[B
    //   125: invokestatic 136	com/tencent/token/utils/l:b	([B)Ljava/lang/String;
    //   128: astore_3
    //   129: aload_3
    //   130: ifnonnull +15 -> 145
    //   133: aload_0
    //   134: getfield 68	com/tencent/token/core/protocolcenter/protocol/ProtoGetMbMobileCode:a	Lcom/tencent/token/global/e;
    //   137: sipush 10000
    //   140: invokevirtual 73	com/tencent/token/global/e:b	(I)V
    //   143: aconst_null
    //   144: areturn
    //   145: new 138	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   152: astore 4
    //   154: aload 4
    //   156: ldc 141
    //   158: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload 4
    //   164: aload_2
    //   165: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload 4
    //   171: ldc 147
    //   173: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload 4
    //   179: aload_3
    //   180: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload 4
    //   186: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: astore_2
    //   190: new 138	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   197: astore_3
    //   198: aload_3
    //   199: invokestatic 152	com/tencent/token/global/c:e	()Ljava/lang/String;
    //   202: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload_3
    //   207: ldc 154
    //   209: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload_3
    //   214: aload_2
    //   215: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload_3
    //   220: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: areturn
    //   224: astore_2
    //   225: goto +11 -> 236
    //   228: astore_2
    //   229: aload_2
    //   230: invokevirtual 157	org/json/JSONException:printStackTrace	()V
    //   233: goto -100 -> 133
    //   236: aload_3
    //   237: invokevirtual 125	org/json/JSONObject:toString	()Ljava/lang/String;
    //   240: invokevirtual 131	java/lang/String:getBytes	()[B
    //   243: invokestatic 136	com/tencent/token/utils/l:b	([B)Ljava/lang/String;
    //   246: ifnonnull +6 -> 252
    //   249: goto -116 -> 133
    //   252: aload_2
    //   253: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	this	ProtoGetMbMobileCode
    //   46	7	1	i	int
    //   6	209	2	str	String
    //   224	1	2	localObject1	java.lang.Object
    //   228	25	2	localJSONException	org.json.JSONException
    //   29	208	3	localObject2	java.lang.Object
    //   152	33	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   30	118	224	finally
    //   229	233	224	finally
    //   30	118	228	org/json/JSONException
  }
  
  protected void a(do paramdo)
  {
    this.d = ((Long)paramdo.c.get("param.uinhash")).longValue();
    this.f = ((Integer)paramdo.c.get("param.mbmobile.getcode")).intValue();
    this.g = ((String)paramdo.c.get("param.mbmobile.mobile"));
    this.h = ((String)paramdo.c.get("param.mbmoible.areacode"));
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    int i = paramJSONObject.getInt("err");
    if (i != 0)
    {
      a(i, paramJSONObject.getString("info"));
      return;
    }
    paramJSONObject = l.c(paramJSONObject.getString("data"));
    if (paramJSONObject != null)
    {
      paramJSONObject = new JSONObject(new String(paramJSONObject));
      i = paramJSONObject.getInt("seq_id");
      if (this.c != i)
      {
        this.a.b(10030);
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("parseJSON error seq is wrong seq=");
        paramJSONObject.append(i);
        paramJSONObject.append(",right = ");
        paramJSONObject.append(this.c);
        g.c(paramJSONObject.toString());
        return;
      }
      this.e = paramJSONObject.getString("sms_prefix");
      this.a.c();
      return;
    }
    a(10022, RqdApplication.l().getString(2131493067));
  }
  
  protected void b()
  {
    if (!this.b.e)
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.obj = this.e;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoGetMbMobileCode
 * JD-Core Version:    0.7.0.1
 */