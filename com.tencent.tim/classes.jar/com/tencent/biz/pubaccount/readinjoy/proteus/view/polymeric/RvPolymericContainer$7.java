package com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import ltp;
import lty;
import org.json.JSONArray;

public class RvPolymericContainer$7
  implements Runnable
{
  public RvPolymericContainer$7(ltp paramltp, JSONArray paramJSONArray) {}
  
  public void run()
  {
    ltp.a(this.this$0).setCellArray(ltp.b(this.this$0).getTemplateFactory(), this.v);
    ltp.a(this.this$0).notifyDataSetChanged();
    this.this$0.aNq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.RvPolymericContainer.7
 * JD-Core Version:    0.7.0.1
 */