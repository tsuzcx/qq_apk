package com.tencent.token.core.protocolcenter.protocol;

import android.os.Handler;
import android.os.Message;
import com.tencent.token.core.protocolcenter.e;
import com.tencent.token.cv;
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.ev;
import com.tencent.token.global.c;
import com.tencent.token.global.f;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;
import java.util.HashMap;

public class ProtoKickOff
  extends e
{
  private long d;
  private String e;
  private String f;
  private int g;
  private int h;
  private String i;
  private String j;
  private int k;
  private int l;
  private String m;
  private String n;
  private int o;
  
  public static void a(ev paramev, long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, int paramInt3, int paramInt4, String paramString5, String paramString6)
  {
    paramev.c.put("param.uinhash", Long.valueOf(paramLong));
    paramev.c.put("param.device.lock.dguid", paramString1);
    paramev.c.put("param.device.lock.ddes", paramString2);
    paramev.c.put("param.device.lock.dappid", Integer.valueOf(paramInt1));
    paramev.c.put("param.device.lock.dsubappid", Integer.valueOf(paramInt2));
    paramev.c.put("param.device.lock.dappname", paramString3);
    paramev.c.put("param.device.lock.guid", paramString4);
    paramev.c.put("param.device.lock.appid", Integer.valueOf(paramInt3));
    paramev.c.put("param.device.lock.subappid", Integer.valueOf(paramInt4));
    paramev.c.put("param.device.lock.appname", paramString5);
    paramev.c.put("param.skey", paramString6);
  }
  
  protected String a()
  {
    String str1 = cv.a().b();
    if (str1 == null)
    {
      this.a.b(104);
      return null;
    }
    h.c("A2A2:" + this.n);
    int i1 = cw.a + 1;
    cw.a = i1;
    this.o = i1;
    String str2 = w.a(new Object[] { "seq_id", Integer.valueOf(this.o), "op_time", Long.valueOf(cx.c().s() / 1000L), "uin", Long.valueOf(this.d), "dguid", this.e, "ddes", this.f, "dappid", Integer.valueOf(this.g), "dappname", this.i, "guid", this.j, "appid", Integer.valueOf(this.k), "subappid", Integer.valueOf(this.l), "appname", this.m, "encryptedA2", w.b(this.n.getBytes()) });
    str1 = "?aq_base_sid=" + str1 + "&data=" + str2;
    return c.e() + "/cn/mbtoken3/mbtoken3_kickoff_v2" + str1;
  }
  
  protected void a(ev paramev)
  {
    this.d = ((Long)paramev.c.get("param.uinhash")).longValue();
    this.e = ((String)paramev.c.get("param.device.lock.dguid"));
    this.f = ((String)paramev.c.get("param.device.lock.ddes"));
    this.g = ((Integer)paramev.c.get("param.device.lock.dappid")).intValue();
    this.h = ((Integer)paramev.c.get("param.device.lock.dsubappid")).intValue();
    this.i = ((String)paramev.c.get("param.device.lock.dappname"));
    this.j = ((String)paramev.c.get("param.device.lock.guid"));
    this.k = ((Integer)paramev.c.get("param.device.lock.appid")).intValue();
    this.l = ((Integer)paramev.c.get("param.device.lock.subappid")).intValue();
    this.m = ((String)paramev.c.get("param.device.lock.appname"));
    this.n = ((String)paramev.c.get("param.skey"));
  }
  
  /* Error */
  protected void a(org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 209
    //   3: invokevirtual 215	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +15 -> 23
    //   11: aload_0
    //   12: iload_2
    //   13: aload_1
    //   14: ldc 217
    //   16: invokevirtual 221	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   19: invokevirtual 224	com/tencent/token/core/protocolcenter/protocol/ProtoKickOff:a	(ILjava/lang/String;)V
    //   22: return
    //   23: aload_1
    //   24: ldc 117
    //   26: invokevirtual 215	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   29: istore_2
    //   30: iload_2
    //   31: aload_0
    //   32: getfield 113	com/tencent/token/core/protocolcenter/protocol/ProtoKickOff:o	I
    //   35: if_icmpeq +50 -> 85
    //   38: aload_0
    //   39: getfield 83	com/tencent/token/core/protocolcenter/protocol/ProtoKickOff:a	Lcom/tencent/token/global/f;
    //   42: sipush 10030
    //   45: invokevirtual 88	com/tencent/token/global/f:b	(I)V
    //   48: new 90	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   55: ldc 226
    //   57: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: iload_2
    //   61: invokevirtual 229	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   64: ldc 231
    //   66: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokestatic 234	com/tencent/token/cw:a	()Lcom/tencent/token/cw;
    //   72: invokevirtual 236	com/tencent/token/cw:b	()I
    //   75: invokevirtual 229	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   78: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 107	com/tencent/token/global/h:c	(Ljava/lang/String;)V
    //   84: return
    //   85: invokestatic 241	com/tencent/token/ds:a	()Lcom/tencent/token/ds;
    //   88: getfield 244	com/tencent/token/ds:b	Lcom/tencent/token/core/bean/OnlineDeviceResult;
    //   91: ifnull +213 -> 304
    //   94: aload_0
    //   95: monitorenter
    //   96: invokestatic 241	com/tencent/token/ds:a	()Lcom/tencent/token/ds;
    //   99: getfield 244	com/tencent/token/ds:b	Lcom/tencent/token/core/bean/OnlineDeviceResult;
    //   102: getfield 250	com/tencent/token/core/bean/OnlineDeviceResult:mDevicesList	Ljava/util/ArrayList;
    //   105: astore_1
    //   106: aload_1
    //   107: ifnull +195 -> 302
    //   110: iconst_0
    //   111: istore_2
    //   112: iload_2
    //   113: aload_1
    //   114: invokevirtual 255	java/util/ArrayList:size	()I
    //   117: if_icmpge +185 -> 302
    //   120: aload_1
    //   121: iload_2
    //   122: invokevirtual 258	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   125: checkcast 260	com/tencent/token/core/bean/g
    //   128: astore_3
    //   129: new 90	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   136: ldc_w 262
    //   139: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload_3
    //   143: getfield 264	com/tencent/token/core/bean/g:e	I
    //   146: invokevirtual 229	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   149: ldc_w 266
    //   152: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload_0
    //   156: getfield 146	com/tencent/token/core/protocolcenter/protocol/ProtoKickOff:g	I
    //   159: invokevirtual 229	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   162: ldc_w 268
    //   165: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload_3
    //   169: getfield 270	com/tencent/token/core/bean/g:f	I
    //   172: invokevirtual 229	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   175: ldc_w 266
    //   178: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload_0
    //   182: getfield 206	com/tencent/token/core/protocolcenter/protocol/ProtoKickOff:h	I
    //   185: invokevirtual 229	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   188: ldc_w 272
    //   191: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload_3
    //   195: getfield 274	com/tencent/token/core/bean/g:g	Ljava/lang/String;
    //   198: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: ldc_w 266
    //   204: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload_0
    //   208: getfield 150	com/tencent/token/core/protocolcenter/protocol/ProtoKickOff:i	Ljava/lang/String;
    //   211: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: ldc_w 276
    //   217: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload_3
    //   221: getfield 278	com/tencent/token/core/bean/g:a	Ljava/lang/String;
    //   224: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: ldc_w 266
    //   230: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: aload_0
    //   234: getfield 138	com/tencent/token/core/protocolcenter/protocol/ProtoKickOff:e	Ljava/lang/String;
    //   237: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokestatic 280	com/tencent/token/global/h:a	(Ljava/lang/String;)V
    //   246: aload_3
    //   247: getfield 264	com/tencent/token/core/bean/g:e	I
    //   250: aload_0
    //   251: getfield 146	com/tencent/token/core/protocolcenter/protocol/ProtoKickOff:g	I
    //   254: if_icmpne +58 -> 312
    //   257: aload_3
    //   258: getfield 270	com/tencent/token/core/bean/g:f	I
    //   261: aload_0
    //   262: getfield 206	com/tencent/token/core/protocolcenter/protocol/ProtoKickOff:h	I
    //   265: if_icmpne +47 -> 312
    //   268: aload_3
    //   269: getfield 274	com/tencent/token/core/bean/g:g	Ljava/lang/String;
    //   272: aload_0
    //   273: getfield 150	com/tencent/token/core/protocolcenter/protocol/ProtoKickOff:i	Ljava/lang/String;
    //   276: invokevirtual 284	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   279: ifeq +33 -> 312
    //   282: aload_3
    //   283: getfield 278	com/tencent/token/core/bean/g:a	Ljava/lang/String;
    //   286: aload_0
    //   287: getfield 138	com/tencent/token/core/protocolcenter/protocol/ProtoKickOff:e	Ljava/lang/String;
    //   290: invokevirtual 284	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   293: ifeq +19 -> 312
    //   296: aload_1
    //   297: iload_2
    //   298: invokevirtual 287	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   301: pop
    //   302: aload_0
    //   303: monitorexit
    //   304: aload_0
    //   305: getfield 83	com/tencent/token/core/protocolcenter/protocol/ProtoKickOff:a	Lcom/tencent/token/global/f;
    //   308: invokevirtual 289	com/tencent/token/global/f:c	()V
    //   311: return
    //   312: iload_2
    //   313: iconst_1
    //   314: iadd
    //   315: istore_2
    //   316: goto -204 -> 112
    //   319: astore_1
    //   320: aload_0
    //   321: monitorexit
    //   322: aload_1
    //   323: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	324	0	this	ProtoKickOff
    //   0	324	1	paramJSONObject	org.json.JSONObject
    //   6	310	2	i1	int
    //   128	155	3	localg	com.tencent.token.core.bean.g
    // Exception table:
    //   from	to	target	type
    //   96	106	319	finally
    //   112	302	319	finally
    //   302	304	319	finally
    //   320	322	319	finally
  }
  
  protected void b()
  {
    if (!this.b.e)
    {
      Message localMessage = this.b.d.obtainMessage(this.b.f);
      localMessage.arg1 = 0;
      localMessage.sendToTarget();
      this.b.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.protocol.ProtoKickOff
 * JD-Core Version:    0.7.0.1
 */