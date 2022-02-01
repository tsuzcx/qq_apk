package com.tencent.token;

import com.tencent.halley.downloader.DownloaderTaskStatus;
import com.tencent.halley.downloader.c.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public final class ms
  implements lx.a, mo, mw
{
  private static ms c;
  public Vector a = new Vector();
  public mv b = new mv(this);
  
  private ms()
  {
    lx.a(this);
  }
  
  public static ms b()
  {
    try
    {
      if (c == null) {
        c = new ms();
      }
      ms localms = c;
      return localms;
    }
    finally {}
  }
  
  private int h()
  {
    synchronized (this.a)
    {
      int i = this.a.size();
      return i + 0;
    }
  }
  
  private List i()
  {
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        nf localnf = (nf)localIterator.next();
        if (localnf.t()) {
          localLinkedList.add(localnf);
        }
      }
      return localLinkedList;
    }
  }
  
  public final void a()
  {
    if (e())
    {
      this.b.a();
      return;
    }
    this.b.b();
  }
  
  public final void a(int paramInt, String paramString)
  {
    Object localObject = i();
    if (((List)localObject).size() > 0)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((nf)((Iterator)localObject).next()).a(paramInt, paramString);
      }
    }
  }
  
  public final void a(mn parammn)
  {
    String str = "TaskManager".concat(String.valueOf(parammn));
    StringBuilder localStringBuilder = new StringBuilder("onTaskDetectedMainloop task:");
    localStringBuilder.append(parammn);
    localStringBuilder.append(",detectLen:");
    localStringBuilder.append(parammn.e());
    mc.a(str, localStringBuilder.toString());
  }
  
  /* Error */
  public final void a(nf paramnf, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: new 109	java/lang/StringBuilder
    //   8: dup
    //   9: ldc 143
    //   11: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: astore 10
    //   16: aload 10
    //   18: aload_1
    //   19: invokevirtual 145	com/tencent/token/nf:c	()Ljava/lang/String;
    //   22: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload 10
    //   28: ldc 147
    //   30: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload 10
    //   36: iload_2
    //   37: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload 10
    //   43: ldc 152
    //   45: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload 10
    //   51: aload_1
    //   52: getfield 156	com/tencent/token/nf:m	J
    //   55: invokevirtual 129	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload 10
    //   61: ldc 158
    //   63: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload 10
    //   69: aload_1
    //   70: getfield 160	com/tencent/token/nf:i	J
    //   73: invokevirtual 129	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload 10
    //   79: ldc 162
    //   81: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload 10
    //   87: aload_1
    //   88: invokevirtual 163	com/tencent/token/nf:e	()J
    //   91: invokevirtual 129	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload 10
    //   97: ldc 165
    //   99: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload 10
    //   105: aload_1
    //   106: getfield 169	com/tencent/token/nf:r	Ljava/util/concurrent/atomic/AtomicLong;
    //   109: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: ldc 97
    //   115: aload 10
    //   117: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 171	com/tencent/token/mc:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: getstatic 176	com/tencent/token/ls:e	Z
    //   126: ifne +31 -> 157
    //   129: new 109	java/lang/StringBuilder
    //   132: dup
    //   133: ldc 178
    //   135: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   138: astore_1
    //   139: aload_1
    //   140: getstatic 176	com/tencent/token/ls:e	Z
    //   143: invokevirtual 181	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: ldc 97
    //   149: aload_1
    //   150: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 183	com/tencent/token/mc:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: return
    //   157: new 185	java/util/HashMap
    //   160: dup
    //   161: invokespecial 186	java/util/HashMap:<init>	()V
    //   164: astore 10
    //   166: new 109	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   173: astore 11
    //   175: aload 11
    //   177: aload_1
    //   178: getfield 191	com/tencent/token/nf:q	Ljava/lang/String;
    //   181: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload 10
    //   187: ldc 193
    //   189: aload 11
    //   191: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   197: pop
    //   198: new 109	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   205: astore 11
    //   207: aload 11
    //   209: invokestatic 201	com/tencent/token/ml:e	()Ljava/lang/String;
    //   212: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload 10
    //   218: ldc 203
    //   220: aload 11
    //   222: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   228: pop
    //   229: new 109	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   236: astore 11
    //   238: aload 11
    //   240: invokestatic 206	com/tencent/token/ml:f	()Ljava/lang/String;
    //   243: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload 10
    //   249: ldc 208
    //   251: aload 11
    //   253: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   259: pop
    //   260: new 109	java/lang/StringBuilder
    //   263: dup
    //   264: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   267: astore 11
    //   269: aload 11
    //   271: invokestatic 211	com/tencent/token/ml:g	()I
    //   274: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload 10
    //   280: ldc 213
    //   282: aload 11
    //   284: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   290: pop
    //   291: getstatic 215	com/tencent/token/ls:a	Ljava/lang/String;
    //   294: invokestatic 221	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   297: ifne +34 -> 331
    //   300: new 109	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   307: astore 11
    //   309: aload 11
    //   311: getstatic 215	com/tencent/token/ls:a	Ljava/lang/String;
    //   314: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: pop
    //   318: aload 10
    //   320: ldc 223
    //   322: aload 11
    //   324: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   330: pop
    //   331: aload 10
    //   333: ldc 225
    //   335: invokestatic 228	com/tencent/token/mj:f	()Ljava/lang/String;
    //   338: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   341: pop
    //   342: aload_1
    //   343: getfield 230	com/tencent/token/nf:c	Ljava/lang/String;
    //   346: invokestatic 221	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   349: ifne +35 -> 384
    //   352: new 109	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   359: astore 11
    //   361: aload 11
    //   363: aload_1
    //   364: getfield 230	com/tencent/token/nf:c	Ljava/lang/String;
    //   367: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: pop
    //   371: aload 10
    //   373: ldc 232
    //   375: aload 11
    //   377: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   383: pop
    //   384: aload_1
    //   385: getfield 235	com/tencent/token/nf:d	Ljava/lang/String;
    //   388: invokestatic 221	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   391: ifne +35 -> 426
    //   394: new 109	java/lang/StringBuilder
    //   397: dup
    //   398: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   401: astore 11
    //   403: aload 11
    //   405: aload_1
    //   406: getfield 235	com/tencent/token/nf:d	Ljava/lang/String;
    //   409: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: aload 10
    //   415: ldc 237
    //   417: aload 11
    //   419: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   425: pop
    //   426: getstatic 239	com/tencent/token/ls:b	Ljava/lang/String;
    //   429: invokestatic 221	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   432: ifne +34 -> 466
    //   435: new 109	java/lang/StringBuilder
    //   438: dup
    //   439: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   442: astore 11
    //   444: aload 11
    //   446: getstatic 239	com/tencent/token/ls:b	Ljava/lang/String;
    //   449: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: pop
    //   453: aload 10
    //   455: ldc 241
    //   457: aload 11
    //   459: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   462: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   465: pop
    //   466: getstatic 242	com/tencent/token/ls:c	Ljava/lang/String;
    //   469: invokestatic 221	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   472: ifne +34 -> 506
    //   475: new 109	java/lang/StringBuilder
    //   478: dup
    //   479: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   482: astore 11
    //   484: aload 11
    //   486: getstatic 242	com/tencent/token/ls:c	Ljava/lang/String;
    //   489: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: pop
    //   493: aload 10
    //   495: ldc 244
    //   497: aload 11
    //   499: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   502: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   505: pop
    //   506: new 109	java/lang/StringBuilder
    //   509: dup
    //   510: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   513: astore 11
    //   515: aload 11
    //   517: invokestatic 248	com/tencent/token/mi:b	()J
    //   520: invokevirtual 129	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   523: pop
    //   524: aload 10
    //   526: ldc 250
    //   528: aload 11
    //   530: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   533: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   536: pop
    //   537: new 109	java/lang/StringBuilder
    //   540: dup
    //   541: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   544: astore 11
    //   546: aload 11
    //   548: invokestatic 252	com/tencent/token/mi:a	()J
    //   551: invokevirtual 129	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   554: pop
    //   555: aload 10
    //   557: ldc 254
    //   559: aload 11
    //   561: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   564: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   567: pop
    //   568: aload 10
    //   570: ldc_w 256
    //   573: aload_1
    //   574: invokevirtual 259	com/tencent/token/nf:s	()Ljava/lang/String;
    //   577: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   580: pop
    //   581: new 109	java/lang/StringBuilder
    //   584: dup
    //   585: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   588: astore 11
    //   590: aload 11
    //   592: aload_1
    //   593: getfield 261	com/tencent/token/nf:h	J
    //   596: invokevirtual 129	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   599: pop
    //   600: aload 10
    //   602: ldc_w 263
    //   605: aload 11
    //   607: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   610: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   613: pop
    //   614: new 109	java/lang/StringBuilder
    //   617: dup
    //   618: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   621: astore 11
    //   623: aload 11
    //   625: aload_1
    //   626: getfield 156	com/tencent/token/nf:m	J
    //   629: invokevirtual 129	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   632: pop
    //   633: aload 10
    //   635: ldc_w 265
    //   638: aload 11
    //   640: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   643: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   646: pop
    //   647: invokestatic 270	java/lang/System:currentTimeMillis	()J
    //   650: lstore 5
    //   652: new 109	java/lang/StringBuilder
    //   655: dup
    //   656: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   659: astore 11
    //   661: aload 11
    //   663: aload_1
    //   664: getfield 273	com/tencent/token/nf:w	J
    //   667: invokevirtual 129	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   670: pop
    //   671: aload 10
    //   673: ldc_w 275
    //   676: aload 11
    //   678: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   681: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   684: pop
    //   685: aload 10
    //   687: ldc_w 277
    //   690: lload 5
    //   692: invokestatic 280	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   695: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   698: pop
    //   699: new 109	java/lang/StringBuilder
    //   702: dup
    //   703: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   706: astore 11
    //   708: aload 11
    //   710: aload_1
    //   711: getfield 283	com/tencent/token/nf:a	I
    //   714: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   717: pop
    //   718: aload 10
    //   720: ldc_w 285
    //   723: aload 11
    //   725: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   728: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   731: pop
    //   732: new 109	java/lang/StringBuilder
    //   735: dup
    //   736: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   739: astore 11
    //   741: aload 11
    //   743: aload_1
    //   744: getfield 286	com/tencent/token/nf:b	Ljava/lang/String;
    //   747: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   750: pop
    //   751: aload 10
    //   753: ldc_w 288
    //   756: aload 11
    //   758: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   761: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   764: pop
    //   765: aload 10
    //   767: ldc_w 290
    //   770: aload_1
    //   771: invokevirtual 293	com/tencent/token/nf:n	()Ljava/lang/String;
    //   774: invokestatic 295	com/tencent/token/ml:b	(Ljava/lang/String;)Ljava/lang/String;
    //   777: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   780: pop
    //   781: aload 10
    //   783: ldc_w 297
    //   786: aload_1
    //   787: getfield 301	com/tencent/token/nf:P	Ljava/util/HashMap;
    //   790: invokevirtual 302	java/util/HashMap:toString	()Ljava/lang/String;
    //   793: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   796: pop
    //   797: aload_1
    //   798: getfield 305	com/tencent/token/nf:u	I
    //   801: istore_3
    //   802: iconst_0
    //   803: istore 4
    //   805: iload_2
    //   806: ifne +5 -> 811
    //   809: iconst_0
    //   810: istore_3
    //   811: aload 10
    //   813: ldc_w 307
    //   816: iload_3
    //   817: invokestatic 310	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   820: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   823: pop
    //   824: aload 10
    //   826: ldc_w 312
    //   829: iload_2
    //   830: invokestatic 310	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   833: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   836: pop
    //   837: aload 10
    //   839: ldc_w 314
    //   842: aload_1
    //   843: invokevirtual 317	com/tencent/token/nf:D	()Ljava/lang/String;
    //   846: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   849: pop
    //   850: aload_1
    //   851: getfield 319	com/tencent/token/nf:I	Ljava/lang/String;
    //   854: invokestatic 221	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   857: ifne +36 -> 893
    //   860: new 109	java/lang/StringBuilder
    //   863: dup
    //   864: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   867: astore 11
    //   869: aload 11
    //   871: aload_1
    //   872: getfield 319	com/tencent/token/nf:I	Ljava/lang/String;
    //   875: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   878: pop
    //   879: aload 10
    //   881: ldc_w 321
    //   884: aload 11
    //   886: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   889: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   892: pop
    //   893: new 109	java/lang/StringBuilder
    //   896: dup
    //   897: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   900: astore 11
    //   902: aload 11
    //   904: invokestatic 323	com/tencent/token/lx:e	()I
    //   907: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   910: pop
    //   911: aload 10
    //   913: ldc_w 325
    //   916: aload 11
    //   918: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   921: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   924: pop
    //   925: new 109	java/lang/StringBuilder
    //   928: dup
    //   929: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   932: astore 11
    //   934: aload 11
    //   936: aload_1
    //   937: invokevirtual 328	com/tencent/token/nf:A	()Ljava/lang/String;
    //   940: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   943: pop
    //   944: aload 10
    //   946: ldc_w 330
    //   949: aload 11
    //   951: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   954: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   957: pop
    //   958: new 109	java/lang/StringBuilder
    //   961: dup
    //   962: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   965: astore 11
    //   967: aload 11
    //   969: aload_1
    //   970: getfield 332	com/tencent/token/nf:J	I
    //   973: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   976: pop
    //   977: aload 10
    //   979: ldc_w 334
    //   982: aload 11
    //   984: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   987: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   990: pop
    //   991: new 109	java/lang/StringBuilder
    //   994: dup
    //   995: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   998: astore 11
    //   1000: aload_1
    //   1001: getfield 336	com/tencent/token/nf:n	Z
    //   1004: ifeq +777 -> 1781
    //   1007: iconst_1
    //   1008: istore_3
    //   1009: goto +3 -> 1012
    //   1012: aload 11
    //   1014: iload_3
    //   1015: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1018: pop
    //   1019: aload 10
    //   1021: ldc_w 338
    //   1024: aload 11
    //   1026: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1029: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1032: pop
    //   1033: aload_1
    //   1034: getfield 340	com/tencent/token/nf:A	Z
    //   1037: istore 9
    //   1039: new 109	java/lang/StringBuilder
    //   1042: dup
    //   1043: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   1046: astore 11
    //   1048: iload 4
    //   1050: istore_3
    //   1051: iload 9
    //   1053: ifeq +5 -> 1058
    //   1056: iconst_1
    //   1057: istore_3
    //   1058: aload 11
    //   1060: iload_3
    //   1061: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1064: pop
    //   1065: aload 10
    //   1067: ldc_w 342
    //   1070: new 99	java/lang/String
    //   1073: dup
    //   1074: aload 11
    //   1076: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1079: invokespecial 343	java/lang/String:<init>	(Ljava/lang/String;)V
    //   1082: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1085: pop
    //   1086: new 109	java/lang/StringBuilder
    //   1089: dup
    //   1090: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   1093: astore 11
    //   1095: aload 11
    //   1097: aload_1
    //   1098: invokevirtual 346	com/tencent/token/nf:y	()J
    //   1101: invokevirtual 129	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1104: pop
    //   1105: aload 10
    //   1107: ldc_w 348
    //   1110: aload 11
    //   1112: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1115: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1118: pop
    //   1119: new 109	java/lang/StringBuilder
    //   1122: dup
    //   1123: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   1126: astore 11
    //   1128: aload 11
    //   1130: aload_1
    //   1131: getfield 350	com/tencent/token/nf:g	J
    //   1134: invokevirtual 129	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1137: pop
    //   1138: aload 10
    //   1140: ldc_w 352
    //   1143: aload 11
    //   1145: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1148: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1151: pop
    //   1152: aload 10
    //   1154: ldc_w 354
    //   1157: aload_1
    //   1158: invokevirtual 357	com/tencent/token/nf:B	()Ljava/lang/String;
    //   1161: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1164: pop
    //   1165: iload_2
    //   1166: ifeq +10 -> 1176
    //   1169: aload_1
    //   1170: invokestatic 362	android/os/SystemClock:elapsedRealtime	()J
    //   1173: putfield 364	com/tencent/token/nf:y	J
    //   1176: ldc2_w 365
    //   1179: lstore 7
    //   1181: lload 7
    //   1183: lstore 5
    //   1185: aload_1
    //   1186: getfield 369	com/tencent/token/nf:x	J
    //   1189: lconst_0
    //   1190: lcmp
    //   1191: ifle +30 -> 1221
    //   1194: lload 7
    //   1196: lstore 5
    //   1198: aload_1
    //   1199: getfield 364	com/tencent/token/nf:y	J
    //   1202: aload_1
    //   1203: getfield 369	com/tencent/token/nf:x	J
    //   1206: lcmp
    //   1207: ifle +14 -> 1221
    //   1210: aload_1
    //   1211: getfield 364	com/tencent/token/nf:y	J
    //   1214: aload_1
    //   1215: getfield 369	com/tencent/token/nf:x	J
    //   1218: lsub
    //   1219: lstore 5
    //   1221: aload 10
    //   1223: ldc_w 371
    //   1226: lload 5
    //   1228: invokestatic 280	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1231: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1234: pop
    //   1235: new 109	java/lang/StringBuilder
    //   1238: dup
    //   1239: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   1242: astore 11
    //   1244: aload 11
    //   1246: aload_1
    //   1247: getfield 160	com/tencent/token/nf:i	J
    //   1250: invokevirtual 129	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1253: pop
    //   1254: aload 10
    //   1256: ldc_w 373
    //   1259: aload 11
    //   1261: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1264: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1267: pop
    //   1268: new 109	java/lang/StringBuilder
    //   1271: dup
    //   1272: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   1275: astore 11
    //   1277: aload 11
    //   1279: aload_1
    //   1280: getfield 169	com/tencent/token/nf:r	Ljava/util/concurrent/atomic/AtomicLong;
    //   1283: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1286: pop
    //   1287: aload 10
    //   1289: ldc_w 375
    //   1292: aload 11
    //   1294: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1297: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1300: pop
    //   1301: new 109	java/lang/StringBuilder
    //   1304: dup
    //   1305: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   1308: astore 11
    //   1310: aload 11
    //   1312: aload_1
    //   1313: getfield 377	com/tencent/token/nf:s	Ljava/util/concurrent/atomic/AtomicLong;
    //   1316: lconst_0
    //   1317: invokevirtual 383	java/util/concurrent/atomic/AtomicLong:getAndSet	(J)J
    //   1320: invokevirtual 129	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1323: pop
    //   1324: aload 10
    //   1326: ldc_w 385
    //   1329: aload 11
    //   1331: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1334: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1337: pop
    //   1338: aload_1
    //   1339: getfield 388	com/tencent/token/nf:G	Z
    //   1342: ifeq +15 -> 1357
    //   1345: aload 10
    //   1347: ldc_w 390
    //   1350: ldc_w 392
    //   1353: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1356: pop
    //   1357: iload_2
    //   1358: ifne +39 -> 1397
    //   1361: new 109	java/lang/StringBuilder
    //   1364: dup
    //   1365: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   1368: astore 11
    //   1370: aload 11
    //   1372: aload_1
    //   1373: getfield 396	com/tencent/token/nf:C	Lcom/tencent/halley/downloader/c/b;
    //   1376: getfield 400	com/tencent/halley/downloader/c/b:e	I
    //   1379: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1382: pop
    //   1383: aload 10
    //   1385: ldc_w 402
    //   1388: aload 11
    //   1390: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1393: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1396: pop
    //   1397: new 109	java/lang/StringBuilder
    //   1400: dup
    //   1401: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   1404: astore 11
    //   1406: aload 11
    //   1408: aload_0
    //   1409: invokespecial 404	com/tencent/token/ms:h	()I
    //   1412: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1415: pop
    //   1416: aload 10
    //   1418: ldc_w 406
    //   1421: aload 11
    //   1423: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1426: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1429: pop
    //   1430: new 109	java/lang/StringBuilder
    //   1433: dup
    //   1434: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   1437: astore 11
    //   1439: aload 11
    //   1441: aload_1
    //   1442: getfield 409	com/tencent/token/nf:E	I
    //   1445: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1448: pop
    //   1449: aload 10
    //   1451: ldc_w 411
    //   1454: aload 11
    //   1456: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1459: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1462: pop
    //   1463: new 109	java/lang/StringBuilder
    //   1466: dup
    //   1467: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   1470: astore 11
    //   1472: aload 11
    //   1474: aload_1
    //   1475: invokevirtual 413	com/tencent/token/nf:x	()I
    //   1478: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1481: pop
    //   1482: aload 10
    //   1484: ldc_w 415
    //   1487: aload 11
    //   1489: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1492: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1495: pop
    //   1496: new 109	java/lang/StringBuilder
    //   1499: dup
    //   1500: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   1503: astore 11
    //   1505: aload 11
    //   1507: aload_1
    //   1508: invokevirtual 417	com/tencent/token/nf:w	()J
    //   1511: invokevirtual 129	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1514: pop
    //   1515: aload 10
    //   1517: ldc_w 419
    //   1520: aload 11
    //   1522: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1525: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1528: pop
    //   1529: aload_1
    //   1530: getfield 422	com/tencent/token/nf:F	Z
    //   1533: ifeq +15 -> 1548
    //   1536: aload 10
    //   1538: ldc_w 424
    //   1541: ldc_w 392
    //   1544: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1547: pop
    //   1548: iload_2
    //   1549: ifne +45 -> 1594
    //   1552: aload_1
    //   1553: getfield 427	com/tencent/token/nf:K	J
    //   1556: lconst_0
    //   1557: lcmp
    //   1558: ifle +36 -> 1594
    //   1561: new 109	java/lang/StringBuilder
    //   1564: dup
    //   1565: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   1568: astore 11
    //   1570: aload 11
    //   1572: aload_1
    //   1573: getfield 427	com/tencent/token/nf:K	J
    //   1576: invokevirtual 129	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1579: pop
    //   1580: aload 10
    //   1582: ldc_w 429
    //   1585: aload 11
    //   1587: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1590: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1593: pop
    //   1594: new 109	java/lang/StringBuilder
    //   1597: dup
    //   1598: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   1601: astore 11
    //   1603: aload 11
    //   1605: aload_1
    //   1606: invokevirtual 431	com/tencent/token/nf:C	()Ljava/lang/String;
    //   1609: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1612: pop
    //   1613: aload 10
    //   1615: ldc_w 433
    //   1618: aload 11
    //   1620: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1623: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1626: pop
    //   1627: new 109	java/lang/StringBuilder
    //   1630: dup
    //   1631: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   1634: astore 11
    //   1636: aload 11
    //   1638: aload_1
    //   1639: invokevirtual 436	com/tencent/token/nf:z	()Ljava/lang/String;
    //   1642: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1645: pop
    //   1646: aload 10
    //   1648: ldc_w 438
    //   1651: aload 11
    //   1653: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1656: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1659: pop
    //   1660: aload_1
    //   1661: getfield 441	com/tencent/token/nf:H	Ljava/lang/String;
    //   1664: invokestatic 221	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1667: ifne +36 -> 1703
    //   1670: new 109	java/lang/StringBuilder
    //   1673: dup
    //   1674: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   1677: astore 11
    //   1679: aload 11
    //   1681: aload_1
    //   1682: getfield 441	com/tencent/token/nf:H	Ljava/lang/String;
    //   1685: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1688: pop
    //   1689: aload 10
    //   1691: ldc_w 443
    //   1694: aload 11
    //   1696: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1699: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1702: pop
    //   1703: aload_1
    //   1704: getfield 446	com/tencent/token/nf:N	Ljava/lang/String;
    //   1707: invokestatic 221	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1710: ifne +49 -> 1759
    //   1713: aload 10
    //   1715: ldc_w 448
    //   1718: aload_1
    //   1719: getfield 446	com/tencent/token/nf:N	Ljava/lang/String;
    //   1722: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1725: pop
    //   1726: new 109	java/lang/StringBuilder
    //   1729: dup
    //   1730: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   1733: astore 11
    //   1735: aload 11
    //   1737: aload_1
    //   1738: getfield 451	com/tencent/token/nf:O	I
    //   1741: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1744: pop
    //   1745: aload 10
    //   1747: ldc_w 453
    //   1750: aload 11
    //   1752: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1755: invokevirtual 197	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1758: pop
    //   1759: ldc_w 455
    //   1762: aload 10
    //   1764: invokestatic 460	com/tencent/token/mk:a	(Ljava/lang/String;Ljava/util/Map;)Z
    //   1767: pop
    //   1768: return
    //   1769: astore_1
    //   1770: goto +9 -> 1779
    //   1773: astore_1
    //   1774: aload_1
    //   1775: invokevirtual 463	java/lang/Throwable:printStackTrace	()V
    //   1778: return
    //   1779: aload_1
    //   1780: athrow
    //   1781: iconst_0
    //   1782: istore_3
    //   1783: goto -771 -> 1012
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1786	0	this	ms
    //   0	1786	1	paramnf	nf
    //   0	1786	2	paramInt	int
    //   801	982	3	i	int
    //   803	246	4	j	int
    //   650	577	5	l1	long
    //   1179	16	7	l2	long
    //   1037	15	9	bool	boolean
    //   14	1749	10	localObject	Object
    //   173	1578	11	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   5	156	1769	finally
    //   157	331	1769	finally
    //   331	384	1769	finally
    //   384	426	1769	finally
    //   426	466	1769	finally
    //   466	506	1769	finally
    //   506	802	1769	finally
    //   811	893	1769	finally
    //   893	1007	1769	finally
    //   1012	1048	1769	finally
    //   1058	1165	1769	finally
    //   1169	1176	1769	finally
    //   1185	1194	1769	finally
    //   1198	1221	1769	finally
    //   1221	1357	1769	finally
    //   1361	1397	1769	finally
    //   1397	1548	1769	finally
    //   1552	1594	1769	finally
    //   1594	1703	1769	finally
    //   1703	1759	1769	finally
    //   1759	1768	1769	finally
    //   1774	1778	1769	finally
    //   5	156	1773	java/lang/Throwable
    //   157	331	1773	java/lang/Throwable
    //   331	384	1773	java/lang/Throwable
    //   384	426	1773	java/lang/Throwable
    //   426	466	1773	java/lang/Throwable
    //   466	506	1773	java/lang/Throwable
    //   506	802	1773	java/lang/Throwable
    //   811	893	1773	java/lang/Throwable
    //   893	1007	1773	java/lang/Throwable
    //   1012	1048	1773	java/lang/Throwable
    //   1058	1165	1773	java/lang/Throwable
    //   1169	1176	1773	java/lang/Throwable
    //   1185	1194	1773	java/lang/Throwable
    //   1198	1221	1773	java/lang/Throwable
    //   1221	1357	1773	java/lang/Throwable
    //   1361	1397	1773	java/lang/Throwable
    //   1397	1548	1773	java/lang/Throwable
    //   1552	1594	1773	java/lang/Throwable
    //   1594	1703	1773	java/lang/Throwable
    //   1703	1759	1773	java/lang/Throwable
    //   1759	1768	1773	java/lang/Throwable
  }
  
  public final void b(mn parammn)
  {
    String str = "TaskManager".concat(String.valueOf(parammn));
    StringBuilder localStringBuilder = new StringBuilder("onTaskReceivedMainloop task:");
    localStringBuilder.append(parammn);
    localStringBuilder.append(",detectLen:");
    localStringBuilder.append(parammn.e());
    localStringBuilder.append(",receivedLen:");
    localStringBuilder.append(parammn.b_());
    localStringBuilder.append(",percentage:");
    localStringBuilder.append(parammn.g());
    mc.a(str, localStringBuilder.toString());
  }
  
  public final void c()
  {
    mv localmv = this.b;
    if (localmv != null) {}
    try
    {
      if (localmv.b) {
        synchronized (localmv.a)
        {
          localmv.a.notify();
          return;
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public final void c(mn parammn)
  {
    if (e()) {
      this.b.a();
    } else {
      this.b.b();
    }
    mc.a("TaskManager".concat(String.valueOf(parammn)), "onTaskPausedMainloop task:".concat(String.valueOf(parammn)));
  }
  
  public final List d()
  {
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.a)
    {
      localLinkedList.addAll(this.a);
      return localLinkedList;
    }
  }
  
  public final void d(mn parammn)
  {
    if (e()) {
      this.b.a();
    } else {
      this.b.b();
    }
    String str = "TaskManager".concat(String.valueOf(parammn));
    StringBuilder localStringBuilder = new StringBuilder("onTaskFailedMainloop task:");
    localStringBuilder.append(parammn);
    localStringBuilder.append(",retCode:");
    localStringBuilder.append(parammn.m());
    localStringBuilder.append(",failInfo:");
    localStringBuilder.append(parammn.n());
    mc.a(str, localStringBuilder.toString());
  }
  
  public final void e(mn parammn)
  {
    if (e()) {
      this.b.a();
    } else {
      this.b.b();
    }
    mc.a("TaskManager".concat(String.valueOf(parammn)), "onTaskCompletedMainloop task:".concat(String.valueOf(parammn)));
  }
  
  public final boolean e()
  {
    for (;;)
    {
      int i;
      synchronized (this.a)
      {
        Iterator localIterator = this.a.iterator();
        boolean bool = localIterator.hasNext();
        i = 0;
        if (bool)
        {
          nf localnf = (nf)localIterator.next();
          if (!localnf.t())
          {
            if (localnf.C.b == DownloaderTaskStatus.PENDING) {
              i = 1;
            }
          }
          else {
            return true;
          }
        }
        else
        {
          return false;
        }
      }
      if (i == 0) {}
    }
  }
  
  public final void f(mn parammn) {}
  
  public final boolean f()
  {
    Object localObject = i();
    int i = ((List)localObject).size();
    localObject = ((List)localObject).iterator();
    boolean bool = false;
    while (((Iterator)localObject).hasNext())
    {
      nf localnf = (nf)((Iterator)localObject).next();
      if (localnf.E < i) {
        localnf.E = i;
      }
      if (localnf.f()) {
        bool = true;
      }
    }
    return bool;
  }
  
  public final long g()
  {
    for (;;)
    {
      long l1;
      synchronized (this.a)
      {
        Iterator localIterator = this.a.iterator();
        l1 = 0L;
        if (localIterator.hasNext())
        {
          nf localnf = (nf)localIterator.next();
          if (!localnf.t()) {
            continue;
          }
          if (localnf.z != null)
          {
            l2 = localnf.z.a;
            break label85;
          }
        }
        else
        {
          return l1;
        }
      }
      long l2 = 0L;
      label85:
      l1 += l2;
    }
  }
  
  public final void g(mn parammn)
  {
    a((nf)parammn, 2);
  }
  
  public final void h(mn parammn)
  {
    a((nf)parammn, 1);
  }
  
  public final void i(mn parammn)
  {
    a((nf)parammn, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ms
 * JD-Core Version:    0.7.0.1
 */