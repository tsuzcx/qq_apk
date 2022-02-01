package com.tencent.mobileqq.apollo;

import aqgz;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class ApolloRender$4
  implements Runnable
{
  ApolloRender$4(ApolloRender paramApolloRender, String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  public void run()
  {
    try
    {
      Object localObject2 = aqgz.getModel();
      String str = aqgz.getDeviceOSVersion();
      int i = aqgz.getCpuNumber();
      long l1 = aqgz.getCpuFrequency();
      long l2 = Math.ceil(aqgz.getSystemTotalMemory() / 1073741824.0D);
      long l3 = aqgz.getWidth();
      long l4 = aqgz.getHeight();
      float f = aqgz.getDesity();
      Object localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("mo", localObject2);
      ((JSONObject)localObject1).put("os", str);
      ((JSONObject)localObject1).put("cc", String.valueOf(i));
      ((JSONObject)localObject1).put("cf", String.valueOf(l1));
      ((JSONObject)localObject1).put("mm", String.valueOf(l2));
      ((JSONObject)localObject1).put("w", String.valueOf(l3));
      ((JSONObject)localObject1).put("h", String.valueOf(l4));
      ((JSONObject)localObject1).put("d", String.valueOf(f));
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("vd", this.bgk);
      ((JSONObject)localObject2).put("vs", this.bgl);
      ((JSONObject)localObject2).put("rd", this.bgm);
      localObject1 = ((JSONObject)localObject1).toString();
      localObject2 = ((JSONObject)localObject2).toString();
      VipUtils.a(null, "cmshow", "Apollo", "device_info", 0, 0, new String[] { String.valueOf(this.val$gameId), localObject1, localObject2 });
      QLog.i("sava_ApolloRender", 1, " onSurfaceCreated report 644 data: " + (String)localObject1 + ";" + (String)localObject2);
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.d("sava_ApolloRender", 2, " onSurfaceCreated report 644 data fail: " + localJSONException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender.4
 * JD-Core Version:    0.7.0.1
 */