package com.tencent.mobileqq.transfile;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ShortVideoTransManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ShortVideoUpInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.ShortVideoUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.ShortVideoUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.protohandler.ShortVideoUpHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import eht;
import ehu;
import ehw;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;
import tencent.im.msg.im_msg_body.VideoFile;

public class ShortVideoUploadProcessor
  extends BaseUploadProcessor
{
  public static final String W = "ShortVideoUploadProcessor";
  public static final String X = "QQ_&_MoblieQQ_&_QQ";
  private String Y;
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new ehu(this);
  private ShortVideoTransManager jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager;
  private ShortVideoUpInfo jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo;
  int aN = 0;
  private int aO;
  private int aP;
  private int aQ;
  private RandomAccessFile jdField_b_of_type_JavaIoRandomAccessFile;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private long j;
  private long k;
  
  public ShortVideoUploadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    paramTransFileController = paramTransferRequest.h;
    String[] arrayOfString = paramTransFileController.split("QQ_&_MoblieQQ_&_QQ");
    if (4 != arrayOfString.length)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "path was not set correctlly------path = " + paramTransFileController);
      }
      throw new IllegalArgumentException("path was not set correctlly.");
    }
    paramTransferRequest.h = arrayOfString[0];
    this.Y = arrayOfString[1];
    this.aQ = Integer.parseInt(arrayOfString[2]);
    this.jdField_b_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(arrayOfString[3]);
  }
  
  private im_msg_body.RichText a()
  {
    for (;;)
    {
      try
      {
        im_msg_body.RichText localRichText = new im_msg_body.RichText();
        im_msg_body.VideoFile localVideoFile = new im_msg_body.VideoFile();
        localVideoFile.setHasFlag(true);
        localVideoFile.bytes_file_name.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h));
        localVideoFile.bytes_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.e)));
        localVideoFile.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(this.jdField_f_of_type_JavaLangString));
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "mResid uuid=" + this.jdField_f_of_type_JavaLangString);
        }
        localVideoFile.uint32_file_format.set(2);
        localVideoFile.uint32_file_size.set((int)this.jdField_a_of_type_Long);
        localVideoFile.uint32_file_time.set(this.aQ);
        localVideoFile.uint32_thumb_width.set(this.aO);
        localVideoFile.uint32_thumb_height.set(this.aP);
        localVideoFile.bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(this.jdField_b_of_type_ArrayOfByte));
        if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo))
        {
          Object localObject1 = (MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          if (localObject1 != null) {
            localVideoFile.bytes_source.set(ByteStringMicro.copyFromUtf8(((MessageForShortVideo)localObject1).fileSource));
          }
          Object localObject3 = new im_msg_body.Text();
          ((im_msg_body.Text)localObject3).setHasFlag(true);
          ((im_msg_body.Text)localObject3).str.set(ByteStringMicro.copyFromUtf8("你的QQ暂不支持查看视频短片，请期待后续版本。"));
          localObject1 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject3);
          localObject3 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject3).video_file.set(localVideoFile);
          localRichText.elems.add((MessageMicro)localObject1);
          localRichText.elems.add((MessageMicro)localObject3);
          return localRichText;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoUploadProcessor", 2, "Construct richtext error", localException);
        }
        localException.printStackTrace();
        return null;
      }
      Object localObject2 = null;
    }
  }
  
  private void d(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    this.aO = localOptions.outWidth;
    this.aP = localOptions.outHeight;
  }
  
  protected long a(long paramLong)
  {
    paramLong = this.jdField_a_of_type_Long - paramLong;
    if (!this.jdField_b_of_type_Boolean) {}
    for (paramLong = Math.min(paramLong, this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a(BaseApplication.getContext(), this.jdField_a_of_type_Long, this.jdField_h_of_type_Long));; paramLong = Math.min(paramLong, this.i)) {
      return Math.min(paramLong, 131072L);
    }
  }
  
  protected String a(byte[] paramArrayOfByte)
  {
    Object localObject2 = MD5.toMD5Byte(paramArrayOfByte, 0, paramArrayOfByte.length);
    if (localObject2 != null)
    {
      paramArrayOfByte = "";
      int i = 0;
      for (;;)
      {
        localObject1 = paramArrayOfByte;
        if (i >= localObject2.length) {
          break;
        }
        paramArrayOfByte = paramArrayOfByte + MD5.byteHEX(localObject2[i]);
        i += 1;
      }
    }
    Object localObject1 = "";
    paramArrayOfByte = new StringBuilder();
    localObject2 = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    paramArrayOfByte.append("http://");
    paramArrayOfByte.append(((ServerAddr)localObject2).jdField_a_of_type_JavaLangString);
    if (((ServerAddr)localObject2).jdField_b_of_type_Int != 80)
    {
      paramArrayOfByte.append(":");
      paramArrayOfByte.append(((ServerAddr)localObject2).jdField_b_of_type_Int);
    }
    paramArrayOfByte.append("/qqupload?ver=");
    paramArrayOfByte.append("607");
    paramArrayOfByte.append("&ukey=");
    paramArrayOfByte.append(this.V);
    paramArrayOfByte.append("&filekey=");
    paramArrayOfByte.append(this.jdField_f_of_type_JavaLangString);
    paramArrayOfByte.append("&filesize=");
    paramArrayOfByte.append(this.jdField_a_of_type_Long);
    paramArrayOfByte.append("&bmd5=");
    paramArrayOfByte.append((String)localObject1);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo.uKey != null))
    {
      if (QLog.isColorLevel())
      {
        QLog.d("ShortVideoUploadProcessor", 2, "getConnUrl()---------- lastukey = " + this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo.uKey);
        QLog.d("ShortVideoUploadProcessor", 2, "getConnUrl()---------- lastip = " + this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo.lastIp);
      }
      paramArrayOfByte.append("&lastukey=");
      paramArrayOfByte.append(this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo.uKey);
      paramArrayOfByte.append("&lastip=");
      paramArrayOfByte.append(this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo.lastIp);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "getConnUrl()---------- url = " + paramArrayOfByte.toString());
    }
    paramArrayOfByte.append("&mType=shortVideo");
    return paramArrayOfByte.toString();
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 8
    //   8: iconst_2
    //   9: ldc_w 364
    //   12: invokestatic 76	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_0
    //   16: invokespecial 366	com/tencent/mobileqq/transfile/BaseUploadProcessor:a	()V
    //   19: aload_0
    //   20: sipush 1001
    //   23: invokevirtual 368	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	(I)V
    //   26: aload_0
    //   27: getfield 371	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   30: invokevirtual 375	com/tencent/mobileqq/transfile/FileMsg:b	()V
    //   33: aload_0
    //   34: getfield 122	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   37: getfield 140	com/tencent/mobileqq/transfile/TransferRequest:e	Ljava/lang/String;
    //   40: invokestatic 381	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   43: ifne +31 -> 74
    //   46: aload_0
    //   47: aload_0
    //   48: getfield 122	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   51: getfield 140	com/tencent/mobileqq/transfile/TransferRequest:e	Ljava/lang/String;
    //   54: invokestatic 99	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   57: putfield 383	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   60: aload_0
    //   61: getfield 371	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   64: aload_0
    //   65: getfield 122	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   68: getfield 140	com/tencent/mobileqq/transfile/TransferRequest:e	Ljava/lang/String;
    //   71: putfield 384	com/tencent/mobileqq/transfile/FileMsg:h	Ljava/lang/String;
    //   74: aload_0
    //   75: getfield 383	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   78: ifnonnull +15 -> 93
    //   81: aload_0
    //   82: invokevirtual 386	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:f	()Z
    //   85: ifne +8 -> 93
    //   88: aload_0
    //   89: invokevirtual 388	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	()V
    //   92: return
    //   93: aload_0
    //   94: getfield 101	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   97: ifnonnull +96 -> 193
    //   100: new 390	java/io/FileInputStream
    //   103: dup
    //   104: aload_0
    //   105: getfield 85	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:Y	Ljava/lang/String;
    //   108: invokespecial 391	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   111: astore_2
    //   112: aload_2
    //   113: astore_1
    //   114: aload_0
    //   115: aload_2
    //   116: lconst_0
    //   117: invokestatic 394	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   120: putfield 101	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   123: aload_2
    //   124: astore_1
    //   125: aload_0
    //   126: getfield 101	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   129: ifnonnull +56 -> 185
    //   132: aload_2
    //   133: astore_1
    //   134: aload_0
    //   135: sipush 9041
    //   138: new 59	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   145: ldc_w 396
    //   148: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload_0
    //   152: getfield 85	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:Y	Ljava/lang/String;
    //   155: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokevirtual 399	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	(ILjava/lang/String;)V
    //   164: aload_2
    //   165: astore_1
    //   166: aload_0
    //   167: invokevirtual 388	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	()V
    //   170: aload_2
    //   171: ifnull -79 -> 92
    //   174: aload_2
    //   175: invokevirtual 402	java/io/FileInputStream:close	()V
    //   178: return
    //   179: astore_1
    //   180: aload_1
    //   181: invokevirtual 403	java/io/IOException:printStackTrace	()V
    //   184: return
    //   185: aload_2
    //   186: ifnull +7 -> 193
    //   189: aload_2
    //   190: invokevirtual 402	java/io/FileInputStream:close	()V
    //   193: aload_0
    //   194: getfield 405	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   197: ifnonnull +126 -> 323
    //   200: aload_0
    //   201: new 407	java/io/RandomAccessFile
    //   204: dup
    //   205: aload_0
    //   206: getfield 122	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   209: getfield 45	com/tencent/mobileqq/transfile/TransferRequest:h	Ljava/lang/String;
    //   212: ldc_w 409
    //   215: invokespecial 412	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   218: putfield 405	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   221: aload_0
    //   222: getfield 405	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   225: ifnonnull +98 -> 323
    //   228: aload_0
    //   229: sipush 9303
    //   232: ldc_w 414
    //   235: invokevirtual 399	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	(ILjava/lang/String;)V
    //   238: aload_0
    //   239: invokevirtual 388	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	()V
    //   242: return
    //   243: astore_1
    //   244: aload_1
    //   245: invokevirtual 403	java/io/IOException:printStackTrace	()V
    //   248: goto -55 -> 193
    //   251: astore_3
    //   252: aconst_null
    //   253: astore_2
    //   254: aload_2
    //   255: astore_1
    //   256: aload_0
    //   257: aconst_null
    //   258: putfield 101	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_ArrayOfByte	[B
    //   261: aload_2
    //   262: astore_1
    //   263: aload_0
    //   264: aload_3
    //   265: invokevirtual 417	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	(Ljava/io/IOException;)V
    //   268: aload_2
    //   269: astore_1
    //   270: aload_0
    //   271: invokevirtual 388	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	()V
    //   274: aload_2
    //   275: ifnull -183 -> 92
    //   278: aload_2
    //   279: invokevirtual 402	java/io/FileInputStream:close	()V
    //   282: return
    //   283: astore_1
    //   284: aload_1
    //   285: invokevirtual 403	java/io/IOException:printStackTrace	()V
    //   288: return
    //   289: astore_2
    //   290: aconst_null
    //   291: astore_1
    //   292: aload_1
    //   293: ifnull +7 -> 300
    //   296: aload_1
    //   297: invokevirtual 402	java/io/FileInputStream:close	()V
    //   300: aload_2
    //   301: athrow
    //   302: astore_1
    //   303: aload_1
    //   304: invokevirtual 403	java/io/IOException:printStackTrace	()V
    //   307: goto -7 -> 300
    //   310: astore_1
    //   311: aload_1
    //   312: invokevirtual 418	java/io/FileNotFoundException:printStackTrace	()V
    //   315: aload_0
    //   316: aconst_null
    //   317: putfield 405	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   320: goto -99 -> 221
    //   323: aload_0
    //   324: getfield 420	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   327: ifnonnull +56 -> 383
    //   330: aload_0
    //   331: new 407	java/io/RandomAccessFile
    //   334: dup
    //   335: aload_0
    //   336: getfield 85	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:Y	Ljava/lang/String;
    //   339: ldc_w 409
    //   342: invokespecial 412	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   345: putfield 420	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   348: aload_0
    //   349: getfield 420	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   352: ifnonnull +31 -> 383
    //   355: aload_0
    //   356: sipush 9303
    //   359: ldc_w 414
    //   362: invokevirtual 399	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:a	(ILjava/lang/String;)V
    //   365: aload_0
    //   366: invokevirtual 388	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:d	()V
    //   369: return
    //   370: astore_1
    //   371: aload_1
    //   372: invokevirtual 418	java/io/FileNotFoundException:printStackTrace	()V
    //   375: aload_0
    //   376: aconst_null
    //   377: putfield 420	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   380: goto -32 -> 348
    //   383: aload_0
    //   384: invokevirtual 422	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:r	()V
    //   387: return
    //   388: astore_2
    //   389: goto -97 -> 292
    //   392: astore_3
    //   393: goto -139 -> 254
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	396	0	this	ShortVideoUploadProcessor
    //   113	53	1	localFileInputStream1	java.io.FileInputStream
    //   179	2	1	localIOException1	IOException
    //   243	2	1	localIOException2	IOException
    //   255	15	1	localFileInputStream2	java.io.FileInputStream
    //   283	2	1	localIOException3	IOException
    //   291	6	1	localObject1	Object
    //   302	2	1	localIOException4	IOException
    //   310	2	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   370	2	1	localFileNotFoundException2	java.io.FileNotFoundException
    //   111	168	2	localFileInputStream3	java.io.FileInputStream
    //   289	12	2	localObject2	Object
    //   388	1	2	localObject3	Object
    //   251	14	3	localIOException5	IOException
    //   392	1	3	localIOException6	IOException
    // Exception table:
    //   from	to	target	type
    //   174	178	179	java/io/IOException
    //   189	193	243	java/io/IOException
    //   100	112	251	java/io/IOException
    //   278	282	283	java/io/IOException
    //   100	112	289	finally
    //   296	300	302	java/io/IOException
    //   200	221	310	java/io/FileNotFoundException
    //   330	348	370	java/io/FileNotFoundException
    //   114	123	388	finally
    //   125	132	388	finally
    //   134	164	388	finally
    //   166	170	388	finally
    //   256	261	388	finally
    //   263	268	388	finally
    //   270	274	388	finally
    //   114	123	392	java/io/IOException
    //   125	132	392	java/io/IOException
    //   134	164	392	java/io/IOException
    //   166	170	392	java/io/IOException
  }
  
  public void a(NetResp paramNetResp)
  {
    super.a(paramNetResp);
    if ((this.jdField_h_of_type_Boolean) || (this.jdField_d_of_type_Boolean)) {
      return;
    }
    a("onResp", "result:" + paramNetResp.jdField_d_of_type_Int + " errCode:" + paramNetResp.e + " errDesc:" + paramNetResp.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel())
    {
      QLog.d("ShortVideoUploadProcessor", 2, "onResp()---- result:" + paramNetResp.jdField_d_of_type_Int);
      QLog.d("ShortVideoUploadProcessor", 2, "onResp()---- errCode:" + paramNetResp.e);
      QLog.d("ShortVideoUploadProcessor", 2, "onResp()---- errDesc:" + paramNetResp.jdField_a_of_type_JavaLangString);
      QLog.d("ShortVideoUploadProcessorTest", 2, "onResp mIpList size ==== = 0" + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    int i = paramNetResp.f;
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
    long l2;
    for (;;)
    {
      try
      {
        if (paramNetResp.jdField_d_of_type_Int != 0) {
          break label1078;
        }
        this.ay = 0;
        this.jdField_a_of_type_ComTencentWsttSSCMSSCM.b();
        if (paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("User-ReturnCode") == null)
        {
          l2 = 9223372036854775807L;
          if (-5103065L != l2) {
            this.aN = 0;
          }
          if ((l2 == 0L) || (l2 == 9223372036854775807L)) {
            break label477;
          }
          if (-5103065L != l2) {
            break label435;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager.b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.e + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
          }
          this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo = null;
          this.jdField_h_of_type_Long = 0L;
          if (this.aN >= 3) {
            break;
          }
          c();
          this.aN += 1;
          return;
        }
      }
      catch (Exception paramNetResp)
      {
        a(9343, "decode reponse unknown exception", "", this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
        return;
      }
      l2 = Long.parseLong((String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("User-ReturnCode"));
    }
    a((int)l2, "续传过期重试超过3次.");
    d();
    return;
    label435:
    a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, false);
    if (!ShortVideoUpHandler.a((int)l2))
    {
      a(-9527, null, b(i, l2), this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
      return;
    }
    label477:
    long l1;
    if (paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("Range") == null)
    {
      l1 = 9223372036854775807L;
      if (l1 != 9223372036854775807L) {
        break label1202;
      }
      Object localObject = paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("X-Range");
      if (localObject == null) {
        break label1202;
      }
    }
    label1202:
    for (;;)
    {
      try
      {
        for (;;)
        {
          i = Integer.parseInt((String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("X-Range"));
          l1 = i;
          if (l1 == 9223372036854775807L)
          {
            a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, false);
            a(-9527, "no header range", a(this.K, this.at), this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
            d();
            return;
            try
            {
              i = Integer.parseInt((String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("Range"));
              l1 = i;
            }
            catch (Exception localException1)
            {
              localException1.printStackTrace();
              l1 = 9223372036854775807L;
            }
          }
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        l1 = 9223372036854775807L;
        continue;
        a("decodeHttpResp", "from " + this.jdField_h_of_type_Long + " to " + l1 + " userReturnCode:" + l2);
        if (l1 <= this.jdField_h_of_type_Long)
        {
          if (this.aI < 3)
          {
            a("procHttpRespBody", "server offset rollback");
            this.aI += 1;
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoUploadProcessor", 2, "onResp()---------- transferedSize = " + l1);
          }
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e = l1;
          this.jdField_h_of_type_Long = l1;
          this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager = ((ShortVideoTransManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52));
          a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, true);
          if (l1 >= this.jdField_a_of_type_Long) {
            continue;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager != null)
          {
            ShortVideoUpInfo localShortVideoUpInfo = this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.e + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
            paramNetResp = localShortVideoUpInfo;
            if (localShortVideoUpInfo == null)
            {
              paramNetResp = new ShortVideoUpInfo();
              paramNetResp.key = (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.e + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
              paramNetResp.uKey = this.V;
              paramNetResp.lastIp = this.k;
            }
            paramNetResp.transferedSize = this.jdField_h_of_type_Long;
            paramNetResp.timeStamp = System.currentTimeMillis();
            this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager.a(paramNetResp);
          }
          if (this.jdField_h_of_type_Boolean) {
            break;
          }
          f();
          c();
          return;
        }
        a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, false);
        this.jdField_a_of_type_JavaUtilHashMap.put("returnCode", "" + l2);
        a(-9527, "", a(this.K, this.as), this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "sendFile() success.");
        }
        s();
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b();
        return;
      }
      label1078:
      this.aN = 0;
      if ((paramNetResp.e == 9364) && (this.ay < 3))
      {
        a("[netChg]", "failed.but net change detect.so retry");
        this.ay += 1;
        this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a();
        o();
        r();
        return;
      }
      if ((paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.jdField_a_of_type_ArrayOfByte.length >= 32768) && (RichMediaStrategy.a(paramNetResp.e)))
      {
        this.jdField_b_of_type_Boolean = true;
        o();
        c();
        return;
      }
      a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, false);
      a(paramNetResp.e, paramNetResp.jdField_a_of_type_JavaLangString);
      d();
      return;
    }
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
    if (paramRichProtoResp != null)
    {
      int i = 0;
      if (i < paramRichProtoResp.jdField_a_of_type_JavaUtilList.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.ShortVideoUpResp)paramRichProtoResp.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          a("procUrl", paramRichProtoReq.toString());
        }
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramRichProtoReq);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "onBusiProtoResp()------response.result = " + paramRichProtoReq.jdField_c_of_type_Int);
        }
        this.jdField_f_of_type_JavaLangString = paramRichProtoReq.jdField_b_of_type_JavaLangString;
        this.jdField_a_of_type_JavaUtilArrayList = paramRichProtoReq.jdField_a_of_type_JavaUtilArrayList;
        if (paramRichProtoReq.jdField_c_of_type_Int == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoUploadProcessor", 2, "onBusiProtoResp()------response.isExist = " + paramRichProtoReq.jdField_a_of_type_Boolean);
          }
          if (paramRichProtoReq.jdField_a_of_type_Boolean) {
            s();
          }
        }
        for (;;)
        {
          i += 1;
          break;
          this.V = paramRichProtoReq.jdField_a_of_type_JavaLangString;
          this.k = paramRichProtoReq.jdField_a_of_type_Long;
          if (QLog.isColorLevel())
          {
            QLog.d("ShortVideoUploadProcessor", 2, "onBusiProtoResp()---- mIpList:" + this.jdField_a_of_type_JavaUtilArrayList);
            QLog.d("ShortVideoUploadProcessor", 2, "onBusiProtoResp()---- firstIpInInt:" + this.k);
            QLog.d("ShortVideoUploadProcessor", 2, "onBusiProtoResp()---- mUiRequest.mMd5:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.e);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager = ((ShortVideoTransManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52));
          if (this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager != null) {
            this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo = this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.e + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
          }
          this.jdField_h_of_type_Long = 0L;
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoUploadProcessor", 2, "sendFile()---------- mShortVideoUpInfo = " + this.jdField_a_of_type_ComTencentMobileqqDataShortVideoUpInfo);
          }
          c();
          continue;
          d();
        }
      }
    }
  }
  
  byte[] a(int paramInt1, int paramInt2)
  {
    long l = paramInt1;
    for (;;)
    {
      int i;
      int m;
      try
      {
        if (l < this.j)
        {
          this.jdField_b_of_type_JavaIoRandomAccessFile.seek(paramInt1);
          if (this.j >= paramInt1 + paramInt2) {
            break label193;
          }
          paramInt1 = (int)(this.j - paramInt1);
          arrayOfByte = new byte[paramInt1];
          i = 0;
          paramInt2 = paramInt1;
          if (i >= paramInt1) {
            break;
          }
          m = this.jdField_b_of_type_JavaIoRandomAccessFile.read(arrayOfByte, i, paramInt2);
          if (m != -1) {
            break label198;
          }
          a(9303, "fileSize not enough");
          this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.b();
          return null;
        }
        this.jdField_a_of_type_JavaIoRandomAccessFile.seek(paramInt1 - this.j);
        byte[] arrayOfByte = new byte[paramInt2];
        i = 0;
        paramInt1 = paramInt2;
        if (i >= paramInt2) {
          break label190;
        }
        m = this.jdField_a_of_type_JavaIoRandomAccessFile.read(arrayOfByte, i, paramInt1);
        if (m == -1)
        {
          a(9303, "fileSize not enough");
          this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.b();
          return null;
        }
      }
      catch (IOException localIOException)
      {
        a(localIOException);
        localIOException.printStackTrace();
        return null;
      }
      i += m;
      paramInt1 -= m;
      continue;
      label190:
      return localIOException;
      label193:
      paramInt1 = paramInt2;
      continue;
      label198:
      i += m;
      paramInt2 -= m;
    }
    return localIOException;
  }
  
  protected void c(boolean paramBoolean)
  {
    if ((!paramBoolean) && (RichMediaStrategy.c(this.aw))) {}
    while ((this.jdField_c_of_type_Boolean) || ((paramBoolean) && ((this.az & 0x2) > 0)) || ((!paramBoolean) && ((this.az & 0x1) > 0))) {
      return;
    }
    int m = this.az;
    int i;
    String str1;
    label86:
    long l;
    String str2;
    if (paramBoolean)
    {
      i = 2;
      this.az = (i | m);
      str1 = "actShortVideoUpload";
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int != 0) {
        break label311;
      }
      str1 = "actShortVideoUpload";
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      l = (System.nanoTime() - this.jdField_c_of_type_Long) / 1000000L;
      str2 = this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(1) + ";" + this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(2) + ";" + this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", str2);
      HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
      if (this.jdField_f_of_type_JavaLangString != null) {
        break label343;
      }
      str2 = this.U;
      label196:
      localHashMap.put("param_uuid", str2);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_toUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_iplist", this.jdField_a_of_type_JavaUtilArrayList.toString());
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.jdField_a_of_type_Long));
      if (!paramBoolean) {
        break label352;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, str1, true, l, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      n();
      return;
      i = 1;
      break;
      label311:
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int != 3000)) {
        break label86;
      }
      str1 = "actShortVideoDiscussgroupUpload";
      break label86;
      label343:
      str2 = this.jdField_f_of_type_JavaLangString;
      break label196;
      label352:
      if (this.aw != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.aw));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.L);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int));
      StatisticCollector.a(BaseApplication.getContext()).a(null, str1, false, l, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  public void d()
  {
    super.d();
    d(1005);
    if (QLog.isColorLevel())
    {
      QLog.d("ShortVideoUploadProcessor", 2, "onError()---- errCode:" + this.aw);
      QLog.d("ShortVideoUploadProcessor", 2, "onError()---- errDesc:" + this.L);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Int = -1;
      localSendResult.jdField_b_of_type_Int = this.aw;
      localSendResult.jdField_a_of_type_JavaLangString = this.L;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.b(localSendResult);
    }
  }
  
  protected void d(int paramInt)
  {
    super.d(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "sendMessageToUpdate------state = " + paramInt);
    }
    if ((this.jdField_d_of_type_Boolean) && (1004 != paramInt)) {
      return;
    }
    ShortVideoBusiManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest);
  }
  
  public int e()
  {
    this.jdField_f_of_type_Boolean = true;
    return 0;
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppShortVideoTransManager.b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.e + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    }
    UpCallBack.SendResult localSendResult;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Int = 0;
      localSendResult.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localSendResult.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      if (this.jdField_f_of_type_JavaLangString != null) {
        break label151;
      }
    }
    label151:
    for (String str = this.U;; str = this.jdField_f_of_type_JavaLangString)
    {
      localSendResult.jdField_c_of_type_JavaLangString = str;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.b(localSendResult);
      d(1003);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "onSuccess().");
      }
      return;
    }
  }
  
  public int f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "resume()  + mIsPause : " + this.jdField_d_of_type_Boolean);
    }
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = false;
      this.jdField_h_of_type_Boolean = false;
      d(1002);
      this.aI = 0;
      this.aH = 0;
      this.V = null;
      this.aG = 0;
      this.jdField_h_of_type_Long = 0L;
      this.aw = 0;
      this.L = "";
      this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a();
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.a.post(new eht(this));
    }
    return 0;
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "pause()");
    }
    super.i();
  }
  
  void r()
  {
    int i = 3;
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.ShortVideoUpReq localShortVideoUpReq = new RichProto.RichProtoReq.ShortVideoUpReq();
    localShortVideoUpReq.jdField_d_of_type_Int = ((int)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "sendGetUrlReq()----busiReq.seq : " + localShortVideoUpReq.jdField_d_of_type_Int);
    }
    localShortVideoUpReq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangString;
    localShortVideoUpReq.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString;
    localShortVideoUpReq.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    localShortVideoUpReq.i = 0;
    localShortVideoUpReq.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString;
    String str;
    if (localShortVideoUpReq.jdField_c_of_type_Int == 0)
    {
      localShortVideoUpReq.jdField_a_of_type_Int = 0;
      localShortVideoUpReq.jdField_b_of_type_Int = 2;
      Object localObject = new File(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h);
      str = ((File)localObject).getName();
      localShortVideoUpReq.jdField_a_of_type_JavaLangString = str;
      localShortVideoUpReq.jdField_a_of_type_Long = ((File)localObject).length();
      this.j = new File(this.Y).length();
      localShortVideoUpReq.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      localShortVideoUpReq.jdField_b_of_type_ArrayOfByte = this.jdField_b_of_type_ArrayOfByte;
      d(this.Y);
      localShortVideoUpReq.f = this.aO;
      localShortVideoUpReq.e = this.aP;
      localShortVideoUpReq.h = this.aQ;
      localShortVideoUpReq.jdField_b_of_type_Long = this.j;
      localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
      long l = localShortVideoUpReq.jdField_a_of_type_Long + this.j;
      this.jdField_a_of_type_Long = l;
      ((FileMsg)localObject).jdField_a_of_type_Long = l;
      str = str.substring(str.lastIndexOf(".") + 1);
      if (!"avi".equals(str)) {
        break label447;
      }
      i = 2;
    }
    for (;;)
    {
      label328:
      localShortVideoUpReq.g = i;
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
      localRichProtoReq.jdField_a_of_type_JavaLangString = "short_video_up";
      localRichProtoReq.jdField_a_of_type_JavaUtilList.add(localShortVideoUpReq);
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (!d())
      {
        a(9366, "illegal app", null, this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
      }
      label447:
      do
      {
        return;
        if (1 == localShortVideoUpReq.jdField_c_of_type_Int)
        {
          localShortVideoUpReq.jdField_a_of_type_Int = 1;
          break;
        }
        if (3000 == localShortVideoUpReq.jdField_c_of_type_Int)
        {
          localShortVideoUpReq.jdField_a_of_type_Int = 2;
          break;
        }
        localShortVideoUpReq.jdField_a_of_type_Int = 3;
        break;
        if ("mp4".equals(str)) {
          break label328;
        }
        if ("wmv".equals(str))
        {
          i = 4;
          break label328;
        }
        if ("mkv".equals(str))
        {
          i = 5;
          break label328;
        }
        if ("rmvb".equals(str))
        {
          i = 6;
          break label328;
        }
        if ("rm".equals(str))
        {
          i = 7;
          break label328;
        }
        if ("afs".equals(str))
        {
          i = 8;
          break label328;
        }
        if ("mov".equals(str))
        {
          i = 9;
          break label328;
        }
        if ("mod".equals(str))
        {
          i = 10;
          break label328;
        }
        if ("ts".equals(str))
        {
          i = 1;
          break label328;
        }
        if (!"mts".equals(str)) {
          break label675;
        }
        i = 11;
        break label328;
        if (QLog.isColorLevel())
        {
          a("requestStart", localRichProtoReq.toString());
          QLog.d("ShortVideoUploadProcessor", 2, "sendRequest()------richReq = " + localRichProtoReq.toString());
        }
      } while (!e());
      this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = localRichProtoReq;
      RichProtoProc.a(localRichProtoReq);
      return;
      label675:
      i = -1;
    }
  }
  
  void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "sendMsg() start.");
    }
    if (!e()) {}
    while (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    Object localObject2 = a();
    if (localObject2 == null)
    {
      a(9368, "constructpberror", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.a((im_msg_body.RichText)localObject2);
      if ((localObject1 != null) && ((localObject1 instanceof MessageForShortVideo))) {
        break label233;
      }
      localObject2 = new StringBuilder().append("Mr_");
      if (localObject1 != null) {
        break label206;
      }
    }
    label206:
    for (Object localObject1 = "null";; localObject1 = "" + ((MessageRecord)localObject1).msgtype)
    {
      a(9368, "msgtypeError", (String)localObject1, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        break;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
      break;
    }
    label233:
    if ((localObject1 instanceof MessageForShortVideo)) {
      ((MessageForShortVideo)localObject1).richText = ((im_msg_body.RichText)localObject2);
    }
    if (!d())
    {
      a(9366, "illegal app", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ShortVideoUploadProcessor
 * JD-Core Version:    0.7.0.1
 */