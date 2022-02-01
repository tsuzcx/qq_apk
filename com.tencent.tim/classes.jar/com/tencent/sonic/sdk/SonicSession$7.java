package com.tencent.sonic.sdk;

class SonicSession$7
  implements Runnable
{
  SonicSession$7(SonicSession paramSonicSession) {}
  
  public void run()
  {
    if (SonicUtils.shouldClearCache(SonicEngine.getInstance().getConfig().SONIC_CACHE_CHECK_TIME_INTERVAL))
    {
      SonicEngine.getInstance().trimSonicCache();
      SonicUtils.saveClearCacheTime(System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicSession.7
 * JD-Core Version:    0.7.0.1
 */