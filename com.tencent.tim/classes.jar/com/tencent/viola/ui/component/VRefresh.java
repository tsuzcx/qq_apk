package com.tencent.viola.ui.component;

import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.annotation.VComponentProp;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.view.VRefreshLayout;
import com.tencent.viola.ui.view.refresh.VRefreshViewGroup;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class VRefresh
  extends VComponentContainer<VRefreshLayout>
{
  public VRefresh(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    super(paramViolaInstance, paramDomObject, paramVComponentContainer);
  }
  
  public void addEvent(String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        super.addEvent(paramString);
        return;
        if (paramString.equals("appear"))
        {
          i = 0;
          continue;
          if (paramString.equals("disappear"))
          {
            i = 1;
            continue;
            if (paramString.equals("pulling"))
            {
              i = 2;
              continue;
              if (paramString.equals("idle"))
              {
                i = 3;
                continue;
                if (paramString.equals("refresh")) {
                  i = 4;
                }
              }
            }
          }
        }
        break;
      }
    }
    this.mAppendEvents.add(paramString);
    return;
    this.mAppendEvents.add(paramString);
    return;
    this.mAppendEvents.add(paramString);
    return;
    this.mAppendEvents.add(paramString);
    return;
    this.mAppendEvents.add(paramString);
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
  public void refreshFinish(Object paramObject)
  {
    if (((getHostView() instanceof VRefreshLayout)) && ((((VRefreshLayout)getHostView()).getParent() instanceof VRefreshViewGroup)))
    {
      ((VRefreshViewGroup)((VRefreshLayout)getHostView()).getParent()).stopRefresh();
      ViolaLogUtils.d("VComponent", "refreshFinish :下拉刷新回调成功");
    }
  }
  
  public void refreshFireEvent(String paramString, JSONArray paramJSONArray, JSONObject paramJSONObject)
  {
    if (!this.mAppendEvents.contains(paramString)) {
      return;
    }
    fireEvent(paramString, paramJSONArray, paramJSONObject);
  }
  
  public boolean resetAttr(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!super.resetAttr(paramString))
    {
      bool1 = bool2;
      if (paramString.equals("refreshStick"))
      {
        setRefreshStick(false);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  @VComponentProp(name="refreshStick")
  public void setRefreshStick(boolean paramBoolean)
  {
    ((VRefreshLayout)getHostView()).setRefreshStick(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.component.VRefresh
 * JD-Core Version:    0.7.0.1
 */