package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;
import java.util.List;
import kbp;
import kxm;
import lhf;
import luq.b;
import nxt;
import org.json.JSONObject;

public class ArticleInfoModule$1
  implements Runnable
{
  public ArticleInfoModule$1(lhf paramlhf, luq.b paramb, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    ToServiceMsg localToServiceMsg = lhf.a(this.this$0, this.a);
    if (localToServiceMsg != null)
    {
      localToServiceMsg.getAttributes().put("feedsRequestBeginTime", Long.valueOf(this.uj));
      localToServiceMsg.getAttributes().put("feedsRequestVersion", Long.valueOf(this.uk));
      if (this.a.extraData != null) {
        localToServiceMsg.getAttributes().put("request_extra_data_key", this.a.extraData);
      }
      localToServiceMsg.getAttributes().put("auto_refresh_src", Integer.valueOf(this.a.aPY));
      if ((this.a.aPZ & 0x40) != 0) {
        localToServiceMsg.getAttributes().put("recommendFlag", Integer.valueOf(this.a.aPZ));
      }
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      long l2 = -1L;
      long l1 = l2;
      if (this.a.iu != null)
      {
        l1 = l2;
        if (this.a.iu.size() >= 1) {
          l1 = ((Long)this.a.iu.get(0)).longValue();
        }
      }
      localJSONObject.put("preload_red_pnt_push_articleID", l1);
      kbp.a(null, "", "0X8009482", "0X8009482", 0, 0, localJSONObject.toString(), "", "", "", false);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    if ((this.a.channelID == 0) && (kxm.AI())) {
      this.this$0.p("-1", 1, 0);
    }
    this.this$0.sendPbReq(localToServiceMsg);
    nxt.a().i(localToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.1
 * JD-Core Version:    0.7.0.1
 */