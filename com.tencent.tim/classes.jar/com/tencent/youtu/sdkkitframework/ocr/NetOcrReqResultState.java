package com.tencent.youtu.sdkkitframework.ocr;

import android.graphics.Rect;
import android.graphics.YuvImage;
import android.util.Base64;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper.StateClassName;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitConfigHelper;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class NetOcrReqResultState
  extends YtFSMBaseState
{
  private static final String TAG = NetOcrReqResultState.class.getSimpleName();
  private HashMap<String, String> _requestOptions = null;
  private String appId;
  private String ocrtype;
  private String resultUrl;
  private String secretId;
  private String secretKey;
  private String userId;
  
  private void onRequestOcrResult()
  {
    Object localObject2 = (YuvImage)YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.OCR_AUTO_DETECT_STATE)).getStateDataBy("best_frame");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (YuvImage)YtFSM.getInstance().getStateByName(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.OCR_MANUAL_DETECT_STATE)).getStateDataBy("best_frame");
    }
    if (localObject1 == null)
    {
      YtFSM.getInstance().sendFSMEvent(new NetOcrReqResultState.3(this));
      return;
    }
    int i = ((YuvImage)localObject1).getWidth();
    int j = ((YuvImage)localObject1).getHeight();
    localObject2 = new ByteArrayOutputStream();
    ((YuvImage)localObject1).compressToJpeg(new Rect(0, 0, i, j), 95, (OutputStream)localObject2);
    localObject2 = Base64.encode(((ByteArrayOutputStream)localObject2).toByteArray(), 2);
    Iterator localIterator = this._requestOptions.entrySet().iterator();
    Map.Entry localEntry;
    for (localObject1 = ""; localIterator.hasNext(); localObject1 = String.format("%s, \"%s\":%s", new Object[] { localObject1, localEntry.getKey(), localEntry.getValue() })) {
      localEntry = (Map.Entry)localIterator.next();
    }
    localObject1 = String.format("{\"app_id\":\"%s\"%s,\"image\":\"%s\"}", new Object[] { this.appId, localObject1, new String((byte[])localObject2) });
    try
    {
      localObject2 = CommonUtils.getYoutuOpenAppSign(this.appId, this.secretId, this.secretKey, this.userId);
      YtFSM.getInstance().sendNetworkRequset(this.resultUrl, (String)localObject1, new NetOcrReqResultState.5(this, (String)localObject2), new NetOcrReqResultState.6(this));
      return;
    }
    catch (Exception localException)
    {
      YtLogger.e(TAG, "Failed to compose sign " + localException.getLocalizedMessage());
      YtFSM.getInstance().sendFSMEvent(new NetOcrReqResultState.4(this, localException));
    }
  }
  
  public void enter()
  {
    super.enter();
    YtFSM.getInstance().sendFSMEvent(new NetOcrReqResultState.2(this));
    onRequestOcrResult();
  }
  
  public void enterFirst() {}
  
  public void exit()
  {
    super.exit();
  }
  
  public void loadStateWith(String paramString, JSONObject paramJSONObject)
  {
    super.loadStateWith(paramString, paramJSONObject);
    try
    {
      paramString = YtSDKKitConfigHelper.getConfigStringBy(paramJSONObject, "app_id", true);
      this.appId = paramString;
      if (paramString == null) {
        return;
      }
      paramString = YtSDKKitConfigHelper.getConfigStringBy(paramJSONObject, "secret_key", true);
      this.secretKey = paramString;
      if (paramString != null)
      {
        paramString = YtSDKKitConfigHelper.getConfigStringBy(paramJSONObject, "secret_id", true);
        this.secretId = paramString;
        if (paramString != null)
        {
          paramString = YtSDKKitConfigHelper.getConfigStringBy(paramJSONObject, "user_id", true);
          this.userId = paramString;
          if (paramString != null)
          {
            this.ocrtype = paramJSONObject.getString("ocrtype");
            paramString = paramJSONObject.getJSONObject(this.ocrtype).getJSONObject("request_options");
            this.resultUrl = paramJSONObject.getJSONObject(this.ocrtype).getString("result_api_url");
            paramJSONObject = paramString.keys();
            this._requestOptions = new HashMap();
            while (paramJSONObject.hasNext())
            {
              String str1 = (String)paramJSONObject.next();
              String str2 = paramString.getString(str1);
              this._requestOptions.put(str1, str2);
            }
          }
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      YtLogger.e(TAG, paramString.getMessage());
      YtFSM.getInstance().sendFSMEvent(new NetOcrReqResultState.1(this, paramString));
    }
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    super.update(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.ocr.NetOcrReqResultState
 * JD-Core Version:    0.7.0.1
 */