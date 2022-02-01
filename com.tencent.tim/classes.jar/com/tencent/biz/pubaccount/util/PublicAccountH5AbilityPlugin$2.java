package com.tencent.biz.pubaccount.util;

import akyj;
import anot;
import aqmr;
import com.tencent.mobileqq.pic.CompressInfo;
import java.util.HashMap;
import obw;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PublicAccountH5AbilityPlugin$2
  implements Runnable
{
  public PublicAccountH5AbilityPlugin$2(obw paramobw, JSONArray paramJSONArray, JSONObject paramJSONObject) {}
  
  public void run()
  {
    CompressInfo localCompressInfo = new CompressInfo(this.this$0.apB, 0);
    localCompressInfo.picType = 0;
    akyj.b(localCompressInfo);
    String str;
    if (!aqmr.isEmpty(localCompressInfo.destPath))
    {
      str = "mqqpa://resourceid/" + this.this$0.apD;
      obw.eH.put(str, localCompressInfo.destPath);
    }
    for (;;)
    {
      try
      {
        this.val$jsonArray.put(0, str);
        this.val$res.put("value", this.val$jsonArray);
        this.val$res.put("retCode", 0);
        this.val$res.put("msg", "Success");
        this.val$res.put("sourceType", "camera");
        this.this$0.callJs(this.this$0.apC, new String[] { this.val$res.toString() });
        anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005895", "0X8005895", 0, 0, "1", "", "", "");
        this.this$0.apB = "";
        this.this$0.apC = "";
        this.this$0.apD = "";
        return;
      }
      catch (JSONException localJSONException1)
      {
        localJSONException1.printStackTrace();
        continue;
      }
      try
      {
        this.val$res.put("retCode", -1);
        this.val$res.put("msg", "compress fail");
        this.val$res.put("sourceType", "camera");
        this.this$0.callJs(this.this$0.apC, new String[] { this.val$res.toString() });
        anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005895", "0X8005895", 0, -1, "1", "", "", "");
      }
      catch (JSONException localJSONException2)
      {
        localJSONException2.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin.2
 * JD-Core Version:    0.7.0.1
 */