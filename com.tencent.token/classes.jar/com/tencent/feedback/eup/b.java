package com.tencent.feedback.eup;

import android.content.Context;
import android.os.Environment;
import com.tencent.feedback.common.c;
import com.tencent.feedback.proguard.j;
import com.tencent.feedback.proguard.l;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class b
{
  private StringBuilder a;
  private int b = 0;
  
  public b(StringBuilder paramStringBuilder, int paramInt)
  {
    this.a = paramStringBuilder;
    this.b = paramInt;
  }
  
  public static int a(Context paramContext, List paramList)
  {
    int i = 0;
    com.tencent.feedback.common.e.b("rqdp{  EUPDAO.deleteEupList() start}", new Object[0]);
    if (paramContext == null)
    {
      com.tencent.feedback.common.e.c("rqdp{  deleteEupList() have null args!}", new Object[0]);
      i = -1;
    }
    while (paramList.size() <= 0) {
      return i;
    }
    Long[] arrayOfLong = new Long[paramList.size()];
    i = 0;
    while (i < paramList.size())
    {
      arrayOfLong[i] = Long.valueOf(((e)paramList.get(i)).a());
      i += 1;
    }
    return l.a(paramContext, arrayOfLong);
  }
  
  /* Error */
  public static e a(Context paramContext, String paramString1, String paramString2, long paramLong1, Map paramMap, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, long paramLong2, String paramString9, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 45	com/tencent/feedback/eup/e
    //   3: dup
    //   4: invokespecial 61	com/tencent/feedback/eup/e:<init>	()V
    //   7: astore 18
    //   9: aload 18
    //   11: aload 6
    //   13: invokevirtual 65	com/tencent/feedback/eup/e:i	(Ljava/lang/String;)V
    //   16: aload 18
    //   18: aload 7
    //   20: invokevirtual 68	com/tencent/feedback/eup/e:j	(Ljava/lang/String;)V
    //   23: aload 18
    //   25: lload 12
    //   27: lload_3
    //   28: ladd
    //   29: invokevirtual 71	com/tencent/feedback/eup/e:b	(J)V
    //   32: aload 14
    //   34: astore 6
    //   36: aload 14
    //   38: ifnull +39 -> 77
    //   41: aload 14
    //   43: astore 6
    //   45: aload 14
    //   47: invokevirtual 76	java/lang/String:length	()I
    //   50: sipush 10000
    //   53: if_icmple +24 -> 77
    //   56: aload 14
    //   58: aload 14
    //   60: invokevirtual 76	java/lang/String:length	()I
    //   63: sipush 10000
    //   66: isub
    //   67: aload 14
    //   69: invokevirtual 76	java/lang/String:length	()I
    //   72: invokevirtual 80	java/lang/String:substring	(II)Ljava/lang/String;
    //   75: astore 6
    //   77: aload 15
    //   79: astore 7
    //   81: aload 15
    //   83: ifnull +98 -> 181
    //   86: aload 15
    //   88: astore 7
    //   90: aload 15
    //   92: arraylength
    //   93: sipush 10000
    //   96: if_icmple +85 -> 181
    //   99: sipush 10000
    //   102: newarray byte
    //   104: astore 7
    //   106: aload 7
    //   108: arraylength
    //   109: iconst_1
    //   110: isub
    //   111: istore 17
    //   113: aload 15
    //   115: arraylength
    //   116: iconst_1
    //   117: isub
    //   118: istore 16
    //   120: iload 17
    //   122: iflt +59 -> 181
    //   125: iload 16
    //   127: iflt +54 -> 181
    //   130: aload 7
    //   132: iload 17
    //   134: aload 15
    //   136: iload 16
    //   138: baload
    //   139: bastore
    //   140: iload 17
    //   142: iconst_1
    //   143: isub
    //   144: istore 17
    //   146: iload 16
    //   148: iconst_1
    //   149: isub
    //   150: istore 16
    //   152: goto -32 -> 120
    //   155: astore 7
    //   157: aload 14
    //   159: astore 6
    //   161: aload 7
    //   163: invokestatic 83	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   166: ifne -89 -> 77
    //   169: aload 7
    //   171: invokevirtual 86	java/lang/Throwable:printStackTrace	()V
    //   174: aload 14
    //   176: astore 6
    //   178: goto -101 -> 77
    //   181: aload 18
    //   183: aload 6
    //   185: invokevirtual 89	com/tencent/feedback/eup/e:k	(Ljava/lang/String;)V
    //   188: aload 18
    //   190: aload 7
    //   192: invokevirtual 92	com/tencent/feedback/eup/e:b	([B)V
    //   195: aload 18
    //   197: aload 8
    //   199: invokevirtual 94	com/tencent/feedback/eup/e:c	(Ljava/lang/String;)V
    //   202: aload 10
    //   204: ifnull +14 -> 218
    //   207: aload 10
    //   209: invokevirtual 98	java/lang/String:trim	()Ljava/lang/String;
    //   212: invokevirtual 76	java/lang/String:length	()I
    //   215: ifne +548 -> 763
    //   218: ldc 100
    //   220: astore 6
    //   222: aload 18
    //   224: aload 6
    //   226: invokevirtual 102	com/tencent/feedback/eup/e:b	(Ljava/lang/String;)V
    //   229: aload 18
    //   231: aload 9
    //   233: invokevirtual 104	com/tencent/feedback/eup/e:a	(Ljava/lang/String;)V
    //   236: aload 11
    //   238: ifnull +18 -> 256
    //   241: aload 11
    //   243: astore 6
    //   245: aload 11
    //   247: invokevirtual 98	java/lang/String:trim	()Ljava/lang/String;
    //   250: invokevirtual 76	java/lang/String:length	()I
    //   253: ifne +7 -> 260
    //   256: ldc 106
    //   258: astore 6
    //   260: aload 18
    //   262: aload 6
    //   264: invokevirtual 109	com/tencent/feedback/eup/e:d	(Ljava/lang/String;)V
    //   267: aload 18
    //   269: ldc 110
    //   271: invokevirtual 113	com/tencent/feedback/eup/e:a	(F)V
    //   274: aload_0
    //   275: invokestatic 118	com/tencent/feedback/common/d:a	(Landroid/content/Context;)Lcom/tencent/feedback/common/d;
    //   278: astore 6
    //   280: aload 18
    //   282: invokestatic 121	com/tencent/feedback/common/d:h	()J
    //   285: invokevirtual 123	com/tencent/feedback/eup/e:c	(J)V
    //   288: aload 18
    //   290: aload 6
    //   292: invokevirtual 125	com/tencent/feedback/common/d:j	()J
    //   295: invokevirtual 128	com/tencent/feedback/eup/e:e	(J)V
    //   298: aload 18
    //   300: invokestatic 131	com/tencent/feedback/common/d:f	()J
    //   303: invokevirtual 133	com/tencent/feedback/eup/e:d	(J)V
    //   306: aload 18
    //   308: invokestatic 136	com/tencent/feedback/common/d:n	()J
    //   311: invokevirtual 138	com/tencent/feedback/eup/e:i	(J)V
    //   314: aload 18
    //   316: invokestatic 141	com/tencent/feedback/common/d:o	()J
    //   319: invokevirtual 143	com/tencent/feedback/eup/e:j	(J)V
    //   322: ldc 145
    //   324: iconst_5
    //   325: anewarray 4	java/lang/Object
    //   328: dup
    //   329: iconst_0
    //   330: aload 18
    //   332: invokevirtual 148	com/tencent/feedback/eup/e:F	()J
    //   335: invokestatic 52	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   338: aastore
    //   339: dup
    //   340: iconst_1
    //   341: aload 18
    //   343: invokevirtual 151	com/tencent/feedback/eup/e:H	()J
    //   346: invokestatic 52	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   349: aastore
    //   350: dup
    //   351: iconst_2
    //   352: aload 18
    //   354: invokevirtual 154	com/tencent/feedback/eup/e:G	()J
    //   357: invokestatic 52	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   360: aastore
    //   361: dup
    //   362: iconst_3
    //   363: aload 18
    //   365: invokevirtual 157	com/tencent/feedback/eup/e:L	()J
    //   368: invokestatic 52	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   371: aastore
    //   372: dup
    //   373: iconst_4
    //   374: aload 18
    //   376: invokevirtual 160	com/tencent/feedback/eup/e:M	()J
    //   379: invokestatic 52	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   382: aastore
    //   383: invokestatic 26	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   386: pop
    //   387: aload_0
    //   388: invokestatic 165	com/tencent/feedback/common/c:a	(Landroid/content/Context;)Lcom/tencent/feedback/common/c;
    //   391: astore 6
    //   393: aload 18
    //   395: aload 6
    //   397: invokevirtual 168	com/tencent/feedback/common/c:t	()J
    //   400: invokevirtual 170	com/tencent/feedback/eup/e:f	(J)V
    //   403: aload 18
    //   405: aload 6
    //   407: invokevirtual 173	com/tencent/feedback/common/c:s	()J
    //   410: invokevirtual 176	com/tencent/feedback/eup/e:g	(J)V
    //   413: aload 18
    //   415: aload 6
    //   417: invokevirtual 179	com/tencent/feedback/common/c:u	()J
    //   420: invokevirtual 181	com/tencent/feedback/eup/e:h	(J)V
    //   423: aload 18
    //   425: aload 6
    //   427: invokevirtual 184	com/tencent/feedback/common/c:B	()Ljava/lang/String;
    //   430: invokevirtual 187	com/tencent/feedback/eup/e:r	(Ljava/lang/String;)V
    //   433: aload 18
    //   435: aload 6
    //   437: invokevirtual 190	com/tencent/feedback/common/c:z	()Ljava/lang/String;
    //   440: invokevirtual 192	com/tencent/feedback/eup/e:s	(Ljava/lang/String;)V
    //   443: ldc 194
    //   445: iconst_5
    //   446: anewarray 4	java/lang/Object
    //   449: dup
    //   450: iconst_0
    //   451: aload 18
    //   453: invokevirtual 196	com/tencent/feedback/eup/e:I	()J
    //   456: invokestatic 52	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   459: aastore
    //   460: dup
    //   461: iconst_1
    //   462: aload 18
    //   464: invokevirtual 199	com/tencent/feedback/eup/e:J	()J
    //   467: invokestatic 52	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   470: aastore
    //   471: dup
    //   472: iconst_2
    //   473: aload 18
    //   475: invokevirtual 202	com/tencent/feedback/eup/e:K	()J
    //   478: invokestatic 52	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   481: aastore
    //   482: dup
    //   483: iconst_3
    //   484: aload 18
    //   486: invokevirtual 205	com/tencent/feedback/eup/e:N	()Ljava/lang/String;
    //   489: aastore
    //   490: dup
    //   491: iconst_4
    //   492: aload 18
    //   494: invokevirtual 208	com/tencent/feedback/eup/e:O	()Ljava/lang/String;
    //   497: aastore
    //   498: invokestatic 26	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   501: pop
    //   502: aload 18
    //   504: aload_1
    //   505: invokevirtual 210	com/tencent/feedback/eup/e:e	(Ljava/lang/String;)V
    //   508: aload 18
    //   510: aload_2
    //   511: invokevirtual 213	com/tencent/feedback/eup/e:q	(Ljava/lang/String;)V
    //   514: aload 18
    //   516: aload 5
    //   518: invokevirtual 216	com/tencent/feedback/eup/e:a	(Ljava/util/Map;)V
    //   521: aload 18
    //   523: new 218	java/lang/StringBuilder
    //   526: dup
    //   527: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   530: invokestatic 223	com/tencent/feedback/proguard/a:d	()Ljava/lang/String;
    //   533: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   539: invokevirtual 233	com/tencent/feedback/eup/e:l	(Ljava/lang/String;)V
    //   542: new 218	java/lang/StringBuilder
    //   545: dup
    //   546: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   549: astore_1
    //   550: aload_0
    //   551: ldc 235
    //   553: invokestatic 238	com/tencent/feedback/proguard/a:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   556: astore_2
    //   557: aload_2
    //   558: ifnull +234 -> 792
    //   561: aload_2
    //   562: invokevirtual 98	java/lang/String:trim	()Ljava/lang/String;
    //   565: invokevirtual 76	java/lang/String:length	()I
    //   568: ifle +224 -> 792
    //   571: iconst_0
    //   572: istore 16
    //   574: iload 16
    //   576: ifne +222 -> 798
    //   579: aload_2
    //   580: ldc 240
    //   582: invokevirtual 244	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   585: ifne +213 -> 798
    //   588: new 218	java/lang/StringBuilder
    //   591: dup
    //   592: ldc 246
    //   594: invokespecial 248	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   597: aload_2
    //   598: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   604: astore_0
    //   605: aload 18
    //   607: aload_1
    //   608: aload_0
    //   609: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   615: invokevirtual 251	com/tencent/feedback/eup/e:m	(Ljava/lang/String;)V
    //   618: aload 18
    //   620: aload 18
    //   622: invokevirtual 253	com/tencent/feedback/eup/e:i	()J
    //   625: aload 6
    //   627: invokevirtual 256	com/tencent/feedback/common/c:D	()J
    //   630: lsub
    //   631: invokevirtual 258	com/tencent/feedback/eup/e:k	(J)V
    //   634: ldc_w 260
    //   637: iconst_1
    //   638: anewarray 4	java/lang/Object
    //   641: dup
    //   642: iconst_0
    //   643: aload 18
    //   645: invokevirtual 263	com/tencent/feedback/eup/e:v	()Ljava/lang/String;
    //   648: aastore
    //   649: invokestatic 26	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   652: pop
    //   653: ldc_w 265
    //   656: iconst_1
    //   657: anewarray 4	java/lang/Object
    //   660: dup
    //   661: iconst_0
    //   662: aload 18
    //   664: invokevirtual 268	com/tencent/feedback/eup/e:y	()Ljava/lang/String;
    //   667: aastore
    //   668: invokestatic 26	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   671: pop
    //   672: aload 18
    //   674: aload 6
    //   676: invokevirtual 270	com/tencent/feedback/common/c:F	()I
    //   679: invokevirtual 273	com/tencent/feedback/eup/e:c	(I)V
    //   682: aload 18
    //   684: aload 6
    //   686: invokevirtual 275	com/tencent/feedback/common/c:G	()I
    //   689: invokevirtual 277	com/tencent/feedback/eup/e:d	(I)V
    //   692: aload 18
    //   694: aload 6
    //   696: invokevirtual 280	com/tencent/feedback/common/c:H	()Ljava/util/Map;
    //   699: invokevirtual 282	com/tencent/feedback/eup/e:b	(Ljava/util/Map;)V
    //   702: aload 18
    //   704: aload 6
    //   706: invokevirtual 284	com/tencent/feedback/common/c:K	()Ljava/util/Map;
    //   709: invokevirtual 286	com/tencent/feedback/eup/e:c	(Ljava/util/Map;)V
    //   712: ldc_w 288
    //   715: iconst_1
    //   716: anewarray 4	java/lang/Object
    //   719: dup
    //   720: iconst_0
    //   721: aload 18
    //   723: invokevirtual 291	com/tencent/feedback/eup/e:R	()I
    //   726: invokestatic 296	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   729: aastore
    //   730: invokestatic 26	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   733: pop
    //   734: aload 18
    //   736: areturn
    //   737: astore 14
    //   739: aload 15
    //   741: astore 7
    //   743: aload 14
    //   745: invokestatic 83	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   748: ifne -567 -> 181
    //   751: aload 14
    //   753: invokevirtual 86	java/lang/Throwable:printStackTrace	()V
    //   756: aload 15
    //   758: astore 7
    //   760: goto -579 -> 181
    //   763: aload 10
    //   765: astore 6
    //   767: aload 10
    //   769: invokevirtual 76	java/lang/String:length	()I
    //   772: sipush 1000
    //   775: if_icmple -553 -> 222
    //   778: aload 10
    //   780: iconst_0
    //   781: sipush 1000
    //   784: invokevirtual 80	java/lang/String:substring	(II)Ljava/lang/String;
    //   787: astore 6
    //   789: goto -567 -> 222
    //   792: iconst_1
    //   793: istore 16
    //   795: goto -221 -> 574
    //   798: aload_0
    //   799: ldc_w 298
    //   802: invokestatic 238	com/tencent/feedback/proguard/a:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   805: astore_2
    //   806: aload_2
    //   807: ifnull +51 -> 858
    //   810: aload_2
    //   811: invokevirtual 98	java/lang/String:trim	()Ljava/lang/String;
    //   814: invokevirtual 76	java/lang/String:length	()I
    //   817: ifle +41 -> 858
    //   820: iconst_0
    //   821: istore 16
    //   823: iload 16
    //   825: ifne +39 -> 864
    //   828: aload_2
    //   829: ldc 240
    //   831: invokevirtual 244	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   834: ifne +30 -> 864
    //   837: new 218	java/lang/StringBuilder
    //   840: dup
    //   841: ldc_w 300
    //   844: invokespecial 248	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   847: aload_2
    //   848: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   851: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   854: astore_0
    //   855: goto -250 -> 605
    //   858: iconst_1
    //   859: istore 16
    //   861: goto -38 -> 823
    //   864: aload_0
    //   865: ldc_w 302
    //   868: invokestatic 238	com/tencent/feedback/proguard/a:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   871: astore_2
    //   872: aload_2
    //   873: ifnull +59 -> 932
    //   876: aload_2
    //   877: invokevirtual 98	java/lang/String:trim	()Ljava/lang/String;
    //   880: invokevirtual 76	java/lang/String:length	()I
    //   883: ifle +49 -> 932
    //   886: iconst_0
    //   887: istore 16
    //   889: iload 16
    //   891: ifne +47 -> 938
    //   894: aload_2
    //   895: ldc 240
    //   897: invokevirtual 244	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   900: ifne +38 -> 938
    //   903: aload_0
    //   904: ldc_w 304
    //   907: invokestatic 238	com/tencent/feedback/proguard/a:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   910: astore_0
    //   911: new 218	java/lang/StringBuilder
    //   914: dup
    //   915: ldc_w 306
    //   918: invokespecial 248	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   921: aload_0
    //   922: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   925: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   928: astore_0
    //   929: goto -324 -> 605
    //   932: iconst_1
    //   933: istore 16
    //   935: goto -46 -> 889
    //   938: aload_0
    //   939: ldc_w 308
    //   942: invokestatic 238	com/tencent/feedback/proguard/a:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   945: astore_2
    //   946: aload_2
    //   947: ifnull +67 -> 1014
    //   950: aload_2
    //   951: invokevirtual 98	java/lang/String:trim	()Ljava/lang/String;
    //   954: invokevirtual 76	java/lang/String:length	()I
    //   957: ifle +57 -> 1014
    //   960: iconst_0
    //   961: istore 16
    //   963: iload 16
    //   965: ifne +55 -> 1020
    //   968: aload_2
    //   969: ldc 240
    //   971: invokevirtual 244	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   974: ifne +46 -> 1020
    //   977: new 218	java/lang/StringBuilder
    //   980: dup
    //   981: ldc_w 310
    //   984: invokespecial 248	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   987: aload_2
    //   988: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   991: ldc_w 312
    //   994: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   997: aload_0
    //   998: ldc_w 314
    //   1001: invokestatic 238	com/tencent/feedback/proguard/a:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   1004: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1007: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1010: astore_0
    //   1011: goto -406 -> 605
    //   1014: iconst_1
    //   1015: istore 16
    //   1017: goto -54 -> 963
    //   1020: aload_0
    //   1021: ldc_w 316
    //   1024: invokestatic 238	com/tencent/feedback/proguard/a:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   1027: astore_2
    //   1028: aload_2
    //   1029: ifnull +57 -> 1086
    //   1032: aload_2
    //   1033: invokevirtual 98	java/lang/String:trim	()Ljava/lang/String;
    //   1036: invokevirtual 76	java/lang/String:length	()I
    //   1039: ifle +47 -> 1086
    //   1042: iconst_0
    //   1043: istore 16
    //   1045: iload 16
    //   1047: ifne +45 -> 1092
    //   1050: aload_2
    //   1051: ldc 240
    //   1053: invokevirtual 244	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1056: ifne +36 -> 1092
    //   1059: new 218	java/lang/StringBuilder
    //   1062: dup
    //   1063: ldc_w 318
    //   1066: invokespecial 248	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1069: aload_0
    //   1070: ldc_w 320
    //   1073: invokestatic 238	com/tencent/feedback/proguard/a:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   1076: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1079: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1082: astore_0
    //   1083: goto -478 -> 605
    //   1086: iconst_1
    //   1087: istore 16
    //   1089: goto -44 -> 1045
    //   1092: aload_0
    //   1093: ldc_w 322
    //   1096: invokestatic 238	com/tencent/feedback/proguard/a:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   1099: astore_2
    //   1100: aload_2
    //   1101: ifnull +51 -> 1152
    //   1104: aload_2
    //   1105: invokevirtual 98	java/lang/String:trim	()Ljava/lang/String;
    //   1108: invokevirtual 76	java/lang/String:length	()I
    //   1111: ifle +41 -> 1152
    //   1114: iconst_0
    //   1115: istore 16
    //   1117: iload 16
    //   1119: ifne +39 -> 1158
    //   1122: aload_2
    //   1123: ldc 240
    //   1125: invokevirtual 244	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1128: ifne +30 -> 1158
    //   1131: new 218	java/lang/StringBuilder
    //   1134: dup
    //   1135: ldc_w 324
    //   1138: invokespecial 248	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1141: aload_2
    //   1142: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1145: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1148: astore_0
    //   1149: goto -544 -> 605
    //   1152: iconst_1
    //   1153: istore 16
    //   1155: goto -38 -> 1117
    //   1158: aload_0
    //   1159: ldc_w 326
    //   1162: invokestatic 238	com/tencent/feedback/proguard/a:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   1165: astore_0
    //   1166: goto -561 -> 605
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1169	0	paramContext	Context
    //   0	1169	1	paramString1	String
    //   0	1169	2	paramString2	String
    //   0	1169	3	paramLong1	long
    //   0	1169	5	paramMap	Map
    //   0	1169	6	paramString3	String
    //   0	1169	7	paramString4	String
    //   0	1169	8	paramString5	String
    //   0	1169	9	paramString6	String
    //   0	1169	10	paramString7	String
    //   0	1169	11	paramString8	String
    //   0	1169	12	paramLong2	long
    //   0	1169	14	paramString9	String
    //   0	1169	15	paramArrayOfByte	byte[]
    //   118	1036	16	i	int
    //   111	34	17	j	int
    //   7	728	18	locale	e
    // Exception table:
    //   from	to	target	type
    //   56	77	155	java/lang/Throwable
    //   99	120	737	java/lang/Throwable
  }
  
  protected static l a(e parame)
  {
    if (parame == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        if (parame.P() != 1)
        {
          i = 1;
          l locall = new l(i, 0, parame.i(), com.tencent.feedback.proguard.a.a(parame));
          locall.b(parame.j());
          locall.a(parame.m());
          locall.a(parame.o());
          locall.a(parame.a());
          if (!parame.w()) {
            break label106;
          }
          i = 1;
          locall.c(i);
          return locall;
        }
      }
      catch (Throwable parame)
      {
        if (!com.tencent.feedback.common.e.a(parame)) {
          parame.printStackTrace();
        }
        return null;
      }
      int i = 2;
      continue;
      label106:
      i = 0;
    }
  }
  
  protected static String a(Throwable paramThrowable, CrashStrategyBean paramCrashStrategyBean)
  {
    int i = 100;
    int j = 3;
    if (paramCrashStrategyBean != null)
    {
      j = Math.max(3, paramCrashStrategyBean.getMaxStackFrame());
      i = Math.max(100, paramCrashStrategyBean.getMaxStackLine());
      com.tencent.feedback.common.e.b("change frame:%d  line:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
    }
    paramCrashStrategyBean = new ArrayList();
    a(paramCrashStrategyBean, paramThrowable, 0, j, i);
    if (paramCrashStrategyBean.size() > 0)
    {
      paramThrowable = new StringBuilder(paramCrashStrategyBean.size());
      paramCrashStrategyBean = paramCrashStrategyBean.iterator();
      while (paramCrashStrategyBean.hasNext()) {
        paramThrowable.append((String)paramCrashStrategyBean.next()).append("\n");
      }
      return paramThrowable.toString();
    }
    return "";
  }
  
  public static List a(Context paramContext, int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong1, long paramLong2, Boolean paramBoolean)
  {
    com.tencent.feedback.common.e.b("rqdp{  EUPDAO.queryEupRecent() start}", new Object[0]);
    if ((paramContext == null) || (paramInt1 == 0) || ((paramLong2 > 0L) && (paramLong1 > paramLong2)) || ((paramInt4 > 0) && (paramInt3 > paramInt4)))
    {
      com.tencent.feedback.common.e.c("rqdp{  context == null || limitNum == 0 || (timeEnd > 0 && timeStart > timeEnd) || (maxCount > 0 && miniCount > maxCount ,pls check}", new Object[0]);
      return null;
    }
    int i;
    if ("asc".equals(paramString1))
    {
      i = 1;
      paramString1 = null;
      if (paramInt2 != 2) {
        break label143;
      }
      paramString1 = new int[1];
      paramString1[0] = 2;
      label87:
      if (paramBoolean != null) {
        break label194;
      }
      paramInt2 = -1;
    }
    for (;;)
    {
      paramString1 = l.a(paramContext, paramString1, -1, i, -1L, paramInt1, paramString2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong1, paramLong2, paramInt2);
      if ((paramString1 != null) && (paramString1.size() > 0)) {
        break label212;
      }
      return null;
      i = 2;
      break;
      label143:
      if (paramInt2 == 1)
      {
        paramString1 = new int[1];
        paramString1[0] = 1;
        break label87;
      }
      if (paramInt2 < 0)
      {
        paramString1 = new int[2];
        String tmp168_167 = paramString1;
        tmp168_167[0] = 1;
        String tmp172_168 = tmp168_167;
        tmp172_168[1] = 2;
        tmp172_168;
        break label87;
      }
      com.tencent.feedback.common.e.c("rqdp{  queryEupRecent() seletedRecordType unaccepted}", new Object[0]);
      break label87;
      label194:
      if (paramBoolean.booleanValue()) {
        paramInt2 = 1;
      } else {
        paramInt2 = 0;
      }
    }
    label212:
    paramString2 = new ArrayList();
    paramBoolean = paramString1.iterator();
    while (paramBoolean.hasNext())
    {
      l locall = (l)paramBoolean.next();
      try
      {
        Object localObject = com.tencent.feedback.proguard.a.b(locall.b());
        if ((localObject != null) && (e.class.isInstance(localObject)))
        {
          localObject = (e)e.class.cast(localObject);
          ((e)localObject).a(locall.a());
          paramString2.add(localObject);
          paramBoolean.remove();
        }
      }
      catch (Throwable localThrowable)
      {
        if (!com.tencent.feedback.common.e.a(localThrowable)) {
          localThrowable.printStackTrace();
        }
        com.tencent.feedback.common.e.d("rqdp{  query have error!}", new Object[0]);
      }
    }
    if (paramString1.size() > 0)
    {
      com.tencent.feedback.common.e.b("rqdp{  there are error datas ,should be remove }" + paramString1.size(), new Object[0]);
      paramBoolean = new Long[paramString1.size()];
      paramInt1 = 0;
      while (paramInt1 < paramString1.size())
      {
        paramBoolean[paramInt1] = Long.valueOf(((l)paramString1.get(paramInt1)).a());
        paramInt1 += 1;
      }
      l.a(paramContext, paramBoolean);
    }
    com.tencent.feedback.common.e.b("rqdp{  EUPDAO.queryEupRecent() end}", new Object[0]);
    return paramString2;
  }
  
  private void a(String paramString)
  {
    int i = 0;
    while (i < this.b)
    {
      this.a.append('\t');
      i += 1;
    }
    if (paramString != null) {
      this.a.append(paramString).append(": ");
    }
  }
  
  private static void a(ArrayList paramArrayList, Throwable paramThrowable, int paramInt1, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      if ((paramArrayList == null) || (paramThrowable == null) || (paramInt1 > paramInt2) || (paramArrayList.size() > paramInt3)) {}
      int i;
      do
      {
        return;
        i = paramInt1 + 1;
        StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
        if (arrayOfStackTraceElement != null)
        {
          int j = arrayOfStackTraceElement.length;
          paramInt1 = 0;
          while (paramInt1 < j)
          {
            paramArrayList.add(arrayOfStackTraceElement[paramInt1].toString());
            paramInt1 += 1;
          }
        }
      } while (paramThrowable.getCause() == null);
      paramArrayList.add("cause by:");
      paramArrayList.add(paramThrowable.getCause().getClass().getName() + ": " + paramThrowable.getCause().getMessage());
      paramThrowable = paramThrowable.getCause();
      paramInt1 = i;
    }
  }
  
  public static boolean a(Context paramContext)
  {
    if (com.tencent.feedback.proguard.a.c() < 0L)
    {
      com.tencent.feedback.common.e.d("rqdp{  today fail?}", new Object[0]);
      new Date().getTime();
    }
    paramContext = g.a(paramContext).a(paramContext, 1);
    return (paramContext != null) && (paramContext.size() > 0);
  }
  
  public static boolean a(Context paramContext, e parame)
  {
    com.tencent.feedback.common.e.b("rqdp{  EUPDAO.insertEUP() start}", new Object[0]);
    if ((paramContext == null) || (parame == null))
    {
      com.tencent.feedback.common.e.c("rqdp{  EUPDAO.insertEUP() have null args}", new Object[0]);
      return false;
    }
    try
    {
      l locall = a(parame);
      if ((paramContext == null) || (locall == null)) {
        com.tencent.feedback.common.e.a("rqdp{  AnalyticsDAO.insert() have null args}", new Object[0]);
      }
      ArrayList localArrayList;
      for (boolean bool = false; bool; bool = l.a(paramContext, localArrayList))
      {
        parame.a(locall.a());
        return true;
        localArrayList = new ArrayList();
        localArrayList.add(locall);
      }
      return false;
    }
    catch (Throwable paramContext)
    {
      if (!com.tencent.feedback.common.e.a(paramContext)) {
        paramContext.printStackTrace();
      }
      com.tencent.feedback.common.e.d("rqdp{  insert fail!}", new Object[0]);
      return false;
    }
    finally
    {
      com.tencent.feedback.common.e.b("rqdp{  EUPDAO.insertEUP() end}", new Object[0]);
    }
  }
  
  protected static boolean a(Context paramContext, e parame, CrashStrategyBean paramCrashStrategyBean)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramCrashStrategyBean != null)
    {
      bool1 = bool2;
      if (paramCrashStrategyBean.isStoreCrashSdcard()) {
        try
        {
          com.tencent.feedback.common.e.b("save eup logs", new Object[0]);
          localObject = c.a(paramContext);
          String str1 = ((c)localObject).b();
          String str2 = ((c)localObject).B();
          String str3 = parame.q();
          Locale localLocale = Locale.US;
          String str4 = ((c)localObject).c();
          localObject = new Date(parame.i());
          if (localObject == null) {}
          for (localObject = null;; localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format((Date)localObject))
          {
            localObject = String.format(localLocale, "#--------\npackage:%s\nversion:%s\nsdk:%s\nprocess:%s\ndate:%s\ntype:%s\nmessage:%s\nstack:\n%s\neupID:%s\n", new Object[] { str1, str2, str4, str3, localObject, parame.e(), parame.f(), parame.h(), parame.v() });
            if (paramCrashStrategyBean.getStoreDirectoryPath() != null) {
              break label344;
            }
            if (com.tencent.feedback.common.a.f(paramContext)) {
              break;
            }
            return false;
          }
          int i = paramCrashStrategyBean.getCrashSdcardMaxSize();
          com.tencent.feedback.common.e.b("rqdp{  sv sd start}", new Object[0]);
          if ((localObject == null) || (((String)localObject).trim().length() <= 0)) {
            break label399;
          }
          if (Environment.getExternalStorageState().equals("mounted")) {
            com.tencent.feedback.proguard.a.a(new File(Environment.getExternalStorageDirectory(), "/Tencent/" + com.tencent.feedback.common.a.b(paramContext) + "/euplog.txt").getAbsolutePath(), (String)localObject, i);
          }
          com.tencent.feedback.common.e.b("rqdp{  sv sd end}", new Object[0]);
        }
        catch (Throwable paramContext)
        {
          Object localObject;
          com.tencent.feedback.common.e.c("rqdp{  save error} %s", new Object[] { paramContext.toString() });
          bool1 = bool2;
          if (!com.tencent.feedback.common.e.a(paramContext))
          {
            paramContext.printStackTrace();
            return false;
            label344:
            parame = new File(paramCrashStrategyBean.getStoreDirectoryPath());
            paramContext = parame;
            if (!parame.isFile()) {
              paramContext = parame.getParentFile();
            }
            com.tencent.feedback.proguard.a.a(new File(paramContext, "euplog.txt").getAbsolutePath(), (String)localObject, paramCrashStrategyBean.getCrashSdcardMaxSize());
            bool1 = true;
          }
        }
      }
    }
    return bool1;
    label399:
    return true;
  }
  
  public static int b(Context paramContext)
  {
    com.tencent.feedback.common.e.b("rqdp{  EUPDAO.querySum() start}", new Object[0]);
    if (paramContext == null)
    {
      com.tencent.feedback.common.e.c("rqdp{  querySum() context is null arg}", new Object[0]);
      return -1;
    }
    return l.a(paramContext, new int[] { 2, 1 }, -1L, 9223372036854775807L, null);
  }
  
  /* Error */
  public static boolean b(Context paramContext, List paramList)
  {
    // Byte code:
    //   0: ldc_w 632
    //   3: iconst_0
    //   4: anewarray 4	java/lang/Object
    //   7: invokestatic 26	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   10: pop
    //   11: aload_0
    //   12: ifnull +16 -> 28
    //   15: aload_1
    //   16: ifnull +12 -> 28
    //   19: aload_1
    //   20: invokeinterface 37 1 0
    //   25: ifgt +16 -> 41
    //   28: ldc_w 634
    //   31: iconst_0
    //   32: anewarray 4	java/lang/Object
    //   35: invokestatic 31	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   38: pop
    //   39: iconst_0
    //   40: ireturn
    //   41: new 379	java/util/ArrayList
    //   44: dup
    //   45: invokespecial 380	java/util/ArrayList:<init>	()V
    //   48: astore_3
    //   49: aload_1
    //   50: invokeinterface 423 1 0
    //   55: astore_1
    //   56: aload_1
    //   57: invokeinterface 395 1 0
    //   62: ifeq +68 -> 130
    //   65: aload_1
    //   66: invokeinterface 399 1 0
    //   71: checkcast 45	com/tencent/feedback/eup/e
    //   74: invokestatic 512	com/tencent/feedback/eup/b:a	(Lcom/tencent/feedback/eup/e;)Lcom/tencent/feedback/proguard/l;
    //   77: astore 4
    //   79: aload 4
    //   81: ifnull -25 -> 56
    //   84: aload_3
    //   85: aload 4
    //   87: invokevirtual 444	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   90: pop
    //   91: goto -35 -> 56
    //   94: astore_0
    //   95: aload_0
    //   96: invokestatic 83	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   99: ifne +7 -> 106
    //   102: aload_0
    //   103: invokevirtual 86	java/lang/Throwable:printStackTrace	()V
    //   106: ldc_w 523
    //   109: iconst_0
    //   110: anewarray 4	java/lang/Object
    //   113: invokestatic 451	com/tencent/feedback/common/e:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   116: pop
    //   117: ldc_w 636
    //   120: iconst_0
    //   121: anewarray 4	java/lang/Object
    //   124: invokestatic 26	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   127: pop
    //   128: iconst_0
    //   129: ireturn
    //   130: aload_0
    //   131: aload_3
    //   132: invokestatic 638	com/tencent/feedback/proguard/l:b	(Landroid/content/Context;Ljava/util/List;)Z
    //   135: istore_2
    //   136: ldc_w 636
    //   139: iconst_0
    //   140: anewarray 4	java/lang/Object
    //   143: invokestatic 26	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   146: pop
    //   147: iload_2
    //   148: ireturn
    //   149: astore_0
    //   150: ldc_w 636
    //   153: iconst_0
    //   154: anewarray 4	java/lang/Object
    //   157: invokestatic 26	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   160: pop
    //   161: aload_0
    //   162: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	paramContext	Context
    //   0	163	1	paramList	List
    //   135	13	2	bool	boolean
    //   48	84	3	localArrayList	ArrayList
    //   77	9	4	locall	l
    // Exception table:
    //   from	to	target	type
    //   41	56	94	java/lang/Throwable
    //   56	79	94	java/lang/Throwable
    //   84	91	94	java/lang/Throwable
    //   130	136	94	java/lang/Throwable
    //   41	56	149	finally
    //   56	79	149	finally
    //   84	91	149	finally
    //   95	106	149	finally
    //   106	117	149	finally
    //   130	136	149	finally
  }
  
  public b a(byte paramByte, String paramString)
  {
    a(paramString);
    this.a.append(paramByte).append('\n');
    return this;
  }
  
  public b a(char paramChar, String paramString)
  {
    a(paramString);
    this.a.append(paramChar).append('\n');
    return this;
  }
  
  public b a(double paramDouble, String paramString)
  {
    a(paramString);
    this.a.append(paramDouble).append('\n');
    return this;
  }
  
  public b a(float paramFloat, String paramString)
  {
    a(paramString);
    this.a.append(paramFloat).append('\n');
    return this;
  }
  
  public b a(int paramInt, String paramString)
  {
    a(paramString);
    this.a.append(paramInt).append('\n');
    return this;
  }
  
  public b a(long paramLong, String paramString)
  {
    a(paramString);
    this.a.append(paramLong).append('\n');
    return this;
  }
  
  public b a(j paramj, String paramString)
  {
    a('{', paramString);
    if (paramj == null) {
      this.a.append('\t').append("null");
    }
    for (;;)
    {
      a('}', null);
      return this;
      paramj.a(this.a, this.b + 1);
    }
  }
  
  public b a(Object paramObject, String paramString)
  {
    if (paramObject == null)
    {
      this.a.append("null\n");
      return this;
    }
    if ((paramObject instanceof Byte))
    {
      a(((Byte)paramObject).byteValue(), paramString);
      return this;
    }
    if ((paramObject instanceof Boolean))
    {
      a(((Boolean)paramObject).booleanValue(), paramString);
      return this;
    }
    if ((paramObject instanceof Short))
    {
      a(((Short)paramObject).shortValue(), paramString);
      return this;
    }
    if ((paramObject instanceof Integer))
    {
      a(((Integer)paramObject).intValue(), paramString);
      return this;
    }
    if ((paramObject instanceof Long))
    {
      a(((Long)paramObject).longValue(), paramString);
      return this;
    }
    if ((paramObject instanceof Float))
    {
      a(((Float)paramObject).floatValue(), paramString);
      return this;
    }
    if ((paramObject instanceof Double))
    {
      a(((Double)paramObject).doubleValue(), paramString);
      return this;
    }
    if ((paramObject instanceof String))
    {
      a((String)paramObject, paramString);
      return this;
    }
    if ((paramObject instanceof Map))
    {
      a((Map)paramObject, paramString);
      return this;
    }
    if ((paramObject instanceof List))
    {
      a((List)paramObject, paramString);
      return this;
    }
    if ((paramObject instanceof j))
    {
      a((j)paramObject, paramString);
      return this;
    }
    if ((paramObject instanceof byte[]))
    {
      a((byte[])paramObject, paramString);
      return this;
    }
    if ((paramObject instanceof boolean[]))
    {
      a((boolean[])paramObject, paramString);
      return this;
    }
    if ((paramObject instanceof short[]))
    {
      a((short[])paramObject, paramString);
      return this;
    }
    if ((paramObject instanceof int[]))
    {
      a((int[])paramObject, paramString);
      return this;
    }
    if ((paramObject instanceof long[]))
    {
      a((long[])paramObject, paramString);
      return this;
    }
    if ((paramObject instanceof float[]))
    {
      a((float[])paramObject, paramString);
      return this;
    }
    if ((paramObject instanceof double[]))
    {
      a((double[])paramObject, paramString);
      return this;
    }
    if (paramObject.getClass().isArray())
    {
      a((Object[])paramObject, paramString);
      return this;
    }
    throw new com.tencent.feedback.proguard.b("write object error: unsupport type.");
  }
  
  public b a(String paramString1, String paramString2)
  {
    a(paramString2);
    if (paramString1 == null)
    {
      this.a.append("null\n");
      return this;
    }
    this.a.append(paramString1).append('\n');
    return this;
  }
  
  public b a(Collection paramCollection, String paramString)
  {
    if (paramCollection == null)
    {
      a(paramString);
      this.a.append("null\t");
      return this;
    }
    return a(paramCollection.toArray(), paramString);
  }
  
  public b a(Map paramMap, String paramString)
  {
    a(paramString);
    if (paramMap == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramMap.isEmpty())
    {
      this.a.append(paramMap.size()).append(", {}\n");
      return this;
    }
    this.a.append(paramMap.size()).append(", {\n");
    paramString = new b(this.a, this.b + 1);
    b localb = new b(this.a, this.b + 2);
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      paramString.a('(', null);
      localb.a(localEntry.getKey(), null);
      localb.a(localEntry.getValue(), null);
      paramString.a(')', null);
    }
    a('}', null);
    return this;
  }
  
  public b a(short paramShort, String paramString)
  {
    a(paramString);
    this.a.append(paramShort).append('\n');
    return this;
  }
  
  public b a(boolean paramBoolean, String paramString)
  {
    a(paramString);
    paramString = this.a;
    if (paramBoolean) {}
    for (char c = 'T';; c = 'F')
    {
      paramString.append(c).append('\n');
      return this;
    }
  }
  
  public b a(byte[] paramArrayOfByte, String paramString)
  {
    a(paramString);
    if (paramArrayOfByte == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfByte.length == 0)
    {
      this.a.append(paramArrayOfByte.length).append(", []\n");
      return this;
    }
    this.a.append(paramArrayOfByte.length).append(", [\n");
    paramString = new b(this.a, this.b + 1);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfByte[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  public b a(double[] paramArrayOfDouble, String paramString)
  {
    a(paramString);
    if (paramArrayOfDouble == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfDouble.length == 0)
    {
      this.a.append(paramArrayOfDouble.length).append(", []\n");
      return this;
    }
    this.a.append(paramArrayOfDouble.length).append(", [\n");
    paramString = new b(this.a, this.b + 1);
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfDouble[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  public b a(float[] paramArrayOfFloat, String paramString)
  {
    a(paramString);
    if (paramArrayOfFloat == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfFloat.length == 0)
    {
      this.a.append(paramArrayOfFloat.length).append(", []\n");
      return this;
    }
    this.a.append(paramArrayOfFloat.length).append(", [\n");
    paramString = new b(this.a, this.b + 1);
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfFloat[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  public b a(int[] paramArrayOfInt, String paramString)
  {
    a(paramString);
    if (paramArrayOfInt == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfInt.length == 0)
    {
      this.a.append(paramArrayOfInt.length).append(", []\n");
      return this;
    }
    this.a.append(paramArrayOfInt.length).append(", [\n");
    paramString = new b(this.a, this.b + 1);
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfInt[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  public b a(long[] paramArrayOfLong, String paramString)
  {
    a(paramString);
    if (paramArrayOfLong == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfLong.length == 0)
    {
      this.a.append(paramArrayOfLong.length).append(", []\n");
      return this;
    }
    this.a.append(paramArrayOfLong.length).append(", [\n");
    paramString = new b(this.a, this.b + 1);
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfLong[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  public b a(Object[] paramArrayOfObject, String paramString)
  {
    a(paramString);
    if (paramArrayOfObject == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfObject.length == 0)
    {
      this.a.append(paramArrayOfObject.length).append(", []\n");
      return this;
    }
    this.a.append(paramArrayOfObject.length).append(", [\n");
    paramString = new b(this.a, this.b + 1);
    int j = paramArrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfObject[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  public b a(short[] paramArrayOfShort, String paramString)
  {
    a(paramString);
    if (paramArrayOfShort == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfShort.length == 0)
    {
      this.a.append(paramArrayOfShort.length).append(", []\n");
      return this;
    }
    this.a.append(paramArrayOfShort.length).append(", [\n");
    paramString = new b(this.a, this.b + 1);
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfShort[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.eup.b
 * JD-Core Version:    0.7.0.1
 */