package com.weiyun.sdk.impl;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.weiyun.sdk.IWyFileSystem.IWyCallback;
import com.weiyun.sdk.IWyFileSystem.ListOfflineFile;
import com.weiyun.sdk.data.WyOfflineFileInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.cmd0x31b.Cmd0X31B.GetOfflineFileRspBody;
import tencent.im.cs.cmd0x31b.Cmd0X31B.OfflineFileInfo;

class DefaultCloudFileSystem$3
  extends BaseCallbackImpl<Cmd0X31B.GetOfflineFileRspBody, IWyFileSystem.ListOfflineFile>
{
  DefaultCloudFileSystem$3(DefaultCloudFileSystem paramDefaultCloudFileSystem, WyCommandImpl paramWyCommandImpl, int paramInt)
  {
    super(paramWyCommandImpl);
  }
  
  private List<WyOfflineFileInfo> transferData(boolean paramBoolean, List<Cmd0X31B.OfflineFileInfo> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Cmd0X31B.OfflineFileInfo localOfflineFileInfo = (Cmd0X31B.OfflineFileInfo)paramList.next();
      WyOfflineFileInfo localWyOfflineFileInfo = new WyOfflineFileInfo();
      localWyOfflineFileInfo.guid = localOfflineFileInfo.bytes_uuid.get().toStringUtf8();
      localWyOfflineFileInfo.bSend = paramBoolean;
      localWyOfflineFileInfo.uin = localOfflineFileInfo.uint64_uin.get();
      localWyOfflineFileInfo.fileName = localOfflineFileInfo.str_file_name.get();
      localWyOfflineFileInfo.fileSize = localOfflineFileInfo.uint64_file_size.get();
      localWyOfflineFileInfo.lifeTime = localOfflineFileInfo.uint32_life_time.get();
      localWyOfflineFileInfo.lifeTime *= 1000L;
      localWyOfflineFileInfo.uploadTime = localOfflineFileInfo.uint32_upload_time.get();
      localWyOfflineFileInfo.uploadTime *= 1000L;
      localArrayList.add(localWyOfflineFileInfo);
    }
    return localArrayList;
  }
  
  protected void handleSuccess(IWyFileSystem.IWyCallback<IWyFileSystem.ListOfflineFile> paramIWyCallback, Cmd0X31B.GetOfflineFileRspBody paramGetOfflineFileRspBody)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool1 = true;
    IWyFileSystem.ListOfflineFile localListOfflineFile = new IWyFileSystem.ListOfflineFile();
    List localList1 = transferData(true, paramGetOfflineFileRspBody.rpt_msg_send_offline_file.get());
    List localList2 = transferData(false, paramGetOfflineFileRspBody.rpt_msg_recv_offline_file.get());
    int i = paramGetOfflineFileRspBody.uint32_recv_list_end.get();
    int j = paramGetOfflineFileRspBody.uint32_send_list_end.get();
    if (this.val$offlineType == 2) {
      if ((i == 1) && (j == 1))
      {
        localListOfflineFile.isEnd = bool1;
        label89:
        if ((localList1 == null) || (localList2 == null)) {
          break label212;
        }
        localList1.addAll(localList2);
        Collections.sort(localList1, new DefaultCloudFileSystem.WyOfflineFileInfoComparator(null));
        paramGetOfflineFileRspBody = localList1;
      }
    }
    for (;;)
    {
      localListOfflineFile.files = paramGetOfflineFileRspBody;
      paramIWyCallback.onSucceed(localListOfflineFile);
      return;
      bool1 = false;
      break;
      if (this.val$offlineType == 1)
      {
        if (j == 1) {}
        for (bool1 = bool2;; bool1 = false)
        {
          localListOfflineFile.isEnd = bool1;
          break;
        }
      }
      if (this.val$offlineType != 0) {
        break label89;
      }
      if (i == 1) {}
      for (bool1 = bool3;; bool1 = false)
      {
        localListOfflineFile.isEnd = bool1;
        break;
      }
      label212:
      if (localList1 != null) {
        paramGetOfflineFileRspBody = localList1;
      } else if (localList2 != null) {
        paramGetOfflineFileRspBody = localList2;
      } else {
        paramGetOfflineFileRspBody = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.weiyun.sdk.impl.DefaultCloudFileSystem.3
 * JD-Core Version:    0.7.0.1
 */