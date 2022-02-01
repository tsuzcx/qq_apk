package com.tencent.biz.pubaccount.util;

import akyj;
import anot;
import aqmr;
import com.tencent.mobileqq.pic.CompressInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import obw;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PublicAccountH5AbilityPlugin$3
  implements Runnable
{
  public PublicAccountH5AbilityPlugin$3(obw paramobw, ArrayList paramArrayList, JSONArray paramJSONArray, JSONObject paramJSONObject) {}
  
  public void run()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.val$list.size())
        {
          String str = UUID.randomUUID().toString();
          str = "mqqpa://resourceid/" + str;
          this.val$jsonArray.put(i, str);
          CompressInfo localCompressInfo = new CompressInfo((String)this.val$list.get(i), 0);
          localCompressInfo.picType = 0;
          akyj.b(localCompressInfo);
          if (!aqmr.isEmpty(localCompressInfo.destPath)) {
            obw.eH.put(str, localCompressInfo.destPath);
          } else {
            obw.eH.put(str, this.val$list.get(i));
          }
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      this.val$res.put("value", this.val$jsonArray);
      this.val$res.put("retCode", 0);
      this.val$res.put("msg", "Success");
      this.val$res.put("sourceType", "album");
      this.this$0.callJs(this.this$0.apC, new String[] { this.val$res.toString() });
      this.this$0.apC = "";
      anot.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005895", "0X8005895", 0, 0, "1", "", "", "");
      return;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin.3
 * JD-Core Version:    0.7.0.1
 */