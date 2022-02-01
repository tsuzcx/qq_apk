package com.tencent.token.core.protocolcenter.protocol;

import android.content.Context;
import com.tencent.token.core.protocolcenter.d;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import java.util.HashMap;
import org.json.JSONObject;

public class ProtoVryMbMobileCode
  extends d
{
  private long d;
  private String e;
  
  public static void a(do paramdo, long paramLong, String paramString)
  {
    paramdo.c.put("param.uinhash", Long.valueOf(paramLong));
    paramdo.c.put("param.mbmobile.vrycode", paramString);
  }
  
  /* Error */
  protected String a()
  {
    // Byte code:
    //   0: invokestatic 45	com/tencent/token/ca:a	()Lcom/tencent/token/ca;
    //   3: invokevirtual 48	com/tencent/token/ca:b	()Ljava/lang/String;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +14 -> 22
    //   11: aload_0
    //   12: getfield 51	com/tencent/token/core/protocolcenter/protocol/ProtoVryMbMobileCode:a	Lcom/tencent/token/global/e;
    //   15: bipush 104
    //   17: invokevirtual 56	com/tencent/token/global/e:b	(I)V
    //   20: aconst_null
    //   21: areturn
    //   22: new 58	org/json/JSONObject
    //   25: dup
    //   26: invokespecial 59	org/json/JSONObject:<init>	()V
    //   29: astore_3
    //   30: aload_3
    //   31: ldc 61
    //   33: aload_0
    //   34: getfield 63	com/tencent/token/core/protocolcenter/protocol/ProtoVryMbMobileCode:d	J
    //   37: invokevirtual 66	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   40: pop
    //   41: getstatic 71	com/tencent/token/cb:a	I
    //   44: iconst_1
    //   45: iadd
    //   46: istore_1
    //   47: iload_1
    //   48: putstatic 71	com/tencent/token/cb:a	I
    //   51: aload_0
    //   52: iload_1
    //   53: putfield 73	com/tencent/token/core/protocolcenter/protocol/ProtoVryMbMobileCode:c	I
    //   56: aload_3
    //   57: ldc 75
    //   59: aload_0
    //   60: getfield 73	com/tencent/token/core/protocolcenter/protocol/ProtoVryMbMobileCode:c	I
    //   63: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   66: pop
    //   67: aload_3
    //   68: ldc 80
    //   70: invokestatic 85	com/tencent/token/cc:c	()Lcom/tencent/token/cc;
    //   73: invokevirtual 89	com/tencent/token/cc:s	()J
    //   76: ldc2_w 90
    //   79: ldiv
    //   80: l2i
    //   81: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   84: pop
    //   85: aload_3
    //   86: ldc 93
    //   88: aload_0
    //   89: getfield 95	com/tencent/token/core/protocolcenter/protocol/ProtoVryMbMobileCode:e	Ljava/lang/String;
    //   92: invokevirtual 98	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   95: pop
    //   96: aload_3
    //   97: invokevirtual 101	org/json/JSONObject:toString	()Ljava/lang/String;
    //   100: invokevirtual 107	java/lang/String:getBytes	()[B
    //   103: invokestatic 112	com/tencent/token/utils/l:b	([B)Ljava/lang/String;
    //   106: astore_3
    //   107: aload_3
    //   108: ifnonnull +15 -> 123
    //   111: aload_0
    //   112: getfield 51	com/tencent/token/core/protocolcenter/protocol/ProtoVryMbMobileCode:a	Lcom/tencent/token/global/e;
    //   115: sipush 10000
    //   118: invokevirtual 56	com/tencent/token/global/e:b	(I)V
    //   121: aconst_null
    //   122: areturn
    //   123: new 114	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   130: astore 4
    //   132: aload 4
    //   134: ldc 117
    //   136: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload 4
    //   142: aload_2
    //   143: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload 4
    //   149: ldc 123
    //   151: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload 4
    //   157: aload_3
    //   158: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload 4
    //   164: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: astore_2
    //   168: new 114	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   175: astore_3
    //   176: aload_3
    //   177: invokestatic 128	com/tencent/token/global/c:e	()Ljava/lang/String;
    //   180: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload_3
    //   185: ldc 130
    //   187: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload_3
    //   192: aload_2
    //   193: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload_3
    //   198: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: areturn
    //   202: astore_2
    //   203: goto +11 -> 214
    //   206: astore_2
    //   207: aload_2
    //   208: invokevirtual 133	org/json/JSONException:printStackTrace	()V
    //   211: goto -100 -> 111
    //   214: aload_3
    //   215: invokevirtual 101	org/json/JSONObject:toString	()Ljava/lang/String;
    //   218: invokevirtual 107	java/lang/String:getBytes	()[B
    //   221: invokestatic 112	com/tencent/token/utils/l:b	([B)Ljava/lang/String;
    //   224: ifnonnull +6 -> 230
    //   227: goto -116 -> 111
    //   230: aload_2
    //   231: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	this	ProtoVryMbMobileCode
    //   46	7	1	i	int
    //   6	187	2	str	String
    //   202	1	2	localObject1	java.lang.Object
    //   206	25	2	localJSONException	org.json.JSONException
    //   29	186	3	localObject2	java.lang.Object
    //   130	33	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   30	96	202	finally
    //   207	211	202	finally
    //   30	96	206	org/json/JSONException
  }
  
  protected void a(do paramdo)
  {
    this.d = ((Long)paramdo.c.get("param.uinhash")).longValue();
    this.e = ((String)paramdo.c.get("param.mbmobile.vrycode"));
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
      i = new JSONObject(new String(paramJSONObject)).getInt("seq_id");
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
      this.a.c();
      return;
    }
    a(10022, RqdApplication.l().getString(2131493067));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoVryMbMobileCode
 * JD-Core Version:    0.7.0.1
 */