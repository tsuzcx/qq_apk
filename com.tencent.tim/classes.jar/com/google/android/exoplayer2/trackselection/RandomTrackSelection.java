package com.google.android.exoplayer2.trackselection;

import android.os.SystemClock;
import com.google.android.exoplayer2.source.TrackGroup;
import java.util.Random;

public final class RandomTrackSelection
  extends BaseTrackSelection
{
  private final Random random;
  private int selectedIndex;
  
  public RandomTrackSelection(TrackGroup paramTrackGroup, int... paramVarArgs)
  {
    super(paramTrackGroup, paramVarArgs);
    this.random = new Random();
    this.selectedIndex = this.random.nextInt(this.length);
  }
  
  public RandomTrackSelection(TrackGroup paramTrackGroup, int[] paramArrayOfInt, long paramLong)
  {
    this(paramTrackGroup, paramArrayOfInt, new Random(paramLong));
  }
  
  public RandomTrackSelection(TrackGroup paramTrackGroup, int[] paramArrayOfInt, Random paramRandom)
  {
    super(paramTrackGroup, paramArrayOfInt);
    this.random = paramRandom;
    this.selectedIndex = paramRandom.nextInt(this.length);
  }
  
  public int getSelectedIndex()
  {
    return this.selectedIndex;
  }
  
  public Object getSelectionData()
  {
    return null;
  }
  
  public int getSelectionReason()
  {
    return 3;
  }
  
  public void updateSelectedTrack(long paramLong1, long paramLong2, long paramLong3)
  {
    int m = 0;
    paramLong1 = SystemClock.elapsedRealtime();
    int i = 0;
    int k;
    for (int j = 0; i < this.length; j = k)
    {
      k = j;
      if (!isBlacklisted(i, paramLong1)) {
        k = j + 1;
      }
      i += 1;
    }
    this.selectedIndex = this.random.nextInt(j);
    if (j != this.length)
    {
      j = 0;
      i = m;
    }
    for (;;)
    {
      if (i < this.length)
      {
        k = j;
        if (isBlacklisted(i, paramLong1)) {
          break label129;
        }
        if (this.selectedIndex == j) {
          this.selectedIndex = i;
        }
      }
      else
      {
        return;
      }
      k = j + 1;
      label129:
      i += 1;
      j = k;
    }
  }
  
  public static final class Factory
    implements TrackSelection.Factory
  {
    private final Random random;
    
    public Factory()
    {
      this.random = new Random();
    }
    
    public Factory(int paramInt)
    {
      this.random = new Random(paramInt);
    }
    
    public RandomTrackSelection createTrackSelection(TrackGroup paramTrackGroup, int... paramVarArgs)
    {
      return new RandomTrackSelection(paramTrackGroup, paramVarArgs, this.random);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.trackselection.RandomTrackSelection
 * JD-Core Version:    0.7.0.1
 */