package com.tencent.viola.ui.component;

import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.viola.adapter.VComponentAdapter;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.view.VRefreshLayout;
import com.tencent.viola.ui.view.refresh.VRefreshViewGroup;
import org.json.JSONObject;

public class VKdRefresh
  extends VRefresh
{
  public VKdRefresh(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
  }
  
  public void destroy()
  {
    super.destroy();
    if (getHostView() != null) {
      ((VRefreshLayout)getHostView()).destroy();
    }
  }
  
  public VRefreshLayout initComponentHostView(@NonNull Context paramContext)
  {
    paramContext = new VRefreshLayout(paramContext);
    paramContext.bindComponent(this);
    paramContext.mComponentType = 3;
    ViolaSDKManager.getInstance().getComponentAdapter().initKdRefresh(paramContext);
    return paramContext;
  }
  
  @JSMethod(uiThread=true)
  public void refresh()
  {
    if (((getHostView() instanceof VRefreshLayout)) && ((((VRefreshLayout)getHostView()).getParent() instanceof VRefreshViewGroup))) {
      ((VRefreshViewGroup)((VRefreshLayout)getHostView()).getParent()).scrollerToTop(true, false);
    }
  }
  
  @JSMethod(uiThread=true)
  public void refreshFinishWithParams(JSONObject paramJSONObject, String paramString)
  {
    if (((getHostView() instanceof VRefreshLayout)) && ((((VRefreshLayout)getHostView()).getParent() instanceof VRefreshViewGroup)))
    {
      int i = paramJSONObject.optInt("type", 1);
      String str = paramJSONObject.optString("text", null);
      int j = paramJSONObject.optInt("duration", 1200);
      int k = paramJSONObject.optInt("delay", 300);
      ViolaSDKManager.getInstance().postOnUiThreadDelay(new VKdRefresh.1(this, i, str), k);
      ViolaSDKManager.getInstance().postOnUiThreadDelay(new VKdRefresh.2(this, paramString), j + k + 500);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.component.VKdRefresh
 * JD-Core Version:    0.7.0.1
 */