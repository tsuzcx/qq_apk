package com.tencent.biz.pubaccount.readinjoy.view;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import kbp;
import kct;
import ndi;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyBaseAdapter$15
  implements Runnable
{
  public ReadInJoyBaseAdapter$15(ndi paramndi, BaseArticleInfo paramBaseArticleInfo) {}
  
  public void run()
  {
    if (this.b != null) {
      if (this.this$0.mChannelID != 56) {
        break label95;
      }
    }
    label95:
    for (JSONObject localJSONObject = new JSONObject();; localJSONObject = null) {
      try
      {
        localJSONObject.put("algorithm_id", this.b.mAlgorithmID);
        kbp.a(null, "", "0X8008AD1", "0X8008AD1", 0, 0, "", "", "", kct.a(this.b.mVideoVid, this.b.innerUniqueID, (int)this.b.mChannelID, localJSONObject), false);
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.15
 * JD-Core Version:    0.7.0.1
 */