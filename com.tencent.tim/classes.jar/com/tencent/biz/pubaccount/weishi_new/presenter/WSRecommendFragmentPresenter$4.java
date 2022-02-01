package com.tencent.biz.pubaccount.weishi_new.presenter;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBField;
import cooperation.qzone.LocalMultiProcConfig;
import omc;
import org.json.JSONException;
import org.json.JSONObject;
import tkv;
import tkw;
import tlm;
import tlm.a;
import tlm.b;

public final class WSRecommendFragmentPresenter$4
  implements Runnable
{
  public void run()
  {
    Object localObject1 = new tlm.a();
    ((tlm.a)localObject1).aJy = "23c763";
    localObject1 = tlm.a(BaseApplicationImpl.getContext(), (tlm.a)localObject1);
    if (localObject1 != null)
    {
      localObject1 = ((tlm.b)localObject1).b;
      JSONObject localJSONObject = null;
      if (localObject1 == null) {
        localObject1 = localJSONObject;
      }
      for (;;)
      {
        try
        {
          localJSONObject = new JSONObject(omc.access$300());
          if ((localObject1 == null) || (localObject1 == JSONObject.NULL)) {
            break label146;
          }
          omc.e((JSONObject)localObject1, localJSONObject);
          tkw.e("WSRecommendFragmentPresenter", "setGdtArgs success args =" + omc.access$300());
          return;
        }
        catch (JSONException localJSONException)
        {
          Object localObject2;
          tkw.d("WSRecommendFragmentPresenter", localJSONException.getMessage());
          return;
        }
        localObject2 = tkv.pbToJson((PBField)localObject1);
        localObject1 = localJSONObject;
        if (localObject2 != null)
        {
          localObject1 = localJSONObject;
          if ((localObject2 instanceof JSONObject))
          {
            localObject1 = (JSONObject)JSONObject.class.cast(localObject2);
            LocalMultiProcConfig.putString("cache_key_gdt_args", ((JSONObject)localObject1).toString());
            continue;
            label146:
            tkw.e("WSRecommendFragmentPresenter", "onResult error");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.presenter.WSRecommendFragmentPresenter.4
 * JD-Core Version:    0.7.0.1
 */