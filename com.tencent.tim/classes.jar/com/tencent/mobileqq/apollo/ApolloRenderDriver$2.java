package com.tencent.mobileqq.apollo;

class ApolloRenderDriver$2
  extends IApolloRunnableTask
{
  ApolloRenderDriver$2(ApolloRenderDriver paramApolloRenderDriver) {}
  
  public String aV()
  {
    return "startLoop";
  }
  
  public void run()
  {
    if (this.this$0.mGameId > 0) {}
    for (String str = String.format("mainTicker.interval = %f;mainTicker.paused = false;renderTicker.paused = false;renderTicker.interval = %f;BK.Director.tickerResume();", new Object[] { Double.valueOf(60.0D / this.this$0.mFrameNum), Double.valueOf(60.0D / this.this$0.mFrameNum) });; str = String.format("var tickerIntervar = %d; if(BK.Director.ticker){BK.Director.ticker.interval = tickerIntervar; BK.Director.ticker.paused = false; } if (\"undefined\" != typeof renderTicker){renderTicker.interval = tickerIntervar; renderTicker.paused = false; } BK.Director.tickerSetInterval(tickerIntervar); if(BK.Director.tickerResume){BK.Director.tickerResume(); }", new Object[] { Integer.valueOf(60 / this.this$0.mFrameNum) }))
    {
      this.this$0.a.BA(str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRenderDriver.2
 * JD-Core Version:    0.7.0.1
 */