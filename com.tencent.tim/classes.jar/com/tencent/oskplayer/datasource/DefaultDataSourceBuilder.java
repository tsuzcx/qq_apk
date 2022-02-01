package com.tencent.oskplayer.datasource;

import android.webkit.URLUtil;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.cache.Cache;
import com.tencent.oskplayer.cache.CacheDataSink;
import com.tencent.oskplayer.cache.CacheDataSource;
import com.tencent.oskplayer.cache.CacheDataSource.EventListener;
import com.tencent.oskplayer.proxy.DataSourceBuilder;
import com.tencent.oskplayer.proxy.HttpRetryLogic;
import com.tencent.oskplayer.proxy.VideoRequest;
import com.tencent.oskplayer.report.IVideoReporter;
import com.tencent.oskplayer.util.PassOnVideoType;
import com.tencent.oskplayer.util.PlayerUtils;

public class DefaultDataSourceBuilder
  implements DataSourceBuilder
{
  private static final String TAG = "DefaultDataSourceBuilder";
  private static BandwidthMeter bandwidthMeter;
  private Cache cache;
  private CacheDataSink cacheDataSink;
  private FileDataSource fileDataSource;
  private DefaultHttpDataSource httpTransport;
  private VideoRequest mVideoRequest;
  
  public DefaultDataSourceBuilder(Cache paramCache, HttpRetryLogic paramHttpRetryLogic, VideoRequest paramVideoRequest)
  {
    if (bandwidthMeter == null) {
      bandwidthMeter = new DefaultBandwidthMeter(null, null);
    }
    this.httpTransport = new NiceHttpDataSource("com.qzone.player-v20150909", new PassOnVideoType(), bandwidthMeter, paramHttpRetryLogic, paramVideoRequest.getContentTypeFixer(), paramVideoRequest);
    this.fileDataSource = new FileDataSource();
    this.cache = paramCache;
    if (paramCache != null) {
      this.cacheDataSink = new CacheDataSink(paramCache, PlayerConfig.g().getCacheSingleFileBytes());
    }
    this.mVideoRequest = paramVideoRequest;
  }
  
  public static BandwidthMeter getBandwidthMeter()
  {
    return bandwidthMeter;
  }
  
  public DataSource build(String paramString1, String paramString2)
  {
    this.httpTransport.setLogTag(paramString2);
    if (this.cacheDataSink != null) {
      this.cacheDataSink.setLogTag(paramString2);
    }
    this.fileDataSource.setLogTag(paramString2);
    if (!URLUtil.isNetworkUrl(paramString1)) {}
    boolean bool2;
    for (int i = 1;; i = 0)
    {
      boolean bool1 = PlayerUtils.isAssetsUri(paramString1);
      bool2 = PlayerUtils.isRawResourceUri(paramString1);
      if (!bool1) {
        break;
      }
      paramString1 = new AssetDataSource(PlayerConfig.g().getAppContext());
      paramString1.setLogTag(paramString2);
      return paramString1;
    }
    if (bool2)
    {
      paramString1 = new RawResourceDataSource(PlayerConfig.g().getAppContext());
      paramString1.setLogTag(paramString2);
      return paramString1;
    }
    if (i != 0)
    {
      paramString1 = this.fileDataSource;
      PlayerUtils.log(3, paramString2 + "DefaultDataSourceBuilder", "play local file");
      return paramString1;
    }
    if ((this.cache == null) || (!PlayerConfig.g().isEnableCache()))
    {
      paramString1 = this.httpTransport;
      PlayerUtils.log(5, paramString2 + "DefaultDataSourceBuilder", "cache disabled");
      return paramString1;
    }
    CacheEventListener localCacheEventListener = new CacheEventListener();
    Cache localCache = this.cache;
    DefaultHttpDataSource localDefaultHttpDataSource = this.httpTransport;
    FileDataSource localFileDataSource = this.fileDataSource;
    if (this.mVideoRequest.isCacheEnabled()) {}
    for (paramString1 = this.cacheDataSink;; paramString1 = null)
    {
      paramString1 = new CacheDataSource(localCache, localDefaultHttpDataSource, localFileDataSource, paramString1, false, true, localCacheEventListener);
      paramString1.setLogTag(paramString2);
      return paramString1;
    }
  }
  
  public class CacheEventListener
    implements CacheDataSource.EventListener
  {
    public CacheEventListener() {}
    
    public void downloadSizeAndDuration(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3)
    {
      if (PlayerConfig.g().getVideoReporter() != null) {
        PlayerConfig.g().getVideoReporter().downloadSizeAndDuration(paramString, paramInt, paramLong1, paramLong2, paramLong3);
      }
    }
    
    public void onCachedAttrRead(long paramLong)
    {
      if (PlayerConfig.g().getVideoReporter() != null) {
        PlayerConfig.g().getVideoReporter().preLoadOccurred(null, paramLong);
      }
    }
    
    public void onCachedBytesRead(long paramLong1, long paramLong2) {}
    
    public void onHttpUpstreamServerCost(String paramString, long paramLong1, long paramLong2, long paramLong3)
    {
      if (PlayerConfig.g().getVideoReporter() != null) {
        PlayerConfig.g().getVideoReporter().downloadServerCost(paramString, paramLong1, paramLong2, paramLong3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.datasource.DefaultDataSourceBuilder
 * JD-Core Version:    0.7.0.1
 */