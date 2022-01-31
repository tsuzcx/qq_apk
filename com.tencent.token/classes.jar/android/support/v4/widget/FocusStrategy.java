package android.support.v4.widget;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;

class FocusStrategy
{
  private static boolean beamBeats(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2, @NonNull Rect paramRect3)
  {
    boolean bool2 = true;
    boolean bool1 = beamsOverlap(paramInt, paramRect1, paramRect2);
    if ((beamsOverlap(paramInt, paramRect1, paramRect3)) || (!bool1)) {
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (!isToDirectionOf(paramInt, paramRect1, paramRect3));
          bool1 = bool2;
        } while (paramInt == 17);
        bool1 = bool2;
      } while (paramInt == 66);
      bool1 = bool2;
    } while (majorAxisDistance(paramInt, paramRect1, paramRect2) < majorAxisDistanceToFarEdge(paramInt, paramRect1, paramRect3));
    return false;
  }
  
  private static boolean beamsOverlap(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    case 17: 
    case 66: 
      if ((paramRect2.bottom < paramRect1.top) || (paramRect2.top > paramRect1.bottom)) {
        break;
      }
    }
    do
    {
      return true;
      return false;
    } while ((paramRect2.right >= paramRect1.left) && (paramRect2.left <= paramRect1.right));
    return false;
  }
  
  public static Object findNextFocusInAbsoluteDirection(@NonNull Object paramObject1, @NonNull FocusStrategy.CollectionAdapter paramCollectionAdapter, @NonNull FocusStrategy.BoundsAdapter paramBoundsAdapter, @Nullable Object paramObject2, @NonNull Rect paramRect, int paramInt)
  {
    Rect localRect1 = new Rect(paramRect);
    Rect localRect2;
    int i;
    Object localObject1;
    label103:
    Object localObject2;
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    case 17: 
      localRect1.offset(paramRect.width() + 1, 0);
      int j = paramCollectionAdapter.size(paramObject1);
      localRect2 = new Rect();
      i = 0;
      localObject1 = null;
      if (i >= j) {
        break label224;
      }
      localObject2 = paramCollectionAdapter.get(paramObject1, i);
      if (localObject2 != paramObject2) {
        break;
      }
    }
    for (;;)
    {
      i += 1;
      break label103;
      localRect1.offset(-(paramRect.width() + 1), 0);
      break;
      localRect1.offset(0, paramRect.height() + 1);
      break;
      localRect1.offset(0, -(paramRect.height() + 1));
      break;
      paramBoundsAdapter.obtainBounds(localObject2, localRect2);
      if (isBetterCandidate(paramInt, paramRect, localRect2, localRect1))
      {
        localRect1.set(localRect2);
        localObject1 = localObject2;
      }
    }
    label224:
    return localObject1;
  }
  
  public static Object findNextFocusInRelativeDirection(@NonNull Object paramObject1, @NonNull FocusStrategy.CollectionAdapter paramCollectionAdapter, @NonNull FocusStrategy.BoundsAdapter paramBoundsAdapter, @Nullable Object paramObject2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = paramCollectionAdapter.size(paramObject1);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramCollectionAdapter.get(paramObject1, i));
      i += 1;
    }
    Collections.sort(localArrayList, new FocusStrategy.SequentialComparator(paramBoolean1, paramBoundsAdapter));
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
    case 2: 
      return getNextFocusable(paramObject2, localArrayList, paramBoolean2);
    }
    return getPreviousFocusable(paramObject2, localArrayList, paramBoolean2);
  }
  
  private static Object getNextFocusable(Object paramObject, ArrayList paramArrayList, boolean paramBoolean)
  {
    int j = paramArrayList.size();
    if (paramObject == null) {}
    for (int i = -1;; i = paramArrayList.lastIndexOf(paramObject))
    {
      i += 1;
      if (i >= j) {
        break;
      }
      return paramArrayList.get(i);
    }
    if ((paramBoolean) && (j > 0)) {
      return paramArrayList.get(0);
    }
    return null;
  }
  
  private static Object getPreviousFocusable(Object paramObject, ArrayList paramArrayList, boolean paramBoolean)
  {
    int j = paramArrayList.size();
    if (paramObject == null) {}
    for (int i = j;; i = paramArrayList.indexOf(paramObject))
    {
      i -= 1;
      if (i < 0) {
        break;
      }
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
    boolean bool2 = true;
    boolean bool1;
    if (!isCandidate(paramRect1, paramRect2, paramInt)) {
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (!isCandidate(paramRect1, paramRect3, paramInt));
        bool1 = bool2;
      } while (beamBeats(paramInt, paramRect1, paramRect2, paramRect3));
      if (beamBeats(paramInt, paramRect1, paramRect3, paramRect2)) {
        return false;
      }
      bool1 = bool2;
    } while (getWeightedDistanceFor(majorAxisDistance(paramInt, paramRect1, paramRect2), minorAxisDistance(paramInt, paramRect1, paramRect2)) < getWeightedDistanceFor(majorAxisDistance(paramInt, paramRect1, paramRect3), minorAxisDistance(paramInt, paramRect1, paramRect3)));
    return false;
  }
  
  private static boolean isCandidate(@NonNull Rect paramRect1, @NonNull Rect paramRect2, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    case 17: 
      if (((paramRect1.right <= paramRect2.right) && (paramRect1.left < paramRect2.right)) || (paramRect1.left <= paramRect2.left)) {
        break;
      }
    }
    do
    {
      do
      {
        do
        {
          return true;
          return false;
        } while (((paramRect1.left < paramRect2.left) || (paramRect1.right <= paramRect2.left)) && (paramRect1.right < paramRect2.right));
        return false;
      } while (((paramRect1.bottom > paramRect2.bottom) || (paramRect1.top >= paramRect2.bottom)) && (paramRect1.top > paramRect2.top));
      return false;
    } while (((paramRect1.top < paramRect2.top) || (paramRect1.bottom <= paramRect2.top)) && (paramRect1.bottom < paramRect2.bottom));
    return false;
  }
  
  private static boolean isToDirectionOf(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    case 17: 
      if (paramRect1.left < paramRect2.right) {
        break;
      }
    }
    do
    {
      do
      {
        do
        {
          return true;
          return false;
        } while (paramRect1.right <= paramRect2.left);
        return false;
      } while (paramRect1.top >= paramRect2.bottom);
      return false;
    } while (paramRect1.bottom <= paramRect2.top);
    return false;
  }
  
  private static int majorAxisDistance(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2)
  {
    return Math.max(0, majorAxisDistanceRaw(paramInt, paramRect1, paramRect2));
  }
  
  private static int majorAxisDistanceRaw(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    case 17: 
      return paramRect1.left - paramRect2.right;
    case 66: 
      return paramRect2.left - paramRect1.right;
    case 33: 
      return paramRect1.top - paramRect2.bottom;
    }
    return paramRect2.top - paramRect1.bottom;
  }
  
  private static int majorAxisDistanceToFarEdge(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2)
  {
    return Math.max(1, majorAxisDistanceToFarEdgeRaw(paramInt, paramRect1, paramRect2));
  }
  
  private static int majorAxisDistanceToFarEdgeRaw(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    case 17: 
      return paramRect1.left - paramRect2.left;
    case 66: 
      return paramRect2.right - paramRect1.right;
    case 33: 
      return paramRect1.top - paramRect2.top;
    }
    return paramRect2.bottom - paramRect1.bottom;
  }
  
  private static int minorAxisDistance(int paramInt, @NonNull Rect paramRect1, @NonNull Rect paramRect2)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    case 17: 
    case 66: 
      return Math.abs(paramRect1.top + paramRect1.height() / 2 - (paramRect2.top + paramRect2.height() / 2));
    }
    return Math.abs(paramRect1.left + paramRect1.width() / 2 - (paramRect2.left + paramRect2.width() / 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.FocusStrategy
 * JD-Core Version:    0.7.0.1
 */