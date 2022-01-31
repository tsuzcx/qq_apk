package com.tencent.mobileqq.app.soso;

import java.util.ArrayList;

public class SosoInterface$SosoLbsInfo
{
  public long a;
  public SosoInterface.SosoAttribute a;
  public SosoInterface.SosoLocation a;
  public String a;
  public final ArrayList a;
  public String b;
  public final ArrayList b;
  
  public SosoInterface$SosoLbsInfo()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  /* Error */
  public static SosoLbsInfo a(String paramString)
  {
    // Byte code:
    //   0: new 30	org/json/JSONObject
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 33	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8: astore 9
    //   10: new 2	com/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo
    //   13: dup
    //   14: invokespecial 34	com/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo:<init>	()V
    //   17: astore_0
    //   18: aload 9
    //   20: ldc 36
    //   22: invokevirtual 40	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   25: astore 10
    //   27: aload_0
    //   28: new 42	com/tencent/mobileqq/app/soso/SosoInterface$SosoLocation
    //   31: dup
    //   32: aload 10
    //   34: ldc 44
    //   36: invokevirtual 48	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   39: aload 10
    //   41: ldc 50
    //   43: invokevirtual 48	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   46: invokespecial 53	com/tencent/mobileqq/app/soso/SosoInterface$SosoLocation:<init>	(DD)V
    //   49: putfield 55	com/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo:jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation	Lcom/tencent/mobileqq/app/soso/SosoInterface$SosoLocation;
    //   52: aload 9
    //   54: ldc 57
    //   56: invokevirtual 40	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   59: astore 10
    //   61: aload_0
    //   62: new 59	com/tencent/mobileqq/app/soso/SosoInterface$SosoAttribute
    //   65: dup
    //   66: aload 10
    //   68: ldc 61
    //   70: invokevirtual 65	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   73: aload 10
    //   75: ldc 67
    //   77: invokevirtual 65	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   80: aload 10
    //   82: ldc 69
    //   84: invokevirtual 65	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   87: aload 10
    //   89: ldc 71
    //   91: invokevirtual 65	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   94: invokespecial 74	com/tencent/mobileqq/app/soso/SosoInterface$SosoAttribute:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   97: putfield 76	com/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo:jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute	Lcom/tencent/mobileqq/app/soso/SosoInterface$SosoAttribute;
    //   100: aload 9
    //   102: ldc 78
    //   104: invokevirtual 82	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   107: astore 10
    //   109: aload 10
    //   111: invokevirtual 88	org/json/JSONArray:length	()I
    //   114: istore_2
    //   115: iconst_0
    //   116: istore_1
    //   117: iload_1
    //   118: iload_2
    //   119: if_icmpge +141 -> 260
    //   122: aload 10
    //   124: iload_1
    //   125: invokevirtual 91	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   128: astore 11
    //   130: aload 11
    //   132: ldc 93
    //   134: invokevirtual 97	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   137: istore_3
    //   138: aload 11
    //   140: ldc 99
    //   142: invokevirtual 97	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   145: istore 4
    //   147: aload 11
    //   149: ldc 101
    //   151: invokevirtual 97	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   154: istore 5
    //   156: aload 11
    //   158: ldc 103
    //   160: invokevirtual 97	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   163: istore 6
    //   165: aload 11
    //   167: ldc 105
    //   169: invokevirtual 97	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   172: istore 7
    //   174: aload_0
    //   175: getfield 20	com/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   178: astore 11
    //   180: iload_1
    //   181: ifne +198 -> 379
    //   184: iconst_1
    //   185: istore 8
    //   187: aload 11
    //   189: new 107	com/tencent/mobileqq/app/soso/SosoInterface$SosoCell
    //   192: dup
    //   193: iload_3
    //   194: iload 4
    //   196: iload 5
    //   198: iload 6
    //   200: iload 7
    //   202: iload 8
    //   204: invokespecial 110	com/tencent/mobileqq/app/soso/SosoInterface$SosoCell:<init>	(IIIIIZ)V
    //   207: invokevirtual 114	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   210: pop
    //   211: iload_1
    //   212: iconst_1
    //   213: iadd
    //   214: istore_1
    //   215: goto -98 -> 117
    //   218: astore 10
    //   220: aload_0
    //   221: new 42	com/tencent/mobileqq/app/soso/SosoInterface$SosoLocation
    //   224: dup
    //   225: dconst_0
    //   226: dconst_0
    //   227: invokespecial 53	com/tencent/mobileqq/app/soso/SosoInterface$SosoLocation:<init>	(DD)V
    //   230: putfield 55	com/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo:jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation	Lcom/tencent/mobileqq/app/soso/SosoInterface$SosoLocation;
    //   233: goto -181 -> 52
    //   236: astore 10
    //   238: aload_0
    //   239: new 59	com/tencent/mobileqq/app/soso/SosoInterface$SosoAttribute
    //   242: dup
    //   243: ldc 116
    //   245: ldc 116
    //   247: ldc 116
    //   249: ldc 116
    //   251: invokespecial 74	com/tencent/mobileqq/app/soso/SosoInterface$SosoAttribute:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   254: putfield 76	com/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo:jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute	Lcom/tencent/mobileqq/app/soso/SosoInterface$SosoAttribute;
    //   257: goto -157 -> 100
    //   260: aload 9
    //   262: ldc 118
    //   264: invokevirtual 82	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   267: astore 10
    //   269: aload 10
    //   271: invokevirtual 88	org/json/JSONArray:length	()I
    //   274: istore_2
    //   275: iconst_0
    //   276: istore_1
    //   277: iload_1
    //   278: iload_2
    //   279: if_icmpge +53 -> 332
    //   282: aload 10
    //   284: iload_1
    //   285: invokevirtual 91	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   288: astore 11
    //   290: aload 11
    //   292: ldc 120
    //   294: invokevirtual 65	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   297: astore 12
    //   299: aload 11
    //   301: ldc 122
    //   303: invokevirtual 97	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   306: istore_3
    //   307: aload_0
    //   308: getfield 22	com/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   311: new 124	com/tencent/mobileqq/app/soso/SosoInterface$SosoWifi
    //   314: dup
    //   315: aload 12
    //   317: iload_3
    //   318: invokespecial 127	com/tencent/mobileqq/app/soso/SosoInterface$SosoWifi:<init>	(Ljava/lang/String;I)V
    //   321: invokevirtual 114	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   324: pop
    //   325: iload_1
    //   326: iconst_1
    //   327: iadd
    //   328: istore_1
    //   329: goto -52 -> 277
    //   332: aload_0
    //   333: aload 9
    //   335: ldc 129
    //   337: invokevirtual 65	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   340: putfield 131	com/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   343: aload_0
    //   344: aload 9
    //   346: ldc 133
    //   348: invokevirtual 65	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   351: putfield 135	com/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   354: aload_0
    //   355: aload 9
    //   357: ldc 137
    //   359: invokevirtual 141	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   362: putfield 143	com/tencent/mobileqq/app/soso/SosoInterface$SosoLbsInfo:jdField_a_of_type_Long	J
    //   365: aload_0
    //   366: areturn
    //   367: astore_0
    //   368: aconst_null
    //   369: areturn
    //   370: astore 9
    //   372: goto -7 -> 365
    //   375: astore 9
    //   377: aload_0
    //   378: areturn
    //   379: iconst_0
    //   380: istore 8
    //   382: goto -195 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	385	0	paramString	String
    //   116	213	1	i	int
    //   114	166	2	j	int
    //   137	181	3	k	int
    //   145	50	4	m	int
    //   154	43	5	n	int
    //   163	36	6	i1	int
    //   172	29	7	i2	int
    //   185	196	8	bool	boolean
    //   8	348	9	localJSONObject	org.json.JSONObject
    //   370	1	9	localJSONException1	org.json.JSONException
    //   375	1	9	localException	java.lang.Exception
    //   25	98	10	localObject1	Object
    //   218	1	10	localJSONException2	org.json.JSONException
    //   236	1	10	localJSONException3	org.json.JSONException
    //   267	16	10	localJSONArray	org.json.JSONArray
    //   128	172	11	localObject2	Object
    //   297	19	12	str	String
    // Exception table:
    //   from	to	target	type
    //   18	52	218	org/json/JSONException
    //   52	100	236	org/json/JSONException
    //   0	18	367	java/lang/Exception
    //   332	365	370	org/json/JSONException
    //   18	52	375	java/lang/Exception
    //   52	100	375	java/lang/Exception
    //   100	115	375	java/lang/Exception
    //   122	180	375	java/lang/Exception
    //   187	211	375	java/lang/Exception
    //   220	233	375	java/lang/Exception
    //   238	257	375	java/lang/Exception
    //   260	275	375	java/lang/Exception
    //   282	325	375	java/lang/Exception
    //   332	365	375	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo
 * JD-Core Version:    0.7.0.1
 */