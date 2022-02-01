package com.tencent.viola.core;

import com.tencent.viola.adapter.ILogAdapter;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.commons.IReportDelegate;
import com.tencent.viola.commons.JSParam;
import com.tencent.viola.module.DomModule;
import com.tencent.viola.module.ViolaModuleManager;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ViolaBridge
{
  public static final String TAG = "ViolaBridge";
  private static ViolaBridge violaBridge;
  
  public static void callError(int paramInt, String paramString)
  {
    ViolaLogUtils.e("ViolaBridge", "callError info: type: " + paramInt + ";info: \n" + paramString);
    Object localObject = ViolaSDKManager.getInstance().getReportDelegate();
    if (localObject != null)
    {
      if (!ViolaSDKManager.getInstance().isRenderJsEnd()) {
        break label191;
      }
      ViolaSDKManager.getInstance().addRunningJsErrorCount();
      ((IReportDelegate)localObject).reportJsError(ViolaSDKManager.getInstance().isRenderJsEnd(), paramInt, paramString);
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        JSONObject localJSONObject1 = new JSONObject();
        JSONObject localJSONObject2 = new JSONObject();
        if (!ViolaSDKManager.getInstance().isRenderJsEnd()) {
          continue;
        }
        paramInt = 1;
        localJSONObject2.put("ifOpen", paramInt);
        localJSONObject1.put("error", paramString);
        localJSONObject1.put("tags", localJSONObject2);
        ((JSONObject)localObject).put("data", localJSONObject1);
        ((JSONObject)localObject).put("type", "error");
        ViolaSDKManager.getInstance().updateInstance(ViolaSDKManager.getInstance().getCurrentViolaInstance(), ((JSONObject)localObject).toString());
      }
      catch (Exception localException)
      {
        label191:
        ViolaLogUtils.e("ViolaBridge", "callError JSONException e:" + localException.getMessage());
        continue;
      }
      ViolaLogUtils.setLogText(paramString);
      localObject = ViolaSDKManager.getInstance().getLogAdapter();
      if (localObject != null) {
        ((ILogAdapter)localObject).onJSError(paramString);
      }
      return;
      ViolaSDKManager.getInstance().addJsErrorCount();
      ((IReportDelegate)localObject).addReportData(ViolaEnvironment.JS_ERROR_BEFORE_RENDER, Integer.toString(ViolaSDKManager.getInstance().getJsErrorCount()));
      break;
      paramInt = 0;
    }
  }
  
  public static ViolaBridge getInstance()
  {
    if (violaBridge == null) {
      violaBridge = new ViolaBridge();
    }
    return violaBridge;
  }
  
  public native int callJS(String paramString, byte[] paramArrayOfByte, int paramInt);
  
  public void callSerializableNative(String paramString, byte[] paramArrayOfByte)
  {
    for (;;)
    {
      int i;
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte);
        JSONArray localJSONArray = new JSONArray(paramArrayOfByte);
        i = 0;
        if (i < localJSONArray.length())
        {
          localJSONObject = localJSONArray.getJSONObject(i);
          localObject = localJSONObject.get("args");
          if (localJSONObject.has("module")) {
            if ("dom".equals(localJSONObject.getString("module")))
            {
              DomModule localDomModule = ViolaModuleManager.getDomModule(paramString);
              if (localDomModule != null) {
                localDomModule.invokeDomMethod(localJSONObject.getString("method"), localObject);
              }
            }
            else
            {
              ViolaBridgeManager.getInstance().callNativeModule(paramString, localJSONObject.getString("module"), localJSONObject.getString("method"), (JSONArray)localObject, null);
            }
          }
        }
      }
      catch (JSONException paramString)
      {
        JSONObject localJSONObject;
        Object localObject;
        ViolaLogUtils.e("ViolaBridge", "callSerializableNative JSONException e:" + paramString.getMessage());
        return;
        if (!localJSONObject.has("component")) {
          break label255;
        }
        ViolaBridgeManager.getInstance().callNativeComponent(paramString, localJSONObject.getString("component"), localJSONObject.getString("method"), (JSONArray)localObject);
      }
      catch (Exception paramString)
      {
        ViolaLogUtils.e("ViolaBridge", "callSerializableNative Exception e:" + paramString.getMessage());
        return;
      }
      ViolaLogUtils.d("ViolaBridge", "callSerializableNative params :" + paramArrayOfByte);
      return;
      label255:
      i += 1;
    }
  }
  
  public native int createInstance(String paramString1, byte[] paramArrayOfByte, int paramInt, String paramString2, String paramString3);
  
  public native int destroy();
  
  public native int destroyInstance(String paramString);
  
  public native int execJSFunc(String paramString, byte[] paramArrayOfByte, int paramInt);
  
  public native JSParam execJSFuncWithResult(String paramString, List<JSParam> paramList);
  
  public native int init();
  
  public native int initJsFramework(byte[] paramArrayOfByte, int paramInt, String paramString);
  
  public void preloadTest(String paramString1, String paramString2)
  {
    for (;;)
    {
      int i;
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString2);
        i = 0;
        if (i < localJSONArray.length())
        {
          localJSONObject = localJSONArray.getJSONObject(i);
          localObject = localJSONObject.get("args");
          if (localJSONObject.has("module")) {
            if ("dom".equals(localJSONObject.getString("module")))
            {
              DomModule localDomModule = ViolaModuleManager.getDomModule(paramString1);
              if (localDomModule != null)
              {
                ViolaLogUtils.d("debugForTimeCost", "preloadTest  invokeDomMethod: " + System.currentTimeMillis());
                localDomModule.invokeDomMethod(localJSONObject.getString("method"), localObject);
              }
            }
            else
            {
              ViolaBridgeManager.getInstance().callNativeModule(paramString1, localJSONObject.getString("module"), localJSONObject.getString("method"), (JSONArray)localObject, null);
            }
          }
        }
      }
      catch (JSONException paramString1)
      {
        JSONObject localJSONObject;
        Object localObject;
        ViolaLogUtils.e("ViolaBridge", "callSerializableNative JSONException e:" + paramString1.getMessage());
        return;
        if (!localJSONObject.has("component")) {
          break label272;
        }
        ViolaBridgeManager.getInstance().callNativeComponent(paramString1, localJSONObject.getString("component"), localJSONObject.getString("method"), (JSONArray)localObject);
      }
      catch (Exception paramString1)
      {
        ViolaLogUtils.e("ViolaBridge", "callSerializableNative Exception e:" + paramString1.getMessage());
        return;
      }
      ViolaLogUtils.d("ViolaBridge", "callSerializableNative params :" + paramString2);
      return;
      label272:
      i += 1;
    }
  }
  
  public void setTimeoutNative(String paramString, int paramInt)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(paramString);
      localJSONArray.put(paramInt);
      ViolaModuleManager.callModuleMethod(ViolaSDKManager.getCurInstanceId(), "jsTimer", "setTimeout", localJSONArray);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return;
    }
    catch (JSONException paramString) {}
  }
  
  public native int updateInstance(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.core.ViolaBridge
 * JD-Core Version:    0.7.0.1
 */