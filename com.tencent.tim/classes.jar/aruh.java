import android.content.Intent;
import java.util.HashSet;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class aruh
  extends MSFServlet
{
  private static final String[] is = { "ConnAuthSvr.get_auth_api_list", "ConnAuthSvr.get_auth_api_list_emp", "ConnAuthSvr.sdk_auth_api", "ConnAuthSvr.sdk_auth_api_emp" };
  private HashSet<String> bK = new HashSet();
  
  /* Error */
  public void onReceive(Intent paramIntent, com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_2
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: new 38	android/os/Bundle
    //   11: dup
    //   12: invokespecial 39	android/os/Bundle:<init>	()V
    //   15: astore 7
    //   17: aload_2
    //   18: invokevirtual 45	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   21: astore 10
    //   23: aload 10
    //   25: ifnull +408 -> 433
    //   28: aload 10
    //   30: arraylength
    //   31: iconst_4
    //   32: if_icmple +401 -> 433
    //   35: new 47	java/io/ByteArrayInputStream
    //   38: dup
    //   39: aload 10
    //   41: invokespecial 50	java/io/ByteArrayInputStream:<init>	([B)V
    //   44: astore 8
    //   46: new 52	java/io/DataInputStream
    //   49: dup
    //   50: aload 8
    //   52: invokespecial 55	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   55: astore 9
    //   57: aload 9
    //   59: invokevirtual 59	java/io/DataInputStream:readInt	()I
    //   62: iconst_4
    //   63: isub
    //   64: istore_3
    //   65: iload_3
    //   66: newarray byte
    //   68: astore 11
    //   70: aload 10
    //   72: iconst_4
    //   73: aload 11
    //   75: iconst_0
    //   76: iload_3
    //   77: invokestatic 65	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   80: aload 7
    //   82: ldc 67
    //   84: aload 11
    //   86: invokevirtual 71	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   89: aload 7
    //   91: ldc 73
    //   93: aload_2
    //   94: invokevirtual 76	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   97: invokevirtual 80	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   100: aload 7
    //   102: ldc 82
    //   104: aload_2
    //   105: invokevirtual 86	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
    //   108: invokevirtual 90	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: aload 8
    //   113: invokevirtual 93	java/io/ByteArrayInputStream:close	()V
    //   116: aload 9
    //   118: invokevirtual 94	java/io/DataInputStream:close	()V
    //   121: aload_2
    //   122: invokevirtual 97	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   125: astore 8
    //   127: getstatic 23	aruh:is	[Ljava/lang/String;
    //   130: astore 9
    //   132: aload 9
    //   134: arraylength
    //   135: istore 6
    //   137: iconst_0
    //   138: istore_3
    //   139: iload 5
    //   141: istore 4
    //   143: iload_3
    //   144: iload 6
    //   146: if_icmpge +18 -> 164
    //   149: aload 9
    //   151: iload_3
    //   152: aaload
    //   153: aload 8
    //   155: invokevirtual 101	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   158: ifeq +306 -> 464
    //   161: iconst_1
    //   162: istore 4
    //   164: iload 4
    //   166: ifeq +316 -> 482
    //   169: aload_1
    //   170: ldc 103
    //   172: invokevirtual 108	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   175: invokevirtual 114	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   178: checkcast 103	com/tencent/qphone/base/remote/ToServiceMsg
    //   181: astore 8
    //   183: new 116	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   190: aload_2
    //   191: invokevirtual 86	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
    //   194: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: ldc 123
    //   199: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload_2
    //   203: invokevirtual 97	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   206: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: ldc 123
    //   211: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload 8
    //   216: ldc 125
    //   218: invokevirtual 129	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   221: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: astore 8
    //   229: aload_0
    //   230: getfield 32	aruh:bK	Ljava/util/HashSet;
    //   233: aload 8
    //   235: invokevirtual 138	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   238: ifeq +44 -> 282
    //   241: aload_0
    //   242: getfield 32	aruh:bK	Ljava/util/HashSet;
    //   245: aload 8
    //   247: invokevirtual 141	java/util/HashSet:remove	(Ljava/lang/Object;)Z
    //   250: pop
    //   251: aload_2
    //   252: ldc 143
    //   254: invokevirtual 144	com/tencent/qphone/base/remote/FromServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   257: ifnonnull +214 -> 471
    //   260: aload 7
    //   262: ldc 146
    //   264: iconst_0
    //   265: invokevirtual 150	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   268: aload_0
    //   269: aload_1
    //   270: iconst_0
    //   271: aload_2
    //   272: invokevirtual 154	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   275: aload 7
    //   277: ldc 156
    //   279: invokevirtual 160	aruh:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   282: invokestatic 165	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   285: ifeq -278 -> 7
    //   288: ldc 167
    //   290: iconst_2
    //   291: new 116	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   298: ldc 169
    //   300: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: aload 8
    //   305: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: ldc 171
    //   310: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: aload_2
    //   314: invokevirtual 174	com/tencent/qphone/base/remote/FromServiceMsg:getAppId	()I
    //   317: invokevirtual 177	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   320: ldc 179
    //   322: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: aload_2
    //   326: invokevirtual 182	com/tencent/qphone/base/remote/FromServiceMsg:getAppSeq	()I
    //   329: invokevirtual 177	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   332: ldc 184
    //   334: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: aload_2
    //   338: invokevirtual 76	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   341: invokevirtual 177	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   344: ldc 186
    //   346: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: aload_2
    //   350: invokevirtual 97	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   353: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: ldc 188
    //   358: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: aload_2
    //   362: invokevirtual 86	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
    //   365: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: ldc 190
    //   370: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: aload_2
    //   374: ldc 143
    //   376: invokevirtual 144	com/tencent/qphone/base/remote/FromServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   379: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   382: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   385: invokestatic 194	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   388: return
    //   389: astore_1
    //   390: ldc 167
    //   392: iconst_1
    //   393: ldc 196
    //   395: aload_1
    //   396: invokestatic 200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   399: return
    //   400: astore 10
    //   402: aload 8
    //   404: invokevirtual 93	java/io/ByteArrayInputStream:close	()V
    //   407: aload 9
    //   409: invokevirtual 94	java/io/DataInputStream:close	()V
    //   412: goto -291 -> 121
    //   415: astore 8
    //   417: goto -296 -> 121
    //   420: astore_1
    //   421: aload 8
    //   423: invokevirtual 93	java/io/ByteArrayInputStream:close	()V
    //   426: aload 9
    //   428: invokevirtual 94	java/io/DataInputStream:close	()V
    //   431: aload_1
    //   432: athrow
    //   433: sipush 1002
    //   436: aload_2
    //   437: invokevirtual 76	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   440: if_icmpne -319 -> 121
    //   443: ldc 167
    //   445: iconst_1
    //   446: ldc 202
    //   448: invokestatic 205	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   451: aload 7
    //   453: ldc 73
    //   455: sipush 1002
    //   458: invokevirtual 80	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   461: goto -340 -> 121
    //   464: iload_3
    //   465: iconst_1
    //   466: iadd
    //   467: istore_3
    //   468: goto -329 -> 139
    //   471: aload 7
    //   473: ldc 146
    //   475: iconst_1
    //   476: invokevirtual 150	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   479: goto -211 -> 268
    //   482: aload_0
    //   483: aload_1
    //   484: iconst_0
    //   485: aload_2
    //   486: invokevirtual 154	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   489: aload 7
    //   491: ldc 156
    //   493: invokevirtual 160	aruh:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   496: return
    //   497: astore_2
    //   498: goto -67 -> 431
    //   501: astore 8
    //   503: goto -382 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	506	0	this	aruh
    //   0	506	1	paramIntent	Intent
    //   0	506	2	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   64	404	3	i	int
    //   141	24	4	j	int
    //   1	139	5	k	int
    //   135	12	6	m	int
    //   15	475	7	localBundle	android.os.Bundle
    //   44	359	8	localObject1	java.lang.Object
    //   415	7	8	localException1	java.lang.Exception
    //   501	1	8	localException2	java.lang.Exception
    //   55	372	9	localObject2	java.lang.Object
    //   21	50	10	arrayOfByte1	byte[]
    //   400	1	10	localException3	java.lang.Exception
    //   68	17	11	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   121	137	389	java/lang/Exception
    //   149	161	389	java/lang/Exception
    //   169	268	389	java/lang/Exception
    //   268	282	389	java/lang/Exception
    //   282	388	389	java/lang/Exception
    //   471	479	389	java/lang/Exception
    //   482	496	389	java/lang/Exception
    //   57	111	400	java/lang/Exception
    //   402	412	415	java/lang/Exception
    //   57	111	420	finally
    //   421	431	497	java/lang/Exception
    //   111	121	501	java/lang/Exception
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket) {}
  
  /* Error */
  public void service(Intent paramIntent)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial 211	mqq/app/MSFServlet:service	(Landroid/content/Intent;)V
    //   7: aload_1
    //   8: ldc 213
    //   10: invokevirtual 217	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   13: astore 7
    //   15: aload_1
    //   16: ldc 219
    //   18: invokevirtual 217	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   21: astore 8
    //   23: new 103	com/tencent/qphone/base/remote/ToServiceMsg
    //   26: dup
    //   27: aconst_null
    //   28: aload 8
    //   30: aload 7
    //   32: invokespecial 222	com/tencent/qphone/base/remote/ToServiceMsg:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   35: astore 6
    //   37: aload_1
    //   38: ldc 67
    //   40: invokevirtual 226	android/content/Intent:getByteArrayExtra	(Ljava/lang/String;)[B
    //   43: astore 11
    //   45: new 228	java/io/ByteArrayOutputStream
    //   48: dup
    //   49: aload 11
    //   51: arraylength
    //   52: iconst_4
    //   53: iadd
    //   54: invokespecial 231	java/io/ByteArrayOutputStream:<init>	(I)V
    //   57: astore 9
    //   59: new 233	java/io/DataOutputStream
    //   62: dup
    //   63: aload 9
    //   65: invokespecial 236	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   68: astore 10
    //   70: aload 10
    //   72: aload 11
    //   74: arraylength
    //   75: iconst_4
    //   76: iadd
    //   77: invokevirtual 239	java/io/DataOutputStream:writeInt	(I)V
    //   80: aload 10
    //   82: aload 11
    //   84: invokevirtual 242	java/io/DataOutputStream:write	([B)V
    //   87: aload 6
    //   89: aload 9
    //   91: invokevirtual 245	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   94: invokevirtual 248	com/tencent/qphone/base/remote/ToServiceMsg:putWupBuffer	([B)V
    //   97: aload 9
    //   99: invokevirtual 249	java/io/ByteArrayOutputStream:close	()V
    //   102: aload 10
    //   104: invokevirtual 250	java/io/DataOutputStream:close	()V
    //   107: aload 6
    //   109: aload_1
    //   110: ldc 252
    //   112: ldc2_w 253
    //   115: invokevirtual 258	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   118: invokevirtual 262	com/tencent/qphone/base/remote/ToServiceMsg:setTimeout	(J)V
    //   121: aload 6
    //   123: ldc_w 264
    //   126: ldc_w 266
    //   129: invokevirtual 270	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   132: pop
    //   133: aload_1
    //   134: ldc_w 272
    //   137: iconst_0
    //   138: invokevirtual 276	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   141: ifeq +9 -> 150
    //   144: aload 6
    //   146: iconst_1
    //   147: invokevirtual 280	com/tencent/qphone/base/remote/ToServiceMsg:setIsSupportRetry	(Z)V
    //   150: getstatic 23	aruh:is	[Ljava/lang/String;
    //   153: astore 9
    //   155: aload 9
    //   157: arraylength
    //   158: istore_3
    //   159: iload_2
    //   160: iload_3
    //   161: if_icmpge +120 -> 281
    //   164: aload 9
    //   166: iload_2
    //   167: aaload
    //   168: aload 7
    //   170: invokevirtual 101	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   173: ifeq +161 -> 334
    //   176: aload 6
    //   178: iconst_1
    //   179: iconst_1
    //   180: invokevirtual 284	com/tencent/qphone/base/remote/ToServiceMsg:setQuickSend	(ZI)V
    //   183: invokestatic 288	java/lang/System:currentTimeMillis	()J
    //   186: lstore 4
    //   188: aload 6
    //   190: ldc 125
    //   192: lload 4
    //   194: invokestatic 294	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   197: invokevirtual 270	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   200: pop
    //   201: new 116	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   208: aload 8
    //   210: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: ldc 123
    //   215: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload 7
    //   220: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: ldc 123
    //   225: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: lload 4
    //   230: invokevirtual 297	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   233: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: astore 7
    //   238: invokestatic 165	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   241: ifeq +30 -> 271
    //   244: ldc 167
    //   246: iconst_2
    //   247: new 116	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   254: ldc_w 299
    //   257: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: aload 7
    //   262: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: invokestatic 205	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   271: aload_0
    //   272: getfield 32	aruh:bK	Ljava/util/HashSet;
    //   275: aload 7
    //   277: invokevirtual 302	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   280: pop
    //   281: aload_1
    //   282: ldc 103
    //   284: invokevirtual 108	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   287: aload 6
    //   289: invokevirtual 306	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   292: pop
    //   293: aload_0
    //   294: aload_1
    //   295: aload 6
    //   297: invokevirtual 310	aruh:sendToMSF	(Landroid/content/Intent;Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
    //   300: return
    //   301: astore 11
    //   303: aload 9
    //   305: invokevirtual 249	java/io/ByteArrayOutputStream:close	()V
    //   308: aload 10
    //   310: invokevirtual 250	java/io/DataOutputStream:close	()V
    //   313: goto -206 -> 107
    //   316: astore 9
    //   318: goto -211 -> 107
    //   321: astore_1
    //   322: aload 9
    //   324: invokevirtual 249	java/io/ByteArrayOutputStream:close	()V
    //   327: aload 10
    //   329: invokevirtual 250	java/io/DataOutputStream:close	()V
    //   332: aload_1
    //   333: athrow
    //   334: iload_2
    //   335: iconst_1
    //   336: iadd
    //   337: istore_2
    //   338: goto -179 -> 159
    //   341: astore 6
    //   343: goto -11 -> 332
    //   346: astore 9
    //   348: goto -241 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	this	aruh
    //   0	351	1	paramIntent	Intent
    //   1	337	2	i	int
    //   158	4	3	j	int
    //   186	43	4	l	long
    //   35	261	6	localToServiceMsg	com.tencent.qphone.base.remote.ToServiceMsg
    //   341	1	6	localException1	java.lang.Exception
    //   13	263	7	str1	String
    //   21	188	8	str2	String
    //   57	247	9	localObject	java.lang.Object
    //   316	7	9	localException2	java.lang.Exception
    //   346	1	9	localException3	java.lang.Exception
    //   68	260	10	localDataOutputStream	java.io.DataOutputStream
    //   43	40	11	arrayOfByte	byte[]
    //   301	1	11	localException4	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   70	97	301	java/lang/Exception
    //   303	313	316	java/lang/Exception
    //   70	97	321	finally
    //   322	332	341	java/lang/Exception
    //   97	107	346	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aruh
 * JD-Core Version:    0.7.0.1
 */