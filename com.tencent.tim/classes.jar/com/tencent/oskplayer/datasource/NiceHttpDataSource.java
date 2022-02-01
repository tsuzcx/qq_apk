package com.tencent.oskplayer.datasource;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.proxy.HttpRetryLogic;
import com.tencent.oskplayer.proxy.UuidPlayIdMap;
import com.tencent.oskplayer.proxy.VideoRequest;
import com.tencent.oskplayer.util.Fixer;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.oskplayer.util.Predicate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class NiceHttpDataSource
  extends DefaultHttpDataSource
{
  private static boolean configLoaded;
  private static int sMaxRetryCount = 3;
  private HttpRetryLogic httpRetryLogic;
  private VideoRequest mVideoRequest;
  private int readRetryCount = 0;
  private String uuid;
  
  public NiceHttpDataSource(String paramString, Predicate<String> paramPredicate, TransferListener paramTransferListener, HttpRetryLogic paramHttpRetryLogic, Fixer<Map<String, List<String>>> paramFixer, VideoRequest paramVideoRequest)
  {
    super(paramString, paramPredicate, paramTransferListener, 30000, 12000, true, paramFixer);
    this.httpRetryLogic = paramHttpRetryLogic;
    this.mVideoRequest = paramVideoRequest;
    this.TAG = "NiceHttpDataSource";
    if (!configLoaded)
    {
      sMaxRetryCount = PlayerConfig.g().getDataSourceMaxRetryCount();
      configLoaded = true;
    }
    paramString = PlayerConfig.g().getGlobalExtraHeader();
    if (paramString != null)
    {
      paramString = paramString.getSnapshot().entrySet().iterator();
      while (paramString.hasNext())
      {
        paramPredicate = (Map.Entry)paramString.next();
        setRequestProperty((String)paramPredicate.getKey(), (String)paramPredicate.getValue());
      }
    }
    paramString = paramVideoRequest.getExtraHeader();
    if (paramString != null)
    {
      paramString = paramString.getSnapshot().entrySet().iterator();
      while (paramString.hasNext())
      {
        paramPredicate = (Map.Entry)paramString.next();
        setRequestProperty((String)paramPredicate.getKey(), (String)paramPredicate.getValue());
      }
    }
  }
  
  private int readRetry(byte[] paramArrayOfByte, int paramInt1, int paramInt2, HttpDataSource.HttpDataSourceException paramHttpDataSourceException)
    throws HttpDataSource.HttpDataSourceException
  {
    if (UuidPlayIdMap.isUuidDeleted(getDataSpec().uuid)) {
      throw new HttpDataSource.InterruptReadException("readRetry interrupted UuidDeleted" + this.mVideoRequest, getDataSpec());
    }
    PlayerUtils.log(4, getLogTag(), "read source error occurred " + paramHttpDataSourceException.toString());
    this.readRetryCount += 1;
    long l1 = getDataSpec().position + bytesRead();
    int i = this.readRetryCount * 2000;
    PlayerUtils.log(4, getLogTag(), "retrying after " + i + " seconds, read start at offset " + l1 + " retry " + this.readRetryCount + "/" + sMaxRetryCount);
    long l2 = i;
    DataSpec localDataSpec;
    try
    {
      Thread.sleep(l2);
      localDataSpec = new DataSpec(Uri.parse(getUri()), 0L, l1, -1L, null, 0, this.uuid, getDataSpec().priority);
      if ((Thread.currentThread().isInterrupted()) || (this.readRetryCount >= sMaxRetryCount)) {
        break label340;
      }
      if (this.mVideoRequest.shouldCancel())
      {
        PlayerUtils.log(4, getLogTag(), "abort retry videoRequest is cancelling " + this.mVideoRequest);
        throw new HttpDataSource.InterruptReadException("readRetry interrupted " + this.mVideoRequest, getDataSpec());
      }
    }
    catch (InterruptedException paramArrayOfByte)
    {
      PlayerUtils.log(5, getLogTag(), "readRetry interrupted");
      throw paramHttpDataSourceException;
    }
    open(localDataSpec);
    return read(paramArrayOfByte, paramInt1, paramInt2);
    label340:
    throw paramHttpDataSourceException;
  }
  
  private long retryOpen(DataSpec paramDataSpec, String paramString, HttpDataSource.HttpDataSourceException paramHttpDataSourceException)
    throws HttpDataSource.HttpDataSourceException
  {
    Object localObject1;
    int i;
    Map localMap;
    if ((paramHttpDataSourceException instanceof HttpDataSource.InvalidResponseCodeException))
    {
      localObject1 = (HttpDataSource.InvalidResponseCodeException)paramHttpDataSourceException;
      i = ((HttpDataSource.InvalidResponseCodeException)localObject1).responseCode;
      localMap = ((HttpDataSource.InvalidResponseCodeException)localObject1).headerFields;
    }
    for (;;)
    {
      Object localObject2 = paramDataSpec.uri.toString();
      PlayerUtils.log(4, getLogTag(), "retryOpen url=" + (String)localObject2 + " with responseCode=" + i);
      int j = 0;
      for (;;)
      {
        String str;
        if ((!Thread.currentThread().isInterrupted()) && (j < sMaxRetryCount)) {
          if (this.httpRetryLogic != null)
          {
            str = this.httpRetryLogic.getRetryUrl((String)localObject2, j, i, localMap);
            PlayerUtils.log(4, getLogTag(), "retryCount=" + j + " retryUrl=" + str);
            if (!TextUtils.isEmpty(str)) {
              break label229;
            }
            localObject1 = localObject2;
          }
        }
        while (UuidPlayIdMap.isUuidDeleted(paramDataSpec.uuid))
        {
          throw new HttpDataSource.InterruptConnectServerException("retry open interrupted UuidDeleted" + this.mVideoRequest, getDataSpec());
          PlayerUtils.log(4, getLogTag(), "httpRetryLogic is null");
          throw paramHttpDataSourceException;
          label229:
          localObject1 = str;
          if (str.equals(localObject2))
          {
            PlayerUtils.log(5, getLogTag(), "retryUrl is same as origin url");
            localObject1 = str;
          }
        }
        j += 1;
        int k = j * 2000;
        PlayerUtils.log(4, getLogTag(), "retry open retrying after " + k + " seconds  retry " + j + "/" + sMaxRetryCount);
        long l = k;
        try
        {
          Thread.sleep(l);
          localObject2 = new DataSpec(Uri.parse((String)localObject1), paramDataSpec.absoluteStreamPosition, paramDataSpec.position, paramDataSpec.length, paramDataSpec.key, paramDataSpec.flags, paramDataSpec.uuid, paramDataSpec.priority);
        }
        catch (InterruptedException paramDataSpec)
        {
          try
          {
            l = super.open((DataSpec)localObject2, paramString);
            return l;
          }
          catch (HttpDataSource.HttpDataSourceException localHttpDataSourceException)
          {
            if ((this.mVideoRequest == null) || (!this.mVideoRequest.shouldCancel())) {
              break label531;
            }
            PlayerUtils.log(4, getLogTag(), "abort retryOpen videoRequest is cancelling " + this.mVideoRequest + ",reason=" + PlayerUtils.getPrintableStackTrace(localHttpDataSourceException));
            throw new HttpDataSource.InterruptConnectServerException("retry open interrupted " + this.mVideoRequest, getDataSpec());
            Object localObject3 = localObject1;
          }
          paramDataSpec = paramDataSpec;
          Thread.currentThread().interrupt();
          throw new HttpDataSource.InterruptConnectServerException("retry open  interrupted " + this.mVideoRequest, getDataSpec());
        }
      }
      label531:
      localMap = null;
      i = 0;
    }
  }
  
  public long open(DataSpec paramDataSpec)
    throws HttpDataSource.HttpDataSourceException
  {
    this.uuid = paramDataSpec.uuid;
    try
    {
      long l = super.open(paramDataSpec);
      return l;
    }
    catch (HttpDataSource.HttpDataSourceException localHttpDataSourceException)
    {
      return retryOpen(paramDataSpec, null, localHttpDataSourceException);
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws HttpDataSource.HttpDataSourceException
  {
    try
    {
      int i = super.read(paramArrayOfByte, paramInt1, paramInt2);
      return i;
    }
    catch (HttpDataSource.HttpDataSourceException localHttpDataSourceException)
    {
      return readRetry(paramArrayOfByte, paramInt1, paramInt2, localHttpDataSourceException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.datasource.NiceHttpDataSource
 * JD-Core Version:    0.7.0.1
 */