package com.tencent.superplayer.api;

import android.content.Context;

public abstract interface ISPBandwidthPredictor
{
  public abstract long getCurrentPrediction();
  
  public abstract long getLastBandwidth();
  
  public abstract void start(Context paramContext);
  
  public abstract void stop(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.api.ISPBandwidthPredictor
 * JD-Core Version:    0.7.0.1
 */