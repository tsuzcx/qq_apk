import android.content.Intent;
import com.tencent.device.file.DevShortVideoOperator.1;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public class szb
  extends BaseShortVideoOprerator
{
  public String aIf;
  public String bN;
  public int gP;
  public long mDuration;
  public int mThumbWidth;
  public String mUin;
  public int mUinType;
  public String mVideoMd5;
  public String mVideoPath;
  public long mVideoSize;
  
  public szb() {}
  
  public szb(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void b(angt paramangt)
  {
    ThreadManager.getSubThreadHandler().post(new DevShortVideoOperator.1(this, paramangt));
  }
  
  public anfw a(Object paramObject, angi paramangi)
  {
    return null;
  }
  
  public angt a(Object paramObject, angi paramangi)
  {
    if (paramObject == null)
    {
      akxe.M(this.logTag, this.bUB, "createShortVideoUploadInfo", "unknow obj");
      return null;
    }
    Object localObject;
    if ((paramObject instanceof Intent))
    {
      localObject = (Intent)paramObject;
      this.mUin = ((Intent)localObject).getStringExtra("uin");
      this.mUinType = ((Intent)localObject).getIntExtra("uintype", 1003);
      this.mVideoPath = ((Intent)localObject).getStringExtra("file_send_path");
    }
    for (;;)
    {
      uH();
      localObject = new angt();
      ((angt)localObject).peerUin = this.mUin;
      ((angt)localObject).localPath = this.mVideoPath;
      ((angt)localObject).thumbPath = this.bN;
      ((angt)localObject).uinType = this.mUinType;
      ((angt)localObject).bUG = "";
      ((angt)localObject).ceG = ((int)this.mVideoSize);
      ((angt)localObject).dFo = ((int)this.mDuration / 1000);
      ((angt)localObject).md5 = this.mVideoMd5;
      ((angt)localObject).thumbWidth = this.mThumbWidth;
      ((angt)localObject).thumbHeight = this.gP;
      ((angt)localObject).dFp = paramangi.dFq;
      ((angt)localObject).message = paramObject;
      ((angt)localObject).thumbMD5 = this.aIf;
      ((angt)localObject).fileSource = "";
      akxe.M(this.logTag, this.bUB, "createShortVideoUploadInfo", "");
      return localObject;
      if ((paramObject instanceof MessageForShortVideo))
      {
        localObject = (MessageForShortVideo)paramObject;
        this.mUin = ((MessageForShortVideo)localObject).frienduin;
        this.mUinType = ((MessageForShortVideo)localObject).istroop;
        this.mVideoSize = ((MessageForShortVideo)localObject).videoFileSize;
        this.mDuration = (((MessageForShortVideo)localObject).videoFileTime * 1000);
        this.mVideoPath = ((MessageForShortVideo)localObject).videoFileName;
        this.bN = ShortVideoUtils.bw(((MessageForShortVideo)localObject).thumbMD5, "jpg");
        this.mVideoMd5 = ((MessageForShortVideo)localObject).md5;
        this.mThumbWidth = ((MessageForShortVideo)localObject).thumbWidth;
        this.gP = ((MessageForShortVideo)localObject).thumbHeight;
        this.aIf = ((MessageForShortVideo)localObject).thumbMD5;
      }
    }
  }
  
  public MessageRecord a(anfw paramanfw)
  {
    return null;
  }
  
  public MessageRecord a(angt paramangt)
  {
    int i = 0;
    long l = System.currentTimeMillis();
    MessageForDevShortVideo localMessageForDevShortVideo = (MessageForDevShortVideo)anbi.d(this.mApp, paramangt.peerUin, paramangt.bUG, paramangt.uinType);
    localMessageForDevShortVideo.videoFileName = paramangt.localPath;
    if (paramangt.uuid == null) {
      paramangt.uuid = "";
    }
    localMessageForDevShortVideo.uuid = paramangt.uuid;
    if (paramangt.md5 == null) {
      paramangt.md5 = "";
    }
    localMessageForDevShortVideo.md5 = paramangt.md5;
    localMessageForDevShortVideo.videoFileFormat = 2;
    localMessageForDevShortVideo.videoFileSize = paramangt.ceG;
    localMessageForDevShortVideo.videoFileTime = paramangt.dFo;
    localMessageForDevShortVideo.thumbWidth = paramangt.thumbWidth;
    localMessageForDevShortVideo.thumbHeight = paramangt.thumbHeight;
    localMessageForDevShortVideo.videoFileStatus = 1002;
    localMessageForDevShortVideo.videoFileProgress = 0;
    localMessageForDevShortVideo.fileType = 19;
    localMessageForDevShortVideo.thumbMD5 = paramangt.thumbMD5;
    localMessageForDevShortVideo.extraflag = 32772;
    if (paramangt.fileSource == null) {
      paramangt.fileSource = "";
    }
    localMessageForDevShortVideo.fileSource = paramangt.fileSource;
    localMessageForDevShortVideo.lastModified = 0L;
    if (paramangt.a != null) {
      i = 1;
    }
    if (i != 0)
    {
      localMessageForDevShortVideo.msgseq = paramangt.a.msgseq;
      localMessageForDevShortVideo.shmsgseq = paramangt.a.shmsgseq;
      localMessageForDevShortVideo.msgUid = paramangt.a.msgUid;
    }
    localMessageForDevShortVideo.msg = localMessageForDevShortVideo.getSummary();
    localMessageForDevShortVideo.serial();
    paramangt.uniseq = localMessageForDevShortVideo.uniseq;
    akxe.M(this.logTag, this.bUB, "packmsg", "cost:" + (System.currentTimeMillis() - l));
    akxe.M(this.logTag, this.bUB, "packMsg", "mr: " + localMessageForDevShortVideo.toLogString() + "-" + localMessageForDevShortVideo.toString());
    return localMessageForDevShortVideo;
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    akxe.M(this.logTag, this.bUB, "attachRichText2Msg", "");
    if ((this.F instanceof MessageForRichText)) {
      ((MessageForRichText)this.F).richText = paramRichText;
    }
    return this.F;
  }
  
  public void a(akyf.a parama)
  {
    akxe.M(this.logTag, this.bUB, "updateMsg", "resut:" + parama);
    if (parama != null)
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)this.F;
      localMessageForShortVideo.videoFileSize = ((int)parama.size);
      localMessageForShortVideo.uuid = parama.uuid;
      localMessageForShortVideo.md5 = parama.md5;
      localMessageForShortVideo.serial();
      this.mApp.b().c(this.F.frienduin, this.F.istroop, this.F.uniseq, localMessageForShortVideo.msgData);
    }
  }
  
  public void a(angt paramangt)
  {
    akxe.M(this.logTag, this.bUB, "sendPic.start", "");
    b(paramangt);
  }
  
  /* Error */
  public int uH()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 5
    //   12: aconst_null
    //   13: aload_0
    //   14: getfield 85	szb:mVideoPath	Ljava/lang/String;
    //   17: invokestatic 358	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getVideoThumbnail	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   20: astore_2
    //   21: aload_2
    //   22: ifnonnull +57 -> 79
    //   25: invokestatic 364	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   28: ifeq +13 -> 41
    //   31: ldc_w 366
    //   34: iconst_2
    //   35: ldc_w 368
    //   38: invokestatic 372	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: iconst_0
    //   42: ifeq +11 -> 53
    //   45: new 374	java/lang/NullPointerException
    //   48: dup
    //   49: invokespecial 375	java/lang/NullPointerException:<init>	()V
    //   52: athrow
    //   53: iconst_0
    //   54: ifeq +11 -> 65
    //   57: new 374	java/lang/NullPointerException
    //   60: dup
    //   61: invokespecial 375	java/lang/NullPointerException:<init>	()V
    //   64: athrow
    //   65: iconst_0
    //   66: ifeq +11 -> 77
    //   69: new 374	java/lang/NullPointerException
    //   72: dup
    //   73: invokespecial 375	java/lang/NullPointerException:<init>	()V
    //   76: athrow
    //   77: iconst_m1
    //   78: ireturn
    //   79: aload_2
    //   80: invokestatic 379	com/tencent/mobileqq/shortvideo/ShortVideoUtils:h	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   83: astore 8
    //   85: aload 8
    //   87: ifnonnull +58 -> 145
    //   90: invokestatic 364	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   93: ifeq +13 -> 106
    //   96: ldc_w 366
    //   99: iconst_2
    //   100: ldc_w 381
    //   103: invokestatic 372	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   106: iconst_0
    //   107: ifeq +11 -> 118
    //   110: new 374	java/lang/NullPointerException
    //   113: dup
    //   114: invokespecial 375	java/lang/NullPointerException:<init>	()V
    //   117: athrow
    //   118: iconst_0
    //   119: ifeq +11 -> 130
    //   122: new 374	java/lang/NullPointerException
    //   125: dup
    //   126: invokespecial 375	java/lang/NullPointerException:<init>	()V
    //   129: athrow
    //   130: iconst_0
    //   131: ifeq -54 -> 77
    //   134: new 374	java/lang/NullPointerException
    //   137: dup
    //   138: invokespecial 375	java/lang/NullPointerException:<init>	()V
    //   141: athrow
    //   142: astore_2
    //   143: iconst_m1
    //   144: ireturn
    //   145: aload_0
    //   146: aload 8
    //   148: invokevirtual 386	android/graphics/Bitmap:getWidth	()I
    //   151: putfield 128	szb:mThumbWidth	I
    //   154: aload_0
    //   155: aload 8
    //   157: invokevirtual 389	android/graphics/Bitmap:getHeight	()I
    //   160: putfield 133	szb:gP	I
    //   163: new 391	java/io/File
    //   166: dup
    //   167: aload_0
    //   168: getfield 85	szb:mVideoPath	Ljava/lang/String;
    //   171: invokespecial 394	java/io/File:<init>	(Ljava/lang/String;)V
    //   174: astore_2
    //   175: aload_0
    //   176: aload_2
    //   177: invokevirtual 397	java/io/File:length	()J
    //   180: putfield 113	szb:mVideoSize	J
    //   183: new 399	java/io/FileInputStream
    //   186: dup
    //   187: aload_2
    //   188: invokespecial 402	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   191: astore_3
    //   192: aload_0
    //   193: aload_3
    //   194: aload_0
    //   195: getfield 113	szb:mVideoSize	J
    //   198: invokestatic 408	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   201: invokestatic 414	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   204: putfield 123	szb:mVideoMd5	Ljava/lang/String;
    //   207: aload_0
    //   208: getfield 123	szb:mVideoMd5	Ljava/lang/String;
    //   211: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   214: ifeq +74 -> 288
    //   217: invokestatic 364	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   220: ifeq +33 -> 253
    //   223: ldc_w 366
    //   226: iconst_2
    //   227: new 271	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 272	java/lang/StringBuilder:<init>	()V
    //   234: ldc_w 422
    //   237: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: aload_0
    //   241: getfield 123	szb:mVideoMd5	Ljava/lang/String;
    //   244: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: invokevirtual 284	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokestatic 372	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: aload_3
    //   254: ifnull +7 -> 261
    //   257: aload_3
    //   258: invokevirtual 425	java/io/FileInputStream:close	()V
    //   261: iconst_0
    //   262: ifeq +11 -> 273
    //   265: new 374	java/lang/NullPointerException
    //   268: dup
    //   269: invokespecial 375	java/lang/NullPointerException:<init>	()V
    //   272: athrow
    //   273: iconst_0
    //   274: ifeq -197 -> 77
    //   277: new 374	java/lang/NullPointerException
    //   280: dup
    //   281: invokespecial 375	java/lang/NullPointerException:<init>	()V
    //   284: athrow
    //   285: astore_2
    //   286: iconst_m1
    //   287: ireturn
    //   288: aload_0
    //   289: getfield 123	szb:mVideoMd5	Ljava/lang/String;
    //   292: ldc 176
    //   294: invokestatic 182	com/tencent/mobileqq/shortvideo/ShortVideoUtils:bw	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   297: astore 9
    //   299: new 271	java/lang/StringBuilder
    //   302: dup
    //   303: invokespecial 272	java/lang/StringBuilder:<init>	()V
    //   306: invokestatic 428	com/tencent/mobileqq/shortvideo/ShortVideoUtils:zJ	()Ljava/lang/String;
    //   309: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: ldc_w 430
    //   315: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: invokevirtual 284	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokestatic 435	aqhq:UD	(Ljava/lang/String;)V
    //   324: new 391	java/io/File
    //   327: dup
    //   328: aload 9
    //   330: invokespecial 394	java/io/File:<init>	(Ljava/lang/String;)V
    //   333: astore 10
    //   335: new 391	java/io/File
    //   338: dup
    //   339: aload 10
    //   341: invokevirtual 438	java/io/File:getParent	()Ljava/lang/String;
    //   344: invokespecial 394	java/io/File:<init>	(Ljava/lang/String;)V
    //   347: astore_2
    //   348: aload_2
    //   349: invokevirtual 441	java/io/File:exists	()Z
    //   352: ifeq +10 -> 362
    //   355: aload_2
    //   356: invokevirtual 444	java/io/File:isDirectory	()Z
    //   359: ifne +8 -> 367
    //   362: aload_2
    //   363: invokevirtual 447	java/io/File:mkdirs	()Z
    //   366: pop
    //   367: aload 10
    //   369: invokevirtual 441	java/io/File:exists	()Z
    //   372: ifeq +11 -> 383
    //   375: aload 10
    //   377: invokevirtual 450	java/io/File:isFile	()Z
    //   380: ifne +9 -> 389
    //   383: aload 10
    //   385: invokevirtual 453	java/io/File:createNewFile	()Z
    //   388: pop
    //   389: new 455	java/io/FileOutputStream
    //   392: dup
    //   393: aload 10
    //   395: invokespecial 456	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   398: astore_2
    //   399: aload 8
    //   401: getstatic 462	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   404: bipush 50
    //   406: aload_2
    //   407: invokevirtual 466	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   410: pop
    //   411: aload_2
    //   412: invokevirtual 469	java/io/FileOutputStream:flush	()V
    //   415: new 399	java/io/FileInputStream
    //   418: dup
    //   419: aload 10
    //   421: invokespecial 402	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   424: astore 4
    //   426: aload_0
    //   427: aload 4
    //   429: aload 10
    //   431: invokevirtual 397	java/io/File:length	()J
    //   434: invokestatic 408	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   437: invokestatic 414	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   440: putfield 150	szb:aIf	Ljava/lang/String;
    //   443: aload_0
    //   444: getfield 150	szb:aIf	Ljava/lang/String;
    //   447: invokestatic 420	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   450: ifeq +70 -> 520
    //   453: invokestatic 364	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   456: ifeq +33 -> 489
    //   459: ldc_w 366
    //   462: iconst_2
    //   463: new 271	java/lang/StringBuilder
    //   466: dup
    //   467: invokespecial 272	java/lang/StringBuilder:<init>	()V
    //   470: ldc_w 471
    //   473: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: aload_0
    //   477: getfield 150	szb:aIf	Ljava/lang/String;
    //   480: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: invokevirtual 284	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   486: invokestatic 372	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   489: aload_3
    //   490: ifnull +7 -> 497
    //   493: aload_3
    //   494: invokevirtual 425	java/io/FileInputStream:close	()V
    //   497: aload_2
    //   498: ifnull +7 -> 505
    //   501: aload_2
    //   502: invokevirtual 472	java/io/FileOutputStream:close	()V
    //   505: aload 4
    //   507: ifnull -430 -> 77
    //   510: aload 4
    //   512: invokevirtual 425	java/io/FileInputStream:close	()V
    //   515: iconst_m1
    //   516: ireturn
    //   517: astore_2
    //   518: iconst_m1
    //   519: ireturn
    //   520: aload_0
    //   521: aload_0
    //   522: getfield 150	szb:aIf	Ljava/lang/String;
    //   525: ldc 176
    //   527: invokestatic 182	com/tencent/mobileqq/shortvideo/ShortVideoUtils:bw	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   530: putfield 100	szb:bN	Ljava/lang/String;
    //   533: aload 9
    //   535: aload_0
    //   536: getfield 100	szb:bN	Ljava/lang/String;
    //   539: invokestatic 476	aqhq:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   542: istore_1
    //   543: iload_1
    //   544: ifne +34 -> 578
    //   547: aload_3
    //   548: ifnull +7 -> 555
    //   551: aload_3
    //   552: invokevirtual 425	java/io/FileInputStream:close	()V
    //   555: aload_2
    //   556: ifnull +7 -> 563
    //   559: aload_2
    //   560: invokevirtual 472	java/io/FileOutputStream:close	()V
    //   563: aload 4
    //   565: ifnull -488 -> 77
    //   568: aload 4
    //   570: invokevirtual 425	java/io/FileInputStream:close	()V
    //   573: iconst_m1
    //   574: ireturn
    //   575: astore_2
    //   576: iconst_m1
    //   577: ireturn
    //   578: aload_0
    //   579: getfield 118	szb:mDuration	J
    //   582: lconst_0
    //   583: lcmp
    //   584: ifne +14 -> 598
    //   587: aload_0
    //   588: aload_0
    //   589: getfield 85	szb:mVideoPath	Ljava/lang/String;
    //   592: invokestatic 480	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getDuration	(Ljava/lang/String;)J
    //   595: putfield 118	szb:mDuration	J
    //   598: aload_3
    //   599: ifnull +7 -> 606
    //   602: aload_3
    //   603: invokevirtual 425	java/io/FileInputStream:close	()V
    //   606: aload_2
    //   607: ifnull +7 -> 614
    //   610: aload_2
    //   611: invokevirtual 472	java/io/FileOutputStream:close	()V
    //   614: aload 4
    //   616: ifnull +8 -> 624
    //   619: aload 4
    //   621: invokevirtual 425	java/io/FileInputStream:close	()V
    //   624: iconst_0
    //   625: ireturn
    //   626: astore 4
    //   628: aconst_null
    //   629: astore_2
    //   630: aconst_null
    //   631: astore_3
    //   632: invokestatic 364	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   635: ifeq +15 -> 650
    //   638: ldc_w 366
    //   641: iconst_2
    //   642: ldc_w 482
    //   645: aload 4
    //   647: invokestatic 485	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   650: aload_3
    //   651: ifnull +7 -> 658
    //   654: aload_3
    //   655: invokevirtual 425	java/io/FileInputStream:close	()V
    //   658: aload 5
    //   660: ifnull +8 -> 668
    //   663: aload 5
    //   665: invokevirtual 472	java/io/FileOutputStream:close	()V
    //   668: aload_2
    //   669: ifnull -592 -> 77
    //   672: aload_2
    //   673: invokevirtual 425	java/io/FileInputStream:close	()V
    //   676: iconst_m1
    //   677: ireturn
    //   678: astore_2
    //   679: iconst_m1
    //   680: ireturn
    //   681: astore 5
    //   683: aconst_null
    //   684: astore_2
    //   685: aconst_null
    //   686: astore 8
    //   688: aload 4
    //   690: astore 6
    //   692: aload 6
    //   694: astore 7
    //   696: aload_2
    //   697: astore 4
    //   699: aload 8
    //   701: astore_3
    //   702: invokestatic 364	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   705: ifeq +25 -> 730
    //   708: aload 6
    //   710: astore 7
    //   712: aload_2
    //   713: astore 4
    //   715: aload 8
    //   717: astore_3
    //   718: ldc_w 366
    //   721: iconst_2
    //   722: ldc_w 482
    //   725: aload 5
    //   727: invokestatic 485	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   730: aload 8
    //   732: ifnull +8 -> 740
    //   735: aload 8
    //   737: invokevirtual 425	java/io/FileInputStream:close	()V
    //   740: aload 6
    //   742: ifnull +8 -> 750
    //   745: aload 6
    //   747: invokevirtual 472	java/io/FileOutputStream:close	()V
    //   750: aload_2
    //   751: ifnull -674 -> 77
    //   754: aload_2
    //   755: invokevirtual 425	java/io/FileInputStream:close	()V
    //   758: iconst_m1
    //   759: ireturn
    //   760: astore_2
    //   761: iconst_m1
    //   762: ireturn
    //   763: astore 5
    //   765: aconst_null
    //   766: astore_2
    //   767: aconst_null
    //   768: astore 8
    //   770: aload 6
    //   772: astore 7
    //   774: aload_2
    //   775: astore 4
    //   777: aload 8
    //   779: astore_3
    //   780: invokestatic 364	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   783: ifeq +25 -> 808
    //   786: aload 6
    //   788: astore 7
    //   790: aload_2
    //   791: astore 4
    //   793: aload 8
    //   795: astore_3
    //   796: ldc_w 366
    //   799: iconst_2
    //   800: ldc_w 487
    //   803: aload 5
    //   805: invokestatic 485	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   808: aload 8
    //   810: ifnull +8 -> 818
    //   813: aload 8
    //   815: invokevirtual 425	java/io/FileInputStream:close	()V
    //   818: aload 6
    //   820: ifnull +8 -> 828
    //   823: aload 6
    //   825: invokevirtual 472	java/io/FileOutputStream:close	()V
    //   828: aload_2
    //   829: ifnull -752 -> 77
    //   832: aload_2
    //   833: invokevirtual 425	java/io/FileInputStream:close	()V
    //   836: iconst_m1
    //   837: ireturn
    //   838: astore_2
    //   839: iconst_m1
    //   840: ireturn
    //   841: astore_2
    //   842: aconst_null
    //   843: astore 4
    //   845: aconst_null
    //   846: astore_3
    //   847: aload 7
    //   849: astore 5
    //   851: aload_3
    //   852: ifnull +7 -> 859
    //   855: aload_3
    //   856: invokevirtual 425	java/io/FileInputStream:close	()V
    //   859: aload 5
    //   861: ifnull +8 -> 869
    //   864: aload 5
    //   866: invokevirtual 472	java/io/FileOutputStream:close	()V
    //   869: aload 4
    //   871: ifnull +8 -> 879
    //   874: aload 4
    //   876: invokevirtual 425	java/io/FileInputStream:close	()V
    //   879: aload_2
    //   880: athrow
    //   881: astore_2
    //   882: goto -829 -> 53
    //   885: astore_2
    //   886: goto -821 -> 65
    //   889: astore_2
    //   890: iconst_m1
    //   891: ireturn
    //   892: astore_2
    //   893: goto -775 -> 118
    //   896: astore_2
    //   897: goto -767 -> 130
    //   900: astore_2
    //   901: goto -640 -> 261
    //   904: astore_2
    //   905: goto -632 -> 273
    //   908: astore_3
    //   909: goto -412 -> 497
    //   912: astore_2
    //   913: goto -408 -> 505
    //   916: astore_3
    //   917: goto -362 -> 555
    //   920: astore_2
    //   921: goto -358 -> 563
    //   924: astore_3
    //   925: goto -319 -> 606
    //   928: astore_2
    //   929: goto -315 -> 614
    //   932: astore_2
    //   933: goto -309 -> 624
    //   936: astore_3
    //   937: goto -279 -> 658
    //   940: astore_3
    //   941: goto -273 -> 668
    //   944: astore_3
    //   945: goto -205 -> 740
    //   948: astore_3
    //   949: goto -199 -> 750
    //   952: astore_3
    //   953: goto -135 -> 818
    //   956: astore_3
    //   957: goto -129 -> 828
    //   960: astore_3
    //   961: goto -102 -> 859
    //   964: astore_3
    //   965: goto -96 -> 869
    //   968: astore_3
    //   969: goto -90 -> 879
    //   972: astore_2
    //   973: aconst_null
    //   974: astore 4
    //   976: aload 7
    //   978: astore 5
    //   980: goto -129 -> 851
    //   983: astore 6
    //   985: aconst_null
    //   986: astore 4
    //   988: aload_2
    //   989: astore 5
    //   991: aload 6
    //   993: astore_2
    //   994: goto -143 -> 851
    //   997: astore 6
    //   999: aload_2
    //   1000: astore 5
    //   1002: aload 6
    //   1004: astore_2
    //   1005: goto -154 -> 851
    //   1008: astore 6
    //   1010: aload_2
    //   1011: astore 4
    //   1013: aload 6
    //   1015: astore_2
    //   1016: goto -165 -> 851
    //   1019: astore_2
    //   1020: aload 7
    //   1022: astore 5
    //   1024: goto -173 -> 851
    //   1027: astore 5
    //   1029: aconst_null
    //   1030: astore_2
    //   1031: aload_3
    //   1032: astore 8
    //   1034: goto -264 -> 770
    //   1037: astore 5
    //   1039: aconst_null
    //   1040: astore 4
    //   1042: aload_2
    //   1043: astore 6
    //   1045: aload 4
    //   1047: astore_2
    //   1048: aload_3
    //   1049: astore 8
    //   1051: goto -281 -> 770
    //   1054: astore 5
    //   1056: aload_2
    //   1057: astore 6
    //   1059: aload 4
    //   1061: astore_2
    //   1062: aload_3
    //   1063: astore 8
    //   1065: goto -295 -> 770
    //   1068: astore 5
    //   1070: aconst_null
    //   1071: astore_2
    //   1072: aload 4
    //   1074: astore 6
    //   1076: aload_3
    //   1077: astore 8
    //   1079: goto -387 -> 692
    //   1082: astore 5
    //   1084: aconst_null
    //   1085: astore 4
    //   1087: aload_2
    //   1088: astore 6
    //   1090: aload 4
    //   1092: astore_2
    //   1093: aload_3
    //   1094: astore 8
    //   1096: goto -404 -> 692
    //   1099: astore 5
    //   1101: aload_2
    //   1102: astore 6
    //   1104: aload 4
    //   1106: astore_2
    //   1107: aload_3
    //   1108: astore 8
    //   1110: goto -418 -> 692
    //   1113: astore 4
    //   1115: aconst_null
    //   1116: astore_2
    //   1117: goto -485 -> 632
    //   1120: astore 4
    //   1122: aconst_null
    //   1123: astore 6
    //   1125: aload_2
    //   1126: astore 5
    //   1128: aload 6
    //   1130: astore_2
    //   1131: goto -499 -> 632
    //   1134: astore 6
    //   1136: aload_2
    //   1137: astore 5
    //   1139: aload 4
    //   1141: astore_2
    //   1142: aload 6
    //   1144: astore 4
    //   1146: goto -514 -> 632
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1149	0	this	szb
    //   542	2	1	bool	boolean
    //   20	60	2	localBitmap	android.graphics.Bitmap
    //   142	1	2	localIOException1	java.io.IOException
    //   174	14	2	localFile1	java.io.File
    //   285	1	2	localIOException2	java.io.IOException
    //   347	155	2	localObject1	Object
    //   517	43	2	localIOException3	java.io.IOException
    //   575	36	2	localIOException4	java.io.IOException
    //   629	44	2	localObject2	Object
    //   678	1	2	localIOException5	java.io.IOException
    //   684	71	2	localObject3	Object
    //   760	1	2	localIOException6	java.io.IOException
    //   766	67	2	localObject4	Object
    //   838	1	2	localIOException7	java.io.IOException
    //   841	39	2	localObject5	Object
    //   881	1	2	localIOException8	java.io.IOException
    //   885	1	2	localIOException9	java.io.IOException
    //   889	1	2	localIOException10	java.io.IOException
    //   892	1	2	localIOException11	java.io.IOException
    //   896	1	2	localIOException12	java.io.IOException
    //   900	1	2	localIOException13	java.io.IOException
    //   904	1	2	localIOException14	java.io.IOException
    //   912	1	2	localIOException15	java.io.IOException
    //   920	1	2	localIOException16	java.io.IOException
    //   928	1	2	localIOException17	java.io.IOException
    //   932	1	2	localIOException18	java.io.IOException
    //   972	17	2	localObject6	Object
    //   993	23	2	localObject7	Object
    //   1019	1	2	localObject8	Object
    //   1030	112	2	localObject9	Object
    //   191	665	3	localObject10	Object
    //   908	1	3	localIOException19	java.io.IOException
    //   916	1	3	localIOException20	java.io.IOException
    //   924	1	3	localIOException21	java.io.IOException
    //   936	1	3	localIOException22	java.io.IOException
    //   940	1	3	localIOException23	java.io.IOException
    //   944	1	3	localIOException24	java.io.IOException
    //   948	1	3	localIOException25	java.io.IOException
    //   952	1	3	localIOException26	java.io.IOException
    //   956	1	3	localIOException27	java.io.IOException
    //   960	1	3	localIOException28	java.io.IOException
    //   964	1	3	localIOException29	java.io.IOException
    //   968	140	3	localIOException30	java.io.IOException
    //   1	619	4	localFileInputStream	java.io.FileInputStream
    //   626	63	4	localIOException31	java.io.IOException
    //   697	408	4	localObject11	Object
    //   1113	1	4	localIOException32	java.io.IOException
    //   1120	20	4	localIOException33	java.io.IOException
    //   1144	1	4	localObject12	Object
    //   10	654	5	localObject13	Object
    //   681	45	5	localException1	java.lang.Exception
    //   763	41	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   849	174	5	localObject14	Object
    //   1027	1	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   1037	1	5	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   1054	1	5	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   1068	1	5	localException2	java.lang.Exception
    //   1082	1	5	localException3	java.lang.Exception
    //   1099	1	5	localException4	java.lang.Exception
    //   1126	12	5	localObject15	Object
    //   4	820	6	localIOException34	java.io.IOException
    //   983	9	6	localObject16	Object
    //   997	6	6	localObject17	Object
    //   1008	6	6	localObject18	Object
    //   1043	86	6	localObject19	Object
    //   1134	9	6	localIOException35	java.io.IOException
    //   7	1014	7	localIOException36	java.io.IOException
    //   83	1026	8	localObject20	Object
    //   297	237	9	str	String
    //   333	97	10	localFile2	java.io.File
    // Exception table:
    //   from	to	target	type
    //   134	142	142	java/io/IOException
    //   277	285	285	java/io/IOException
    //   510	515	517	java/io/IOException
    //   568	573	575	java/io/IOException
    //   12	21	626	java/io/IOException
    //   25	41	626	java/io/IOException
    //   79	85	626	java/io/IOException
    //   90	106	626	java/io/IOException
    //   145	192	626	java/io/IOException
    //   672	676	678	java/io/IOException
    //   12	21	681	java/lang/Exception
    //   25	41	681	java/lang/Exception
    //   79	85	681	java/lang/Exception
    //   90	106	681	java/lang/Exception
    //   145	192	681	java/lang/Exception
    //   754	758	760	java/io/IOException
    //   12	21	763	java/lang/OutOfMemoryError
    //   25	41	763	java/lang/OutOfMemoryError
    //   79	85	763	java/lang/OutOfMemoryError
    //   90	106	763	java/lang/OutOfMemoryError
    //   145	192	763	java/lang/OutOfMemoryError
    //   832	836	838	java/io/IOException
    //   12	21	841	finally
    //   25	41	841	finally
    //   79	85	841	finally
    //   90	106	841	finally
    //   145	192	841	finally
    //   45	53	881	java/io/IOException
    //   57	65	885	java/io/IOException
    //   69	77	889	java/io/IOException
    //   110	118	892	java/io/IOException
    //   122	130	896	java/io/IOException
    //   257	261	900	java/io/IOException
    //   265	273	904	java/io/IOException
    //   493	497	908	java/io/IOException
    //   501	505	912	java/io/IOException
    //   551	555	916	java/io/IOException
    //   559	563	920	java/io/IOException
    //   602	606	924	java/io/IOException
    //   610	614	928	java/io/IOException
    //   619	624	932	java/io/IOException
    //   654	658	936	java/io/IOException
    //   663	668	940	java/io/IOException
    //   735	740	944	java/io/IOException
    //   745	750	948	java/io/IOException
    //   813	818	952	java/io/IOException
    //   823	828	956	java/io/IOException
    //   855	859	960	java/io/IOException
    //   864	869	964	java/io/IOException
    //   874	879	968	java/io/IOException
    //   192	253	972	finally
    //   288	362	972	finally
    //   362	367	972	finally
    //   367	383	972	finally
    //   383	389	972	finally
    //   389	399	972	finally
    //   399	426	983	finally
    //   426	489	997	finally
    //   520	543	997	finally
    //   578	598	997	finally
    //   632	650	1008	finally
    //   702	708	1019	finally
    //   718	730	1019	finally
    //   780	786	1019	finally
    //   796	808	1019	finally
    //   192	253	1027	java/lang/OutOfMemoryError
    //   288	362	1027	java/lang/OutOfMemoryError
    //   362	367	1027	java/lang/OutOfMemoryError
    //   367	383	1027	java/lang/OutOfMemoryError
    //   383	389	1027	java/lang/OutOfMemoryError
    //   389	399	1027	java/lang/OutOfMemoryError
    //   399	426	1037	java/lang/OutOfMemoryError
    //   426	489	1054	java/lang/OutOfMemoryError
    //   520	543	1054	java/lang/OutOfMemoryError
    //   578	598	1054	java/lang/OutOfMemoryError
    //   192	253	1068	java/lang/Exception
    //   288	362	1068	java/lang/Exception
    //   362	367	1068	java/lang/Exception
    //   367	383	1068	java/lang/Exception
    //   383	389	1068	java/lang/Exception
    //   389	399	1068	java/lang/Exception
    //   399	426	1082	java/lang/Exception
    //   426	489	1099	java/lang/Exception
    //   520	543	1099	java/lang/Exception
    //   578	598	1099	java/lang/Exception
    //   192	253	1113	java/io/IOException
    //   288	362	1113	java/io/IOException
    //   362	367	1113	java/io/IOException
    //   367	383	1113	java/io/IOException
    //   383	389	1113	java/io/IOException
    //   389	399	1113	java/io/IOException
    //   399	426	1120	java/io/IOException
    //   426	489	1134	java/io/IOException
    //   520	543	1134	java/io/IOException
    //   578	598	1134	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     szb
 * JD-Core Version:    0.7.0.1
 */