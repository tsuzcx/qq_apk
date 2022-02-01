package com.huawei.hms.support.api.core;

import android.text.TextUtils;
import com.huawei.hms.support.api.ResolvePendingResult;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.InnerPendingResult;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.entity.core.CheckConnectInfo;
import com.huawei.hms.support.api.entity.core.CheckConnectResp;
import com.huawei.hms.support.api.entity.core.ConnectInfo;
import com.huawei.hms.support.api.entity.core.ConnectResp;
import com.huawei.hms.support.api.entity.core.DisconnectInfo;
import com.huawei.hms.support.api.entity.core.DisconnectResp;
import com.huawei.hms.support.api.entity.core.JosGetNoticeReq;
import com.huawei.hms.support.api.entity.core.JosGetNoticeResp;

public final class ConnectService
{
  public static InnerPendingResult<ResolveResult<CheckConnectResp>> checkconnect(ApiClient paramApiClient, CheckConnectInfo paramCheckConnectInfo)
  {
    return ResolvePendingResult.build(paramApiClient, "core.checkconnect", paramCheckConnectInfo, CheckConnectResp.class);
  }
  
  public static PendingResult<ResolveResult<ConnectResp>> connect(ApiClient paramApiClient, ConnectInfo paramConnectInfo)
  {
    return new ConnectService.1(paramApiClient, "core.connect", paramConnectInfo);
  }
  
  public static ResolvePendingResult<DisconnectResp> disconnect(ApiClient paramApiClient, DisconnectInfo paramDisconnectInfo)
  {
    return ResolvePendingResult.build(paramApiClient, "core.disconnect", paramDisconnectInfo, DisconnectResp.class);
  }
  
  public static PendingResult<ResolveResult<ConnectResp>> forceConnect(ApiClient paramApiClient, ConnectInfo paramConnectInfo)
  {
    return new ConnectService.2(paramApiClient, "core.foreconnect", paramConnectInfo);
  }
  
  public static PendingResult<ResolveResult<JosGetNoticeResp>> getNotice(ApiClient paramApiClient, int paramInt, String paramString)
  {
    JosGetNoticeReq localJosGetNoticeReq = new JosGetNoticeReq();
    localJosGetNoticeReq.setNoticeType(paramInt);
    localJosGetNoticeReq.setHmsSdkVersionName(paramString);
    if (!TextUtils.isEmpty(paramApiClient.getCpID())) {
      localJosGetNoticeReq.setCpID(paramApiClient.getCpID());
    }
    return new ConnectService.3(paramApiClient, "core.getNoticeIntent", localJosGetNoticeReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.support.api.core.ConnectService
 * JD-Core Version:    0.7.0.1
 */