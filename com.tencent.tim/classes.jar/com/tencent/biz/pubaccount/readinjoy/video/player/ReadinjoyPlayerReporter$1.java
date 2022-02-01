package com.tencent.biz.pubaccount.readinjoy.video.player;

import com.tencent.common.app.BaseApplicationImpl;
import kbx;
import kxm;
import mhu;
import nbk;

public class ReadinjoyPlayerReporter$1
  implements Runnable
{
  public ReadinjoyPlayerReporter$1(nbk paramnbk, mhu parammhu) {}
  
  public void run()
  {
    kxm.a(BaseApplicationImpl.getContext(), kxm.getAccount(), true, this.b.u());
    kbx.a(this.b);
    kxm.a(this.b.success, this.b.aiJ, this.b.videoFormat, this.b.busiType, this.b.vt, 409409, this.b.errCode, this.b.rowkey);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.player.ReadinjoyPlayerReporter.1
 * JD-Core Version:    0.7.0.1
 */