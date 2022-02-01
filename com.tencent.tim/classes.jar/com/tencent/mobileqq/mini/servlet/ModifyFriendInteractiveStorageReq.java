package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StKVData;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StModifyFriendInteractiveStorageReq;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StModifyFriendInteractiveStorageRsp;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class ModifyFriendInteractiveStorageReq
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_cloudstorage.ModifyFriendInteractiveStorage";
  public static final String TAG = "ModifyFriendInteractiveStorageReq";
  private static final String unikey = "ModifyFriendInteractiveStorageReq";
  private CloudStorage.StModifyFriendInteractiveStorageReq req = new CloudStorage.StModifyFriendInteractiveStorageReq();
  
  public ModifyFriendInteractiveStorageReq(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, HashMap<String, String> paramHashMap)
  {
    if (paramStCommonExt != null) {
      this.req.ext.set(paramStCommonExt);
    }
    this.req.appid.set(paramString1);
    this.req.toUser.set(paramString2);
    this.req.shareId.set(paramString3);
    this.req.opNum.set(paramInt);
    this.req.operation.set(paramString4);
    paramStCommonExt = paramHashMap.entrySet().iterator();
    while (paramStCommonExt.hasNext())
    {
      paramString1 = (Map.Entry)paramStCommonExt.next();
      paramString2 = new CloudStorage.StKVData();
      paramString2.key.set((String)paramString1.getKey());
      paramString2.value.set((String)paramString1.getValue());
      this.req.KVDataList.add(paramString2);
    }
  }
  
  public static CloudStorage.StModifyFriendInteractiveStorageRsp onResponse(byte[] paramArrayOfByte)
  {
    CloudStorage.StModifyFriendInteractiveStorageRsp localStModifyFriendInteractiveStorageRsp = new CloudStorage.StModifyFriendInteractiveStorageRsp();
    try
    {
      localStModifyFriendInteractiveStorageRsp.mergeFrom(decode(paramArrayOfByte));
      return localStModifyFriendInteractiveStorageRsp;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ModifyFriendInteractiveStorageReq", 2, "onResponse fail." + paramArrayOfByte);
      }
    }
    return null;
  }
  
  public byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.ModifyFriendInteractiveStorageReq
 * JD-Core Version:    0.7.0.1
 */