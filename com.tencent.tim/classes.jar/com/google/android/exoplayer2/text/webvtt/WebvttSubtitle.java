package com.google.android.exoplayer2.text.webvtt;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class WebvttSubtitle
  implements Subtitle
{
  private final long[] cueTimesUs;
  private final List<WebvttCue> cues;
  private final int numCues;
  private final long[] sortedCueTimesUs;
  
  public WebvttSubtitle(List<WebvttCue> paramList)
  {
    this.cues = paramList;
    this.numCues = paramList.size();
    this.cueTimesUs = new long[this.numCues * 2];
    int i = 0;
    while (i < this.numCues)
    {
      WebvttCue localWebvttCue = (WebvttCue)paramList.get(i);
      int j = i * 2;
      this.cueTimesUs[j] = localWebvttCue.startTime;
      this.cueTimesUs[(j + 1)] = localWebvttCue.endTime;
      i += 1;
    }
    this.sortedCueTimesUs = Arrays.copyOf(this.cueTimesUs, this.cueTimesUs.length);
    Arrays.sort(this.sortedCueTimesUs);
  }
  
  public List<Cue> getCues(long paramLong)
  {
    Object localObject2 = null;
    int i = 0;
    Object localObject1 = null;
    ArrayList localArrayList = null;
    label61:
    Object localObject3;
    if (i < this.numCues)
    {
      if ((this.cueTimesUs[(i * 2)] > paramLong) || (paramLong >= this.cueTimesUs[(i * 2 + 1)])) {
        break label274;
      }
      if (localArrayList != null) {
        break label271;
      }
      localArrayList = new ArrayList();
      localObject3 = (WebvttCue)this.cues.get(i);
      if (((WebvttCue)localObject3).isNormalCue()) {
        if (localObject1 == null)
        {
          localObject1 = localObject2;
          localObject2 = localObject3;
        }
      }
    }
    for (;;)
    {
      i += 1;
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
      break;
      if (localObject2 == null)
      {
        localObject2 = new SpannableStringBuilder();
        ((SpannableStringBuilder)localObject2).append(localObject1.text).append("\n").append(((WebvttCue)localObject3).text);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
      else
      {
        ((SpannableStringBuilder)localObject2).append("\n").append(((WebvttCue)localObject3).text);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localArrayList.add(localObject3);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        if (localObject2 != null) {
          localArrayList.add(new WebvttCue((CharSequence)localObject2));
        }
        while (localArrayList != null)
        {
          return localArrayList;
          if (localObject1 != null) {
            localArrayList.add(localObject1);
          }
        }
        return Collections.emptyList();
        label271:
        break label61;
        label274:
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
    }
  }
  
  public long getEventTime(int paramInt)
  {
    boolean bool2 = true;
    if (paramInt >= 0)
    {
      bool1 = true;
      Assertions.checkArgument(bool1);
      if (paramInt >= this.sortedCueTimesUs.length) {
        break label39;
      }
    }
    label39:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assertions.checkArgument(bool1);
      return this.sortedCueTimesUs[paramInt];
      bool1 = false;
      break;
    }
  }
  
  public int getEventTimeCount()
  {
    return this.sortedCueTimesUs.length;
  }
  
  public int getNextEventTimeIndex(long paramLong)
  {
    int i = Util.binarySearchCeil(this.sortedCueTimesUs, paramLong, false, false);
    if (i < this.sortedCueTimesUs.length) {
      return i;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.text.webvtt.WebvttSubtitle
 * JD-Core Version:    0.7.0.1
 */