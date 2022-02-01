package com.weiyun.sdk.impl;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.weiyun.sdk.IWyFileSystem.IWyCallback;
import com.weiyun.sdk.IWyFileSystem.ListFiles;
import com.weiyun.sdk.data.WyFileInfo;
import com.weiyun.sdk.util.UtilsMisc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.cmd0x31b.Cmd0X31B.FileInfo;
import tencent.im.cs.cmd0x31b.Cmd0X31B.GetLibListRspBody;

class DefaultCloudFileSystem$2
  extends BaseCallbackImpl<Cmd0X31B.GetLibListRspBody, IWyFileSystem.ListFiles>
{
  DefaultCloudFileSystem$2(DefaultCloudFileSystem paramDefaultCloudFileSystem, WyCommandImpl paramWyCommandImpl, String paramString, int paramInt1, int paramInt2)
  {
    super(paramWyCommandImpl);
  }
  
  private List<WyFileInfo> transfer(List<Cmd0X31B.FileInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Cmd0X31B.FileInfo localFileInfo = (Cmd0X31B.FileInfo)localIterator.next();
      paramList = null;
      if (localFileInfo.bytes_md5.has()) {
        paramList = UtilsMisc.hexStringToByteArrayFromByteArray(localFileInfo.bytes_md5.get().toByteArray());
      }
      String str = null;
      if (localFileInfo.bytes_encode_url.has()) {
        str = UtilsMisc.hexStringToByteArrayFromByteArray(localFileInfo.bytes_encode_url.get().toByteArray());
      }
      localArrayList.add(new WyFileInfo(localFileInfo.str_file_id.get(), localFileInfo.str_file_name.get(), localFileInfo.uint64_mtime.get(), localFileInfo.uint64_file_size.get(), localFileInfo.uint32_file_resource.get(), paramList, str, localFileInfo.str_cookie_name.get(), localFileInfo.str_cookie_value.get(), localFileInfo.str_host_name.get(), localFileInfo.uint32_server_port.get()));
    }
    return localArrayList;
  }
  
  protected void handleSuccess(IWyFileSystem.IWyCallback<IWyFileSystem.ListFiles> paramIWyCallback, Cmd0X31B.GetLibListRspBody paramGetLibListRspBody)
  {
    IWyFileSystem.ListFiles localListFiles = new IWyFileSystem.ListFiles();
    localListFiles.categoryId = this.val$category;
    localListFiles.totalNum = paramGetLibListRspBody.uint32_file_total_num.get();
    localListFiles.timestamp = paramGetLibListRspBody.uint64_time_stamp.get();
    localListFiles.files = transfer(paramGetLibListRspBody.rpt_msg_file_info.get());
    localListFiles.isEnd = false;
    if (this.val$offset + this.val$count >= localListFiles.totalNum) {
      localListFiles.isEnd = true;
    }
    paramIWyCallback.onSucceed(localListFiles);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.weiyun.sdk.impl.DefaultCloudFileSystem.2
 * JD-Core Version:    0.7.0.1
 */