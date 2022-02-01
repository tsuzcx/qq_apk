package com.google.android.exoplayer2.trackselection;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public abstract class MappingTrackSelector
  extends TrackSelector
{
  private MappedTrackInfo currentMappedTrackInfo;
  private final SparseBooleanArray rendererDisabledFlags = new SparseBooleanArray();
  private final SparseArray<Map<TrackGroupArray, SelectionOverride>> selectionOverrides = new SparseArray();
  private int tunnelingAudioSessionId = 0;
  
  private boolean[] determineEnabledRenderers(RendererCapabilities[] paramArrayOfRendererCapabilities, TrackSelection[] paramArrayOfTrackSelection)
  {
    boolean[] arrayOfBoolean = new boolean[paramArrayOfTrackSelection.length];
    int i = 0;
    if (i < arrayOfBoolean.length)
    {
      if ((!this.rendererDisabledFlags.get(i)) && ((paramArrayOfRendererCapabilities[i].getTrackType() == 5) || (paramArrayOfTrackSelection[i] != null))) {}
      for (int j = 1;; j = 0)
      {
        arrayOfBoolean[i] = j;
        i += 1;
        break;
      }
    }
    return arrayOfBoolean;
  }
  
  private static int findRenderer(RendererCapabilities[] paramArrayOfRendererCapabilities, TrackGroup paramTrackGroup)
    throws ExoPlaybackException
  {
    int k = paramArrayOfRendererCapabilities.length;
    int j = 0;
    int i = 0;
    int m;
    label22:
    int n;
    if (i < paramArrayOfRendererCapabilities.length)
    {
      RendererCapabilities localRendererCapabilities = paramArrayOfRendererCapabilities[i];
      m = 0;
      if (m < paramTrackGroup.length)
      {
        n = localRendererCapabilities.supportsFormat(paramTrackGroup.getFormat(m)) & 0x7;
        if (n <= j) {
          break label102;
        }
        if (n == 4) {
          return i;
        }
        k = n;
      }
    }
    for (j = i;; j = n)
    {
      n = m + 1;
      m = j;
      j = k;
      k = m;
      m = n;
      break label22;
      i += 1;
      break;
      return k;
      label102:
      n = k;
      k = j;
    }
  }
  
  private static int[] getFormatSupport(RendererCapabilities paramRendererCapabilities, TrackGroup paramTrackGroup)
    throws ExoPlaybackException
  {
    int[] arrayOfInt = new int[paramTrackGroup.length];
    int i = 0;
    while (i < paramTrackGroup.length)
    {
      arrayOfInt[i] = paramRendererCapabilities.supportsFormat(paramTrackGroup.getFormat(i));
      i += 1;
    }
    return arrayOfInt;
  }
  
  private static int[] getMixedMimeTypeAdaptationSupport(RendererCapabilities[] paramArrayOfRendererCapabilities)
    throws ExoPlaybackException
  {
    int[] arrayOfInt = new int[paramArrayOfRendererCapabilities.length];
    int i = 0;
    while (i < arrayOfInt.length)
    {
      arrayOfInt[i] = paramArrayOfRendererCapabilities[i].supportsMixedMimeTypeAdaptation();
      i += 1;
    }
    return arrayOfInt;
  }
  
  private static void maybeConfigureRenderersForTunneling(RendererCapabilities[] paramArrayOfRendererCapabilities, TrackGroupArray[] paramArrayOfTrackGroupArray, int[][][] paramArrayOfInt, RendererConfiguration[] paramArrayOfRendererConfiguration, TrackSelection[] paramArrayOfTrackSelection, int paramInt)
  {
    int i1 = 0;
    if (paramInt == 0) {
      return;
    }
    int i = 0;
    int k = -1;
    int j = -1;
    int m;
    int n;
    if (i < paramArrayOfRendererCapabilities.length)
    {
      int i2 = paramArrayOfRendererCapabilities[i].getTrackType();
      TrackSelection localTrackSelection = paramArrayOfTrackSelection[i];
      if (i2 != 1)
      {
        m = k;
        n = j;
        if (i2 != 2) {}
      }
      else
      {
        m = k;
        n = j;
        if (localTrackSelection != null)
        {
          m = k;
          n = j;
          if (rendererSupportsTunneling(paramArrayOfInt[i], paramArrayOfTrackGroupArray[i], localTrackSelection))
          {
            if (i2 != 1) {
              break label192;
            }
            if (j != -1) {
              i = 0;
            }
          }
        }
      }
    }
    for (;;)
    {
      label115:
      m = i1;
      if (j != -1)
      {
        m = i1;
        if (k != -1) {
          m = 1;
        }
      }
      if ((i & m) == 0) {
        break;
      }
      paramArrayOfRendererCapabilities = new RendererConfiguration(paramInt);
      paramArrayOfRendererConfiguration[j] = paramArrayOfRendererCapabilities;
      paramArrayOfRendererConfiguration[k] = paramArrayOfRendererCapabilities;
      return;
      n = i;
      m = k;
      for (;;)
      {
        i += 1;
        k = m;
        j = n;
        break;
        label192:
        if (k != -1)
        {
          i = 0;
          break label115;
        }
        m = i;
        n = j;
      }
      i = 1;
    }
  }
  
  private static boolean rendererSupportsTunneling(int[][] paramArrayOfInt, TrackGroupArray paramTrackGroupArray, TrackSelection paramTrackSelection)
  {
    if (paramTrackSelection == null) {
      return false;
    }
    int j = paramTrackGroupArray.indexOf(paramTrackSelection.getTrackGroup());
    int i = 0;
    for (;;)
    {
      if (i >= paramTrackSelection.length()) {
        break label57;
      }
      if ((paramArrayOfInt[j][paramTrackSelection.getIndexInTrackGroup(i)] & 0x20) != 32) {
        break;
      }
      i += 1;
    }
    label57:
    return true;
  }
  
  public final void clearSelectionOverride(int paramInt, TrackGroupArray paramTrackGroupArray)
  {
    Map localMap = (Map)this.selectionOverrides.get(paramInt);
    if ((localMap == null) || (!localMap.containsKey(paramTrackGroupArray))) {
      return;
    }
    localMap.remove(paramTrackGroupArray);
    if (localMap.isEmpty()) {
      this.selectionOverrides.remove(paramInt);
    }
    invalidate();
  }
  
  public final void clearSelectionOverrides()
  {
    if (this.selectionOverrides.size() == 0) {
      return;
    }
    this.selectionOverrides.clear();
    invalidate();
  }
  
  public final void clearSelectionOverrides(int paramInt)
  {
    Map localMap = (Map)this.selectionOverrides.get(paramInt);
    if ((localMap == null) || (localMap.isEmpty())) {
      return;
    }
    this.selectionOverrides.remove(paramInt);
    invalidate();
  }
  
  public final MappedTrackInfo getCurrentMappedTrackInfo()
  {
    return this.currentMappedTrackInfo;
  }
  
  public final boolean getRendererDisabled(int paramInt)
  {
    return this.rendererDisabledFlags.get(paramInt);
  }
  
  public final SelectionOverride getSelectionOverride(int paramInt, TrackGroupArray paramTrackGroupArray)
  {
    Map localMap = (Map)this.selectionOverrides.get(paramInt);
    if (localMap != null) {
      return (SelectionOverride)localMap.get(paramTrackGroupArray);
    }
    return null;
  }
  
  public final boolean hasSelectionOverride(int paramInt, TrackGroupArray paramTrackGroupArray)
  {
    Map localMap = (Map)this.selectionOverrides.get(paramInt);
    return (localMap != null) && (localMap.containsKey(paramTrackGroupArray));
  }
  
  public final void onSelectionActivated(Object paramObject)
  {
    this.currentMappedTrackInfo = ((MappedTrackInfo)paramObject);
  }
  
  public final TrackSelectorResult selectTracks(RendererCapabilities[] paramArrayOfRendererCapabilities, TrackGroupArray paramTrackGroupArray)
    throws ExoPlaybackException
  {
    int j = 0;
    Object localObject4 = new int[paramArrayOfRendererCapabilities.length + 1];
    Object localObject6 = new TrackGroup[paramArrayOfRendererCapabilities.length + 1][];
    int[][][] arrayOfInt = new int[paramArrayOfRendererCapabilities.length + 1][][];
    int i = 0;
    while (i < localObject6.length)
    {
      localObject6[i] = new TrackGroup[paramTrackGroupArray.length];
      arrayOfInt[i] = new int[paramTrackGroupArray.length][];
      i += 1;
    }
    Object localObject3 = getMixedMimeTypeAdaptationSupport(paramArrayOfRendererCapabilities);
    i = 0;
    int k;
    Object localObject1;
    if (i < paramTrackGroupArray.length)
    {
      localObject2 = paramTrackGroupArray.get(i);
      k = findRenderer(paramArrayOfRendererCapabilities, (TrackGroup)localObject2);
      if (k == paramArrayOfRendererCapabilities.length) {}
      for (localObject1 = new int[((TrackGroup)localObject2).length];; localObject1 = getFormatSupport(paramArrayOfRendererCapabilities[k], (TrackGroup)localObject2))
      {
        int m = localObject4[k];
        localObject6[k][m] = localObject2;
        arrayOfInt[k][m] = localObject1;
        localObject4[k] += 1;
        i += 1;
        break;
      }
    }
    Object localObject2 = new TrackGroupArray[paramArrayOfRendererCapabilities.length];
    Object localObject5 = new int[paramArrayOfRendererCapabilities.length];
    i = 0;
    while (i < paramArrayOfRendererCapabilities.length)
    {
      k = localObject4[i];
      localObject2[i] = new TrackGroupArray((TrackGroup[])Arrays.copyOf(localObject6[i], k));
      arrayOfInt[i] = ((int[][])Arrays.copyOf(arrayOfInt[i], k));
      localObject5[i] = paramArrayOfRendererCapabilities[i].getTrackType();
      i += 1;
    }
    i = localObject4[paramArrayOfRendererCapabilities.length];
    localObject6 = new TrackGroupArray((TrackGroup[])Arrays.copyOf(localObject6[paramArrayOfRendererCapabilities.length], i));
    localObject4 = selectTracks(paramArrayOfRendererCapabilities, (TrackGroupArray[])localObject2, arrayOfInt);
    i = 0;
    if (i < paramArrayOfRendererCapabilities.length)
    {
      if (this.rendererDisabledFlags.get(i)) {
        localObject4[i] = null;
      }
      do
      {
        i += 1;
        break;
        localObject1 = localObject2[i];
      } while (!hasSelectionOverride(i, (TrackGroupArray)localObject1));
      localObject7 = (SelectionOverride)((Map)this.selectionOverrides.get(i)).get(localObject1);
      if (localObject7 == null) {}
      for (localObject1 = null;; localObject1 = ((SelectionOverride)localObject7).createTrackSelection((TrackGroupArray)localObject1))
      {
        localObject4[i] = localObject1;
        break;
      }
    }
    Object localObject7 = determineEnabledRenderers(paramArrayOfRendererCapabilities, (TrackSelection[])localObject4);
    localObject3 = new MappedTrackInfo((int[])localObject5, (TrackGroupArray[])localObject2, (int[])localObject3, arrayOfInt, (TrackGroupArray)localObject6);
    localObject5 = new RendererConfiguration[paramArrayOfRendererCapabilities.length];
    i = j;
    if (i < paramArrayOfRendererCapabilities.length)
    {
      if (localObject7[i] != 0) {}
      for (localObject1 = RendererConfiguration.DEFAULT;; localObject1 = null)
      {
        localObject5[i] = localObject1;
        i += 1;
        break;
      }
    }
    maybeConfigureRenderersForTunneling(paramArrayOfRendererCapabilities, (TrackGroupArray[])localObject2, arrayOfInt, (RendererConfiguration[])localObject5, (TrackSelection[])localObject4, this.tunnelingAudioSessionId);
    return new TrackSelectorResult(paramTrackGroupArray, (boolean[])localObject7, new TrackSelectionArray((TrackSelection[])localObject4), localObject3, (RendererConfiguration[])localObject5);
  }
  
  protected abstract TrackSelection[] selectTracks(RendererCapabilities[] paramArrayOfRendererCapabilities, TrackGroupArray[] paramArrayOfTrackGroupArray, int[][][] paramArrayOfInt)
    throws ExoPlaybackException;
  
  public final void setRendererDisabled(int paramInt, boolean paramBoolean)
  {
    if (this.rendererDisabledFlags.get(paramInt) == paramBoolean) {
      return;
    }
    this.rendererDisabledFlags.put(paramInt, paramBoolean);
    invalidate();
  }
  
  public final void setSelectionOverride(int paramInt, TrackGroupArray paramTrackGroupArray, SelectionOverride paramSelectionOverride)
  {
    Map localMap = (Map)this.selectionOverrides.get(paramInt);
    Object localObject = localMap;
    if (localMap == null)
    {
      localObject = new HashMap();
      this.selectionOverrides.put(paramInt, localObject);
    }
    if ((((Map)localObject).containsKey(paramTrackGroupArray)) && (Util.areEqual(((Map)localObject).get(paramTrackGroupArray), paramSelectionOverride))) {
      return;
    }
    ((Map)localObject).put(paramTrackGroupArray, paramSelectionOverride);
    invalidate();
  }
  
  public void setTunnelingAudioSessionId(int paramInt)
  {
    if (this.tunnelingAudioSessionId != paramInt)
    {
      this.tunnelingAudioSessionId = paramInt;
      invalidate();
    }
  }
  
  public static final class MappedTrackInfo
  {
    public static final int RENDERER_SUPPORT_EXCEEDS_CAPABILITIES_TRACKS = 2;
    public static final int RENDERER_SUPPORT_NO_TRACKS = 0;
    public static final int RENDERER_SUPPORT_PLAYABLE_TRACKS = 3;
    public static final int RENDERER_SUPPORT_UNSUPPORTED_TRACKS = 1;
    private final int[][][] formatSupport;
    public final int length;
    private final int[] mixedMimeTypeAdaptiveSupport;
    private final int[] rendererTrackTypes;
    private final TrackGroupArray[] trackGroups;
    private final TrackGroupArray unassociatedTrackGroups;
    
    MappedTrackInfo(int[] paramArrayOfInt1, TrackGroupArray[] paramArrayOfTrackGroupArray, int[] paramArrayOfInt2, int[][][] paramArrayOfInt, TrackGroupArray paramTrackGroupArray)
    {
      this.rendererTrackTypes = paramArrayOfInt1;
      this.trackGroups = paramArrayOfTrackGroupArray;
      this.formatSupport = paramArrayOfInt;
      this.mixedMimeTypeAdaptiveSupport = paramArrayOfInt2;
      this.unassociatedTrackGroups = paramTrackGroupArray;
      this.length = paramArrayOfTrackGroupArray.length;
    }
    
    public int getAdaptiveSupport(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      int j = 0;
      int m = this.trackGroups[paramInt1].get(paramInt2).length;
      int[] arrayOfInt = new int[m];
      int i = 0;
      while (i < m)
      {
        int n = getTrackFormatSupport(paramInt1, paramInt2, i);
        int k;
        if (n != 4)
        {
          k = j;
          if (paramBoolean)
          {
            k = j;
            if (n != 3) {}
          }
        }
        else
        {
          arrayOfInt[j] = i;
          k = j + 1;
        }
        i += 1;
        j = k;
      }
      return getAdaptiveSupport(paramInt1, paramInt2, Arrays.copyOf(arrayOfInt, j));
    }
    
    public int getAdaptiveSupport(int paramInt1, int paramInt2, int[] paramArrayOfInt)
    {
      Object localObject = null;
      int m = 0;
      int j = 0;
      int i = 16;
      int k = 0;
      while (m < paramArrayOfInt.length)
      {
        int n = paramArrayOfInt[m];
        String str = this.trackGroups[paramInt1].get(paramInt2).getFormat(n).sampleMimeType;
        if (k == 0)
        {
          localObject = str;
          i = Math.min(i, this.formatSupport[paramInt1][paramInt2][m] & 0x18);
          m += 1;
          k += 1;
        }
        else
        {
          if (!Util.areEqual(localObject, str)) {}
          for (n = 1;; n = 0)
          {
            j = n | j;
            break;
          }
        }
      }
      paramInt2 = i;
      if (j != 0) {
        paramInt2 = Math.min(i, this.mixedMimeTypeAdaptiveSupport[paramInt1]);
      }
      return paramInt2;
    }
    
    public int getRendererSupport(int paramInt)
    {
      int[][] arrayOfInt = this.formatSupport[paramInt];
      int i = 0;
      paramInt = 0;
      for (;;)
      {
        int j = paramInt;
        if (i < arrayOfInt.length)
        {
          j = 0;
          if (j >= arrayOfInt[i].length) {
            break label91;
          }
          switch (arrayOfInt[i][j] & 0x7)
          {
          }
        }
        for (int k = 1;; k = 2)
        {
          paramInt = Math.max(paramInt, k);
          j += 1;
          break;
          j = 3;
          return j;
        }
        label91:
        i += 1;
      }
    }
    
    public int getTrackFormatSupport(int paramInt1, int paramInt2, int paramInt3)
    {
      return this.formatSupport[paramInt1][paramInt2][paramInt3] & 0x7;
    }
    
    public TrackGroupArray getTrackGroups(int paramInt)
    {
      return this.trackGroups[paramInt];
    }
    
    public int getTrackTypeRendererSupport(int paramInt)
    {
      int i = 0;
      int k;
      for (int j = 0; i < this.length; j = k)
      {
        k = j;
        if (this.rendererTrackTypes[i] == paramInt) {
          k = Math.max(j, getRendererSupport(i));
        }
        i += 1;
      }
      return j;
    }
    
    public TrackGroupArray getUnassociatedTrackGroups()
    {
      return this.unassociatedTrackGroups;
    }
  }
  
  public static final class SelectionOverride
  {
    public final TrackSelection.Factory factory;
    public final int groupIndex;
    public final int length;
    public final int[] tracks;
    
    public SelectionOverride(TrackSelection.Factory paramFactory, int paramInt, int... paramVarArgs)
    {
      this.factory = paramFactory;
      this.groupIndex = paramInt;
      this.tracks = paramVarArgs;
      this.length = paramVarArgs.length;
    }
    
    public boolean containsTrack(int paramInt)
    {
      boolean bool2 = false;
      int[] arrayOfInt = this.tracks;
      int j = arrayOfInt.length;
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < j)
        {
          if (arrayOfInt[i] == paramInt) {
            bool1 = true;
          }
        }
        else {
          return bool1;
        }
        i += 1;
      }
    }
    
    public TrackSelection createTrackSelection(TrackGroupArray paramTrackGroupArray)
    {
      return this.factory.createTrackSelection(paramTrackGroupArray.get(this.groupIndex), this.tracks);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.trackselection.MappingTrackSelector
 * JD-Core Version:    0.7.0.1
 */