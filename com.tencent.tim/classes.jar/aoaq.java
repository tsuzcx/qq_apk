class aoaq
  extends agie
{
  aoaq(aoap paramaoap) {}
  
  /* Error */
  protected void a(boolean paramBoolean1, long paramLong1, java.lang.String paramString1, java.lang.String paramString2, com.tencent.mobileqq.pb.ByteStringMicro paramByteStringMicro, boolean paramBoolean2, java.lang.String paramString3, short paramShort, java.lang.String paramString4, java.util.List<java.lang.String> paramList, int paramInt, java.lang.String paramString5, java.lang.String paramString6, java.lang.String paramString7, long paramLong2, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 12
    //   3: new 19	org/json/JSONObject
    //   6: dup
    //   7: invokespecial 20	org/json/JSONObject:<init>	()V
    //   10: astore 6
    //   12: iload_1
    //   13: ifeq +393 -> 406
    //   16: invokestatic 26	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   19: ifeq +68 -> 87
    //   22: ldc 28
    //   24: iconst_2
    //   25: new 30	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   32: ldc 33
    //   34: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: lload_2
    //   38: invokevirtual 40	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   41: ldc 42
    //   43: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload 4
    //   48: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: ldc 44
    //   53: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload 5
    //   58: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc 46
    //   63: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload 8
    //   68: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc 48
    //   73: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: iload 9
    //   78: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   81: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 59	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   87: new 30	java/lang/StringBuilder
    //   90: dup
    //   91: ldc 61
    //   93: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   96: astore 4
    //   98: aload 4
    //   100: aload 8
    //   102: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: ldc 66
    //   107: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: iload 9
    //   112: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   115: aload 10
    //   117: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: new 68	org/json/JSONArray
    //   124: dup
    //   125: invokespecial 69	org/json/JSONArray:<init>	()V
    //   128: astore 8
    //   130: aload 8
    //   132: iconst_0
    //   133: aload 4
    //   135: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokevirtual 73	org/json/JSONArray:put	(ILjava/lang/Object;)Lorg/json/JSONArray;
    //   141: pop
    //   142: aload 6
    //   144: ldc 75
    //   146: aload 8
    //   148: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   151: pop
    //   152: aload 6
    //   154: ldc 80
    //   156: aload 13
    //   158: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   161: pop
    //   162: aload 6
    //   164: ldc 82
    //   166: aload 5
    //   168: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   171: pop
    //   172: aload 6
    //   174: ldc 84
    //   176: iload 7
    //   178: invokevirtual 87	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   181: pop
    //   182: iconst_1
    //   183: istore 9
    //   185: iconst_0
    //   186: istore 12
    //   188: aload_0
    //   189: getfield 10	aoaq:a	Laoap;
    //   192: getfield 93	aoap:entity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   195: ifnull +132 -> 327
    //   198: iload 9
    //   200: ifne +21 -> 221
    //   203: aload 6
    //   205: ldc 80
    //   207: aload_0
    //   208: getfield 10	aoaq:a	Laoap;
    //   211: getfield 97	aoap:e	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   214: getfield 103	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:fileName	Ljava/lang/String;
    //   217: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   220: pop
    //   221: aload 6
    //   223: ldc 105
    //   225: iconst_1
    //   226: invokevirtual 108	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   229: pop
    //   230: aload 6
    //   232: ldc 110
    //   234: aload_0
    //   235: getfield 10	aoaq:a	Laoap;
    //   238: getfield 93	aoap:entity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   241: getfield 115	com/tencent/mobileqq/filemanager/data/FileManagerEntity:Uuid	Ljava/lang/String;
    //   244: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   247: pop
    //   248: aload 6
    //   250: ldc 117
    //   252: aload_0
    //   253: getfield 10	aoaq:a	Laoap;
    //   256: getfield 93	aoap:entity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   259: getfield 120	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   262: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   265: pop
    //   266: aload 6
    //   268: ldc 122
    //   270: aload_0
    //   271: getfield 10	aoaq:a	Laoap;
    //   274: getfield 93	aoap:entity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   277: getfield 125	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileSHA	Ljava/lang/String;
    //   280: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   283: pop
    //   284: aload 6
    //   286: ldc 127
    //   288: aload_0
    //   289: getfield 10	aoaq:a	Laoap;
    //   292: getfield 93	aoap:entity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   295: getfield 131	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fileSize	J
    //   298: invokevirtual 134	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   301: pop
    //   302: aload_0
    //   303: getfield 10	aoaq:a	Laoap;
    //   306: getfield 93	aoap:entity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   309: getfield 138	com/tencent/mobileqq/filemanager/data/FileManagerEntity:bSend	Z
    //   312: ifeq +141 -> 453
    //   315: aload 6
    //   317: ldc 140
    //   319: iconst_1
    //   320: invokevirtual 108	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   323: pop
    //   324: iconst_1
    //   325: istore 12
    //   327: iload 12
    //   329: ifne +8 -> 337
    //   332: iload 9
    //   334: ifeq +168 -> 502
    //   337: aload 6
    //   339: ifnull +163 -> 502
    //   342: aload_0
    //   343: getfield 10	aoaq:a	Laoap;
    //   346: getfield 143	aoap:a	Laoar;
    //   349: aload 6
    //   351: aload_0
    //   352: getfield 10	aoaq:a	Laoap;
    //   355: getfield 97	aoap:e	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   358: aload_0
    //   359: getfield 10	aoaq:a	Laoap;
    //   362: invokevirtual 149	java/lang/Object:hashCode	()I
    //   365: invokevirtual 155	aoar:b	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;I)V
    //   368: return
    //   369: astore 4
    //   371: iconst_0
    //   372: istore 9
    //   374: ldc 28
    //   376: iconst_2
    //   377: new 30	java/lang/StringBuilder
    //   380: dup
    //   381: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   384: ldc 157
    //   386: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: aload 4
    //   391: invokevirtual 158	java/lang/Exception:toString	()Ljava/lang/String;
    //   394: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 160	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   403: goto -218 -> 185
    //   406: ldc 28
    //   408: iconst_1
    //   409: new 30	java/lang/StringBuilder
    //   412: dup
    //   413: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   416: ldc 33
    //   418: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: lload_2
    //   422: invokevirtual 40	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   425: ldc 162
    //   427: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: aload 13
    //   432: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: ldc 164
    //   437: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   443: invokestatic 160	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   446: iload 12
    //   448: istore 9
    //   450: goto -265 -> 185
    //   453: aload 6
    //   455: ldc 140
    //   457: iconst_2
    //   458: invokevirtual 108	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   461: pop
    //   462: goto -138 -> 324
    //   465: astore 4
    //   467: ldc 28
    //   469: iconst_2
    //   470: new 30	java/lang/StringBuilder
    //   473: dup
    //   474: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   477: ldc 166
    //   479: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: aload 4
    //   484: invokevirtual 158	java/lang/Exception:toString	()Ljava/lang/String;
    //   487: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: invokestatic 160	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   496: iconst_0
    //   497: istore 12
    //   499: goto -172 -> 327
    //   502: aload_0
    //   503: getfield 10	aoaq:a	Laoap;
    //   506: iconst_1
    //   507: invokevirtual 170	aoap:QI	(Z)V
    //   510: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	511	0	this	aoaq
    //   0	511	1	paramBoolean1	boolean
    //   0	511	2	paramLong1	long
    //   0	511	4	paramString1	java.lang.String
    //   0	511	5	paramString2	java.lang.String
    //   0	511	6	paramByteStringMicro	com.tencent.mobileqq.pb.ByteStringMicro
    //   0	511	7	paramBoolean2	boolean
    //   0	511	8	paramString3	java.lang.String
    //   0	511	9	paramShort	short
    //   0	511	10	paramString4	java.lang.String
    //   0	511	11	paramList	java.util.List<java.lang.String>
    //   0	511	12	paramInt	int
    //   0	511	13	paramString5	java.lang.String
    //   0	511	14	paramString6	java.lang.String
    //   0	511	15	paramString7	java.lang.String
    //   0	511	16	paramLong2	long
    //   0	511	18	paramBundle	android.os.Bundle
    // Exception table:
    //   from	to	target	type
    //   121	182	369	java/lang/Exception
    //   188	198	465	java/lang/Exception
    //   203	221	465	java/lang/Exception
    //   221	324	465	java/lang/Exception
    //   453	462	465	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aoaq
 * JD-Core Version:    0.7.0.1
 */