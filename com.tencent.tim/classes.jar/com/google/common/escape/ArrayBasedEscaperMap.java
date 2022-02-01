package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Beta
@GwtCompatible
public final class ArrayBasedEscaperMap
{
  private static final char[][] EMPTY_REPLACEMENT_ARRAY = (char[][])Array.newInstance(Character.TYPE, new int[] { 0, 0 });
  private final char[][] replacementArray;
  
  private ArrayBasedEscaperMap(char[][] paramArrayOfChar)
  {
    this.replacementArray = paramArrayOfChar;
  }
  
  public static ArrayBasedEscaperMap create(Map<Character, String> paramMap)
  {
    return new ArrayBasedEscaperMap(createReplacementArray(paramMap));
  }
  
  @VisibleForTesting
  static char[][] createReplacementArray(Map<Character, String> paramMap)
  {
    Preconditions.checkNotNull(paramMap);
    if (paramMap.isEmpty()) {
      return EMPTY_REPLACEMENT_ARRAY;
    }
    char[][] arrayOfChar = new char[((Character)Collections.max(paramMap.keySet())).charValue() + '\001'][];
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      char c = ((Character)localIterator.next()).charValue();
      arrayOfChar[c] = ((String)paramMap.get(Character.valueOf(c))).toCharArray();
    }
    return arrayOfChar;
  }
  
  char[][] getReplacementArray()
  {
    return this.replacementArray;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.escape.ArrayBasedEscaperMap
 * JD-Core Version:    0.7.0.1
 */