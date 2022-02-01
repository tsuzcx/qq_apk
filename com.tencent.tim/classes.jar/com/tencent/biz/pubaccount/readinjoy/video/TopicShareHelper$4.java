package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.widgets.ElasticHorScrView;
import mso;

public class TopicShareHelper$4
  implements Runnable
{
  public TopicShareHelper$4(mso parammso, ElasticHorScrView paramElasticHorScrView1, int paramInt1, ElasticHorScrView paramElasticHorScrView2, int paramInt2) {}
  
  public void run()
  {
    if (this.a.getWidth() < this.aTX) {
      this.a.setMove(true);
    }
    while (this.b.getWidth() < this.aTY)
    {
      this.b.setMove(true);
      return;
      this.a.setMove(false);
    }
    this.b.setMove(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.TopicShareHelper.4
 * JD-Core Version:    0.7.0.1
 */