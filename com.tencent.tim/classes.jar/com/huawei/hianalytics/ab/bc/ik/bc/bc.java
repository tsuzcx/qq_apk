package com.huawei.hianalytics.ab.bc.ik.bc;

import android.content.Context;
import org.json.JSONObject;

public class bc
  implements com.huawei.hianalytics.ab.bc.ik.cd.ab
{
  private Context ab = com.huawei.hianalytics.ab.ab.bc.ik();
  private String bc;
  private JSONObject cd;
  private String de;
  private String ef;
  private String fg;
  private String gh;
  private Boolean hi;
  
  public bc(String paramString1, JSONObject paramJSONObject, String paramString2, String paramString3, long paramLong)
  {
    this.bc = paramString1;
    this.cd = paramJSONObject;
    this.de = paramString2;
    this.ef = paramString3;
    this.fg = String.valueOf(paramLong);
    if (com.huawei.hianalytics.ab.ab.ab.ef(paramString2, "oper"))
    {
      paramString1 = com.huawei.hianalytics.ab.bc.hi.ab.ab().ab(paramString2, paramLong);
      this.gh = paramString1.ab();
      this.hi = Boolean.valueOf(paramString1.bc());
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 85
    //   2: ldc 87
    //   4: invokestatic 92	com/huawei/hianalytics/ab/bc/ef/ab:bc	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: invokestatic 95	com/huawei/hianalytics/ab/ab/bc:hi	()I
    //   10: istore_1
    //   11: aload_0
    //   12: getfield 37	com/huawei/hianalytics/ab/bc/ik/bc/bc:de	Ljava/lang/String;
    //   15: aload_0
    //   16: getfield 39	com/huawei/hianalytics/ab/bc/ik/bc/bc:ef	Ljava/lang/String;
    //   19: invokestatic 100	com/huawei/hianalytics/ab/ab/cd:hi	(Ljava/lang/String;Ljava/lang/String;)I
    //   22: istore_2
    //   23: aload_0
    //   24: getfield 31	com/huawei/hianalytics/ab/bc/ik/bc/bc:ab	Landroid/content/Context;
    //   27: ldc 102
    //   29: iload_1
    //   30: ldc 103
    //   32: imul
    //   33: invokestatic 108	com/huawei/hianalytics/ab/bc/kl/bc:ab	(Landroid/content/Context;Ljava/lang/String;I)Z
    //   36: ifeq +21 -> 57
    //   39: ldc 110
    //   41: ldc 112
    //   43: invokestatic 92	com/huawei/hianalytics/ab/bc/ef/ab:bc	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: invokestatic 117	com/huawei/hianalytics/ab/bc/ik/ab/ab:ab	()Lcom/huawei/hianalytics/ab/bc/ik/ab/ab;
    //   49: ldc 119
    //   51: ldc 121
    //   53: invokevirtual 123	com/huawei/hianalytics/ab/bc/ik/ab/ab:ab	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: return
    //   57: new 125	com/huawei/hianalytics/ab/bc/cd/bc/de
    //   60: dup
    //   61: invokespecial 126	com/huawei/hianalytics/ab/bc/cd/bc/de:<init>	()V
    //   64: astore 4
    //   66: aload 4
    //   68: aload_0
    //   69: getfield 33	com/huawei/hianalytics/ab/bc/ik/bc/bc:bc	Ljava/lang/String;
    //   72: invokevirtual 129	com/huawei/hianalytics/ab/bc/cd/bc/de:bc	(Ljava/lang/String;)V
    //   75: aload 4
    //   77: aload_0
    //   78: getfield 35	com/huawei/hianalytics/ab/bc/ik/bc/bc:cd	Lorg/json/JSONObject;
    //   81: invokevirtual 134	org/json/JSONObject:toString	()Ljava/lang/String;
    //   84: invokevirtual 136	com/huawei/hianalytics/ab/bc/cd/bc/de:cd	(Ljava/lang/String;)V
    //   87: aload 4
    //   89: aload_0
    //   90: getfield 39	com/huawei/hianalytics/ab/bc/ik/bc/bc:ef	Ljava/lang/String;
    //   93: invokevirtual 138	com/huawei/hianalytics/ab/bc/cd/bc/de:ab	(Ljava/lang/String;)V
    //   96: aload 4
    //   98: aload_0
    //   99: getfield 47	com/huawei/hianalytics/ab/bc/ik/bc/bc:fg	Ljava/lang/String;
    //   102: invokevirtual 140	com/huawei/hianalytics/ab/bc/cd/bc/de:de	(Ljava/lang/String;)V
    //   105: aload 4
    //   107: aload_0
    //   108: getfield 69	com/huawei/hianalytics/ab/bc/ik/bc/bc:gh	Ljava/lang/String;
    //   111: invokevirtual 142	com/huawei/hianalytics/ab/bc/cd/bc/de:ef	(Ljava/lang/String;)V
    //   114: aload_0
    //   115: getfield 79	com/huawei/hianalytics/ab/bc/ik/bc/bc:hi	Ljava/lang/Boolean;
    //   118: ifnonnull +106 -> 224
    //   121: aconst_null
    //   122: astore_3
    //   123: aload 4
    //   125: aload_3
    //   126: invokevirtual 144	com/huawei/hianalytics/ab/bc/cd/bc/de:fg	(Ljava/lang/String;)V
    //   129: aload 4
    //   131: invokevirtual 147	com/huawei/hianalytics/ab/bc/cd/bc/de:de	()Lorg/json/JSONObject;
    //   134: astore 4
    //   136: aload_0
    //   137: getfield 37	com/huawei/hianalytics/ab/bc/ik/bc/bc:de	Ljava/lang/String;
    //   140: aload_0
    //   141: getfield 39	com/huawei/hianalytics/ab/bc/ik/bc/bc:ef	Ljava/lang/String;
    //   144: invokestatic 152	com/huawei/hianalytics/ab/bc/kl/ef:ab	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   147: astore 5
    //   149: aload_0
    //   150: getfield 31	com/huawei/hianalytics/ab/bc/ik/bc/bc:ab	Landroid/content/Context;
    //   153: ldc 102
    //   155: aload 5
    //   157: ldc 119
    //   159: invokestatic 157	com/huawei/hianalytics/ab/bc/ij/ab:bc	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   162: astore_3
    //   163: new 159	org/json/JSONArray
    //   166: dup
    //   167: aload_3
    //   168: invokespecial 161	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   171: astore_3
    //   172: aload_3
    //   173: aload 4
    //   175: invokevirtual 165	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   178: pop
    //   179: aload_0
    //   180: getfield 31	com/huawei/hianalytics/ab/bc/ik/bc/bc:ab	Landroid/content/Context;
    //   183: ldc 102
    //   185: aload 5
    //   187: aload_3
    //   188: invokevirtual 166	org/json/JSONArray:toString	()Ljava/lang/String;
    //   191: invokestatic 169	com/huawei/hianalytics/ab/bc/ij/ab:ab	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   194: aload_3
    //   195: invokevirtual 166	org/json/JSONArray:toString	()Ljava/lang/String;
    //   198: invokevirtual 172	java/lang/String:length	()I
    //   201: iload_2
    //   202: sipush 1024
    //   205: imul
    //   206: if_icmple -150 -> 56
    //   209: invokestatic 117	com/huawei/hianalytics/ab/bc/ik/ab/ab:ab	()Lcom/huawei/hianalytics/ab/bc/ik/ab/ab;
    //   212: aload_0
    //   213: getfield 37	com/huawei/hianalytics/ab/bc/ik/bc/bc:de	Ljava/lang/String;
    //   216: aload_0
    //   217: getfield 39	com/huawei/hianalytics/ab/bc/ik/bc/bc:ef	Ljava/lang/String;
    //   220: invokevirtual 123	com/huawei/hianalytics/ab/bc/ik/ab/ab:ab	(Ljava/lang/String;Ljava/lang/String;)V
    //   223: return
    //   224: aload_0
    //   225: getfield 79	com/huawei/hianalytics/ab/bc/ik/bc/bc:hi	Ljava/lang/Boolean;
    //   228: invokestatic 175	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   231: astore_3
    //   232: goto -109 -> 123
    //   235: astore_3
    //   236: ldc 85
    //   238: ldc 177
    //   240: invokestatic 179	com/huawei/hianalytics/ab/bc/ef/ab:cd	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: return
    //   244: astore_3
    //   245: ldc 85
    //   247: ldc 181
    //   249: invokestatic 92	com/huawei/hianalytics/ab/bc/ef/ab:bc	(Ljava/lang/String;Ljava/lang/String;)V
    //   252: new 159	org/json/JSONArray
    //   255: dup
    //   256: invokespecial 182	org/json/JSONArray:<init>	()V
    //   259: astore_3
    //   260: goto -88 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	this	bc
    //   10	23	1	i	int
    //   22	184	2	j	int
    //   122	110	3	localObject1	Object
    //   235	1	3	localJSONException1	org.json.JSONException
    //   244	1	3	localJSONException2	org.json.JSONException
    //   259	1	3	localJSONArray	org.json.JSONArray
    //   64	110	4	localObject2	Object
    //   147	39	5	str	String
    // Exception table:
    //   from	to	target	type
    //   129	136	235	org/json/JSONException
    //   163	172	244	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.ab.bc.ik.bc.bc
 * JD-Core Version:    0.7.0.1
 */