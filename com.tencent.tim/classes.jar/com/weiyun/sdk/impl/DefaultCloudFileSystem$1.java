package com.weiyun.sdk.impl;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.weiyun.sdk.IWyFileSystem.IWyCallback;
import com.weiyun.sdk.data.WyCategoryInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.cmd0x31b.Cmd0X31B.GetLibTypeRspBody;
import tencent.im.cs.cmd0x31b.Cmd0X31B.LibTypeInfo;

class DefaultCloudFileSystem$1
  extends BaseCallbackImpl<Cmd0X31B.GetLibTypeRspBody, List<WyCategoryInfo>>
{
  DefaultCloudFileSystem$1(DefaultCloudFileSystem paramDefaultCloudFileSystem, WyCommandImpl paramWyCommandImpl)
  {
    super(paramWyCommandImpl);
  }
  
  private List<WyCategoryInfo> transfer(List<Cmd0X31B.LibTypeInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Cmd0X31B.LibTypeInfo localLibTypeInfo = (Cmd0X31B.LibTypeInfo)paramList.next();
      localArrayList.add(new WyCategoryInfo(localLibTypeInfo.str_type_name.get(), localLibTypeInfo.str_type_desc.get(), localLibTypeInfo.uint32_file_total_num.get(), localLibTypeInfo.uint64_timestamp.get()));
    }
    return localArrayList;
  }
  
  protected void handleSuccess(IWyFileSystem.IWyCallback<List<WyCategoryInfo>> paramIWyCallback, Cmd0X31B.GetLibTypeRspBody paramGetLibTypeRspBody)
  {
    new ArrayList();
    if (paramGetLibTypeRspBody.rpt_msg_lib_type_info.has()) {
      paramIWyCallback.onSucceed(transfer(paramGetLibTypeRspBody.rpt_msg_lib_type_info.get()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.weiyun.sdk.impl.DefaultCloudFileSystem.1
 * JD-Core Version:    0.7.0.1
 */