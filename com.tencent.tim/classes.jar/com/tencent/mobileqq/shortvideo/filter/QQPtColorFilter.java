package com.tencent.mobileqq.shortvideo.filter;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.av.video.effect.utils.CommonUtils;
import com.tencent.filter.ttpic.GPUImageLookupFilter;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.shortvideo.resource.AVFilterResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.baseutils.device.DeviceInstance;
import com.tencent.view.RendererUtils;
import java.io.File;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

public class QQPtColorFilter
  extends QQBaseFilter
{
  public static final String TAG = "QQPtColorFilter";
  private static HashSet blackList = new HashSet();
  private boolean bwork = false;
  private String currentFilterPath;
  private VideoFilterBase effectFilter;
  private boolean hasinit = false;
  private GPUImageLookupFilter internalFilter = new GPUImageLookupFilter();
  private boolean isLoadSoSuccess = false;
  private int lastHeight = 0;
  private int lastWidth = 0;
  private Frame mCacheFrame = new Frame();
  private int[] mPtColorTextureId = new int[1];
  private boolean needChange = false;
  private String newFilterPath = null;
  
  static
  {
    blackList.add("HUAWEI_ALP-AL00");
  }
  
  public QQPtColorFilter(QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(999, paramQQFilterRenderManager);
    GPUImageLookupFilter.jarPath = null;
  }
  
  public static QQPtColorFilterInfo getColorFilterInfo(String paramString)
  {
    try
    {
      paramString = CommonUtils.getInputStreamFromPath(SdkContext.getInstance().getApplication(), paramString + File.separator + "params.json");
      if (paramString == null) {
        break label241;
      }
      paramString = CommonUtils.convertStreamToString(paramString);
      if (paramString == null) {
        break label241;
      }
      paramString = new JSONObject(paramString);
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        SLog.e("QQPtColorFilterInfo", "getColorFilterInfo:" + paramString);
        Object localObject = null;
        continue;
        for (;;)
        {
          try
          {
            if (!((JSONObject)localObject).has("filterId")) {
              break label236;
            }
            i = Integer.valueOf(((JSONObject)localObject).getString("filterId")).intValue();
            if (!((JSONObject)localObject).has("name")) {
              break label231;
            }
            paramString = ((JSONObject)localObject).getString("name");
            if (!((JSONObject)localObject).has("subId")) {
              break label226;
            }
            j = Integer.valueOf(((JSONObject)localObject).getString("subId")).intValue();
            if (((JSONObject)localObject).has("resourceList"))
            {
              localObject = ((JSONObject)localObject).getJSONArray("resourceList");
              if ((localObject != null) && (((JSONArray)localObject).length() > 0))
              {
                localObject = ((JSONArray)localObject).get(0).toString();
                paramString = new QQPtColorFilterInfo(i, paramString, j, (String)localObject);
                return paramString;
              }
            }
          }
          catch (Exception paramString)
          {
            return null;
          }
          localObject = null;
          continue;
          label226:
          int j = -1;
          continue;
          label231:
          paramString = null;
          continue;
          label236:
          int i = -1;
        }
        label241:
        paramString = null;
      }
    }
    localObject = paramString;
    if (localObject == null)
    {
      if (SLog.isEnable()) {
        SLog.e("QQPtColorFilterInfo", "filterConfig == null!");
      }
      return null;
    }
  }
  
  private void init(int paramInt1, int paramInt2)
  {
    release();
    this.internalFilter.applyFilterChain(true, paramInt1, paramInt2);
    GLES20.glGenTextures(this.mPtColorTextureId.length, this.mPtColorTextureId, 0);
    this.hasinit = true;
  }
  
  private void release()
  {
    if (!this.isLoadSoSuccess) {
      return;
    }
    if (this.internalFilter != null) {
      this.internalFilter.ClearGLSL();
    }
    this.mCacheFrame.clear();
    GLES20.glDeleteTextures(this.mPtColorTextureId.length, this.mPtColorTextureId, 0);
    if (SLog.isEnable()) {
      SLog.d("QQPtColorFilter", "reslease internalFilter");
    }
    this.hasinit = false;
  }
  
  private void setNeedChangeFilter(String paramString, boolean paramBoolean)
  {
    try
    {
      this.newFilterPath = paramString;
      this.needChange = paramBoolean;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public boolean isFilterWork()
  {
    return this.bwork;
  }
  
  public void onDrawFrame()
  {
    if ((TextUtils.isEmpty(this.newFilterPath)) && (TextUtils.isEmpty(this.currentFilterPath)) && (this.effectFilter == null))
    {
      this.mOutputTextureID = this.mInputTextureID;
      return;
    }
    this.lastWidth = getQQFilterRenderManager().getFilterWidth();
    this.lastHeight = getQQFilterRenderManager().getFilterHeight();
    if (!this.isLoadSoSuccess) {
      this.isLoadSoSuccess = getQQFilterRenderManager().loadFilterSoSuccess();
    }
    if (!this.isLoadSoSuccess)
    {
      this.mOutputTextureID = this.mInputTextureID;
      return;
    }
    if (!this.hasinit)
    {
      init(this.lastWidth, this.lastHeight);
      this.mOutputTextureID = this.mInputTextureID;
      return;
    }
    if ((this.effectFilter != null) && (this.effectFilter.isValid()))
    {
      this.mOutputTextureID = this.effectFilter.RenderProcess(this.mInputTextureID, this.lastWidth, this.lastHeight).getTextureId();
      return;
    }
    Object localObject = this.newFilterPath;
    if (this.needChange)
    {
      setNeedChangeFilter(null, false);
      this.currentFilterPath = ((String)localObject);
      this.internalFilter.updateLut(this.currentFilterPath);
    }
    if (TextUtils.isEmpty(this.currentFilterPath))
    {
      this.mOutputTextureID = this.mInputTextureID;
      return;
    }
    this.internalFilter.RenderProcess(this.mInputTextureID, this.lastWidth, this.lastHeight, this.mPtColorTextureId[0], 0.0D, this.mCacheFrame);
    if (blackList.contains(DeviceInstance.getInstance().getDeviceName()))
    {
      localObject = RendererUtils.saveTexture(this.mCacheFrame);
      Log.e("QQPtColorFilter", "Save bitmap to avoid black lines " + ((Bitmap)localObject).getWidth());
      ((Bitmap)localObject).recycle();
    }
    this.mOutputTextureID = this.mPtColorTextureId[0];
  }
  
  public void onSurfaceChange(int paramInt1, int paramInt2)
  {
    if (!this.isLoadSoSuccess) {}
    while ((this.lastHeight == paramInt1) && (this.lastHeight == paramInt2)) {
      return;
    }
    init(paramInt1, paramInt2);
  }
  
  public void onSurfaceDestroy()
  {
    if (this.hasinit)
    {
      release();
      if (this.effectFilter != null) {
        this.effectFilter.clearGLSLSelf();
      }
    }
  }
  
  public void setEffectFilter(VideoFilterBase paramVideoFilterBase)
  {
    if (this.effectFilter != null)
    {
      this.effectFilter.clearGLSLSelf();
      this.effectFilter = null;
    }
    this.effectFilter = paramVideoFilterBase;
  }
  
  public void setLutResPath(FilterDesc paramFilterDesc)
  {
    if (paramFilterDesc == null)
    {
      setNeedChangeFilter(null, true);
      this.bwork = false;
      return;
    }
    String str2 = SdkContext.getInstance().getResources().getAvFilterResource().getFilterResPath();
    String str1 = "";
    if (paramFilterDesc != null) {
      if (TextUtils.isEmpty(paramFilterDesc.resRootPath)) {
        break label117;
      }
    }
    label117:
    for (str1 = paramFilterDesc.getResFold(paramFilterDesc.resRootPath);; str1 = paramFilterDesc.getResFold(str2))
    {
      paramFilterDesc = getColorFilterInfo(str1);
      if (paramFilterDesc == null) {
        break;
      }
      paramFilterDesc = str1 + paramFilterDesc.getColorPng();
      if (!new File(paramFilterDesc).exists()) {
        break;
      }
      setNeedChangeFilter(paramFilterDesc, true);
      this.bwork = true;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQPtColorFilter
 * JD-Core Version:    0.7.0.1
 */