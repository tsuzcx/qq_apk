import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.cloudfile.AirCopyExtInfo;
import com.tencent.cloudfile.BatchRequest;
import com.tencent.cloudfile.CloudBase;
import com.tencent.cloudfile.CloudFile;
import com.tencent.cloudfile.CloudFileCallbackCenter;
import com.tencent.cloudfile.CloudHistoryInfo;
import com.tencent.cloudfile.CloudOnlineFileExt;
import com.tencent.cloudfile.CloudUploadFile;
import com.tencent.cloudfile.FileInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.transfile.ProtoReqManager.c;
import com.tencent.mobileqq.transfile.ProtoReqManager.d;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.cloudfile.CloudFileHandler.6;
import com.tencent.tim.cloudfile.CloudFileHandler.7;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.cloud.history_file_extension.history_file_extension.AIOFileExtension;
import tencent.cloud.history_file_extension.history_file_extension.CloudFileExtension;
import tencent.cloud.history_file_extension.history_file_extension.FileExtension;
import tencent.cloud.history_file_extension.history_file_extension.WPSFileExtension;
import tencent.cloud.history_file_extension.history_file_extension.WeiyunFileExtension;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x6ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x6RspBody;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyCopyToReq;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyCopyToRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346.FileInfo;
import tencent.im.cs.cmd0x346.cmd0x346.RecvListQueryReq;
import tencent.im.cs.cmd0x346.cmd0x346.RecvListQueryRsp;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;
import tencent.im.cs.cmd0x346.cmd0x346.SendListQueryReq;
import tencent.im.cs.cmd0x346.cmd0x346.SendListQueryRsp;
import tencent.im.cs.weiyun.weiyun_lite_message.FileExtInfo;
import tencent.im.cs.weiyun.weiyun_lite_message.TimCloudAddtionalInfo;
import tencent.im.cs.weiyun.weiyun_lite_message.TimCloudFileExtInfo;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9.CopyToReqBody;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9.ReqBody;

public class ateh
  extends accg
{
  private static int cRe;
  private ateh.a jdField_a_of_type_Ateh$a;
  private atsn jdField_a_of_type_Atsn = new atfe(this);
  CloudFileCallbackCenter jdField_a_of_type_ComTencentCloudfileCloudFileCallbackCenter = new atfb(this);
  
  public ateh(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    atgi.a().a(this.jdField_a_of_type_ComTencentCloudfileCloudFileCallbackCenter);
    this.app.a().addObserver(this.jdField_a_of_type_Atsn);
  }
  
  private void C(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    boolean bool1 = false;
    int i = -1;
    FileManagerEntity localFileManagerEntity = null;
    Object localObject1 = null;
    if (paramd.g.getResultCode() != 1000)
    {
      i = paramd.g.getResultCode();
      QLog.i("CloudFileHandler", 1, "handleCopyFileToCloudC2C: resp is failed[" + paramd.g.getResultCode() + "]");
      paramd = null;
      i += 1000000;
    }
    label90:
    Object localObject2;
    for (;;)
    {
      if (i != 0) {
        bool1 = false;
      }
      if (localObject1 != null) {
        break label771;
      }
      bool1 = false;
      long l = ((Long)((Object[])(Object[])paramc.fi)[0]).longValue();
      localFileManagerEntity = this.app.a().b(l);
      if (localFileManagerEntity != null) {
        break label283;
      }
      QLog.e("CloudFileHandler", 1, "handleCopyFileToCloudC2C, but entity is null!!!");
      return;
      paramd = paramd.g.getWupBuffer();
      localObject2 = new cmd0x346.RspBody();
      try
      {
        ((cmd0x346.RspBody)localObject2).mergeFrom(paramd);
        if (((cmd0x346.RspBody)localObject2).msg_apply_copy_to_rsp.has()) {
          break;
        }
        QLog.i("CloudFileHandler", 1, "handleCopyFileToCloudC2C rspBody has not hasMsgApplyDownloadAbsRsp");
        paramd = null;
        i = -1;
      }
      catch (InvalidProtocolBufferMicroException paramd)
      {
        paramd.printStackTrace();
        paramd = null;
        i = -1;
      }
    }
    localObject1 = (cmd0x346.ApplyCopyToRsp)((cmd0x346.RspBody)localObject2).msg_apply_copy_to_rsp.get();
    if (((cmd0x346.ApplyCopyToRsp)localObject1).int32_ret_code.has()) {
      i = ((cmd0x346.ApplyCopyToRsp)localObject1).int32_ret_code.get();
    }
    paramd = localFileManagerEntity;
    if (((cmd0x346.ApplyCopyToRsp)localObject1).str_ret_msg.has()) {
      paramd = ((cmd0x346.ApplyCopyToRsp)localObject1).str_ret_msg.get();
    }
    if (((cmd0x346.ApplyCopyToRsp)localObject1).str_file_key.has()) {}
    for (localObject1 = ((cmd0x346.ApplyCopyToRsp)localObject1).str_file_key.get();; localObject1 = null)
    {
      bool1 = true;
      break;
      label283:
      localObject2 = (atgc)this.app.getManager(373);
      boolean bool2 = ((Boolean)((Object[])(Object[])paramc.fi)[1]).booleanValue();
      FileInfo localFileInfo = athu.a(this.app, localFileManagerEntity, bool2);
      if (bool1)
      {
        localFileManagerEntity.cloudFile.cloudId = ((String)localObject1).getBytes();
        if ((bool2) && (!TextUtils.isEmpty(null))) {
          localFileInfo.fileName = null;
        }
        atgi.a().notifyAirCopySuccess(localFileManagerEntity.cloudFile.cloudId, localFileManagerEntity.cloudFile.pDirKey, localFileInfo);
        if (!bool2)
        {
          localFileManagerEntity.setCloudType(9);
          localFileManagerEntity.pDirKey = localFileManagerEntity.cloudFile.pDirKey;
          localFileManagerEntity.cloudId = localFileManagerEntity.cloudFile.cloudId;
          localFileManagerEntity.cloudIdHex = aqhs.bytes2HexStr(localFileManagerEntity.cloudId);
          localFileManagerEntity.cloudFile.type = 2;
          this.app.a().u(localFileManagerEntity);
          ((atgc)localObject2).S(localFileManagerEntity);
        }
        notifyUI(18, bool1, new Object[] { localFileManagerEntity, Boolean.valueOf(bool2), Integer.valueOf(i), paramd });
      }
      for (;;)
      {
        a(bool2, localFileManagerEntity, localFileInfo, i);
        return;
        QLog.e("CloudFileHandler", 1, "handleCopyFileToCloudC2C fail retCode = " + i + " retMsg = " + paramd + " fileName = " + localFileManagerEntity.fileName + " peerUin = " + localFileManagerEntity.peerUin + " srvTime = " + localFileManagerEntity.srvTime + " fileSize = " + localFileManagerEntity.fileSize + " uuid = " + localFileManagerEntity.Uuid + " bSend = " + localFileManagerEntity.bSend + " md5 = " + localFileManagerEntity.strFileMd5);
        if (!bool2)
        {
          if ((i == 1053) || (i == 22081))
          {
            ((atgc)localObject2).R(localFileManagerEntity);
            this.app.getProtoReqManager().e(paramc);
          }
          if ((i == -7003) || (i == 1091))
          {
            localFileManagerEntity.errCode = i;
            this.app.a().u(localFileManagerEntity);
            this.app.getProtoReqManager().e(paramc);
          }
        }
        notifyUI(18, bool1, new Object[] { localFileManagerEntity, Boolean.valueOf(bool2), Integer.valueOf(i), paramd });
      }
      label771:
      break label90;
    }
  }
  
  private void D(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    Object localObject3 = "";
    FileManagerEntity localFileManagerEntity = null;
    Object localObject1 = null;
    Object localObject2 = null;
    int i;
    boolean bool1;
    if ((paramd.g.getResultCode() == 1002) || (paramd.g.getResultCode() == 1013))
    {
      i = paramd.g.getResultCode();
      QLog.i("CloudFileHandler", 1, "handleCopyFileToCloudDisc: resp is timeout[" + paramd.g.getResultCode() + "]");
      i = 1000000 + i;
      bool1 = false;
    }
    for (paramd = "";; paramd = "")
    {
      if (i != 0) {
        bool1 = false;
      }
      if (localObject1 != null) {
        break label894;
      }
      bool1 = false;
      label112:
      long l = ((Long)((Object[])(Object[])paramc.fi)[0]).longValue();
      localFileManagerEntity = this.app.a().b(l);
      if (localFileManagerEntity != null) {
        break label413;
      }
      QLog.e("CloudFileHandler", 1, "handleCopyFileToCloudDisc, but entity is null!!!");
      return;
      if (paramd.g.getResultCode() == 1000) {
        break;
      }
      i = paramd.g.getResultCode();
      QLog.i("CloudFileHandler", 1, "handleCopyFileToCloudDisc: resp is failed[" + paramd.g.getResultCode() + "]");
      i = 1000000 + i;
      bool1 = false;
    }
    paramd = paramd.g.getWupBuffer();
    Object localObject4 = new cmd0x345.RspBody();
    for (;;)
    {
      try
      {
        ((cmd0x345.RspBody)localObject4).mergeFrom(paramd);
        if (!((cmd0x345.RspBody)localObject4).uint32_return_code.has()) {
          break label903;
        }
        i = ((cmd0x345.RspBody)localObject4).uint32_return_code.get();
        if (((cmd0x345.RspBody)localObject4).msg_subcmd_0x6_rsp_body.has()) {
          break label325;
        }
        QLog.i("CloudFileHandler", 1, "handleCopyFileToCloudDisc: rspBody has not hasMsgApplyDownloadRsp");
        bool1 = false;
        paramd = "";
      }
      catch (InvalidProtocolBufferMicroException paramd)
      {
        paramd.printStackTrace();
        i = -1;
        bool1 = false;
        paramd = "";
      }
      break;
      label325:
      localObject2 = (cmd0x345.RspBody.SubCmd0x6RspBody)((cmd0x345.RspBody)localObject4).msg_subcmd_0x6_rsp_body.get();
      paramd = (ProtoReqManager.d)localObject3;
      if (((cmd0x345.RspBody.SubCmd0x6RspBody)localObject2).str_ret_msg.has()) {
        paramd = ((cmd0x345.RspBody.SubCmd0x6RspBody)localObject2).str_ret_msg.get();
      }
      localObject1 = localFileManagerEntity;
      if (((cmd0x345.RspBody.SubCmd0x6RspBody)localObject2).str_file_id.has()) {
        localObject1 = ((cmd0x345.RspBody.SubCmd0x6RspBody)localObject2).str_file_id.get();
      }
      if (((cmd0x345.RspBody.SubCmd0x6RspBody)localObject2).str_file_name.has()) {}
      for (localObject2 = ((cmd0x345.RspBody.SubCmd0x6RspBody)localObject2).str_file_name.get();; localObject2 = null)
      {
        bool1 = true;
        break;
        label413:
        localObject3 = (atgc)this.app.getManager(373);
        boolean bool2 = ((Boolean)((Object[])(Object[])paramc.fi)[1]).booleanValue();
        localObject4 = athu.a(this.app, localFileManagerEntity, bool2);
        if (bool1)
        {
          localFileManagerEntity.cloudFile.cloudId = ((String)localObject1).getBytes();
          if ((bool2) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
            ((FileInfo)localObject4).fileName = ((String)localObject2);
          }
          atgi.a().notifyAirCopySuccess(localFileManagerEntity.cloudFile.cloudId, localFileManagerEntity.cloudFile.pDirKey, (FileInfo)localObject4);
          if (!bool2)
          {
            localFileManagerEntity.setCloudType(9);
            localFileManagerEntity.pDirKey = localFileManagerEntity.cloudFile.pDirKey;
            localFileManagerEntity.cloudId = localFileManagerEntity.cloudFile.cloudId;
            localFileManagerEntity.cloudIdHex = aqhs.bytes2HexStr(localFileManagerEntity.cloudId);
            this.app.a().u(localFileManagerEntity);
            ((atgc)localObject3).S(localFileManagerEntity);
          }
          notifyUI(19, bool1, new Object[] { localFileManagerEntity, Boolean.valueOf(bool2), Integer.valueOf(i), paramd });
        }
        for (;;)
        {
          a(bool2, localFileManagerEntity, (FileInfo)localObject4, i);
          return;
          QLog.e("CloudFileHandler", 1, "handleCopyFileToCloudDisc fail retCode = " + i + " retMsg = " + paramd + " fileName = " + localFileManagerEntity.fileName + " peerUin = " + localFileManagerEntity.peerUin + " srvTime = " + localFileManagerEntity.srvTime + " fileSize = " + localFileManagerEntity.fileSize + " uuid = " + localFileManagerEntity.Uuid + " bSend = " + localFileManagerEntity.bSend + " md5 = " + localFileManagerEntity.strFileMd5);
          if (!bool2)
          {
            if ((i == 1053) || (i == 22081))
            {
              ((atgc)localObject3).R(localFileManagerEntity);
              this.app.getProtoReqManager().e(paramc);
            }
            if ((i == -6101) || (i == 1091))
            {
              localFileManagerEntity.errCode = i;
              this.app.a().u(localFileManagerEntity);
              this.app.getProtoReqManager().e(paramc);
            }
          }
          notifyUI(19, bool1, new Object[] { localFileManagerEntity, Boolean.valueOf(bool2), Integer.valueOf(i), paramd });
        }
        label894:
        break label112;
      }
      label903:
      i = -1;
    }
  }
  
  private void E(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    boolean bool1 = false;
    int i = -1;
    Iterator localIterator = null;
    paramc = null;
    int j = -1;
    boolean bool2 = true;
    ArrayList localArrayList = new ArrayList();
    if (paramd.g.getResultCode() != 1000) {
      QLog.i("CloudFileHandler", 1, "handleOfflineRecvFileListQuery: resp is failed[" + paramd.g.getResultCode() + "]");
    }
    Object localObject;
    for (;;)
    {
      if (i != 0) {
        bool1 = false;
      }
      if (bool1) {
        nz(localArrayList);
      }
      notifyUI(25, bool1, new Object[] { Integer.valueOf(j), Boolean.valueOf(bool2), localArrayList, Integer.valueOf(i), paramc });
      return;
      paramd = paramd.g.getWupBuffer();
      localObject = new cmd0x346.RspBody();
      try
      {
        ((cmd0x346.RspBody)localObject).mergeFrom(paramd);
        if (((cmd0x346.RspBody)localObject).msg_recv_list_query_rsp.has()) {
          break;
        }
        QLog.i("CloudFileHandler", 1, "handleOfflineRecvFileListQuery rspBody has not hasMsgApplyDownloadAbsRsp");
      }
      catch (InvalidProtocolBufferMicroException paramd)
      {
        paramd.printStackTrace();
      }
    }
    paramd = (cmd0x346.RecvListQueryRsp)((cmd0x346.RspBody)localObject).msg_recv_list_query_rsp.get();
    if (paramd.int32_ret_code.has()) {}
    for (i = paramd.int32_ret_code.get();; i = -1)
    {
      paramc = localIterator;
      if (paramd.str_ret_msg.has()) {
        paramc = paramd.str_ret_msg.get();
      }
      if (paramd.rpt_msg_file_list.has())
      {
        localIterator = paramd.rpt_msg_file_list.get().iterator();
        while (localIterator.hasNext())
        {
          localObject = (cmd0x346.FileInfo)localIterator.next();
          OfflineFileInfo localOfflineFileInfo = new OfflineFileInfo();
          localOfflineFileInfo.bSend = false;
          localOfflineFileInfo.cYg = ((cmd0x346.FileInfo)localObject).uint32_danger_evel.get();
          localOfflineFileInfo.nFileSize = ((cmd0x346.FileInfo)localObject).uint64_file_size.get();
          localOfflineFileInfo.Zm = (anaz.gQ() * 1000L + ((cmd0x346.FileInfo)localObject).uint32_life_time.get() * 1000L);
          localOfflineFileInfo.Zn = (((cmd0x346.FileInfo)localObject).uint32_upload_time.get() * 1000L);
          localOfflineFileInfo.strFileName = ((cmd0x346.FileInfo)localObject).str_file_name.get();
          localOfflineFileInfo.bHK = ((cmd0x346.FileInfo)localObject).bytes_uuid.get().toStringUtf8();
          localOfflineFileInfo.uFriendUin = ((cmd0x346.FileInfo)localObject).uint64_uin.get();
          localArrayList.add(localOfflineFileInfo);
        }
      }
      if (paramd.uint32_begin_index.has()) {}
      for (j = paramd.uint32_begin_index.get();; j = -1)
      {
        if (paramd.uint32_is_end.has()) {
          if (paramd.uint32_is_end.get() == 1) {
            bool1 = true;
          }
        }
        for (;;)
        {
          bool2 = bool1;
          bool1 = true;
          break;
          bool1 = false;
          continue;
          bool1 = true;
        }
      }
    }
  }
  
  private void F(ProtoReqManager.c paramc, ProtoReqManager.d paramd)
  {
    boolean bool1 = false;
    int i = -1;
    Iterator localIterator = null;
    paramc = null;
    int j = -1;
    boolean bool2 = true;
    ArrayList localArrayList = new ArrayList();
    if (paramd.g.getResultCode() != 1000) {
      QLog.i("CloudFileHandler", 1, "handleOfflineSendFileListQuery: resp is failed[" + paramd.g.getResultCode() + "]");
    }
    Object localObject;
    for (;;)
    {
      if (i != 0) {
        bool1 = false;
      }
      if (bool1) {
        nz(localArrayList);
      }
      notifyUI(26, bool1, new Object[] { Integer.valueOf(j), Boolean.valueOf(bool2), localArrayList, Integer.valueOf(i), paramc });
      return;
      paramd = paramd.g.getWupBuffer();
      localObject = new cmd0x346.RspBody();
      try
      {
        ((cmd0x346.RspBody)localObject).mergeFrom(paramd);
        if (((cmd0x346.RspBody)localObject).msg_send_list_query_rsp.has()) {
          break;
        }
        QLog.i("CloudFileHandler", 1, "handleOfflineSendFileListQuery rspBody has not hasMsgApplyDownloadAbsRsp");
      }
      catch (InvalidProtocolBufferMicroException paramd)
      {
        paramd.printStackTrace();
      }
    }
    paramd = (cmd0x346.SendListQueryRsp)((cmd0x346.RspBody)localObject).msg_send_list_query_rsp.get();
    if (paramd.int32_ret_code.has()) {}
    for (i = paramd.int32_ret_code.get();; i = -1)
    {
      paramc = localIterator;
      if (paramd.str_ret_msg.has()) {
        paramc = paramd.str_ret_msg.get();
      }
      if (paramd.rpt_msg_file_list.has())
      {
        localIterator = paramd.rpt_msg_file_list.get().iterator();
        while (localIterator.hasNext())
        {
          localObject = (cmd0x346.FileInfo)localIterator.next();
          OfflineFileInfo localOfflineFileInfo = new OfflineFileInfo();
          localOfflineFileInfo.bSend = false;
          localOfflineFileInfo.cYg = ((cmd0x346.FileInfo)localObject).uint32_danger_evel.get();
          localOfflineFileInfo.nFileSize = ((cmd0x346.FileInfo)localObject).uint64_file_size.get();
          localOfflineFileInfo.Zm = (anaz.gQ() * 1000L + ((cmd0x346.FileInfo)localObject).uint32_life_time.get() * 1000L);
          localOfflineFileInfo.Zn = (((cmd0x346.FileInfo)localObject).uint32_upload_time.get() * 1000L);
          localOfflineFileInfo.strFileName = ((cmd0x346.FileInfo)localObject).str_file_name.get();
          localOfflineFileInfo.bHK = ((cmd0x346.FileInfo)localObject).bytes_uuid.get().toStringUtf8();
          localOfflineFileInfo.uFriendUin = ((cmd0x346.FileInfo)localObject).uint64_uin.get();
          localArrayList.add(localOfflineFileInfo);
        }
      }
      if (paramd.uint32_begin_index.has()) {}
      for (j = paramd.uint32_begin_index.get();; j = -1)
      {
        if (paramd.uint32_is_end.has()) {
          if (paramd.uint32_is_end.get() == 1) {
            bool1 = true;
          }
        }
        for (;;)
        {
          bool2 = bool1;
          bool1 = true;
          break;
          bool1 = false;
          continue;
          bool1 = true;
        }
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity1, FileManagerEntity paramFileManagerEntity2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CloudFileHandler", 2, "start c2c aio recent receive");
    }
    if ((paramFileManagerEntity1.cloudType == 3) || ((paramFileManagerEntity1.cloudType == 9) && (!TextUtils.isEmpty(paramFileManagerEntity1.getFilePath()))))
    {
      String str = paramFileManagerEntity1.getFilePath();
      boolean bool = new File(str).exists();
      if (QLog.isColorLevel()) {
        QLog.d("CloudFileHandler", 2, new Object[] { "download c2c but local, file exist: ", Boolean.valueOf(bool) });
      }
      if (bool)
      {
        if (paramFileManagerEntity2 == null) {
          return;
        }
        if (paramFileManagerEntity2.cloudFile.aioRecentFileExt != null) {}
        for (bool = true;; bool = false)
        {
          paramFileManagerEntity2.status = 1;
          paramFileManagerEntity2.strFilePath = str;
          atgi.a().a(paramFileManagerEntity2, str, bool);
          QQToast.a(paramQQAppInterface.getApplication(), 2, 2131690299, 0).show(aqcx.dip2px(paramQQAppInterface.getApplication(), 44.0F));
          return;
        }
      }
    }
    paramQQAppInterface.a().l(paramFileManagerEntity1);
  }
  
  private void a(FileManagerEntity paramFileManagerEntity, long paramLong, AirCopyExtInfo paramAirCopyExtInfo, TroopFileTransferManager paramTroopFileTransferManager, apcy paramapcy)
  {
    atgi.a().airCopyToOtherBiz(paramFileManagerEntity.pDirKey, paramFileManagerEntity.cloudId, 102, paramLong, paramFileManagerEntity.fileSize, paramFileManagerEntity.cloudSha, paramFileManagerEntity.fileName, paramAirCopyExtInfo, new atet(this, paramFileManagerEntity, paramTroopFileTransferManager, paramapcy));
  }
  
  private void a(String paramString, byte[] paramArrayOfByte, Object[] paramArrayOfObject, int paramInt1, int paramInt2, int paramInt3)
  {
    ProtoReqManager.c localc = new ProtoReqManager.c();
    localc.clW = paramString;
    localc.fW = paramArrayOfByte;
    localc.fi = paramArrayOfObject;
    localc.daB = paramInt1;
    localc.tryCount = paramInt2;
    localc.dPR = paramInt3;
    localc.a = new ateq(this);
    this.app.getProtoReqManager().b(localc);
  }
  
  private void a(boolean paramBoolean, FileManagerEntity paramFileManagerEntity, FileInfo paramFileInfo, int paramInt)
  {
    if (!paramBoolean)
    {
      atgi.a().autoAirCopyReportData(paramFileManagerEntity.cloudId, paramFileManagerEntity.pDirKey, paramFileInfo, paramInt);
      return;
    }
    long l = 0L;
    if (!TextUtils.isEmpty(paramFileManagerEntity.peerUin)) {
      l = Long.parseLong(paramFileManagerEntity.peerUin);
    }
    int i;
    if (paramFileManagerEntity.peerType == 3000) {
      i = 3;
    }
    for (;;)
    {
      atgi.a().manualAirCopyReportData(paramFileManagerEntity.cloudId, paramFileManagerEntity.pDirKey, paramFileInfo, 1, i, l, paramInt);
      return;
      if (paramFileManagerEntity.peerType == 1) {
        i = 4;
      } else {
        i = 2;
      }
    }
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt1, Object paramObject, int paramInt2, atgg paramatgg)
  {
    StringBuilder localStringBuilder;
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder().append("getDirFileList dirKey").append(Arrays.toString(paramArrayOfByte)).append(" operationType:").append(paramInt1).append(" lastFile:");
      if (paramObject == null) {
        break label102;
      }
    }
    label102:
    for (String str = paramObject.toString();; str = "")
    {
      QLog.d("CloudFileHandler", 2, str);
      paramatgg = new atfl(this, paramArrayOfByte, paramatgg, paramInt1);
      if (paramInt1 != 0) {
        break;
      }
      atgi.a().a(paramArrayOfByte, null, false, paramInt2, paramatgg);
      return;
    }
    if (paramInt1 == 2)
    {
      atgi.a().a(paramArrayOfByte, paramObject, true, paramInt2, paramatgg);
      return;
    }
    atgi.a().a(paramArrayOfByte, paramInt2, paramatgg);
  }
  
  private void b(FileManagerEntity paramFileManagerEntity, boolean paramBoolean)
  {
    if (paramFileManagerEntity == null) {
      return;
    }
    Object localObject1 = new cmd0x346.ApplyCopyToReq();
    ((cmd0x346.ApplyCopyToReq)localObject1).uint64_dst_id.set(this.app.getLongAccountUin());
    ((cmd0x346.ApplyCopyToReq)localObject1).uint64_dst_uin.set(this.app.getLongAccountUin());
    ((cmd0x346.ApplyCopyToReq)localObject1).uint32_dst_svcid.set(77);
    ((cmd0x346.ApplyCopyToReq)localObject1).uint64_src_uin.set(this.app.getLongAccountUin());
    ((cmd0x346.ApplyCopyToReq)localObject1).uint64_file_size.set(paramFileManagerEntity.fileSize);
    cmd0x346.ReqBody localReqBody;
    cmd0x346.ExtensionReq localExtensionReq;
    Object localObject2;
    label222:
    weiyun_lite_message.FileExtInfo localFileExtInfo;
    weiyun_lite_message.TimCloudAddtionalInfo localTimCloudAddtionalInfo;
    weiyun_lite_message.TimCloudFileExtInfo localTimCloudFileExtInfo;
    if (paramBoolean)
    {
      ((cmd0x346.ApplyCopyToReq)localObject1).str_file_name.set(paramFileManagerEntity.fileName);
      ((cmd0x346.ApplyCopyToReq)localObject1).bytes_uuid.set(ByteStringMicro.copyFrom(paramFileManagerEntity.Uuid.getBytes()));
      localReqBody = new cmd0x346.ReqBody();
      localReqBody.msg_apply_copy_to_req.set((MessageMicro)localObject1);
      localReqBody.uint32_cmd.set(60100);
      localObject1 = localReqBody.uint32_seq;
      i = cRe;
      cRe = i + 1;
      ((PBUInt32Field)localObject1).set(i);
      localReqBody.uint32_business_id.set(3);
      localReqBody.uint32_client_type.set(104);
      localExtensionReq = new cmd0x346.ExtensionReq();
      localObject2 = (atgc)this.app.getManager(373);
      if (!paramBoolean) {
        break label644;
      }
      localObject1 = ((atgc)localObject2).aG();
      localExtensionReq.bytes_tim_cloud_pdir_key.set(ByteStringMicro.copyFrom((byte[])localObject1));
      localExtensionReq.bytes_tim_cloud_ppdir_key.set(ByteStringMicro.copyFrom(((atgc)localObject2).aE()));
      localFileExtInfo = new weiyun_lite_message.FileExtInfo();
      localFileExtInfo.width.set(paramFileManagerEntity.imgWidth);
      localFileExtInfo.height.set(paramFileManagerEntity.imgHeight);
      if (!paramBoolean)
      {
        localTimCloudAddtionalInfo = new weiyun_lite_message.TimCloudAddtionalInfo();
        localTimCloudAddtionalInfo.uint32_biz_type.set(0);
        localTimCloudAddtionalInfo.uint32_src_type.set(2);
        localTimCloudFileExtInfo = new weiyun_lite_message.TimCloudFileExtInfo();
        localTimCloudFileExtInfo.str_show_name.set(paramFileManagerEntity.fileName);
        localObject2 = Long.valueOf(0L);
      }
    }
    try
    {
      long l = Long.parseLong(paramFileManagerEntity.peerUin.replace("+", ""));
      localObject2 = Long.valueOf(l);
    }
    catch (Exception localException)
    {
      label367:
      boolean bool;
      break label367;
    }
    localTimCloudFileExtInfo.uint64_peer_uin.set(((Long)localObject2).longValue());
    if (paramFileManagerEntity.bSend)
    {
      localTimCloudFileExtInfo.uint64_create_uin.set(this.app.getLongAccountUin());
      label402:
      localTimCloudFileExtInfo.uint64_trans_time.set(paramFileManagerEntity.srvTime);
      localObject2 = localTimCloudFileExtInfo.uint32_trans_type;
      if (!paramFileManagerEntity.bSend) {
        break label670;
      }
      i = 1;
      label430:
      ((PBUInt32Field)localObject2).set(i);
      if (!TextUtils.isEmpty(paramFileManagerEntity.strFileMd5)) {
        localTimCloudFileExtInfo.file_10m_md5.set(ByteStringMicro.copyFrom(paramFileManagerEntity.strFileMd5.getBytes()));
      }
      localTimCloudAddtionalInfo.msg_tim_cloud_file_ext_info.set(localTimCloudFileExtInfo);
      localFileExtInfo.bytes_tim_cloud_addtional_info.set(ByteStringMicro.copyFrom(localTimCloudAddtionalInfo.toByteArray()));
      localObject2 = localFileExtInfo.bool_ftn_to_qcloud_auto_req;
      if (paramBoolean) {
        break label675;
      }
      bool = true;
      label504:
      ((PBBoolField)localObject2).set(bool);
      localExtensionReq.bytes_tim_cloud_extension_info.set(ByteStringMicro.copyFrom(localFileExtInfo.toByteArray()));
      localObject2 = localExtensionReq.uint32_tim_file_exist_option;
      if (!paramBoolean) {
        break label681;
      }
    }
    label644:
    label670:
    label675:
    label681:
    for (int i = 0;; i = 1)
    {
      ((PBUInt32Field)localObject2).set(i);
      localReqBody.msg_extension_req.set(localExtensionReq);
      paramFileManagerEntity.cloudFile = new CloudFile();
      paramFileManagerEntity.cloudFile.pDirKey = ((byte[])localObject1);
      a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_COPY_TO-60100", localReqBody.toByteArray(), new Object[] { Long.valueOf(paramFileManagerEntity.nSessionId), Boolean.valueOf(paramBoolean) }, 30000, 3, 1);
      return;
      ((cmd0x346.ApplyCopyToReq)localObject1).str_file_name.set(atgi.a().encodeFileNameForAirCopy(paramFileManagerEntity.Uuid, paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize));
      break;
      localObject1 = ((atgc)localObject2).aF();
      break label222;
      localTimCloudFileExtInfo.uint64_create_uin.set(((Long)localObject2).longValue());
      break label402;
      i = 2;
      break label430;
      bool = false;
      break label504;
    }
  }
  
  private void d(FileManagerEntity paramFileManagerEntity, boolean paramBoolean)
  {
    if (paramFileManagerEntity == null) {
      return;
    }
    cmd0x345.ReqBody.SubCmd0x6ReqBody localSubCmd0x6ReqBody = new cmd0x345.ReqBody.SubCmd0x6ReqBody();
    localSubCmd0x6ReqBody.uint32_dst_bus_id.set(77);
    localSubCmd0x6ReqBody.uint64_file_size.set(paramFileManagerEntity.fileSize);
    localSubCmd0x6ReqBody.bytes_uuid.set(ByteStringMicro.copyFrom(paramFileManagerEntity.Uuid.getBytes()));
    if ((paramFileManagerEntity.strFileMd5 != null) && (paramFileManagerEntity.strFileMd5.length() > 0)) {
      localSubCmd0x6ReqBody.bytes_file_md5.set(ByteStringMicro.copyFrom(paramFileManagerEntity.strFileMd5.getBytes()));
    }
    try
    {
      localSubCmd0x6ReqBody.uint64_src_uin.set(Long.parseLong(paramFileManagerEntity.peerUin.replace("+", "")));
      localSubCmd0x6ReqBody.uint64_dst_uin.set(this.app.getLongAccountUin());
      if (paramBoolean)
      {
        localSubCmd0x6ReqBody.str_file_name.set(paramFileManagerEntity.fileName);
        localSubCmd0x6ReqBody.str_src_file_path.set(paramFileManagerEntity.Uuid);
        localSubCmd0x6ReqBody.str_src_parent_folder.set("/");
        localSubCmd0x6ReqBody.uint32_client_type.set(104);
        if (paramFileManagerEntity.tmpSessionType > 0L)
        {
          if ((paramFileManagerEntity.tmpSessionRelatedUin != null) && (paramFileManagerEntity.tmpSessionRelatedUin.length() > 0)) {
            localSubCmd0x6ReqBody.uint64_src_uin.set(Long.parseLong(paramFileManagerEntity.tmpSessionRelatedUin));
          }
          localSubCmd0x6ReqBody.uint64_app_id.set(3L);
          localSubCmd0x6ReqBody.uint64_talk_type.set(paramFileManagerEntity.tmpSessionType);
          if ((paramFileManagerEntity.tmpSessionSig != null) && (paramFileManagerEntity.tmpSessionSig.length > 0)) {
            localSubCmd0x6ReqBody.bytes_sig.set(ByteStringMicro.copyFrom(paramFileManagerEntity.tmpSessionSig));
          }
          if ((paramFileManagerEntity.tmpSessionToPhone != null) && (paramFileManagerEntity.tmpSessionToPhone.length() > 0)) {
            localSubCmd0x6ReqBody.str_dst_phone_number.set(paramFileManagerEntity.tmpSessionToPhone);
          }
          if (QLog.isColorLevel()) {
            QLog.d("CloudFileHandler", 2, "ForwardDiscFile : addtempinfo SessionType[" + paramFileManagerEntity.tmpSessionType + "], sessionId[" + paramFileManagerEntity.nSessionId + "]");
          }
        }
        localObject1 = (atgc)this.app.getManager(373);
        if (!paramBoolean) {
          break label807;
        }
        arrayOfByte1 = ((atgc)localObject1).aG();
        localSubCmd0x6ReqBody.bytes_tim_cloud_pdir_key.set(ByteStringMicro.copyFrom(arrayOfByte1));
        localSubCmd0x6ReqBody.bytes_tim_cloud_ppdir_key.set(ByteStringMicro.copyFrom(((atgc)localObject1).aE()));
        localObject1 = new weiyun_lite_message.FileExtInfo();
        ((weiyun_lite_message.FileExtInfo)localObject1).width.set(paramFileManagerEntity.imgWidth);
        ((weiyun_lite_message.FileExtInfo)localObject1).height.set(paramFileManagerEntity.imgHeight);
        if (!paramBoolean)
        {
          localObject2 = new weiyun_lite_message.TimCloudAddtionalInfo();
          ((weiyun_lite_message.TimCloudAddtionalInfo)localObject2).uint32_biz_type.set(0);
          ((weiyun_lite_message.TimCloudAddtionalInfo)localObject2).uint32_src_type.set(3);
          localTimCloudFileExtInfo = new weiyun_lite_message.TimCloudFileExtInfo();
          localTimCloudFileExtInfo.str_show_name.set(paramFileManagerEntity.fileName);
        }
      }
    }
    catch (Exception localException2)
    {
      try
      {
        localTimCloudFileExtInfo.uint64_peer_uin.set(Long.parseLong(paramFileManagerEntity.peerUin.replace("+", "")));
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            byte[] arrayOfByte1;
            localTimCloudFileExtInfo.uint64_create_uin.set(Long.parseLong(paramFileManagerEntity.selfUin));
            localTimCloudFileExtInfo.uint64_trans_time.set(paramFileManagerEntity.srvTime);
            PBUInt32Field localPBUInt32Field = localTimCloudFileExtInfo.uint32_trans_type;
            if (!paramFileManagerEntity.bSend) {
              break;
            }
            i = 1;
            localPBUInt32Field.set(i);
            if (!TextUtils.isEmpty(paramFileManagerEntity.strFileMd5)) {
              localTimCloudFileExtInfo.file_10m_md5.set(ByteStringMicro.copyFrom(paramFileManagerEntity.strFileMd5.getBytes()));
            }
            ((weiyun_lite_message.TimCloudAddtionalInfo)localObject2).msg_tim_cloud_file_ext_info.set(localTimCloudFileExtInfo);
            ((weiyun_lite_message.FileExtInfo)localObject1).bytes_tim_cloud_addtional_info.set(ByteStringMicro.copyFrom(((weiyun_lite_message.TimCloudAddtionalInfo)localObject2).toByteArray()));
            Object localObject2 = ((weiyun_lite_message.FileExtInfo)localObject1).bool_ftn_to_qcloud_auto_req;
            if (paramBoolean) {
              break label850;
            }
            bool = true;
            ((PBBoolField)localObject2).set(bool);
            localSubCmd0x6ReqBody.bytes_tim_cloud_extension_info.set(ByteStringMicro.copyFrom(((weiyun_lite_message.FileExtInfo)localObject1).toByteArray()));
            Object localObject1 = localSubCmd0x6ReqBody.uint32_tim_file_exist_option;
            if (!paramBoolean) {
              break label856;
            }
            i = 0;
            ((PBUInt32Field)localObject1).set(i);
            localObject1 = new cmd0x345.ReqBody();
            ((cmd0x345.ReqBody)localObject1).msg_subcmd_0x6_req_body.set(localSubCmd0x6ReqBody);
            ((cmd0x345.ReqBody)localObject1).uint32_sub_cmd.set(7);
            paramFileManagerEntity.cloudFile = new CloudFile();
            paramFileManagerEntity.cloudFile.pDirKey = arrayOfByte1;
            a("GTalkFileAppSvr.CMD_DISCUSS_FILE", ((cmd0x345.ReqBody)localObject1).toByteArray(), new Object[] { Long.valueOf(paramFileManagerEntity.nSessionId), Boolean.valueOf(paramBoolean) }, 30000, 3, 1);
            return;
            localException1 = localException1;
            localSubCmd0x6ReqBody.uint64_src_uin.set(0L);
            continue;
            localSubCmd0x6ReqBody.str_file_name.set(atgi.a().encodeFileNameForAirCopy(paramFileManagerEntity.Uuid, paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize));
            continue;
            label807:
            byte[] arrayOfByte2 = ((atgc)localObject1).aF();
            continue;
            localException2 = localException2;
            localTimCloudFileExtInfo.uint64_peer_uin.set(0L);
          }
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            weiyun_lite_message.TimCloudFileExtInfo localTimCloudFileExtInfo;
            localTimCloudFileExtInfo.uint64_create_uin.set(0L);
            continue;
            int i = 2;
            continue;
            label850:
            boolean bool = false;
            continue;
            label856:
            i = 1;
          }
        }
      }
    }
  }
  
  private int fL(String paramString)
  {
    if ("doc".equals(paramString)) {
      return 1;
    }
    if ("sheet".equals(paramString)) {
      return 2;
    }
    if ("form".equals(paramString)) {
      return 3;
    }
    if ("slides".equals(paramString)) {
      return 4;
    }
    return -1;
  }
  
  private void l(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    notifyUI(0, paramBoolean1, new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean2) });
  }
  
  private void ny(List<FileInfo> paramList)
  {
    ThreadManager.executeOnFileThread(new CloudFileHandler.6(this, paramList));
  }
  
  private void nz(List<OfflineFileInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList(this.app.a().eV());
    Collections.sort(paramList, new atfa(this));
    paramList = paramList.iterator();
    label264:
    label393:
    label396:
    for (;;)
    {
      label51:
      Object localObject1;
      Object localObject2;
      label79:
      FileManagerEntity localFileManagerEntity;
      int i;
      if (paramList.hasNext())
      {
        localObject1 = (OfflineFileInfo)paramList.next();
        localObject2 = localArrayList.iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label393;
        }
        localFileManagerEntity = (FileManagerEntity)((Iterator)localObject2).next();
        String str = ((OfflineFileInfo)localObject1).bHK.replace("/offline", "");
        if ((localFileManagerEntity.Uuid == null) || (!localFileManagerEntity.Uuid.equalsIgnoreCase(str))) {
          break label264;
        }
        i = 1;
      }
      for (;;)
      {
        label140:
        if (i != 0) {
          break label396;
        }
        localObject1 = ahav.a((OfflineFileInfo)localObject1, 0);
        if (((FileManagerEntity)localObject1).nFileType == 0) {
          this.app.a().a((FileManagerEntity)localObject1, 5);
        }
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("CloudFileHandler", 2, "mergeOfflineList,addEntity:fileName[" + ((FileManagerEntity)localObject1).fileName + "],bSend[" + ((FileManagerEntity)localObject1).bSend + "],Uuid[" + ((FileManagerEntity)localObject1).Uuid + "]");
          }
          ((FileManagerEntity)localObject1).bOnceSuccess = true;
          this.app.a().s((FileManagerEntity)localObject1);
          break label51;
          break;
          if ((Math.abs(localFileManagerEntity.srvTime - ((OfflineFileInfo)localObject1).Zn) >= 60000L) || (localFileManagerEntity.fileSize != ((OfflineFileInfo)localObject1).nFileSize) || (localFileManagerEntity.peerUin == null) || (!localFileManagerEntity.peerUin.equalsIgnoreCase(String.valueOf(((OfflineFileInfo)localObject1).uFriendUin))) || (localFileManagerEntity.fileName == null) || (!localFileManagerEntity.fileName.equalsIgnoreCase(((OfflineFileInfo)localObject1).strFileName))) {
            break label79;
          }
          i = 1;
          break label140;
          if (((FileManagerEntity)localObject1).nFileType == 2)
          {
            localObject2 = this.app.a().a((FileManagerEntity)localObject1);
            if (localObject2 != null) {
              ((FileManagerEntity)localObject1).strThumbPath = ((String)localObject2);
            }
          }
        }
        i = 0;
      }
    }
  }
  
  private boolean x(FileManagerEntity paramFileManagerEntity)
  {
    long l = 604800000L;
    if (paramFileManagerEntity.peerType == 3000) {
      l = 2592000000L;
    }
    return l + paramFileManagerEntity.srvTime <= NetConnInfoCenter.getServerTimeMillis() + 5000L;
  }
  
  public void N(int paramInt, Object paramObject)
  {
    Object localObject = (atgc)this.app.getManager(373);
    byte[] arrayOfByte = ((atgc)localObject).aE();
    if (QLog.isColorLevel()) {
      QLog.d("CloudFileHandler", 2, "getFileGridData operationType:" + paramInt);
    }
    localObject = new atei(this, (atgc)localObject, paramInt);
    if (arrayOfByte == null)
    {
      a(new ates(this, paramInt, (atgg)localObject));
      return;
    }
    a(arrayOfByte, paramInt, paramObject, 100, (atgg)localObject);
    eto();
  }
  
  public long a(byte[] paramArrayOfByte, CloudOnlineFileExt paramCloudOnlineFileExt)
  {
    if (!aqiw.isNetworkAvailable(BaseApplicationImpl.getContext()))
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 1, BaseApplicationImpl.getApplication().getString(2131693404), 0).show(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299627));
      return -1L;
    }
    paramArrayOfByte = atgi.a().a(paramArrayOfByte, paramCloudOnlineFileExt);
    atgi.a().startUploadFile(Arrays.asList(new Long[] { Long.valueOf(paramArrayOfByte.uploadFile.taskId) }));
    return paramArrayOfByte.uploadFile.taskId;
  }
  
  public CloudOnlineFileExt a(String paramString1, String paramString2)
  {
    Object localObject = ((aulh)this.app.getBusinessHandler(178)).g(paramString1, paramString2);
    try
    {
      if (((JSONObject)localObject).getInt("retcode") != 0) {
        break label273;
      }
      int i = ((JSONObject)localObject).getInt("domainId");
      String str2 = ((JSONObject)localObject).getString("localPadId");
      String str4 = ((JSONObject)localObject).getString("url");
      String str5 = ((JSONObject)localObject).optString("thumbUrl");
      long l = ((JSONObject)localObject).getLong("createdDate");
      String str3 = ((JSONObject)localObject).getString("padType");
      String str1 = ((JSONObject)localObject).getString("title");
      localObject = new CloudOnlineFileExt();
      try
      {
        ((CloudOnlineFileExt)localObject).createSrcType = 1;
        ((CloudOnlineFileExt)localObject).url = str4;
        ((CloudOnlineFileExt)localObject).thumbUrl = str5;
        if (str1 != null) {
          paramString2 = str1;
        }
        ((CloudOnlineFileExt)localObject).fileName = paramString2;
        ((CloudOnlineFileExt)localObject).domainId = i;
        ((CloudOnlineFileExt)localObject).localId = str2;
        if (!TextUtils.isEmpty(str3)) {}
        for (((CloudOnlineFileExt)localObject).onlineFileType = fL(str3);; ((CloudOnlineFileExt)localObject).onlineFileType = fL(paramString1))
        {
          ((CloudOnlineFileExt)localObject).onlineListType = 1;
          ((CloudOnlineFileExt)localObject).creatorUin = this.app.getLongAccountUin();
          ((CloudOnlineFileExt)localObject).onlineCreateTime = l;
          ((CloudOnlineFileExt)localObject).lastModifierUin = this.app.getLongAccountUin();
          ((CloudOnlineFileExt)localObject).onlineModifyTime = l;
          return localObject;
        }
        localObject = paramString1;
      }
      catch (JSONException paramString2)
      {
        paramString1 = (String)localObject;
      }
    }
    catch (JSONException paramString2)
    {
      for (;;)
      {
        paramString1 = null;
      }
      label273:
      localObject = null;
    }
    if (QLog.isColorLevel())
    {
      QLog.e("CloudFileHandler", 2, paramString2, new Object[] { "createTeamWorkCloudFile" });
      return paramString1;
    }
    return localObject;
  }
  
  public List<Long> a(byte[] paramArrayOfByte, List<FileInfo> paramList)
  {
    ny(paramList);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    label215:
    while (paramList.hasNext())
    {
      FileInfo localFileInfo = (FileInfo)paramList.next();
      if (QLog.isColorLevel()) {
        QLog.i("CloudFileHandler", 2, "createFile name:" + localFileInfo.fileName + " path:" + localFileInfo.localPath + " size:" + String.valueOf(localFileInfo.fileSize));
      }
      localFileInfo.fileSrcType = 1;
      FileManagerEntity localFileManagerEntity = atgi.a().a(paramArrayOfByte, localFileInfo);
      if (localFileManagerEntity.uploadFile.taskId != 0L) {
        localArrayList.add(Long.valueOf(localFileManagerEntity.uploadFile.taskId));
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label215;
        }
        QLog.i("CloudFileHandler", 2, "createFile taskId:" + localFileManagerEntity.uploadFile.taskId);
        break;
        ThreadManager.getUIHandler().post(new CloudFileHandler.7(this, localFileInfo));
      }
    }
    atgi.a().startUploadFile(localArrayList);
    return localArrayList;
  }
  
  public void a(int paramInt, atgg paramatgg)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("CloudFileHandler", 2, "getFeedsListGridThumb operationType:" + paramInt);
    }
    paramatgg = new atej(this, paramatgg, paramInt);
    if (paramInt == 0) {
      atgi.a().a(null, 14, true, paramatgg);
    }
    for (;;)
    {
      atgi.a().getAllItemCount(paramatgg);
      return;
      atgi.a().a(null, 14, true, paramatgg);
    }
  }
  
  public void a(int paramInt, Object paramObject, atgg paramatgg)
  {
    String str;
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("getFeedsList operationType:").append(paramInt).append(" lastFile:");
      if (paramObject != null)
      {
        str = paramObject.toString();
        QLog.d("CloudFileHandler", 2, str);
      }
    }
    else
    {
      paramatgg = new atek(this, paramatgg, paramInt);
      if (paramInt != 0) {
        break label99;
      }
      atgi.a().a(null, 14, true, paramatgg);
    }
    for (;;)
    {
      atgi.a().getAllItemCount(paramatgg);
      return;
      str = "";
      break;
      label99:
      if (paramInt == 2) {
        atgi.a().a(paramObject, 14, true, paramatgg);
      } else {
        atgi.a().a(14, true, paramatgg);
      }
    }
  }
  
  public void a(ateh.a parama)
  {
    this.jdField_a_of_type_Ateh$a = parama;
  }
  
  public void a(atgg paramatgg)
  {
    paramatgg = new atff(this, paramatgg);
    atgi.a().b(paramatgg);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, int paramInt1, int paramInt2)
  {
    if (paramFileManagerEntity == null)
    {
      QLog.i("CloudFileHandler", 1, "addNewRecentFileHistory. but fileEntity is null.");
      return;
    }
    CloudHistoryInfo localCloudHistoryInfo = new CloudHistoryInfo();
    history_file_extension.FileExtension localFileExtension = new history_file_extension.FileExtension();
    localCloudHistoryInfo.sourceType = paramInt2;
    localCloudHistoryInfo.operateType = paramInt1;
    switch (paramInt2)
    {
    }
    for (;;)
    {
      localCloudHistoryInfo.fileExtInfo = localFileExtension.toByteArray();
      if (QLog.isColorLevel())
      {
        paramFileManagerEntity = "";
        if (localCloudHistoryInfo.fileIdBytes != null) {
          paramFileManagerEntity = new String(localCloudHistoryInfo.fileIdBytes, Charset.forName("UTF-8"));
        }
        QLog.i("CloudFileHandler", 1, "addNewRecentFileHistory. fileName[" + localCloudHistoryInfo.fileName + "] source[" + localCloudHistoryInfo.sourceType + "] localPath[" + localCloudHistoryInfo.localPath + "] fileId[" + paramFileManagerEntity + "]");
      }
      atgi.a().a(localCloudHistoryInfo, new atfg(this));
      return;
      Object localObject = paramFileManagerEntity.cloudFile;
      if (localObject == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("CloudFileHandler<QFileCloud>", 1, "addNewRecentFileHistory error, cloudFile is null! sessionId[" + paramFileManagerEntity.nSessionId + "]");
        return;
      }
      localCloudHistoryInfo.fileType = ((CloudFile)localObject).fileType;
      localCloudHistoryInfo.fileName = ((CloudFile)localObject).showName;
      localCloudHistoryInfo.fileSize = ((CloudFile)localObject).fileSize;
      localCloudHistoryInfo.operateTime = System.currentTimeMillis();
      localCloudHistoryInfo.localPath = paramFileManagerEntity.getFilePath();
      localCloudHistoryInfo.fileSha = ((CloudFile)localObject).fileSha;
      localCloudHistoryInfo.fileIdBytes = ((CloudFile)localObject).cloudId;
      localObject = new history_file_extension.CloudFileExtension();
      ((history_file_extension.CloudFileExtension)localObject).bytes_tim_cloud_pdir_id.set(ByteStringMicro.copyFrom(paramFileManagerEntity.pDirKey));
      localFileExtension.cloud_file_extension.set((MessageMicro)localObject);
      continue;
      localCloudHistoryInfo.fileName = paramFileManagerEntity.fileName;
      localCloudHistoryInfo.fileSize = paramFileManagerEntity.fileSize;
      localCloudHistoryInfo.fileType = ahav.hN(paramFileManagerEntity.nFileType);
      localCloudHistoryInfo.operateTime = System.currentTimeMillis();
      localCloudHistoryInfo.localPath = paramFileManagerEntity.getFilePath();
      if (!TextUtils.isEmpty(paramFileManagerEntity.Uuid))
      {
        localCloudHistoryInfo.fileIdBytes = paramFileManagerEntity.Uuid.getBytes(Charset.forName("UTF-8"));
        localObject = new history_file_extension.AIOFileExtension();
        localFileExtension.uint64_session_id.set(paramFileManagerEntity.nSessionId);
        if (paramFileManagerEntity.selfUin != null) {
          ((history_file_extension.AIOFileExtension)localObject).uint64_sender_uin.set(Long.valueOf(paramFileManagerEntity.selfUin).longValue());
        }
        if (paramFileManagerEntity.peerUin != null) {
          ((history_file_extension.AIOFileExtension)localObject).uint64_recver_uin.set(Long.valueOf(paramFileManagerEntity.peerUin).longValue());
        }
        if (paramInt2 == 2) {
          ((history_file_extension.AIOFileExtension)localObject).uint64_discuss_uin.set(Long.valueOf(paramFileManagerEntity.peerUin).longValue());
        }
      }
      else
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("CloudFileHandler<QFileCloud>", 1, "addNewRecentFileHistory error, offline file uuid is null!cloudType[" + paramFileManagerEntity.getCloudFileType() + "] sessionId[" + paramFileManagerEntity.nSessionId + "]");
        return;
        localCloudHistoryInfo.fileName = paramFileManagerEntity.fileName;
        localCloudHistoryInfo.fileSize = paramFileManagerEntity.fileSize;
        localCloudHistoryInfo.fileType = ahav.hN(paramFileManagerEntity.nFileType);
        localCloudHistoryInfo.operateTime = System.currentTimeMillis();
        localCloudHistoryInfo.localPath = paramFileManagerEntity.getFilePath();
        if (!TextUtils.isEmpty(paramFileManagerEntity.WeiYunFileId))
        {
          localCloudHistoryInfo.fileIdBytes = paramFileManagerEntity.WeiYunFileId.getBytes(Charset.forName("UTF-8"));
          localObject = new history_file_extension.WeiyunFileExtension();
          localFileExtension.uint64_session_id.set(paramFileManagerEntity.nSessionId);
          if (!TextUtils.isEmpty(paramFileManagerEntity.WeiYunDirKey)) {
            ((history_file_extension.WeiyunFileExtension)localObject).str_thumb_url.set(paramFileManagerEntity.WeiYunDirKey);
          }
          localFileExtension.weiyun_file_extension.set((MessageMicro)localObject);
        }
        else
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("CloudFileHandler<QFileCloud>", 1, "addNewRecentFileHistory error, weiyun fileId is null!cloudType[" + paramFileManagerEntity.getCloudFileType() + "] sessionId[" + paramFileManagerEntity.nSessionId + "]");
          return;
          localObject = apsv.a(this.app, paramFileManagerEntity);
          localCloudHistoryInfo.fileType = ahav.hN(paramFileManagerEntity.nFileType);
          localCloudHistoryInfo.fileName = paramFileManagerEntity.fileName;
          localCloudHistoryInfo.fileSize = paramFileManagerEntity.fileSize;
          localCloudHistoryInfo.operateTime = System.currentTimeMillis();
          localCloudHistoryInfo.localPath = paramFileManagerEntity.getFilePath();
          if (!TextUtils.isEmpty(paramFileManagerEntity.strTroopFilePath))
          {
            localCloudHistoryInfo.fileIdBytes = paramFileManagerEntity.strTroopFilePath.getBytes(Charset.forName("UTF-8"));
            if (!TextUtils.isEmpty(((apcy)localObject).sha1)) {
              localCloudHistoryInfo.fileSha = ((apcy)localObject).sha1.getBytes(Charset.forName("UTF-8"));
            }
            localObject = new history_file_extension.AIOFileExtension();
            localFileExtension.uint64_session_id.set(paramFileManagerEntity.nSessionId);
            ((history_file_extension.AIOFileExtension)localObject).uint64_groupe_code.set(paramFileManagerEntity.TroopUin);
            ((history_file_extension.AIOFileExtension)localObject).int32_group_busid.set(paramFileManagerEntity.busId);
            if (!TextUtils.isEmpty(paramFileManagerEntity.strTroopFileID)) {
              ((history_file_extension.AIOFileExtension)localObject).str_group_file_path.set(paramFileManagerEntity.strTroopFileID);
            }
            localFileExtension.aio_file_extension.set((MessageMicro)localObject);
          }
          else
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("CloudFileHandler<QFileCloud>", 1, "addNewRecentFileHistory error, troop strTroopFilePath is null!cloudType[" + paramFileManagerEntity.getCloudFileType() + "] sessionId[" + paramFileManagerEntity.nSessionId + "]");
            return;
            localCloudHistoryInfo.fileName = paramFileManagerEntity.fileName;
            localCloudHistoryInfo.fileSize = paramFileManagerEntity.fileSize;
            localCloudHistoryInfo.fileType = ahav.hN(paramFileManagerEntity.nFileType);
            localCloudHistoryInfo.operateTime = System.currentTimeMillis();
            localCloudHistoryInfo.localPath = paramFileManagerEntity.getFilePath();
          }
        }
      }
    }
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, boolean paramBoolean)
  {
    if ((paramFileManagerEntity == null) || (paramFileManagerEntity.peerType == 3000) || (paramFileManagerEntity.peerType == 1) || (paramFileManagerEntity.peerType == 6000) || (paramFileManagerEntity.peerType == 6003) || (paramFileManagerEntity.peerType == 6002) || (paramFileManagerEntity.peerType == 6001) || (paramFileManagerEntity.status == 16) || (paramFileManagerEntity.errCode == -7003) || (paramFileManagerEntity.errCode == 1091)) {
      notifyUI(28, false, new Object[] { paramFileManagerEntity, Boolean.valueOf(paramBoolean), Integer.valueOf(-65535), "file is invaild" });
    }
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("CloudFileHandler", 2, "copyFileToCloudC2C peerType:" + paramFileManagerEntity.peerType + " uuid:" + paramFileManagerEntity.Uuid);
      }
      localSharedPreferences = this.app.getApplication().getSharedPreferences(this.app.getCurrentAccountUin(), 0);
      if ((!((atgc)this.app.getManager(373)).aJe()) || (paramFileManagerEntity == null) || (TextUtils.isEmpty(paramFileManagerEntity.Uuid))) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("CloudFileHandler", 2, "copyFileToCloudC2C peerType:" + paramFileManagerEntity.peerType + " uuid:" + paramFileManagerEntity.Uuid + "name" + paramFileManagerEntity.fileName);
      }
      if (paramBoolean)
      {
        b(paramFileManagerEntity, paramBoolean);
        return;
      }
    } while (!localSharedPreferences.getBoolean("tim_cloudfile_autosave_flag", true));
    atgi.a().a(athu.a(this.app, paramFileManagerEntity), new atex(this, paramFileManagerEntity, paramBoolean));
    return;
    notifyUI(28, false, new Object[] { paramFileManagerEntity, Boolean.valueOf(paramBoolean), Integer.valueOf(-255), "uuid is null" });
  }
  
  public void a(String paramString1, String paramString2, long paramLong, int paramInt1, int paramInt2)
  {
    CloudHistoryInfo localCloudHistoryInfo = new CloudHistoryInfo();
    history_file_extension.FileExtension localFileExtension = new history_file_extension.FileExtension();
    localCloudHistoryInfo.sourceType = 8;
    localCloudHistoryInfo.operateType = paramInt2;
    localCloudHistoryInfo.fileName = paramString1;
    localCloudHistoryInfo.fileSize = paramLong;
    localCloudHistoryInfo.fileType = ahav.hN(paramInt1);
    localCloudHistoryInfo.operateTime = System.currentTimeMillis();
    localCloudHistoryInfo.localPath = paramString2;
    localCloudHistoryInfo.fileExtInfo = localFileExtension.toByteArray();
    if (QLog.isColorLevel()) {
      QLog.i("CloudFileHandler", 1, "addNewRecentFileHistoryWithLocal. fileName[" + localCloudHistoryInfo.fileName + "] source[" + localCloudHistoryInfo.sourceType + "] localPath[" + localCloudHistoryInfo.localPath + "] ");
    }
    atgi.a().a(localCloudHistoryInfo, new atfh(this));
  }
  
  public void a(String paramString1, String paramString2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, long paramLong, int paramInt1, int paramInt2)
  {
    CloudHistoryInfo localCloudHistoryInfo = new CloudHistoryInfo();
    localCloudHistoryInfo.fileType = paramInt1;
    localCloudHistoryInfo.fileName = paramString1;
    localCloudHistoryInfo.fileSize = paramLong;
    localCloudHistoryInfo.operateTime = System.currentTimeMillis();
    localCloudHistoryInfo.localPath = paramString2;
    localCloudHistoryInfo.fileIdBytes = paramArrayOfByte2;
    localCloudHistoryInfo.fileSha = paramArrayOfByte3;
    localCloudHistoryInfo.sourceType = 4;
    localCloudHistoryInfo.operateType = paramInt2;
    paramString1 = new history_file_extension.FileExtension();
    paramString2 = new history_file_extension.CloudFileExtension();
    paramString2.bytes_tim_cloud_pdir_id.set(ByteStringMicro.copyFrom(paramArrayOfByte1));
    paramString1.cloud_file_extension.set(paramString2);
    localCloudHistoryInfo.fileExtInfo = paramString1.toByteArray();
    if (QLog.isColorLevel()) {
      QLog.i("CloudFileHandler", 1, "addNewRecentFileHistoryWithTimCloud. fileName[" + localCloudHistoryInfo.fileName + "] source[" + localCloudHistoryInfo.sourceType + "] localPath[" + localCloudHistoryInfo.localPath + "]");
    }
    atgi.a().a(localCloudHistoryInfo, new atfj(this));
  }
  
  public void a(List<BatchRequest> paramList, byte[] paramArrayOfByte)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    byte[] arrayOfByte = ((BatchRequest)paramList.get(0)).pDirKey;
    if (QLog.isColorLevel()) {
      QLog.d("CloudFileHandler", 2, "move file source pdirKey" + Arrays.toString(arrayOfByte) + " dst key name" + Arrays.toString(paramArrayOfByte));
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      BatchRequest localBatchRequest = (BatchRequest)localIterator.next();
      if (QLog.isColorLevel()) {
        QLog.d("CloudFileHandler", 2, "move file self key" + Arrays.toString(localBatchRequest.cloudId));
      }
    }
    atgi.a().a(paramList, paramArrayOfByte, new ateo(this, arrayOfByte, paramArrayOfByte, paramList));
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt, Object paramObject)
  {
    int i = 14;
    if (Arrays.equals(((atgc)this.app.getManager(373)).aE(), paramArrayOfByte)) {
      i = 100;
    }
    a(paramArrayOfByte, paramInt, paramObject, i, null);
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CloudFileHandler", 2, "renameFolder pdirKey" + Arrays.toString(paramArrayOfByte1) + " self key " + Arrays.toString(paramArrayOfByte2) + "\n new name" + paramString);
    }
    atgi.a().a(paramArrayOfByte1, paramArrayOfByte2, paramString, new atem(this, paramArrayOfByte1, paramArrayOfByte2, paramString));
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CloudFileHandler", 2, "copyFile pdirKey" + Arrays.toString(paramArrayOfByte1) + " self key " + Arrays.toString(paramArrayOfByte2) + "\n dst key" + paramArrayOfByte3 + "fileExistOpt" + paramInt);
    }
    atgi.a().a(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramInt, new atep(this, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramInt));
  }
  
  public FileManagerEntity b(FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("CloudFileHandler", 2, "insertCloud2OfflineEntity : entity is null, peerUin[" + ahav.kZ(paramString2) + "], peerType[" + paramInt1 + "]");
      }
      paramFileManagerEntity = null;
      return paramFileManagerEntity;
    }
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.copyFrom(paramFileManagerEntity);
    localFileManagerEntity.nSessionId = ahav.d().longValue();
    String str = aoon.a("", 0L, 0, true);
    long l = anbi.d(-1000).uniseq;
    localFileManagerEntity.uniseq = l;
    localFileManagerEntity.peerUin = paramString2;
    localFileManagerEntity.setCloudType(9);
    localFileManagerEntity.nOpType = 50;
    localFileManagerEntity.peerNick = ahav.a(this.app, paramString2, null, paramInt1);
    localFileManagerEntity.peerType = paramInt1;
    localFileManagerEntity.selfUin = this.app.getAccount();
    localFileManagerEntity.srvTime = (anaz.gQ() * 1000L);
    localFileManagerEntity.status = 2;
    localFileManagerEntity.msgSeq = ahav.bA();
    localFileManagerEntity.msgUid = ahav.ge();
    wte.a().i(l, 0L, paramInt2);
    this.app.a().jo(paramFileManagerEntity.nSessionId);
    this.app.a().s(localFileManagerEntity);
    paramFileManagerEntity = this.app.getAccount();
    if ((paramInt1 == 1004) || (paramInt1 == 1000)) {
      paramFileManagerEntity = paramString1;
    }
    for (;;)
    {
      this.app.a().a(paramString2, paramFileManagerEntity, true, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, true, paramInt1, str, localFileManagerEntity.msgSeq, localFileManagerEntity.msgSeq, null, 2, l, localFileManagerEntity.msgUid, -1L, anaz.gQ());
      paramFileManagerEntity = localFileManagerEntity;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("CloudFileHandler", 2, "insertWeiYun2OfflineEntity peerType[" + paramInt1 + "],FileManagerEntity:" + ahav.d(localFileManagerEntity));
      return localFileManagerEntity;
      if (paramInt1 == 1006)
      {
        localFileManagerEntity.tmpSessionFromPhone = paramString1;
        localFileManagerEntity.tmpSessionToPhone = paramString2;
        paramFileManagerEntity = paramString1;
      }
    }
  }
  
  public void b(FileManagerEntity paramFileManagerEntity, int paramInt, boolean paramBoolean)
  {
    int i = 3;
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("CloudFileHandler", 2, "sendCloudOfflineFile : entity is null");
      }
      return;
    }
    paramFileManagerEntity.status = 2;
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      paramFileManagerEntity.status = 0;
      paramFileManagerEntity.isReaded = false;
      this.app.a().dhl();
      this.app.a().b(false, 3, null);
      this.app.a().b(false, 101, new Object[] { Integer.valueOf(2), "", Long.valueOf(paramFileManagerEntity.nSessionId) });
      if (QLog.isColorLevel()) {
        QLog.i("CloudFileHandler", 2, "sendCloudOfflineFile : network error");
      }
      this.app.a().u(paramFileManagerEntity);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CloudFileHandler", 2, "sendCloudOfflineFile, peerUin[" + paramFileManagerEntity.peerUin + "] peerType[" + paramInt + "]],  fileName[" + paramFileManagerEntity.fileName + "], fileSize[" + paramFileManagerEntity.fileSize + "]");
    }
    paramFileManagerEntity.setfProgress(0.0F);
    Object localObject1 = (aizg)this.app.getManager(16);
    if ((localObject1 != null) && (((aizg)localObject1).nf(paramFileManagerEntity.peerUin)))
    {
      ahav.JI("该好友已被屏蔽！请先解除屏蔽！");
      paramFileManagerEntity.status = 0;
      this.app.a().dhl();
      this.app.a().b(false, 3, null);
      this.app.a().b(false, 101, new Object[] { Integer.valueOf(10), "", Long.valueOf(paramFileManagerEntity.nSessionId) });
      if (QLog.isColorLevel()) {
        QLog.i("CloudFileHandler", 2, "sendCloudOfflineFile : shield");
      }
      this.app.a().u(paramFileManagerEntity);
      return;
    }
    localObject1 = null;
    Object localObject2;
    if (paramFileManagerEntity.tmpSessionType > 0L)
    {
      localObject2 = new AirCopyExtInfo();
      paramFileManagerEntity.tmpSessionSig = ahav.a(this.app, paramFileManagerEntity.peerUin, (int)paramFileManagerEntity.tmpSessionType);
      if (paramFileManagerEntity.tmpSessionType == 102L) {
        ((AirCopyExtInfo)localObject2).phoneNum = paramFileManagerEntity.peerUin;
      }
      ((AirCopyExtInfo)localObject2).uinType = ((int)paramFileManagerEntity.tmpSessionType);
      localObject1 = localObject2;
      if (paramFileManagerEntity.tmpSessionSig != null)
      {
        localObject1 = localObject2;
        if (paramFileManagerEntity.tmpSessionSig.length > 0)
        {
          ((AirCopyExtInfo)localObject2).sig = new String(paramFileManagerEntity.tmpSessionSig);
          localObject1 = localObject2;
        }
      }
    }
    if ((paramFileManagerEntity.cloudId == null) || (paramFileManagerEntity.pDirKey == null) || (TextUtils.isEmpty(paramFileManagerEntity.fileName)))
    {
      if (QLog.isColorLevel())
      {
        if (paramFileManagerEntity.cloudId != null) {
          break label668;
        }
        localObject1 = "true";
        if (paramFileManagerEntity.pDirKey != null) {
          break label676;
        }
      }
      label668:
      label676:
      for (localObject2 = "true";; localObject2 = "false")
      {
        QLog.i("CloudFileHandler", 2, "sendCloudOfflineFile onFailed: cloudId is null[" + (String)localObject1 + "], pDirKey is null [" + (String)localObject2 + "],fileName is Null[" + TextUtils.isEmpty(paramFileManagerEntity.fileName) + "]");
        paramFileManagerEntity.status = 0;
        paramFileManagerEntity.isReaded = false;
        this.app.a().dhl();
        this.app.a().u(paramFileManagerEntity);
        this.app.a().o(paramFileManagerEntity.nSessionId, 1005);
        this.app.a().b(false, 101, new Object[] { Integer.valueOf(1), "", Long.valueOf(paramFileManagerEntity.nSessionId) });
        return;
        localObject1 = "false";
        break;
      }
    }
    if (paramInt == 3000) {
      i = 106;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CloudFileHandler", 2, "saveToFTNFromCloud, peerUin[" + paramFileManagerEntity.peerUin + "] peerType[" + i + "]],  fileName[" + paramFileManagerEntity.fileName + "], fileSize[" + paramFileManagerEntity.fileSize + "] , file sha [" + Arrays.toString(paramFileManagerEntity.cloudSha) + "], cloudID [" + Arrays.toString(paramFileManagerEntity.cloudId) + "], cloudParentId[" + Arrays.toString(paramFileManagerEntity.pDirKey) + "]");
    }
    atgi.a().airCopyToOtherBiz(paramFileManagerEntity.pDirKey, paramFileManagerEntity.cloudId, i, Long.parseLong(paramFileManagerEntity.peerUin), paramFileManagerEntity.fileSize, paramFileManagerEntity.cloudSha, paramFileManagerEntity.fileName, (AirCopyExtInfo)localObject1, new ateu(this, paramFileManagerEntity, paramInt));
    ahav.jR(paramFileManagerEntity.nSessionId);
  }
  
  public void b(FileManagerEntity paramFileManagerEntity, String paramString, int paramInt)
  {
    if (paramFileManagerEntity == null) {
      if (QLog.isColorLevel()) {
        QLog.e("CloudFileHandler", 2, "sendWeiYun2Troop : entity is null");
      }
    }
    TroopFileTransferManager localTroopFileTransferManager;
    int i;
    apcy localapcy;
    do
    {
      do
      {
        return;
        localTroopFileTransferManager = TroopFileTransferManager.a(this.app, Long.valueOf(paramString).longValue());
      } while (localTroopFileTransferManager == null);
      i = Math.abs(new Random().nextInt());
      localapcy = localTroopFileTransferManager.a(Arrays.toString(paramFileManagerEntity.cloudId), paramFileManagerEntity.fileName, paramFileManagerEntity.getFilePath(), paramFileManagerEntity.fileSize, 25, i, 8888L);
    } while (localapcy == null);
    int j = ahav.getFileType(localapcy.LocalFile);
    Object localObject;
    TroopFileTransferManager.Item localItem;
    if ((aueh.isFileExists(localapcy.LocalFile)) && ((j == 0) || (j == 2))) {
      if (j == 0)
      {
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
        BitmapFactory.decodeFile(localapcy.LocalFile, (BitmapFactory.Options)localObject);
        apsv.a(this.app, paramString, localapcy.FileName, localapcy.ProgressTotal, localapcy.Id.toString(), i, String.valueOf(localapcy.TroopUin), paramFileManagerEntity.nSessionId, ((BitmapFactory.Options)localObject).outWidth, ((BitmapFactory.Options)localObject).outHeight, 0, 0L, paramInt);
        localItem = localTroopFileTransferManager.a(localapcy.Id);
        if (localItem != null)
        {
          localItem.width = ((BitmapFactory.Options)localObject).outWidth;
          localItem.height = ((BitmapFactory.Options)localObject).outHeight;
        }
      }
    }
    for (;;)
    {
      if (aqiw.isNetSupport(BaseApplication.getContext())) {
        break label453;
      }
      paramFileManagerEntity.status = 0;
      paramFileManagerEntity.isReaded = false;
      localTroopFileTransferManager.a(localapcy.Id, -1, null, "当前网络不可用，请检查你的网络设置");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CloudFileHandler", 2, "sendWeiYun2Troop : network error");
      return;
      if (j == 2)
      {
        localObject = ShortVideoUtils.n(localapcy.LocalFile);
        apsv.a(this.app, paramString, localapcy.FileName, localapcy.ProgressTotal, localapcy.Id.toString(), i, String.valueOf(localapcy.TroopUin), paramFileManagerEntity.nSessionId, localObject[0], localObject[1], localObject[2], 0L, paramInt);
        localItem = localTroopFileTransferManager.a(localapcy.Id);
        if (localItem != null)
        {
          localItem.width = localObject[0];
          localItem.height = localObject[1];
          continue;
          apsv.a(this.app, paramString, paramFileManagerEntity.fileName, paramFileManagerEntity.fileSize, localapcy.Id.toString(), i, String.valueOf(8888L), paramFileManagerEntity.nSessionId, 0, 0, 0, 0L, paramInt);
        }
      }
    }
    label453:
    paramFileManagerEntity.setfProgress(0.0F);
    long l2 = 0L;
    try
    {
      l1 = Long.parseLong(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("CloudFileHandler", 2, "saveToFTNFromCloud, peerUin[" + l1 + "] peerType[" + 102 + "],fileName[" + paramFileManagerEntity.fileName + "], fileSize[" + paramFileManagerEntity.fileSize + "] , file sha [" + Arrays.toString(paramFileManagerEntity.cloudSha) + "], cloudID [" + Arrays.toString(paramFileManagerEntity.cloudId) + "], cloudParentId[" + Arrays.toString(paramFileManagerEntity.pDirKey) + "]");
      }
      paramString = null;
      if (paramFileManagerEntity.tmpSessionType > 0L)
      {
        localObject = new AirCopyExtInfo();
        paramFileManagerEntity.tmpSessionSig = ahav.a(this.app, paramFileManagerEntity.peerUin, (int)paramFileManagerEntity.tmpSessionType);
        if (paramFileManagerEntity.tmpSessionType == 102L) {
          ((AirCopyExtInfo)localObject).phoneNum = paramFileManagerEntity.peerUin;
        }
        ((AirCopyExtInfo)localObject).uinType = ((int)paramFileManagerEntity.tmpSessionType);
        paramString = (String)localObject;
        if (paramFileManagerEntity.tmpSessionSig != null)
        {
          paramString = (String)localObject;
          if (paramFileManagerEntity.tmpSessionSig.length > 0)
          {
            ((AirCopyExtInfo)localObject).sig = new String(paramFileManagerEntity.tmpSessionSig);
            paramString = (String)localObject;
          }
        }
      }
      if (paramFileManagerEntity.cloudSha == null)
      {
        atgi.a().getCloudItemById(paramFileManagerEntity.cloudId, new ater(this, paramFileManagerEntity, l1, paramString, localTroopFileTransferManager, localapcy));
        return;
      }
    }
    catch (NumberFormatException paramString)
    {
      long l1;
      for (;;)
      {
        l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.w("CloudFileHandler", 2, "number format failed!");
          l1 = l2;
        }
      }
      a(paramFileManagerEntity, l1, paramString, localTroopFileTransferManager, localapcy);
      this.app.a().jo(paramFileManagerEntity.nSessionId);
    }
  }
  
  public void b(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5)
  {
    CloudHistoryInfo localCloudHistoryInfo = new CloudHistoryInfo();
    localCloudHistoryInfo.fileName = paramString1;
    localCloudHistoryInfo.fileSize = paramLong;
    localCloudHistoryInfo.localPath = paramString5;
    localCloudHistoryInfo.fileType = ahav.hN(ahav.getFileType(paramString1));
    localCloudHistoryInfo.operateTime = System.currentTimeMillis();
    if (!TextUtils.isEmpty(paramString2))
    {
      localCloudHistoryInfo.fileIdBytes = paramString2.getBytes(Charset.forName("UTF-8"));
      if (TextUtils.isEmpty(paramString4)) {
        break label315;
      }
      localCloudHistoryInfo.fileSha = paramString4.getBytes(Charset.forName("UTF-8"));
      localCloudHistoryInfo.sourceType = 6;
      localCloudHistoryInfo.operateType = 4;
      paramString1 = new history_file_extension.FileExtension();
      paramString2 = new history_file_extension.WPSFileExtension();
      paramString2.str_preview_url.set(paramString3);
      paramString1.wps_file_extension.set(paramString2);
      localCloudHistoryInfo.fileExtInfo = paramString1.toByteArray();
      if (QLog.isColorLevel())
      {
        paramString1 = "";
        if (localCloudHistoryInfo.fileIdBytes != null) {
          paramString1 = new String(localCloudHistoryInfo.fileIdBytes, Charset.forName("UTF-8"));
        }
        QLog.i("CloudFileHandler", 1, "addNewRecentFileHistoryWithWPS. fileName[" + localCloudHistoryInfo.fileName + "] source[" + localCloudHistoryInfo.sourceType + "] localPath[" + localCloudHistoryInfo.localPath + "] fileId[" + paramString1 + "]");
      }
      atgi.a().a(localCloudHistoryInfo, new atfi(this));
    }
    label315:
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.i("CloudFileHandler<QFileCloud>", 1, "addNewRecentFileHistoryWithWPS error, wps fileId is null! url[" + paramString3 + "]");
      return;
    }
    QLog.i("CloudFileHandler<QFileCloud>", 1, "addNewRecentFileHistoryWithWPS error, wps sha is null! url[" + paramString3 + "]");
  }
  
  public void b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CloudFileHandler", 2, "renameFile pdirKey" + Arrays.toString(paramArrayOfByte1) + " self key " + Arrays.toString(paramArrayOfByte2) + "\n new name" + paramString);
    }
    atgi.a().b(paramArrayOfByte1, paramArrayOfByte2, paramString, new aten(this, paramArrayOfByte1, paramArrayOfByte2, paramString));
  }
  
  public void bF(Object paramObject)
  {
    if (paramObject == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    } while (!(paramObject instanceof FileManagerEntity));
    FileManagerEntity localFileManagerEntity1 = (FileManagerEntity)paramObject;
    Object localObject = localFileManagerEntity1.cloudFile;
    paramObject = localObject;
    if (localObject == null)
    {
      paramObject = athu.a(localFileManagerEntity1);
      localFileManagerEntity1.cloudFile = paramObject;
    }
    localObject = (atgc)localQQAppInterface.getManager(373);
    if (!localFileManagerEntity1.fromCloudFile)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CloudFileHandler", 2, "start download cloud file: recent, from aio.");
      }
      if (x(localFileManagerEntity1))
      {
        if ((!TextUtils.isEmpty(localFileManagerEntity1.strFilePath)) && (aueh.isFileExists(localFileManagerEntity1.strFilePath)))
        {
          QQToast.a(localQQAppInterface.getApplication(), 2, 2131690299, 0).show(aqcx.dip2px(localQQAppInterface.getApplication(), 44.0F));
          return;
        }
        localFileManagerEntity1.nOpType = -1;
        ((atgc)localObject).y(localFileManagerEntity1);
        atgi.a().startDownloadFile(paramObject.pLogicDirKey, paramObject.cloudId, acbn.bmg + paramObject.showName);
        return;
      }
      if ((!TextUtils.isEmpty(localFileManagerEntity1.strFilePath)) && (aueh.isFileExists(localFileManagerEntity1.strFilePath)))
      {
        QQToast.a(localQQAppInterface.getApplication(), 2, 2131690299, 0).show(aqcx.dip2px(localQQAppInterface.getApplication(), 44.0F));
        return;
      }
      ((atgc)localObject).y(localFileManagerEntity1);
      a(localQQAppInterface, localFileManagerEntity1, null);
      return;
    }
    if (Arrays.equals(localFileManagerEntity1.pDirKey, ((atgc)localObject).aF()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CloudFileHandler", 2, "start download cloud file: recent, from folder.");
      }
      FileManagerEntity localFileManagerEntity2 = localQQAppInterface.a().a(localFileManagerEntity1.cloudId);
      if ((localFileManagerEntity2 == null) || (x(localFileManagerEntity2)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("CloudFileHandler", 2, "aio recent file expired or entity null");
        }
        if ((aueh.isFileExists(localFileManagerEntity1.strFilePath)) || ((localFileManagerEntity1.cloudFile != null) && (!TextUtils.isEmpty(localFileManagerEntity1.cloudFile.finalPath)) && (aueh.isFileExists(localFileManagerEntity1.cloudFile.finalPath))))
        {
          QQToast.a(localQQAppInterface.getApplication(), 2, 2131690299, 0).show(aqcx.dip2px(localQQAppInterface.getApplication(), 44.0F));
          return;
        }
        localFileManagerEntity1.nOpType = -1;
        if (ahav.getFileType(localFileManagerEntity1.fileName) == 2)
        {
          ((atgc)localObject).y(localFileManagerEntity1);
          localFileManagerEntity1.nOpType = 8;
          localQQAppInterface.a().b(true, 3, null);
          return;
        }
        ((atgc)localObject).y(localFileManagerEntity1);
        atgi.a().startDownloadFile(paramObject.pLogicDirKey, paramObject.cloudId, acbn.bmg + paramObject.showName);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CloudFileHandler", 2, "aio recent file avaliable , downloadc2c");
      }
      if ((!TextUtils.isEmpty(localFileManagerEntity1.strFilePath)) && (aueh.isFileExists(localFileManagerEntity1.strFilePath)))
      {
        QQToast.a(localQQAppInterface.getApplication(), 2, 2131690299, 0).show(aqcx.dip2px(localQQAppInterface.getApplication(), 44.0F));
        return;
      }
      ((atgc)localObject).y(localFileManagerEntity2);
      a(localQQAppInterface, localFileManagerEntity2, localFileManagerEntity1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CloudFileHandler", 2, "start download cloud file: normal.");
    }
    if ((aueh.isFileExists(localFileManagerEntity1.strFilePath)) || ((localFileManagerEntity1.cloudFile != null) && (!TextUtils.isEmpty(localFileManagerEntity1.cloudFile.finalPath)) && (aueh.isFileExists(localFileManagerEntity1.cloudFile.finalPath))))
    {
      QQToast.a(localQQAppInterface.getApplication(), 2, 2131690299, 0).show(aqcx.dip2px(localQQAppInterface.getApplication(), 44.0F));
      return;
    }
    ((atgc)localObject).y(localFileManagerEntity1);
    atgi.a().startDownloadFile(paramObject.pLogicDirKey, paramObject.cloudId, acbn.bmg + paramObject.showName);
  }
  
  public void c(MessageForTroopFile paramMessageForTroopFile)
  {
    if ((paramMessageForTroopFile == null) || (TextUtils.isEmpty(paramMessageForTroopFile.url))) {
      return;
    }
    oidb_0x6d9.CopyToReqBody localCopyToReqBody = new oidb_0x6d9.CopyToReqBody();
    localCopyToReqBody.uint32_app_id.set(52);
    localCopyToReqBody.uint64_group_code.set(Long.parseLong(paramMessageForTroopFile.frienduin));
    localCopyToReqBody.uint64_dst_uin.set(this.app.getLongAccountUin());
    localCopyToReqBody.uint32_src_bus_id.set(paramMessageForTroopFile.bisID);
    localCopyToReqBody.str_src_file_id.set(paramMessageForTroopFile.url);
    localCopyToReqBody.uint32_dst_bus_id.set(77);
    atgc localatgc = (atgc)this.app.getManager(373);
    localCopyToReqBody.bytes_tim_cloud_pdir_key.set(ByteStringMicro.copyFrom(localatgc.aG()));
    localCopyToReqBody.bytes_tim_cloud_ppdir_key.set(ByteStringMicro.copyFrom(localatgc.aE()));
    Object localObject = new weiyun_lite_message.FileExtInfo();
    ((weiyun_lite_message.FileExtInfo)localObject).width.set(paramMessageForTroopFile.width);
    ((weiyun_lite_message.FileExtInfo)localObject).height.set(paramMessageForTroopFile.height);
    ((weiyun_lite_message.FileExtInfo)localObject).bool_ftn_to_qcloud_auto_req.set(false);
    localCopyToReqBody.bytes_tim_cloud_extension_info.set(ByteStringMicro.copyFrom(((weiyun_lite_message.FileExtInfo)localObject).toByteArray()));
    localCopyToReqBody.uint32_tim_file_exist_option.set(0);
    localObject = new oidb_0x6d9.ReqBody();
    ((oidb_0x6d9.ReqBody)localObject).copy_to_req.set(localCopyToReqBody);
    jnm.b(this.app, new atez(this, paramMessageForTroopFile, localatgc), ((oidb_0x6d9.ReqBody)localObject).toByteArray(), "OidbSvc.0x6d9_2", 1753, 2, null);
  }
  
  public void c(FileManagerEntity paramFileManagerEntity, boolean paramBoolean)
  {
    if ((paramFileManagerEntity == null) || (paramFileManagerEntity.peerType != 3000) || (paramFileManagerEntity.errCode == -6101) || (paramFileManagerEntity.errCode == 1091) || (paramFileManagerEntity.status == 16))
    {
      notifyUI(29, false, new Object[] { paramFileManagerEntity, Boolean.valueOf(paramBoolean), Integer.valueOf(-65535), "file is invaild" });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CloudFileHandler", 2, "copyFileToCloudDisc peerType:" + paramFileManagerEntity.peerType + " uuid:" + paramFileManagerEntity.Uuid);
    }
    SharedPreferences localSharedPreferences = this.app.getApplication().getSharedPreferences(this.app.getCurrentAccountUin(), 0);
    if ((((atgc)this.app.getManager(373)).aJe()) && (paramFileManagerEntity != null) && (!TextUtils.isEmpty(paramFileManagerEntity.Uuid)))
    {
      if (paramBoolean)
      {
        QLog.d("CloudFileHandler", 1, "copyFileToCloudDisc is manual, so copy to cloud");
        d(paramFileManagerEntity, paramBoolean);
        return;
      }
      if (localSharedPreferences.getBoolean("tim_cloudfile_autosave_flag", true))
      {
        QLog.d("CloudFileHandler", 1, "copyFileToCloudDisc autosaveflag is true");
        atgi.a().a(athu.a(this.app, paramFileManagerEntity), new atey(this, paramFileManagerEntity, paramBoolean));
        return;
      }
      QLog.d("CloudFileHandler", 1, "copyFileToCloudDisc autosaveflag is false");
      return;
    }
    notifyUI(29, false, new Object[] { paramFileManagerEntity, Boolean.valueOf(paramBoolean), Integer.valueOf(-255), "uuid is null" });
  }
  
  public void d(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    if (paramFileManagerEntity == null) {
      return;
    }
    if ((this.app.a().a(paramFileManagerEntity.cloudId) == null) || (x(paramFileManagerEntity))) {
      if (ahav.getFileType(paramFileManagerEntity.fileName) == 2) {
        if (paramFileManagerEntity.cloudType == 0) {
          this.app.a().js(paramFileManagerEntity.nSessionId);
        }
      }
    }
    label62:
    while (this.jdField_a_of_type_Ateh$a != null)
    {
      this.jdField_a_of_type_Ateh$a.a(paramFileManagerEntity, false, null);
      return;
      this.app.a().bZ(paramFileManagerEntity.nSessionId);
      paramFileManagerEntity.status = 3;
      continue;
      atgi.a().stopDownloadFile(paramFileManagerEntity.pDirKey, paramFileManagerEntity.cloudId, paramInt);
      paramFileManagerEntity.status = 3;
      continue;
      if (paramFileManagerEntity.cloudId != null) {
        break label217;
      }
      if (QLog.isColorLevel()) {
        QLog.i("CloudFileHandler", 2, paramFileManagerEntity.nSessionId + " doAIOCancel");
      }
      if (paramFileManagerEntity.cloudType != 0) {
        break label199;
      }
      this.app.a().js(paramFileManagerEntity.nSessionId);
      label190:
      break label239;
    }
    for (;;)
    {
      paramFileManagerEntity.status = 3;
      break label62;
      break;
      label199:
      this.app.a().bZ(paramFileManagerEntity.nSessionId);
      continue;
      label217:
      Iterator localIterator = ((atgc)this.app.getManager(373)).hh().iterator();
      label239:
      if (localIterator.hasNext())
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
        if ((localFileManagerEntity == null) || (localFileManagerEntity.cloudId == null) || (paramFileManagerEntity.cloudId == null) || (!Arrays.equals(localFileManagerEntity.cloudId, paramFileManagerEntity.cloudId))) {
          break label190;
        }
        if (QLog.isColorLevel()) {
          QLog.i("CloudFileHandler", 2, localFileManagerEntity.nSessionId + " doCancel");
        }
        if (paramFileManagerEntity.cloudType == 0) {
          this.app.a().js(localFileManagerEntity.nSessionId);
        } else {
          this.app.a().bZ(localFileManagerEntity.nSessionId);
        }
      }
    }
  }
  
  public void eto()
  {
    atfk localatfk = new atfk(this);
    atgi.a().c(localatfk);
  }
  
  public void f(byte[] paramArrayOfByte, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("CloudFileHandler", 2, "createFileFolder dirKey" + Arrays.toString(paramArrayOfByte) + " folderName:" + paramString);
    }
    atgi.a().a(paramArrayOfByte, paramString, new atfm(this, paramArrayOfByte));
  }
  
  public void g(List<CloudBase> paramList, int paramInt, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0) || (paramList.get(0) == null)) {
      return;
    }
    byte[] arrayOfByte = ((CloudBase)paramList.get(0)).pLogicDirKey;
    if (QLog.isColorLevel()) {
      QLog.d("CloudFileHandler", 2, "deleteFileFolder pdirKey" + Arrays.toString(arrayOfByte));
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      CloudBase localCloudBase = (CloudBase)localIterator.next();
      if (QLog.isDevelopLevel()) {
        QLog.d("CloudFileHandler", 2, "deleteFileFolder dirKey" + Arrays.toString(localCloudBase.cloudId));
      }
      BatchRequest localBatchRequest = new BatchRequest();
      localBatchRequest.pDirKey = localCloudBase.pLogicDirKey;
      localBatchRequest.cloudId = localCloudBase.cloudId;
      localBatchRequest.modelType = localCloudBase.type;
      localBatchRequest.fileName = localCloudBase.showName;
      localArrayList.add(localBatchRequest);
    }
    atgi.a().a(localArrayList, paramInt, new atel(this, arrayOfByte, paramList, paramInt, paramBoolean));
    anpc.report("tim_mine_tab_file_click_del_file");
  }
  
  public void kO(int paramInt1, int paramInt2)
  {
    Object localObject = new cmd0x346.RecvListQueryReq();
    ((cmd0x346.RecvListQueryReq)localObject).uint64_uin.set(this.app.getLongAccountUin());
    ((cmd0x346.RecvListQueryReq)localObject).uint32_begin_index.set(paramInt1);
    ((cmd0x346.RecvListQueryReq)localObject).uint32_req_count.set(paramInt2);
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    localReqBody.msg_recv_list_query_req.set((MessageMicro)localObject);
    localReqBody.uint32_cmd.set(100);
    localObject = localReqBody.uint32_seq;
    paramInt1 = cRe;
    cRe = paramInt1 + 1;
    ((PBUInt32Field)localObject).set(paramInt1);
    localReqBody.uint32_business_id.set(3);
    localReqBody.uint32_client_type.set(104);
    a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_RECV_LIST-100", localReqBody.toByteArray(), null, 30000, 3, 1);
  }
  
  public void kP(int paramInt1, int paramInt2)
  {
    Object localObject = new cmd0x346.SendListQueryReq();
    ((cmd0x346.SendListQueryReq)localObject).uint64_uin.set(this.app.getLongAccountUin());
    ((cmd0x346.SendListQueryReq)localObject).uint32_begin_index.set(paramInt1);
    ((cmd0x346.SendListQueryReq)localObject).uint32_req_count.set(paramInt2);
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    localReqBody.msg_send_list_query_req.set((MessageMicro)localObject);
    localReqBody.uint32_cmd.set(200);
    localObject = localReqBody.uint32_seq;
    paramInt1 = cRe;
    cRe = paramInt1 + 1;
    ((PBUInt32Field)localObject).set(paramInt1);
    localReqBody.uint32_business_id.set(3);
    localReqBody.uint32_client_type.set(104);
    a("OfflineFilleHandleSvr.pb_ftn_CMD_REQ_SEND_LIST-200", localReqBody.toByteArray(), null, 30000, 3, 1);
  }
  
  void l(byte[] paramArrayOfByte, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CloudFileHandler", 2, "sendCloudFileSDKRequest");
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("tim_qdisk_svr.req");
    localToServiceMsg.putWupBuffer(paramArrayOfByte);
    localToServiceMsg.extraData.putLong("callback", paramLong);
    sendPbReq(localToServiceMsg);
  }
  
  void lJ(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CloudFileHandler", 2, "handleCloudFileSDKResponse");
    }
    long l = paramToServiceMsg.extraData.getLong("callback", 0L);
    if (l != 0L) {
      atgi.a().recvResponse(paramFromServiceMsg.getResultCode(), (byte[])paramObject, l);
    }
  }
  
  protected Class<? extends acci> observerClass()
  {
    return atgd.class;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    atgi.c(this.jdField_a_of_type_ComTencentCloudfileCloudFileCallbackCenter);
    this.app.a().deleteObserver(this.jdField_a_of_type_Atsn);
    this.jdField_a_of_type_Ateh$a = null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("tim_qdisk_svr.req".equals(paramFromServiceMsg.getServiceCmd())) {
      lJ(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(FileManagerEntity paramFileManagerEntity, boolean paramBoolean, @Nullable String paramString);
    
    public abstract void onDownloadFailed(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ateh
 * JD-Core Version:    0.7.0.1
 */