package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.DeviceInfo;
import NS_MINI_INTERFACE.INTERFACE.StGetDropdownAppListReq;
import NS_MINI_INTERFACE.INTERFACE.StGetDropdownAppListRsp;
import NS_MINI_INTERFACE.INTERFACE.StRecommendApp;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class GetUserAppListRequestV2
  extends ProtoBufRequest
{
  public static final String CMD_STRING = "LightAppSvc.mini_app_userapp.GetDropdownAppList";
  public static final String KEY_RSP = "response";
  private INTERFACE.StGetDropdownAppListReq req = new INTERFACE.StGetDropdownAppListReq();
  
  public GetUserAppListRequestV2(COMM.StCommonExt paramStCommonExt, ArrayList<INTERFACE.StRecommendApp> paramArrayList, ArrayList<Integer> paramArrayList1, int paramInt, INTERFACE.DeviceInfo paramDeviceInfo, ArrayList<Integer> paramArrayList2, ArrayList<String> paramArrayList3)
  {
    if (paramStCommonExt != null) {
      this.req.extInfo.set(paramStCommonExt);
    }
    this.req.oldRecommendList.set(paramArrayList);
    this.req.types.set(paramArrayList1);
    this.req.hasCache.set(paramInt);
    this.req.deviceInfo.set(paramDeviceInfo);
    this.req.subTypes.set(paramArrayList2);
    this.req.itemIds.set(paramArrayList3);
  }
  
  public static INTERFACE.StGetDropdownAppListRsp onResponse(byte[] paramArrayOfByte)
  {
    INTERFACE.StGetDropdownAppListRsp localStGetDropdownAppListRsp = new INTERFACE.StGetDropdownAppListRsp();
    try
    {
      localStGetDropdownAppListRsp.mergeFrom(decode(paramArrayOfByte));
      return localStGetDropdownAppListRsp;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProtoBufRequest", 2, "onResponse fail." + paramArrayOfByte);
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
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.GetUserAppListRequestV2
 * JD-Core Version:    0.7.0.1
 */