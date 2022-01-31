package com.tencent.mobileqq.transfile;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.transfile.protohandler.C2CPicUpHandler;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PicUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.C2CPicUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import grd;
import gre;
import grf;
import grg;
import gsg;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.NotOnlineImage;
import tencent.im.msg.im_msg_body.RichMsg;
import tencent.im.msg.im_msg_body.RichText;

public class C2CPicUploadProcessor
  extends BaseUploadProcessor
{
  public static final String U = "C2CPicUploadProcessor";
  private static final boolean j = false;
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new grg(this);
  private Transaction jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = null;
  private int aH = 0;
  boolean i = false;
  
  public C2CPicUploadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.n = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.aJ = 0;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Boolean = true;
  }
  
  private im_msg_body.RichText a()
  {
    label700:
    label711:
    label713:
    for (int k = 1;; k = 0)
    {
      im_msg_body.RichText localRichText;
      for (;;)
      {
        try
        {
          localRichText = new im_msg_body.RichText();
          Object localObject1 = new im_msg_body.NotOnlineImage();
          ((im_msg_body.NotOnlineImage)localObject1).file_path.set(ByteStringMicro.copyFromUtf8(this.jdField_d_of_type_JavaLangString));
          ((im_msg_body.NotOnlineImage)localObject1).file_len.set((int)this.jdField_f_of_type_Long);
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.j != null) {
            ((im_msg_body.NotOnlineImage)localObject1).download_path.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.j));
          }
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i != null) {
            ((im_msg_body.NotOnlineImage)localObject1).res_id.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i));
          }
          ((im_msg_body.NotOnlineImage)localObject1).pic_md5.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ArrayOfByte));
          ((im_msg_body.NotOnlineImage)localObject1).pic_height.set(this.ak);
          ((im_msg_body.NotOnlineImage)localObject1).pic_width.set(this.aj);
          Object localObject2 = ((im_msg_body.NotOnlineImage)localObject1).original;
          if (!this.jdField_d_of_type_Boolean) {
            break label713;
          }
          ((PBUInt32Field)localObject2).set(k);
          if ("jpg".equals(this.jdField_e_of_type_JavaLangString)) {
            ((im_msg_body.NotOnlineImage)localObject1).img_type.set(2);
          }
          switch (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.d)
          {
          case 1005: 
            if (QLog.isColorLevel()) {
              a("busiTypeStat", "uiBusiType:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.d + " protoBusiType:" + ((im_msg_body.NotOnlineImage)localObject1).biz_type.get());
            }
            localObject2 = new im_msg_body.Elem();
            ((im_msg_body.Elem)localObject2).not_online_image.set((MessageMicro)localObject1);
            localRichText.elems.add((MessageMicro)localObject2);
            MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
            if (!(localMessageRecord instanceof MessageForStructing)) {
              break label711;
            }
            localObject2 = (MessageForStructing)localMessageRecord;
            if ((((MessageForStructing)localObject2).structingMsg == null) || (!(((MessageForStructing)localObject2).structingMsg instanceof StructMsgForImageShare))) {
              break label711;
            }
            StructMsgItemImage localStructMsgItemImage = ((StructMsgForImageShare)((MessageForStructing)localObject2).structingMsg).getFirstImageElement();
            if (localStructMsgItemImage == null) {
              break label711;
            }
            localStructMsgItemImage.j = this.jdField_c_of_type_JavaLangString;
            if (this.jdField_f_of_type_JavaLangString != null) {
              break label700;
            }
            localObject1 = this.S;
            localStructMsgItemImage.i = ((String)localObject1);
            localStructMsgItemImage.jdField_c_of_type_Long = this.jdField_f_of_type_Long;
            localStructMsgItemImage.jdField_d_of_type_Long = localMessageRecord.time;
            localObject1 = ((MessageForStructing)localObject2).structingMsg.getXmlBytes();
            if ((TextUtils.isEmpty(((MessageForStructing)localObject2).frienduin)) || (localObject1 == null)) {
              break label711;
            }
            localObject2 = new im_msg_body.RichMsg();
            ((im_msg_body.RichMsg)localObject2).bytes_template_1.set(ByteStringMicro.copyFrom((byte[])localObject1));
            localObject1 = new im_msg_body.Elem();
            ((im_msg_body.Elem)localObject1).rich_msg.set((MessageMicro)localObject2);
            localRichText.elems.add((MessageMicro)localObject1);
            break label711;
            if ("bmp".equals(this.jdField_e_of_type_JavaLangString))
            {
              ((im_msg_body.NotOnlineImage)localObject1).img_type.set(1);
              continue;
            }
            if (!"gif".equals(this.jdField_e_of_type_JavaLangString)) {
              break label610;
            }
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("C2CPicUploadProcessor", 2, "Construct richtext error", localException);
          }
          localException.printStackTrace();
          return null;
        }
        localException.img_type.set(3);
        continue;
        label610:
        localException.img_type.set(0);
        continue;
        localException.biz_type.set(1);
        continue;
        localException.biz_type.set(2);
        continue;
        localException.biz_type.set(3);
        continue;
        localException.biz_type.set(4);
        continue;
        localException.biz_type.set(5);
        continue;
        localException.biz_type.set(6);
        continue;
        localException.biz_type.set(7);
        continue;
        String str = this.jdField_f_of_type_JavaLangString;
      }
      return localRichText;
    }
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (paramLong1 != 0L) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true, 1, 1, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, paramLong1);
    }
    if (paramLong2 != 0L) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true, 1, 1, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, paramLong2);
    }
    if (paramLong3 != 0L) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true, 0, 1, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, paramLong3);
    }
    if (paramLong4 != 0L) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true, 0, 1, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, paramLong4);
    }
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    Object localObject1 = null;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    }
    long l1;
    if ((localObject1 != null) && ((localObject1 instanceof MessageForPic)))
    {
      l1 = ((MessageForPic)localObject1).DSKey;
      if (l1 != 0L) {
        break label53;
      }
    }
    label53:
    Object[] arrayOfObject;
    do
    {
      return;
      arrayOfObject = (Object[])this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b.remove(Long.valueOf(l1));
    } while (arrayOfObject == null);
    String str2 = (String)arrayOfObject[0];
    ((MessageForPic)localObject1).SpeedInfo = paramString;
    Object localObject2 = paramString.split(";");
    Object localObject3 = localObject2[0];
    localObject1 = localObject2[1];
    localObject2 = localObject2[2];
    localObject3 = ((String)localObject3).split("_");
    Object localObject5 = ((String)localObject1).split("_");
    localObject1 = ((String)localObject2).split("_");
    long l2 = Long.valueOf(localObject3[4]).longValue();
    long l3 = Long.valueOf(localObject1[4]).longValue();
    long l4 = Long.valueOf(localObject5[4]).longValue();
    localObject2 = str2.split(";");
    localObject3 = localObject2[0];
    localObject1 = localObject2[1];
    localObject2 = localObject2[2];
    localObject3 = ((String)localObject3).split("_");
    localObject1 = ((String)localObject1).split("_");
    localObject2 = ((String)localObject2).split("_");
    long l5 = Long.valueOf(localObject3[4]).longValue();
    long l6 = Long.valueOf(localObject2[4]).longValue();
    long l7 = Long.valueOf(localObject1[4]).longValue();
    localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("param_BdhTrans");
    long l8 = Long.valueOf(localObject1[4]).longValue() - ((Integer)arrayOfObject[4]).intValue();
    Object localObject4;
    String str1;
    int n;
    int m;
    if ((localObject2 != null) && (((String)localObject2).length() > 0))
    {
      localObject1 = ((String)localObject2).split(";");
      localObject4 = localObject1[2].split(":")[1];
      str1 = localObject1[3].split(":")[1];
      localObject3 = localObject1[4].split(":")[1];
      localObject2 = localObject1[5].split(":")[1];
      localObject1 = localObject1[6].split(":")[1];
      l1 = Long.valueOf(localObject5[4]).longValue() - Integer.valueOf(str1).intValue();
      n = (int)((float)this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long / ((float)l1 / 1000.0F) / 1000.0F);
      m = (int)((float)this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long / ((float)l8 / 1000.0F) / 1000.0F);
      if ((str1 == null) || (l1 < l8)) {
        break label1269;
      }
    }
    label718:
    label747:
    label1261:
    label1269:
    for (int k = 0;; k = 1)
    {
      String str3 = (String)arrayOfObject[2];
      int i1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      localObject5 = new SimpleDateFormat("MM-dd HH:mm:ss").format(Long.valueOf(System.currentTimeMillis()));
      StringBuilder localStringBuilder = new StringBuilder("双发结果:").append("发了第").append(i1).append("张").append("\n");
      localStringBuilder.append("时间:").append((String)localObject5).append("\n");
      localStringBuilder.append("图片大小:").append(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long).append("bytes\n");
      localObject5 = localStringBuilder.append("老通道传输:").append(l8).append("ms,").append("速度:");
      if (l8 == 0L) {
        m = 0;
      }
      ((StringBuilder)localObject5).append(m).append("kbps").append("\n");
      localObject5 = localStringBuilder.append("新通道传输:").append(l1).append("ms,").append("速度:");
      if (l1 == 0L)
      {
        m = 0;
        ((StringBuilder)localObject5).append(m).append("kbps").append("\n");
        if (k == 0) {
          break label1253;
        }
        localObject5 = "结果:新通道传输较快\n";
        localStringBuilder.append((String)localObject5);
        localStringBuilder.append("老通道 Step:").append("申请").append(l5).append("ms_").append("传输").append(l7).append("ms_").append("消息").append(l6).append("ms").append("\n");
        localStringBuilder.append("新通道 Step:").append("申请").append(l2).append("ms_").append("传输").append(l4).append("ms_").append("消息").append(l3).append("ms").append("\n");
        localStringBuilder.append("群图Info:").append("接入:").append(arrayOfObject[3]).append("ms;").append("架平:").append(arrayOfObject[4]).append("ms").append("\n");
        localStringBuilder.append("新通道info:").append("接入:").append((String)localObject4).append("ms;").append("架平:").append(str1).append("ms").append("\n");
        localObject4 = localStringBuilder.append("Channel:");
        if (this.aH != 1) {
          break label1261;
        }
      }
      for (str1 = "Tcp";; str1 = "Http")
      {
        ((StringBuilder)localObject4).append(str1).append("\n");
        localStringBuilder.append("网络:").append((String)localObject3).append("\n");
        localStringBuilder.append("Host:").append((String)localObject2).append("\n");
        localStringBuilder.append("连接数:").append((String)localObject1).append("\n");
        localObject1 = MessageRecordFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), str3, str3, 1, (byte)1, (byte)0, (short)0, localStringBuilder.toString());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject1, null);
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("param_c2cSpeed", String.valueOf(l1));
        ((HashMap)localObject1).put("param_grpSpeed", String.valueOf(l8));
        ((HashMap)localObject1).put("param_c2cInfo", paramString);
        ((HashMap)localObject1).put("param_grpInfo", str2);
        StatisticCollector.a(BaseApplication.getContext()).a(null, "actSFResult", paramBoolean, l1, this.jdField_f_of_type_Long, (HashMap)localObject1, "");
        return;
        l1 = this.jdField_d_of_type_Long;
        long l9 = this.jdField_e_of_type_Long;
        localObject1 = null;
        localObject2 = null;
        localObject3 = null;
        str1 = String.valueOf(l9);
        localObject4 = null;
        break;
        m = n;
        break label718;
        localObject5 = "结果:老通道传输较快\n";
        break label747;
      }
    }
  }
  
  private void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CPicUploadProcessor", 2, paramString);
    }
  }
  
  private void u()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.a.post(new grd(this));
  }
  
  private void v()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepBaseInfo.a();
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b.a();
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo.a();
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_ComTencentMobileqqTransfileFileMsg$StepBaseInfo.a();
    FileMsg localFileMsg = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
    long l = System.nanoTime();
    localFileMsg.jdField_e_of_type_Long = l;
    this.jdField_a_of_type_Long = l;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_f_of_type_Long = 0L;
  }
  
  protected long a(long paramLong)
  {
    paramLong = this.jdField_f_of_type_Long - paramLong;
    if (!this.jdField_g_of_type_Boolean) {}
    for (paramLong = Math.min(paramLong, this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a(BaseApplication.getContext(), this.jdField_f_of_type_Long, this.jdField_h_of_type_Long));; paramLong = Math.min(paramLong, 14600L)) {
      return Math.min(paramLong, 131072L);
    }
  }
  
  protected String a(byte[] paramArrayOfByte)
  {
    String str = c();
    if ((str == null) || (str.equals(""))) {
      return null;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo.jdField_d_of_type_JavaLangString = str;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    if (!this.i)
    {
      paramArrayOfByte = MD5.toMD5(paramArrayOfByte);
      localStringBuilder.append("?ver=");
      localStringBuilder.append("2");
      localStringBuilder.append("&ukey=");
      localStringBuilder.append(this.T);
      localStringBuilder.append("&filekey=");
      localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
      localStringBuilder.append("&filesize=");
      localStringBuilder.append(this.jdField_f_of_type_Long);
      localStringBuilder.append("&bmd5");
      localStringBuilder.append(paramArrayOfByte);
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("cgi-bin/httpconn?htcmd=0x6ff0070&ver=5345");
      localStringBuilder.append("&ukey=");
      localStringBuilder.append(this.T);
      localStringBuilder.append("&filesize=");
      localStringBuilder.append(this.jdField_f_of_type_Long);
      localStringBuilder.append("&uin=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("&range=");
      localStringBuilder.append(this.jdField_h_of_type_Long);
    }
  }
  
  public void a()
  {
    d(1000);
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b();
    d(1001);
    if ((this.jdField_a_of_type_ArrayOfByte == null) && (!f()))
    {
      d();
      return;
    }
    if ((this.ak == 0) || (this.aj == 0))
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      localOptions.inSampleSize = 1;
      BitmapFactory.decodeFile(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g, localOptions);
      this.ak = localOptions.outHeight;
      this.aj = localOptions.outWidth;
    }
    if (this.jdField_a_of_type_JavaIoRandomAccessFile == null) {
      try
      {
        this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g, "r");
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
    q();
  }
  
  public void a(NetResp paramNetResp)
  {
    super.a(paramNetResp);
    if ((this.jdField_e_of_type_Boolean) || (this.jdField_c_of_type_Boolean)) {}
    for (;;)
    {
      return;
      a("onResp", "result:" + paramNetResp.d + " errCode:" + paramNetResp.jdField_a_of_type_Long + " errDesc:" + paramNetResp.jdField_a_of_type_JavaLangString);
      int k = paramNetResp.jdField_e_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
      long l3;
      for (;;)
      {
        try
        {
          if (paramNetResp.d != 0) {
            break label632;
          }
          this.av = 0;
          this.jdField_a_of_type_ComTencentWsttSSCMSSCM.b();
          if (paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("User-ReturnCode") == null)
          {
            l3 = 9223372036854775807L;
            if ((l3 == 0L) || (l3 == 9223372036854775807L)) {
              break;
            }
            a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, false);
            if (C2CPicUpHandler.a((int)l3)) {
              break;
            }
            a(-9527, null, b(k, l3), this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
            d();
            return;
          }
        }
        catch (Exception paramNetResp)
        {
          a(9343, Log.getStackTraceString(new Exception("decode unknown exception")), "", this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
          d();
          return;
        }
        l3 = Long.parseLong((String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("User-ReturnCode"));
      }
      long l1;
      long l2;
      if (paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("Range") == null)
      {
        l1 = 9223372036854775807L;
        l2 = l1;
        if (l1 == 9223372036854775807L)
        {
          Object localObject = paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("X-Range");
          l2 = l1;
          if (localObject == null) {}
        }
      }
      try
      {
        for (;;)
        {
          k = Integer.parseInt((String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("X-Range"));
          l2 = k;
          if (l2 == 9223372036854775807L)
          {
            a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, false);
            a(-9527, "no header range", a(this.I, this.aq), this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
            d();
            return;
            try
            {
              k = Integer.parseInt((String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("Range"));
              l1 = k;
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
        for (;;)
        {
          localException2.printStackTrace();
          l2 = 9223372036854775807L;
        }
        a("decodeHttpResp", "from " + this.jdField_h_of_type_Long + " to " + l2 + " userReturnCode:" + l3);
        if (l2 <= this.jdField_h_of_type_Long)
        {
          if (this.aD < 3)
          {
            a("procHttpRespBody", "server offset rollback");
            this.aD += 1;
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_d_of_type_Long = l2;
          this.jdField_h_of_type_Long = l2;
          a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, true);
          if (l2 >= this.jdField_f_of_type_Long) {
            break label620;
          }
          if (this.jdField_e_of_type_Boolean) {
            continue;
          }
          f();
          r();
          return;
        }
        a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, false);
        this.jdField_a_of_type_JavaUtilHashMap.put("returnCode", "" + l3);
        a(-9527, "", a(this.I, this.ap), this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
        return;
        label620:
        s();
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b();
        return;
      }
    }
    label632:
    if ((paramNetResp.jdField_a_of_type_Long == 9364L) && (this.av < 3))
    {
      a("[netChg]", "failed.but net change detect.so retry");
      this.av += 1;
      this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a();
      o();
      q();
      return;
    }
    if ((paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.jdField_a_of_type_ArrayOfByte.length >= 32768) && (RichMediaStrategy.a((int)paramNetResp.jdField_a_of_type_Long)))
    {
      this.jdField_g_of_type_Boolean = true;
      o();
      r();
      return;
    }
    a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, false);
    a((int)paramNetResp.jdField_a_of_type_Long, paramNetResp.jdField_a_of_type_JavaLangString);
    d();
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
    Object localObject;
    boolean bool;
    if (paramRichProtoResp != null)
    {
      int k = 0;
      if (k < paramRichProtoResp.jdField_a_of_type_JavaUtilList.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.C2CPicUpResp)paramRichProtoResp.jdField_a_of_type_JavaUtilList.get(k);
        if (QLog.isColorLevel()) {
          a("procUrl", paramRichProtoReq.toString());
        }
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramRichProtoReq);
        if (paramRichProtoReq.jdField_c_of_type_Int == 0)
        {
          String str;
          if (paramRichProtoReq.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long;
            localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
            str = paramRichProtoReq.jdField_a_of_type_JavaLangString;
            ((FileMsg)localObject).i = str;
            this.jdField_f_of_type_JavaLangString = str;
            localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
            paramRichProtoReq = paramRichProtoReq.jdField_b_of_type_JavaLangString;
            ((FileMsg)localObject).j = paramRichProtoReq;
            this.S = paramRichProtoReq;
            s();
          }
          for (;;)
          {
            k += 1;
            break;
            localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
            str = paramRichProtoReq.jdField_a_of_type_JavaLangString;
            ((FileMsg)localObject).i = str;
            this.jdField_f_of_type_JavaLangString = str;
            localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
            str = paramRichProtoReq.jdField_b_of_type_JavaLangString;
            ((FileMsg)localObject).j = str;
            this.S = str;
            this.T = paramRichProtoReq.jdField_c_of_type_JavaLangString;
            this.jdField_a_of_type_JavaUtilArrayList = paramRichProtoReq.jdField_a_of_type_JavaUtilArrayList;
            this.i = paramRichProtoReq.jdField_b_of_type_Boolean;
            bool = paramRichProtoReq.jdField_d_of_type_Boolean;
            this.jdField_g_of_type_Long = paramRichProtoReq.jdField_a_of_type_Long;
            if ((paramRichProtoReq.jdField_a_of_type_Int != 0) && (this.jdField_h_of_type_Boolean) && (!paramRichProtoReq.jdField_c_of_type_Boolean)) {
              this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a(paramRichProtoReq.jdField_a_of_type_Int);
            }
            if (QLog.isColorLevel()) {
              QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> About to submit Transaction , from onBusiProtoResp.");
            }
            if (this.aH != 2) {
              break label307;
            }
            c("<BDH_LOG> onBusiProtoResp() last status is HTTP and resume by start");
            r();
          }
          label307:
          if (this.aH == 0)
          {
            c("<BDH_LOG> onBusiProtoResp() start normally, selecting channel...");
            if (!bool) {
              c("<BDH_LOG> onBusiProtoResp() Server's isUseBdh = false");
            }
          }
        }
      }
    }
    label539:
    for (;;)
    {
      if (bool)
      {
        c("<BDH_LOG> onBusiProtoResp() select BDH channel");
        this.aH = 1;
        c();
        break;
        if (!NetworkUtil.c(BaseApplication.getContext())) {
          break label539;
        }
        paramRichProtoReq = NetworkUtil.a(BaseApplication.getContext());
        if ((paramRichProtoReq == null) || ((!paramRichProtoReq.equalsIgnoreCase("cmwap")) && (!paramRichProtoReq.equalsIgnoreCase("ctwap")))) {
          break label539;
        }
        c("<BDH_LOG> onBusiProtoResp() APN=" + paramRichProtoReq);
        bool = false;
        continue;
      }
      c("<BDH_LOG> onBusiProtoResp() select HTTP channel");
      this.aH = 2;
      r();
      break;
      localObject = new StringBuilder().append("<BDH_LOG> onBusiProtoResp() CANNOT start BDH or HTTP channel. current status is not INIT, is");
      if (this.aH == 1) {}
      for (paramRichProtoReq = "BDH";; paramRichProtoReq = "HTTP")
      {
        c(paramRichProtoReq);
        break;
      }
      c("<BDH_LOG> onBusiProtoResp() error : " + paramRichProtoReq.jdField_c_of_type_Int + " ,select HTTP channel");
      this.aH = 2;
      d();
      return;
    }
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
          if ((localMessageRecord instanceof MessageForPic))
          {
            localObject = (MessageForPic)localMessageRecord;
            ((MessageForPic)localObject).size = this.jdField_f_of_type_Long;
            if (this.jdField_f_of_type_JavaLangString == null) {}
            for (str = this.S;; str = this.jdField_f_of_type_JavaLangString)
            {
              ((MessageForPic)localObject).uuid = str;
              ((MessageForPic)localObject).serial();
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, localMessageRecord.uniseq, ((MessageForPic)localObject).msgData);
              return;
            }
          }
        } while (!(localMessageRecord instanceof MessageForStructing));
        localObject = (MessageForStructing)localMessageRecord;
      } while ((((MessageForStructing)localObject).structingMsg == null) || (!(((MessageForStructing)localObject).structingMsg instanceof StructMsgForImageShare)));
      localStructMsgItemImage = ((StructMsgForImageShare)((MessageForStructing)localObject).structingMsg).getFirstImageElement();
    } while (localStructMsgItemImage == null);
    localStructMsgItemImage.j = this.jdField_c_of_type_JavaLangString;
    if (this.jdField_f_of_type_JavaLangString == null) {}
    for (String str = this.S;; str = this.jdField_f_of_type_JavaLangString)
    {
      localStructMsgItemImage.i = str;
      localStructMsgItemImage.jdField_c_of_type_Long = this.jdField_f_of_type_Long;
      localStructMsgItemImage.jdField_d_of_type_Long = localMessageRecord.time;
      ((MessageForStructing)localObject).msgData = ((MessageForStructing)localObject).structingMsg.getBytes();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, localMessageRecord.uniseq, ((MessageForStructing)localObject).msgData);
      return;
    }
  }
  
  boolean a(int paramInt)
  {
    return false;
  }
  
  String c()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
      return "";
    }
    int k = this.am;
    int m = this.jdField_a_of_type_JavaUtilArrayList.size();
    ServerAddr localServerAddr = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(k % m);
    String str = "http://" + localServerAddr.jdField_a_of_type_JavaLangString;
    if (localServerAddr.jdField_b_of_type_Int != 80) {
      str = str + ":" + localServerAddr.jdField_b_of_type_Int;
    }
    for (;;)
    {
      return str + "/";
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> Transaction submit:sendFile:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction + "  this:" + this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction != null) {}
    int k;
    do
    {
      return;
      this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
      byte[] arrayOfByte = HexUtil.a(this.T);
      gre localgre = new gre(this, SystemClock.uptimeMillis());
      this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 1, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g, (int)this.jdField_g_of_type_Long, arrayOfByte, this.jdField_a_of_type_ArrayOfByte, localgre);
      k = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().submitTransactionTask(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
      if (QLog.isColorLevel()) {
        QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + k + " T_ID:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId() + " UniSeq:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long + " MD5:" + this.jdField_c_of_type_JavaLangString + " uuid:" + this.S + " Path:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.filePath + " Cmd:" + 1);
      }
    } while (k == 0);
    a(k, "SubmitError.", "", this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
    d();
  }
  
  protected void c(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(1) + ";" + this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(2) + ";" + this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(3);
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.d == 1030) {}
    while (((!paramBoolean) && (RichMediaStrategy.c(this.at))) || (this.jdField_b_of_type_Boolean) || ((paramBoolean) && ((this.aw & 0x2) > 0)) || ((!paramBoolean) && ((this.aw & 0x1) > 0))) {
      return;
    }
    int m = this.aw;
    int k;
    String str;
    label172:
    long l;
    if (paramBoolean)
    {
      k = 2;
      this.aw = (k | m);
      str = "actC2CPicUploadV2";
      switch (this.aH)
      {
      default: 
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        l = (System.nanoTime() - this.jdField_a_of_type_Long) / 1000000L;
        this.jdField_a_of_type_JavaUtilHashMap.put("param_step", localObject);
        HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
        if (this.jdField_f_of_type_JavaLangString == null)
        {
          localObject = this.S;
          label225:
          localHashMap.put("param_uuid", localObject);
          this.jdField_a_of_type_JavaUtilHashMap.put("param_toUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString);
          if (!paramBoolean) {
            break label709;
          }
          if ((this.jdField_d_of_type_Long <= 0L) || (this.jdField_e_of_type_Long <= 0L)) {
            break label704;
          }
          k = 1;
          label278:
          if (QLog.isColorLevel()) {
            a("doReport", "costReport:" + this.jdField_a_of_type_JavaLangStringBuilder.toString() + ",isReportValid:" + this.jdField_f_of_type_Boolean);
          }
          if ((this.jdField_f_of_type_Boolean) && (k != 0))
          {
            if (this.aC > 100)
            {
              this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
              this.jdField_a_of_type_JavaLangStringBuilder.append("s").append(this.aC).append("_").append("tr").append(this.jdField_d_of_type_Long).append("_").append("ht").append(this.jdField_c_of_type_Long).append("_").append("pic").append(this.jdField_e_of_type_Long).append(";");
            }
            this.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", String.valueOf(this.jdField_e_of_type_Long));
            this.jdField_a_of_type_JavaUtilHashMap.put("param_CostEach", this.jdField_a_of_type_JavaLangStringBuilder.toString());
            this.jdField_a_of_type_JavaUtilHashMap.put("param_sliceNum", String.valueOf(this.aC));
            if ((this.aH == 2) && (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("param_BdhTrans")))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("sn:").append(this.aC).append(";").append("tc_s:").append(this.jdField_d_of_type_Long).append(";").append("tc_h:").append(this.jdField_c_of_type_Long).append(";").append("tc_p:").append(this.jdField_e_of_type_Long).append(";");
              this.jdField_a_of_type_JavaUtilHashMap.put("param_BdhTrans", ((StringBuilder)localObject).toString());
            }
          }
          StatisticCollector.a(BaseApplication.getContext()).a(null, str, true, l, this.jdField_f_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
        }
        break;
      }
    }
    for (;;)
    {
      n();
      return;
      k = 1;
      break;
      c("<BDH_LOG> doReport() current status is INIT, return");
      return;
      str = "actC2CPicUploadV1";
      c("<BDH_LOG> doReport() current status is HTTP, choice C2C_PICUP_STATISTIC_TAG");
      break label172;
      str = "actC2CPicUploadV2";
      c("<BDH_LOG> doReport() current status is BDH, choice C2C_PICUP_STATISTIC_TAG_V2");
      break label172;
      localObject = this.jdField_f_of_type_JavaLangString;
      break label225;
      label704:
      k = 0;
      break label278;
      label709:
      if (this.at != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.remove("param_url");
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.at));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.J);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picmd5", this.jdField_d_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.jdField_f_of_type_Long));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_busi", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.d));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uniseq", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long));
      StatisticCollector.a(BaseApplication.getContext()).a(null, str, false, l, this.jdField_f_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
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
      localSendResult.jdField_b_of_type_Int = this.at;
      localSendResult.jdField_a_of_type_JavaLangString = this.J;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.b(localSendResult);
    }
  }
  
  public int e()
  {
    a("uiParam", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.toString());
    String str = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g;
    if (TextUtils.isEmpty(str))
    {
      a(9302, a(new Exception("filePath null")));
      d();
      return -1;
    }
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
    long l = localFile.length();
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long = l;
    this.jdField_f_of_type_Long = l;
    if (l <= 0L)
    {
      a(9071, a(new Exception("file size 0 " + str)));
      d();
      return -1;
    }
    str = FileUtils.a(str);
    if (!TextUtils.isEmpty(str))
    {
      if ((str.contains(FileUtils.jdField_b_of_type_JavaLangString)) || (!FileUtils.f(str)))
      {
        a(9072, str, a(str), null);
        d();
        return -1;
      }
      this.jdField_e_of_type_JavaLangString = str;
    }
    if (l >= 19922944L)
    {
      a(9063, str, a(str), null);
      d();
      return -1;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject instanceof TransferRequest.PicUpExtraInfo))) {
      this.jdField_d_of_type_Boolean = ((TransferRequest.PicUpExtraInfo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
    }
    return 0;
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Int = 0;
      localSendResult.jdField_a_of_type_Long = this.jdField_f_of_type_Long;
      localSendResult.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      if (this.jdField_f_of_type_JavaLangString == null) {}
      for (String str = this.S;; str = this.jdField_f_of_type_JavaLangString)
      {
        localSendResult.jdField_c_of_type_JavaLangString = str;
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.b(localSendResult);
        return;
      }
    }
    a(true);
  }
  
  public int f()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_e_of_type_Boolean = false;
      this.aD = 0;
      this.am = 0;
      if (this.aH != 1)
      {
        this.jdField_f_of_type_JavaLangString = null;
        this.S = null;
        this.jdField_h_of_type_Long = 0L;
      }
      this.T = null;
      this.i = false;
      this.al = 0;
      this.at = 0;
      this.J = "";
      this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a();
      v();
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.a.post(new grf(this));
    }
    return 0;
  }
  
  public void i()
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        a("pause", "");
      }
      d(1004);
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq != null)
      {
        RichProtoProc.b(this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq);
        this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
      }
    }
    switch (this.aH)
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
  
  void q()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.PicUpReq localPicUpReq = new RichProto.RichProtoReq.PicUpReq();
    localPicUpReq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangString;
    localPicUpReq.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString;
    localPicUpReq.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
    localPicUpReq.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    localPicUpReq.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    localPicUpReq.jdField_a_of_type_Long = this.jdField_f_of_type_Long;
    localPicUpReq.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localPicUpReq.jdField_a_of_type_Int = this.aj;
    localPicUpReq.jdField_b_of_type_Int = this.ak;
    boolean bool;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int == 1006)
    {
      bool = true;
      localPicUpReq.jdField_b_of_type_Boolean = bool;
      localPicUpReq.jdField_a_of_type_Boolean = this.jdField_d_of_type_Boolean;
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
      localRichProtoReq.jdField_a_of_type_JavaLangString = "c2c_pic_up";
      localRichProtoReq.jdField_a_of_type_JavaUtilList.add(localPicUpReq);
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (d()) {
        break label201;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
    }
    label201:
    do
    {
      return;
      bool = false;
      break;
      if (QLog.isColorLevel()) {
        a("requestStart", localRichProtoReq.toString());
      }
    } while (!e());
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = localRichProtoReq;
    RichProtoProc.a(localRichProtoReq);
  }
  
  public void r()
  {
    long l1 = 14600L;
    this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    long l4 = this.jdField_h_of_type_Long;
    long l2 = this.jdField_f_of_type_Long - l4;
    if (!this.jdField_g_of_type_Boolean)
    {
      long l3 = this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a(BaseApplication.getContext(), this.jdField_f_of_type_Long, this.jdField_h_of_type_Long);
      l1 = l3;
      if (l2 >= l3) {}
    }
    HttpNetReq localHttpNetReq;
    do
    {
      l1 = l2;
      byte[] arrayOfByte;
      for (;;)
      {
        l1 = Math.min(l1, 131072L);
        arrayOfByte = a((int)l4, (int)l1);
        if (arrayOfByte != null) {
          break;
        }
        d();
        return;
        if (l2 < 14600L) {
          l1 = this.jdField_f_of_type_Long - l4;
        }
      }
      a("sendingdata", "pos:" + l4 + "  transferData len:" + arrayOfByte.length);
      String str = a(arrayOfByte);
      localHttpNetReq = new HttpNetReq();
      localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
      localHttpNetReq.jdField_a_of_type_JavaLangString = str;
      localHttpNetReq.jdField_c_of_type_Int = 1;
      localHttpNetReq.jdField_a_of_type_ArrayOfByte = arrayOfByte;
      localHttpNetReq.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
      localHttpNetReq.jdField_c_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
      localHttpNetReq.o = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
      localHttpNetReq.n = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
      localHttpNetReq.jdField_a_of_type_Boolean = true;
      localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Range", "bytes=" + this.jdField_h_of_type_Long + "-");
      localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
      localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("mType", "picCu");
      if (l1 + l4 >= this.jdField_f_of_type_Long) {
        localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Connection", "close");
      }
    } while (!e());
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = localHttpNetReq;
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a(localHttpNetReq);
  }
  
  public void s()
  {
    if (!e()) {
      c("<BDH_LOG> sendMsg() do not send message, due to mIsCancel=true || mIsPause=true, current channel = " + this.aH);
    }
    do
    {
      return;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if ((localObject1 != null) && ((localObject1 instanceof MessageForPic)) && (((MessageForPic)localObject1).DSKey != 0L))
      {
        e();
        return;
      }
      d(1003);
    } while (!this.jdField_a_of_type_Boolean);
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
      if ((localObject1 != null) && (((localObject1 instanceof MessageForPic)) || ((localObject1 instanceof MessageForStructing)))) {
        break label295;
      }
      localObject2 = new StringBuilder().append("Mr_");
      if (localObject1 != null) {
        break label268;
      }
    }
    label268:
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
    label295:
    if ((localObject1 instanceof MessageForPic)) {
      ((MessageForPic)localObject1).richText = ((im_msg_body.RichText)localObject2);
    }
    if ((localObject1 instanceof MessageForStructing)) {
      ((MessageForStructing)localObject1).richText = ((im_msg_body.RichText)localObject2);
    }
    if (!d())
    {
      a(9366, "illegal app", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  public void t()
  {
    if (this.jdField_e_of_type_Boolean) {
      return;
    }
    if ((this.jdField_f_of_type_JavaLangString != null) || (this.S != null))
    {
      if (this.jdField_h_of_type_Long >= this.jdField_f_of_type_Long)
      {
        s();
        return;
      }
      u();
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.C2CPicUploadProcessor
 * JD-Core Version:    0.7.0.1
 */