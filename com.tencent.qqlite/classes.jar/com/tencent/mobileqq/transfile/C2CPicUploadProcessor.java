package com.tencent.mobileqq.transfile;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
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
import ehs;
import eht;
import ehu;
import ehv;
import ehw;
import ejc;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.ProxyIpManager;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.NotOnlineImage;
import tencent.im.msg.im_msg_body.RichMsg;
import tencent.im.msg.im_msg_body.RichText;

public class C2CPicUploadProcessor
  extends BaseUploadProcessor
{
  public static final String W = "C2CPicUploadProcessor";
  MessageObserver a;
  
  public C2CPicUploadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new ehw(this);
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.n = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.aT = 0;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3)).getProxyIp(3);
  }
  
  private im_msg_body.RichText a()
  {
    label700:
    label711:
    label713:
    for (int i = 1;; i = 0)
    {
      im_msg_body.RichText localRichText;
      for (;;)
      {
        try
        {
          localRichText = new im_msg_body.RichText();
          Object localObject1 = new im_msg_body.NotOnlineImage();
          ((im_msg_body.NotOnlineImage)localObject1).file_path.set(ByteStringMicro.copyFromUtf8(this.jdField_d_of_type_JavaLangString));
          ((im_msg_body.NotOnlineImage)localObject1).file_len.set((int)this.jdField_a_of_type_Long);
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.j != null) {
            ((im_msg_body.NotOnlineImage)localObject1).download_path.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.j));
          }
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i != null) {
            ((im_msg_body.NotOnlineImage)localObject1).res_id.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i));
          }
          ((im_msg_body.NotOnlineImage)localObject1).pic_md5.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ArrayOfByte));
          ((im_msg_body.NotOnlineImage)localObject1).pic_height.set(this.ap);
          ((im_msg_body.NotOnlineImage)localObject1).pic_width.set(this.ao);
          Object localObject2 = ((im_msg_body.NotOnlineImage)localObject1).original;
          if (!this.jdField_e_of_type_Boolean) {
            break label713;
          }
          ((PBUInt32Field)localObject2).set(i);
          if ("jpg".equals(this.jdField_e_of_type_JavaLangString)) {
            ((im_msg_body.NotOnlineImage)localObject1).img_type.set(2);
          }
          switch (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_Int)
          {
          case 1005: 
            if (QLog.isColorLevel()) {
              a("busiTypeStat", "uiBusiType:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_Int + " protoBusiType:" + ((im_msg_body.NotOnlineImage)localObject1).biz_type.get());
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
            localObject1 = this.U;
            localStructMsgItemImage.i = ((String)localObject1);
            localStructMsgItemImage.jdField_c_of_type_Long = this.jdField_a_of_type_Long;
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
    int k;
    int j;
    if ((localObject2 != null) && (((String)localObject2).length() > 0))
    {
      localObject1 = ((String)localObject2).split(";");
      localObject2 = localObject1[0];
      localObject4 = localObject1[2].split(":")[1];
      str1 = localObject1[3].split(":")[1];
      localObject3 = localObject1[4].split(":")[1];
      localObject2 = localObject1[5].split(":")[1];
      localObject1 = localObject1[6].split(":")[1];
      l1 = Long.valueOf(localObject5[4]).longValue() - Integer.valueOf(str1).intValue();
      k = (int)((float)this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long / ((float)l1 / 1000.0F) / 1000.0F);
      j = (int)((float)this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long / ((float)l8 / 1000.0F) / 1000.0F);
      if ((str1 == null) || (l1 < l8)) {
        break label1275;
      }
    }
    label724:
    label753:
    label1267:
    label1275:
    for (int i = 0;; i = 1)
    {
      String str3 = (String)arrayOfObject[2];
      int m = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      localObject5 = new SimpleDateFormat("MM-dd HH:mm:ss").format(Long.valueOf(System.currentTimeMillis()));
      StringBuilder localStringBuilder = new StringBuilder("双发结果:").append("发了第").append(m).append("张").append("\n");
      localStringBuilder.append("时间:").append((String)localObject5).append("\n");
      localStringBuilder.append("图片大小:").append(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long).append("bytes\n");
      localObject5 = localStringBuilder.append("老通道传输:").append(l8).append("ms,").append("速度:");
      if (l8 == 0L) {
        j = 0;
      }
      ((StringBuilder)localObject5).append(j).append("kbps").append("\n");
      localObject5 = localStringBuilder.append("新通道传输:").append(l1).append("ms,").append("速度:");
      if (l1 == 0L)
      {
        j = 0;
        ((StringBuilder)localObject5).append(j).append("kbps").append("\n");
        if (i == 0) {
          break label1259;
        }
        localObject5 = "结果:新通道传输较快\n";
        localStringBuilder.append((String)localObject5);
        localStringBuilder.append("老通道 Step:").append("申请").append(l5).append("ms_").append("传输").append(l7).append("ms_").append("消息").append(l6).append("ms").append("\n");
        localStringBuilder.append("新通道 Step:").append("申请").append(l2).append("ms_").append("传输").append(l4).append("ms_").append("消息").append(l3).append("ms").append("\n");
        localStringBuilder.append("群图Info:").append("接入:").append(arrayOfObject[3]).append("ms;").append("架平:").append(arrayOfObject[4]).append("ms").append("\n");
        localStringBuilder.append("新通道info:").append("接入:").append((String)localObject4).append("ms;").append("架平:").append(str1).append("ms").append("\n");
        localObject4 = localStringBuilder.append("Channel:");
        if (this.aM != 1) {
          break label1267;
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
        StatisticCollector.a(BaseApplication.getContext()).a(null, "actSFResult", paramBoolean, l1, this.jdField_a_of_type_Long, (HashMap)localObject1, "");
        return;
        l1 = this.jdField_f_of_type_Long;
        long l9 = this.g;
        localObject1 = null;
        localObject2 = null;
        localObject3 = null;
        str1 = String.valueOf(l9);
        localObject4 = null;
        break;
        j = k;
        break label724;
        localObject5 = "结果:老通道传输较快\n";
        break label753;
      }
    }
  }
  
  private void v()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.a.post(new eht(this));
  }
  
  private void w()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepBaseInfo.a();
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b.a();
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg$StepTransInfo.a();
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_ComTencentMobileqqTransfileFileMsg$StepBaseInfo.a();
    FileMsg localFileMsg = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
    long l = System.nanoTime();
    localFileMsg.jdField_f_of_type_Long = l;
    this.jdField_c_of_type_Long = l;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.g = 0L;
  }
  
  protected long a(long paramLong)
  {
    paramLong = this.jdField_a_of_type_Long - paramLong;
    if (!this.jdField_b_of_type_Boolean) {}
    for (paramLong = Math.min(paramLong, this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a(BaseApplication.getContext(), this.jdField_a_of_type_Long, this.jdField_h_of_type_Long));; paramLong = Math.min(paramLong, 14600L)) {
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
    if (!this.k)
    {
      paramArrayOfByte = MD5.toMD5(paramArrayOfByte);
      localStringBuilder.append("?ver=");
      localStringBuilder.append("2");
      localStringBuilder.append("&ukey=");
      localStringBuilder.append(this.V);
      localStringBuilder.append("&filekey=");
      localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
      localStringBuilder.append("&filesize=");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append("&bmd5");
      localStringBuilder.append(paramArrayOfByte);
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("cgi-bin/httpconn?htcmd=0x6ff0070&ver=5345");
      localStringBuilder.append("&ukey=");
      localStringBuilder.append(this.V);
      localStringBuilder.append("&filesize=");
      localStringBuilder.append(this.jdField_a_of_type_Long);
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
  
  public void a(NetResp paramNetResp)
  {
    super.a(paramNetResp);
    if ((this.jdField_h_of_type_Boolean) || (this.jdField_d_of_type_Boolean)) {}
    for (;;)
    {
      return;
      a("onResp", "result:" + paramNetResp.jdField_d_of_type_Int + " errCode:" + paramNetResp.jdField_e_of_type_Int + " errDesc:" + paramNetResp.jdField_a_of_type_JavaLangString);
      int i = paramNetResp.f;
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
      long l3;
      for (;;)
      {
        try
        {
          if (paramNetResp.jdField_d_of_type_Int != 0) {
            break label632;
          }
          this.ay = 0;
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
            a(-9527, null, b(i, l3), this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
            d();
            return;
          }
        }
        catch (Exception paramNetResp)
        {
          a(9343, MsfSdkUtils.getStackTraceString(new Exception("decode unknown exception")), "", this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
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
          i = Integer.parseInt((String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("X-Range"));
          l2 = i;
          if (l2 == 9223372036854775807L)
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
        for (;;)
        {
          localException2.printStackTrace();
          l2 = 9223372036854775807L;
        }
        a("decodeHttpResp", "from " + this.jdField_h_of_type_Long + " to " + l2 + " userReturnCode:" + l3);
        if (l2 <= this.jdField_h_of_type_Long)
        {
          if (this.aI < 3)
          {
            a("procHttpRespBody", "server offset rollback");
            this.aI += 1;
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Long = l2;
          this.jdField_h_of_type_Long = l2;
          a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, true);
          if (l2 >= this.jdField_a_of_type_Long) {
            break label620;
          }
          if (this.jdField_h_of_type_Boolean) {
            continue;
          }
          f();
          s();
          return;
        }
        a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, false);
        this.jdField_a_of_type_JavaUtilHashMap.put("returnCode", "" + l3);
        a(-9527, "", a(this.K, this.as), this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
        return;
        label620:
        t();
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b();
        return;
      }
    }
    label632:
    if ((paramNetResp.jdField_e_of_type_Int == 9364) && (this.ay < 3))
    {
      a("[netChg]", "failed.but net change detect.so retry");
      this.ay += 1;
      this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a();
      o();
      r();
      return;
    }
    if ((paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.jdField_a_of_type_ArrayOfByte.length >= 32768) && (RichMediaStrategy.a(paramNetResp.jdField_e_of_type_Int)))
    {
      this.jdField_b_of_type_Boolean = true;
      o();
      s();
      return;
    }
    a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, false);
    a(paramNetResp.jdField_e_of_type_Int, paramNetResp.jdField_a_of_type_JavaLangString);
    d();
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
    Object localObject;
    boolean bool;
    if (paramRichProtoResp != null)
    {
      int i = 0;
      if (i < paramRichProtoResp.jdField_a_of_type_JavaUtilList.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.C2CPicUpResp)paramRichProtoResp.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          a("procUrl", paramRichProtoReq.toString());
        }
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramRichProtoReq);
        if (paramRichProtoReq.jdField_c_of_type_Int == 0)
        {
          d(1002);
          String str;
          if (paramRichProtoReq.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_e_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long;
            localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
            str = paramRichProtoReq.jdField_a_of_type_JavaLangString;
            ((FileMsg)localObject).i = str;
            this.jdField_f_of_type_JavaLangString = str;
            localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
            paramRichProtoReq = paramRichProtoReq.jdField_b_of_type_JavaLangString;
            ((FileMsg)localObject).j = paramRichProtoReq;
            this.U = paramRichProtoReq;
            t();
          }
          for (;;)
          {
            i += 1;
            break;
            localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
            str = paramRichProtoReq.jdField_a_of_type_JavaLangString;
            ((FileMsg)localObject).i = str;
            this.jdField_f_of_type_JavaLangString = str;
            localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
            str = paramRichProtoReq.jdField_b_of_type_JavaLangString;
            ((FileMsg)localObject).j = str;
            this.U = str;
            this.V = paramRichProtoReq.jdField_c_of_type_JavaLangString;
            this.jdField_a_of_type_JavaUtilArrayList = paramRichProtoReq.jdField_a_of_type_JavaUtilArrayList;
            this.k = paramRichProtoReq.jdField_b_of_type_Boolean;
            bool = paramRichProtoReq.jdField_d_of_type_Boolean;
            this.jdField_b_of_type_Long = paramRichProtoReq.jdField_a_of_type_Long;
            if ((paramRichProtoReq.jdField_a_of_type_Int != 0) && (this.j) && (!paramRichProtoReq.jdField_c_of_type_Boolean)) {
              this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a(paramRichProtoReq.jdField_a_of_type_Int);
            }
            if (QLog.isColorLevel()) {
              QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> About to submit Transaction , from onBusiProtoResp.");
            }
            if (this.aM != 2) {
              break label314;
            }
            c("<BDH_LOG> onBusiProtoResp() last status is HTTP and resume by start");
            s();
          }
          label314:
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
    label546:
    for (;;)
    {
      if (bool)
      {
        c("<BDH_LOG> onBusiProtoResp() select BDH channel");
        this.aM = 1;
        c();
        break;
        if (!NetworkUtil.c(BaseApplication.getContext())) {
          break label546;
        }
        paramRichProtoReq = NetworkUtil.a(BaseApplication.getContext());
        if ((paramRichProtoReq == null) || ((!paramRichProtoReq.equalsIgnoreCase("cmwap")) && (!paramRichProtoReq.equalsIgnoreCase("ctwap")))) {
          break label546;
        }
        c("<BDH_LOG> onBusiProtoResp() APN=" + paramRichProtoReq);
        bool = false;
        continue;
      }
      c("<BDH_LOG> onBusiProtoResp() select HTTP channel");
      this.aM = 2;
      s();
      break;
      localObject = new StringBuilder().append("<BDH_LOG> onBusiProtoResp() CANNOT start BDH or HTTP channel. current status is not INIT, is");
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
          if (localMessageRecord.isMultiMsg)
          {
            a("updateDb", "is multiMsg");
            return;
          }
          if ((localMessageRecord instanceof MessageForPic))
          {
            localObject = (MessageForPic)localMessageRecord;
            ((MessageForPic)localObject).size = this.jdField_a_of_type_Long;
            if (this.jdField_f_of_type_JavaLangString == null) {}
            for (str = this.U;; str = this.jdField_f_of_type_JavaLangString)
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
    for (String str = this.U;; str = this.jdField_f_of_type_JavaLangString)
    {
      localStructMsgItemImage.i = str;
      localStructMsgItemImage.jdField_c_of_type_Long = this.jdField_a_of_type_Long;
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
    int i = this.aH;
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    ServerAddr localServerAddr = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(i % j);
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
    int i;
    do
    {
      return;
      this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
      byte[] arrayOfByte = HexUtil.a(this.V);
      ehu localehu = new ehu(this, SystemClock.uptimeMillis());
      this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 1, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h, (int)this.jdField_b_of_type_Long, arrayOfByte, this.jdField_a_of_type_ArrayOfByte, localehu);
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().submitTransactionTask(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
      if (QLog.isColorLevel()) {
        QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + i + " T_ID:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId() + " UniSeq:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long + " MD5:" + this.jdField_c_of_type_JavaLangString + " uuid:" + this.U + " Path:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.filePath + " Cmd:" + 1);
      }
    } while (i == 0);
    a(i, "SubmitError.", "", this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
    d();
  }
  
  protected void c(boolean paramBoolean)
  {
    int i = 2;
    String str2 = this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(1) + ";" + this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(2) + ";" + this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(3);
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_d_of_type_Int == 1030) {}
    while (((!paramBoolean) && (RichMediaStrategy.c(this.aw))) || (this.jdField_c_of_type_Boolean) || ((paramBoolean) && ((this.az & 0x2) > 0)) || ((!paramBoolean) && ((this.az & 0x1) > 0))) {
      return;
    }
    int j = this.az;
    String str1;
    label172:
    long l;
    if (paramBoolean)
    {
      this.az = (i | j);
      str1 = "actC2CPicUploadV2";
      switch (this.aM)
      {
      case 0: 
      default: 
        this.jdField_d_of_type_Long = System.currentTimeMillis();
        l = (System.nanoTime() - this.jdField_c_of_type_Long) / 1000000L;
        this.jdField_a_of_type_JavaUtilHashMap.put("param_step", str2);
        HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
        if (this.jdField_f_of_type_JavaLangString == null)
        {
          str2 = this.U;
          label225:
          localHashMap.put("param_uuid", str2);
          this.jdField_a_of_type_JavaUtilHashMap.put("param_toUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString);
          if (!paramBoolean) {
            break label323;
          }
          q();
          StatisticCollector.a(BaseApplication.getContext()).a(null, str1, true, l, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
        }
        break;
      }
    }
    for (;;)
    {
      n();
      return;
      i = 1;
      break;
      str1 = "actC2CPicUploadV1";
      break label172;
      str1 = "actC2CPicUploadV2";
      break label172;
      str2 = this.jdField_f_of_type_JavaLangString;
      break label225;
      label323:
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
      StatisticCollector.a(BaseApplication.getContext()).a(null, str1, false, l, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
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
    a("uiParam", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.toString());
    String str = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.h;
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
    this.jdField_a_of_type_Long = l;
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
        new Handler(Looper.getMainLooper()).post(new ehs(this));
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
      this.jdField_e_of_type_Boolean = ((TransferRequest.PicUpExtraInfo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
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
      localSendResult.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localSendResult.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      if (this.jdField_f_of_type_JavaLangString == null) {}
      for (String str = this.U;; str = this.jdField_f_of_type_JavaLangString)
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
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = false;
      this.jdField_h_of_type_Boolean = false;
      this.aI = 0;
      this.aH = 0;
      if (this.aM != 1)
      {
        this.jdField_f_of_type_JavaLangString = null;
        this.U = null;
        this.jdField_h_of_type_Long = 0L;
      }
      this.V = null;
      this.k = false;
      this.aG = 0;
      this.aw = 0;
      this.L = "";
      this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a();
      w();
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.a.post(new ehv(this));
    }
    return 0;
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
  
  void r()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.PicUpReq localPicUpReq = new RichProto.RichProtoReq.PicUpReq();
    localPicUpReq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangString;
    localPicUpReq.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString;
    localPicUpReq.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
    localPicUpReq.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    localPicUpReq.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    localPicUpReq.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    localPicUpReq.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localPicUpReq.jdField_a_of_type_Int = this.ao;
    localPicUpReq.jdField_b_of_type_Int = this.ap;
    boolean bool;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int == 1006)
    {
      bool = true;
      localPicUpReq.jdField_b_of_type_Boolean = bool;
      localPicUpReq.jdField_a_of_type_Boolean = this.jdField_e_of_type_Boolean;
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
  
  public void s()
  {
    long l1 = 14600L;
    this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    long l4 = this.jdField_h_of_type_Long;
    long l2 = this.jdField_a_of_type_Long - l4;
    if (!this.jdField_b_of_type_Boolean)
    {
      long l3 = this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a(BaseApplication.getContext(), this.jdField_a_of_type_Long, this.jdField_h_of_type_Long);
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
          l1 = this.jdField_a_of_type_Long - l4;
        }
      }
      a("sendingdata", "pos:" + l4 + "  transferData len:" + arrayOfByte.length);
      String str = a(a(arrayOfByte), this.jdField_a_of_type_JavaUtilArrayList);
      BaseTransProcessor.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilArrayList);
      localHttpNetReq = new HttpNetReq();
      localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
      localHttpNetReq.jdField_a_of_type_JavaLangString = str;
      localHttpNetReq.jdField_c_of_type_Int = 1;
      localHttpNetReq.jdField_a_of_type_ArrayOfByte = arrayOfByte;
      localHttpNetReq.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
      localHttpNetReq.jdField_d_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
      localHttpNetReq.n = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
      localHttpNetReq.m = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
      localHttpNetReq.jdField_a_of_type_Boolean = true;
      localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Range", "bytes=" + this.jdField_h_of_type_Long + "-");
      localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
      localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("mType", "picCu");
      if (l1 + l4 >= this.jdField_a_of_type_Long) {
        localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Connection", "close");
      }
    } while (!e());
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = localHttpNetReq;
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a(localHttpNetReq);
  }
  
  public void t()
  {
    if (!e())
    {
      c("<BDH_LOG> sendMsg() do not send message, due to mIsCancel=true || mIsPause=true, current channel = " + this.aM);
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if ((localObject1 != null) && ((localObject1 instanceof MessageForPic)) && (((MessageForPic)localObject1).DSKey != 0L))
    {
      e();
      return;
    }
    d(1003);
    if (!this.jdField_a_of_type_Boolean)
    {
      localObject1 = a();
      if (localObject1 == null)
      {
        a(9368, "constructpberror", null, this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null) {
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.a((im_msg_body.RichText)localObject1);
      }
      e();
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
      if ((localObject1 != null) && (((localObject1 instanceof MessageForPic)) || ((localObject1 instanceof MessageForStructing)))) {
        break label353;
      }
      localObject2 = new StringBuilder().append("Mr_");
      if (localObject1 != null) {
        break label326;
      }
    }
    label326:
    for (localObject1 = "null";; localObject1 = "" + ((MessageRecord)localObject1).msgtype)
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
    label353:
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
  
  public void u()
  {
    if (this.jdField_h_of_type_Boolean) {
      return;
    }
    if ((this.jdField_f_of_type_JavaLangString != null) || (this.U != null))
    {
      if (this.jdField_h_of_type_Long >= this.jdField_a_of_type_Long)
      {
        t();
        return;
      }
      v();
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.C2CPicUploadProcessor
 * JD-Core Version:    0.7.0.1
 */