package com.tencent.mobileqq.msf.core;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.jce.wup.ObjectCreateException;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.HexUtil;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.msf.core.a.a.a;
import com.tencent.mobileqq.msf.core.net.j;
import com.tencent.mobileqq.msf.core.net.k.b;
import com.tencent.mobileqq.msf.core.net.m;
import com.tencent.mobileqq.msf.core.net.n;
import com.tencent.mobileqq.msf.core.push.g;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.msf.service.protocol.pb.SSOLoginMerge.BusiBuffData;
import com.tencent.msf.service.protocol.pb.SSOLoginMerge.BusiBuffItem;
import com.tencent.msf.service.protocol.pb.SSOReserveField.ReserveFields;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.StringUtils;
import com.tencent.qphone.base.util.l;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ak
{
  public static AtomicInteger A;
  public static ArrayList B;
  public static String E;
  public static String F;
  public static int G = 0;
  public static int H = 0;
  public static long J = 0L;
  public static int M = 0;
  public static byte[] N;
  public static int O = 0;
  public static volatile boolean P = false;
  public static long U = 0L;
  static int V = 0;
  static AtomicBoolean W;
  public static final String Y = "GrayUinPro.Check";
  public static final String Z = "res";
  public static final String a = "MSF.C.NetConnTag";
  private static String aE;
  private static int aF = 0;
  private static final String aJ = "gray_uin_check_dir";
  private static final String aK = "gray_uin_check_file_num";
  private static final String aL = "gray_uin_check_file";
  private static final String aM;
  private static final String aN;
  private static final String aO;
  private static AtomicBoolean aP = new AtomicBoolean();
  public static final int ac = -10008;
  public static final int ad = -302;
  public static final int ae = 302;
  static CopyOnWriteArraySet af;
  private static final int ai = 72;
  private static final int aj = 4;
  private static final int ak = 128;
  private static final int al = -1;
  private static final AtomicInteger ap;
  private static boolean ar = false;
  private static int au = 0;
  private static String av;
  private static String[] aw;
  public static final String c = "__extraTimeoutSeq";
  public static boolean s = false;
  public static ConcurrentHashMap t;
  public static ConcurrentHashMap u;
  public static long v;
  public static int w;
  public static int x;
  public static boolean y;
  public static long z;
  public a C;
  MsfCore D;
  public com.tencent.mobileqq.msf.core.net.a.f I;
  c K;
  long L;
  AtomicBoolean Q;
  int R;
  long S;
  long T;
  HashSet X;
  private long aA;
  private long aB;
  private long aC;
  private long aD;
  private byte[] aG;
  private long aH;
  private Random aI;
  public int aa;
  public AtomicBoolean ab;
  ArrayList ag;
  boolean ah;
  private HashSet am;
  private ToServiceMsg an;
  private Handler ao;
  private SimpleDateFormat aq;
  private int as;
  private String at;
  private HashSet ax;
  private volatile boolean ay;
  private Object az;
  public n b;
  public ConcurrentHashMap d;
  public ConcurrentHashMap e;
  public ConcurrentHashMap f;
  public LinkedBlockingDeque g;
  public LinkedBlockingDeque h;
  b i;
  public int j;
  public int k;
  public int l;
  public int m;
  public int n;
  public int o;
  public long p;
  public boolean q;
  public volatile boolean r;
  
  static
  {
    ap = new AtomicInteger();
    t = new ConcurrentHashMap();
    u = new ConcurrentHashMap();
    v = -1L;
    w = -1;
    x = 0;
    y = true;
    z = -1L;
    ar = false;
    A = new AtomicInteger(0);
    B = new ArrayList();
    E = ":";
    F = "0";
    G = 0;
    H = 0;
    au = 0;
    av = "";
    aw = new String[] { "StreamSvr.UploadStreamMsg" };
    J = -1L;
    M = 0;
    N = null;
    O = 0;
    P = false;
    aF = -1;
    U = 0L;
    V = -1;
    W = new AtomicBoolean();
    aM = "/storage/emulated/0/tencent" + File.separator + "MobileQQ" + File.separator + "gray_uin_check_dir";
    aN = "/storage/emulated/0/tencent" + File.separator + "MobileQQ" + File.separator + "gray_uin_check_dir" + File.separator + "gray_uin_check_file_num";
    aO = "/storage/emulated/0/tencent" + File.separator + "MobileQQ" + File.separator + "gray_uin_check_dir" + File.separator + "gray_uin_check_file";
    af = new CopyOnWriteArraySet();
  }
  
  /* Error */
  public ak(MsfCore paramMsfCore)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 276	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: new 164	java/util/concurrent/ConcurrentHashMap
    //   8: dup
    //   9: invokespecial 165	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   12: putfield 278	com/tencent/mobileqq/msf/core/ak:d	Ljava/util/concurrent/ConcurrentHashMap;
    //   15: aload_0
    //   16: new 164	java/util/concurrent/ConcurrentHashMap
    //   19: dup
    //   20: invokespecial 165	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   23: putfield 280	com/tencent/mobileqq/msf/core/ak:e	Ljava/util/concurrent/ConcurrentHashMap;
    //   26: aload_0
    //   27: new 164	java/util/concurrent/ConcurrentHashMap
    //   30: dup
    //   31: invokespecial 165	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   34: putfield 282	com/tencent/mobileqq/msf/core/ak:f	Ljava/util/concurrent/ConcurrentHashMap;
    //   37: aload_0
    //   38: new 284	java/util/concurrent/LinkedBlockingDeque
    //   41: dup
    //   42: sipush 1000
    //   45: invokespecial 285	java/util/concurrent/LinkedBlockingDeque:<init>	(I)V
    //   48: putfield 287	com/tencent/mobileqq/msf/core/ak:g	Ljava/util/concurrent/LinkedBlockingDeque;
    //   51: aload_0
    //   52: new 284	java/util/concurrent/LinkedBlockingDeque
    //   55: dup
    //   56: invokespecial 288	java/util/concurrent/LinkedBlockingDeque:<init>	()V
    //   59: putfield 290	com/tencent/mobileqq/msf/core/ak:h	Ljava/util/concurrent/LinkedBlockingDeque;
    //   62: aload_0
    //   63: new 292	java/util/HashSet
    //   66: dup
    //   67: invokespecial 293	java/util/HashSet:<init>	()V
    //   70: putfield 295	com/tencent/mobileqq/msf/core/ak:am	Ljava/util/HashSet;
    //   73: aload_0
    //   74: new 9	com/tencent/mobileqq/msf/core/ak$b
    //   77: dup
    //   78: aload_0
    //   79: invokespecial 298	com/tencent/mobileqq/msf/core/ak$b:<init>	(Lcom/tencent/mobileqq/msf/core/ak;)V
    //   82: putfield 300	com/tencent/mobileqq/msf/core/ak:i	Lcom/tencent/mobileqq/msf/core/ak$b;
    //   85: aload_0
    //   86: bipush 10
    //   88: putfield 302	com/tencent/mobileqq/msf/core/ak:j	I
    //   91: aload_0
    //   92: sipush 3072
    //   95: putfield 304	com/tencent/mobileqq/msf/core/ak:k	I
    //   98: aload_0
    //   99: iconst_0
    //   100: putfield 306	com/tencent/mobileqq/msf/core/ak:l	I
    //   103: aload_0
    //   104: sipush 500
    //   107: putfield 308	com/tencent/mobileqq/msf/core/ak:m	I
    //   110: aload_0
    //   111: iconst_0
    //   112: putfield 310	com/tencent/mobileqq/msf/core/ak:n	I
    //   115: aload_0
    //   116: sipush 300
    //   119: putfield 312	com/tencent/mobileqq/msf/core/ak:o	I
    //   122: aload_0
    //   123: lconst_0
    //   124: putfield 314	com/tencent/mobileqq/msf/core/ak:p	J
    //   127: aload_0
    //   128: iconst_0
    //   129: putfield 316	com/tencent/mobileqq/msf/core/ak:q	Z
    //   132: aload_0
    //   133: iconst_0
    //   134: putfield 318	com/tencent/mobileqq/msf/core/ak:r	Z
    //   137: aload_0
    //   138: new 320	java/text/SimpleDateFormat
    //   141: dup
    //   142: ldc_w 322
    //   145: invokestatic 328	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   148: invokespecial 331	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   151: putfield 333	com/tencent/mobileqq/msf/core/ak:aq	Ljava/text/SimpleDateFormat;
    //   154: aload_0
    //   155: new 6	com/tencent/mobileqq/msf/core/ak$a
    //   158: dup
    //   159: aload_0
    //   160: invokespecial 334	com/tencent/mobileqq/msf/core/ak$a:<init>	(Lcom/tencent/mobileqq/msf/core/ak;)V
    //   163: putfield 336	com/tencent/mobileqq/msf/core/ak:C	Lcom/tencent/mobileqq/msf/core/ak$a;
    //   166: aload_0
    //   167: iconst_0
    //   168: putfield 338	com/tencent/mobileqq/msf/core/ak:as	I
    //   171: aload_0
    //   172: ldc 199
    //   174: putfield 340	com/tencent/mobileqq/msf/core/ak:at	Ljava/lang/String;
    //   177: aload_0
    //   178: aconst_null
    //   179: putfield 342	com/tencent/mobileqq/msf/core/ak:I	Lcom/tencent/mobileqq/msf/core/net/a/f;
    //   182: aload_0
    //   183: new 12	com/tencent/mobileqq/msf/core/ak$c
    //   186: dup
    //   187: aload_0
    //   188: invokespecial 343	com/tencent/mobileqq/msf/core/ak$c:<init>	(Lcom/tencent/mobileqq/msf/core/ak;)V
    //   191: putfield 345	com/tencent/mobileqq/msf/core/ak:K	Lcom/tencent/mobileqq/msf/core/ak$c;
    //   194: aload_0
    //   195: new 292	java/util/HashSet
    //   198: dup
    //   199: invokespecial 293	java/util/HashSet:<init>	()V
    //   202: putfield 347	com/tencent/mobileqq/msf/core/ak:ax	Ljava/util/HashSet;
    //   205: aload_0
    //   206: iconst_0
    //   207: putfield 349	com/tencent/mobileqq/msf/core/ak:ay	Z
    //   210: aload_0
    //   211: new 4	java/lang/Object
    //   214: dup
    //   215: invokespecial 276	java/lang/Object:<init>	()V
    //   218: putfield 351	com/tencent/mobileqq/msf/core/ak:az	Ljava/lang/Object;
    //   221: aload_0
    //   222: lconst_0
    //   223: putfield 353	com/tencent/mobileqq/msf/core/ak:aA	J
    //   226: aload_0
    //   227: lconst_0
    //   228: putfield 355	com/tencent/mobileqq/msf/core/ak:aB	J
    //   231: aload_0
    //   232: invokestatic 361	android/os/SystemClock:uptimeMillis	()J
    //   235: putfield 363	com/tencent/mobileqq/msf/core/ak:aC	J
    //   238: aload_0
    //   239: lconst_0
    //   240: putfield 365	com/tencent/mobileqq/msf/core/ak:aD	J
    //   243: aload_0
    //   244: aconst_null
    //   245: putfield 367	com/tencent/mobileqq/msf/core/ak:aG	[B
    //   248: aload_0
    //   249: new 235	java/util/concurrent/atomic/AtomicBoolean
    //   252: dup
    //   253: invokespecial 236	java/util/concurrent/atomic/AtomicBoolean:<init>	()V
    //   256: putfield 369	com/tencent/mobileqq/msf/core/ak:Q	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   259: aload_0
    //   260: iconst_0
    //   261: putfield 371	com/tencent/mobileqq/msf/core/ak:R	I
    //   264: aload_0
    //   265: lconst_0
    //   266: putfield 373	com/tencent/mobileqq/msf/core/ak:S	J
    //   269: aload_0
    //   270: lconst_0
    //   271: putfield 375	com/tencent/mobileqq/msf/core/ak:T	J
    //   274: aload_0
    //   275: new 292	java/util/HashSet
    //   278: dup
    //   279: invokespecial 293	java/util/HashSet:<init>	()V
    //   282: putfield 377	com/tencent/mobileqq/msf/core/ak:X	Ljava/util/HashSet;
    //   285: aload_0
    //   286: lconst_0
    //   287: putfield 379	com/tencent/mobileqq/msf/core/ak:aH	J
    //   290: aload_0
    //   291: new 381	java/util/Random
    //   294: dup
    //   295: invokestatic 386	java/lang/System:currentTimeMillis	()J
    //   298: invokespecial 389	java/util/Random:<init>	(J)V
    //   301: putfield 391	com/tencent/mobileqq/msf/core/ak:aI	Ljava/util/Random;
    //   304: aload_0
    //   305: iconst_m1
    //   306: putfield 393	com/tencent/mobileqq/msf/core/ak:aa	I
    //   309: aload_0
    //   310: new 235	java/util/concurrent/atomic/AtomicBoolean
    //   313: dup
    //   314: invokespecial 236	java/util/concurrent/atomic/AtomicBoolean:<init>	()V
    //   317: putfield 395	com/tencent/mobileqq/msf/core/ak:ab	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   320: aload_0
    //   321: new 190	java/util/ArrayList
    //   324: dup
    //   325: invokespecial 191	java/util/ArrayList:<init>	()V
    //   328: putfield 397	com/tencent/mobileqq/msf/core/ak:ag	Ljava/util/ArrayList;
    //   331: aload_0
    //   332: iconst_0
    //   333: putfield 399	com/tencent/mobileqq/msf/core/ak:ah	Z
    //   336: aload_0
    //   337: aload_1
    //   338: putfield 401	com/tencent/mobileqq/msf/core/ak:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   341: new 403	android/os/HandlerThread
    //   344: dup
    //   345: ldc_w 405
    //   348: iconst_5
    //   349: invokespecial 408	android/os/HandlerThread:<init>	(Ljava/lang/String;I)V
    //   352: astore_2
    //   353: aload_2
    //   354: invokevirtual 411	android/os/HandlerThread:start	()V
    //   357: aload_0
    //   358: new 413	android/os/Handler
    //   361: dup
    //   362: aload_2
    //   363: invokevirtual 417	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   366: invokespecial 420	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   369: putfield 422	com/tencent/mobileqq/msf/core/ak:ao	Landroid/os/Handler;
    //   372: aload_0
    //   373: aload_1
    //   374: invokevirtual 428	com/tencent/mobileqq/msf/core/MsfCore:getMsfAppid	()I
    //   377: putfield 338	com/tencent/mobileqq/msf/core/ak:as	I
    //   380: aload_0
    //   381: new 430	com/tencent/mobileqq/msf/core/net/n
    //   384: dup
    //   385: aload_1
    //   386: aload_0
    //   387: getfield 422	com/tencent/mobileqq/msf/core/ak:ao	Landroid/os/Handler;
    //   390: invokespecial 433	com/tencent/mobileqq/msf/core/net/n:<init>	(Lcom/tencent/mobileqq/msf/core/MsfCore;Landroid/os/Handler;)V
    //   393: putfield 435	com/tencent/mobileqq/msf/core/ak:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   396: aload_0
    //   397: getfield 345	com/tencent/mobileqq/msf/core/ak:K	Lcom/tencent/mobileqq/msf/core/ak$c;
    //   400: ldc_w 437
    //   403: invokevirtual 441	com/tencent/mobileqq/msf/core/ak$c:setName	(Ljava/lang/String;)V
    //   406: invokestatic 446	com/tencent/mobileqq/msf/core/a/a:c	()[Ljava/lang/String;
    //   409: astore_1
    //   410: aload_1
    //   411: ifnull +117 -> 528
    //   414: aload_0
    //   415: aload_1
    //   416: iconst_0
    //   417: aaload
    //   418: invokestatic 452	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   421: putfield 302	com/tencent/mobileqq/msf/core/ak:j	I
    //   424: aload_0
    //   425: aload_1
    //   426: iconst_1
    //   427: aaload
    //   428: invokestatic 452	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   431: putfield 304	com/tencent/mobileqq/msf/core/ak:k	I
    //   434: aload_0
    //   435: aload_1
    //   436: iconst_2
    //   437: aaload
    //   438: invokestatic 452	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   441: putfield 312	com/tencent/mobileqq/msf/core/ak:o	I
    //   444: aload_0
    //   445: aload_1
    //   446: iconst_3
    //   447: aaload
    //   448: invokestatic 452	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   451: putfield 308	com/tencent/mobileqq/msf/core/ak:m	I
    //   454: invokestatic 458	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   457: ifeq +71 -> 528
    //   460: ldc 47
    //   462: iconst_2
    //   463: new 240	java/lang/StringBuilder
    //   466: dup
    //   467: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   470: ldc_w 460
    //   473: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: aload_0
    //   477: getfield 304	com/tencent/mobileqq/msf/core/ak:k	I
    //   480: invokevirtual 463	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   483: ldc_w 465
    //   486: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: aload_0
    //   490: getfield 312	com/tencent/mobileqq/msf/core/ak:o	I
    //   493: invokevirtual 463	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   496: ldc_w 467
    //   499: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: aload_0
    //   503: getfield 308	com/tencent/mobileqq/msf/core/ak:m	I
    //   506: invokevirtual 463	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   509: ldc_w 469
    //   512: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: aload_0
    //   516: getfield 302	com/tencent/mobileqq/msf/core/ak:j	I
    //   519: invokevirtual 463	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   522: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   525: invokestatic 472	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   528: aload_0
    //   529: invokestatic 474	com/tencent/mobileqq/msf/core/a/a:d	()[Ljava/lang/String;
    //   532: invokevirtual 477	com/tencent/mobileqq/msf/core/ak:a	([Ljava/lang/String;)V
    //   535: aload_0
    //   536: invokestatic 479	com/tencent/mobileqq/msf/core/a/a:e	()Ljava/lang/String;
    //   539: invokestatic 452	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   542: putfield 310	com/tencent/mobileqq/msf/core/ak:n	I
    //   545: invokestatic 458	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   548: ifeq +32 -> 580
    //   551: ldc 47
    //   553: iconst_2
    //   554: new 240	java/lang/StringBuilder
    //   557: dup
    //   558: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   561: ldc_w 481
    //   564: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: aload_0
    //   568: getfield 310	com/tencent/mobileqq/msf/core/ak:n	I
    //   571: invokevirtual 463	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   574: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   577: invokestatic 472	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   580: aload_0
    //   581: invokespecial 483	com/tencent/mobileqq/msf/core/ak:v	()V
    //   584: return
    //   585: astore_1
    //   586: ldc 47
    //   588: iconst_1
    //   589: new 240	java/lang/StringBuilder
    //   592: dup
    //   593: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   596: ldc_w 485
    //   599: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: aload_1
    //   603: invokevirtual 488	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   606: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   609: aload_1
    //   610: invokestatic 491	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   613: goto -85 -> 528
    //   616: astore_1
    //   617: ldc 47
    //   619: iconst_1
    //   620: new 240	java/lang/StringBuilder
    //   623: dup
    //   624: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   627: ldc_w 485
    //   630: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   633: aload_1
    //   634: invokevirtual 488	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   637: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   640: aload_1
    //   641: invokestatic 491	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   644: goto -109 -> 535
    //   647: astore_1
    //   648: ldc 47
    //   650: iconst_1
    //   651: new 240	java/lang/StringBuilder
    //   654: dup
    //   655: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   658: ldc_w 485
    //   661: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: aload_1
    //   665: invokevirtual 488	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   668: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   671: aload_1
    //   672: invokestatic 491	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   675: goto -95 -> 580
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	678	0	this	ak
    //   0	678	1	paramMsfCore	MsfCore
    //   352	11	2	localHandlerThread	android.os.HandlerThread
    // Exception table:
    //   from	to	target	type
    //   406	410	585	java/lang/Exception
    //   414	528	585	java/lang/Exception
    //   528	535	616	java/lang/Exception
    //   535	580	647	java/lang/Exception
  }
  
  private void A()
  {
    boolean bool2 = false;
    try
    {
      for (ThreadGroup localThreadGroup = Thread.currentThread().getThreadGroup(); localThreadGroup.getParent() != null; localThreadGroup = localThreadGroup.getParent()) {}
      Thread[] arrayOfThread = new Thread[localThreadGroup.activeCount()];
      localThreadGroup.enumerate(arrayOfThread);
      int i2 = this.g.size();
      int i3 = arrayOfThread.length;
      int i1 = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i1 < i3)
        {
          localThreadGroup = arrayOfThread[i1];
          if ((localThreadGroup != null) && ("MsfCoreMsgSender".equals(localThreadGroup.getName()))) {
            bool1 = true;
          }
        }
        else
        {
          QLog.d("MSF.C.NetConnTag", 1, "sender alive:" + bool1 + " size: " + i2);
          return;
        }
        i1 += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d("MSF.C.NetConnTag", 1, "printCurrentThreads error", localException);
    }
  }
  
  private void B()
  {
    File localFile1 = new File(aM);
    File localFile2 = new File(aN);
    try
    {
      if (!localFile1.exists()) {
        localFile1.mkdir();
      }
      if (!localFile2.exists()) {
        localFile2.createNewFile();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("MSF.C.NetConnTag", 1, "ensureFileExist " + localThrowable);
    }
  }
  
  private static boolean C()
  {
    if ((MsfCore.sCore == null) || (MsfCore.sCore.sender == null) || (MsfCore.sCore.sender.b == null)) {}
    while (MsfCore.sCore.sender.b.f() != 2) {
      return false;
    }
    return true;
  }
  
  private static String D()
  {
    String str2 = "none";
    String str1 = str2;
    try
    {
      if (MsfCore.sCore != null)
      {
        str1 = str2;
        if (MsfCore.sCore.sender != null)
        {
          str1 = str2;
          if (MsfCore.sCore.sender.b != null) {
            str1 = MsfCore.sCore.sender.b.n();
          }
        }
      }
      return str1;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MSF.C.NetConnTag", 1, "check getProtocolType throw t", localThrowable);
    }
    return "none";
  }
  
  public static void a(int paramInt1, long paramLong, int paramInt2)
  {
    QLog.e("Crypt.MSF.C.NetConnTag", 1, "server decrypt err, failCode = " + paramInt1 + ", ssoSeq = " + paramLong);
    HashMap localHashMap = new HashMap();
    localHashMap.put("fail_code", String.valueOf(paramInt1));
    localHashMap.put("sso_seq", String.valueOf(paramLong));
    localHashMap.put("account_uin", MsfService.getCore().getAccountCenter().i());
    localHashMap.put("data_size", String.valueOf(paramInt2));
    localHashMap.put("is_crypt_log_open", String.valueOf(CodecWarpper.isCryptLogOpen()));
    localHashMap.put("is_http_protocol", D());
    if (MsfService.getCore().getStatReporter() != null) {
      MsfService.getCore().getStatReporter().a("evt_msf_decrypt_err", true, 0L, 0L, localHashMap, true, false);
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      af.add(paramString);
      QLog.d("MSF.C.NetConnTag", 1, "use simple head for uin:" + MsfSdkUtils.getShortUin(paramString));
    }
    for (;;)
    {
      CodecWarpper.nativeSetUseSimpleHead(paramString, paramBoolean);
      return;
      af.remove(paramString);
      QLog.d("MSF.C.NetConnTag", 1, "use full head for uin:" + MsfSdkUtils.getShortUin(paramString));
      if (t.containsKey(paramString))
      {
        t.remove(paramString);
        QLog.d("MSF.C.NetConnTag", 1, "clear storeSendSsoSeq tag for uin:" + MsfSdkUtils.getShortUin(paramString));
      }
    }
  }
  
  /* Error */
  private void b(Context paramContext)
  {
    // Byte code:
    //   0: new 240	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   7: invokestatic 683	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   10: invokevirtual 687	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   13: invokevirtual 690	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   16: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: ldc_w 692
    //   22: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: astore_1
    //   29: new 240	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   36: aload_1
    //   37: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc_w 694
    //   43: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: astore_3
    //   50: new 249	java/io/File
    //   53: dup
    //   54: aload_3
    //   55: invokespecial 536	java/io/File:<init>	(Ljava/lang/String;)V
    //   58: astore_2
    //   59: aload_2
    //   60: astore_1
    //   61: aload_2
    //   62: invokevirtual 697	java/io/File:canRead	()Z
    //   65: ifne +12 -> 77
    //   68: new 249	java/io/File
    //   71: dup
    //   72: aload_3
    //   73: invokespecial 536	java/io/File:<init>	(Ljava/lang/String;)V
    //   76: astore_1
    //   77: invokestatic 458	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   80: ifeq +71 -> 151
    //   83: ldc 47
    //   85: iconst_2
    //   86: new 240	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   93: ldc_w 699
    //   96: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_1
    //   100: invokevirtual 690	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   103: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: ldc_w 701
    //   109: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload_1
    //   113: invokevirtual 704	java/io/File:isFile	()Z
    //   116: invokevirtual 528	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   119: ldc_w 706
    //   122: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_1
    //   126: invokevirtual 697	java/io/File:canRead	()Z
    //   129: invokevirtual 528	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   132: ldc_w 708
    //   135: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_1
    //   139: invokevirtual 711	java/io/File:length	()J
    //   142: invokevirtual 580	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   145: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 713	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   151: new 715	java/util/Properties
    //   154: dup
    //   155: invokespecial 716	java/util/Properties:<init>	()V
    //   158: astore 4
    //   160: aload_1
    //   161: invokevirtual 539	java/io/File:exists	()Z
    //   164: ifeq +228 -> 392
    //   167: new 718	java/io/FileInputStream
    //   170: dup
    //   171: aload_1
    //   172: invokespecial 721	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   175: astore_2
    //   176: aload_2
    //   177: astore_1
    //   178: aload 4
    //   180: aload_2
    //   181: invokevirtual 725	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   184: aload_2
    //   185: astore_1
    //   186: aload_2
    //   187: invokevirtual 728	java/io/FileInputStream:close	()V
    //   190: aload_2
    //   191: ifnull +7 -> 198
    //   194: aload_2
    //   195: invokevirtual 728	java/io/FileInputStream:close	()V
    //   198: aload 4
    //   200: ldc_w 730
    //   203: invokevirtual 733	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   206: astore_1
    //   207: aload_1
    //   208: ifnull +171 -> 379
    //   211: aload_1
    //   212: invokevirtual 736	java/lang/String:trim	()Ljava/lang/String;
    //   215: invokevirtual 738	java/lang/String:length	()I
    //   218: ifle +161 -> 379
    //   221: aload_1
    //   222: invokestatic 743	com/tencent/mobileqq/msf/core/d:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/msf/core/d;
    //   225: astore_2
    //   226: aload_2
    //   227: invokevirtual 745	com/tencent/mobileqq/msf/core/d:c	()Ljava/lang/String;
    //   230: ifnull +10 -> 240
    //   233: aload_2
    //   234: invokevirtual 746	com/tencent/mobileqq/msf/core/d:f	()I
    //   237: ifgt +61 -> 298
    //   240: return
    //   241: astore_1
    //   242: aload_1
    //   243: invokevirtual 749	java/io/IOException:printStackTrace	()V
    //   246: goto -48 -> 198
    //   249: astore_3
    //   250: aconst_null
    //   251: astore_2
    //   252: aload_2
    //   253: astore_1
    //   254: aload_3
    //   255: invokevirtual 750	java/lang/Exception:printStackTrace	()V
    //   258: aload_2
    //   259: ifnull -61 -> 198
    //   262: aload_2
    //   263: invokevirtual 728	java/io/FileInputStream:close	()V
    //   266: goto -68 -> 198
    //   269: astore_1
    //   270: aload_1
    //   271: invokevirtual 749	java/io/IOException:printStackTrace	()V
    //   274: goto -76 -> 198
    //   277: astore_2
    //   278: aconst_null
    //   279: astore_1
    //   280: aload_1
    //   281: ifnull +7 -> 288
    //   284: aload_1
    //   285: invokevirtual 728	java/io/FileInputStream:close	()V
    //   288: aload_2
    //   289: athrow
    //   290: astore_1
    //   291: aload_1
    //   292: invokevirtual 749	java/io/IOException:printStackTrace	()V
    //   295: goto -7 -> 288
    //   298: aload_1
    //   299: invokevirtual 736	java/lang/String:trim	()Ljava/lang/String;
    //   302: ldc_w 485
    //   305: ldc 209
    //   307: invokevirtual 754	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   310: astore_1
    //   311: aload_0
    //   312: getfield 435	com/tencent/mobileqq/msf/core/ak:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   315: aload_1
    //   316: invokevirtual 756	com/tencent/mobileqq/msf/core/net/n:a	(Ljava/lang/String;)V
    //   319: ldc 47
    //   321: iconst_1
    //   322: new 240	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   329: ldc_w 758
    //   332: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload_1
    //   336: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokestatic 472	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   345: aload 4
    //   347: ldc_w 760
    //   350: invokevirtual 733	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   353: astore_1
    //   354: aload_1
    //   355: ifnull -115 -> 240
    //   358: aload_1
    //   359: invokevirtual 736	java/lang/String:trim	()Ljava/lang/String;
    //   362: invokevirtual 738	java/lang/String:length	()I
    //   365: ifle -125 -> 240
    //   368: aload_1
    //   369: invokestatic 763	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   372: invokevirtual 766	java/lang/Integer:intValue	()I
    //   375: putstatic 229	com/tencent/mobileqq/msf/core/ak:aF	I
    //   378: return
    //   379: aload_0
    //   380: invokespecial 768	com/tencent/mobileqq/msf/core/ak:x	()V
    //   383: return
    //   384: astore_2
    //   385: goto -105 -> 280
    //   388: astore_3
    //   389: goto -137 -> 252
    //   392: aconst_null
    //   393: astore_2
    //   394: goto -204 -> 190
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	397	0	this	ak
    //   0	397	1	paramContext	Context
    //   58	205	2	localObject1	Object
    //   277	12	2	localObject2	Object
    //   384	1	2	localObject3	Object
    //   393	1	2	localObject4	Object
    //   49	24	3	str	String
    //   249	6	3	localException1	Exception
    //   388	1	3	localException2	Exception
    //   158	188	4	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   194	198	241	java/io/IOException
    //   160	176	249	java/lang/Exception
    //   262	266	269	java/io/IOException
    //   160	176	277	finally
    //   284	288	290	java/io/IOException
    //   178	184	384	finally
    //   186	190	384	finally
    //   254	258	384	finally
    //   178	184	388	java/lang/Exception
    //   186	190	388	java/lang/Exception
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.b.b())
    {
      ToServiceMsg localToServiceMsg = new ToServiceMsg("", "0", "Heartbeat.Alive");
      localToServiceMsg.setMsfCommand(MsfCommand._msf_HeartbeatAlive);
      localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      localToServiceMsg.setAppId(this.D.getMsfAppid());
      localToServiceMsg.putWupBuffer(new byte[] { 0, 0, 0, 4 });
      if (paramBoolean) {
        localToServiceMsg.setTimeout(com.tencent.mobileqq.msf.core.a.a.C());
      }
      for (;;)
      {
        a(localToServiceMsg);
        this.R = com.tencent.mobileqq.msf.core.a.a.I();
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.NetConnTag", 4, "send fast net detect Heartbeat msg ok");
        }
        if ((!paramBoolean) || (com.tencent.mobileqq.msf.core.a.a.Q()))
        {
          this.S = System.currentTimeMillis();
          if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.NetConnTag", 1, "Update send heartbeat time: " + this.S);
          }
        }
        this.Q.set(true);
        return;
        localToServiceMsg.setTimeout(10000L);
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.C.NetConnTag", 4, "conn is also closed.not need send heartbeat msg");
    }
    z();
  }
  
  public static boolean b(String paramString)
  {
    return af.contains(paramString);
  }
  
  public static byte[] b(ToServiceMsg paramToServiceMsg, int paramInt)
  {
    paramToServiceMsg = d(paramToServiceMsg, paramInt);
    if (paramToServiceMsg == null) {
      return null;
    }
    return paramToServiceMsg.toByteArray();
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    int i1 = paramArrayOfByte.length;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(i1 + 4);
    localByteBuffer.putInt(i1 + 4).put(paramArrayOfByte).flip();
    return localByteBuffer.array();
  }
  
  public static void c(String paramString)
  {
    if (!C()) {
      av = paramString;
    }
  }
  
  public static byte[] c(ToServiceMsg paramToServiceMsg, int paramInt)
  {
    if (TextUtils.isEmpty(aE))
    {
      QLog.d("MSF.C.NetConnTag", 1, "[buildReserveFiledWithQimei] qimei is null.");
      return null;
    }
    SSOReserveField.ReserveFields localReserveFields = d(paramToServiceMsg, paramInt);
    paramToServiceMsg = localReserveFields;
    if (localReserveFields == null) {
      paramToServiceMsg = new SSOReserveField.ReserveFields();
    }
    paramToServiceMsg.qimei.set(ByteStringMicro.copyFrom(aE.getBytes()));
    return paramToServiceMsg.toByteArray();
  }
  
  private static SSOReserveField.ReserveFields d(ToServiceMsg paramToServiceMsg, int paramInt)
  {
    Object localObject;
    for (;;)
    {
      try
      {
        if (MsfCore.sCore == null) {
          break label609;
        }
        i1 = MsfCore.sCore.mLocaleId;
        int i3 = com.tencent.mobileqq.msf.core.a.a.bf();
        int i2 = i3;
        if (i3 < 1) {
          i2 = 1;
        }
        i3 = (int)(Math.random() * 100.0D);
        if ((paramToServiceMsg.getServiceCmd().equals("MessageSvc.PbGetMsg")) && (i3 % i2 == i2 - 1))
        {
          localObject = new SSOReserveField.ReserveFields();
          paramToServiceMsg = (String)paramToServiceMsg.getAttribute("sso_push_timestamp");
          if (paramToServiceMsg == null) {
            break;
          }
          String[] arrayOfString = paramToServiceMsg.split("\\|");
          String str1 = Build.MODEL.replace('\n', '-');
          i2 = Build.VERSION.SDK_INT;
          String str2 = Build.DISPLAY;
          String str3 = Build.MANUFACTURER;
          if (arrayOfString.length == 3)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("model:" + str1 + ";");
            localStringBuilder.append("os:" + i2 + ";");
            localStringBuilder.append("version:v2");
            if (com.tencent.mobileqq.msf.core.a.a.bl())
            {
              localStringBuilder.append("man:" + str3);
              localStringBuilder.append("sys:" + str2);
            }
            ((SSOReserveField.ReserveFields)localObject).sso_send.set(Long.parseLong(arrayOfString[0]));
            ((SSOReserveField.ReserveFields)localObject).sdk_recv.set(Long.parseLong(arrayOfString[1]));
            ((SSOReserveField.ReserveFields)localObject).app_recv.set(Long.parseLong(arrayOfString[2]));
            ((SSOReserveField.ReserveFields)localObject).sdk_send.set(System.currentTimeMillis());
            ((SSOReserveField.ReserveFields)localObject).type.set(w);
            ((SSOReserveField.ReserveFields)localObject).extra.set(localStringBuilder.toString());
            if (i1 > 0) {
              ((SSOReserveField.ReserveFields)localObject).locale_id.set(i1);
            }
            if ((2 <= paramInt) && (N != null))
            {
              if (QLog.isColorLevel()) {
                QLog.d("MSF.C.NetConnTag", 2, "MSF.C.CodecWarpper buildReserveFiled sGwV4Sec:" + N);
              }
              ((SSOReserveField.ReserveFields)localObject).client_ipcookie.set(ByteStringMicro.copyFrom(N));
            }
          }
          QLog.d("MSF.C.NetConnTag", 1, "msf get timestamp:" + paramToServiceMsg + ", length:" + arrayOfString.length + ", model:" + str1 + ", type:" + w);
          break;
        }
        if (i1 > 0)
        {
          paramToServiceMsg = new SSOReserveField.ReserveFields();
          paramToServiceMsg.locale_id.set(i1);
          localObject = paramToServiceMsg;
          if (2 > paramInt) {
            break;
          }
          localObject = paramToServiceMsg;
          if (N == null) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag", 2, "MSF.C.CodecWarpper buildReserveFiled sGwV4Sec:" + N);
          }
          localObject = paramToServiceMsg;
          if (paramToServiceMsg == null) {
            localObject = new SSOReserveField.ReserveFields();
          }
          ((SSOReserveField.ReserveFields)localObject).client_ipcookie.set(ByteStringMicro.copyFrom(N));
          return localObject;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.d("MSF.C.NetConnTag", 1, "failed to construct reserve field", paramToServiceMsg);
        return null;
      }
      paramToServiceMsg = null;
      continue;
      label609:
      int i1 = 0;
    }
    return localObject;
  }
  
  public static void d(int paramInt)
  {
    au = paramInt;
  }
  
  private String e(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i1 = 0;
    while (i1 < paramInt)
    {
      localStringBuffer.append((char)(int)(Math.random() * 9.0D + 48.0D));
      i1 += 1;
    }
    return localStringBuffer.toString();
  }
  
  /* Error */
  private String f(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: new 249	java/io/File
    //   9: dup
    //   10: getstatic 262	com/tencent/mobileqq/msf/core/ak:aN	Ljava/lang/String;
    //   13: invokespecial 536	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: astore_3
    //   17: new 249	java/io/File
    //   20: dup
    //   21: getstatic 264	com/tencent/mobileqq/msf/core/ak:aO	Ljava/lang/String;
    //   24: invokespecial 536	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: astore 7
    //   29: ldc 209
    //   31: astore_2
    //   32: aload_2
    //   33: astore 4
    //   35: aload 7
    //   37: invokevirtual 539	java/io/File:exists	()Z
    //   40: ifeq +43 -> 83
    //   43: aload_2
    //   44: astore 4
    //   46: aload 7
    //   48: invokevirtual 1042	java/io/File:delete	()Z
    //   51: pop
    //   52: aload_2
    //   53: astore 4
    //   55: ldc 47
    //   57: iconst_1
    //   58: new 240	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   65: ldc_w 1044
    //   68: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: getstatic 264	com/tencent/mobileqq/msf/core/ak:aO	Ljava/lang/String;
    //   74: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 472	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   83: aload_2
    //   84: astore 4
    //   86: aload_3
    //   87: invokevirtual 539	java/io/File:exists	()Z
    //   90: ifne +74 -> 164
    //   93: aload_2
    //   94: astore 4
    //   96: aload_0
    //   97: invokespecial 1046	com/tencent/mobileqq/msf/core/ak:B	()V
    //   100: aload_2
    //   101: astore 4
    //   103: aload_0
    //   104: iload_1
    //   105: invokespecial 1048	com/tencent/mobileqq/msf/core/ak:e	(I)Ljava/lang/String;
    //   108: astore_2
    //   109: aload_2
    //   110: astore 4
    //   112: new 1050	java/io/FileOutputStream
    //   115: dup
    //   116: aload_3
    //   117: invokespecial 1051	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   120: astore_3
    //   121: aload_3
    //   122: ifnull +453 -> 575
    //   125: aload_3
    //   126: aload_2
    //   127: invokevirtual 890	java/lang/String:getBytes	()[B
    //   130: invokevirtual 1054	java/io/FileOutputStream:write	([B)V
    //   133: aload 6
    //   135: astore 4
    //   137: aload 4
    //   139: ifnull +8 -> 147
    //   142: aload 4
    //   144: invokevirtual 728	java/io/FileInputStream:close	()V
    //   147: aload_2
    //   148: astore 4
    //   150: aload_3
    //   151: ifnull +10 -> 161
    //   154: aload_3
    //   155: invokevirtual 1055	java/io/FileOutputStream:close	()V
    //   158: aload_2
    //   159: astore 4
    //   161: aload 4
    //   163: areturn
    //   164: aload_2
    //   165: astore 4
    //   167: new 718	java/io/FileInputStream
    //   170: dup
    //   171: aload_3
    //   172: invokespecial 721	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   175: astore_3
    //   176: iload_1
    //   177: newarray byte
    //   179: astore_2
    //   180: aload_3
    //   181: ifnull +379 -> 560
    //   184: aload_3
    //   185: aload_2
    //   186: invokevirtual 1059	java/io/FileInputStream:read	([B)I
    //   189: pop
    //   190: new 213	java/lang/String
    //   193: dup
    //   194: aload_2
    //   195: invokespecial 1061	java/lang/String:<init>	([B)V
    //   198: astore_2
    //   199: aload_3
    //   200: invokevirtual 728	java/io/FileInputStream:close	()V
    //   203: aconst_null
    //   204: astore 5
    //   206: aload_3
    //   207: astore 4
    //   209: aload 5
    //   211: astore_3
    //   212: goto -75 -> 137
    //   215: astore 4
    //   217: ldc 47
    //   219: iconst_1
    //   220: new 240	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   227: ldc_w 1063
    //   230: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: aload 4
    //   235: invokevirtual 488	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokestatic 472	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   244: goto -97 -> 147
    //   247: astore_3
    //   248: ldc 47
    //   250: iconst_1
    //   251: new 240	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   258: ldc_w 1065
    //   261: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: aload_3
    //   265: invokevirtual 488	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   268: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 472	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: aload_2
    //   275: areturn
    //   276: astore_3
    //   277: aconst_null
    //   278: astore 5
    //   280: aload 4
    //   282: astore_2
    //   283: aconst_null
    //   284: astore 6
    //   286: aload_3
    //   287: astore 4
    //   289: aload 6
    //   291: astore_3
    //   292: ldc 47
    //   294: iconst_1
    //   295: new 240	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   302: ldc_w 1067
    //   305: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: aload 4
    //   310: invokevirtual 488	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 472	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   319: aload 5
    //   321: ifnull +8 -> 329
    //   324: aload 5
    //   326: invokevirtual 728	java/io/FileInputStream:close	()V
    //   329: aload_2
    //   330: astore 4
    //   332: aload_3
    //   333: ifnull -172 -> 161
    //   336: aload_3
    //   337: invokevirtual 1055	java/io/FileOutputStream:close	()V
    //   340: aload_2
    //   341: areturn
    //   342: astore_3
    //   343: ldc 47
    //   345: iconst_1
    //   346: new 240	java/lang/StringBuilder
    //   349: dup
    //   350: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   353: ldc_w 1065
    //   356: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: aload_3
    //   360: invokevirtual 488	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   363: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   366: invokestatic 472	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   369: aload_2
    //   370: areturn
    //   371: astore 4
    //   373: ldc 47
    //   375: iconst_1
    //   376: new 240	java/lang/StringBuilder
    //   379: dup
    //   380: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   383: ldc_w 1063
    //   386: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: aload 4
    //   391: invokevirtual 488	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   394: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: invokestatic 472	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   400: goto -71 -> 329
    //   403: astore_2
    //   404: aconst_null
    //   405: astore_3
    //   406: aload 5
    //   408: astore 4
    //   410: aload 4
    //   412: ifnull +8 -> 420
    //   415: aload 4
    //   417: invokevirtual 728	java/io/FileInputStream:close	()V
    //   420: aload_3
    //   421: ifnull +7 -> 428
    //   424: aload_3
    //   425: invokevirtual 1055	java/io/FileOutputStream:close	()V
    //   428: aload_2
    //   429: athrow
    //   430: astore 4
    //   432: ldc 47
    //   434: iconst_1
    //   435: new 240	java/lang/StringBuilder
    //   438: dup
    //   439: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   442: ldc_w 1063
    //   445: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: aload 4
    //   450: invokevirtual 488	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   453: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   456: invokestatic 472	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   459: goto -39 -> 420
    //   462: astore_3
    //   463: ldc 47
    //   465: iconst_1
    //   466: new 240	java/lang/StringBuilder
    //   469: dup
    //   470: invokespecial 241	java/lang/StringBuilder:<init>	()V
    //   473: ldc_w 1065
    //   476: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: aload_3
    //   480: invokevirtual 488	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   483: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   486: invokestatic 472	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   489: goto -61 -> 428
    //   492: astore_2
    //   493: aload 5
    //   495: astore 4
    //   497: goto -87 -> 410
    //   500: astore_2
    //   501: aconst_null
    //   502: astore 5
    //   504: aload_3
    //   505: astore 4
    //   507: aload 5
    //   509: astore_3
    //   510: goto -100 -> 410
    //   513: astore_2
    //   514: aload 5
    //   516: astore 4
    //   518: goto -108 -> 410
    //   521: astore 4
    //   523: aconst_null
    //   524: astore 5
    //   526: goto -234 -> 292
    //   529: astore 4
    //   531: ldc 209
    //   533: astore_2
    //   534: aconst_null
    //   535: astore 6
    //   537: aload_3
    //   538: astore 5
    //   540: aload 6
    //   542: astore_3
    //   543: goto -251 -> 292
    //   546: astore 4
    //   548: aconst_null
    //   549: astore 6
    //   551: aload_3
    //   552: astore 5
    //   554: aload 6
    //   556: astore_3
    //   557: goto -265 -> 292
    //   560: ldc 209
    //   562: astore_2
    //   563: aconst_null
    //   564: astore 5
    //   566: aload_3
    //   567: astore 4
    //   569: aload 5
    //   571: astore_3
    //   572: goto -435 -> 137
    //   575: aload 6
    //   577: astore 4
    //   579: goto -442 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	582	0	this	ak
    //   0	582	1	paramInt	int
    //   31	339	2	localObject1	Object
    //   403	26	2	localObject2	Object
    //   492	1	2	localObject3	Object
    //   500	1	2	localObject4	Object
    //   513	1	2	localObject5	Object
    //   533	30	2	str	String
    //   16	196	3	localObject6	Object
    //   247	18	3	localThrowable1	Throwable
    //   276	11	3	localThrowable2	Throwable
    //   291	46	3	localObject7	Object
    //   342	18	3	localThrowable3	Throwable
    //   405	20	3	localObject8	Object
    //   462	43	3	localThrowable4	Throwable
    //   509	63	3	localObject9	Object
    //   33	175	4	localObject10	Object
    //   215	66	4	localThrowable5	Throwable
    //   287	44	4	localObject11	Object
    //   371	19	4	localThrowable6	Throwable
    //   408	8	4	localObject12	Object
    //   430	19	4	localThrowable7	Throwable
    //   495	22	4	localObject13	Object
    //   521	1	4	localThrowable8	Throwable
    //   529	1	4	localThrowable9	Throwable
    //   546	1	4	localThrowable10	Throwable
    //   567	11	4	localObject14	Object
    //   1	569	5	localObject15	Object
    //   4	572	6	localObject16	Object
    //   27	20	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   142	147	215	java/lang/Throwable
    //   154	158	247	java/lang/Throwable
    //   35	43	276	java/lang/Throwable
    //   46	52	276	java/lang/Throwable
    //   55	83	276	java/lang/Throwable
    //   86	93	276	java/lang/Throwable
    //   96	100	276	java/lang/Throwable
    //   103	109	276	java/lang/Throwable
    //   112	121	276	java/lang/Throwable
    //   167	176	276	java/lang/Throwable
    //   336	340	342	java/lang/Throwable
    //   324	329	371	java/lang/Throwable
    //   35	43	403	finally
    //   46	52	403	finally
    //   55	83	403	finally
    //   86	93	403	finally
    //   96	100	403	finally
    //   103	109	403	finally
    //   112	121	403	finally
    //   167	176	403	finally
    //   415	420	430	java/lang/Throwable
    //   424	428	462	java/lang/Throwable
    //   125	133	492	finally
    //   176	180	500	finally
    //   184	199	500	finally
    //   199	203	500	finally
    //   292	319	513	finally
    //   125	133	521	java/lang/Throwable
    //   176	180	529	java/lang/Throwable
    //   184	199	529	java/lang/Throwable
    //   199	203	546	java/lang/Throwable
  }
  
  private static void f(String paramString)
  {
    if (C()) {
      av = paramString;
    }
  }
  
  private int g(ToServiceMsg paramToServiceMsg)
  {
    Object localObject1;
    long l1;
    if (paramToServiceMsg.isNeedCallback())
    {
      this.d.put(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()), paramToServiceMsg);
      paramToServiceMsg.getAttributes().put("__extraTimeoutSeq", Integer.valueOf(ap.incrementAndGet()));
      if (paramToServiceMsg.getTimeout() == -1L)
      {
        paramToServiceMsg.setTimeout(30000L);
        localObject1 = this.D.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout());
        if (("LongConn.OffPicUp".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) || ("ImgStore.GroupPicUp".equalsIgnoreCase(paramToServiceMsg.getServiceCmd()))) {
          QLog.d("MSF.C.NetConnTag", 1, "Sender PicUpMsg timer start, appSeq: " + paramToServiceMsg.getAppSeq() + ", delayMillis: " + paramToServiceMsg.getTimeout());
        }
        paramToServiceMsg.addAttribute("to_timeoutCallbacker", localObject1);
        if (com.tencent.mobileqq.msf.core.a.a.x())
        {
          l1 = paramToServiceMsg.getTimeout() - com.tencent.mobileqq.msf.core.a.a.A();
          if (l1 > 0L) {
            paramToServiceMsg.addAttribute("to_predetect_timeoutCallbacker", this.D.msfAlarmer.b(paramToServiceMsg, l1));
          }
        }
        if ((com.tencent.mobileqq.msf.core.a.a.aa()) && (this.D.quicksender != null) && (this.D.quicksender.b(paramToServiceMsg)))
        {
          QLog.d("MSF.C.NetConnTag", 1, "add quick send timeout check " + paramToServiceMsg.getRequestSsoSeq());
          if ((this.b.b()) && (this.b.l() != null) && (this.b.l().b() != null)) {
            paramToServiceMsg.getAttributes().put("connIDC", this.b.l().b().j);
          }
          this.D.quicksender.c(paramToServiceMsg);
        }
      }
    }
    for (;;)
    {
      try
      {
        this.D.quicksender.f.a(paramToServiceMsg);
        if (this.g.offer(paramToServiceMsg)) {
          break label613;
        }
        QLog.d("MSF.C.NetConnTag", 1, "error, add " + paramToServiceMsg + " to send queue is full! size: " + this.g.size());
        if (paramToServiceMsg.getServiceCmd().equals("SSO.LoginMerge")) {
          break label528;
        }
        localObject1 = w.a(paramToServiceMsg);
        ((FromServiceMsg)localObject1).setBusinessFail(1008, "send queue is full!");
        this.D.addRespToQuque(paramToServiceMsg, (FromServiceMsg)localObject1);
        if ((!W.get()) && (i.c))
        {
          W.set(true);
          V = paramToServiceMsg.getRequestSsoSeq();
        }
        return paramToServiceMsg.getRequestSsoSeq();
        localObject1 = this.D.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout());
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        continue;
      }
      if (paramToServiceMsg.getServiceCmd().equals("SSO.LoginMerge"))
      {
        this.D.msfAlarmer.a(paramToServiceMsg.getRequestSsoSeq(), 30000L);
        continue;
        label528:
        Object localObject2 = (ArrayList)this.f.remove(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()));
        if (localObject2 != null)
        {
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            ToServiceMsg localToServiceMsg = (ToServiceMsg)((Iterator)localObject2).next();
            FromServiceMsg localFromServiceMsg = w.a(localToServiceMsg);
            localFromServiceMsg.setBusinessFail(1008, "send queue is full!");
            this.D.addRespToQuque(localToServiceMsg, localFromServiceMsg);
          }
          continue;
          label613:
          this.aD += 1L;
          this.f.remove(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()));
          if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.NetConnTag", 4, "add " + paramToServiceMsg + " to sendQueue(" + this.g.size() + ")");
          }
          l1 = SystemClock.elapsedRealtime();
          if (l1 - this.aA >= 300000L)
          {
            this.aA = l1;
            if (QLog.isColorLevel()) {
              A();
            }
          }
        }
      }
    }
  }
  
  public static void h()
  {
    Iterator localIterator = af.iterator();
    while (localIterator.hasNext()) {
      CodecWarpper.nativeSetUseSimpleHead((String)localIterator.next(), false);
    }
    af.clear();
  }
  
  private void h(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg.getUin().equals("0")) {}
    int i1;
    do
    {
      return;
      int i2 = 0;
      i1 = i2;
      if (!this.X.contains(paramToServiceMsg.getUin()))
      {
        this.aH += 1L;
        if (this.aH >= 2L)
        {
          i1 = i2;
          if (this.aI.nextInt(20) >= 2) {}
        }
        else
        {
          i1 = 1;
        }
      }
    } while (i1 == 0);
    a(paramToServiceMsg.getAppId(), paramToServiceMsg.getUin());
  }
  
  public static int n()
  {
    return au;
  }
  
  public static String o()
  {
    return av;
  }
  
  private void v()
  {
    QLog.d("libboot_MSF.C.NetConnTag", 1, "[initQimei] obtain qimei.");
    UserAction.getQimei(new al(this));
  }
  
  private void w()
  {
    this.am.add("StatSvc.register");
    this.am.add("PushService.register");
    this.am.add("RegPrxySvc.info");
    this.am.add("RegPrxySvc.infoNew");
    this.am.add("RegPrxySvc.infoAndroid");
    this.am.add("RegPrxySvc.infoLogin");
    this.am.add("RegPrxySvc.infoSync");
    this.am.add("im_status.stat_reg");
    this.am.add("SSO.LoginMerge");
  }
  
  private void x()
  {
    if (MsfSdkUtils.isBuildTestEnvValid())
    {
      d locald = d.a("socket://113.96.213.95:14000");
      if ((locald.c() == null) || (locald.f() <= 0)) {
        QLog.i("MSF.C.NetConnTag", 1, "testServerAddress ip or port error");
      }
    }
    else
    {
      return;
    }
    this.b.a("socket://113.96.213.95:14000");
    aF = 62;
    QLog.d("MSF.C.NetConnTag", 1, "set buildTestServer Address socket://113.96.213.95:14000");
  }
  
  private void y()
  {
    if (this.b.b())
    {
      ToServiceMsg localToServiceMsg = new ToServiceMsg("", "0", "Heartbeat.Alive");
      localToServiceMsg.setMsfCommand(MsfCommand._msf_HeartbeatAlive);
      localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      localToServiceMsg.setAppId(this.D.getMsfAppid());
      localToServiceMsg.putWupBuffer(new byte[] { 0, 0, 0, 4 });
      localToServiceMsg.setTimeout(com.tencent.mobileqq.msf.core.a.a.A());
      a(localToServiceMsg);
      this.R += 1;
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.NetConnTag", 4, "send Heartbeat msg ok");
      }
      this.S = System.currentTimeMillis();
      this.Q.set(true);
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.C.NetConnTag", 4, "conn is also closed.not need send heartbeat msg");
    }
    z();
  }
  
  private void z()
  {
    this.R = 0;
    this.Q.set(false);
  }
  
  public int a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg.getRequestSsoSeq() == -1) {
      paramToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
    }
    paramToServiceMsg.addAttribute("__timestamp_addSendQueue", Long.valueOf(System.currentTimeMillis()));
    Runnable localRunnable;
    if (paramToServiceMsg.isNeedCallback())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "add " + paramToServiceMsg + " to send");
      }
      this.d.put(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()), paramToServiceMsg);
      paramToServiceMsg.getAttributes().put("__extraTimeoutSeq", Integer.valueOf(ap.incrementAndGet()));
      if (paramToServiceMsg.getTimeout() != -1L) {
        break label175;
      }
      paramToServiceMsg.setTimeout(30000L);
      localRunnable = this.D.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout());
    }
    for (;;)
    {
      paramToServiceMsg.addAttribute("to_timeoutCallbacker", localRunnable);
      try
      {
        this.g.addFirst(paramToServiceMsg);
        this.aD += 1L;
        return paramToServiceMsg.getRequestSsoSeq();
        label175:
        localRunnable = this.D.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout());
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.d("MSF.C.NetConnTag", 1, "inset heartbeatMsg error. " + localException, localException);
        }
      }
    }
  }
  
  public long a()
  {
    return this.aC;
  }
  
  public Runnable a(int paramInt)
  {
    long l1 = com.tencent.mobileqq.msf.core.a.a.B();
    if (l1 > 0L) {
      return this.D.msfAlarmer.b(paramInt, l1);
    }
    b(paramInt);
    return null;
  }
  
  public void a(int paramInt, String paramString)
  {
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setRequestId(MsfCore.getNextSeq());
    localUniPacket.setServantName("KQQ.ConfigService.ConfigServantObj");
    localUniPacket.setFuncName("ClientReq");
    Object localObject = new com.tencent.msf.service.protocol.e.c();
    ((com.tencent.msf.service.protocol.e.c)localObject).a = paramInt;
    ((com.tencent.msf.service.protocol.e.c)localObject).b = paramString;
    ((com.tencent.msf.service.protocol.e.c)localObject).d = f(18);
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "getInfoMachine = " + ((com.tencent.msf.service.protocol.e.c)localObject).d + " file_path = " + aN);
    }
    localUniPacket.put("req", localObject);
    localObject = new ToServiceMsg("", paramString, "GrayUinPro.Check");
    ((ToServiceMsg)localObject).setAppId(paramInt);
    ((ToServiceMsg)localObject).setRequestSsoSeq(MsfCore.getNextSeq());
    ((ToServiceMsg)localObject).putWupBuffer(localUniPacket.encode());
    ((ToServiceMsg)localObject).setTimeout(30000L);
    ((ToServiceMsg)localObject).setMsfCommand(MsfCommand.checkRole);
    b((ToServiceMsg)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "role send gray check for " + paramString + " use " + paramInt + " to:" + localObject);
    }
  }
  
  public void a(com.tencent.qphone.base.a parama)
  {
    this.b.a(parama);
  }
  
  public void a(FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.getResultCode() == 1000) {
      this.X.add(paramFromServiceMsg.getUin());
    }
    label372:
    for (;;)
    {
      try
      {
        Object localObject1 = paramFromServiceMsg.getWupBuffer();
        if ((localObject1.length <= 4) || (localObject1[0] != 0) || (localObject1[1] != 0) || (localObject1[2] != 0) || (localObject1[3] != 4)) {
          break label372;
        }
        Object localObject2 = new byte[localObject1.length - 4];
        System.arraycopy(localObject1, 4, localObject2, 0, localObject2.length);
        localObject1 = localObject2;
        QLog.d("MSF.C.NetConnTag", 1, "recv buf:" + HexUtil.bytes2HexStr((byte[])localObject1));
        localObject2 = new UniPacket();
        ((UniPacket)localObject2).decode((byte[])localObject1);
        localObject1 = (com.tencent.msf.service.protocol.e.d)((UniPacket)localObject2).getByClass("res", new com.tencent.msf.service.protocol.e.d());
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.NetConnTag", 4, "role received gray resp uin:" + paramFromServiceMsg.getUin() + " appid:" + paramFromServiceMsg.getAppId() + " status:" + ((com.tencent.msf.service.protocol.e.d)localObject1).a + " yyb:" + ((com.tencent.msf.service.protocol.e.d)localObject1).b + " msg:" + HexUtil.bytes2HexStr(((com.tencent.msf.service.protocol.e.d)localObject1).c));
        }
        if (((com.tencent.msf.service.protocol.e.d)localObject1).a == 1)
        {
          this.D.getSsoRespHandler();
          an.a.put(paramFromServiceMsg.getUin(), localObject1);
          QLog.d("MSF.C.NetConnTag", 1, Thread.currentThread().getName() + " onRecvCheckRoleResp setAccountNoLogin uin=" + MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()));
          this.D.getAccountCenter().k(paramFromServiceMsg.getUin());
          return;
        }
        an.a.remove(paramFromServiceMsg.getUin());
        return;
      }
      catch (ObjectCreateException paramFromServiceMsg)
      {
        if (!QLog.isDevelopLevel()) {
          break;
        }
      }
      QLog.d("MSF.C.NetConnTag", 4, "role gray check error", paramFromServiceMsg);
      return;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("MSF.C.NetConnTag", 4, "role gray check fail " + paramFromServiceMsg);
      return;
    }
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    if (paramFromServiceMsg.getBusinessFailCode() == 1002)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "handleHeartbeat wait " + paramToServiceMsg + " timeout.");
      }
      if (!this.b.b())
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "conn is also closed.");
        }
        z();
      }
      do
      {
        return;
        if (this.R < com.tencent.mobileqq.msf.core.a.a.I()) {
          break;
        }
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag", 2, "Heartbeat continueTimeoutCount is " + this.R + ",closeConn closeByNetDetectFailed");
          }
          this.D.sender.b.a(com.tencent.qphone.base.a.p);
          z();
          return;
        }
        catch (Exception paramFromServiceMsg) {}
      } while (!QLog.isColorLevel());
      QLog.d("MSF.C.NetConnTag", 2, paramFromServiceMsg.toString(), paramFromServiceMsg);
      return;
      long l1 = System.currentTimeMillis();
      if (l1 - this.S > com.tencent.mobileqq.msf.core.a.a.I() * com.tencent.mobileqq.msf.core.a.a.A())
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "timenow - firstSendHeartBeatTime is " + (l1 - this.S) + ",closeConn continueWaitRspTimeout");
        }
        this.D.sender.b.a(com.tencent.qphone.base.a.e);
        z();
        return;
      }
      y();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "recv heart resp.now conn is alive.");
    }
    z();
  }
  
  public void a(ToServiceMsg paramToServiceMsg, int paramInt)
  {
    paramToServiceMsg.getAttributes().put("_attr_regprxy_socket_hashcode", new Integer(paramInt));
    this.an = paramToServiceMsg;
  }
  
  public void a(Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      this.D.msfAlarmer.b(paramRunnable);
    }
  }
  
  public void a(String paramString)
  {
    CodecWarpper.nativeRemoveAccountKey(paramString);
  }
  
  public void a(HashMap paramHashMap)
  {
    this.ag.add(paramHashMap);
    this.ah = true;
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "add waitReportData " + this.ag.size());
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.aG = paramArrayOfByte;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    if (!this.b.c(paramInt)) {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "onRecvSsoResp: dump, connId: " + paramInt);
      }
    }
    int i1;
    do
    {
      return;
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 4) || (paramArrayOfByte.length > 72)) {
        break;
      }
      i1 = this.C.onSSOPingResponse(paramArrayOfByte, paramInt);
      if (i1 > 0)
      {
        this.C.nativeOnReceData(paramArrayOfByte, paramInt);
        return;
      }
    } while (i1 != 0);
    if ((paramArrayOfByte[4] & 0x80) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Crypt.ping.MSF.C.NetConnTag", 2, "onSSOPingResponse ping back： isEncrypt = " + bool + ", pingBack.len = " + paramArrayOfByte.length + ", s = " + StringUtils.bytes2Str(paramArrayOfByte));
      }
      CodecWarpper.setIsNeedEncryptWithHardKeyFromSerN(bool);
      return;
    }
    this.C.nativeOnReceData(paramArrayOfByte, paramInt);
  }
  
  public void a(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      int i2 = paramArrayOfString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        String str = paramArrayOfString[i1];
        if ((str != null) && (str.length() > 0)) {
          this.ax.add(str);
        }
        i1 += 1;
      }
    }
    this.ax.add("GrayUinPro.Check");
    this.ax.add("StatSvc.register");
    this.ax.add("StatSvc.get");
    this.ax.add("RegPrxySvc.infoLogin");
    this.ax.add("RegPrxySvc.infoSync");
    this.ax.add("wtlogin.login");
    this.ax.add("RegPrxySvc.getOffMsg");
    this.ax.add("login.auth");
    this.ax.add("wtlogin.exchange");
    this.ax.add("wtlogin.trans_emp");
    this.ax.add("MessageSvc.PbSendMsg");
    this.ax.add("LongConn.OffPicUp");
    this.ax.add("LongConn.OffPicDown");
    this.ax.add("ImgStore.GroupPicUp");
    this.ax.add("ImgStore.GroupPicDown");
    this.ax.add("StreamSvr.UploadStreamMsg");
    this.ax.add("StreamSvr.RespUploadStreamMsg");
    this.ax.add("StreamSvr.PushStreamMsg");
    this.ax.add("StreamSvr.RespPushStreamMsg");
    this.ax.add("OidbSvc.0x787_1");
    this.ax.add("OidbSvc.0x49d_107");
    this.ax.add("MultiMsg.ApplyUp");
    this.ax.add("MultiMsg.ApplyDown");
    this.ax.add("PttCenterSvr.ShortVideoUpReq");
    this.ax.add("PttCenterSvr.ShortVideoDownReq");
    this.ax.add("ImgStore.GroupPicUp#pttGu");
    this.ax.add("ImgStore.GroupPicDown#pttGd");
    this.ax.add("PttStore.GroupPttUp");
    this.ax.add("PttStore.GroupPttDown");
    this.ax.add("Heartbeat.Alive");
    this.ax.add("friendlist.getFriendGroupList");
    this.ax.add("VideoSvc.Send");
    this.ax.add("VideoSvc.Ack");
    this.ax.add("SharpSvr.c2s");
    this.ax.add("SharpSvr.c2sack");
    this.ax.add("SharpSvr.s2c");
    this.ax.add("SharpSvr.s2cack");
    this.ax.add("MultiVideo.c2s");
    this.ax.add("MultiVideo.c2sack");
    this.ax.add("MultiVideo.s2c");
    this.ax.add("MultiVideo.s2cack");
    this.ax.add("MessageSvc.PbGetMsg");
    this.ax.add("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_DOWNLOAD-1200");
    this.ax.add("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_UPLOAD-500");
    this.ax.add("OfflineFilleHandleSvr.pb_ftnPtt_CMD_REQ_APPLY_DOWNLOAD-1200");
    this.ax.add("cmd_openConn");
    this.ax.add("wtlogin.exchange_emp");
    this.ax.add("wtlogin.name2uin");
    this.ax.add("Client.CorrectTime");
    this.ax.add("StatSvc.RspMSFForceOffline");
    this.ax.add("LightAppSvc.mini_app_userapp.GetUserAppList");
    this.ax.add("qzoneh5.video.vv");
    this.ax.add("OidbSvc.0xb77_9");
    this.ax.add("OidbSvc.0xdc2_9");
    this.ax.add("OidbSvc.0xd55");
    this.ax.add("QQConnectLogin.pre_auth");
    this.ax.add("ConnAuthSvr.get_app_info");
    this.ax.add("ConnAuthSvr.sdk_auth_api");
    this.ax.add("ConnAuthSvr.get_auth_api_list");
    this.ax.add("QQConnectLogin.pre_auth_emp");
    this.ax.add("ConnAuthSvr.get_app_info_emp");
    this.ax.add("ConnAuthSvr.sdk_auth_api_emp");
    this.ax.add("ConnAuthSvr.get_auth_api_list_emp");
  }
  
  public boolean a(Context paramContext)
  {
    try
    {
      if (com.tencent.mobileqq.msf.core.a.a.aI())
      {
        this.I = new com.tencent.mobileqq.msf.core.net.a.f(this.D, paramContext);
        s = true;
      }
    }
    catch (Throwable localException)
    {
      try
      {
        x();
        w();
      }
      catch (Exception localException)
      {
        try
        {
          do
          {
            for (;;)
            {
              this.C.init(paramContext, false);
              CodecWarpper.nativeSetKsid(this.D.getAccountCenter().f());
              this.K.start();
              i.a(paramContext, true);
              return true;
              localThrowable = localThrowable;
              QLog.d("MSF.C.NetConnTag", 1, "init socketAdaptorfactory failed", localThrowable);
            }
            localException = localException;
          } while (!QLog.isColorLevel());
          QLog.d("MSF.C.NetConnTag", 2, "setBuildTestServerIfNeed error " + localException);
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          for (;;)
          {
            com.tencent.mobileqq.msf.core.c.k.a("codecwrapperV2", CodecWarpper.isLoaded, CodecWarpper.soLoadResultCode, localUnsatisfiedLinkError.getMessage());
          }
        }
      }
    }
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return false;
    }
    if (paramToServiceMsg.getMsfCommand() == MsfCommand.msf_ssoping)
    {
      this.D.sender.b.l().h();
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, Thread.currentThread().getName() + " onFoundTimeoutMsg closeConn closeBySSOPingTimeout");
      }
      this.D.sender.b.a(com.tencent.qphone.base.a.B);
      return false;
    }
    if (paramToServiceMsg.getMsfCommand() == MsfCommand.msf_oshello)
    {
      QLog.d("MSF.C.NetConnTag", 1, "cannot get os hello response");
      return false;
    }
    long l1 = 0L;
    long l2 = 0L;
    int i1 = 0;
    int i2;
    boolean bool1;
    try
    {
      i2 = NetConnInfoCenter.getActiveNetworkType();
      l3 = this.b.l().e();
      boolean bool2 = this.b.b();
      if (paramToServiceMsg.getAttributes().containsKey("_attr_req_send_time")) {
        l1 = ((Long)paramToServiceMsg.getAttribute("_attr_req_send_time")).longValue();
      }
      if (paramToServiceMsg.getAttributes().containsKey("_attr_req_socket_conn_time")) {
        l2 = ((Long)paramToServiceMsg.getAttribute("_attr_req_socket_conn_time")).longValue();
      }
      if (paramToServiceMsg.getAttributes().containsKey("_attr_req_netstate")) {
        i1 = ((Integer)paramToServiceMsg.getAttribute("_attr_req_netstate")).intValue();
      }
      if (!paramToServiceMsg.getAttributes().containsKey("_attr_req_isconn")) {
        break label1853;
      }
      bool1 = ((Boolean)paramToServiceMsg.getAttribute("_attr_req_isconn")).booleanValue();
      if (this.D.statReporter != null)
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("_attr_req_send_time", "" + l1);
        ((HashMap)localObject).put("_attr_req_socket_conn_time", "" + l2);
        ((HashMap)localObject).put("_attr_req_netstate", "" + i1);
        ((HashMap)localObject).put("_attr_req_isconn", "" + bool1);
        ((HashMap)localObject).put("_attr_timeout_netstate", "" + i2);
        ((HashMap)localObject).put("_attr_timeout_isconn", "" + bool2);
        ((HashMap)localObject).put("_attr_timeout_socket_conn_time", "" + l3);
        this.D.statReporter.a("actReqTimeoutReport", false, 0L, 0L, (Map)localObject, false, false);
      }
    }
    catch (Exception localException3)
    {
      try
      {
        this.I.b().a(paramToServiceMsg.getRequestSsoSeq(), true);
        if (!paramToServiceMsg.getAttributes().containsKey("__timestamp_msf2net")) {
          break label1847;
        }
        l1 = ((Long)paramToServiceMsg.getAttribute("__timestamp_msf2net")).longValue();
        l3 = System.currentTimeMillis();
        if (!paramToServiceMsg.getAttributes().containsKey("__timestamp_addSendQueue")) {
          break label1841;
        }
        l2 = ((Long)paramToServiceMsg.getAttribute("__timestamp_addSendQueue")).longValue();
      }
      catch (Exception localException3)
      {
        try
        {
          if ((!paramToServiceMsg.getServiceCmd().equals("MessageSvc.PbGetMsg")) || (this.D.statReporter == null)) {
            break label694;
          }
          this.D.statReporter.a("dim.Msf.PushSendFail", false, 0L, 0L, null, false, false);
        }
        catch (Exception localException3)
        {
          try
          {
            Object localObject;
            while (paramToServiceMsg.getServiceCmd() == com.tencent.mobileqq.msf.core.push.e.k)
            {
              l4 = ((Long)paramToServiceMsg.getAttribute("_attr_alarm_elapsed_time", Long.valueOf(0L))).longValue();
              if ((com.tencent.mobileqq.msf.core.a.a.v) && (l4 > com.tencent.mobileqq.msf.core.a.a.bn()) && (l2 >= this.b.l().e()))
              {
                localObject = paramToServiceMsg.getUin();
                if (localObject != null) {
                  if ((!com.tencent.mobileqq.msf.core.a.a.w) || (Long.parseLong((String)localObject) % 2L == 0L))
                  {
                    QLog.d("MSF.C.NetConnTag", 1, "try close conn by wakeup alarm exceeded and detect timeout:" + l4);
                    this.D.sender.b.a(com.tencent.qphone.base.a.E);
                    if (this.D.getStatReporter() != null) {
                      this.D.getStatReporter().a("3", (String)localObject, true, 0L);
                    }
                    return false;
                    localException1 = localException1;
                    QLog.e("MSF.C.NetConnTag", 1, "report 1002 failed", localException1);
                    continue;
                    localException2 = localException2;
                    QLog.d("MSF.C.NetConnTag", 1, "adaptor recv timeout failed", localException2);
                    continue;
                    localException3 = localException3;
                    QLog.d("MSF.C.NetConnTag", 1, "", localException3);
                  }
                  else
                  {
                    this.D.pushManager.E = SystemClock.elapsedRealtime();
                    QLog.d("MSF.C.NetConnTag", 1, "wakeup alarm exceeded and detect timeout, but not close conn");
                  }
                }
              }
            }
          }
          catch (Exception localException4)
          {
            for (;;)
            {
              long l3;
              QLog.d("MSF.C.NetConnTag", 1, "SimpleGet timeout error!", localException4);
            }
          }
          if ((l2 == 0L) || (l3 - l2 <= paramToServiceMsg.getTimeout()) || (l3 - l2 <= this.D.pushManager.e()) || (paramToServiceMsg.getTimeout() >= this.D.pushManager.e())) {
            break label1094;
          }
          if (l2 < this.b.l().e()) {
            break label1092;
          }
          if (!QLog.isColorLevel()) {
            break label1054;
          }
          QLog.d("MSF.C.NetConnTag", 2, "xiaomi 2s: " + paramToServiceMsg.getRequestSsoSeq() + " msg timeout , addtoqueueTime is " + (l3 - l2) + ",try close conn");
          this.D.sender.b.a(com.tencent.qphone.base.a.q);
          z();
          return true;
          return true;
          if ((l1 != 0L) && (l1 <= this.b.l().e())) {
            break label1462;
          }
          if (paramToServiceMsg.getMsfCommand() != MsfCommand._msf_HeartbeatAlive) {
            break label1164;
          }
          QLog.d("MSF.C.NetConnTag", 1, "found timeout heartalive msg " + paramToServiceMsg.getRequestSsoSeq());
          a(paramFromServiceMsg, paramToServiceMsg);
          return false;
          if (paramToServiceMsg.getMsfCommand() != MsfCommand._msf_QuickHeartBeat) {
            break label1218;
          }
          QLog.d("MSF.C.NetConnTag", 1, "found timeout quickheartbeat msg " + paramToServiceMsg.getRequestSsoSeq());
          this.D.quicksender.a(paramToServiceMsg, paramFromServiceMsg, false);
          return false;
          try
          {
            if ((this.Q.get()) && (System.currentTimeMillis() - this.S < com.tencent.mobileqq.msf.core.a.a.O() + 120000)) {
              break label1418;
            }
            l1 = System.currentTimeMillis();
            if (l1 - this.S <= com.tencent.mobileqq.msf.core.a.a.O()) {
              break label1363;
            }
            if (paramToServiceMsg.getRequestSsoSeq() == V)
            {
              V = -1;
              QLog.d("MSF.C.NetConnTag", 1, "found first msg screen on timeout try close conn " + paramToServiceMsg);
              this.D.sender.b.a(com.tencent.qphone.base.a.t);
              z();
              return true;
            }
          }
          finally {}
          if (!com.tencent.mobileqq.msf.core.a.a.bo()) {
            break label1349;
          }
          y();
          for (;;)
          {
            if (paramToServiceMsg.getMsfCommand() != MsfCommand._msf_HeartbeatAlive) {
              break label1497;
            }
            return false;
            QLog.d("MSF.C.NetConnTag", 1, "found timeout msg check time: timenow = " + l1 + " firstSendHeartBeatTime = " + this.S + " ConfigManager.getHeartBeatTimeInterval() = " + com.tencent.mobileqq.msf.core.a.a.O());
            break;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("MSF.C.NetConnTag", 2, "sendingHeartBeat: " + this.Q + "net detect has started, no need sendHeartbeat");
            break;
            QLog.d("MSF.C.NetConnTag", 1, "found timeout msg " + paramToServiceMsg + " before connSucc.");
          }
          if (paramToServiceMsg.getMsfCommand() != MsfCommand._msf_QuickHeartBeat) {
            break label1522;
          }
          this.D.quicksender.a(paramToServiceMsg, paramFromServiceMsg, true);
          return false;
        }
      }
    }
    if ((paramToServiceMsg != null) && (paramToServiceMsg.isNeedRemindSlowNetwork())) {
      com.tencent.mobileqq.msf.core.net.k.a(k.b.a);
    }
    paramToServiceMsg.addAttribute("_tag_socket_connerror", n.p);
    paramFromServiceMsg.addAttribute("_tag_socket_connerror", n.p);
    if (paramToServiceMsg.getAttributes().containsKey("_tag_socket")) {
      paramFromServiceMsg.addAttribute("_tag_socket", paramToServiceMsg.getAttribute("_tag_socket"));
    }
    if ((s) && (com.tencent.mobileqq.msf.core.net.a.f.a())) {}
    for (;;)
    {
      try
      {
        label694:
        long l4;
        label1054:
        label1092:
        label1094:
        label1363:
        label1497:
        label1522:
        if (!this.b.b()) {
          break label1859;
        }
        label1164:
        label1218:
        label1349:
        int i3 = 1;
        label1418:
        label1462:
        paramFromServiceMsg = aw;
        int i4 = paramFromServiceMsg.length;
        i1 = 0;
        i2 = i3;
        if (i1 < i4)
        {
          CharSequence localCharSequence = paramFromServiceMsg[i1];
          if ((TextUtils.isEmpty(localCharSequence)) || (paramToServiceMsg == null) || (!localCharSequence.equals(paramToServiceMsg.getServiceCmd()))) {
            break label1861;
          }
          i2 = 0;
        }
        if (i2 == 0) {
          break label1859;
        }
        if (!B.contains(paramToServiceMsg.getServiceCmd())) {
          B.add(paramToServiceMsg.getServiceCmd());
        }
        if (A.incrementAndGet() < com.tencent.mobileqq.msf.core.a.a.J()) {
          break label1859;
        }
        if (B.size() > 2)
        {
          QLog.d("MSF.C.NetConnTag", 1, "Continue wait resp for bus packets ,try close conn");
          A.set(0);
          B.clear();
          this.D.sender.b.a(com.tencent.qphone.base.a.e);
          z();
        }
        else if (QLog.isColorLevel())
        {
          paramToServiceMsg = (String)B.get(0);
          QLog.d("MSF.C.NetConnTag", 1, "Continue wait resp timeout by single cmd:" + paramToServiceMsg);
          A.set(0);
          B.clear();
          paramToServiceMsg = new HashMap();
          paramToServiceMsg.put("event_cmd", B.get(0));
          if (this.D.getStatReporter() == null) {
            break label1859;
          }
          this.D.getStatReporter().a("dim.Msf.SingleCmdTimeout", false, 0L, 0L, paramToServiceMsg, false, false);
        }
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.d("MSF.C.NetConnTag", 1, " Continue wait resp for bus packets ,try close conn failed: " + paramToServiceMsg);
      }
      paramToServiceMsg = com.tencent.mobileqq.msf.core.b.c.a((String)B.get(0));
      continue;
      label1841:
      l2 = 0L;
      continue;
      label1847:
      l1 = 0L;
      continue;
      label1853:
      bool1 = false;
      break;
      label1859:
      return true;
      label1861:
      i1 += 1;
    }
  }
  
  public int b(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return -1;
    }
    if (this.D.isSuspended())
    {
      QLog.d("MSF.C.NetConnTag", 1, "handleSsoFailCode, msfcore suspent");
      ??? = w.a(paramToServiceMsg);
      ((FromServiceMsg)???).setBusinessFail(2009, "MSF is suspeded.");
      this.D.addRespToQuque(paramToServiceMsg, (FromServiceMsg)???);
      return paramToServiceMsg.getRequestSsoSeq();
    }
    if ((paramToServiceMsg.getWupBuffer() != null) && (paramToServiceMsg.getWupBuffer().length > 103424))
    {
      ??? = w.a(paramToServiceMsg);
      ((FromServiceMsg)???).setBusinessFail(2019, "check the wupbuf size in range[0, 101kb]");
      this.D.addRespToQuque(paramToServiceMsg, (FromServiceMsg)???);
      return paramToServiceMsg.getRequestSsoSeq();
    }
    Object localObject2;
    String str;
    int i1;
    if (this.D.configManager.K != null)
    {
      Iterator localIterator = this.D.configManager.K.iterator();
      ??? = null;
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localObject2 = (a.a)localIterator.next();
          if (((a.a)localObject2).a + ((a.a)localObject2).b.b < System.currentTimeMillis() / 1000L)
          {
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.NetConnTag", 2, "OverloadPushNotify item expired sCmd = " + ((a.a)localObject2).c);
            }
            this.D.configManager.K.remove(localObject2);
            ??? = localObject2;
          }
          else
          {
            str = paramToServiceMsg.getServiceCmd();
            if (((a.a)localObject2).c.charAt(((a.a)localObject2).c.length() - 1) == '*')
            {
              ??? = localObject2;
              if (!str.startsWith(((a.a)localObject2).c.substring(0, ((a.a)localObject2).c.length() - 1))) {
                continue;
              }
              if (!QLog.isColorLevel()) {
                break label1969;
              }
              QLog.d("MSF.C.NetConnTag", 2, "OverloadPushNotify item matched strServiceCmd = " + str + " sCmd:" + ((a.a)localObject2).c);
              i1 = 1;
              ??? = localObject2;
            }
          }
        }
      }
    }
    for (;;)
    {
      if ((i1 != 0) && (??? != null))
      {
        if (((a.a)???).b.e == 1)
        {
          localObject2 = new FromServiceMsg();
          ((FromServiceMsg)localObject2).setUin("0");
          ((FromServiceMsg)localObject2).setServiceCmd("OverLoadPush.notify");
          ((FromServiceMsg)localObject2).setMsfCommand(MsfCommand.onOverloadPushNotify);
          ((FromServiceMsg)localObject2).setAppId(this.D.getMsfAppid());
          ((FromServiceMsg)localObject2).setMsgSuccess();
          ((FromServiceMsg)localObject2).setRequestSsoSeq(MsfCore.getNextSeq());
          MsfSdkUtils.addFromMsgProcessName("*", (FromServiceMsg)localObject2);
          ((FromServiceMsg)localObject2).getAttributes().put("msg", new String(((a.a)???).b.d));
          this.D.addRespToQuque(null, (FromServiceMsg)localObject2);
          ((a.a)???).b.e = 0;
        }
        localObject2 = w.a(paramToServiceMsg);
        ((FromServiceMsg)localObject2).setBusinessFail(((a.a)???).b.c, new String(((a.a)???).b.d));
        this.D.addRespToQuque(paramToServiceMsg, (FromServiceMsg)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "OverloadPushNotify server overload block tomsg: " + paramToServiceMsg + " frommsg: " + localObject2);
        }
        return paramToServiceMsg.getRequestSsoSeq();
        ??? = localObject2;
        if (!((a.a)localObject2).c.equals(str)) {
          break;
        }
        if (!QLog.isColorLevel()) {
          break label1969;
        }
        QLog.d("MSF.C.NetConnTag", 2, "OverloadPushNotify item matched strServiceCmd = " + str + " sCmd:" + ((a.a)localObject2).c);
        i1 = 1;
        ??? = localObject2;
        continue;
      }
      if ((paramToServiceMsg.getAppId() <= 0) && (paramToServiceMsg.getMsfCommand() != MsfCommand.openConn) && ((TextUtils.isEmpty(paramToServiceMsg.getServiceCmd())) || (!paramToServiceMsg.getServiceCmd().startsWith("wtlogin."))))
      {
        ??? = w.a(paramToServiceMsg);
        ((FromServiceMsg)???).setBusinessFail(1007, "msg appid is " + paramToServiceMsg.getAppId());
        this.D.addRespToQuque(paramToServiceMsg, (FromServiceMsg)???);
        return paramToServiceMsg.getRequestSsoSeq();
      }
      if (aP.get())
      {
        ??? = w.a(paramToServiceMsg);
        ((FromServiceMsg)???).setBusinessFail(2014, "error");
        this.D.addRespToQuque(paramToServiceMsg, (FromServiceMsg)???);
        return paramToServiceMsg.getRequestSsoSeq();
      }
      localObject2 = (com.tencent.msf.service.protocol.e.d)an.a.get(paramToServiceMsg.getUin());
      ??? = localObject2;
      if (localObject2 != null)
      {
        ??? = localObject2;
        if (paramToServiceMsg.getServiceCmd().equals("wtlogin.login"))
        {
          this.X.remove(paramToServiceMsg.getUin());
          an.a.remove(paramToServiceMsg.getUin());
          ??? = null;
        }
      }
      if ((??? != null) && (!paramToServiceMsg.getServiceCmd().startsWith("login.")) && (!paramToServiceMsg.getServiceCmd().startsWith("wtlogin.login")) && (!paramToServiceMsg.getServiceCmd().equals("GrayUinPro.Check")))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "error, " + paramToServiceMsg.getUin() + " not in gray list");
        }
        localObject2 = w.a(paramToServiceMsg);
        try
        {
          ((FromServiceMsg)localObject2).setBusinessFail(2008, new String(((com.tencent.msf.service.protocol.e.d)???).c, "UTF-8"));
          ((FromServiceMsg)localObject2).addAttribute(((FromServiceMsg)localObject2).getServiceCmd(), String.valueOf(((com.tencent.msf.service.protocol.e.d)???).b));
          this.D.addRespToQuque(paramToServiceMsg, (FromServiceMsg)localObject2);
          if (this.D.getAccountCenter().g(((FromServiceMsg)localObject2).getUin()))
          {
            QLog.d("MSF.C.NetConnTag", 1, Thread.currentThread().getName() + " addSendQueue setAccountNoLogin uin=" + MsfSdkUtils.getShortUin(((FromServiceMsg)localObject2).getUin()));
            this.D.getAccountCenter().k(((FromServiceMsg)localObject2).getUin());
          }
          return paramToServiceMsg.getRequestSsoSeq();
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ((FromServiceMsg)localObject2).setBusinessFail(2008, paramToServiceMsg.getUin() + " not in gray list");
          }
        }
      }
      if ((this.D.standbyModeManager != null) && (this.D.standbyModeManager.b()))
      {
        if (!this.D.standbyModeManager.a(paramToServiceMsg.getServiceCmd()))
        {
          QLog.d("MSF.C.NetConnTag", 1, "refuse to send request cmd: " + paramToServiceMsg.getServiceCmd() + " ssoseq: " + paramToServiceMsg.getRequestSsoSeq() + " by standbyMode");
          this.D.getStandyModeManager().a(paramToServiceMsg);
          ??? = w.a(paramToServiceMsg);
          ((FromServiceMsg)???).setBusinessFail(2018, "standby mode force stop request");
          this.D.addRespToQuque(paramToServiceMsg, (FromServiceMsg)???);
          if (!this.b.b())
          {
            ??? = MsfMsgUtil.getConnOpenMsg("");
            MsfSdkUtils.addToMsgProcessName("", (ToServiceMsg)???);
            this.D.sendSsoMsg((ToServiceMsg)???);
          }
          return paramToServiceMsg.getRequestSsoSeq();
        }
        this.D.getStandyModeManager().b(paramToServiceMsg);
      }
      CodecWarpper.getFileStoreKey();
      ??? = this.D.getAccountCenter().i(paramToServiceMsg.getUin());
      if (??? != null) {
        paramToServiceMsg.setUin((String)???);
      }
      if ((!paramToServiceMsg.getUin().equals("0")) && (!this.at.equals(paramToServiceMsg.getUin())))
      {
        this.at = paramToServiceMsg.getUin();
        if (this.D.statReporter != null) {
          this.D.statReporter.a(this.at);
        }
        if (this.as != paramToServiceMsg.getAppId()) {
          this.as = paramToServiceMsg.getAppId();
        }
        if (paramToServiceMsg.getRequestSsoSeq() == -1) {
          paramToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
        }
        if (!paramToServiceMsg.getAttributes().containsKey("__timestamp_app2msf")) {
          paramToServiceMsg.addAttribute("__timestamp_app2msf", Long.valueOf(System.currentTimeMillis()));
        }
        paramToServiceMsg.addAttribute("__timestamp_addSendQueue", Long.valueOf(System.currentTimeMillis()));
        if ((!this.q) && (this.r))
        {
          this.p = SystemClock.elapsedRealtime();
          this.q = true;
        }
        if (((paramToServiceMsg.getServiceCmd().equals("StatSvc.register")) || (paramToServiceMsg.getServiceCmd().equals("StatSvc.get"))) && (paramToServiceMsg.getMsfCommand().equals(MsfCommand._msf_RegPush)) && (this.r))
        {
          this.p = SystemClock.elapsedRealtime();
          this.q = true;
          ??? = com.tencent.mobileqq.msf.core.a.a.d();
          if ((??? == null) || (this.ax.size() == ???.length)) {
            break label1687;
          }
          a((String[])???);
        }
      }
      for (;;)
      {
        if ((this.r) && (SystemClock.elapsedRealtime() - this.p < this.n))
        {
          if (this.ax.size() == 0) {
            a(null);
          }
          if ((this.ax.contains(paramToServiceMsg.getServiceCmd())) || ((!TextUtils.isEmpty(paramToServiceMsg.getServiceCmd())) && (paramToServiceMsg.getServiceCmd().startsWith("wtlogin."))) || (("ConfigurationService.ReqGetConfig".equals(paramToServiceMsg.getServiceCmd())) && (((Boolean)paramToServiceMsg.getAttribute("_attr_disable_merge", Boolean.valueOf(false))).booleanValue())))
          {
            return g(paramToServiceMsg);
            if ((!paramToServiceMsg.getUin().equals("0")) || (paramToServiceMsg.getAttributes().containsKey("__base_tag_isAppMsg")) || (paramToServiceMsg.getServiceCmd().equals("PhSigLcId.Check"))) {
              break;
            }
            paramToServiceMsg.setUin(j());
            break;
            label1687:
            if (??? != null) {
              continue;
            }
            a(null);
            continue;
          }
          this.L = SystemClock.elapsedRealtime();
          this.h.add(paramToServiceMsg);
          i1 = paramToServiceMsg.getWupBuffer().length;
          for (;;)
          {
            synchronized (this.az)
            {
              this.l = (i1 + this.l);
              if (!this.ay)
              {
                this.ao.postDelayed(this.i, this.m);
                this.ay = true;
              }
              ??? = paramToServiceMsg.getServiceCmd();
              if (QLog.isColorLevel())
              {
                QLog.d("MSF.C.NetConnTag", 2, "add " + paramToServiceMsg.getRequestSsoSeq() + " cmd: " + (String)??? + " uin: " + paramToServiceMsg.getUin() + " len: " + paramToServiceMsg.getWupBuffer().length + " msg to SSO.LoginMerge delayWaitSendList");
                return paramToServiceMsg.getRequestSsoSeq();
              }
            }
            QLog.d("MSF.C.NetConnTag", 1, "add " + paramToServiceMsg.getRequestSsoSeq() + " cmd:" + com.tencent.mobileqq.msf.core.b.c.a((String)???) + " uin: " + MsfSdkUtils.getShortUin(paramToServiceMsg.getUin()) + " len: " + paramToServiceMsg.getWupBuffer().length + " msg to " + com.tencent.mobileqq.msf.core.b.c.a("SSO.LoginMerge") + " delayWaitSendList");
          }
        }
      }
      return g(paramToServiceMsg);
      i1 = 0;
      continue;
      label1969:
      i1 = 1;
      ??? = localObject2;
    }
  }
  
  public long b()
  {
    return this.aD;
  }
  
  public void b(int paramInt)
  {
    try
    {
      if ((this.b.b()) && (this.b.l() != null) && (this.b.l().i() == paramInt)) {
        b(true);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void b(FromServiceMsg paramFromServiceMsg)
  {
    if ((this.an == null) || (!this.an.getAttributes().containsKey("_attr_regprxy_socket_hashcode")) || (!this.an.getAttributes().containsKey("_attr_regprxy_random_code")))
    {
      QLog.d("MSF.C.NetConnTag", 1, "not tag regprxysvc resp seq:" + paramFromServiceMsg.getRequestSsoSeq() + " by infoLogin error");
      return;
    }
    int i1 = this.b.l().i();
    if ((!this.b.b()) || (i1 == 0))
    {
      QLog.d("MSF.C.NetConnTag", 1, "not tag regprxysvc resp seq:" + paramFromServiceMsg.getRequestSsoSeq() + " by disconn, sockethashcode = " + i1);
      return;
    }
    if (i1 == ((Integer)this.an.getAttributes().get("_attr_regprxy_socket_hashcode")).intValue())
    {
      paramFromServiceMsg.getAttributes().put("_attr_regprxy_random_code", this.an.getAttributes().get("_attr_regprxy_random_code"));
      return;
    }
    QLog.d("MSF.C.NetConnTag", 1, "not tag regprxysvc resp seq:" + paramFromServiceMsg.getRequestSsoSeq() + " by socket changed");
  }
  
  public ToServiceMsg c(int paramInt)
  {
    ToServiceMsg localToServiceMsg = (ToServiceMsg)this.d.remove(Integer.valueOf(paramInt));
    if (localToServiceMsg != null)
    {
      Runnable localRunnable = (Runnable)localToServiceMsg.getAttributes().remove("to_timeoutCallbacker");
      this.D.msfAlarmer.b().removeCallbacks(localRunnable);
      if (com.tencent.mobileqq.msf.core.a.a.x())
      {
        localRunnable = (Runnable)localToServiceMsg.getAttributes().remove("to_predetect_timeoutCallbacker");
        if (localRunnable != null) {
          this.D.msfAlarmer.b().removeCallbacks(localRunnable);
        }
      }
      if ((this.D.getStatReporter() != null) && (localToServiceMsg.isSupportRetry())) {
        this.D.getStatReporter().e(true);
      }
    }
    return localToServiceMsg;
  }
  
  public void c()
  {
    this.aD = 0L;
  }
  
  public void c(ToServiceMsg paramToServiceMsg)
  {
    this.d.put(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()), paramToServiceMsg);
    paramToServiceMsg.getAttributes().put("__extraTimeoutSeq", Integer.valueOf(ap.incrementAndGet()));
    if (paramToServiceMsg.getTimeout() == -1L) {
      paramToServiceMsg.setTimeout(30000L);
    }
    for (Runnable localRunnable = this.D.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout());; localRunnable = this.D.msfAlarmer.a(paramToServiceMsg, paramToServiceMsg.getTimeout()))
    {
      paramToServiceMsg.addAttribute("to_timeoutCallbacker", localRunnable);
      return;
    }
  }
  
  public void d(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg != null)
    {
      Runnable localRunnable = (Runnable)paramToServiceMsg.getAttributes().remove("to_timeoutCallbacker");
      if (localRunnable != null) {
        this.D.msfAlarmer.b().removeCallbacks(localRunnable);
      }
      if (com.tencent.mobileqq.msf.core.a.a.x())
      {
        paramToServiceMsg = (Runnable)paramToServiceMsg.getAttributes().remove("to_predetect_timeoutCallbacker");
        if (paramToServiceMsg != null) {
          this.D.msfAlarmer.b().removeCallbacks(paramToServiceMsg);
        }
      }
    }
  }
  
  public boolean d()
  {
    return this.d.isEmpty();
  }
  
  public byte[] e()
  {
    return this.aG;
  }
  
  public byte[] e(ToServiceMsg paramToServiceMsg)
  {
    Object localObject1 = null;
    if (paramToServiceMsg != null) {}
    for (;;)
    {
      try
      {
        Object localObject2 = paramToServiceMsg.getServiceCmd();
        i1 = ((String)localObject2).indexOf("#");
        localObject1 = localObject2;
        if (i1 != -1) {
          localObject1 = ((String)localObject2).substring(0, i1);
        }
        if (paramToServiceMsg.getWupBuffer() != null)
        {
          byte b2 = j.b();
          i1 = (byte)NetConnInfoCenter.getActiveNetIpFamily(false);
          if (!P) {
            break label324;
          }
          b1 = (byte)(i1 | 0x4);
          if (this.b.l().b() == null) {
            break label334;
          }
          i1 = this.b.l().b().d();
          localObject2 = b(paramToServiceMsg, i1);
          byte[] arrayOfByte1 = c(paramToServiceMsg, i1);
          h();
          byte[] arrayOfByte2 = e();
          byte[] arrayOfByte3 = paramToServiceMsg.getWupBuffer();
          if (591 == CodecWarpper.getSharedObjectVersion()) {
            return CodecWarpper.nativeEncodeRequest(paramToServiceMsg.getRequestSsoSeq(), w.d(), w.f(), w.g(), "", (String)localObject1, arrayOfByte2, paramToServiceMsg.getAppId(), this.D.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b2, arrayOfByte3, false);
          }
          if ((595 == CodecWarpper.getSharedObjectVersion()) || (600 == CodecWarpper.getSharedObjectVersion())) {
            return CodecWarpper.nativeEncodeRequest(paramToServiceMsg.getRequestSsoSeq(), w.d(), w.f(), w.g(), "", (String)localObject1, arrayOfByte2, paramToServiceMsg.getAppId(), this.D.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b2, (byte[])localObject2, arrayOfByte1, arrayOfByte3, false);
          }
          return CodecWarpper.nativeEncodeRequest(paramToServiceMsg.getRequestSsoSeq(), w.d(), w.f(), w.g(), "", (String)localObject1, arrayOfByte2, paramToServiceMsg.getAppId(), this.D.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b2, b1, (byte[])localObject2, arrayOfByte1, arrayOfByte3, false);
        }
        return new byte[0];
      }
      catch (Throwable paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        QLog.d("MSF.C.NetConnTag", 1, "encode packet failed", paramToServiceMsg);
        localObject1 = new byte[0];
      }
      return localObject1;
      label324:
      byte b1 = (byte)(i1 & 0xFFFFFFFB);
      continue;
      label334:
      int i1 = 1;
    }
  }
  
  public void f()
  {
    if (this.at != "0") {
      this.D.getAccountCenter().a(false);
    }
  }
  
  public void f(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {}
    while ((paramToServiceMsg.getMsfCommand() == MsfCommand.msf_ssoping) || (paramToServiceMsg.getMsfCommand() == MsfCommand._msf_HeartbeatAlive)) {
      return;
    }
    if (paramToServiceMsg.getAttributes().containsKey("__timestamp_msf2net")) {}
    for (long l1 = ((Long)paramToServiceMsg.getAttribute("__timestamp_msf2net")).longValue();; l1 = 0L)
    {
      if ((l1 != 0L) && (l1 <= this.b.l().e()))
      {
        QLog.d("MSF.C.NetConnTag", 1, "preDetectTimeoutMsg return before connSucc.");
        return;
      }
      for (;;)
      {
        synchronized (this.Q)
        {
          if ((!this.Q.get()) || (System.currentTimeMillis() - this.S >= com.tencent.mobileqq.msf.core.a.a.O() + 120000))
          {
            l1 = System.currentTimeMillis();
            if (!QLog.isColorLevel()) {
              break label287;
            }
            localObject = paramToServiceMsg.getServiceCmd();
            if (l1 - this.S <= com.tencent.mobileqq.msf.core.a.a.P()) {
              break label299;
            }
            y();
            QLog.d("MSF.C.NetConnTag", 1, "preDetectTimeoutMsg cmd:" + (String)localObject + ", ssoSeq:" + paramToServiceMsg.getRequestSsoSeq());
            if (this.D.statReporter != null)
            {
              localObject = new HashMap();
              ((HashMap)localObject).put("param_preDetectUin", paramToServiceMsg.getUin());
              ((HashMap)localObject).put("param_preDetectCmd", paramToServiceMsg.getServiceCmd());
              ((HashMap)localObject).put("param_preDetectSsoseq", String.valueOf(paramToServiceMsg.getRequestSsoSeq()));
              this.D.statReporter.a("dim.Msf.PreDetectTimeoutMsg", true, 0L, 0L, (Map)localObject, false, false);
            }
          }
          return;
        }
        label287:
        Object localObject = com.tencent.mobileqq.msf.core.b.c.a(paramToServiceMsg.getServiceCmd());
        continue;
        label299:
        QLog.d("MSF.C.NetConnTag", 1, "notry preDetectTimeoutMsg cmd:" + (String)localObject + ", ssoSeq:" + paramToServiceMsg.getRequestSsoSeq());
      }
    }
  }
  
  public void g()
  {
    b(false);
  }
  
  public void i()
  {
    this.C.nativeClearReceData();
  }
  
  public String j()
  {
    return this.at;
  }
  
  public int k()
  {
    return this.as;
  }
  
  public void l()
  {
    try
    {
      if (this.ah)
      {
        Iterator localIterator = this.ag.iterator();
        while (localIterator.hasNext())
        {
          HashMap localHashMap = (HashMap)localIterator.next();
          try
          {
            this.D.configManager.a(localHashMap, "");
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
          }
        }
      }
      return;
    }
    catch (Exception localException1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.NetConnTag", 2, "report waitReportData error " + localException1);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.NetConnTag", 2, "report waitReportData succ " + this.ag.size());
    }
    this.ag.clear();
    this.ah = false;
  }
  
  public void m()
  {
    Iterator localIterator = this.d.entrySet().iterator();
    label271:
    for (;;)
    {
      Object localObject1;
      int i1;
      if (localIterator.hasNext())
      {
        localObject1 = (Map.Entry)localIterator.next();
        if (localObject1 == null) {
          continue;
        }
        localObject1 = (ToServiceMsg)((Map.Entry)localObject1).getValue();
        if ((localObject1 == null) || (this.g.contains(localObject1))) {
          continue;
        }
        if (((ToServiceMsg)localObject1).isFastResendEnabled()) {
          i1 = 1;
        }
      }
      for (;;)
      {
        if (i1 == 0) {
          break label271;
        }
        Object localObject2 = MsfSdkUtils.constructResponse((ToServiceMsg)localObject1, 2901, "", null);
        ((FromServiceMsg)localObject2).setBusinessFail(2901);
        if ((localObject1 != null) && (this.D.quicksender != null) && (this.D.quicksender.b((ToServiceMsg)localObject1))) {
          this.D.quicksender.a((ToServiceMsg)localObject1, (FromServiceMsg)localObject2, -1);
        }
        this.D.addRespToQuque((ToServiceMsg)localObject1, (FromServiceMsg)localObject2);
        localIterator.remove();
        break;
        if (((ToServiceMsg)localObject1).isSupportRetry())
        {
          QLog.d("MSF.C.NetConnTag", 1, "send reteyMsg :" + ((ToServiceMsg)localObject1).getStringForLog());
          this.g.offer(localObject1);
          i1 = 0;
        }
        else
        {
          localObject2 = BaseConstants.CMD_NeedResendCmds;
          int i2 = localObject2.length;
          i1 = 0;
          for (;;)
          {
            if (i1 < i2)
            {
              Object localObject3 = localObject2[i1];
              if (((ToServiceMsg)localObject1).getServiceCmd().equals(localObject3))
              {
                i1 = 1;
                break;
              }
              i1 += 1;
              continue;
              return;
            }
          }
          i1 = 0;
        }
      }
    }
  }
  
  public void p()
  {
    if ((this.b != null) && (this.b.l() != null)) {
      this.b.l().g();
    }
  }
  
  class a
    extends CodecWarpper
  {
    a() {}
    
    private com.tencent.qphone.base.a a(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return com.tencent.qphone.base.a.u;
      case -2: 
        return com.tencent.qphone.base.a.v;
      case -3: 
        return com.tencent.qphone.base.a.w;
      case -4: 
        return com.tencent.qphone.base.a.x;
      case -5: 
        return com.tencent.qphone.base.a.j;
      case -6: 
        return com.tencent.qphone.base.a.r;
      case -7: 
        return com.tencent.qphone.base.a.s;
      case -8: 
        return com.tencent.qphone.base.a.y;
      }
      return com.tencent.qphone.base.a.G;
    }
    
    private void a(int paramInt1, int paramInt2)
    {
      if ((paramInt1 == -9) || (paramInt1 == -10) || (paramInt1 == -5))
      {
        QLog.d("Crypt." + tag, 1, "handleLenInvalid, failCode = " + paramInt1);
        CodecWarpper.setDecryptFailN(true, 3);
      }
      ak.a(paramInt1, -1L, paramInt2);
    }
    
    private void a(FromServiceMsg paramFromServiceMsg)
    {
      if (paramFromServiceMsg != null) {}
      try
      {
        paramFromServiceMsg = paramFromServiceMsg.getServiceCmd();
        if ((!TextUtils.isEmpty(paramFromServiceMsg)) && (paramFromServiceMsg.equals("SharpSvr.s2c"))) {
          com.tencent.mobileqq.msf.service.u.a("MSF:VideoPush", 3000L);
        }
        return;
      }
      catch (Throwable paramFromServiceMsg)
      {
        QLog.e(tag, 1, "checkVideoPushCmd fail.", paramFromServiceMsg);
      }
    }
    
    private void a(FromServiceMsg paramFromServiceMsg, int paramInt)
    {
      a(paramFromServiceMsg);
      paramFromServiceMsg.addAttribute("__timestamp_net2msf", Long.valueOf(System.currentTimeMillis()));
      paramFromServiceMsg.addAttribute("__timestamp_net2msf_boot", Long.valueOf(SystemClock.elapsedRealtime()));
      Object localObject = paramFromServiceMsg.getMsgCookie();
      if ((localObject != null) && (localObject.length > 0)) {
        ak.this.D.sender.a((byte[])localObject);
      }
      paramFromServiceMsg.setRequestSsoSeq(paramFromServiceMsg.getAppSeq());
      if ((!paramFromServiceMsg.isSuccess()) && (paramFromServiceMsg.getBusinessFailCode() == -10008)) {
        ak.a(paramFromServiceMsg.getUin(), false);
      }
      ToServiceMsg localToServiceMsg;
      for (;;)
      {
        if (NetConnInfoCenter.isNeedWifiAuth()) {
          NetConnInfoCenter.setNeedWifiAuth(false);
        }
        localToServiceMsg = ak.this.D.sender.c(paramFromServiceMsg.getRequestSsoSeq());
        label137:
        long l2;
        long l1;
        StringBuilder localStringBuilder;
        String str2;
        int i;
        label286:
        String str1;
        if (localToServiceMsg != null)
        {
          localObject = localToServiceMsg.getServiceCmd();
          l2 = 0L;
          l1 = l2;
          if (localToServiceMsg != null)
          {
            l1 = l2;
            if (localToServiceMsg.getAttribute("__timestamp_msf2net") != null)
            {
              l1 = l2;
              if (paramFromServiceMsg != null)
              {
                l1 = l2;
                if (paramFromServiceMsg.getAttribute("__timestamp_net2msf") != null)
                {
                  l2 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_net2msf")).longValue() - ((Long)localToServiceMsg.getAttribute("__timestamp_msf2net")).longValue();
                  l1 = l2;
                  if (l2 < 0L) {
                    l1 = 0L;
                  }
                  l2 = l1;
                  if (l1 > 2147483647L) {
                    l2 = 0L;
                  }
                  paramFromServiceMsg.addAttribute("__timestamp_msf2net", localToServiceMsg.getAttribute("__timestamp_msf2net"));
                  l1 = l2;
                }
              }
            }
          }
          localStringBuilder = new StringBuilder();
          str2 = paramFromServiceMsg.getServiceCmd();
          if (!com.tencent.mobileqq.a.a.a.b) {
            break label1053;
          }
          i = 1;
          if (!QLog.isDevelopLevel()) {
            break label1161;
          }
          if (l1 != 0L) {
            break label1058;
          }
          str1 = String.valueOf(l1);
          label306:
          if (paramFromServiceMsg.getResultCode() == 1000) {
            break label1084;
          }
          QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + " uin:" + paramFromServiceMsg.getUin() + " cmd:" + str2 + " len:" + paramInt + " costTime:" + str1 + " code:" + paramFromServiceMsg.getResultCode() + " failMsg:" + paramFromServiceMsg.getBusinessFailMsg() + " cross:" + i);
          label414:
          paramFromServiceMsg.addAttribute("_tag_LOGSTR", ak.E + "|" + paramFromServiceMsg.getRequestSsoSeq() + "|" + paramFromServiceMsg.getServiceCmd() + "|");
          paramFromServiceMsg.addAttribute("_tag_socket", ak.E);
          paramFromServiceMsg.addAttribute("_tag_localsocket", ak.F);
          paramFromServiceMsg.addAttribute("_tag_socket_nettype", Integer.valueOf(ak.G));
          if (localToServiceMsg == null) {}
        }
        try
        {
          ak.this.b.a(paramFromServiceMsg, localToServiceMsg);
          i = paramFromServiceMsg.getRequestSsoSeq();
          l2 = paramInt;
          if (localToServiceMsg == null)
          {
            bool = true;
            com.tencent.mobileqq.a.a.f.a((String)localObject, i, l2, l1, bool);
            com.tencent.mobileqq.a.a.a.a().a(localToServiceMsg, paramFromServiceMsg);
            if ((ak.this.D.isReconnectSso.get()) && (ak.this.D.sender.d()))
            {
              ak.this.b.l().b(com.tencent.qphone.base.a.h);
              ak.this.D.isReconnectSso.set(false);
            }
            if (localToServiceMsg == null) {
              break label1550;
            }
            paramFromServiceMsg.setAppSeq(localToServiceMsg.getAppSeq());
            paramFromServiceMsg.setMsfCommand(localToServiceMsg.getMsfCommand());
            paramFromServiceMsg.setAppId(localToServiceMsg.getAppId());
            if (paramFromServiceMsg.isSuccess()) {
              break label1550;
            }
            i = paramFromServiceMsg.getBusinessFailCode();
            paramInt = i;
            if (i == 302)
            {
              paramFromServiceMsg.setBusinessFail(-302);
              paramInt = -302;
            }
            if (paramInt != -302) {
              break label1441;
            }
            ak.this.b.l().b(com.tencent.qphone.base.a.i);
            ak.this.D.reSendMsg(localToServiceMsg);
            return;
            if ((paramFromServiceMsg.getUin() == null) || (paramFromServiceMsg.getUin().length() <= 4) || (ak.af.contains(paramFromServiceMsg.getUin())) || (!paramFromServiceMsg.isSuccess()) || (paramFromServiceMsg.getServiceCmd().startsWith("login.")) || (paramFromServiceMsg.getServiceCmd().startsWith("wtlogin.")) || (paramFromServiceMsg.getServiceCmd().equals("ConfigService.ClientReq")) || (paramFromServiceMsg.getServiceCmd().equals("ResourceConfig.ClientReq")) || (paramFromServiceMsg.getServiceCmd().equals("GrayUinPro.Check")) || (paramFromServiceMsg.getServiceCmd().equals("account.RequestReBindMblWTLogin_emp")) || (paramFromServiceMsg.getServiceCmd().equals("account.RequestVerifyWTLogin_emp")) || (paramFromServiceMsg.getServiceCmd().equals("ConnAuthSvr.get_app_info_emp")) || (paramFromServiceMsg.getServiceCmd().equals("ConnAuthSvr.sdk_auth_api_emp")) || (paramFromServiceMsg.getServiceCmd().equals("ConnAuthSvr.get_auth_api_list_emp"))) {
              continue;
            }
            localObject = (ConcurrentLinkedQueue)ak.t.get(paramFromServiceMsg.getUin());
            if ((localObject != null) && (((ConcurrentLinkedQueue)localObject).contains(Integer.valueOf(paramFromServiceMsg.getRequestSsoSeq()))))
            {
              ak.t.remove(paramFromServiceMsg.getUin());
              ak.a(paramFromServiceMsg.getUin(), true);
              QLog.d(tag, 1, "recv Packet removeItem setV9, ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + ", uin:" + MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()));
              continue;
            }
            QLog.d(tag, 1, "recv Packet ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + ", uin:" + MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()));
            continue;
            localObject = paramFromServiceMsg.getServiceCmd();
            break label137;
            label1053:
            i = 0;
            break label286;
            label1058:
            str1 = l1 + NetConnInfoCenter.getSignalStrengthsLog();
            break label306;
            label1084:
            QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + " uin:" + paramFromServiceMsg.getUin() + " cmd:" + str2 + " len:" + paramInt + " costTime:" + str1 + " cross:" + i);
            break label414;
            label1161:
            if (paramFromServiceMsg.getResultCode() != 1000)
            {
              QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + " uin:" + MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()) + " cmd:" + com.tencent.mobileqq.msf.core.b.c.a(str2) + new StringBuilder().append(" ").append(paramFromServiceMsg.getRequestSsoSeq() + paramInt).toString() + " code:" + paramFromServiceMsg.getResultCode() + " failMsg:" + paramFromServiceMsg.getBusinessFailMsg() + " cross:" + i);
              break label414;
            }
            QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + " uin:" + MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()) + " cmd:" + com.tencent.mobileqq.msf.core.b.c.a(str2) + new StringBuilder().append(" ").append(paramFromServiceMsg.getRequestSsoSeq() + paramInt).toString() + " cross:" + i);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ak.this.b.g();
            ak.this.b.m = 0L;
            QLog.d(tag, 1, "call firstResponseGetted error " + localException, localException);
            continue;
            boolean bool = false;
          }
          label1441:
          if (paramInt == -10008)
          {
            if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getRequestSsoSeq() == 0)) {
              MsfCore.sCore.getStatReporter().a(false, localToServiceMsg, paramFromServiceMsg);
            }
            if (!MsfMsgUtil.hasResendBy10008(localToServiceMsg))
            {
              localToServiceMsg.getAttributes().put("_attr_msg_has_resend_by_10008", Boolean.valueOf(true));
              QLog.d(tag, 1, "Resend 10008 " + localToServiceMsg.getShortStringForLog());
              ak.this.D.reSendMsg(localToServiceMsg);
              return;
            }
            QLog.d(tag, 1, "This msg has already resend by -10008, won't resend again!");
          }
        }
      }
      label1550:
      if (ak.t().get()) {
        QLog.e(tag, 1, "invalidSign, " + paramFromServiceMsg + " is droped.");
      }
      for (;;)
      {
        ak.this.D.getAccountCenter().g.a();
        aa.a().z();
        ak.this.l();
        return;
        if (paramFromServiceMsg.getBusinessFailCode() == -10113)
        {
          QLog.d("Crypt." + tag, 1, "server decrypt fail, res code = " + paramFromServiceMsg.getBusinessFailCode());
          CodecWarpper.setDecryptFailN(true, 1);
          ak.a(paramFromServiceMsg.getBusinessFailCode(), paramFromServiceMsg.getRequestSsoSeq(), 0);
        }
        else if (paramFromServiceMsg.getMsfCommand() == MsfCommand._msf_HeartbeatAlive)
        {
          ak.this.a(paramFromServiceMsg, localToServiceMsg);
        }
        else if (paramFromServiceMsg.getMsfCommand() == MsfCommand._msf_QuickHeartBeat)
        {
          ak.this.D.quicksender.a(localToServiceMsg, paramFromServiceMsg, false);
        }
        else
        {
          ak.A.set(0);
          ak.B.clear();
          ak.this.D.getSsoRespHandler().b(localToServiceMsg, paramFromServiceMsg);
        }
      }
    }
    
    private void a(ByteBuffer paramByteBuffer)
    {
      if (!ak.u()) {
        return;
      }
      if (paramByteBuffer.remaining() < 16)
      {
        QLog.d(tag, 1, "setGatewayIpV6, remaining = " + paramByteBuffer.remaining());
        return;
      }
      for (;;)
      {
        int i;
        try
        {
          StringBuilder localStringBuilder = new StringBuilder();
          byte[] arrayOfByte = new byte[2];
          i = 0;
          if (i < 8)
          {
            paramByteBuffer.get(arrayOfByte);
            localStringBuilder.append(HexUtil.bytes2HexStr(arrayOfByte));
            if (i == 7) {
              break label226;
            }
            localStringBuilder.append(":");
            break label226;
          }
          paramByteBuffer = f.a(localStringBuilder.toString().toLowerCase());
          ak.e(paramByteBuffer);
          if (!QLog.isDevelopLevel()) {
            break label170;
          }
          QLog.d(tag, 2, "setGatewayIpV6, ip = " + paramByteBuffer);
          return;
        }
        catch (Throwable paramByteBuffer) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(tag, 2, "setGatewayIpV6 throws e", paramByteBuffer);
        return;
        label170:
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(tag, 2, "setGatewayIpV6, " + com.tencent.mobileqq.msf.core.b.c.a(new StringBuilder().append("ip = ").append(paramByteBuffer).toString()));
        return;
        label226:
        i += 1;
      }
    }
    
    public void a(int paramInt1, int paramInt2, int paramInt3)
    {
      QLog.d(tag, 1, "MSF.C.CodecWarpper loginMerge onInvalidData " + paramInt1 + " size is " + paramInt2 + ", try to closeConn");
      ak.this.b.l().b(a(paramInt1));
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(ak.d(ak.this)).append("|").append(MsfCore.mobileQQAppid).append("|").append(paramInt3).append("|").append(paramInt1).append("|").append(ak.this.b.l().b().a());
      if (QLog.isDevelopLevel()) {
        QLog.d(tag, 4, "CodecStatHelper Report loginMerge_error " + localStringBuffer.toString());
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("loginMerge_failDetail", localStringBuffer.toString());
      if (MsfService.getCore().getStatReporter() != null) {
        MsfService.getCore().getStatReporter().a("loginMerge_error", true, 0L, 0L, localHashMap, false, false);
      }
    }
    
    public void onInvalidData(int paramInt1, int paramInt2)
    {
      QLog.d("Crypt." + tag, 1, "MSF.C.CodecWarpper onInvalidData " + paramInt1 + " size is " + paramInt2 + ", try to closeConn");
      a(paramInt1, paramInt2);
      ak.this.b.l().b(a(paramInt1));
      try
      {
        ak.this.b.i();
        return;
      }
      catch (Exception localException)
      {
        QLog.d(tag, 1, "call findResponseDataError error " + localException);
      }
    }
    
    public void onInvalidSign()
    {
      QLog.d(tag, 1, "MSF.C.CodecWarpper onInvalidSign");
      FromServiceMsg localFromServiceMsg = new FromServiceMsg(ak.this.D.getMsfAppid(), MsfCore.getNextSeq(), "0", "cmd_InvalidSign");
      localFromServiceMsg.setBusinessFail(2014, "onInvalidSign");
      localFromServiceMsg.setMsfCommand(MsfCommand.onInvalidSign);
      MsfSdkUtils.addFromMsgProcessName("*", localFromServiceMsg);
      ak.this.D.addRespToQuque(null, localFromServiceMsg);
      ak.t().set(true);
    }
    
    public void onResponse(int paramInt1, Object paramObject, int paramInt2)
    {
      Object localObject1 = null;
      if (paramObject != null) {}
      try
      {
        if (ak.V != -1) {
          ak.V = -1;
        }
        ak.this.T = System.currentTimeMillis();
        ak.U = ak.this.T;
        localObject2 = (FromServiceMsg)paramObject;
        try
        {
          paramInt1 = ((FromServiceMsg)localObject2).getWupBuffer().length;
          if (!((FromServiceMsg)localObject2).getServiceCmd().equals("SSO.LoginMerge")) {
            break label417;
          }
          ((FromServiceMsg)localObject2).setRequestSsoSeq(((FromServiceMsg)localObject2).getAppSeq());
          if (((FromServiceMsg)localObject2).isSuccess()) {
            break label417;
          }
          if (!QLog.isColorLevel()) {
            break label404;
          }
          localObject1 = ((FromServiceMsg)localObject2).getServiceCmd();
          QLog.d("MSF.C.NetConnTag", 1, "failed merge netRecv ssoSeq:" + ((FromServiceMsg)localObject2).getRequestSsoSeq() + " cmd: " + (String)localObject1 + " len: " + ((FromServiceMsg)localObject2).getWupBuffer().length);
          localObject1 = (ArrayList)ak.this.e.remove(Integer.valueOf(((FromServiceMsg)localObject2).getRequestSsoSeq()));
          if (((FromServiceMsg)localObject2).getBusinessFailCode() == -10107)
          {
            if (ak.this.r) {
              ak.this.r = false;
            }
            QLog.d("MSF.C.NetConnTag", 1, "merge not support, " + Arrays.toString(((ArrayList)localObject1).toArray()) + "resend, close merge.");
          }
          if (localObject1 == null) {
            break label417;
          }
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            paramInt1 = ((Integer)((Iterator)localObject1).next()).intValue();
            ToServiceMsg localToServiceMsg = ak.this.D.sender.c(paramInt1);
            if (localToServiceMsg != null) {
              ak.a(ak.this, localToServiceMsg);
            }
          }
          if (!((Throwable)localObject2).toString().contains("InvalidProtocol")) {
            break label354;
          }
        }
        catch (Throwable localThrowable2)
        {
          localObject1 = localObject2;
          localObject2 = localThrowable2;
        }
      }
      catch (Throwable localThrowable1)
      {
        Object localObject2;
        label323:
        label354:
        break label323;
      }
      if (localObject1 != null) {
        a(-8, paramInt2, ((FromServiceMsg)localObject1).getRequestSsoSeq());
      }
      if (QLog.isColorLevel()) {
        QLog.d(tag, 2, "handleSsoResp " + paramObject + " error " + ((Throwable)localObject2).toString(), (Throwable)localObject2);
      }
      for (;;)
      {
        return;
        label404:
        localObject1 = com.tencent.mobileqq.msf.core.b.c.a(((FromServiceMsg)localObject2).getServiceCmd());
        break;
        label417:
        int i;
        if ((((FromServiceMsg)localObject2).getFlag() & 0x1) != 0)
        {
          localObject1 = ((FromServiceMsg)localObject2).getWupBuffer();
          i = localObject1.length;
          if (i > 4) {
            i = (localObject1[0] & 0xFF) << 24 | 0x0 | (localObject1[1] & 0xFF) << 16 | (localObject1[2] & 0xFF) << 8 | localObject1[3] & 0xFF;
          }
        }
        else
        {
          try
          {
            Object localObject3 = new byte[i];
            System.arraycopy(localObject1, 4, localObject3, 0, i - 4);
            localObject3 = l.b((byte[])localObject3);
            Object localObject4 = new byte[localObject3.length + 4];
            localObject4[0] = ((byte)(localObject3.length + 4 >> 24 & 0xFF));
            localObject4[1] = ((byte)(localObject3.length + 4 >> 16 & 0xFF));
            localObject4[2] = ((byte)(localObject3.length + 4 >> 8 & 0xFF));
            localObject4[3] = ((byte)(localObject3.length + 4 & 0xFF));
            System.arraycopy(localObject3, 0, localObject4, 4, localObject3.length);
            ((FromServiceMsg)localObject2).putWupBuffer((byte[])localObject4);
            if ((!((FromServiceMsg)localObject2).isSuccess()) || (!((FromServiceMsg)localObject2).getServiceCmd().equals("SSO.LoginMerge"))) {
              break label1002;
            }
            QLog.d("MSF.C.NetConnTag", 1, "netRecv Delay FromServiceMsg ssoSeq:" + ((FromServiceMsg)localObject2).getRequestSsoSeq() + " scmd: " + ((FromServiceMsg)localObject2).getServiceCmd() + " len: " + paramInt1 + " uncompressed len: " + ((FromServiceMsg)localObject2).getWupBuffer().length);
            localObject1 = new SSOLoginMerge.BusiBuffData();
            localObject3 = new byte[((FromServiceMsg)localObject2).getWupBuffer().length - 4];
            System.arraycopy(((FromServiceMsg)localObject2).getWupBuffer(), 4, localObject3, 0, localObject3.length);
            localObject1 = ((SSOLoginMerge.BusiBuffData)((SSOLoginMerge.BusiBuffData)localObject1).mergeFrom((byte[])localObject3)).BusiBuffVec.get().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject3 = (SSOLoginMerge.BusiBuffItem)((Iterator)localObject1).next();
              localObject4 = new FromServiceMsg();
              ((FromServiceMsg)localObject4).setServiceCmd(((SSOLoginMerge.BusiBuffItem)localObject3).ServiceCmd.get());
              ((FromServiceMsg)localObject4).setRequestSsoSeq(((SSOLoginMerge.BusiBuffItem)localObject3).SeqNo.get());
              ((FromServiceMsg)localObject4).putWupBuffer(((SSOLoginMerge.BusiBuffItem)localObject3).BusiBuff.get().toByteArray());
              ((FromServiceMsg)localObject4).setAppSeq(((FromServiceMsg)localObject4).getRequestSsoSeq());
              ((FromServiceMsg)localObject4).setMsgSuccess();
              ((FromServiceMsg)localObject4).setUin(((FromServiceMsg)localObject2).getUin());
              ((FromServiceMsg)localObject4).putWupBuffer(ak.b(((FromServiceMsg)localObject4).getWupBuffer()));
              a((FromServiceMsg)localObject4, ((FromServiceMsg)localObject4).getWupBuffer().length);
            }
            if (((FromServiceMsg)localObject2).getServiceCmd().equals("SSO.LoginMerge")) {
              break label987;
            }
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel()) {
              QLog.d(tag, 2, "uncompress data failed " + localException);
            }
            if (!((FromServiceMsg)localObject2).getServiceCmd().equals("SSO.LoginMerge"))
            {
              onInvalidData(-7, localObject1.length);
              return;
            }
            a(-7, localObject1.length, ((FromServiceMsg)localObject2).getRequestSsoSeq());
            return;
          }
        }
      }
      onInvalidData(-6, localObject1.length);
      return;
      label987:
      a(-6, localObject1.length, ((FromServiceMsg)localObject2).getRequestSsoSeq());
      return;
      label1002:
      a((FromServiceMsg)localObject2, paramInt2);
    }
    
    /* Error */
    public void onResponse(int paramInt1, Object paramObject, int paramInt2, byte[] paramArrayOfByte)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 10
      //   3: aload_2
      //   4: ifnull +428 -> 432
      //   7: getstatic 697	com/tencent/mobileqq/msf/core/ak:V	I
      //   10: iconst_m1
      //   11: if_icmpeq +7 -> 18
      //   14: iconst_m1
      //   15: putstatic 697	com/tencent/mobileqq/msf/core/ak:V	I
      //   18: aload_0
      //   19: getfield 12	com/tencent/mobileqq/msf/core/ak$a:a	Lcom/tencent/mobileqq/msf/core/ak;
      //   22: invokestatic 135	java/lang/System:currentTimeMillis	()J
      //   25: putfield 700	com/tencent/mobileqq/msf/core/ak:T	J
      //   28: aload_0
      //   29: getfield 12	com/tencent/mobileqq/msf/core/ak$a:a	Lcom/tencent/mobileqq/msf/core/ak;
      //   32: getfield 700	com/tencent/mobileqq/msf/core/ak:T	J
      //   35: putstatic 703	com/tencent/mobileqq/msf/core/ak:U	J
      //   38: aload_2
      //   39: checkcast 90	com/tencent/qphone/base/remote/FromServiceMsg
      //   42: astore 9
      //   44: aload 9
      //   46: invokevirtual 706	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
      //   49: arraylength
      //   50: istore_1
      //   51: aload 9
      //   53: invokevirtual 235	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
      //   56: tableswitch	default:+1430 -> 1486, -10112:+561->617, -10111:+460->516, -10110:+377->433
      //   85: lconst_0
      //   86: invokevirtual 93	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   89: ldc_w 708
      //   92: invokevirtual 107	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   95: ifeq +569 -> 664
      //   98: aload 9
      //   100: aload 9
      //   102: invokevirtual 172	com/tencent/qphone/base/remote/FromServiceMsg:getAppSeq	()I
      //   105: invokevirtual 176	com/tencent/qphone/base/remote/FromServiceMsg:setRequestSsoSeq	(I)V
      //   108: aload 9
      //   110: invokevirtual 180	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
      //   113: ifne +551 -> 664
      //   116: invokestatic 598	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   119: ifeq +532 -> 651
      //   122: aload 9
      //   124: invokevirtual 93	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   127: astore 8
      //   129: ldc 237
      //   131: iconst_1
      //   132: new 50	java/lang/StringBuilder
      //   135: dup
      //   136: invokespecial 51	java/lang/StringBuilder:<init>	()V
      //   139: ldc_w 710
      //   142: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   145: aload 9
      //   147: invokevirtual 201	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
      //   150: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   153: ldc_w 712
      //   156: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   159: aload 8
      //   161: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   164: ldc_w 714
      //   167: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   170: aload 9
      //   172: invokevirtual 706	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
      //   175: arraylength
      //   176: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   179: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   182: invokestatic 76	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   185: aload_0
      //   186: getfield 12	com/tencent/mobileqq/msf/core/ak$a:a	Lcom/tencent/mobileqq/msf/core/ak;
      //   189: getfield 716	com/tencent/mobileqq/msf/core/ak:e	Ljava/util/concurrent/ConcurrentHashMap;
      //   192: aload 9
      //   194: invokevirtual 201	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
      //   197: invokestatic 280	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   200: invokevirtual 404	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
      //   203: checkcast 552	java/util/ArrayList
      //   206: astore 8
      //   208: aload 9
      //   210: invokevirtual 183	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailCode	()I
      //   213: sipush -10107
      //   216: if_icmpne +60 -> 276
      //   219: aload_0
      //   220: getfield 12	com/tencent/mobileqq/msf/core/ak$a:a	Lcom/tencent/mobileqq/msf/core/ak;
      //   223: getfield 718	com/tencent/mobileqq/msf/core/ak:r	Z
      //   226: ifeq +11 -> 237
      //   229: aload_0
      //   230: getfield 12	com/tencent/mobileqq/msf/core/ak$a:a	Lcom/tencent/mobileqq/msf/core/ak;
      //   233: iconst_0
      //   234: putfield 718	com/tencent/mobileqq/msf/core/ak:r	Z
      //   237: ldc 237
      //   239: iconst_1
      //   240: new 50	java/lang/StringBuilder
      //   243: dup
      //   244: invokespecial 51	java/lang/StringBuilder:<init>	()V
      //   247: ldc_w 720
      //   250: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   253: aload 8
      //   255: invokevirtual 724	java/util/ArrayList:toArray	()[Ljava/lang/Object;
      //   258: invokestatic 729	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
      //   261: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   264: ldc_w 731
      //   267: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   270: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   273: invokestatic 76	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   276: aload 8
      //   278: ifnull +386 -> 664
      //   281: aload 8
      //   283: invokevirtual 735	java/util/ArrayList:iterator	()Ljava/util/Iterator;
      //   286: astore 4
      //   288: aload 4
      //   290: invokeinterface 740 1 0
      //   295: ifeq +137 -> 432
      //   298: aload 4
      //   300: invokeinterface 744 1 0
      //   305: checkcast 277	java/lang/Integer
      //   308: invokevirtual 747	java/lang/Integer:intValue	()I
      //   311: istore_1
      //   312: aload_0
      //   313: getfield 12	com/tencent/mobileqq/msf/core/ak$a:a	Lcom/tencent/mobileqq/msf/core/ak;
      //   316: getfield 160	com/tencent/mobileqq/msf/core/ak:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   319: getfield 165	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
      //   322: iload_1
      //   323: invokevirtual 205	com/tencent/mobileqq/msf/core/ak:c	(I)Lcom/tencent/qphone/base/remote/ToServiceMsg;
      //   326: astore 8
      //   328: aload 8
      //   330: ifnull -42 -> 288
      //   333: aload_0
      //   334: getfield 12	com/tencent/mobileqq/msf/core/ak$a:a	Lcom/tencent/mobileqq/msf/core/ak;
      //   337: aload 8
      //   339: invokestatic 750	com/tencent/mobileqq/msf/core/ak:a	(Lcom/tencent/mobileqq/msf/core/ak;Lcom/tencent/qphone/base/remote/ToServiceMsg;)I
      //   342: pop
      //   343: goto -55 -> 288
      //   346: astore 8
      //   348: aload 9
      //   350: astore 4
      //   352: aload 8
      //   354: invokevirtual 751	java/lang/Throwable:toString	()Ljava/lang/String;
      //   357: ldc_w 753
      //   360: invokevirtual 755	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   363: ifeq +20 -> 383
      //   366: aload 4
      //   368: ifnull +15 -> 383
      //   371: aload_0
      //   372: bipush 248
      //   374: iload_3
      //   375: aload 4
      //   377: invokevirtual 201	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
      //   380: invokevirtual 757	com/tencent/mobileqq/msf/core/ak$a:a	(III)V
      //   383: invokestatic 598	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   386: ifeq +46 -> 432
      //   389: getstatic 61	com/tencent/mobileqq/msf/core/ak$a:tag	Ljava/lang/String;
      //   392: iconst_2
      //   393: new 50	java/lang/StringBuilder
      //   396: dup
      //   397: invokespecial 51	java/lang/StringBuilder:<init>	()V
      //   400: ldc_w 759
      //   403: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   406: aload_2
      //   407: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   410: ldc_w 761
      //   413: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   416: aload 8
      //   418: invokevirtual 751	java/lang/Throwable:toString	()Ljava/lang/String;
      //   421: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   424: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   427: aload 8
      //   429: invokestatic 442	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   432: return
      //   433: aload_0
      //   434: getfield 12	com/tencent/mobileqq/msf/core/ak$a:a	Lcom/tencent/mobileqq/msf/core/ak;
      //   437: getfield 160	com/tencent/mobileqq/msf/core/ak:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   440: getfield 855	com/tencent/mobileqq/msf/core/MsfCore:ssoListManager	Lcom/tencent/mobileqq/msf/core/a/c;
      //   443: invokevirtual 859	com/tencent/mobileqq/msf/core/a/c:e	()V
      //   446: aload_0
      //   447: getfield 12	com/tencent/mobileqq/msf/core/ak$a:a	Lcom/tencent/mobileqq/msf/core/ak;
      //   450: getfield 160	com/tencent/mobileqq/msf/core/ak:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   453: getfield 165	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
      //   456: getfield 283	com/tencent/mobileqq/msf/core/ak:b	Lcom/tencent/mobileqq/msf/core/net/n;
      //   459: invokevirtual 314	com/tencent/mobileqq/msf/core/net/n:l	()Lcom/tencent/mobileqq/msf/core/net/m;
      //   462: getstatic 317	com/tencent/qphone/base/a:h	Lcom/tencent/qphone/base/a;
      //   465: invokevirtual 322	com/tencent/mobileqq/msf/core/net/m:b	(Lcom/tencent/qphone/base/a;)V
      //   468: aload_0
      //   469: getfield 12	com/tencent/mobileqq/msf/core/ak$a:a	Lcom/tencent/mobileqq/msf/core/ak;
      //   472: getfield 160	com/tencent/mobileqq/msf/core/ak:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   475: getfield 303	com/tencent/mobileqq/msf/core/MsfCore:isReconnectSso	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   478: iconst_0
      //   479: invokevirtual 325	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
      //   482: getstatic 61	com/tencent/mobileqq/msf/core/ak$a:tag	Ljava/lang/String;
      //   485: iconst_1
      //   486: new 50	java/lang/StringBuilder
      //   489: dup
      //   490: invokespecial 51	java/lang/StringBuilder:<init>	()V
      //   493: ldc_w 861
      //   496: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   499: aload 9
      //   501: invokevirtual 235	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
      //   504: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   507: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   510: invokestatic 76	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   513: goto -429 -> 84
      //   516: getstatic 61	com/tencent/mobileqq/msf/core/ak$a:tag	Ljava/lang/String;
      //   519: iconst_1
      //   520: new 50	java/lang/StringBuilder
      //   523: dup
      //   524: invokespecial 51	java/lang/StringBuilder:<init>	()V
      //   527: ldc_w 863
      //   530: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   533: aload 9
      //   535: invokevirtual 235	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
      //   538: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   541: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   544: invokestatic 76	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   547: aload_0
      //   548: getfield 12	com/tencent/mobileqq/msf/core/ak$a:a	Lcom/tencent/mobileqq/msf/core/ak;
      //   551: getfield 160	com/tencent/mobileqq/msf/core/ak:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   554: getfield 855	com/tencent/mobileqq/msf/core/MsfCore:ssoListManager	Lcom/tencent/mobileqq/msf/core/a/c;
      //   557: invokevirtual 859	com/tencent/mobileqq/msf/core/a/c:e	()V
      //   560: iconst_1
      //   561: invokestatic 867	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getActiveNetIpFamily	(Z)I
      //   564: iconst_2
      //   565: if_icmpeq -481 -> 84
      //   568: aload_0
      //   569: getfield 12	com/tencent/mobileqq/msf/core/ak$a:a	Lcom/tencent/mobileqq/msf/core/ak;
      //   572: getfield 160	com/tencent/mobileqq/msf/core/ak:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   575: getfield 165	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ak;
      //   578: getfield 283	com/tencent/mobileqq/msf/core/ak:b	Lcom/tencent/mobileqq/msf/core/net/n;
      //   581: invokevirtual 314	com/tencent/mobileqq/msf/core/net/n:l	()Lcom/tencent/mobileqq/msf/core/net/m;
      //   584: getstatic 317	com/tencent/qphone/base/a:h	Lcom/tencent/qphone/base/a;
      //   587: invokevirtual 322	com/tencent/mobileqq/msf/core/net/m:b	(Lcom/tencent/qphone/base/a;)V
      //   590: aload_0
      //   591: getfield 12	com/tencent/mobileqq/msf/core/ak$a:a	Lcom/tencent/mobileqq/msf/core/ak;
      //   594: getfield 160	com/tencent/mobileqq/msf/core/ak:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   597: getfield 303	com/tencent/mobileqq/msf/core/MsfCore:isReconnectSso	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   600: iconst_0
      //   601: invokevirtual 325	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
      //   604: getstatic 61	com/tencent/mobileqq/msf/core/ak$a:tag	Ljava/lang/String;
      //   607: iconst_1
      //   608: ldc_w 869
      //   611: invokestatic 76	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   614: goto -530 -> 84
      //   617: getstatic 61	com/tencent/mobileqq/msf/core/ak$a:tag	Ljava/lang/String;
      //   620: iconst_1
      //   621: new 50	java/lang/StringBuilder
      //   624: dup
      //   625: invokespecial 51	java/lang/StringBuilder:<init>	()V
      //   628: ldc_w 863
      //   631: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   634: aload 9
      //   636: invokevirtual 235	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
      //   639: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   642: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   645: invokestatic 76	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   648: goto -564 -> 84
      //   651: aload 9
      //   653: invokevirtual 93	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   656: invokestatic 426	com/tencent/mobileqq/msf/core/b/c:a	(Ljava/lang/String;)Ljava/lang/String;
      //   659: astore 8
      //   661: goto -532 -> 129
      //   664: aload 9
      //   666: invokevirtual 764	com/tencent/qphone/base/remote/FromServiceMsg:getFlag	()I
      //   669: iconst_1
      //   670: iand
      //   671: ifeq +188 -> 859
      //   674: aload 9
      //   676: invokevirtual 706	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
      //   679: astore 8
      //   681: aload 8
      //   683: arraylength
      //   684: istore 5
      //   686: iload 5
      //   688: iconst_4
      //   689: if_icmple +692 -> 1381
      //   692: iconst_0
      //   693: aload 8
      //   695: iconst_0
      //   696: baload
      //   697: sipush 255
      //   700: iand
      //   701: bipush 24
      //   703: ishl
      //   704: ior
      //   705: aload 8
      //   707: iconst_1
      //   708: baload
      //   709: sipush 255
      //   712: iand
      //   713: bipush 16
      //   715: ishl
      //   716: ior
      //   717: aload 8
      //   719: iconst_2
      //   720: baload
      //   721: sipush 255
      //   724: iand
      //   725: bipush 8
      //   727: ishl
      //   728: ior
      //   729: aload 8
      //   731: iconst_3
      //   732: baload
      //   733: sipush 255
      //   736: iand
      //   737: ior
      //   738: istore 5
      //   740: iload 5
      //   742: newarray byte
      //   744: astore 10
      //   746: aload 8
      //   748: iconst_4
      //   749: aload 10
      //   751: iconst_0
      //   752: iload 5
      //   754: iconst_4
      //   755: isub
      //   756: invokestatic 768	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   759: aload 10
      //   761: invokestatic 773	com/tencent/qphone/base/util/l:b	([B)[B
      //   764: astore 10
      //   766: aload 10
      //   768: arraylength
      //   769: iconst_4
      //   770: iadd
      //   771: newarray byte
      //   773: astore 11
      //   775: aload 11
      //   777: iconst_0
      //   778: aload 10
      //   780: arraylength
      //   781: iconst_4
      //   782: iadd
      //   783: bipush 24
      //   785: ishr
      //   786: sipush 255
      //   789: iand
      //   790: i2b
      //   791: bastore
      //   792: aload 11
      //   794: iconst_1
      //   795: aload 10
      //   797: arraylength
      //   798: iconst_4
      //   799: iadd
      //   800: bipush 16
      //   802: ishr
      //   803: sipush 255
      //   806: iand
      //   807: i2b
      //   808: bastore
      //   809: aload 11
      //   811: iconst_2
      //   812: aload 10
      //   814: arraylength
      //   815: iconst_4
      //   816: iadd
      //   817: bipush 8
      //   819: ishr
      //   820: sipush 255
      //   823: iand
      //   824: i2b
      //   825: bastore
      //   826: aload 11
      //   828: iconst_3
      //   829: aload 10
      //   831: arraylength
      //   832: iconst_4
      //   833: iadd
      //   834: sipush 255
      //   837: iand
      //   838: i2b
      //   839: bastore
      //   840: aload 10
      //   842: iconst_0
      //   843: aload 11
      //   845: iconst_4
      //   846: aload 10
      //   848: arraylength
      //   849: invokestatic 768	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   852: aload 9
      //   854: aload 11
      //   856: invokevirtual 776	com/tencent/qphone/base/remote/FromServiceMsg:putWupBuffer	([B)V
      //   859: aload 4
      //   861: ifnull +169 -> 1030
      //   864: aload 9
      //   866: invokevirtual 93	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   869: ldc_w 871
      //   872: invokevirtual 107	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   875: ifeq +155 -> 1030
      //   878: invokestatic 152	android/os/SystemClock:elapsedRealtime	()J
      //   881: lstore 6
      //   883: iconst_0
      //   884: lload 6
      //   886: ldc2_w 872
      //   889: lsub
      //   890: lload 6
      //   892: invokestatic 876	com/tencent/mobileqq/msf/core/c/k:a	(ZJJ)B
      //   895: putstatic 878	com/tencent/mobileqq/msf/core/ak:w	I
      //   898: new 880	com/tencent/msf/service/protocol/pb/SSOReserveField$ReserveFields
      //   901: dup
      //   902: invokespecial 881	com/tencent/msf/service/protocol/pb/SSOReserveField$ReserveFields:<init>	()V
      //   905: astore 8
      //   907: aload 8
      //   909: aload 4
      //   911: invokevirtual 882	com/tencent/msf/service/protocol/pb/SSOReserveField$ReserveFields:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
      //   914: pop
      //   915: new 50	java/lang/StringBuilder
      //   918: dup
      //   919: invokespecial 51	java/lang/StringBuilder:<init>	()V
      //   922: astore 4
      //   924: aload 4
      //   926: aload 8
      //   928: getfield 886	com/tencent/msf/service/protocol/pb/SSOReserveField$ReserveFields:sso_send	Lcom/tencent/mobileqq/pb/PBUInt64Field;
      //   931: invokevirtual 890	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
      //   934: invokevirtual 419	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   937: ldc_w 263
      //   940: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   943: invokestatic 135	java/lang/System:currentTimeMillis	()J
      //   946: invokevirtual 419	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   949: pop
      //   950: aload 9
      //   952: ldc_w 892
      //   955: aload 4
      //   957: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   960: invokevirtual 145	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
      //   963: pop
      //   964: getstatic 61	com/tencent/mobileqq/msf/core/ak$a:tag	Ljava/lang/String;
      //   967: iconst_1
      //   968: new 50	java/lang/StringBuilder
      //   971: dup
      //   972: invokespecial 51	java/lang/StringBuilder:<init>	()V
      //   975: ldc_w 894
      //   978: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   981: aload 4
      //   983: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   986: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   989: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   992: invokestatic 76	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   995: aload_0
      //   996: getfield 12	com/tencent/mobileqq/msf/core/ak$a:a	Lcom/tencent/mobileqq/msf/core/ak;
      //   999: getfield 160	com/tencent/mobileqq/msf/core/ak:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   1002: getfield 898	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
      //   1005: ifnull +25 -> 1030
      //   1008: aload_0
      //   1009: getfield 12	com/tencent/mobileqq/msf/core/ak$a:a	Lcom/tencent/mobileqq/msf/core/ak;
      //   1012: getfield 160	com/tencent/mobileqq/msf/core/ak:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   1015: getfield 898	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
      //   1018: ldc_w 900
      //   1021: iconst_1
      //   1022: lconst_0
      //   1023: lconst_0
      //   1024: aconst_null
      //   1025: iconst_0
      //   1026: iconst_0
      //   1027: invokevirtual 652	com/tencent/mobileqq/msf/core/c/k:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
      //   1030: aload 9
      //   1032: invokevirtual 180	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
      //   1035: ifeq +402 -> 1437
      //   1038: aload 9
      //   1040: invokevirtual 93	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   1043: ldc_w 708
      //   1046: invokevirtual 107	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   1049: ifeq +388 -> 1437
      //   1052: ldc 237
      //   1054: iconst_1
      //   1055: new 50	java/lang/StringBuilder
      //   1058: dup
      //   1059: invokespecial 51	java/lang/StringBuilder:<init>	()V
      //   1062: ldc_w 778
      //   1065: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1068: aload 9
      //   1070: invokevirtual 201	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
      //   1073: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1076: ldc_w 780
      //   1079: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1082: aload 9
      //   1084: invokevirtual 93	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   1087: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1090: ldc_w 714
      //   1093: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1096: iload_1
      //   1097: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1100: ldc_w 782
      //   1103: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1106: aload 9
      //   1108: invokevirtual 706	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
      //   1111: arraylength
      //   1112: invokevirtual 70	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1115: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1118: invokestatic 76	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1121: new 784	com/tencent/msf/service/protocol/pb/SSOLoginMerge$BusiBuffData
      //   1124: dup
      //   1125: invokespecial 785	com/tencent/msf/service/protocol/pb/SSOLoginMerge$BusiBuffData:<init>	()V
      //   1128: astore 4
      //   1130: aload 9
      //   1132: invokevirtual 706	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
      //   1135: arraylength
      //   1136: iconst_4
      //   1137: isub
      //   1138: newarray byte
      //   1140: astore 8
      //   1142: aload 9
      //   1144: invokevirtual 706	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
      //   1147: iconst_4
      //   1148: aload 8
      //   1150: iconst_0
      //   1151: aload 8
      //   1153: arraylength
      //   1154: invokestatic 768	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   1157: aload 4
      //   1159: aload 8
      //   1161: invokevirtual 789	com/tencent/msf/service/protocol/pb/SSOLoginMerge$BusiBuffData:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
      //   1164: checkcast 784	com/tencent/msf/service/protocol/pb/SSOLoginMerge$BusiBuffData
      //   1167: getfield 793	com/tencent/msf/service/protocol/pb/SSOLoginMerge$BusiBuffData:BusiBuffVec	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
      //   1170: invokevirtual 798	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
      //   1173: invokeinterface 801 1 0
      //   1178: astore 4
      //   1180: aload 4
      //   1182: invokeinterface 740 1 0
      //   1187: ifeq -755 -> 432
      //   1190: aload 4
      //   1192: invokeinterface 744 1 0
      //   1197: checkcast 803	com/tencent/msf/service/protocol/pb/SSOLoginMerge$BusiBuffItem
      //   1200: astore 8
      //   1202: new 90	com/tencent/qphone/base/remote/FromServiceMsg
      //   1205: dup
      //   1206: invokespecial 804	com/tencent/qphone/base/remote/FromServiceMsg:<init>	()V
      //   1209: astore 10
      //   1211: aload 10
      //   1213: aload 8
      //   1215: getfield 808	com/tencent/msf/service/protocol/pb/SSOLoginMerge$BusiBuffItem:ServiceCmd	Lcom/tencent/mobileqq/pb/PBStringField;
      //   1218: invokevirtual 812	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
      //   1221: invokevirtual 815	com/tencent/qphone/base/remote/FromServiceMsg:setServiceCmd	(Ljava/lang/String;)V
      //   1224: aload 10
      //   1226: aload 8
      //   1228: getfield 819	com/tencent/msf/service/protocol/pb/SSOLoginMerge$BusiBuffItem:SeqNo	Lcom/tencent/mobileqq/pb/PBUInt32Field;
      //   1231: invokevirtual 823	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
      //   1234: invokevirtual 176	com/tencent/qphone/base/remote/FromServiceMsg:setRequestSsoSeq	(I)V
      //   1237: aload 10
      //   1239: aload 8
      //   1241: getfield 827	com/tencent/msf/service/protocol/pb/SSOLoginMerge$BusiBuffItem:BusiBuff	Lcom/tencent/mobileqq/pb/PBBytesField;
      //   1244: invokevirtual 832	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
      //   1247: invokevirtual 837	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
      //   1250: invokevirtual 776	com/tencent/qphone/base/remote/FromServiceMsg:putWupBuffer	([B)V
      //   1253: aload 10
      //   1255: aload 10
      //   1257: invokevirtual 201	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
      //   1260: invokevirtual 329	com/tencent/qphone/base/remote/FromServiceMsg:setAppSeq	(I)V
      //   1263: aload 10
      //   1265: invokevirtual 840	com/tencent/qphone/base/remote/FromServiceMsg:setMsgSuccess	()V
      //   1268: aload 10
      //   1270: aload 9
      //   1272: invokevirtual 186	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
      //   1275: invokevirtual 843	com/tencent/qphone/base/remote/FromServiceMsg:setUin	(Ljava/lang/String;)V
      //   1278: aload 10
      //   1280: aload 10
      //   1282: invokevirtual 706	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
      //   1285: invokestatic 844	com/tencent/mobileqq/msf/core/ak:b	([B)[B
      //   1288: invokevirtual 776	com/tencent/qphone/base/remote/FromServiceMsg:putWupBuffer	([B)V
      //   1291: aload_0
      //   1292: aload 10
      //   1294: aload 10
      //   1296: invokevirtual 706	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
      //   1299: arraylength
      //   1300: invokespecial 846	com/tencent/mobileqq/msf/core/ak$a:a	(Lcom/tencent/qphone/base/remote/FromServiceMsg;I)V
      //   1303: goto -123 -> 1180
      //   1306: astore 4
      //   1308: invokestatic 598	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1311: ifeq +31 -> 1342
      //   1314: getstatic 61	com/tencent/mobileqq/msf/core/ak$a:tag	Ljava/lang/String;
      //   1317: iconst_2
      //   1318: new 50	java/lang/StringBuilder
      //   1321: dup
      //   1322: invokespecial 51	java/lang/StringBuilder:<init>	()V
      //   1325: ldc_w 848
      //   1328: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1331: aload 4
      //   1333: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   1336: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1339: invokestatic 76	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1342: aload 9
      //   1344: invokevirtual 93	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   1347: ldc_w 708
      //   1350: invokevirtual 107	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   1353: ifne +13 -> 1366
      //   1356: aload_0
      //   1357: bipush 249
      //   1359: aload 8
      //   1361: arraylength
      //   1362: invokevirtual 850	com/tencent/mobileqq/msf/core/ak$a:onInvalidData	(II)V
      //   1365: return
      //   1366: aload_0
      //   1367: bipush 249
      //   1369: aload 8
      //   1371: arraylength
      //   1372: aload 9
      //   1374: invokevirtual 201	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
      //   1377: invokevirtual 757	com/tencent/mobileqq/msf/core/ak$a:a	(III)V
      //   1380: return
      //   1381: aload 9
      //   1383: invokevirtual 93	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   1386: ldc_w 708
      //   1389: invokevirtual 107	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   1392: ifne +13 -> 1405
      //   1395: aload_0
      //   1396: bipush 250
      //   1398: aload 8
      //   1400: arraylength
      //   1401: invokevirtual 850	com/tencent/mobileqq/msf/core/ak$a:onInvalidData	(II)V
      //   1404: return
      //   1405: aload_0
      //   1406: bipush 250
      //   1408: aload 8
      //   1410: arraylength
      //   1411: aload 9
      //   1413: invokevirtual 201	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
      //   1416: invokevirtual 757	com/tencent/mobileqq/msf/core/ak$a:a	(III)V
      //   1419: return
      //   1420: astore 4
      //   1422: getstatic 61	com/tencent/mobileqq/msf/core/ak$a:tag	Ljava/lang/String;
      //   1425: iconst_1
      //   1426: ldc_w 902
      //   1429: aload 4
      //   1431: invokestatic 442	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   1434: goto -404 -> 1030
      //   1437: aload 9
      //   1439: invokevirtual 180	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
      //   1442: ifeq +27 -> 1469
      //   1445: aload 9
      //   1447: invokevirtual 93	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   1450: ldc_w 904
      //   1453: invokevirtual 107	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   1456: ifeq +13 -> 1469
      //   1459: aload 9
      //   1461: invokevirtual 706	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
      //   1464: iconst_1
      //   1465: invokestatic 910	com/tencent/mobileqq/msf/core/net/utils/MsfPullConfigUtil:parseConfigResponse	([BZ)V
      //   1468: return
      //   1469: aload_0
      //   1470: aload 9
      //   1472: iload_3
      //   1473: invokespecial 846	com/tencent/mobileqq/msf/core/ak$a:a	(Lcom/tencent/qphone/base/remote/FromServiceMsg;I)V
      //   1476: return
      //   1477: astore 8
      //   1479: aload 10
      //   1481: astore 4
      //   1483: goto -1131 -> 352
      //   1486: goto -1402 -> 84
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1489	0	this	a
      //   0	1489	1	paramInt1	int
      //   0	1489	2	paramObject	Object
      //   0	1489	3	paramInt2	int
      //   0	1489	4	paramArrayOfByte	byte[]
      //   684	72	5	i	int
      //   881	10	6	l	long
      //   127	211	8	localObject1	Object
      //   346	82	8	localThrowable1	Throwable
      //   659	750	8	localObject2	Object
      //   1477	1	8	localThrowable2	Throwable
      //   42	1429	9	localFromServiceMsg	FromServiceMsg
      //   1	1479	10	localObject3	Object
      //   773	82	11	arrayOfByte	byte[]
      // Exception table:
      //   from	to	target	type
      //   44	84	346	java/lang/Throwable
      //   84	129	346	java/lang/Throwable
      //   129	237	346	java/lang/Throwable
      //   237	276	346	java/lang/Throwable
      //   281	288	346	java/lang/Throwable
      //   288	328	346	java/lang/Throwable
      //   333	343	346	java/lang/Throwable
      //   433	513	346	java/lang/Throwable
      //   516	614	346	java/lang/Throwable
      //   617	648	346	java/lang/Throwable
      //   651	661	346	java/lang/Throwable
      //   664	686	346	java/lang/Throwable
      //   740	859	346	java/lang/Throwable
      //   864	1030	346	java/lang/Throwable
      //   1030	1180	346	java/lang/Throwable
      //   1180	1303	346	java/lang/Throwable
      //   1308	1342	346	java/lang/Throwable
      //   1342	1365	346	java/lang/Throwable
      //   1366	1380	346	java/lang/Throwable
      //   1381	1404	346	java/lang/Throwable
      //   1405	1419	346	java/lang/Throwable
      //   1422	1434	346	java/lang/Throwable
      //   1437	1468	346	java/lang/Throwable
      //   1469	1476	346	java/lang/Throwable
      //   740	859	1306	java/lang/Exception
      //   864	1030	1420	java/lang/Exception
      //   7	18	1477	java/lang/Throwable
      //   18	44	1477	java/lang/Throwable
    }
    
    public int onSSOPingResponse(byte[] paramArrayOfByte, int paramInt)
    {
      int j = 0;
      String str = "Crypt.ping." + CodecWarpper.tag;
      if (paramArrayOfByte == null)
      {
        QLog.d(str, 1, "MSF.C.CodecWarpper onSSOPingResponse error, data null, connId = " + paramInt);
        paramInt = -1;
        return paramInt;
      }
      Object localObject1 = paramArrayOfByte;
      boolean bool;
      label94:
      Object localObject2;
      if (paramArrayOfByte.length > 4)
      {
        if ((paramArrayOfByte[4] & 0x80) == 0) {
          break label201;
        }
        bool = true;
        if (!bool) {
          break label1115;
        }
        localObject1 = CodecWarpper.nativeDecodePingRequest(paramArrayOfByte);
        localObject2 = new StringBuilder().append("onSSOPingResponse ping back： isEncrypt = ").append(bool).append(", pingBack.len = ").append(paramArrayOfByte.length).append(", tmpPing.len = ");
        if (localObject1 == null) {
          break label207;
        }
      }
      label201:
      label207:
      for (int i = localObject1.length;; i = 0)
      {
        QLog.d(str, 1, i + ", s = " + StringUtils.bytes2Str(paramArrayOfByte));
        if (localObject1 != null) {
          break label212;
        }
        QLog.d(str, 1, "MSF.C.CodecWarpper onSSOPingResponse after decrypt err, data null, connId = " + paramInt);
        return 1;
        bool = false;
        break;
      }
      label212:
      if (localObject1.length <= 4)
      {
        QLog.d(str, 1, "MSF.C.CodecWarpper onSSOPingResponse error, length: " + localObject1.length);
        return 1;
      }
      int k = localObject1.length;
      try
      {
        paramArrayOfByte = ByteBuffer.wrap((byte[])localObject1);
        i = paramArrayOfByte.getInt();
        if (i != k) {
          return 1;
        }
        int m = paramArrayOfByte.getInt();
        if ((m < 20121114) || (m > 20371119)) {
          break label1121;
        }
        paramArrayOfByte.getInt();
        m = paramArrayOfByte.get() - 1;
        if ((m <= 0) || (m > i - 13)) {
          break label1123;
        }
        localObject2 = new byte[m];
        paramArrayOfByte.get((byte[])localObject2, 0, m);
        localObject2 = new String((byte[])localObject2);
        if ((!((String)localObject2).equals("MSF")) && (!((String)localObject2).equals("GWv4")) && (com.tencent.mobileqq.msf.core.a.a.aQ()))
        {
          bool = com.tencent.mobileqq.msf.core.net.a.b.b();
          if (bool) {
            try
            {
              com.tencent.mobileqq.msf.core.net.a.b.b((byte[])localObject1);
              return 0;
            }
            catch (Exception paramArrayOfByte)
            {
              QLog.d(str, 1, "heartbeatproxy failed to process back msg ", paramArrayOfByte);
              return 0;
            }
          }
        }
        paramArrayOfByte.position(paramArrayOfByte.get() + paramArrayOfByte.position() - 1);
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        QLog.d(str, 1, "MSF.C.CodecWarpper onSSOPingResponse error, exception : ", paramArrayOfByte);
        return 0;
      }
      i = paramArrayOfByte.getInt();
      Object localObject3 = (i >> 24 & 0xFF) + '.' + (i >> 16 & 0xFF) + '.' + (i >> 8 & 0xFF) + '.' + (i & 0xFF);
      a(paramArrayOfByte);
      if ("GWv4".equals(localObject2))
      {
        ak.O = i;
        if (localObject1.length == 50)
        {
          byte[] arrayOfByte = new byte[24];
          paramArrayOfByte.get(arrayOfByte, 0, 24);
          ak.N = arrayOfByte;
          if (QLog.isColorLevel()) {
            QLog.d(str, 2, "MSF.C.CodecWarpper onSSOPingResponse sGwV4Sec:" + ak.N);
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(str, 2, "MSF.C.CodecWarpper onSSOPingResponse cmd:" + (String)localObject2 + ", ip=" + (String)localObject3 + ", totalsize=" + k);
      }
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        i = 0;
        while (i < k)
        {
          if (i % 4 == 0) {
            ((StringBuilder)localObject3).append("\n");
          }
          localObject2 = Integer.toHexString(localObject1[i] & 0xFF);
          paramArrayOfByte = (byte[])localObject2;
          if (((String)localObject2).length() == 1) {
            paramArrayOfByte = "0" + (String)localObject2;
          }
          ((StringBuilder)localObject3).append(paramArrayOfByte).append(" ");
          i += 1;
        }
        QLog.d(str, 2, "MSF.C.CodecWarpper onSSOPingResponse pingBack=" + ((StringBuilder)localObject3).toString());
      }
      ak.this.b.e(paramInt);
      localObject1 = ak.this.b.l().h();
      long l2;
      long l1;
      if ((localObject1 != null) && (((ToServiceMsg)localObject1).getAttribute("__timestamp_msf2net") != null))
      {
        l2 = SystemClock.elapsedRealtime() - ((Long)((ToServiceMsg)localObject1).getAttribute("__timestamp_msf2net")).longValue();
        l1 = l2;
        if (l2 >= 0L) {
          break label1125;
        }
        l1 = 0L;
      }
      for (;;)
      {
        paramInt = j;
        if (localObject1 == null) {
          break;
        }
        com.tencent.mobileqq.a.a.a.a().a(((ToServiceMsg)localObject1).getRequestSsoSeq(), l2);
        localObject2 = new StringBuilder();
        paramArrayOfByte = ((ToServiceMsg)localObject1).getServiceCmd();
        if (QLog.isDevelopLevel())
        {
          if (l2 == 0L) {}
          for (paramArrayOfByte = String.valueOf(l2);; paramArrayOfByte = l2 + NetConnInfoCenter.getSignalStrengthsLog())
          {
            QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + ((ToServiceMsg)localObject1).getRequestSsoSeq() + " uin:" + ((ToServiceMsg)localObject1).getUin() + " cmd:" + ((ToServiceMsg)localObject1).getServiceCmd() + " len:" + k + " costTime:" + paramArrayOfByte);
            return 0;
          }
        }
        QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + ((ToServiceMsg)localObject1).getRequestSsoSeq() + " uin:" + MsfSdkUtils.getShortUin(((ToServiceMsg)localObject1).getUin()) + " cmd:" + com.tencent.mobileqq.msf.core.b.c.a(paramArrayOfByte) + new StringBuilder().append(" ").append(k + ((ToServiceMsg)localObject1).getRequestSsoSeq()).toString());
        return 0;
        l2 = 0L;
        continue;
        label1115:
        localObject1 = paramArrayOfByte;
        break label94;
        label1121:
        return 1;
        label1123:
        return 1;
        label1125:
        l2 = l1;
        if (l1 > 2147483647L) {
          l2 = 0L;
        }
      }
    }
  }
  
  class b
    implements Runnable
  {
    b() {}
    
    public void run()
    {
      int j;
      long l;
      synchronized (ak.a(ak.this))
      {
        j = ak.this.h.size();
        i = j;
        if (j > ak.this.j) {
          i = ak.this.j;
        }
        l = SystemClock.elapsedRealtime();
        if (ak.this.L >= l)
        {
          ak.b(ak.this).postDelayed(ak.this.i, ak.this.m);
          if ((!ak.c(ak.this)) && (ak.this.h.size() - ak.this.k > 0))
          {
            ak.b(ak.this).postDelayed(ak.this.i, ak.this.m);
            ak.a(ak.this, true);
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.NetConnTag", 4, "delayWaitSendList size is " + ak.this.h.size() + ", " + i + " sso package should be merged.");
          }
          if (i <= 0) {
            break label1622;
          }
          j = i;
        }
        try
        {
          if (i > ak.this.h.size()) {
            j = ak.this.h.size();
          }
          if (j != 1) {
            break label348;
          }
          ??? = (ToServiceMsg)ak.this.h.peek();
          if ((??? == null) || (((ToServiceMsg)???).getWupBuffer().length >= ak.this.o)) {
            break label348;
          }
          ak localak = ak.this;
          localak.l -= ((ToServiceMsg)???).getWupBuffer().length;
          ak.a(ak.this, (ToServiceMsg)ak.this.h.poll());
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            synchronized (ak.a(ak.this))
            {
              if ((ak.this.l >= ak.this.k) && (!ak.c(ak.this)))
              {
                ak.a(ak.this, true);
                ak.b(ak.this).post(ak.this.i);
                if (i1 > 0)
                {
                  ak.this.e.put(Integer.valueOf(((ToServiceMsg)???).getRequestSsoSeq()), localObject6);
                  ak.this.f.put(Integer.valueOf(((ToServiceMsg)???).getRequestSsoSeq()), localObject5);
                  localObject5 = localBusiBuffData.toByteArray();
                  localObject6 = new ByteArrayOutputStream();
                  l.a((byte[])localObject5, (OutputStream)localObject6);
                  localObject6 = ak.b(((ByteArrayOutputStream)localObject6).toByteArray());
                  ((ToServiceMsg)???).putWupBuffer((byte[])localObject6);
                  ((ToServiceMsg)???).getAttributes().put("mergeCount", Integer.valueOf(i1));
                  ((ToServiceMsg)???).getAttributes().put("noRespCount", Integer.valueOf(j));
                  if (QLog.isDevelopLevel()) {
                    QLog.d("MSF.C.NetConnTag", 4, "Delay ToServiceMsg ssoseq: " + ((ToServiceMsg)???).getRequestSsoSeq() + " delayWaitSendList buffer size is " + localObject5.length + ", zip size is " + localObject6.length);
                  }
                }
                if (??? == null) {
                  continue;
                }
                ((ToServiceMsg)???).addAttribute("__timestamp_addSendQueue", Long.valueOf(System.currentTimeMillis()));
                ak.a(ak.this, (ToServiceMsg)???);
                return;
                localException = localException;
                QLog.d("MSF.C.NetConnTag", 1, "add delayMsg to send error, close LoginMerge. " + localException, localException);
                ak.this.r = false;
                if (ak.this.h.size() <= 0) {
                  continue;
                }
                localToServiceMsg1 = (ToServiceMsg)ak.this.h.poll();
                if (localToServiceMsg1 == null) {
                  continue;
                }
                ak.a(ak.this, localToServiceMsg1);
                continue;
                if ("RegPrxySvc.getOffMsg".equals(localToServiceMsg2.getServiceCmd()))
                {
                  localToServiceMsg1.getAttributes().put("infoLoginMsg", localToServiceMsg2);
                  continue;
                }
                if (!"RegPrxySvc.infoSync".equals(localToServiceMsg2.getServiceCmd())) {
                  continue;
                }
                localToServiceMsg1.getAttributes().put("infoLoginMsg", localToServiceMsg2);
                continue;
                ??? = ak.this;
                ((ak)???).l -= localToServiceMsg2.getWupBuffer().length;
                if (n == 0)
                {
                  localToServiceMsg1.setUin(localToServiceMsg2.getUin());
                  localBusiBuffItem = new SSOLoginMerge.BusiBuffItem();
                  localBusiBuffItem.SeqNo.set(localToServiceMsg2.getRequestSsoSeq());
                  localBusiBuffItem.ServiceCmd.set(localToServiceMsg2.getServiceCmd());
                  if (localToServiceMsg2.getWupBuffer().length < 4)
                  {
                    localBusiBuffItem.BusiBuffLen.set(ak.b(localToServiceMsg2.getWupBuffer()).length);
                    if (localToServiceMsg2.getWupBuffer().length < 4) {
                      continue;
                    }
                    ??? = new byte[localToServiceMsg2.getWupBuffer().length - 4];
                    System.arraycopy(localToServiceMsg2.getWupBuffer(), 4, ???, 0, ???.length);
                    localBusiBuffItem.BusiBuff.set(ByteStringMicro.copyFrom((byte[])???));
                    localBusiBuffItem.NeedResp.set(localToServiceMsg2.isNeedCallback());
                    localBusiBuffData.BusiBuffVec.add(localBusiBuffItem);
                    ((ArrayList)localObject6).add(Integer.valueOf(localToServiceMsg2.getRequestSsoSeq()));
                    ((ArrayList)localObject5).add(localToServiceMsg2);
                    ak.this.d.put(Integer.valueOf(localToServiceMsg2.getRequestSsoSeq()), localToServiceMsg2);
                    localToServiceMsg2.getAttributes().put("__extraTimeoutSeq", Integer.valueOf(ak.r().incrementAndGet()));
                    if (localToServiceMsg2.getTimeout() != -1L) {
                      continue;
                    }
                    localToServiceMsg2.setTimeout(30000L);
                    ??? = ak.this.D.msfAlarmer.a(localToServiceMsg2, localToServiceMsg2.getTimeout());
                    localToServiceMsg2.addAttribute("to_timeoutCallbacker", ???);
                    i1 = j;
                    i2 = i;
                    if (!com.tencent.mobileqq.msf.core.a.a.x()) {
                      break;
                    }
                    l = localToServiceMsg2.getTimeout() - com.tencent.mobileqq.msf.core.a.a.A();
                    i1 = j;
                    i2 = i;
                    if (l <= 0L) {
                      break;
                    }
                    localToServiceMsg2.addAttribute("to_predetect_timeoutCallbacker", ak.this.D.msfAlarmer.b(localToServiceMsg2, l));
                    i1 = j;
                    i2 = i;
                    break;
                  }
                }
                else
                {
                  if (localToServiceMsg1.getUin().equals(localToServiceMsg2.getUin())) {
                    continue;
                  }
                  ak.this.h.addFirst(localToServiceMsg2);
                  ??? = ak.this;
                  i = ((ak)???).l;
                  ((ak)???).l = (localToServiceMsg2.getWupBuffer().length + i);
                  i1 = k;
                  continue;
                }
                localBusiBuffItem.BusiBuffLen.set(localToServiceMsg2.getWupBuffer().length);
                continue;
                ??? = localToServiceMsg2.getWupBuffer();
                continue;
                ??? = ak.this.D.msfAlarmer.a(localToServiceMsg2, localToServiceMsg2.getTimeout());
                continue;
              }
              if ((!ak.c(ak.this)) && (ak.this.h.size() >= ak.this.j))
              {
                ak.a(ak.this, true);
                ak.b(ak.this).post(ak.this.i);
              }
            }
            if ((!ak.c(ak.this)) && (!ak.this.h.isEmpty()))
            {
              ak.b(ak.this).postDelayed(ak.this.i, ak.this.m);
              ak.a(ak.this, true);
            }
          }
          int k = i;
        }
        ak.a(ak.this, false);
      }
      label348:
      ??? = new ToServiceMsg("MSF SSOPackageMerge", ak.d(ak.this), "SSO.LoginMerge");
      ((ToServiceMsg)???).setAppId(MsfCore.mobileQQAppid);
      ((ToServiceMsg)???).setMsfCommand(MsfCommand.unknown);
      if (((ToServiceMsg)???).getRequestSsoSeq() == -1) {
        ((ToServiceMsg)???).setRequestSsoSeq(MsfCore.getNextSeq());
      }
      ((ToServiceMsg)???).setTimeout(30000L);
      ((ToServiceMsg)???).setNeedCallback(false);
      Object localObject6 = new ArrayList();
      Object localObject5 = new ArrayList();
      SSOLoginMerge.BusiBuffData localBusiBuffData = new SSOLoginMerge.BusiBuffData();
      int i = j;
      if (i > ak.this.h.size()) {
        k = ak.this.h.size();
      }
      for (;;)
      {
        int i1 = k;
        j = i;
        ToServiceMsg localToServiceMsg2;
        int i2;
        if (n < k)
        {
          localToServiceMsg2 = (ToServiceMsg)ak.this.h.poll();
          i1 = i;
          i2 = m;
          if (localToServiceMsg2 == null) {
            break label1648;
          }
          if (!"RegPrxySvc.infoLogin".equals(localToServiceMsg2.getServiceCmd())) {
            break label956;
          }
          ((ToServiceMsg)???).getAttributes().put("infoLoginMsg", localToServiceMsg2);
          j = i;
          if (!localToServiceMsg2.isNeedCallback()) {
            j = i + 1;
          }
          i = m + localToServiceMsg2.getWupBuffer().length;
          if ((i < ak.this.k) || (n == 0)) {
            break label1016;
          }
          ak.this.h.addFirst(localToServiceMsg2);
          i1 = n;
        }
        ToServiceMsg localToServiceMsg1;
        label956:
        label1016:
        SSOLoginMerge.BusiBuffItem localBusiBuffItem;
        label1622:
        localObject5 = null;
        localObject6 = null;
        localBusiBuffData = null;
        Object localObject3 = null;
        break;
        int m = 0;
        i = 0;
        int n = 0;
        continue;
        label1648:
        n += 1;
        m = i2;
        i = i1;
      }
    }
  }
  
  class c
    extends Thread
  {
    long a = 0L;
    
    c() {}
    
    private void a(ToServiceMsg paramToServiceMsg)
    {
      if ((!q.a().d()) || (!ak.this.b.b()) || (ak.this.D.quicksender == null) || (ak.this.D.getDeepSleepDetector() == null)) {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "sendQuiHeartbeatWhenWakeFromDs, isConned = " + ak.this.b.b() + ", than return.");
        }
      }
      do
      {
        return;
        if (ak.this.D.quicksender.b(2000L))
        {
          a(paramToServiceMsg, 1);
          return;
        }
      } while (!ak.this.D.getDeepSleepDetector().b());
      a(paramToServiceMsg, 2);
      ak.this.D.quicksender.b(false);
    }
    
    private void a(ToServiceMsg paramToServiceMsg, int paramInt)
    {
      if (!paramToServiceMsg.isSupportRetry())
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "sendQuiHeartbeatWhenWakeFromDs#setRetry, goCase = " + paramInt);
        }
        paramToServiceMsg.setIsSupportRetry(true);
        if (ak.this.D.getStatReporter() != null) {
          ak.this.D.getStatReporter().m();
        }
      }
    }
    
    private void a(ToServiceMsg paramToServiceMsg, String paramString1, String paramString2)
    {
      ak.this.c(paramToServiceMsg.getRequestSsoSeq());
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   4: getfield 135	com/tencent/mobileqq/msf/core/ak:g	Ljava/util/concurrent/LinkedBlockingDeque;
      //   7: invokevirtual 141	java/util/concurrent/LinkedBlockingDeque:take	()Ljava/lang/Object;
      //   10: checkcast 98	com/tencent/qphone/base/remote/ToServiceMsg
      //   13: astore 17
      //   15: aload_0
      //   16: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   19: getfield 42	com/tencent/mobileqq/msf/core/ak:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   22: ifnull +33 -> 55
      //   25: aload_0
      //   26: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   29: getfield 42	com/tencent/mobileqq/msf/core/ak:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   32: getfield 145	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   35: ifnull +20 -> 55
      //   38: aload_0
      //   39: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   42: getfield 42	com/tencent/mobileqq/msf/core/ak:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   45: getfield 145	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   48: iconst_1
      //   49: invokeinterface 151 2 0
      //   54: pop
      //   55: aload 17
      //   57: ifnull +1031 -> 1088
      //   60: aload 17
      //   62: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   65: astore 14
      //   67: aload 14
      //   69: ldc 156
      //   71: invokevirtual 162	java/lang/String:indexOf	(Ljava/lang/String;)I
      //   74: istore_3
      //   75: iload_3
      //   76: iconst_m1
      //   77: if_icmpeq +2721 -> 2798
      //   80: new 61	java/lang/StringBuilder
      //   83: dup
      //   84: invokespecial 62	java/lang/StringBuilder:<init>	()V
      //   87: aload 14
      //   89: iload_3
      //   90: iconst_1
      //   91: iadd
      //   92: aload 14
      //   94: invokevirtual 165	java/lang/String:length	()I
      //   97: invokevirtual 169	java/lang/String:substring	(II)Ljava/lang/String;
      //   100: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   103: ldc 171
      //   105: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   108: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   111: astore 15
      //   113: aload 14
      //   115: iconst_0
      //   116: iload_3
      //   117: invokevirtual 169	java/lang/String:substring	(II)Ljava/lang/String;
      //   120: astore 14
      //   122: aload 17
      //   124: ldc 173
      //   126: lconst_0
      //   127: invokestatic 179	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   130: invokevirtual 183	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
      //   133: checkcast 175	java/lang/Long
      //   136: invokevirtual 187	java/lang/Long:longValue	()J
      //   139: lstore 7
      //   141: invokestatic 192	java/lang/System:currentTimeMillis	()J
      //   144: lstore 9
      //   146: aload_0
      //   147: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   150: getfield 42	com/tencent/mobileqq/msf/core/ak:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   153: getfield 196	com/tencent/mobileqq/msf/core/MsfCore:configManager	Lcom/tencent/mobileqq/msf/core/a/a;
      //   156: aload 17
      //   158: lload 9
      //   160: invokevirtual 201	com/tencent/mobileqq/msf/core/a/a:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;J)V
      //   163: aload 17
      //   165: invokevirtual 205	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
      //   168: ifnull +1235 -> 1403
      //   171: invokestatic 210	com/tencent/mobileqq/msf/core/net/j:b	()B
      //   174: istore_2
      //   175: iload_2
      //   176: ifne +39 -> 215
      //   179: aload_0
      //   180: getfield 20	com/tencent/mobileqq/msf/core/ak$c:a	J
      //   183: lconst_0
      //   184: lcmp
      //   185: ifeq +17 -> 202
      //   188: lload 9
      //   190: aload_0
      //   191: getfield 20	com/tencent/mobileqq/msf/core/ak$c:a	J
      //   194: lsub
      //   195: ldc2_w 211
      //   198: lcmp
      //   199: ifle +16 -> 215
      //   202: aload_0
      //   203: lload 9
      //   205: putfield 20	com/tencent/mobileqq/msf/core/ak$c:a	J
      //   208: invokestatic 218	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
      //   211: iconst_1
      //   212: invokestatic 224	com/tencent/mobileqq/msf/core/NetConnInfoCenter:checkConnInfo	(Landroid/content/Context;Z)V
      //   215: iload_2
      //   216: getstatic 228	com/tencent/mobileqq/msf/core/ak:M	I
      //   219: if_icmpeq +18 -> 237
      //   222: iload_2
      //   223: putstatic 228	com/tencent/mobileqq/msf/core/ak:M	I
      //   226: invokestatic 231	com/tencent/mobileqq/msf/core/ak:h	()V
      //   229: ldc 59
      //   231: iconst_1
      //   232: ldc 233
      //   234: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   237: iconst_0
      //   238: invokestatic 237	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getActiveNetIpFamily	(Z)I
      //   241: i2b
      //   242: istore_3
      //   243: getstatic 241	com/tencent/mobileqq/msf/core/ak:P	Z
      //   246: ifeq +931 -> 1177
      //   249: iload_3
      //   250: iconst_4
      //   251: ior
      //   252: i2b
      //   253: istore_1
      //   254: getstatic 247	com/tencent/mobileqq/msf/core/auth/d:f	Ljava/util/concurrent/ConcurrentHashMap;
      //   257: aload 17
      //   259: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
      //   262: invokevirtual 256	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
      //   265: ifeq +80 -> 345
      //   268: aload_0
      //   269: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   272: getfield 42	com/tencent/mobileqq/msf/core/ak:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   275: invokevirtual 260	com/tencent/mobileqq/msf/core/MsfCore:getAccountCenter	()Lcom/tencent/mobileqq/msf/core/auth/b;
      //   278: aload 17
      //   280: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
      //   283: invokevirtual 266	com/tencent/mobileqq/msf/core/auth/b:o	(Ljava/lang/String;)V
      //   286: getstatic 247	com/tencent/mobileqq/msf/core/auth/d:f	Ljava/util/concurrent/ConcurrentHashMap;
      //   289: aload 17
      //   291: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
      //   294: invokevirtual 270	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
      //   297: pop
      //   298: ldc 59
      //   300: iconst_1
      //   301: new 61	java/lang/StringBuilder
      //   304: dup
      //   305: invokespecial 62	java/lang/StringBuilder:<init>	()V
      //   308: ldc_w 272
      //   311: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   314: aload 17
      //   316: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
      //   319: invokestatic 278	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getShortUin	(Ljava/lang/String;)Ljava/lang/String;
      //   322: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   325: ldc_w 280
      //   328: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   331: aload 17
      //   333: invokevirtual 123	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
      //   336: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   339: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   342: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   345: aload_0
      //   346: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   349: getfield 34	com/tencent/mobileqq/msf/core/ak:b	Lcom/tencent/mobileqq/msf/core/net/n;
      //   352: invokevirtual 38	com/tencent/mobileqq/msf/core/net/n:b	()Z
      //   355: ifne +15 -> 370
      //   358: invokestatic 231	com/tencent/mobileqq/msf/core/ak:h	()V
      //   361: ldc 59
      //   363: iconst_1
      //   364: ldc_w 282
      //   367: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   370: aload_0
      //   371: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   374: invokestatic 286	com/tencent/mobileqq/msf/core/ak:e	(Lcom/tencent/mobileqq/msf/core/ak;)Ljava/util/HashSet;
      //   377: aload 17
      //   379: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   382: invokevirtual 291	java/util/HashSet:contains	(Ljava/lang/Object;)Z
      //   385: ifeq +12 -> 397
      //   388: aload 17
      //   390: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
      //   393: iconst_0
      //   394: invokestatic 294	com/tencent/mobileqq/msf/core/ak:a	(Ljava/lang/String;Z)V
      //   397: aload_0
      //   398: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   401: getfield 34	com/tencent/mobileqq/msf/core/ak:b	Lcom/tencent/mobileqq/msf/core/net/n;
      //   404: invokevirtual 298	com/tencent/mobileqq/msf/core/net/n:l	()Lcom/tencent/mobileqq/msf/core/net/m;
      //   407: invokevirtual 303	com/tencent/mobileqq/msf/core/net/m:b	()Lcom/tencent/mobileqq/msf/core/d;
      //   410: ifnull +776 -> 1186
      //   413: aload_0
      //   414: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   417: getfield 34	com/tencent/mobileqq/msf/core/ak:b	Lcom/tencent/mobileqq/msf/core/net/n;
      //   420: invokevirtual 298	com/tencent/mobileqq/msf/core/net/n:l	()Lcom/tencent/mobileqq/msf/core/net/m;
      //   423: invokevirtual 303	com/tencent/mobileqq/msf/core/net/m:b	()Lcom/tencent/mobileqq/msf/core/d;
      //   426: invokevirtual 307	com/tencent/mobileqq/msf/core/d:d	()I
      //   429: istore_3
      //   430: aload 17
      //   432: iload_3
      //   433: invokestatic 310	com/tencent/mobileqq/msf/core/ak:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;I)[B
      //   436: astore 13
      //   438: aload 17
      //   440: iload_3
      //   441: invokestatic 312	com/tencent/mobileqq/msf/core/ak:c	(Lcom/tencent/qphone/base/remote/ToServiceMsg;I)[B
      //   444: astore 16
      //   446: aload 17
      //   448: invokevirtual 205	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
      //   451: ifnonnull +62 -> 513
      //   454: new 314	java/util/HashMap
      //   457: dup
      //   458: invokespecial 315	java/util/HashMap:<init>	()V
      //   461: astore 18
      //   463: aload 18
      //   465: ldc_w 317
      //   468: aload 17
      //   470: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   473: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   476: pop
      //   477: aload_0
      //   478: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   481: getfield 42	com/tencent/mobileqq/msf/core/ak:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   484: invokevirtual 113	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/k;
      //   487: ifnull +26 -> 513
      //   490: aload_0
      //   491: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   494: getfield 42	com/tencent/mobileqq/msf/core/ak:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   497: invokevirtual 113	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/k;
      //   500: ldc_w 323
      //   503: iconst_0
      //   504: lconst_0
      //   505: lconst_0
      //   506: aload 18
      //   508: iconst_0
      //   509: iconst_0
      //   510: invokevirtual 326	com/tencent/mobileqq/msf/core/c/k:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
      //   513: invokestatic 329	com/tencent/mobileqq/msf/core/ak:s	()Z
      //   516: ifne +52 -> 568
      //   519: invokestatic 334	com/tencent/qphone/base/util/CodecWarpper:getSharedObjectVersion	()I
      //   522: sipush 780
      //   525: if_icmpeq +38 -> 563
      //   528: aload_0
      //   529: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   532: getfield 42	com/tencent/mobileqq/msf/core/ak:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   535: invokevirtual 113	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/k;
      //   538: ifnull +25 -> 563
      //   541: aload_0
      //   542: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   545: getfield 42	com/tencent/mobileqq/msf/core/ak:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   548: invokevirtual 113	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/k;
      //   551: ldc_w 336
      //   554: iconst_0
      //   555: lconst_0
      //   556: lconst_0
      //   557: aconst_null
      //   558: iconst_0
      //   559: iconst_0
      //   560: invokevirtual 326	com/tencent/mobileqq/msf/core/c/k:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
      //   563: iconst_1
      //   564: invokestatic 339	com/tencent/mobileqq/msf/core/ak:a	(Z)Z
      //   567: pop
      //   568: sipush 591
      //   571: invokestatic 334	com/tencent/qphone/base/util/CodecWarpper:getSharedObjectVersion	()I
      //   574: if_icmpne +678 -> 1252
      //   577: aload 17
      //   579: invokevirtual 123	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
      //   582: invokestatic 343	com/tencent/mobileqq/msf/core/w:d	()Ljava/lang/String;
      //   585: invokestatic 345	com/tencent/mobileqq/msf/core/w:f	()Ljava/lang/String;
      //   588: invokestatic 347	com/tencent/mobileqq/msf/core/w:g	()Ljava/lang/String;
      //   591: ldc_w 349
      //   594: aload 14
      //   596: aload_0
      //   597: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   600: invokevirtual 351	com/tencent/mobileqq/msf/core/ak:e	()[B
      //   603: aload 17
      //   605: invokevirtual 354	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
      //   608: aload_0
      //   609: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   612: getfield 42	com/tencent/mobileqq/msf/core/ak:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   615: invokevirtual 357	com/tencent/mobileqq/msf/core/MsfCore:getMsfAppid	()I
      //   618: aload 17
      //   620: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
      //   623: iconst_0
      //   624: iload_2
      //   625: aload 17
      //   627: invokevirtual 205	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
      //   630: iconst_0
      //   631: invokestatic 361	com/tencent/qphone/base/util/CodecWarpper:nativeEncodeRequest	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BIILjava/lang/String;BB[BZ)[B
      //   634: astore 13
      //   636: aload 13
      //   638: ifnull +21 -> 659
      //   641: aload 17
      //   643: invokevirtual 365	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
      //   646: ldc_w 367
      //   649: aload 13
      //   651: arraylength
      //   652: invokestatic 372	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   655: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   658: pop
      //   659: ldc 59
      //   661: iconst_1
      //   662: new 61	java/lang/StringBuilder
      //   665: dup
      //   666: invokespecial 62	java/lang/StringBuilder:<init>	()V
      //   669: ldc_w 374
      //   672: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   675: aload 17
      //   677: invokevirtual 123	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
      //   680: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   683: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   686: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   689: aload 13
      //   691: astore 16
      //   693: aload 17
      //   695: ifnull +32 -> 727
      //   698: aload 13
      //   700: astore 16
      //   702: aload 17
      //   704: invokevirtual 123	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
      //   707: ifne +20 -> 727
      //   710: getstatic 377	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   713: invokevirtual 113	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/k;
      //   716: iconst_1
      //   717: aload 17
      //   719: aconst_null
      //   720: invokevirtual 380	com/tencent/mobileqq/msf/core/c/k:a	(ZLcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
      //   723: aload 13
      //   725: astore 16
      //   727: aload 16
      //   729: ifnonnull +682 -> 1411
      //   732: ldc 59
      //   734: iconst_1
      //   735: new 61	java/lang/StringBuilder
      //   738: dup
      //   739: invokespecial 62	java/lang/StringBuilder:<init>	()V
      //   742: ldc_w 382
      //   745: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   748: aload 17
      //   750: invokevirtual 385	com/tencent/qphone/base/remote/ToServiceMsg:getStringForLog	()Ljava/lang/String;
      //   753: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   756: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   759: invokestatic 388	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
      //   762: aload_0
      //   763: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   766: aload 17
      //   768: invokevirtual 123	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
      //   771: invokevirtual 126	com/tencent/mobileqq/msf/core/ak:c	(I)Lcom/tencent/qphone/base/remote/ToServiceMsg;
      //   774: pop
      //   775: aload_0
      //   776: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   779: getfield 42	com/tencent/mobileqq/msf/core/ak:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   782: ifnull -782 -> 0
      //   785: aload_0
      //   786: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   789: getfield 42	com/tencent/mobileqq/msf/core/ak:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   792: getfield 145	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   795: ifnull -795 -> 0
      //   798: aload_0
      //   799: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   802: getfield 42	com/tencent/mobileqq/msf/core/ak:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   805: getfield 145	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   808: iconst_1
      //   809: invokeinterface 391 2 0
      //   814: pop
      //   815: goto -815 -> 0
      //   818: astore 13
      //   820: ldc 59
      //   822: iconst_1
      //   823: new 61	java/lang/StringBuilder
      //   826: dup
      //   827: invokespecial 62	java/lang/StringBuilder:<init>	()V
      //   830: ldc_w 393
      //   833: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   836: aload 13
      //   838: invokevirtual 396	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   841: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   844: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   847: goto -632 -> 215
      //   850: astore 13
      //   852: ldc 59
      //   854: iconst_1
      //   855: aload 13
      //   857: invokevirtual 397	java/lang/Throwable:toString	()Ljava/lang/String;
      //   860: aload 13
      //   862: invokestatic 400	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   865: aload_0
      //   866: aload 17
      //   868: ldc_w 402
      //   871: aload 13
      //   873: invokevirtual 397	java/lang/Throwable:toString	()Ljava/lang/String;
      //   876: invokespecial 404	com/tencent/mobileqq/msf/core/ak$c:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Ljava/lang/String;Ljava/lang/String;)V
      //   879: aload_0
      //   880: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   883: getfield 135	com/tencent/mobileqq/msf/core/ak:g	Ljava/util/concurrent/LinkedBlockingDeque;
      //   886: aload 17
      //   888: invokevirtual 406	java/util/concurrent/LinkedBlockingDeque:remove	(Ljava/lang/Object;)Z
      //   891: pop
      //   892: aload_0
      //   893: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   896: invokestatic 409	com/tencent/mobileqq/msf/core/ak:f	(Lcom/tencent/mobileqq/msf/core/ak;)J
      //   899: pop2
      //   900: aload 17
      //   902: invokevirtual 413	com/tencent/qphone/base/remote/ToServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
      //   905: astore 13
      //   907: getstatic 419	com/tencent/mobileqq/msf/sdk/MsfCommand:_msf_kickedAndCleanTokenResp	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
      //   910: astore 14
      //   912: aload 13
      //   914: aload 14
      //   916: if_acmpne +172 -> 1088
      //   919: aload 17
      //   921: aload 17
      //   923: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   926: invokevirtual 422	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
      //   929: checkcast 424	com/tencent/qphone/base/remote/FromServiceMsg
      //   932: astore 13
      //   934: ldc 59
      //   936: iconst_1
      //   937: new 61	java/lang/StringBuilder
      //   940: dup
      //   941: invokespecial 62	java/lang/StringBuilder:<init>	()V
      //   944: invokestatic 428	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   947: invokevirtual 431	java/lang/Thread:getName	()Ljava/lang/String;
      //   950: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   953: ldc_w 433
      //   956: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   959: aload 13
      //   961: invokevirtual 434	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
      //   964: invokestatic 278	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getShortUin	(Ljava/lang/String;)Ljava/lang/String;
      //   967: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   970: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   973: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   976: aload_0
      //   977: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   980: getfield 42	com/tencent/mobileqq/msf/core/ak:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   983: invokevirtual 260	com/tencent/mobileqq/msf/core/MsfCore:getAccountCenter	()Lcom/tencent/mobileqq/msf/core/auth/b;
      //   986: aload 13
      //   988: invokevirtual 434	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
      //   991: invokevirtual 437	com/tencent/mobileqq/msf/core/auth/b:k	(Ljava/lang/String;)V
      //   994: aload 13
      //   996: sipush 2012
      //   999: aload 13
      //   1001: invokevirtual 440	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
      //   1004: invokevirtual 444	com/tencent/qphone/base/remote/FromServiceMsg:setBusinessFail	(ILjava/lang/String;)V
      //   1007: iconst_0
      //   1008: istore 11
      //   1010: aload 17
      //   1012: invokevirtual 365	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
      //   1015: ldc_w 446
      //   1018: invokevirtual 447	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
      //   1021: ifeq +19 -> 1040
      //   1024: aload 17
      //   1026: ldc_w 446
      //   1029: invokevirtual 422	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
      //   1032: checkcast 449	java/lang/Boolean
      //   1035: invokevirtual 452	java/lang/Boolean:booleanValue	()Z
      //   1038: istore 11
      //   1040: aload 13
      //   1042: ldc_w 446
      //   1045: iload 11
      //   1047: invokestatic 455	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   1050: invokevirtual 458	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
      //   1053: pop
      //   1054: ldc_w 460
      //   1057: aload 13
      //   1059: invokestatic 464	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:addFromMsgProcessName	(Ljava/lang/String;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
      //   1062: aload_0
      //   1063: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   1066: getfield 42	com/tencent/mobileqq/msf/core/ak:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   1069: aconst_null
      //   1070: aload 13
      //   1072: invokevirtual 468	com/tencent/mobileqq/msf/core/MsfCore:addRespToQuque	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
      //   1075: aload_0
      //   1076: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   1079: getfield 34	com/tencent/mobileqq/msf/core/ak:b	Lcom/tencent/mobileqq/msf/core/net/n;
      //   1082: getstatic 473	com/tencent/qphone/base/a:a	Lcom/tencent/qphone/base/a;
      //   1085: invokevirtual 476	com/tencent/mobileqq/msf/core/net/n:a	(Lcom/tencent/qphone/base/a;)V
      //   1088: aload_0
      //   1089: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   1092: getfield 42	com/tencent/mobileqq/msf/core/ak:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   1095: ifnull +33 -> 1128
      //   1098: aload_0
      //   1099: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   1102: getfield 42	com/tencent/mobileqq/msf/core/ak:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   1105: getfield 145	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   1108: ifnull +20 -> 1128
      //   1111: aload_0
      //   1112: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   1115: getfield 42	com/tencent/mobileqq/msf/core/ak:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   1118: getfield 145	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   1121: iconst_1
      //   1122: invokeinterface 391 2 0
      //   1127: pop
      //   1128: ldc2_w 477
      //   1131: invokestatic 482	java/lang/Thread:sleep	(J)V
      //   1134: aload_0
      //   1135: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   1138: getfield 42	com/tencent/mobileqq/msf/core/ak:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   1141: ifnull -1141 -> 0
      //   1144: aload_0
      //   1145: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   1148: getfield 42	com/tencent/mobileqq/msf/core/ak:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   1151: getfield 145	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   1154: ifnull -1154 -> 0
      //   1157: aload_0
      //   1158: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   1161: getfield 42	com/tencent/mobileqq/msf/core/ak:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   1164: getfield 145	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   1167: iconst_1
      //   1168: invokeinterface 391 2 0
      //   1173: pop
      //   1174: goto -1174 -> 0
      //   1177: iload_3
      //   1178: bipush 251
      //   1180: iand
      //   1181: i2b
      //   1182: istore_1
      //   1183: goto -929 -> 254
      //   1186: iconst_1
      //   1187: istore_3
      //   1188: goto -758 -> 430
      //   1191: astore 18
      //   1193: ldc 59
      //   1195: iconst_1
      //   1196: ldc_w 484
      //   1199: aload 18
      //   1201: invokestatic 400	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   1204: goto -636 -> 568
      //   1207: astore 13
      //   1209: aload_0
      //   1210: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   1213: getfield 42	com/tencent/mobileqq/msf/core/ak:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   1216: ifnull +33 -> 1249
      //   1219: aload_0
      //   1220: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   1223: getfield 42	com/tencent/mobileqq/msf/core/ak:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   1226: getfield 145	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   1229: ifnull +20 -> 1249
      //   1232: aload_0
      //   1233: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   1236: getfield 42	com/tencent/mobileqq/msf/core/ak:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   1239: getfield 145	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   1242: iconst_1
      //   1243: invokeinterface 391 2 0
      //   1248: pop
      //   1249: aload 13
      //   1251: athrow
      //   1252: sipush 595
      //   1255: invokestatic 334	com/tencent/qphone/base/util/CodecWarpper:getSharedObjectVersion	()I
      //   1258: if_icmpeq +12 -> 1270
      //   1261: sipush 600
      //   1264: invokestatic 334	com/tencent/qphone/base/util/CodecWarpper:getSharedObjectVersion	()I
      //   1267: if_icmpne +69 -> 1336
      //   1270: aload 17
      //   1272: invokevirtual 123	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
      //   1275: invokestatic 343	com/tencent/mobileqq/msf/core/w:d	()Ljava/lang/String;
      //   1278: invokestatic 345	com/tencent/mobileqq/msf/core/w:f	()Ljava/lang/String;
      //   1281: invokestatic 347	com/tencent/mobileqq/msf/core/w:g	()Ljava/lang/String;
      //   1284: ldc_w 349
      //   1287: aload 14
      //   1289: aload_0
      //   1290: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   1293: invokevirtual 351	com/tencent/mobileqq/msf/core/ak:e	()[B
      //   1296: aload 17
      //   1298: invokevirtual 354	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
      //   1301: aload_0
      //   1302: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   1305: getfield 42	com/tencent/mobileqq/msf/core/ak:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   1308: invokevirtual 357	com/tencent/mobileqq/msf/core/MsfCore:getMsfAppid	()I
      //   1311: aload 17
      //   1313: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
      //   1316: iconst_0
      //   1317: iload_2
      //   1318: aload 13
      //   1320: aload 16
      //   1322: aload 17
      //   1324: invokevirtual 205	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
      //   1327: iconst_0
      //   1328: invokestatic 487	com/tencent/qphone/base/util/CodecWarpper:nativeEncodeRequest	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BIILjava/lang/String;BB[B[B[BZ)[B
      //   1331: astore 13
      //   1333: goto -697 -> 636
      //   1336: aload 17
      //   1338: invokevirtual 123	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
      //   1341: invokestatic 343	com/tencent/mobileqq/msf/core/w:d	()Ljava/lang/String;
      //   1344: invokestatic 345	com/tencent/mobileqq/msf/core/w:f	()Ljava/lang/String;
      //   1347: invokestatic 347	com/tencent/mobileqq/msf/core/w:g	()Ljava/lang/String;
      //   1350: ldc_w 349
      //   1353: aload 14
      //   1355: aload_0
      //   1356: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   1359: invokevirtual 351	com/tencent/mobileqq/msf/core/ak:e	()[B
      //   1362: aload 17
      //   1364: invokevirtual 354	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
      //   1367: aload_0
      //   1368: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   1371: getfield 42	com/tencent/mobileqq/msf/core/ak:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   1374: invokevirtual 357	com/tencent/mobileqq/msf/core/MsfCore:getMsfAppid	()I
      //   1377: aload 17
      //   1379: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
      //   1382: iconst_0
      //   1383: iload_2
      //   1384: iload_1
      //   1385: aload 13
      //   1387: aload 16
      //   1389: aload 17
      //   1391: invokevirtual 205	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
      //   1394: iconst_0
      //   1395: invokestatic 490	com/tencent/qphone/base/util/CodecWarpper:nativeEncodeRequest	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BIILjava/lang/String;BBB[B[B[BZ)[B
      //   1398: astore 13
      //   1400: goto -764 -> 636
      //   1403: iconst_0
      //   1404: newarray byte
      //   1406: astore 16
      //   1408: goto -681 -> 727
      //   1411: aload 17
      //   1413: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
      //   1416: ldc_w 492
      //   1419: invokevirtual 495	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   1422: ifne +1382 -> 2804
      //   1425: aload 17
      //   1427: ldc_w 497
      //   1430: iconst_0
      //   1431: invokestatic 455	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   1434: invokevirtual 183	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
      //   1437: checkcast 449	java/lang/Boolean
      //   1440: invokevirtual 452	java/lang/Boolean:booleanValue	()Z
      //   1443: ifne +1361 -> 2804
      //   1446: aload 17
      //   1448: invokevirtual 354	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
      //   1451: iconst_m1
      //   1452: if_icmpeq +1352 -> 2804
      //   1455: aload 17
      //   1457: invokevirtual 354	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
      //   1460: bipush 100
      //   1462: if_icmpeq +1342 -> 2804
      //   1465: aload_0
      //   1466: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   1469: aload 17
      //   1471: invokestatic 500	com/tencent/mobileqq/msf/core/ak:b	(Lcom/tencent/mobileqq/msf/core/ak;Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
      //   1474: goto +1330 -> 2804
      //   1477: iload 11
      //   1479: ifne -579 -> 900
      //   1482: invokestatic 192	java/lang/System:currentTimeMillis	()J
      //   1485: lstore 9
      //   1487: lload 9
      //   1489: lload 7
      //   1491: lsub
      //   1492: aload 17
      //   1494: invokevirtual 503	com/tencent/qphone/base/remote/ToServiceMsg:getTimeout	()J
      //   1497: lcmp
      //   1498: ifle +39 -> 1537
      //   1501: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1504: ifeq -604 -> 900
      //   1507: ldc 59
      //   1509: iconst_2
      //   1510: new 61	java/lang/StringBuilder
      //   1513: dup
      //   1514: invokespecial 62	java/lang/StringBuilder:<init>	()V
      //   1517: aload 17
      //   1519: invokevirtual 396	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   1522: ldc_w 505
      //   1525: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1528: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1531: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1534: goto -634 -> 900
      //   1537: getstatic 508	com/tencent/mobileqq/msf/core/ak:U	J
      //   1540: lconst_0
      //   1541: lcmp
      //   1542: ifeq +114 -> 1656
      //   1545: lload 9
      //   1547: getstatic 508	com/tencent/mobileqq/msf/core/ak:U	J
      //   1550: lsub
      //   1551: invokestatic 511	com/tencent/mobileqq/msf/core/a/a:R	()I
      //   1554: i2l
      //   1555: lcmp
      //   1556: ifle +100 -> 1656
      //   1559: aload_0
      //   1560: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   1563: getfield 34	com/tencent/mobileqq/msf/core/ak:b	Lcom/tencent/mobileqq/msf/core/net/n;
      //   1566: invokevirtual 38	com/tencent/mobileqq/msf/core/net/n:b	()Z
      //   1569: ifeq +87 -> 1656
      //   1572: getstatic 508	com/tencent/mobileqq/msf/core/ak:U	J
      //   1575: aload_0
      //   1576: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   1579: getfield 34	com/tencent/mobileqq/msf/core/ak:b	Lcom/tencent/mobileqq/msf/core/net/n;
      //   1582: invokevirtual 298	com/tencent/mobileqq/msf/core/net/n:l	()Lcom/tencent/mobileqq/msf/core/net/m;
      //   1585: invokevirtual 513	com/tencent/mobileqq/msf/core/net/m:e	()J
      //   1588: lcmp
      //   1589: iflt +531 -> 2120
      //   1592: lconst_0
      //   1593: putstatic 508	com/tencent/mobileqq/msf/core/ak:U	J
      //   1596: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1599: ifeq +47 -> 1646
      //   1602: ldc 59
      //   1604: iconst_2
      //   1605: new 61	java/lang/StringBuilder
      //   1608: dup
      //   1609: invokespecial 62	java/lang/StringBuilder:<init>	()V
      //   1612: ldc_w 515
      //   1615: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1618: invokestatic 192	java/lang/System:currentTimeMillis	()J
      //   1621: getstatic 508	com/tencent/mobileqq/msf/core/ak:U	J
      //   1624: lsub
      //   1625: invokevirtual 518	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1628: ldc_w 520
      //   1631: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1634: invokestatic 511	com/tencent/mobileqq/msf/core/a/a:R	()I
      //   1637: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1640: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1643: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1646: aload_0
      //   1647: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   1650: getstatic 522	com/tencent/qphone/base/a:o	Lcom/tencent/qphone/base/a;
      //   1653: invokevirtual 523	com/tencent/mobileqq/msf/core/ak:a	(Lcom/tencent/qphone/base/a;)V
      //   1656: getstatic 508	com/tencent/mobileqq/msf/core/ak:U	J
      //   1659: lconst_0
      //   1660: lcmp
      //   1661: ifeq +85 -> 1746
      //   1664: lload 9
      //   1666: getstatic 508	com/tencent/mobileqq/msf/core/ak:U	J
      //   1669: lsub
      //   1670: ldc2_w 524
      //   1673: lcmp
      //   1674: ifle +72 -> 1746
      //   1677: aload_0
      //   1678: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   1681: getfield 34	com/tencent/mobileqq/msf/core/ak:b	Lcom/tencent/mobileqq/msf/core/net/n;
      //   1684: invokevirtual 38	com/tencent/mobileqq/msf/core/net/n:b	()Z
      //   1687: ifeq +59 -> 1746
      //   1690: getstatic 508	com/tencent/mobileqq/msf/core/ak:U	J
      //   1693: aload_0
      //   1694: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   1697: getfield 34	com/tencent/mobileqq/msf/core/ak:b	Lcom/tencent/mobileqq/msf/core/net/n;
      //   1700: invokevirtual 298	com/tencent/mobileqq/msf/core/net/n:l	()Lcom/tencent/mobileqq/msf/core/net/m;
      //   1703: invokevirtual 513	com/tencent/mobileqq/msf/core/net/m:e	()J
      //   1706: lcmp
      //   1707: iflt +39 -> 1746
      //   1710: aload_0
      //   1711: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   1714: getfield 529	com/tencent/mobileqq/msf/core/ak:Q	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   1717: invokevirtual 534	java/util/concurrent/atomic/AtomicBoolean:get	()Z
      //   1720: ifne +26 -> 1746
      //   1723: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1726: ifeq +12 -> 1738
      //   1729: ldc 59
      //   1731: iconst_2
      //   1732: ldc_w 536
      //   1735: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1738: aload_0
      //   1739: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   1742: iconst_0
      //   1743: invokestatic 539	com/tencent/mobileqq/msf/core/ak:b	(Lcom/tencent/mobileqq/msf/core/ak;Z)V
      //   1746: aload_0
      //   1747: aload 17
      //   1749: invokespecial 541	com/tencent/mobileqq/msf/core/ak$c:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
      //   1752: iload 11
      //   1754: istore 12
      //   1756: aload 17
      //   1758: ldc_w 543
      //   1761: invokestatic 548	android/os/SystemClock:elapsedRealtime	()J
      //   1764: invokestatic 179	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   1767: invokevirtual 549	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
      //   1770: pop
      //   1771: iload 11
      //   1773: istore 12
      //   1775: aload 17
      //   1777: ldc_w 551
      //   1780: lconst_0
      //   1781: invokestatic 179	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   1784: invokevirtual 549	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
      //   1787: pop
      //   1788: iload 11
      //   1790: istore 12
      //   1792: aload 17
      //   1794: ldc_w 553
      //   1797: getstatic 557	com/tencent/mobileqq/msf/core/ak:E	Ljava/lang/String;
      //   1800: invokevirtual 549	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
      //   1803: pop
      //   1804: iload 11
      //   1806: istore 12
      //   1808: aload 17
      //   1810: ldc_w 559
      //   1813: getstatic 562	com/tencent/mobileqq/msf/core/ak:F	Ljava/lang/String;
      //   1816: invokevirtual 549	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
      //   1819: pop
      //   1820: iload 11
      //   1822: istore 12
      //   1824: aload 17
      //   1826: ldc_w 564
      //   1829: invokestatic 192	java/lang/System:currentTimeMillis	()J
      //   1832: invokestatic 179	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   1835: invokevirtual 549	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
      //   1838: pop
      //   1839: iload 11
      //   1841: istore 12
      //   1843: aload 17
      //   1845: ldc_w 566
      //   1848: aload_0
      //   1849: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   1852: getfield 34	com/tencent/mobileqq/msf/core/ak:b	Lcom/tencent/mobileqq/msf/core/net/n;
      //   1855: invokevirtual 298	com/tencent/mobileqq/msf/core/net/n:l	()Lcom/tencent/mobileqq/msf/core/net/m;
      //   1858: invokevirtual 513	com/tencent/mobileqq/msf/core/net/m:e	()J
      //   1861: invokestatic 179	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   1864: invokevirtual 549	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
      //   1867: pop
      //   1868: iload 11
      //   1870: istore 12
      //   1872: aload 17
      //   1874: ldc_w 568
      //   1877: invokestatic 571	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getActiveNetworkType	()I
      //   1880: invokestatic 372	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1883: invokevirtual 549	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
      //   1886: pop
      //   1887: iload 11
      //   1889: istore 12
      //   1891: aload 17
      //   1893: ldc_w 573
      //   1896: aload_0
      //   1897: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   1900: getfield 34	com/tencent/mobileqq/msf/core/ak:b	Lcom/tencent/mobileqq/msf/core/net/n;
      //   1903: invokevirtual 38	com/tencent/mobileqq/msf/core/net/n:b	()Z
      //   1906: invokestatic 455	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   1909: invokevirtual 549	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
      //   1912: pop
      //   1913: iload 11
      //   1915: istore 12
      //   1917: aload_0
      //   1918: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   1921: invokestatic 192	java/lang/System:currentTimeMillis	()J
      //   1924: invokestatic 576	com/tencent/mobileqq/msf/core/ak:a	(Lcom/tencent/mobileqq/msf/core/ak;J)J
      //   1927: pop2
      //   1928: iload 11
      //   1930: istore 12
      //   1932: aload_0
      //   1933: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   1936: getfield 34	com/tencent/mobileqq/msf/core/ak:b	Lcom/tencent/mobileqq/msf/core/net/n;
      //   1939: aload 17
      //   1941: invokevirtual 354	com/tencent/qphone/base/remote/ToServiceMsg:getAppId	()I
      //   1944: aload 17
      //   1946: invokevirtual 579	com/tencent/qphone/base/remote/ToServiceMsg:getAppSeq	()I
      //   1949: aload 14
      //   1951: aload 15
      //   1953: aload 17
      //   1955: invokevirtual 413	com/tencent/qphone/base/remote/ToServiceMsg:getMsfCommand	()Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
      //   1958: aload 17
      //   1960: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
      //   1963: aload 17
      //   1965: invokevirtual 123	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
      //   1968: aload 16
      //   1970: aload 17
      //   1972: invokevirtual 582	com/tencent/mobileqq/msf/core/net/n:a	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/msf/sdk/MsfCommand;Ljava/lang/String;I[BLcom/tencent/qphone/base/remote/ToServiceMsg;)Z
      //   1975: istore 11
      //   1977: iload 11
      //   1979: istore 12
      //   1981: aload_0
      //   1982: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   1985: invokestatic 585	android/os/SystemClock:uptimeMillis	()J
      //   1988: invokestatic 587	com/tencent/mobileqq/msf/core/ak:b	(Lcom/tencent/mobileqq/msf/core/ak;J)J
      //   1991: pop2
      //   1992: iload 11
      //   1994: ifne +189 -> 2183
      //   1997: aload 17
      //   1999: invokevirtual 365	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
      //   2002: ldc_w 543
      //   2005: invokevirtual 588	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
      //   2008: pop
      //   2009: aload 17
      //   2011: invokevirtual 365	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
      //   2014: ldc_w 551
      //   2017: invokevirtual 588	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
      //   2020: pop
      //   2021: aload 17
      //   2023: invokevirtual 365	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
      //   2026: ldc_w 553
      //   2029: invokevirtual 588	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
      //   2032: pop
      //   2033: aload 17
      //   2035: invokevirtual 365	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
      //   2038: ldc_w 559
      //   2041: invokevirtual 588	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
      //   2044: pop
      //   2045: aload 17
      //   2047: invokevirtual 365	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
      //   2050: ldc_w 590
      //   2053: iconst_1
      //   2054: invokestatic 455	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   2057: invokevirtual 321	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2060: pop
      //   2061: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   2064: ifeq +34 -> 2098
      //   2067: ldc 59
      //   2069: iconst_2
      //   2070: new 61	java/lang/StringBuilder
      //   2073: dup
      //   2074: invokespecial 62	java/lang/StringBuilder:<init>	()V
      //   2077: invokestatic 428	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   2080: invokevirtual 431	java/lang/Thread:getName	()Ljava/lang/String;
      //   2083: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2086: ldc_w 592
      //   2089: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2092: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2095: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   2098: aload_0
      //   2099: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   2102: getfield 34	com/tencent/mobileqq/msf/core/ak:b	Lcom/tencent/mobileqq/msf/core/net/n;
      //   2105: getstatic 594	com/tencent/qphone/base/a:d	Lcom/tencent/qphone/base/a;
      //   2108: invokevirtual 476	com/tencent/mobileqq/msf/core/net/n:a	(Lcom/tencent/qphone/base/a;)V
      //   2111: getstatic 599	com/tencent/qphone/base/BaseConstants:reSendIntrevTime	J
      //   2114: invokestatic 482	java/lang/Thread:sleep	(J)V
      //   2117: goto -640 -> 1477
      //   2120: lconst_0
      //   2121: putstatic 508	com/tencent/mobileqq/msf/core/ak:U	J
      //   2124: goto -468 -> 1656
      //   2127: astore 13
      //   2129: ldc 59
      //   2131: iconst_1
      //   2132: new 61	java/lang/StringBuilder
      //   2135: dup
      //   2136: invokespecial 62	java/lang/StringBuilder:<init>	()V
      //   2139: ldc_w 601
      //   2142: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2145: aload 13
      //   2147: invokevirtual 396	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   2150: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2153: aload 13
      //   2155: invokestatic 400	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   2158: iload 12
      //   2160: istore 11
      //   2162: goto -170 -> 1992
      //   2165: astore 13
      //   2167: ldc 59
      //   2169: iconst_1
      //   2170: aload 13
      //   2172: invokevirtual 602	java/lang/Exception:toString	()Ljava/lang/String;
      //   2175: aload 13
      //   2177: invokestatic 400	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   2180: goto -703 -> 1477
      //   2183: aload 17
      //   2185: ldc_w 551
      //   2188: invokestatic 192	java/lang/System:currentTimeMillis	()J
      //   2191: invokestatic 179	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   2194: invokevirtual 549	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
      //   2197: pop
      //   2198: iconst_0
      //   2199: istore_3
      //   2200: iconst_0
      //   2201: istore 4
      //   2203: iconst_0
      //   2204: istore 5
      //   2206: ldc_w 604
      //   2209: aload 14
      //   2211: invokevirtual 495	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2214: istore 12
      //   2216: iload 12
      //   2218: ifeq +478 -> 2696
      //   2221: iload 4
      //   2223: istore_3
      //   2224: aload 17
      //   2226: invokevirtual 365	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
      //   2229: ldc_w 606
      //   2232: invokevirtual 608	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
      //   2235: checkcast 369	java/lang/Integer
      //   2238: invokevirtual 611	java/lang/Integer:intValue	()I
      //   2241: istore 4
      //   2243: iload 4
      //   2245: istore_3
      //   2246: aload 17
      //   2248: invokevirtual 365	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
      //   2251: ldc_w 613
      //   2254: invokevirtual 608	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
      //   2257: checkcast 369	java/lang/Integer
      //   2260: invokevirtual 611	java/lang/Integer:intValue	()I
      //   2263: istore 6
      //   2265: iload 6
      //   2267: istore_3
      //   2268: iload_3
      //   2269: istore 5
      //   2271: ldc_w 604
      //   2274: aload 14
      //   2276: invokevirtual 495	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2279: ifne +17 -> 2296
      //   2282: iload_3
      //   2283: istore 5
      //   2285: aload 17
      //   2287: invokevirtual 616	com/tencent/qphone/base/remote/ToServiceMsg:isNeedCallback	()Z
      //   2290: ifne +6 -> 2296
      //   2293: iconst_1
      //   2294: istore 5
      //   2296: aload 14
      //   2298: aload 17
      //   2300: invokevirtual 123	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
      //   2303: aload 16
      //   2305: arraylength
      //   2306: i2l
      //   2307: iload 4
      //   2309: iload 5
      //   2311: invokestatic 621	com/tencent/mobileqq/a/a/f:a	(Ljava/lang/String;IJII)V
      //   2314: aload 17
      //   2316: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
      //   2319: ifnull +279 -> 2598
      //   2322: aload 17
      //   2324: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
      //   2327: invokevirtual 165	java/lang/String:length	()I
      //   2330: iconst_4
      //   2331: if_icmple +267 -> 2598
      //   2334: aload 17
      //   2336: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   2339: ldc_w 623
      //   2342: invokevirtual 627	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   2345: ifne +253 -> 2598
      //   2348: aload 17
      //   2350: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   2353: ldc_w 629
      //   2356: invokevirtual 627	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   2359: ifne +239 -> 2598
      //   2362: aload 17
      //   2364: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   2367: ldc_w 631
      //   2370: invokevirtual 495	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2373: ifne +225 -> 2598
      //   2376: aload 17
      //   2378: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   2381: ldc_w 633
      //   2384: invokevirtual 495	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2387: ifne +211 -> 2598
      //   2390: aload 17
      //   2392: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   2395: ldc_w 635
      //   2398: invokevirtual 495	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2401: ifne +197 -> 2598
      //   2404: aload 17
      //   2406: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   2409: ldc_w 637
      //   2412: invokevirtual 495	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2415: ifne +183 -> 2598
      //   2418: aload 17
      //   2420: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   2423: ldc_w 639
      //   2426: invokevirtual 495	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2429: ifne +169 -> 2598
      //   2432: aload 17
      //   2434: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   2437: ldc_w 641
      //   2440: invokevirtual 495	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2443: ifne +155 -> 2598
      //   2446: aload 17
      //   2448: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   2451: ldc_w 643
      //   2454: invokevirtual 495	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2457: ifne +141 -> 2598
      //   2460: aload 17
      //   2462: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   2465: ldc_w 645
      //   2468: invokevirtual 495	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2471: ifne +127 -> 2598
      //   2474: getstatic 649	com/tencent/mobileqq/msf/core/ak:af	Ljava/util/concurrent/CopyOnWriteArraySet;
      //   2477: aload 17
      //   2479: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
      //   2482: invokevirtual 652	java/util/concurrent/CopyOnWriteArraySet:contains	(Ljava/lang/Object;)Z
      //   2485: ifne +113 -> 2598
      //   2488: getstatic 655	com/tencent/mobileqq/msf/core/ak:t	Ljava/util/concurrent/ConcurrentHashMap;
      //   2491: aload 17
      //   2493: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
      //   2496: invokevirtual 656	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
      //   2499: ifnonnull +26 -> 2525
      //   2502: new 658	java/util/concurrent/ConcurrentLinkedQueue
      //   2505: dup
      //   2506: invokespecial 659	java/util/concurrent/ConcurrentLinkedQueue:<init>	()V
      //   2509: astore 13
      //   2511: getstatic 655	com/tencent/mobileqq/msf/core/ak:t	Ljava/util/concurrent/ConcurrentHashMap;
      //   2514: aload 17
      //   2516: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
      //   2519: aload 13
      //   2521: invokevirtual 660	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   2524: pop
      //   2525: getstatic 655	com/tencent/mobileqq/msf/core/ak:t	Ljava/util/concurrent/ConcurrentHashMap;
      //   2528: aload 17
      //   2530: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
      //   2533: invokevirtual 656	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
      //   2536: checkcast 658	java/util/concurrent/ConcurrentLinkedQueue
      //   2539: aload 17
      //   2541: invokevirtual 123	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
      //   2544: invokestatic 372	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2547: invokevirtual 663	java/util/concurrent/ConcurrentLinkedQueue:offer	(Ljava/lang/Object;)Z
      //   2550: pop
      //   2551: ldc 59
      //   2553: iconst_1
      //   2554: new 61	java/lang/StringBuilder
      //   2557: dup
      //   2558: invokespecial 62	java/lang/StringBuilder:<init>	()V
      //   2561: ldc_w 665
      //   2564: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2567: aload 17
      //   2569: invokevirtual 123	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
      //   2572: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   2575: ldc_w 667
      //   2578: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2581: aload 17
      //   2583: invokevirtual 250	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
      //   2586: invokestatic 278	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getShortUin	(Ljava/lang/String;)Ljava/lang/String;
      //   2589: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2592: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2595: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   2598: aload 17
      //   2600: invokevirtual 154	com/tencent/qphone/base/remote/ToServiceMsg:getServiceCmd	()Ljava/lang/String;
      //   2603: ldc_w 669
      //   2606: invokevirtual 627	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   2609: ifeq +9 -> 2618
      //   2612: invokestatic 548	android/os/SystemClock:elapsedRealtime	()J
      //   2615: putstatic 671	com/tencent/mobileqq/msf/core/ak:J	J
      //   2618: aload_0
      //   2619: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   2622: getfield 674	com/tencent/mobileqq/msf/core/ak:ab	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   2625: invokevirtual 534	java/util/concurrent/atomic/AtomicBoolean:get	()Z
      //   2628: ifeq +182 -> 2810
      //   2631: aload_0
      //   2632: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   2635: getfield 677	com/tencent/mobileqq/msf/core/ak:aa	I
      //   2638: iconst_m1
      //   2639: if_icmpne +171 -> 2810
      //   2642: aload_0
      //   2643: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   2646: aload 17
      //   2648: invokevirtual 123	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
      //   2651: putfield 677	com/tencent/mobileqq/msf/core/ak:aa	I
      //   2654: ldc 59
      //   2656: iconst_1
      //   2657: new 61	java/lang/StringBuilder
      //   2660: dup
      //   2661: invokespecial 62	java/lang/StringBuilder:<init>	()V
      //   2664: ldc_w 679
      //   2667: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2670: aload_0
      //   2671: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   2674: getfield 677	com/tencent/mobileqq/msf/core/ak:aa	I
      //   2677: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   2680: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2683: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   2686: goto +124 -> 2810
      //   2689: astore 13
      //   2691: aload 13
      //   2693: invokevirtual 682	java/lang/Exception:printStackTrace	()V
      //   2696: iload_3
      //   2697: istore 4
      //   2699: iload 5
      //   2701: istore_3
      //   2702: goto -434 -> 2268
      //   2705: astore 13
      //   2707: ldc 59
      //   2709: iconst_1
      //   2710: new 61	java/lang/StringBuilder
      //   2713: dup
      //   2714: invokespecial 62	java/lang/StringBuilder:<init>	()V
      //   2717: ldc_w 684
      //   2720: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2723: aload 13
      //   2725: invokevirtual 602	java/lang/Exception:toString	()Ljava/lang/String;
      //   2728: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2731: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2734: invokestatic 686	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   2737: goto -1649 -> 1088
      //   2740: astore 13
      //   2742: ldc 59
      //   2744: iconst_1
      //   2745: aload 13
      //   2747: invokevirtual 397	java/lang/Throwable:toString	()Ljava/lang/String;
      //   2750: aload 13
      //   2752: invokestatic 400	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   2755: aload_0
      //   2756: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   2759: getfield 42	com/tencent/mobileqq/msf/core/ak:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   2762: ifnull -2762 -> 0
      //   2765: aload_0
      //   2766: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   2769: getfield 42	com/tencent/mobileqq/msf/core/ak:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   2772: getfield 145	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   2775: ifnull -2775 -> 0
      //   2778: aload_0
      //   2779: getfield 15	com/tencent/mobileqq/msf/core/ak$c:b	Lcom/tencent/mobileqq/msf/core/ak;
      //   2782: getfield 42	com/tencent/mobileqq/msf/core/ak:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   2785: getfield 145	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   2788: iconst_1
      //   2789: invokeinterface 391 2 0
      //   2794: pop
      //   2795: goto -2795 -> 0
      //   2798: aconst_null
      //   2799: astore 15
      //   2801: goto -2679 -> 122
      //   2804: iconst_0
      //   2805: istore 11
      //   2807: goto -1330 -> 1477
      //   2810: goto -1333 -> 1477
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	2813	0	this	c
      //   253	1132	1	b1	byte
      //   174	1210	2	i	int
      //   74	2628	3	j	int
      //   2201	497	4	k	int
      //   2204	496	5	m	int
      //   2263	3	6	n	int
      //   139	1351	7	l1	long
      //   144	1521	9	l2	long
      //   1008	1798	11	bool1	boolean
      //   1754	463	12	bool2	boolean
      //   436	288	13	arrayOfByte1	byte[]
      //   818	19	13	localException1	Exception
      //   850	22	13	localThrowable1	Throwable
      //   905	166	13	localObject1	Object
      //   1207	112	13	arrayOfByte2	byte[]
      //   1331	68	13	arrayOfByte3	byte[]
      //   2127	27	13	localThrowable2	Throwable
      //   2165	11	13	localException2	Exception
      //   2509	11	13	localConcurrentLinkedQueue	ConcurrentLinkedQueue
      //   2689	3	13	localException3	Exception
      //   2705	19	13	localException4	Exception
      //   2740	11	13	localThrowable3	Throwable
      //   65	2232	14	localObject2	Object
      //   111	2689	15	str	String
      //   444	1860	16	arrayOfByte4	byte[]
      //   13	2634	17	localToServiceMsg	ToServiceMsg
      //   461	46	18	localHashMap	HashMap
      //   1191	9	18	localException5	Exception
      // Exception table:
      //   from	to	target	type
      //   208	215	818	java/lang/Exception
      //   60	75	850	java/lang/Throwable
      //   80	122	850	java/lang/Throwable
      //   122	175	850	java/lang/Throwable
      //   179	202	850	java/lang/Throwable
      //   202	208	850	java/lang/Throwable
      //   208	215	850	java/lang/Throwable
      //   215	237	850	java/lang/Throwable
      //   237	249	850	java/lang/Throwable
      //   254	345	850	java/lang/Throwable
      //   345	370	850	java/lang/Throwable
      //   370	397	850	java/lang/Throwable
      //   397	430	850	java/lang/Throwable
      //   430	446	850	java/lang/Throwable
      //   446	513	850	java/lang/Throwable
      //   513	563	850	java/lang/Throwable
      //   563	568	850	java/lang/Throwable
      //   568	636	850	java/lang/Throwable
      //   641	659	850	java/lang/Throwable
      //   659	689	850	java/lang/Throwable
      //   702	723	850	java/lang/Throwable
      //   732	775	850	java/lang/Throwable
      //   820	847	850	java/lang/Throwable
      //   1193	1204	850	java/lang/Throwable
      //   1252	1270	850	java/lang/Throwable
      //   1270	1333	850	java/lang/Throwable
      //   1336	1400	850	java/lang/Throwable
      //   1403	1408	850	java/lang/Throwable
      //   1411	1474	850	java/lang/Throwable
      //   1482	1534	850	java/lang/Throwable
      //   1537	1646	850	java/lang/Throwable
      //   1646	1656	850	java/lang/Throwable
      //   1656	1738	850	java/lang/Throwable
      //   1738	1746	850	java/lang/Throwable
      //   1746	1752	850	java/lang/Throwable
      //   1997	2098	850	java/lang/Throwable
      //   2098	2111	850	java/lang/Throwable
      //   2111	2117	850	java/lang/Throwable
      //   2120	2124	850	java/lang/Throwable
      //   2129	2158	850	java/lang/Throwable
      //   2167	2180	850	java/lang/Throwable
      //   2183	2198	850	java/lang/Throwable
      //   2206	2216	850	java/lang/Throwable
      //   2224	2243	850	java/lang/Throwable
      //   2246	2265	850	java/lang/Throwable
      //   2271	2282	850	java/lang/Throwable
      //   2285	2293	850	java/lang/Throwable
      //   2296	2525	850	java/lang/Throwable
      //   2525	2598	850	java/lang/Throwable
      //   2598	2618	850	java/lang/Throwable
      //   2618	2686	850	java/lang/Throwable
      //   2691	2696	850	java/lang/Throwable
      //   446	513	1191	java/lang/Exception
      //   513	563	1191	java/lang/Exception
      //   563	568	1191	java/lang/Exception
      //   0	55	1207	finally
      //   60	75	1207	finally
      //   80	122	1207	finally
      //   122	175	1207	finally
      //   179	202	1207	finally
      //   202	208	1207	finally
      //   208	215	1207	finally
      //   215	237	1207	finally
      //   237	249	1207	finally
      //   254	345	1207	finally
      //   345	370	1207	finally
      //   370	397	1207	finally
      //   397	430	1207	finally
      //   430	446	1207	finally
      //   446	513	1207	finally
      //   513	563	1207	finally
      //   563	568	1207	finally
      //   568	636	1207	finally
      //   641	659	1207	finally
      //   659	689	1207	finally
      //   702	723	1207	finally
      //   732	775	1207	finally
      //   820	847	1207	finally
      //   852	900	1207	finally
      //   900	912	1207	finally
      //   919	1007	1207	finally
      //   1010	1040	1207	finally
      //   1040	1088	1207	finally
      //   1088	1128	1207	finally
      //   1128	1134	1207	finally
      //   1193	1204	1207	finally
      //   1252	1270	1207	finally
      //   1270	1333	1207	finally
      //   1336	1400	1207	finally
      //   1403	1408	1207	finally
      //   1411	1474	1207	finally
      //   1482	1534	1207	finally
      //   1537	1646	1207	finally
      //   1646	1656	1207	finally
      //   1656	1738	1207	finally
      //   1738	1746	1207	finally
      //   1746	1752	1207	finally
      //   1756	1771	1207	finally
      //   1775	1788	1207	finally
      //   1792	1804	1207	finally
      //   1808	1820	1207	finally
      //   1824	1839	1207	finally
      //   1843	1868	1207	finally
      //   1872	1887	1207	finally
      //   1891	1913	1207	finally
      //   1917	1928	1207	finally
      //   1932	1977	1207	finally
      //   1981	1992	1207	finally
      //   1997	2098	1207	finally
      //   2098	2111	1207	finally
      //   2111	2117	1207	finally
      //   2120	2124	1207	finally
      //   2129	2158	1207	finally
      //   2167	2180	1207	finally
      //   2183	2198	1207	finally
      //   2206	2216	1207	finally
      //   2224	2243	1207	finally
      //   2246	2265	1207	finally
      //   2271	2282	1207	finally
      //   2285	2293	1207	finally
      //   2296	2525	1207	finally
      //   2525	2598	1207	finally
      //   2598	2618	1207	finally
      //   2618	2686	1207	finally
      //   2691	2696	1207	finally
      //   2707	2737	1207	finally
      //   2742	2755	1207	finally
      //   1756	1771	2127	java/lang/Throwable
      //   1775	1788	2127	java/lang/Throwable
      //   1792	1804	2127	java/lang/Throwable
      //   1808	1820	2127	java/lang/Throwable
      //   1824	1839	2127	java/lang/Throwable
      //   1843	1868	2127	java/lang/Throwable
      //   1872	1887	2127	java/lang/Throwable
      //   1891	1913	2127	java/lang/Throwable
      //   1917	1928	2127	java/lang/Throwable
      //   1932	1977	2127	java/lang/Throwable
      //   1981	1992	2127	java/lang/Throwable
      //   2111	2117	2165	java/lang/Exception
      //   2224	2243	2689	java/lang/Exception
      //   2246	2265	2689	java/lang/Exception
      //   919	1007	2705	java/lang/Exception
      //   1010	1040	2705	java/lang/Exception
      //   1040	1088	2705	java/lang/Exception
      //   0	55	2740	java/lang/Throwable
      //   852	900	2740	java/lang/Throwable
      //   900	912	2740	java/lang/Throwable
      //   919	1007	2740	java/lang/Throwable
      //   1010	1040	2740	java/lang/Throwable
      //   1040	1088	2740	java/lang/Throwable
      //   1088	1128	2740	java/lang/Throwable
      //   1128	1134	2740	java/lang/Throwable
      //   2707	2737	2740	java/lang/Throwable
    }
  }
  
  class d
    implements Runnable
  {
    int a = 0;
    
    public d(int paramInt)
    {
      this.a = paramInt;
    }
    
    public void run()
    {
      try
      {
        long l = System.currentTimeMillis();
        Object localObject = Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/com/tencent/mobileqq/com.tencent.mobileqq_logcat_" + this.a + "_" + QLog.getLogFileFormatter().format(Long.valueOf(l)) + ".log";
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "start to store logcat " + (String)localObject);
        }
        localObject = "logcat -b main -b system -b radio -b events -v time -f " + (String)localObject;
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, "start to execute command " + (String)localObject);
        }
        localObject = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec((String)localObject).getErrorStream()));
        for (;;)
        {
          String str = ((BufferedReader)localObject).readLine();
          if (str == null) {
            break;
          }
          QLog.d("MSF.C.NetConnTag", 1, "logcat storage error:" + str);
        }
        localException.close();
      }
      catch (Exception localException)
      {
        QLog.d("MSF.C.NetConnTag", 1, "failed to store logcat ", localException);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.ak
 * JD-Core Version:    0.7.0.1
 */