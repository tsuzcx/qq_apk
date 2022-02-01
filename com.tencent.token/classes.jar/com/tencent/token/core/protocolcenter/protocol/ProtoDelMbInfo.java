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

public class ProtoDelMbInfo
  extends d
{
  private long d;
  private int e;
  
  public static void a(do paramdo, long paramLong, int paramInt)
  {
    paramdo.c.put("param.uinhash", Long.valueOf(paramLong));
    paramdo.c.put("param.mbinfo.id", Integer.valueOf(paramInt));
  }
  
  /* Error */
  protected String a()
  {
    // Byte code:
    //   0: invokestatic 50	com/tencent/token/ca:a	()Lcom/tencent/token/ca;
    //   3: invokevirtual 53	com/tencent/token/ca:b	()Ljava/lang/String;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +14 -> 22
    //   11: aload_0
    //   12: getfield 56	com/tencent/token/core/protocolcenter/protocol/ProtoDelMbInfo:a	Lcom/tencent/token/global/e;
    //   15: bipush 104
    //   17: invokevirtual 61	com/tencent/token/global/e:b	(I)V
    //   20: aconst_null
    //   21: areturn
    //   22: new 63	org/json/JSONObject
    //   25: dup
    //   26: invokespecial 64	org/json/JSONObject:<init>	()V
    //   29: astore_3
    //   30: aload_3
    //   31: ldc 66
    //   33: aload_0
    //   34: getfield 68	com/tencent/token/core/protocolcenter/protocol/ProtoDelMbInfo:d	J
    //   37: invokevirtual 71	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   40: pop
    //   41: aload_3
    //   42: ldc 73
    //   44: aload_0
    //   45: getfield 75	com/tencent/token/core/protocolcenter/protocol/ProtoDelMbInfo:e	I
    //   48: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   51: pop
    //   52: getstatic 82	com/tencent/token/cb:a	I
    //   55: iconst_1
    //   56: iadd
    //   57: istore_1
    //   58: iload_1
    //   59: putstatic 82	com/tencent/token/cb:a	I
    //   62: aload_0
    //   63: iload_1
    //   64: putfield 84	com/tencent/token/core/protocolcenter/protocol/ProtoDelMbInfo:c	I
    //   67: aload_3
    //   68: ldc 86
    //   70: aload_0
    //   71: getfield 84	com/tencent/token/core/protocolcenter/protocol/ProtoDelMbInfo:c	I
    //   74: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   77: pop
    //   78: aload_3
    //   79: ldc 88
    //   81: invokestatic 93	com/tencent/token/cc:c	()Lcom/tencent/token/cc;
    //   84: invokevirtual 97	com/tencent/token/cc:s	()J
    //   87: ldc2_w 98
    //   90: ldiv
    //   91: l2i
    //   92: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   95: pop
    //   96: aload_3
    //   97: invokevirtual 102	org/json/JSONObject:toString	()Ljava/lang/String;
    //   100: invokevirtual 108	java/lang/String:getBytes	()[B
    //   103: invokestatic 113	com/tencent/token/utils/l:b	([B)Ljava/lang/String;
    //   106: astore_3
    //   107: aload_3
    //   108: ifnonnull +15 -> 123
    //   111: aload_0
    //   112: getfield 56	com/tencent/token/core/protocolcenter/protocol/ProtoDelMbInfo:a	Lcom/tencent/token/global/e;
    //   115: sipush 10000
    //   118: invokevirtual 61	com/tencent/token/global/e:b	(I)V
    //   121: aconst_null
    //   122: areturn
    //   123: new 115	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   130: astore 4
    //   132: aload 4
    //   134: ldc 118
    //   136: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload 4
    //   142: aload_2
    //   143: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload 4
    //   149: ldc 124
    //   151: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload 4
    //   157: aload_3
    //   158: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload 4
    //   164: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: astore_2
    //   168: new 115	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   175: astore_3
    //   176: aload_3
    //   177: invokestatic 129	com/tencent/token/global/c:e	()Ljava/lang/String;
    //   180: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload_3
    //   185: ldc 131
    //   187: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload_3
    //   192: aload_2
    //   193: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload_3
    //   198: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: areturn
    //   202: astore_2
    //   203: goto +11 -> 214
    //   206: astore_2
    //   207: aload_2
    //   208: invokevirtual 134	org/json/JSONException:printStackTrace	()V
    //   211: goto -100 -> 111
    //   214: aload_3
    //   215: invokevirtual 102	org/json/JSONObject:toString	()Ljava/lang/String;
    //   218: invokevirtual 108	java/lang/String:getBytes	()[B
    //   221: invokestatic 113	com/tencent/token/utils/l:b	([B)Ljava/lang/String;
    //   224: ifnonnull +6 -> 230
    //   227: goto -116 -> 111
    //   230: aload_2
    //   231: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	this	ProtoDelMbInfo
    //   57	7	1	i	int
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
    this.e = ((Integer)paramdo.c.get("param.mbinfo.id")).intValue();
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
        return;
      }
      this.a.c();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("parseJSON error decodeData=");
    localStringBuilder.append(paramJSONObject);
    g.c(localStringBuilder.toString());
    a(10022, RqdApplication.l().getString(2131493067));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoDelMbInfo
 * JD-Core Version:    0.7.0.1
 */