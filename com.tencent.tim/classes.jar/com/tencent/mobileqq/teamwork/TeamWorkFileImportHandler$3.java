package com.tencent.mobileqq.teamwork;

import aoar;
import org.json.JSONObject;

public class TeamWorkFileImportHandler$3
  implements Runnable
{
  public TeamWorkFileImportHandler$3(aoar paramaoar, JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, int paramInt) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 18	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:this$0	Laoar;
    //   4: getfield 39	aoar:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7: ifnonnull +4 -> 11
    //   10: return
    //   11: invokestatic 45	java/lang/System:currentTimeMillis	()J
    //   14: lstore_3
    //   15: aload_0
    //   16: getfield 20	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:bI	Lorg/json/JSONObject;
    //   19: ifnull +24 -> 43
    //   22: aload_0
    //   23: getfield 22	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:b	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   26: invokevirtual 51	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:azs	()Z
    //   29: ifeq +14 -> 43
    //   32: aload_0
    //   33: getfield 20	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:bI	Lorg/json/JSONObject;
    //   36: ldc 53
    //   38: iconst_1
    //   39: invokevirtual 59	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   42: pop
    //   43: aload_0
    //   44: getfield 20	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:bI	Lorg/json/JSONObject;
    //   47: aload_0
    //   48: getfield 18	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:this$0	Laoar;
    //   51: getfield 39	aoar:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   54: invokevirtual 65	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   57: invokestatic 71	aobk:a	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   60: astore 10
    //   62: invokestatic 45	java/lang/System:currentTimeMillis	()J
    //   65: lstore 5
    //   67: aload_0
    //   68: getfield 22	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:b	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   71: getfield 74	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:dNT	I
    //   74: aload_0
    //   75: getfield 24	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:dNO	I
    //   78: if_icmpeq +32 -> 110
    //   81: ldc 76
    //   83: iconst_2
    //   84: new 78	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   91: ldc 81
    //   93: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload_0
    //   97: getfield 24	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:dNO	I
    //   100: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   103: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 97	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: return
    //   110: ldc 99
    //   112: astore 9
    //   114: aload 10
    //   116: ifnull +283 -> 399
    //   119: aload_0
    //   120: getfield 18	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:this$0	Laoar;
    //   123: aload 10
    //   125: aload_0
    //   126: getfield 22	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:b	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   129: invokestatic 102	aoar:a	(Laoar;Ljava/lang/String;Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;)Z
    //   132: istore 7
    //   134: new 55	org/json/JSONObject
    //   137: dup
    //   138: aload 10
    //   140: invokespecial 105	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   143: ldc 107
    //   145: invokevirtual 111	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   148: astore 8
    //   150: aload 8
    //   152: astore 9
    //   154: ldc 112
    //   156: invokestatic 118	acfp:m	(I)Ljava/lang/String;
    //   159: astore 8
    //   161: aload_0
    //   162: getfield 22	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:b	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   165: getfield 121	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:nFileType	I
    //   168: iconst_3
    //   169: if_icmpne +252 -> 421
    //   172: ldc 123
    //   174: astore 8
    //   176: lload 5
    //   178: lload_3
    //   179: lsub
    //   180: lstore_3
    //   181: aload_0
    //   182: getfield 18	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:this$0	Laoar;
    //   185: getfield 39	aoar:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   188: astore 11
    //   190: aload_0
    //   191: getfield 22	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:b	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   194: getfield 126	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:dNQ	I
    //   197: istore_2
    //   198: iload 7
    //   200: ifeq +278 -> 478
    //   203: iconst_1
    //   204: istore_1
    //   205: aload 11
    //   207: ldc 128
    //   209: ldc 99
    //   211: ldc 99
    //   213: ldc 130
    //   215: ldc 130
    //   217: iload_2
    //   218: iload_1
    //   219: new 78	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   226: lload_3
    //   227: invokevirtual 133	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   230: ldc 99
    //   232: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: ldc 99
    //   240: aload 8
    //   242: aload 9
    //   244: invokestatic 138	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   247: ldc 76
    //   249: ldc 140
    //   251: lload_3
    //   252: invokestatic 146	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   255: aload_0
    //   256: getfield 22	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:b	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   259: getfield 150	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:traceId	Ljava/lang/String;
    //   262: invokestatic 156	aodb:Q	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   265: iload 7
    //   267: ifne -257 -> 10
    //   270: aload_0
    //   271: getfield 22	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:b	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   274: invokevirtual 51	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:azs	()Z
    //   277: ifne +224 -> 501
    //   280: aload_0
    //   281: getfield 22	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:b	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   284: getfield 159	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:filePath	Ljava/lang/String;
    //   287: invokestatic 165	ahbj:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   290: ifeq +211 -> 501
    //   293: ldc 76
    //   295: ldc 167
    //   297: ldc 169
    //   299: aload_0
    //   300: getfield 22	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:b	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   303: getfield 150	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:traceId	Ljava/lang/String;
    //   306: invokestatic 156	aodb:Q	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   309: aload_0
    //   310: getfield 18	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:this$0	Laoar;
    //   313: aload_0
    //   314: getfield 22	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:b	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   317: invokevirtual 173	aoar:l	(Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;)V
    //   320: aload_0
    //   321: getfield 22	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:b	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   324: astore 8
    //   326: iconst_0
    //   327: istore_2
    //   328: iload_2
    //   329: istore_1
    //   330: aload 10
    //   332: invokestatic 179	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   335: ifne +18 -> 353
    //   338: new 55	org/json/JSONObject
    //   341: dup
    //   342: aload 10
    //   344: invokespecial 105	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   347: ldc 181
    //   349: invokevirtual 185	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   352: istore_1
    //   353: iload_1
    //   354: sipush 20003
    //   357: if_icmpeq -347 -> 10
    //   360: iload_1
    //   361: sipush 20005
    //   364: if_icmpeq -354 -> 10
    //   367: aload 8
    //   369: iconst_0
    //   370: putfield 189	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:cKX	Z
    //   373: aload_0
    //   374: getfield 18	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:this$0	Laoar;
    //   377: aload 8
    //   379: invokevirtual 192	aoar:j	(Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;)V
    //   382: return
    //   383: astore 8
    //   385: ldc 76
    //   387: iconst_1
    //   388: aload 8
    //   390: invokevirtual 193	java/lang/Exception:toString	()Ljava/lang/String;
    //   393: invokestatic 196	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   396: goto -242 -> 154
    //   399: ldc 76
    //   401: ldc 167
    //   403: ldc 198
    //   405: aload_0
    //   406: getfield 22	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:b	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   409: getfield 150	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:traceId	Ljava/lang/String;
    //   412: invokestatic 156	aodb:Q	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   415: iconst_0
    //   416: istore 7
    //   418: goto -264 -> 154
    //   421: aload_0
    //   422: getfield 22	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:b	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   425: getfield 121	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:nFileType	I
    //   428: bipush 6
    //   430: if_icmpne +10 -> 440
    //   433: ldc 200
    //   435: astore 8
    //   437: goto -261 -> 176
    //   440: aload_0
    //   441: getfield 22	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:b	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   444: getfield 121	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:nFileType	I
    //   447: bipush 7
    //   449: if_icmpne +10 -> 459
    //   452: ldc 202
    //   454: astore 8
    //   456: goto -280 -> 176
    //   459: aload_0
    //   460: getfield 22	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:b	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   463: getfield 121	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:nFileType	I
    //   466: bipush 9
    //   468: if_icmpne -292 -> 176
    //   471: ldc 204
    //   473: astore 8
    //   475: goto -299 -> 176
    //   478: iconst_2
    //   479: istore_1
    //   480: goto -275 -> 205
    //   483: astore 9
    //   485: ldc 76
    //   487: iconst_1
    //   488: aload 9
    //   490: invokevirtual 205	org/json/JSONException:toString	()Ljava/lang/String;
    //   493: invokestatic 196	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   496: iload_2
    //   497: istore_1
    //   498: goto -145 -> 353
    //   501: aload_0
    //   502: getfield 18	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:this$0	Laoar;
    //   505: invokestatic 208	aoar:a	(Laoar;)Landroid/os/Handler;
    //   508: ifnull -498 -> 10
    //   511: aload_0
    //   512: getfield 18	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:this$0	Laoar;
    //   515: invokestatic 208	aoar:a	(Laoar;)Landroid/os/Handler;
    //   518: sipush 8002
    //   521: invokevirtual 214	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
    //   524: astore 8
    //   526: aload 8
    //   528: aload_0
    //   529: getfield 22	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:b	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   532: putfield 220	android/os/Message:obj	Ljava/lang/Object;
    //   535: aload_0
    //   536: getfield 18	com/tencent/mobileqq/teamwork/TeamWorkFileImportHandler$3:this$0	Laoar;
    //   539: invokestatic 208	aoar:a	(Laoar;)Landroid/os/Handler;
    //   542: aload 8
    //   544: invokevirtual 224	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   547: pop
    //   548: return
    //   549: astore 8
    //   551: goto -508 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	554	0	this	3
    //   204	294	1	i	int
    //   197	300	2	j	int
    //   14	238	3	l1	long
    //   65	112	5	l2	long
    //   132	285	7	bool	boolean
    //   148	230	8	localObject1	Object
    //   383	6	8	localException	java.lang.Exception
    //   435	108	8	localObject2	Object
    //   549	1	8	localJSONException1	org.json.JSONException
    //   112	131	9	localObject3	Object
    //   483	6	9	localJSONException2	org.json.JSONException
    //   60	283	10	str	java.lang.String
    //   188	18	11	localQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   134	150	383	java/lang/Exception
    //   330	353	483	org/json/JSONException
    //   32	43	549	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkFileImportHandler.3
 * JD-Core Version:    0.7.0.1
 */