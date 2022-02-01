package com.tencent.viola.ui.action;

import android.text.TextUtils;
import com.tencent.viola.core.ViolaDomManager;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.context.DOMActionContext;
import com.tencent.viola.ui.context.RenderActionContext;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.utils.ViolaLogUtils;
import org.json.JSONObject;

public class MethodCreateBody
  extends MethodAbsAdd
{
  public static String TAG = "MethodCreateBody";
  private JSONObject mData;
  
  public MethodCreateBody(JSONObject paramJSONObject)
  {
    this.mData = paramJSONObject;
  }
  
  protected void appendDomToTree(DOMActionContext paramDOMActionContext, DomObject paramDomObject)
  {
    ViolaInstance localViolaInstance = paramDOMActionContext.getInstance();
    if (localViolaInstance != null)
    {
      float f = localViolaInstance.getRenderContainerHeight() / FlexConvertUtils.getScreenWidth() * 750.0F;
      if (f == 0.0F)
      {
        localViolaInstance.setRootMeasuredExactly(false);
        ViolaLogUtils.e(TAG, "测试算出来的高度：appendDomToTree");
      }
      paramDomObject.initRoot(paramDomObject.getRef(), f, 750.0F);
      paramDOMActionContext.setRootRef(paramDomObject.getRef());
      this.mRootRef = paramDomObject.getRef();
    }
  }
  
  protected VComponent createComponent(DOMActionContext paramDOMActionContext, DomObject paramDomObject)
  {
    return generateComponentTree(paramDOMActionContext, paramDomObject, null);
  }
  
  public void executeDom(DOMActionContext paramDOMActionContext)
  {
    ViolaLogUtils.d("debugForTimeCost", "executeDom before : " + System.currentTimeMillis());
    ViolaInstance localViolaInstance = paramDOMActionContext.getInstance();
    long l = System.currentTimeMillis();
    addDomInternal(paramDOMActionContext, this.mData);
    paramDOMActionContext.postRenderTask(this);
    ViolaLogUtils.d("debugForTimeCost", "executeDom after : " + System.currentTimeMillis());
    if (localViolaInstance != null)
    {
      localViolaInstance.mLayoutStart = l;
      localViolaInstance.mLayoutEnd = System.currentTimeMillis();
      ViolaLogUtils.d("debugForTimeCost", "executeDom : " + (System.currentTimeMillis() - l));
    }
  }
  
  public void executeRender(RenderActionContext paramRenderActionContext)
  {
    if ((paramRenderActionContext == null) || (TextUtils.isEmpty(this.mRootRef))) {
      return;
    }
    ViolaLogUtils.e(TAG, "violaInstance executeRender start!");
    VComponent localVComponent = paramRenderActionContext.getComponent(this.mRootRef);
    paramRenderActionContext = paramRenderActionContext.getInstance();
    if ((paramRenderActionContext == null) || (paramRenderActionContext.getContext() == null))
    {
      ViolaLogUtils.e(TAG, "instance is null or instance is destroy!");
      return;
    }
    if (ViolaSDKManager.getInstance().getRenderManager() == null)
    {
      ViolaLogUtils.e(TAG, "violaInstance renderManager null!");
      return;
    }
    paramRenderActionContext.mCreateViewStart = System.currentTimeMillis();
    float f;
    if (!paramRenderActionContext.isRootMeasuredExactly())
    {
      f = paramRenderActionContext.getRenderContainerHeight() / FlexConvertUtils.getScreenWidth() * 750.0F;
      if (f != 0.0F) {
        break label189;
      }
      paramRenderActionContext.setRootMeasuredExactly(false);
    }
    for (;;)
    {
      localVComponent.createView();
      paramRenderActionContext.mCreateViewEnd = System.currentTimeMillis();
      paramRenderActionContext.mApplyLayoutAndEventStart = System.currentTimeMillis();
      localVComponent.applyLayoutAndEvent();
      paramRenderActionContext.mApplyLayoutAndEventEnd = System.currentTimeMillis();
      paramRenderActionContext.mBindDataStart = System.currentTimeMillis();
      localVComponent.bindData();
      paramRenderActionContext.mBindDataEnd = System.currentTimeMillis();
      ViolaLogUtils.e(TAG, "violaInstance executeRender end!");
      if (!(localVComponent instanceof VComponentContainer)) {
        break;
      }
      paramRenderActionContext.onRootCreated((VComponentContainer)localVComponent);
      return;
      label189:
      localVComponent.getDomObject().initRoot(localVComponent.getDomObject().getRef(), f, 750.0F);
      if (f != localVComponent.getDomObject().getLayoutHeight()) {
        ViolaSDKManager.getInstance().getDomManager().forceBatch();
      }
      paramRenderActionContext.setRootMeasuredExactly(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.action.MethodCreateBody
 * JD-Core Version:    0.7.0.1
 */