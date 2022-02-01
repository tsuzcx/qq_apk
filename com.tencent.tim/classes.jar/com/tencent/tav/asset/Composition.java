package com.tencent.tav.asset;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.support.annotation.NonNull;
import android.util.Log;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.extractor.AssetExtractor;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Composition<CTrack extends CompositionTrack>
  extends Asset
{
  protected List<CTrack> tracks = new ArrayList();
  
  protected Composition() {}
  
  protected Composition(@NonNull String paramString)
  {
    super(paramString);
  }
  
  protected Composition(@NonNull URL paramURL)
  {
    super(paramURL);
  }
  
  @TargetApi(16)
  protected void createTracks()
  {
    int j = this.extractor.getTrackCount();
    if (this.tracks == null) {
      this.tracks = new ArrayList();
    }
    int i = 0;
    if (i < j)
    {
      Object localObject = this.extractor.getTrackFormat(i).getString("mime");
      int k;
      if (((String)localObject).startsWith("video/"))
      {
        k = this.trackIndex;
        this.trackIndex = (k + 1);
        localObject = new CompositionTrack(this, k, 1, new CMTimeRange(CMTime.CMTimeZero, getVideoDuration()));
        this.tracks.add(localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        if (((String)localObject).startsWith("audio/"))
        {
          k = this.trackIndex;
          this.trackIndex = (k + 1);
          localObject = new CompositionTrack(this, k, 2, new CMTimeRange(CMTime.CMTimeZero, getAudioDuration()));
          this.tracks.add(localObject);
        }
      }
    }
    Log.e("Asset", " Composition createTracks finish, has track count: " + this.tracks);
  }
  
  protected CMTime getAudioDuration()
  {
    Object localObject1 = CMTime.CMTimeZero;
    Iterator localIterator = this.tracks.iterator();
    if (localIterator.hasNext())
    {
      Object localObject2 = (CompositionTrack)localIterator.next();
      if (((CompositionTrack)localObject2).getMediaType() != 2) {
        break label68;
      }
      CMTime localCMTime = ((CompositionTrack)localObject2).getDuration();
      localObject2 = localObject1;
      if (localCMTime.bigThan((CMTime)localObject1)) {
        localObject2 = localCMTime;
      }
      localObject1 = localObject2;
    }
    label68:
    for (;;)
    {
      break;
      return localObject1;
    }
  }
  
  public List<CTrack> getTracks()
  {
    Log.e("Asset", "getTracks finish, has track count: " + this.tracks);
    return this.tracks;
  }
  
  protected CMTime getVideoDuration()
  {
    Object localObject1 = CMTime.CMTimeZero;
    Iterator localIterator = this.tracks.iterator();
    if (localIterator.hasNext())
    {
      Object localObject2 = (CompositionTrack)localIterator.next();
      if (((CompositionTrack)localObject2).getMediaType() != 1) {
        break label68;
      }
      CMTime localCMTime = ((CompositionTrack)localObject2).getDuration();
      localObject2 = localObject1;
      if (localCMTime.bigThan((CMTime)localObject1)) {
        localObject2 = localCMTime;
      }
      localObject1 = localObject2;
    }
    label68:
    for (;;)
    {
      break;
      return localObject1;
    }
  }
  
  public void loadValuesAsynchronouslyForKeys(List<String> paramList, AsynchronousKeyValueLoading.loadCallback paramloadCallback) {}
  
  public int statusOfValueForKey(String paramString)
    throws Exception
  {
    return 1;
  }
  
  public String toString()
  {
    return "Composition{tracks=" + this.tracks + ", trackCount=" + this.trackCount + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.tav.asset.Composition
 * JD-Core Version:    0.7.0.1
 */