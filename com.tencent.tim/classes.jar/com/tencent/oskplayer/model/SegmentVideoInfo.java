package com.tencent.oskplayer.model;

import android.text.TextUtils;
import com.tencent.oskplayer.util.PlayerUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class SegmentVideoInfo
{
  public static final int DEFAULT_VIDEO_RATE = 750;
  private static final String LOG_TAG = "SegmentVideoInfo";
  public static final int STREAM_TYPE_H265_NORMAL = 4;
  public static final int STREAM_TYPE_HIGNBR = 1;
  public static final int STREAM_TYPE_LOWBR = 2;
  public static final int STREAM_TYPE_NORMAL = 0;
  public static final int STREAM_TYPE_ORIGINAL = 3;
  private int currentStreamRate;
  private int defaultStreamRate;
  private HashMap<Integer, StreamInfo> streams;
  
  public SegmentVideoInfo()
  {
    this(new HashMap());
  }
  
  public SegmentVideoInfo(String paramString, int paramInt)
  {
    this();
    paramString = new StreamInfo(paramString, paramInt);
    this.streams.put(Integer.valueOf(0), paramString);
  }
  
  public SegmentVideoInfo(HashMap<Integer, StreamInfo> paramHashMap)
  {
    this(paramHashMap, 750);
  }
  
  public SegmentVideoInfo(HashMap<Integer, StreamInfo> paramHashMap, int paramInt)
  {
    this.streams = paramHashMap;
    this.defaultStreamRate = paramInt;
    this.currentStreamRate = paramInt;
  }
  
  public static int maxFloor(Set<Integer> paramSet, int paramInt)
  {
    if ((paramSet == null) || (paramSet.size() == 0)) {}
    label73:
    label74:
    for (;;)
    {
      return paramInt;
      paramSet = paramSet.iterator();
      int i = 0;
      if (paramSet.hasNext())
      {
        Integer localInteger = (Integer)paramSet.next();
        if ((localInteger.intValue() <= i) || (localInteger.intValue() > paramInt)) {
          break label73;
        }
        i = localInteger.intValue();
      }
      for (;;)
      {
        break;
        if (i == 0) {
          break label74;
        }
        return i;
      }
    }
  }
  
  private void resetStreamTypeIfNeeded()
  {
    int i;
    if ((this.streams != null) && (this.streams.size() > 0))
    {
      Iterator localIterator = this.streams.keySet().iterator();
      i = 0;
      if (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        if (localInteger.intValue() <= i) {
          break label103;
        }
        i = localInteger.intValue();
      }
    }
    label103:
    for (;;)
    {
      break;
      if (i <= 4)
      {
        if (this.defaultStreamRate >= 750) {
          this.defaultStreamRate = 0;
        }
        if (this.currentStreamRate >= 750) {
          this.currentStreamRate = 0;
        }
      }
      return;
    }
  }
  
  public StreamInfo getCurrentStreamInfo()
  {
    resetStreamTypeIfNeeded();
    return getStreamInfo(this.currentStreamRate);
  }
  
  public int getCurrentStreamType()
  {
    resetStreamTypeIfNeeded();
    return this.currentStreamRate;
  }
  
  public StreamInfo getDefaultStreamInfo()
  {
    if (this.streams == null) {
      return null;
    }
    resetStreamTypeIfNeeded();
    return (StreamInfo)this.streams.get(Integer.valueOf(this.defaultStreamRate));
  }
  
  public String getDefaultUrl()
  {
    return getRealSegmentUrl(0, 0);
  }
  
  public String getRealSegmentUrl(int paramInt1, int paramInt2)
  {
    Object localObject = getStreamInfo(paramInt1);
    if ((localObject == null) || (((StreamInfo)localObject).segmentInfos == null)) {
      return "";
    }
    localObject = (SegmentInfo)((StreamInfo)localObject).segmentInfos.get(paramInt2);
    if (localObject == null) {
      return "";
    }
    if (TextUtils.isEmpty(((SegmentInfo)localObject).url)) {
      return "";
    }
    return ((SegmentInfo)localObject).url;
  }
  
  public int getSegmentCount()
  {
    StreamInfo localStreamInfo = getCurrentStreamInfo();
    if (localStreamInfo == null) {
      return 0;
    }
    return localStreamInfo.getCount();
  }
  
  public StreamInfo getStreamInfo(int paramInt)
  {
    if ((this.streams == null) || (this.streams.size() == 0)) {
      return null;
    }
    return (StreamInfo)this.streams.get(Integer.valueOf(paramInt));
  }
  
  public HashMap<Integer, StreamInfo> getStreams()
  {
    return this.streams;
  }
  
  public int getdefaultStreamRate()
  {
    resetStreamTypeIfNeeded();
    return this.defaultStreamRate;
  }
  
  public boolean isValid()
  {
    if ((this.streams == null) || (this.streams.isEmpty()))
    {
      PlayerUtils.log(6, "SegmentVideoInfo", "streams is null or empty");
      return false;
    }
    Iterator localIterator = this.streams.values().iterator();
    while (localIterator.hasNext()) {
      if (!((StreamInfo)localIterator.next()).isValid()) {
        return false;
      }
    }
    return true;
  }
  
  public void setCurrentStreamType(int paramInt)
  {
    this.currentStreamRate = paramInt;
  }
  
  public void setMaxStreamRate(int paramInt)
  {
    if (this.currentStreamRate > paramInt) {
      this.currentStreamRate = maxFloor(this.streams.keySet(), paramInt);
    }
  }
  
  public void setStreamInfo(StreamInfo paramStreamInfo, int paramInt)
  {
    if (this.streams == null) {
      return;
    }
    this.streams.put(Integer.valueOf(paramInt), paramStreamInfo);
  }
  
  public void setStreams(HashMap<Integer, StreamInfo> paramHashMap)
  {
    this.streams = paramHashMap;
  }
  
  public void setVideoRate(int paramInt)
  {
    this.currentStreamRate = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64).append("SegmentVideoInfo{streams=[");
    Iterator localIterator = this.streams.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      localStringBuilder.append("{streamType=").append(((Map.Entry)localObject).getKey()).append(", streamInfo=");
      localObject = (StreamInfo)((Map.Entry)localObject).getValue();
      if (localObject == null) {
        localStringBuilder.append("null");
      }
      for (;;)
      {
        localStringBuilder.append("}, ");
        break;
        localStringBuilder.append(((StreamInfo)localObject).toString());
      }
    }
    localStringBuilder.append("]");
    localStringBuilder.append(", defaultStreamRate=").append(this.defaultStreamRate);
    localStringBuilder.append(", currentStreamRate=").append(this.currentStreamRate);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public static class SegmentInfo
  {
    public int duration;
    public int offset;
    public String url;
    
    public SegmentInfo(String paramString, int paramInt1, int paramInt2)
    {
      this.url = paramString;
      this.offset = paramInt1;
      this.duration = paramInt2;
    }
  }
  
  public static class StreamInfo
  {
    private VideoDecoderType.DecoderType decoderTypeSuggest;
    public boolean isHLSLive;
    public boolean isVideoTimeCanBeTrust;
    public boolean isVip;
    public String mSafeUrlKey;
    private String mUrl;
    public ArrayList<SegmentVideoInfo.SegmentInfo> segmentInfos;
    public int streamType;
    
    public StreamInfo()
    {
      this.segmentInfos = new ArrayList();
      this.decoderTypeSuggest = VideoDecoderType.DecoderType.H264;
    }
    
    public StreamInfo(String paramString, int paramInt)
    {
      this(paramString, paramInt, VideoDecoderType.DecoderType.H264);
    }
    
    public StreamInfo(String paramString, int paramInt, VideoDecoderType.DecoderType paramDecoderType)
    {
      this.mUrl = paramString;
      paramString = new SegmentVideoInfo.SegmentInfo(paramString, 0, paramInt);
      this.segmentInfos = new ArrayList();
      this.segmentInfos.add(paramString);
      this.decoderTypeSuggest = paramDecoderType;
    }
    
    public void addSegmentInfo(String paramString, int paramInt)
    {
      if (this.segmentInfos == null) {
        this.segmentInfos = new ArrayList();
      }
      if (this.segmentInfos.isEmpty()) {}
      int j;
      for (int i = 0;; i = ((SegmentVideoInfo.SegmentInfo)this.segmentInfos.get(i - 1)).duration + j)
      {
        if (!TextUtils.isEmpty(paramString)) {
          this.segmentInfos.add(new SegmentVideoInfo.SegmentInfo(paramString, i, paramInt));
        }
        return;
        i = this.segmentInfos.size();
        j = ((SegmentVideoInfo.SegmentInfo)this.segmentInfos.get(i - 1)).offset;
      }
    }
    
    public int getCount()
    {
      if (this.segmentInfos == null) {
        return 0;
      }
      return this.segmentInfos.size();
    }
    
    public VideoDecoderType.DecoderType getDecoderTypeSuggest()
    {
      return this.decoderTypeSuggest;
    }
    
    public SegmentVideoInfo.SegmentInfo getSegment(int paramInt)
    {
      if ((this.segmentInfos == null) || (paramInt < 0) || (paramInt >= getCount())) {
        return null;
      }
      return (SegmentVideoInfo.SegmentInfo)this.segmentInfos.get(paramInt);
    }
    
    public int getSegmentIndex(long paramLong)
    {
      int i = 0;
      if ((this.segmentInfos == null) || (this.segmentInfos.isEmpty())) {
        i = -1;
      }
      int j;
      do
      {
        return i;
        j = getCount();
      } while (j == 1);
      i = 0;
      while (i < j)
      {
        SegmentVideoInfo.SegmentInfo localSegmentInfo = (SegmentVideoInfo.SegmentInfo)this.segmentInfos.get(i);
        if (localSegmentInfo == null) {
          return -1;
        }
        int k = localSegmentInfo.offset;
        if (localSegmentInfo.duration + k > paramLong) {
          return i;
        }
        i += 1;
      }
      return -1;
    }
    
    public int getTotalDuration()
    {
      if ((this.segmentInfos == null) || (this.segmentInfos.isEmpty())) {
        return 0;
      }
      SegmentVideoInfo.SegmentInfo localSegmentInfo = (SegmentVideoInfo.SegmentInfo)this.segmentInfos.get(this.segmentInfos.size() - 1);
      if (localSegmentInfo == null) {
        return 0;
      }
      int i = localSegmentInfo.offset;
      return localSegmentInfo.duration + i;
    }
    
    public String getUrl()
    {
      return this.mUrl;
    }
    
    public boolean isValid()
    {
      if ((this.segmentInfos == null) || (this.segmentInfos.isEmpty()))
      {
        PlayerUtils.log(6, "SegmentVideoInfo", "segmentInfos is null or empty");
        return false;
      }
      int i = 0;
      while (i < this.segmentInfos.size())
      {
        SegmentVideoInfo.SegmentInfo localSegmentInfo1 = (SegmentVideoInfo.SegmentInfo)this.segmentInfos.get(i);
        if (localSegmentInfo1 == null)
        {
          PlayerUtils.log(6, "SegmentVideoInfo", "segment index=" + i + " segment is null");
          return false;
        }
        if (TextUtils.isEmpty(localSegmentInfo1.url))
        {
          PlayerUtils.log(6, "SegmentVideoInfo", "segment index=" + i + " url is empty");
          return false;
        }
        if (localSegmentInfo1.offset < 0)
        {
          PlayerUtils.log(6, "SegmentVideoInfo", "segment index=" + i + " segmentInfo.offset=" + localSegmentInfo1.offset);
          return false;
        }
        if (localSegmentInfo1.duration < 0)
        {
          PlayerUtils.log(6, "SegmentVideoInfo", "segment index=" + i + " segmentInfo.duration=" + localSegmentInfo1.duration);
          return false;
        }
        if (i > 0)
        {
          SegmentVideoInfo.SegmentInfo localSegmentInfo2 = (SegmentVideoInfo.SegmentInfo)this.segmentInfos.get(i - 1);
          if (localSegmentInfo2.offset + localSegmentInfo2.duration != localSegmentInfo1.offset)
          {
            PlayerUtils.log(6, "SegmentVideoInfo", "segment index=" + i + " segmentInfo.offset=" + localSegmentInfo1.offset + " before.offset=" + localSegmentInfo2.offset + " before.duration=" + localSegmentInfo2.duration);
            return false;
          }
        }
        i += 1;
      }
      return true;
    }
    
    public void setDecoderTypeSuggest(VideoDecoderType.DecoderType paramDecoderType)
    {
      this.decoderTypeSuggest = paramDecoderType;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(32).append("[");
      if (this.segmentInfos == null)
      {
        localStringBuilder.append("null");
        localStringBuilder.append("]");
        return localStringBuilder.toString();
      }
      Iterator localIterator = this.segmentInfos.iterator();
      label49:
      SegmentVideoInfo.SegmentInfo localSegmentInfo;
      if (localIterator.hasNext())
      {
        localSegmentInfo = (SegmentVideoInfo.SegmentInfo)localIterator.next();
        if (localSegmentInfo != null) {
          break label89;
        }
        localStringBuilder.append("{null}");
      }
      for (;;)
      {
        localStringBuilder.append(", ");
        break label49;
        break;
        label89:
        localStringBuilder.append("{url=").append(localSegmentInfo.url);
        localStringBuilder.append(", duration=").append(localSegmentInfo.duration);
        localStringBuilder.append(", offset=").append(localSegmentInfo.offset).append("}");
      }
    }
    
    public void updateDuration()
    {
      if ((this.segmentInfos == null) || (this.segmentInfos.isEmpty())) {}
      label89:
      for (;;)
      {
        return;
        int i = 1;
        for (;;)
        {
          if (i >= this.segmentInfos.size()) {
            break label89;
          }
          SegmentVideoInfo.SegmentInfo localSegmentInfo1 = (SegmentVideoInfo.SegmentInfo)this.segmentInfos.get(i);
          SegmentVideoInfo.SegmentInfo localSegmentInfo2 = (SegmentVideoInfo.SegmentInfo)this.segmentInfos.get(i - 1);
          if ((localSegmentInfo1 == null) || (localSegmentInfo2 == null)) {
            break;
          }
          int j = localSegmentInfo2.offset;
          localSegmentInfo1.offset = (localSegmentInfo2.duration + j);
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.model.SegmentVideoInfo
 * JD-Core Version:    0.7.0.1
 */