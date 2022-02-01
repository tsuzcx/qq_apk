package com.tencent.mobileqq.startup.step;

import aciu;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.collector.ResultObject;
import com.tencent.mfsdk.reporter.ReporterMachine;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class InitMagnifierSDK
  extends Step
{
  public static void b(JSONObject paramJSONObject, long paramLong)
  {
    try
    {
      paramJSONObject.put("MemorySize", paramLong);
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("p_id", MagnifierSDK.getProductId());
      localJSONObject1.put("plugin", String.valueOf(22));
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("memorydata", paramJSONObject);
      localJSONObject2.put("clientinfo", localJSONObject1);
      localJSONObject2.put("newplugin", 129);
      ReporterMachine.b(new ResultObject(0, "testcase", false, 1L, 1L, localJSONObject2, true, true, MagnifierSDK.uin));
      if (QLog.isColorLevel()) {
        QLog.d("QQ_QAPM", 2, "reportTOAPM : " + localJSONObject2.toString());
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QQ_QAPM", 2, paramJSONObject, new Object[0]);
    }
  }
  
  protected boolean doStep()
  {
    if (aciu.abf()) {
      MagnifierSDK.a().start();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitMagnifierSDK
 * JD-Core Version:    0.7.0.1
 */