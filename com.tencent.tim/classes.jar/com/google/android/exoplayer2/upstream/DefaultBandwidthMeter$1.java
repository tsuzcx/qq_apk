package com.google.android.exoplayer2.upstream;

class DefaultBandwidthMeter$1
  implements Runnable
{
  DefaultBandwidthMeter$1(DefaultBandwidthMeter paramDefaultBandwidthMeter, int paramInt, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    DefaultBandwidthMeter.access$000(this.this$0).onBandwidthSample(this.val$elapsedMs, this.val$bytes, this.val$bitrate);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.upstream.DefaultBandwidthMeter.1
 * JD-Core Version:    0.7.0.1
 */