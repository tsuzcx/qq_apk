package com.tencent.oskplayer.datasource;

import java.util.Comparator;

final class SlidingPercentile$1
  implements Comparator<SlidingPercentile.Sample>
{
  public int compare(SlidingPercentile.Sample paramSample1, SlidingPercentile.Sample paramSample2)
  {
    return paramSample1.index - paramSample2.index;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.datasource.SlidingPercentile.1
 * JD-Core Version:    0.7.0.1
 */