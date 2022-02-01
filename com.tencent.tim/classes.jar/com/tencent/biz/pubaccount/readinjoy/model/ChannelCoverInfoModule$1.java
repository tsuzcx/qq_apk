package com.tencent.biz.pubaccount.readinjoy.model;

import aqec;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import lhn;
import org.json.JSONObject;

public class ChannelCoverInfoModule$1
  implements Runnable
{
  public ChannelCoverInfoModule$1(lhn paramlhn, TabChannelCoverInfo paramTabChannelCoverInfo) {}
  
  public void run()
  {
    if (this.e.redPoint != null) {
      this.e.redPointJson = aqec.convert2JSON(this.e.redPoint).toString();
    }
    this.this$0.a(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule.1
 * JD-Core Version:    0.7.0.1
 */