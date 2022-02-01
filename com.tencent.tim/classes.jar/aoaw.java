class aoaw
  extends agie
{
  aoaw(aoav paramaoav) {}
  
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
    //   13: ifeq +488 -> 501
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
    //   189: getfield 10	aoaw:a	Laoav;
    //   192: getfield 93	aoav:entity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   195: ifnull +212 -> 407
    //   198: iload 9
    //   200: ifne +21 -> 221
    //   203: aload 6
    //   205: ldc 80
    //   207: aload_0
    //   208: getfield 10	aoaw:a	Laoav;
    //   211: getfield 97	aoav:e	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
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
    //   235: getfield 10	aoaw:a	Laoav;
    //   238: getfield 93	aoav:entity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   241: getfield 115	com/tencent/mobileqq/filemanager/data/FileManagerEntity:Uuid	Ljava/lang/String;
    //   244: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   247: pop
    //   248: aload 6
    //   250: ldc 117
    //   252: aload_0
    //   253: getfield 10	aoaw:a	Laoav;
    //   256: getfield 93	aoav:entity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   259: getfield 120	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   262: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   265: pop
    //   266: aload 6
    //   268: ldc 122
    //   270: aload_0
    //   271: getfield 10	aoaw:a	Laoav;
    //   274: getfield 93	aoav:entity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   277: getfield 125	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileSHA	Ljava/lang/String;
    //   280: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   283: pop
    //   284: aload 6
    //   286: ldc 127
    //   288: aload_0
    //   289: getfield 10	aoaw:a	Laoav;
    //   292: getfield 93	aoav:entity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   295: getfield 131	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fileSize	J
    //   298: invokevirtual 134	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   301: pop
    //   302: aload_0
    //   303: getfield 10	aoaw:a	Laoav;
    //   306: getfield 97	aoav:e	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   309: getfield 137	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:bxe	Ljava/lang/String;
    //   312: ifnull +21 -> 333
    //   315: aload 6
    //   317: ldc 139
    //   319: aload_0
    //   320: getfield 10	aoaw:a	Laoav;
    //   323: getfield 97	aoav:e	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   326: getfield 137	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:bxe	Ljava/lang/String;
    //   329: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   332: pop
    //   333: aload_0
    //   334: getfield 10	aoaw:a	Laoav;
    //   337: getfield 97	aoav:e	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   340: aload_0
    //   341: getfield 10	aoaw:a	Laoav;
    //   344: getfield 93	aoav:entity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   347: getfield 115	com/tencent/mobileqq/filemanager/data/FileManagerEntity:Uuid	Ljava/lang/String;
    //   350: putfield 142	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:cjG	Ljava/lang/String;
    //   353: aload_0
    //   354: getfield 10	aoaw:a	Laoav;
    //   357: getfield 97	aoav:e	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   360: iconst_1
    //   361: putfield 145	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:filetype	I
    //   364: aload_0
    //   365: getfield 10	aoaw:a	Laoav;
    //   368: getfield 93	aoav:entity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   371: getfield 149	com/tencent/mobileqq/filemanager/data/FileManagerEntity:bSend	Z
    //   374: ifeq +174 -> 548
    //   377: aload 6
    //   379: ldc 151
    //   381: iconst_1
    //   382: invokevirtual 108	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   385: pop
    //   386: aload 6
    //   388: ldc 153
    //   390: aload_0
    //   391: getfield 10	aoaw:a	Laoav;
    //   394: getfield 97	aoav:e	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   397: getfield 156	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:dNR	I
    //   400: invokevirtual 108	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   403: pop
    //   404: iconst_1
    //   405: istore 12
    //   407: iload 12
    //   409: ifne +8 -> 417
    //   412: iload 9
    //   414: ifeq +183 -> 597
    //   417: aload 6
    //   419: invokestatic 162	aoag:u	(Lorg/json/JSONObject;)Z
    //   422: ifeq +175 -> 597
    //   425: aload_0
    //   426: getfield 10	aoaw:a	Laoav;
    //   429: aload 6
    //   431: invokestatic 165	aoav:a	(Laoav;Lorg/json/JSONObject;)Z
    //   434: ifeq +163 -> 597
    //   437: aload_0
    //   438: getfield 10	aoaw:a	Laoav;
    //   441: getfield 168	aoav:a	Laoar;
    //   444: aload 6
    //   446: aload_0
    //   447: getfield 10	aoaw:a	Laoav;
    //   450: getfield 97	aoav:e	Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;
    //   453: aload_0
    //   454: getfield 10	aoaw:a	Laoav;
    //   457: invokevirtual 174	java/lang/Object:hashCode	()I
    //   460: invokevirtual 179	aoar:a	(Lorg/json/JSONObject;Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;I)V
    //   463: return
    //   464: astore 4
    //   466: iconst_0
    //   467: istore 9
    //   469: ldc 28
    //   471: iconst_2
    //   472: new 30	java/lang/StringBuilder
    //   475: dup
    //   476: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   479: ldc 181
    //   481: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: aload 4
    //   486: invokevirtual 182	java/lang/Exception:toString	()Ljava/lang/String;
    //   489: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   495: invokestatic 184	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   498: goto -313 -> 185
    //   501: ldc 28
    //   503: iconst_1
    //   504: new 30	java/lang/StringBuilder
    //   507: dup
    //   508: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   511: ldc 33
    //   513: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: lload_2
    //   517: invokevirtual 40	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   520: ldc 186
    //   522: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: aload 13
    //   527: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: ldc 188
    //   532: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   538: invokestatic 184	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   541: iload 12
    //   543: istore 9
    //   545: goto -360 -> 185
    //   548: aload 6
    //   550: ldc 151
    //   552: iconst_2
    //   553: invokevirtual 108	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   556: pop
    //   557: goto -171 -> 386
    //   560: astore 4
    //   562: ldc 28
    //   564: iconst_2
    //   565: new 30	java/lang/StringBuilder
    //   568: dup
    //   569: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   572: ldc 190
    //   574: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: aload 4
    //   579: invokevirtual 182	java/lang/Exception:toString	()Ljava/lang/String;
    //   582: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   588: invokestatic 184	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   591: iconst_0
    //   592: istore 12
    //   594: goto -187 -> 407
    //   597: aload_0
    //   598: getfield 10	aoaw:a	Laoav;
    //   601: iconst_1
    //   602: invokevirtual 194	aoav:QI	(Z)V
    //   605: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	606	0	this	aoaw
    //   0	606	1	paramBoolean1	boolean
    //   0	606	2	paramLong1	long
    //   0	606	4	paramString1	java.lang.String
    //   0	606	5	paramString2	java.lang.String
    //   0	606	6	paramByteStringMicro	com.tencent.mobileqq.pb.ByteStringMicro
    //   0	606	7	paramBoolean2	boolean
    //   0	606	8	paramString3	java.lang.String
    //   0	606	9	paramShort	short
    //   0	606	10	paramString4	java.lang.String
    //   0	606	11	paramList	java.util.List<java.lang.String>
    //   0	606	12	paramInt	int
    //   0	606	13	paramString5	java.lang.String
    //   0	606	14	paramString6	java.lang.String
    //   0	606	15	paramString7	java.lang.String
    //   0	606	16	paramLong2	long
    //   0	606	18	paramBundle	android.os.Bundle
    // Exception table:
    //   from	to	target	type
    //   121	182	464	java/lang/Exception
    //   188	198	560	java/lang/Exception
    //   203	221	560	java/lang/Exception
    //   221	333	560	java/lang/Exception
    //   333	386	560	java/lang/Exception
    //   386	404	560	java/lang/Exception
    //   548	557	560	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aoaw
 * JD-Core Version:    0.7.0.1
 */