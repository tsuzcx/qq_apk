package com.tencent.pts.core;

import android.text.TextUtils;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.itemview.PTSItemData.Builder;
import com.tencent.pts.core.itemview.PTSItemView;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.pts.utils.PTSLog;

public class PTSComposer
{
  private static final String TAG = "PTSComposer";
  private boolean hasDestroyed = false;
  private PTSAppInstance ptsAppInstance;
  
  public static PTSComposer buildComposer(String paramString1, String paramString2, String paramString3, float paramFloat, IPTSLiteEventListener paramIPTSLiteEventListener)
  {
    paramString1 = new PTSItemData.Builder().withPageName(paramString1).withFrameTreeJson(paramString2).withJsonData(paramString3).build();
    paramString1 = new PTSAppInstance.Builder().withRootNodeType(1).withItemData(paramString1).withContainerWidth(paramFloat).withLiteEventListener(paramIPTSLiteEventListener).build();
    paramString2 = new PTSComposer();
    paramString2.ptsAppInstance = paramString1;
    return paramString2;
  }
  
  public static PTSComposer buildComposer(String paramString1, String paramString2, String paramString3, IPTSLiteEventListener paramIPTSLiteEventListener)
  {
    return buildComposer(paramString1, paramString2, paramString3, PTSDeviceUtil.getScreenWidthDp(), paramIPTSLiteEventListener);
  }
  
  public void destroy()
  {
    if (!this.hasDestroyed)
    {
      this.ptsAppInstance.onDestroy();
      this.hasDestroyed = true;
    }
  }
  
  public PTSItemView layoutToView(PTSItemView paramPTSItemView)
  {
    if (paramPTSItemView == null)
    {
      PTSLog.e("PTSComposer", "[layoutToView] convertView is null.");
      return null;
    }
    this.ptsAppInstance.setContext(paramPTSItemView.getContext());
    this.ptsAppInstance.getRootNode().setRootView(paramPTSItemView);
    paramPTSItemView.bindData(this.ptsAppInstance);
    return paramPTSItemView;
  }
  
  public void setData(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    if (this.hasDestroyed)
    {
      PTSLog.i("PTSComposer", "[setData] failed, PTSComposer has been destroyed.");
      return;
    }
    paramString = this.ptsAppInstance.getItemData();
    paramString = new PTSItemData.Builder().withPageName(paramString.getPageName()).withFrameTreeJson(paramString.getFrameTreeJson()).withJsonData(str).build();
    this.ptsAppInstance.setItemData(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pts.core.PTSComposer
 * JD-Core Version:    0.7.0.1
 */