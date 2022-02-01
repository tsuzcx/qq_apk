package com.tencent.qapmsdk.memory;

import android.support.annotation.NonNull;
import java.util.Comparator;
import java.util.Map.Entry;

final class DumpMemInfoHandler$1
  implements Comparator<Object>
{
  public int compare(@NonNull Object paramObject1, @NonNull Object paramObject2)
  {
    int i = ((Integer)((Map.Entry)paramObject1).getValue()).intValue();
    int j = ((Integer)((Map.Entry)paramObject2).getValue()).intValue();
    if (i == j) {
      return 0;
    }
    if (i < j) {
      return 2;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.memory.DumpMemInfoHandler.1
 * JD-Core Version:    0.7.0.1
 */