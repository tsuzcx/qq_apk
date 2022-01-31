package com.tencent.litetransfersdk;

import com.dataline.util.QualityReportUtil;
import com.dataline.util.file.FileUtil;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import java.util.Timer;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadHitRspV2;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRspV2;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRspV3;
import tencent.im.cs.cmd0x346.cmd0x346.DownloadInfo;
import tencent.im.cs.cmd0x346.cmd0x346.FileInfo;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;
import ub;

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
    QLog.d("LiteTransferOperatorCallback.Main", 1, "SendPbMsg: _handleCSMsg0x346, msg subtype:" + paramMsgCSBody0x346.uMsgSubType);
    this.mHandler.a(paramInt, paramMsgCSBody0x346);
  }
  
  private void _sendFTNNotify(int paramInt, FTNNotify paramFTNNotify)
  {
    QLog.d("LiteTransferOperatorCallback.Main", 1, "_notifyFTNNotify");
    this.mHandler.a(paramInt, paramFTNNotify.uint64_sessionid, 1004, paramFTNNotify.str_file_name, paramFTNNotify.str_file_index, paramFTNNotify.bytes_file_md5, paramFTNNotify.uint64_file_len, paramFTNNotify.bytes_originfile_md5, paramFTNNotify.uint32_originfiletype, paramFTNNotify.uint32_group_id, paramFTNNotify.uint32_group_size, paramFTNNotify.uint32_group_curindex, paramFTNNotify.uint32_batchID, paramFTNNotify.uint32_groupflag, paramFTNNotify.msg_ActionInfo);
  }
  
  private void _sendFileControl(int paramInt, FileControl paramFileControl)
  {
    QLog.d("LiteTransferOperatorCallback.Main", 1, "_notifyFileControl");
    if (!NetworkUtil.e(BaseApplication.getContext())) {
      return;
    }
    new Timer().schedule(new ub(this, paramInt, paramFileControl), 10L);
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
      localDataLineHandler.a(l1, l2, 1003, bool, paramNFCNotify.str_file_name, paramNFCNotify.uint64_file_len, paramNFCNotify.bytes_file_md5, paramNFCNotify.bytes_originfile_md5, paramNFCNotify.fixed32_ip, paramNFCNotify.uint32_port, paramNFCNotify.bytes_url_notify, paramNFCNotify.uint32_originfiletype, paramNFCNotify.uint32_group_id, paramNFCNotify.uint32_group_size, paramNFCNotify.uint32_group_curindex, paramNFCNotify.uint32_batchID, paramNFCNotify.uint32_groupflag, paramNFCNotify.msg_ActionInfo);
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
  
  public MsgSCBody convert2MsgScBody(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt)
  {
    MsgSCBody localMsgSCBody = new MsgSCBody();
    localMsgSCBody.uMsgType = 838;
    if (paramFromServiceMsg == null)
    {
      localMsgSCBody.bTimeOut = true;
      return localMsgSCBody;
    }
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      localMsgSCBody.bTimeOut = true;
      return localMsgSCBody;
    }
    paramToServiceMsg = null;
    if (paramFromServiceMsg.getWupBuffer() != null)
    {
      int i = paramFromServiceMsg.getWupBuffer().length - 4;
      if (i < 0)
      {
        localMsgSCBody.bTimeOut = true;
        return localMsgSCBody;
      }
      paramToServiceMsg = new byte[i];
      PkgTools.a(paramToServiceMsg, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
    }
    paramFromServiceMsg = new cmd0x346.RspBody();
    for (;;)
    {
      try
      {
        paramFromServiceMsg.mergeFrom(paramToServiceMsg);
        paramToServiceMsg = new MsgSCBody0x346();
        paramToServiceMsg.uMsgSubType = paramInt;
        switch (paramInt)
        {
        default: 
          QLog.d("LiteTransferOperatorCallback.Main", 1, "convert2MsgScBody, unknown cmd:" + paramInt);
          localMsgSCBody.msgBody0x346 = paramToServiceMsg;
          return localMsgSCBody;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        return localMsgSCBody;
      }
      paramToServiceMsg.pMsgBody0x346_uploadRsp = new ApplyUploadRsp();
      paramToServiceMsg.pMsgBody0x346_uploadRsp.int32_ret_code = paramFromServiceMsg.msg_apply_upload_rsp_v2.int32_ret_code.get();
      paramToServiceMsg.pMsgBody0x346_uploadRsp.str_ret_msg = paramFromServiceMsg.msg_apply_upload_rsp_v2.str_ret_msg.get();
      paramToServiceMsg.pMsgBody0x346_uploadRsp.uint64_total_space = paramFromServiceMsg.msg_apply_upload_rsp_v2.uint64_total_space.get();
      paramToServiceMsg.pMsgBody0x346_uploadRsp.uint64_used_space = paramFromServiceMsg.msg_apply_upload_rsp_v2.uint64_used_space.get();
      paramToServiceMsg.pMsgBody0x346_uploadRsp.uint64_uploaded_size = paramFromServiceMsg.msg_apply_upload_rsp_v2.uint64_uploaded_size.get();
      paramToServiceMsg.pMsgBody0x346_uploadRsp.str_upload_ip = paramFromServiceMsg.msg_apply_upload_rsp_v2.str_upload_ip.get();
      paramToServiceMsg.pMsgBody0x346_uploadRsp.str_upload_domain = paramFromServiceMsg.msg_apply_upload_rsp_v2.str_upload_domain.get();
      paramToServiceMsg.pMsgBody0x346_uploadRsp.uint32_upload_port = paramFromServiceMsg.msg_apply_upload_rsp_v2.uint32_upload_port.get();
      paramToServiceMsg.pMsgBody0x346_uploadRsp.bytes_uuid = paramFromServiceMsg.msg_apply_upload_rsp_v2.bytes_uuid.get().toStringUtf8();
      paramToServiceMsg.pMsgBody0x346_uploadRsp.bytes_upload_key = paramFromServiceMsg.msg_apply_upload_rsp_v2.bytes_upload_key.get().toByteArray();
      paramToServiceMsg.pMsgBody0x346_uploadRsp.bool_file_exist = paramFromServiceMsg.msg_apply_upload_rsp_v2.bool_file_exist.get();
      paramToServiceMsg.pMsgBody0x346_uploadRsp.uint32_pack_size = paramFromServiceMsg.msg_apply_upload_rsp_v2.uint32_pack_size.get();
      List localList = paramFromServiceMsg.msg_apply_upload_rsp_v2.rpt_str_uploadip_list.get();
      paramToServiceMsg.pMsgBody0x346_uploadRsp.rpt_str_uploadip_list = ((String[])localList.toArray(new String[localList.size()]));
      paramToServiceMsg.pMsgBody0x346_uploadRsp.uint32_httpsvr_api_ver = paramFromServiceMsg.msg_apply_upload_rsp_v2.uint32_httpsvr_api_ver.get();
      paramToServiceMsg.pMsgBody0x346_uploadRsp.bytes_sha = paramFromServiceMsg.msg_apply_upload_rsp_v2.bytes_sha.get().toByteArray();
      continue;
      paramToServiceMsg.pMsgBody0x346_uploadRsp = new ApplyUploadRsp();
      paramToServiceMsg.pMsgBody0x346_uploadRsp.int32_ret_code = paramFromServiceMsg.msg_apply_upload_rsp_v3.int32_ret_code.get();
      paramToServiceMsg.pMsgBody0x346_uploadRsp.str_ret_msg = paramFromServiceMsg.msg_apply_upload_rsp_v3.str_ret_msg.get();
      paramToServiceMsg.pMsgBody0x346_uploadRsp.uint64_total_space = paramFromServiceMsg.msg_apply_upload_rsp_v3.uint64_total_space.get();
      paramToServiceMsg.pMsgBody0x346_uploadRsp.uint64_used_space = paramFromServiceMsg.msg_apply_upload_rsp_v3.uint64_used_space.get();
      paramToServiceMsg.pMsgBody0x346_uploadRsp.uint64_uploaded_size = paramFromServiceMsg.msg_apply_upload_rsp_v3.uint64_uploaded_size.get();
      paramToServiceMsg.pMsgBody0x346_uploadRsp.str_upload_ip = paramFromServiceMsg.msg_apply_upload_rsp_v3.str_upload_ip.get();
      paramToServiceMsg.pMsgBody0x346_uploadRsp.str_upload_domain = paramFromServiceMsg.msg_apply_upload_rsp_v3.str_upload_domain.get();
      paramToServiceMsg.pMsgBody0x346_uploadRsp.uint32_upload_port = paramFromServiceMsg.msg_apply_upload_rsp_v3.uint32_upload_port.get();
      paramToServiceMsg.pMsgBody0x346_uploadRsp.bytes_uuid = paramFromServiceMsg.msg_apply_upload_rsp_v3.bytes_uuid.get().toStringUtf8();
      paramToServiceMsg.pMsgBody0x346_uploadRsp.bytes_upload_key = paramFromServiceMsg.msg_apply_upload_rsp_v3.bytes_upload_key.get().toByteArray();
      paramToServiceMsg.pMsgBody0x346_uploadRsp.bool_file_exist = paramFromServiceMsg.msg_apply_upload_rsp_v3.bool_file_exist.get();
      paramToServiceMsg.pMsgBody0x346_uploadRsp.uint32_pack_size = paramFromServiceMsg.msg_apply_upload_rsp_v3.uint32_pack_size.get();
      paramFromServiceMsg = paramFromServiceMsg.msg_apply_upload_rsp_v3.rpt_str_uploadip_list.get();
      paramToServiceMsg.pMsgBody0x346_uploadRsp.rpt_str_uploadip_list = ((String[])paramFromServiceMsg.toArray(new String[paramFromServiceMsg.size()]));
      continue;
      paramToServiceMsg.pMsgBody0x346_1810 = new ApplyUploadHitRsp();
      paramToServiceMsg.pMsgBody0x346_1810.int32_ret_code = paramFromServiceMsg.msg_apply_upload_hit_rsp_v2.int32_ret_code.get();
      paramToServiceMsg.pMsgBody0x346_1810.str_ret_msg = paramFromServiceMsg.msg_apply_upload_hit_rsp_v2.str_ret_msg.get();
      paramToServiceMsg.pMsgBody0x346_1810.str_upload_ip = paramFromServiceMsg.msg_apply_upload_hit_rsp_v2.str_upload_ip.get();
      paramToServiceMsg.pMsgBody0x346_1810.str_upload_domain = paramFromServiceMsg.msg_apply_upload_hit_rsp_v2.str_upload_domain.get();
      paramToServiceMsg.pMsgBody0x346_1810.bytes_uuid = paramFromServiceMsg.msg_apply_upload_hit_rsp_v2.bytes_uuid.get().toByteArray();
      paramToServiceMsg.pMsgBody0x346_1810.bytes_upload_key = paramFromServiceMsg.msg_apply_upload_hit_rsp_v2.bytes_upload_key.get().toByteArray();
      paramToServiceMsg.pMsgBody0x346_1810.uint64_total_space = paramFromServiceMsg.msg_apply_upload_hit_rsp_v2.uint64_total_space.get();
      paramToServiceMsg.pMsgBody0x346_1810.uint64_used_space = paramFromServiceMsg.msg_apply_upload_hit_rsp_v2.uint64_used_space.get();
      continue;
      paramToServiceMsg.pMsgBody0x346_1210 = new ApplyDownloadRsp();
      paramToServiceMsg.pMsgBody0x346_1210.int32_ret_code = paramFromServiceMsg.msg_apply_download_rsp.int32_ret_code.get();
      paramToServiceMsg.pMsgBody0x346_1210.str_ret_msg = paramFromServiceMsg.msg_apply_download_rsp.str_ret_msg.get();
      paramToServiceMsg.pMsgBody0x346_1210.msg_download_info = new DownloadInfo();
      paramToServiceMsg.pMsgBody0x346_1210.msg_download_info.bytes_download_key = paramFromServiceMsg.msg_apply_download_rsp.msg_download_info.bytes_download_key.get().toByteArray();
      paramToServiceMsg.pMsgBody0x346_1210.msg_download_info.str_download_ip = paramFromServiceMsg.msg_apply_download_rsp.msg_download_info.str_download_ip.get();
      paramToServiceMsg.pMsgBody0x346_1210.msg_download_info.str_download_domain = paramFromServiceMsg.msg_apply_download_rsp.msg_download_info.str_download_domain.get();
      paramToServiceMsg.pMsgBody0x346_1210.msg_download_info.uint32_port = paramFromServiceMsg.msg_apply_download_rsp.msg_download_info.uint32_port.get();
      paramToServiceMsg.pMsgBody0x346_1210.msg_download_info.str_download_url = paramFromServiceMsg.msg_apply_download_rsp.msg_download_info.str_download_url.get();
      localList = paramFromServiceMsg.msg_apply_download_rsp.msg_download_info.rpt_str_downloadip_list.get();
      paramToServiceMsg.pMsgBody0x346_1210.msg_download_info.rpt_str_downloadip_list = ((String[])localList.toArray(new String[localList.size()]));
      paramToServiceMsg.pMsgBody0x346_1210.msg_download_info.str_cookie = paramFromServiceMsg.msg_apply_download_rsp.msg_download_info.str_cookie.get();
      paramToServiceMsg.pMsgBody0x346_1210.msg_file_info = new FileInfo();
      paramToServiceMsg.pMsgBody0x346_1210.msg_file_info.uint64_uin = paramFromServiceMsg.msg_apply_download_rsp.msg_file_info.uint64_uin.get();
      paramToServiceMsg.pMsgBody0x346_1210.msg_file_info.uint32_danger_evel = paramFromServiceMsg.msg_apply_download_rsp.msg_file_info.uint32_danger_evel.get();
      paramToServiceMsg.pMsgBody0x346_1210.msg_file_info.uint64_file_size = paramFromServiceMsg.msg_apply_download_rsp.msg_file_info.uint64_file_size.get();
      paramToServiceMsg.pMsgBody0x346_1210.msg_file_info.uint32_life_time = paramFromServiceMsg.msg_apply_download_rsp.msg_file_info.uint32_life_time.get();
      paramToServiceMsg.pMsgBody0x346_1210.msg_file_info.uint32_upload_time = paramFromServiceMsg.msg_apply_download_rsp.msg_file_info.uint32_upload_time.get();
      paramToServiceMsg.pMsgBody0x346_1210.msg_file_info.bytes_uuid = paramFromServiceMsg.msg_apply_download_rsp.msg_file_info.bytes_uuid.get().toByteArray();
      paramToServiceMsg.pMsgBody0x346_1210.msg_file_info.str_file_name = paramFromServiceMsg.msg_apply_download_rsp.msg_file_info.str_file_name.get();
      paramToServiceMsg.pMsgBody0x346_1210.msg_file_info.uint32_abs_file_type = paramFromServiceMsg.msg_apply_download_rsp.msg_file_info.uint32_abs_file_type.get();
      paramToServiceMsg.pMsgBody0x346_1210.msg_file_info.bytes_10m_md5 = paramFromServiceMsg.msg_apply_download_rsp.msg_file_info.bytes_10m_md5.get().toByteArray();
      paramToServiceMsg.pMsgBody0x346_1210.msg_file_info.uint32_client_type = paramFromServiceMsg.msg_apply_download_rsp.msg_file_info.uint32_client_type.get();
      paramToServiceMsg.pMsgBody0x346_1210.msg_file_info.uint64_owner_uin = paramFromServiceMsg.msg_apply_download_rsp.msg_file_info.uint64_owner_uin.get();
      paramToServiceMsg.pMsgBody0x346_1210.msg_file_info.uint64_peer_uin = paramFromServiceMsg.msg_apply_download_rsp.msg_file_info.uint64_peer_uin.get();
      paramToServiceMsg.pMsgBody0x346_1210.msg_file_info.uint32_expire_time = paramFromServiceMsg.msg_apply_download_rsp.msg_file_info.uint32_expire_time.get();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.litetransfersdk.LiteTransferOperatorCallback
 * JD-Core Version:    0.7.0.1
 */