package com.google.ical.iter;

import java.util.Comparator;

final class HeapElement$1
  implements Comparator<HeapElement>
{
  public int compare(HeapElement paramHeapElement1, HeapElement paramHeapElement2)
  {
    long l1 = paramHeapElement1.comparable();
    long l2 = paramHeapElement2.comparable();
    if (l1 < l2) {
      return -1;
    }
    if (l1 == l2) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.iter.HeapElement.1
 * JD-Core Version:    0.7.0.1
 */