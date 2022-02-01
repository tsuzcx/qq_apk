package com.tencent.token;

import com.tencent.halley.downloader.c;
import com.tencent.halley.downloader.c.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public final class x
  implements c, aa, p.a
{
  private static x a;
  private Vector b = new Vector();
  private z c = new z(this);
  
  private x()
  {
    p.a(this);
  }
  
  public static x a()
  {
    try
    {
      if (a == null) {
        a = new x();
      }
      x localx = a;
      return localx;
    }
    finally {}
  }
  
  /* Error */
  private void a(e parame, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: new 48	java/lang/StringBuilder
    //   8: dup
    //   9: ldc 50
    //   11: invokespecial 53	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: astore 10
    //   16: aload 10
    //   18: aload_1
    //   19: invokevirtual 58	com/tencent/halley/downloader/c/e:c	()Ljava/lang/String;
    //   22: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload 10
    //   28: ldc 64
    //   30: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload 10
    //   36: iload_2
    //   37: invokevirtual 67	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload 10
    //   43: ldc 69
    //   45: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload 10
    //   51: aload_1
    //   52: getfield 73	com/tencent/halley/downloader/c/e:j	J
    //   55: invokevirtual 76	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload 10
    //   61: ldc 78
    //   63: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload 10
    //   69: aload_1
    //   70: invokevirtual 82	com/tencent/halley/downloader/c/e:f	()J
    //   73: invokevirtual 76	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload 10
    //   79: ldc 84
    //   81: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload 10
    //   87: aload_1
    //   88: invokevirtual 87	com/tencent/halley/downloader/c/e:a_	()J
    //   91: invokevirtual 76	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload 10
    //   97: ldc 89
    //   99: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload 10
    //   105: aload_1
    //   106: getfield 93	com/tencent/halley/downloader/c/e:o	Ljava/util/concurrent/atomic/AtomicLong;
    //   109: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: ldc 98
    //   115: aload 10
    //   117: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 106	com/tencent/halley/common/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: getstatic 112	com/tencent/token/k:e	Z
    //   126: ifne +31 -> 157
    //   129: new 48	java/lang/StringBuilder
    //   132: dup
    //   133: ldc 114
    //   135: invokespecial 53	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   138: astore_1
    //   139: aload_1
    //   140: getstatic 112	com/tencent/token/k:e	Z
    //   143: invokevirtual 117	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: ldc 98
    //   149: aload_1
    //   150: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 119	com/tencent/halley/common/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: return
    //   157: new 121	java/util/HashMap
    //   160: dup
    //   161: invokespecial 122	java/util/HashMap:<init>	()V
    //   164: astore 10
    //   166: new 48	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   173: astore 11
    //   175: aload 11
    //   177: aload_1
    //   178: getfield 127	com/tencent/halley/downloader/c/e:n	Ljava/lang/String;
    //   181: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload 10
    //   187: ldc 129
    //   189: aload 11
    //   191: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   197: pop
    //   198: new 48	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   205: astore 11
    //   207: aload 11
    //   209: invokestatic 137	com/tencent/halley/common/h:e	()Ljava/lang/String;
    //   212: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload 10
    //   218: ldc 139
    //   220: aload 11
    //   222: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   228: pop
    //   229: new 48	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   236: astore 11
    //   238: aload 11
    //   240: invokestatic 141	com/tencent/halley/common/h:f	()Ljava/lang/String;
    //   243: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload 10
    //   249: ldc 143
    //   251: aload 11
    //   253: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   259: pop
    //   260: new 48	java/lang/StringBuilder
    //   263: dup
    //   264: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   267: astore 11
    //   269: aload 11
    //   271: invokestatic 147	com/tencent/halley/common/h:g	()I
    //   274: invokevirtual 67	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload 10
    //   280: ldc 149
    //   282: aload 11
    //   284: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   290: pop
    //   291: getstatic 151	com/tencent/token/k:a	Ljava/lang/String;
    //   294: invokestatic 157	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   297: ifne +34 -> 331
    //   300: new 48	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   307: astore 11
    //   309: aload 11
    //   311: getstatic 151	com/tencent/token/k:a	Ljava/lang/String;
    //   314: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: pop
    //   318: aload 10
    //   320: ldc 159
    //   322: aload 11
    //   324: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   330: pop
    //   331: aload 10
    //   333: ldc 161
    //   335: invokestatic 164	com/tencent/halley/common/f:f	()Ljava/lang/String;
    //   338: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   341: pop
    //   342: aload_1
    //   343: getfield 166	com/tencent/halley/downloader/c/e:c	Ljava/lang/String;
    //   346: invokestatic 157	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   349: ifne +35 -> 384
    //   352: new 48	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   359: astore 11
    //   361: aload 11
    //   363: aload_1
    //   364: getfield 166	com/tencent/halley/downloader/c/e:c	Ljava/lang/String;
    //   367: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: pop
    //   371: aload 10
    //   373: ldc 168
    //   375: aload 11
    //   377: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   383: pop
    //   384: aload_1
    //   385: getfield 171	com/tencent/halley/downloader/c/e:d	Ljava/lang/String;
    //   388: invokestatic 157	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   391: ifne +35 -> 426
    //   394: new 48	java/lang/StringBuilder
    //   397: dup
    //   398: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   401: astore 11
    //   403: aload 11
    //   405: aload_1
    //   406: getfield 171	com/tencent/halley/downloader/c/e:d	Ljava/lang/String;
    //   409: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: aload 10
    //   415: ldc 173
    //   417: aload 11
    //   419: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   425: pop
    //   426: getstatic 175	com/tencent/token/k:b	Ljava/lang/String;
    //   429: invokestatic 157	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   432: ifne +34 -> 466
    //   435: new 48	java/lang/StringBuilder
    //   438: dup
    //   439: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   442: astore 11
    //   444: aload 11
    //   446: getstatic 175	com/tencent/token/k:b	Ljava/lang/String;
    //   449: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: pop
    //   453: aload 10
    //   455: ldc 177
    //   457: aload 11
    //   459: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   462: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   465: pop
    //   466: getstatic 178	com/tencent/token/k:c	Ljava/lang/String;
    //   469: invokestatic 157	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   472: ifne +34 -> 506
    //   475: new 48	java/lang/StringBuilder
    //   478: dup
    //   479: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   482: astore 11
    //   484: aload 11
    //   486: getstatic 178	com/tencent/token/k:c	Ljava/lang/String;
    //   489: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: pop
    //   493: aload 10
    //   495: ldc 180
    //   497: aload 11
    //   499: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   502: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   505: pop
    //   506: new 48	java/lang/StringBuilder
    //   509: dup
    //   510: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   513: astore 11
    //   515: aload 11
    //   517: invokestatic 184	com/tencent/halley/common/e:b	()J
    //   520: invokevirtual 76	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   523: pop
    //   524: aload 10
    //   526: ldc 186
    //   528: aload 11
    //   530: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   533: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   536: pop
    //   537: new 48	java/lang/StringBuilder
    //   540: dup
    //   541: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   544: astore 11
    //   546: aload 11
    //   548: invokestatic 188	com/tencent/halley/common/e:a	()J
    //   551: invokevirtual 76	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   554: pop
    //   555: aload 10
    //   557: ldc 190
    //   559: aload 11
    //   561: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   564: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   567: pop
    //   568: aload 10
    //   570: ldc 192
    //   572: aload_1
    //   573: invokevirtual 195	com/tencent/halley/downloader/c/e:s	()Ljava/lang/String;
    //   576: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   579: pop
    //   580: new 48	java/lang/StringBuilder
    //   583: dup
    //   584: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   587: astore 11
    //   589: aload 11
    //   591: aload_1
    //   592: invokevirtual 198	com/tencent/halley/downloader/c/e:q	()J
    //   595: invokevirtual 76	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   598: pop
    //   599: aload 10
    //   601: ldc 200
    //   603: aload 11
    //   605: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   608: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   611: pop
    //   612: new 48	java/lang/StringBuilder
    //   615: dup
    //   616: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   619: astore 11
    //   621: aload 11
    //   623: aload_1
    //   624: getfield 73	com/tencent/halley/downloader/c/e:j	J
    //   627: invokevirtual 76	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   630: pop
    //   631: aload 10
    //   633: ldc 202
    //   635: aload 11
    //   637: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   640: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   643: pop
    //   644: invokestatic 207	java/lang/System:currentTimeMillis	()J
    //   647: lstore 5
    //   649: new 48	java/lang/StringBuilder
    //   652: dup
    //   653: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   656: astore 11
    //   658: aload 11
    //   660: aload_1
    //   661: getfield 210	com/tencent/halley/downloader/c/e:t	J
    //   664: invokevirtual 76	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   667: pop
    //   668: aload 10
    //   670: ldc 212
    //   672: aload 11
    //   674: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   677: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   680: pop
    //   681: new 48	java/lang/StringBuilder
    //   684: dup
    //   685: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   688: astore 11
    //   690: aload 11
    //   692: lload 5
    //   694: invokevirtual 76	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   697: pop
    //   698: aload 10
    //   700: ldc 214
    //   702: aload 11
    //   704: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   707: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   710: pop
    //   711: new 48	java/lang/StringBuilder
    //   714: dup
    //   715: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   718: astore 11
    //   720: aload 11
    //   722: aload_1
    //   723: getfield 217	com/tencent/halley/downloader/c/e:a	I
    //   726: invokevirtual 67	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   729: pop
    //   730: aload 10
    //   732: ldc 219
    //   734: aload 11
    //   736: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   739: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   742: pop
    //   743: new 48	java/lang/StringBuilder
    //   746: dup
    //   747: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   750: astore 11
    //   752: aload 11
    //   754: aload_1
    //   755: getfield 220	com/tencent/halley/downloader/c/e:b	Ljava/lang/String;
    //   758: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   761: pop
    //   762: aload 10
    //   764: ldc 222
    //   766: aload 11
    //   768: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   771: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   774: pop
    //   775: aload 10
    //   777: ldc 224
    //   779: aload_1
    //   780: invokevirtual 226	com/tencent/halley/downloader/c/e:n	()Ljava/lang/String;
    //   783: invokestatic 229	com/tencent/halley/common/h:b	(Ljava/lang/String;)Ljava/lang/String;
    //   786: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   789: pop
    //   790: aload 10
    //   792: ldc 231
    //   794: aload_1
    //   795: getfield 235	com/tencent/halley/downloader/c/e:F	Ljava/util/HashMap;
    //   798: invokevirtual 236	java/util/HashMap:toString	()Ljava/lang/String;
    //   801: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   804: pop
    //   805: aload_1
    //   806: invokevirtual 239	com/tencent/halley/downloader/c/e:m	()I
    //   809: istore_3
    //   810: iconst_0
    //   811: istore 4
    //   813: iload_2
    //   814: ifne +5 -> 819
    //   817: iconst_0
    //   818: istore_3
    //   819: new 48	java/lang/StringBuilder
    //   822: dup
    //   823: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   826: astore 11
    //   828: aload 11
    //   830: iload_3
    //   831: invokevirtual 67	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   834: pop
    //   835: aload 10
    //   837: ldc 241
    //   839: aload 11
    //   841: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   844: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   847: pop
    //   848: new 48	java/lang/StringBuilder
    //   851: dup
    //   852: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   855: astore 11
    //   857: aload 11
    //   859: iload_2
    //   860: invokevirtual 67	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   863: pop
    //   864: aload 10
    //   866: ldc 243
    //   868: aload 11
    //   870: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   873: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   876: pop
    //   877: aload 10
    //   879: ldc 245
    //   881: aload_1
    //   882: invokevirtual 248	com/tencent/halley/downloader/c/e:M	()Ljava/lang/String;
    //   885: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   888: pop
    //   889: aload_1
    //   890: getfield 251	com/tencent/halley/downloader/c/e:z	Ljava/lang/String;
    //   893: invokestatic 157	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   896: ifne +35 -> 931
    //   899: new 48	java/lang/StringBuilder
    //   902: dup
    //   903: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   906: astore 11
    //   908: aload 11
    //   910: aload_1
    //   911: getfield 251	com/tencent/halley/downloader/c/e:z	Ljava/lang/String;
    //   914: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   917: pop
    //   918: aload 10
    //   920: ldc 253
    //   922: aload 11
    //   924: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   927: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   930: pop
    //   931: new 48	java/lang/StringBuilder
    //   934: dup
    //   935: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   938: astore 11
    //   940: aload 11
    //   942: invokestatic 255	com/tencent/token/p:e	()I
    //   945: invokevirtual 67	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   948: pop
    //   949: aload 10
    //   951: ldc_w 257
    //   954: aload 11
    //   956: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   959: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   962: pop
    //   963: new 48	java/lang/StringBuilder
    //   966: dup
    //   967: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   970: astore 11
    //   972: aload 11
    //   974: aload_1
    //   975: invokevirtual 259	com/tencent/halley/downloader/c/e:J	()Ljava/lang/String;
    //   978: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   981: pop
    //   982: aload 10
    //   984: ldc_w 261
    //   987: aload 11
    //   989: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   992: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   995: pop
    //   996: new 48	java/lang/StringBuilder
    //   999: dup
    //   1000: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   1003: astore 11
    //   1005: aload 11
    //   1007: aload_1
    //   1008: getfield 264	com/tencent/halley/downloader/c/e:A	I
    //   1011: invokevirtual 67	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1014: pop
    //   1015: aload 10
    //   1017: ldc_w 266
    //   1020: aload 11
    //   1022: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1025: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1028: pop
    //   1029: new 48	java/lang/StringBuilder
    //   1032: dup
    //   1033: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   1036: astore 11
    //   1038: aload_1
    //   1039: invokevirtual 269	com/tencent/halley/downloader/c/e:o	()Z
    //   1042: ifeq +795 -> 1837
    //   1045: iconst_1
    //   1046: istore_3
    //   1047: goto +3 -> 1050
    //   1050: aload 11
    //   1052: iload_3
    //   1053: invokevirtual 67	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1056: pop
    //   1057: aload 10
    //   1059: ldc_w 271
    //   1062: aload 11
    //   1064: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1067: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1070: pop
    //   1071: aload_1
    //   1072: invokevirtual 273	com/tencent/halley/downloader/c/e:z	()Z
    //   1075: istore 9
    //   1077: new 48	java/lang/StringBuilder
    //   1080: dup
    //   1081: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   1084: astore 11
    //   1086: iload 4
    //   1088: istore_3
    //   1089: iload 9
    //   1091: ifeq +5 -> 1096
    //   1094: iconst_1
    //   1095: istore_3
    //   1096: aload 11
    //   1098: iload_3
    //   1099: invokevirtual 67	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1102: pop
    //   1103: aload 10
    //   1105: ldc_w 275
    //   1108: new 277	java/lang/String
    //   1111: dup
    //   1112: aload 11
    //   1114: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1117: invokespecial 278	java/lang/String:<init>	(Ljava/lang/String;)V
    //   1120: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1123: pop
    //   1124: new 48	java/lang/StringBuilder
    //   1127: dup
    //   1128: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   1131: astore 11
    //   1133: aload 11
    //   1135: aload_1
    //   1136: invokevirtual 281	com/tencent/halley/downloader/c/e:H	()J
    //   1139: invokevirtual 76	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1142: pop
    //   1143: aload 10
    //   1145: ldc_w 283
    //   1148: aload 11
    //   1150: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1153: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1156: pop
    //   1157: new 48	java/lang/StringBuilder
    //   1160: dup
    //   1161: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   1164: astore 11
    //   1166: aload 11
    //   1168: aload_1
    //   1169: invokevirtual 286	com/tencent/halley/downloader/c/e:G	()J
    //   1172: invokevirtual 76	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1175: pop
    //   1176: aload 10
    //   1178: ldc_w 288
    //   1181: aload 11
    //   1183: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1186: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1189: pop
    //   1190: aload 10
    //   1192: ldc_w 290
    //   1195: aload_1
    //   1196: invokevirtual 293	com/tencent/halley/downloader/c/e:K	()Ljava/lang/String;
    //   1199: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1202: pop
    //   1203: iload_2
    //   1204: ifeq +10 -> 1214
    //   1207: aload_1
    //   1208: invokestatic 298	android/os/SystemClock:elapsedRealtime	()J
    //   1211: putfield 301	com/tencent/halley/downloader/c/e:v	J
    //   1214: ldc2_w 302
    //   1217: lstore 7
    //   1219: lload 7
    //   1221: lstore 5
    //   1223: aload_1
    //   1224: getfield 306	com/tencent/halley/downloader/c/e:u	J
    //   1227: lconst_0
    //   1228: lcmp
    //   1229: ifle +30 -> 1259
    //   1232: lload 7
    //   1234: lstore 5
    //   1236: aload_1
    //   1237: getfield 301	com/tencent/halley/downloader/c/e:v	J
    //   1240: aload_1
    //   1241: getfield 306	com/tencent/halley/downloader/c/e:u	J
    //   1244: lcmp
    //   1245: ifle +14 -> 1259
    //   1248: aload_1
    //   1249: getfield 301	com/tencent/halley/downloader/c/e:v	J
    //   1252: aload_1
    //   1253: getfield 306	com/tencent/halley/downloader/c/e:u	J
    //   1256: lsub
    //   1257: lstore 5
    //   1259: new 48	java/lang/StringBuilder
    //   1262: dup
    //   1263: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   1266: astore 11
    //   1268: aload 11
    //   1270: lload 5
    //   1272: invokevirtual 76	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1275: pop
    //   1276: aload 10
    //   1278: ldc_w 308
    //   1281: aload 11
    //   1283: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1286: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1289: pop
    //   1290: new 48	java/lang/StringBuilder
    //   1293: dup
    //   1294: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   1297: astore 11
    //   1299: aload 11
    //   1301: aload_1
    //   1302: invokevirtual 82	com/tencent/halley/downloader/c/e:f	()J
    //   1305: invokevirtual 76	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1308: pop
    //   1309: aload 10
    //   1311: ldc_w 310
    //   1314: aload 11
    //   1316: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1319: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1322: pop
    //   1323: new 48	java/lang/StringBuilder
    //   1326: dup
    //   1327: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   1330: astore 11
    //   1332: aload 11
    //   1334: aload_1
    //   1335: getfield 93	com/tencent/halley/downloader/c/e:o	Ljava/util/concurrent/atomic/AtomicLong;
    //   1338: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1341: pop
    //   1342: aload 10
    //   1344: ldc_w 312
    //   1347: aload 11
    //   1349: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1352: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1355: pop
    //   1356: new 48	java/lang/StringBuilder
    //   1359: dup
    //   1360: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   1363: astore 11
    //   1365: aload 11
    //   1367: aload_1
    //   1368: getfield 315	com/tencent/halley/downloader/c/e:p	Ljava/util/concurrent/atomic/AtomicLong;
    //   1371: lconst_0
    //   1372: invokevirtual 321	java/util/concurrent/atomic/AtomicLong:getAndSet	(J)J
    //   1375: invokevirtual 76	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1378: pop
    //   1379: aload 10
    //   1381: ldc_w 323
    //   1384: aload 11
    //   1386: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1389: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1392: pop
    //   1393: aload_1
    //   1394: getfield 326	com/tencent/halley/downloader/c/e:x	Z
    //   1397: ifeq +15 -> 1412
    //   1400: aload 10
    //   1402: ldc_w 328
    //   1405: ldc_w 330
    //   1408: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1411: pop
    //   1412: iload_2
    //   1413: ifne +36 -> 1449
    //   1416: new 48	java/lang/StringBuilder
    //   1419: dup
    //   1420: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   1423: astore 11
    //   1425: aload 11
    //   1427: aload_1
    //   1428: invokevirtual 332	com/tencent/halley/downloader/c/e:A	()I
    //   1431: invokevirtual 67	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1434: pop
    //   1435: aload 10
    //   1437: ldc_w 334
    //   1440: aload 11
    //   1442: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1445: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1448: pop
    //   1449: new 48	java/lang/StringBuilder
    //   1452: dup
    //   1453: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   1456: astore 11
    //   1458: aload 11
    //   1460: aload_0
    //   1461: invokespecial 337	com/tencent/token/x:i	()I
    //   1464: invokevirtual 67	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1467: pop
    //   1468: aload 10
    //   1470: ldc_w 339
    //   1473: aload 11
    //   1475: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1478: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1481: pop
    //   1482: new 48	java/lang/StringBuilder
    //   1485: dup
    //   1486: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   1489: astore 11
    //   1491: aload 11
    //   1493: aload_1
    //   1494: invokevirtual 342	com/tencent/halley/downloader/c/e:B	()I
    //   1497: invokevirtual 67	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1500: pop
    //   1501: aload 10
    //   1503: ldc_w 344
    //   1506: aload 11
    //   1508: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1511: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1514: pop
    //   1515: new 48	java/lang/StringBuilder
    //   1518: dup
    //   1519: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   1522: astore 11
    //   1524: aload 11
    //   1526: aload_1
    //   1527: invokevirtual 347	com/tencent/halley/downloader/c/e:E	()I
    //   1530: invokevirtual 67	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1533: pop
    //   1534: aload 10
    //   1536: ldc_w 349
    //   1539: aload 11
    //   1541: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1544: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1547: pop
    //   1548: new 48	java/lang/StringBuilder
    //   1551: dup
    //   1552: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   1555: astore 11
    //   1557: aload 11
    //   1559: aload_1
    //   1560: invokevirtual 352	com/tencent/halley/downloader/c/e:D	()J
    //   1563: invokevirtual 76	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1566: pop
    //   1567: aload 10
    //   1569: ldc_w 354
    //   1572: aload 11
    //   1574: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1577: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1580: pop
    //   1581: aload_1
    //   1582: invokevirtual 357	com/tencent/halley/downloader/c/e:C	()Z
    //   1585: ifeq +15 -> 1600
    //   1588: aload 10
    //   1590: ldc_w 359
    //   1593: ldc_w 330
    //   1596: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1599: pop
    //   1600: iload_2
    //   1601: ifne +45 -> 1646
    //   1604: aload_1
    //   1605: getfield 361	com/tencent/halley/downloader/c/e:B	J
    //   1608: lconst_0
    //   1609: lcmp
    //   1610: ifle +36 -> 1646
    //   1613: new 48	java/lang/StringBuilder
    //   1616: dup
    //   1617: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   1620: astore 11
    //   1622: aload 11
    //   1624: aload_1
    //   1625: getfield 361	com/tencent/halley/downloader/c/e:B	J
    //   1628: invokevirtual 76	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1631: pop
    //   1632: aload 10
    //   1634: ldc_w 363
    //   1637: aload 11
    //   1639: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1642: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1645: pop
    //   1646: new 48	java/lang/StringBuilder
    //   1649: dup
    //   1650: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   1653: astore 11
    //   1655: aload 11
    //   1657: aload_1
    //   1658: invokevirtual 366	com/tencent/halley/downloader/c/e:L	()Ljava/lang/String;
    //   1661: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1664: pop
    //   1665: aload 10
    //   1667: ldc_w 368
    //   1670: aload 11
    //   1672: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1675: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1678: pop
    //   1679: new 48	java/lang/StringBuilder
    //   1682: dup
    //   1683: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   1686: astore 11
    //   1688: aload 11
    //   1690: aload_1
    //   1691: invokevirtual 370	com/tencent/halley/downloader/c/e:I	()Ljava/lang/String;
    //   1694: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1697: pop
    //   1698: aload 10
    //   1700: ldc_w 372
    //   1703: aload 11
    //   1705: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1708: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1711: pop
    //   1712: aload_1
    //   1713: getfield 375	com/tencent/halley/downloader/c/e:y	Ljava/lang/String;
    //   1716: invokestatic 157	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1719: ifne +36 -> 1755
    //   1722: new 48	java/lang/StringBuilder
    //   1725: dup
    //   1726: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   1729: astore 11
    //   1731: aload 11
    //   1733: aload_1
    //   1734: getfield 375	com/tencent/halley/downloader/c/e:y	Ljava/lang/String;
    //   1737: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1740: pop
    //   1741: aload 10
    //   1743: ldc_w 377
    //   1746: aload 11
    //   1748: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1751: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1754: pop
    //   1755: aload_1
    //   1756: getfield 379	com/tencent/halley/downloader/c/e:D	Ljava/lang/String;
    //   1759: invokestatic 157	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1762: ifne +49 -> 1811
    //   1765: aload 10
    //   1767: ldc_w 381
    //   1770: aload_1
    //   1771: getfield 379	com/tencent/halley/downloader/c/e:D	Ljava/lang/String;
    //   1774: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1777: pop
    //   1778: new 48	java/lang/StringBuilder
    //   1781: dup
    //   1782: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   1785: astore 11
    //   1787: aload 11
    //   1789: aload_1
    //   1790: getfield 383	com/tencent/halley/downloader/c/e:E	I
    //   1793: invokevirtual 67	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1796: pop
    //   1797: aload 10
    //   1799: ldc_w 385
    //   1802: aload 11
    //   1804: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1807: invokevirtual 133	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1810: pop
    //   1811: ldc_w 387
    //   1814: iconst_1
    //   1815: lconst_0
    //   1816: lconst_0
    //   1817: aload 10
    //   1819: iconst_1
    //   1820: invokestatic 392	com/tencent/halley/common/g:a	(Ljava/lang/String;ZJJLjava/util/Map;Z)Z
    //   1823: pop
    //   1824: return
    //   1825: astore_1
    //   1826: goto +9 -> 1835
    //   1829: astore_1
    //   1830: aload_1
    //   1831: invokevirtual 395	java/lang/Throwable:printStackTrace	()V
    //   1834: return
    //   1835: aload_1
    //   1836: athrow
    //   1837: iconst_0
    //   1838: istore_3
    //   1839: goto -789 -> 1050
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1842	0	this	x
    //   0	1842	1	parame	e
    //   0	1842	2	paramInt	int
    //   809	1030	3	i	int
    //   811	276	4	j	int
    //   647	624	5	l1	long
    //   1217	16	7	l2	long
    //   1075	15	9	bool	boolean
    //   14	1804	10	localObject	Object
    //   173	1630	11	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   5	156	1825	finally
    //   157	331	1825	finally
    //   331	384	1825	finally
    //   384	426	1825	finally
    //   426	466	1825	finally
    //   466	506	1825	finally
    //   506	810	1825	finally
    //   819	931	1825	finally
    //   931	1045	1825	finally
    //   1050	1086	1825	finally
    //   1096	1203	1825	finally
    //   1207	1214	1825	finally
    //   1223	1232	1825	finally
    //   1236	1259	1825	finally
    //   1259	1412	1825	finally
    //   1416	1449	1825	finally
    //   1449	1600	1825	finally
    //   1604	1646	1825	finally
    //   1646	1755	1825	finally
    //   1755	1811	1825	finally
    //   1811	1824	1825	finally
    //   1830	1834	1825	finally
    //   5	156	1829	java/lang/Throwable
    //   157	331	1829	java/lang/Throwable
    //   331	384	1829	java/lang/Throwable
    //   384	426	1829	java/lang/Throwable
    //   426	466	1829	java/lang/Throwable
    //   466	506	1829	java/lang/Throwable
    //   506	810	1829	java/lang/Throwable
    //   819	931	1829	java/lang/Throwable
    //   931	1045	1829	java/lang/Throwable
    //   1050	1086	1829	java/lang/Throwable
    //   1096	1203	1829	java/lang/Throwable
    //   1207	1214	1829	java/lang/Throwable
    //   1223	1232	1829	java/lang/Throwable
    //   1236	1259	1829	java/lang/Throwable
    //   1259	1412	1829	java/lang/Throwable
    //   1416	1449	1829	java/lang/Throwable
    //   1449	1600	1829	java/lang/Throwable
    //   1604	1646	1829	java/lang/Throwable
    //   1646	1755	1829	java/lang/Throwable
    //   1755	1811	1829	java/lang/Throwable
    //   1811	1824	1829	java/lang/Throwable
  }
  
  private int i()
  {
    synchronized (this.b)
    {
      int i = this.b.size();
      return i + 0;
    }
  }
  
  private boolean j()
  {
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        if ((locale.t()) || (locale.u())) {
          return true;
        }
      }
      return false;
    }
  }
  
  public final void a(int paramInt, String paramString)
  {
    Object localObject = d();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((e)((Iterator)localObject).next()).a(paramInt, paramString);
      }
    }
  }
  
  public final void a(com.tencent.halley.downloader.b paramb) {}
  
  public final void a(com.tencent.halley.downloader.b paramb, boolean paramBoolean)
  {
    if (paramb == null) {
      return;
    }
    ??? = new StringBuilder("delete task:");
    ((StringBuilder)???).append(paramb.c());
    com.tencent.halley.common.b.b("TaskManager", ((StringBuilder)???).toString());
    e locale = (e)paramb;
    locale.a(paramBoolean);
    synchronized (this.b)
    {
      this.b.remove(paramb);
      a(locale, 3);
      if (j())
      {
        this.c.a();
        return;
      }
      this.c.b();
      return;
    }
  }
  
  public final void b()
  {
    z localz = this.c;
    if (localz != null) {
      localz.c();
    }
  }
  
  public final void b(com.tencent.halley.downloader.b paramb)
  {
    if (j())
    {
      this.c.a();
      return;
    }
    this.c.b();
  }
  
  public final List c()
  {
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.b)
    {
      localLinkedList.addAll(this.b);
      return localLinkedList;
    }
  }
  
  public final void c(com.tencent.halley.downloader.b paramb)
  {
    Object localObject = new StringBuilder("TaskManager");
    ((StringBuilder)localObject).append(paramb);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder("onTaskDetectedMainloop task:");
    localStringBuilder.append(paramb);
    localStringBuilder.append(",detectLen:");
    localStringBuilder.append(paramb.a_());
    com.tencent.halley.common.b.a((String)localObject, localStringBuilder.toString());
  }
  
  public final List d()
  {
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        if (locale.t()) {
          localLinkedList.add(locale);
        }
      }
      return localLinkedList;
    }
  }
  
  public final void d(com.tencent.halley.downloader.b paramb)
  {
    Object localObject = new StringBuilder("TaskManager");
    ((StringBuilder)localObject).append(paramb);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder("onTaskReceivedMainloop task:");
    localStringBuilder.append(paramb);
    localStringBuilder.append(",detectLen:");
    localStringBuilder.append(paramb.a_());
    localStringBuilder.append(",receivedLen:");
    localStringBuilder.append(paramb.f());
    localStringBuilder.append(",percentage:");
    localStringBuilder.append(paramb.g());
    com.tencent.halley.common.b.a((String)localObject, localStringBuilder.toString());
  }
  
  public final void e(com.tencent.halley.downloader.b paramb)
  {
    if (j()) {
      this.c.a();
    } else {
      this.c.b();
    }
    Object localObject = new StringBuilder("TaskManager");
    ((StringBuilder)localObject).append(paramb);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder("onTaskPausedMainloop task:");
    localStringBuilder.append(paramb);
    com.tencent.halley.common.b.a((String)localObject, localStringBuilder.toString());
  }
  
  public final boolean e()
  {
    Object localObject = d();
    int i = ((List)localObject).size();
    localObject = ((List)localObject).iterator();
    boolean bool = false;
    while (((Iterator)localObject).hasNext())
    {
      e locale = (e)((Iterator)localObject).next();
      locale.a(i);
      if (locale.e()) {
        bool = true;
      }
    }
    return bool;
  }
  
  public final long f()
  {
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      long l = 0L;
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        if (locale.t()) {
          l += locale.F();
        }
      }
      return l;
    }
  }
  
  public final void f(com.tencent.halley.downloader.b paramb)
  {
    if (j()) {
      this.c.a();
    } else {
      this.c.b();
    }
    Object localObject = new StringBuilder("TaskManager");
    ((StringBuilder)localObject).append(paramb);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder("onTaskFailedMainloop task:");
    localStringBuilder.append(paramb);
    localStringBuilder.append(",retCode:");
    localStringBuilder.append(paramb.m());
    localStringBuilder.append(",failInfo:");
    localStringBuilder.append(paramb.n());
    com.tencent.halley.common.b.a((String)localObject, localStringBuilder.toString());
  }
  
  public final void g(com.tencent.halley.downloader.b paramb)
  {
    if (j()) {
      this.c.a();
    } else {
      this.c.b();
    }
    Object localObject = new StringBuilder("TaskManager");
    ((StringBuilder)localObject).append(paramb);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder("onTaskCompletedMainloop task:");
    localStringBuilder.append(paramb);
    com.tencent.halley.common.b.a((String)localObject, localStringBuilder.toString());
  }
  
  public final boolean g()
  {
    return f() > 4194304L;
  }
  
  public final void h(com.tencent.halley.downloader.b paramb) {}
  
  public final boolean h()
  {
    return f() < 2097152L;
  }
  
  public final void i(com.tencent.halley.downloader.b paramb) {}
  
  public final void j(com.tencent.halley.downloader.b paramb) {}
  
  public final void k(com.tencent.halley.downloader.b paramb)
  {
    a((e)paramb, 2);
  }
  
  public final void l(com.tencent.halley.downloader.b paramb)
  {
    a((e)paramb, 1);
  }
  
  public final void m(com.tencent.halley.downloader.b paramb)
  {
    a((e)paramb, 0);
  }
  
  /* Error */
  public final void n(com.tencent.halley.downloader.b paramb)
  {
    // Byte code:
    //   0: ldc_w 503
    //   3: astore_3
    //   4: aload_1
    //   5: ifnull +283 -> 288
    //   8: aload_1
    //   9: instanceof 55
    //   12: ifne +6 -> 18
    //   15: goto +273 -> 288
    //   18: aload_1
    //   19: checkcast 55	com/tencent/halley/downloader/c/e
    //   22: astore 4
    //   24: aload_0
    //   25: monitorenter
    //   26: aload 4
    //   28: getfield 505	com/tencent/halley/downloader/c/e:i	Ljava/lang/String;
    //   31: invokestatic 508	com/tencent/halley/common/h:a	(Ljava/lang/String;)Z
    //   34: ifeq +11 -> 45
    //   37: aload 4
    //   39: ldc_w 503
    //   42: putfield 505	com/tencent/halley/downloader/c/e:i	Ljava/lang/String;
    //   45: aload_3
    //   46: astore_2
    //   47: aload 4
    //   49: getfield 505	com/tencent/halley/downloader/c/e:i	Ljava/lang/String;
    //   52: invokestatic 510	com/tencent/token/k:c	(Ljava/lang/String;)Z
    //   55: ifeq +155 -> 210
    //   58: aload_0
    //   59: invokevirtual 512	com/tencent/token/x:c	()Ljava/util/List;
    //   62: invokeinterface 423 1 0
    //   67: astore_2
    //   68: aload_3
    //   69: astore_1
    //   70: aload_2
    //   71: invokeinterface 407 1 0
    //   76: ifeq +117 -> 193
    //   79: aload_2
    //   80: invokeinterface 411 1 0
    //   85: checkcast 425	com/tencent/halley/downloader/b
    //   88: astore_1
    //   89: aload 4
    //   91: getfield 514	com/tencent/halley/downloader/c/e:h	Ljava/lang/String;
    //   94: aload_1
    //   95: invokeinterface 516 1 0
    //   100: invokevirtual 519	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   103: ifeq -35 -> 68
    //   106: aload 4
    //   108: getfield 505	com/tencent/halley/downloader/c/e:i	Ljava/lang/String;
    //   111: astore 5
    //   113: aload_1
    //   114: checkcast 55	com/tencent/halley/downloader/c/e
    //   117: invokevirtual 522	com/tencent/halley/downloader/c/e:r	()Z
    //   120: ifeq +13 -> 133
    //   123: aload_1
    //   124: invokeinterface 524 1 0
    //   129: astore_1
    //   130: goto +10 -> 140
    //   133: aload_1
    //   134: invokeinterface 526 1 0
    //   139: astore_1
    //   140: aload 5
    //   142: aload_1
    //   143: invokevirtual 519	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   146: ifeq -78 -> 68
    //   149: new 48	java/lang/StringBuilder
    //   152: dup
    //   153: ldc_w 528
    //   156: invokespecial 53	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   159: astore_1
    //   160: aload_1
    //   161: aload 4
    //   163: getfield 514	com/tencent/halley/downloader/c/e:h	Ljava/lang/String;
    //   166: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload_1
    //   171: ldc_w 530
    //   174: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload_1
    //   179: aload 4
    //   181: getfield 505	com/tencent/halley/downloader/c/e:i	Ljava/lang/String;
    //   184: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload_1
    //   189: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: astore_1
    //   193: aload_1
    //   194: astore_2
    //   195: ldc_w 503
    //   198: aload_1
    //   199: invokevirtual 533	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   202: ifne +8 -> 210
    //   205: aload_0
    //   206: monitorexit
    //   207: goto +85 -> 292
    //   210: aload_0
    //   211: getfield 27	com/tencent/token/x:b	Ljava/util/Vector;
    //   214: astore_1
    //   215: aload_1
    //   216: monitorenter
    //   217: aload_0
    //   218: getfield 27	com/tencent/token/x:b	Ljava/util/Vector;
    //   221: aload 4
    //   223: invokevirtual 534	java/util/Vector:add	(Ljava/lang/Object;)Z
    //   226: pop
    //   227: aload_1
    //   228: monitorexit
    //   229: aload 4
    //   231: invokevirtual 536	com/tencent/halley/downloader/c/e:p	()V
    //   234: aload_2
    //   235: astore_1
    //   236: goto -31 -> 205
    //   239: astore_1
    //   240: goto +36 -> 276
    //   243: astore_1
    //   244: aload_1
    //   245: invokevirtual 539	com/tencent/halley/downloader/exceptions/DownloaderAddTaskException:getLocalizedMessage	()Ljava/lang/String;
    //   248: astore_1
    //   249: aload_0
    //   250: getfield 27	com/tencent/token/x:b	Ljava/util/Vector;
    //   253: astore_2
    //   254: aload_2
    //   255: monitorenter
    //   256: aload_0
    //   257: getfield 27	com/tencent/token/x:b	Ljava/util/Vector;
    //   260: aload 4
    //   262: invokevirtual 439	java/util/Vector:remove	(Ljava/lang/Object;)Z
    //   265: pop
    //   266: aload_2
    //   267: monitorexit
    //   268: goto -63 -> 205
    //   271: astore_1
    //   272: aload_2
    //   273: monitorexit
    //   274: aload_1
    //   275: athrow
    //   276: aload_1
    //   277: athrow
    //   278: astore_2
    //   279: aload_1
    //   280: monitorexit
    //   281: aload_2
    //   282: athrow
    //   283: astore_1
    //   284: aload_0
    //   285: monitorexit
    //   286: aload_1
    //   287: athrow
    //   288: ldc_w 541
    //   291: astore_1
    //   292: ldc_w 503
    //   295: aload_1
    //   296: invokevirtual 533	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   299: ifeq +4 -> 303
    //   302: return
    //   303: new 501	com/tencent/halley/downloader/exceptions/DownloaderAddTaskException
    //   306: dup
    //   307: aload_1
    //   308: invokespecial 542	com/tencent/halley/downloader/exceptions/DownloaderAddTaskException:<init>	(Ljava/lang/String;)V
    //   311: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	this	x
    //   0	312	1	paramb	com.tencent.halley.downloader.b
    //   278	4	2	localObject2	Object
    //   3	66	3	str1	String
    //   22	239	4	locale	e
    //   111	30	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   229	234	239	finally
    //   244	256	239	finally
    //   272	276	239	finally
    //   229	234	243	com/tencent/halley/downloader/exceptions/DownloaderAddTaskException
    //   256	268	271	finally
    //   217	229	278	finally
    //   26	45	283	finally
    //   47	68	283	finally
    //   70	130	283	finally
    //   133	140	283	finally
    //   140	193	283	finally
    //   195	205	283	finally
    //   205	207	283	finally
    //   210	217	283	finally
    //   276	278	283	finally
    //   279	283	283	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.x
 * JD-Core Version:    0.7.0.1
 */