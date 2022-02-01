package com.tencent.qqmini.sdk.request;

import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import NS_MINI_AD.MiniAppAd.StGetAdForSdkReq;
import NS_MINI_AD.MiniAppAd.StGetAdForSdkRsp;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class GetAdRequest
  extends ProtoBufRequest
{
  private static final String TAG = "GetAdRequest";
  private MiniAppAd.StGetAdForSdkReq req = new MiniAppAd.StGetAdForSdkReq();
  
  public GetAdRequest(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, HashMap<String, String> paramHashMap)
  {
    this.req.strAppid.set(paramString1);
    this.req.iAdType.set(paramInt);
    this.req.strGetAdUrl.set(paramString4);
    paramString1 = new ArrayList();
    if ((paramHashMap != null) && (paramHashMap.size() > 0))
    {
      paramString4 = paramHashMap.entrySet().iterator();
      while (paramString4.hasNext())
      {
        localObject1 = (Map.Entry)paramString4.next();
        paramHashMap = (String)((Map.Entry)localObject1).getKey();
        localObject1 = (String)((Map.Entry)localObject1).getValue();
        localObject2 = new COMM.Entry();
        ((COMM.Entry)localObject2).key.set(paramHashMap);
        ((COMM.Entry)localObject2).value.set((String)localObject1);
        paramString1.add(localObject2);
      }
    }
    if (paramString1.size() > 0) {
      this.req.mapParam.addAll(paramString1);
    }
    paramString4 = new COMM.StCommonExt();
    paramHashMap = new ArrayList();
    Object localObject1 = new COMM.Entry();
    ((COMM.Entry)localObject1).key.set("refer");
    Object localObject2 = ((COMM.Entry)localObject1).value;
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = "";
    }
    ((PBStringField)localObject2).set(paramString1);
    paramHashMap.add(localObject1);
    paramString2 = new COMM.Entry();
    paramString2.key.set("via");
    localObject1 = paramString2.value;
    paramString1 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString1 = "";
    }
    ((PBStringField)localObject1).set(paramString1);
    paramHashMap.add(paramString2);
    paramString4.mapInfo.set(paramHashMap);
    this.req.extInfo.setHasFlag(true);
    this.req.extInfo.set(paramString4);
  }
  
  protected byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "GetAdForSdk";
  }
  
  protected String getModule()
  {
    return "mini_app_ad";
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    MiniAppAd.StGetAdForSdkRsp localStGetAdForSdkRsp = new MiniAppAd.StGetAdForSdkRsp();
    try
    {
      localStGetAdForSdkRsp.mergeFrom(paramArrayOfByte);
      if (localStGetAdForSdkRsp != null)
      {
        paramJSONObject.put("response", localStGetAdForSdkRsp);
        paramJSONObject.put("resultCode", paramJSONObject.get("retCode"));
        return paramJSONObject;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("GetAdRequest", "onResponse fail." + paramArrayOfByte);
      return null;
    }
    QMLog.d("GetAdRequest", "onResponse fail.rsp = null");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.GetAdRequest
 * JD-Core Version:    0.7.0.1
 */