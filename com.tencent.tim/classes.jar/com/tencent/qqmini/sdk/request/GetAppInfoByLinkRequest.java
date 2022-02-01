package com.tencent.qqmini.sdk.request;

import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE.StGetAppInfoByLinkReq;
import NS_MINI_INTERFACE.INTERFACE.StGetAppInfoByLinkRsp;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.utils.ProcessUtil;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import org.json.JSONObject;

public class GetAppInfoByLinkRequest
  extends ProtoBufRequest
{
  private static final String unikey = "GetAppInfoByLink";
  private JSONObject mJSONObject = new JSONObject();
  private INTERFACE.StGetAppInfoByLinkReq req = new INTERFACE.StGetAppInfoByLinkReq();
  
  public GetAppInfoByLinkRequest(String paramString, int paramInt)
  {
    if (getContentType() == 0)
    {
      this.req.link.set(paramString);
      this.req.linkType.set(paramInt);
      return;
    }
    try
    {
      this.mJSONObject.put("link", paramString);
      this.mJSONObject.put("linkType", paramInt);
      return;
    }
    catch (Exception paramString)
    {
      QMLog.d("ProtoBufRequest", "GetAppInfoByLinkRequest Exception:" + paramString);
    }
  }
  
  private void savaMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    if (!ProcessUtil.isMainProcess(AppLoaderFactory.g().getMiniAppEnv().getContext())) {
      return;
    }
    ThreadManager.executeOnDiskIOThreadPool(new GetAppInfoByLinkRequest.1(this, paramMiniAppInfo));
  }
  
  public byte[] getBusiBuf()
  {
    if (getContentType() == 0) {
      return this.req.toByteArray();
    }
    return this.mJSONObject.toString().getBytes();
  }
  
  protected String getCmdName()
  {
    return "GetAppInfoByLink";
  }
  
  public int getContentType()
  {
    if (QUAUtil.isAlienApp()) {
      return 1;
    }
    return 0;
  }
  
  protected String getModule()
  {
    return "mini_app_info";
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    if (paramArrayOfByte == null) {
      paramArrayOfByte = null;
    }
    for (;;)
    {
      return paramArrayOfByte;
      Object localObject;
      if (getContentType() == 0)
      {
        localObject = new INTERFACE.StGetAppInfoByLinkRsp();
        try
        {
          ((INTERFACE.StGetAppInfoByLinkRsp)localObject).mergeFrom(paramArrayOfByte);
          if ((localObject != null) && (((INTERFACE.StGetAppInfoByLinkRsp)localObject).appInfo != null))
          {
            MiniAppInfo localMiniAppInfo = MiniAppInfo.from(((INTERFACE.StGetAppInfoByLinkRsp)localObject).appInfo);
            localMiniAppInfo.link = this.req.link.get();
            localMiniAppInfo.linkType = this.req.linkType.get();
            paramArrayOfByte = ((INTERFACE.StGetAppInfoByLinkRsp)localObject).shareTicket.get();
            paramJSONObject.put("appInfo", localMiniAppInfo);
            paramJSONObject.put("shareTicket", paramArrayOfByte);
            paramArrayOfByte = paramJSONObject;
            if (((INTERFACE.StGetAppInfoByLinkRsp)localObject).appInfo.type.get() != 3) {
              continue;
            }
            savaMiniAppInfo(localMiniAppInfo);
            return paramJSONObject;
          }
        }
        catch (Exception paramArrayOfByte)
        {
          QMLog.d("ProtoBufRequest", "onResponse fail." + paramArrayOfByte);
          return null;
        }
        QMLog.d("ProtoBufRequest", "onResponse fail.rsp = null");
        return null;
      }
      else
      {
        try
        {
          paramArrayOfByte = new JSONObject(new String(paramArrayOfByte));
          localObject = MiniAppInfo.createMiniAppInfo(paramArrayOfByte.optJSONObject("appInfo"));
          ((MiniAppInfo)localObject).link = this.mJSONObject.optString("link");
          ((MiniAppInfo)localObject).linkType = this.mJSONObject.optInt("linkType");
          paramJSONObject.put("appInfo", localObject);
          paramJSONObject.put("shareTicket", paramArrayOfByte.optString("shareTicket"));
          paramArrayOfByte = paramJSONObject;
          if (((MiniAppInfo)localObject).verType == 3)
          {
            savaMiniAppInfo((MiniAppInfo)localObject);
            return paramJSONObject;
          }
        }
        catch (Exception paramArrayOfByte)
        {
          QMLog.d("ProtoBufRequest", "onResponse fail." + paramArrayOfByte);
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.GetAppInfoByLinkRequest
 * JD-Core Version:    0.7.0.1
 */