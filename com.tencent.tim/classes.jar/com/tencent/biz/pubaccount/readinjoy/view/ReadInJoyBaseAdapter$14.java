package com.tencent.biz.pubaccount.readinjoy.view;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import kbp;
import nce;
import nce.a;
import ndi;

public class ReadInJoyBaseAdapter$14
  implements Runnable
{
  public ReadInJoyBaseAdapter$14(ndi paramndi, BaseArticleInfo paramBaseArticleInfo) {}
  
  public void run()
  {
    if (this.b != null) {
      kbp.a(null, "", "0X8008E28", "0X8008E28", 0, 0, "", "", "", new nce.a(null, null, this.b.mVideoVid, this.b.innerUniqueID).a((int)this.b.mChannelID).O((int)ndi.b(this.this$0)).R(0).a().toJsonString(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.14
 * JD-Core Version:    0.7.0.1
 */