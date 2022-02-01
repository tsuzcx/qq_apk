package com.tencent.viola.ui.baseComponent;

import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.commons.AssocioationEvents;
import com.tencent.viola.commons.JSParam;
import com.tencent.viola.core.ViolaDomManager;
import com.tencent.viola.core.ViolaEnvironment;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.ui.action.DOMAction;
import com.tencent.viola.ui.action.MethodUpdateElement;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class VComponent$2
  implements Runnable
{
  VComponent$2(VComponent paramVComponent, JSParam paramJSParam) {}
  
  public void run()
  {
    if (VComponent.access$200(this.this$0) == null) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
    } while (this.val$jsParam == null);
    localArrayList.add(this.val$jsParam);
    long l = System.currentTimeMillis();
    for (;;)
    {
      int i;
      JSONObject localJSONObject1;
      JSONObject localJSONObject2;
      Object localObject1;
      JSONObject localJSONObject3;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      try
      {
        JSONArray localJSONArray = VComponent.access$200(this.this$0).mProps;
        i = 0;
        if (i < localJSONArray.length())
        {
          localJSONObject1 = new JSONObject();
          localJSONObject2 = localJSONArray.getJSONObject(i);
          if (!localJSONObject2.has(AssocioationEvents.ASSOCIOATION_PROPS_KEY_TARGET)) {
            break label533;
          }
          localObject1 = localJSONObject2.getString(AssocioationEvents.ASSOCIOATION_PROPS_KEY_TARGET);
          if (!localJSONObject2.has(AssocioationEvents.ASSOCIOATION_PROPS_KEY_STYLE)) {
            break label280;
          }
          localJSONObject3 = new JSONObject();
          localObject2 = localJSONObject2.getJSONObject(AssocioationEvents.ASSOCIOATION_PROPS_KEY_STYLE);
          localObject3 = ((JSONObject)localObject2).keys();
          if (!((Iterator)localObject3).hasNext()) {
            break label261;
          }
          localObject4 = (String)((Iterator)localObject3).next();
          Object localObject5 = ((JSONObject)localObject2).getString((String)localObject4);
          localObject5 = ViolaBridgeManager.getInstance().execJSFuncByNameWithResult((String)localObject5, localArrayList);
          if ((localObject5 == null) || (((JSParam)localObject5).data == null)) {
            continue;
          }
          localJSONObject3.put((String)localObject4, (String)((JSParam)localObject5).data);
          continue;
        }
        if (!ViolaEnvironment.isDebugable()) {
          break;
        }
      }
      catch (JSONException localJSONException) {}
      ViolaLogUtils.d("VComponent", "richGesture all jsFunction cost:" + (System.currentTimeMillis() - l) + "ms");
      return;
      label261:
      if (localJSONObject3.length() > 0) {
        localJSONObject1.put(AssocioationEvents.ASSOCIOATION_PROPS_KEY_STYLE, localJSONObject3);
      }
      label280:
      if (localJSONObject2.has(AssocioationEvents.ASSOCIOATION_PROPS_KEY_ATTR))
      {
        localJSONObject3 = new JSONObject();
        localJSONObject2 = localJSONObject2.getJSONObject(AssocioationEvents.ASSOCIOATION_PROPS_KEY_ATTR);
        localObject2 = localJSONObject2.keys();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          localObject4 = localJSONObject2.getString((String)localObject3);
          localObject4 = ViolaBridgeManager.getInstance().execJSFuncByNameWithResult((String)localObject4, localJSONException);
          if ((localObject4 != null) && (((JSParam)localObject4).data != null)) {
            localJSONObject3.put((String)localObject3, (String)((JSParam)localObject4).data);
          }
        }
        if (localJSONObject3.length() > 0) {
          localJSONObject1.put(AssocioationEvents.ASSOCIOATION_PROPS_KEY_ATTR, localJSONObject3);
        }
      }
      if (ViolaEnvironment.isDebugable()) {
        ViolaLogUtils.d("VComponent", "richGesture one prop js handCost :" + (System.currentTimeMillis() - l));
      }
      if (localJSONObject1.length() > 0)
      {
        localObject1 = new MethodUpdateElement((String)localObject1, localJSONObject1);
        if ((localObject1 instanceof DOMAction))
        {
          ViolaSDKManager.getInstance().getDomManager().postTransitionTask(this.this$0.getInstance().getInstanceId(), (DOMAction)localObject1, false);
          if (ViolaEnvironment.isDebugable()) {
            ViolaLogUtils.d("VComponent", "richGesture update :" + localJSONObject1.toString());
          }
        }
      }
      label533:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.baseComponent.VComponent.2
 * JD-Core Version:    0.7.0.1
 */