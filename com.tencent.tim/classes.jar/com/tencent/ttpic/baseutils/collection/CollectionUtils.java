package com.tencent.ttpic.baseutils.collection;

import java.util.Collection;

public class CollectionUtils
{
  public static boolean indexOutOfBounds(Collection paramCollection, int paramInt)
  {
    return (paramCollection == null) || (paramInt < 0) || (paramInt >= paramCollection.size());
  }
  
  public static boolean isEmpty(Collection paramCollection)
  {
    return (paramCollection == null) || (paramCollection.isEmpty());
  }
  
  public static int size(Collection paramCollection)
  {
    if (paramCollection == null) {
      return 0;
    }
    return paramCollection.size();
  }
  
  public static int size(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null) {
      return 0;
    }
    return paramArrayOfObject.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.collection.CollectionUtils
 * JD-Core Version:    0.7.0.1
 */