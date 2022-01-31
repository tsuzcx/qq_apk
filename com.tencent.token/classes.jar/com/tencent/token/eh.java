package com.tencent.token;

import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import java.util.HashMap;

public final class eh
  extends bm
{
  private long c;
  private String d;
  private String e;
  private int f;
  private int g;
  private String h;
  private String i;
  private int j;
  private int k;
  private String l;
  private String m;
  
  protected final String a()
  {
    ae.a();
    if (ax.a().p()) {
      ax.a();
    }
    for (String str = ax.c; str == null; str = null)
    {
      this.a.a(104, null, null);
      return null;
    }
    str = "?uin=" + this.c + "&aq_base_sid=" + str + "&dguid=" + this.d + "&ddes=" + this.e + "&dappid=" + this.f + "&dsubappid=" + this.g + "&dappname=" + this.h + "&guid=" + this.i + "&appid=" + this.j + "&subappid=" + this.k + "&appname=" + this.l + "&encryptedA2=" + s.b(this.m.getBytes());
    e.c("A2A2:" + this.m);
    return b.c() + "/cn/mbtoken3/mbtoken3_kickoff" + str;
  }
  
  protected final void a(fs paramfs)
  {
    this.c = ((Long)paramfs.c.get("param.uinhash")).longValue();
    this.d = ((String)paramfs.c.get("param.device.lock.dguid"));
    this.e = ((String)paramfs.c.get("param.device.lock.ddes"));
    this.f = ((Integer)paramfs.c.get("param.device.lock.dappid")).intValue();
    this.g = ((Integer)paramfs.c.get("param.device.lock.dsubappid")).intValue();
    this.h = ((String)paramfs.c.get("param.device.lock.dappname"));
    this.i = ((String)paramfs.c.get("param.device.lock.guid"));
    this.j = ((Integer)paramfs.c.get("param.device.lock.appid")).intValue();
    this.k = ((Integer)paramfs.c.get("param.device.lock.subappid")).intValue();
    this.l = ((String)paramfs.c.get("param.device.lock.appname"));
    this.m = ((String)paramfs.c.get("param.skey"));
  }
  
  /* Error */
  protected final void a(org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 185
    //   3: invokevirtual 191	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +15 -> 23
    //   11: aload_0
    //   12: iload_2
    //   13: aload_1
    //   14: ldc 193
    //   16: invokevirtual 197	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   19: invokevirtual 200	com/tencent/token/eh:a	(ILjava/lang/String;)V
    //   22: return
    //   23: invokestatic 205	com/tencent/token/bb:a	()Lcom/tencent/token/bb;
    //   26: getfield 208	com/tencent/token/bb:b	Lcom/tencent/token/core/bean/OnlineDeviceResult;
    //   29: ifnull +205 -> 234
    //   32: aload_0
    //   33: monitorenter
    //   34: invokestatic 205	com/tencent/token/bb:a	()Lcom/tencent/token/bb;
    //   37: getfield 208	com/tencent/token/bb:b	Lcom/tencent/token/core/bean/OnlineDeviceResult;
    //   40: getfield 214	com/tencent/token/core/bean/OnlineDeviceResult:mDevicesList	Ljava/util/ArrayList;
    //   43: astore_1
    //   44: aload_1
    //   45: ifnull +187 -> 232
    //   48: iconst_0
    //   49: istore_2
    //   50: iload_2
    //   51: aload_1
    //   52: invokevirtual 219	java/util/ArrayList:size	()I
    //   55: if_icmpge +177 -> 232
    //   58: aload_1
    //   59: iload_2
    //   60: invokevirtual 222	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   63: checkcast 224	com/tencent/token/core/bean/f
    //   66: astore_3
    //   67: new 51	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   74: ldc 226
    //   76: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_3
    //   80: getfield 228	com/tencent/token/core/bean/f:e	I
    //   83: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   86: ldc 230
    //   88: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_0
    //   92: getfield 77	com/tencent/token/eh:f	I
    //   95: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   98: ldc 232
    //   100: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload_3
    //   104: getfield 233	com/tencent/token/core/bean/f:f	I
    //   107: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   110: ldc 230
    //   112: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload_0
    //   116: getfield 84	com/tencent/token/eh:g	I
    //   119: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   122: ldc 235
    //   124: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: aload_3
    //   128: getfield 237	com/tencent/token/core/bean/f:g	Ljava/lang/String;
    //   131: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: ldc 230
    //   136: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload_0
    //   140: getfield 88	com/tencent/token/eh:h	Ljava/lang/String;
    //   143: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: ldc 239
    //   148: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload_3
    //   152: getfield 241	com/tencent/token/core/bean/f:a	Ljava/lang/String;
    //   155: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: ldc 230
    //   160: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload_0
    //   164: getfield 69	com/tencent/token/eh:d	Ljava/lang/String;
    //   167: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 243	com/tencent/token/global/e:a	(Ljava/lang/String;)V
    //   176: aload_3
    //   177: getfield 228	com/tencent/token/core/bean/f:e	I
    //   180: aload_0
    //   181: getfield 77	com/tencent/token/eh:f	I
    //   184: if_icmpne +59 -> 243
    //   187: aload_3
    //   188: getfield 233	com/tencent/token/core/bean/f:f	I
    //   191: aload_0
    //   192: getfield 84	com/tencent/token/eh:g	I
    //   195: if_icmpne +48 -> 243
    //   198: aload_3
    //   199: getfield 237	com/tencent/token/core/bean/f:g	Ljava/lang/String;
    //   202: aload_0
    //   203: getfield 88	com/tencent/token/eh:h	Ljava/lang/String;
    //   206: invokevirtual 247	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   209: ifeq +34 -> 243
    //   212: aload_3
    //   213: getfield 241	com/tencent/token/core/bean/f:a	Ljava/lang/String;
    //   216: aload_0
    //   217: getfield 69	com/tencent/token/eh:d	Ljava/lang/String;
    //   220: invokevirtual 247	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   223: ifeq +20 -> 243
    //   226: aload_1
    //   227: iload_2
    //   228: invokevirtual 250	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   231: pop
    //   232: aload_0
    //   233: monitorexit
    //   234: aload_0
    //   235: getfield 44	com/tencent/token/eh:a	Lcom/tencent/token/global/d;
    //   238: iconst_0
    //   239: putfield 252	com/tencent/token/global/d:a	I
    //   242: return
    //   243: iload_2
    //   244: iconst_1
    //   245: iadd
    //   246: istore_2
    //   247: goto -197 -> 50
    //   250: astore_1
    //   251: aload_0
    //   252: monitorexit
    //   253: aload_1
    //   254: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	255	0	this	eh
    //   0	255	1	paramJSONObject	org.json.JSONObject
    //   6	241	2	n	int
    //   66	147	3	localf	com.tencent.token.core.bean.f
    // Exception table:
    //   from	to	target	type
    //   34	44	250	finally
    //   50	232	250	finally
    //   232	234	250	finally
  }
  
  protected final void b()
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
 * Qualified Name:     com.tencent.token.eh
 * JD-Core Version:    0.7.0.1
 */