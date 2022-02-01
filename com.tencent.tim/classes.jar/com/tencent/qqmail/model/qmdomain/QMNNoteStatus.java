package com.tencent.qqmail.model.qmdomain;

import com.alibaba.fastjson.JSONObject;

public class QMNNoteStatus
  extends QMDomain
{
  private static final String TAG = "QMNNoteStatus";
  private static final long serialVersionUID = 1L;
  public double createUTC;
  public double sequence;
  public boolean starred;
  public int status;
  public double updateUTC;
  
  /* Error */
  public boolean parseWithDictionary(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 11
    //   3: iconst_0
    //   4: istore 12
    //   6: iconst_0
    //   7: istore 10
    //   9: iload 12
    //   11: istore 8
    //   13: aload_1
    //   14: ldc 31
    //   16: invokevirtual 37	com/alibaba/fastjson/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   19: astore 14
    //   21: iload 10
    //   23: istore 9
    //   25: iload 12
    //   27: istore 8
    //   29: aload 14
    //   31: invokestatic 43	org/apache/commons/lang3/StringUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   34: ifne +45 -> 79
    //   37: iload 12
    //   39: istore 8
    //   41: aload 14
    //   43: invokestatic 49	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   46: invokevirtual 53	java/lang/Double:doubleValue	()D
    //   49: dstore_2
    //   50: iload 12
    //   52: istore 8
    //   54: aload_0
    //   55: getfield 55	com/tencent/qqmail/model/qmdomain/QMNNoteStatus:createUTC	D
    //   58: dstore 4
    //   60: iload 10
    //   62: istore 9
    //   64: dload_2
    //   65: dload 4
    //   67: dcmpl
    //   68: ifeq +11 -> 79
    //   71: aload_0
    //   72: dload_2
    //   73: putfield 55	com/tencent/qqmail/model/qmdomain/QMNNoteStatus:createUTC	D
    //   76: iconst_1
    //   77: istore 9
    //   79: iload 9
    //   81: istore 8
    //   83: aload_1
    //   84: ldc 57
    //   86: invokevirtual 37	com/alibaba/fastjson/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   89: astore 14
    //   91: iload 9
    //   93: istore 10
    //   95: iload 9
    //   97: istore 8
    //   99: aload 14
    //   101: invokestatic 43	org/apache/commons/lang3/StringUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   104: ifne +45 -> 149
    //   107: iload 9
    //   109: istore 8
    //   111: aload 14
    //   113: invokestatic 49	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   116: invokevirtual 53	java/lang/Double:doubleValue	()D
    //   119: dstore_2
    //   120: iload 9
    //   122: istore 8
    //   124: aload_0
    //   125: getfield 59	com/tencent/qqmail/model/qmdomain/QMNNoteStatus:updateUTC	D
    //   128: dstore 4
    //   130: iload 9
    //   132: istore 10
    //   134: dload_2
    //   135: dload 4
    //   137: dcmpl
    //   138: ifeq +11 -> 149
    //   141: aload_0
    //   142: dload_2
    //   143: putfield 59	com/tencent/qqmail/model/qmdomain/QMNNoteStatus:updateUTC	D
    //   146: iconst_1
    //   147: istore 10
    //   149: iload 10
    //   151: istore 8
    //   153: aload_1
    //   154: ldc 60
    //   156: invokevirtual 37	com/alibaba/fastjson/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   159: astore 14
    //   161: iload 10
    //   163: istore 9
    //   165: iload 10
    //   167: istore 8
    //   169: aload 14
    //   171: invokestatic 43	org/apache/commons/lang3/StringUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   174: ifne +45 -> 219
    //   177: iload 10
    //   179: istore 8
    //   181: aload 14
    //   183: invokestatic 49	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   186: invokevirtual 53	java/lang/Double:doubleValue	()D
    //   189: dstore_2
    //   190: iload 10
    //   192: istore 8
    //   194: aload_0
    //   195: getfield 62	com/tencent/qqmail/model/qmdomain/QMNNoteStatus:sequence	D
    //   198: dstore 4
    //   200: iload 10
    //   202: istore 9
    //   204: dload_2
    //   205: dload 4
    //   207: dcmpl
    //   208: ifeq +11 -> 219
    //   211: aload_0
    //   212: dload_2
    //   213: putfield 62	com/tencent/qqmail/model/qmdomain/QMNNoteStatus:sequence	D
    //   216: iconst_1
    //   217: istore 9
    //   219: iload 9
    //   221: istore 8
    //   223: aload_1
    //   224: ldc 64
    //   226: invokevirtual 68	com/alibaba/fastjson/JSONObject:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   229: invokestatic 72	com/tencent/qqmail/model/qmdomain/QMNNoteStatus:getBoolean	(Ljava/lang/Object;)Ljava/lang/Boolean;
    //   232: astore 14
    //   234: iload 9
    //   236: istore 10
    //   238: aload 14
    //   240: ifnull +47 -> 287
    //   243: iload 9
    //   245: istore 8
    //   247: aload 14
    //   249: invokevirtual 78	java/lang/Boolean:booleanValue	()Z
    //   252: istore 12
    //   254: iload 9
    //   256: istore 8
    //   258: aload_0
    //   259: getfield 80	com/tencent/qqmail/model/qmdomain/QMNNoteStatus:starred	Z
    //   262: istore 13
    //   264: iload 9
    //   266: istore 10
    //   268: iload 12
    //   270: iload 13
    //   272: if_icmpeq +15 -> 287
    //   275: aload_0
    //   276: aload 14
    //   278: invokevirtual 78	java/lang/Boolean:booleanValue	()Z
    //   281: putfield 80	com/tencent/qqmail/model/qmdomain/QMNNoteStatus:starred	Z
    //   284: iconst_1
    //   285: istore 10
    //   287: iload 10
    //   289: istore 8
    //   291: aload_1
    //   292: ldc 82
    //   294: invokevirtual 37	com/alibaba/fastjson/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   297: astore_1
    //   298: aload_1
    //   299: ifnull +61 -> 360
    //   302: iload 10
    //   304: istore 8
    //   306: aload_1
    //   307: invokestatic 88	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   310: istore 6
    //   312: iload 10
    //   314: istore 8
    //   316: aload_0
    //   317: getfield 90	com/tencent/qqmail/model/qmdomain/QMNNoteStatus:status	I
    //   320: istore 7
    //   322: iload 7
    //   324: iload 6
    //   326: if_icmpeq +34 -> 360
    //   329: aload_0
    //   330: iload 6
    //   332: putfield 90	com/tencent/qqmail/model/qmdomain/QMNNoteStatus:status	I
    //   335: iconst_1
    //   336: ireturn
    //   337: astore_1
    //   338: bipush 6
    //   340: ldc 8
    //   342: aload_1
    //   343: invokevirtual 94	java/lang/NumberFormatException:toString	()Ljava/lang/String;
    //   346: invokestatic 100	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   349: iload 8
    //   351: ireturn
    //   352: astore_1
    //   353: iload 11
    //   355: istore 8
    //   357: goto -19 -> 338
    //   360: iload 10
    //   362: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	363	0	this	QMNNoteStatus
    //   0	363	1	paramJSONObject	JSONObject
    //   49	164	2	d1	double
    //   58	148	4	d2	double
    //   310	21	6	i	int
    //   320	7	7	j	int
    //   11	345	8	bool1	boolean
    //   23	242	9	bool2	boolean
    //   7	354	10	bool3	boolean
    //   1	353	11	bool4	boolean
    //   4	269	12	bool5	boolean
    //   262	11	13	bool6	boolean
    //   19	258	14	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   13	21	337	java/lang/NumberFormatException
    //   29	37	337	java/lang/NumberFormatException
    //   41	50	337	java/lang/NumberFormatException
    //   54	60	337	java/lang/NumberFormatException
    //   83	91	337	java/lang/NumberFormatException
    //   99	107	337	java/lang/NumberFormatException
    //   111	120	337	java/lang/NumberFormatException
    //   124	130	337	java/lang/NumberFormatException
    //   153	161	337	java/lang/NumberFormatException
    //   169	177	337	java/lang/NumberFormatException
    //   181	190	337	java/lang/NumberFormatException
    //   194	200	337	java/lang/NumberFormatException
    //   223	234	337	java/lang/NumberFormatException
    //   247	254	337	java/lang/NumberFormatException
    //   258	264	337	java/lang/NumberFormatException
    //   291	298	337	java/lang/NumberFormatException
    //   306	312	337	java/lang/NumberFormatException
    //   316	322	337	java/lang/NumberFormatException
    //   71	76	352	java/lang/NumberFormatException
    //   141	146	352	java/lang/NumberFormatException
    //   211	216	352	java/lang/NumberFormatException
    //   275	284	352	java/lang/NumberFormatException
    //   329	335	352	java/lang/NumberFormatException
  }
  
  public String toString()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("class", "QMNNoteStatus");
    localJSONObject.put("crt", Double.valueOf(this.createUTC));
    localJSONObject.put("sequence", Double.valueOf(this.sequence));
    if (this.starred) {}
    for (String str = "1";; str = "0")
    {
      localJSONObject.put("star", str);
      localJSONObject.put("st", Integer.valueOf(this.status));
      return localJSONObject.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.qmdomain.QMNNoteStatus
 * JD-Core Version:    0.7.0.1
 */