package com.tencent.sharp.jni;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;
import java.util.TimerTask;

public class TraeMediaPlayer
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 100;
  private Context jdField_a_of_type_AndroidContentContext;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer = null;
  private TraeMediaPlayer.OnCompletionListener jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer$OnCompletionListener;
  private Timer jdField_a_of_type_JavaUtilTimer = null;
  private TimerTask jdField_a_of_type_JavaUtilTimerTask = null;
  boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  int e = 0;
  private int f = 0;
  private int g = -1;
  
  public TraeMediaPlayer(Context paramContext, TraeMediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer$OnCompletionListener = paramOnCompletionListener;
  }
  
  public int a()
  {
    return this.f;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TRAE", 2, "TraeMediaPlay stopRing ");
    }
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
    }
    try
    {
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer = null;
        this.jdField_a_of_type_JavaUtilTimerTask = null;
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
    }
    catch (Exception localException)
    {
      label70:
      break label70;
    }
    this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    this.g = -1;
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  /* Error */
  public boolean a(int paramInt1, int paramInt2, android.net.Uri paramUri, java.lang.String paramString, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, boolean paramBoolean3, int paramInt4)
  {
    // Byte code:
    //   0: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +119 -> 122
    //   6: new 97	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   13: ldc 100
    //   15: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: iload_1
    //   19: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   22: ldc 109
    //   24: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: iload_2
    //   28: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   31: ldc 111
    //   33: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_3
    //   37: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   40: ldc 116
    //   42: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload 4
    //   47: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: ldc 118
    //   52: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: astore 12
    //   57: iload 5
    //   59: ifeq +137 -> 196
    //   62: ldc 120
    //   64: astore 11
    //   66: ldc 65
    //   68: iconst_2
    //   69: aload 12
    //   71: aload 11
    //   73: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: ldc 122
    //   78: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: iload 6
    //   83: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   86: ldc 124
    //   88: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: iload 7
    //   93: invokevirtual 127	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   96: ldc 129
    //   98: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: iload 8
    //   103: invokevirtual 127	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   106: ldc 131
    //   108: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: iload 9
    //   113: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   116: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 137	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   122: iload 5
    //   124: ifne +85 -> 209
    //   127: iload 6
    //   129: ifgt +80 -> 209
    //   132: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   135: ifeq +59 -> 194
    //   138: new 97	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   145: ldc 139
    //   147: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: iload_1
    //   151: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   154: ldc 118
    //   156: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: astore 4
    //   161: iload 5
    //   163: ifeq +40 -> 203
    //   166: ldc 120
    //   168: astore_3
    //   169: ldc 65
    //   171: iconst_2
    //   172: aload 4
    //   174: aload_3
    //   175: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: ldc 122
    //   180: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: iload 6
    //   185: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   188: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 137	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   194: iconst_0
    //   195: ireturn
    //   196: ldc 141
    //   198: astore 11
    //   200: goto -134 -> 66
    //   203: ldc 141
    //   205: astore_3
    //   206: goto -37 -> 169
    //   209: aload_0
    //   210: getfield 33	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   213: ifnull +31 -> 244
    //   216: aload_0
    //   217: getfield 33	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   220: invokevirtual 75	android/media/MediaPlayer:isPlaying	()Z
    //   223: istore 10
    //   225: iload 10
    //   227: ifeq +5 -> 232
    //   230: iconst_0
    //   231: ireturn
    //   232: aload_0
    //   233: getfield 33	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   236: invokevirtual 86	android/media/MediaPlayer:release	()V
    //   239: aload_0
    //   240: aconst_null
    //   241: putfield 33	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   244: aload_0
    //   245: getfield 45	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_JavaUtilTimer	Ljava/util/Timer;
    //   248: ifnull +20 -> 268
    //   251: aload_0
    //   252: getfield 45	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_JavaUtilTimer	Ljava/util/Timer;
    //   255: invokevirtual 83	java/util/Timer:cancel	()V
    //   258: aload_0
    //   259: aconst_null
    //   260: putfield 45	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_JavaUtilTimer	Ljava/util/Timer;
    //   263: aload_0
    //   264: aconst_null
    //   265: putfield 47	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_JavaUtilTimerTask	Ljava/util/TimerTask;
    //   268: aload_0
    //   269: getfield 49	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   272: ldc 143
    //   274: invokevirtual 149	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   277: checkcast 151	android/media/AudioManager
    //   280: astore 11
    //   282: aload_0
    //   283: new 72	android/media/MediaPlayer
    //   286: dup
    //   287: invokespecial 152	android/media/MediaPlayer:<init>	()V
    //   290: putfield 33	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   293: aload_0
    //   294: getfield 33	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   297: ifnonnull +196 -> 493
    //   300: aload_0
    //   301: getfield 33	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   304: invokevirtual 86	android/media/MediaPlayer:release	()V
    //   307: aload_0
    //   308: aconst_null
    //   309: putfield 33	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   312: iconst_0
    //   313: ireturn
    //   314: astore 11
    //   316: aload_0
    //   317: aconst_null
    //   318: putfield 33	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   321: goto -77 -> 244
    //   324: astore_3
    //   325: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   328: ifeq +43 -> 371
    //   331: ldc 65
    //   333: iconst_2
    //   334: new 97	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   341: ldc 154
    //   343: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: aload_3
    //   347: invokevirtual 157	java/lang/IllegalStateException:getLocalizedMessage	()Ljava/lang/String;
    //   350: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: ldc 159
    //   355: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: aload_3
    //   359: invokevirtual 162	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   362: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   371: aload_0
    //   372: getfield 33	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   375: invokevirtual 86	android/media/MediaPlayer:release	()V
    //   378: aload_0
    //   379: aconst_null
    //   380: putfield 33	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   383: iconst_0
    //   384: ireturn
    //   385: astore_3
    //   386: aload_0
    //   387: aconst_null
    //   388: putfield 33	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   391: aload_3
    //   392: athrow
    //   393: astore_3
    //   394: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   397: ifeq -26 -> 371
    //   400: ldc 65
    //   402: iconst_2
    //   403: new 97	java/lang/StringBuilder
    //   406: dup
    //   407: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   410: ldc 164
    //   412: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: aload_3
    //   416: invokevirtual 165	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
    //   419: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: ldc 159
    //   424: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload_3
    //   428: invokevirtual 166	java/io/IOException:getMessage	()Ljava/lang/String;
    //   431: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   440: goto -69 -> 371
    //   443: astore_3
    //   444: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   447: ifeq -76 -> 371
    //   450: ldc 65
    //   452: iconst_2
    //   453: new 97	java/lang/StringBuilder
    //   456: dup
    //   457: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   460: ldc 168
    //   462: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: aload_3
    //   466: invokevirtual 169	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   469: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: ldc 159
    //   474: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: aload_3
    //   478: invokevirtual 170	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   481: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   487: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   490: goto -119 -> 371
    //   493: aload_0
    //   494: getfield 33	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   497: aload_0
    //   498: invokevirtual 174	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   501: aload_0
    //   502: getfield 33	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   505: aload_0
    //   506: invokevirtual 178	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   509: iload_1
    //   510: tableswitch	default:+647 -> 1157, 0:+78->588, 1:+246->756, 2:+342->852
    //   537: nop
    //   538: lstore_0
    //   539: ifeq +28 -> 567
    //   542: ldc 65
    //   544: iconst_2
    //   545: new 97	java/lang/StringBuilder
    //   548: dup
    //   549: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   552: ldc 180
    //   554: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: iload_1
    //   558: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   561: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   564: invokestatic 137	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   567: aload_0
    //   568: getfield 33	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   571: invokevirtual 86	android/media/MediaPlayer:release	()V
    //   574: aload_0
    //   575: aconst_null
    //   576: putfield 33	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   579: aload_0
    //   580: getfield 33	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   583: ifnonnull +313 -> 896
    //   586: iconst_0
    //   587: ireturn
    //   588: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   591: ifeq +28 -> 619
    //   594: ldc 65
    //   596: iconst_2
    //   597: new 97	java/lang/StringBuilder
    //   600: dup
    //   601: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   604: ldc 182
    //   606: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   609: iload_2
    //   610: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   613: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   616: invokestatic 137	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   619: aload_0
    //   620: getfield 49	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   623: invokevirtual 186	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   626: iload_2
    //   627: invokevirtual 192	android/content/res/Resources:openRawResourceFd	(I)Landroid/content/res/AssetFileDescriptor;
    //   630: astore_3
    //   631: aload_3
    //   632: ifnonnull +48 -> 680
    //   635: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   638: ifeq +28 -> 666
    //   641: ldc 65
    //   643: iconst_2
    //   644: new 97	java/lang/StringBuilder
    //   647: dup
    //   648: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   651: ldc 194
    //   653: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: iload_2
    //   657: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   660: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   663: invokestatic 137	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   666: aload_0
    //   667: getfield 33	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   670: invokevirtual 86	android/media/MediaPlayer:release	()V
    //   673: aload_0
    //   674: aconst_null
    //   675: putfield 33	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   678: iconst_0
    //   679: ireturn
    //   680: aload_0
    //   681: getfield 33	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   684: aload_3
    //   685: invokevirtual 200	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   688: aload_3
    //   689: invokevirtual 204	android/content/res/AssetFileDescriptor:getStartOffset	()J
    //   692: aload_3
    //   693: invokevirtual 207	android/content/res/AssetFileDescriptor:getLength	()J
    //   696: invokevirtual 211	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;JJ)V
    //   699: aload_3
    //   700: invokevirtual 214	android/content/res/AssetFileDescriptor:close	()V
    //   703: goto -124 -> 579
    //   706: astore_3
    //   707: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   710: ifeq -339 -> 371
    //   713: ldc 65
    //   715: iconst_2
    //   716: new 97	java/lang/StringBuilder
    //   719: dup
    //   720: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   723: ldc 216
    //   725: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   728: aload_3
    //   729: invokevirtual 217	java/lang/IllegalArgumentException:getLocalizedMessage	()Ljava/lang/String;
    //   732: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: ldc 159
    //   737: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: aload_3
    //   741: invokevirtual 218	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   744: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   750: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   753: goto -382 -> 371
    //   756: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   759: ifeq +28 -> 787
    //   762: ldc 65
    //   764: iconst_2
    //   765: new 97	java/lang/StringBuilder
    //   768: dup
    //   769: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   772: ldc 220
    //   774: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   777: aload_3
    //   778: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   781: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   784: invokestatic 137	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   787: aload_0
    //   788: getfield 33	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   791: aload_0
    //   792: getfield 49	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   795: aload_3
    //   796: invokevirtual 223	android/media/MediaPlayer:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
    //   799: goto -220 -> 579
    //   802: astore_3
    //   803: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   806: ifeq -435 -> 371
    //   809: ldc 65
    //   811: iconst_2
    //   812: new 97	java/lang/StringBuilder
    //   815: dup
    //   816: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   819: ldc 225
    //   821: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: aload_3
    //   825: invokevirtual 226	java/lang/SecurityException:getLocalizedMessage	()Ljava/lang/String;
    //   828: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   831: ldc 159
    //   833: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: aload_3
    //   837: invokevirtual 227	java/lang/SecurityException:getMessage	()Ljava/lang/String;
    //   840: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   843: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   846: invokestatic 70	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   849: goto -478 -> 371
    //   852: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   855: ifeq +29 -> 884
    //   858: ldc 65
    //   860: iconst_2
    //   861: new 97	java/lang/StringBuilder
    //   864: dup
    //   865: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   868: ldc 229
    //   870: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   873: aload 4
    //   875: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   878: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   881: invokestatic 137	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   884: aload_0
    //   885: getfield 33	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   888: aload 4
    //   890: invokevirtual 232	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   893: goto -314 -> 579
    //   896: aload_0
    //   897: iload 7
    //   899: putfield 43	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_Boolean	Z
    //   902: iconst_0
    //   903: istore_1
    //   904: aload_0
    //   905: getfield 43	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_Boolean	Z
    //   908: ifeq +202 -> 1110
    //   911: aload_0
    //   912: iconst_2
    //   913: putfield 35	com/tencent/sharp/jni/TraeMediaPlayer:f	I
    //   916: iconst_1
    //   917: istore_1
    //   918: aload_0
    //   919: iload 8
    //   921: putfield 37	com/tencent/sharp/jni/TraeMediaPlayer:b	Z
    //   924: aload_0
    //   925: getfield 37	com/tencent/sharp/jni/TraeMediaPlayer:b	Z
    //   928: ifeq +9 -> 937
    //   931: aload_0
    //   932: iload 9
    //   934: putfield 35	com/tencent/sharp/jni/TraeMediaPlayer:f	I
    //   937: aload_0
    //   938: getfield 33	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   941: aload_0
    //   942: getfield 35	com/tencent/sharp/jni/TraeMediaPlayer:f	I
    //   945: invokevirtual 236	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   948: aload_0
    //   949: getfield 33	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   952: invokevirtual 239	android/media/MediaPlayer:prepare	()V
    //   955: aload_0
    //   956: getfield 33	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   959: iload 5
    //   961: invokevirtual 243	android/media/MediaPlayer:setLooping	(Z)V
    //   964: aload_0
    //   965: getfield 33	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   968: invokevirtual 246	android/media/MediaPlayer:start	()V
    //   971: iload 5
    //   973: iconst_1
    //   974: if_icmpne +154 -> 1128
    //   977: aload_0
    //   978: iconst_1
    //   979: putfield 41	com/tencent/sharp/jni/TraeMediaPlayer:e	I
    //   982: aload_0
    //   983: iconst_m1
    //   984: putfield 39	com/tencent/sharp/jni/TraeMediaPlayer:g	I
    //   987: aload_0
    //   988: aload_0
    //   989: getfield 41	com/tencent/sharp/jni/TraeMediaPlayer:e	I
    //   992: iconst_1
    //   993: isub
    //   994: putfield 41	com/tencent/sharp/jni/TraeMediaPlayer:e	I
    //   997: aload_0
    //   998: getfield 37	com/tencent/sharp/jni/TraeMediaPlayer:b	Z
    //   1001: ifne +9 -> 1010
    //   1004: aload 11
    //   1006: iload_1
    //   1007: invokevirtual 249	android/media/AudioManager:setMode	(I)V
    //   1010: aload_0
    //   1011: getfield 39	com/tencent/sharp/jni/TraeMediaPlayer:g	I
    //   1014: ifle +45 -> 1059
    //   1017: aload_0
    //   1018: new 80	java/util/Timer
    //   1021: dup
    //   1022: invokespecial 250	java/util/Timer:<init>	()V
    //   1025: putfield 45	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_JavaUtilTimer	Ljava/util/Timer;
    //   1028: aload_0
    //   1029: new 252	hzh
    //   1032: dup
    //   1033: aload_0
    //   1034: invokespecial 255	hzh:<init>	(Lcom/tencent/sharp/jni/TraeMediaPlayer;)V
    //   1037: putfield 47	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_JavaUtilTimerTask	Ljava/util/TimerTask;
    //   1040: aload_0
    //   1041: getfield 45	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_JavaUtilTimer	Ljava/util/Timer;
    //   1044: aload_0
    //   1045: getfield 47	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_JavaUtilTimerTask	Ljava/util/TimerTask;
    //   1048: aload_0
    //   1049: getfield 39	com/tencent/sharp/jni/TraeMediaPlayer:g	I
    //   1052: bipush 100
    //   1054: iadd
    //   1055: i2l
    //   1056: invokevirtual 259	java/util/Timer:schedule	(Ljava/util/TimerTask;J)V
    //   1059: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1062: ifeq +98 -> 1160
    //   1065: ldc 65
    //   1067: iconst_2
    //   1068: new 97	java/lang/StringBuilder
    //   1071: dup
    //   1072: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   1075: ldc_w 261
    //   1078: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1081: aload_0
    //   1082: getfield 33	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   1085: invokevirtual 264	android/media/MediaPlayer:getDuration	()I
    //   1088: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1091: ldc 118
    //   1093: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1096: iload 5
    //   1098: invokevirtual 127	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1101: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1104: invokestatic 137	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1107: goto +53 -> 1160
    //   1110: aload_0
    //   1111: iconst_0
    //   1112: putfield 35	com/tencent/sharp/jni/TraeMediaPlayer:f	I
    //   1115: getstatic 269	android/os/Build$VERSION:SDK_INT	I
    //   1118: bipush 11
    //   1120: if_icmplt -202 -> 918
    //   1123: iconst_3
    //   1124: istore_1
    //   1125: goto -207 -> 918
    //   1128: aload_0
    //   1129: iload 6
    //   1131: putfield 41	com/tencent/sharp/jni/TraeMediaPlayer:e	I
    //   1134: aload_0
    //   1135: aload_0
    //   1136: getfield 41	com/tencent/sharp/jni/TraeMediaPlayer:e	I
    //   1139: aload_0
    //   1140: getfield 33	com/tencent/sharp/jni/TraeMediaPlayer:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   1143: invokevirtual 264	android/media/MediaPlayer:getDuration	()I
    //   1146: imul
    //   1147: putfield 39	com/tencent/sharp/jni/TraeMediaPlayer:g	I
    //   1150: goto -163 -> 987
    //   1153: astore_3
    //   1154: goto -776 -> 378
    //   1157: goto -621 -> 536
    //   1160: iconst_1
    //   1161: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1162	0	this	TraeMediaPlayer
    //   0	1162	1	paramInt1	int
    //   0	1162	2	paramInt2	int
    //   0	1162	3	paramUri	android.net.Uri
    //   0	1162	4	paramString	java.lang.String
    //   0	1162	5	paramBoolean1	boolean
    //   0	1162	6	paramInt3	int
    //   0	1162	7	paramBoolean2	boolean
    //   0	1162	8	paramBoolean3	boolean
    //   0	1162	9	paramInt4	int
    //   223	3	10	bool	boolean
    //   64	217	11	localObject	Object
    //   314	691	11	localException	Exception
    //   55	15	12	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   232	239	314	java/lang/Exception
    //   209	225	324	java/lang/IllegalStateException
    //   239	244	324	java/lang/IllegalStateException
    //   244	268	324	java/lang/IllegalStateException
    //   268	312	324	java/lang/IllegalStateException
    //   316	321	324	java/lang/IllegalStateException
    //   386	393	324	java/lang/IllegalStateException
    //   493	509	324	java/lang/IllegalStateException
    //   536	567	324	java/lang/IllegalStateException
    //   567	579	324	java/lang/IllegalStateException
    //   579	586	324	java/lang/IllegalStateException
    //   588	619	324	java/lang/IllegalStateException
    //   619	631	324	java/lang/IllegalStateException
    //   635	666	324	java/lang/IllegalStateException
    //   666	678	324	java/lang/IllegalStateException
    //   680	703	324	java/lang/IllegalStateException
    //   756	787	324	java/lang/IllegalStateException
    //   787	799	324	java/lang/IllegalStateException
    //   852	884	324	java/lang/IllegalStateException
    //   884	893	324	java/lang/IllegalStateException
    //   896	902	324	java/lang/IllegalStateException
    //   904	916	324	java/lang/IllegalStateException
    //   918	937	324	java/lang/IllegalStateException
    //   937	971	324	java/lang/IllegalStateException
    //   977	987	324	java/lang/IllegalStateException
    //   987	1010	324	java/lang/IllegalStateException
    //   1010	1059	324	java/lang/IllegalStateException
    //   1059	1107	324	java/lang/IllegalStateException
    //   1110	1115	324	java/lang/IllegalStateException
    //   1115	1123	324	java/lang/IllegalStateException
    //   1128	1150	324	java/lang/IllegalStateException
    //   232	239	385	finally
    //   209	225	393	java/io/IOException
    //   239	244	393	java/io/IOException
    //   244	268	393	java/io/IOException
    //   268	312	393	java/io/IOException
    //   316	321	393	java/io/IOException
    //   386	393	393	java/io/IOException
    //   493	509	393	java/io/IOException
    //   536	567	393	java/io/IOException
    //   567	579	393	java/io/IOException
    //   579	586	393	java/io/IOException
    //   588	619	393	java/io/IOException
    //   619	631	393	java/io/IOException
    //   635	666	393	java/io/IOException
    //   666	678	393	java/io/IOException
    //   680	703	393	java/io/IOException
    //   756	787	393	java/io/IOException
    //   787	799	393	java/io/IOException
    //   852	884	393	java/io/IOException
    //   884	893	393	java/io/IOException
    //   896	902	393	java/io/IOException
    //   904	916	393	java/io/IOException
    //   918	937	393	java/io/IOException
    //   937	971	393	java/io/IOException
    //   977	987	393	java/io/IOException
    //   987	1010	393	java/io/IOException
    //   1010	1059	393	java/io/IOException
    //   1059	1107	393	java/io/IOException
    //   1110	1115	393	java/io/IOException
    //   1115	1123	393	java/io/IOException
    //   1128	1150	393	java/io/IOException
    //   209	225	443	java/lang/Exception
    //   239	244	443	java/lang/Exception
    //   244	268	443	java/lang/Exception
    //   268	312	443	java/lang/Exception
    //   316	321	443	java/lang/Exception
    //   325	371	443	java/lang/Exception
    //   386	393	443	java/lang/Exception
    //   394	440	443	java/lang/Exception
    //   493	509	443	java/lang/Exception
    //   536	567	443	java/lang/Exception
    //   567	579	443	java/lang/Exception
    //   579	586	443	java/lang/Exception
    //   588	619	443	java/lang/Exception
    //   619	631	443	java/lang/Exception
    //   635	666	443	java/lang/Exception
    //   666	678	443	java/lang/Exception
    //   680	703	443	java/lang/Exception
    //   707	753	443	java/lang/Exception
    //   756	787	443	java/lang/Exception
    //   787	799	443	java/lang/Exception
    //   803	849	443	java/lang/Exception
    //   852	884	443	java/lang/Exception
    //   884	893	443	java/lang/Exception
    //   896	902	443	java/lang/Exception
    //   904	916	443	java/lang/Exception
    //   918	937	443	java/lang/Exception
    //   937	971	443	java/lang/Exception
    //   977	987	443	java/lang/Exception
    //   987	1010	443	java/lang/Exception
    //   1010	1059	443	java/lang/Exception
    //   1059	1107	443	java/lang/Exception
    //   1110	1115	443	java/lang/Exception
    //   1115	1123	443	java/lang/Exception
    //   1128	1150	443	java/lang/Exception
    //   209	225	706	java/lang/IllegalArgumentException
    //   239	244	706	java/lang/IllegalArgumentException
    //   244	268	706	java/lang/IllegalArgumentException
    //   268	312	706	java/lang/IllegalArgumentException
    //   316	321	706	java/lang/IllegalArgumentException
    //   386	393	706	java/lang/IllegalArgumentException
    //   493	509	706	java/lang/IllegalArgumentException
    //   536	567	706	java/lang/IllegalArgumentException
    //   567	579	706	java/lang/IllegalArgumentException
    //   579	586	706	java/lang/IllegalArgumentException
    //   588	619	706	java/lang/IllegalArgumentException
    //   619	631	706	java/lang/IllegalArgumentException
    //   635	666	706	java/lang/IllegalArgumentException
    //   666	678	706	java/lang/IllegalArgumentException
    //   680	703	706	java/lang/IllegalArgumentException
    //   756	787	706	java/lang/IllegalArgumentException
    //   787	799	706	java/lang/IllegalArgumentException
    //   852	884	706	java/lang/IllegalArgumentException
    //   884	893	706	java/lang/IllegalArgumentException
    //   896	902	706	java/lang/IllegalArgumentException
    //   904	916	706	java/lang/IllegalArgumentException
    //   918	937	706	java/lang/IllegalArgumentException
    //   937	971	706	java/lang/IllegalArgumentException
    //   977	987	706	java/lang/IllegalArgumentException
    //   987	1010	706	java/lang/IllegalArgumentException
    //   1010	1059	706	java/lang/IllegalArgumentException
    //   1059	1107	706	java/lang/IllegalArgumentException
    //   1110	1115	706	java/lang/IllegalArgumentException
    //   1115	1123	706	java/lang/IllegalArgumentException
    //   1128	1150	706	java/lang/IllegalArgumentException
    //   209	225	802	java/lang/SecurityException
    //   239	244	802	java/lang/SecurityException
    //   244	268	802	java/lang/SecurityException
    //   268	312	802	java/lang/SecurityException
    //   316	321	802	java/lang/SecurityException
    //   386	393	802	java/lang/SecurityException
    //   493	509	802	java/lang/SecurityException
    //   536	567	802	java/lang/SecurityException
    //   567	579	802	java/lang/SecurityException
    //   579	586	802	java/lang/SecurityException
    //   588	619	802	java/lang/SecurityException
    //   619	631	802	java/lang/SecurityException
    //   635	666	802	java/lang/SecurityException
    //   666	678	802	java/lang/SecurityException
    //   680	703	802	java/lang/SecurityException
    //   756	787	802	java/lang/SecurityException
    //   787	799	802	java/lang/SecurityException
    //   852	884	802	java/lang/SecurityException
    //   884	893	802	java/lang/SecurityException
    //   896	902	802	java/lang/SecurityException
    //   904	916	802	java/lang/SecurityException
    //   918	937	802	java/lang/SecurityException
    //   937	971	802	java/lang/SecurityException
    //   977	987	802	java/lang/SecurityException
    //   987	1010	802	java/lang/SecurityException
    //   1010	1059	802	java/lang/SecurityException
    //   1059	1107	802	java/lang/SecurityException
    //   1110	1115	802	java/lang/SecurityException
    //   1115	1123	802	java/lang/SecurityException
    //   1128	1150	802	java/lang/SecurityException
    //   371	378	1153	java/lang/Exception
  }
  
  public int b()
  {
    return this.g;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    AudioDeviceInterface.LogTraceEntry(" cb:" + this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer$OnCompletionListener + " loopCount:" + this.e);
    try
    {
      if (this.e <= 0)
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
        this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
        if (this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer$OnCompletionListener != null) {
          this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer$OnCompletionListener.a();
        }
      }
      for (;;)
      {
        label74:
        AudioDeviceInterface.LogTraceExit();
        return;
        this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
        this.e -= 1;
      }
    }
    catch (Exception paramMediaPlayer)
    {
      break label74;
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    AudioDeviceInterface.LogTraceEntry(" cb:" + this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer$OnCompletionListener + " arg1:" + paramInt1 + " arg2:" + paramInt2);
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      label53:
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      if (this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer$OnCompletionListener != null) {
        this.jdField_a_of_type_ComTencentSharpJniTraeMediaPlayer$OnCompletionListener.a();
      }
      AudioDeviceInterface.LogTraceExit();
      return false;
    }
    catch (Exception paramMediaPlayer)
    {
      break label53;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.sharp.jni.TraeMediaPlayer
 * JD-Core Version:    0.7.0.1
 */