import com.tencent.mobileqq.apollo.GLTextureView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class ynp
  extends Thread
{
  private int jdField_a_of_type_Int = 0;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private yno jdField_a_of_type_Yno;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 1;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l = true;
  private boolean m;
  private boolean n = true;
  
  public ynp(WeakReference paramWeakReference)
  {
    super("Apollo_GLThread_" + GLTextureView.access$804());
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  private boolean a()
  {
    return (!this.d) && (this.e) && (!this.f) && (this.jdField_a_of_type_Int > 0) && (this.jdField_b_of_type_Int > 0) && ((this.l) || (this.jdField_c_of_type_Int == 1));
  }
  
  private void h()
  {
    if (this.i)
    {
      this.i = false;
      this.jdField_a_of_type_Yno.b();
    }
  }
  
  private void i()
  {
    if (this.h)
    {
      this.jdField_a_of_type_Yno.c();
      this.h = false;
      GLTextureView.access$900().b(this);
    }
  }
  
  /* Error */
  private void j()
  {
    // Byte code:
    //   0: aload_0
    //   1: new 86	yno
    //   4: dup
    //   5: aload_0
    //   6: getfield 69	ynp:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   9: invokespecial 105	yno:<init>	(Ljava/lang/ref/WeakReference;)V
    //   12: putfield 84	ynp:jdField_a_of_type_Yno	Lyno;
    //   15: aload_0
    //   16: iconst_0
    //   17: putfield 90	ynp:h	Z
    //   20: aload_0
    //   21: iconst_0
    //   22: putfield 82	ynp:i	Z
    //   25: iconst_0
    //   26: istore 10
    //   28: aconst_null
    //   29: astore 22
    //   31: iconst_0
    //   32: istore_1
    //   33: iconst_0
    //   34: istore_3
    //   35: iconst_0
    //   36: istore 5
    //   38: iconst_0
    //   39: istore 6
    //   41: iconst_0
    //   42: istore 7
    //   44: iconst_0
    //   45: istore 8
    //   47: iconst_0
    //   48: istore 9
    //   50: aconst_null
    //   51: astore 21
    //   53: iconst_0
    //   54: istore_2
    //   55: iconst_0
    //   56: istore 4
    //   58: invokestatic 96	com/tencent/mobileqq/apollo/GLTextureView:access$900	()Lynq;
    //   61: astore 23
    //   63: aload 23
    //   65: monitorenter
    //   66: iload 10
    //   68: istore 11
    //   70: iload 7
    //   72: istore 10
    //   74: iload 4
    //   76: istore 14
    //   78: aload_0
    //   79: getfield 107	ynp:jdField_a_of_type_Boolean	Z
    //   82: ifeq +34 -> 116
    //   85: aload 23
    //   87: monitorexit
    //   88: invokestatic 96	com/tencent/mobileqq/apollo/GLTextureView:access$900	()Lynq;
    //   91: astore 21
    //   93: aload 21
    //   95: monitorenter
    //   96: aload_0
    //   97: invokespecial 109	ynp:h	()V
    //   100: aload_0
    //   101: invokespecial 111	ynp:i	()V
    //   104: aload 21
    //   106: monitorexit
    //   107: return
    //   108: astore 22
    //   110: aload 21
    //   112: monitorexit
    //   113: aload 22
    //   115: athrow
    //   116: aload_0
    //   117: getfield 57	ynp:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   120: invokevirtual 114	java/util/ArrayList:isEmpty	()Z
    //   123: ifne +93 -> 216
    //   126: aload_0
    //   127: getfield 57	ynp:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   130: iconst_0
    //   131: invokevirtual 118	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   134: checkcast 120	java/lang/Runnable
    //   137: astore 21
    //   139: iload 10
    //   141: istore 7
    //   143: iload 6
    //   145: istore 12
    //   147: iload_1
    //   148: istore 4
    //   150: iload 11
    //   152: istore 10
    //   154: iload 7
    //   156: istore 6
    //   158: iload 12
    //   160: istore 7
    //   162: iload_2
    //   163: istore_1
    //   164: iload 14
    //   166: istore_2
    //   167: aload 23
    //   169: monitorexit
    //   170: aload 21
    //   172: ifnull +648 -> 820
    //   175: aload 21
    //   177: invokeinterface 123 1 0
    //   182: iload 6
    //   184: istore 11
    //   186: aconst_null
    //   187: astore 21
    //   189: iload_1
    //   190: istore 12
    //   192: iload_2
    //   193: istore 6
    //   195: iload 4
    //   197: istore_1
    //   198: iload 12
    //   200: istore_2
    //   201: iload 6
    //   203: istore 4
    //   205: iload 7
    //   207: istore 6
    //   209: iload 11
    //   211: istore 7
    //   213: goto -155 -> 58
    //   216: aload_0
    //   217: getfield 73	ynp:d	Z
    //   220: aload_0
    //   221: getfield 125	ynp:jdField_c_of_type_Boolean	Z
    //   224: if_icmpeq +1075 -> 1299
    //   227: aload_0
    //   228: getfield 125	ynp:jdField_c_of_type_Boolean	Z
    //   231: istore 19
    //   233: aload_0
    //   234: aload_0
    //   235: getfield 125	ynp:jdField_c_of_type_Boolean	Z
    //   238: putfield 73	ynp:d	Z
    //   241: invokestatic 96	com/tencent/mobileqq/apollo/GLTextureView:access$900	()Lynq;
    //   244: invokevirtual 130	java/lang/Object:notifyAll	()V
    //   247: iload_3
    //   248: istore 4
    //   250: aload_0
    //   251: getfield 132	ynp:k	Z
    //   254: ifeq +19 -> 273
    //   257: aload_0
    //   258: invokespecial 109	ynp:h	()V
    //   261: aload_0
    //   262: invokespecial 111	ynp:i	()V
    //   265: aload_0
    //   266: iconst_0
    //   267: putfield 132	ynp:k	Z
    //   270: iconst_1
    //   271: istore 4
    //   273: iload 10
    //   275: istore 7
    //   277: iload 10
    //   279: ifeq +14 -> 293
    //   282: aload_0
    //   283: invokespecial 109	ynp:h	()V
    //   286: aload_0
    //   287: invokespecial 111	ynp:i	()V
    //   290: iconst_0
    //   291: istore 7
    //   293: iload 19
    //   295: ifeq +14 -> 309
    //   298: aload_0
    //   299: getfield 82	ynp:i	Z
    //   302: ifeq +7 -> 309
    //   305: aload_0
    //   306: invokespecial 109	ynp:h	()V
    //   309: iload 19
    //   311: ifeq +48 -> 359
    //   314: aload_0
    //   315: getfield 90	ynp:h	Z
    //   318: ifeq +41 -> 359
    //   321: aload_0
    //   322: getfield 69	ynp:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   325: invokevirtual 138	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   328: checkcast 38	com/tencent/mobileqq/apollo/GLTextureView
    //   331: astore 24
    //   333: aload 24
    //   335: ifnonnull +346 -> 681
    //   338: iconst_0
    //   339: istore 20
    //   341: iload 20
    //   343: ifeq +12 -> 355
    //   346: invokestatic 96	com/tencent/mobileqq/apollo/GLTextureView:access$900	()Lynq;
    //   349: invokevirtual 140	ynq:a	()Z
    //   352: ifeq +7 -> 359
    //   355: aload_0
    //   356: invokespecial 111	ynp:i	()V
    //   359: iload 19
    //   361: ifeq +19 -> 380
    //   364: invokestatic 96	com/tencent/mobileqq/apollo/GLTextureView:access$900	()Lynq;
    //   367: invokevirtual 142	ynq:b	()Z
    //   370: ifeq +10 -> 380
    //   373: aload_0
    //   374: getfield 84	ynp:jdField_a_of_type_Yno	Lyno;
    //   377: invokevirtual 92	yno:c	()V
    //   380: aload_0
    //   381: getfield 75	ynp:e	Z
    //   384: ifne +71 -> 455
    //   387: aload_0
    //   388: getfield 144	ynp:g	Z
    //   391: ifne +64 -> 455
    //   394: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   397: ifeq +31 -> 428
    //   400: ldc 151
    //   402: iconst_2
    //   403: new 27	java/lang/StringBuilder
    //   406: dup
    //   407: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   410: ldc 153
    //   412: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: aload_0
    //   416: invokevirtual 157	ynp:getId	()J
    //   419: invokevirtual 160	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   422: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   425: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   428: aload_0
    //   429: getfield 82	ynp:i	Z
    //   432: ifeq +7 -> 439
    //   435: aload_0
    //   436: invokespecial 109	ynp:h	()V
    //   439: aload_0
    //   440: iconst_1
    //   441: putfield 144	ynp:g	Z
    //   444: aload_0
    //   445: iconst_0
    //   446: putfield 77	ynp:f	Z
    //   449: invokestatic 96	com/tencent/mobileqq/apollo/GLTextureView:access$900	()Lynq;
    //   452: invokevirtual 130	java/lang/Object:notifyAll	()V
    //   455: aload_0
    //   456: getfield 75	ynp:e	Z
    //   459: ifeq +21 -> 480
    //   462: aload_0
    //   463: getfield 144	ynp:g	Z
    //   466: ifeq +14 -> 480
    //   469: aload_0
    //   470: iconst_0
    //   471: putfield 144	ynp:g	Z
    //   474: invokestatic 96	com/tencent/mobileqq/apollo/GLTextureView:access$900	()Lynq;
    //   477: invokevirtual 130	java/lang/Object:notifyAll	()V
    //   480: iload 14
    //   482: istore 12
    //   484: iload 5
    //   486: istore 13
    //   488: iload 14
    //   490: ifeq +20 -> 510
    //   493: iconst_0
    //   494: istore 13
    //   496: iconst_0
    //   497: istore 12
    //   499: aload_0
    //   500: iconst_1
    //   501: putfield 165	ynp:m	Z
    //   504: invokestatic 96	com/tencent/mobileqq/apollo/GLTextureView:access$900	()Lynq;
    //   507: invokevirtual 130	java/lang/Object:notifyAll	()V
    //   510: iload 4
    //   512: istore_3
    //   513: iload 6
    //   515: istore 15
    //   517: iload 8
    //   519: istore 16
    //   521: iload 9
    //   523: istore 17
    //   525: iload 11
    //   527: istore 18
    //   529: aload_0
    //   530: invokespecial 166	ynp:a	()Z
    //   533: ifeq +250 -> 783
    //   536: iload 4
    //   538: istore_3
    //   539: iload 11
    //   541: istore 10
    //   543: aload_0
    //   544: getfield 90	ynp:h	Z
    //   547: ifne +14 -> 561
    //   550: iload 4
    //   552: ifeq +139 -> 691
    //   555: iconst_0
    //   556: istore_3
    //   557: iload 11
    //   559: istore 10
    //   561: aload_0
    //   562: getfield 90	ynp:h	Z
    //   565: ifeq +723 -> 1288
    //   568: aload_0
    //   569: getfield 82	ynp:i	Z
    //   572: ifne +716 -> 1288
    //   575: aload_0
    //   576: iconst_1
    //   577: putfield 82	ynp:i	Z
    //   580: iconst_1
    //   581: istore 9
    //   583: iconst_1
    //   584: istore 5
    //   586: iconst_1
    //   587: istore 4
    //   589: aload_0
    //   590: getfield 82	ynp:i	Z
    //   593: ifeq +715 -> 1308
    //   596: aload_0
    //   597: getfield 59	ynp:n	Z
    //   600: ifeq +671 -> 1271
    //   603: iconst_1
    //   604: istore_2
    //   605: aload_0
    //   606: getfield 61	ynp:jdField_a_of_type_Int	I
    //   609: istore 6
    //   611: aload_0
    //   612: getfield 63	ynp:jdField_b_of_type_Int	I
    //   615: istore_1
    //   616: iconst_1
    //   617: istore 8
    //   619: iconst_1
    //   620: istore 5
    //   622: aload_0
    //   623: iconst_0
    //   624: putfield 59	ynp:n	Z
    //   627: aload_0
    //   628: iconst_0
    //   629: putfield 65	ynp:l	Z
    //   632: invokestatic 96	com/tencent/mobileqq/apollo/GLTextureView:access$900	()Lynq;
    //   635: invokevirtual 130	java/lang/Object:notifyAll	()V
    //   638: iload 4
    //   640: istore 11
    //   642: iload 12
    //   644: istore 4
    //   646: iload 6
    //   648: istore 12
    //   650: iload 7
    //   652: istore 6
    //   654: iload_2
    //   655: istore 7
    //   657: iload 5
    //   659: istore 9
    //   661: iload 4
    //   663: istore_2
    //   664: iload_1
    //   665: istore 4
    //   667: iload 12
    //   669: istore_1
    //   670: iload 8
    //   672: istore 5
    //   674: iload 11
    //   676: istore 8
    //   678: goto -511 -> 167
    //   681: aload 24
    //   683: invokestatic 170	com/tencent/mobileqq/apollo/GLTextureView:access$1000	(Lcom/tencent/mobileqq/apollo/GLTextureView;)Z
    //   686: istore 20
    //   688: goto -347 -> 341
    //   691: invokestatic 96	com/tencent/mobileqq/apollo/GLTextureView:access$900	()Lynq;
    //   694: aload_0
    //   695: invokevirtual 173	ynq:a	(Lynp;)Z
    //   698: istore 19
    //   700: iload 4
    //   702: istore_3
    //   703: iload 11
    //   705: istore 10
    //   707: iload 19
    //   709: ifeq -148 -> 561
    //   712: aload_0
    //   713: getfield 84	ynp:jdField_a_of_type_Yno	Lyno;
    //   716: invokevirtual 175	yno:a	()V
    //   719: aload_0
    //   720: iconst_1
    //   721: putfield 90	ynp:h	Z
    //   724: iconst_1
    //   725: istore 10
    //   727: invokestatic 96	com/tencent/mobileqq/apollo/GLTextureView:access$900	()Lynq;
    //   730: invokevirtual 130	java/lang/Object:notifyAll	()V
    //   733: iload 4
    //   735: istore_3
    //   736: goto -175 -> 561
    //   739: astore 21
    //   741: aload 23
    //   743: monitorexit
    //   744: aload 21
    //   746: athrow
    //   747: astore 22
    //   749: invokestatic 96	com/tencent/mobileqq/apollo/GLTextureView:access$900	()Lynq;
    //   752: astore 21
    //   754: aload 21
    //   756: monitorenter
    //   757: aload_0
    //   758: invokespecial 109	ynp:h	()V
    //   761: aload_0
    //   762: invokespecial 111	ynp:i	()V
    //   765: aload 21
    //   767: monitorexit
    //   768: aload 22
    //   770: athrow
    //   771: astore 21
    //   773: invokestatic 96	com/tencent/mobileqq/apollo/GLTextureView:access$900	()Lynq;
    //   776: aload_0
    //   777: invokevirtual 101	ynq:b	(Lynp;)V
    //   780: aload 21
    //   782: athrow
    //   783: invokestatic 96	com/tencent/mobileqq/apollo/GLTextureView:access$900	()Lynq;
    //   786: invokevirtual 178	java/lang/Object:wait	()V
    //   789: iload 12
    //   791: istore 14
    //   793: iload 13
    //   795: istore 5
    //   797: iload 15
    //   799: istore 6
    //   801: iload 7
    //   803: istore 10
    //   805: iload 16
    //   807: istore 8
    //   809: iload 17
    //   811: istore 9
    //   813: iload 18
    //   815: istore 11
    //   817: goto -739 -> 78
    //   820: iload 9
    //   822: ifeq +446 -> 1268
    //   825: aload_0
    //   826: getfield 84	ynp:jdField_a_of_type_Yno	Lyno;
    //   829: invokevirtual 179	yno:a	()Z
    //   832: ifeq +345 -> 1177
    //   835: invokestatic 96	com/tencent/mobileqq/apollo/GLTextureView:access$900	()Lynq;
    //   838: astore 23
    //   840: aload 23
    //   842: monitorenter
    //   843: aload_0
    //   844: iconst_1
    //   845: putfield 181	ynp:j	Z
    //   848: invokestatic 96	com/tencent/mobileqq/apollo/GLTextureView:access$900	()Lynq;
    //   851: invokevirtual 130	java/lang/Object:notifyAll	()V
    //   854: aload 23
    //   856: monitorexit
    //   857: iconst_0
    //   858: istore 9
    //   860: iload 8
    //   862: ifeq +403 -> 1265
    //   865: aload_0
    //   866: getfield 84	ynp:jdField_a_of_type_Yno	Lyno;
    //   869: invokevirtual 184	yno:a	()Ljavax/microedition/khronos/opengles/GL;
    //   872: checkcast 186	javax/microedition/khronos/opengles/GL10
    //   875: astore 22
    //   877: invokestatic 96	com/tencent/mobileqq/apollo/GLTextureView:access$900	()Lynq;
    //   880: aload 22
    //   882: invokevirtual 189	ynq:a	(Ljavax/microedition/khronos/opengles/GL10;)V
    //   885: iconst_0
    //   886: istore 8
    //   888: iload 10
    //   890: istore 11
    //   892: iload 10
    //   894: ifeq +42 -> 936
    //   897: aload_0
    //   898: getfield 69	ynp:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   901: invokevirtual 138	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   904: checkcast 38	com/tencent/mobileqq/apollo/GLTextureView
    //   907: astore 23
    //   909: aload 23
    //   911: ifnull +416 -> 1327
    //   914: aload 23
    //   916: invokestatic 193	com/tencent/mobileqq/apollo/GLTextureView:access$1100	(Lcom/tencent/mobileqq/apollo/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
    //   919: aload 22
    //   921: aload_0
    //   922: getfield 84	ynp:jdField_a_of_type_Yno	Lyno;
    //   925: getfield 196	yno:a	Ljavax/microedition/khronos/egl/EGLConfig;
    //   928: invokeinterface 202 3 0
    //   933: goto +394 -> 1327
    //   936: iload 7
    //   938: istore 10
    //   940: iload 7
    //   942: ifeq +52 -> 994
    //   945: aload_0
    //   946: getfield 69	ynp:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   949: invokevirtual 138	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   952: checkcast 38	com/tencent/mobileqq/apollo/GLTextureView
    //   955: astore 23
    //   957: aload 23
    //   959: ifnull +374 -> 1333
    //   962: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   965: ifeq +11 -> 976
    //   968: ldc 151
    //   970: iconst_2
    //   971: ldc 204
    //   973: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   976: aload 23
    //   978: invokestatic 193	com/tencent/mobileqq/apollo/GLTextureView:access$1100	(Lcom/tencent/mobileqq/apollo/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
    //   981: aload 22
    //   983: iload_1
    //   984: iload 4
    //   986: invokeinterface 208 4 0
    //   991: goto +342 -> 1333
    //   994: aload_0
    //   995: getfield 69	ynp:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   998: invokevirtual 138	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1001: checkcast 38	com/tencent/mobileqq/apollo/GLTextureView
    //   1004: astore 23
    //   1006: aload 23
    //   1008: ifnull +49 -> 1057
    //   1011: aload 23
    //   1013: invokestatic 193	com/tencent/mobileqq/apollo/GLTextureView:access$1100	(Lcom/tencent/mobileqq/apollo/GLTextureView;)Landroid/opengl/GLSurfaceView$Renderer;
    //   1016: aload 22
    //   1018: invokeinterface 211 2 0
    //   1023: aload 23
    //   1025: invokestatic 214	com/tencent/mobileqq/apollo/GLTextureView:access$1200	(Lcom/tencent/mobileqq/apollo/GLTextureView;)Z
    //   1028: ifne +29 -> 1057
    //   1031: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1034: ifeq +11 -> 1045
    //   1037: ldc 151
    //   1039: iconst_2
    //   1040: ldc 216
    //   1042: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1045: aload 23
    //   1047: iconst_1
    //   1048: invokestatic 220	com/tencent/mobileqq/apollo/GLTextureView:access$1202	(Lcom/tencent/mobileqq/apollo/GLTextureView;Z)Z
    //   1051: pop
    //   1052: aload 23
    //   1054: invokevirtual 223	com/tencent/mobileqq/apollo/GLTextureView:checkSetAlpha	()V
    //   1057: aload_0
    //   1058: getfield 84	ynp:jdField_a_of_type_Yno	Lyno;
    //   1061: invokevirtual 225	yno:a	()I
    //   1064: istore 12
    //   1066: iload 6
    //   1068: istore 7
    //   1070: iload 12
    //   1072: lookupswitch	default:+267->1339, 12288:+63->1135, 12302:+171->1243
    //   1101: <illegal opcode>
    //   1102: ldc 229
    //   1104: iload 12
    //   1106: invokestatic 232	yno:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   1109: invokestatic 96	com/tencent/mobileqq/apollo/GLTextureView:access$900	()Lynq;
    //   1112: astore 23
    //   1114: aload 23
    //   1116: monitorenter
    //   1117: aload_0
    //   1118: iconst_1
    //   1119: putfield 77	ynp:f	Z
    //   1122: invokestatic 96	com/tencent/mobileqq/apollo/GLTextureView:access$900	()Lynq;
    //   1125: invokevirtual 130	java/lang/Object:notifyAll	()V
    //   1128: aload 23
    //   1130: monitorexit
    //   1131: iload 6
    //   1133: istore 7
    //   1135: iload 5
    //   1137: ifeq +168 -> 1305
    //   1140: iconst_1
    //   1141: istore_2
    //   1142: iload_1
    //   1143: istore 12
    //   1145: iload_2
    //   1146: istore 6
    //   1148: iload 4
    //   1150: istore_1
    //   1151: iload 12
    //   1153: istore_2
    //   1154: iload 6
    //   1156: istore 4
    //   1158: iload 10
    //   1160: istore 6
    //   1162: iload 11
    //   1164: istore 10
    //   1166: goto -1108 -> 58
    //   1169: astore 21
    //   1171: aload 23
    //   1173: monitorexit
    //   1174: aload 21
    //   1176: athrow
    //   1177: invokestatic 96	com/tencent/mobileqq/apollo/GLTextureView:access$900	()Lynq;
    //   1180: astore 23
    //   1182: aload 23
    //   1184: monitorenter
    //   1185: aload_0
    //   1186: iconst_1
    //   1187: putfield 181	ynp:j	Z
    //   1190: aload_0
    //   1191: iconst_1
    //   1192: putfield 77	ynp:f	Z
    //   1195: invokestatic 96	com/tencent/mobileqq/apollo/GLTextureView:access$900	()Lynq;
    //   1198: invokevirtual 130	java/lang/Object:notifyAll	()V
    //   1201: aload 23
    //   1203: monitorexit
    //   1204: iload 6
    //   1206: istore 11
    //   1208: iload_1
    //   1209: istore 12
    //   1211: iload_2
    //   1212: istore 6
    //   1214: iload 4
    //   1216: istore_1
    //   1217: iload 12
    //   1219: istore_2
    //   1220: iload 6
    //   1222: istore 4
    //   1224: iload 7
    //   1226: istore 6
    //   1228: iload 11
    //   1230: istore 7
    //   1232: goto -1174 -> 58
    //   1235: astore 21
    //   1237: aload 23
    //   1239: monitorexit
    //   1240: aload 21
    //   1242: athrow
    //   1243: iconst_1
    //   1244: istore 7
    //   1246: goto -111 -> 1135
    //   1249: astore 21
    //   1251: aload 23
    //   1253: monitorexit
    //   1254: aload 21
    //   1256: athrow
    //   1257: astore 22
    //   1259: aload 21
    //   1261: monitorexit
    //   1262: aload 22
    //   1264: athrow
    //   1265: goto -377 -> 888
    //   1268: goto -408 -> 860
    //   1271: iload 13
    //   1273: istore 8
    //   1275: iload_2
    //   1276: istore 6
    //   1278: iload 5
    //   1280: istore_2
    //   1281: iload 9
    //   1283: istore 5
    //   1285: goto -658 -> 627
    //   1288: iload 6
    //   1290: istore 5
    //   1292: iload 8
    //   1294: istore 4
    //   1296: goto -707 -> 589
    //   1299: iconst_0
    //   1300: istore 19
    //   1302: goto -1055 -> 247
    //   1305: goto -163 -> 1142
    //   1308: iload 5
    //   1310: istore 15
    //   1312: iload 4
    //   1314: istore 16
    //   1316: iload 9
    //   1318: istore 17
    //   1320: iload 10
    //   1322: istore 18
    //   1324: goto -541 -> 783
    //   1327: iconst_0
    //   1328: istore 11
    //   1330: goto -394 -> 936
    //   1333: iconst_0
    //   1334: istore 10
    //   1336: goto -342 -> 994
    //   1339: goto -239 -> 1100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1342	0	this	ynp
    //   32	1185	1	i1	int
    //   54	1227	2	i2	int
    //   34	702	3	i3	int
    //   56	1257	4	i4	int
    //   36	1273	5	i5	int
    //   39	1250	6	i6	int
    //   42	1203	7	i7	int
    //   45	1248	8	i8	int
    //   48	1269	9	i9	int
    //   26	1309	10	i10	int
    //   68	1261	11	i11	int
    //   145	1073	12	i12	int
    //   486	786	13	i13	int
    //   76	716	14	i14	int
    //   515	796	15	i15	int
    //   519	796	16	i16	int
    //   523	796	17	i17	int
    //   527	796	18	i18	int
    //   231	1070	19	bool1	boolean
    //   339	348	20	bool2	boolean
    //   51	137	21	localObject1	Object
    //   739	6	21	localObject2	Object
    //   752	14	21	localynq	ynq
    //   771	10	21	localRuntimeException	java.lang.RuntimeException
    //   1169	6	21	localObject3	Object
    //   1235	6	21	localObject4	Object
    //   1249	11	21	localObject5	Object
    //   29	1	22	localObject6	Object
    //   108	6	22	localObject7	Object
    //   747	22	22	localObject8	Object
    //   875	142	22	localGL10	javax.microedition.khronos.opengles.GL10
    //   1257	6	22	localObject9	Object
    //   331	351	24	localGLTextureView	GLTextureView
    // Exception table:
    //   from	to	target	type
    //   96	107	108	finally
    //   110	113	108	finally
    //   78	88	739	finally
    //   116	139	739	finally
    //   167	170	739	finally
    //   216	247	739	finally
    //   250	270	739	finally
    //   282	290	739	finally
    //   298	309	739	finally
    //   314	333	739	finally
    //   346	355	739	finally
    //   355	359	739	finally
    //   364	380	739	finally
    //   380	428	739	finally
    //   428	439	739	finally
    //   439	455	739	finally
    //   455	480	739	finally
    //   499	510	739	finally
    //   529	536	739	finally
    //   543	550	739	finally
    //   561	580	739	finally
    //   589	603	739	finally
    //   605	616	739	finally
    //   622	627	739	finally
    //   627	638	739	finally
    //   681	688	739	finally
    //   691	700	739	finally
    //   712	719	739	finally
    //   719	724	739	finally
    //   727	733	739	finally
    //   741	744	739	finally
    //   773	783	739	finally
    //   783	789	739	finally
    //   58	66	747	finally
    //   175	182	747	finally
    //   744	747	747	finally
    //   825	843	747	finally
    //   865	885	747	finally
    //   897	909	747	finally
    //   914	933	747	finally
    //   945	957	747	finally
    //   962	976	747	finally
    //   976	991	747	finally
    //   994	1006	747	finally
    //   1011	1045	747	finally
    //   1045	1057	747	finally
    //   1057	1066	747	finally
    //   1100	1117	747	finally
    //   1174	1177	747	finally
    //   1177	1185	747	finally
    //   1240	1243	747	finally
    //   1254	1257	747	finally
    //   712	719	771	java/lang/RuntimeException
    //   843	857	1169	finally
    //   1171	1174	1169	finally
    //   1185	1204	1235	finally
    //   1237	1240	1235	finally
    //   1117	1131	1249	finally
    //   1251	1254	1249	finally
    //   757	768	1257	finally
    //   1259	1262	1257	finally
  }
  
  public int a()
  {
    synchronized ()
    {
      int i1 = this.jdField_c_of_type_Int;
      return i1;
    }
  }
  
  public void a()
  {
    synchronized ()
    {
      this.l = true;
      GLTextureView.access$900().notifyAll();
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 1)) {
      throw new IllegalArgumentException("renderMode");
    }
    synchronized (GLTextureView.access$900())
    {
      this.jdField_c_of_type_Int = paramInt;
      GLTextureView.access$900().notifyAll();
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    synchronized ()
    {
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
      this.n = true;
      this.l = true;
      this.m = false;
      GLTextureView.access$900().notifyAll();
      return;
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      throw new IllegalArgumentException("r must not be null");
    }
    synchronized (GLTextureView.access$900())
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramRunnable);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramRunnable);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 100) {
        QLog.e("GLTextureView", 1, new Object[] { "GLThread runable queueList size is > 100, last r:", paramRunnable });
      }
      GLTextureView.access$900().notifyAll();
      return;
    }
  }
  
  public void b()
  {
    synchronized ()
    {
      this.e = true;
      this.j = false;
      GLTextureView.access$900().notifyAll();
      return;
    }
  }
  
  public void c()
  {
    synchronized ()
    {
      this.e = false;
      GLTextureView.access$900().notifyAll();
      return;
    }
  }
  
  public void d()
  {
    synchronized ()
    {
      this.jdField_c_of_type_Boolean = true;
      GLTextureView.access$900().notifyAll();
      for (;;)
      {
        if (!this.jdField_b_of_type_Boolean)
        {
          boolean bool = this.d;
          if (!bool) {
            try
            {
              GLTextureView.access$900().wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
  }
  
  public void e()
  {
    synchronized ()
    {
      this.jdField_c_of_type_Boolean = false;
      this.l = true;
      this.m = false;
      GLTextureView.access$900().notifyAll();
      for (;;)
      {
        if ((!this.jdField_b_of_type_Boolean) && (this.d))
        {
          boolean bool = this.m;
          if (!bool) {
            try
            {
              GLTextureView.access$900().wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
  }
  
  public void f()
  {
    synchronized ()
    {
      this.jdField_a_of_type_Boolean = true;
      GLTextureView.access$900().notifyAll();
      return;
    }
  }
  
  public void g()
  {
    this.k = true;
    GLTextureView.access$900().notifyAll();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 267	ynp:j	()V
    //   4: invokestatic 96	com/tencent/mobileqq/apollo/GLTextureView:access$900	()Lynq;
    //   7: aload_0
    //   8: invokevirtual 269	ynq:a	(Lynp;)V
    //   11: return
    //   12: astore_1
    //   13: invokestatic 96	com/tencent/mobileqq/apollo/GLTextureView:access$900	()Lynq;
    //   16: aload_0
    //   17: invokevirtual 269	ynq:a	(Lynp;)V
    //   20: return
    //   21: astore_1
    //   22: invokestatic 96	com/tencent/mobileqq/apollo/GLTextureView:access$900	()Lynq;
    //   25: aload_0
    //   26: invokevirtual 269	ynq:a	(Lynp;)V
    //   29: aload_1
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	ynp
    //   12	1	1	localInterruptedException	InterruptedException
    //   21	9	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	4	12	java/lang/InterruptedException
    //   0	4	21	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ynp
 * JD-Core Version:    0.7.0.1
 */