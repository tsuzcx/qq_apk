package org.apache.commons.lang3.time;

final class FastDateParser$4
  extends FastDateParser.NumberStrategy
{
  FastDateParser$4(int paramInt)
  {
    super(paramInt);
  }
  
  int modify(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 12) {
      i = 0;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.time.FastDateParser.4
 * JD-Core Version:    0.7.0.1
 */