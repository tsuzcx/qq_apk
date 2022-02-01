package com.tencent.viola.ui.action;

import android.text.TextUtils;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.context.DOMActionContext;
import com.tencent.viola.ui.context.RenderActionContext;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.DomObject.Consumer;
import com.tencent.viola.utils.ViolaUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class MethodUpdateElement
  implements DOMAction, RenderAction
{
  public static String TAG = "MethodUpdateElement";
  private DomObject mDomObject;
  private String mRef;
  private String mRootRef;
  private JSONObject mUpdateData;
  private boolean needReflow = false;
  
  public MethodUpdateElement(String paramString, JSONObject paramJSONObject)
  {
    this.mRef = paramString;
    this.mUpdateData = paramJSONObject;
  }
  
  private void tryCompatVR(Map<String, Object> paramMap, VComponent paramVComponent)
  {
    if ((paramMap == null) || (!paramMap.containsKey("vr")) || (paramVComponent == null) || (this.mDomObject == null)) {
      return;
    }
    paramVComponent.tryCompatVR(this.mDomObject);
  }
  
  public void executeDom(DOMActionContext paramDOMActionContext)
  {
    if ((paramDOMActionContext.isDestory()) || (this.mUpdateData == null)) {}
    DomObject localDomObject;
    do
    {
      return;
      localDomObject = paramDOMActionContext.getDomByRef(this.mRef);
    } while (localDomObject == null);
    try
    {
      if (this.mUpdateData.has("style"))
      {
        localDomObject.updateStyle(ViolaUtils.json2HashMap(this.mUpdateData.getJSONObject("style")));
        localDomObject.traverseTree(new DomObject.Consumer[] { paramDOMActionContext.getApplyStyleConsumer() });
      }
      if (this.mUpdateData.has("attr")) {
        localDomObject.updateAttr(ViolaUtils.json2HashMap(this.mUpdateData.getJSONObject("attr")));
      }
      this.mDomObject = localDomObject;
      paramDOMActionContext.getComponent(this.mRef);
      this.mRootRef = paramDOMActionContext.getRootRef();
      paramDOMActionContext.postRenderTask(this);
      return;
    }
    catch (JSONException paramDOMActionContext) {}
  }
  
  public void executeRender(RenderActionContext paramRenderActionContext)
  {
    int j = 1;
    VComponent localVComponent = paramRenderActionContext.getComponent(this.mRef);
    if ((localVComponent == null) || (TextUtils.isEmpty(this.mRootRef))) {
      return;
    }
    int k = 0;
    int i = k;
    for (;;)
    {
      try
      {
        Map localMap;
        if (this.mUpdateData.has("attr"))
        {
          localMap = ViolaUtils.json2HashMap(this.mUpdateData.getJSONObject("attr"));
          localVComponent.updateAttrs(localMap);
          tryCompatVR(localMap, localVComponent);
          i = k;
          if (DomObject.shouldDirty(localMap)) {
            i = 1;
          }
        }
        if (this.mUpdateData.has("style"))
        {
          localMap = ViolaUtils.json2HashMap(this.mUpdateData.getJSONObject("style"));
          localVComponent.updateStyle(localMap, true);
          if (DomObject.shouldDirty(localMap))
          {
            i = j;
            paramRenderActionContext = paramRenderActionContext.getComponent(this.mRootRef);
            if (paramRenderActionContext != null) {
              paramRenderActionContext.applyLayoutAndEvent();
            }
            if (this.mDomObject != null)
            {
              localVComponent.bindData(this.mDomObject);
              if (i != 0) {
                localVComponent.notifyChange(1, this.mRef);
              }
              localVComponent.notifyWhenChange("update", this.mDomObject);
            }
            localVComponent.updateLifeCycle("updated");
            return;
          }
        }
      }
      catch (JSONException paramRenderActionContext)
      {
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.action.MethodUpdateElement
 * JD-Core Version:    0.7.0.1
 */