package com.tencent.thumbplayer.core.common;

final class TPCodecUtils$1
  implements Runnable
{
  public void run()
  {
    TPCodecUtils.getVMediaCodecMaxCapabilityMap();
    TPCodecUtils.getAMediaCodecMaxCapabilityMap();
    TPCodecUtils.getVCodecSWMaxCapabilityMap();
    TPCodecUtils.getACodecSWMaxCapabilityMap();
    TPCodecUtils.access$002(true);
    TPNativeLog.printLog(2, "TPCodecUtils", "new thread getDecoderMaxCapabilityMap done");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPCodecUtils.1
 * JD-Core Version:    0.7.0.1
 */