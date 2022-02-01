import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.litetransfersdk.ActionInfo;
import com.tencent.litetransfersdk.FTNInfo;
import com.tencent.litetransfersdk.FTNNotify;
import com.tencent.litetransfersdk.FileControl;
import com.tencent.litetransfersdk.LiteTransferListenerCallback;
import com.tencent.litetransfersdk.LiteTransferOperatorCallback;
import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.litetransfersdk.MsgCSBody;
import com.tencent.litetransfersdk.MsgCSBody0x211;
import com.tencent.litetransfersdk.MsgCSBody0x211_0x7;
import com.tencent.litetransfersdk.MsgCSBody0x345;
import com.tencent.litetransfersdk.MsgCSBody0x346;
import com.tencent.litetransfersdk.MsgHeader;
import com.tencent.litetransfersdk.MsgSCBody;
import com.tencent.litetransfersdk.MsgSCBody0x211;
import com.tencent.litetransfersdk.MsgSCBody0x211_0x7;
import com.tencent.litetransfersdk.MsgSCBody0x345;
import com.tencent.litetransfersdk.NFCInfo;
import com.tencent.litetransfersdk.NFCNotify;
import com.tencent.litetransfersdk.ProtocolHelper;
import com.tencent.litetransfersdk.RFCInfoNotify;
import com.tencent.litetransfersdk.ReportItem;
import com.tencent.litetransfersdk.Session;
import com.tencent.litetransfersdk.SubCmd0x6ReqBody;
import com.tencent.litetransfersdk.SubCmd0x6RspBody;
import com.tencent.mobileqq.app.DataLineHandler.10;
import com.tencent.mobileqq.app.DataLineHandler.11;
import com.tencent.mobileqq.app.DataLineHandler.12;
import com.tencent.mobileqq.app.DataLineHandler.13;
import com.tencent.mobileqq.app.DataLineHandler.14;
import com.tencent.mobileqq.app.DataLineHandler.15;
import com.tencent.mobileqq.app.DataLineHandler.16;
import com.tencent.mobileqq.app.DataLineHandler.4;
import com.tencent.mobileqq.app.DataLineHandler.5;
import com.tencent.mobileqq.app.DataLineHandler.6;
import com.tencent.mobileqq.app.DataLineHandler.7;
import com.tencent.mobileqq.app.DataLineHandler.8;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.Long;>;
import java.util.Set;
import java.util.Timer;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import msf.msgsvc.msg_svc.PbSendMsgResp;
import msf.msgsvc.msg_svc.RoutingHead;
import msf.msgsvc.msg_svc.Trans0x211;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x6ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x6RspBody;
import tencent.im.cs.cmd0x346.cmd0x346.FileQueryReq;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.msg.im_msg_head.InstCtrl;
import tencent.im.msg.im_msg_head.InstInfo;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.FTNNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.FileControl;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.GenericSubCmd;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.MoloNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.MpFileNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.MsgHeader;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.NFCNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.RNFCNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x9.C2CType0x211_SubC2CType0x9.MsgBody;

public class acde
  extends accg
  implements LiteTransferListenerCallback, LiteTransferOperatorCallback
{
  private static int cuN;
  private Timer A;
  private long Pl;
  private long Pm;
  private long Pn = -1L;
  private long Po = -1L;
  private achq jdField_a_of_type_Achq = new acdj(this);
  public acio a;
  private aviq jdField_a_of_type_Aviq;
  public LiteTransferWrapper a;
  public ProtocolHelper a;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
  public String aR = acbn.bkw;
  private BroadcastReceiver aW;
  private BroadcastReceiver aX;
  private ci jdField_b_of_type_Ci;
  private cl jdField_b_of_type_Cl = new cl(this);
  public cp b;
  public boolean bHf;
  private boolean bHg;
  private boolean bHh;
  private boolean bHi;
  public int cuM;
  private int dI;
  private int dJ;
  protected HashMap<Long, amzx> iE = new HashMap();
  private HashMap<Long, Session> iF = new HashMap();
  private ArrayList<amzy> sV = new ArrayList();
  private List<Long> xm;
  private List<Long> xn;
  private List<Integer> xo = new ArrayList();
  
  acde(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper = new LiteTransferWrapper(this, this);
    this.jdField_a_of_type_Acio = new acio(paramQQAppInterface);
    this.jdField_b_of_type_Cp = new cp(paramQQAppInterface);
    this.jdField_b_of_type_Ci = new ci(paramQQAppInterface);
    this.dI = BaseApplication.getContext().getResources().getDimensionPixelSize(2131297045);
    this.dJ = BaseApplication.getContext().getResources().getDimensionPixelSize(2131297044);
    this.aW = new acdf(this);
    this.aX = new acdh(this, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new acdi(this);
    this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper = new ProtocolHelper(paramQQAppInterface, 0);
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.intent.logout");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
    localIntentFilter.addAction("mqq.intent.action.FORCE_LOGOUT");
    localIntentFilter.addAction("mqq.intent.action.EXIT_" + paramQQAppInterface.getApp().getPackageName());
    localIntentFilter.addAction("mqq.intent.action.LOGOUT");
    paramQQAppInterface.getApp().registerReceiver(this.aX, localIntentFilter);
    localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
    localIntentFilter.addAction("android.intent.action.MEDIA_UNMOUNTABLE");
    localIntentFilter.addAction("android.intent.action.MEDIA_EJECT");
    localIntentFilter.addAction("android.intent.action.MEDIA_REMOVED");
    localIntentFilter.addDataScheme("file");
    paramQQAppInterface.getApp().registerReceiver(this.aW, localIntentFilter);
    AppNetConnInfo.registerConnectionChangeReceiver(paramQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Achq);
    this.jdField_a_of_type_Aviq = new aviq(paramQQAppInterface);
    cIf();
    cIg();
    this.bHi = false;
  }
  
  private void A(ArrayList<Session> paramArrayList, boolean paramBoolean)
  {
    boolean bool = true;
    if (!aqiw.isNetSupport(BaseApplication.getContext())) {
      this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.showNoNetworkDialog();
    }
    while (paramArrayList.size() == 0) {
      return;
    }
    LiteTransferWrapper localLiteTransferWrapper = this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper;
    if (paramArrayList.size() == 1) {
      bool = false;
    }
    localLiteTransferWrapper.SendGroup(paramArrayList, paramBoolean, bool);
  }
  
  public static int a(FileManagerEntity paramFileManagerEntity)
  {
    int j = 255;
    if (paramFileManagerEntity == null)
    {
      QLog.i("DataLineHandler", 2, "转发文件, FileManagerEntity为空");
      return j;
    }
    int i;
    if ((!TextUtils.isEmpty(paramFileManagerEntity.getFilePath())) && (new File(paramFileManagerEntity.getFilePath()).exists())) {
      i = 0;
    }
    for (;;)
    {
      j = i;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i("DataLineHandler", 4, "是否可以转发到数据线, [" + paramFileManagerEntity.peerType + "]， name[" + paramFileManagerEntity.fileName + "], LocalPath[" + paramFileManagerEntity.getFilePath() + "], FileSize[" + paramFileManagerEntity.fileSize + "], fileFrom[" + i + "], peerType[" + paramFileManagerEntity.peerType + "], peerUin[" + paramFileManagerEntity.peerUin + "], cloudType[" + paramFileManagerEntity.getCloudType());
      return i;
      i = j;
      switch (paramFileManagerEntity.getCloudType())
      {
      case 3: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      default: 
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.e("dataline", 2, "FileManagerEntity->cloudType 转 ForwardFileInfo->type， 未识别的cloudType[" + paramFileManagerEntity.getCloudType());
          i = j;
        }
        break;
      case 1: 
        switch (paramFileManagerEntity.peerType)
        {
        default: 
          if (QLog.isColorLevel())
          {
            QLog.i("DataLineHandler", 2, "转发文件, 未知的文件来源默认为C2C, peerType[" + paramFileManagerEntity.peerType + "]， name[" + paramFileManagerEntity.fileName + "], LocalPath[" + paramFileManagerEntity.getFilePath() + "], FileSize[" + paramFileManagerEntity.fileSize + "], fileFrom[" + 1 + "], peerUin[" + paramFileManagerEntity.peerUin + "], cloudType[" + paramFileManagerEntity.getCloudType());
            i = 1;
          }
          break;
        case 0: 
          i = 1;
          break;
        case 3000: 
          i = 3;
          break;
        case 1: 
          i = 2;
          break;
        case 6000: 
          i = 5;
        }
        break;
      case 2: 
        i = 4;
        break;
      case 4: 
        i = 2;
        break;
      case 10: 
        i = 6;
        continue;
        i = 1;
      }
    }
  }
  
  private ToServiceMsg a(boolean paramBoolean, long paramLong1, String paramString, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, long paramLong2, int paramInt4)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("MessageSvc.PbSendMsg");
    localToServiceMsg.extraData.putInt("SEND_MSG_CMD_MSG_TYPE", 1);
    localToServiceMsg.extraData.putInt("ROUNTING_TYPE", 13);
    localToServiceMsg.extraData.putBoolean("ISFROM_DATALINE", true);
    localToServiceMsg.extraData.putInt("DATALINE_CMD", paramInt3);
    localToServiceMsg.addAttribute("cookie", Long.valueOf(paramLong1));
    localToServiceMsg.addAttribute("sendFromNative", Boolean.valueOf(paramBoolean));
    localToServiceMsg.extraData.putInt("DATALINE_TRYINDEX", 0);
    paramLong1 = ahav.ge();
    long l = ahav.bA();
    anbn localanbn = new anbn();
    localanbn.dEY = paramInt2;
    localanbn.msg = paramArrayOfByte;
    paramString = a(13, paramString, localanbn, l, anbk.ac(paramLong1), paramLong2);
    paramArrayOfByte = new im_msg_head.InstInfo();
    paramInt1 = 1;
    if (paramInt4 == 3) {
      paramInt1 = 1001;
    }
    paramArrayOfByte.uint32_apppid.set(paramInt1);
    paramArrayOfByte.uint32_instid.set(0);
    paramArrayOfByte.enum_device_type.set(paramInt4);
    paramArrayOfByte.setHasFlag(true);
    paramString.routing_head.trans_0x211.inst_ctrl.rpt_msg_send_to_inst.add(paramArrayOfByte);
    paramArrayOfByte = new im_msg_head.InstInfo();
    paramArrayOfByte.uint32_apppid.set(1001);
    paramArrayOfByte.uint32_instid.set(AppSetting.getAppId());
    paramArrayOfByte.enum_device_type.set(2);
    paramArrayOfByte.setHasFlag(true);
    paramString.routing_head.trans_0x211.inst_ctrl.msg_from_inst = paramArrayOfByte;
    paramString.routing_head.trans_0x211.inst_ctrl.setHasFlag(true);
    localToServiceMsg.putWupBuffer(paramString.toByteArray());
    sendPbReq(localToServiceMsg);
    return localToServiceMsg;
  }
  
  private msg_svc.PbSendMsgReq a(int paramInt1, String paramString, anbn paramanbn, long paramLong1, int paramInt2, long paramLong2)
  {
    return anbh.a(this.app, paramInt1, paramString, paramanbn, paramLong1, paramInt2);
  }
  
  private void a(int paramInt1, FTNNotify paramFTNNotify, long paramLong, int paramInt2)
  {
    SubMsgType0x7.MsgBody localMsgBody = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.MsgBodyFromFTNNotify(paramFTNNotify, paramLong, this.aR, paramInt2);
    a(paramInt1, 1004, localMsgBody, paramFTNNotify.uint64_sessionid);
  }
  
  private void a(int paramInt1, FileControl paramFileControl, long paramLong, int paramInt2)
  {
    if (!aqiw.isNetSupport(BaseApplication.getContext())) {
      return;
    }
    SubMsgType0x7.MsgBody localMsgBody = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.MsgBodyFromFileControl(paramFileControl, paramLong, this.aR, paramInt2);
    a(paramInt1, 1005, localMsgBody, paramFileControl.uint64_sessionid);
  }
  
  private void a(int paramInt, MsgCSBody0x211 paramMsgCSBody0x211)
  {
    switch (paramMsgCSBody0x211.uMsgSubType)
    {
    default: 
      QLog.d("DataLineHandler", 1, "SendPbMsg: cannot recognize the pb msg form 0X211");
      return;
    }
    a(paramInt, paramMsgCSBody0x211.msgBody0x211_0x7);
  }
  
  private void a(int paramInt, MsgCSBody0x211_0x7 paramMsgCSBody0x211_0x7)
  {
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i = 0;
    long l = paramMsgCSBody0x211_0x7.msgHeader.uint64_dst_uin;
    switch (paramMsgCSBody0x211_0x7.uMsgSubCmd)
    {
    }
    for (;;)
    {
      QLog.d("DataLineHandler", 1, "SendPbMsg: cannot recognize the pb msg form 0X211_0x7");
      for (;;)
      {
        return;
        while (i < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x1_FTNNotifySrc.length)
        {
          a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x1_FTNNotifySrc[i], l, paramMsgCSBody0x211_0x7.uMsgSubCmd);
          i += 1;
        }
        continue;
        while (j < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x2_NFCNotifySrc.length)
        {
          a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x2_NFCNotifySrc[j], l, paramMsgCSBody0x211_0x7.uMsgSubCmd);
          j += 1;
        }
        continue;
        while (k < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x3_FileControl.length)
        {
          a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x3_FileControl[k], l, paramMsgCSBody0x211_0x7.uMsgSubCmd);
          k += 1;
        }
        continue;
        while (m < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x9_FTNNotifyThumb.length)
        {
          paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x9_FTNNotifyThumb[m].bytes_originfile_md5 = null;
          a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x9_FTNNotifyThumb[m], l, paramMsgCSBody0x211_0x7.uMsgSubCmd);
          m += 1;
        }
        continue;
        while (n < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0xa_NFCNotifyThumb.length)
        {
          paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0xa_NFCNotifyThumb[n].bytes_originfile_md5 = null;
          a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0xa_NFCNotifyThumb[n], l, paramMsgCSBody0x211_0x7.uMsgSubCmd);
          n += 1;
        }
      }
      while (i1 < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x8_RFCInfoNotiy.length)
      {
        a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x8_RFCInfoNotiy[i1], l, paramMsgCSBody0x211_0x7.uMsgSubCmd);
        i1 += 1;
      }
    }
  }
  
  private void a(int paramInt1, NFCNotify paramNFCNotify, long paramLong, int paramInt2)
  {
    SubMsgType0x7.MsgBody localMsgBody = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.MsgBodyFromNFCNotify(paramNFCNotify, paramLong, this.aR, paramInt2);
    a(paramInt1, 1003, localMsgBody, paramNFCNotify.uint64_sessionid);
  }
  
  private void a(int paramInt1, RFCInfoNotify paramRFCInfoNotify, long paramLong, int paramInt2)
  {
    SubMsgType0x7.MsgBody localMsgBody = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.msgBodyFromRFCInfoNotify(paramRFCInfoNotify, paramLong, this.aR, paramInt2);
    a(paramInt1, 1008, localMsgBody, paramRFCInfoNotify.uSessionId);
  }
  
  private void a(int paramInt1, DataLineMsgRecord paramDataLineMsgRecord, int paramInt2)
  {
    paramDataLineMsgRecord.bIsTransfering = false;
    if (paramDataLineMsgRecord.isSend())
    {
      if (paramInt2 == 2)
      {
        paramDataLineMsgRecord.fileMsgStatus = 0L;
        paramDataLineMsgRecord.bIsSended = true;
        if ((TextUtils.isEmpty(paramDataLineMsgRecord.path)) || (!new File(paramDataLineMsgRecord.path).exists()))
        {
          paramDataLineMsgRecord.nOpType = 1;
          paramDataLineMsgRecord.progress = 0.0F;
        }
        f(paramDataLineMsgRecord);
        if (!TextUtils.isEmpty(paramDataLineMsgRecord.thumbPath)) {
          this.app.b().a(paramInt1).af(paramDataLineMsgRecord.msgId, paramDataLineMsgRecord.thumbPath);
        }
        this.app.b().a(paramInt1).ig(paramDataLineMsgRecord.msgId);
        this.app.b().a(paramInt1).cNV();
        this.app.b().a(paramInt1).ie(paramDataLineMsgRecord.msgId);
        anot.a(this.app, "CliOper", "", "", "0X8006223", "0X8006223", 0, 0, "", "", "", "");
        return;
      }
      if ((paramInt2 == 32) || (paramInt2 == 11) || (paramInt2 == 8))
      {
        paramDataLineMsgRecord.fileMsgStatus = 2L;
        this.app.b().a(paramInt1).ig(paramDataLineMsgRecord.msgId);
        this.app.b().a(paramInt1).jdMethod_if(paramDataLineMsgRecord.msgId);
        anot.a(this.app, "CliOper", "", "", "0X8006224", "0X8006224", 0, 0, "", "", "", "");
        return;
      }
      paramDataLineMsgRecord.fileMsgStatus = 0L;
      this.app.b().a(paramInt1).ig(paramDataLineMsgRecord.msgId);
      this.app.b().a(paramInt1).jdMethod_if(paramDataLineMsgRecord.msgId);
      anot.a(this.app, "CliOper", "", "", "0X8006224", "0X8006224", 0, 0, "", "", "", "");
      return;
    }
    if (paramInt2 == 2)
    {
      paramDataLineMsgRecord.fileMsgStatus = 0L;
      f(paramDataLineMsgRecord);
      if (!TextUtils.isEmpty(paramDataLineMsgRecord.thumbPath)) {
        this.app.b().a(paramInt1).af(paramDataLineMsgRecord.msgId, paramDataLineMsgRecord.thumbPath);
      }
      String str = ahbf.ld(paramDataLineMsgRecord.path);
      if (str != null)
      {
        aqhq.deleteFile(paramDataLineMsgRecord.path);
        paramDataLineMsgRecord.path = str;
        this.app.b().a(paramInt1).ag(paramDataLineMsgRecord.msgId, str);
      }
      this.app.b().a(paramInt1).ig(paramDataLineMsgRecord.msgId);
      this.app.b().a(paramInt1).ie(paramDataLineMsgRecord.msgId);
      this.app.b().a(paramInt1).cNV();
      anot.a(this.app, "CliOper", "", "", "0X8006226", "0X8006226", 0, 0, "", "", "", "");
      return;
    }
    if ((paramInt2 == 32) || (paramInt2 == 11) || (paramInt2 == 8))
    {
      paramDataLineMsgRecord.fileMsgStatus = 2L;
      this.app.b().a(paramInt1).ig(paramDataLineMsgRecord.msgId);
      this.app.b().a(paramInt1).jdMethod_if(paramDataLineMsgRecord.msgId);
      anot.a(this.app, "CliOper", "", "", "0X8006227", "0X8006227", 0, 0, "", "", "", "");
      return;
    }
    if ((paramInt2 == 41) && (paramDataLineMsgRecord.fileMsgStatus == 1L) && (!paramDataLineMsgRecord.bIsTransfering))
    {
      QLog.w("DataLineHandler", 1, "uSessionID[" + paramDataLineMsgRecord.sessionid + "]_onSessionComplete. net fail. but comingfile is no start transfer");
      return;
    }
    paramDataLineMsgRecord.fileMsgStatus = 0L;
    this.app.b().a(paramInt1).ig(paramDataLineMsgRecord.msgId);
    this.app.b().a(paramInt1).jdMethod_if(paramDataLineMsgRecord.msgId);
    anot.a(this.app, "CliOper", "", "", "0X8006227", "0X8006227", 0, 0, "", "", "", "");
  }
  
  private void a(int paramInt, SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, List<SubMsgType0x7.MsgBody.RNFCNotify> paramList)
  {
    paramMsgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.MsgCSBodyFromRFCInfoNotify(paramInt, paramMsgHeader, paramList);
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.OnPbMsgReceive(paramMsgHeader);
  }
  
  private void a(int paramInt, SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, List<SubMsgType0x7.MsgBody.FTNNotify> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SubMsgType0x7.MsgBody.FTNNotify localFTNNotify = (SubMsgType0x7.MsgBody.FTNNotify)paramList.next();
      if ((localFTNNotify.uint64_sessionid.has()) && (localFTNNotify.uint32_originfiletype.has()) && (localFTNNotify.str_file_name.has()) && (localFTNNotify.uint64_file_len.has()) && (localFTNNotify.bytes_file_md5.has()) && (localFTNNotify.str_file_index.has()))
      {
        String str1 = localFTNNotify.str_file_name.get();
        if (str1 != null)
        {
          String str2 = ahav.getFileName(str1);
          if ((!TextUtils.isEmpty(str2)) && (!str1.equalsIgnoreCase(str2))) {
            localFTNNotify.str_file_name.set(str2);
          }
        }
        localArrayList.add(localFTNNotify);
      }
    }
    if (localArrayList.size() > 0)
    {
      paramMsgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.MsgCSBodyFromFTNNotify(paramInt, paramMsgHeader, localArrayList, paramBoolean);
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.OnPbMsgReceive(paramMsgHeader);
    }
  }
  
  private void a(Session paramSession, NFCInfo paramNFCInfo, FTNInfo paramFTNInfo, boolean paramBoolean)
  {
    if (paramSession == null) {}
    int j;
    DataLineMsgRecord localDataLineMsgRecord;
    int i;
    label105:
    label122:
    do
    {
      return;
      j = DataLineMsgRecord.getDevTypeBySeId(paramSession.uSessionID);
      localDataLineMsgRecord = this.app.b().a(j).a(paramSession.uSessionID);
      if (localDataLineMsgRecord != null) {
        break label570;
      }
      localDataLineMsgRecord = new DataLineMsgRecord();
      localDataLineMsgRecord.msg = "";
      localDataLineMsgRecord.msgtype = gu(paramSession.emFileType);
      localDataLineMsgRecord.sessionid = paramSession.uSessionID;
      if (!paramSession.bSend) {
        break;
      }
      i = 1;
      localDataLineMsgRecord.issend = i;
      if (!paramSession.bSend) {
        break label497;
      }
      bool = true;
      localDataLineMsgRecord.isread = bool;
      if (!paramSession.bSend) {
        break label503;
      }
      i = 0;
      localDataLineMsgRecord.nOpType = i;
      localDataLineMsgRecord.path = paramSession.strFilePathSrc;
      localDataLineMsgRecord.fileFrom = paramSession.emFileFrom;
      if (paramSession.vOfflineFileUUID != null) {
        localDataLineMsgRecord.fileUuid = new String(paramSession.vOfflineFileUUID);
      }
      localDataLineMsgRecord.uOwnerUin = paramSession.uOwnerUin;
      localDataLineMsgRecord.thumbPath = paramSession.strFilePathThumb;
      localDataLineMsgRecord.md5 = paramSession.vFileMD5Src;
      if (paramNFCInfo != null)
      {
        localDataLineMsgRecord.nServerIp = paramNFCInfo.dwServerIP;
        localDataLineMsgRecord.nServerPort = paramNFCInfo.wServerPort;
        localDataLineMsgRecord.vUrlNotify = paramNFCInfo.vUrlNotify;
        localDataLineMsgRecord.vTokenKey = paramNFCInfo.vTokenKey;
      }
      if (paramFTNInfo != null) {
        localDataLineMsgRecord.serverPath = paramFTNInfo.strFileIndex;
      }
    } while (localDataLineMsgRecord.path == null);
    if ((paramSession.strFileNameSrc != null) && (paramSession.strFileNameSrc.length() > 0))
    {
      localDataLineMsgRecord.filename = paramSession.strFileNameSrc;
      label286:
      localDataLineMsgRecord.filesize = paramSession.uFileSizeSrc;
      localDataLineMsgRecord.issuc = false;
      localDataLineMsgRecord.vipBubbleID = Ao();
      localDataLineMsgRecord.time = paramSession.uMsgTime;
      localDataLineMsgRecord.groupId = paramSession.dwGroupID;
      localDataLineMsgRecord.groupSize = paramSession.dwGroupSize;
      localDataLineMsgRecord.groupIndex = paramSession.dwGroupIndex;
      localDataLineMsgRecord.progress = 0.0F;
      if (!paramBoolean) {
        break label540;
      }
      localDataLineMsgRecord.fileMsgStatus = 0L;
      label365:
      paramNFCInfo = this.app.b().a(j);
      if (paramSession.bSend) {
        break label564;
      }
    }
    label540:
    label564:
    for (boolean bool = true;; bool = false)
    {
      for (;;)
      {
        paramNFCInfo.a(localDataLineMsgRecord, bool);
        paramNFCInfo = localDataLineMsgRecord;
        paramNFCInfo.issuc = true;
        paramNFCInfo.bIsTransfering = true;
        if (!paramSession.bSend) {
          break label638;
        }
        e(7, true, new Object[] { Long.valueOf(0L), Long.valueOf(paramSession.uSessionID), paramSession.strFilePathSrc, Byte.valueOf((byte)paramSession.emFileType), Boolean.valueOf(false), Boolean.valueOf(paramBoolean), Long.valueOf(paramNFCInfo.filesize) });
        return;
        i = 0;
        break;
        label497:
        bool = false;
        break label105;
        label503:
        i = 1;
        break label122;
        try
        {
          localDataLineMsgRecord.filename = new File(localDataLineMsgRecord.path).getName();
        }
        catch (Exception paramNFCInfo)
        {
          paramNFCInfo.printStackTrace();
        }
      }
      break label286;
      localDataLineMsgRecord.fileMsgStatus = 2L;
      if (paramSession.bSend) {
        break label365;
      }
      localDataLineMsgRecord.fileMsgStatus = 1L;
      break label365;
    }
    label570:
    if (paramBoolean) {}
    for (localDataLineMsgRecord.fileMsgStatus = 0L;; localDataLineMsgRecord.fileMsgStatus = 2L)
    {
      this.app.b().a(j).ig(localDataLineMsgRecord.msgId);
      this.app.b().a(j).jdMethod_if(localDataLineMsgRecord.msgId);
      paramNFCInfo = localDataLineMsgRecord;
      break;
    }
    label638:
    if (!paramBoolean)
    {
      paramFTNInfo = this.app.a(j).a(paramSession.uSessionID);
      if ((paramFTNInfo == null) || (!DataLineMsgSet.isSingle(paramFTNInfo))) {
        break label749;
      }
      cIh();
    }
    for (;;)
    {
      e(6, true, new Object[] { Long.valueOf(0L), Long.valueOf(paramSession.uSessionID), paramSession.strFilePathSrc, Byte.valueOf((byte)paramSession.emFileType), Boolean.valueOf(false), Boolean.valueOf(paramBoolean), Long.valueOf(paramNFCInfo.filesize) });
      return;
      label749:
      paramFTNInfo = this.app.a(j).a(paramSession.dwGroupID);
      if ((paramFTNInfo == null) || (paramFTNInfo.getComeCount() == 1)) {
        cIh();
      }
    }
  }
  
  private void a(DataLineMsgRecord paramDataLineMsgRecord, WeiYunFileInfo paramWeiYunFileInfo)
  {
    long l = paramDataLineMsgRecord.sessionid;
    this.app.a().a().a(paramWeiYunFileInfo, new acdg(this, l));
  }
  
  private void a(SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, List<SubMsgType0x7.MsgBody.FileControl> paramList)
  {
    paramMsgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.MsgCSBodyFromFileControl(paramMsgHeader, paramList);
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.OnPbMsgReceive(paramMsgHeader);
  }
  
  private boolean a(amzy paramamzy)
  {
    int j = 0;
    int i = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    int m = paramamzy.a(localStringBuffer);
    if (m == -1) {
      return false;
    }
    int k;
    if (this.cuM == 0) {
      while (i < localStringBuffer.length())
      {
        j = i;
        if (localStringBuffer.charAt(i) == '\024')
        {
          j = i;
          if (i < localStringBuffer.length() - 1)
          {
            k = afky.hl(localStringBuffer.charAt(i + 1));
            j = i;
            if (k >= 0)
            {
              localStringBuffer.setCharAt(i + 1, (char)k);
              j = i + 1;
            }
          }
        }
        i = j + 1;
      }
    }
    if (this.cuM == 1)
    {
      i = j;
      for (;;)
      {
        if (i < localStringBuffer.length())
        {
          k = i;
          String str;
          if (localStringBuffer.charAt(i) == '\024')
          {
            k = i;
            if (i < localStringBuffer.length() - 1)
            {
              k = localStringBuffer.charAt(i + 1);
              j = k;
              if (k == 250) {
                j = 10;
              }
              k = i;
              if (j >= 0)
              {
                k = i;
                if (j < aoff.hj.length) {
                  str = aoff.hj[j];
                }
              }
            }
          }
          try
          {
            localStringBuffer.replace(i + 1, i + 2, str);
            k = i + str.length();
            i = k + 1;
          }
          catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException)
          {
            for (;;)
            {
              localStringIndexOutOfBoundsException.printStackTrace();
              QLog.d("DataLineHandler", 2, "SendSubText ipad emoj fail", localStringIndexOutOfBoundsException);
            }
          }
        }
      }
    }
    paramamzy.S(a(paramamzy.e().longValue(), 1001, paramamzy.Jf(), m, localStringBuffer.toString().getBytes()));
    return true;
  }
  
  static boolean a(Session paramSession, String paramString)
  {
    if (paramSession != null) {
      if ((paramString == null) || (paramString.length() == 0))
      {
        if ((paramSession.actionInfo != null) && (paramSession.actionInfo.strServiceName != null) && (paramSession.actionInfo.strServiceName.length() != 0)) {}
      }
      else {
        while ((paramSession.actionInfo != null) && (paramSession.actionInfo.strServiceName != null) && (paramSession.actionInfo.strServiceName.equals(paramString))) {
          return true;
        }
      }
    }
    return false;
  }
  
  private void av(long paramLong, int paramInt)
  {
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    DataLineMsgRecord localDataLineMsgRecord = this.app.b().a(i).a(paramLong);
    if (localDataLineMsgRecord == null) {}
    do
    {
      do
      {
        return;
        if ((!localDataLineMsgRecord.isSend()) || (localDataLineMsgRecord.fileFrom != 0)) {
          break label266;
        }
        if (paramInt != 2) {
          break;
        }
        e(4, true, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), Float.valueOf(1.0F) });
        e(2, true, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), localDataLineMsgRecord.path });
      } while (paramLong <= 0L);
      FileManagerEntity localFileManagerEntity = localDataLineMsgRecord.trans2Entity();
      if ((localFileManagerEntity != null) && (localFileManagerEntity.fileSize <= 20971520L))
      {
        ((aocy)this.app.getManager(305)).g(localDataLineMsgRecord, i);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("AIOMessageSpreadManager", 1, "can't find File Msg sID:");
    return;
    if ((paramInt == 32) || (paramInt == 11) || (paramInt == 8))
    {
      e(2, false, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), localDataLineMsgRecord.path });
      return;
    }
    e(2, false, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), localDataLineMsgRecord.path });
    return;
    label266:
    if (paramInt == 2)
    {
      e(4, true, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), Float.valueOf(1.0F) });
      e(3, true, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), localDataLineMsgRecord.path });
      return;
    }
    if ((paramInt == 32) || (paramInt == 11) || (paramInt == 8))
    {
      e(3, false, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), localDataLineMsgRecord.path });
      return;
    }
    e(3, false, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong), localDataLineMsgRecord.path });
  }
  
  private void b(int paramInt, SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, List<SubMsgType0x7.MsgBody.NFCNotify> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SubMsgType0x7.MsgBody.NFCNotify localNFCNotify = (SubMsgType0x7.MsgBody.NFCNotify)paramList.next();
      if ((localNFCNotify.uint64_sessionid.has()) && (localNFCNotify.uint32_originfiletype.has()) && (localNFCNotify.str_file_name.has()) && (localNFCNotify.uint64_file_len.has()) && (localNFCNotify.bytes_file_md5.has()) && (localNFCNotify.fixed32_ip.has()) && (localNFCNotify.uint32_port.has()) && (localNFCNotify.bytes_url_notify.has()) && (localNFCNotify.bytes_tokenkey.has()))
      {
        String str1 = localNFCNotify.str_file_name.get();
        if (str1 != null)
        {
          String str2 = ahav.getFileName(str1);
          if ((!TextUtils.isEmpty(str2)) && (!str1.equalsIgnoreCase(str2))) {
            localNFCNotify.str_file_name.set(str2);
          }
        }
        localArrayList.add(localNFCNotify);
      }
    }
    if (localArrayList.size() > 0)
    {
      paramMsgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.MsgCSBodyFromNFCNotify(paramInt, paramMsgHeader, localArrayList, paramBoolean);
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.OnPbMsgReceive(paramMsgHeader);
    }
  }
  
  public static boolean c(FileManagerEntity paramFileManagerEntity)
  {
    return ir(a(paramFileManagerEntity));
  }
  
  private void cIf()
  {
    SharedPreferences localSharedPreferences = this.app.getPreferences();
    String str = this.app.getCurrentAccountUin() + "_PC_STATE";
    if (localSharedPreferences.contains(str))
    {
      this.bHg = true;
      this.Pl = localSharedPreferences.getLong(str, 0L);
      return;
    }
    this.bHg = false;
  }
  
  private void cIg()
  {
    SharedPreferences localSharedPreferences = this.app.getPreferences();
    String str = this.app.getCurrentAccountUin() + "_IPAD_STATE";
    if (localSharedPreferences.contains(str))
    {
      this.bHh = true;
      this.Pm = localSharedPreferences.getLong(str, 0L);
      return;
    }
    this.bHh = false;
  }
  
  private void cIh()
  {
    if (this.bHf == true) {}
    for (boolean bool = false;; bool = true)
    {
      getApp().q(1, bool, false);
      return;
    }
  }
  
  private void cY(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = 0;
    paramObject = new MsgSCBody();
    paramObject.uMsgType = 529;
    paramObject.msgBody0x211 = new MsgSCBody0x211();
    paramObject.msgBody0x211.uMsgSubType = 7;
    paramObject.msgBody0x211.msgBody0x211_0x7 = new MsgSCBody0x211_0x7();
    Long localLong = (Long)paramToServiceMsg.getAttribute("cookie");
    MsgSCBody0x211_0x7 localMsgSCBody0x211_0x7;
    if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.isSuccess()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "handleFTNNotify " + localLong.intValue() + " 发送信令，发送失败");
      }
      paramObject.bTimeOut = true;
      if (paramFromServiceMsg != null)
      {
        localMsgSCBody0x211_0x7 = paramObject.msgBody0x211.msgBody0x211_0x7;
        if (!paramFromServiceMsg.isSuccess()) {
          break label235;
        }
      }
    }
    for (;;)
    {
      localMsgSCBody0x211_0x7.uResult = i;
      if (!((Boolean)paramToServiceMsg.getAttribute("sendFromNative", Boolean.valueOf(true))).booleanValue()) {
        break label241;
      }
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.OnPbMsgReply(localLong.intValue(), paramObject);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "handleFTNNotify " + localLong.intValue() + " 发送信令，发送成功");
      }
      paramObject.bTimeOut = false;
      break;
      label235:
      i = 1;
    }
    label241:
    m(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void cZ(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = 0;
    if (i < this.sV.size()) {
      if (!((amzy)this.sV.get(i)).b().equals(paramToServiceMsg)) {}
    }
    for (paramToServiceMsg = (amzy)this.sV.get(i);; paramToServiceMsg = null)
    {
      if (paramToServiceMsg == null) {}
      do
      {
        return;
        i += 1;
        break;
        paramToServiceMsg.b().progress = 1.0F;
        i = DataLineMsgRecord.getDevTypeBySeId(paramToServiceMsg.e().longValue());
        if (!paramFromServiceMsg.isSuccess())
        {
          paramToServiceMsg.b().issuc = false;
          e(1, false, new Object[] { paramToServiceMsg.e(), paramToServiceMsg.zs() });
          return;
        }
        if (paramToServiceMsg.aws())
        {
          paramToServiceMsg.b().issuc = true;
          this.app.b().a(i).ie(paramToServiceMsg.b().msgId);
          this.sV.remove(paramToServiceMsg);
          e(1, true, new Object[] { paramToServiceMsg.e(), paramToServiceMsg.zs() });
          return;
        }
      } while (a(paramToServiceMsg));
      paramToServiceMsg.b().issuc = false;
      this.sV.remove(paramToServiceMsg);
      e(1, false, new Object[] { paramToServiceMsg.e(), paramToServiceMsg.zs() });
      return;
    }
  }
  
  private void d(DataLineMsgRecord paramDataLineMsgRecord)
  {
    paramDataLineMsgRecord.fileMsgStatus = 0L;
    int i = DataLineMsgRecord.getDevTypeBySeId(paramDataLineMsgRecord.sessionid);
    this.app.b().a(i).ig(paramDataLineMsgRecord.msgId);
    this.app.b().a(i).jdMethod_if(paramDataLineMsgRecord.msgId);
    e(3, false, new Object[] { Long.valueOf(0L), Long.valueOf(paramDataLineMsgRecord.sessionid), paramDataLineMsgRecord.path });
  }
  
  private void e(Session paramSession)
  {
    String str = paramSession.strFilePathSrc;
    if ((paramSession.dwGroupID == 0) && (paramSession.bSend) && (paramSession.emFileType == 1) && (str != null) && (new File(str).exists())) {
      URLDrawable.getDrawable(AsyncImageView.a(str, this.dI, this.dJ, true), null, null, false).downloadImediatly();
    }
  }
  
  private void f(DataLineMsgRecord paramDataLineMsgRecord)
  {
    String str = paramDataLineMsgRecord.path;
    if (ahav.getFileType(str) != 0) {}
    do
    {
      do
      {
        return;
      } while (aqhq.fileExistsAndNotEmpty(paramDataLineMsgRecord.thumbPath));
      str = ahav.h(str, 384, 384);
    } while (TextUtils.isEmpty(str));
    paramDataLineMsgRecord.thumbPath = str;
  }
  
  private void g(int paramInt, long paramLong, String paramString)
  {
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    DataLineMsgRecord localDataLineMsgRecord = this.app.b().a(i).a(paramLong);
    if (localDataLineMsgRecord == null) {}
    do
    {
      do
      {
        return;
        if (paramInt != 0) {
          break;
        }
        localDataLineMsgRecord.thumbPath = paramString;
      } while (localDataLineMsgRecord.isSend());
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "uSessionID[" + paramLong + "]OnSessionThumbUpdate: update");
      }
      e(10, true, new Object[] { Long.valueOf(paramLong) });
      return;
      if (paramInt == 1)
      {
        localDataLineMsgRecord.serverPath = paramString;
        this.app.b().a(i).a(localDataLineMsgRecord.msgId, localDataLineMsgRecord.serverPath, localDataLineMsgRecord.md5);
        return;
      }
    } while (paramInt != 2);
    localDataLineMsgRecord.md5 = aqhs.hexStr2Bytes(paramString);
    if ((QLog.isDevelopLevel()) && (localDataLineMsgRecord.md5 != null)) {
      QLog.d("DataLineHandler", 4, "SessionUpdateType_FileMD5, uSessionID[" + paramLong + "], strValuebuf[" + paramString + "], strMD5MR[" + aqhs.bytes2HexStr(localDataLineMsgRecord.md5) + "], strMD5Notify" + paramString);
    }
    this.app.b().a(i).a(localDataLineMsgRecord.msgId, localDataLineMsgRecord.serverPath, localDataLineMsgRecord.md5);
  }
  
  private void g(DataLineMsgRecord paramDataLineMsgRecord)
  {
    if ((paramDataLineMsgRecord != null) && (!paramDataLineMsgRecord.isSendFromLocal()) && (DataLineMsgSet.isSingle(paramDataLineMsgRecord)) && (paramDataLineMsgRecord.msgtype == -2000) && (paramDataLineMsgRecord.path != null) && (new File(paramDataLineMsgRecord.path).exists())) {
      URLDrawable.getDrawable(AsyncImageView.a(paramDataLineMsgRecord.path, this.dI, this.dJ, true), null, null, false).downloadImediatly();
    }
  }
  
  public static int gu(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return -2005;
    case 1: 
      return -2000;
    }
    return -2009;
  }
  
  public static int gv(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case -2000: 
      return 1;
    }
    return 2;
  }
  
  public static int i(String paramString, boolean paramBoolean)
  {
    switch (ahav.getFileType(paramString))
    {
    default: 
      if (!paramBoolean) {
        break;
      }
    case 0: 
      return 1;
    case 1: 
      return 3;
    case 2: 
      return 2;
    }
    return 0;
  }
  
  private void iF(List<SubMsgType0x7.MsgBody.MoloNotify> paramList)
  {
    paramList = paramList.iterator();
    Object localObject;
    DataLineMsgRecord localDataLineMsgRecord;
    int i;
    while (paramList.hasNext())
    {
      localObject = (SubMsgType0x7.MsgBody.MoloNotify)paramList.next();
      if (!((SubMsgType0x7.MsgBody.MoloNotify)localObject).bytes_buf.has())
      {
        if (QLog.isColorLevel()) {
          QLog.d("DataLineHandler", 2, "应用宝消息  moloHandler SubCmd0x5 do not has bytes_buf");
        }
      }
      else
      {
        localDataLineMsgRecord = this.jdField_b_of_type_Cl.a(((SubMsgType0x7.MsgBody.MoloNotify)localObject).bytes_buf.get().toByteArray());
        if (localDataLineMsgRecord == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("DataLineHandler", 2, "应用宝消息 moloHandler dealWith return null");
          }
        }
        else
        {
          if (!((SubMsgType0x7.MsgBody.MoloNotify)localObject).uint32_group_id.has()) {
            break label357;
          }
          i = ((SubMsgType0x7.MsgBody.MoloNotify)localObject).uint32_group_id.get();
          localDataLineMsgRecord.groupId = i;
          if (!((SubMsgType0x7.MsgBody.MoloNotify)localObject).uint32_group_size.has()) {
            break label362;
          }
          i = ((SubMsgType0x7.MsgBody.MoloNotify)localObject).uint32_group_size.get();
          label147:
          localDataLineMsgRecord.groupSize = i;
          if (!((SubMsgType0x7.MsgBody.MoloNotify)localObject).uint32_group_curindex.has()) {
            break label367;
          }
          i = ((SubMsgType0x7.MsgBody.MoloNotify)localObject).uint32_group_curindex.get();
          label173:
          localDataLineMsgRecord.groupIndex = i;
          if (QLog.isColorLevel()) {
            QLog.d("DataLineHandler", 2, "应用宝消息 groupId[" + localDataLineMsgRecord.groupId + "],size[" + localDataLineMsgRecord.groupSize + "],index[" + localDataLineMsgRecord.groupIndex + "], sessionid[" + localDataLineMsgRecord.sessionid + "], key[" + localDataLineMsgRecord.strMoloKey);
          }
          if (localDataLineMsgRecord.groupSize == 1)
          {
            localDataLineMsgRecord.groupId = 0;
            localDataLineMsgRecord.groupSize = 0;
            localDataLineMsgRecord.groupIndex = 0;
          }
          if ((DataLineMsgSet.isSingle(localDataLineMsgRecord)) || (!iq(localDataLineMsgRecord.groupId))) {
            break label372;
          }
          if (QLog.isColorLevel()) {
            QLog.d("DataLineHandler", 2, "应用宝消息msg record in deleted group, sessionid[" + localDataLineMsgRecord.sessionid);
          }
        }
      }
    }
    label357:
    label362:
    label367:
    label372:
    int j;
    do
    {
      return;
      i = 0;
      break;
      i = 0;
      break label147;
      i = 0;
      break label173;
      j = DataLineMsgRecord.getDevTypeBySeId(localDataLineMsgRecord.sessionid);
      getApp().b().a(j).a(localDataLineMsgRecord, true);
      if ((DataLineMsgSet.isSingle(localDataLineMsgRecord)) || (!iq(localDataLineMsgRecord.groupId))) {
        break label484;
      }
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "应用宝消息 msg record in deleted group 2, sessionid[" + localDataLineMsgRecord.sessionid);
      }
      paramList = getApp().a(j).b(localDataLineMsgRecord.sessionid);
    } while (paramList == null);
    c(paramList);
    return;
    label484:
    label503:
    boolean bool;
    if (DataLineMsgSet.isSingle(localDataLineMsgRecord))
    {
      cu.a(this.app);
      cIh();
      bool = false;
      if (!j(localDataLineMsgRecord.sessionid, localDataLineMsgRecord.groupId)) {
        break label644;
      }
    }
    for (;;)
    {
      e(6, true, new Object[] { Long.valueOf(0L), Long.valueOf(localDataLineMsgRecord.sessionid), localDataLineMsgRecord.path, Byte.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(bool), Long.valueOf(localDataLineMsgRecord.filesize) });
      break;
      localObject = getApp().a(j).a(localDataLineMsgRecord.groupId);
      if ((localObject != null) && (((DataLineMsgSet)localObject).getComeCount() != 1)) {
        break label503;
      }
      cu.b(this.app);
      cIh();
      break label503;
      label644:
      localDataLineMsgRecord.issuc = true;
      localDataLineMsgRecord.fileMsgStatus = 1L;
      bool = aqiw.isWifiConnected(BaseApplication.getContext());
      if (localDataLineMsgRecord.filesize <= 3145728L)
      {
        i = 1;
        label678:
        if ((!bool) && ((!getAutoDownload()) || (i == 0))) {
          break label761;
        }
        bool = true;
        if (bool) {
          localDataLineMsgRecord.fileMsgStatus = 0L;
        }
      }
      try
      {
        F(111);
        this.jdField_b_of_type_Cl.y(localDataLineMsgRecord.strMoloKey);
        cu.c(this.app);
        label734:
        this.app.b().a(j).ig(localDataLineMsgRecord.msgId);
        continue;
        i = 0;
        break label678;
        label761:
        bool = false;
      }
      catch (Exception localException)
      {
        break label734;
      }
    }
  }
  
  public static boolean ir(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    default: 
      return false;
    }
    return true;
  }
  
  private void m(ToServiceMsg paramToServiceMsg)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), acdm.class);
    localNewIntent.putExtra(ToServiceMsg.class.getSimpleName(), paramToServiceMsg);
    this.app.startServlet(localNewIntent);
    long l = System.currentTimeMillis();
    paramToServiceMsg.extraData.putLong("datalineSendTimekey", l);
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    long l = ((Long)paramToServiceMsg.getAttribute("cookie")).longValue();
    int j = DataLineMsgRecord.getDevTypeBySeId(l);
    paramToServiceMsg = this.app.b().a(j).a(l);
    if (paramToServiceMsg == null) {
      return;
    }
    paramToServiceMsg.fileUuid = null;
    paramToServiceMsg.uOwnerUin = 0L;
    paramToServiceMsg.busId = 38;
    paramToServiceMsg.forwardTroopFileEntrance = 0;
    paramToServiceMsg.nOpType = 0;
    paramToServiceMsg.fileFrom = 5;
    paramToServiceMsg.path = (acbn.bmg + paramToServiceMsg.filename);
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {}
    for (int i = 2;; i = 36)
    {
      a(j, paramToServiceMsg, i);
      new Handler(Looper.getMainLooper()).post(new DataLineHandler.8(this, l, i));
      return;
    }
  }
  
  private void o(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong3 == 0L) {}
    for (float f = 0.0F;; f = (float)paramLong2 / (float)paramLong3)
    {
      int i = DataLineMsgRecord.getDevTypeBySeId(paramLong1);
      DataLineMsgRecord localDataLineMsgRecord = this.app.b().a(i).a(paramLong1);
      if (localDataLineMsgRecord != null) {
        localDataLineMsgRecord.progress = f;
      }
      e(4, true, new Object[] { Long.valueOf(0L), Long.valueOf(paramLong1), Float.valueOf(f) });
      return;
    }
  }
  
  public long A(int paramInt)
  {
    if (paramInt == 0) {
      return this.Pl;
    }
    return this.Pm;
  }
  
  protected void A(List<SubMsgType0x7.MsgBody.MpFileNotify> paramList) {}
  
  public int An()
  {
    try
    {
      int i = this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.generateGroupID();
      return i;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      QLog.e("DataLineHandler", 1, "native genGroupId failed");
      return 0;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  public int Ao()
  {
    return ((acle)this.app.getBusinessHandler(13)).AS();
  }
  
  public void EI(boolean paramBoolean)
  {
    this.bHg = paramBoolean;
    SharedPreferences localSharedPreferences = this.app.getPreferences();
    String str = this.app.getCurrentAccountUin() + "_PC_STATE";
    if (this.bHg)
    {
      localSharedPreferences.edit().putLong(str, this.Pl).commit();
      return;
    }
    localSharedPreferences.edit().remove(str).commit();
  }
  
  public void EJ(boolean paramBoolean)
  {
    this.bHh = paramBoolean;
    SharedPreferences localSharedPreferences = this.app.getPreferences();
    String str = this.app.getCurrentAccountUin() + "_IPAD_STATE";
    if (this.bHh)
    {
      localSharedPreferences.edit().putLong(str, this.Pm).commit();
      return;
    }
    localSharedPreferences.edit().remove(str).commit();
  }
  
  public void F(int paramInt)
  {
    this.jdField_b_of_type_Cl.F(paramInt);
  }
  
  public void GetThumbFilePath(int paramInt, Session paramSession)
  {
    QLog.i("DataLineHandler", 2, "==ruo  int to java GetThumbFilePath ");
    Object localObject = (ackv)this.app.getBusinessHandler(10);
    if ((localObject != null) && (((ackv)localObject).bi() == 0))
    {
      QLog.i("DataLineHandler", 2, "==ruo  int to java GetThumbFilePath pc not line ");
      return;
    }
    if (paramSession.uFileSizeSrc < 51200L)
    {
      QLog.i("DataLineHandler", 2, "==ruo  int to java GetThumbFilePathu 333 MinSize_for_CreateThumb e ");
      return;
    }
    localObject = dx.i(BaseApplication.getContext(), paramSession.strFilePathSrc);
    if (localObject == null)
    {
      QLog.i("DataLineHandler", 2, "==ruo  int to java GetThumbFilePathu 444 MinSize_for_CreateThumb e ");
      return;
    }
    File localFile = new File((String)localObject);
    if ((localFile == null) || (!localFile.exists()))
    {
      QLog.i("DataLineHandler", 2, "==ruo  int to java GetThumbFilePathu 555 MinSize_for_CreateThumb e ");
      return;
    }
    if (localFile.length() + 51200L < paramSession.uFileSizeSrc)
    {
      QLog.i("DataLineHandler", 2, "==ruo  int to java GetThumbFilePathu 666 MinSize_for_CreateThumb e ");
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.OnGetThumbFilePathReply(paramInt, (String)localObject);
      return;
    }
    QLog.i("DataLineHandler", 2, "==ruo  int to java GetThumbFilePathu 777 MinSize_for_CreateThumb e ");
    localFile.delete();
  }
  
  public void HandleSession(int paramInt1, long paramLong, int paramInt2, MsgHeader paramMsgHeader) {}
  
  public void IO(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    synchronized (this.xo)
    {
      if (!this.xo.contains(Integer.valueOf(paramInt)))
      {
        this.xo.add(Integer.valueOf(paramInt));
        if (this.xo.size() > 256) {
          this.xo.remove(0);
        }
      }
      return;
    }
  }
  
  public void IP(int paramInt)
  {
    bm(paramInt, false);
  }
  
  public void InvokeReport(ReportItem paramReportItem)
  {
    dt.a(this.app, paramReportItem, dt.dM);
  }
  
  public void OnGroupComplete(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DataLineHandler", 2, "uGroupID[" + paramInt1 + "]OnGroupComplete 分组结束 emGroupStatus[" + paramInt2 + "]");
    }
    if (paramInt1 == 0) {}
    DataLineMsgSet localDataLineMsgSet1;
    do
    {
      return;
      DataLineMsgSet localDataLineMsgSet2 = this.app.a(0).a(paramInt1);
      localDataLineMsgSet1 = localDataLineMsgSet2;
      if (localDataLineMsgSet2 == null) {
        localDataLineMsgSet1 = this.app.a(1).a(paramInt1);
      }
    } while (localDataLineMsgSet1 == null);
    localDataLineMsgSet1.setTimeOut();
    e(11, true, null);
  }
  
  public void OnGroupStart(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DataLineHandler", 2, "uGroupID[" + paramInt + "]OnGroupStart 分组开始");
    }
    e(11, true, null);
  }
  
  public boolean OnQueryAutoDownload(long paramLong, byte paramByte)
  {
    boolean bool2 = false;
    if (paramByte == 2)
    {
      boolean bool1 = aqiw.isWifiConnected(BaseApplication.getContext());
      if (paramLong <= 3145728L) {}
      for (paramByte = 1;; paramByte = 0)
      {
        if (!bool1)
        {
          bool1 = bool2;
          if (getAutoDownload())
          {
            bool1 = bool2;
            if (paramByte == 0) {}
          }
        }
        else
        {
          bool1 = true;
        }
        return bool1;
      }
    }
    return true;
  }
  
  public void OnSessionComplete(long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject = (Session)this.iF.get(Long.valueOf(paramLong));
    if ((paramInt1 == 2) && (localObject != null)) {
      this.iF.remove(Long.valueOf(paramLong));
    }
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    if (localObject == null)
    {
      localObject = Looper.getMainLooper();
      DataLineMsgRecord localDataLineMsgRecord = this.app.b().a(i).a(paramLong);
      if (localDataLineMsgRecord == null)
      {
        if (Thread.currentThread() != ((Looper)localObject).getThread()) {
          new Handler((Looper)localObject).post(new DataLineHandler.14(this, paramLong, paramInt1, paramInt2));
        }
        return;
      }
      if (paramInt1 == 2) {
        g(localDataLineMsgRecord);
      }
      a(i, localDataLineMsgRecord, paramInt1);
      if (Thread.currentThread() != ((Looper)localObject).getThread())
      {
        new Handler((Looper)localObject).post(new DataLineHandler.15(this, paramLong, paramInt1));
        return;
      }
      av(paramLong, paramInt1);
      return;
    }
    if (paramInt1 == 2) {}
    for (boolean bool = true;; bool = false)
    {
      e(16, bool, localObject);
      return;
    }
  }
  
  public void OnSessionNew(Session paramSession, NFCInfo paramNFCInfo, FTNInfo paramFTNInfo)
  {
    if (paramSession.bSend)
    {
      anot.a(this.app, "CliOper", "", "", "0X8006222", "0X8006222", 0, 0, "", "", "", "");
      if ((paramSession.actionInfo != null) && (paramSession.actionInfo.strServiceName != null) && (paramSession.actionInfo.strServiceName.length() != 0)) {
        break label211;
      }
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "uSessionID[" + paramSession.uSessionID + "]OnSessionNew Session创建");
      }
      Looper localLooper = Looper.getMainLooper();
      if (Thread.currentThread() == localLooper.getThread()) {
        break label200;
      }
      new Handler(localLooper).post(new DataLineHandler.11(this, paramSession, paramNFCInfo, paramFTNInfo));
    }
    for (;;)
    {
      e(paramSession);
      return;
      anot.a(this.app, "CliOper", "", "", "0X8006225", "0X8006225", 0, 0, "", "", "", "");
      break;
      label200:
      a(paramSession, paramNFCInfo, paramFTNInfo, false);
    }
    label211:
    this.iF.put(Long.valueOf(paramSession.uSessionID), paramSession);
    e(17, true, paramSession);
  }
  
  public void OnSessionProgress(long paramLong1, long paramLong2, long paramLong3)
  {
    Object localObject = (Session)this.iF.get(Long.valueOf(paramLong1));
    if (localObject == null)
    {
      localObject = Looper.getMainLooper();
      if (Thread.currentThread() != ((Looper)localObject).getThread())
      {
        new Handler((Looper)localObject).post(new DataLineHandler.13(this, paramLong1, paramLong2, paramLong3));
        return;
      }
      o(paramLong1, paramLong2, paramLong3);
      return;
    }
    e(15, true, new Object[] { localObject, Float.valueOf((float)((float)paramLong2 * 1.0D / (float)paramLong3)) });
  }
  
  public void OnSessionStart(long paramLong)
  {
    Object localObject = (Session)this.iF.get(Long.valueOf(paramLong));
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "uSessionID[" + paramLong + "], OnSessionStart, Session开始");
      }
      localObject = Looper.getMainLooper();
      if (Thread.currentThread() != ((Looper)localObject).getThread())
      {
        new Handler((Looper)localObject).post(new DataLineHandler.12(this, paramLong));
        return;
      }
      a(a(paramLong), null, null, true);
      return;
    }
    e(14, true, localObject);
  }
  
  public void OnSessionUpdate(int paramInt, long paramLong, String paramString)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new DataLineHandler.16(this, paramInt, paramLong, paramString));
      return;
    }
    g(paramInt, paramLong, paramString);
  }
  
  public void SendPbMsg(int paramInt, MsgCSBody paramMsgCSBody)
  {
    QLog.d("DataLineHandler", 1, "SendPbMsg: msgBody.uMsgType " + paramMsgCSBody.uMsgType);
    switch (paramMsgCSBody.uMsgType)
    {
    default: 
      QLog.d("DataLineHandler", 1, "SendPbMsg: cannot recognize the pb msg form JNI, cmd[" + paramMsgCSBody.uMsgType);
      return;
    case 529: 
      a(paramInt, paramMsgCSBody.msgBody0x211);
      return;
    case 838: 
      a(paramInt, paramMsgCSBody.msgBody0x346);
      return;
    }
    a(paramInt, paramMsgCSBody.msgBody0x345);
  }
  
  public boolean ZP()
  {
    return this.app.getPreferences().getBoolean("dl_pc_online_notify", true);
  }
  
  public boolean ZQ()
  {
    return this.app.getPreferences().getBoolean("dl_ipad_online_notify", true);
  }
  
  public long a(FileManagerEntity paramFileManagerEntity)
  {
    String str = paramFileManagerEntity.fileName + "\n";
    paramFileManagerEntity = str + paramFileManagerEntity.Uuid + "\n";
    return a(paramFileManagerEntity + "来自:腾讯文档", 0).longValue();
  }
  
  public long a(String paramString1, String paramString2, int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    return a(paramString1, paramString2, null, paramInt1, paramLong, paramInt2, paramInt3, paramInt4, paramBoolean);
  }
  
  public long a(String paramString1, String paramString2, String paramString3, int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    paramString1 = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.genSession(0, paramString1, paramString2, paramString3, paramInt1, 0, paramLong, paramInt2, paramInt3, paramInt4);
    if (paramString1 == null) {
      return 0L;
    }
    localArrayList.add(paramString1);
    if (0L == paramLong) {
      paramString1.uSessionID = a(0, this.cuM).longValue();
    }
    paramString1.msgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.msgHeader(Long.valueOf(this.app.getCurrentAccountUin()).longValue(), this.cuM);
    A(localArrayList, paramBoolean);
    return paramString1.uSessionID;
  }
  
  public aviq a()
  {
    return this.jdField_a_of_type_Aviq;
  }
  
  public ci a()
  {
    return this.jdField_b_of_type_Ci;
  }
  
  public Session a(long paramLong)
  {
    boolean bool = true;
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    DataLineMsgRecord localDataLineMsgRecord = getApp().b().a(i).a(paramLong);
    if (localDataLineMsgRecord == null) {
      return null;
    }
    Session localSession = new Session();
    localSession.uSessionID = localDataLineMsgRecord.sessionid;
    if (localDataLineMsgRecord.issend == 1) {}
    for (;;)
    {
      localSession.bSend = bool;
      i = DataLineMsgRecord.getDevTypeBySeId(localDataLineMsgRecord.sessionid);
      localSession.msgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.msgHeader(Long.valueOf(this.app.getCurrentAccountUin()).longValue(), i);
      localSession.dwGroupID = localDataLineMsgRecord.groupId;
      localSession.dwGroupSize = localDataLineMsgRecord.groupSize;
      localSession.dwGroupIndex = localDataLineMsgRecord.groupIndex;
      localSession.emFileType = gv(localDataLineMsgRecord.msgtype);
      localSession.strFilePathSrc = ahbf.getRealPath(localDataLineMsgRecord.path);
      localSession.strFilePathThumb = localDataLineMsgRecord.thumbPath;
      localSession.uFileSizeSrc = localDataLineMsgRecord.filesize;
      localSession.vFileMD5Src = localDataLineMsgRecord.md5;
      if ((QLog.isDevelopLevel()) && (localDataLineMsgRecord.md5 != null)) {
        QLog.d("DataLineHandler", 4, "getSessionFromMsgRecord, uSessionID[" + localDataLineMsgRecord.sessionid + "], strMR[" + aqhs.bytes2HexStr(localDataLineMsgRecord.md5) + "], filesize[" + localDataLineMsgRecord.filesize);
      }
      localSession.actionInfo = null;
      return localSession;
      bool = false;
    }
  }
  
  public ToServiceMsg a(int paramInt, SubMsgType0x7.MsgBody paramMsgBody, long paramLong)
  {
    int i = paramMsgBody.msg_header.uint32_dst_ter_type.get();
    String str = this.app.getCurrentAccountUin();
    paramMsgBody = paramMsgBody.toByteArray();
    if (QLog.isColorLevel()) {
      QLog.d("DataLineHandler", 2, "send0x211C2CDatalineMsg DataLineMsgRecord:" + paramLong);
    }
    return a(false, paramLong, str, 529, 7, paramInt, paramMsgBody, paramLong, i);
  }
  
  public ToServiceMsg a(long paramLong, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    SubMsgType0x7.MsgBody localMsgBody = new SubMsgType0x7.MsgBody();
    localMsgBody.uint32_sub_cmd.set(4);
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillMsgHeader(localMsgBody.msg_header, Long.valueOf(this.app.getCurrentAccountUin()).longValue(), i);
    localMsgBody.msg_subcmd_0x4_generic.uint64_sessionid.set(paramLong);
    localMsgBody.msg_subcmd_0x4_generic.uint32_size.set(paramInt2);
    localMsgBody.msg_subcmd_0x4_generic.uint32_index.set(paramInt3);
    localMsgBody.msg_subcmd_0x4_generic.uint32_type.set(1);
    SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg localQQDataTextMsg = new SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg();
    SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem localMsgItem = new SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem();
    localMsgItem.uint32_type.set(1);
    localMsgItem.bytes_text.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    localMsgItem.setHasFlag(true);
    localQQDataTextMsg.rpt_msg_item.add(localMsgItem);
    localQQDataTextMsg.setHasFlag(true);
    localMsgBody.msg_subcmd_0x4_generic.bytes_buf.set(ByteStringMicro.copyFrom(localQQDataTextMsg.toByteArray()));
    localMsgBody.msg_subcmd_0x4_generic.setHasFlag(true);
    localMsgBody.setHasFlag(true);
    return a(paramLong, paramInt1, localMsgBody, paramLong);
  }
  
  public ToServiceMsg a(long paramLong1, int paramInt, SubMsgType0x7.MsgBody paramMsgBody, long paramLong2)
  {
    String str = this.app.getCurrentAccountUin();
    int i = paramMsgBody.msg_header.uint32_dst_ter_type.get();
    paramMsgBody = paramMsgBody.toByteArray();
    if (QLog.isColorLevel()) {
      QLog.d("DataLineHandler", 2, "send0x211C2CDatalineMsg DataLineMsgRecord:" + paramLong2);
    }
    return a(paramLong1, str, 529, 7, paramInt, paramMsgBody, paramLong2, i);
  }
  
  public ToServiceMsg a(long paramLong, MsgCSBody0x345 paramMsgCSBody0x345)
  {
    Object localObject = null;
    byte[] arrayOfByte = null;
    cmd0x345.ReqBody localReqBody = new cmd0x345.ReqBody();
    localReqBody.uint32_sub_cmd.set(paramMsgCSBody0x345.uMsgSubType);
    switch (paramMsgCSBody0x345.uMsgSubType)
    {
    default: 
      localObject = arrayOfByte;
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "send0x345Req, unknwon nCmdType:" + paramMsgCSBody0x345.uMsgSubType);
      }
      break;
    }
    for (localObject = arrayOfByte;; localObject = createToServiceMsg("GTalkFileAppSvr.CMD_DISCUSS_FILE", null))
    {
      paramMsgCSBody0x345 = (MsgCSBody0x345)localObject;
      if (localObject != null)
      {
        paramMsgCSBody0x345 = localReqBody.toByteArray();
        arrayOfByte = new byte[paramMsgCSBody0x345.length + 4];
        aqoj.DWord2Byte(arrayOfByte, 0, paramMsgCSBody0x345.length + 4);
        aqoj.b(arrayOfByte, 4, paramMsgCSBody0x345, paramMsgCSBody0x345.length);
        ((ToServiceMsg)localObject).putWupBuffer(arrayOfByte);
        ((ToServiceMsg)localObject).addAttribute("cookie", Long.valueOf(paramLong));
        ((ToServiceMsg)localObject).extraData.putInt("DATALINE_TRYINDEX", 0);
        m((ToServiceMsg)localObject);
        paramMsgCSBody0x345 = (MsgCSBody0x345)localObject;
      }
      do
      {
        return paramMsgCSBody0x345;
        if (paramMsgCSBody0x345.subCmd0x6ReqBody != null) {
          break;
        }
        paramMsgCSBody0x345 = (MsgCSBody0x345)localObject;
      } while (!QLog.isColorLevel());
      QLog.d("DataLineHandler", 2, "send0x345Req, subCmd0x6ReqBody is empty");
      return null;
      localObject = new cmd0x345.ReqBody.SubCmd0x6ReqBody();
      ((cmd0x345.ReqBody.SubCmd0x6ReqBody)localObject).uint32_dst_bus_id.set(paramMsgCSBody0x345.subCmd0x6ReqBody.uint32_dst_bus_id);
      ((cmd0x345.ReqBody.SubCmd0x6ReqBody)localObject).uint64_src_uin.set(paramMsgCSBody0x345.subCmd0x6ReqBody.uint64_src_uin);
      ((cmd0x345.ReqBody.SubCmd0x6ReqBody)localObject).bytes_uuid.set(ByteStringMicro.copyFrom(paramMsgCSBody0x345.subCmd0x6ReqBody.bytes_uuid));
      if (paramMsgCSBody0x345.subCmd0x6ReqBody.bytes_file_md5 != null) {
        ((cmd0x345.ReqBody.SubCmd0x6ReqBody)localObject).bytes_file_md5.set(ByteStringMicro.copyFrom(paramMsgCSBody0x345.subCmd0x6ReqBody.bytes_file_md5));
      }
      ((cmd0x345.ReqBody.SubCmd0x6ReqBody)localObject).uint64_dst_uin.set(paramMsgCSBody0x345.subCmd0x6ReqBody.uint64_dst_uin);
      ((cmd0x345.ReqBody.SubCmd0x6ReqBody)localObject).uint64_file_size.set(paramMsgCSBody0x345.subCmd0x6ReqBody.uint64_file_size);
      ((cmd0x345.ReqBody.SubCmd0x6ReqBody)localObject).str_file_name.set(paramMsgCSBody0x345.subCmd0x6ReqBody.str_file_name);
      ((cmd0x345.ReqBody.SubCmd0x6ReqBody)localObject).str_src_file_path.set(paramMsgCSBody0x345.subCmd0x6ReqBody.str_src_file_path);
      ((cmd0x345.ReqBody.SubCmd0x6ReqBody)localObject).str_src_parent_folder.set(paramMsgCSBody0x345.subCmd0x6ReqBody.str_src_parent_folder);
      ((cmd0x345.ReqBody.SubCmd0x6ReqBody)localObject).uint32_client_type.set(104);
      localReqBody.msg_subcmd_0x6_req_body.set((MessageMicro)localObject);
    }
  }
  
  public ToServiceMsg a(long paramLong, MsgCSBody0x346 paramMsgCSBody0x346)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    localReqBody.uint32_cmd.set(paramMsgCSBody0x346.uMsgSubType);
    localReqBody.uint32_business_id.set(paramMsgCSBody0x346.uint32_business_id);
    if (paramMsgCSBody0x346.uint32_business_id == 0) {
      localReqBody.uint32_business_id.set(38);
    }
    localReqBody.uint32_client_type.set(104);
    PBUInt32Field localPBUInt32Field = localReqBody.uint32_seq;
    int i = cuN;
    cuN = i + 1;
    localPBUInt32Field.set(i);
    if (!this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.FillReqBody(paramMsgCSBody0x346, localReqBody))
    {
      paramMsgCSBody0x346 = (MsgCSBody0x346)localObject1;
      return paramMsgCSBody0x346;
    }
    switch (paramMsgCSBody0x346.uMsgSubType)
    {
    }
    for (;;)
    {
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("DataLineHandler", 2, "send0x346Req, unknwon nCmdType:" + paramMsgCSBody0x346.uMsgSubType);
        localObject1 = localObject2;
      }
      for (;;)
      {
        paramMsgCSBody0x346 = localReqBody.toByteArray();
        localObject2 = new byte[paramMsgCSBody0x346.length + 4];
        aqoj.DWord2Byte((byte[])localObject2, 0, paramMsgCSBody0x346.length + 4);
        aqoj.b((byte[])localObject2, 4, paramMsgCSBody0x346, paramMsgCSBody0x346.length);
        paramMsgCSBody0x346 = (MsgCSBody0x346)localObject1;
        if (localObject1 == null) {
          break;
        }
        ((ToServiceMsg)localObject1).putWupBuffer((byte[])localObject2);
        ((ToServiceMsg)localObject1).addAttribute("cookie", Long.valueOf(paramLong));
        ((ToServiceMsg)localObject1).extraData.putInt("DATALINE_TRYINDEX", 0);
        m((ToServiceMsg)localObject1);
        return localObject1;
        localObject1 = createToServiceMsg("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V2-1600", null);
        continue;
        localObject1 = createToServiceMsg("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700", null);
        continue;
        localObject1 = createToServiceMsg("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_HIT_V2-1800", null);
        continue;
        localObject1 = createToServiceMsg("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD-1200", null);
        continue;
        localObject1 = createToServiceMsg("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_FILE_QUERY-1400", null);
      }
      localObject2 = createToServiceMsg("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100", null);
    }
  }
  
  public ToServiceMsg a(long paramLong1, String paramString, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, long paramLong2)
  {
    return a(true, paramLong1, paramString, paramInt1, paramInt2, paramInt3, paramArrayOfByte, paramLong2, 1);
  }
  
  public ToServiceMsg a(long paramLong1, String paramString, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, long paramLong2, int paramInt4)
  {
    return a(true, paramLong1, paramString, paramInt1, paramInt2, paramInt3, paramArrayOfByte, paramLong2, paramInt4);
  }
  
  public Long a(int paramInt)
  {
    return Long.valueOf(this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.generateSessionID(paramInt));
  }
  
  public Long a(int paramInt1, int paramInt2)
  {
    try
    {
      long l = this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.generateSessionIDByDev(paramInt1, paramInt2);
      return Long.valueOf(l);
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      QLog.e("DataLineHandler", 1, "genSessionId failed");
      return Long.valueOf(0L);
    }
    catch (Exception localException) {}
    return Long.valueOf(0L);
  }
  
  public Long a(String paramString, int paramInt)
  {
    if (paramString.length() == 0) {
      return Long.valueOf(0L);
    }
    Long localLong = a(0, paramInt);
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.msgId = localLong.longValue();
    localDataLineMsgRecord.sessionid = localLong.longValue();
    localDataLineMsgRecord.msg = paramString;
    localDataLineMsgRecord.msgtype = -1000;
    localDataLineMsgRecord.issend = 1;
    localDataLineMsgRecord.isread = true;
    localDataLineMsgRecord.issuc = false;
    ((acle)this.app.getBusinessHandler(13)).W(localDataLineMsgRecord);
    localDataLineMsgRecord.time = anaz.gQ();
    localDataLineMsgRecord.sessionid = localLong.longValue();
    localDataLineMsgRecord.progress = 0.0F;
    this.app.b().a(paramInt).a(localDataLineMsgRecord, false);
    if (!aqiw.isNetSupport(BaseApplication.getContext())) {
      return Long.valueOf(0L);
    }
    localDataLineMsgRecord.issuc = true;
    paramString = new amzy(paramString, localLong, localDataLineMsgRecord);
    if (!a(paramString)) {
      return Long.valueOf(0L);
    }
    this.sV.add(paramString);
    return localLong;
  }
  
  public SubMsgType0x7.MsgBody a(DataLineMsgRecord paramDataLineMsgRecord, long paramLong)
  {
    String str = paramDataLineMsgRecord.filename;
    SubMsgType0x7.MsgBody localMsgBody = new SubMsgType0x7.MsgBody();
    localMsgBody.uint32_sub_cmd.set(1);
    int i = DataLineMsgRecord.getDevTypeBySeId(paramDataLineMsgRecord.sessionid);
    ProtocolHelper.fillMsgHeader(localMsgBody.msg_header, paramLong, Long.valueOf(this.app.getCurrentAccountUin()).longValue(), i);
    SubMsgType0x7.MsgBody.FTNNotify localFTNNotify = new SubMsgType0x7.MsgBody.FTNNotify();
    localFTNNotify.uint64_sessionid.set(paramDataLineMsgRecord.sessionid);
    localFTNNotify.str_file_name.set(str);
    localFTNNotify.str_file_index.set(paramDataLineMsgRecord.serverPath);
    localFTNNotify.bytes_file_md5.set(ByteStringMicro.copyFrom(paramDataLineMsgRecord.md5));
    localFTNNotify.uint64_file_len.set(paramDataLineMsgRecord.filesize);
    localFTNNotify.bytes_originfile_md5.set(ByteStringMicro.copyFrom(paramDataLineMsgRecord.md5));
    localFTNNotify.uint32_originfiletype.set(gv(paramDataLineMsgRecord.msgtype));
    localFTNNotify.setHasFlag(true);
    localMsgBody.rpt_msg_subcmd_0x1_ftn_notify.add(localFTNNotify);
    localMsgBody.setHasFlag(true);
    return localMsgBody;
  }
  
  protected void a(long paramLong1, long paramLong2, SubMsgType0x7.MsgBody.GenericSubCmd paramGenericSubCmd, SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader)
  {
    for (;;)
    {
      amzx localamzx;
      Object localObject1;
      try
      {
        if (!paramGenericSubCmd.uint32_type.has()) {
          return;
        }
        switch (paramGenericSubCmd.uint32_type.get())
        {
        case 1: 
          if (!paramGenericSubCmd.uint64_sessionid.has()) {
            break label697;
          }
          switch (paramMsgHeader.uint32_src_ter_type.get())
          {
          default: 
            long l = paramGenericSubCmd.uint64_sessionid.get();
            if (i != 1) {
              break label694;
            }
            l |= 0x0;
            if (!this.iE.containsKey(Long.valueOf(l)))
            {
              localamzx = new amzx(Long.valueOf(paramGenericSubCmd.uint32_size.get()), Long.valueOf(l));
              this.iE.put(Long.valueOf(l), localamzx);
              if (!paramGenericSubCmd.bytes_buf.has()) {
                break label697;
              }
              paramMsgHeader = new String();
              localObject1 = new SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg();
              ((SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg)localObject1).mergeFrom(paramGenericSubCmd.bytes_buf.get().toByteArray());
              localObject1 = ((SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg)localObject1).rpt_msg_item.get().iterator();
              if (((Iterator)localObject1).hasNext())
              {
                Object localObject2 = (SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem)((Iterator)localObject1).next();
                if ((!((SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem)localObject2).uint32_type.has()) || (((SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem)localObject2).uint32_type.get() != 1) || (!((SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem)localObject2).bytes_text.has())) {
                  break label691;
                }
                localObject2 = new String(((SubMsgType0x7.MsgBody.GenericSubCmd.QQDataTextMsg.MsgItem)localObject2).bytes_text.get().toByteArray());
                paramMsgHeader = paramMsgHeader + (String)localObject2;
                break label705;
              }
            }
            else
            {
              localamzx = (amzx)this.iE.get(Long.valueOf(l));
              continue;
            }
            if (!paramGenericSubCmd.uint32_index.has()) {
              break label697;
            }
            localamzx.dG(paramGenericSubCmd.uint32_index.get(), paramMsgHeader);
            if (!localamzx.awr()) {
              break label697;
            }
            this.iE.remove(Long.valueOf(l));
            localObject1 = new DataLineMsgRecord();
            ((DataLineMsgRecord)localObject1).msgId = l;
            ((DataLineMsgRecord)localObject1).sessionid = l;
            if (i == 1)
            {
              paramGenericSubCmd = localamzx.zr();
              i = 0;
              if (i < aoff.hj.length)
              {
                paramMsgHeader = paramGenericSubCmd;
                if (paramGenericSubCmd.indexOf('\024' + aoff.hj[i]) == -1) {
                  break label714;
                }
                paramMsgHeader = paramGenericSubCmd.replace('\024' + aoff.hj[i], "\024" + (char)i);
                break label714;
              }
              ((DataLineMsgRecord)localObject1).msg = paramGenericSubCmd;
              ((DataLineMsgRecord)localObject1).msgtype = -1000;
              ((DataLineMsgRecord)localObject1).issend = 0;
              ((DataLineMsgRecord)localObject1).isread = false;
              ((DataLineMsgRecord)localObject1).time = paramLong1;
              ((DataLineMsgRecord)localObject1).issuc = true;
              ((DataLineMsgRecord)localObject1).sessionid = ((DataLineMsgRecord)localObject1).msgId;
              ((DataLineMsgRecord)localObject1).shmsgseq = paramLong2;
              i = DataLineMsgRecord.getDevTypeBySeId(((DataLineMsgRecord)localObject1).sessionid);
              this.app.b().a(i).a((DataLineMsgRecord)localObject1, true);
              cIh();
              e(8, true, new Object[] { Integer.valueOf((int)paramLong1), localamzx.zr(), Long.valueOf(((DataLineMsgRecord)localObject1).sessionid) });
              return;
            }
            break;
          }
          break;
        }
      }
      catch (Exception paramGenericSubCmd)
      {
        paramGenericSubCmd.printStackTrace();
        return;
      }
      ((DataLineMsgRecord)localObject1).msg = localamzx.zr();
      continue;
      ajdv.a().a(paramGenericSubCmd);
      return;
      label691:
      break label705;
      label694:
      continue;
      label697:
      return;
      return;
      int i = 0;
      continue;
      label705:
      continue;
      i = 1;
      continue;
      label714:
      i += 1;
      paramGenericSubCmd = paramMsgHeader;
    }
  }
  
  public void a(DataLineMsgRecord paramDataLineMsgRecord, boolean paramBoolean)
  {
    if (paramDataLineMsgRecord == null) {}
    ArrayList localArrayList;
    Session localSession;
    do
    {
      return;
      localArrayList = new ArrayList();
      localSession = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.genSession(paramDataLineMsgRecord);
    } while (localSession == null);
    if (0L == paramDataLineMsgRecord.sessionid) {
      localSession.uSessionID = a(0, this.cuM).longValue();
    }
    localSession.msgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.msgHeader(Long.valueOf(this.app.getCurrentAccountUin()).longValue(), this.cuM);
    localArrayList.add(localSession);
    A(localArrayList, paramBoolean);
  }
  
  public void a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    if (paramWeiYunFileInfo == null)
    {
      QLog.e("DatalineHandler", 1, "sendWeiYunFile weiYunFileInfo=null");
      return;
    }
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.selfuin = this.app.getCurrentUin();
    localDataLineMsgRecord.filename = paramWeiYunFileInfo.strFileName;
    localDataLineMsgRecord.filesize = paramWeiYunFileInfo.nFileSize;
    localDataLineMsgRecord.busId = 25;
    localDataLineMsgRecord.fileFrom = 4;
    localDataLineMsgRecord.nOpType = 35;
    localDataLineMsgRecord.istroop = 0;
    acde localacde = (acde)this.app.getBusinessHandler(8);
    localDataLineMsgRecord.sessionid = localacde.a(0, 0).longValue();
    localDataLineMsgRecord.msg = "";
    localDataLineMsgRecord.issend = 1;
    localDataLineMsgRecord.isread = true;
    localDataLineMsgRecord.issuc = false;
    ((acle)this.app.getBusinessHandler(13)).W(localDataLineMsgRecord);
    localDataLineMsgRecord.time = anaz.gQ();
    localDataLineMsgRecord.progress = 0.2F;
    localDataLineMsgRecord.fileMsgStatus = 0L;
    localDataLineMsgRecord.msgtype = gu(0);
    localDataLineMsgRecord.bIsTransfering = true;
    localDataLineMsgRecord.bNoInsertFm = true;
    localDataLineMsgRecord.strWeiyunId = paramWeiYunFileInfo.bIk;
    localDataLineMsgRecord.strWeiyunDir = paramWeiYunFileInfo.dirKey;
    localDataLineMsgRecord.nWeiyunSrcType = paramWeiYunFileInfo.cYi;
    localDataLineMsgRecord.strWeiyunMd5 = paramWeiYunFileInfo.md5;
    localDataLineMsgRecord.strWeiyunSha = paramWeiYunFileInfo.sha;
    this.app.b().a(DataLineMsgRecord.getDevTypeBySeId(localDataLineMsgRecord.sessionid)).a(localDataLineMsgRecord, true);
    localacde.e(7, true, new Object[] { Long.valueOf(0L), Long.valueOf(localDataLineMsgRecord.sessionid), localDataLineMsgRecord.path, Byte.valueOf((byte)gv(localDataLineMsgRecord.msgtype)), Boolean.valueOf(false), Boolean.valueOf(false), Long.valueOf(localDataLineMsgRecord.filesize) });
    a(localDataLineMsgRecord, paramWeiYunFileInfo);
  }
  
  public void a(ArrayList<FileInfo> paramArrayList, String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    if (paramArrayList == null) {}
    int j;
    int i;
    ArrayList localArrayList;
    Object localObject;
    String str;
    for (;;)
    {
      return;
      j = paramArrayList.size();
      if (j > 3) {
        break;
      }
      i = 0;
      while (i < j)
      {
        localArrayList = new ArrayList();
        localObject = ((FileInfo)paramArrayList.get(i)).getPath();
        str = ((FileInfo)paramArrayList.get(i)).getApkPackeageName();
        localObject = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.genSession(0, (String)localObject, null, str, 0, 0, 0L, 0, 0, 0);
        if (localObject != null)
        {
          localArrayList.add(localObject);
          ((Session)localObject).uSessionID = a(0, this.cuM).longValue();
          ((Session)localObject).msgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.msgHeader(paramLong, this.cuM);
          this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillService((Session)localObject, paramString, paramArrayOfByte);
        }
        if (localArrayList.size() > 0) {
          A(localArrayList, false);
        }
        i += 1;
      }
    }
    if ((j > 3) && (j < 50))
    {
      localArrayList = new ArrayList();
      int k = An();
      i = 0;
      label199:
      if (i < j)
      {
        localObject = ((FileInfo)paramArrayList.get(i)).getPath();
        str = ((FileInfo)paramArrayList.get(i)).getApkPackeageName();
        localObject = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.genSession(0, (String)localObject, null, str, 0, 0, 0L, k, j, i);
        if (localObject == null) {
          break label634;
        }
        localArrayList.add(localObject);
        ((Session)localObject).uSessionID = a(k, this.cuM).longValue();
        ((Session)localObject).msgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.msgHeader(paramLong, this.cuM);
        this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillService((Session)localObject, paramString, paramArrayOfByte);
        if (!DataLineMsgSet.isSingle(0, k)) {
          break label634;
        }
        ((Session)localObject).dwGroupID = 0;
        ((Session)localObject).dwGroupIndex = 0;
        ((Session)localObject).dwGroupSize = 0;
        if (localArrayList.size() > 0) {
          A(localArrayList, false);
        }
        localArrayList = new ArrayList();
      }
    }
    label412:
    label631:
    label634:
    for (;;)
    {
      i += 1;
      break label199;
      if (localArrayList.size() <= 0) {
        break;
      }
      A(localArrayList, false);
      return;
      j = An();
      localArrayList = new ArrayList();
      i = 0;
      if (i < 50)
      {
        localObject = ((FileInfo)paramArrayList.get(i)).getPath();
        str = ((FileInfo)paramArrayList.get(i)).getApkPackeageName();
        localObject = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.genSession(0, (String)localObject, null, str, 0, 0, 0L, j, 50, i);
        if (localObject == null) {
          break label631;
        }
        localArrayList.add(localObject);
        ((Session)localObject).uSessionID = a(j, this.cuM).longValue();
        ((Session)localObject).msgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.msgHeader(paramLong, this.cuM);
        this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillService((Session)localObject, paramString, paramArrayOfByte);
        if (!DataLineMsgSet.isSingle(0, j)) {
          break label631;
        }
        ((Session)localObject).dwGroupID = 0;
        ((Session)localObject).dwGroupIndex = 0;
        ((Session)localObject).dwGroupSize = 0;
        if (localArrayList.size() > 0) {
          A(localArrayList, false);
        }
        localArrayList = new ArrayList();
      }
      for (;;)
      {
        i += 1;
        break label412;
        if (localArrayList.size() > 0) {
          A(localArrayList, false);
        }
        i = 0;
        while (i < 50)
        {
          paramArrayList.remove(0);
          i += 1;
        }
        break;
      }
    }
  }
  
  public void a(ArrayList<DataLineMsgRecord> paramArrayList, boolean paramBoolean, String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)paramArrayList.next();
      Session localSession = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.genSession(localDataLineMsgRecord);
      if (localSession != null)
      {
        if (0L == localSession.uSessionID) {
          localSession.uSessionID = a(localDataLineMsgRecord.groupId, this.cuM).longValue();
        }
        localSession.msgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.msgHeader(paramLong, this.cuM);
        this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillService(localSession, paramString, paramArrayOfByte);
        localArrayList.add(localSession);
      }
    }
    if (localArrayList.size() > 0) {
      A(localArrayList, paramBoolean);
    }
  }
  
  public void a(msg_comm.Msg paramMsg, SubMsgType0x7.MsgBody paramMsgBody)
  {
    this.jdField_a_of_type_Aviq.a(paramMsg, paramMsgBody);
    DataLineMsgRecord localDataLineMsgRecord;
    try
    {
      localDataLineMsgRecord = new DataLineMsgRecord();
      localDataLineMsgRecord.shmsgseq = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
      localDataLineMsgRecord.time = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
      localDataLineMsgRecord.msgId = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
      if (!paramMsgBody.msg_header.has()) {
        throw new Exception("msgBody do not has msg_header");
      }
    }
    catch (Exception paramMsg)
    {
      paramMsg = paramMsg;
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "<<<<<<<<<<handleDataLinePushMsg_PB_0x211 Exception:" + paramMsg.toString() + ">>>>>>>>>>");
      }
      return;
      if (!paramMsgBody.msg_header.uint32_src_app_id.has()) {
        throw new Exception("msgBody do not has uint32_src_app_id");
      }
    }
    finally {}
    if (!paramMsgBody.msg_header.uint32_src_inst_id.has()) {
      throw new Exception("msgBody do not has uint32_src_inst_id");
    }
    if (!paramMsgBody.msg_header.uint32_dst_app_id.has()) {
      throw new Exception("msgBody do not has uint32_dst_app_id");
    }
    if (!paramMsgBody.msg_header.uint32_dst_inst_id.has()) {
      throw new Exception("msgBody do not has uint32_dst_inst_id");
    }
    if (e(paramMsgBody.msg_header.uint32_src_app_id.get(), paramMsgBody.msg_header.uint32_src_inst_id.get())) {
      throw new Exception("msgBody command from android");
    }
    if ((paramMsgBody.uint32_sub_cmd.get() != 5) && (!q(paramMsgBody.msg_header.uint32_dst_app_id.get(), paramMsgBody.msg_header.uint32_dst_inst_id.get()))) {
      throw new Exception("msgBody command not for android");
    }
    Object localObject = (im_msg_head.InstInfo)((im_msg_head.InstCtrl)((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_inst_ctrl.get()).msg_from_inst.get();
    paramMsgBody.msg_header.uint32_src_ter_type.set(((im_msg_head.InstInfo)localObject).enum_device_type.get());
    QLog.d("DataLineHandler", 2, "DoCCPush msg time[" + localDataLineMsgRecord.time + "] mr.shmsgseq[" + localDataLineMsgRecord.shmsgseq + "] uint32_sub_cmd[" + paramMsgBody.uint32_sub_cmd.get() + "]");
    this.app.b().a(paramMsgBody.msg_header.uint32_src_ter_type.get()).ih(localDataLineMsgRecord.time);
    if (a(localDataLineMsgRecord, paramMsgBody.msg_header.uint32_src_ter_type.get()))
    {
      QLog.d("DataLineHandler", 2, "DoCCPush msg time[" + localDataLineMsgRecord.time + "] is repeated mr.shmsgseq[" + localDataLineMsgRecord.shmsgseq + "] uint32_sub_cmd[" + paramMsgBody.uint32_sub_cmd.get() + "]");
      return;
    }
    localObject = (ackv)this.app.getBusinessHandler(10);
    if ((localObject != null) && (((ackv)localObject).AO() != 1)) {
      ((ackv)localObject).ac(1);
    }
    if (!paramMsgBody.uint32_sub_cmd.has()) {
      throw new Exception("msgBody do not has uint32_sub_cmd");
    }
    QLog.d("DataLineHandler", 2, "DoCCPush msg time[" + localDataLineMsgRecord.time + "]  mr.shmsgseq[" + localDataLineMsgRecord.shmsgseq + "] uint32_sub_cmd[" + paramMsgBody.uint32_sub_cmd.get() + "]");
    switch (paramMsgBody.uint32_sub_cmd.get())
    {
    case 1: 
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "0x211 0x7 0x1 文件原图中转通知");
      }
      if (!paramMsgBody.msg_header.uint64_dst_uin.has()) {
        throw new Exception("msg_header do not has uint64_dst_uin");
      }
    case 4: 
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "0x211 0x7 0x4 通用协议");
      }
      if (!paramMsgBody.msg_subcmd_0x4_generic.has()) {
        throw new Exception("msgBody do not has msg_subcmd_0x4_generic");
      }
      a(localDataLineMsgRecord.time, localDataLineMsgRecord.shmsgseq, paramMsgBody.msg_subcmd_0x4_generic, paramMsgBody.msg_header);
      return;
      a(((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get(), paramMsgBody.msg_header, paramMsgBody.rpt_msg_subcmd_0x1_ftn_notify.get(), false);
      return;
    case 2: 
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "0x211 0x7 0x2 文件原图近场通知");
      }
      if (!paramMsgBody.msg_header.uint64_dst_uin.has()) {
        throw new Exception("msg_header do not has uint64_dst_uin");
      }
      b(((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get(), paramMsgBody.msg_header, paramMsgBody.rpt_msg_subcmd_0x2_nfc_notify.get(), false);
      return;
    case 3: 
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "0x211 0x7 0x3 文件控制命令");
      }
      a(paramMsgBody.msg_header, paramMsgBody.rpt_msg_subcmd_0x3_filecontrol.get());
      return;
    case 5: 
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "0x211 0x7 0x5 应用宝通知");
      }
      iF(paramMsgBody.rpt_msg_subcmd_0x5_molo_notify.get());
      return;
    case 11: 
      A(paramMsgBody.rpt_msg_subcmd_0xb_mpfile_notify.get());
      return;
    case 9: 
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "0x211 0x7 0x9 文件缩略图中转通知");
      }
      if (!paramMsgBody.msg_header.uint64_dst_uin.has()) {
        throw new Exception("msg_header do not has uint64_dst_uin");
      }
      a(((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get(), paramMsgBody.msg_header, paramMsgBody.rpt_msg_subcmd_0x9_ftn_thumb_notify.get(), true);
      return;
    case 10: 
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "0x211 0x7 0xa 文件缩略图近场通知");
      }
      if (!paramMsgBody.msg_header.uint64_dst_uin.has()) {
        throw new Exception("msg_header do not has uint64_dst_uin");
      }
      b(((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get(), paramMsgBody.msg_header, paramMsgBody.rpt_msg_subcmd_0xa_nfc_thumb_notify.get(), true);
      return;
    case 8: 
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "0x211 0x7 0x8 rfc信令");
      }
      if (!paramMsgBody.msg_header.uint64_dst_uin.has()) {
        throw new Exception("msg_header do not has uint64_dst_uin");
      }
      a(((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get(), paramMsgBody.msg_header, paramMsgBody.rpt_msg_subcmd_0x8_rnfc_notify.get());
      return;
    }
  }
  
  public void a(msg_comm.Msg paramMsg, C2CType0x211_SubC2CType0x9.MsgBody paramMsgBody)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new MqqHandler(localLooper).post(new DataLineHandler.10(this, this, paramMsg, paramMsgBody));
      return;
    }
    this.jdField_a_of_type_Acio.a(this, paramMsg, paramMsgBody);
  }
  
  public boolean a(DataLineMsgRecord paramDataLineMsgRecord, int paramInt)
  {
    Object localObject;
    Iterator localIterator;
    MessageRecord localMessageRecord;
    if (paramInt == 3)
    {
      if (this.xn == null) {
        this.xn = new ArrayList();
      }
      if (this.xn.isEmpty())
      {
        localObject = this.app.a(1).a();
        if ((localObject != null) && (((DataLineMsgSetList)localObject).size() > 0))
        {
          localObject = ((DataLineMsgSetList)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            localIterator = ((DataLineMsgSet)((Iterator)localObject).next()).values().iterator();
            while (localIterator.hasNext())
            {
              localMessageRecord = (MessageRecord)localIterator.next();
              this.xn.add(Long.valueOf(localMessageRecord.shmsgseq));
            }
          }
        }
      }
      localObject = this.xn.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (((Long)((Iterator)localObject).next()).longValue() != paramDataLineMsgRecord.shmsgseq);
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        this.xn.add(Long.valueOf(paramDataLineMsgRecord.shmsgseq));
        bool2 = bool1;
        if (this.xn.size() > 120)
        {
          this.xn.remove(0);
          bool2 = bool1;
        }
      }
      return bool2;
      if (this.xm == null) {
        this.xm = new ArrayList();
      }
      if (this.xm.isEmpty())
      {
        localObject = this.app.a(0).a();
        if ((localObject != null) && (((DataLineMsgSetList)localObject).size() > 0))
        {
          localObject = ((DataLineMsgSetList)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            localIterator = ((DataLineMsgSet)((Iterator)localObject).next()).values().iterator();
            while (localIterator.hasNext())
            {
              localMessageRecord = (MessageRecord)localIterator.next();
              this.xm.add(Long.valueOf(localMessageRecord.shmsgseq));
            }
          }
        }
      }
      localObject = this.xm.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (((Long)((Iterator)localObject).next()).longValue() != paramDataLineMsgRecord.shmsgseq);
      for (bool1 = true;; bool1 = false)
      {
        bool2 = bool1;
        if (bool1) {
          break;
        }
        this.xm.add(Long.valueOf(paramDataLineMsgRecord.shmsgseq));
        bool2 = bool1;
        if (this.xm.size() <= 120) {
          break;
        }
        this.xm.remove(0);
        return bool1;
      }
    }
  }
  
  public boolean af(List<Long> paramList)
  {
    QLog.i("DataLineHandler", 1, "manually receives a file . sessionlist");
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1 = paramList.iterator();
    boolean bool1 = false;
    int i;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Long)((Iterator)localObject1).next();
      i = DataLineMsgRecord.getDevTypeBySeId(((Long)localObject2).longValue());
      localObject3 = getApp().b().a(i).a(((Long)localObject2).longValue());
      if (localObject3 != null)
      {
        ((DataLineMsgRecord)localObject3).fileMsgStatus = 0L;
        this.app.b().a(i).ig(((DataLineMsgRecord)localObject3).msgId);
      }
      if ((localObject3 != null) && (((DataLineMsgRecord)localObject3).strMoloKey != null))
      {
        this.jdField_b_of_type_Cl.y(((DataLineMsgRecord)localObject3).strMoloKey);
        bool1 = true;
      }
      for (;;)
      {
        break;
        localArrayList1.add(localObject2);
      }
    }
    ArrayList localArrayList2 = new ArrayList();
    boolean bool2 = bool1;
    DataLineMsgRecord localDataLineMsgRecord;
    if (localArrayList1.size() > 0)
    {
      localObject2 = null;
      Iterator localIterator = paramList.iterator();
      localObject3 = null;
      localObject1 = null;
      paramList = (List<Long>)localObject2;
      if (!localIterator.hasNext()) {
        break label569;
      }
      localObject2 = (Long)localIterator.next();
      i = DataLineMsgRecord.getDevTypeBySeId(((Long)localObject2).longValue());
      localDataLineMsgRecord = this.app.b().a(i).a(((Long)localObject2).longValue());
      if (localDataLineMsgRecord == null)
      {
        QLog.e("DataLineHandler", 1, "uSessionID[" + localObject2 + "], prepareMsg: session not found");
        bool2 = false;
      }
    }
    else
    {
      label291:
      return bool2;
    }
    localArrayList2.add(localDataLineMsgRecord);
    if ((localDataLineMsgRecord.filename == null) || (localDataLineMsgRecord.filesize == 0L) || ((localDataLineMsgRecord.md5 == null) && (TextUtils.isEmpty(localDataLineMsgRecord.serverPath))))
    {
      QLog.e("DataLineHandler", 1, "uSessionID[" + localObject2 + "], receive param err.filename:" + localDataLineMsgRecord.filename + " filesize;" + localDataLineMsgRecord.filesize);
      return false;
    }
    Object localObject4 = a(localDataLineMsgRecord.sessionid);
    Object localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = new ArrayList();
    }
    ((List)localObject2).add(localObject4);
    localObject4 = new FTNInfo();
    ((FTNInfo)localObject4).strFileIndex = localDataLineMsgRecord.serverPath;
    Object localObject3 = localObject1;
    if (localObject1 == null) {
      localObject3 = new ArrayList();
    }
    ((List)localObject3).add(localObject4);
    localObject1 = new NFCInfo();
    ((NFCInfo)localObject1).dwServerIP = ((int)localDataLineMsgRecord.nServerIp);
    ((NFCInfo)localObject1).wServerPort = ((short)(int)localDataLineMsgRecord.nServerPort);
    ((NFCInfo)localObject1).vTokenKey = localDataLineMsgRecord.vTokenKey;
    ((NFCInfo)localObject1).vUrlNotify = localDataLineMsgRecord.vUrlNotify;
    if (paramList == null) {
      paramList = new ArrayList();
    }
    for (;;)
    {
      paramList.add(localObject1);
      localObject1 = localObject3;
      localObject3 = localObject2;
      break;
      label569:
      bool2 = bool1;
      if (localObject3 == null) {
        break label291;
      }
      localObject2 = this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper;
      localObject3 = (Session[])((List)localObject3).toArray(new Session[((List)localObject3).size()]);
      paramList = (NFCInfo[])paramList.toArray(new NFCInfo[paramList.size()]);
      localObject1 = (FTNInfo[])((List)localObject1).toArray(new FTNInfo[((List)localObject1).size()]);
      if (localArrayList1.size() == 1) {}
      for (bool1 = false;; bool1 = true)
      {
        ((LiteTransferWrapper)localObject2).RecvGroup((Session[])localObject3, paramList, (FTNInfo[])localObject1, bool1);
        paramList = localArrayList2.iterator();
        while (paramList.hasNext()) {
          ((DataLineMsgRecord)paramList.next()).bIsTransfering = true;
        }
      }
      return true;
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt)
  {
    new Handler(Looper.getMainLooper()).post(new DataLineHandler.6(this, paramToServiceMsg, paramFromServiceMsg, paramInt));
  }
  
  public void b(msg_comm.Msg paramMsg)
  {
    this.jdField_a_of_type_Aviq.a(paramMsg);
  }
  
  public void bm(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.CancelAll(paramInt, paramBoolean);
    this.jdField_b_of_type_Cl.W();
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt)
  {
    if (paramToServiceMsg == null) {}
    long l;
    do
    {
      return;
      l = ((Long)paramToServiceMsg.getAttribute("cookie")).longValue();
      paramInt = DataLineMsgRecord.getDevTypeBySeId(l);
    } while (this.app.b().a(paramInt).a(l) == null);
    new Handler(Looper.getMainLooper()).post(new DataLineHandler.7(this, paramFromServiceMsg, paramInt, l));
  }
  
  public boolean c(DataLineMsgRecord paramDataLineMsgRecord)
  {
    OnSessionProgress(paramDataLineMsgRecord.sessionid, (paramDataLineMsgRecord.filesize * 0.4D), paramDataLineMsgRecord.filesize);
    if ((0L != paramDataLineMsgRecord.filesize) && (paramDataLineMsgRecord.path != null) && (paramDataLineMsgRecord.path.length() != 0) && (paramDataLineMsgRecord.md5 != null) && (paramDataLineMsgRecord.md5.length != 0)) {}
    for (int i = 1; i != 0; i = 0) {
      return true;
    }
    Object localObject2 = new cmd0x346.ReqBody();
    ((cmd0x346.ReqBody)localObject2).uint32_cmd.set(1400);
    ((cmd0x346.ReqBody)localObject2).uint32_client_type.set(104);
    Object localObject1 = ((cmd0x346.ReqBody)localObject2).uint32_seq;
    i = cuN;
    cuN = i + 1;
    ((PBUInt32Field)localObject1).set(i);
    ((cmd0x346.ReqBody)localObject2).msg_file_query_req.setHasFlag(true);
    ((cmd0x346.ReqBody)localObject2).msg_file_query_req.uint64_uin.set(Long.valueOf(this.app.getCurrentAccountUin()).longValue());
    if ((2 == paramDataLineMsgRecord.fileFrom) || (4 == paramDataLineMsgRecord.fileFrom) || (6 == paramDataLineMsgRecord.fileFrom))
    {
      ((cmd0x346.ReqBody)localObject2).msg_file_query_req.bytes_uuid.set(ByteStringMicro.copyFrom(paramDataLineMsgRecord.serverPath.getBytes()));
      ((cmd0x346.ReqBody)localObject2).uint32_business_id.set(38);
    }
    for (;;)
    {
      localObject1 = createToServiceMsg("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_FILE_QUERY-1400", null);
      ((ToServiceMsg)localObject1).addAttribute("sendFromNative", Boolean.valueOf(false));
      localObject2 = ((cmd0x346.ReqBody)localObject2).toByteArray();
      byte[] arrayOfByte = new byte[localObject2.length + 4];
      aqoj.DWord2Byte(arrayOfByte, 0, localObject2.length + 4);
      aqoj.b(arrayOfByte, 4, (byte[])localObject2, localObject2.length);
      if (localObject1 != null)
      {
        ((ToServiceMsg)localObject1).putWupBuffer(arrayOfByte);
        ((ToServiceMsg)localObject1).addAttribute("cookie", Long.valueOf(paramDataLineMsgRecord.sessionid));
        ((ToServiceMsg)localObject1).extraData.putInt("DATALINE_TRYINDEX", 0);
        m((ToServiceMsg)localObject1);
      }
      return false;
      ((cmd0x346.ReqBody)localObject2).msg_file_query_req.bytes_uuid.set(ByteStringMicro.copyFrom(paramDataLineMsgRecord.fileUuid.getBytes()));
      ((cmd0x346.ReqBody)localObject2).uint32_business_id.set(3);
    }
  }
  
  public boolean c(DataLineMsgSet paramDataLineMsgSet)
  {
    if (!paramDataLineMsgSet.isSingle()) {
      IO(paramDataLineMsgSet.getGroupId());
    }
    int i = DataLineMsgRecord.getDevTypeBySet(paramDataLineMsgSet);
    Iterator localIterator = paramDataLineMsgSet.values().iterator();
    while (localIterator.hasNext())
    {
      DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
      if (localDataLineMsgRecord.strMoloKey != null)
      {
        List localList = getApp().a(i).am(localDataLineMsgRecord.strMoloKey);
        if ((localList == null) || (localList.size() == 1))
        {
          this.jdField_b_of_type_Cl.delete(localDataLineMsgRecord.strMoloKey);
          if (QLog.isDevelopLevel()) {
            QLog.d("DataLineHandler", 4, "删除应用宝消息 sessionid[" + localDataLineMsgRecord.sessionid);
          }
        }
      }
    }
    return this.app.b().a(i).a(paramDataLineMsgSet) >= 0;
  }
  
  public void cIe()
  {
    long l = this.app.b().a(String.valueOf(acbn.bkw), 6000).time;
    QLog.d("DataLineHandler", 2, "sendDatalineReadConfirm last time[" + l + "]");
    ArrayList localArrayList;
    if ((l != 0L) && (l != this.Pn))
    {
      localArrayList = new ArrayList();
      localArrayList.add(new Pair(Long.valueOf(this.app.getCurrentAccountUin()), Long.valueOf(l)));
      ((tob)this.app.a().a("c2c_processor")).cL(localArrayList);
      this.Pn = l;
    }
    l = this.app.b().a(String.valueOf(acbn.bkx), 6003).time;
    if ((l != 0L) && (l != this.Po))
    {
      localArrayList = new ArrayList();
      localArrayList.add(new Pair(Long.valueOf(this.app.getCurrentAccountUin()), Long.valueOf(l)));
      ((tob)this.app.a().a("c2c_processor")).cL(localArrayList);
      this.Po = l;
    }
  }
  
  public void cIi()
  {
    Object localObject = this.app.a(0).a();
    DataLineMsgSet localDataLineMsgSet;
    if (localObject != null)
    {
      localObject = ((DataLineMsgSetList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localDataLineMsgSet = (DataLineMsgSet)((Iterator)localObject).next();
        if (!localDataLineMsgSet.isSingle()) {
          IO(localDataLineMsgSet.getGroupId());
        }
      }
    }
    localObject = this.app.a(0).a(false);
    if (localObject != null)
    {
      localObject = ((DataLineMsgSetList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localDataLineMsgSet = (DataLineMsgSet)((Iterator)localObject).next();
        if (!localDataLineMsgSet.isSingle()) {
          IO(localDataLineMsgSet.getGroupId());
        }
      }
    }
    this.jdField_b_of_type_Cl.X();
  }
  
  public void cW(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DataLineHandler", 2, "received a cmd=" + paramFromServiceMsg.getServiceCmd());
    }
    if (paramFromServiceMsg.getServiceCmd().equals("MessageSvc.PbSendMsg"))
    {
      if (!paramToServiceMsg.extraData.getBoolean("exit_push_0x211_key", false)) {
        break label73;
      }
      ajdv.a().jZ(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    label73:
    while ((paramToServiceMsg.extraData.getInt("ROUNTING_TYPE") != 13) || (!paramToServiceMsg.extraData.getBoolean("ISFROM_DATALINE"))) {
      return;
    }
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      int i = paramToServiceMsg.extraData.getInt("DATALINE_TRYINDEX");
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "<PbSendMsg><R><---handle0x211C2CMessageError, retry = " + i);
      }
      if (i < 3)
      {
        paramToServiceMsg.extraData.putInt("DATALINE_TRYINDEX", i + 1);
        sendPbReq(paramToServiceMsg);
        return;
      }
    }
    cX(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void cX(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    msg_svc.PbSendMsgResp localPbSendMsgResp = new msg_svc.PbSendMsgResp();
    try
    {
      localPbSendMsgResp = (msg_svc.PbSendMsgResp)localPbSendMsgResp.mergeFrom((byte[])paramObject);
      if ((localPbSendMsgResp == null) || (!localPbSendMsgResp.result.has()))
      {
        if (QLog.isColorLevel()) {
          QLog.e("DataLineHandler", 2, "handle0x211C2CMessageResp::server did not return a valid result code, use 4 instead.");
        }
        i = 4;
        if (QLog.isColorLevel()) {
          QLog.d("DataLineHandler", 2, "<PbSendMsg><R><---handle0x211C2CMessageResp: ---ServiceCmd:" + paramToServiceMsg.getServiceCmd() + "----replyCode:" + i);
        }
        switch (paramToServiceMsg.extraData.getInt("DATALINE_CMD"))
        {
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        if (QLog.isColorLevel()) {
          QLog.e("DataLineHandler", 2, "<---handle0x211C2CMessageResp::invalid.", localException);
        }
        Object localObject = null;
        continue;
        if (localObject.result.get() != 0)
        {
          i = localObject.result.get();
          continue;
          cZ(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
          cY(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
          cY(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
          paramToServiceMsg = (Long)paramToServiceMsg.getAttribute("cookie");
          if ((a(paramToServiceMsg.longValue()) == null) && (QLog.isColorLevel())) {
            QLog.d("DataLineHandler", 2, "uSessionID[" + paramToServiceMsg + "]handleFileOperate: session not found");
          }
        }
        else
        {
          i = 0;
        }
      }
    }
  }
  
  public void dA(ArrayList<FileInfo> paramArrayList)
  {
    a(paramArrayList, null, null, Long.valueOf(this.app.getCurrentAccountUin()).longValue());
  }
  
  public void e(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (this.A != null)
    {
      this.A.cancel();
      this.A = null;
    }
    if (((paramInt == 3) || (paramInt == 2) || (paramInt == 1) || (paramInt == 8)) && (!this.bHi)) {}
    try
    {
      this.A = new Timer();
      this.A.schedule(new DataLineHandler.4(this), 20000L);
      notifyUI(paramInt, paramBoolean, paramObject);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        localIllegalStateException.printStackTrace();
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localOutOfMemoryError.printStackTrace();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void e(DataLineMsgRecord paramDataLineMsgRecord)
  {
    a(1004, a(paramDataLineMsgRecord, Long.valueOf(this.app.getCurrentAccountUin()).longValue()), paramDataLineMsgRecord.sessionid);
    OnSessionProgress(paramDataLineMsgRecord.sessionid, (paramDataLineMsgRecord.filesize * 0.8D), paramDataLineMsgRecord.filesize);
  }
  
  public void e(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      QLog.e("DatalineHandler", 1, "sendWeiYunFile weiyunEntity=null");
      return;
    }
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.selfuin = this.app.getCurrentUin();
    localDataLineMsgRecord.filename = paramFileManagerEntity.fileName;
    if (paramFileManagerEntity.strThumbPath != null)
    {
      localDataLineMsgRecord.thumbPath = ahbj.ba(ahbj.aC(this.app.getApplication()), ahav.getFileName(paramFileManagerEntity.strThumbPath));
      aqhq.copyFile(paramFileManagerEntity.strThumbPath, localDataLineMsgRecord.thumbPath);
    }
    localDataLineMsgRecord.filesize = paramFileManagerEntity.fileSize;
    localDataLineMsgRecord.busId = 25;
    localDataLineMsgRecord.fileFrom = 4;
    localDataLineMsgRecord.nOpType = 35;
    localDataLineMsgRecord.istroop = 0;
    Object localObject = (acde)this.app.getBusinessHandler(8);
    localDataLineMsgRecord.sessionid = ((acde)localObject).a(0, 0).longValue();
    localDataLineMsgRecord.msg = "";
    localDataLineMsgRecord.issend = 1;
    localDataLineMsgRecord.isread = true;
    localDataLineMsgRecord.issuc = false;
    ((acle)this.app.getBusinessHandler(13)).W(localDataLineMsgRecord);
    localDataLineMsgRecord.time = anaz.gQ();
    localDataLineMsgRecord.progress = 0.2F;
    localDataLineMsgRecord.fileMsgStatus = 0L;
    localDataLineMsgRecord.msgtype = gu(0);
    localDataLineMsgRecord.bIsTransfering = true;
    localDataLineMsgRecord.bNoInsertFm = true;
    this.app.b().a(DataLineMsgRecord.getDevTypeBySeId(localDataLineMsgRecord.sessionid)).a(localDataLineMsgRecord, true);
    ((acde)localObject).e(7, true, new Object[] { Long.valueOf(0L), Long.valueOf(localDataLineMsgRecord.sessionid), localDataLineMsgRecord.path, Byte.valueOf((byte)gv(localDataLineMsgRecord.msgtype)), Boolean.valueOf(false), Boolean.valueOf(false), Long.valueOf(localDataLineMsgRecord.filesize) });
    localObject = new WeiYunFileInfo();
    ((WeiYunFileInfo)localObject).strFileName = paramFileManagerEntity.fileName;
    ((WeiYunFileInfo)localObject).nFileSize = paramFileManagerEntity.fileSize;
    ((WeiYunFileInfo)localObject).dirKey = paramFileManagerEntity.WeiYunDirKey;
    ((WeiYunFileInfo)localObject).bIk = paramFileManagerEntity.WeiYunFileId;
    ((WeiYunFileInfo)localObject).cYi = paramFileManagerEntity.nWeiYunSrcType;
    ((WeiYunFileInfo)localObject).md5 = paramFileManagerEntity.strFileMd5;
    ((WeiYunFileInfo)localObject).sha = paramFileManagerEntity.strFileSHA;
    localDataLineMsgRecord.strWeiyunId = ((WeiYunFileInfo)localObject).bIk;
    localDataLineMsgRecord.strWeiyunDir = ((WeiYunFileInfo)localObject).dirKey;
    localDataLineMsgRecord.nWeiyunSrcType = ((WeiYunFileInfo)localObject).cYi;
    localDataLineMsgRecord.strWeiyunMd5 = ((WeiYunFileInfo)localObject).md5;
    localDataLineMsgRecord.strWeiyunSha = ((WeiYunFileInfo)localObject).sha;
    a(localDataLineMsgRecord, (WeiYunFileInfo)localObject);
  }
  
  protected boolean e(int paramInt1, int paramInt2)
  {
    int i = AppSetting.getAppId();
    if ((paramInt1 == 1001) && (paramInt2 == i) && (QLog.isColorLevel())) {
      QLog.d("DataLineHandler", 2, "msgBody command from android" + paramInt2 + " " + i);
    }
    return false;
  }
  
  protected void ff()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DataLineHandler", 2, "--->>logout cancel all task");
    }
    IP(32);
  }
  
  protected void fn() {}
  
  protected void fo()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DataLineHandler", 2, "--->>wifi lost cancel all task");
    }
    IP(41);
  }
  
  public void g(int paramInt, long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DataLineHandler", 2, "manually cancel a file . session =" + paramLong);
    }
    if (paramLong == 0L)
    {
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.CancelGroup(paramInt, paramLong, 32, paramBoolean);
      return;
    }
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    DataLineMsgRecord localDataLineMsgRecord = getApp().b().a(i).a(paramLong);
    if (localDataLineMsgRecord == null)
    {
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.CancelGroup(paramInt, paramLong, 32, paramBoolean);
      return;
    }
    localDataLineMsgRecord.fileMsgStatus = 2L;
    localDataLineMsgRecord.bIsTransfering = false;
    this.app.b().a(i).ig(localDataLineMsgRecord.msgId);
    if (localDataLineMsgRecord.strMoloKey != null)
    {
      this.jdField_b_of_type_Cl.A(localDataLineMsgRecord.strMoloKey);
      return;
    }
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.CancelGroup(localDataLineMsgRecord.groupId, paramLong, 32, paramBoolean);
  }
  
  public final QQAppInterface getApp()
  {
    return this.app;
  }
  
  public boolean getAutoDownload()
  {
    return getApp().getPreferences().getBoolean("auto_receive_files", false);
  }
  
  public void h(DataLineMsgRecord paramDataLineMsgRecord)
  {
    if (paramDataLineMsgRecord == null)
    {
      QLog.e("DatalineHandler", 1, "reSendWeiYunFile entity=null");
      return;
    }
    if ((TextUtils.isEmpty(paramDataLineMsgRecord.strWeiyunId)) || (TextUtils.isEmpty(paramDataLineMsgRecord.filename)))
    {
      QLog.e("DatalineHandler", 1, "reSendWeiYunFile keyinfo=null");
      return;
    }
    WeiYunFileInfo localWeiYunFileInfo = new WeiYunFileInfo();
    localWeiYunFileInfo.strFileName = paramDataLineMsgRecord.filename;
    localWeiYunFileInfo.nFileSize = paramDataLineMsgRecord.filesize;
    localWeiYunFileInfo.dirKey = paramDataLineMsgRecord.strWeiyunDir;
    localWeiYunFileInfo.bIk = paramDataLineMsgRecord.strWeiyunId;
    localWeiYunFileInfo.cYi = paramDataLineMsgRecord.nWeiyunSrcType;
    localWeiYunFileInfo.md5 = paramDataLineMsgRecord.strWeiyunMd5;
    localWeiYunFileInfo.sha = paramDataLineMsgRecord.strWeiyunSha;
    paramDataLineMsgRecord.bNoInsertFm = true;
    a(paramDataLineMsgRecord, localWeiYunFileInfo);
  }
  
  public boolean ip(int paramInt)
  {
    if (paramInt == 0) {
      return this.bHg;
    }
    return this.bHh;
  }
  
  public boolean iq(int paramInt)
  {
    return this.xo.contains(Integer.valueOf(paramInt));
  }
  
  public boolean isInstalled(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return this.jdField_b_of_type_Cl.isInstalled(paramString);
  }
  
  public boolean j(long paramLong, int paramInt)
  {
    int i = DataLineMsgRecord.getDevTypeBySeId(paramLong);
    DataLineMsgRecord localDataLineMsgRecord = this.app.a(i).a(paramLong);
    DataLineMsgSet localDataLineMsgSet = this.app.a(i).a(paramInt);
    if ((localDataLineMsgSet != null) && (localDataLineMsgSet.isPaused()))
    {
      if (localDataLineMsgRecord != null)
      {
        localDataLineMsgRecord.issuc = true;
        localDataLineMsgRecord.fileMsgStatus = 2L;
        this.app.b().a(i).ig(localDataLineMsgRecord.msgId);
      }
      return true;
    }
    return false;
  }
  
  public void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i;
    if ((paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000))
    {
      i = paramToServiceMsg.extraData.getInt("DATALINE_TRYINDEX", -1);
      if (i >= 0) {}
    }
    do
    {
      do
      {
        return;
        if (i < 3)
        {
          paramToServiceMsg.extraData.putInt("DATALINE_TRYINDEX", i + 1);
          m(paramToServiceMsg);
          return;
        }
      } while ((paramFromServiceMsg == null) || (paramFromServiceMsg.getServiceCmd() == null));
      if (paramFromServiceMsg.getServiceCmd().equals("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V2-1600"))
      {
        b(paramToServiceMsg, paramFromServiceMsg, 1610);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700"))
      {
        b(paramToServiceMsg, paramFromServiceMsg, 1710);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_HIT_V2-1800"))
      {
        b(paramToServiceMsg, paramFromServiceMsg, 1810);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_DOWNLOAD-1200"))
      {
        b(paramToServiceMsg, paramFromServiceMsg, 1210);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_FILE_QUERY-1400"))
      {
        if (((Boolean)paramToServiceMsg.getAttribute("sendFromNative", Boolean.valueOf(true))).booleanValue())
        {
          b(paramToServiceMsg, paramFromServiceMsg, 1410);
          return;
        }
        c(paramToServiceMsg, paramFromServiceMsg, 1410);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100"))
      {
        b(paramToServiceMsg, paramFromServiceMsg, 60110);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("GTalkFileAppSvr.CMD_DISCUSS_FILE"))
      {
        l(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("DataLineHandler", 2, "<PbSendMsg><R><---handle0x346Rsp, unknown cmd:" + paramFromServiceMsg.getServiceCmd());
  }
  
  public void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = 0;
    MsgSCBody localMsgSCBody = new MsgSCBody();
    cmd0x345.RspBody localRspBody = new cmd0x345.RspBody();
    localMsgSCBody.uMsgType = 837;
    localMsgSCBody.bTimeOut = false;
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      localMsgSCBody.bTimeOut = true;
    }
    if (paramFromServiceMsg == null) {}
    label121:
    long l;
    label192:
    label199:
    int j;
    do
    {
      localMsgSCBody.msgBody0x345 = new MsgSCBody0x345();
      paramFromServiceMsg = localMsgSCBody.msgBody0x345;
      if (localRspBody.uint32_sub_cmd.has()) {
        i = localRspBody.uint32_sub_cmd.get();
      }
      paramFromServiceMsg.uMsgSubType = i;
      paramFromServiceMsg = localMsgSCBody.msgBody0x345;
      if (!localRspBody.uint32_return_code.has()) {
        break;
      }
      i = localRspBody.uint32_return_code.get();
      paramFromServiceMsg.uint32_return_code = i;
      switch (localMsgSCBody.msgBody0x345.uMsgSubType)
      {
      default: 
        if (QLog.isColorLevel()) {
          QLog.e("DataLineHandler", 2, "PBToMsgSCBody : msgtype is not cmd0x345[" + localMsgSCBody.msgBody0x345.uMsgSubType);
        }
        if (paramToServiceMsg != null) {
          break label373;
        }
        l = 0L;
        this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.OnPbMsgReply(Long.valueOf(l).intValue(), localMsgSCBody);
        return;
        if (paramFromServiceMsg.getWupBuffer() == null) {
          break label391;
        }
        j = paramFromServiceMsg.getWupBuffer().length - 4;
      }
    } while (j < 0);
    byte[] arrayOfByte = new byte[j];
    aqoj.copyData(arrayOfByte, 0, paramFromServiceMsg.getWupBuffer(), 4, j);
    label391:
    for (paramFromServiceMsg = arrayOfByte; paramFromServiceMsg != null; paramFromServiceMsg = null)
    {
      try
      {
        localRspBody.mergeFrom(paramFromServiceMsg);
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
      }
      break;
      i = -1;
      break label121;
      if (localRspBody.msg_subcmd_0x6_rsp_body.has()) {}
      for (paramFromServiceMsg = (cmd0x345.RspBody.SubCmd0x6RspBody)localRspBody.msg_subcmd_0x6_rsp_body.get();; paramFromServiceMsg = null)
      {
        if (paramFromServiceMsg == null) {
          break label371;
        }
        localMsgSCBody.msgBody0x345.subCmd0x6RspBody = new SubCmd0x6RspBody();
        localMsgSCBody.msgBody0x345.subCmd0x6RspBody.str_file_id = paramFromServiceMsg.str_file_id.get();
        localMsgSCBody.msgBody0x345.subCmd0x6RspBody.str_ret_msg = paramFromServiceMsg.str_ret_msg.get();
        break;
      }
      label371:
      break label192;
      label373:
      l = ((Long)paramToServiceMsg.getAttribute("cookie")).longValue();
      break label199;
    }
  }
  
  protected boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("MessageSvc.PbSendMsg");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  protected Class<? extends acci> observerClass()
  {
    return acdl.class;
  }
  
  public void onDestroy()
  {
    boolean bool2 = false;
    if ((this.app != null) && (this.app.getApp() != null) && (this.aX != null)) {}
    try
    {
      this.app.getApp().unregisterReceiver(this.aX);
      this.aX = null;
      if ((this.app == null) || (this.app.getApp() == null) || (this.aW == null)) {}
    }
    catch (Exception localException1)
    {
      try
      {
        this.app.getApp().unregisterReceiver(this.aW);
        this.aW = null;
        if ((this.app != null) && (this.app.getApp() != null) && (this.jdField_a_of_type_Achq != null))
        {
          this.app.removeObserver(this.jdField_a_of_type_Achq);
          this.jdField_a_of_type_Achq = null;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler != null)
        {
          AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
          this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = null;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DataLineHandler", 2, "--->>close cancel all task");
        }
        IP(32);
        boolean bool1 = bool2;
        Object localObject;
        if (this.app != null)
        {
          bool1 = bool2;
          if (this.app.a(0) != null)
          {
            localObject = this.app.a(0).a();
            bool1 = bool2;
            if (localObject != null)
            {
              bool1 = bool2;
              if (((DataLineMsgSetList)localObject).size() > 0)
              {
                localObject = ((DataLineMsgSetList)localObject).iterator();
                do
                {
                  bool1 = bool2;
                  if (!((Iterator)localObject).hasNext()) {
                    break;
                  }
                } while (!((DataLineMsgSet)((Iterator)localObject).next()).hasSendingOrRecving());
                bool1 = true;
              }
            }
          }
        }
        bool2 = bool1;
        if (this.app != null)
        {
          bool2 = bool1;
          if (this.app.a(1) != null)
          {
            localObject = this.app.a(1).a();
            bool2 = bool1;
            if (localObject != null)
            {
              bool2 = bool1;
              if (((DataLineMsgSetList)localObject).size() > 0)
              {
                localObject = ((DataLineMsgSetList)localObject).iterator();
                do
                {
                  bool2 = bool1;
                  if (!((Iterator)localObject).hasNext()) {
                    break;
                  }
                } while (!((DataLineMsgSet)((Iterator)localObject).next()).hasSendingOrRecving());
                bool2 = true;
              }
            }
          }
        }
        this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.endLiteTransfer(bool2);
        this.jdField_a_of_type_Aviq.eAn();
        this.jdField_b_of_type_Cl.cg();
        this.jdField_a_of_type_Acio.cg();
        this.jdField_b_of_type_Ci.onDestroy();
        if (this.A != null)
        {
          this.A.cancel();
          this.A = null;
        }
        this.bHi = true;
        return;
        localException1 = localException1;
        QLog.e("DataLineHandler", 1, "onDestroy fail unregisterReceiver exitReceiver:" + localException1);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          QLog.e("DataLineHandler", 1, "onDestroy fail unregisterReceiver sdCardReceiver:" + localException2);
        }
      }
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    this.jdField_a_of_type_Aviq.a(paramToServiceMsg, paramFromServiceMsg, (byte[])paramObject);
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, "cmdfilter error=" + paramFromServiceMsg.getServiceCmd());
      }
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new DataLineHandler.5(this, paramToServiceMsg, paramFromServiceMsg, paramObject));
      return;
    }
    cW(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public int open(String paramString)
  {
    if (paramString == null) {
      return 1;
    }
    return this.jdField_b_of_type_Cl.open(paramString);
  }
  
  protected boolean q(int paramInt1, int paramInt2)
  {
    int i = AppSetting.getAppId();
    if ((paramInt1 == 1001) && ((paramInt2 == i) || (paramInt2 == 0))) {}
    while (!QLog.isColorLevel()) {
      return true;
    }
    QLog.d("DataLineHandler", 2, "msgBody command not for android" + paramInt2 + " " + i);
    return true;
  }
  
  public void report(int paramInt)
  {
    this.jdField_b_of_type_Cl.report(paramInt);
  }
  
  public void z(ArrayList<DataLineMsgRecord> paramArrayList, boolean paramBoolean)
  {
    a(paramArrayList, paramBoolean, null, null, Long.valueOf(this.app.getCurrentAccountUin()).longValue());
  }
  
  public boolean z(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return this.jdField_b_of_type_Cl.z(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acde
 * JD-Core Version:    0.7.0.1
 */