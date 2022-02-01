package com.tencent.mobileqq.transfile;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.transfile.protohandler.GroupPicUpHandler;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PicUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PttUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.ReqCommon;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.GroupPicUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.GroupPttUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import gnj;
import gnk;
import gnl;
import gny;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.Ptt;
import tencent.im.msg.im_msg_body.RichMsg;
import tencent.im.msg.im_msg_body.RichText;

public class GroupPicUploadProcessor
  extends BaseUploadProcessor
{
  public static final String U = "GroupPicUploadProcessor";
  private static final boolean l = true;
  MessageObserver a;
  private SSCM b;
  boolean i;
  long jdField_j_of_type_Long;
  boolean jdField_j_of_type_Boolean = true;
  private long jdField_k_of_type_Long = -1L;
  boolean jdField_k_of_type_Boolean = false;
  
  public GroupPicUploadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    this.jdField_b_of_type_ComTencentWsttSSCMSSCM = new SSCM();
    this.jdField_i_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new gnl(this);
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
      int m = arrayOfByte[3];
      int n = arrayOfByte[2];
      int i1 = arrayOfByte[1];
      int i2 = arrayOfByte[0];
      return i2 << 24 & 0xFF000000 | m & 0xFF | n << 8 & 0xFF00 | i1 << 16 & 0xFF0000;
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
      if ((localMessageRecord != null) && (paramBoolean) && (this.jdField_k_of_type_Boolean)) {
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
    PicReq localPicReq = PicBusiManager.a(1, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.d);
    Object localObject = new PicUploadInfo.Builder();
    ((PicUploadInfo.Builder)localObject).d("51640996");
    if (this.jdField_d_of_type_Boolean)
    {
      m = 1;
      ((PicUploadInfo.Builder)localObject).c(m);
      if (!this.jdField_d_of_type_Boolean) {
        break label365;
      }
    }
    label365:
    for (int m = 1;; m = 0)
    {
      ((PicUploadInfo.Builder)localObject).i(m);
      ((PicUploadInfo.Builder)localObject).e(1000);
      ((PicUploadInfo.Builder)localObject).d(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.d);
      ((PicUploadInfo.Builder)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g);
      if (("251988669".equals(localMessageRecord.frienduin)) || ("79151594".equals(localMessageRecord.frienduin))) {
        ((PicUploadInfo.Builder)localObject).e("4141988669");
      }
      localObject = ((PicUploadInfo.Builder)localObject).a();
      ((PicUploadInfo)localObject).jdField_b_of_type_Long = localMessageRecord.uniseq;
      ((PicUploadInfo)localObject).jdField_b_of_type_Boolean = false;
      localPicReq.a((PicUploadInfo)localObject);
      localObject = localMessageRecord.frienduin;
      m = (int)this.jdField_c_of_type_Long;
      int n = (int)this.jdField_e_of_type_Long;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b.put(Long.valueOf(localMessageRecord.uniseq), new Object[] { paramString, localPicReq, localObject, Integer.valueOf(m), Integer.valueOf(n) });
      if (QLog.isColorLevel()) {
        QLog.d("GroupPicUploadProcessor", 2, "HighSpeedTest");
      }
      new gnj(this, localPicReq).execute(new Void[0]);
      return;
      m = 0;
      break;
    }
  }
  
  protected long a(long paramLong)
  {
    paramLong = this.jdField_f_of_type_Long - paramLong;
    if (!this.jdField_i_of_type_Boolean) {}
    for (paramLong = Math.min(paramLong, this.jdField_b_of_type_ComTencentWsttSSCMSSCM.a(BaseApplication.getContext(), this.jdField_f_of_type_Long, this.jdField_h_of_type_Long));; paramLong = Math.min(paramLong, 14600L)) {
      return Math.min(paramLong, 131072L);
    }
  }
  
  protected String a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new StringBuilder();
    ServerAddr localServerAddr = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    paramArrayOfByte.append("http://");
    paramArrayOfByte.append(localServerAddr.jdField_a_of_type_JavaLangString);
    if (localServerAddr.jdField_b_of_type_Int != 80)
    {
      paramArrayOfByte.append(":");
      paramArrayOfByte.append(localServerAddr.jdField_b_of_type_Int);
    }
    paramArrayOfByte.append("/cgi-bin/httpconn?htcmd=0x6ff0071&ver=5468&term=android&ukey=");
    paramArrayOfByte.append(this.T);
    paramArrayOfByte.append("&filesize=");
    paramArrayOfByte.append(this.jdField_f_of_type_Long);
    paramArrayOfByte.append("&range=");
    paramArrayOfByte.append(this.jdField_h_of_type_Long);
    paramArrayOfByte.append("&uin=");
    paramArrayOfByte.append(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangString);
    paramArrayOfByte.append("&groupcode=");
    paramArrayOfByte.append(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString);
    return paramArrayOfByte.toString();
  }
  
  protected im_msg_body.RichText a()
  {
    try
    {
      im_msg_body.Ptt localPtt = new im_msg_body.Ptt();
      localPtt.uint32_file_type.set(4);
      localPtt.uint64_src_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangString));
      localPtt.uint32_file_id.set((int)this.jdField_j_of_type_Long);
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        localObject = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        localPtt.uint32_server_ip.set(a(((ServerAddr)localObject).jdField_a_of_type_JavaLangString));
        localPtt.uint32_server_port.set(((ServerAddr)localObject).jdField_b_of_type_Int);
      }
      int m = MessageUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      im_msg_body.Elem localElem = new im_msg_body.Elem();
      localObject = new im_msg_body.ElemFlags2();
      ((im_msg_body.ElemFlags2)localObject).uint32_vip_status.set(m);
      localElem.elem_flags2.set((MessageMicro)localObject);
      localPtt.bool_valid.set(true);
      localPtt.bytes_file_md5.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ArrayOfByte));
      localPtt.bytes_file_name.set(ByteStringMicro.copyFromUtf8(this.jdField_d_of_type_JavaLangString));
      localObject = new im_msg_body.RichText();
      ((im_msg_body.RichText)localObject).ptt.set(localPtt);
      ((im_msg_body.RichText)localObject).elems.add(localElem);
    }
    catch (Exception localException)
    {
      do
      {
        Object localObject = null;
      } while (!QLog.isColorLevel());
      QLog.e("GroupPicUploadProcessor", 2, "Construct richtext error", localException);
    }
    return localObject;
    return null;
  }
  
  public void a()
  {
    super.a();
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
    q();
  }
  
  public void a(NetResp paramNetResp)
  {
    super.a(paramNetResp);
    if ((this.jdField_e_of_type_Boolean) || (this.jdField_c_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
    int m = paramNetResp.e;
    a("onResp", "result:" + paramNetResp.d + " errCode:" + paramNetResp.jdField_a_of_type_Long + " errDesc:" + paramNetResp.jdField_a_of_type_JavaLangString);
    long l3;
    try
    {
      if (paramNetResp.d != 0) {
        break label670;
      }
      this.av = 0;
      this.jdField_b_of_type_ComTencentWsttSSCMSSCM.b();
      if (paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("X-User-ReturnCode") == null) {
        break label785;
      }
      l3 = Long.parseLong((String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("X-User-ReturnCode"));
      if ((l3 != 0L) && (l3 != 9223372036854775807L))
      {
        a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, false);
        if (!GroupPicUpHandler.a((int)l3))
        {
          a(-9527, null, b(m, l3), this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
          d();
          return;
        }
      }
    }
    catch (Exception paramNetResp)
    {
      a(9343, AbstractImageDownloader.a(new Exception("decode unknown exception")), "", this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
      return;
    }
    Object localObject = paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("Range");
    if (localObject != null) {}
    for (;;)
    {
      long l2;
      try
      {
        m = Integer.parseInt((String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("Range"));
        l1 = m;
        l2 = l1;
        if (l1 == 9223372036854775807L)
        {
          localObject = paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("X-Range");
          l2 = l1;
          if (localObject == null) {}
        }
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
      try
      {
        m = Integer.parseInt((String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("X-Range"));
        l2 = m;
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        l2 = 9223372036854775807L;
        continue;
        a("decodeHttpResp", "from " + this.jdField_h_of_type_Long + " to " + l2 + " userReturnCode:" + l3);
        if (l2 > this.jdField_h_of_type_Long) {
          break label481;
        }
        if (this.aD >= 3) {
          break label525;
        }
        a("procHttpRespBody", "server offset rollback");
        this.aD += 1;
        label481:
        this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_d_of_type_Long = l2;
        this.jdField_h_of_type_Long = l2;
        a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, true);
        if (l2 >= this.jdField_f_of_type_Long) {
          break label598;
        }
        f();
        c();
        return;
        label525:
        a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, false);
        this.jdField_a_of_type_JavaUtilHashMap.put("returnCode", "" + l3);
        a(-9527, "", a(this.I, this.ap), this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
        return;
        label598:
        l1 = SystemClock.uptimeMillis();
        l2 = this.jdField_k_of_type_Long;
        if (!QLog.isDevelopLevel()) {
          break label665;
        }
        QLog.d("GroupPicUploadProcessor", 4, "<BDH_LOG> Transaction End : Success. Old : SendTotalCost:" + (l1 - l2) + "ms" + " ,fileSize:" + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long);
        label665:
        r();
        return;
      }
      if (l2 == 9223372036854775807L)
      {
        a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, false);
        a(-9527, "no header range", a(this.I, this.aq), this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
        d();
        return;
      }
      label670:
      if ((paramNetResp.jdField_a_of_type_Long == 9364L) && (this.av < 3))
      {
        a("[netChg]", "failed.but net change detect.so retry");
        this.av += 1;
        o();
        q();
        return;
      }
      if ((paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.jdField_a_of_type_ArrayOfByte.length >= 32768) && (RichMediaStrategy.a((int)paramNetResp.jdField_a_of_type_Long)))
      {
        this.jdField_i_of_type_Boolean = true;
        o();
        c();
        return;
      }
      a(this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramNetResp, false);
      a((int)paramNetResp.jdField_a_of_type_Long, paramNetResp.jdField_a_of_type_JavaLangString);
      d();
      return;
      label785:
      l3 = 9223372036854775807L;
      break;
      long l1 = 9223372036854775807L;
    }
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
    int m;
    if (paramRichProtoResp != null)
    {
      m = 0;
      if (m < paramRichProtoResp.jdField_a_of_type_JavaUtilList.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.RespCommon)paramRichProtoResp.jdField_a_of_type_JavaUtilList.get(m);
        if (QLog.isColorLevel()) {
          a("procUrl", paramRichProtoReq.toString());
        }
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramRichProtoReq);
        if (!(paramRichProtoReq instanceof RichProto.RichProtoResp.GroupPicUpResp)) {
          break label209;
        }
        paramRichProtoReq = (RichProto.RichProtoResp.GroupPicUpResp)paramRichProtoReq;
        if (paramRichProtoReq.jdField_c_of_type_Int == 0) {
          if (paramRichProtoReq.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long;
            this.jdField_j_of_type_Long = paramRichProtoReq.jdField_a_of_type_Long;
            r();
          }
        }
      }
    }
    for (;;)
    {
      m += 1;
      break;
      this.jdField_j_of_type_Long = paramRichProtoReq.jdField_a_of_type_Long;
      this.T = paramRichProtoReq.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_JavaUtilArrayList = paramRichProtoReq.jdField_a_of_type_JavaUtilArrayList;
      this.jdField_h_of_type_Long = paramRichProtoReq.jdField_b_of_type_Int;
      this.jdField_i_of_type_Long = paramRichProtoReq.jdField_a_of_type_Int;
      if ((paramRichProtoReq.jdField_a_of_type_Int != 0) && (this.jdField_h_of_type_Boolean) && (!paramRichProtoReq.jdField_b_of_type_Boolean)) {
        this.jdField_b_of_type_ComTencentWsttSSCMSSCM.a(paramRichProtoReq.jdField_a_of_type_Int);
      }
      c();
      continue;
      d();
      return;
      label209:
      if ((paramRichProtoReq instanceof RichProto.RichProtoResp.GroupPttUpResp))
      {
        paramRichProtoReq = (RichProto.RichProtoResp.GroupPttUpResp)paramRichProtoReq;
        if (paramRichProtoReq.jdField_c_of_type_Int != 0) {
          break label313;
        }
        if (paramRichProtoReq.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long;
          this.jdField_j_of_type_Long = paramRichProtoReq.jdField_a_of_type_Long;
          r();
        }
        else
        {
          this.jdField_j_of_type_Long = paramRichProtoReq.jdField_a_of_type_Long;
          this.T = paramRichProtoReq.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_JavaUtilArrayList = paramRichProtoReq.jdField_a_of_type_JavaUtilArrayList;
          this.jdField_h_of_type_Long = paramRichProtoReq.jdField_b_of_type_Int;
          this.jdField_i_of_type_Long = paramRichProtoReq.jdField_a_of_type_Int;
          c();
        }
      }
    }
    label313:
    d();
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
          if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 2) && ((localMessageRecord instanceof MessageForPtt)))
          {
            localObject = (MessageForPtt)localMessageRecord;
            ((MessageForPtt)localObject).url = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g;
            ((MessageForPtt)localObject).fileSize = this.jdField_f_of_type_Long;
            ((MessageForPtt)localObject).urlAtServer = this.jdField_d_of_type_JavaLangString;
            ((MessageForPtt)localObject).itemType = 2;
            ((MessageForPtt)localObject).groupFileID = this.jdField_j_of_type_Long;
            ((MessageForPtt)localObject).md5 = this.jdField_c_of_type_JavaLangString;
            ((MessageForPtt)localObject).serial();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, localMessageRecord.uniseq, ((MessageForPtt)localObject).msgData);
            return;
          }
          if ((localMessageRecord instanceof MessageForPic))
          {
            localObject = (MessageForPic)localMessageRecord;
            ((MessageForPic)localObject).path = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g;
            ((MessageForPic)localObject).size = this.jdField_f_of_type_Long;
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
    localStructMsgItemImage.jdField_c_of_type_Long = this.jdField_f_of_type_Long;
    localStructMsgItemImage.jdField_b_of_type_Long = this.jdField_j_of_type_Long;
    localStructMsgItemImage.jdField_d_of_type_Long = localMessageRecord.time;
    ((MessageForStructing)localObject).msgData = ((MessageForStructing)localObject).structingMsg.getBytes();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, localMessageRecord.uniseq, ((MessageForStructing)localObject).msgData);
  }
  
  protected im_msg_body.RichText b()
  {
    for (;;)
    {
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
        if (!this.jdField_d_of_type_Boolean) {
          break label702;
        }
        m = 1;
        ((PBUInt32Field)localObject1).set(m);
        m = 200;
        switch (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.d)
        {
        case 1005: 
          ((im_msg_body.CustomFace)localObject2).uint32_width.set(this.aj);
          ((im_msg_body.CustomFace)localObject2).uint32_height.set(this.ak);
          ((im_msg_body.CustomFace)localObject2).uint32_size.set((int)this.jdField_f_of_type_Long);
          ((im_msg_body.CustomFace)localObject2).uint32_source.set(m);
          if (QLog.isColorLevel()) {
            a("busiTypeStat", "uiBusiType:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.d + " protoBusiType:" + ((im_msg_body.CustomFace)localObject2).biz_type.get());
          }
          localObject1 = new im_msg_body.RichText();
          Object localObject3 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject3).custom_face.set((MessageMicro)localObject2);
          ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject3);
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
          if (!(localObject3 instanceof MessageForStructing)) {
            break label700;
          }
          localObject2 = (MessageForStructing)localObject3;
          if ((((MessageForStructing)localObject2).structingMsg == null) || (!(((MessageForStructing)localObject2).structingMsg instanceof StructMsgForImageShare))) {
            break label700;
          }
          StructMsgItemImage localStructMsgItemImage = ((StructMsgForImageShare)((MessageForStructing)localObject2).structingMsg).getFirstImageElement();
          if (localStructMsgItemImage == null) {
            break label700;
          }
          localStructMsgItemImage.j = this.jdField_c_of_type_JavaLangString;
          localStructMsgItemImage.i = this.jdField_d_of_type_JavaLangString;
          localStructMsgItemImage.jdField_b_of_type_Long = this.jdField_j_of_type_Long;
          localStructMsgItemImage.jdField_d_of_type_Long = ((MessageRecord)localObject3).time;
          localStructMsgItemImage.jdField_c_of_type_Long = this.jdField_f_of_type_Long;
          localObject3 = ((MessageForStructing)localObject2).structingMsg.getXmlBytes();
          if ((TextUtils.isEmpty(((MessageForStructing)localObject2).frienduin)) || (localObject3 == null)) {
            break label700;
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
        Object localObject2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("GroupPicUploadProcessor", 2, "Construct richtext error", localException);
        localException.printStackTrace();
        return null;
      }
      ((im_msg_body.CustomFace)localObject2).biz_type.set(1);
      int m = 102;
      continue;
      ((im_msg_body.CustomFace)localObject2).biz_type.set(2);
      m = 105;
      continue;
      ((im_msg_body.CustomFace)localObject2).biz_type.set(3);
      m = 101;
      continue;
      ((im_msg_body.CustomFace)localObject2).biz_type.set(4);
      m = 104;
      continue;
      ((im_msg_body.CustomFace)localObject2).biz_type.set(5);
      m = 103;
      continue;
      ((im_msg_body.CustomFace)localObject2).biz_type.set(6);
      m = 106;
      continue;
      ((im_msg_body.CustomFace)localObject2).biz_type.set(7);
      continue;
      continue;
      label700:
      return localException;
      label702:
      m = 0;
    }
  }
  
  public void c()
  {
    if (this.jdField_k_of_type_Long == -1L) {
      this.jdField_k_of_type_Long = SystemClock.uptimeMillis();
    }
    super.c();
  }
  
  protected void c(boolean paramBoolean)
  {
    int m = 2;
    String str2 = this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(1) + ";" + this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(2) + ";" + this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(3);
    if (QLog.isColorLevel()) {
      QLog.d("GroupPicUploadProcessor", 2, "doDSReport : GroupPic doReport : result:" + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.d == 1030) {}
    while (((!paramBoolean) && (RichMediaStrategy.c(this.at))) || (this.jdField_b_of_type_Boolean) || ((paramBoolean) && ((this.aw & 0x2) > 0)) || ((!paramBoolean) && ((this.aw & 0x1) > 0))) {
      return;
    }
    int n = this.aw;
    String str1;
    label187:
    long l1;
    if (paramBoolean)
    {
      this.aw = (m | n);
      if (!this.jdField_j_of_type_Boolean) {
        break label482;
      }
      if (!this.jdField_k_of_type_Boolean) {
        break label474;
      }
      str1 = "actGroupPicUploadV1";
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      l1 = (System.nanoTime() - this.jdField_a_of_type_Long) / 1000000L;
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", str2);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fileid", String.valueOf(this.jdField_j_of_type_Long));
      if (!paramBoolean) {
        break label510;
      }
      if ((this.jdField_d_of_type_Long <= 0L) || (this.jdField_e_of_type_Long <= 0L)) {
        break label505;
      }
      m = 1;
      label281:
      if ((this.jdField_f_of_type_Boolean) && (m != 0))
      {
        this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
        this.jdField_a_of_type_JavaLangStringBuilder.append("s").append(this.aC).append("_").append("tr").append(this.jdField_d_of_type_Long).append("_").append("ht").append(this.jdField_c_of_type_Long).append("_").append("pic").append(this.jdField_e_of_type_Long).append(";");
        this.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", String.valueOf(this.jdField_e_of_type_Long));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_CostEach", this.jdField_a_of_type_JavaLangStringBuilder.toString());
        this.jdField_a_of_type_JavaUtilHashMap.put("param_sliceNum", String.valueOf(this.aC));
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, str1, true, l1, this.jdField_f_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      n();
      return;
      m = 1;
      break;
      label474:
      str1 = "actGrpPttUp";
      break label187;
      label482:
      if (this.jdField_k_of_type_Boolean) {}
      for (str1 = "actDiscussPicUpload";; str1 = "actDisscusPttUp") {
        break;
      }
      label505:
      m = 0;
      break label281;
      label510:
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
      StatisticCollector.a(BaseApplication.getContext()).a(null, str1, false, l1, this.jdField_f_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
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
    boolean bool2 = true;
    int n = 0;
    super.e();
    a("uiParam", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.toString());
    boolean bool1;
    String str;
    int m;
    if (1 == this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int)
    {
      bool1 = true;
      this.jdField_j_of_type_Boolean = bool1;
      bool1 = bool2;
      if (2 == this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int) {
        bool1 = false;
      }
      this.jdField_k_of_type_Boolean = bool1;
      str = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g;
      if (!TextUtils.isEmpty(str)) {
        break label113;
      }
      a(9302, a(new Exception("filePath null")));
      d();
      m = -1;
    }
    label113:
    do
    {
      do
      {
        return m;
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
        this.jdField_f_of_type_Long = l1;
        if (l1 <= 0L)
        {
          a(9071, a(new Exception("file size 0 " + str)));
          d();
          return -1;
        }
        if (this.jdField_k_of_type_Boolean)
        {
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
        m = n;
      } while (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject == null);
      m = n;
    } while (!(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject instanceof TransferRequest.PicUpExtraInfo));
    this.jdField_d_of_type_Boolean = ((TransferRequest.PicUpExtraInfo)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
    return 0;
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Long = this.jdField_f_of_type_Long;
      localSendResult.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      localSendResult.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      localSendResult.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g;
      localSendResult.jdField_b_of_type_Long = this.jdField_j_of_type_Long;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.b(localSendResult);
    }
    for (;;)
    {
      if (!this.jdField_k_of_type_Boolean) {
        d(1003);
      }
      return;
      a(true);
    }
  }
  
  public int f()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_e_of_type_Boolean = false;
      d(1002);
      this.aD = 0;
      this.am = 0;
      this.T = null;
      this.al = 0;
      this.jdField_h_of_type_Long = 0L;
      this.at = 0;
      this.J = "";
      this.jdField_b_of_type_ComTencentWsttSSCMSSCM.a();
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.a.post(new gnk(this));
    }
    return 0;
  }
  
  protected void p()
  {
    int m = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq instanceof HttpNetReq))
    {
      if (!this.jdField_j_of_type_Boolean) {
        break label72;
      }
      if (m == 2) {
        ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaUtilHashMap.put("mType", "pttGu");
      }
    }
    else
    {
      return;
    }
    ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaUtilHashMap.put("mType", "picGu");
    return;
    label72:
    if (m == 2)
    {
      ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaUtilHashMap.put("mType", "pttDu");
      return;
    }
    ((HttpNetReq)this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq).jdField_a_of_type_JavaUtilHashMap.put("mType", "picDu");
  }
  
  void q()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    Object localObject;
    String str;
    if (this.jdField_k_of_type_Boolean)
    {
      localObject = new RichProto.RichProtoReq.PicUpReq();
      ((RichProto.RichProtoReq.PicUpReq)localObject).jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      ((RichProto.RichProtoReq.PicUpReq)localObject).jdField_a_of_type_Long = this.jdField_f_of_type_Long;
      ((RichProto.RichProtoReq.PicUpReq)localObject).jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      ((RichProto.RichProtoReq.PicUpReq)localObject).jdField_a_of_type_Int = this.aj;
      ((RichProto.RichProtoReq.PicUpReq)localObject).jdField_b_of_type_Int = this.ak;
      ((RichProto.RichProtoReq.PicUpReq)localObject).jdField_a_of_type_Boolean = this.jdField_d_of_type_Boolean;
      ((RichProto.RichProtoReq.ReqCommon)localObject).jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangString;
      ((RichProto.RichProtoReq.ReqCommon)localObject).jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString;
      ((RichProto.RichProtoReq.ReqCommon)localObject).jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
      ((RichProto.RichProtoReq.ReqCommon)localObject).jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
      if (!this.jdField_k_of_type_Boolean) {
        break label242;
      }
      str = "grp_pic_up";
      label138:
      localRichProtoReq.jdField_a_of_type_JavaLangString = str;
      localRichProtoReq.jdField_a_of_type_JavaUtilList.add(localObject);
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (d()) {
        break label249;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
    }
    label242:
    label249:
    do
    {
      return;
      localObject = new RichProto.RichProtoReq.PttUpReq();
      ((RichProto.RichProtoReq.PttUpReq)localObject).jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      ((RichProto.RichProtoReq.PttUpReq)localObject).jdField_b_of_type_Int = ((int)this.jdField_f_of_type_Long);
      ((RichProto.RichProtoReq.PttUpReq)localObject).jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      ((RichProto.RichProtoReq.PttUpReq)localObject).jdField_a_of_type_Int = QQRecorder.a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g);
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
  
  void r()
  {
    if (!e()) {
      return;
    }
    this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    if (this.jdField_k_of_type_Boolean) {
      d(1003);
    }
    if (this.jdField_j_of_type_Boolean)
    {
      s();
      return;
    }
    t();
  }
  
  void s()
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
      if ((localObject1 instanceof MessageForPtt)) {
        ((MessageForPtt)localObject1).richText = ((im_msg_body.RichText)localObject2);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      return;
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
        break label468;
      }
      localObject2 = new StringBuilder().append("Mr_");
      if (localObject1 != null) {
        break label441;
      }
    }
    label441:
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
    label468:
    if ((localObject1 instanceof MessageForPic)) {
      ((MessageForPic)localObject1).richText = ((im_msg_body.RichText)localObject2);
    }
    if ((localObject1 instanceof MessageForStructing)) {
      ((MessageForStructing)localObject1).richText = ((im_msg_body.RichText)localObject2);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
  
  void t()
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
      if ((localObject1 instanceof MessageForPtt)) {
        ((MessageForPtt)localObject1).richText = ((im_msg_body.RichText)localObject2);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      return;
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
        break label468;
      }
      localObject2 = new StringBuilder().append("Mr_");
      if (localObject1 != null) {
        break label441;
      }
    }
    label441:
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
    label468:
    if ((localObject1 instanceof MessageForPic)) {
      ((MessageForPic)localObject1).richText = ((im_msg_body.RichText)localObject2);
    }
    if ((localObject1 instanceof MessageForStructing)) {
      ((MessageForStructing)localObject1).richText = ((im_msg_body.RichText)localObject2);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.GroupPicUploadProcessor
 * JD-Core Version:    0.7.0.1
 */