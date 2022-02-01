package com.tencent.biz.pubaccount.weishi_new.verticalvideo.data;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBField;
import cooperation.qzone.LocalMultiProcConfig;
import oqp;
import org.json.JSONException;
import org.json.JSONObject;
import tkv;
import tkw;
import tlm;
import tlm.a;
import tlm.b;

public final class WSVerticalDataManager$2
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
          localJSONObject = new JSONObject(oqp.access$500());
          if ((localObject1 == null) || (localObject1 == JSONObject.NULL)) {
            break label146;
          }
          oqp.f((JSONObject)localObject1, localJSONObject);
          tkw.e("WSVerticalDataManagerLog", "setGdtArgs success args =" + oqp.access$500());
          return;
        }
        catch (JSONException localJSONException)
        {
          Object localObject2;
          tkw.d("WSVerticalDataManagerLog", localJSONException.getMessage());
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
            tkw.e("WSVerticalDataManagerLog", "onResult error");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager.2
 * JD-Core Version:    0.7.0.1
 */