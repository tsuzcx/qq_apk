import android.util.SparseArray;

public class apme
{
  public boolean bUc;
  private SparseArray<apmd> dE = new SparseArray();
  
  public apme()
  {
    init();
  }
  
  /* Error */
  public static apme a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 32	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 15	android/util/SparseArray
    //   12: dup
    //   13: invokespecial 16	android/util/SparseArray:<init>	()V
    //   16: astore 7
    //   18: new 34	org/json/JSONObject
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 37	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   26: astore 6
    //   28: aload 6
    //   30: ldc 39
    //   32: iconst_0
    //   33: invokevirtual 43	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   36: istore_1
    //   37: aload 6
    //   39: ldc 45
    //   41: invokevirtual 49	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   44: astore 6
    //   46: iload_1
    //   47: istore_3
    //   48: aload 6
    //   50: ifnull +123 -> 173
    //   53: iload_1
    //   54: istore_3
    //   55: aload 6
    //   57: invokevirtual 55	org/json/JSONArray:length	()I
    //   60: ifle +113 -> 173
    //   63: iconst_0
    //   64: istore_2
    //   65: iload_1
    //   66: istore_3
    //   67: iload_2
    //   68: aload 6
    //   70: invokevirtual 55	org/json/JSONArray:length	()I
    //   73: if_icmpge +100 -> 173
    //   76: aload 6
    //   78: iload_2
    //   79: invokevirtual 59	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   82: astore 8
    //   84: aload 8
    //   86: ldc 61
    //   88: invokevirtual 64	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   91: istore_3
    //   92: aload 8
    //   94: ldc 66
    //   96: invokevirtual 70	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   99: astore 9
    //   101: aload 8
    //   103: ldc 72
    //   105: invokevirtual 75	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   108: astore 10
    //   110: aload 8
    //   112: ldc 77
    //   114: invokevirtual 80	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   117: istore 4
    //   119: aload 9
    //   121: invokestatic 32	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   124: ifne +31 -> 155
    //   127: aload 10
    //   129: invokestatic 32	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   132: ifne +23 -> 155
    //   135: aload 7
    //   137: iload_3
    //   138: new 82	apmd
    //   141: dup
    //   142: iload_3
    //   143: aload 10
    //   145: aload 9
    //   147: iload 4
    //   149: invokespecial 85	apmd:<init>	(ILjava/lang/String;Ljava/lang/String;I)V
    //   152: invokevirtual 89	android/util/SparseArray:append	(ILjava/lang/Object;)V
    //   155: iload_2
    //   156: iconst_1
    //   157: iadd
    //   158: istore_2
    //   159: goto -94 -> 65
    //   162: astore 6
    //   164: iconst_0
    //   165: istore_1
    //   166: aload 6
    //   168: invokevirtual 92	org/json/JSONException:printStackTrace	()V
    //   171: iload_1
    //   172: istore_3
    //   173: aload 7
    //   175: invokevirtual 95	android/util/SparseArray:size	()I
    //   178: ifle +84 -> 262
    //   181: new 2	apme
    //   184: dup
    //   185: invokespecial 96	apme:<init>	()V
    //   188: astore 6
    //   190: aload 6
    //   192: aload 7
    //   194: putfield 18	apme:dE	Landroid/util/SparseArray;
    //   197: iload_3
    //   198: iconst_1
    //   199: if_icmpne +57 -> 256
    //   202: iconst_1
    //   203: istore 5
    //   205: aload 6
    //   207: iload 5
    //   209: putfield 98	apme:bUc	Z
    //   212: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   215: ifeq +38 -> 253
    //   218: ldc 106
    //   220: iconst_2
    //   221: new 108	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   228: ldc 111
    //   230: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: aload_0
    //   234: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: ldc 116
    //   239: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload 6
    //   244: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   247: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: aload 6
    //   255: areturn
    //   256: iconst_0
    //   257: istore 5
    //   259: goto -54 -> 205
    //   262: ldc 106
    //   264: iconst_1
    //   265: ldc 129
    //   267: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   270: aconst_null
    //   271: astore 6
    //   273: goto -61 -> 212
    //   276: astore 6
    //   278: goto -112 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	281	0	paramString	String
    //   36	136	1	i	int
    //   64	95	2	j	int
    //   47	153	3	k	int
    //   117	31	4	m	int
    //   203	55	5	bool	boolean
    //   26	51	6	localObject	Object
    //   162	5	6	localJSONException1	org.json.JSONException
    //   188	84	6	localapme	apme
    //   276	1	6	localJSONException2	org.json.JSONException
    //   16	177	7	localSparseArray	SparseArray
    //   82	29	8	localJSONObject	org.json.JSONObject
    //   99	47	9	str1	String
    //   108	36	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   18	37	162	org/json/JSONException
    //   37	46	276	org/json/JSONException
    //   55	63	276	org/json/JSONException
    //   67	155	276	org/json/JSONException
  }
  
  private void init()
  {
    apmd localapmd1 = new apmd(1, "龙王", "https://qzonestyle.gtimg.cn/aoi/sola/20200213150116_n4PxCiurbm.png", 1);
    apmd localapmd2 = new apmd(2, "群聊之火", "https://qzonestyle.gtimg.cn/aoi/sola/20200213150231_zLczuKN4tp.png", 2);
    apmd localapmd3 = new apmd(3, "群聊炽焰", "https://qzonestyle.gtimg.cn/aoi/sola/20200213150305_AJiyOgHCDg.png", 3);
    apmd localapmd4 = new apmd(4, "冒尖小春笋", "https://qzonestyle.gtimg.cn/aoi/sola/20200213150335_tUJCAtoKVP.png", 4);
    apmd localapmd5 = new apmd(5, "茁壮小春笋", "https://qzonestyle.gtimg.cn/aoi/sola/20200213150408_nw0sOEFzqw.png", 5);
    apmd localapmd6 = new apmd(6, "快乐源泉", "https://qzonestyle.gtimg.cn/aoi/sola/20200213150434_3tDmsJExCP.png", 6);
    a(localapmd1);
    a(localapmd2);
    a(localapmd3);
    a(localapmd4);
    a(localapmd5);
    a(localapmd6);
  }
  
  public apmd a(int paramInt)
  {
    if (this.dE != null) {
      return (apmd)this.dE.get(paramInt);
    }
    return null;
  }
  
  public void a(apmd paramapmd)
  {
    if (this.dE != null) {
      this.dE.put(paramapmd.id, paramapmd);
    }
  }
  
  public String toString()
  {
    return "TroopHonorConfig{mHonorMap=" + this.dE + ", isSupport=" + this.bUc + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apme
 * JD-Core Version:    0.7.0.1
 */