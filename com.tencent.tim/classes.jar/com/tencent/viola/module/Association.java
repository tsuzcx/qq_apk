package com.tencent.viola.module;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.commons.AssocioationEvents;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaRenderManager;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.ui.baseComponent.VComponent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Association
  extends BaseModule
{
  public static final String MODULE_NAME = "association";
  public static final String TAG = "Association";
  
  private void bind(@Nullable String paramString1, @Nullable String paramString2, @Nullable JSONArray paramJSONArray, @Nullable String paramString3, @Nullable String paramString4)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramJSONArray != null))
    {
      Object localObject = getViolaInstance();
      localObject = ViolaSDKManager.getInstance().getRenderManager().getComponent(((ViolaInstance)localObject).getInstanceId(), paramString1);
      if ((localObject != null) && (!((VComponent)localObject).isDestroyed())) {
        ((VComponent)localObject).setAssocioationEvents(new AssocioationEvents(paramString1, paramString2, paramJSONArray, paramString3, paramString4));
      }
    }
  }
  
  @JSMethod
  public void bind(@Nullable JSONObject paramJSONObject, @Nullable String paramString)
  {
    if ((paramJSONObject.has(AssocioationEvents.ASSOCIOATION_KEY_REF)) && (paramJSONObject.has(AssocioationEvents.ASSOCIOATION_KEY_EVENT)) && (paramJSONObject.has(AssocioationEvents.ASSOCIOATION_KEY_PROPS))) {}
    try
    {
      bind(paramJSONObject.getString(AssocioationEvents.ASSOCIOATION_KEY_REF), paramJSONObject.getString(AssocioationEvents.ASSOCIOATION_KEY_EVENT), paramJSONObject.getJSONArray(AssocioationEvents.ASSOCIOATION_KEY_PROPS), "", paramString);
      return;
    }
    catch (JSONException paramJSONObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.module.Association
 * JD-Core Version:    0.7.0.1
 */