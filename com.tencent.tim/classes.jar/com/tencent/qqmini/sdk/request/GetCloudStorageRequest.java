package com.tencent.qqmini.sdk.request;

import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetUserCloudStorageReq;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StGetUserCloudStorageRsp;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StKVData;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class GetCloudStorageRequest
  extends ProtoBufRequest
{
  private static final String TAG = "GetCloudStorageRequest";
  private CloudStorage.StGetUserCloudStorageReq req = new CloudStorage.StGetUserCloudStorageReq();
  
  public GetCloudStorageRequest(String[] paramArrayOfString, String paramString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      this.req.keyList.add(str);
      i += 1;
    }
    this.req.appid.set(paramString);
  }
  
  protected byte[] getBusiBuf()
  {
    return this.req.toByteArray();
  }
  
  protected String getCmdName()
  {
    return "GetUserCloudStorage";
  }
  
  protected String getModule()
  {
    return "mini_app_cloudstorage";
  }
  
  public JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    Object localObject = new CloudStorage.StGetUserCloudStorageRsp();
    try
    {
      ((CloudStorage.StGetUserCloudStorageRsp)localObject).mergeFrom(paramArrayOfByte);
      if ((localObject == null) || (((CloudStorage.StGetUserCloudStorageRsp)localObject).KVDataList == null)) {
        break label162;
      }
      localObject = ((CloudStorage.StGetUserCloudStorageRsp)localObject).KVDataList.get();
      paramArrayOfByte = new JSONArray();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        CloudStorage.StKVData localStKVData = (CloudStorage.StKVData)((Iterator)localObject).next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("key", localStKVData.key.get());
        localJSONObject.put("value", localStKVData.value.get());
        paramArrayOfByte.put(localJSONObject);
      }
      paramJSONObject.put("KVDataList", paramArrayOfByte);
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("GetCloudStorageRequest", "onResponse fail." + paramArrayOfByte);
      return null;
    }
    return paramJSONObject;
    label162:
    QMLog.d("GetCloudStorageRequest", "onResponse fail.rsp = null");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.GetCloudStorageRequest
 * JD-Core Version:    0.7.0.1
 */