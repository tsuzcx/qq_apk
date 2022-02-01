package com.tencent.biz.pubaccount.readinjoy.data;

import com.tencent.mobileqq.app.automator.AsyncStep;

public class ReadInJoyDAUReport
  extends AsyncStep
{
  public String eE(String paramString)
  {
    if (paramString == null) {}
    do
    {
      do
      {
        return null;
        paramString = paramString.split("\\|");
      } while (paramString == null);
      paramString = paramString[(paramString.length - 1)].split(".");
    } while ((paramString == null) || (paramString.length <= 1));
    return paramString[1];
  }
  
  /* Error */
  public int od()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 29	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyDAUReport:a	Lcom/tencent/mobileqq/app/automator/Automator;
    //   4: getfield 35	com/tencent/mobileqq/app/automator/Automator:mApp	Lcom/tencent/common/app/AppInterface;
    //   7: invokevirtual 41	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   10: invokevirtual 47	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   13: astore 4
    //   15: ldc 49
    //   17: monitorenter
    //   18: aload 4
    //   20: ldc 49
    //   22: invokevirtual 55	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;)Ljava/util/List;
    //   25: astore_3
    //   26: aload_0
    //   27: getfield 29	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyDAUReport:a	Lcom/tencent/mobileqq/app/automator/Automator;
    //   30: getfield 35	com/tencent/mobileqq/app/automator/Automator:mApp	Lcom/tencent/common/app/AppInterface;
    //   33: bipush 51
    //   35: invokevirtual 59	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   38: checkcast 61	acff
    //   41: astore 5
    //   43: aload 5
    //   45: ifnull +614 -> 659
    //   48: aload 5
    //   50: aload_0
    //   51: getfield 29	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyDAUReport:a	Lcom/tencent/mobileqq/app/automator/Automator;
    //   54: getfield 35	com/tencent/mobileqq/app/automator/Automator:mApp	Lcom/tencent/common/app/AppInterface;
    //   57: invokevirtual 65	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   60: invokevirtual 69	acff:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   63: astore 5
    //   65: aload 5
    //   67: ifnull +592 -> 659
    //   70: aload 5
    //   72: getfield 75	com/tencent/mobileqq/data/Card:shGender	S
    //   75: istore_2
    //   76: aload 5
    //   78: getfield 79	com/tencent/mobileqq/data/Card:age	B
    //   81: istore_1
    //   82: aload_3
    //   83: ifnull +562 -> 645
    //   86: aload_3
    //   87: invokeinterface 84 1 0
    //   92: ifle +553 -> 645
    //   95: aload_3
    //   96: invokeinterface 88 1 0
    //   101: astore_3
    //   102: aload_3
    //   103: invokeinterface 94 1 0
    //   108: ifeq +537 -> 645
    //   111: aload_3
    //   112: invokeinterface 98 1 0
    //   117: checkcast 49	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo
    //   120: astore 5
    //   122: new 100	java/util/HashMap
    //   125: dup
    //   126: iconst_2
    //   127: invokespecial 103	java/util/HashMap:<init>	(I)V
    //   130: astore 6
    //   132: aload 6
    //   134: ldc 105
    //   136: aload 5
    //   138: getfield 108	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activityName	Ljava/lang/String;
    //   141: invokevirtual 112	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   144: pop
    //   145: aload 6
    //   147: ldc 114
    //   149: aload 5
    //   151: getfield 117	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:count	I
    //   154: invokestatic 121	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   157: invokevirtual 112	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   160: pop
    //   161: aload 6
    //   163: ldc 123
    //   165: iload_2
    //   166: invokestatic 121	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   169: invokevirtual 112	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   172: pop
    //   173: aload 6
    //   175: ldc 124
    //   177: iload_1
    //   178: invokestatic 121	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   181: invokevirtual 112	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   184: pop
    //   185: aload 6
    //   187: ldc 126
    //   189: aload 5
    //   191: getfield 128	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:preActivityList	Ljava/lang/String;
    //   194: invokevirtual 112	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   197: pop
    //   198: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   201: ifeq +92 -> 293
    //   204: ldc 135
    //   206: iconst_2
    //   207: new 137	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   214: ldc 140
    //   216: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload_0
    //   220: getfield 29	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyDAUReport:a	Lcom/tencent/mobileqq/app/automator/Automator;
    //   223: getfield 35	com/tencent/mobileqq/app/automator/Automator:mApp	Lcom/tencent/common/app/AppInterface;
    //   226: invokevirtual 65	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   229: invokestatic 147	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   232: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: ldc 149
    //   237: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload 5
    //   242: getfield 152	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activeDate	Ljava/lang/String;
    //   245: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: ldc 154
    //   250: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: ldc 156
    //   255: iconst_1
    //   256: anewarray 158	java/lang/Object
    //   259: dup
    //   260: iconst_0
    //   261: invokestatic 163	com/tencent/common/config/AppSetting:getVersion	()Ljava/lang/String;
    //   264: aastore
    //   265: invokestatic 167	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   268: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: ldc 169
    //   273: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload 5
    //   278: getfield 173	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:showTime	J
    //   281: invokestatic 179	java/lang/Long:toString	(J)Ljava/lang/String;
    //   284: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   293: aconst_null
    //   294: ldc 187
    //   296: ldc 189
    //   298: ldc 189
    //   300: ldc 191
    //   302: ldc 191
    //   304: iconst_0
    //   305: iconst_0
    //   306: aload 5
    //   308: getfield 173	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:showTime	J
    //   311: invokestatic 179	java/lang/Long:toString	(J)Ljava/lang/String;
    //   314: aload 5
    //   316: getfield 152	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activeDate	Ljava/lang/String;
    //   319: ldc 156
    //   321: iconst_1
    //   322: anewarray 158	java/lang/Object
    //   325: dup
    //   326: iconst_0
    //   327: invokestatic 163	com/tencent/common/config/AppSetting:getVersion	()Ljava/lang/String;
    //   330: aastore
    //   331: invokestatic 167	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   334: aconst_null
    //   335: invokestatic 196	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   338: aload_0
    //   339: aload 5
    //   341: getfield 128	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:preActivityList	Ljava/lang/String;
    //   344: invokevirtual 198	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyDAUReport:eE	(Ljava/lang/String;)Ljava/lang/String;
    //   347: astore 6
    //   349: aload 5
    //   351: getfield 108	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activityName	Ljava/lang/String;
    //   354: invokestatic 204	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   357: ifne +158 -> 515
    //   360: aload 5
    //   362: getfield 108	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activityName	Ljava/lang/String;
    //   365: ldc 206
    //   367: invokevirtual 210	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   370: ifeq +145 -> 515
    //   373: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   376: ifeq +92 -> 468
    //   379: ldc 135
    //   381: iconst_2
    //   382: new 137	java/lang/StringBuilder
    //   385: dup
    //   386: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   389: ldc 212
    //   391: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: aload_0
    //   395: getfield 29	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyDAUReport:a	Lcom/tencent/mobileqq/app/automator/Automator;
    //   398: getfield 35	com/tencent/mobileqq/app/automator/Automator:mApp	Lcom/tencent/common/app/AppInterface;
    //   401: invokevirtual 65	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   404: invokestatic 147	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   407: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: ldc 149
    //   412: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: aload 5
    //   417: getfield 152	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activeDate	Ljava/lang/String;
    //   420: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: ldc 154
    //   425: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: ldc 156
    //   430: iconst_1
    //   431: anewarray 158	java/lang/Object
    //   434: dup
    //   435: iconst_0
    //   436: invokestatic 163	com/tencent/common/config/AppSetting:getVersion	()Ljava/lang/String;
    //   439: aastore
    //   440: invokestatic 167	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   443: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: ldc 169
    //   448: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: aload 5
    //   453: getfield 173	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:showTime	J
    //   456: invokestatic 179	java/lang/Long:toString	(J)Ljava/lang/String;
    //   459: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   465: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   468: aconst_null
    //   469: ldc 187
    //   471: ldc 189
    //   473: ldc 189
    //   475: ldc 214
    //   477: ldc 214
    //   479: iconst_0
    //   480: iconst_0
    //   481: aload 5
    //   483: getfield 173	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:showTime	J
    //   486: invokestatic 179	java/lang/Long:toString	(J)Ljava/lang/String;
    //   489: aload 5
    //   491: getfield 152	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activeDate	Ljava/lang/String;
    //   494: ldc 156
    //   496: iconst_1
    //   497: anewarray 158	java/lang/Object
    //   500: dup
    //   501: iconst_0
    //   502: invokestatic 163	com/tencent/common/config/AppSetting:getVersion	()Ljava/lang/String;
    //   505: aastore
    //   506: invokestatic 167	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   509: invokestatic 219	kxm:iQ	()Ljava/lang/String;
    //   512: invokestatic 196	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   515: aload 5
    //   517: getfield 108	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activityName	Ljava/lang/String;
    //   520: invokestatic 204	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   523: ifne -421 -> 102
    //   526: aload 6
    //   528: ifnull -426 -> 102
    //   531: aload 6
    //   533: ldc 206
    //   535: invokevirtual 210	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   538: ifeq -436 -> 102
    //   541: aload 5
    //   543: getfield 108	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activityName	Ljava/lang/String;
    //   546: ldc 221
    //   548: invokevirtual 224	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   551: ifeq -449 -> 102
    //   554: aconst_null
    //   555: ldc 187
    //   557: ldc 189
    //   559: ldc 189
    //   561: ldc 214
    //   563: ldc 214
    //   565: iconst_0
    //   566: iconst_0
    //   567: aload 5
    //   569: getfield 173	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:showTime	J
    //   572: invokestatic 179	java/lang/Long:toString	(J)Ljava/lang/String;
    //   575: aload 5
    //   577: getfield 152	com/tencent/biz/pubaccount/readinjoy/data/ReadInJoyActivityDAUInfo:activeDate	Ljava/lang/String;
    //   580: ldc 156
    //   582: iconst_1
    //   583: anewarray 158	java/lang/Object
    //   586: dup
    //   587: iconst_0
    //   588: invokestatic 163	com/tencent/common/config/AppSetting:getVersion	()Ljava/lang/String;
    //   591: aastore
    //   592: invokestatic 167	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   595: invokestatic 219	kxm:iQ	()Ljava/lang/String;
    //   598: invokestatic 196	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   601: goto -499 -> 102
    //   604: astore_3
    //   605: ldc 49
    //   607: monitorexit
    //   608: aload_3
    //   609: athrow
    //   610: astore_3
    //   611: invokestatic 133	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   614: ifeq +52 -> 666
    //   617: ldc 135
    //   619: iconst_2
    //   620: new 137	java/lang/StringBuilder
    //   623: dup
    //   624: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   627: ldc 226
    //   629: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: aload_3
    //   633: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   636: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   639: invokestatic 185	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   642: goto +24 -> 666
    //   645: aload 4
    //   647: ldc 49
    //   649: invokevirtual 233	com/tencent/mobileqq/persistence/EntityManager:drop	(Ljava/lang/Class;)Z
    //   652: pop
    //   653: ldc 49
    //   655: monitorexit
    //   656: bipush 7
    //   658: ireturn
    //   659: iconst_m1
    //   660: istore_1
    //   661: iconst_m1
    //   662: istore_2
    //   663: goto -581 -> 82
    //   666: aconst_null
    //   667: astore_3
    //   668: goto -642 -> 26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	671	0	this	ReadInJoyDAUReport
    //   81	580	1	i	int
    //   75	588	2	j	int
    //   25	87	3	localObject1	java.lang.Object
    //   604	5	3	localObject2	java.lang.Object
    //   610	23	3	localException	java.lang.Exception
    //   667	1	3	localObject3	java.lang.Object
    //   13	633	4	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    //   41	535	5	localObject4	java.lang.Object
    //   130	402	6	localObject5	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   18	26	604	finally
    //   26	43	604	finally
    //   48	65	604	finally
    //   70	82	604	finally
    //   86	102	604	finally
    //   102	293	604	finally
    //   293	468	604	finally
    //   468	515	604	finally
    //   515	526	604	finally
    //   531	601	604	finally
    //   605	608	604	finally
    //   611	642	604	finally
    //   645	656	604	finally
    //   18	26	610	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.data.ReadInJoyDAUReport
 * JD-Core Version:    0.7.0.1
 */