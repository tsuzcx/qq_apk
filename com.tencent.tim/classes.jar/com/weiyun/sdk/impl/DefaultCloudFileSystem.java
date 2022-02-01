package com.weiyun.sdk.impl;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.weiyun.sdk.IWyCloudFileSystem;
import com.weiyun.sdk.IWyFileSystem.CommonFtnFile;
import com.weiyun.sdk.IWyFileSystem.IWyCallback;
import com.weiyun.sdk.IWyFileSystem.ListFiles;
import com.weiyun.sdk.IWyFileSystem.ListOfflineFile;
import com.weiyun.sdk.IWyFileSystem.PreviewAdderss;
import com.weiyun.sdk.IWyFileSystem.WyCommand;
import com.weiyun.sdk.channel.ISender;
import com.weiyun.sdk.context.SdkContext;
import com.weiyun.sdk.context.SdkContext.IndependentPasswordContext;
import com.weiyun.sdk.data.WyCategoryInfo;
import com.weiyun.sdk.data.WyOfflineFileInfo;
import com.weiyun.sdk.util.HashSumCalc;
import com.weiyun.sdk.util.Utils;
import com.weiyun.sdk.util.UtilsMisc;
import java.util.Comparator;
import java.util.List;
import tencent.im.cs.cmd0x31b.Cmd0X31B.DeleteFileReqBody;
import tencent.im.cs.cmd0x31b.Cmd0X31B.ExtensionReq;
import tencent.im.cs.cmd0x31b.Cmd0X31B.FilePreviewReqBody;
import tencent.im.cs.cmd0x31b.Cmd0X31B.GetLibListReqBody;
import tencent.im.cs.cmd0x31b.Cmd0X31B.GetLibTypeReqBody;
import tencent.im.cs.cmd0x31b.Cmd0X31B.GetOfflineFileReqBody;
import tencent.im.cs.cmd0x31b.Cmd0X31B.QCloud2FtnReqBody;
import tencent.im.cs.cmd0x31b.Cmd0X31B.QueryPwdReqBody;
import tencent.im.cs.cmd0x31b.Cmd0X31B.ReqBody;
import tencent.im.cs.cmd0x31b.Cmd0X31B.StoreFilePreviewReqBody;
import tencent.im.cs.cmd0x31b.Cmd0X31B.VerifyPwdReqBody;

public class DefaultCloudFileSystem
  implements IWyCloudFileSystem
{
  private Cmd0X31B.ReqBody newReqBody(int paramInt)
  {
    Cmd0X31B.ReqBody localReqBody = new Cmd0X31B.ReqBody();
    localReqBody.uint32_sub_cmd.set(paramInt);
    localReqBody.str_app_id.set("30223");
    return localReqBody;
  }
  
  public IWyFileSystem.WyCommand deleteWyFile(String paramString, int paramInt, IWyFileSystem.IWyCallback<Void> paramIWyCallback)
  {
    UtilsMisc.checkNotNull(paramString);
    UtilsMisc.checkNotNull(paramIWyCallback);
    Cmd0X31B.DeleteFileReqBody localDeleteFileReqBody = new Cmd0X31B.DeleteFileReqBody();
    localDeleteFileReqBody.str_file_id.set(paramString);
    localDeleteFileReqBody.uint32_file_resource.set(paramInt);
    paramString = newReqBody(7);
    paramString.msg_delete_file_req_body.set(localDeleteFileReqBody);
    paramIWyCallback = new WyCommandImpl(paramIWyCallback);
    SdkContext.getInstance().getSender().sendRequest("OfflineFilleHandleSvr.pb_weiyun_CMD_REQ_DELETE_FILE-7", paramString.toByteArray(), new DefaultCloudFileSystem.5(this, paramIWyCallback));
    return paramIWyCallback;
  }
  
  public IWyFileSystem.WyCommand getPreviewAddress(String paramString, IWyFileSystem.IWyCallback<IWyFileSystem.PreviewAdderss> paramIWyCallback)
  {
    UtilsMisc.checkNotNull(paramString);
    UtilsMisc.checkNotNull(paramIWyCallback);
    Cmd0X31B.StoreFilePreviewReqBody localStoreFilePreviewReqBody = new Cmd0X31B.StoreFilePreviewReqBody();
    localStoreFilePreviewReqBody.file_id.set(paramString);
    paramString = newReqBody(19);
    paramString.msg_storefilepreview_req_body.set(localStoreFilePreviewReqBody);
    paramIWyCallback = new WyCommandImpl(paramIWyCallback);
    SdkContext.getInstance().getSender().sendRequest("OfflineFilleHandleSvr.pb_weiyun_CMD_REQ_STORE_FILE_PREVIEW-19", paramString.toByteArray(), new DefaultCloudFileSystem.9(this, paramIWyCallback));
    return paramIWyCallback;
  }
  
  public IWyFileSystem.WyCommand getPreviewUrl(String paramString1, String paramString2, IWyFileSystem.IWyCallback<String> paramIWyCallback)
  {
    UtilsMisc.checkNotNull(paramIWyCallback);
    Cmd0X31B.FilePreviewReqBody localFilePreviewReqBody = new Cmd0X31B.FilePreviewReqBody();
    localFilePreviewReqBody.str_file_id.set(paramString1);
    localFilePreviewReqBody.str_file_name.set(paramString2);
    localFilePreviewReqBody.uint32_client_type.set(30001);
    localFilePreviewReqBody.uint32_preview_type.set(0);
    localFilePreviewReqBody.uint32_build_version.set(1);
    paramString1 = newReqBody(11);
    paramString1.msg_file_preview_req_body.set(localFilePreviewReqBody);
    paramString2 = new WyCommandImpl(paramIWyCallback);
    SdkContext.getInstance().getSender().sendRequest("OfflineFilleHandleSvr.pb_weiyun_CMD_REQ_FILE_PREVIEW-11", paramString1.toByteArray(), new DefaultCloudFileSystem.4(this, paramString2));
    return paramString2;
  }
  
  public boolean hasQueriedVerifyPassword()
  {
    return SdkContext.getInstance().getIPContext().isQueried();
  }
  
  public IWyFileSystem.WyCommand listCategory(IWyFileSystem.IWyCallback<List<WyCategoryInfo>> paramIWyCallback)
  {
    UtilsMisc.checkNotNull(paramIWyCallback);
    Cmd0X31B.GetLibTypeReqBody localGetLibTypeReqBody = new Cmd0X31B.GetLibTypeReqBody();
    Cmd0X31B.ReqBody localReqBody = newReqBody(1);
    localReqBody.msg_get_lib_type_req_body.set(localGetLibTypeReqBody);
    paramIWyCallback = new WyCommandImpl(paramIWyCallback);
    SdkContext.getInstance().getSender().sendRequest("OfflineFilleHandleSvr.pb_weiyun_CMD_REQ_GET_LIB_TYPE-1", localReqBody.toByteArray(), new DefaultCloudFileSystem.1(this, paramIWyCallback));
    return paramIWyCallback;
  }
  
  public IWyFileSystem.WyCommand listCloudFiles(String paramString, int paramInt1, int paramInt2, long paramLong, IWyFileSystem.IWyCallback<IWyFileSystem.ListFiles> paramIWyCallback)
  {
    UtilsMisc.checkNotNull(paramString);
    UtilsMisc.checkNotNull(paramIWyCallback);
    Cmd0X31B.GetLibListReqBody localGetLibListReqBody = new Cmd0X31B.GetLibListReqBody();
    localGetLibListReqBody.str_libtype.set(paramString);
    localGetLibListReqBody.uint32_offset.set(paramInt1);
    localGetLibListReqBody.uint32_number.set(paramInt2);
    localGetLibListReqBody.uint64_time_stamp.set(paramLong);
    Cmd0X31B.ReqBody localReqBody = newReqBody(2);
    localReqBody.msg_get_lib_list_req_body.set(localGetLibListReqBody);
    paramIWyCallback = new WyCommandImpl(paramIWyCallback);
    SdkContext.getInstance().getSender().sendRequest("OfflineFilleHandleSvr.pb_weiyun_CMD_REQ_GET_LIB_LIST-2", localReqBody.toByteArray(), new DefaultCloudFileSystem.2(this, paramIWyCallback, paramString, paramInt1, paramInt2));
    return paramIWyCallback;
  }
  
  public IWyFileSystem.WyCommand listOfflineFiles(int paramInt1, int paramInt2, int paramInt3, IWyFileSystem.IWyCallback<IWyFileSystem.ListOfflineFile> paramIWyCallback)
  {
    UtilsMisc.checkNotNull(paramIWyCallback);
    Cmd0X31B.GetOfflineFileReqBody localGetOfflineFileReqBody = new Cmd0X31B.GetOfflineFileReqBody();
    localGetOfflineFileReqBody.uint32_offline_type.set(paramInt1);
    localGetOfflineFileReqBody.uint32_offset.set(paramInt2);
    localGetOfflineFileReqBody.uint32_number.set(paramInt3);
    Cmd0X31B.ReqBody localReqBody = newReqBody(257);
    localReqBody.msg_get_offline_file_req_body.set(localGetOfflineFileReqBody);
    paramIWyCallback = new WyCommandImpl(paramIWyCallback);
    SdkContext.getInstance().getSender().sendRequest("OfflineFilleHandleSvr.pb_weiyun_CMD_REQ_OFFLINE_FILE-257", localReqBody.toByteArray(), new DefaultCloudFileSystem.3(this, paramIWyCallback, paramInt1));
    return paramIWyCallback;
  }
  
  public IWyFileSystem.WyCommand needVerifyIndependentPassword(IWyFileSystem.IWyCallback<Boolean> paramIWyCallback)
  {
    UtilsMisc.checkNotNull(paramIWyCallback);
    WyCommandImpl localWyCommandImpl = new WyCommandImpl(paramIWyCallback);
    if (SdkContext.getInstance().getIPContext().isQueried())
    {
      if ((SdkContext.getInstance().getIPContext().hasIndependentPassword()) && (!SdkContext.getInstance().getIPContext().isVerifySuccess()))
      {
        paramIWyCallback.onSucceed(Boolean.valueOf(true));
        return localWyCommandImpl;
      }
      paramIWyCallback.onSucceed(Boolean.valueOf(false));
      return localWyCommandImpl;
    }
    paramIWyCallback = new Cmd0X31B.QueryPwdReqBody();
    Cmd0X31B.ReqBody localReqBody = newReqBody(15);
    localReqBody.msg_querypwd_req_body.set(paramIWyCallback);
    SdkContext.getInstance().getSender().sendRequest("OfflineFilleHandleSvr.pb_weiyun_CMD_REQ_QUERY_PWD-15", localReqBody.toByteArray(), new DefaultCloudFileSystem.7(this, localWyCommandImpl));
    return localWyCommandImpl;
  }
  
  public IWyFileSystem.WyCommand sendWyFile2Ftn(String paramString1, String paramString2, long paramLong1, int paramInt1, long paramLong2, int paramInt2, String paramString3, IWyFileSystem.IWyCallback<IWyFileSystem.CommonFtnFile> paramIWyCallback)
  {
    return sendWyFile2Ftn(paramString1, paramString2, paramLong1, paramInt1, null, paramLong2, paramInt2, paramString3, null, paramIWyCallback);
  }
  
  public IWyFileSystem.WyCommand sendWyFile2Ftn(String paramString1, String paramString2, long paramLong1, int paramInt1, String paramString3, long paramLong2, int paramInt2, String paramString4, Cmd0X31B.ExtensionReq paramExtensionReq, IWyFileSystem.IWyCallback<IWyFileSystem.CommonFtnFile> paramIWyCallback)
  {
    Cmd0X31B.QCloud2FtnReqBody localQCloud2FtnReqBody = new Cmd0X31B.QCloud2FtnReqBody();
    localQCloud2FtnReqBody.uint64_dst_id.set(paramLong2);
    localQCloud2FtnReqBody.uint32_dst_bid.set(paramInt2);
    if (paramString4 != null) {
      localQCloud2FtnReqBody.str_dst_path.set(paramString4);
    }
    localQCloud2FtnReqBody.str_file_id.set(paramString1);
    localQCloud2FtnReqBody.str_file_name.set(paramString2);
    localQCloud2FtnReqBody.uint64_file_size.set(paramLong1);
    localQCloud2FtnReqBody.uint32_file_resource.set(paramInt1);
    if (!Utils.isEmptyString(paramString3)) {
      localQCloud2FtnReqBody.bytes_file_md5.set(ByteStringMicro.copyFrom(UtilsMisc.hexStringToByteArray(paramString3)));
    }
    if (paramExtensionReq != null) {
      localQCloud2FtnReqBody.extension_req.set(paramExtensionReq);
    }
    paramString1 = newReqBody(13);
    paramString1.msg_qcloud2ftn_req_body.set(localQCloud2FtnReqBody);
    paramString2 = new WyCommandImpl(paramIWyCallback);
    SdkContext.getInstance().getSender().sendRequest("OfflineFilleHandleSvr.pb_weiyun_CMD_REQ_QCLOUD2FTN-13", paramString1.toByteArray(), new DefaultCloudFileSystem.6(this, paramString2));
    return paramString2;
  }
  
  public IWyFileSystem.WyCommand verifyIndependentPassword(String paramString1, String paramString2, IWyFileSystem.IWyCallback<String> paramIWyCallback)
  {
    UtilsMisc.checkNotNull(paramIWyCallback);
    Cmd0X31B.VerifyPwdReqBody localVerifyPwdReqBody = new Cmd0X31B.VerifyPwdReqBody();
    if (paramString1 != null)
    {
      paramString1 = HashSumCalc.getStringHashSafely(paramString1, "MD5");
      localVerifyPwdReqBody.bytes_pwd_md5.set(ByteStringMicro.copyFrom(UtilsMisc.hexStringToByteArray(paramString1)));
    }
    for (;;)
    {
      paramString1 = newReqBody(16);
      paramString1.msg_verifypwd_req_body.set(localVerifyPwdReqBody);
      paramString2 = new WyCommandImpl(paramIWyCallback);
      SdkContext.getInstance().getSender().sendRequest("OfflineFilleHandleSvr.pb_weiyun_CMD_REQ_VERIFY_PWD-16", paramString1.toByteArray(), new DefaultCloudFileSystem.8(this, paramString2));
      return paramString2;
      if (paramString2 != null) {
        localVerifyPwdReqBody.bytes_cs_sig.set(ByteStringMicro.copyFrom(UtilsMisc.hexStringToByteArray(paramString2)));
      }
    }
  }
  
  static class WyOfflineFileInfoComparator
    implements Comparator<WyOfflineFileInfo>
  {
    public int compare(WyOfflineFileInfo paramWyOfflineFileInfo1, WyOfflineFileInfo paramWyOfflineFileInfo2)
    {
      long l = paramWyOfflineFileInfo1.uploadTime - paramWyOfflineFileInfo2.uploadTime;
      if (l != 0L)
      {
        if (l > 0L) {
          return -1;
        }
        return 1;
      }
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.weiyun.sdk.impl.DefaultCloudFileSystem
 * JD-Core Version:    0.7.0.1
 */