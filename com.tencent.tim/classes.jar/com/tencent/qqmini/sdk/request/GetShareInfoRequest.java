package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import NS_MINI_SHARE.MiniProgramShare.StAdaptShareInfoReq;
import NS_MINI_SHARE.MiniProgramShare.StAdaptShareInfoRsp;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

public class GetShareInfoRequest
  extends ProtoBufRequest
{
  public static final String JSON_DATA = "jsonData";
  public static final String MINI_APP_NEED_ONLY_PREVIEW = "miniAppNeedOnlyPreview";
  public static final String NEED_SHARE_CALLBACK = "needShareCallBack";
  public static final long SHARE_APPID_MISMATCHING = -1000710003L;
  public static final long SHARE_OUT_OF_LIMIT = -100070004L;
  private static final String TAG = "GetShareInfoRequest";
  private MiniProgramShare.StAdaptShareInfoReq req;
  
  public GetShareInfoRequest(MiniProgramShare.StAdaptShareInfoReq paramStAdaptShareInfoReq)
  {
    this.req = paramStAdaptShareInfoReq;
  }
  
  protected byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "AdaptShareInfo";
  }
  
  protected String getModule()
  {
    return "mini_app_share";
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    if (paramArrayOfByte == null) {
      return null;
    }
    MiniProgramShare.StAdaptShareInfoRsp localStAdaptShareInfoRsp = new MiniProgramShare.StAdaptShareInfoRsp();
    label264:
    label271:
    for (;;)
    {
      long l;
      boolean bool2;
      int i;
      try
      {
        localStAdaptShareInfoRsp.mergeFrom(paramArrayOfByte);
        if (localStAdaptShareInfoRsp == null) {
          break label238;
        }
        l = paramJSONObject.getLong("retCode");
        paramJSONObject.getString("errMsg");
        bool2 = bool3;
        if (localStAdaptShareInfoRsp.extInfo == null) {
          break label271;
        }
        bool2 = bool3;
        if (localStAdaptShareInfoRsp.extInfo.mapInfo == null) {
          break label271;
        }
        i = 0;
        bool2 = bool1;
        if (i >= localStAdaptShareInfoRsp.extInfo.mapInfo.size()) {
          break label271;
        }
        paramArrayOfByte = (COMM.Entry)localStAdaptShareInfoRsp.extInfo.mapInfo.get(i);
        if ((!"needShareCallBack".equals(paramArrayOfByte.key.get())) || (!"true".equals(paramArrayOfByte.value.get()))) {
          break label264;
        }
        bool1 = true;
      }
      catch (Exception paramArrayOfByte)
      {
        label148:
        QMLog.d("GetShareInfoRequest", "onResponse fail." + paramArrayOfByte);
        return null;
      }
      QMLog.e("GetShareInfoRequest", "onGetShareInfo isSuccess=false, retCode=" + l);
      paramJSONObject.put("needShareCallBack", bool2);
      return paramJSONObject;
      label238:
      do
      {
        paramArrayOfByte = new JSONObject(localStAdaptShareInfoRsp.jsonData.get());
        paramArrayOfByte.put("needShareCallBack", bool2);
        return paramArrayOfByte;
        paramJSONObject.put("retCode", -1);
        paramJSONObject.put("errMsg", "数据解析错误");
        QMLog.d("GetShareInfoRequest", "onResponse fail.webRsp = null");
        return paramJSONObject;
        i += 1;
        break;
        if (l == -100070004L) {
          break label148;
        }
      } while (l != -1000710003L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.GetShareInfoRequest
 * JD-Core Version:    0.7.0.1
 */