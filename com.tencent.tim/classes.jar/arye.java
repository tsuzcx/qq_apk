import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.business.viareport.ReportManager.1;
import com.tencent.open.business.viareport.ReportManager.2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimeZone;

public class arye
{
  protected static arye a;
  protected ArrayList<arya> DB = new ArrayList();
  protected ArrayList<arya> DC = new ArrayList();
  protected String cDr = "";
  public volatile boolean isUploading;
  
  private void Uo(boolean paramBoolean)
  {
    String str = String.valueOf(aroi.a().getUin());
    if (sw(str)) {
      ThreadManager.executeOnNetWorkThread(new ReportManager.2(this, str, paramBoolean));
    }
  }
  
  public static arye a()
  {
    try
    {
      if (a == null) {
        a = new arye();
      }
      arye localarye = a;
      return localarye;
    }
    finally {}
  }
  
  /* Error */
  private void a(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: invokestatic 87	aryc:Nk	()I
    //   3: istore 9
    //   5: ldc 89
    //   7: new 91	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   14: ldc 94
    //   16: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: iload 9
    //   21: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   24: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokestatic 111	arwt:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: iconst_0
    //   31: istore 7
    //   33: iconst_0
    //   34: istore 6
    //   36: invokestatic 116	android/os/SystemClock:elapsedRealtime	()J
    //   39: lstore 16
    //   41: lconst_0
    //   42: lstore 12
    //   44: lconst_0
    //   45: lstore 18
    //   47: iconst_0
    //   48: istore 10
    //   50: iload 7
    //   52: iconst_1
    //   53: iadd
    //   54: istore 8
    //   56: lload 12
    //   58: lstore 20
    //   60: aload_1
    //   61: aload_2
    //   62: aload_3
    //   63: invokestatic 121	com/tencent/open/base/http/HttpBaseUtil:a	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Lcom/tencent/open/base/http/HttpBaseUtil$c;
    //   66: astore 24
    //   68: lload 12
    //   70: lstore 20
    //   72: aload 24
    //   74: getfield 126	com/tencent/open/base/http/HttpBaseUtil$c:response	Ljava/lang/String;
    //   77: invokestatic 130	com/tencent/open/base/http/HttpBaseUtil:D	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   80: astore 25
    //   82: lload 12
    //   84: lstore 20
    //   86: aload 25
    //   88: ldc 132
    //   90: invokevirtual 138	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   93: istore 7
    //   95: iload 7
    //   97: ifeq +22 -> 119
    //   100: lload 12
    //   102: lstore 20
    //   104: aload 24
    //   106: getfield 126	com/tencent/open/base/http/HttpBaseUtil$c:response	Ljava/lang/String;
    //   109: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   112: istore 11
    //   114: iload 11
    //   116: ifne +933 -> 1049
    //   119: iconst_1
    //   120: istore 7
    //   122: iload 9
    //   124: istore 6
    //   126: lload 12
    //   128: lstore 20
    //   130: lload 12
    //   132: lstore 14
    //   134: aload 24
    //   136: getfield 148	com/tencent/open/base/http/HttpBaseUtil$c:reqSize	J
    //   139: lstore 12
    //   141: lload 12
    //   143: lstore 20
    //   145: lload 12
    //   147: lstore 14
    //   149: aload 24
    //   151: getfield 151	com/tencent/open/base/http/HttpBaseUtil$c:awI	J
    //   154: lstore 22
    //   156: iload 10
    //   158: istore 8
    //   160: lload 22
    //   162: lstore 14
    //   164: iload 6
    //   166: iload 9
    //   168: if_icmplt +858 -> 1026
    //   171: ldc 89
    //   173: new 91	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   180: ldc 153
    //   182: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: lload 16
    //   187: invokevirtual 156	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   190: ldc 158
    //   192: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: lload 12
    //   197: invokevirtual 156	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   200: ldc 158
    //   202: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: lload 14
    //   207: invokevirtual 156	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   210: ldc 158
    //   212: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: iload 8
    //   217: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   220: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 161	arwt:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   226: aload_0
    //   227: iload 8
    //   229: invokevirtual 165	arye:mP	(I)Z
    //   232: ifeq +30 -> 262
    //   235: invokestatic 170	arxy:a	()Larxy;
    //   238: ldc 172
    //   240: lload 16
    //   242: lload 12
    //   244: lload 14
    //   246: iload 8
    //   248: invokestatic 37	aroi:a	()Laroi;
    //   251: invokevirtual 41	aroi:getUin	()J
    //   254: ldc 174
    //   256: aconst_null
    //   257: iload 5
    //   259: invokevirtual 178	arxy:b	(Ljava/lang/String;JJJIJLjava/lang/String;Ljava/lang/String;Z)V
    //   262: iload 7
    //   264: iconst_1
    //   265: if_icmpne +695 -> 960
    //   268: ldc 180
    //   270: ldc 182
    //   272: invokestatic 111	arwt:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   275: iload 4
    //   277: ifeq +26 -> 303
    //   280: ldc 89
    //   282: ldc 184
    //   284: invokestatic 111	arwt:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   287: aload_0
    //   288: iconst_0
    //   289: putfield 186	arye:isUploading	Z
    //   292: iload 7
    //   294: ifeq +9 -> 303
    //   297: aload_0
    //   298: iload 5
    //   300: invokespecial 188	arye:Uo	(Z)V
    //   303: return
    //   304: astore 25
    //   306: bipush 252
    //   308: istore 7
    //   310: goto -215 -> 95
    //   313: astore 24
    //   315: iload 6
    //   317: istore 7
    //   319: iload 8
    //   321: istore 6
    //   323: invokestatic 116	android/os/SystemClock:elapsedRealtime	()J
    //   326: lstore 16
    //   328: lconst_0
    //   329: lstore 12
    //   331: lconst_0
    //   332: lstore 14
    //   334: bipush 249
    //   336: istore 8
    //   338: ldc 89
    //   340: new 91	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   347: ldc 190
    //   349: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: aload 24
    //   354: invokevirtual 191	org/apache/http/conn/ConnectTimeoutException:toString	()Ljava/lang/String;
    //   357: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: invokestatic 194	arwt:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   366: goto -202 -> 164
    //   369: astore 24
    //   371: iload 6
    //   373: istore 7
    //   375: iload 8
    //   377: istore 6
    //   379: invokestatic 116	android/os/SystemClock:elapsedRealtime	()J
    //   382: lstore 16
    //   384: lconst_0
    //   385: lstore 12
    //   387: lconst_0
    //   388: lstore 14
    //   390: bipush 248
    //   392: istore 8
    //   394: ldc 89
    //   396: new 91	java/lang/StringBuilder
    //   399: dup
    //   400: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   403: ldc 190
    //   405: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: aload 24
    //   410: invokevirtual 195	java/net/SocketTimeoutException:toString	()Ljava/lang/String;
    //   413: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: invokestatic 194	arwt:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   422: goto -258 -> 164
    //   425: astore 24
    //   427: iload 6
    //   429: istore 7
    //   431: iload 8
    //   433: istore 6
    //   435: lconst_0
    //   436: lstore 12
    //   438: lconst_0
    //   439: lstore 14
    //   441: bipush 252
    //   443: istore 8
    //   445: ldc 89
    //   447: new 91	java/lang/StringBuilder
    //   450: dup
    //   451: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   454: ldc 190
    //   456: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: aload 24
    //   461: invokevirtual 196	org/json/JSONException:toString	()Ljava/lang/String;
    //   464: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   470: invokestatic 194	arwt:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   473: goto -309 -> 164
    //   476: astore_1
    //   477: ldc 89
    //   479: new 91	java/lang/StringBuilder
    //   482: dup
    //   483: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   486: ldc 190
    //   488: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: aload_1
    //   492: invokevirtual 197	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException:toString	()Ljava/lang/String;
    //   495: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   501: invokestatic 194	arwt:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   504: aload_0
    //   505: iconst_0
    //   506: putfield 186	arye:isUploading	Z
    //   509: return
    //   510: astore_1
    //   511: aload_1
    //   512: invokevirtual 200	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException:getMessage	()Ljava/lang/String;
    //   515: ldc 202
    //   517: ldc 20
    //   519: invokevirtual 206	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   522: invokestatic 211	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   525: istore 6
    //   527: aload_0
    //   528: iload 6
    //   530: invokevirtual 165	arye:mP	(I)Z
    //   533: ifeq +30 -> 563
    //   536: invokestatic 170	arxy:a	()Larxy;
    //   539: ldc 172
    //   541: lload 16
    //   543: lload 20
    //   545: lload 18
    //   547: iload 6
    //   549: invokestatic 37	aroi:a	()Laroi;
    //   552: invokevirtual 41	aroi:getUin	()J
    //   555: ldc 174
    //   557: aconst_null
    //   558: iload 5
    //   560: invokevirtual 178	arxy:b	(Ljava/lang/String;JJJIJLjava/lang/String;Ljava/lang/String;Z)V
    //   563: ldc 89
    //   565: new 91	java/lang/StringBuilder
    //   568: dup
    //   569: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   572: ldc 190
    //   574: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: aload_1
    //   578: invokevirtual 212	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException:toString	()Ljava/lang/String;
    //   581: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   587: invokestatic 194	arwt:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   590: aload_0
    //   591: iconst_0
    //   592: putfield 186	arye:isUploading	Z
    //   595: return
    //   596: astore_2
    //   597: ldc 89
    //   599: new 91	java/lang/StringBuilder
    //   602: dup
    //   603: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   606: ldc 190
    //   608: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: aload_1
    //   612: invokevirtual 212	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException:toString	()Ljava/lang/String;
    //   615: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   621: invokestatic 194	arwt:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   624: goto -61 -> 563
    //   627: astore 24
    //   629: iload 6
    //   631: istore 7
    //   633: iload 8
    //   635: istore 6
    //   637: lconst_0
    //   638: lstore 12
    //   640: lconst_0
    //   641: lstore 14
    //   643: aload 24
    //   645: invokestatic 217	arxh:a	(Ljava/io/IOException;)I
    //   648: istore 8
    //   650: ldc 89
    //   652: new 91	java/lang/StringBuilder
    //   655: dup
    //   656: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   659: ldc 190
    //   661: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: aload 24
    //   666: invokevirtual 218	java/io/IOException:toString	()Ljava/lang/String;
    //   669: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   675: invokestatic 194	arwt:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   678: goto -514 -> 164
    //   681: astore 24
    //   683: iload 6
    //   685: istore 7
    //   687: iload 8
    //   689: istore 6
    //   691: aload 24
    //   693: instanceof 75
    //   696: ifeq +37 -> 733
    //   699: ldc 89
    //   701: new 91	java/lang/StringBuilder
    //   704: dup
    //   705: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   708: ldc 190
    //   710: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: aload 24
    //   715: invokevirtual 219	java/lang/Exception:toString	()Ljava/lang/String;
    //   718: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   724: invokestatic 194	arwt:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   727: aload_0
    //   728: iconst_0
    //   729: putfield 186	arye:isUploading	Z
    //   732: return
    //   733: aload 24
    //   735: instanceof 77
    //   738: ifeq +122 -> 860
    //   741: aload 24
    //   743: invokevirtual 220	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   746: ldc 202
    //   748: ldc 20
    //   750: invokevirtual 206	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   753: invokestatic 211	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   756: istore 6
    //   758: aload_0
    //   759: iload 6
    //   761: invokevirtual 165	arye:mP	(I)Z
    //   764: ifeq +30 -> 794
    //   767: invokestatic 170	arxy:a	()Larxy;
    //   770: ldc 172
    //   772: lload 16
    //   774: lload 12
    //   776: lload 18
    //   778: iload 6
    //   780: invokestatic 37	aroi:a	()Laroi;
    //   783: invokevirtual 41	aroi:getUin	()J
    //   786: ldc 174
    //   788: aconst_null
    //   789: iload 5
    //   791: invokevirtual 178	arxy:b	(Ljava/lang/String;JJJIJLjava/lang/String;Ljava/lang/String;Z)V
    //   794: ldc 89
    //   796: new 91	java/lang/StringBuilder
    //   799: dup
    //   800: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   803: ldc 190
    //   805: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: aload 24
    //   810: invokevirtual 219	java/lang/Exception:toString	()Ljava/lang/String;
    //   813: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   819: invokestatic 194	arwt:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   822: aload_0
    //   823: iconst_0
    //   824: putfield 186	arye:isUploading	Z
    //   827: return
    //   828: astore_1
    //   829: ldc 89
    //   831: new 91	java/lang/StringBuilder
    //   834: dup
    //   835: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   838: ldc 190
    //   840: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   843: aload 24
    //   845: invokevirtual 219	java/lang/Exception:toString	()Ljava/lang/String;
    //   848: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   851: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   854: invokestatic 194	arwt:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   857: goto -63 -> 794
    //   860: aload 24
    //   862: instanceof 79
    //   865: ifeq +50 -> 915
    //   868: lconst_0
    //   869: lstore 12
    //   871: lconst_0
    //   872: lstore 14
    //   874: aload 24
    //   876: checkcast 79	java/io/IOException
    //   879: invokestatic 217	arxh:a	(Ljava/io/IOException;)I
    //   882: istore 8
    //   884: ldc 89
    //   886: new 91	java/lang/StringBuilder
    //   889: dup
    //   890: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   893: ldc 190
    //   895: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   898: aload 24
    //   900: invokevirtual 219	java/lang/Exception:toString	()Ljava/lang/String;
    //   903: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   906: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   909: invokestatic 194	arwt:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   912: goto -748 -> 164
    //   915: lconst_0
    //   916: lstore 12
    //   918: lconst_0
    //   919: lstore 14
    //   921: bipush 250
    //   923: istore 8
    //   925: ldc 89
    //   927: new 91	java/lang/StringBuilder
    //   930: dup
    //   931: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   934: ldc 190
    //   936: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   939: aload 24
    //   941: invokevirtual 219	java/lang/Exception:toString	()Ljava/lang/String;
    //   944: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   947: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   950: invokestatic 194	arwt:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   953: iload 9
    //   955: istore 6
    //   957: goto -793 -> 164
    //   960: ldc 180
    //   962: ldc 222
    //   964: invokestatic 111	arwt:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   967: iload 4
    //   969: ifeq -694 -> 275
    //   972: invokestatic 227	aryd:a	()Laryd;
    //   975: aload_0
    //   976: getfield 29	arye:DC	Ljava/util/ArrayList;
    //   979: invokevirtual 231	aryd:x	(Ljava/util/ArrayList;)I
    //   982: pop
    //   983: invokestatic 227	aryd:a	()Laryd;
    //   986: aload_0
    //   987: getfield 27	arye:DB	Ljava/util/ArrayList;
    //   990: invokevirtual 231	aryd:x	(Ljava/util/ArrayList;)I
    //   993: pop
    //   994: goto -719 -> 275
    //   997: astore 24
    //   999: lload 14
    //   1001: lstore 12
    //   1003: goto -312 -> 691
    //   1006: astore 24
    //   1008: goto -371 -> 637
    //   1011: astore 24
    //   1013: goto -578 -> 435
    //   1016: astore 24
    //   1018: goto -639 -> 379
    //   1021: astore 24
    //   1023: goto -700 -> 323
    //   1026: iload 6
    //   1028: istore 10
    //   1030: iload 7
    //   1032: istore 6
    //   1034: iload 10
    //   1036: istore 7
    //   1038: lload 14
    //   1040: lstore 18
    //   1042: iload 8
    //   1044: istore 10
    //   1046: goto -996 -> 50
    //   1049: iload 6
    //   1051: istore 7
    //   1053: iload 8
    //   1055: istore 6
    //   1057: goto -931 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1060	0	this	arye
    //   0	1060	1	paramString1	String
    //   0	1060	2	paramString2	String
    //   0	1060	3	paramBundle	Bundle
    //   0	1060	4	paramBoolean1	boolean
    //   0	1060	5	paramBoolean2	boolean
    //   34	1022	6	i	int
    //   31	1021	7	j	int
    //   54	1000	8	k	int
    //   3	951	9	m	int
    //   48	997	10	n	int
    //   112	3	11	bool	boolean
    //   42	960	12	l1	long
    //   132	907	14	l2	long
    //   39	734	16	l3	long
    //   45	996	18	l4	long
    //   58	486	20	l5	long
    //   154	7	22	l6	long
    //   66	84	24	localc	com.tencent.open.base.http.HttpBaseUtil.c
    //   313	40	24	localConnectTimeoutException1	org.apache.http.conn.ConnectTimeoutException
    //   369	40	24	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   425	35	24	localJSONException1	org.json.JSONException
    //   627	38	24	localIOException1	java.io.IOException
    //   681	259	24	localException1	java.lang.Exception
    //   997	1	24	localException2	java.lang.Exception
    //   1006	1	24	localIOException2	java.io.IOException
    //   1011	1	24	localJSONException2	org.json.JSONException
    //   1016	1	24	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   1021	1	24	localConnectTimeoutException2	org.apache.http.conn.ConnectTimeoutException
    //   80	7	25	localJSONObject	org.json.JSONObject
    //   304	1	25	localJSONException3	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   86	95	304	org/json/JSONException
    //   60	68	313	org/apache/http/conn/ConnectTimeoutException
    //   72	82	313	org/apache/http/conn/ConnectTimeoutException
    //   86	95	313	org/apache/http/conn/ConnectTimeoutException
    //   104	114	313	org/apache/http/conn/ConnectTimeoutException
    //   60	68	369	java/net/SocketTimeoutException
    //   72	82	369	java/net/SocketTimeoutException
    //   86	95	369	java/net/SocketTimeoutException
    //   104	114	369	java/net/SocketTimeoutException
    //   60	68	425	org/json/JSONException
    //   72	82	425	org/json/JSONException
    //   104	114	425	org/json/JSONException
    //   60	68	476	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   72	82	476	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   86	95	476	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   104	114	476	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   134	141	476	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   149	156	476	com/tencent/open/base/http/HttpBaseUtil$NetworkUnavailableException
    //   60	68	510	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException
    //   72	82	510	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException
    //   86	95	510	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException
    //   104	114	510	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException
    //   134	141	510	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException
    //   149	156	510	com/tencent/open/base/http/HttpBaseUtil$HttpStatusException
    //   511	563	596	java/lang/Exception
    //   60	68	627	java/io/IOException
    //   72	82	627	java/io/IOException
    //   86	95	627	java/io/IOException
    //   104	114	627	java/io/IOException
    //   60	68	681	java/lang/Exception
    //   72	82	681	java/lang/Exception
    //   86	95	681	java/lang/Exception
    //   104	114	681	java/lang/Exception
    //   741	794	828	java/lang/Exception
    //   134	141	997	java/lang/Exception
    //   149	156	997	java/lang/Exception
    //   134	141	1006	java/io/IOException
    //   149	156	1006	java/io/IOException
    //   134	141	1011	org/json/JSONException
    //   149	156	1011	org/json/JSONException
    //   134	141	1016	java/net/SocketTimeoutException
    //   149	156	1016	java/net/SocketTimeoutException
    //   134	141	1021	org/apache/http/conn/ConnectTimeoutException
    //   149	156	1021	org/apache/http/conn/ConnectTimeoutException
  }
  
  protected String DA()
  {
    if (TextUtils.isEmpty(this.cDr)) {
      this.cDr = "https://analy.qq.com/cgi-bin/mapp_apptrace";
    }
    return this.cDr;
  }
  
  protected String a(ArrayList<arya> paramArrayList1, ArrayList<arya> paramArrayList2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramArrayList1 != null)
    {
      paramArrayList1 = paramArrayList1.iterator();
      while (paramArrayList1.hasNext())
      {
        arya localarya = (arya)paramArrayList1.next();
        localStringBuilder.append(localarya.appId + "_" + localarya.via + "_" + localarya.actionType + "_" + localarya.getNetwork() + "_" + localarya.aIR);
        if (!TextUtils.isEmpty(localarya.cDm)) {
          localStringBuilder.append("_" + localarya.cDm);
        }
        if (!TextUtils.isEmpty(localarya.cDn)) {
          localStringBuilder.append("_" + localarya.cDn);
        }
        if (!TextUtils.isEmpty(localarya.cDo)) {
          localStringBuilder.append("_" + localarya.cDo);
        }
        if (!TextUtils.isEmpty(localarya.cDp)) {
          localStringBuilder.append("_" + localarya.cDp);
        }
        if (!TextUtils.isEmpty(localarya.cDq)) {
          localStringBuilder.append("_" + localarya.cDq);
        }
        localStringBuilder.append(",");
      }
    }
    if (paramArrayList2 != null)
    {
      paramArrayList1 = paramArrayList2.iterator();
      while (paramArrayList1.hasNext())
      {
        paramArrayList2 = (arya)paramArrayList1.next();
        localStringBuilder.append(paramArrayList2.appId + "_" + paramArrayList2.via + "_" + paramArrayList2.actionType + "_" + paramArrayList2.getNetwork() + "_" + paramArrayList2.aIR);
        if (!TextUtils.isEmpty(paramArrayList2.cDm)) {
          localStringBuilder.append("_" + paramArrayList2.cDm);
        }
        if (!TextUtils.isEmpty(paramArrayList2.cDn)) {
          localStringBuilder.append("_" + paramArrayList2.cDn);
        }
        if (!TextUtils.isEmpty(paramArrayList2.cDo)) {
          localStringBuilder.append("_" + paramArrayList2.cDo);
        }
        if (!TextUtils.isEmpty(paramArrayList2.cDp)) {
          localStringBuilder.append("_" + paramArrayList2.cDp);
        }
        if (!TextUtils.isEmpty(paramArrayList2.cDq)) {
          localStringBuilder.append("_" + paramArrayList2.cDq);
        }
        localStringBuilder.append(",");
      }
    }
    paramArrayList2 = localStringBuilder.toString();
    paramArrayList1 = paramArrayList2;
    if (paramArrayList2.endsWith(",")) {
      paramArrayList1 = paramArrayList2.substring(0, paramArrayList2.length() - 1);
    }
    return paramArrayList1;
  }
  
  public void a(String paramString, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    Bundle localBundle = new Bundle();
    if (paramBoolean1)
    {
      if (!a(paramString, localBundle))
      {
        arwt.i("viareport", "database empty");
        return;
      }
      this.isUploading = true;
    }
    localBundle.putString("uin", paramString);
    localBundle.putString("platform", aroi.a().getPlatform());
    localBundle.putString("action", "100");
    if (paramBoolean2)
    {
      paramString = "";
      localBundle.putString("imei", paramString);
      localBundle.putString("resolution", arxr.getResolution());
      localBundle.putString("network", arwo.bE(aroi.a().getContext()));
      localBundle.putString("wifimac", arxr.Dy());
      localBundle.putString("mobile_pf", "1");
      localBundle.putString("os_ver", Build.VERSION.RELEASE);
      localBundle.putString("lang", arxr.getLanguage());
      localBundle.putString("device", Build.DEVICE);
      localBundle.putString("model_name", Build.MODEL);
      localBundle.putString("sdk_ver", "1.5");
      localBundle.putString("timezone", TimeZone.getDefault().getID());
      localBundle.putString("city", arxr.getCity());
      if (!paramBoolean2) {
        break label328;
      }
      paramString = "";
      label226:
      localBundle.putString("longitude", paramString);
      localBundle.putString("ret_code", "0");
      localBundle.putString("qua", aroi.a().getQUA3());
      localBundle.putString("qz_ver", aroi.a().getAppVersionName());
      localBundle.putString("ext", aroi.a().Db());
      if (paramBundle != null) {
        localBundle.putAll(paramBundle);
      }
      if (!paramBoolean1) {
        break label335;
      }
    }
    label328:
    label335:
    for (paramString = "POST";; paramString = "GET")
    {
      a(DA(), paramString, localBundle, paramBoolean1, paramBoolean2);
      return;
      paramString = arxr.getImei();
      break;
      paramString = arxr.getLocation();
      break label226;
    }
  }
  
  public void a(String paramString, arya paramarya, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    ThreadManager.executeOnNetWorkThread(new ReportManager.1(this, paramBoolean1, paramarya, paramBundle, paramString, paramBoolean2));
  }
  
  /* Error */
  protected boolean a(String paramString, Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokestatic 227	aryd:a	()Laryd;
    //   6: aload_1
    //   7: invokevirtual 443	aryd:ak	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   10: putfield 27	arye:DB	Ljava/util/ArrayList;
    //   13: invokestatic 227	aryd:a	()Laryd;
    //   16: ldc_w 445
    //   19: aload_1
    //   20: invokevirtual 449	aryd:aj	(Ljava/lang/String;Ljava/lang/String;)I
    //   23: pop
    //   24: aload_0
    //   25: invokestatic 227	aryd:a	()Laryd;
    //   28: aload_1
    //   29: invokevirtual 452	aryd:al	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   32: putfield 29	arye:DC	Ljava/util/ArrayList;
    //   35: invokestatic 227	aryd:a	()Laryd;
    //   38: ldc_w 454
    //   41: aload_1
    //   42: invokevirtual 449	aryd:aj	(Ljava/lang/String;Ljava/lang/String;)I
    //   45: pop
    //   46: aload_0
    //   47: aload_0
    //   48: getfield 27	arye:DB	Ljava/util/ArrayList;
    //   51: aload_0
    //   52: getfield 29	arye:DC	Ljava/util/ArrayList;
    //   55: invokevirtual 456	arye:a	(Ljava/util/ArrayList;Ljava/util/ArrayList;)Ljava/lang/String;
    //   58: astore_1
    //   59: ldc 89
    //   61: new 91	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   68: ldc_w 458
    //   71: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload_1
    //   75: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 111	arwt:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: aload_2
    //   85: ldc_w 460
    //   88: aload_1
    //   89: invokevirtual 311	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: aload_1
    //   93: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   96: istore_3
    //   97: iload_3
    //   98: ifeq +9 -> 107
    //   101: iconst_0
    //   102: istore_3
    //   103: aload_0
    //   104: monitorexit
    //   105: iload_3
    //   106: ireturn
    //   107: iconst_1
    //   108: istore_3
    //   109: goto -6 -> 103
    //   112: astore_1
    //   113: aload_0
    //   114: monitorexit
    //   115: aload_1
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	arye
    //   0	117	1	paramString	String
    //   0	117	2	paramBundle	Bundle
    //   96	13	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	97	112	finally
  }
  
  /* Error */
  public boolean aHf()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 464	aryc:getLastReportTime	()J
    //   5: lstore_1
    //   6: invokestatic 469	java/lang/System:currentTimeMillis	()J
    //   9: lstore_3
    //   10: ldc 89
    //   12: new 91	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 471
    //   22: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: lload_1
    //   26: invokevirtual 156	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   29: ldc_w 473
    //   32: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: lload_3
    //   36: invokevirtual 156	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   39: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 111	arwt:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: invokestatic 476	aryc:ic	()J
    //   48: lstore 5
    //   50: ldc 89
    //   52: new 91	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   59: ldc_w 478
    //   62: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: lload 5
    //   67: invokevirtual 156	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   70: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 111	arwt:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: lload_3
    //   77: lload_1
    //   78: lsub
    //   79: lload 5
    //   81: ldc2_w 479
    //   84: lmul
    //   85: lcmp
    //   86: ifge +19 -> 105
    //   89: ldc 180
    //   91: ldc_w 482
    //   94: invokestatic 111	arwt:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: iconst_0
    //   98: istore 7
    //   100: aload_0
    //   101: monitorexit
    //   102: iload 7
    //   104: ireturn
    //   105: lload_3
    //   106: invokestatic 486	aryc:bd	(J)V
    //   109: ldc 180
    //   111: ldc_w 488
    //   114: invokestatic 111	arwt:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   117: iconst_1
    //   118: istore 7
    //   120: goto -20 -> 100
    //   123: astore 8
    //   125: aload_0
    //   126: monitorexit
    //   127: aload 8
    //   129: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	arye
    //   5	73	1	l1	long
    //   9	97	3	l2	long
    //   48	32	5	l3	long
    //   98	21	7	bool	boolean
    //   123	5	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	76	123	finally
    //   89	97	123	finally
    //   105	117	123	finally
  }
  
  /* Error */
  protected boolean mP(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: invokestatic 492	aryc:kQ	(I)I
    //   6: istore_1
    //   7: ldc 89
    //   9: new 91	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 494
    //   19: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: iload_1
    //   23: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   26: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 111	arwt:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: new 496	java/util/Random
    //   35: dup
    //   36: invokespecial 497	java/util/Random:<init>	()V
    //   39: bipush 100
    //   41: invokevirtual 500	java/util/Random:nextInt	(I)I
    //   44: iload_1
    //   45: if_icmpge +18 -> 63
    //   48: ldc_w 502
    //   51: ldc_w 504
    //   54: invokestatic 111	arwt:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: iconst_1
    //   58: istore_2
    //   59: aload_0
    //   60: monitorexit
    //   61: iload_2
    //   62: ireturn
    //   63: ldc_w 502
    //   66: ldc_w 506
    //   69: invokestatic 111	arwt:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: iconst_0
    //   73: istore_2
    //   74: goto -15 -> 59
    //   77: astore_3
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_3
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	arye
    //   0	82	1	paramInt	int
    //   58	16	2	bool	boolean
    //   77	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	57	77	finally
    //   63	72	77	finally
  }
  
  /* Error */
  public boolean sw(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 509	aryc:Nj	()I
    //   5: istore_2
    //   6: ldc 89
    //   8: new 91	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   15: ldc_w 511
    //   18: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: iload_2
    //   22: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   25: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 111	arwt:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: invokestatic 227	aryd:a	()Laryd;
    //   34: aload_1
    //   35: invokevirtual 514	aryd:fE	(Ljava/lang/String;)I
    //   38: iload_2
    //   39: if_icmplt +17 -> 56
    //   42: ldc 180
    //   44: ldc_w 516
    //   47: invokestatic 111	arwt:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: iconst_1
    //   51: istore_3
    //   52: aload_0
    //   53: monitorexit
    //   54: iload_3
    //   55: ireturn
    //   56: ldc 180
    //   58: ldc_w 518
    //   61: invokestatic 111	arwt:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: iconst_0
    //   65: istore_3
    //   66: goto -14 -> 52
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	arye
    //   0	74	1	paramString	String
    //   5	35	2	i	int
    //   51	15	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	50	69	finally
    //   56	64	69	finally
  }
  
  /* Error */
  public boolean sx(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 522	aryc:fD	(Ljava/lang/String;)I
    //   6: istore_2
    //   7: ldc 89
    //   9: new 91	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 524
    //   19: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: iload_2
    //   23: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   26: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 111	arwt:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: new 496	java/util/Random
    //   35: dup
    //   36: invokespecial 497	java/util/Random:<init>	()V
    //   39: bipush 100
    //   41: invokevirtual 500	java/util/Random:nextInt	(I)I
    //   44: iload_2
    //   45: if_icmpge +18 -> 63
    //   48: ldc_w 502
    //   51: ldc_w 526
    //   54: invokestatic 111	arwt:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: iconst_1
    //   58: istore_3
    //   59: aload_0
    //   60: monitorexit
    //   61: iload_3
    //   62: ireturn
    //   63: ldc_w 502
    //   66: ldc_w 528
    //   69: invokestatic 111	arwt:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: iconst_0
    //   73: istore_3
    //   74: goto -15 -> 59
    //   77: astore_1
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	arye
    //   0	82	1	paramString	String
    //   6	40	2	i	int
    //   58	16	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	57	77	finally
    //   63	72	77	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arye
 * JD-Core Version:    0.7.0.1
 */