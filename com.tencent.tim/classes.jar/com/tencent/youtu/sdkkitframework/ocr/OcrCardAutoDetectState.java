package com.tencent.youtu.sdkkitframework.ocr;

import android.graphics.Rect;
import android.graphics.YuvImage;
import com.tencent.youtu.sdk.ocr.imagerefiner.YtImageRefinerSDK;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon.StateNameHelper.StateClassName;
import com.tencent.youtu.ytcommon.tools.YTUtils;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class OcrCardAutoDetectState
  extends YtFSMBaseState
{
  private static final long MAX_AUTO_TIMEOUT_MS = 30000L;
  private static final long MIN_AUTO_TIMEOUT_MS = 5000L;
  private static final String TAG = OcrCardAutoDetectState.class.getSimpleName();
  private long autoTimeoutMs = 10000L;
  private long beginTime;
  private double blurThreshold = 0.4000000059604645D;
  private boolean isLoadResourceOnline = false;
  private boolean isTimeOut;
  private int modeType = 2;
  private int tooBlurCount = 0;
  
  public void enter()
  {
    super.enter();
    this.tooBlurCount = 0;
    YtImageRefinerSDK.getInstance().setTargetPreviewRect(new Rect(66, 66, 468, 340));
    YtImageRefinerSDK.getInstance().setBlurThreshold(this.blurThreshold);
    this.beginTime = System.currentTimeMillis();
    YtFSM.getInstance().sendFSMEvent(new OcrCardAutoDetectState.2(this));
    if (this.modeType == 0) {
      moveToNextState();
    }
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
      if (paramJSONObject.has("resource_online")) {
        this.isLoadResourceOnline = paramJSONObject.getBoolean("resource_online");
      }
      if (!this.isLoadResourceOnline) {
        YTUtils.loadLibrary("YTImageRefiner");
      }
      YtLogger.d(TAG, "Load " + YtImageRefinerSDK.version());
      int i = YtImageRefinerSDK.getInstance().init();
      if (i != 0)
      {
        YtLogger.e(TAG, "Failed to init sdk " + i);
        YtFSM.getInstance().sendFSMEvent(new OcrCardAutoDetectState.1(this, i));
      }
    }
    catch (JSONException paramString)
    {
      try
      {
        this.modeType = paramJSONObject.getInt("mode_type");
        this.autoTimeoutMs = paramJSONObject.getLong("auto_timeout_ms");
        this.autoTimeoutMs = Math.max(5000L, Math.min(this.autoTimeoutMs, 30000L));
        this.isTimeOut = false;
        return;
        paramString = paramString;
        paramString.printStackTrace();
        YtLogger.e(TAG, "Failed to parse json:" + paramString.getLocalizedMessage());
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          YtLogger.e(TAG, "Failed parse json " + paramString.getLocalizedMessage());
        }
      }
    }
  }
  
  public void moveToNextState()
  {
    super.moveToNextState();
    if (this.modeType == 0)
    {
      YtFSM.getInstance().transitNextRound(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.OCR_MANUAL_DETECT_STATE));
      return;
    }
    if (this.isTimeOut)
    {
      if (this.modeType == 2)
      {
        YtFSM.getInstance().transitNextRound(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.OCR_MANUAL_DETECT_STATE));
        return;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("ui_action", "process_finished");
      localHashMap.put("ui_tips", "rst_failed");
      localHashMap.put("process_action", "failed");
      localHashMap.put("error_code", Integer.valueOf(4194304));
      localHashMap.put("message", "ocr_auto_timeout");
      YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.IDLE_STATE));
      YtFSM.getInstance().sendFSMEvent(localHashMap);
      return;
    }
    YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_OCR_REQ_RESULT_STATE));
  }
  
  public void unload()
  {
    super.unload();
    int i = YtImageRefinerSDK.getInstance().deInit();
    if (i != 0) {
      YtLogger.e(TAG, " Failed to deinit sdk " + i);
    }
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    super.update(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
    double[] arrayOfDouble = new double[1];
    int[] arrayOfInt = new int[8];
    HashMap localHashMap = new HashMap();
    if (System.currentTimeMillis() - this.beginTime > this.autoTimeoutMs)
    {
      this.isTimeOut = true;
      moveToNextState();
      return;
    }
    paramInt3 = YtImageRefinerSDK.getInstance().detectFrame(paramArrayOfByte, paramInt1, paramInt2, arrayOfDouble, arrayOfInt);
    if ((paramInt3 == 0) && (arrayOfInt[0] != 0))
    {
      YtLogger.d(TAG, "Found proper image");
      localHashMap.put("ui_action", "pass");
      localHashMap.put("ui_tips", "ocr_auto_succeed");
      paramArrayOfByte = new YuvImage(paramArrayOfByte, 17, paramInt1, paramInt2, null);
      this.stateData.put("best_frame", paramArrayOfByte);
      if (!localHashMap.isEmpty()) {
        YtFSM.getInstance().sendFSMEvent(localHashMap);
      }
      moveToNextState();
      return;
    }
    switch (paramInt3)
    {
    default: 
      if ((paramInt3 & 0x2000) == 8192)
      {
        localHashMap.put("ui_action", "process_finished");
        localHashMap.put("ui_tips", "rst_failed");
        localHashMap.put("process_action", "failed");
        localHashMap.put("error_code", Integer.valueOf(paramInt3));
        localHashMap.put("message", "msg_inner_error");
        YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.IDLE_STATE));
      }
      break;
    }
    while (!localHashMap.isEmpty())
    {
      YtFSM.getInstance().sendFSMEvent(localHashMap);
      return;
      localHashMap.put("ui_action", "process_finished");
      localHashMap.put("ui_tips", "rst_succeed");
      localHashMap.put("process_action", "failed");
      localHashMap.put("error_code", Integer.valueOf(paramInt3 + 3145728));
      localHashMap.put("message", "msg_param_error");
      continue;
      localHashMap.put("ui_tips", "ocr_card_closer");
      localHashMap.put("ui_action", "not_pass");
      continue;
      localHashMap.put("ui_tips", "ocr_card_farer");
      localHashMap.put("ui_action", "not_pass");
      continue;
      localHashMap.put("ui_tips", "ocr_cam_blur");
      localHashMap.put("ui_action", "card_not_found");
      this.tooBlurCount += 1;
      if (this.tooBlurCount > 20)
      {
        localHashMap.put("ui_action", "need_focus");
        this.tooBlurCount = 0;
        continue;
        localHashMap.put("ui_tips", "ocr_no_card");
        localHashMap.put("ui_action", "card_not_found");
        continue;
        localHashMap.put("ui_tips", "ocr_pose_keep");
        localHashMap.put("ui_action", "pass");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.ocr.OcrCardAutoDetectState
 * JD-Core Version:    0.7.0.1
 */