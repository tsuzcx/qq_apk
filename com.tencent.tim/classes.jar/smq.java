import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
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
import com.tencent.mobileqq.troop.filemanager.TroopFileProtoReqMgr;
import com.tencent.mobileqq.troop.filemanager.TroopFileProtoReqMgr.b;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import msf.msgsvc.msg_ctrl.MsgCtrl;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.cs.group_file_common.group_file_common.FeedsInfo;
import tencent.im.cs.group_file_common.group_file_common.FeedsResult;
import tencent.im.cs.group_file_common.group_file_common.FileInfo;
import tencent.im.cs.group_file_common.group_file_common.FolderInfo;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.DeleteFileReqBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.DeleteFileRspBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.DownloadFileReqBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.DownloadFileRspBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.MoveFileReqBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.MoveFileRspBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.ReqBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.ResendReqBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.ResendRspBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.RspBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.UploadFileReqBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.UploadFileRspBody;
import tencent.im.oidb.cmd0x6d7.oidb_0x6d7.CreateFolderReqBody;
import tencent.im.oidb.cmd0x6d7.oidb_0x6d7.CreateFolderRspBody;
import tencent.im.oidb.cmd0x6d7.oidb_0x6d7.DeleteFolderReqBody;
import tencent.im.oidb.cmd0x6d7.oidb_0x6d7.DeleteFolderRspBody;
import tencent.im.oidb.cmd0x6d7.oidb_0x6d7.RenameFolderReqBody;
import tencent.im.oidb.cmd0x6d7.oidb_0x6d7.RenameFolderRspBody;
import tencent.im.oidb.cmd0x6d7.oidb_0x6d7.ReqBody;
import tencent.im.oidb.cmd0x6d7.oidb_0x6d7.RspBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.GetFileCountReqBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.GetFileCountRspBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.GetFileInfoReqBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.GetFileInfoRspBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.GetFileListReqBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.GetFileListRspBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.GetFileListRspBody.Item;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.GetFilePreviewReqBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.GetFilePreviewRspBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.GetSpaceReqBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.GetSpaceRspBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.ReqBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.RspBody;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9.CopyToReqBody;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9.CopyToRspBody;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9.FeedsReqBody;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9.FeedsRspBody;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9.ReqBody;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9.RspBody;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9.TransFileReqBody;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9.TransFileRspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class smq
{
  public static TroopFileProtoReqMgr.b a(QQAppInterface paramQQAppInterface, long paramLong, TroopFileTransferManager.Item paramItem, int paramInt, boolean paramBoolean1, boolean paramBoolean2, smq.m paramm)
  {
    if ((paramLong == 0L) || (paramItem == null)) {
      return null;
    }
    int i = ahav.getFileType(ahbj.getExtension(paramItem.FileName));
    oidb_0x6d6.DownloadFileReqBody localDownloadFileReqBody = new oidb_0x6d6.DownloadFileReqBody();
    localDownloadFileReqBody.uint32_bus_id.set(paramItem.BusId);
    localDownloadFileReqBody.uint32_app_id.set(3);
    localDownloadFileReqBody.uint64_group_code.set(paramLong);
    localDownloadFileReqBody.str_file_id.set(paramItem.FilePath);
    Object localObject = localDownloadFileReqBody.bool_thumbnail_req;
    boolean bool;
    if (paramInt != 0)
    {
      bool = true;
      ((PBBoolField)localObject).set(bool);
      localDownloadFileReqBody.bool_preview_req.set(paramBoolean1);
      if (i == 2)
      {
        if (!paramBoolean2) {
          break label250;
        }
        localDownloadFileReqBody.uint32_src.set(1);
        label127:
        if (paramInt == 0) {
          break label262;
        }
        localDownloadFileReqBody.bool_thumbnail_req.set(false);
        localDownloadFileReqBody.bool_preview_req.set(true);
      }
    }
    for (;;)
    {
      localDownloadFileReqBody.uint32_url_type.set(0);
      localObject = new Bundle();
      ((Bundle)localObject).putString("itemKey", paramItem.Id.toString());
      ((Bundle)localObject).putLong("troopUin", paramLong);
      ((Bundle)localObject).putInt("thumbNail", paramInt);
      ((Bundle)localObject).putBoolean("isPreview", paramBoolean1);
      paramItem = new oidb_0x6d6.ReqBody();
      paramItem.download_file_req.set(localDownloadFileReqBody);
      return a(paramQQAppInterface, paramm, paramItem.toByteArray(), "OidbSvc.0x6d6_2", 1750, 2, (Bundle)localObject);
      bool = false;
      break;
      label250:
      localDownloadFileReqBody.uint32_src.set(0);
      break label127;
      label262:
      localDownloadFileReqBody.bool_thumbnail_req.set(false);
      localDownloadFileReqBody.bool_preview_req.set(false);
    }
  }
  
  public static TroopFileProtoReqMgr.b a(QQAppInterface paramQQAppInterface, long paramLong, TroopFileTransferManager.Item paramItem, smq.o paramo)
  {
    if ((paramLong == 0L) || (paramItem == null)) {
      return null;
    }
    Object localObject = new oidb_0x6d6.ResendReqBody();
    ((oidb_0x6d6.ResendReqBody)localObject).uint32_bus_id.set(paramItem.BusId);
    ((oidb_0x6d6.ResendReqBody)localObject).uint32_app_id.set(3);
    ((oidb_0x6d6.ResendReqBody)localObject).uint64_group_code.set(paramLong);
    ((oidb_0x6d6.ResendReqBody)localObject).str_file_id.set(paramItem.FilePath);
    ((oidb_0x6d6.ResendReqBody)localObject).bytes_sha.set(ByteStringMicro.copyFrom(paramItem.Sha));
    oidb_0x6d6.ReqBody localReqBody = new oidb_0x6d6.ReqBody();
    localReqBody.resend_file_req.set((MessageMicro)localObject);
    localObject = new Bundle();
    ((Bundle)localObject).putString("itemKey", paramItem.Id.toString());
    ((Bundle)localObject).putLong("troopUin", paramLong);
    return a(paramQQAppInterface, paramo, localReqBody.toByteArray(), "OidbSvc.0x6d6_1", 1750, 1, (Bundle)localObject);
  }
  
  public static TroopFileProtoReqMgr.b a(QQAppInterface paramQQAppInterface, long paramLong, TroopFileTransferManager.Item paramItem, smq.q paramq)
  {
    if ((paramLong == 0L) || (paramItem == null)) {
      return null;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("itemKey", paramItem.Id.toString());
    localBundle.putLong("troopUin", paramLong);
    localBundle.putBoolean("bExtfTransfer", paramItem.bExtfTransfer);
    return a(paramQQAppInterface, paramLong, paramItem.FileName, paramItem.LocalFile, paramItem.ProgressTotal, paramItem.isFromAIO, paramItem.Md5, paramItem.Sha, paramItem.Sha3, paramItem.BusId, paramItem.mParentId, localBundle, paramq);
  }
  
  public static TroopFileProtoReqMgr.b a(QQAppInterface paramQQAppInterface, long paramLong, String paramString, int paramInt, smq.f paramf)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopFileProtocol", 4, "getFilePreviewList" + paramLong + ",filePath:" + paramString + ",busId:" + paramInt);
    }
    oidb_0x6d8.GetFilePreviewReqBody localGetFilePreviewReqBody = new oidb_0x6d8.GetFilePreviewReqBody();
    localGetFilePreviewReqBody.uint64_group_code.set(paramLong);
    localGetFilePreviewReqBody.uint32_app_id.set(3);
    localGetFilePreviewReqBody.uint32_bus_id.set(paramInt);
    localGetFilePreviewReqBody.str_file_id.set(paramString);
    paramString = new oidb_0x6d8.ReqBody();
    paramString.file_preview_req.set(localGetFilePreviewReqBody);
    return a(paramQQAppInterface, paramf, paramString.toByteArray(), "OidbSvc.0x6d8_4", 1752, 4, null);
  }
  
  public static TroopFileProtoReqMgr.b a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, String paramString2, long paramLong2, boolean paramBoolean, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString3, int paramInt, String paramString4, Bundle paramBundle, smq.q paramq)
  {
    oidb_0x6d6.UploadFileReqBody localUploadFileReqBody = new oidb_0x6d6.UploadFileReqBody();
    localUploadFileReqBody.uint32_bus_id.set(paramInt);
    localUploadFileReqBody.uint32_app_id.set(3);
    localUploadFileReqBody.uint64_group_code.set(paramLong1);
    localUploadFileReqBody.bytes_md5.set(ByteStringMicro.copyFrom(paramArrayOfByte1));
    localUploadFileReqBody.bytes_sha.set(ByteStringMicro.copyFrom(paramArrayOfByte2));
    if (paramString3 != null)
    {
      paramArrayOfByte1 = HexUtil.hexStr2Bytes(paramString3);
      localUploadFileReqBody.bytes_sha3.set(ByteStringMicro.copyFrom(paramArrayOfByte1));
    }
    if (TextUtils.isEmpty(paramString4))
    {
      localUploadFileReqBody.str_parent_folder_id.set("/");
      localUploadFileReqBody.str_file_name.set(paramString1);
      localUploadFileReqBody.str_local_path.set(paramString2);
      paramString1 = localUploadFileReqBody.uint32_entrance;
      if (!paramBoolean) {
        break label238;
      }
    }
    label238:
    for (paramInt = 5;; paramInt = 4)
    {
      paramString1.set(paramInt);
      localUploadFileReqBody.uint64_file_size.set(paramLong2);
      paramBoolean = false;
      if (paramBundle != null) {
        paramBoolean = paramBundle.getBoolean("bExtfTransfer", false);
      }
      if (paramBoolean) {
        localUploadFileReqBody.bool_support_multi_upload.set(true);
      }
      paramString1 = new oidb_0x6d6.ReqBody();
      paramString1.upload_file_req.set(localUploadFileReqBody);
      return a(paramQQAppInterface, paramq, paramString1.toByteArray(), "OidbSvc.0x6d6_0", 1750, 0, paramBundle);
      localUploadFileReqBody.str_parent_folder_id.set(paramString4);
      break;
    }
  }
  
  public static TroopFileProtoReqMgr.b a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, String paramString2, long paramLong2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt, String paramString3, Bundle paramBundle, smq.q paramq)
  {
    if (paramLong1 == 0L) {
      return null;
    }
    return a(paramQQAppInterface, paramLong1, paramString1, paramString2, paramLong2, true, paramArrayOfByte1, paramArrayOfByte2, null, paramInt, paramString3, paramBundle, paramq);
  }
  
  private static TroopFileProtoReqMgr.b a(QQAppInterface paramQQAppInterface, jnm.d paramd, byte[] paramArrayOfByte, String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(paramInt1);
    localOIDBSSOPkg.uint32_service_type.set(paramInt2);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    localOIDBSSOPkg.str_client_version.set(AppSetting.getVersion());
    paramArrayOfByte = new TroopFileProtoReqMgr.b();
    paramArrayOfByte.clW = paramString;
    paramArrayOfByte.fW = localOIDBSSOPkg.toByteArray();
    paramArrayOfByte.bo = paramBundle;
    paramArrayOfByte.c = paramd;
    paramQQAppInterface.getTroopFileProtoReqMgr().a(paramArrayOfByte);
    return paramArrayOfByte;
  }
  
  private static String a(TroopFileTransferManager.Item paramItem)
  {
    try
    {
      if (!ahwy.a().aom())
      {
        if (!QLog.isColorLevel()) {
          break label179;
        }
        QLog.i("IMG_FILE", 1, "choushane false!");
        break label179;
      }
      if (paramItem.strQRUrl != null) {
        return paramItem.strQRUrl;
      }
      Object localObject;
      if (rox.fileExistsAndNotEmpty(paramItem.middleThumbnailFile)) {
        localObject = new File(paramItem.middleThumbnailFile);
      }
      for (String str = "mid";; str = "larg")
      {
        localObject = ahwo.a(BaseApplicationImpl.getContext(), (File)localObject);
        if (localObject == null) {
          break label175;
        }
        paramItem.strQRUrl = ((StringBuilder)((Pair)localObject).first).toString();
        if (QLog.isDevelopLevel()) {
          QLog.i("IMG_FILE_QR", 1, "reqFeeds getImageUrl success:" + paramItem.strQRUrl + " use:" + str);
        }
        return paramItem.strQRUrl;
        if (!rox.fileExistsAndNotEmpty(paramItem.largeThumbnailFile)) {
          break;
        }
        localObject = new File(paramItem.largeThumbnailFile);
      }
      return null;
    }
    catch (Throwable paramItem) {}
    label175:
    return "";
    label179:
    return "";
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString, int paramInt6, long paramLong2, int paramInt7, ByteStringMicro paramByteStringMicro, smq.e parame)
  {
    boolean bool;
    oidb_0x6d8.GetFileListReqBody localGetFileListReqBody;
    if (paramInt7 == 0)
    {
      bool = true;
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopFileProtocol", 4, "getFileList" + paramLong1 + ",reqFor:" + paramInt2 + ",reqFrom:" + paramInt4 + ",count:" + paramInt3 + ",firstPage:" + bool);
      }
      localGetFileListReqBody = new oidb_0x6d8.GetFileListReqBody();
      localGetFileListReqBody.uint32_all_file_count.set(paramInt1);
      localGetFileListReqBody.uint32_file_count.set(paramInt3);
      localGetFileListReqBody.uint32_req_from.set(paramInt4);
      localGetFileListReqBody.uint64_group_code.set(paramLong1);
      localGetFileListReqBody.uint32_app_id.set(3);
      localGetFileListReqBody.str_folder_id.set(paramString);
      localGetFileListReqBody.uint32_sort_by.set(paramInt5);
      localGetFileListReqBody.uint32_filter_code.set(paramInt6);
      localGetFileListReqBody.uint64_uin.set(paramLong2);
      localGetFileListReqBody.uint32_start_index.set(paramInt7);
      if (paramByteStringMicro != null) {
        break label344;
      }
      localGetFileListReqBody.bytes_context.set(ByteStringMicro.copyFromUtf8(""));
      label210:
      if ((paramInt6 != 2) && (paramInt6 != 3)) {
        break label357;
      }
      localGetFileListReqBody.uint32_show_onlinedoc_folder.set(0);
    }
    for (;;)
    {
      paramByteStringMicro = new Bundle();
      paramByteStringMicro.putLong("troopUin", paramLong1);
      paramByteStringMicro.putInt("reqFor", paramInt2);
      paramByteStringMicro.putInt("reqFrom", paramInt4);
      paramByteStringMicro.putBoolean("isFirstPage", bool);
      paramByteStringMicro.putString("parentFileId", paramString);
      paramByteStringMicro.putLong("uin_filter", paramLong2);
      paramString = new oidb_0x6d8.ReqBody();
      paramString.file_list_info_req.set(localGetFileListReqBody);
      jnm.b(paramQQAppInterface, parame, paramString.toByteArray(), "OidbSvc.0x6d8_1", 1752, 1, paramByteStringMicro);
      return;
      bool = false;
      break;
      label344:
      localGetFileListReqBody.bytes_context.set(paramByteStringMicro);
      break label210;
      label357:
      localGetFileListReqBody.uint32_show_onlinedoc_folder.set(1);
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, Bundle paramBundle, msg_ctrl.MsgCtrl paramMsgCtrl, smq.n paramn)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("TroopFileProtocol", 1, "reqFeeds error.filePath is null ");
      return;
    }
    group_file_common.FeedsInfo localFeedsInfo = new group_file_common.FeedsInfo();
    localFeedsInfo.str_file_id.set(paramString);
    localFeedsInfo.uint32_bus_id.set(paramInt1);
    localFeedsInfo.uint32_msg_random.set(paramInt2);
    if (paramBoolean) {
      localFeedsInfo.uint32_feed_flag.set(1);
    }
    for (;;)
    {
      if (paramMsgCtrl != null) {
        localFeedsInfo.msg_ctrl.set(paramMsgCtrl);
      }
      try
      {
        paramString = new JSONObject();
        if (paramBundle.containsKey("yyb_apk_package_name_key")) {
          paramString.put("yyb_apk_package_name_key", paramBundle.getString("yyb_apk_package_name_key"));
        }
        if (paramBundle.containsKey("yyb_apk_name_key")) {
          paramString.put("yyb_apk_name_key", paramBundle.getString("yyb_apk_name_key"));
        }
        if (paramBundle.containsKey("yyb_apk_icon_url_key")) {
          paramString.put("yyb_apk_icon_url_key", paramBundle.getString("yyb_apk_icon_url_key"));
        }
        if ((paramInt3 != 0) && (paramInt4 != 0))
        {
          paramString.put("width", paramInt3);
          paramString.put("height", paramInt4);
          paramString.put("duration", paramInt5);
        }
        if (paramString.length() > 0) {
          localFeedsInfo.bytes_ext.set(ByteStringMicro.copyFromUtf8(paramString.toString()));
        }
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
      paramString = new oidb_0x6d9.FeedsReqBody();
      paramString.uint32_app_id.set(3);
      paramString.uint64_group_code.set(paramLong);
      paramString.rpt_feeds_info_list.add(localFeedsInfo);
      paramMsgCtrl = new oidb_0x6d9.ReqBody();
      paramMsgCtrl.feeds_info_req.set(paramString);
      jnm.b(paramQQAppInterface, paramn, paramMsgCtrl.toByteArray(), "OidbSvc.0x6d9_4", 1753, 4, paramBundle);
      return;
      localFeedsInfo.uint32_feed_flag.set(3);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, Bundle paramBundle, smq.n paramn)
  {
    a(paramQQAppInterface, paramLong, paramInt1, paramString, paramInt2, paramInt3, paramInt4, paramInt5, paramBoolean, paramBundle, null, paramn);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, int paramInt1, String paramString, long paramLong2, int paramInt2, Bundle paramBundle, smq.l paraml)
  {
    oidb_0x6d9.CopyToReqBody localCopyToReqBody = new oidb_0x6d9.CopyToReqBody();
    localCopyToReqBody.uint32_app_id.set(3);
    localCopyToReqBody.uint64_group_code.set(paramLong1);
    localCopyToReqBody.uint64_dst_uin.set(paramLong2);
    localCopyToReqBody.uint32_src_bus_id.set(paramInt1);
    localCopyToReqBody.str_src_file_id.set(paramString);
    localCopyToReqBody.uint32_dst_bus_id.set(paramInt2);
    paramString = new oidb_0x6d9.ReqBody();
    paramString.copy_to_req.set(localCopyToReqBody);
    jnm.b(paramQQAppInterface, paraml, paramString.toByteArray(), "OidbSvc.0x6d9_2", 1753, 2, paramBundle);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, smq.b paramb)
  {
    if ((paramLong == 0L) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    Object localObject = new oidb_0x6d6.DeleteFileReqBody();
    ((oidb_0x6d6.DeleteFileReqBody)localObject).uint32_bus_id.set(paramInt1);
    ((oidb_0x6d6.DeleteFileReqBody)localObject).str_file_id.set(paramString1);
    ((oidb_0x6d6.DeleteFileReqBody)localObject).uint32_app_id.set(3);
    ((oidb_0x6d6.DeleteFileReqBody)localObject).uint64_group_code.set(paramLong);
    ((oidb_0x6d6.DeleteFileReqBody)localObject).str_parent_folder_id.set(paramString2);
    if (paramInt2 != 0) {
      ((oidb_0x6d6.DeleteFileReqBody)localObject).uint32_msgdb_seq.set(paramInt2);
    }
    if (paramInt3 != 0) {
      ((oidb_0x6d6.DeleteFileReqBody)localObject).uint32_msg_rand.set(paramInt3);
    }
    paramString2 = new oidb_0x6d6.ReqBody();
    paramString2.delete_file_req.set((MessageMicro)localObject);
    localObject = new Bundle();
    ((Bundle)localObject).putString("fileId", paramString1);
    jnm.b(paramQQAppInterface, paramb, paramString2.toByteArray(), "OidbSvc.0x6d6_3", 1750, 3, (Bundle)localObject);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt, String paramString1, String paramString2, String paramString3, smq.i parami)
  {
    if ((paramLong == 0L) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {}
    while (paramString2.equals(paramString3)) {
      return;
    }
    oidb_0x6d6.MoveFileReqBody localMoveFileReqBody = new oidb_0x6d6.MoveFileReqBody();
    localMoveFileReqBody.uint32_bus_id.set(paramInt);
    localMoveFileReqBody.str_file_id.set(paramString1);
    localMoveFileReqBody.uint32_app_id.set(3);
    localMoveFileReqBody.uint64_group_code.set(paramLong);
    localMoveFileReqBody.str_parent_folder_id.set(paramString2);
    localMoveFileReqBody.str_dest_folder_id.set(paramString3);
    paramString1 = new oidb_0x6d6.ReqBody();
    paramString1.move_file_req.set(localMoveFileReqBody);
    jnm.b(paramQQAppInterface, parami, paramString1.toByteArray(), "OidbSvc.0x6d6_5", 1750, 5);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt, String paramString, smq.h paramh)
  {
    if ((paramQQAppInterface == null) || (paramLong == 0L) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    oidb_0x6d8.GetFileInfoReqBody localGetFileInfoReqBody = new oidb_0x6d8.GetFileInfoReqBody();
    localGetFileInfoReqBody.uint64_group_code.set(paramLong);
    localGetFileInfoReqBody.uint32_app_id.set(3);
    localGetFileInfoReqBody.uint32_bus_id.set(paramInt);
    localGetFileInfoReqBody.str_file_id.set(paramString);
    paramString = new oidb_0x6d8.ReqBody();
    paramString.file_info_req.set(localGetFileInfoReqBody);
    jnm.b(paramQQAppInterface, paramh, paramString.toByteArray(), "OidbSvc.0x6d8_0", 1752, 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, apbr paramapbr, smq.p paramp)
  {
    if ((paramLong == 0L) || (paramapbr == null)) {
      return;
    }
    oidb_0x6d9.TransFileReqBody localTransFileReqBody = new oidb_0x6d9.TransFileReqBody();
    localTransFileReqBody.uint32_app_id.set(3);
    localTransFileReqBody.uint64_group_code.set(paramLong);
    localTransFileReqBody.uint32_bus_id.set(paramapbr.dTg);
    localTransFileReqBody.str_file_id.set(paramapbr.mFileId);
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopUin", paramLong);
    localBundle.putString("fileId", paramapbr.mFileId);
    paramapbr = new oidb_0x6d9.ReqBody();
    paramapbr.trans_file_req.set(localTransFileReqBody);
    jnm.b(paramQQAppInterface, paramp, paramapbr.toByteArray(), "OidbSvc.0x6d9_0", 1753, 0, localBundle);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, TroopFileTransferManager.Item paramItem, smq.n paramn)
  {
    if ((paramLong == 0L) || (paramItem == null)) {
      return;
    }
    QLog.i("TroopFileProtocol", 1, "reqFeeds, waterTest.");
    Bundle localBundle = new Bundle();
    localBundle.putString("itemKey", paramItem.Id.toString());
    localBundle.putLong("troopUin", paramLong);
    localBundle.putString("fileId", paramItem.FilePath);
    QLog.i("TroopFileProtocol", 1, "reqFeeds, waterTest.pkgName[" + paramItem.yybApkPackageName + "]");
    if (!TextUtils.isEmpty(paramItem.yybApkPackageName)) {
      localBundle.putString("yyb_apk_package_name_key", paramItem.yybApkPackageName);
    }
    if (!TextUtils.isEmpty(paramItem.yybApkName)) {
      localBundle.putString("yyb_apk_name_key", paramItem.yybApkName);
    }
    if (!TextUtils.isEmpty(paramItem.yybApkIconUrl)) {
      localBundle.putString("yyb_apk_icon_url_key", paramItem.yybApkIconUrl);
    }
    Object localObject = a(paramItem);
    localObject = ahwo.a(paramItem.LocalFile, paramItem.width, paramItem.height, (String)localObject);
    a(paramQQAppInterface, paramLong, paramItem.BusId, paramItem.FilePath, paramItem.RandomNum, paramItem.width, paramItem.height, paramItem.duration, true, localBundle, (msg_ctrl.MsgCtrl)localObject, paramn);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, smq.a parama)
  {
    if ((paramLong == 0L) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    oidb_0x6d7.CreateFolderReqBody localCreateFolderReqBody = new oidb_0x6d7.CreateFolderReqBody();
    localCreateFolderReqBody.str_parent_folder_id.set(paramString1);
    localCreateFolderReqBody.str_folder_name.set(paramString2);
    localCreateFolderReqBody.uint32_app_id.set(3);
    localCreateFolderReqBody.uint64_group_code.set(paramLong);
    paramString1 = new oidb_0x6d7.ReqBody();
    paramString1.create_folder_req.set(localCreateFolderReqBody);
    jnm.b(paramQQAppInterface, parama, paramString1.toByteArray(), "OidbSvc.0x6d7_0", 1751, 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, smq.k paramk)
  {
    if ((paramLong == 0L) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    Object localObject = new oidb_0x6d7.RenameFolderReqBody();
    ((oidb_0x6d7.RenameFolderReqBody)localObject).str_folder_id.set(paramString1);
    ((oidb_0x6d7.RenameFolderReqBody)localObject).str_new_folder_name.set(paramString2);
    ((oidb_0x6d7.RenameFolderReqBody)localObject).uint32_app_id.set(3);
    ((oidb_0x6d7.RenameFolderReqBody)localObject).uint64_group_code.set(paramLong);
    oidb_0x6d7.ReqBody localReqBody = new oidb_0x6d7.ReqBody();
    localReqBody.rename_folder_req.set((MessageMicro)localObject);
    localObject = new Bundle();
    ((Bundle)localObject).putString("folderId", paramString1);
    ((Bundle)localObject).putString("folderName", paramString2);
    jnm.b(paramQQAppInterface, paramk, localReqBody.toByteArray(), "OidbSvc.0x6d7_2", 1751, 2, (Bundle)localObject);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString, smq.c paramc)
  {
    if ((paramLong == 0L) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    oidb_0x6d7.DeleteFolderReqBody localDeleteFolderReqBody = new oidb_0x6d7.DeleteFolderReqBody();
    localDeleteFolderReqBody.str_folder_id.set(paramString);
    localDeleteFolderReqBody.uint32_app_id.set(3);
    localDeleteFolderReqBody.uint64_group_code.set(paramLong);
    paramString = new oidb_0x6d7.ReqBody();
    paramString.delete_folder_req.set(localDeleteFolderReqBody);
    jnm.b(paramQQAppInterface, paramc, paramString.toByteArray(), "OidbSvc.0x6d7_1", 1751, 1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, smq.d paramd)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopFileProtocol", 4, "getFileList" + paramLong);
    }
    oidb_0x6d8.GetFileCountReqBody localGetFileCountReqBody = new oidb_0x6d8.GetFileCountReqBody();
    localGetFileCountReqBody.uint64_group_code.set(paramLong);
    localGetFileCountReqBody.uint32_app_id.set(3);
    localGetFileCountReqBody.uint32_bus_id.set(0);
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopUin", paramLong);
    oidb_0x6d8.ReqBody localReqBody = new oidb_0x6d8.ReqBody();
    localReqBody.group_file_cnt_req.set(localGetFileCountReqBody);
    jnm.b(paramQQAppInterface, paramd, localReqBody.toByteArray(), "OidbSvc.0x6d8_1", 1752, 2, localBundle);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, smq.g paramg)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopFileProtocol", 4, "getFileList" + paramLong);
    }
    oidb_0x6d8.GetSpaceReqBody localGetSpaceReqBody = new oidb_0x6d8.GetSpaceReqBody();
    localGetSpaceReqBody.uint64_group_code.set(paramLong);
    localGetSpaceReqBody.uint32_app_id.set(3);
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopUin", paramLong);
    oidb_0x6d8.ReqBody localReqBody = new oidb_0x6d8.ReqBody();
    localReqBody.group_space_req.set(localGetSpaceReqBody);
    jnm.a(paramQQAppInterface, paramg, localReqBody.toByteArray(), "OidbSvc.0x6d8_3", 1752, 3, localBundle);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, TroopFileProtoReqMgr.b paramb)
  {
    if ((paramQQAppInterface == null) || (paramb == null)) {
      return;
    }
    paramQQAppInterface.getTroopFileProtoReqMgr().b(paramb);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, FileManagerEntity paramFileManagerEntity, smq.j paramj)
  {
    paramString1 = new aprc("http://" + paramString1 + ":" + paramString2 + "/ftn_compress_list/rkey=" + paramString3 + "&filetype=" + paramInt + "&path=" + aurr.encodeUrl(paramString4) + "&", "GET", new smr(new ArrayList(), paramString4, paramFileManagerEntity, paramQQAppInterface, paramInt, paramj), 1000, null);
    paramString2 = new Bundle();
    paramString2.putString("version", aqgz.getQQVersion());
    paramString2.putString("Cookie", paramString5);
    paramString3 = new HashMap();
    paramString3.put("BUNDLE", paramString2);
    paramString3.put("CONTEXT", paramQQAppInterface.getApp().getApplicationContext());
    paramString1.J(paramString3);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, long paramLong1, TroopFileTransferManager.Item paramItem, long paramLong2, long paramLong3, smq.l paraml)
  {
    if ((paramLong1 == 0L) || (paramItem == null)) {
      return;
    }
    Object localObject = new oidb_0x6d9.CopyToReqBody();
    ((oidb_0x6d9.CopyToReqBody)localObject).uint32_app_id.set(3);
    if (paramBoolean) {
      ((oidb_0x6d9.CopyToReqBody)localObject).uint64_group_code.set(paramLong1);
    }
    for (;;)
    {
      ((oidb_0x6d9.CopyToReqBody)localObject).uint64_dst_uin.set(paramLong2);
      ((oidb_0x6d9.CopyToReqBody)localObject).uint32_src_bus_id.set(paramItem.ForwardBusId);
      if (!TextUtils.isEmpty(paramItem.ForwardPath)) {
        ((oidb_0x6d9.CopyToReqBody)localObject).str_src_file_id.set(paramItem.ForwardPath);
      }
      ((oidb_0x6d9.CopyToReqBody)localObject).uint32_dst_bus_id.set(paramItem.BusId);
      oidb_0x6d9.ReqBody localReqBody = new oidb_0x6d9.ReqBody();
      localReqBody.copy_to_req.set((MessageMicro)localObject);
      localObject = new Bundle();
      ((Bundle)localObject).putLong("troopUin", paramLong1);
      ((Bundle)localObject).putString("itemKey", paramItem.Id.toString());
      ((Bundle)localObject).putLong("sessionId", paramLong3);
      if (paramItem.BusId == 25) {
        awou.eEJ();
      }
      jnm.b(paramQQAppInterface, paraml, localReqBody.toByteArray(), "OidbSvc.0x6d9_2", 1753, 2, (Bundle)localObject);
      return;
      ((oidb_0x6d9.CopyToReqBody)localObject).uint64_group_code.set(paramItem.ForwardTroopuin);
    }
  }
  
  public static abstract class a
    extends jnm.d
  {
    public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
    {
      if (paramInt != 0)
      {
        a(false, paramInt, null);
        return;
      }
      paramBundle = new oidb_0x6d7.RspBody();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (oidb_0x6d7.CreateFolderRspBody)paramBundle.create_folder_rsp.get();
        if (!paramArrayOfByte.int32_ret_code.has()) {
          break label104;
        }
        if (paramArrayOfByte.int32_ret_code.get() == 0)
        {
          a(true, 0, new apbr((group_file_common.FolderInfo)paramArrayOfByte.folder_info.get()));
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        a(false, -1, null);
        return;
      }
      a(false, paramArrayOfByte.int32_ret_code.get(), null);
      return;
      label104:
      a(false, -1, null);
    }
    
    protected abstract void a(boolean paramBoolean, int paramInt, apbr paramapbr);
  }
  
  public static abstract class b
    extends jnm.d
  {
    public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
    {
      if (paramInt != 0)
      {
        a(false, paramInt, paramBundle, "", acfp.m(2131715728));
        return;
      }
      oidb_0x6d6.RspBody localRspBody = new oidb_0x6d6.RspBody();
      try
      {
        localRspBody.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (oidb_0x6d6.DeleteFileRspBody)localRspBody.delete_file_rsp.get();
        if (!paramArrayOfByte.int32_ret_code.has()) {
          break label133;
        }
        if (paramArrayOfByte.int32_ret_code.get() == 0)
        {
          a(true, 0, paramBundle, paramArrayOfByte.str_ret_msg.get(), paramArrayOfByte.str_client_wording.get());
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        a(false, -1, paramBundle, "", acfp.m(2131715724));
        return;
      }
      a(false, paramArrayOfByte.int32_ret_code.get(), paramBundle, paramArrayOfByte.str_ret_msg.get(), paramArrayOfByte.str_client_wording.get());
      return;
      label133:
      a(false, -1, paramBundle, "", acfp.m(2131715732));
    }
    
    protected abstract void a(boolean paramBoolean, int paramInt, Bundle paramBundle, String paramString1, String paramString2);
  }
  
  public static abstract class c
    extends jnm.d
  {
    public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
    {
      if (paramInt != 0)
      {
        ai(false, paramInt);
        return;
      }
      paramBundle = new oidb_0x6d7.RspBody();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (oidb_0x6d7.DeleteFolderRspBody)paramBundle.delete_folder_rsp.get();
        if (!paramArrayOfByte.int32_ret_code.has()) {
          break label84;
        }
        if (paramArrayOfByte.int32_ret_code.get() == 0)
        {
          ai(true, 0);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        ai(false, -1);
        return;
      }
      ai(false, paramArrayOfByte.int32_ret_code.get());
      return;
      label84:
      ai(false, -1);
    }
    
    protected abstract void ai(boolean paramBoolean, int paramInt);
  }
  
  public static abstract class d
    extends jnm.d
  {
    public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
    {
      if ((paramInt != 0) || (paramArrayOfByte == null))
      {
        a(false, false, 0, 0, 0);
        return;
      }
      paramBundle = new oidb_0x6d8.RspBody();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        if (!paramBundle.group_file_cnt_rsp.has())
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopFileProtocol", 2, "no group_file_cnt_rsp rsp.");
          }
          a(false, false, 0, 0, 0);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        a(false, false, 0, 0, 0);
        return;
      }
      paramArrayOfByte = (oidb_0x6d8.GetFileCountRspBody)paramBundle.group_file_cnt_rsp.get();
      a(true, paramArrayOfByte.bool_file_too_many.get(), paramArrayOfByte.uint32_all_file_count.get(), paramArrayOfByte.uint32_limit_count.get(), paramInt);
    }
    
    public abstract void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3);
  }
  
  public static abstract class e
    extends jnm.d
  {
    public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
    {
      if ((paramInt != 0) || (paramArrayOfByte == null))
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder().append("GetFileListObserver, errorCode=").append(paramInt).append(", has data=");
          if (paramArrayOfByte == null) {
            break label73;
          }
        }
        label73:
        for (bool = true;; bool = false)
        {
          QLog.i("TroopFileProtocol", 2, bool);
          a(false, false, 0, 0, 0, null, null, paramBundle);
          return;
        }
      }
      Object localObject1 = new oidb_0x6d8.RspBody();
      try
      {
        ((oidb_0x6d8.RspBody)localObject1).mergeFrom(paramArrayOfByte);
        if (!((oidb_0x6d8.RspBody)localObject1).file_list_info_rsp.has())
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopFileProtocol", 2, "no FileList rsp.");
          }
          a(false, false, 0, 0, 0, null, null, paramBundle);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopFileProtocol", 2, "merge data exception," + paramArrayOfByte.toString());
        }
        a(false, false, 0, 0, 0, null, null, paramBundle);
        return;
      }
      localObject1 = (oidb_0x6d8.GetFileListRspBody)((oidb_0x6d8.RspBody)localObject1).file_list_info_rsp.get();
      if (((oidb_0x6d8.GetFileListRspBody)localObject1).int32_ret_code.has())
      {
        i = ((oidb_0x6d8.GetFileListRspBody)localObject1).int32_ret_code.get();
        if (QLog.isColorLevel()) {
          QLog.i("TroopFileProtocol", 2, "GetFileListObserver, retCode=" + i);
        }
        if (i < 0)
        {
          if (i == -1000)
          {
            a(true, false, 0, i, 0, null, null, paramBundle);
            return;
          }
          a(false, false, 0, 0, 0, null, null, paramBundle);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopFileProtocol", 2, "GetFileListObserver, has not redCode");
        }
        a(false, false, 0, 0, 0, null, null, paramBundle);
        return;
      }
      int i = ((oidb_0x6d8.GetFileListRspBody)localObject1).uint32_all_file_count.get();
      boolean bool = ((oidb_0x6d8.GetFileListRspBody)localObject1).bool_is_end.get();
      int j = ((oidb_0x6d8.GetFileListRspBody)localObject1).uint32_next_index.get();
      paramArrayOfByte = ((oidb_0x6d8.GetFileListRspBody)localObject1).bytes_context.get();
      Object localObject2 = ((oidb_0x6d8.GetFileListRspBody)localObject1).rpt_item_list.get();
      localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject1).add(new apbr((oidb_0x6d8.GetFileListRspBody.Item)((Iterator)localObject2).next()));
      }
      a(true, bool, i, paramInt, j, paramArrayOfByte, (List)localObject1, paramBundle);
    }
    
    public abstract void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, ByteStringMicro paramByteStringMicro, List<apbr> paramList, Bundle paramBundle);
  }
  
  public static abstract class f
    extends jnm.d
  {
    public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
    {
      if ((paramInt != 0) || (paramArrayOfByte == null))
      {
        a(false, paramInt, null, null, 0, 0, null, null, null, null, paramBundle);
        return;
      }
      Object localObject = new oidb_0x6d8.RspBody();
      try
      {
        ((oidb_0x6d8.RspBody)localObject).mergeFrom(paramArrayOfByte);
        localObject.toString();
        if (((oidb_0x6d8.RspBody)localObject).file_preview_rsp.has()) {
          break label106;
        }
        if (QLog.isColorLevel()) {
          QLog.d("TroopFileProtocol", 2, "no file_preview rsp.");
        }
        a(false, paramInt, null, null, 0, 0, null, null, null, null, paramBundle);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte = paramBundle;
      }
      a(false, paramInt, null, null, 0, 0, null, null, null, null, paramArrayOfByte);
      return;
      label106:
      paramArrayOfByte = (oidb_0x6d8.GetFilePreviewRspBody)((oidb_0x6d8.RspBody)localObject).file_preview_rsp.get();
      if (!paramArrayOfByte.bytes_download_url.has())
      {
        a(false, paramInt, null, null, 0, 0, null, null, null, null, paramBundle);
        return;
      }
      int i = paramArrayOfByte.int32_ret_code.get();
      localObject = paramArrayOfByte.str_ret_msg.get();
      String str1 = paramArrayOfByte.str_client_wording.get();
      int j = paramArrayOfByte.int32_server_ip.get();
      int k = paramArrayOfByte.int32_server_port.get();
      String str2 = paramArrayOfByte.str_download_dns.get();
      ByteStringMicro localByteStringMicro1 = paramArrayOfByte.bytes_download_url.get();
      ByteStringMicro localByteStringMicro2 = paramArrayOfByte.bytes_reserved_field.get();
      String str3 = paramArrayOfByte.str_cookie_val.get();
      paramArrayOfByte.str_download_dns_https.get().toStringUtf8();
      paramArrayOfByte.uint32_preview_port_https.get();
      if (paramBundle == null) {}
      for (paramArrayOfByte = new Bundle();; paramArrayOfByte = paramBundle)
      {
        try
        {
          if (!TextUtils.isEmpty(str2))
          {
            paramArrayOfByte.putString("strHttpsDomain", str2);
            paramArrayOfByte.putInt("httpsPort", 443);
          }
          a(true, i, (String)localObject, str1, j, k, str2, localByteStringMicro1, str3, localByteStringMicro2, paramArrayOfByte);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramBundle) {}
        break;
      }
    }
    
    public abstract void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, ByteStringMicro paramByteStringMicro1, String paramString4, ByteStringMicro paramByteStringMicro2, Bundle paramBundle);
  }
  
  public static abstract class g
    extends jnm.d
  {
    public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
    {
      if ((paramInt != 0) || (paramArrayOfByte == null))
      {
        a(false, 0L, 0L, 0);
        return;
      }
      paramBundle = new oidb_0x6d8.RspBody();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        if (!paramBundle.group_space_rsp.has())
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopFileProtocol", 2, "no group_space_rsp rsp.");
          }
          a(false, 0L, 0L, 0);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        a(false, 0L, 0L, 0);
        return;
      }
      paramArrayOfByte = (oidb_0x6d8.GetSpaceRspBody)paramBundle.group_space_rsp.get();
      a(true, paramArrayOfByte.uint64_total_space.get(), paramArrayOfByte.uint64_used_space.get(), paramInt);
    }
    
    public abstract void a(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt);
  }
  
  public static abstract class h
    extends jnm.d
  {
    public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
    {
      if (paramInt != 0) {
        a(false, paramInt, null);
      }
      label103:
      do
      {
        for (;;)
        {
          return;
          paramBundle = new oidb_0x6d8.RspBody();
          try
          {
            paramBundle.mergeFrom(paramArrayOfByte);
            paramArrayOfByte = (oidb_0x6d8.GetFileInfoRspBody)paramBundle.file_info_rsp.get();
            if (!paramArrayOfByte.int32_ret_code.has()) {
              break label103;
            }
            if (paramArrayOfByte.int32_ret_code.get() == 0)
            {
              paramArrayOfByte = (group_file_common.FileInfo)paramArrayOfByte.file_info.get();
              if (paramArrayOfByte == null) {
                continue;
              }
              a(true, 0, paramArrayOfByte);
            }
          }
          catch (InvalidProtocolBufferMicroException paramArrayOfByte)
          {
            a(false, -1, null);
            return;
          }
        }
        a(false, paramArrayOfByte.int32_ret_code.get(), null);
        return;
        if (!paramArrayOfByte.file_info.has()) {
          break;
        }
        paramArrayOfByte = (group_file_common.FileInfo)paramArrayOfByte.file_info.get();
      } while (paramArrayOfByte == null);
      a(true, 0, paramArrayOfByte);
      return;
      a(false, -1, null);
    }
    
    protected abstract void a(boolean paramBoolean, int paramInt, group_file_common.FileInfo paramFileInfo);
  }
  
  public static abstract class i
    extends jnm.d
  {
    public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
    {
      if (paramInt != 0)
      {
        e(false, paramInt, null);
        return;
      }
      paramBundle = new oidb_0x6d6.RspBody();
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (oidb_0x6d6.MoveFileRspBody)paramBundle.move_file_rsp.get();
        if (!paramArrayOfByte.int32_ret_code.has()) {
          break label94;
        }
        if (paramArrayOfByte.int32_ret_code.get() == 0)
        {
          e(true, 0, paramArrayOfByte.str_parent_folder_id.get());
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        e(false, -1, null);
        return;
      }
      e(false, paramArrayOfByte.int32_ret_code.get(), null);
      return;
      label94:
      e(false, -1, null);
    }
    
    protected abstract void e(boolean paramBoolean, int paramInt, String paramString);
  }
  
  public static abstract interface j
  {
    public abstract void fe(List<agxi.a> paramList);
  }
  
  public static abstract class k
    extends jnm.d
  {
    public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
    {
      String str;
      if (paramBundle != null) {
        str = paramBundle.getString("folderId");
      }
      for (paramBundle = paramBundle.getString("folderName");; paramBundle = "")
      {
        if (paramInt != 0)
        {
          b(false, paramInt, str, paramBundle);
          return;
        }
        oidb_0x6d7.RspBody localRspBody = new oidb_0x6d7.RspBody();
        try
        {
          localRspBody.mergeFrom(paramArrayOfByte);
          paramArrayOfByte = (oidb_0x6d7.RenameFolderRspBody)localRspBody.rename_folder_rsp.get();
          if (!paramArrayOfByte.int32_ret_code.has()) {
            break label118;
          }
          if (paramArrayOfByte.int32_ret_code.get() == 0)
          {
            b(true, 0, str, paramBundle);
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          b(false, -1, str, paramBundle);
          return;
        }
        b(false, paramArrayOfByte.int32_ret_code.get(), str, paramBundle);
        return;
        label118:
        b(false, -1, str, paramBundle);
        return;
        str = "";
      }
    }
    
    protected abstract void b(boolean paramBoolean, int paramInt, String paramString1, String paramString2);
  }
  
  public static abstract class l
    extends jnm.d
  {
    public l()
    {
      super();
    }
    
    public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
    {
      int i = 102;
      if (paramInt != 0)
      {
        a(false, paramInt, 102, null, null, null, paramBundle);
        return;
      }
      Object localObject = new oidb_0x6d9.RspBody();
      try
      {
        ((oidb_0x6d9.RspBody)localObject).mergeFrom(paramArrayOfByte);
        if (!((oidb_0x6d9.RspBody)localObject).copy_to_rsp.has())
        {
          a(false, paramInt, 102, null, null, null, paramBundle);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        a(false, paramInt, 102, null, null, null, paramBundle);
        return;
      }
      paramArrayOfByte = (oidb_0x6d9.CopyToRspBody)((oidb_0x6d9.RspBody)localObject).copy_to_rsp.get();
      if (!paramArrayOfByte.int32_ret_code.has())
      {
        a(false, paramInt, 102, null, null, null, paramBundle);
        return;
      }
      int j = paramArrayOfByte.int32_ret_code.get();
      localObject = paramArrayOfByte.str_client_wording.get();
      String str1 = paramArrayOfByte.str_ret_msg.get();
      String str2 = paramArrayOfByte.str_save_file_path.get();
      paramInt = i;
      if (paramArrayOfByte.uint32_bus_id.has()) {
        paramInt = paramArrayOfByte.uint32_bus_id.get();
      }
      a(true, j, paramInt, str2, str1, (String)localObject, paramBundle);
    }
    
    public abstract void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, Bundle paramBundle);
  }
  
  public static abstract class m
    extends jnm.d
  {
    public m()
    {
      super();
    }
    
    public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
    {
      if (paramInt != 0)
      {
        a(false, paramInt, null, paramBundle);
        return;
      }
      oidb_0x6d6.RspBody localRspBody = new oidb_0x6d6.RspBody();
      try
      {
        localRspBody.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (oidb_0x6d6.DownloadFileRspBody)localRspBody.download_file_rsp.get();
        if (paramArrayOfByte.int32_ret_code.has())
        {
          a(true, 0, paramArrayOfByte, paramBundle);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        a(false, -1, null, paramBundle);
        return;
      }
      a(false, -1, null, paramBundle);
    }
    
    public abstract void a(boolean paramBoolean, int paramInt, oidb_0x6d6.DownloadFileRspBody paramDownloadFileRspBody, Bundle paramBundle);
  }
  
  public static abstract class n
    extends jnm.d
  {
    public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
    {
      int j = 102;
      if (paramInt != 0)
      {
        a(false, paramInt, "", 102, 0, paramBundle);
        return;
      }
      Object localObject = new oidb_0x6d9.RspBody();
      int k;
      try
      {
        ((oidb_0x6d9.RspBody)localObject).mergeFrom(paramArrayOfByte);
        if (!((oidb_0x6d9.RspBody)localObject).feeds_info_rsp.has())
        {
          a(false, paramInt, "", 102, 0, paramBundle);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        for (;;)
        {
          a(false, paramInt, "", 102, 0, paramBundle);
        }
        localObject = (oidb_0x6d9.FeedsRspBody)((oidb_0x6d9.RspBody)localObject).feeds_info_rsp.get();
        if (!((oidb_0x6d9.FeedsRspBody)localObject).int32_ret_code.has())
        {
          a(false, paramInt, "", 102, 0, paramBundle);
          return;
        }
        k = ((oidb_0x6d9.FeedsRspBody)localObject).int32_ret_code.get();
        paramArrayOfByte = ((oidb_0x6d9.FeedsRspBody)localObject).str_client_wording.get();
        i = j;
        if (!((oidb_0x6d9.FeedsRspBody)localObject).rpt_feeds_result_list.has()) {
          break label236;
        }
      }
      localObject = (group_file_common.FeedsResult)((oidb_0x6d9.FeedsRspBody)localObject).rpt_feeds_result_list.get().get(0);
      int i = j;
      if (localObject != null)
      {
        paramInt = j;
        if (((group_file_common.FeedsResult)localObject).uint32_bus_id.has()) {
          paramInt = ((group_file_common.FeedsResult)localObject).uint32_bus_id.get();
        }
        i = paramInt;
        if (!((group_file_common.FeedsResult)localObject).uint32_dead_time.has()) {}
      }
      for (i = ((group_file_common.FeedsResult)localObject).uint32_dead_time.get();; i = j)
      {
        a(true, k, paramArrayOfByte, paramInt, i, paramBundle);
        return;
        label236:
        j = 0;
        paramInt = i;
      }
    }
    
    public abstract void a(boolean paramBoolean, int paramInt1, String paramString, int paramInt2, int paramInt3, Bundle paramBundle);
  }
  
  public static abstract class o
    extends jnm.d
  {
    public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
    {
      if (paramInt != 0)
      {
        a(false, paramInt, null, paramBundle);
        return;
      }
      oidb_0x6d6.RspBody localRspBody = new oidb_0x6d6.RspBody();
      try
      {
        localRspBody.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (oidb_0x6d6.ResendRspBody)localRspBody.resend_file_rsp.get();
        if (paramArrayOfByte.int32_ret_code.has())
        {
          a(true, 0, paramArrayOfByte, paramBundle);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        a(false, -1, null, paramBundle);
        return;
      }
      a(false, -1, null, paramBundle);
    }
    
    public abstract void a(boolean paramBoolean, int paramInt, oidb_0x6d6.ResendRspBody paramResendRspBody, Bundle paramBundle);
  }
  
  public static abstract class p
    extends jnm.d
  {
    public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
    {
      if (paramInt != 0)
      {
        a(false, paramInt, null, paramBundle);
        return;
      }
      oidb_0x6d9.RspBody localRspBody = new oidb_0x6d9.RspBody();
      try
      {
        localRspBody.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (oidb_0x6d9.TransFileRspBody)localRspBody.trans_file_rsp.get();
        if (paramArrayOfByte.int32_ret_code.has())
        {
          a(true, 0, paramArrayOfByte, paramBundle);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        a(false, -1, null, paramBundle);
        return;
      }
      a(false, -1, null, paramBundle);
    }
    
    public abstract void a(boolean paramBoolean, int paramInt, oidb_0x6d9.TransFileRspBody paramTransFileRspBody, Bundle paramBundle);
  }
  
  public static abstract class q
    extends jnm.d
  {
    public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
    {
      if (paramInt != 0)
      {
        a(false, paramInt, null, paramBundle);
        return;
      }
      oidb_0x6d6.RspBody localRspBody = new oidb_0x6d6.RspBody();
      try
      {
        localRspBody.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (oidb_0x6d6.UploadFileRspBody)localRspBody.upload_file_rsp.get();
        if (paramArrayOfByte.int32_ret_code.has())
        {
          a(true, 0, paramArrayOfByte, paramBundle);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        a(false, -1, null, paramBundle);
        return;
      }
      a(false, -1, null, paramBundle);
    }
    
    public abstract void a(boolean paramBoolean, int paramInt, oidb_0x6d6.UploadFileRspBody paramUploadFileRspBody, Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     smq
 * JD-Core Version:    0.7.0.1
 */