package com.tencent.mobileqq.activity;

class Leba$36
  implements Runnable
{
  Leba$36(Leba paramLeba) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_1
    //   3: istore 4
    //   5: invokestatic 25	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   8: invokevirtual 29	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   11: bipush 36
    //   13: invokevirtual 35	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   16: checkcast 37	altq
    //   19: astore 5
    //   21: new 39	java/util/ArrayList
    //   24: dup
    //   25: invokespecial 40	java/util/ArrayList:<init>	()V
    //   28: astore 6
    //   30: aload 5
    //   32: ldc 42
    //   34: invokevirtual 46	altq:getAppInfoByPath	(Ljava/lang/String;)Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   37: astore 7
    //   39: aload 7
    //   41: ifnonnull +4 -> 45
    //   44: return
    //   45: aload 5
    //   47: aconst_null
    //   48: iconst_1
    //   49: invokevirtual 50	altq:a	(Laltq$b;Z)I
    //   52: istore_1
    //   53: aload 7
    //   55: getfield 56	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:iNewFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   58: invokevirtual 62	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   61: istore_3
    //   62: iload_3
    //   63: iconst_1
    //   64: if_icmpne +225 -> 289
    //   67: aload 7
    //   69: getfield 66	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   72: invokevirtual 71	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   75: astore 5
    //   77: aload 5
    //   79: invokestatic 77	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   82: ifne +103 -> 185
    //   85: ldc 79
    //   87: iconst_1
    //   88: new 81	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   95: ldc 84
    //   97: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload 5
    //   102: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: new 99	org/json/JSONObject
    //   114: dup
    //   115: aload 5
    //   117: invokespecial 102	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   120: astore 5
    //   122: aload 5
    //   124: ldc 104
    //   126: invokevirtual 108	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   129: astore 7
    //   131: aload 5
    //   133: ldc 110
    //   135: invokevirtual 114	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   138: aload 7
    //   140: invokevirtual 114	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   143: ldc 116
    //   145: invokevirtual 120	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   148: astore 5
    //   150: aload 5
    //   152: invokevirtual 125	org/json/JSONArray:length	()I
    //   155: istore_3
    //   156: iload_2
    //   157: iload_3
    //   158: if_icmpge +35 -> 193
    //   161: aload 6
    //   163: aload 5
    //   165: iload_2
    //   166: invokevirtual 128	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   169: checkcast 130	java/lang/String
    //   172: invokeinterface 136 2 0
    //   177: pop
    //   178: iload_2
    //   179: iconst_1
    //   180: iadd
    //   181: istore_2
    //   182: goto -26 -> 156
    //   185: ldc 79
    //   187: iconst_1
    //   188: ldc 138
    //   190: invokestatic 141	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   196: ifeq +28 -> 224
    //   199: ldc 147
    //   201: iconst_2
    //   202: new 81	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   209: ldc 149
    //   211: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: iload_1
    //   215: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   218: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   224: aload_0
    //   225: getfield 12	com/tencent/mobileqq/activity/Leba$36:this$0	Lcom/tencent/mobileqq/activity/Leba;
    //   228: iload_1
    //   229: iload 4
    //   231: aload 6
    //   233: invokestatic 157	com/tencent/mobileqq/activity/Leba:a	(Lcom/tencent/mobileqq/activity/Leba;IZLjava/util/List;)V
    //   236: return
    //   237: astore 5
    //   239: iconst_0
    //   240: istore_1
    //   241: iconst_0
    //   242: istore 4
    //   244: ldc 79
    //   246: iconst_2
    //   247: new 81	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   254: ldc 159
    //   256: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: aload 5
    //   261: invokevirtual 160	java/lang/Exception:toString	()Ljava/lang/String;
    //   264: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 163	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   273: goto -80 -> 193
    //   276: astore 5
    //   278: iconst_0
    //   279: istore 4
    //   281: goto -37 -> 244
    //   284: astore 5
    //   286: goto -42 -> 244
    //   289: iconst_0
    //   290: istore 4
    //   292: goto -225 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	295	0	this	36
    //   52	189	1	i	int
    //   1	181	2	j	int
    //   61	98	3	k	int
    //   3	288	4	bool	boolean
    //   19	145	5	localObject1	Object
    //   237	23	5	localException1	java.lang.Exception
    //   276	1	5	localException2	java.lang.Exception
    //   284	1	5	localException3	java.lang.Exception
    //   28	204	6	localArrayList	java.util.ArrayList
    //   37	102	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   30	39	237	java/lang/Exception
    //   45	53	237	java/lang/Exception
    //   53	62	276	java/lang/Exception
    //   67	156	284	java/lang/Exception
    //   161	178	284	java/lang/Exception
    //   185	193	284	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.36
 * JD-Core Version:    0.7.0.1
 */