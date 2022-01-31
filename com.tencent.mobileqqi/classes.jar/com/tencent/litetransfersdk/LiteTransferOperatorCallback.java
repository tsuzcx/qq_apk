package com.tencent.litetransfersdk;

import QQService.FileDownloadResp;
import QQService.FileUploadResp;
import android.os.Bundle;
import bwr;
import com.dataline.util.DatalineMathUtil;
import com.dataline.util.QualityReportUtil;
import com.dataline.util.file.FileUtil;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Timer;

public class LiteTransferOperatorCallback
{
  public static final String sTagName = "LiteTransferOperatorCallback.Main";
  public static final long uMinSize_for_CreateThumb = 51200L;
  private DataLineHandler mHandler;
  
  public LiteTransferOperatorCallback(DataLineHandler paramDataLineHandler)
  {
    this.mHandler = paramDataLineHandler;
  }
  
  private void _handleCSMsg0x211(int paramInt, MsgCSBody0x211 paramMsgCSBody0x211)
  {
    switch (paramMsgCSBody0x211.uMsgSubType)
    {
    default: 
      QLog.d("LiteTransferOperatorCallback.Main", 1, "SendPbMsg: cannot recognize the pb msg form 0X211");
      return;
    }
    _handleCSMsg0x211_0x7(paramInt, paramMsgCSBody0x211.msgBody0x211_0x7);
  }
  
  private void _handleCSMsg0x211_0x7(int paramInt, MsgCSBody0x211_0x7 paramMsgCSBody0x211_0x7)
  {
    int k = 0;
    int m = 0;
    int n = 0;
    int j = 0;
    Object localObject = (RegisterProxySvcPackHandler)this.mHandler.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(9);
    if (localObject != null) {}
    for (int i = ((RegisterProxySvcPackHandler)localObject).a();; i = 1)
    {
      switch (paramMsgCSBody0x211_0x7.uMsgSubCmd)
      {
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      default: 
        QLog.d("LiteTransferOperatorCallback.Main", 1, "SendPbMsg: cannot recognize the pb msg form 0X211_0x7");
      case 1: 
      case 2: 
      case 3: 
      case 9: 
        do
        {
          for (;;)
          {
            return;
            i = 0;
            while (i < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x1_FTNNotifySrc.length)
            {
              _sendFTNNotify(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x1_FTNNotifySrc[i]);
              i += 1;
            }
            continue;
            while (j < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x2_NFCNotifySrc.length)
            {
              _sendNFCNotify(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x2_NFCNotifySrc[j]);
              j += 1;
            }
            continue;
            while (k < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x3_FileControl.length)
            {
              _sendFileControl(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x3_FileControl[k]);
              k += 1;
            }
          }
        } while (m >= paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x9_FTNNotifyThumb.length);
        if (i == 0)
        {
          localObject = new MsgSCBody();
          ((MsgSCBody)localObject).uMsgType = 529;
          ((MsgSCBody)localObject).msgBody0x211 = new MsgSCBody0x211();
          ((MsgSCBody)localObject).msgBody0x211.uMsgSubType = 7;
          ((MsgSCBody)localObject).msgBody0x211.msgBody0x211_0x7 = new MsgSCBody0x211_0x7();
          ((MsgSCBody)localObject).bTimeOut = true;
          ((MsgSCBody)localObject).msgBody0x211.msgBody0x211_0x7.uResult = 1;
          this.mHandler.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.doPbMsgReply(paramInt, (MsgSCBody)localObject);
        }
        for (;;)
        {
          m += 1;
          break;
          paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x9_FTNNotifyThumb[m].bytes_originfile_md5 = null;
          _sendFTNNotify(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x9_FTNNotifyThumb[m]);
        }
      }
      label334:
      if (n < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0xa_NFCNotifyThumb.length)
      {
        if (i != 0) {
          break label442;
        }
        localObject = new MsgSCBody();
        ((MsgSCBody)localObject).uMsgType = 529;
        ((MsgSCBody)localObject).msgBody0x211 = new MsgSCBody0x211();
        ((MsgSCBody)localObject).msgBody0x211.uMsgSubType = 7;
        ((MsgSCBody)localObject).msgBody0x211.msgBody0x211_0x7 = new MsgSCBody0x211_0x7();
        ((MsgSCBody)localObject).bTimeOut = true;
        ((MsgSCBody)localObject).msgBody0x211.msgBody0x211_0x7.uResult = 1;
        this.mHandler.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.doPbMsgReply(paramInt, (MsgSCBody)localObject);
      }
      for (;;)
      {
        n += 1;
        break label334;
        break;
        label442:
        paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0xa_NFCNotifyThumb[n].bytes_originfile_md5 = null;
        _sendNFCNotify(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0xa_NFCNotifyThumb[n]);
      }
    }
  }
  
  private void _handleCSMsg0x346(int paramInt, MsgCSBody0x346 paramMsgCSBody0x346)
  {
    QLog.d("LiteTransferOperatorCallback.Main", 1, "SendPbMsg: _handleCSMsg0x346");
    switch (paramMsgCSBody0x346.uMsgSubType)
    {
    default: 
      QLog.d("LiteTransferOperatorCallback.Main", 1, "SendPbMsg: cannot recognize the pb msg form 0X346");
      return;
    case 7: 
      _handleMsgBody0x346_0x7(paramInt, paramMsgCSBody0x346.pMsgBody0x346_0x7);
      return;
    }
    _handleMsgBody0x346_0xe(paramInt, paramMsgCSBody0x346.pMsgBody0x346_0xe);
  }
  
  private void _handleMsgBody0x346_0x7(int paramInt, ApplyUploadReq paramApplyUploadReq)
  {
    QLog.d("LiteTransferOperatorCallback.Main", 1, "_handleMsgBody0x346_0x7s");
    ToServiceMsg localToServiceMsg = this.mHandler.b("TransService.FileUploadReq");
    localToServiceMsg.addAttribute("cookie", Integer.valueOf(paramInt));
    localToServiceMsg.extraData.putLong("CMD_PARAM_UPLOAD_FROM_UIN", paramApplyUploadReq.uint64_sender_uin);
    localToServiceMsg.extraData.putLong("CMD_PARAM_UPLOAD_TO_UIN", paramApplyUploadReq.uint64_recver_uin);
    localToServiceMsg.extraData.putByte("CMD_PARAM_UPLOAD_TYPE", (byte)1);
    localToServiceMsg.extraData.putLong("CMD_PARAM_UPLOAD_FILE_SIZE", paramApplyUploadReq.uint64_file_size);
    localToServiceMsg.extraData.putByte("CMD_PARAM_UPLOAD_VER", (byte)10);
    byte[] arrayOfByte = new byte[2];
    localToServiceMsg.extraData.putByteArray("CMD_PARAM_UPLOAD_DATA", arrayOfByte);
    localToServiceMsg.extraData.putString("CMD_PARAM_UPLOAD_FILE_NAME", paramApplyUploadReq.str_file_name);
    localToServiceMsg.extraData.putByteArray("CMD_PARAM_UPLOAD_FILE_MD5", paramApplyUploadReq.bytes_10m_md5);
    this.mHandler.c(localToServiceMsg);
  }
  
  private void _handleMsgBody0x346_0xe(int paramInt, ApplyDownloadReq paramApplyDownloadReq)
  {
    QLog.d("LiteTransferOperatorCallback.Main", 1, "_handleMsgBody0x346_0xe");
    ToServiceMsg localToServiceMsg = this.mHandler.b("TransService.FileDownloadReq");
    localToServiceMsg.addAttribute("cookie", Integer.valueOf(paramInt));
    localToServiceMsg.extraData.putLong("CMD_PARAM_DOWNLOAD_LFROMUIN", paramApplyDownloadReq.uint64_uin);
    localToServiceMsg.extraData.putLong("CMD_PARAM_DOWNLOAD_LTOUIN", paramApplyDownloadReq.uint64_uin);
    localToServiceMsg.extraData.putByte("CMD_PARAM_DOWNLOAD_CTYPE", (byte)1);
    localToServiceMsg.extraData.putString("CMD_PARAM_DOWNLOAD_FILEPATH", paramApplyDownloadReq.bytes_uuid);
    this.mHandler.c(localToServiceMsg);
  }
  
  private void _sendFTNNotify(int paramInt, FTNNotify paramFTNNotify)
  {
    QLog.d("LiteTransferOperatorCallback.Main", 1, "_notifyFTNNotify");
    this.mHandler.a(paramInt, paramFTNNotify.uint64_sessionid, 1004, paramFTNNotify.str_file_name, paramFTNNotify.str_file_index, paramFTNNotify.bytes_file_md5, paramFTNNotify.uint64_file_len, paramFTNNotify.bytes_originfile_md5, paramFTNNotify.uint32_originfiletype, paramFTNNotify.uint32_group_id, paramFTNNotify.uint32_group_size, paramFTNNotify.uint32_group_curindex, paramFTNNotify.uint32_batchID, paramFTNNotify.uint32_groupflag);
  }
  
  private void _sendFileControl(int paramInt, FileControl paramFileControl)
  {
    QLog.d("LiteTransferOperatorCallback.Main", 1, "_notifyFileControl");
    if (!NetworkUtil.e(BaseApplication.getContext())) {
      return;
    }
    new Timer().schedule(new bwr(this, paramInt, paramFileControl), 10L);
  }
  
  private void _sendNFCNotify(int paramInt, NFCNotify paramNFCNotify)
  {
    QLog.d("LiteTransferOperatorCallback.Main", 1, "_notifyNFCNotify");
    DataLineHandler localDataLineHandler = this.mHandler;
    long l1 = paramInt;
    long l2 = paramNFCNotify.uint64_sessionid;
    if (paramNFCNotify.bytes_originfile_md5 == null) {}
    for (boolean bool = true;; bool = false)
    {
      localDataLineHandler.a(l1, l2, 1003, bool, paramNFCNotify.str_file_name, paramNFCNotify.uint64_file_len, paramNFCNotify.bytes_file_md5, paramNFCNotify.bytes_originfile_md5, paramNFCNotify.fixed32_ip, paramNFCNotify.uint32_port, paramNFCNotify.bytes_url_notify, paramNFCNotify.uint32_originfiletype, paramNFCNotify.uint32_group_id, paramNFCNotify.uint32_group_size, paramNFCNotify.uint32_group_curindex, paramNFCNotify.uint32_batchID, paramNFCNotify.uint32_groupflag);
      return;
    }
  }
  
  public void GetThumbFilePath(int paramInt, Session paramSession)
  {
    Object localObject = (RegisterProxySvcPackHandler)this.mHandler.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(9);
    if ((localObject != null) && (((RegisterProxySvcPackHandler)localObject).a() == 0)) {}
    File localFile;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramSession.uFileSizeSrc < 51200L);
        localObject = FileUtil.c(BaseApplication.getContext(), paramSession.strFilePathSrc);
      } while (localObject == null);
      localFile = new File((String)localObject);
    } while ((localFile == null) || (!localFile.exists()));
    if (localFile.length() + 51200L < paramSession.uFileSizeSrc)
    {
      this.mHandler.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.DoGetThumbFilePathReply(paramInt, (String)localObject);
      return;
    }
    localFile.delete();
  }
  
  public void InvokeReport(ReportItem paramReportItem)
  {
    QualityReportUtil.a(this.mHandler.a(), paramReportItem);
  }
  
  public void SendPbMsg(int paramInt, MsgCSBody paramMsgCSBody)
  {
    QLog.d("LiteTransferOperatorCallback.Main", 1, "SendPbMsg: msgBody.uMsgType " + paramMsgCSBody.uMsgType);
    switch (paramMsgCSBody.uMsgType)
    {
    default: 
      QLog.d("LiteTransferOperatorCallback.Main", 1, "SendPbMsg: cannot recognize the pb msg form JNI");
      return;
    case 529: 
      _handleCSMsg0x211(paramInt, paramMsgCSBody.msgBody0x211);
      return;
    }
    _handleCSMsg0x346(paramInt, paramMsgCSBody.msgBody0x346);
  }
  
  public MsgSCBody handleMsgBody0x346_0x7_Rsp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    QLog.d("LiteTransferOperatorCallback.Main", 1, "handleMsgBody0x346_0x7_Rsp");
    paramToServiceMsg = new MsgSCBody();
    paramToServiceMsg.uMsgType = 838;
    paramToServiceMsg.msgBody0x346 = new MsgSCBody0x346();
    paramToServiceMsg.msgBody0x346.uMsgSubType = 7;
    paramToServiceMsg.msgBody0x346.pMsgBody0x346_0x7 = new ApplyUploadRsp();
    FileUploadResp localFileUploadResp = (FileUploadResp)paramObject;
    if ((paramFromServiceMsg == null) || (paramObject == null))
    {
      QLog.d("LiteTransferOperatorCallback.Main", 1, "handleMsgBody0x346_0x7_Rsp: respone param is null .");
      paramToServiceMsg.bTimeOut = true;
      return paramToServiceMsg;
    }
    paramToServiceMsg.bTimeOut = false;
    paramToServiceMsg.msgBody0x346.pMsgBody0x346_0x7.int32_ret_code = localFileUploadResp.nRetCode;
    paramToServiceMsg.msgBody0x346.pMsgBody0x346_0x7.str_ret_msg = localFileUploadResp.strRetMessage;
    paramToServiceMsg.msgBody0x346.pMsgBody0x346_0x7.bytes_uuid = localFileUploadResp.strFilePath;
    paramToServiceMsg.msgBody0x346.pMsgBody0x346_0x7.bool_file_exist = localFileUploadResp.isFileExist;
    paramToServiceMsg.msgBody0x346.pMsgBody0x346_0x7.bytes_upload_key = localFileUploadResp.vFileKey;
    paramToServiceMsg.msgBody0x346.pMsgBody0x346_0x7.uint32_pack_size = localFileUploadResp.nPackSize;
    paramToServiceMsg.msgBody0x346.pMsgBody0x346_0x7.uint32_upload_port = localFileUploadResp.shUploadPort;
    paramToServiceMsg.msgBody0x346.pMsgBody0x346_0x7.str_upload_ip = DatalineMathUtil.a(localFileUploadResp.uUploadIP);
    QLog.d("LiteTransferOperatorCallback.Main", 1, "handleMsgBody0x346_0x7_Rsp len " + localFileUploadResp.vFileKey.length + " copylen " + localFileUploadResp.vFileKey.length);
    return paramToServiceMsg;
  }
  
  public MsgSCBody handleMsgBody0x346_0xe_Rsp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    QLog.d("LiteTransferOperatorCallback.Main", 1, "_handleMsgBody0x346_0xe_Rsp");
    paramToServiceMsg = new MsgSCBody();
    paramToServiceMsg.uMsgType = 838;
    paramToServiceMsg.msgBody0x346 = new MsgSCBody0x346();
    paramToServiceMsg.msgBody0x346.uMsgSubType = 14;
    paramToServiceMsg.msgBody0x346.pMsgBody0x346_0xe = new ApplyDownloadRsp();
    FileDownloadResp localFileDownloadResp = (FileDownloadResp)paramObject;
    if ((paramFromServiceMsg == null) || (paramObject == null))
    {
      QLog.d("LiteTransferOperatorCallback.Main", 1, "handleMsgBody0x346_0xe_Rsp: respone param is null .");
      paramToServiceMsg.bTimeOut = true;
    }
    for (;;)
    {
      if (localFileDownloadResp != null) {
        QLog.d("LiteTransferOperatorCallback.Main", 1, "download ip " + localFileDownloadResp.uDownloadIP + " port " + localFileDownloadResp.shDownloadPort + " key length " + localFileDownloadResp.vDownloadURL.length);
      }
      return paramToServiceMsg;
      paramToServiceMsg.bTimeOut = false;
      paramToServiceMsg.msgBody0x346.pMsgBody0x346_0xe.int32_ret_code = localFileDownloadResp.nRetCode;
      paramToServiceMsg.msgBody0x346.pMsgBody0x346_0xe.str_ret_msg = localFileDownloadResp.strRetMessage;
      paramToServiceMsg.msgBody0x346.pMsgBody0x346_0xe.msg_download_info = new DownloadInfo();
      paramToServiceMsg.msgBody0x346.pMsgBody0x346_0xe.msg_download_info.str_download_ip = DatalineMathUtil.a(localFileDownloadResp.uDownloadIP);
      paramToServiceMsg.msgBody0x346.pMsgBody0x346_0xe.msg_download_info.uint32_port = localFileDownloadResp.shDownloadPort;
      paramToServiceMsg.msgBody0x346.pMsgBody0x346_0xe.msg_download_info.bytes_download_key = localFileDownloadResp.vDownloadURL;
      paramToServiceMsg.msgBody0x346.pMsgBody0x346_0xe.msg_file_info = new FileInfo();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.litetransfersdk.LiteTransferOperatorCallback
 * JD-Core Version:    0.7.0.1
 */