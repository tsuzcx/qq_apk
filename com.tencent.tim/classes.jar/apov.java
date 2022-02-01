import java.util.ArrayList;

public class apov
{
  public static boolean bUc;
  public static boolean cRS;
  public ArrayList<Integer> Cf = new ArrayList();
  public ArrayList<Integer> Cg = new ArrayList();
  
  public apov()
  {
    bUc = false;
  }
  
  /* Error */
  public static apov a(java.lang.String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 7
    //   3: aload_0
    //   4: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +5 -> 12
    //   10: aconst_null
    //   11: areturn
    //   12: new 17	java/util/ArrayList
    //   15: dup
    //   16: invokespecial 18	java/util/ArrayList:<init>	()V
    //   19: astore 8
    //   21: new 37	org/json/JSONObject
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 40	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   29: astore_0
    //   30: aload_0
    //   31: ldc 42
    //   33: iconst_0
    //   34: invokevirtual 46	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   37: istore_2
    //   38: aload_0
    //   39: ldc 48
    //   41: iconst_0
    //   42: invokevirtual 46	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   45: istore_1
    //   46: aload_0
    //   47: ldc 50
    //   49: invokevirtual 54	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   52: astore 9
    //   54: aload 9
    //   56: ifnull +44 -> 100
    //   59: aload 9
    //   61: invokevirtual 60	org/json/JSONArray:length	()I
    //   64: ifle +36 -> 100
    //   67: iconst_0
    //   68: istore_3
    //   69: iload_3
    //   70: aload 9
    //   72: invokevirtual 60	org/json/JSONArray:length	()I
    //   75: if_icmpge +25 -> 100
    //   78: aload 8
    //   80: aload 9
    //   82: iload_3
    //   83: invokevirtual 64	org/json/JSONArray:getInt	(I)I
    //   86: invokestatic 70	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   89: invokevirtual 74	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   92: pop
    //   93: iload_3
    //   94: iconst_1
    //   95: iadd
    //   96: istore_3
    //   97: goto -28 -> 69
    //   100: aload_0
    //   101: ldc 76
    //   103: invokevirtual 54	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   106: astore_0
    //   107: iload_1
    //   108: istore 5
    //   110: iload_2
    //   111: istore_3
    //   112: aload_0
    //   113: ifnull +70 -> 183
    //   116: iload_1
    //   117: istore 5
    //   119: iload_2
    //   120: istore_3
    //   121: aload_0
    //   122: invokevirtual 60	org/json/JSONArray:length	()I
    //   125: ifle +58 -> 183
    //   128: iconst_0
    //   129: istore 4
    //   131: iload_1
    //   132: istore 5
    //   134: iload_2
    //   135: istore_3
    //   136: iload 4
    //   138: aload_0
    //   139: invokevirtual 60	org/json/JSONArray:length	()I
    //   142: if_icmpge +41 -> 183
    //   145: aload 8
    //   147: aload_0
    //   148: iload 4
    //   150: invokevirtual 64	org/json/JSONArray:getInt	(I)I
    //   153: invokestatic 70	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   156: invokevirtual 74	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   159: pop
    //   160: iload 4
    //   162: iconst_1
    //   163: iadd
    //   164: istore 4
    //   166: goto -35 -> 131
    //   169: astore_0
    //   170: iconst_0
    //   171: istore_2
    //   172: iconst_0
    //   173: istore_1
    //   174: aload_0
    //   175: invokevirtual 79	org/json/JSONException:printStackTrace	()V
    //   178: iload_2
    //   179: istore_3
    //   180: iload_1
    //   181: istore 5
    //   183: new 2	apov
    //   186: dup
    //   187: invokespecial 80	apov:<init>	()V
    //   190: astore_0
    //   191: aload_0
    //   192: ifnull +37 -> 229
    //   195: iload_3
    //   196: iconst_1
    //   197: if_icmpne +34 -> 231
    //   200: iconst_1
    //   201: istore 6
    //   203: iload 6
    //   205: putstatic 24	apov:bUc	Z
    //   208: iload 5
    //   210: iconst_1
    //   211: if_icmpne +26 -> 237
    //   214: iload 7
    //   216: istore 6
    //   218: iload 6
    //   220: putstatic 82	apov:cRS	Z
    //   223: aload_0
    //   224: aload 8
    //   226: putfield 20	apov:Cf	Ljava/util/ArrayList;
    //   229: aload_0
    //   230: areturn
    //   231: iconst_0
    //   232: istore 6
    //   234: goto -31 -> 203
    //   237: iconst_0
    //   238: istore 6
    //   240: goto -22 -> 218
    //   243: astore_0
    //   244: iconst_0
    //   245: istore_1
    //   246: goto -72 -> 174
    //   249: astore_0
    //   250: goto -76 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	paramString	java.lang.String
    //   45	201	1	i	int
    //   37	142	2	j	int
    //   68	130	3	k	int
    //   129	36	4	m	int
    //   108	104	5	n	int
    //   201	38	6	bool1	boolean
    //   1	214	7	bool2	boolean
    //   19	206	8	localArrayList	ArrayList
    //   52	29	9	localJSONArray	org.json.JSONArray
    // Exception table:
    //   from	to	target	type
    //   21	38	169	org/json/JSONException
    //   38	46	243	org/json/JSONException
    //   46	54	249	org/json/JSONException
    //   59	67	249	org/json/JSONException
    //   69	93	249	org/json/JSONException
    //   100	107	249	org/json/JSONException
    //   121	128	249	org/json/JSONException
    //   136	160	249	org/json/JSONException
  }
  
  public boolean md(int paramInt)
  {
    return (true == bUc) || (this.Cf.contains(Integer.valueOf(paramInt)));
  }
  
  public boolean me(int paramInt)
  {
    return (true == cRS) || (this.Cg.contains(Integer.valueOf(paramInt)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apov
 * JD-Core Version:    0.7.0.1
 */