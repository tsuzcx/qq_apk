package com.tencent.qqlive.tvkplayer.tools.utils;

public class TVKHttpProcessorFactory
{
  private static ITVKHttpProcessor mProcessor;
  
  public static ITVKHttpProcessor getInstance()
  {
    if (mProcessor == null) {}
    try
    {
      if (mProcessor == null) {
        mProcessor = TVKHttpClient.getInstance();
      }
      return mProcessor;
    }
    finally {}
  }
  
  public static void init(ITVKHttpProcessor paramITVKHttpProcessor)
  {
    try
    {
      if (mProcessor == null) {
        mProcessor = paramITVKHttpProcessor;
      }
      return;
    }
    finally
    {
      paramITVKHttpProcessor = finally;
      throw paramITVKHttpProcessor;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.tools.utils.TVKHttpProcessorFactory
 * JD-Core Version:    0.7.0.1
 */