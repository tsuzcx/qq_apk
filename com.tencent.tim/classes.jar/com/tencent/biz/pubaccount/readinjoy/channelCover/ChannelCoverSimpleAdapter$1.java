package com.tencent.biz.pubaccount.readinjoy.channelCover;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import kbp;
import kct;
import kqn;
import nce;
import nce.a;
import org.json.JSONException;
import org.json.JSONObject;

public class ChannelCoverSimpleAdapter$1
  implements Runnable
{
  public ChannelCoverSimpleAdapter$1(kqn paramkqn, ChannelCoverInfo paramChannelCoverInfo) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if ((kqn.a(this.this$0) != null) && ((kqn.a(this.this$0) instanceof Activity)) && (((Activity)kqn.a(this.this$0)).getIntent() != null))
        {
          i = ((Activity)kqn.a(this.this$0)).getIntent().getIntExtra("channel_from", -1);
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("is_followed", "1");
          kbp.a(null, "", "0X8007BE6", "0X8007BE6", 0, 0, "1", "", "", new nce.a(kct.a(this.c.mChannelCoverId, localJSONObject)).O(i).a().toJsonString(), false);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.channelCover.ChannelCoverSimpleAdapter.1
 * JD-Core Version:    0.7.0.1
 */