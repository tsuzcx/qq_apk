package com.tencent.viola.ui.component;

import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.viola.annotation.VComponentProp;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.view.VRefreshLayout;

public class VHeaderView
  extends VRefresh
{
  public VHeaderView(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
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
    paramContext.mComponentType = 2;
    return paramContext;
  }
  
  public boolean resetAttr(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!super.resetAttr(paramString))
    {
      bool1 = bool2;
      if (paramString.equals("show"))
      {
        setShow(0);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  @VComponentProp(name="show")
  public void setShow(int paramInt)
  {
    ((VRefreshLayout)getHostView()).notifyShowUpdate(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.component.VHeaderView
 * JD-Core Version:    0.7.0.1
 */