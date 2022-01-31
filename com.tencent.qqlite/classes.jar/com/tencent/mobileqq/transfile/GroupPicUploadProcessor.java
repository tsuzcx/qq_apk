package com.tencent.mobileqq.transfile;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PicUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PttUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.ReqCommon;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.GroupPicUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.GroupPttUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.voicechange.QQVoiceChangerThread;
import com.tencent.mobileqq.voicechange.QQVoiceChangerThread.CompressFinishListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import eih;
import eii;
import eij;
import eik;
import eil;
import ejc;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.ProxyIpManager;
import tencent.im.cs.ptt_reserve.ptt_reserve.ReserveStruct;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.Ptt;
import tencent.im.msg.im_msg_body.RichMsg;
import tencent.im.msg.im_msg_body.RichText;

public class GroupPicUploadProcessor
  extends BaseUploadProcessor
  implements QQVoiceChangerThread.CompressFinishListener
{
  public static final String W = "GroupPicUploadProcessor";
  public static final boolean o = true;
  private static final boolean r = true;
  String X;
  MessageObserver a;
  private SSCM b;
  long j;
  private long k = -1L;
  boolean l = false;
  boolean m = true;
  boolean n = false;
  private boolean p = false;
  private boolean q = false;
  
  public GroupPicUploadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    this.jdField_b_of_type_ComTencentWsttSSCMSSCM = new SSCM();
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new eil(this);
  }
  
  public static int a(String paramString)
  {
    if (paramString == null) {
      return 0;
    }
    byte[] arrayOfByte = new byte[4];
    try
    {
      paramString = paramString.split("\\.");
      arrayOfByte[0] = ((byte)(Integer.parseInt(paramString[0]) & 0xFF));
      arrayOfByte[1] = ((byte)(Integer.parseInt(paramString[1]) & 0xFF));
      arrayOfByte[2] = ((byte)(Integer.parseInt(paramString[2]) & 0xFF));
      arrayOfByte[3] = ((byte)(Integer.parseInt(paramString[3]) & 0xFF));
      int i = arrayOfByte[3];
      int i1 = arrayOfByte[2];
      int i2 = arrayOfByte[1];
      int i3 = arrayOfByte[0];
      return i3 << 24 & 0xFF000000 | i & 0xFF | i1 << 8 & 0xFF00 | i2 << 16 & 0xFF0000;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    MessageRecord localMessageRecord;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
    {
      localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if ((localMessageRecord != null) && (paramBoolean) && (this.n)) {
        break label72;
      }
    }
    label72:
    while ((!"251988669".equals(localMessageRecord.frienduin)) && (!"79151594".equals(localMessageRecord.frienduin)))
    {
      return;
      localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
      break;
    }
    PicReq localPicReq = PicBusiManager.a(1, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_Int);
    Object localObject = new PicUploadInfo.Builder();
    ((PicUploadInfo.Builder)localObject).d("51640996");
    if (this.jdField_e_of_type_Boolean)
    {
      i = 1;
      ((PicUploadInfo.Builder)localObject).c(i);
      if (!this.jdField_e_of_type_Boolean) {
        break label366;
      }
    }
    label366:
    for (int i = 2;; i = 0)
    {
      ((PicUploadInfo.Builder)localObject).i(i);
      ((PicUploadInfo.Builder)localObject).e(1000);
      ((PicUploadInfo.Builder)localObject).d(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_Int);
      ((PicUploadInfo.Builder)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h);
      if (("251988669".equals(localMessageRecord.frienduin)) || ("79151594".equals(localMessageRecord.frienduin))) {
        ((PicUploadInfo.Builder)localObject).e("4141988669");
      }
      localObject = ((PicUploadInfo.Builder)localObject).a();
      ((PicUploadInfo)localObject).jdField_b_of_type_Long = localMessageRecord.uniseq;
      ((PicUploadInfo)localObject).jdField_b_of_type_Boolean = false;
      localPicReq.a((PicUploadInfo)localObject);
      localObject = localMessageRecord.frienduin;
      i = (int)this.jdField_e_of_type_Long;
      int i1 = (int)this.g;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b.put(Long.valueOf(localMessageRecord.uniseq), new Object[] { paramString, localPicReq, localObject, Integer.valueOf(i), Integer.valueOf(i1) });
      if (QLog.isColorLevel()) {
        QLog.d("GroupPicUploadProcessor", 2, "HighSpeedTest");
      }
      new eii(this, localPicReq).execute(new Void[0]);
      return;
      i = 0;
      break;
    }
  }
  
  private void a(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append("/cgi-bin/httpconn?htcmd=0x6ff0071&ver=5468&term=android&ukey=");
    paramStringBuilder.append(this.V);
    paramStringBuilder.append("&filesize=");
    paramStringBuilder.append(this.jdField_a_of_type_Long);
    paramStringBuilder.append("&range=");
    paramStringBuilder.append(this.jdField_h_of_type_Long);
    paramStringBuilder.append("&uin=");
    paramStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangString);
    paramStringBuilder.append("&groupcode=");
    paramStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString);
  }
  
  private byte[] a(MessageForPtt paramMessageForPtt)
  {
    Object localObject = new ptt_reserve.ReserveStruct();
    ((ptt_reserve.ReserveStruct)localObject).uint32_change_voice.set(paramMessageForPtt.voiceChangeFlag);
    localObject = ((ptt_reserve.ReserveStruct)localObject).toByteArray();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("change flag is ");
      if (paramMessageForPtt != null) {
        break label69;
      }
    }
    label69:
    for (int i = -1;; i = paramMessageForPtt.voiceChangeFlag)
    {
      QLog.d("pttchangevoice", 2, i);
      return localObject;
    }
  }
  
  private void b(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append("/?ver=4679&ukey=");
    paramStringBuilder.append(this.V);
    paramStringBuilder.append("&filekey=");
    paramStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    paramStringBuilder.append("&filesize=");
    paramStringBuilder.append(this.jdField_a_of_type_Long);
    paramStringBuilder.append("&range=");
    paramStringBuilder.append(this.jdField_h_of_type_Long);
    paramStringBuilder.append("&bmd5=");
    paramStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    paramStringBuilder.append("&mType=");
    if (this.m)
    {
      paramStringBuilder.append("pttGu");
      return;
    }
    paramStringBuilder.append("pttDu");
  }
  
  private void d(boolean paramBoolean)
  {
    if (!paramBoolean) {
      d(1001);
    }
    d(1000);
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b();
    d(1001);
    if ((this.jdField_a_of_type_ArrayOfByte == null) && (!f()))
    {
      d();
      return;
    }
    if ((this.ap == 0) || (this.ao == 0))
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      localOptions.inSampleSize = 1;
      BitmapFactory.decodeFile(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h, localOptions);
      this.ap = localOptions.outHeight;
      this.ao = localOptions.outWidth;
    }
    if (this.jdField_a_of_type_JavaIoRandomAccessFile == null) {
      try
      {
        this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h, "r");
        if (this.jdField_a_of_type_JavaIoRandomAccessFile == null)
        {
          a(9303, "read file error");
          d();
          return;
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          localFileNotFoundException.printStackTrace();
          this.jdField_a_of_type_JavaIoRandomAccessFile = null;
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().preConnect();
    r();
  }
  
  private int h()
  {
    boolean bool2 = true;
    int i1 = 0;
    a("uiParam", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.toString());
    boolean bool1;
    String str;
    int i;
    if (1 == this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int)
    {
      bool1 = true;
      this.m = bool1;
      bool1 = bool2;
      if (2 == this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int) {
        bool1 = false;
      }
      this.n = bool1;
      str = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h;
      if (!TextUtils.isEmpty(str)) {
        break label108;
      }
      a(9302, a(new Exception("filePath null")));
      d();
      i = -1;
    }
    label108:
    do
    {
      do
      {
        return i;
        bool1 = false;
        break;
        File localFile = new File(str);
        if (!localFile.exists())
        {
          a(9042, a(new Exception("sendFile not exist " + str)));
          d();
          return -1;
        }
        if (!localFile.canRead())
        {
          a(9070, a(new Exception("sendFile not readable " + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_JavaLangString)));
          d();
          return -1;
        }
        long l1 = localFile.length();
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long = l1;
        this.jdField_a_of_type_Long = l1;
        if (l1 <= 0L)
        {
          a(9071, a(new Exception("file size 0 " + str)));
          d();
          return -1;
        }
        if (this.n)
        {
          str = FileUtils.a(str);
          if (!TextUtils.isEmpty(str))
          {
            if ((str.contains(FileUtils.jdField_b_of_type_JavaLangString)) || (!FileUtils.f(str)))
            {
              a(9072, str, a(str), null);
              d();
              new Handler(Looper.getMainLooper()).post(new eih(this));
              return -1;
            }
            this.jdField_e_of_type_JavaLangString = str;
          }
          if (l1 >= 19922944L)
          {
            a(9063, str, a(str), null);
            d();
            return -1;
          }
        }
        else
        {
          this.jdField_e_of_type_JavaLangString = "amr";
        }
        i = i1;
      } while (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject == null);
      i = i1;
    } while (!(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject instanceof TransferRequest.PicUpExtraInfo));
    this.jdField_e_of_type_Boolean = ((TransferRequest.PicUpExtraInfo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
    return 0;
  }
  
  protected long a(long paramLong)
  {
    paramLong = this.jdField_a_of_type_Long - paramLong;
    if (!this.l) {}
    for (paramLong = Math.min(paramLong, this.jdField_b_of_type_ComTencentWsttSSCMSSCM.a(BaseApplication.getContext(), this.jdField_a_of_type_Long, this.jdField_h_of_type_Long));; paramLong = Math.min(paramLong, 14600L)) {
      return Math.min(paramLong, 131072L);
    }
  }
  
  protected String a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new StringBuilder();
    Object localObject = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    paramArrayOfByte.append("http://");
    paramArrayOfByte.append(((ServerAddr)localObject).jdField_a_of_type_JavaLangString);
    if (((ServerAddr)localObject).jdField_b_of_type_Int != 80)
    {
      paramArrayOfByte.append(":");
      paramArrayOfByte.append(((ServerAddr)localObject).jdField_b_of_type_Int);
    }
    if (!this.n) {
      b(paramArrayOfByte);
    }
    for (;;)
    {
      if (!this.n)
      {
        localObject = (MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        paramArrayOfByte.append("&voice_codec=" + ((MessageForPtt)localObject).voiceType);
      }
      paramArrayOfByte = a(paramArrayOfByte.toString(), this.jdField_a_of_type_JavaUtilArrayList);
      BaseTransProcessor.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilArrayList);
      return paramArrayOfByte;
      a(paramArrayOfByte);
    }
  }
  
  /* Error */
  protected im_msg_body.RichText a()
  {
    // Byte code:
    //   0: new 532	tencent/im/msg/im_msg_body$Ptt
    //   3: dup
    //   4: invokespecial 533	tencent/im/msg/im_msg_body$Ptt:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: getfield 536	tencent/im/msg/im_msg_body$Ptt:uint32_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12: iconst_4
    //   13: invokevirtual 279	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   16: aload_3
    //   17: getfield 540	tencent/im/msg/im_msg_body$Ptt:uint64_src_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   20: aload_0
    //   21: getfield 87	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   24: getfield 259	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   27: invokestatic 544	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   30: invokevirtual 549	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   33: aload_3
    //   34: getfield 552	tencent/im/msg/im_msg_body$Ptt:uint32_file_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   37: aload_0
    //   38: getfield 554	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_j_of_type_Long	J
    //   41: l2i
    //   42: invokevirtual 279	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   45: aload_0
    //   46: getfield 556	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:X	Ljava/lang/String;
    //   49: astore_2
    //   50: aload_2
    //   51: ifnull +23 -> 74
    //   54: aload_3
    //   55: getfield 560	tencent/im/msg/im_msg_body$Ptt:bytes_group_file_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   58: aload_0
    //   59: getfield 556	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:X	Ljava/lang/String;
    //   62: ldc_w 562
    //   65: invokevirtual 566	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   68: invokestatic 572	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   71: invokevirtual 577	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   74: aload_0
    //   75: getfield 493	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   78: ifnull +50 -> 128
    //   81: aload_0
    //   82: getfield 493	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   85: invokevirtual 580	java/util/ArrayList:size	()I
    //   88: ifle +40 -> 128
    //   91: aload_0
    //   92: getfield 493	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   95: iconst_0
    //   96: invokevirtual 499	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   99: checkcast 501	com/tencent/mobileqq/transfile/ServerAddr
    //   102: astore_2
    //   103: aload_3
    //   104: getfield 583	tencent/im/msg/im_msg_body$Ptt:uint32_server_ip	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   107: aload_2
    //   108: getfield 504	com/tencent/mobileqq/transfile/ServerAddr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   111: invokestatic 585	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Ljava/lang/String;)I
    //   114: invokevirtual 279	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   117: aload_3
    //   118: getfield 588	tencent/im/msg/im_msg_body$Ptt:uint32_server_port	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   121: aload_2
    //   122: getfield 505	com/tencent/mobileqq/transfile/ServerAddr:jdField_b_of_type_Int	I
    //   125: invokevirtual 279	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   128: aload_0
    //   129: getfield 95	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   132: aload_0
    //   133: getfield 95	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   136: invokevirtual 590	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   139: invokestatic 595	com/tencent/mobileqq/service/message/MessageUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)I
    //   142: istore_1
    //   143: new 597	tencent/im/msg/im_msg_body$Elem
    //   146: dup
    //   147: invokespecial 598	tencent/im/msg/im_msg_body$Elem:<init>	()V
    //   150: astore 4
    //   152: new 600	tencent/im/msg/im_msg_body$ElemFlags2
    //   155: dup
    //   156: invokespecial 601	tencent/im/msg/im_msg_body$ElemFlags2:<init>	()V
    //   159: astore_2
    //   160: aload_2
    //   161: getfield 604	tencent/im/msg/im_msg_body$ElemFlags2:uint32_vip_status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   164: iload_1
    //   165: invokevirtual 279	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   168: aload 4
    //   170: getfield 608	tencent/im/msg/im_msg_body$Elem:elem_flags2	Ltencent/im/msg/im_msg_body$ElemFlags2;
    //   173: aload_2
    //   174: invokevirtual 611	tencent/im/msg/im_msg_body$ElemFlags2:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   177: aload_3
    //   178: getfield 615	tencent/im/msg/im_msg_body$Ptt:bool_valid	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   181: iconst_1
    //   182: invokevirtual 619	com/tencent/mobileqq/pb/PBBoolField:set	(Z)V
    //   185: aload_3
    //   186: getfield 622	tencent/im/msg/im_msg_body$Ptt:uint32_file_size	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   189: aload_0
    //   190: getfield 248	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_Long	J
    //   193: l2i
    //   194: invokevirtual 279	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   197: aload_3
    //   198: getfield 625	tencent/im/msg/im_msg_body$Ptt:bytes_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   201: aload_0
    //   202: getfield 323	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   205: invokestatic 572	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   208: invokevirtual 577	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   211: aload_3
    //   212: getfield 628	tencent/im/msg/im_msg_body$Ptt:bytes_file_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   215: aload_0
    //   216: getfield 630	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   219: invokestatic 634	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   222: invokevirtual 577	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   225: aload_0
    //   226: aload_0
    //   227: getfield 87	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   230: getfield 92	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   233: checkcast 271	com/tencent/mobileqq/data/MessageForPtt
    //   236: invokespecial 636	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Lcom/tencent/mobileqq/data/MessageForPtt;)[B
    //   239: astore_2
    //   240: aload_2
    //   241: ifnull +14 -> 255
    //   244: aload_3
    //   245: getfield 639	tencent/im/msg/im_msg_body$Ptt:bytes_pb_reserve	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   248: aload_2
    //   249: invokestatic 572	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   252: invokevirtual 577	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   255: new 641	tencent/im/msg/im_msg_body$RichText
    //   258: dup
    //   259: invokespecial 642	tencent/im/msg/im_msg_body$RichText:<init>	()V
    //   262: astore_2
    //   263: aload_2
    //   264: getfield 646	tencent/im/msg/im_msg_body$RichText:ptt	Ltencent/im/msg/im_msg_body$Ptt;
    //   267: aload_3
    //   268: invokevirtual 647	tencent/im/msg/im_msg_body$Ptt:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   271: aload_2
    //   272: getfield 651	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   275: aload 4
    //   277: invokevirtual 656	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   280: aload_2
    //   281: areturn
    //   282: astore_3
    //   283: aconst_null
    //   284: astore_2
    //   285: invokestatic 217	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   288: ifeq -8 -> 280
    //   291: ldc 10
    //   293: iconst_2
    //   294: ldc_w 658
    //   297: aload_3
    //   298: invokestatic 661	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   301: aconst_null
    //   302: areturn
    //   303: astore_2
    //   304: goto -230 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	307	0	this	GroupPicUploadProcessor
    //   142	23	1	i	int
    //   49	236	2	localObject	Object
    //   303	1	2	localUnsupportedEncodingException	UnsupportedEncodingException
    //   7	261	3	localPtt	im_msg_body.Ptt
    //   282	16	3	localException	Exception
    //   150	126	4	localElem	im_msg_body.Elem
    // Exception table:
    //   from	to	target	type
    //   0	50	282	java/lang/Exception
    //   54	74	282	java/lang/Exception
    //   74	128	282	java/lang/Exception
    //   128	240	282	java/lang/Exception
    //   244	255	282	java/lang/Exception
    //   255	280	282	java/lang/Exception
    //   54	74	303	java/io/UnsupportedEncodingException
  }
  
  public void a()
  {
    super.a();
    if ((!this.n) && (!this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g))
    {
      if (QQVoiceChangerThread.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h, this)) {
        try
        {
          if (this.q)
          {
            d(1001);
            this.q = true;
          }
          return;
        }
        finally {}
      }
      if (h() == 0) {
        d(false);
      }
    }
    else
    {
      d(false);
    }
  }
  
  /* Error */
  public void a(NetResp paramNetResp)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 677	com/tencent/mobileqq/transfile/BaseUploadProcessor:a	(Lcom/tencent/mobileqq/transfile/NetResp;)V
    //   5: aload_0
    //   6: getfield 679	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_h_of_type_Boolean	Z
    //   9: ifne +10 -> 19
    //   12: aload_0
    //   13: getfield 681	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_d_of_type_Boolean	Z
    //   16: ifeq +4 -> 20
    //   19: return
    //   20: aload_0
    //   21: aconst_null
    //   22: putfield 684	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   25: aload_1
    //   26: getfield 688	com/tencent/mobileqq/transfile/NetResp:f	I
    //   29: istore_2
    //   30: aload_0
    //   31: ldc_w 690
    //   34: new 238	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   41: ldc_w 692
    //   44: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_1
    //   48: getfield 693	com/tencent/mobileqq/transfile/NetResp:jdField_d_of_type_Int	I
    //   51: invokevirtual 291	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   54: ldc_w 695
    //   57: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: aload_1
    //   61: getfield 697	com/tencent/mobileqq/transfile/NetResp:e	I
    //   64: invokevirtual 291	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   67: ldc_w 699
    //   70: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_1
    //   74: getfield 700	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   77: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokevirtual 386	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: aload_1
    //   87: getfield 693	com/tencent/mobileqq/transfile/NetResp:jdField_d_of_type_Int	I
    //   90: ifne +527 -> 617
    //   93: aload_0
    //   94: iconst_0
    //   95: putfield 703	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:ay	I
    //   98: aload_0
    //   99: getfield 38	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_b_of_type_ComTencentWsttSSCMSSCM	Lcom/tencent/wstt/SSCM/SSCM;
    //   102: invokevirtual 704	com/tencent/wstt/SSCM/SSCM:b	()V
    //   105: aload_1
    //   106: getfield 707	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   109: ldc_w 709
    //   112: invokevirtual 714	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   115: ifnull +614 -> 729
    //   118: aload_1
    //   119: getfield 707	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   122: ldc_w 709
    //   125: invokevirtual 714	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   128: checkcast 67	java/lang/String
    //   131: invokestatic 544	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   134: lstore 7
    //   136: lload 7
    //   138: lconst_0
    //   139: lcmp
    //   140: ifeq +87 -> 227
    //   143: lload 7
    //   145: ldc2_w 715
    //   148: lcmp
    //   149: ifeq +78 -> 227
    //   152: aload_0
    //   153: aload_0
    //   154: getfield 719	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   157: aload_1
    //   158: iconst_0
    //   159: invokevirtual 722	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;Lcom/tencent/mobileqq/transfile/NetResp;Z)V
    //   162: lload 7
    //   164: l2i
    //   165: invokestatic 727	com/tencent/mobileqq/transfile/protohandler/GroupPicUpHandler:a	(I)Z
    //   168: ifne +59 -> 227
    //   171: aload_0
    //   172: sipush -9527
    //   175: aconst_null
    //   176: iload_2
    //   177: lload 7
    //   179: invokestatic 730	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:b	(IJ)Ljava/lang/String;
    //   182: aload_0
    //   183: getfield 719	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   186: invokevirtual 439	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;)V
    //   189: aload_0
    //   190: invokevirtual 328	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:d	()V
    //   193: return
    //   194: astore_1
    //   195: aload_0
    //   196: sipush 9343
    //   199: new 63	java/lang/Exception
    //   202: dup
    //   203: ldc_w 732
    //   206: invokespecial 398	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   209: invokestatic 735	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Exception;)Ljava/lang/String;
    //   212: ldc_w 737
    //   215: aload_0
    //   216: getfield 719	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   219: invokevirtual 439	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;)V
    //   222: aload_0
    //   223: invokevirtual 328	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:d	()V
    //   226: return
    //   227: aload_1
    //   228: getfield 707	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   231: ldc_w 739
    //   234: invokevirtual 714	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   237: astore 9
    //   239: aload 9
    //   241: ifnull +496 -> 737
    //   244: aload_1
    //   245: getfield 707	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   248: ldc_w 739
    //   251: invokevirtual 714	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   254: checkcast 67	java/lang/String
    //   257: invokestatic 76	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   260: istore_2
    //   261: iload_2
    //   262: i2l
    //   263: lstore_3
    //   264: lload_3
    //   265: lstore 5
    //   267: lload_3
    //   268: ldc2_w 715
    //   271: lcmp
    //   272: ifne +44 -> 316
    //   275: aload_1
    //   276: getfield 707	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   279: ldc_w 741
    //   282: invokevirtual 714	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   285: astore 9
    //   287: lload_3
    //   288: lstore 5
    //   290: aload 9
    //   292: ifnull +24 -> 316
    //   295: aload_1
    //   296: getfield 707	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   299: ldc_w 741
    //   302: invokevirtual 714	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   305: checkcast 67	java/lang/String
    //   308: invokestatic 76	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   311: istore_2
    //   312: iload_2
    //   313: i2l
    //   314: lstore 5
    //   316: lload 5
    //   318: ldc2_w 715
    //   321: lcmp
    //   322: ifne +69 -> 391
    //   325: aload_0
    //   326: aload_0
    //   327: getfield 719	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   330: aload_1
    //   331: iconst_0
    //   332: invokevirtual 722	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;Lcom/tencent/mobileqq/transfile/NetResp;Z)V
    //   335: aload_0
    //   336: sipush -9527
    //   339: ldc_w 743
    //   342: aload_0
    //   343: getfield 746	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:K	Ljava/lang/String;
    //   346: aload_0
    //   347: getfield 749	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:at	I
    //   350: i2l
    //   351: invokestatic 752	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Ljava/lang/String;J)Ljava/lang/String;
    //   354: aload_0
    //   355: getfield 719	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   358: invokevirtual 439	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;)V
    //   361: aload_0
    //   362: invokevirtual 328	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:d	()V
    //   365: return
    //   366: astore 9
    //   368: aload 9
    //   370: invokevirtual 82	java/lang/Exception:printStackTrace	()V
    //   373: goto +364 -> 737
    //   376: astore 9
    //   378: aload 9
    //   380: invokevirtual 82	java/lang/Exception:printStackTrace	()V
    //   383: ldc2_w 715
    //   386: lstore 5
    //   388: goto -72 -> 316
    //   391: aload_0
    //   392: ldc_w 754
    //   395: new 238	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   402: ldc_w 756
    //   405: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: aload_0
    //   409: getfield 255	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_h_of_type_Long	J
    //   412: invokevirtual 251	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   415: ldc_w 758
    //   418: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: lload 5
    //   423: invokevirtual 251	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   426: ldc_w 760
    //   429: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: lload 7
    //   434: invokevirtual 251	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   437: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   440: invokevirtual 386	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   443: lload 5
    //   445: aload_0
    //   446: getfield 255	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_h_of_type_Long	J
    //   449: lcmp
    //   450: ifgt +31 -> 481
    //   453: aload_0
    //   454: getfield 763	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:aI	I
    //   457: iconst_3
    //   458: if_icmpge +74 -> 532
    //   461: aload_0
    //   462: ldc_w 765
    //   465: ldc_w 767
    //   468: invokevirtual 386	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   471: aload_0
    //   472: aload_0
    //   473: getfield 763	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:aI	I
    //   476: iconst_1
    //   477: iadd
    //   478: putfield 763	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:aI	I
    //   481: aload_0
    //   482: getfield 316	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   485: lload 5
    //   487: putfield 768	com/tencent/mobileqq/transfile/FileMsg:jdField_e_of_type_Long	J
    //   490: aload_0
    //   491: lload 5
    //   493: putfield 255	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_h_of_type_Long	J
    //   496: aload_0
    //   497: aload_0
    //   498: getfield 719	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   501: aload_1
    //   502: iconst_1
    //   503: invokevirtual 722	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;Lcom/tencent/mobileqq/transfile/NetResp;Z)V
    //   506: lload 5
    //   508: aload_0
    //   509: getfield 248	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_Long	J
    //   512: lcmp
    //   513: ifge +92 -> 605
    //   516: aload_0
    //   517: getfield 679	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_h_of_type_Boolean	Z
    //   520: ifne -501 -> 19
    //   523: aload_0
    //   524: invokevirtual 770	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:f	()V
    //   527: aload_0
    //   528: invokevirtual 773	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:s	()V
    //   531: return
    //   532: aload_0
    //   533: aload_0
    //   534: getfield 719	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   537: aload_1
    //   538: iconst_0
    //   539: invokevirtual 722	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;Lcom/tencent/mobileqq/transfile/NetResp;Z)V
    //   542: aload_0
    //   543: getfield 774	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   546: ldc_w 776
    //   549: new 238	java/lang/StringBuilder
    //   552: dup
    //   553: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   556: ldc_w 737
    //   559: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: lload 7
    //   564: invokevirtual 251	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   567: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   570: invokevirtual 777	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   573: pop
    //   574: aload_0
    //   575: sipush -9527
    //   578: ldc_w 737
    //   581: aload_0
    //   582: getfield 746	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:K	Ljava/lang/String;
    //   585: aload_0
    //   586: getfield 780	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:as	I
    //   589: i2l
    //   590: invokestatic 752	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Ljava/lang/String;J)Ljava/lang/String;
    //   593: aload_0
    //   594: getfield 719	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   597: invokevirtual 439	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;)V
    //   600: aload_0
    //   601: invokevirtual 328	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:d	()V
    //   604: return
    //   605: aload_0
    //   606: invokevirtual 783	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:t	()V
    //   609: aload_0
    //   610: getfield 316	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   613: invokevirtual 320	com/tencent/mobileqq/transfile/FileMsg:b	()V
    //   616: return
    //   617: aload_1
    //   618: getfield 697	com/tencent/mobileqq/transfile/NetResp:e	I
    //   621: sipush 9364
    //   624: if_icmpne +40 -> 664
    //   627: aload_0
    //   628: getfield 703	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:ay	I
    //   631: iconst_3
    //   632: if_icmpge +32 -> 664
    //   635: aload_0
    //   636: ldc_w 785
    //   639: ldc_w 787
    //   642: invokevirtual 386	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   645: aload_0
    //   646: aload_0
    //   647: getfield 703	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:ay	I
    //   650: iconst_1
    //   651: iadd
    //   652: putfield 703	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:ay	I
    //   655: aload_0
    //   656: invokevirtual 789	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:o	()V
    //   659: aload_0
    //   660: invokevirtual 380	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:r	()V
    //   663: return
    //   664: aload_1
    //   665: getfield 790	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   668: getfield 793	com/tencent/mobileqq/transfile/NetReq:jdField_a_of_type_ArrayOfByte	[B
    //   671: arraylength
    //   672: ldc_w 794
    //   675: if_icmplt +27 -> 702
    //   678: aload_1
    //   679: getfield 697	com/tencent/mobileqq/transfile/NetResp:e	I
    //   682: invokestatic 797	com/tencent/mobileqq/transfile/RichMediaStrategy:a	(I)Z
    //   685: ifeq +17 -> 702
    //   688: aload_0
    //   689: iconst_1
    //   690: putfield 42	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:l	Z
    //   693: aload_0
    //   694: invokevirtual 789	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:o	()V
    //   697: aload_0
    //   698: invokevirtual 773	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:s	()V
    //   701: return
    //   702: aload_0
    //   703: aload_0
    //   704: getfield 719	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   707: aload_1
    //   708: iconst_0
    //   709: invokevirtual 722	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;Lcom/tencent/mobileqq/transfile/NetResp;Z)V
    //   712: aload_0
    //   713: aload_1
    //   714: getfield 697	com/tencent/mobileqq/transfile/NetResp:e	I
    //   717: aload_1
    //   718: getfield 700	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   721: invokevirtual 369	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:a	(ILjava/lang/String;)V
    //   724: aload_0
    //   725: invokevirtual 328	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:d	()V
    //   728: return
    //   729: ldc2_w 715
    //   732: lstore 7
    //   734: goto -598 -> 136
    //   737: ldc2_w 715
    //   740: lstore_3
    //   741: goto -477 -> 264
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	744	0	this	GroupPicUploadProcessor
    //   0	744	1	paramNetResp	NetResp
    //   29	284	2	i	int
    //   263	478	3	l1	long
    //   265	242	5	l2	long
    //   134	599	7	l3	long
    //   237	54	9	localObject	Object
    //   366	3	9	localException1	Exception
    //   376	3	9	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   86	136	194	java/lang/Exception
    //   152	193	194	java/lang/Exception
    //   227	239	194	java/lang/Exception
    //   275	287	194	java/lang/Exception
    //   325	365	194	java/lang/Exception
    //   368	373	194	java/lang/Exception
    //   378	383	194	java/lang/Exception
    //   391	481	194	java/lang/Exception
    //   481	531	194	java/lang/Exception
    //   532	604	194	java/lang/Exception
    //   605	616	194	java/lang/Exception
    //   617	663	194	java/lang/Exception
    //   664	701	194	java/lang/Exception
    //   702	728	194	java/lang/Exception
    //   244	261	366	java/lang/Exception
    //   295	312	376	java/lang/Exception
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
    boolean bool;
    if (paramRichProtoResp != null)
    {
      int i = 0;
      if (i < paramRichProtoResp.jdField_a_of_type_JavaUtilList.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.RespCommon)paramRichProtoResp.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          a("procUrl", paramRichProtoReq.toString());
        }
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramRichProtoReq);
        if (!(paramRichProtoReq instanceof RichProto.RichProtoResp.GroupPicUpResp)) {
          break label506;
        }
        if (!this.p)
        {
          this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3)).getProxyIp(3);
          this.p = true;
        }
        paramRichProtoReq = (RichProto.RichProtoResp.GroupPicUpResp)paramRichProtoReq;
        if (paramRichProtoReq.jdField_c_of_type_Int == 0)
        {
          if (paramRichProtoReq.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long;
            this.jdField_j_of_type_Long = paramRichProtoReq.jdField_a_of_type_Long;
            this.jdField_a_of_type_JavaUtilArrayList = paramRichProtoReq.jdField_a_of_type_JavaUtilArrayList;
            t();
          }
          for (;;)
          {
            i += 1;
            break;
            this.jdField_j_of_type_Long = paramRichProtoReq.jdField_a_of_type_Long;
            this.V = paramRichProtoReq.jdField_a_of_type_JavaLangString;
            this.jdField_a_of_type_JavaUtilArrayList = paramRichProtoReq.jdField_a_of_type_JavaUtilArrayList;
            this.jdField_h_of_type_Long = paramRichProtoReq.jdField_b_of_type_Int;
            this.i = paramRichProtoReq.jdField_a_of_type_Int;
            this.jdField_b_of_type_Long = paramRichProtoReq.jdField_b_of_type_Long;
            bool = paramRichProtoReq.jdField_c_of_type_Boolean;
            if ((paramRichProtoReq.jdField_a_of_type_Int != 0) && (this.jdField_j_of_type_Boolean) && (!paramRichProtoReq.jdField_b_of_type_Boolean)) {
              this.jdField_b_of_type_ComTencentWsttSSCMSSCM.a(paramRichProtoReq.jdField_a_of_type_Int);
            }
            if (this.aM != 2) {
              break label274;
            }
            c("<BDH_LOG> onBusiProtoResp() last status is HTTP and resume by start");
            s();
          }
          label274:
          if (this.aM == 0)
          {
            c("<BDH_LOG> onBusiProtoResp() start normally, selecting channel...");
            if (!bool) {
              c("<BDH_LOG> onBusiProtoResp() Server's isUseBdh = false");
            }
          }
        }
      }
    }
    label652:
    label737:
    for (;;)
    {
      for (;;)
      {
        if (bool)
        {
          c("<BDH_LOG> onBusiProtoResp() select BDH channel");
          this.aM = 1;
          c();
          break;
          if (!NetworkUtil.c(BaseApplication.getContext())) {
            break label737;
          }
          paramRichProtoReq = NetworkUtil.a(BaseApplication.getContext());
          if ((paramRichProtoReq == null) || ((!paramRichProtoReq.equalsIgnoreCase("cmwap")) && (!paramRichProtoReq.equalsIgnoreCase("ctwap")))) {
            break label737;
          }
          c("<BDH_LOG> onBusiProtoResp() APN=" + paramRichProtoReq);
          bool = false;
          continue;
        }
        c("<BDH_LOG> onBusiProtoResp() select HTTP channel");
        this.aM = 2;
        s();
        break;
        StringBuilder localStringBuilder = new StringBuilder().append("<BDH_LOG> onBusiProtoResp() CANNOT start BDH or HTTP channel. current status is not INIT, is");
        if (this.aM == 1) {}
        for (paramRichProtoReq = "BDH";; paramRichProtoReq = "HTTP")
        {
          c(paramRichProtoReq);
          break;
        }
        c("<BDH_LOG> onBusiProtoResp() error : " + paramRichProtoReq.jdField_c_of_type_Int + " ,select HTTP channel");
        this.aM = 2;
        d();
        return;
        label506:
        if (!(paramRichProtoReq instanceof RichProto.RichProtoResp.GroupPttUpResp)) {
          break;
        }
        if (!this.p)
        {
          this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3)).getProxyIp(4);
          this.p = true;
        }
        paramRichProtoReq = (RichProto.RichProtoResp.GroupPttUpResp)paramRichProtoReq;
        if (paramRichProtoReq.jdField_c_of_type_Int == 0) {
          if (paramRichProtoReq.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long;
            this.jdField_j_of_type_Long = paramRichProtoReq.jdField_a_of_type_Long;
            if (paramRichProtoReq.jdField_a_of_type_ArrayOfByte == null) {}
          }
        }
        try
        {
          for (;;)
          {
            this.X = new String(paramRichProtoReq.jdField_a_of_type_ArrayOfByte, "utf-8");
            label612:
            t();
            break;
            this.jdField_j_of_type_Long = paramRichProtoReq.jdField_a_of_type_Long;
            if (paramRichProtoReq.jdField_a_of_type_ArrayOfByte != null) {}
            try
            {
              this.X = new String(paramRichProtoReq.jdField_a_of_type_ArrayOfByte, "utf-8");
              this.V = paramRichProtoReq.jdField_a_of_type_JavaLangString;
              this.jdField_a_of_type_JavaUtilArrayList = paramRichProtoReq.jdField_a_of_type_JavaUtilArrayList;
              this.jdField_h_of_type_Long = paramRichProtoReq.jdField_b_of_type_Int;
              this.i = paramRichProtoReq.jdField_a_of_type_Int;
              a("OnProtoResp", " TryUpload response GrpFileKey:" + this.X);
              s();
              break;
              d();
              return;
            }
            catch (UnsupportedEncodingException localUnsupportedEncodingException)
            {
              break label652;
            }
          }
        }
        catch (UnsupportedEncodingException paramRichProtoReq)
        {
          break label612;
        }
      }
    }
  }
  
  /* Error */
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 87	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   6: iconst_1
    //   7: putfield 665	com/tencent/mobileqq/transfile/TransferRequest:g	Z
    //   10: aload_0
    //   11: getfield 87	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   14: getfield 92	com/tencent/mobileqq/transfile/TransferRequest:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   17: checkcast 271	com/tencent/mobileqq/data/MessageForPtt
    //   20: astore_1
    //   21: aload_1
    //   22: iload_3
    //   23: putfield 914	com/tencent/mobileqq/data/MessageForPtt:voiceLength	I
    //   26: aload_1
    //   27: iload_2
    //   28: putfield 514	com/tencent/mobileqq/data/MessageForPtt:voiceType	I
    //   31: aload_0
    //   32: getfield 48	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:q	Z
    //   35: ifne +18 -> 53
    //   38: aload_0
    //   39: invokespecial 672	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:h	()I
    //   42: ifne +8 -> 50
    //   45: aload_0
    //   46: iconst_0
    //   47: invokespecial 674	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:d	(Z)V
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: aload_0
    //   54: invokespecial 672	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:h	()I
    //   57: ifne -7 -> 50
    //   60: aload_0
    //   61: iconst_1
    //   62: invokespecial 674	com/tencent/mobileqq/transfile/GroupPicUploadProcessor:d	(Z)V
    //   65: goto -15 -> 50
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	GroupPicUploadProcessor
    //   0	73	1	paramString	String
    //   0	73	2	paramInt1	int
    //   0	73	3	paramInt2	int
    // Exception table:
    //   from	to	target	type
    //   2	50	68	finally
    //   50	52	68	finally
    //   53	65	68	finally
    //   69	71	68	finally
  }
  
  public void a(boolean paramBoolean)
  {
    MessageRecord localMessageRecord;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
    {
      localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if (localMessageRecord != null) {
        break label78;
      }
      a("updateDb", "msg null");
    }
    label78:
    Object localObject;
    StructMsgItemImage localStructMsgItemImage;
    do
    {
      do
      {
        do
        {
          return;
          localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
          a("updateDb", "findmsgbyMsgId,need fix");
          break;
          if (localMessageRecord.isMultiMsg)
          {
            a("updateDb", "is multiMsg");
            return;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 2) && ((localMessageRecord instanceof MessageForPtt)))
          {
            localObject = (MessageForPtt)localMessageRecord;
            ((MessageForPtt)localObject).url = MessageForPtt.getMsgFilePath(((MessageForPtt)localObject).voiceType, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h);
            ((MessageForPtt)localObject).fileSize = this.jdField_a_of_type_Long;
            ((MessageForPtt)localObject).urlAtServer = this.jdField_d_of_type_JavaLangString;
            ((MessageForPtt)localObject).itemType = 2;
            ((MessageForPtt)localObject).groupFileID = this.jdField_j_of_type_Long;
            ((MessageForPtt)localObject).groupFileKeyStr = this.X;
            ((MessageForPtt)localObject).md5 = this.jdField_c_of_type_JavaLangString;
            ((MessageForPtt)localObject).serial();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, localMessageRecord.uniseq, ((MessageForPtt)localObject).msgData);
            return;
          }
          if ((localMessageRecord instanceof MessageForPic))
          {
            localObject = (MessageForPic)localMessageRecord;
            ((MessageForPic)localObject).path = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h;
            ((MessageForPic)localObject).size = this.jdField_a_of_type_Long;
            ((MessageForPic)localObject).uuid = this.jdField_d_of_type_JavaLangString;
            ((MessageForPic)localObject).groupFileID = this.jdField_j_of_type_Long;
            ((MessageForPic)localObject).md5 = this.jdField_c_of_type_JavaLangString;
            ((MessageForPic)localObject).type = 1;
            ((MessageForPic)localObject).serial();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, localMessageRecord.uniseq, ((MessageForPic)localObject).msgData);
            return;
          }
        } while (!(localMessageRecord instanceof MessageForStructing));
        localObject = (MessageForStructing)localMessageRecord;
      } while ((((MessageForStructing)localObject).structingMsg == null) || (!(((MessageForStructing)localObject).structingMsg instanceof StructMsgForImageShare)));
      localStructMsgItemImage = ((StructMsgForImageShare)((MessageForStructing)localObject).structingMsg).getFirstImageElement();
    } while (localStructMsgItemImage == null);
    localStructMsgItemImage.j = this.jdField_c_of_type_JavaLangString;
    localStructMsgItemImage.i = this.jdField_d_of_type_JavaLangString;
    localStructMsgItemImage.jdField_c_of_type_Long = this.jdField_a_of_type_Long;
    localStructMsgItemImage.jdField_b_of_type_Long = this.jdField_j_of_type_Long;
    localStructMsgItemImage.jdField_d_of_type_Long = localMessageRecord.time;
    ((MessageForStructing)localObject).msgData = ((MessageForStructing)localObject).structingMsg.getBytes();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, localMessageRecord.uniseq, ((MessageForStructing)localObject).msgData);
  }
  
  protected im_msg_body.RichText b()
  {
    label780:
    label782:
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject2 = new im_msg_body.CustomFace();
        ((im_msg_body.CustomFace)localObject2).uint32_file_id.set((int)this.jdField_j_of_type_Long);
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          localObject1 = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          ((im_msg_body.CustomFace)localObject2).uint32_server_ip.set(a(((ServerAddr)localObject1).jdField_a_of_type_JavaLangString));
          ((im_msg_body.CustomFace)localObject2).uint32_server_port.set(((ServerAddr)localObject1).jdField_b_of_type_Int);
        }
        ((im_msg_body.CustomFace)localObject2).uint32_file_type.set(Integer.valueOf(66).intValue());
        ((im_msg_body.CustomFace)localObject2).uint32_useful.set(1);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() != null) {
          ((im_msg_body.CustomFace)localObject2).bytes_signature.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()));
        }
        ((im_msg_body.CustomFace)localObject2).bytes_md5.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ArrayOfByte));
        ((im_msg_body.CustomFace)localObject2).str_file_path.set(this.jdField_d_of_type_JavaLangString);
        Object localObject1 = ((im_msg_body.CustomFace)localObject2).uint32_origin;
        if (!this.jdField_e_of_type_Boolean) {
          break label782;
        }
        i = 1;
        ((PBUInt32Field)localObject1).set(i);
        i = 200;
        switch (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_Int)
        {
        case 1005: 
          ((im_msg_body.CustomFace)localObject2).uint32_width.set(this.ao);
          ((im_msg_body.CustomFace)localObject2).uint32_height.set(this.ap);
          ((im_msg_body.CustomFace)localObject2).uint32_size.set((int)this.jdField_a_of_type_Long);
          ((im_msg_body.CustomFace)localObject2).uint32_source.set(i);
          if (!"jpg".equals(this.jdField_e_of_type_JavaLangString)) {
            break label718;
          }
          ((im_msg_body.CustomFace)localObject2).image_type.set(0);
          if (QLog.isColorLevel()) {
            a("busiTypeStat", "uiBusiType:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_Int + " protoBusiType:" + ((im_msg_body.CustomFace)localObject2).biz_type.get());
          }
          localObject1 = new im_msg_body.RichText();
          Object localObject3 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject3).custom_face.set((MessageMicro)localObject2);
          ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject3);
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
          if (!(localObject3 instanceof MessageForStructing)) {
            break label780;
          }
          localObject2 = (MessageForStructing)localObject3;
          if ((((MessageForStructing)localObject2).structingMsg == null) || (!(((MessageForStructing)localObject2).structingMsg instanceof StructMsgForImageShare))) {
            break label780;
          }
          StructMsgItemImage localStructMsgItemImage = ((StructMsgForImageShare)((MessageForStructing)localObject2).structingMsg).getFirstImageElement();
          if (localStructMsgItemImage == null) {
            break label780;
          }
          localStructMsgItemImage.j = this.jdField_c_of_type_JavaLangString;
          localStructMsgItemImage.i = this.jdField_d_of_type_JavaLangString;
          localStructMsgItemImage.jdField_b_of_type_Long = this.jdField_j_of_type_Long;
          localStructMsgItemImage.jdField_d_of_type_Long = ((MessageRecord)localObject3).time;
          localStructMsgItemImage.jdField_c_of_type_Long = this.jdField_a_of_type_Long;
          localObject3 = ((MessageForStructing)localObject2).structingMsg.getXmlBytes();
          if ((TextUtils.isEmpty(((MessageForStructing)localObject2).frienduin)) || (localObject3 == null)) {
            break label780;
          }
          localObject2 = new im_msg_body.RichMsg();
          ((im_msg_body.RichMsg)localObject2).bytes_template_1.set(ByteStringMicro.copyFrom((byte[])localObject3));
          localObject3 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject3).rich_msg.set((MessageMicro)localObject2);
          ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject3);
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("GroupPicUploadProcessor", 2, "Construct richtext error", localException);
        localException.printStackTrace();
        return null;
      }
      ((im_msg_body.CustomFace)localObject2).biz_type.set(1);
      int i = 102;
      continue;
      ((im_msg_body.CustomFace)localObject2).biz_type.set(2);
      i = 105;
      continue;
      ((im_msg_body.CustomFace)localObject2).biz_type.set(3);
      i = 101;
      continue;
      ((im_msg_body.CustomFace)localObject2).biz_type.set(4);
      i = 104;
      continue;
      ((im_msg_body.CustomFace)localObject2).biz_type.set(5);
      i = 103;
      continue;
      ((im_msg_body.CustomFace)localObject2).biz_type.set(6);
      i = 106;
      continue;
      ((im_msg_body.CustomFace)localObject2).biz_type.set(7);
      continue;
      label718:
      if ("bmp".equals(this.jdField_e_of_type_JavaLangString))
      {
        ((im_msg_body.CustomFace)localObject2).image_type.set(3);
      }
      else if ("gif".equals(this.jdField_e_of_type_JavaLangString))
      {
        ((im_msg_body.CustomFace)localObject2).image_type.set(2);
      }
      else
      {
        ((im_msg_body.CustomFace)localObject2).image_type.set(0);
        continue;
        continue;
        return localException;
        i = 0;
      }
    }
  }
  
  public long c()
  {
    if ((this.n) || (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g)) {
      return super.c();
    }
    return 7000L;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupPicUploadProcessor", 2, "<BDH_LOG> Transaction submit:sendFile:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction + "  this:" + this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction != null) {}
    int i;
    do
    {
      return;
      this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
      byte[] arrayOfByte = HexUtil.a(this.V);
      eij localeij = new eij(this);
      this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h, (int)this.jdField_b_of_type_Long, arrayOfByte, this.jdField_a_of_type_ArrayOfByte, localeij);
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().submitTransactionTask(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
      if (QLog.isColorLevel()) {
        QLog.d("GroupPicUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + i + " T_ID:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId() + " UniSeq:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long + " MD5:" + this.jdField_c_of_type_JavaLangString + " uuid:" + this.U + " Path:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.filePath + " Cmd:" + 2);
      }
    } while (i == 0);
    a(i, "SubmitError.", "", this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
    d();
  }
  
  protected void c(boolean paramBoolean)
  {
    int i = 2;
    String str3 = this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(1) + ";" + this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(2) + ";" + this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(3);
    if (QLog.isColorLevel()) {
      QLog.d("GroupPicUploadProcessor", 2, "doDSReport : GroupPic doReport : result:" + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_Int == 1030) {}
    while (((!paramBoolean) && (RichMediaStrategy.c(this.aw))) || (this.jdField_c_of_type_Boolean) || ((paramBoolean) && ((this.az & 0x2) > 0)) || ((!paramBoolean) && ((this.az & 0x1) > 0))) {
      return;
    }
    int i1 = this.az;
    String str2;
    label187:
    String str1;
    if (paramBoolean)
    {
      this.az = (i | i1);
      if (!this.m) {
        break label337;
      }
      if (!this.n) {
        break label329;
      }
      str2 = "actGroupPicUploadV1";
      str1 = str2;
      if (!this.n) {
        break label578;
      }
      str1 = str2;
      if (this.aM != 1) {
        break label578;
      }
      str1 = "actGroupPicUploadV2";
    }
    label578:
    for (;;)
    {
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      long l1 = (System.nanoTime() - this.jdField_c_of_type_Long) / 1000000L;
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", str3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fileid", String.valueOf(this.jdField_j_of_type_Long));
      if (paramBoolean)
      {
        q();
        StatisticCollector.a(BaseApplication.getContext()).a(null, str1, true, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
      }
      for (;;)
      {
        n();
        return;
        i = 1;
        break;
        label329:
        str2 = "actGrpPttUp";
        break label187;
        label337:
        if (this.n) {}
        for (str2 = "actDiscussPicUpload";; str2 = "actDisscusPttUp")
        {
          str1 = str2;
          if (!this.n) {
            break label578;
          }
          str1 = str2;
          if (this.aM != 1) {
            break label578;
          }
          str1 = "actDiscussPicUploadV2";
          break;
        }
        if (this.aw != -9527) {
          this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
        }
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_url");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.aw));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.L);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picmd5", this.jdField_d_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.jdField_a_of_type_Long));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_busi", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_Int));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_uniseq", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long));
        StatisticCollector.a(BaseApplication.getContext()).a(null, str1, false, l1, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
      }
    }
  }
  
  public void d()
  {
    super.d();
    d(1005);
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Int = -1;
      localSendResult.jdField_b_of_type_Int = this.aw;
      localSendResult.jdField_a_of_type_JavaLangString = this.L;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.b(localSendResult);
    }
  }
  
  public int e()
  {
    super.e();
    if ((!this.n) && (!this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g)) {
      return 0;
    }
    return h();
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localSendResult.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      localSendResult.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      localSendResult.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h;
      localSendResult.jdField_b_of_type_Long = this.jdField_j_of_type_Long;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.b(localSendResult);
    }
    for (;;)
    {
      if (!this.n) {
        d(1003);
      }
      return;
      a(true);
    }
  }
  
  public int f()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = false;
      this.jdField_h_of_type_Boolean = false;
      d(1002);
      if (this.aM != 1)
      {
        this.jdField_h_of_type_Long = 0L;
        this.V = null;
      }
      this.aI = 0;
      this.aH = 0;
      this.aG = 0;
      this.aw = 0;
      this.L = "";
      this.jdField_b_of_type_ComTencentWsttSSCMSSCM.a();
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.a.post(new eik(this));
    }
    return 0;
  }
  
  public int g()
  {
    return super.g();
  }
  
  public void i()
  {
    if (!this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        a("pause", "");
      }
      d(1006);
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq != null)
      {
        RichProtoProc.b(this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq);
        this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
      }
    }
    switch (this.aM)
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        return;
        c("<BDH_LOG> pause() BUT current status is INIT");
        return;
        c("<BDH_LOG> pause() pause HTTP channel");
      } while (this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq == null);
      this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.b(this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq);
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction != null)
    {
      c("<BDH_LOG> pause() pause BDH channel, transation id=" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().stopTransactionTask(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
      return;
    }
    c("<BDH_LOG> pause() pause BDH channel, but trans == null");
  }
  
  protected void p()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq instanceof HttpNetReq))
    {
      if (!this.m) {
        break label58;
      }
      if (i != 2) {
        break label31;
      }
    }
    label31:
    label58:
    while (i == 2)
    {
      return;
      ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("picGu", ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString);
      return;
    }
    ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("picDu", ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaLangString);
  }
  
  void r()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    Object localObject;
    String str;
    if (this.n)
    {
      localObject = new RichProto.RichProtoReq.PicUpReq();
      ((RichProto.RichProtoReq.PicUpReq)localObject).jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      ((RichProto.RichProtoReq.PicUpReq)localObject).jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      ((RichProto.RichProtoReq.PicUpReq)localObject).jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      ((RichProto.RichProtoReq.PicUpReq)localObject).jdField_a_of_type_Int = this.ao;
      ((RichProto.RichProtoReq.PicUpReq)localObject).jdField_b_of_type_Int = this.ap;
      ((RichProto.RichProtoReq.PicUpReq)localObject).jdField_a_of_type_Boolean = this.jdField_e_of_type_Boolean;
      ((RichProto.RichProtoReq.ReqCommon)localObject).jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangString;
      ((RichProto.RichProtoReq.ReqCommon)localObject).jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString;
      ((RichProto.RichProtoReq.ReqCommon)localObject).jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
      ((RichProto.RichProtoReq.ReqCommon)localObject).jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
      if (!this.n) {
        break label259;
      }
      str = "grp_pic_up";
      label138:
      localRichProtoReq.jdField_a_of_type_JavaLangString = str;
      localRichProtoReq.jdField_a_of_type_JavaUtilList.add(localObject);
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (d()) {
        break label266;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
    }
    label259:
    label266:
    do
    {
      return;
      localObject = new RichProto.RichProtoReq.PttUpReq();
      ((RichProto.RichProtoReq.PttUpReq)localObject).jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      ((RichProto.RichProtoReq.PttUpReq)localObject).jdField_b_of_type_Int = ((int)this.jdField_a_of_type_Long);
      ((RichProto.RichProtoReq.PttUpReq)localObject).jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      ((RichProto.RichProtoReq.PttUpReq)localObject).jdField_a_of_type_Int = QQRecorder.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      ((RichProto.RichProtoReq.PttUpReq)localObject).jdField_c_of_type_Int = ((MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).voiceType;
      break;
      str = "grp_ptt_up";
      break label138;
      if (QLog.isColorLevel()) {
        a("requestStart", localRichProtoReq.toString());
      }
    } while (!e());
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = localRichProtoReq;
    RichProtoProc.a(localRichProtoReq);
  }
  
  public void s()
  {
    if (this.k == -1L) {
      this.k = SystemClock.uptimeMillis();
    }
    super.c();
  }
  
  public void t()
  {
    if (!e()) {
      return;
    }
    this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    if (this.n) {
      d(1003);
    }
    if (this.m)
    {
      u();
      return;
    }
    v();
  }
  
  void u()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 2)
    {
      localObject2 = a();
      if (localObject2 == null)
      {
        a(9368, "constructpberror", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
        return;
      }
      if (!d())
      {
        a(9366, "illegal app", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        if ((localObject1 != null) && ((localObject1 instanceof MessageForPtt))) {
          break label207;
        }
        localObject2 = new StringBuilder().append("Mr_");
        if (localObject1 != null) {
          break label180;
        }
      }
      label180:
      for (localObject1 = "null";; localObject1 = "" + ((MessageRecord)localObject1).msgtype)
      {
        a(9368, "msgtypeError", (String)localObject1, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
        return;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
        break;
      }
      label207:
      MessageForPtt localMessageForPtt = (MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      ((im_msg_body.RichText)localObject2).ptt.uint32_format.set(localMessageForPtt.voiceType);
      ((im_msg_body.RichText)localObject2).ptt.uint32_time.set(Utils.a(localMessageForPtt.voiceLength));
      if (QLog.isColorLevel()) {
        QLog.d("RecordParams", 2, "<---sendGroupMsg voiceType：" + localMessageForPtt.voiceType + " voiceLengh:" + localMessageForPtt.voiceLength);
      }
      ((MessageForPtt)localObject1).richText = ((im_msg_body.RichText)localObject2);
      AnonymousChatHelper.a().a((MessageRecord)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      localObject1 = b();
      if (localObject1 == null)
      {
        a(9368, "constructpberror", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
      }
      for (;;)
      {
        e();
        return;
        if (!d())
        {
          a(9366, "illegal app", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
          d();
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null) {
          this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.a((im_msg_body.RichText)localObject1);
        }
      }
    }
    Object localObject2 = b();
    if (localObject2 == null)
    {
      a(9368, "constructpberror", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
      return;
    }
    if (!d())
    {
      a(9366, "illegal app", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.a((im_msg_body.RichText)localObject2);
      if ((localObject1 != null) && (((localObject1 instanceof MessageForPic)) || ((localObject1 instanceof MessageForStructing)))) {
        break label654;
      }
      localObject2 = new StringBuilder().append("Mr_");
      if (localObject1 != null) {
        break label627;
      }
    }
    label627:
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
    label654:
    if ((localObject1 instanceof MessageForPic)) {
      ((MessageForPic)localObject1).richText = ((im_msg_body.RichText)localObject2);
    }
    if ((localObject1 instanceof MessageForStructing)) {
      ((MessageForStructing)localObject1).richText = ((im_msg_body.RichText)localObject2);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  void v()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 2)
    {
      localObject2 = a();
      if (localObject2 == null)
      {
        a(9368, "constructpberror", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
        return;
      }
      if (!d())
      {
        a(9366, "illegal app", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        if ((localObject1 != null) && ((localObject1 instanceof MessageForPtt))) {
          break label207;
        }
        localObject2 = new StringBuilder().append("Mr_");
        if (localObject1 != null) {
          break label180;
        }
      }
      label180:
      for (localObject1 = "null";; localObject1 = "" + ((MessageRecord)localObject1).msgtype)
      {
        a(9368, "msgtypeError", (String)localObject1, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
        return;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
        break;
      }
      label207:
      MessageForPtt localMessageForPtt = (MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      ((im_msg_body.RichText)localObject2).ptt.uint32_format.set(localMessageForPtt.voiceType);
      ((im_msg_body.RichText)localObject2).ptt.uint32_time.set(Utils.a(localMessageForPtt.voiceLength));
      if (QLog.isColorLevel()) {
        QLog.d("RecordParams", 2, "<---sendDiscussMsg voiceType：" + localMessageForPtt.voiceType + " voiceLengh:" + localMessageForPtt.voiceLength);
      }
      ((MessageForPtt)localObject1).richText = ((im_msg_body.RichText)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      localObject1 = b();
      if (localObject1 == null)
      {
        a(9368, "constructpberror", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
      }
      for (;;)
      {
        e();
        return;
        if (!d())
        {
          a(9366, "illegal app", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
          d();
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null) {
          this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.a((im_msg_body.RichText)localObject1);
        }
      }
    }
    Object localObject2 = b();
    if (localObject2 == null)
    {
      a(9368, "constructpberror", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
      return;
    }
    if (!d())
    {
      a(9366, "illegal app", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.a((im_msg_body.RichText)localObject2);
      if ((localObject1 != null) && (((localObject1 instanceof MessageForPic)) || ((localObject1 instanceof MessageForStructing)))) {
        break label647;
      }
      localObject2 = new StringBuilder().append("Mr_");
      if (localObject1 != null) {
        break label620;
      }
    }
    label620:
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
    label647:
    if ((localObject1 instanceof MessageForPic)) {
      ((MessageForPic)localObject1).richText = ((im_msg_body.RichText)localObject2);
    }
    if ((localObject1 instanceof MessageForStructing)) {
      ((MessageForStructing)localObject1).richText = ((im_msg_body.RichText)localObject2);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  public void w()
  {
    if (this.jdField_h_of_type_Boolean) {
      return;
    }
    if ((this.V != null) && (this.jdField_j_of_type_Long != 0L))
    {
      if (this.jdField_h_of_type_Long >= this.jdField_a_of_type_Long)
      {
        t();
        return;
      }
      if ((this.aM == 1) && (this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction != null))
      {
        c("<BDH_LOG> sendFileNotBlockCallThread() resume BDH channel");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().resumeTransactionTask(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
        return;
      }
      a();
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.GroupPicUploadProcessor
 * JD-Core Version:    0.7.0.1
 */