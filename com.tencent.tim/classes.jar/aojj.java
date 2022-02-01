import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.netprobe.MtuProbe;
import com.tencent.mobileqq.highway.netprobe.PingProbe;
import com.tencent.mobileqq.highway.netprobe.ProbeChain;
import com.tencent.mobileqq.highway.netprobe.ProbeItem;
import com.tencent.mobileqq.highway.netprobe.ProbeRequest;
import com.tencent.mobileqq.highway.netprobe.ProbeTask;
import com.tencent.mobileqq.highway.netprobe.TracerouteProbe;
import com.tencent.mobileqq.highway.netprobe.WeakNetLearner;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.utils.PicCryptor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.manager.ProxyIpManager;
import mqq.manager.TicketManager;

public class aojj
  extends aoji
  implements aolm.c
{
  private static final Pattern aj = Pattern.compile(".*//[^/]*/[^/]*/(.*)/.*");
  private ArrayList<String> Bm = new ArrayList();
  protected aool.c a;
  protected boolean cLO;
  protected boolean cLP;
  protected boolean cLQ;
  protected boolean cLR;
  protected boolean cLS;
  protected String cla = "";
  protected String clb;
  protected int dOQ;
  protected byte[] fF;
  protected byte[] mST;
  public WeakNetLearner mWeakNetLearner;
  
  public aojj() {}
  
  public aojj(aooi paramaooi, aool paramaool)
  {
    super(paramaooi, paramaool);
    this.mWeakNetLearner = aojp.a;
    this.Ha = ((ProxyIpManager)this.app.getManager(3)).getProxyIp(3);
    dUS();
  }
  
  private boolean a(aomh paramaomh)
  {
    if (paramaomh != null) {
      try
      {
        if (paramaomh.b.atY != null)
        {
          BitmapFactory.Options localOptions = new BitmapFactory.Options();
          localOptions.inJustDecodeBounds = true;
          BitmapFactory.decodeFile(paramaomh.b.atY, localOptions);
          if (localOptions.outHeight > 0)
          {
            int i = localOptions.outWidth;
            if (i > 0) {}
          }
          else
          {
            return false;
          }
        }
      }
      catch (Throwable paramaomh)
      {
        paramaomh.printStackTrace();
        return false;
      }
    }
    return true;
  }
  
  private void f(aomh paramaomh)
  {
    String str;
    if ((paramaomh.b != null) && (paramaomh.b.mTempPath != null) && (paramaomh.b.mTempPath.length() != 0) && (paramaomh.b.atY != null) && (paramaomh.b.atY.length() != 0))
    {
      str = paramaomh.b.mTempPath;
      paramaomh = paramaomh.b.atY;
      if (this.h != null) {
        break label77;
      }
    }
    label77:
    int i;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        aonc.a(this.h.mUinType, this.h.cNy, this.h.mFileType, String.valueOf(this.h.mUniseq), "handleProgressiveJPEG", "mUiRequest.mRequestOffset: " + this.h.dQG + " mUiRequest.mRequestLength: " + this.h.dQH + " tempPath: " + str + " outPath: " + paramaomh);
      }
      i = a(this.h);
      if (i == 4)
      {
        hJ(paramaomh, str);
        return;
      }
      if (i == 2)
      {
        hK(paramaomh, str);
        return;
      }
    } while (i != 3);
    hL(paramaomh, str);
  }
  
  /* Error */
  private void hJ(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 4
    //   6: new 165	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   13: aload_1
    //   14: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: ldc 213
    //   19: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: astore 7
    //   27: aload_1
    //   28: aload 7
    //   30: invokestatic 219	aqhq:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   33: pop
    //   34: new 221	java/io/File
    //   37: dup
    //   38: aload 7
    //   40: invokespecial 224	java/io/File:<init>	(Ljava/lang/String;)V
    //   43: astore 5
    //   45: new 221	java/io/File
    //   48: dup
    //   49: aload_2
    //   50: invokespecial 224	java/io/File:<init>	(Ljava/lang/String;)V
    //   53: astore 8
    //   55: invokestatic 227	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   58: ifeq +41 -> 99
    //   61: ldc 229
    //   63: iconst_4
    //   64: new 165	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   71: ldc 231
    //   73: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload 8
    //   78: invokevirtual 234	java/io/File:length	()J
    //   81: invokevirtual 237	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   84: ldc 239
    //   86: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_1
    //   90: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 243	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   99: aload 5
    //   101: invokevirtual 246	java/io/File:exists	()Z
    //   104: ifeq +139 -> 243
    //   107: aload 8
    //   109: invokevirtual 246	java/io/File:exists	()Z
    //   112: ifeq +131 -> 243
    //   115: new 248	java/io/RandomAccessFile
    //   118: dup
    //   119: aload 5
    //   121: ldc 250
    //   123: invokespecial 253	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   126: astore_2
    //   127: aload_2
    //   128: aload_0
    //   129: getfield 136	aojj:h	Laool;
    //   132: getfield 175	aool:dQG	I
    //   135: i2l
    //   136: invokevirtual 257	java/io/RandomAccessFile:seek	(J)V
    //   139: new 259	java/io/FileInputStream
    //   142: dup
    //   143: aload 8
    //   145: invokespecial 262	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   148: astore 5
    //   150: sipush 1024
    //   153: newarray byte
    //   155: astore 4
    //   157: aload 5
    //   159: aload 4
    //   161: invokevirtual 266	java/io/FileInputStream:read	([B)I
    //   164: istore_3
    //   165: iload_3
    //   166: ifle +78 -> 244
    //   169: aload_2
    //   170: aload 4
    //   172: iconst_0
    //   173: iload_3
    //   174: invokevirtual 270	java/io/RandomAccessFile:write	([BII)V
    //   177: goto -20 -> 157
    //   180: astore 4
    //   182: aload_2
    //   183: astore 4
    //   185: aload 5
    //   187: astore_2
    //   188: aload 4
    //   190: ifnull +8 -> 198
    //   193: aload 4
    //   195: invokevirtual 273	java/io/RandomAccessFile:close	()V
    //   198: aload_2
    //   199: ifnull +7 -> 206
    //   202: aload_2
    //   203: invokevirtual 274	java/io/FileInputStream:close	()V
    //   206: aload 8
    //   208: invokevirtual 277	java/io/File:delete	()Z
    //   211: pop
    //   212: aload 7
    //   214: aload_1
    //   215: invokestatic 280	aqhq:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   218: ifne +25 -> 243
    //   221: aload 7
    //   223: aload_1
    //   224: invokestatic 219	aqhq:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   227: ifeq +121 -> 348
    //   230: new 221	java/io/File
    //   233: dup
    //   234: aload 7
    //   236: invokespecial 224	java/io/File:<init>	(Ljava/lang/String;)V
    //   239: invokevirtual 277	java/io/File:delete	()Z
    //   242: pop
    //   243: return
    //   244: aload_2
    //   245: ifnull +7 -> 252
    //   248: aload_2
    //   249: invokevirtual 273	java/io/RandomAccessFile:close	()V
    //   252: aload 5
    //   254: ifnull +8 -> 262
    //   257: aload 5
    //   259: invokevirtual 274	java/io/FileInputStream:close	()V
    //   262: aload 8
    //   264: invokevirtual 277	java/io/File:delete	()Z
    //   267: pop
    //   268: aload 7
    //   270: aload_1
    //   271: invokestatic 280	aqhq:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   274: ifne -31 -> 243
    //   277: aload 7
    //   279: aload_1
    //   280: invokestatic 219	aqhq:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   283: ifeq +33 -> 316
    //   286: new 221	java/io/File
    //   289: dup
    //   290: aload 7
    //   292: invokespecial 224	java/io/File:<init>	(Ljava/lang/String;)V
    //   295: invokevirtual 277	java/io/File:delete	()Z
    //   298: pop
    //   299: return
    //   300: astore_2
    //   301: aload_2
    //   302: invokevirtual 281	java/io/IOException:printStackTrace	()V
    //   305: goto -53 -> 252
    //   308: astore_2
    //   309: aload_2
    //   310: invokevirtual 281	java/io/IOException:printStackTrace	()V
    //   313: goto -51 -> 262
    //   316: new 221	java/io/File
    //   319: dup
    //   320: aload 7
    //   322: invokespecial 224	java/io/File:<init>	(Ljava/lang/String;)V
    //   325: invokevirtual 277	java/io/File:delete	()Z
    //   328: pop
    //   329: return
    //   330: astore 4
    //   332: aload 4
    //   334: invokevirtual 281	java/io/IOException:printStackTrace	()V
    //   337: goto -139 -> 198
    //   340: astore_2
    //   341: aload_2
    //   342: invokevirtual 281	java/io/IOException:printStackTrace	()V
    //   345: goto -139 -> 206
    //   348: new 221	java/io/File
    //   351: dup
    //   352: aload 7
    //   354: invokespecial 224	java/io/File:<init>	(Ljava/lang/String;)V
    //   357: invokevirtual 277	java/io/File:delete	()Z
    //   360: pop
    //   361: return
    //   362: astore 4
    //   364: aconst_null
    //   365: astore_2
    //   366: aload 6
    //   368: astore 5
    //   370: aload_2
    //   371: ifnull +7 -> 378
    //   374: aload_2
    //   375: invokevirtual 273	java/io/RandomAccessFile:close	()V
    //   378: aload 5
    //   380: ifnull +8 -> 388
    //   383: aload 5
    //   385: invokevirtual 274	java/io/FileInputStream:close	()V
    //   388: aload 8
    //   390: invokevirtual 277	java/io/File:delete	()Z
    //   393: pop
    //   394: aload 7
    //   396: aload_1
    //   397: invokestatic 280	aqhq:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   400: ifne +25 -> 425
    //   403: aload 7
    //   405: aload_1
    //   406: invokestatic 219	aqhq:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   409: ifeq +35 -> 444
    //   412: new 221	java/io/File
    //   415: dup
    //   416: aload 7
    //   418: invokespecial 224	java/io/File:<init>	(Ljava/lang/String;)V
    //   421: invokevirtual 277	java/io/File:delete	()Z
    //   424: pop
    //   425: aload 4
    //   427: athrow
    //   428: astore_2
    //   429: aload_2
    //   430: invokevirtual 281	java/io/IOException:printStackTrace	()V
    //   433: goto -55 -> 378
    //   436: astore_2
    //   437: aload_2
    //   438: invokevirtual 281	java/io/IOException:printStackTrace	()V
    //   441: goto -53 -> 388
    //   444: new 221	java/io/File
    //   447: dup
    //   448: aload 7
    //   450: invokespecial 224	java/io/File:<init>	(Ljava/lang/String;)V
    //   453: invokevirtual 277	java/io/File:delete	()Z
    //   456: pop
    //   457: goto -32 -> 425
    //   460: astore 4
    //   462: aload 6
    //   464: astore 5
    //   466: goto -96 -> 370
    //   469: astore 4
    //   471: goto -101 -> 370
    //   474: astore_2
    //   475: aconst_null
    //   476: astore_2
    //   477: goto -289 -> 188
    //   480: astore 4
    //   482: aconst_null
    //   483: astore 5
    //   485: aload_2
    //   486: astore 4
    //   488: aload 5
    //   490: astore_2
    //   491: goto -303 -> 188
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	494	0	this	aojj
    //   0	494	1	paramString1	String
    //   0	494	2	paramString2	String
    //   164	10	3	i	int
    //   4	167	4	arrayOfByte	byte[]
    //   180	1	4	localThrowable1	Throwable
    //   183	11	4	str1	String
    //   330	3	4	localIOException	java.io.IOException
    //   362	64	4	localObject1	Object
    //   460	1	4	localObject2	Object
    //   469	1	4	localObject3	Object
    //   480	1	4	localThrowable2	Throwable
    //   486	1	4	str2	String
    //   43	446	5	localObject4	Object
    //   1	462	6	localObject5	Object
    //   25	424	7	str3	String
    //   53	336	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   150	157	180	java/lang/Throwable
    //   157	165	180	java/lang/Throwable
    //   169	177	180	java/lang/Throwable
    //   248	252	300	java/io/IOException
    //   257	262	308	java/io/IOException
    //   193	198	330	java/io/IOException
    //   202	206	340	java/io/IOException
    //   115	127	362	finally
    //   374	378	428	java/io/IOException
    //   383	388	436	java/io/IOException
    //   127	150	460	finally
    //   150	157	469	finally
    //   157	165	469	finally
    //   169	177	469	finally
    //   115	127	474	java/lang/Throwable
    //   127	150	480	java/lang/Throwable
  }
  
  /* Error */
  private void hK(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 221	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 224	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_3
    //   9: new 221	java/io/File
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 224	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 4
    //   19: aload 4
    //   21: invokevirtual 246	java/io/File:exists	()Z
    //   24: ifeq +9 -> 33
    //   27: aload 4
    //   29: invokevirtual 277	java/io/File:delete	()Z
    //   32: pop
    //   33: invokestatic 227	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   36: ifeq +41 -> 77
    //   39: ldc 229
    //   41: iconst_4
    //   42: new 165	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   49: ldc_w 285
    //   52: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_3
    //   56: invokevirtual 234	java/io/File:length	()J
    //   59: invokevirtual 237	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   62: ldc 239
    //   64: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_1
    //   68: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 243	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: aload_3
    //   78: invokevirtual 246	java/io/File:exists	()Z
    //   81: ifeq +89 -> 170
    //   84: new 248	java/io/RandomAccessFile
    //   87: dup
    //   88: aload_3
    //   89: ldc 250
    //   91: invokespecial 253	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   94: astore 4
    //   96: aload 4
    //   98: astore_3
    //   99: aload 4
    //   101: aload 4
    //   103: invokevirtual 286	java/io/RandomAccessFile:length	()J
    //   106: invokevirtual 257	java/io/RandomAccessFile:seek	(J)V
    //   109: aload 4
    //   111: astore_3
    //   112: aload 4
    //   114: iconst_2
    //   115: newarray byte
    //   117: dup
    //   118: iconst_0
    //   119: ldc_w 287
    //   122: bastore
    //   123: dup
    //   124: iconst_1
    //   125: ldc_w 288
    //   128: bastore
    //   129: invokevirtual 291	java/io/RandomAccessFile:write	([B)V
    //   132: aload 4
    //   134: ifnull +8 -> 142
    //   137: aload 4
    //   139: invokevirtual 273	java/io/RandomAccessFile:close	()V
    //   142: aload_2
    //   143: aload_1
    //   144: invokestatic 280	aqhq:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   147: ifne +23 -> 170
    //   150: aload_2
    //   151: aload_1
    //   152: invokestatic 219	aqhq:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   155: ifeq +24 -> 179
    //   158: new 221	java/io/File
    //   161: dup
    //   162: aload_2
    //   163: invokespecial 224	java/io/File:<init>	(Ljava/lang/String;)V
    //   166: invokevirtual 277	java/io/File:delete	()Z
    //   169: pop
    //   170: return
    //   171: astore_3
    //   172: aload_3
    //   173: invokevirtual 281	java/io/IOException:printStackTrace	()V
    //   176: goto -34 -> 142
    //   179: new 221	java/io/File
    //   182: dup
    //   183: aload_2
    //   184: invokespecial 224	java/io/File:<init>	(Ljava/lang/String;)V
    //   187: invokevirtual 277	java/io/File:delete	()Z
    //   190: pop
    //   191: return
    //   192: astore 5
    //   194: aconst_null
    //   195: astore 4
    //   197: aload 4
    //   199: astore_3
    //   200: aload 5
    //   202: invokevirtual 292	java/io/FileNotFoundException:printStackTrace	()V
    //   205: aload 4
    //   207: ifnull +8 -> 215
    //   210: aload 4
    //   212: invokevirtual 273	java/io/RandomAccessFile:close	()V
    //   215: aload_2
    //   216: aload_1
    //   217: invokestatic 280	aqhq:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   220: ifne -50 -> 170
    //   223: aload_2
    //   224: aload_1
    //   225: invokestatic 219	aqhq:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   228: ifeq +24 -> 252
    //   231: new 221	java/io/File
    //   234: dup
    //   235: aload_2
    //   236: invokespecial 224	java/io/File:<init>	(Ljava/lang/String;)V
    //   239: invokevirtual 277	java/io/File:delete	()Z
    //   242: pop
    //   243: return
    //   244: astore_3
    //   245: aload_3
    //   246: invokevirtual 281	java/io/IOException:printStackTrace	()V
    //   249: goto -34 -> 215
    //   252: new 221	java/io/File
    //   255: dup
    //   256: aload_2
    //   257: invokespecial 224	java/io/File:<init>	(Ljava/lang/String;)V
    //   260: invokevirtual 277	java/io/File:delete	()Z
    //   263: pop
    //   264: return
    //   265: astore 5
    //   267: aconst_null
    //   268: astore 4
    //   270: aload 4
    //   272: astore_3
    //   273: aload 5
    //   275: invokevirtual 281	java/io/IOException:printStackTrace	()V
    //   278: aload 4
    //   280: ifnull +8 -> 288
    //   283: aload 4
    //   285: invokevirtual 273	java/io/RandomAccessFile:close	()V
    //   288: aload_2
    //   289: aload_1
    //   290: invokestatic 280	aqhq:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   293: ifne -123 -> 170
    //   296: aload_2
    //   297: aload_1
    //   298: invokestatic 219	aqhq:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   301: ifeq +24 -> 325
    //   304: new 221	java/io/File
    //   307: dup
    //   308: aload_2
    //   309: invokespecial 224	java/io/File:<init>	(Ljava/lang/String;)V
    //   312: invokevirtual 277	java/io/File:delete	()Z
    //   315: pop
    //   316: return
    //   317: astore_3
    //   318: aload_3
    //   319: invokevirtual 281	java/io/IOException:printStackTrace	()V
    //   322: goto -34 -> 288
    //   325: new 221	java/io/File
    //   328: dup
    //   329: aload_2
    //   330: invokespecial 224	java/io/File:<init>	(Ljava/lang/String;)V
    //   333: invokevirtual 277	java/io/File:delete	()Z
    //   336: pop
    //   337: return
    //   338: astore 4
    //   340: aconst_null
    //   341: astore_3
    //   342: aload_3
    //   343: ifnull +7 -> 350
    //   346: aload_3
    //   347: invokevirtual 273	java/io/RandomAccessFile:close	()V
    //   350: aload_2
    //   351: aload_1
    //   352: invokestatic 280	aqhq:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   355: ifne +23 -> 378
    //   358: aload_2
    //   359: aload_1
    //   360: invokestatic 219	aqhq:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   363: ifeq +26 -> 389
    //   366: new 221	java/io/File
    //   369: dup
    //   370: aload_2
    //   371: invokespecial 224	java/io/File:<init>	(Ljava/lang/String;)V
    //   374: invokevirtual 277	java/io/File:delete	()Z
    //   377: pop
    //   378: aload 4
    //   380: athrow
    //   381: astore_3
    //   382: aload_3
    //   383: invokevirtual 281	java/io/IOException:printStackTrace	()V
    //   386: goto -36 -> 350
    //   389: new 221	java/io/File
    //   392: dup
    //   393: aload_2
    //   394: invokespecial 224	java/io/File:<init>	(Ljava/lang/String;)V
    //   397: invokevirtual 277	java/io/File:delete	()Z
    //   400: pop
    //   401: goto -23 -> 378
    //   404: astore 4
    //   406: goto -64 -> 342
    //   409: astore 5
    //   411: goto -141 -> 270
    //   414: astore 5
    //   416: goto -219 -> 197
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	419	0	this	aojj
    //   0	419	1	paramString1	String
    //   0	419	2	paramString2	String
    //   8	104	3	localObject1	Object
    //   171	2	3	localIOException1	java.io.IOException
    //   199	1	3	localObject2	Object
    //   244	2	3	localIOException2	java.io.IOException
    //   272	1	3	localObject3	Object
    //   317	2	3	localIOException3	java.io.IOException
    //   341	6	3	localObject4	Object
    //   381	2	3	localIOException4	java.io.IOException
    //   17	267	4	localObject5	Object
    //   338	41	4	localObject6	Object
    //   404	1	4	localObject7	Object
    //   192	9	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   265	9	5	localIOException5	java.io.IOException
    //   409	1	5	localIOException6	java.io.IOException
    //   414	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   137	142	171	java/io/IOException
    //   84	96	192	java/io/FileNotFoundException
    //   210	215	244	java/io/IOException
    //   84	96	265	java/io/IOException
    //   283	288	317	java/io/IOException
    //   84	96	338	finally
    //   346	350	381	java/io/IOException
    //   99	109	404	finally
    //   112	132	404	finally
    //   200	205	404	finally
    //   273	278	404	finally
    //   99	109	409	java/io/IOException
    //   112	132	409	java/io/IOException
    //   99	109	414	java/io/FileNotFoundException
    //   112	132	414	java/io/FileNotFoundException
  }
  
  /* Error */
  private void hL(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 4
    //   6: new 165	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   13: aload_1
    //   14: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: ldc 213
    //   19: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: astore 7
    //   27: aload_1
    //   28: aload 7
    //   30: invokestatic 219	aqhq:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   33: pop
    //   34: new 221	java/io/File
    //   37: dup
    //   38: aload 7
    //   40: invokespecial 224	java/io/File:<init>	(Ljava/lang/String;)V
    //   43: astore 5
    //   45: new 221	java/io/File
    //   48: dup
    //   49: aload_2
    //   50: invokespecial 224	java/io/File:<init>	(Ljava/lang/String;)V
    //   53: astore 8
    //   55: invokestatic 227	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   58: ifeq +42 -> 100
    //   61: ldc 229
    //   63: iconst_4
    //   64: new 165	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   71: ldc_w 294
    //   74: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload 8
    //   79: invokevirtual 234	java/io/File:length	()J
    //   82: invokevirtual 237	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   85: ldc 239
    //   87: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_1
    //   91: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 243	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   100: aload 5
    //   102: invokevirtual 246	java/io/File:exists	()Z
    //   105: ifeq +139 -> 244
    //   108: aload 8
    //   110: invokevirtual 246	java/io/File:exists	()Z
    //   113: ifeq +131 -> 244
    //   116: new 248	java/io/RandomAccessFile
    //   119: dup
    //   120: aload 5
    //   122: ldc 250
    //   124: invokespecial 253	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   127: astore_2
    //   128: aload_2
    //   129: aload_0
    //   130: getfield 136	aojj:h	Laool;
    //   133: getfield 175	aool:dQG	I
    //   136: i2l
    //   137: invokevirtual 257	java/io/RandomAccessFile:seek	(J)V
    //   140: new 259	java/io/FileInputStream
    //   143: dup
    //   144: aload 8
    //   146: invokespecial 262	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   149: astore 5
    //   151: sipush 1024
    //   154: newarray byte
    //   156: astore 4
    //   158: aload 5
    //   160: aload 4
    //   162: invokevirtual 266	java/io/FileInputStream:read	([B)I
    //   165: istore_3
    //   166: iload_3
    //   167: ifle +78 -> 245
    //   170: aload_2
    //   171: aload 4
    //   173: iconst_0
    //   174: iload_3
    //   175: invokevirtual 270	java/io/RandomAccessFile:write	([BII)V
    //   178: goto -20 -> 158
    //   181: astore 4
    //   183: aload_2
    //   184: astore 4
    //   186: aload 5
    //   188: astore_2
    //   189: aload 4
    //   191: ifnull +8 -> 199
    //   194: aload 4
    //   196: invokevirtual 273	java/io/RandomAccessFile:close	()V
    //   199: aload_2
    //   200: ifnull +7 -> 207
    //   203: aload_2
    //   204: invokevirtual 274	java/io/FileInputStream:close	()V
    //   207: aload 8
    //   209: invokevirtual 277	java/io/File:delete	()Z
    //   212: pop
    //   213: aload 7
    //   215: aload_1
    //   216: invokestatic 280	aqhq:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   219: ifne +25 -> 244
    //   222: aload 7
    //   224: aload_1
    //   225: invokestatic 219	aqhq:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   228: ifeq +106 -> 334
    //   231: new 221	java/io/File
    //   234: dup
    //   235: aload 7
    //   237: invokespecial 224	java/io/File:<init>	(Ljava/lang/String;)V
    //   240: invokevirtual 277	java/io/File:delete	()Z
    //   243: pop
    //   244: return
    //   245: aload_2
    //   246: iconst_2
    //   247: newarray byte
    //   249: dup
    //   250: iconst_0
    //   251: ldc_w 287
    //   254: bastore
    //   255: dup
    //   256: iconst_1
    //   257: ldc_w 288
    //   260: bastore
    //   261: invokevirtual 291	java/io/RandomAccessFile:write	([B)V
    //   264: aload_2
    //   265: ifnull +7 -> 272
    //   268: aload_2
    //   269: invokevirtual 273	java/io/RandomAccessFile:close	()V
    //   272: aload 5
    //   274: ifnull +8 -> 282
    //   277: aload 5
    //   279: invokevirtual 274	java/io/FileInputStream:close	()V
    //   282: aload 8
    //   284: invokevirtual 277	java/io/File:delete	()Z
    //   287: pop
    //   288: aload 7
    //   290: aload_1
    //   291: invokestatic 280	aqhq:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   294: ifne -50 -> 244
    //   297: aload 7
    //   299: aload_1
    //   300: invokestatic 219	aqhq:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   303: ifeq +17 -> 320
    //   306: new 221	java/io/File
    //   309: dup
    //   310: aload 7
    //   312: invokespecial 224	java/io/File:<init>	(Ljava/lang/String;)V
    //   315: invokevirtual 277	java/io/File:delete	()Z
    //   318: pop
    //   319: return
    //   320: new 221	java/io/File
    //   323: dup
    //   324: aload 7
    //   326: invokespecial 224	java/io/File:<init>	(Ljava/lang/String;)V
    //   329: invokevirtual 277	java/io/File:delete	()Z
    //   332: pop
    //   333: return
    //   334: new 221	java/io/File
    //   337: dup
    //   338: aload 7
    //   340: invokespecial 224	java/io/File:<init>	(Ljava/lang/String;)V
    //   343: invokevirtual 277	java/io/File:delete	()Z
    //   346: pop
    //   347: return
    //   348: astore 4
    //   350: aconst_null
    //   351: astore_2
    //   352: aload 6
    //   354: astore 5
    //   356: aload_2
    //   357: ifnull +7 -> 364
    //   360: aload_2
    //   361: invokevirtual 273	java/io/RandomAccessFile:close	()V
    //   364: aload 5
    //   366: ifnull +8 -> 374
    //   369: aload 5
    //   371: invokevirtual 274	java/io/FileInputStream:close	()V
    //   374: aload 8
    //   376: invokevirtual 277	java/io/File:delete	()Z
    //   379: pop
    //   380: aload 7
    //   382: aload_1
    //   383: invokestatic 280	aqhq:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   386: ifne +25 -> 411
    //   389: aload 7
    //   391: aload_1
    //   392: invokestatic 219	aqhq:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   395: ifeq +19 -> 414
    //   398: new 221	java/io/File
    //   401: dup
    //   402: aload 7
    //   404: invokespecial 224	java/io/File:<init>	(Ljava/lang/String;)V
    //   407: invokevirtual 277	java/io/File:delete	()Z
    //   410: pop
    //   411: aload 4
    //   413: athrow
    //   414: new 221	java/io/File
    //   417: dup
    //   418: aload 7
    //   420: invokespecial 224	java/io/File:<init>	(Ljava/lang/String;)V
    //   423: invokevirtual 277	java/io/File:delete	()Z
    //   426: pop
    //   427: goto -16 -> 411
    //   430: astore_2
    //   431: goto -159 -> 272
    //   434: astore_2
    //   435: goto -153 -> 282
    //   438: astore 4
    //   440: goto -241 -> 199
    //   443: astore_2
    //   444: goto -237 -> 207
    //   447: astore_2
    //   448: goto -84 -> 364
    //   451: astore_2
    //   452: goto -78 -> 374
    //   455: astore 4
    //   457: aload 6
    //   459: astore 5
    //   461: goto -105 -> 356
    //   464: astore 4
    //   466: goto -110 -> 356
    //   469: astore_2
    //   470: aconst_null
    //   471: astore_2
    //   472: goto -283 -> 189
    //   475: astore 4
    //   477: aconst_null
    //   478: astore 5
    //   480: aload_2
    //   481: astore 4
    //   483: aload 5
    //   485: astore_2
    //   486: goto -297 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	489	0	this	aojj
    //   0	489	1	paramString1	String
    //   0	489	2	paramString2	String
    //   165	10	3	i	int
    //   4	168	4	arrayOfByte	byte[]
    //   181	1	4	localIOException1	java.io.IOException
    //   184	11	4	str1	String
    //   348	64	4	localObject1	Object
    //   438	1	4	localIOException2	java.io.IOException
    //   455	1	4	localObject2	Object
    //   464	1	4	localObject3	Object
    //   475	1	4	localIOException3	java.io.IOException
    //   481	1	4	str2	String
    //   43	441	5	localObject4	Object
    //   1	457	6	localObject5	Object
    //   25	394	7	str3	String
    //   53	322	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   151	158	181	java/io/IOException
    //   158	166	181	java/io/IOException
    //   170	178	181	java/io/IOException
    //   245	264	181	java/io/IOException
    //   116	128	348	finally
    //   268	272	430	java/io/IOException
    //   277	282	434	java/io/IOException
    //   194	199	438	java/io/IOException
    //   203	207	443	java/io/IOException
    //   360	364	447	java/io/IOException
    //   369	374	451	java/io/IOException
    //   128	151	455	finally
    //   151	158	464	finally
    //   158	166	464	finally
    //   170	178	464	finally
    //   245	264	464	finally
    //   116	128	469	java/io/IOException
    //   128	151	475	java/io/IOException
  }
  
  void QS(boolean paramBoolean) {}
  
  void QT(boolean paramBoolean) {}
  
  int a(aool paramaool)
  {
    if (paramaool.dQG < 0) {}
    do
    {
      return 1;
      if (paramaool.dQG > 0)
      {
        if (paramaool.dQH > 0) {
          return 3;
        }
        return 4;
      }
    } while (paramaool.dQH <= 0);
    return 2;
  }
  
  protected ArrayList<aonh> a(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        aonh localaonh = new aonh();
        localaonh.mIp = str;
        localaonh.port = KI();
        localaonh.isIpv6 = paramBoolean;
        localArrayList.add(localaonh);
      }
    }
    return localArrayList;
  }
  
  public void a(aoll paramaoll, String paramString)
  {
    if (this.cLQ)
    {
      paramaoll.bZ = op(paramString);
      if (!paramString.equals(paramaoll.bZ))
      {
        paramaoll.u.put("Cookie", "mST=" + aqoj.C(this.mST));
        if (this.cLP)
        {
          PicCryptor localPicCryptor = new PicCryptor(this.fF);
          localPicCryptor.d = paramaoll;
          paramaoll.a = localPicCryptor;
          paramaoll.mTempPath = (paramaoll.atY + "." + MD5.toMD5(aonc.z(paramString, false)) + ".tmp");
        }
      }
    }
    for (;;)
    {
      if ((this.cLR) && (!this.cLP))
      {
        paramaoll.mTempPath = (paramaoll.atY + "." + MD5.toMD5(aonc.z(paramString, false)) + ".tmp");
        paramaoll.bZ = (paramString + "&rollback=1");
      }
      return;
      this.cLP = false;
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, long paramLong, HashMap<String, String> paramHashMap)
  {
    int i;
    String str;
    if (!paramBoolean)
    {
      i = this.errCode;
      if (this.errCode != -9527) {
        break label72;
      }
      str = (String)this.mM.get("param_reason");
      if (str == null) {
        break label72;
      }
    }
    for (;;)
    {
      paramHashMap.put("param_detail_code", str);
      anpc.a(BaseApplication.getContext()).collectPerformance(null, paramString, true, paramLong, this.apq, paramHashMap, null);
      return;
      label72:
      str = String.valueOf(i);
    }
  }
  
  public boolean a(subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf paramDownloadEncryptConf)
  {
    return false;
  }
  
  protected String aB(String paramString, int paramInt)
  {
    String str = "&rf=other";
    if (this.h.dpB == 0)
    {
      str = "&rf=aio";
      str = "cldver=3.4.4.3058" + str;
      paramInt = paramString.indexOf("?");
      if (paramInt <= 0) {
        break label219;
      }
      if (paramString.length() != paramInt + 1) {
        break label136;
      }
      paramString = paramString.substring(0, paramInt + 1) + str;
    }
    for (;;)
    {
      return paramString + "&msgTime=" + this.h.mMsgTime;
      if (this.h.dpB != 1) {
        break;
      }
      str = "&rf=naio";
      break;
      label136:
      paramInt = paramString.indexOf("#", paramInt);
      if (paramInt > -1)
      {
        paramString = paramString.substring(0, paramInt) + "&" + str + paramString.substring(paramInt);
      }
      else
      {
        paramString = paramString + "&" + str;
        continue;
        label219:
        paramString = paramString + "?" + str;
      }
    }
  }
  
  protected boolean azM()
  {
    if (this.h.mFileType == 65537) {
      return true;
    }
    if ((this.h.F instanceof MessageForPic))
    {
      long l1 = ((MessageForPic)this.h.F).size;
      long l2 = Runtime.getRuntime().totalMemory();
      l2 = Runtime.getRuntime().maxMemory() - (l2 - Runtime.getRuntime().freeMemory());
      if (l2 < l1)
      {
        QLog.e("BaseTransProcessor", 1, "checkMemoryForEncrypt : memory is not enough ! remainMemory = " + l2 + ", picSize = " + l1);
        return false;
      }
      if (l1 > 5242880L)
      {
        QLog.e("BaseTransProcessor", 1, "checkMemoryForEncrypt : pic too large, picSize = " + l1);
        return false;
      }
    }
    return true;
  }
  
  public void d(aomh paramaomh)
  {
    int i = 0;
    if (!this.jdField_a_of_type_Aomg.cMT) {
      f(paramaomh);
    }
    if (((this.cLQ) || (this.cLP)) && (!a(paramaomh)))
    {
      this.cLP = false;
      this.cLQ = false;
      this.cLR = true;
      if (this.jdField_a_of_type_Aomg != null) {
        this.clb = ("checkPicFormat Erro, erroCode:" + paramaomh.mErrCode + " ,erroDesc:" + paramaomh.clO + " ,encryptUrl:" + ((aoll)this.jdField_a_of_type_Aomg).bZ + " ,ST:" + aqoj.C(this.mST));
      }
      QS(true);
      return;
    }
    onSuccess();
    aomy localaomy = this.jdField_a_of_type_Aomy;
    long l = this.apr;
    if (this.jdField_a_of_type_Aool$c == null) {}
    for (;;)
    {
      localaomy.mFileSize = (l - i);
      a(paramaomh, true, "actRichMediaNetMonitor_picDown", this.h.cmo);
      return;
      i = this.jdField_a_of_type_Aool$c.dQO;
    }
  }
  
  public void dUS()
  {
    Object localObject = (TicketManager)this.app.getManager(2);
    this.fF = ((TicketManager)localObject).getStkey(this.app.getAccount(), 1600000226);
    this.mST = ((TicketManager)localObject).getSt(this.app.getAccount(), 1600000226);
    subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf localDownloadEncryptConf = aokl.a().a();
    if ((this.mST != null) && (this.fF != null) && (this.mST.length > 0) && (this.fF.length > 0) && (localDownloadEncryptConf != null))
    {
      this.cLQ = localDownloadEncryptConf.bool_enable_encrypt_request.get();
      this.cLP = localDownloadEncryptConf.bool_enable_encrypted_pic.get();
      if (this.fF != null) {
        break label172;
      }
    }
    label172:
    for (localObject = "key or switch can't get!";; localObject = "STKey:" + MD5.toMD5(this.fF))
    {
      hM("ticketInit", (String)localObject);
      if ((!a(localDownloadEncryptConf)) || (!isMainProcess))
      {
        this.cLP = false;
        this.cLQ = false;
      }
      return;
      this.cLP = false;
      this.cLQ = false;
      break;
    }
  }
  
  public void dUT()
  {
    Object localObject2 = this.h.F;
    Object localObject1;
    if (GifDrawable.isGifFile(new File(this.h.clR))) {
      if ((localObject2 != null) && ((localObject2 instanceof MessageForPic)))
      {
        localObject1 = (MessageForPic)localObject2;
        if (!((MessageForPic)localObject1).checkGif())
        {
          ((MessageForPic)localObject1).imageType = 2000;
          ((MessageForPic)localObject1).updateMessage();
        }
      }
    }
    label247:
    label250:
    for (;;)
    {
      return;
      if (aqgz.getDispalyDpi() >= 240)
      {
        if ((localObject2 instanceof MessageForMixedMsg))
        {
          localObject1 = ((MessageForMixedMsg)localObject2).getSubMessage(this.h.apI);
          if ((localObject1 == null) || (!(localObject1 instanceof MessageForPic))) {
            break label247;
          }
        }
        for (localObject1 = (MessageForPic)localObject1;; localObject1 = null)
        {
          if (localObject1 == null) {
            break label250;
          }
          if (((acfx.W((MessageRecord)localObject1)) || (acei.W((MessageRecord)localObject1))) && (!TextUtils.isEmpty(((MessageForPic)localObject1).md5)))
          {
            localObject2 = this.h.clR + "_fp";
            aqgy.bi(this.h.clR, (String)localObject2, ((MessageForPic)localObject1).md5);
            return;
            localObject1 = localObject2;
            if (!(localObject2 instanceof MessageForStructing)) {
              break;
            }
            Object localObject3 = (MessageForStructing)localObject2;
            localObject1 = localObject2;
            if (!(((MessageForStructing)localObject3).structingMsg instanceof StructMsgForImageShare)) {
              break;
            }
            localObject3 = ((StructMsgForImageShare)((MessageForStructing)localObject3).structingMsg).getFirstImageElement();
            localObject1 = localObject2;
            if (localObject3 == null) {
              break;
            }
            localObject1 = localObject2;
            if (((ansu)localObject3).j == null) {
              break;
            }
            localObject1 = ((ansu)localObject3).j;
            break;
          }
          x((MessageForPic)localObject1);
          return;
        }
      }
    }
  }
  
  public void dUU()
  {
    aoom localaoom = this.h.a;
    if (localaoom != null)
    {
      localaoom.mResult = 0;
      localaoom.i = this.h;
      try
      {
        if ((this.h.mFileType == 65537) && (this.h.clR != null)) {
          return;
        }
        if (((this.h.mFileType == 1) || (this.h.mFileType == 131075)) && (this.h.clR != null) && (this.h.F != null))
        {
          dUT();
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PIC_TAG", 2, localThrowable.getMessage());
        }
      }
    }
  }
  
  public void e(aomh paramaomh)
  {
    if ((paramaomh.mErrCode == 9364) && (this.dOY < 3))
    {
      hM("[netChg]", "failed.but net change detect.so retry");
      this.dOQ = 4;
      this.cla = paramaomh.clO;
      this.dOY += 1;
      dVd();
      QS(false);
      return;
    }
    Object localObject1;
    Object localObject2;
    boolean bool;
    if ((this.cLP) || (this.cLQ))
    {
      this.cLP = false;
      this.cLQ = false;
      this.cLR = true;
      if (paramaomh.mErrCode != -9527) {
        break label574;
      }
      localObject1 = (String)paramaomh.nR.get(aqog.cuy);
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (((String)localObject1).split("_").length < 3)) {
        break label679;
      }
      Object localObject3 = ((String)localObject1).split("_");
      localObject1 = localObject3[0];
      localObject2 = localObject3[1];
      localObject3 = localObject3[2];
      if ((!"H".equals(localObject1)) || (!"400".equals(localObject2)) || (!((String)localObject3).equals("-106")) || (!this.cLP)) {
        break label679;
      }
      bool = true;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aomg != null)
      {
        if ("encryptReqError=" + bool + ", ResErroCode:" + paramaomh.mErrCode + " ,erroDesc:" + paramaomh.clO + " ,encryptUrl:" + ((aoll)this.jdField_a_of_type_Aomg).bZ == null)
        {
          localObject1 = "null";
          label279:
          this.clb = ((String)localObject1);
        }
      }
      else
      {
        if (!this.cLM) {
          break label660;
        }
        this.dOQ = 3;
        this.cla = paramaomh.clO;
        if (!(this instanceof aoku)) {
          break label632;
        }
        aokl.a().a().clear(2);
        label321:
        if (!this.cLR) {
          break label652;
        }
        QS(true);
        label333:
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("param_FailCode", String.valueOf(paramaomh.mErrCode));
        ((HashMap)localObject1).put("param_errorDesc", paramaomh.clO);
        if (this.jdField_a_of_type_Aomg != null) {
          ((HashMap)localObject1).put("param_url", ((aoll)this.jdField_a_of_type_Aomg).bZ);
        }
        anpc.a(BaseApplication.getContext()).collectPerformance(this.h.mSelfUin, "report_direct_download_fail", false, (System.nanoTime() - this.mStartTime) / 1000000L, this.apq, (HashMap)localObject1, "");
      }
      for (;;)
      {
        localObject1 = new StringBuffer();
        ((StringBuffer)localObject1).append(this.h.mUinType);
        ((StringBuffer)localObject1).append(" isMsgDown:");
        ((StringBuffer)localObject1).append(this.cLM);
        ((StringBuffer)localObject1).append(" result:");
        ((StringBuffer)localObject1).append(paramaomh.mResult);
        ((StringBuffer)localObject1).append(" adr:");
        if (this.xp == null) {
          break label667;
        }
        paramaomh = this.xp.iterator();
        while (paramaomh.hasNext())
        {
          localObject2 = (aonh)paramaomh.next();
          try
          {
            ((StringBuffer)localObject1).append(aqmr.toHexString(((aonh)localObject2).mIp) + ",");
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
        label574:
        if (paramaomh.mErrCode != 9058) {
          break label679;
        }
        bool = true;
        break;
        localObject1 = ((aoll)this.jdField_a_of_type_Aomg).bZ + " ,ST:" + aqoj.C(this.mST);
        break label279;
        label632:
        if (!(this instanceof aoju)) {
          break label321;
        }
        aokl.a().a().clear(1);
        break label321;
        label652:
        QS(false);
        break label333;
        label660:
        onError();
      }
      label667:
      QLog.d("BaseTransProcessor", 1, ((StringBuffer)localObject1).toString());
      return;
      label679:
      bool = false;
    }
  }
  
  public void g(aomh paramaomh)
  {
    aomy localaomy = this.jdField_a_of_type_Aomy;
    long l = this.apr;
    if (this.jdField_a_of_type_Aool$c == null) {}
    for (int i = 0;; i = this.jdField_a_of_type_Aool$c.dQO)
    {
      localaomy.mFileSize = (l - i);
      a(paramaomh, false, "actRichMediaNetMonitor_picDown", this.h.cmo);
      return;
    }
  }
  
  void ge(String paramString, int paramInt)
  {
    this.ckX = this.jdField_a_of_type_Aool$c.cms;
    if ((this.ckX == null) || (this.ckX.length() == 0))
    {
      this.dOQ = 1;
      QS(false);
      return;
    }
    if (!QLog.isColorLevel()) {}
    for (;;)
    {
      this.xp = i(a(aopd.a().a(paramString, paramInt, true, 28, false), true), a(aopd.a().a(paramString, paramInt, true, 1, false), false));
      if ((this.xp == null) || (this.xp.size() <= 0)) {
        break;
      }
      this.cLO = true;
      this.cLM = true;
      this.d.dVf();
      QT(false);
      return;
      if (this.ckX.contains("com.tencent.mobileqq"))
      {
        anow.report("Download_Pic_URL_Invalid", this.ckX);
        QLog.d("BaseTransProcessor", 1, "directMsgUrlDown Download_Pic_URL_Invalid:" + this.ckX);
      }
    }
    this.dOQ = 2;
    QS(false);
  }
  
  void onError()
  {
    super.onError();
    Object localObject1 = this.h.a;
    if (localObject1 != null)
    {
      ((aoom)localObject1).mResult = -1;
      ((aoom)localObject1).aqr = this.errCode;
      ((aoom)localObject1).clO = this.errDesc;
      ((aoom)localObject1).i = this.h;
    }
    Object localObject4;
    try
    {
      if (this.jdField_b_of_type_Aoko != null) {
        this.jdField_b_of_type_Aoko.status = 2005;
      }
      localObject1 = this.Bl.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = (akxb)((Iterator)localObject1).next();
        akxb.a locala = new akxb.a();
        locala.result = -1;
        locala.errCode = this.errCode;
        locala.errStr = this.errDesc;
        ((akxb)localObject4).a(locala);
        if (QLog.isColorLevel()) {
          QLog.d("PIC_TAG", 2, "onError ");
        }
      }
      if (this.jdField_b_of_type_Aoko == null) {
        break label174;
      }
    }
    finally {}
    hM("notify", "start");
    label174:
    notifyAll();
    if (this.jdField_b_of_type_Aoko != null) {
      hM("notify", "end");
    }
    int i;
    if ((this.errCode == 9014) || (this.errCode == 9050))
    {
      Object localObject3 = aonc.a(((aoll)this.jdField_a_of_type_Aomg).bZ);
      if (localObject3 != null)
      {
        localObject3 = ((aonh)localObject3).mIp;
        localObject4 = new ProbeChain();
        if (this.errCode != 9014) {
          break label381;
        }
        ((ProbeChain)localObject4).addProbeItem(new PingProbe());
        ((ProbeChain)localObject4).addProbeItem(new MtuProbe());
        ((ProbeChain)localObject4).addProbeItem(new TracerouteProbe());
        if (this.errCode != 9014) {
          break label408;
        }
        i = -1201;
        label308:
        localObject3 = new ProbeRequest((String)localObject3, i, (ProbeItem)localObject4);
        if (this.mWeakNetLearner != null) {
          this.mWeakNetLearner.startProbe(new ProbeTask((ProbeRequest)localObject3));
        }
      }
    }
    VR(2005);
    if (this.h != null)
    {
      if (!ajdg.aH(this.h.F)) {
        break label415;
      }
      ajdg.fb(String.valueOf(this.errCode), 3);
    }
    label381:
    while (!ajdg.aG(this.h.F))
    {
      return;
      ((ProbeChain)localObject4).addProbeItem(new PingProbe());
      ((ProbeChain)localObject4).addProbeItem(new TracerouteProbe());
      break;
      i = -1202;
      break label308;
    }
    label408:
    label415:
    ajdg.fb(String.valueOf(this.errCode), 2);
  }
  
  public void onResp(aomh paramaomh)
  {
    boolean bool2 = true;
    super.onResp(paramaomh);
    Object localObject = new StringBuilder().append("directMsgUrlDown:").append(this.cLM).append(" isEncrypt:");
    boolean bool1;
    if ((this.cLP) || (this.cLQ))
    {
      bool1 = true;
      localObject = ((StringBuilder)localObject).append(bool1).append(" isRollBack:").append(this.cLR).append(" result:");
      if (paramaomh.mResult != 0) {
        break label290;
      }
      bool1 = true;
      label87:
      hM("onHttpResp", bool1);
      if ((QLog.isColorLevel()) && (this.jdField_a_of_type_Aomg != null)) {
        QLog.d("big_thumb", 2, "onResp" + this.h.mFileType + "mUiRequest.mOutFilePath=" + this.h.clR + "url=" + ((aoll)this.jdField_a_of_type_Aomg).bZ);
      }
      if (!this.cLM) {
        break label295;
      }
      localObject = this.d;
      label197:
      if (paramaomh.mResult != 0) {
        break label304;
      }
      bool1 = bool2;
      label206:
      a((aojn.a)localObject, paramaomh, bool1);
      this.apq = paramaomh.apU;
      if (this.apq <= 0L) {
        this.apq = (paramaomh.apV + paramaomh.b.apS);
      }
      this.apr += paramaomh.apW;
      if ((paramaomh.mResult != 0) || (this.jdField_a_of_type_Aomg == null)) {
        break label309;
      }
      d(paramaomh);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aomg = null;
      return;
      bool1 = false;
      break;
      label290:
      bool1 = false;
      break label87;
      label295:
      localObject = this.jdField_b_of_type_Aojn$a;
      break label197;
      label304:
      bool1 = false;
      break label206;
      label309:
      e(paramaomh);
    }
  }
  
  void onSuccess()
  {
    super.onSuccess();
    if (QLog.isColorLevel()) {
      QLog.d("big_thumb", 2, "onsuccess mUiRequest.mFileType" + this.h.mFileType + "mUiRequest.mOutFilePath=" + this.h.clR + "url=" + ((aoll)this.jdField_a_of_type_Aomg).bZ);
    }
    dUU();
    for (;;)
    {
      Object localObject3;
      akxb.a locala;
      boolean bool;
      try
      {
        if (this.jdField_b_of_type_Aoko != null) {
          this.jdField_b_of_type_Aoko.status = 2003;
        }
        Object localObject1 = this.h;
        if (((aool)localObject1).cmq != null)
        {
          localObject3 = new File(((aool)localObject1).cmq);
          if ((((File)localObject3).exists()) && (((File)localObject3).delete()) && (QLog.isDevelopLevel())) {
            QLog.d("peak_pgjpeg", 4, "BasePicDownloadProcessor.onSuccess():Delete " + ((aool)localObject1).cmq);
          }
        }
        int i = a(this.h);
        localObject1 = this.Bl.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label399;
        }
        localObject3 = (akxb)((Iterator)localObject1).next();
        locala = new akxb.a();
        locala.result = 0;
        locala.bUF = this.h.clR;
        locala.md5 = this.h.mMd5;
        locala.dpA = this.h.mFileType;
        locala.dpB = this.h.dpB;
        if (i == 2) {
          break label495;
        }
        if (i != 3) {
          break label394;
        }
      }
      finally {}
      locala.bjc = bool;
      ((akxb)localObject3).a(locala);
      if ((this.h.mFileType == 131075) && (QLog.isDevelopLevel())) {
        QLog.d("peak_pgjpeg", 4, "BasePicDownloadProcessor.onSuccess():" + this.h.clR + ", isPart " + locala.bjc);
      }
      if (QLog.isColorLevel())
      {
        QLog.d("PIC_TAG", 2, "onSuccess ");
        continue;
        label394:
        bool = false;
        continue;
        label399:
        if (this.jdField_b_of_type_Aoko != null) {
          hM("notify", "start");
        }
        notifyAll();
        if (this.jdField_b_of_type_Aoko != null) {
          hM("notify", "end");
        }
        VR(2003);
        if (this.h != null)
        {
          if (!ajdg.aH(this.h.F)) {
            break label474;
          }
          ajdg.fb("0", 3);
        }
        label474:
        while (!ajdg.aG(this.h.F)) {
          return;
        }
        ajdg.fb("0", 2);
        return;
        label495:
        bool = true;
      }
    }
  }
  
  /* Error */
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: ldc2_w 1058
    //   3: lload_2
    //   4: lmul
    //   5: lload 4
    //   7: ldiv
    //   8: l2i
    //   9: istore 6
    //   11: iload 6
    //   13: aload_0
    //   14: getfield 1062	aojj:dOP	I
    //   17: if_icmple +33 -> 50
    //   20: aload_0
    //   21: iload 6
    //   23: putfield 1062	aojj:dOP	I
    //   26: aload_0
    //   27: getfield 554	aojj:jdField_a_of_type_Aool$c	Laool$c;
    //   30: getfield 1065	aool$c:a	Lcom/tencent/image/URLDrawableHandler;
    //   33: ifnull +17 -> 50
    //   36: aload_0
    //   37: getfield 554	aojj:jdField_a_of_type_Aool$c	Laool$c;
    //   40: getfield 1065	aool$c:a	Lcom/tencent/image/URLDrawableHandler;
    //   43: iload 6
    //   45: invokeinterface 1070 2 0
    //   50: aload_0
    //   51: monitorenter
    //   52: aload_0
    //   53: getfield 899	aojj:jdField_b_of_type_Aoko	Laoko;
    //   56: ifnull +13 -> 69
    //   59: aload_0
    //   60: getfield 899	aojj:jdField_b_of_type_Aoko	Laoko;
    //   63: sipush 2002
    //   66: putfield 904	aoko:status	I
    //   69: iconst_0
    //   70: istore 10
    //   72: iconst_0
    //   73: istore 11
    //   75: iconst_0
    //   76: istore 9
    //   78: aload_0
    //   79: getfield 136	aojj:h	Laool;
    //   82: astore 13
    //   84: aload 13
    //   86: getfield 1073	aool:dQI	I
    //   89: istore 7
    //   91: iload 9
    //   93: istore 8
    //   95: aload 13
    //   97: getfield 175	aool:dQG	I
    //   100: ifne +248 -> 348
    //   103: iload 9
    //   105: istore 8
    //   107: iload 7
    //   109: ifle +239 -> 348
    //   112: iload 9
    //   114: istore 8
    //   116: aload 13
    //   118: getfield 1031	aool:cmq	Ljava/lang/String;
    //   121: ifnull +227 -> 348
    //   124: new 221	java/io/File
    //   127: dup
    //   128: aload 13
    //   130: getfield 1031	aool:cmq	Ljava/lang/String;
    //   133: invokespecial 224	java/io/File:<init>	(Ljava/lang/String;)V
    //   136: astore 14
    //   138: new 221	java/io/File
    //   141: dup
    //   142: aload_1
    //   143: getfield 126	aomg:mTempPath	Ljava/lang/String;
    //   146: invokespecial 224	java/io/File:<init>	(Ljava/lang/String;)V
    //   149: astore 16
    //   151: aload 16
    //   153: invokevirtual 234	java/io/File:length	()J
    //   156: lstore_2
    //   157: iload 9
    //   159: istore 8
    //   161: aload 14
    //   163: invokevirtual 246	java/io/File:exists	()Z
    //   166: ifne +182 -> 348
    //   169: iload 9
    //   171: istore 8
    //   173: lload_2
    //   174: lconst_0
    //   175: lcmp
    //   176: ifle +172 -> 348
    //   179: iload 9
    //   181: istore 8
    //   183: iload 7
    //   185: i2l
    //   186: lload_2
    //   187: lcmp
    //   188: ifge +160 -> 348
    //   191: new 221	java/io/File
    //   194: dup
    //   195: new 165	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   202: aload 13
    //   204: getfield 1031	aool:cmq	Ljava/lang/String;
    //   207: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: ldc_w 1075
    //   213: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokespecial 224	java/io/File:<init>	(Ljava/lang/String;)V
    //   222: astore 15
    //   224: aconst_null
    //   225: astore 12
    //   227: aconst_null
    //   228: astore_1
    //   229: aload 16
    //   231: aload 15
    //   233: iconst_0
    //   234: iload 7
    //   236: invokestatic 1078	aqhq:a	(Ljava/io/File;Ljava/io/File;II)J
    //   239: lstore_2
    //   240: lload_2
    //   241: iload 7
    //   243: i2l
    //   244: lcmp
    //   245: ifeq +146 -> 391
    //   248: aload 15
    //   250: invokevirtual 246	java/io/File:exists	()Z
    //   253: ifeq +138 -> 391
    //   256: aload 15
    //   258: invokevirtual 277	java/io/File:delete	()Z
    //   261: pop
    //   262: iload 9
    //   264: istore 8
    //   266: aload_1
    //   267: ifnull +81 -> 348
    //   270: iload 10
    //   272: istore 9
    //   274: aload_1
    //   275: invokevirtual 273	java/io/RandomAccessFile:close	()V
    //   278: iload 10
    //   280: istore 9
    //   282: aload 15
    //   284: aload 14
    //   286: invokestatic 1082	aqhq:renameFile	(Ljava/io/File;Ljava/io/File;)Z
    //   289: pop
    //   290: iconst_1
    //   291: istore 11
    //   293: iconst_1
    //   294: istore 10
    //   296: iload 10
    //   298: istore 8
    //   300: iload 11
    //   302: istore 9
    //   304: invokestatic 227	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   307: ifeq +41 -> 348
    //   310: iload 11
    //   312: istore 9
    //   314: ldc 229
    //   316: iconst_4
    //   317: new 165	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   324: ldc_w 1084
    //   327: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload 13
    //   332: getfield 1031	aool:cmq	Ljava/lang/String;
    //   335: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokestatic 243	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   344: iload 10
    //   346: istore 8
    //   348: aload_0
    //   349: getfield 907	aojj:Bl	Ljava/util/ArrayList;
    //   352: invokevirtual 302	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   355: astore_1
    //   356: aload_1
    //   357: invokeinterface 307 1 0
    //   362: ifeq +252 -> 614
    //   365: aload_1
    //   366: invokeinterface 311 1 0
    //   371: checkcast 909	akxb
    //   374: iload 6
    //   376: iload 8
    //   378: invokeinterface 1088 3 0
    //   383: goto -27 -> 356
    //   386: astore_1
    //   387: aload_0
    //   388: monitorexit
    //   389: aload_1
    //   390: athrow
    //   391: new 248	java/io/RandomAccessFile
    //   394: dup
    //   395: aload 15
    //   397: ldc 250
    //   399: invokespecial 253	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   402: astore_1
    //   403: aload_1
    //   404: lload_2
    //   405: invokevirtual 257	java/io/RandomAccessFile:seek	(J)V
    //   408: aload_1
    //   409: iconst_2
    //   410: newarray byte
    //   412: dup
    //   413: iconst_0
    //   414: ldc_w 287
    //   417: bastore
    //   418: dup
    //   419: iconst_1
    //   420: ldc_w 288
    //   423: bastore
    //   424: invokevirtual 291	java/io/RandomAccessFile:write	([B)V
    //   427: goto -165 -> 262
    //   430: astore_1
    //   431: aload_1
    //   432: invokevirtual 281	java/io/IOException:printStackTrace	()V
    //   435: iload 9
    //   437: istore 8
    //   439: goto -91 -> 348
    //   442: astore_1
    //   443: aload 12
    //   445: astore_1
    //   446: iload 9
    //   448: istore 8
    //   450: aload_1
    //   451: ifnull -103 -> 348
    //   454: iload 11
    //   456: istore 9
    //   458: aload_1
    //   459: invokevirtual 273	java/io/RandomAccessFile:close	()V
    //   462: iload 11
    //   464: istore 9
    //   466: aload 15
    //   468: aload 14
    //   470: invokestatic 1082	aqhq:renameFile	(Ljava/io/File;Ljava/io/File;)Z
    //   473: pop
    //   474: iconst_1
    //   475: istore 11
    //   477: iconst_1
    //   478: istore 10
    //   480: iload 10
    //   482: istore 8
    //   484: iload 11
    //   486: istore 9
    //   488: invokestatic 227	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   491: ifeq -143 -> 348
    //   494: iload 11
    //   496: istore 9
    //   498: ldc 229
    //   500: iconst_4
    //   501: new 165	java/lang/StringBuilder
    //   504: dup
    //   505: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   508: ldc_w 1084
    //   511: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: aload 13
    //   516: getfield 1031	aool:cmq	Ljava/lang/String;
    //   519: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   525: invokestatic 243	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   528: iload 10
    //   530: istore 8
    //   532: goto -184 -> 348
    //   535: astore_1
    //   536: aload_1
    //   537: invokevirtual 281	java/io/IOException:printStackTrace	()V
    //   540: iload 9
    //   542: istore 8
    //   544: goto -196 -> 348
    //   547: astore 12
    //   549: aconst_null
    //   550: astore_1
    //   551: aload_1
    //   552: ifnull +51 -> 603
    //   555: aload_1
    //   556: invokevirtual 273	java/io/RandomAccessFile:close	()V
    //   559: aload 15
    //   561: aload 14
    //   563: invokestatic 1082	aqhq:renameFile	(Ljava/io/File;Ljava/io/File;)Z
    //   566: pop
    //   567: invokestatic 227	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   570: ifeq +33 -> 603
    //   573: ldc 229
    //   575: iconst_4
    //   576: new 165	java/lang/StringBuilder
    //   579: dup
    //   580: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   583: ldc_w 1084
    //   586: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: aload 13
    //   591: getfield 1031	aool:cmq	Ljava/lang/String;
    //   594: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   600: invokestatic 243	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   603: aload 12
    //   605: athrow
    //   606: astore_1
    //   607: aload_1
    //   608: invokevirtual 281	java/io/IOException:printStackTrace	()V
    //   611: goto -8 -> 603
    //   614: aload_0
    //   615: monitorexit
    //   616: return
    //   617: astore 12
    //   619: goto -68 -> 551
    //   622: astore 12
    //   624: goto -178 -> 446
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	627	0	this	aojj
    //   0	627	1	paramaomg	aomg
    //   0	627	2	paramLong1	long
    //   0	627	4	paramLong2	long
    //   9	366	6	i	int
    //   89	153	7	j	int
    //   93	450	8	bool1	boolean
    //   76	465	9	bool2	boolean
    //   70	459	10	bool3	boolean
    //   73	422	11	bool4	boolean
    //   225	219	12	localObject1	Object
    //   547	57	12	localObject2	Object
    //   617	1	12	localObject3	Object
    //   622	1	12	localIOException	java.io.IOException
    //   82	508	13	localaool	aool
    //   136	426	14	localFile1	File
    //   222	338	15	localFile2	File
    //   149	81	16	localFile3	File
    // Exception table:
    //   from	to	target	type
    //   52	69	386	finally
    //   78	91	386	finally
    //   95	103	386	finally
    //   116	157	386	finally
    //   161	169	386	finally
    //   191	224	386	finally
    //   274	278	386	finally
    //   282	290	386	finally
    //   304	310	386	finally
    //   314	344	386	finally
    //   348	356	386	finally
    //   356	383	386	finally
    //   387	389	386	finally
    //   431	435	386	finally
    //   458	462	386	finally
    //   466	474	386	finally
    //   488	494	386	finally
    //   498	528	386	finally
    //   536	540	386	finally
    //   555	603	386	finally
    //   603	606	386	finally
    //   607	611	386	finally
    //   614	616	386	finally
    //   274	278	430	java/io/IOException
    //   282	290	430	java/io/IOException
    //   304	310	430	java/io/IOException
    //   314	344	430	java/io/IOException
    //   229	240	442	java/io/IOException
    //   248	262	442	java/io/IOException
    //   391	403	442	java/io/IOException
    //   458	462	535	java/io/IOException
    //   466	474	535	java/io/IOException
    //   488	494	535	java/io/IOException
    //   498	528	535	java/io/IOException
    //   229	240	547	finally
    //   248	262	547	finally
    //   391	403	547	finally
    //   555	603	606	java/io/IOException
    //   403	427	617	finally
    //   403	427	622	java/io/IOException
  }
  
  public String op(String paramString)
  {
    String str2 = oq(paramString);
    Cryptor localCryptor = new Cryptor();
    if (str2 != null)
    {
      String str1 = str2 + "&encrypt=";
      if (this.cLP) {}
      for (str1 = str1 + "1";; str1 = str1 + "0") {
        return paramString.replace(str2, aqoj.C(localCryptor.encrypt(str1.getBytes(), this.fF)));
      }
    }
    this.cLP = false;
    return paramString;
  }
  
  public String oq(String paramString)
  {
    paramString = aj.matcher(paramString);
    if (paramString.find()) {
      return paramString.group(1);
    }
    return null;
  }
  
  public void x(MessageForPic paramMessageForPic)
  {
    CompressInfo localCompressInfo;
    URL localURL;
    Object localObject;
    if (paramMessageForPic.fileSizeFlag == 1)
    {
      bool = true;
      if (this.h.mFileType == aoop.n("chatimg", bool))
      {
        localCompressInfo = new CompressInfo(this.h.clR, 0);
        localURL = aoop.a(paramMessageForPic, 65537);
        localCompressInfo.cuR = true;
        localObject = aoiz.getFilePath(localURL.toString());
        if (!((String)localObject).endsWith("_hd"))
        {
          if (!((String)localObject).endsWith("_big400")) {
            break label228;
          }
          ((String)localObject).replace("_big400", "_hd");
          label99:
          localCompressInfo.destPath = ((String)localObject);
          localCompressInfo.a = paramMessageForPic.thumbWidthHeightDP;
          akyj.c(localCompressInfo);
          if (localCompressInfo.destPath != null)
          {
            localObject = new File((String)localObject);
            if (!localCompressInfo.destPath.equals(localCompressInfo.srcPath)) {
              break label257;
            }
          }
        }
      }
    }
    label257:
    for (boolean bool = dx.copyFile(new File(localCompressInfo.srcPath), (File)localObject);; bool = true)
    {
      if ((bool) && (BaseApplicationImpl.sImageCache.get(localURL.toString()) != null))
      {
        BaseApplicationImpl.sImageCache.remove(localURL.toString());
        localObject = URLDrawable.getDrawable(localURL);
        if (localObject != null)
        {
          if (paramMessageForPic.thumbWidthHeightDP != null) {
            break label252;
          }
          ((URLDrawable)localObject).downloadImediatly(true);
        }
      }
      return;
      bool = false;
      break;
      label228:
      localObject = (String)localObject + "_hd";
      break label99;
      label252:
      ((URLDrawable)localObject).invalidateSelf();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aojj
 * JD-Core Version:    0.7.0.1
 */