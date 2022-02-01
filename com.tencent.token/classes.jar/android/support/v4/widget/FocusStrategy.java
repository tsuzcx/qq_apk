package android.support.v4.widget;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class FocusStrategy
{
  private static boolean beamBeats(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2, @NonNull Rect paramRect3)
  {
    boolean bool = beamsOverlap(paramInt, paramRect1, paramRect2);
    if (!beamsOverlap(paramInt, paramRect1, paramRect3))
    {
      if (!bool) {
        return false;
      }
      if (!isToDirectionOf(paramInt, paramRect1, paramRect3)) {
        return true;
      }
      if (paramInt != 17)
      {
        if (paramInt == 66) {
          return true;
        }
        return majorAxisDistance(paramInt, paramRect1, paramRect2) < majorAxisDistanceToFarEdge(paramInt, paramRect1, paramRect3);
      }
      return true;
    }
    return false;
  }
  
  private static boolean beamsOverlap(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2)
  {
    if (paramInt != 17)
    {
      if (paramInt != 33)
      {
        if (paramInt == 66) {
          break label64;
        }
        if (paramInt != 130) {
          throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
      }
      return (paramRect2.right >= paramRect1.left) && (paramRect2.left <= paramRect1.right);
    }
    label64:
    return (paramRect2.bottom >= paramRect1.top) && (paramRect2.top <= paramRect1.bottom);
  }
  
  public static <L, T> T findNextFocusInAbsoluteDirection(@NonNull L paramL, @NonNull CollectionAdapter<L, T> paramCollectionAdapter, @NonNull BoundsAdapter<T> paramBoundsAdapter, @Nullable T paramT, @NonNull Rect paramRect, int paramInt)
  {
    Rect localRect1 = new Rect(paramRect);
    int i = 0;
    if (paramInt != 17)
    {
      if (paramInt != 33)
      {
        if (paramInt != 66)
        {
          if (paramInt == 130) {
            localRect1.offset(0, -(paramRect.height() + 1));
          } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
          }
        }
        else {
          localRect1.offset(-(paramRect.width() + 1), 0);
        }
      }
      else {
        localRect1.offset(0, paramRect.height() + 1);
      }
    }
    else {
      localRect1.offset(paramRect.width() + 1, 0);
    }
    Object localObject1 = null;
    int j = paramCollectionAdapter.size(paramL);
    Rect localRect2 = new Rect();
    while (i < j)
    {
      Object localObject2 = paramCollectionAdapter.get(paramL, i);
      if (localObject2 != paramT)
      {
        paramBoundsAdapter.obtainBounds(localObject2, localRect2);
        if (isBetterCandidate(paramInt, paramRect, localRect2, localRect1))
        {
          localRect1.set(localRect2);
          localObject1 = localObject2;
        }
      }
      i += 1;
    }
    return localObject1;
  }
  
  public static <L, T> T findNextFocusInRelativeDirection(@NonNull L paramL, @NonNull CollectionAdapter<L, T> paramCollectionAdapter, @NonNull BoundsAdapter<T> paramBoundsAdapter, @Nullable T paramT, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = paramCollectionAdapter.size(paramL);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramCollectionAdapter.get(paramL, i));
      i += 1;
    }
    Collections.sort(localArrayList, new SequentialComparator(paramBoolean1, paramBoundsAdapter));
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
    case 2: 
      return getNextFocusable(paramT, localArrayList, paramBoolean2);
    }
    return getPreviousFocusable(paramT, localArrayList, paramBoolean2);
  }
  
  private static <T> T getNextFocusable(T paramT, ArrayList<T> paramArrayList, boolean paramBoolean)
  {
    int j = paramArrayList.size();
    int i;
    if (paramT == null) {
      i = -1;
    } else {
      i = paramArrayList.lastIndexOf(paramT);
    }
    i += 1;
    if (i < j) {
      return paramArrayList.get(i);
    }
    if ((paramBoolean) && (j > 0)) {
      return paramArrayList.get(0);
    }
    return null;
  }
  
  private static <T> T getPreviousFocusable(T paramT, ArrayList<T> paramArrayList, boolean paramBoolean)
  {
    int j = paramArrayList.size();
    int i;
    if (paramT == null) {
      i = j;
    } else {
      i = paramArrayList.indexOf(paramT);
    }
    i -= 1;
    if (i >= 0) {
      return paramArrayList.get(i);
    }
    if ((paramBoolean) && (j > 0)) {
      return paramArrayList.get(j - 1);
    }
    return null;
  }
  
  private static int getWeightedDistanceFor(int paramInt1, int paramInt2)
  {
    return paramInt1 * 13 * paramInt1 + paramInt2 * paramInt2;
  }
  
  private static boolean isBetterCandidate(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2, @NonNull Rect paramRect3)
  {
    boolean bool2 = isCandidate(paramRect1, paramRect2, paramInt);
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    if (!isCandidate(paramRect1, paramRect3, paramInt)) {
      return true;
    }
    if (beamBeats(paramInt, paramRect1, paramRect2, paramRect3)) {
      return true;
    }
    if (beamBeats(paramInt, paramRect1, paramRect3, paramRect2)) {
      return false;
    }
    if (getWeightedDistanceFor(majorAxisDistance(paramInt, paramRect1, paramRect2), minorAxisDistance(paramInt, paramRect1, paramRect2)) < getWeightedDistanceFor(majorAxisDistance(paramInt, paramRect1, paramRect3), minorAxisDistance(paramInt, paramRect1, paramRect3))) {
      bool1 = true;
    }
    return bool1;
  }
  
  private static boolean isCandidate(@NonNull Rect paramRect1, @NonNull Rect paramRect2, int paramInt)
  {
    if (paramInt != 17)
    {
      if (paramInt != 33)
      {
        if (paramInt != 66)
        {
          if (paramInt == 130) {
            return ((paramRect1.top < paramRect2.top) || (paramRect1.bottom <= paramRect2.top)) && (paramRect1.bottom < paramRect2.bottom);
          }
          throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return ((paramRect1.left < paramRect2.left) || (paramRect1.right <= paramRect2.left)) && (paramRect1.right < paramRect2.right);
      }
      return ((paramRect1.bottom > paramRect2.bottom) || (paramRect1.top >= paramRect2.bottom)) && (paramRect1.top > paramRect2.top);
    }
    return ((paramRect1.right > paramRect2.right) || (paramRect1.left >= paramRect2.right)) && (paramRect1.left > paramRect2.left);
  }
  
  private static boolean isToDirectionOf(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2)
  {
    if (paramInt != 17)
    {
      if (paramInt != 33)
      {
        if (paramInt != 66)
        {
          if (paramInt == 130) {
            return paramRect1.bottom <= paramRect2.top;
          }
          throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return paramRect1.right <= paramRect2.left;
      }
      return paramRect1.top >= paramRect2.bottom;
    }
    return paramRect1.left >= paramRect2.right;
  }
  
  private static int majorAxisDistance(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2)
  {
    return Math.max(0, majorAxisDistanceRaw(paramInt, paramRect1, paramRect2));
  }
  
  private static int majorAxisDistanceRaw(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2)
  {
    if (paramInt != 17)
    {
      if (paramInt != 33)
      {
        if (paramInt != 66)
        {
          if (paramInt == 130) {
            return paramRect2.top - paramRect1.bottom;
          }
          throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return paramRect2.left - paramRect1.right;
      }
      return paramRect1.top - paramRect2.bottom;
    }
    return paramRect1.left - paramRect2.right;
  }
  
  private static int majorAxisDistanceToFarEdge(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2)
  {
    return Math.max(1, majorAxisDistanceToFarEdgeRaw(paramInt, paramRect1, paramRect2));
  }
  
  private static int majorAxisDistanceToFarEdgeRaw(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2)
  {
    if (paramInt != 17)
    {
      if (paramInt != 33)
      {
        if (paramInt != 66)
        {
          if (paramInt == 130) {
            return paramRect2.bottom - paramRect1.bottom;
          }
          throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return paramRect2.right - paramRect1.right;
      }
      return paramRect1.top - paramRect2.top;
    }
    return paramRect1.left - paramRect2.left;
  }
  
  private static int minorAxisDistance(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2)
  {
    if (paramInt != 17)
    {
      if (paramInt != 33)
      {
        if (paramInt == 66) {
          break label65;
        }
        if (paramInt != 130) {
          throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
      }
      return Math.abs(paramRect1.left + paramRect1.width() / 2 - (paramRect2.left + paramRect2.width() / 2));
    }
    label65:
    return Math.abs(paramRect1.top + paramRect1.height() / 2 - (paramRect2.top + paramRect2.height() / 2));
  }
  
  public static abstract interface BoundsAdapter<T>
  {
    public abstract void obtainBounds(T paramT, Rect paramRect);
  }
  
  public static abstract interface CollectionAdapter<T, V>
  {
    public abstract V get(T paramT, int paramInt);
    
    public abstract int size(T paramT);
  }
  
  private static class SequentialComparator<T>
    implements Comparator<T>
  {
    private final FocusStrategy.BoundsAdapter<T> mAdapter;
    private final boolean mIsLayoutRtl;
    private final Rect mTemp1 = new Rect();
    private final Rect mTemp2 = new Rect();
    
    SequentialComparator(boolean paramBoolean, FocusStrategy.BoundsAdapter<T> paramBoundsAdapter)
    {
      this.mIsLayoutRtl = paramBoolean;
      this.mAdapter = paramBoundsAdapter;
    }
    
    public int compare(T paramT1, T paramT2)
    {
      Rect localRect1 = this.mTemp1;
      Rect localRect2 = this.mTemp2;
      this.mAdapter.obtainBounds(paramT1, localRect1);
      this.mAdapter.obtainBounds(paramT2, localRect2);
      int j = localRect1.top;
      int k = localRect2.top;
      int i = -1;
      if (j < k) {
        return -1;
      }
      if (localRect1.top > localRect2.top) {
        return 1;
      }
      if (localRect1.left < localRect2.left)
      {
        if (this.mIsLayoutRtl) {
          i = 1;
        }
        return i;
      }
      if (localRect1.left > localRect2.left)
      {
        if (this.mIsLayoutRtl) {
          return -1;
        }
        return 1;
      }
      if (localRect1.bottom < localRect2.bottom) {
        return -1;
      }
      if (localRect1.bottom > localRect2.bottom) {
        return 1;
      }
      if (localRect1.right < localRect2.right)
      {
        if (this.mIsLayoutRtl) {
          i = 1;
        }
        return i;
      }
      if (localRect1.right > localRect2.right)
      {
        if (this.mIsLayoutRtl) {
          return -1;
        }
        return 1;
      }
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.FocusStrategy
 * JD-Core Version:    0.7.0.1
 */